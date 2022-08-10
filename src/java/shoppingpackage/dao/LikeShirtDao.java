
package shoppingpackage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import shoppingpackage.model.LikeShirt;

/**
 *
 * @author Duku Allan
 */
public class LikeShirtDao {
    
    private Connection con;
        private String query;
        private PreparedStatement pst;
        private ResultSet rs;
        
        public LikeShirtDao(Connection con){
            this.con =con;
        }
     public void register(LikeShirt like) throws SQLException{
         
         
       if(like.getCustomerID() != 0) //registering like with a logged in customer
       {
           query= "insert into customer_like (shirtID,  customerID) value(?,?)";
           
           
           
           pst = con.prepareStatement(query);
           
           pst.setInt(1, like.getShirtID());
           pst.setInt(2, like.getCustomerID());
          
           
           
       }
       else //registering like with unknown customer
       {
           query = "insert into customer_like (shirtID) value(?)";
           
           pst = con.prepareStatement(query);
           
           pst.setInt(1, like.getShirtID());
           
       }
       
        pst.executeUpdate();
        
        
    }
    
}
