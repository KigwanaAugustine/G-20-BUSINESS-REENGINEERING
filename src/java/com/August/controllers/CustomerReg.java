
package com.August.controllers;

import com.August.Dao.CustomerDao;
import com.August.entities.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tanuki
 */
@WebServlet("/cReg")
public class CustomerReg extends HttpServlet 
{
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
        Customer c = new Customer();
      
       c.setCFname(request.getParameter("cFname"));
       c.setCLname(request.getParameter("cLname"));
       c.setGender(request.getParameter("gender"));
       c.setLocation(request.getParameter("location"));
       c.setCEmail(request.getParameter("cEmail"));
       c.setCPassword(request.getParameter("cPassword"));
       c.setCUserName(request.getParameter("cUserName"));
       
       CustomerDao cd = new CustomerDao();
       
        try {
            cd.register(c);
        } catch (SQLException ex) 
        {
            out.println(ex.getMessage());
        }
       
       
       
        
    }

    

}
