/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.August.Dao;

import com.August.DBConnection;
import com.August.entities.CustomerLike;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tanuki
 */
public class CustomerLikeDao 
{
    
    DBConnection db = new DBConnection();
    Connection con = db.getConnection();
    String sql = null;
    PreparedStatement pstmt;
    ResultSet rs;
    
    public void register(CustomerLike like) throws SQLException
    {
       if(like.getCustomerID() != 0) //registering like with a logged in customer
       {
           sql = "INSERT INTO `shirt-yoo`.`customer_like` "
               + "(`shirtID`, `customerID`) "
               + "VALUES (?, ?)";
           
           pstmt = con.prepareStatement(sql);
           
           pstmt.setInt(1, like.getShirtID());
           pstmt.setInt(2, like.getCustomerID());
           
           
       }
       else //registering like with unknown customer
       {
           sql = "INSERT INTO `shirt-yoo`.`customer_like` "
               + "(`shirtID`) "
               + "VALUES (?)";
           
           pstmt = con.prepareStatement(sql);
           
           pstmt.setInt(1, like.getShirtID());
       }
       
        pstmt.executeUpdate();
    }
}
