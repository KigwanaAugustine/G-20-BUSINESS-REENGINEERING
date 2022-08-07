///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package com.August.controllers;
//
//import com.August.DBConnection;
//import com.August.entities.Shirt;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//
//@WebServlet("/regShirt")
//public class ShirtReg extends HttpServlet 
//{
//    DBConnection db = new DBConnection();
//    Connection con = db.getConnection();
//    String sql = null;
//  
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException 
//    {
//        PrintWriter out = response.getWriter();
//    }
//    
//    Shirt shirt = new Shirt();
//    
//    ShirtDao sd = new ShirtDao();
//    
//    sd.register(sd);
//    
//}