<%--
    Document   : customerReg
    Created on : 9 Aug 2022, 15:15:35
    Author     : Duku Allan
--%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="shoppingpackage.model.*" %>
<%
    CustomerModel auth = (CustomerModel) request.getSession().getAttribute("auth");
    if(auth != null ){
        request.setAttribute("auth", auth);
    }
   %>
<!DOCTYPE html>
<html>
    <head>
        
        <title>JSP Page</title>
        <%@include file="includes/head.jsp"  %>
    </head>
    <body>
        
        <div class="container">
            <div class="card w-50 mx-auto my-5">
                <div class="card-header text -center">Customer Login</div>
                <div class="card-body">
                    <form action="cReg" method="post">
                        <div class ="form-group">
                            <div class ="form-group">
                            <label>First Name</label>
                            <input type="text" class="form-control" name="cFname" placeholder="f name" required>
                        </div>
                        <div class ="form-group">
                            <label>Last Name</label>
                            <input type="text" class="form-control" name="cLname" placeholder="l name" required>
                        </div>
                            <label>Gender</label>
                            <input type="text" class="form-control" name="gender" placeholder="location" required>
                        </div>
                        <div class ="form-group">
                            <label>Location</label>
                            <input type="text" class="form-control" name="location" placeholder="gender" required>
                        </div>
                        <div class ="form-group">
                            <label>Email Address</label>
                            <input type="email" class="form-control" name="cEmail" placeholder="Enter Your Email" required>
                        </div>
                        <div class ="form-group">
                            <label>Password</label>
                            <input type="password" class="form-control" name="cPassword" placeholder="*****" required>
                        </div>
                        <div class ="form-group">
                            <label>Username</label>
                            <input type="text" class="form-control" name="cUserName" placeholder="Enter your username" required>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Register</button>
                        </div> 
                    </form>
                </div>
            </div>
        </div>
         <%@include file="includes/footer.jsp"  %>
    </body>
</html>
