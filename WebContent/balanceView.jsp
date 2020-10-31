<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>
a:link, a:visited {
  background-color: lime;
  color: white;
  padding: 15px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: purple;
}
</style>

<title>Balance</title>
</head>
<body style="background-color: black;">
	
	<p style="color: orange; text-align: center; font-family:Courier New; font-size: 300%">Your Balance is: <b style="color: yellow;"><%=session.getAttribute("balance") %><b></p>
	
	<br>
	<center><a href="home.jsp">GO BACK TO PROFILE</a></center>
	
	<br><br>
	<footer>
		<marquee style="font-family:Courier New; font-size: 200%; color: blue; background-color: yellow;"><b>This is Created by B B Devaiah aka. ninjaduck ABCFEB20EJPVIJ015</b></marquee>
	</footer>
</body>
</html>