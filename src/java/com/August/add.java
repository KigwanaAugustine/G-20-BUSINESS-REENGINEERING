

package com.August;

import com.August.Dao.ManagerDao;
import com.August.entities.Manager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/add")
public class add extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res) 
           throws ServletException , IOException
    {
        PrintWriter out = res.getWriter();
        
        
      //  ManagerDao md = new ManagerDao();
        
        try {
            
//            Manager[] managers = new Manager[2];
//            
//            managers[0] = new Manager();
//            managers[1] = new Manager();
//            
//            managers = md.selectManager();
//            
//            for(int i = 0; i < 2; i++)
//            {
//                managers[i].toString();
//                out.println();
//            }
//            Manager m = md.selectManager();
//            
//            out.println("MANAGER B4");
//            out.println(m.toString());
//           
//            
//            int x = md.updateManager();
//            
//            Manager m2 = md.selectManager();
//            
//            out.println();
//            
//            out.println(x + " rows affected, new Manager");
//            out.println(m2.toString());
            
//            md.insertManager();
//            Manager m = md.selectManager();
//            out.println(m.toString());
            

            
            
        } catch (Exception e) {
           out.println(e.getMessage());
        }
        
//        Alien august = new Alien(101, "august", "java");
//        
//        
//        List<Alien> aliens = Arrays.asList(new Alien(101, "august", "java"), new Alien(102 ,"torelo", "python"));
//        
//        req.setAttribute("aliens",aliens);
//        
//        RequestDispatcher rd = req.getRequestDispatcher("play.jsp");
//        rd.forward(req, res);
//        
//        int num1 = Integer.parseInt(req.getParameter("num1"));
//        int num2 = Integer.parseInt(req.getParameter("num2"));
//        
//        out.println("Sum is " + (num1 + num2));
        
    }
}
