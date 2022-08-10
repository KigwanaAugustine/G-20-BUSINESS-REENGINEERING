///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.August.Dao;
//
//import com.August.DBConnection;
//import com.August.entities.Shirt;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
///**
// *
// * @author Tanuki
// */
//public class ShirtDao
//{
//    DBConnection db = new DBConnection();
//    Connection con = db.getConnection();
//    String sql = null;
//    
//    public void register(Shirt shirt) throws SQLException
//    {
//        sql = "SELECT * FROM `shirt-yoo`.shirt";
//        
//        PreparedStatement pstmt = con.prepareStatement(sql);
//        
//        ResultSet rs = pstmt.executeQuery();
//        
//        while(rs.next()){
//                shoppingpackage.model.Shirt row = new shoppingpackage.model.Shirt();
//                row.setShirtID(rs.getInt("shirtID"));
//                row.setPrice(rs.getDouble("price"));
//                row.setImage(rs.getString("image"));
//                row.setCategoryName(rs.getString("categoryName"));
//                row.setDescription(rs.getString("description"));
//                 
//                shirts.add(row);
//            }
//        }catch(Exception e){
//           System.out.println(e.getMessage());
//        }
//        return shirts;
//    }
//}
//
//
