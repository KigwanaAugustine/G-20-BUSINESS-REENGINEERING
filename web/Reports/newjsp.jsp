<%-- 
    Document   : newjsp
    Created on : Aug 5, 2022, 6:02:02 AM
    Author     : ERISA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*" %>
<%!Integer y[]={};%>
<%!String x[]={};%>
<%ArrayList<Integer> ylabel=new ArrayList<Integer>(Arrays.asList(y));%>
<%ArrayList<String> xlabel=new ArrayList<String>(Arrays.asList(x));%>
<%!ResultSet res;%>

<%@include file="connection.jsp"%>

<%!Integer pay[]={};%>
<%!String name[]={};%>
<%ArrayList<Integer> paylabel=new ArrayList<Integer>(Arrays.asList(pay));%>
<%ArrayList<String> namelabel=new ArrayList<String>(Arrays.asList(name));%>
<%!ResultSet rest;%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/grid.css"/>
    </head>
    <body>
             <div class="dashboard">
	
	
	<header class="menu-wrap">
		<figure class="user">
			<div class="user-avatar">
				<img src="https://images-workbench.99static.com/MHId5TEtb1cGSa1OhlmxMsaY3uI=/99designs-contests-attachments/77/77756/attachment_77756028" alt="SHIRT-YO" style="width:50px">
			</div>
			<figcaption>
				SHIRT-YO
			</figcaption>
		</figure>
	
		<nav>
			<section class="dicover">
				<h3>Shirt-yo REPORT</h3>
				
				<ul>
                                    <li>
                                        <a href="code2.jsp">
					Customer table
						</a>
					</li>
					
					<li>
						<a href="code3.jsp">
							Sales table
						</a>
					</li>
					
					<li>
						<a href="code5.jsp">
							production_line_category
						</a>
					</li>
					
					<li>
						<a href="code4.jsp">
							customer_like
						</a>
					</li>
                                        <li>
						<a href="sample.jsp">
							Pie Chart
						</a>
					</li>
                                        <li>
						<a href="newjsp.jsp">
							Bar Graph
						</a>
					</li>
                                        
				</ul>
			</section>
		
		</nav>
	</header>
        
               <%
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    
                    Statement st = conn.createStatement();
                    
                    //BAR CHART
                    res=st.executeQuery("select * from customer");
                    while(res.next()){
                        xlabel.add("'"+res.getString("cFname")+"'");
                       
                    }
                    
                    
                    //out.println(ylabel);
                    //PIE CHART
                    rest=st.executeQuery("select * from sale");
                    while(rest.next()){
                        paylabel.add(rest.getInt("quantity"));
                    }
                   
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch(ClassNotFoundException e) {
                e.printStackTrace();
            }
        %>
        <div
        <div class="main">
        <div class="charts">
           
            <div class="chart">
                <div>
            <canvas id="line"></canvas>
                </div>
            </div>
          
            <div class="chart">
                <div>
            <canvas id="r2"></canvas>
                </div>
            </div>
        </div>
        </div>
        <script src="./chart.min.js"></script>
        <script>
    
var ctx = document.getElementById("line").getContext("2d");
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: <%out.println(xlabel);%>,
        datasets: [{
            label: 'Like',
            data: <%out.println(paylabel);%>,
            backgroundColor: [
                'rgba(234,255,260)'

            ],
            borderColor: 'rgb(41, 155, 99)',
            borderWidth: 1
        }
        
    ]
    },
    options: {
        responsive: true,
        scales:{
        y:{
            title:{
                display:true,
                text:"Quantity"
                
            }
        }
       
        },
        "maintainAspectRatio": false
        
    }
});


        </script>
    </body>
</html>
