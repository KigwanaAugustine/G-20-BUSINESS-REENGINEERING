
package DukuShoppingPackage.servlet;

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
import DukuShoppingPackage.connection.DbCon;
import DukuShoppingPackage.dao.OrderDao;
import DukuShoppingPackage.model.Cart;
import DukuShoppingPackage.model.Order;
import java.text.DateFormat;

/**
 *
 * @author Duku Allan
 */
@WebServlet(name = "OrderNowServlet", urlPatterns = {"/order-now"})
public class OrderNowServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()){
            
            int customerID = 0;
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            String date = formatter.format(new Date(System.currentTimeMillis()));
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            
//            Date date = new Date();
           
           if(request.getSession().getAttribute("customerID") == null)
            response.sendRedirect("login.jsp");
            else
            customerID = (int)request.getSession().getAttribute("customerID");
           
            String  username = (String)request.getSession().getAttribute("username");
            
           if(username != null) {
               String productId = request.getParameter("id");
               int productQuantity = Integer.parseInt(request.getParameter("quantity"));
               if(productQuantity <= 0){
                   productQuantity=1;
               }
               
               Order orderModel = new Order();
               orderModel.setShirtID(Integer.parseInt(productId));
               orderModel.setCustomerID(customerID);
               orderModel.setQuantity(productQuantity);
               orderModel.setDate(date);
               
               OrderDao orderDao = new OrderDao();
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

   


