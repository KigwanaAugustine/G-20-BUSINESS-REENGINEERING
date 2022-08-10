<%-- 
    Document   : login
    Created on : 5 Aug 2022, 09:34:38
    Author     : Duku Allan
--%>
<%@page import="com.August.entities.Customer"%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@page import="shoppingpackage.model.*" %>--%>
<%
    
    session = request.getSession();
    int customerID = 0;
    
    if(session.getAttribute("customerID") != null)
      customerID = (int)session.getAttribute("customerID");
   
    
//        ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
//        if(cart_list != null){
//            request.setAttribute("cart_list", cart_list);
//        }
%>

<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/navbar.jsp"  %>
        <%@include file="includes/head.jsp"  %>
        <title>login</title>
    </head>
    <body>
        <div class="container">
            <div class="card w-50 mx-auto my-5">
                <div class="card-header text -center">Customer Login</div>
                <div class="card-body">
                    <form action="login" method="post">
                        <div class ="form-group">
                            <label>Username</label>
                            <input type="text" class="form-control" name="username" placeholder="Enter Your Username" required>
                        </div>
                        <div class ="form-group">
                            <label>Password</label>
                            <input type="password" class="form-control" name="password" placeholder="*****" required>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Login</button>
                        </div> 
                        <div class="text-center"><br>
                            <a class="" href="customerReg.jsp">Sign Up if new?</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
        <%@include file="includes/footer.jsp"  %>
    </body>
</html>
