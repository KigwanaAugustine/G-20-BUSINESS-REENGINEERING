/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.August;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Tanuki
 */
public class DBConnection 
{
    String url ="jdbc:mysql://localhost:3306/shirt-yoo";
    String username = "root";
    String password = "@Tanuki12broz";
    

    
    //connection
    public Connection getConnection()
    {
        Connection con = null;
        
        try 
        {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, username, password);
        
        
         } catch (Exception e) 
        {
            e.getMessage();
        }
        
        return con;
    }
    
    
}
