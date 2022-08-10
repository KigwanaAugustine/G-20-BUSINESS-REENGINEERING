
package DukuShoppingPackage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DukuShoppingPackage.connection.DbCon;
import DukuShoppingPackage.dao.CustomerDao;
import DukuShoppingPackage.model.CustomerModel;

/**
 *
 * @author Duku Allan
 */
@WebServlet("/customer-loginServlet")
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
           String cEmail = request.getParameter("login-email");
           String cPassword = request.getParameter("login-password");
           
           try{ 
           DbCon db1 = new DbCon();  
           CustomerDao cDao = new CustomerDao(db1.getConnection());
           CustomerModel customer = cDao.customerLogin(cEmail, cPassword);
           
           if(customer != null){
               request.getSession().setAttribute("auth", customer);
               response.sendRedirect("index.jsp");
           }else{
               out.print("customer login failed...");  
           }
           }catch (Exception e){
               e.getMessage();
           }
        }
    }

}
