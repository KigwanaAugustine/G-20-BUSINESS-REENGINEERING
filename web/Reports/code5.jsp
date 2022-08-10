<%@page import="java.sql.*" %>

<!DOCTYPE html
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Code - Users Dashboard</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'><link rel="stylesheet" href="style2.css">
     
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css"/>

<script type="text/javascript" src=" https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js"></script>

</head>
<body>
<!-- partial:index.partial.html -->
<div class="dashboard">

	
	<header class="menu-wrap">
		<figure class="user">
			<div class="user-avatar" width="1000px">
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
            
%>	
	<td style="padding-left:0%">
            <td style="padding-bottom:50px">
                
        <h2>Table of the production_line_category</h2>
        <table border="1" id="example" class="display table table-dark" style="width:500px">
            <tr>
                <th>line category name</th>
                <th>daily number of shirts</th>
                <th>daily number of shirts</th>
                
            </tr>
            <%
                Statement st6 = conn.createStatement();
                ResultSet rs6 = st6.executeQuery("SELECT * FROM production_line_category");
                
                while(rs6.next()){
                %>
                <tr>
                    <td><%out.println(rs6.getString(1));%></td>
                    <td><%out.println(rs6.getInt(2));%></td>
                    <td><%out.println(rs6.getInt(3));%></td>

                </tr>
        
            <%
                
            }
        %>
        
        </td>
        
        
        </tr>
</table>
<!--        <script>
            $(document).ready(function () {
    $('#example').DataTable();
});
        </script>-->
		</div>
	</main>
</div>
<!-- partial -->
 
</body>
</html>
