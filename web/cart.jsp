<%-- 
    Document   : cart
    Created on : 5 Aug 2022, 09:35:01
    Author     : Duku Allan
--%>
<%@page import="java.util.*" %>
<%@page import="java.text.*" %>
<%@page import="shoppingpackage.connection.DbCon" %>
<%@page import="shoppingpackage.dao.ShirtDao" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="shoppingpackage.model.*" %>
<%@page errorPage = "errors.jsp"%>
<%
    //Preventing loging back in with the back button
       response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
    
    DecimalFormat dcf = new DecimalFormat("#.##");
    request.setAttribute("dcf", dcf);
    CustomerModel auth = (CustomerModel) request.getSession().getAttribute("auth");
    if(auth != null ){
        request.setAttribute("auth", auth);
//        response.sendRedirect("index.jsp");
    }
    
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartShirt = null;
    if(cart_list != null){
        DbCon db = new DbCon();
        ShirtDao sh = new ShirtDao();
        cartShirt = sh.getCartShirts(cart_list);
        request.setAttribute("cart_list", cart_list);
        //the total price 
        double total = sh.getTotalCartPrice(cart_list);
        request.setAttribute("total", total);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/head.jsp"  %>
        <style>
            .table tbody td {
                vertical-align: middle;
            }
            .btn-incre, .btn-decre{
                box-shadow: none;
                font-size: 25px;
            }
        </style>  
        <title>shopping cart</title>
    </head>
    <body>
        <%@include file="includes/navbar.jsp"  %>
        
        <div class="container">
            <div class="d-flex py-3 "><h3>Total Price: $ ${ (total>0)?dcf.format(total):0 }</h3>
                <a class="mx-3 btn btn-primary" href="check-out">Check Out</a>
            </div>
            <table class="table table-loght">
              <thead>
                    <tr>
                        <th scope="col">Description</th>
                        <th scope="col">Category</th>
                        <th scope="col">Price</th>
                        <th scope="col">Buy Now</th>
                        <th scope="col">Cancel</th>
                       </tr>
                </thead>
                <tbody>
                    <%
                        if(cart_list != null){
                            for(Cart c1:cartShirt){ %>
                               <tr>
                                   <td><%=c1.getDescription() %></td>
                                    <td><%=c1.getShirtCategoryName() %></td>
                                    <td>$<%=dcf.format(c1.getPrice())%></td>
                                    <td>
                                            <form action="order-now" method="post" class="form-inline">
                                                <input type="hidden" name="id" value="<%= c1.getShirtID() %>" class="form-input">
                                                <div class="form-group d-flex justify-content-between w-50">
                                                    <a class="btn btn-sm btn-decre" href="quantity-change?action=dec&id=<%= c1.getShirtID()%>"><i class="fas fa-minus-square"></i></a>
                                                    <input type="text" name="quantity" class="form-control w-50" value="<%= c1.getQuantity() %>" readonly="">                                   
                                                    <a class="btn btn-sm btn-incre" href="quantity-change?action=inc&id=<%= c1.getShirtID()%>"><i class="fas fa-plus-square"></i></a>
                                                </div>
                                                <button type="submit" class="btn btn-primary btn-sm">Buy</button>
                                            </form>
                                    </td> 
                                    <td><a class="btn btn-sm btn-danger" href="remove-from-cart?id=<%= c1.getShirtID()%>">Remove</a></td>
                              </tr> 
                              <%  }
                        }
                    %>
                    </tbody> 
                    
                
            </table>
        </div>
        
        <%@include file="includes/footer.jsp"  %>
    </body>
</html>
