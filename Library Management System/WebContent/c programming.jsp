<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>C PROGRAMMING BOOK DETAILS</title>
</head>
<body>
<div style=" width:500px;margin:0 auto; border:1px solid #000;" align="center">
<img src="c.png" width="250" height="250" ><BR>
Id:book1<br>
Name: The C Programming Language(ansi c)<br>
Authors:Brian Kernighan, Dennis Ritchie<br>
Publication: PHI<br>
Edition: Second<br>
Price:200 INR<br>
order now:write book id and click on submit button.
<form action="BookOrderServlet">
<input type="text" name="id" value="c programming">
<input type="submit" name="submit" value="order now">
</form>
<% %>
</div>
</body> 
</html>