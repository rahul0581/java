<%@page import="miniproject.beans.BookBorrower"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="width:600;height:auto;border:1 solid green;color:1">


<div style="width:800;height:auto;border:1;color:1;float:left"></div>
<div align="center">
<a href="UserLogout">Logout</a>
</div>
<div align="center">
<a href="Home">Home</a><br>
<a href="BookHistory">Book History</a>

</div>
<table align="center" border="1">
<tr>
<td>BorrowerId</td>
<td>BookName</td>
<td>IssuedDate</td>
<td>ReturnDate</td>
<td>BookStatus</td>
</tr>
<%
List<BookBorrower> l = (List<BookBorrower>)request.getAttribute("bookHistory");
for(BookBorrower bw: l){%>
	<tr>
	<td><%=bw.getBorrower_Id() %></td>
	<td><%=bw.getBook_Name() %></td>
	<td><%=bw.getBook_IssuedDate() %></td>
	<td><%=bw.getBook_ReturnedDate() %></td>
	<td><%=bw.getStatus() %></td>
	</tr>
<% }%>



</table>
</div >
</body>
</html>