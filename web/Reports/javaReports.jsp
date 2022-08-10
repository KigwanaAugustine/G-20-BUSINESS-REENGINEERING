<%-- 
    Document   : javaReports
    Created on : Aug 5, 2022, 10:41:49 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; chars1et=UTF-8">
        <title>Tables</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <table>
            <tr>
                <td>
        <%@include file="connection.jsp" %>
        
        <%  
                Statement st1 = conn.createStatement();
                ResultSet rs1 = st1.executeQuery("SELECT * FROM customer");
            
        %>

        <h2>Table of customers</h2>
        <table border="1"class="table table-dark">
            <tr>
                <th>Customer Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Gender</th>
                <th>Location</th>
                <th>Email</th>
                <th>Password</th>
            </tr>
            <%
                while(rs1.next()){
                %>
                <tr>
                    <td><%out.println(rs1.getInt(1));%></td>
                    <td><%out.println(rs1.getString(2));%></td>
                    <td><%out.println(rs1.getString(3));%></td>
                    <td><%out.println(rs1.getString(4));%></td>
                    <td><%out.println(rs1.getString(5));%></td>
                    <td><%out.println(rs1.getString(6));%></td>
                    <td><%out.println(rs1.getString(7));%></td>
                </tr>
            <%
                
            }
        %>
        </table>

        <%
        Statement st2 = conn.createStatement();
        ResultSet rs2 = st2.executeQuery("SELECT COUNT(customerID) FROM customer");
        rs2.next();
        
        int CustomerNo = rs2.getInt(1);
        
        %>        
    
        <h2>Number of Customers: <%=CustomerNo%></h2>
       </td>
        <%-- Table of sales code starts here--%>
        <td style="padding-left: 300px">
        <h2>Table of sales</h2>
        <table border="1"class="table table-dark">
            <tr>
                <th>Sale ID</th>
                <th>Customer ID</th>
                <th>date</th>
                <th>Quantity</th>
                
            </tr>
            <%
                Statement st3 = conn.createStatement();
                ResultSet rs3 = st3.executeQuery("SELECT * FROM sale");
                
                while(rs3.next()){
                %>
                <tr>
                    <td><%out.println(rs3.getInt(1));%></td>
                    <td><%out.println(rs3.getInt(2));%></td>
                    <td><%out.println(rs3.getString(3));%></td>
                    <td><%out.println(rs3.getInt(4));%></td>

                </tr>
            <%
                
            }

        %>
        </table>
        
        </td>
        </table>
        
        <table>
         <%-- Table of the manager code starts here--%>
        <td style="padding-left: 0px">
            <td style="padding-top:0px">
        <h2>Table of the manager</h2>
        <table border="1"class="table table-dark">
            <tr>
                <th>manager ID</th>
                <th>sFname</th>
                <th>sLname</th>
                <th>address</th>
                 <th>salary</th>
                  <th>sEmail</th>
                   <th>sPassword</th>
                
            </tr>
            <%
                Statement st4 = conn.createStatement();
                ResultSet rs4 = st4.executeQuery("SELECT * FROM manager");
                
                while(rs4.next()){
                %>
                <tr>
                    <td><%out.println(rs4.getInt(1));%></td>
                    <td><%out.println(rs4.getString(2));%></td>
                    <td><%out.println(rs4.getString(3));%></td>
                    <td><%out.println(rs4.getString(4));%></td>
                    <td><%out.println(rs4.getString(5));%></td>
                    <td><%out.println(rs4.getString(6));%></td>
                    <td><%out.println(rs4.getString(7));%></td>
                </tr>
        
            <%
                
            }
        %>
        
        </td>
        
        
        </tr>
</table>
          <%-- Table of the Cart code starts here--%>
        <td style="padding-left: 400px">
        <h2>Table of the Cart</h2>
        <table border="1"class="table table-dark">
            <tr>
                <th>cart ID</th>
                <th>customer ID</th>
                <th>cart status</th>
                
            </tr>
            <%
                Statement st5 = conn.createStatement();
                ResultSet rs5 = st5.executeQuery("SELECT * FROM cart");
                
                while(rs5.next()){
                %>
                <tr>
                    <td><%out.println(rs5.getInt(1));%></td>
                    <td><%out.println(rs5.getString(2));%></td>
                    <td><%out.println(rs5.getString(3));%></td>

                </tr>
        
            <%
                
            }
        %>
        
        </td>
        
        
        </tr>
</table>
        </table>
        <table>
                   <%-- Table of the production_line_category code starts here--%>
        <td style="padding-left:0%">
            <td style="padding-bottom:50px">
                
        <h2>Table of the production_line_category</h2>
        <table border="1"class="table table-dark">
            <tr>
                <th>line category name</th>
                <th>daily number of shirts</th>
                <th>daily number of shirts</th>
                
            </tr>
            <%
                Statement st6 = conn.createStatement();
                ResultSet rs6 = st6.executeQuery("SELECT * FROM production_line_category");
                
                while(rs6.next()){
                %>
                <tr>
                    <td><%out.println(rs6.getString(1));%></td>
                    <td><%out.println(rs6.getInt(2));%></td>
                    <td><%out.println(rs6.getInt(3));%></td>

                </tr>
        
            <%
                
            }
        %>
        
        </td>
        
        
        </tr>
</table>
        
           <%-- Table of the staff code starts here--%>
           <td style="padding-left:400px">
        <h2>Table of the staff</h2>
        <table border="1"class="table table-dark">
            <tr>
                <th>Staff ID</th>
                <th>sFname</th>
                <th>sLname</th>
                <th>address</th>
                 <th>salary</th>
                  <th>sEmail</th>
                   <th>manager ID</th>
                
            </tr>
            <%
                Statement st7 = conn.createStatement();
                ResultSet rs7 = st7.executeQuery("SELECT * FROM staff");
                
                while(rs7.next()){
                %>
                <tr>
                    <td><%out.println(rs7.getString(1));%></td>
                    <td><%out.println(rs7.getString(2));%></td>
                    <td><%out.println(rs7.getString(3));%></td>
                    <td><%out.println(rs7.getString(4));%></td>
                     <td><%out.println(rs7.getString(5));%></td>
                      <td><%out.println(rs7.getString(6));%></td>
                       <td><%out.println(rs7.getString(7));%></td>

                </tr>
        
            <%
                
            }
        %>
        
        </td>
        
        
        </tr>
</table>
        </table>
        
    </body>
</html>
