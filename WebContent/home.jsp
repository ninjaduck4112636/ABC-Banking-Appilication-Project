<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>
a:link, a:visited {
  background-color: red;
  color: white;
  padding: 15px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: blue;
}
</style>

<title>Welcome to Home</title>
</head>
<body style="background-color: black;">
	<header>
		<h1 style="color: white; text-align: center; font-family:Courier New; font-size: 600%"><b>WELCOME TO BANK HOME</b></h1>
	</header>
	<center>
		<p style="color: blue; text-align: center; font-family:Courier New; font-size: 300%">Greeting's <%=session.getAttribute("user_name") %></p>
		<!-- <br>
		<p style="color: blue; text-align: center; font-family:Courier New; font-size: 600%"><%=session.getAttribute("account_no") %></p> -->
	</center>
	<br>
	
	<center><a href="CheckBalance">CHECK BALANCE</a></center>
	<br>
	<center><a href="ChangePassword.html">CHANGE PASSWORD</a></center>
	<br>
	<center><a href="transferAmount.jsp">TRANSFER AMOUNT</a></center>
	<br>
	<center><a href="GetMiniStatement">MINI-STATEMENT</a></center>
	<br>
	<center><a href="ApplyForLoan.html">APPLY FOR LOAN</a></center>
	
	
	
	<br><br>
	<footer>
		<marquee style="font-family:Courier New; font-size: 200%; color: blue; background-color: yellow;"><b>This is Created by B B Devaiah aka. ninjaduck ABCFEB20EJPVIJ015</b></marquee>
	</footer>
</body>
</html>