<%@page import="java.sql.*" %>

<!DOCTYPE html
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Code - Users Dashboard</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'><link rel="stylesheet" href="style2.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<!-- partial:index.partial.html -->
<div class="dashboard">
	
	
	<header class="menu-wrap">
		<figure class="user">
			<div class="user-avatar" width="800px">
				<img src="https://images-workbench.99static.com/MHId5TEtb1cGSa1OhlmxMsaY3uI=/99designs-contests-attachments/77/77756/attachment_77756028" alt="SHIRT-YO"style="width:50px">
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
	
	<main class="content-wrap">
		
		<div class="content">
		<%
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shirt-yo", "root","");
            
                Statement st9 = conn.createStatement();
                ResultSet rs9 = st9.executeQuery("SELECT * FROM customer_like");
%>	<h2>The customer_like table</h2>
	 <table border="1"class="table table-dark" style="width:500px">
            <tr>
                <th>like Id</th>
                <th>shirt Id</th>
                <th>customer ID</th>
               
            </tr>
            <%
                while(rs9.next()){
                %>
                <tr>
                    <td><%out.println(rs9.getString(1));%></td>
                    <td><%out.println(rs9.getString(2));%></td>
                    <td><%out.println(rs9.getString(3));%></td>
                    
                </tr>
            <%
                
            }
        %>
        </table>	
			
		</div>
	</main>
</div>
<!-- partial -->
  
</body>
</html>
