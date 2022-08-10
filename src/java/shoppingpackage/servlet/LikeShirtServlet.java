/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package shoppingpackage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import shoppingpackage.connection.DbCon;
import shoppingpackage.dao.LikeShirtDao;
import shoppingpackage.model.LikeShirt;

/**
 *
 * @author Duku Allan
 */
@WebServlet(name = "LikeShirtServlet", urlPatterns = {"/like-shirt"})
public class LikeShirtServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.sendRedirect("index.jsp");
        PrintWriter out = response.getWriter();
        LikeShirt like = new LikeShirt();
        
        HttpSession session = request.getSession();
        
        DbCon db = new DbCon();
        
        LikeShirtDao cLikeDao = new LikeShirtDao(db.getConnection());
        
        String cFname = (String)session.getAttribute("cEmail");
        if( cFname != null) //when user likes a product and they are logged in
        {
            int customerID = (Integer)session.getAttribute("customerID");
            
            if(customerID != 0)  like.setCustomerID(customerID);
            
            like.setShirtID(Integer.parseInt(request.getParameter("shirtID")));
            try {
                cLikeDao.register(like);
            } catch (Exception ex) {
               out.print(ex.getMessage());
            }
        }
        else
        {
            
            like.setShirtID(Integer.parseInt(request.getParameter("shirtID")));
            try {
                cLikeDao.register(like);
            } catch (Exception ex) {
                out.print(ex.getMessage());
            }
        }
        
        
    }
    }

   
  

