
package DukuShoppingPackage.connection;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author Duku Allan
 */
public class DbCon 
{
    String url = "jdbc:mysql://localhost:3306/shirt-yo";
    String username = "root";
    String password = "";
    
    public Connection getConnection() {
      Connection connection = null;
        
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.print("Connected");
        } catch (Exception e)
        {
            e.getMessage();
        }
        
        return connection;
        
    }
}
