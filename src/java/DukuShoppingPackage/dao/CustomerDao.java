
package DukuShoppingPackage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;import java.sql.Statement;
;
import DukuShoppingPackage.model.CustomerModel;
import DukuShoppingPackage.model.CustomerModel;
import DukuShoppingPackage.model.Order;
import DukuShoppingPackage.model.CustomerModel;
import DukuShoppingPackage.model.CustomerModel;

public class CustomerDao {
            private Connection con;
            private String query;
            private PreparedStatement pst;
            private ResultSet rs;

    public CustomerDao(Connection con) {
        this.con = con;
    }
    public CustomerModel customerLogin(String cEmail, String cPassword)  {
        CustomerModel customer = null;
            try{
                query = "select * from customer where cEmail =? and cPassword =?";
                pst = this.con.prepareStatement(query);
                pst.setString(1, cEmail);
                pst.setString(2, cPassword);
                rs = pst.executeQuery();
                
                if(rs.next()) {
                    customer = new CustomerModel();
                    customer.setCustomerID(rs.getInt("customerID"));
                    customer.setcFname(rs.getString("cFname"));
                    customer.setcLname(rs.getString("cLname"));
                    customer.setcEmail(rs.getString("cEmail"));
                }
            }catch(Exception e) {
                e.printStackTrace(); 
                System.out.println(e.getMessage());
            }
            return customer;        

    } 
    public boolean regCustomer(CustomerModel c){
            boolean result = false;
            try{
                query = "insert into customer (cFname, cLname, gender, location, cEmail, cPassword) value(?,?,?,?,?,?)";
                
                pst = this.con.prepareStatement(query);
                    pst.setString(1, c.getcFname());
                    pst.setString(2, c.getcLname());
                    pst.setString(3, c.getGender());
                    pst.setString(4, c.getLocation());
                    pst.setString(5, c.getcEmail());
                    pst.setString(6, c.getcPassword());
//                    pst.setString(7, c.getCUserName());
                pst.executeUpdate();
                result = true;
                
            }catch(Exception e) {
                e.printStackTrace();
            }
            return result;
        }
}
