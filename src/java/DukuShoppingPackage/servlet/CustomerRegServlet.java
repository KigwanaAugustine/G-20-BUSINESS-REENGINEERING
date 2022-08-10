
package DukuShoppingPackage.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import DukuShoppingPackage.connection.DbCon;
import DukuShoppingPackage.dao.CustomerDao;
import DukuShoppingPackage.model.CustomerModel;


/**
 *
 * @author Tanuki
 */
@WebServlet("/cRegister")
public class CustomerRegServlet extends HttpServlet 
{
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
        CustomerModel c = new CustomerModel();
      
       c.setcFname(request.getParameter("cFname"));
       c.setcLname(request.getParameter("cLname"));
       c.setGender(request.getParameter("gender"));
       c.setLocation(request.getParameter("location"));
       c.setcEmail(request.getParameter("cEmail"));
       c.setcPassword(request.getParameter("cPassword"));
//       c.setcUserName(request.getParameter("cUserName"));
       
        
       
       
        try {
            DbCon db1 = new DbCon();  
        CustomerDao cDao = new CustomerDao(db1.getConnection());
            cDao.regCustomer(c);
            response.sendRedirect("cart.jsp");
        } catch (Exception ex) 
        {
            out.println(ex.getMessage());
        }
       
    }

    

}
