
package shoppingpackage.servlet;

import com.August.entities.Customer;
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
import shoppingpackage.model.Order;

/**
 *
 * @author Duku Allan
 */
@WebServlet(name = "OrderNowServlet", urlPatterns = {"/order-now"})
public class OrderNowServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            
            Date date = new Date();
           Customer  customer = (Customer)request.getSession().getAttribute("auth");
           if(customer != null) {
               String productId = request.getParameter("id");
               int productQuantity = Integer.parseInt(request.getParameter("quantity"));
               if(productQuantity <= 0){
                   productQuantity=1;
               }
               
               Order orderModel = new Order();
               orderModel.setShirtID(Integer.parseInt(productId));
               orderModel.setCustomerID(customer.getCustomerID());
               orderModel.setQuantity(productQuantity);
               orderModel.setDate(formatter.format(date));
               
               DbCon db = new DbCon();
               OrderDao orderDao = new OrderDao(db.getConnection());
               boolean result = orderDao.insertOrder(orderModel);
               
               if(result){
                    ArrayList<Cart> cart_list = (ArrayList<Cart>)request.getSession().getAttribute("cart-list");
                if(cart_list != null){
                    for(Cart c:cart_list){
                        if(c.getShirtID()==Integer.parseInt(productId)){
                            cart_list.remove(cart_list.indexOf(c));
                            break;
                        }
                    }
                }
                   response.sendRedirect("orders.jsp");
               }else{
                   out.print("order failed");
               }   
               
           }else{
               response.sendRedirect("login.jsp");
           }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doGet(request, response);
    }
    }

   


