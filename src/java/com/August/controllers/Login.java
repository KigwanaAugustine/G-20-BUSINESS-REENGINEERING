/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.August.controllers;

import com.August.Dao.CustomerDao;
import com.August.Dao.ManagerDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/login")

public class Login extends HttpServlet
{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException
    {
       
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        int customerID = 0;
        ManagerDao md = new ManagerDao();
        CustomerDao cd = new CustomerDao();
        
        
        
        
        if(cd.check(username, password))//check if client is loggin in, redirect to customer landing
        {
            
            
           try {
                 customerID = cd.searchCustomer(username);  //get customerID
            } catch (SQLException ex) {
                out.print(ex.getMessage());
            }
           
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("customerID", customerID);
            response.sendRedirect("index.jsp");         
        }
        else if(md.check(username, password))//check if manager is logging in , redirect to manager landing
        {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            
            response.sendRedirect("welcome.jsp");
        }
        else
        {
           response.sendRedirect("login.jsp");
        }
            
    }
}