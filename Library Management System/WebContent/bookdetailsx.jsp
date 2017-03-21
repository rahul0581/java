<%@page import="miniproject.beans.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div style=" width:600px;margin:0 auto; border:1px solid #000;" align="center">
<div style="float:right"><a href="UserLogout">Logout</a></div>
<div style="width:200px;float:left;">
<a href="Home">Home</a><br>
<a href="BookHistory">Book History</a>

</div>
<form action="BookOrderServlet" method="POST">
<img src="ba1.png"><br>

<table align="center" cellpadding="4" cellspacing="4">
<tr>

</tr>
<tr>
<td><b>Book Name</b></td>
<td><b>Author</b></td>
<td><b>Publisher</b></td>
<td><b>Book price</b></td>
<td><b>Book isbn</b></td>
<td><b>Book available or not</b></td>
<td><b>Book quantity</b></td>
</tr>
<%

	try{
		 ArrayList<Book> al = (ArrayList<Book>)request.getAttribute("bookDetails"); 
	  for(Book book : al){
%>
<tr bgcolor="#8FBC8F">

<td><%=book.getBookName() %></td>
<td><%=book.getAuthor()%></td>
<td><%=book.getPublication()%></td>
<td><%=book.getPrice()%></td>
<td><%=book.getIsbn()%></td>
<td><%=1%></td>
<td><%=book.getBookQuantity()%></td>
</tr>

<%

}
	}catch (Exception e) {
e.printStackTrace();
}
	finally{}
%>
</table>
<input type="submit" value="go ahead">
</form>
</div>
</body>
</html>