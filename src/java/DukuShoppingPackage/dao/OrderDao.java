
package DukuShoppingPackage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DukuShoppingPackage.model.Order;
import com.August.DBConnection;

/**
 *
 * @author Duku Allan
 */
public class OrderDao {
    DBConnection db = new DBConnection();
    Connection con = db.getConnection();
    String query = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public OrderDao() {
    }
        
        
        public boolean insertOrder(Order model){
            boolean result = false;
            try{
                query = "insert into sale (customerID, date) value(?,?)";
                
                pst = con.prepareStatement(query);
                pst.setInt(1, model.getCustomerID());
                pst.setString(2, model.getDate());
                pst.executeUpdate();
                result = true;
                
                query = "SELECT  saleID FROM `shirt-yoo`.sale WHERE customerID = ? AND date=?";
                
                pst = con.prepareStatement(query);
                
                pst.setInt(1, model.getCustomerID());
                pst.setString(2, model.getDate());
                
                rs = pst.executeQuery();
                rs.next();
                int saleID = rs.getInt(1);
                
                //registering the sale 
                
               
            }catch(Exception e) {
                e.printStackTrace();
            }
            return result;
        }
    
}
