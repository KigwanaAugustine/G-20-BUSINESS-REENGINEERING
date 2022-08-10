<%--
    Document   : customerReg
    Created on : 9 Aug 2022, 15:15:35
    Author     : Duku Allan
--%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dukushoppingpackage.model.*" %>

<!DOCTYPE html>
<html>
    <head>
        
        <title>JSP Page</title>
        <%@include file="includes/head.jsp"  %>
    </head>
    <body>
        
        <div class="container">
            <div class="card w-50 mx-auto my-5">
                <div class="card-header text -center">Register Staff</div>
                <div class="card-body">
                    <form action="sReg" method="post">
                        <div class ="form-group">
                            <div class ="form-group">
                            <label>First Name</label>
                            <input type="text" class="form-control" name="sFname" placeholder="f name" required>
                        </div>
                        <div class ="form-group">
                            <label>Last Name</label>
                            <input type="text" class="form-control" name="sLname" placeholder="l name" required>
                        </div>
                            <label>Gender</label>
                            <input type="text" class="form-control" name="gender" placeholder="gender" required>
                        </div>
                        <div class ="form-group">
                            <label>Address</label>
                            <input type="text" class="form-control" name="address" placeholder="Address" required>
                        </div>
                        <div class ="form-group">
                            <label>Salary</label>
                            <input type="number" class="form-control" name="salary" placeholder="Enter staff salary" required>
                        </div>
                        <div class ="form-group">
                            <label>Email</label>
                            <input type="email" class="form-control" name="sEmail" placeholder="Email" required>
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
