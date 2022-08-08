/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.August.controllers;

import com.August.Dao.ShirtCategoryDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/changePrice")

public class ChangePrice extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException
    {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        
        String shirtCategoryName = request.getParameter("shirtCategoryName");
        int price = Integer.parseInt(request.getParameter("price"));
        
        ShirtCategoryDao scd = new ShirtCategoryDao();
        
        try {
            scd.changePrice(shirtCategoryName, price);
        } catch (SQLException ex) {
            out.println(ex.getMessage());
        }
    }
    
}