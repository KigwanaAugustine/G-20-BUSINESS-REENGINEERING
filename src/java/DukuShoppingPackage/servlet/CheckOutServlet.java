
package DukuShoppingPackage.servlet;

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
import DukuShoppingPackage.connection.DbCon;
import DukuShoppingPackage.dao.OrderDao;
import DukuShoppingPackage.model.Cart;
import DukuShoppingPackage.model.CustomerModel;
import DukuShoppingPackage.model.Order;
import jakarta.servlet.http.HttpSession;
import java.text.DateFormat;

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
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
               String date = formatter.format(new Date(System.currentTimeMillis()));
                
                //retrieve all cart products
                ArrayList<Cart> cart_list = (ArrayList<Cart>)request.getSession().getAttribute("cart-list");
                
                //User authentication
                HttpSession session = request.getSession();
                int customerID = 0;
    
                if(session.getAttribute("customerID") == null)
                 response.sendRedirect("login.jsp");
                else
                  customerID = (int)session.getAttribute("customerID");
    
                String username = (String) session.getAttribute("username");
                 
                //check auth and cart list
                if (cart_list != null ){
                    //prepare the order object
                    for(Cart c: cart_list){
                        Order order = new Order();
                        order.setShirtID(c.getShirtID());
                        order.setCustomerID(customerID);
                        order.setQuantity(c.getQuantity());
                        order.setDate(date);
                        
                        //instantiate the dao class
                    
                        OrderDao oDao = new OrderDao();
                        //calling the insert
                        boolean result = oDao.insertOrder(order);
                        if(!result) break; 
                    }
                    
                    cart_list.clear();
                    response.sendRedirect("orders.jsp");
                }
//                else{
//                    if(customer == null) response.sendRedirect("login.jsp");
//                        
//                        response.sendRedirect("cart.jsp");
//                }
            }catch(Exception e){
                e.printStackTrace();
            }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    

}
