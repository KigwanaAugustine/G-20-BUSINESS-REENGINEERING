<%-- 
    Document   : orders
    Created on : 5 Aug 2022, 09:35:18
    Author     : Duku Allan
--%>

<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="shoppingpackage.model.*" %>
<%
    CustomerModel auth = (CustomerModel) request.getSession().getAttribute("auth");
    if(auth != null ){
         request.setAttribute("auth", auth);
//        response.sendRedirect("index.jsp");
    }
    
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
