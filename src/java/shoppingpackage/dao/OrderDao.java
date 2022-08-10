
package shoppingpackage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import shoppingpackage.model.Order;

/**
 *
 * @author Duku Allan
 */
public class OrderDao {
        private Connection con;
        private String query;
        private PreparedStatement pst;
        private ResultSet rs;
        
        public OrderDao(Connection con){
            this.con =con;
        }
        
        public boolean insertOrder(Order model){
            boolean result = false;
            try{
                query = "insert into sale (customerID, shirtID, quantity, date) value(?,?,?,?)";
                
                pst = this.con.prepareStatement(query);
                pst.setInt(1, model.getCustomerID());
                pst.setInt(2, model.getShirtID());
                pst.setInt(3, model.getQuantity());
                pst.setString(4, model.getDate());
                pst.executeUpdate();
                result = true;
                
            }catch(Exception e) {
                e.printStackTrace();
            }
            return result;
        }
    
}
