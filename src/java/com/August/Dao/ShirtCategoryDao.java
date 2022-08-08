/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.August.Dao;

import com.August.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Tanuki
 */
public class ShirtCategoryDao 
{
    DBConnection db = new DBConnection();
    Connection con = db.getConnection();
    String sql = null;
    
    public void changePrice(String shirtCategoryName,int price) throws SQLException
    {
        sql = "UPDATE `shirt-yoo`.`shirt_category` SET `price` = ? WHERE (`shirtCategoryName` = ?)";
        
        PreparedStatement pstmt = con.prepareStatement(sql);
        
        pstmt.setInt(1, price);
        pstmt.setString(2, shirtCategoryName);
        pstmt.executeUpdate();
        
        try{
                pstmt.close();
             } catch(SQLException e) {
                System.out.println(e.getMessage());
             }
        
    }
}