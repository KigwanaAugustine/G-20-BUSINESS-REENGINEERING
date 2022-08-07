/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.August.Dao;

import com.August.DBConnection;
import com.August.entities.Manager;
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
public class ManagerDao 
{
    DBConnection db = new DBConnection();
    Connection con = db.getConnection();
    
    public boolean check(String sUserName, String sPassword)
    {
        String sql = "SELECT * FROM manager WHERE sUserName = ? and sPassword = ?";
        
    try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, sUserName);
            st.setString(2, sPassword);
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next())
               return true;
                
                try{
                rs.close();
             } catch(SQLException e) {
                System.out.println(e.getMessage());
             }     
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }

        
        return false;
    }
    
    
    public Manager[] selectManager() throws SQLException
    {
        Manager[] managers = new Manager[2];
        Statement stmt = con.createStatement();
        String sql = "SELECT * FROM manager";
        ResultSet rs = stmt.executeQuery(sql);
        
        int i = 0;
        while( rs.next())
        {
            managers[i] = new Manager(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8));
        }
       
      
        
//        Manager m = new Manager(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8));
            try{
                rs.close();
                stmt.close();
             } catch(SQLException e) {
                System.out.println(e.getMessage());
             }
 
        
        return managers;
    }
    
    
    public int updateManager() throws SQLException
    {
        String sqlUpdate = "UPDATE `shirt-yoo`.`manager` SET `sLname` = ? WHERE (`managerID` = ?)";
        
        PreparedStatement pstmt = con.prepareStatement(sqlUpdate);
        
        String sLname = "August";
        int managerID = 101;
        
        pstmt.setString(1, sLname);
        pstmt.setInt(2, managerID);
        
        int rowsAffected = pstmt.executeUpdate();
        
        try{
                pstmt.close();
             } catch(SQLException e) {
                System.out.println(e.getMessage());
             }
        
        return rowsAffected;
    }
          
    
    public void register(Manager m) throws SQLException
    {
        ResultSet rs = null;
       
        String sql = "INSERT INTO `shirt-yoo`.`manager` "
                + "(`managerID`, `sFname`, `sLname`, `address`, `salary`, `sEmail`, `sPassword`, `sUserName`)" 
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        pstmt.setInt(1, m.getManagerID());
        pstmt.setString(2, m.getSFname());
        pstmt.setString(3, m.getSLname());
        pstmt.setString(4, m.getAddress());
        pstmt.setDouble(5, m.getSalary());
        pstmt.setString(6, m.getSEmail());
        pstmt.setString(7, m.getSPassword());
        pstmt.setString(8, m.getSUserName());
        
        int rowAffected = pstmt.executeUpdate();
//        
//        if(rowAffected == 1)
//        {
//            rs = pstmt.getGeneratedKeys();
//            
//            if(rs.next())
//                 managerID = rs.getInt(1);
//        }
        
        try{
                rs.close();
                pstmt.close();
             } catch(SQLException e) {
                System.out.println(e.getMessage());
             }
        
       
    }

    
}
