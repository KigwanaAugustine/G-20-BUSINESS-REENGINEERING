
package DukuShoppingPackage.dao;

import com.August.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import DukuShoppingPackage.model.Cart;
import DukuShoppingPackage.model.Shirt;

/**
 *
 * @author Duku Allan
 */
public class ShirtDao {
            
    DBConnection db = new DBConnection();
    Connection con = db.getConnection();
    String query = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    
    public List<Shirt> getAllShirts(){
        List<Shirt> shirts = new ArrayList<Shirt>();
        try{
            query = "SELECT * FROM `shirt-yoo`.shirt";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next()){
                Shirt row = new Shirt();
                row.setShirtID(rs.getInt("shirtID"));
                row.setPrice(rs.getDouble("price"));
                row.setImage(rs.getString("image"));
                row.setShirtCategoryName(rs.getString("shirtCategoryName"));
                row.setDescription(rs.getString("description"));
                 
                shirts.add(row);
            }
        }catch(Exception e){
           System.out.println(e.getMessage());
        }
        return shirts;
    }
    
    public List<Cart> getCartShirts(ArrayList<Cart> cartList){
        List<Cart> shirts = new ArrayList<Cart>();
        
        try{
            if(cartList.size()>0){
                for(Cart item:cartList){
                    query = "select * from shirt where shirtID=?";
                    pst = con.prepareStatement(query);
                    pst.setInt(1, item.getShirtID());
                    rs = pst.executeQuery();
                    while(rs.next()){
                        Cart row = new Cart();
                         row.setShirtID(rs.getInt("shirtID"));
                         row.setDescription(rs.getString("description"));
                         row.setPrice(rs.getDouble("price")*item.getQuantity());
                         row.setShirtCategoryName(rs.getString("shirtCategoryName"));
//                         row.setQuantity(rs.getInt("quantity"));
                         shirts.add(row);
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            
        }
        return shirts;
    }
    
    public double getTotalCartPrice(ArrayList<Cart> cartList) {
        double sum = 0;
        
        try{
            if(cartList.size()>0){
                for(Cart item:cartList) {
                    query = "select price from shirt where shirtID=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getShirtID());
                    rs = pst.executeQuery();
                    
                    while(rs.next()){
                        sum += rs.getDouble("price")*item.getQuantity();
                    }
                }
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage()); 
        }
        
        return sum;
    }
            
}
