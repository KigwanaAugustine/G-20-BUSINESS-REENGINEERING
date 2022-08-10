/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.August.controllers;

import com.August.Dao.CustomerDao;
import com.August.Dao.CustomerLikeDao;
import com.August.entities.CustomerLike;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet("/regLike")
public class RegLike extends HttpServlet 
{
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
        CustomerLike like = new CustomerLike();
        
        HttpSession session = request.getSession();
        
        CustomerLikeDao cLikeDao = new CustomerLikeDao();
        
        String cUserName = (String)session.getAttribute("username");
        if( cUserName != null) //when user likes a product and they are logged in
        {
            int customerID = (Integer)session.getAttribute("customerID");
            
            if(customerID != 0)  
            like.setCustomerID(customerID);
            
            like.setShirtID(Integer.parseInt(request.getParameter("shirtID")));
            try {
                cLikeDao.register(like);
            } catch (SQLException ex) {
               out.print(ex.getMessage());
            }
        }
        else
        {
            
            like.setShirtID(Integer.parseInt(request.getParameter("shirtID")));
            try {
                cLikeDao.register(like);
            } catch (SQLException ex) {
                out.print(ex.getMessage());
            }
        }
        
        
    }
    
}