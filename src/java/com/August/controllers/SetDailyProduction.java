/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.August.controllers;


import com.August.Dao.ProductionLineCategoryDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Tanuki
 */
@WebServlet("/setProduction")
public class SetDailyProduction extends HttpServlet 
{
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
       
        int longTermShirts = Integer.parseInt(request.getParameter("longTermShirts"));
        int midTermShirts = 2 * longTermShirts;
        int shortTermShirts = 10 * longTermShirts;
        
        ProductionLineCategoryDao pLineCatDao = new ProductionLineCategoryDao();
        
        try 
        {
            pLineCatDao.updateDailyNumShirts("longTerm", longTermShirts);
            pLineCatDao.updateDailyNumShirts("midTerm", midTermShirts);
            pLineCatDao.updateDailyNumShirts("shortTerm", shortTermShirts);
        } catch (SQLException ex) 
        {
            out.println(ex.getMessage());
        }
        
        
    }
}