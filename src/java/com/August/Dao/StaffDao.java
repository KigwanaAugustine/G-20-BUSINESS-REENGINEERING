/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.August.Dao;

import com.August.DBConnection;
import com.August.entities.Staff;
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
    
    public ArrayList<Staff> getEmployees() throws SQLException
    {
        ArrayList<Staff> employees = new ArrayList<>();
        Staff staff = new Staff();
        
        sql = "SELECT * FROM `shirt-yoo`.staff";
        Statement stmt = con.createStatement(); 
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next())
        {
            staff.setStaffID(rs.getInt(1));
            staff.setSFname(rs.getString(2));
            staff.setSLname(rs.getString(3));
            staff.setGender(rs.getString(4));
            staff.setAddress(rs.getString(5));
            staff.setSalary(rs.getDouble(6));
            staff.setSEmail(rs.getString(7));
            staff.setManagerID(rs.getInt(8));
            
          
            employees.add(staff);
        }
           
        return employees;
    }
}
