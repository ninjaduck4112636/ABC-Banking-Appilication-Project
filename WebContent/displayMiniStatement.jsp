<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mini-Statement</title>
</head>
<body style="background-color: black;">
	<header>
	<%String un = (String)session.getAttribute("user_name"); %>
		<h1 style="color: white; text-align: center; font-family:Courier New; font-size: 600%"><b><%=un %> YOUR MINI-STATEMENT</b></h1>
	</header>
	
	<%ResultSet res = (ResultSet)session.getAttribute("resultSet_of_Details_mini_statement"); %>
	<center>
		<%while(res.next()){%>
		<table border="1px">
		
			<thead><tr><td style="color: white;">SENDER ACCOUNT NO.</td><td style="color: white;">RECIVER ACCOUNT NO.</td><td style="color: white;">AMOUNT TRANSFERED</td></tr></thead>
			<tbody><tr><td style="color: white;"><%=res.getString("ACCOUNT_NO") %></td><td style="color: white;"><%=res.getString("RECIVER_ACCOUNT_NO") %></td><td style="color: white;"><%=res.getString("BALANCE") %></td></tr></tbody>
		
		</table>
	<%}%>
	</center>
	
	<br><br>
	<footer>
		<marquee style="font-family:Courier New; font-size: 200%; color: blue; background-color: yellow;"><b>This is Created by B B Devaiah aka. ninjaduck ABCFEB20EJPVIJ015</b></marquee>
	</footer>
</body>
</html>