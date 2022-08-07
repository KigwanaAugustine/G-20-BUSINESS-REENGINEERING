<%-- 
    Document   : welcome
    Created on : Aug 5, 2022, 8:32:36 AM
    Author     : Tanuki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WELCOME Page</title>
    </head>
    <body>
        
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
            if(session.getAttribute("username") == null)
            {
                response.sendRedirect("login.jsp");
            }
        %>
        
        <h1>Welcome</h1> <br>
        
        
        <<form action="logout">
            <input type="submit" value="logout">
        </form>
    </body>
</html>
