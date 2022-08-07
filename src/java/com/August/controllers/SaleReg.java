///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package com.August.controllers;
//
//import com.August.Dao.SaleDao;
//import com.August.entities.Sale;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@WebServlet("/regSale")
//public class SaleReg extends HttpServlet 
//{
//  
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException 
//    {
//        PrintWriter out = response.getWriter();
//        
//        Sale sale = new Sale();
//        SaleDao sd = new SaleDao();
//        HttpSession session = request.getSession();
//        
//        int customerID = (Integer)session.getAttribute("customerID");
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        
//        sale.setCustomerID(customerID);
//        sale.setQuantity(quantity);
//       
//        
//        sd.register(sale);
//    }
//    
//}