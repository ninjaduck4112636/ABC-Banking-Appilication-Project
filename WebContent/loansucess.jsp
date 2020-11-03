<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>
a:link, a:visited {
  background-color: navy;
  color: white;
  padding: 15px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: gray;
}
</style>

<title>Success</title>
</head>
<body style="background-color: black;">
	<h1 style="color: green; text-align: center; font-family:Courier New; font-size: 600%;"><b>SUCCESSFULLY TRANSFERED AMOUNT <%=session.getAttribute("amount_for_loan") %> FOR THE REASON <%=session.getAttribute("loan_reason") %> THE INTREST RATE IS: 5% P.A</b></h1>
	
	<br>
	<center><a href="index.html">CLICK HERE TO GO HOME</a></center>
	<br><br>
	<center><a href="login.html">CLICK HERE TO LOGIN</a></center>
	<br><br>
	<center><a href="home.jsp">GO BACK TO PROFILE</a></center>
	
	<br><br>
	<footer>
		<marquee style="font-family:Courier New; font-size: 200%; color: blue; background-color: yellow;"><b>This is Created by B B Devaiah aka. ninjaduck ABCFEB20EJPVIJ015</b></marquee>
	</footer>
</body>
</html>