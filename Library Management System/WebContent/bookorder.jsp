<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Borrowing Book</title>
</head>
<body>







<!--  <div style="width:400px; margin-right:auto; margin-left:auto; border:1px solid #000;">-->
<div style=" width:500px;margin:0 auto; border:1px solid #000;" align="center">
<div style="float:right"><a href="UserLogout">Logout</a></div>
<div style="width:200px;float:left;">
<a href="Home">Home</a><br>
<a href="BookHistory">Book History</a>

</div>
Order Details Page<br>
<img src="bb.png"><br>

<form method="post" action="ConfirmBookOrderServlet" >
	<fieldset>
	<legend>Borrowed Book Details</legend>

<label>*borrower id:</label><%=session.getAttribute("username") %><br>
<label>*book name:</label><%=session.getAttribute("bookName") %><br>
<label>*book issued date:</label>
<%out.print((String)session.getAttribute("issuedDate"));
//String ss="" + dNow;
//session.setAttribute("b",xx);


//session.setAttribute("bnamen",request.getParameter("bnname"));

%>


<br>
<label>*book returned date:</label><%out.print((String)session.getAttribute("returnDate"));%>
<br><label>*fine:</label>2 R/Day<br>
<input type="submit" name="submit"><br>
	</fieldset>
	

	
</form>
</div>
</body>
</html>