/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.August.controllers;

import com.August.Dao.StaffDao;
import com.August.entities.StaffProductionLine;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/reallocateBySales")

public class ReallocateBySales extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException
    {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        //getting start date and enddate between which the sales are required
        String startDate = request.getParameter("startDate");
       
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String endDate = formatter.format(new Date(System.currentTimeMillis()));
        String[] arr = endDate.split(" ");

        endDate = arr[0];
        
        StaffDao sd = new StaffDao();
        
        //getting the sales for all the categories in between the given date range
        int smallSales=0, mediumSales=0, largeSales=0, ExtraLargeSales=0;
        try {
            smallSales = sd.getNumSales("Small", startDate, endDate);
            mediumSales = sd.getNumSales("Medium", startDate, endDate);
            largeSales = sd.getNumSales("Large", startDate, endDate);
            ExtraLargeSales = sd.getNumSales("ExtraLarge", startDate, endDate);
        } catch (Exception e) {
            
            out.println(e.toString());
        }
         
        
        //Getting the employees for each category
        int totalSales = smallSales + mediumSales + largeSales + ExtraLargeSales;
        int totalStaff = 0;
        try {
             totalStaff = sd.getTotalStaff();
        } catch (Exception e) {
            
            out.println(e.toString());
        }
        
         int eSmall = 0, eMedium = 0, eLarge = 0, eExtraLarge = 0;
         eSmall = (smallSales/totalSales) * totalStaff;
         eMedium = (mediumSales/totalSales) * totalStaff;
         eLarge = (largeSales/totalSales) * totalStaff;
         eExtraLarge = (ExtraLargeSales/totalSales) * totalStaff;
                
        ArrayList<StaffProductionLine> staffReallocation = new ArrayList<>();
        try {
            //REALLOCATION
           staffReallocation = sd.reallocate(eSmall, eMedium, eLarge, eExtraLarge, endDate);
        } catch (Exception e) {
            
            out.println(e.toString());
        }
       
        //putting the new staffReallocation into session ; only display staffID and categoryLine
        session.setAttribute("staffReallocation", staffReallocation);
        
    }
    
}