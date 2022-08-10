
package DukuShoppingPackage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import DukuShoppingPackage.model.Cart;

/**
 *
 * @author Duku Allan
 */
@WebServlet(name = "QuantityChangeServlet", urlPatterns = {"/quantity-change"})
public class QuantityChangeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter();){
            String action = request.getParameter("action");
            int id = Integer.parseInt(request.getParameter("id"));
            
            ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
            
           if(action != null && id>=1) {
               if(action.equals("inc")){
                   for(Cart c:cart_list){
                       if(c.getShirtID() == id) {
                           int quantity = c.getQuantity();
                           quantity++;
                           c.setQuantity(quantity);
                           response.sendRedirect("cart.jsp");
                       }
                   }
               }
           }
           if(action != null && id>=1) {
               if(action.equals("dec")){
                   for(Cart c:cart_list){
                       if(c.getShirtID() == id && c.getQuantity()>1) {
                           int quantity = c.getQuantity();
                           quantity--;
                           c.setQuantity(quantity);
                           break;
                       }
                   }
                   response.sendRedirect("cart.jsp");
               }
           }else{
               response.sendRedirect("cart.jsp");
           }
           
        }
    }

   

}
