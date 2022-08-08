/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.August.controllers;

import com.August.Dao.CustomerDao;
import com.August.entities.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/displayCustomers")

public class DisplayCustomers extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException
    {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        CustomerDao cd = new CustomerDao();
        
        ArrayList<Customer> customers = new ArrayList<>();
        
        try 
        {
            customers = cd.getCustomers();
        } catch (Exception ex) {
           out.println(ex.getMessage());
        }
        
        session.setAttribute("customers", customers);
        response.sendRedirect("index.jsp");
    }
    
}