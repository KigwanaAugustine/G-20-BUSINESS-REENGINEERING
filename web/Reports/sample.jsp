<%-- 
    Document   : sample
    Created on : Aug 6, 2022, 4:28:45 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*" %>
 <link rel="stylesheet" href="report.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'><link rel="stylesheet" href="style2.css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="report.css"/>
    </head>
   <%!Integer ylabel[]={};%>
   <%!String xlabel[]={};%>
   <% ArrayList<String> labels=new ArrayList<String>(Arrays.asList(xlabel));%>
   <% ArrayList<Integer> label=new ArrayList<Integer>(Arrays.asList(ylabel));%>
   <%@include file="connection.jsp"%>
    <%
        
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from production_line_category");
        while(rs.next()){
           label.add(rs.getInt("dailyNumShirts"));
           labels.add("'"+rs.getString("lineCategoryName")+"'");
        }
      

    %>
    
    
    <body>
        <div class="dashboard">
	
	
	<header class="menu-wrap">
		<figure class="user">
			<div class="user-avatar" width="800px">
				<img src="https://images-workbench.99static.com/MHId5TEtb1cGSa1OhlmxMsaY3uI=/99designs-contests-attachments/77/77756/attachment_77756028" alt="SHIRT-YO" style="width:50px">
			</div>
			<figcaption>
				SHIRT-YO
			</figcaption>
		</figure>
	
		<nav>
			<section class="dicover">
				<h3>SHIRT-YO REPORT</h3>
				
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

        <div class="container">
            <div class="charts">
                
                <div class="inner">
                    <canvas id="pie"></canvas>
                </div>
            </div>
        </div>
        <script src="./chart.min.js"></script>
        <script>
            var pie=document.getElementById("pie").getContext("2d");
            var pieChart=new Chart(pie,{
                 type: 'pie',
                  data: {
        labels: <%out.println(labels);%>,

        datasets: [{
            label: 'Employees',
            data: <% out.println(label);%>,
            backgroundColor: [
                'rgba(41, 155, 99, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(120, 46, 139,1)'

            ],
            borderColor: [
                'rgba(41, 155, 99, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(120, 46, 139,1)'

            ],
            borderWidth: 1
        }]

    },
    options: {
        responsive: true,
        indexAxis: 'y',
        "maintainAspectRatio":false
    
    }
            });
        </script>
       <%
       label.clear();
       labels.clear();
       conn.close();
       %>
    </body>
    
</html>
