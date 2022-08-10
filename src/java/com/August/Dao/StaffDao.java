/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.August.Dao;

import com.August.DBConnection;
import com.August.entities.Staff;
import com.August.entities.StaffProductionLine;
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
        pstmt.setInt(7, 101);
       
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
    
    public int getNumSales(String shirtCategoryName, String startDate , String endDate) throws SQLException
    {
        int numSales = 0;
        
        
        sql = "SELECT count(*)  FROM shirt inner join sale on (shirt.saleID) = (sale.saleID) WHERE ((shirtCategoryName ='"+ shirtCategoryName +"' ) AND (DATE BETWEEN '" + startDate + "'  AND '" + endDate +"'))";
        

        
        PreparedStatement pstmt = con.prepareStatement(sql);

        
        ResultSet rs = pstmt.executeQuery(sql);
        
         rs.next();
        
        numSales = rs.getInt(1);
        
        return numSales;
    }
    
    public int getTotalStaff() throws SQLException
    {
        int totalStaff = 0;
        
        sql = "SELECT count(*) FROM `shirt-yoo`.staff";
        
        PreparedStatement pstmt = con.prepareStatement(sql);
        
        ResultSet rs = pstmt.executeQuery(sql);
        
        rs.next();
        
        totalStaff = rs.getInt(1);
        
        return totalStaff;
    }
    
    
    public ArrayList<StaffProductionLine> reallocate(int eSmall, int eLarge, int eMedium, int eExtraLarge,  String endDate) throws SQLException
    {
        ArrayList<StaffProductionLine> staffAllocation = new ArrayList<>();
        StaffProductionLine staff = new StaffProductionLine();
        StaffProductionLineDao splDao = new StaffProductionLineDao();
        
        sql = "SELECT * FROM `shirt-yoo`.staff_production_line";
        
        PreparedStatement pstmt = con.prepareStatement(sql);
        
        ResultSet rs = pstmt.executeQuery(sql);
        
        //adding all the staff with their current productionLines in an arraylist
        while(rs.next())
        {
            staff.setStaffID(rs.getInt(1));
            staff.setStartDate(rs.getString(2));
            staff.setShirtCategoryName(rs.getString(3));
            
            staffAllocation.add(staff);
        }
        
        //getting totalStaff
        int totalStaff = 0;
        totalStaff = eSmall + eLarge + eMedium + eExtraLarge;
        
        //updating production lines for staff
        for(int i = 0; i < eSmall; i++)
        {
            staff = staffAllocation.get(i);
            
            if(staff.getShirtCategoryName().equals("Small"))
              continue;
            else
            {
                 splDao.insert(staff.getStaffID(), "Small",  endDate);
                 staff.setShirtCategoryName("Small"); 
            }
               
        }
        
        for(int i = eSmall; i < (eSmall + eMedium); i++)
        {
            staff = staffAllocation.get(i);
            
            if(staff.getShirtCategoryName().equals("Medium"))
              continue;
            else
            {
                splDao.insert(staff.getStaffID(), "Medium", endDate);
                staff.setShirtCategoryName("Medium");               
            }
        }
        
        for(int i = (eSmall + eMedium); i < (eSmall + eMedium + eLarge); i++)
        {
            staff = staffAllocation.get(i);
            
            if(staff.getShirtCategoryName().equals("Large"))
              continue;
            else
            {
                splDao.insert(staff.getStaffID(), "Large", endDate);
                staff.setShirtCategoryName("Large"); 
                
            }
        }
        
        for(int i = (eSmall + eMedium + eLarge); i < (eSmall + eMedium + eLarge + eExtraLarge); i++)
        {
            staff = staffAllocation.get(i);
            
            if(staff.getShirtCategoryName().equals("ExtraLarge"))
              continue;
            else
            {
                splDao.insert(staff.getStaffID(), "ExtraLarge", endDate);
                staff.setShirtCategoryName("ExtraLarge"); 
            }
        }
        
           
        
        return staffAllocation;
    }
}
