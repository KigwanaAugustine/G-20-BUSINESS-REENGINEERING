<%-- 
    Document   : orders
    Created on : 5 Aug 2022, 09:35:18
    Author     : Duku Allan
--%>

<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DukuShoppingPackage.model.*" %>
<%
    session = request.getSession();
    int customerID = 0;
    
    if(session.getAttribute("customerID") == null)
     response.sendRedirect("login.jsp");
    else
      customerID = (int)session.getAttribute("customerID");
    
    String username = (String) session.getAttribute("username");
    
        ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
        if(cart_list != null){
            request.setAttribute("cart_list", cart_list);
        }
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/head.jsp"  %>
        <title>your orders</title>
    </head>
    <body>
        <%@include file="includes/navbar.jsp"  %>
        
        
        
        <%@include file="includes/footer.jsp"  %>
    </body>
</html>
