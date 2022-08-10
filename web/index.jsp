<%--
    Document   : index
    Created on : 5 Aug 2022, 09:34:07
    Author     : Duku Allan
--%>

<%@page import="java.lang.Integer"%>
<%@page import="java.util.*"%>
<%@page import="DukuShoppingPackage.dao.ShirtDao"%>
<%@page import="DukuShoppingPackage.connection.DbCon"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="DukuShoppingPackage.model.*" %>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<%
    session = request.getSession();
    int customerID = 0;
    
    if(session.getAttribute("customerID") != null)
      customerID = (int)session.getAttribute("customerID");
    
    String username = (String) session.getAttribute("username");
    
    //preventing reloggin in with backbutton
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
    
    ShirtDao sh = new ShirtDao();
    List<Shirt> shirts = sh.getAllShirts();
    
    //order-now?quantity=1&id=<%=s.getShirtID()
    
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
        if(cart_list != null){
            request.setAttribute("cart_list", cart_list);
        }
//<%= s.getImage();
%>

<!DOCTYPE html>
<html>
    <head>
        <title>home</title>
        <%@include file="includes/head.jsp"  %>
    </head>
    <body>
        <%@include file="includes/navbar.jsp"  %>
                
        <div class="container">
               <div class="card-header my-3">All Products</div>
                    <div class="row">
                     <%
                            PrintWriter out1 = response.getWriter();
                            if( !shirts.isEmpty()){
                                for(Shirt s:shirts){%>
                                <div class="col-md-3 my-3">
                                   <div class="card w-100" style="width: 18rem;">
                                        <img class="card-img-top" src="product-images/<%= s.getImage()%>" alt="Card image cap">
                                         <div class="card-body">
                                                <h5 class="card-title"><%= s.getDescription() %></h5>
                                                <h6 class="price">Price: $<%= s.getPrice() %></h6>
                                                <h6 class="category">Category: <%= s.getShirtCategoryName() %></h6>
                                                <div class="mt-3 d-flex justify-content-between">
                                                    <a href="add-to-cart?shirtID=<%= s.getShirtID() %>" class="btn btn-dark">Add to Cart</a>
                                                    <a href="regLike?shirtID=<%= s.getShirtID() %>" class="btn btn-primary">Like</a>
                                                    
                                                    
                                             </div>
                                        </div>
                                    </div>
                             </div> 
                                    
                             <%   }
                            }
                        %>
                        
                </div>           
        </div>
    
        <%@include file="includes/footer.jsp"  %>
    </body>
</html>
