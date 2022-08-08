/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.August.controllers;

import com.August.Dao.StaffDao;
import com.August.entities.Staff;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/displayEmployees")

public class DisplayEmployees extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException
    {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        StaffDao sd = new StaffDao();
        
        ArrayList<Staff> employees = new ArrayList<>();
        
        try 
        {
            employees = sd.getEmployees();
        } catch (Exception ex) {
           out.println(ex.getMessage());
        }
        
        
        session.setAttribute("employees", employees);
       
        //response.sendRedirect("index.jsp");
    }
}