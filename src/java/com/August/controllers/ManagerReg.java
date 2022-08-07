/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.August.controllers;


import com.August.Dao.ManagerDao;
import com.August.entities.Manager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/mReg")
public class ManagerReg extends HttpServlet 
{
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
       
        Manager m = new Manager();
      
       m.setManagerID(Integer.parseInt(request.getParameter("managerID")));
       m.setSFname(request.getParameter("sFname"));
       m.setSLname(request.getParameter("sLname"));
       m.setAddress(request.getParameter("address"));
       m.setSalary(Integer.parseInt(request.getParameter("salary")));
       m.setSEmail(request.getParameter("sEmail"));
       m.setSPassword(request.getParameter("sPassword"));
       m.setSUserName(request.getParameter("sUserName"));
       
       ManagerDao md = new ManagerDao();
       
        try {
            md.register(m);
        } catch (SQLException ex) 
        {
            out.println(ex.getMessage());
        }
        
        
    }
}