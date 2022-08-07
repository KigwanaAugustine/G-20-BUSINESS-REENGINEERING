/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.August.Dao;

import com.August.DBConnection;
import com.August.entities.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Tanuki
 */
public class StaffDao 
{
    DBConnection db = new DBConnection();
    Connection con = db.getConnection();
    String sql = null;
    
    public void register(Staff staff) throws SQLException
    {
        sql = "INSERT INTO `shirt-yoo`.`staff` "
           + "(`sFname`, `sLname`, `gender`, `address`, `salary`, `sEmail`, `managerID`) "
           + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        pstmt.setString(1, staff.getSFname());
        pstmt.setString(2, staff.getSLname());
        pstmt.setString(3, staff.getGender());
        pstmt.setString(4, staff.getAddress());
        pstmt.setDouble(5, staff.getSalary());
        pstmt.setString(6, staff.getSEmail());
        pstmt.setInt(7, staff.getManagerID());
       
         int rowAffected = pstmt.executeUpdate();
    }
}
