<%-- 
    Document   : errors.jsp
    Created on : Jul 25, 2022, 3:48:46 PM
    Author     : Tanuki
--%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage = "true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR PAGE</title>
    </head>
    <body bgcolor = "red">
        <h3>ERROR</h3> <br>
        
        <h2> <%= exception.getMessage() %></h2>
       
      
    </body>
</html>
