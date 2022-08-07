/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.August.Dao;

import com.August.DBConnection;
import com.August.entities.ProductionLineCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Tanuki
 */
public class ProductionLineCategoryDao 
{
    
    DBConnection db = new DBConnection();
    Connection con = db.getConnection();
    String sql = null;
    
    public void register(ProductionLineCategory pLineCat) throws SQLException
    {
        sql = "INSERT INTO `shirt-yoo`.`production_line_category` "
            + "(`lineCategoryName`, `dailyNumShirts`, `dailyNumStaff`) "
            + "VALUES (?,?,?)";
        
        PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        pstmt.setString(1, pLineCat.getLineCategoryName());
        pstmt.setInt(2, pLineCat.getDailyNumShirts());
        pstmt.setInt(3, pLineCat.getDailyNumStaff());
        
        int rowAffected = pstmt.executeUpdate();
    }
    
    
    public void updateDailyNumShirts(String lineCatName, int dailyNumShirts) throws SQLException
    {
        sql = "UPDATE `shirt-yoo`.`production_line_category` "
             + "SET `dailyNumShirts` = ? "
             + "WHERE (`lineCategoryName` = ?)";
        
        PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        pstmt.setInt(1, dailyNumShirts);
        pstmt.setString(2, lineCatName);
        
         int rowAffected = pstmt.executeUpdate();
        
    }
}
