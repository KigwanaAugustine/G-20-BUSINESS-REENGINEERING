/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.August.Dao;

import com.August.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Tanuki
 */
public class StaffProductionLineDao 
{
    DBConnection db = new DBConnection();
    Connection con = db.getConnection();
    String sql = null;
    
    public void insert(int staffID, String shirtCategoryName, String endDate) throws SQLException
    {
        sql = "INSERT INTO `shirt-yoo`.`staff_production_line` (`staffID`, `startDate`, `shirtCategoryName`) VALUES (?, ?, ?)";
        
        PreparedStatement pstmt = con.prepareStatement(sql);
        
        pstmt.setInt(1, staffID );
        pstmt.setString(2, endDate);
        pstmt.setString(3, shirtCategoryName);
        
        pstmt.executeUpdate();
    }
}
