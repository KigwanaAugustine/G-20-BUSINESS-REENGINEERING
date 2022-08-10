<%-- 
    Document   : index
    Created on : Jul 25, 2022, 9:09:30 AM
    Author     : Tanuki
--%>



<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import= "com.August.entities.Staff"%>
<%@page import= "com.August.entities.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "errors.jsp"%>
<%@taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        
        
        
        <%   
            //ArrayList<Customer> customers = new ArrayList<>();
            //customers = (ArrayList<Customer>) session.getAttribute("customers");
            //out.print(customers.get(1).toString());
        %>
        
        <form action="reallocateBySales" >
            
            <input type ="text"  name="startDate"> <br><br>
            
<!--            <input type ="text"  name="price"> <br><br>-->
           
       <!--     <input type="text"  name="dailyNumStaff"> <br><br>
           
            <input type="text"  name="address"> <br><br>
            
            <input type="text"  name="salary"> <br><br>
            
            <input type="text"  name="sEmail"> <br><br>
           
            <input type="text"  name="managerID"> <br><br>--> 
            
            
            <input type ="submit" value="submit" >
       </form>
        
        <% // String username = (String) session.getAttribute("username");
//            out.print(username);
        %>

        <%--
        //JSTL FUNCTION TAGS
        
        <c:set var="str" value="Kigwana is the real king." />
        
        Length : ${fn:length(str)}
        
        <c:forEach items = "{fn:split(str, ' ')}" var="s">
            <br>
            ${s}
        </c:forEach>  --%>
        
        
        <%--
        JSTL TAGS DB CONNECTION
        <sql:setDataSource var="db" driver="org.gjt.mm.mysql.Driver" url="jbdc:mysql://localhost:3306/test" user="root" password="@Tanuki12broz"/>
        
        <sql:query dataSource="${db}" var="rs" > 
            SELECT * from employees; 
        </sql:query>
        
        <c:forEach var="employee" items="${rs.rows }">
        ${employee.Name}
        </c:forEach>   --%>
                   
       
    </body>
</html>
