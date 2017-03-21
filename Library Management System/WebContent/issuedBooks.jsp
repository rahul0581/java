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
<div style=" width:600px;margin:0 auto; border:1px solid #000;height: 400px" align="center">
<div style="float:right"><a href="AdminLogout">Logout</a></div>
<center>Issued Book Details</center>
<form action="SendMailCheckServlet" method="POST">

<table border="1">
<tr>
<td></td>
<td>borrowerId</td>
<td>BookName</td>
<td>IssuedDate</td>
<td>ReturnDate</td>
<td>Click to Send Mail</td>
</tr>
<%
session.setAttribute("smid","librarymessage123@gmail.com");
session.setAttribute("smpd","librarian123");
//session.setAttribute("smsg","Dear User, your date to return book has passed. please return your book to get least fine. Thanking You, Administrator");
session.setAttribute("ssub","return library book");

%>

<%
List<BookBorrower> borrowers = (List<BookBorrower>)request.getAttribute("borrowers");
List<String> emails = (List<String>)request.getAttribute("emails");
int i = 0;
for(BookBorrower bw : borrowers){
String email = emails.get(i);
String issuedDate = bw.getBook_IssuedDate();
String returnDate = bw.getBook_ReturnedDate();
%>

	<tr>	
<td><input type="hidden" name="returnDate" value="<%=returnDate%>"></td>
<td><%=bw.getBorrower_Id() %></td>
<td><%=bw.getBook_Name() %></td>
<td><%=bw.getBook_IssuedDate() %></td>
<td><%=bw.getBook_ReturnedDate() %></td>
<td>Send Mail<input type="checkbox" name="email" value="<%=email%>"></td>
<!-- <a href="SendMailCheckServlet?email=<%=email%>"> -->
	</tr>
<% 
i++;
}%>
<tr>
<td colspan="5">Send Mails to Book Borrowers</td>
<td><input type="submit" name="submit" value="Send Mails"></td>
</tr>
</table>
</form>
1.<a href="AuthenticationServlet?cnt=1">update returned book status</a><br>
<!-- updatereturnedbookstatus.jsp -->
2.<a href="AuthenticationServlet?cnt=2">check available books</a><br>
<!-- checkavailablebooks.jsp -->
3.<a href="AuthenticationServlet?cnt=3">check registered users</a><br>
<!-- checkregisteredusers.jsp -->
4.<a href="AuthenticationServlet?cnt=4">Issued Books</a><br>
<!-- sendmailtouser.jsp -->
5.<a href="AuthenticationServlet?cnt=5">delete user</a><br>
<!-- deleteusers.jsp -->
6.<a href="AuthenticationServlet?cnt=6">return book</a><br>
<!--returnbook.jsp  -->
7.<a href="AuthenticationServlet?cnt=7">add new book</a><br>
<!-- addnewbook.jsp -->
8.<a href="AuthenticationServlet?cnt=8">delete book</a><br>
<!-- deletebook.jsp -->

</div>
</body>
</html>