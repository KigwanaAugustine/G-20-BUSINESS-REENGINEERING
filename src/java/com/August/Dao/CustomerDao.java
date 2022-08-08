/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.August.Dao;

import com.August.DBConnection;
import com.August.entities.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Tanuki
 */
public class CustomerDao 
{
    DBConnection db = new DBConnection();
    Connection con = db.getConnection();
    String sql = null;
    
     public boolean check(String cUserName, String cPassword)
    {
         sql = "SELECT * FROM customer WHERE cUserName = ? and cPassword = ?";
        
    try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, cUserName);
            st.setString(2, cPassword);
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next())
                return true;
               //return rs.getString(1);
                
                try{
                rs.close();
             } catch(SQLException e) {
                System.out.println(e.getMessage());
             }     
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }

        //"Nothing came back"
        return false;
    }
    //register customer
    public void register(Customer c) throws SQLException
    {
        sql = "INSERT INTO `shirt-yoo`.`customer` "
            + "(`cFname`, `cLname`, `gender`, `location`, `cEmail`, `cPassword`, `cUserName`) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        pstmt.setString(1, c.getCFname());
        pstmt.setString(2, c.getCLname());
        pstmt.setString(3, c.getGender());
        pstmt.setString(4, c.getLocation());
        pstmt.setString(5, c.getCEmail());
        pstmt.setString(6, c.getCPassword());
        pstmt.setString(7, c.getCUserName());
        
        int rowAffected = pstmt.executeUpdate();
        
    }
    //search customer by the user name
    public int searchCustomer(String cUsername) throws SQLException
    {
        ResultSet rs;
        int customerID = 0;
        
        sql = "SELECT customerID\n" +
              "FROM `shirt-yoo`.customer\n" +
              "WHERE cUserName = ?";
        
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, cUsername);
        
        rs  = pstmt.executeQuery();
        
        while(rs.next())
        {
            customerID = rs.getInt(1);
        }
        
        
        return customerID;
    }
    
     public ArrayList<Customer> getCustomers() throws SQLException
    {
        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer = new Customer();
        
        sql = "SELECT * FROM `shirt-yoo`.customer";
        Statement stmt = con.createStatement(); 
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next())
        {
            customer.setCustomerID(rs.getInt(1));
            customer.setCFname(rs.getString(2));
            customer.setCLname(rs.getString(3));
            customer.setGender(rs.getString(4));
            customer.setLocation(rs.getString(5));
            customer.setCEmail(rs.getString(6));
            
          
            customers.add(customer);
        }
           
        return customers;
    }
}
