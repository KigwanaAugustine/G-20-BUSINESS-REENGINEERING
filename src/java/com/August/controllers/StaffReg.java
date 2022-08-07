package com.August.controllers;

import com.August.Dao.CustomerDao;
import com.August.Dao.StaffDao;
import com.August.entities.Customer;
import com.August.entities.Staff;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/sReg")
public class StaffReg extends HttpServlet 
{
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
        Staff staff = new Staff();
      
       staff.setSFname(request.getParameter("sFname"));
       staff.setSLname(request.getParameter("sLname"));
       staff.setGender(request.getParameter("gender"));
       staff.setAddress(request.getParameter("address"));
       staff.setSalary(Integer.parseInt(request.getParameter("salary")));
       staff.setSEmail(request.getParameter("sEmail"));
       staff.setManagerID(Integer.parseInt(request.getParameter("managerID")));
       
      StaffDao sd = new StaffDao();
       
        try {
            sd.register(staff);
        } catch (SQLException ex) 
        {
            out.println(ex.getMessage());
        }
       
       
       
        
    }

    

}