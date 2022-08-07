/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.August.controllers;

import com.August.Dao.ProductionLineCategoryDao;
import com.August.entities.ProductionLineCategory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/pLineCatReg")
public class ProductionLineCategoryReg extends HttpServlet 
{
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
        ProductionLineCategory pLineCat = new ProductionLineCategory();
        
        pLineCat.setLineCategoryName(request.getParameter("lineCategoryName"));
        pLineCat.setDailyNumShirts(Integer.parseInt(request.getParameter("dailyNumShirts")));
        pLineCat.setDailyNumStaff(Integer.parseInt(request.getParameter("dailyNumStaff")));
       
        ProductionLineCategoryDao pLineCatDao = new ProductionLineCategoryDao();
      
        try {
            pLineCatDao.register(pLineCat);
        } catch (SQLException ex) 
        {
            out.println(ex.getMessage());
        }  
        
    }
}


