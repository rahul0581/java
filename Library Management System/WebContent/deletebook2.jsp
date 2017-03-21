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
<div style=" width:500px;margin:0 auto; border:1px solid #000;" align="center">

<%
String bnn=request.getParameter("deleteid");

try
{
	
 Class.forName("com.mysql.jdbc.Driver");
// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root" );
 PreparedStatement st=con.prepareStatement("delete from book where book_name=?");
 st.setString(1,bnn);
 int num=st.executeUpdate();
if(num>=1)
{
	out.println("<img src=delete.png><br>");
	out.println("Book deleted");
}
}
catch(Exception e)
{
	out.println(e);
}
%>
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