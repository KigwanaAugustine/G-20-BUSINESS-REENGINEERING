/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.August.Dao;

import com.August.DBConnection;
import com.August.entities.Sale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Tanuki
 */
public class SaleDao 
{
    DBConnection db = new DBConnection();
    Connection con = db.getConnection();
    String sql = null;
    
    public void register(Sale sale) throws SQLException
    {
        sql = "INSERT INTO `shirt-yoo`.`sale` (`customerID`, `quantity`) VALUES (?, ?)";
        
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, sale.getCustomerID());
        pstmt.setInt(2, sale.getQuantity());
        
        pstmt.executeUpdate();
    }
}
