
package shoppingpackage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import shoppingpackage.connection.DbCon;
import shoppingpackage.dao.OrderDao;
import shoppingpackage.model.Cart;
import shoppingpackage.model.CustomerModel;
import shoppingpackage.model.Order;

/**
 *
 * @author Duku Allan
 */
@WebServlet(name = "CheckOutServlet", urlPatterns = {"/check-out"})
public class CheckOutServlet extends HttpServlet {

  
        
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
            try(PrintWriter out = response.getWriter()){
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                
                //retrieve all cart products
                ArrayList<Cart> cart_list = (ArrayList<Cart>)request.getSession().getAttribute("cart-list");
                
                //User authentication
                CustomerModel  customer = (CustomerModel)request.getSession().getAttribute("auth");
                
                //check auth and cart list
                if (cart_list != null &&  customer != null){
                    //prepare the order object
                    for(Cart c: cart_list){
                        Order order = new Order();
                        order.setShirtID(c.getShirtID());
                        order.setCustomerID(customer.getCustomerID());
                        order.setQuantity(c.getQuantity());
                        order.setDate(formatter.format(date));
                        
                        //instantiate the dao class
                        DbCon db = new DbCon();
                        OrderDao oDao = new OrderDao(db.getConnection());
                        //calling the insert
                        boolean result = oDao.insertOrder(order);
                        if(!result) break; 
                    }
                    
                    cart_list.clear();
                    response.sendRedirect("orders.jsp");
                }else{
                    if(customer == null) response.sendRedirect("login.jsp");
                        
                        response.sendRedirect("cart.jsp");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    

}
