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
<div style="float:right"><a href="AdminLogout">Logout</a></div>
<img src="delete.png"><br>
<table align="center" cellpadding="4" cellspacing="4">
<tr>

</tr>
<tr>
<td><b>Availabe Book Names</b></td>
<!--  <td><b>Id</b></td>

<td><b>Address</b></td>
<td><b>Destination </b></td>
<td><b>Salary</b></td>
<td><b>DateOfJoin</b></td>
<td><b>availabe or not</b></td>-->
</tr>
<%
	try{
		 Class.forName("com.mysql.jdbc.Driver");
	 // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root" );
	  //Statement st=con.createStatement();
	  //String query="insert into product values("+prod_id+",'"+prod_name+"',"+qty+","+price+")";
	  //String query="insert into one values(2)";
	  //String query="create table one(id int not null)";
	  //int idd=2;
	  //String query="create table registeredusers (name varchar(100) not null,mailid varchar(100) not null,phoneno varchar(10) not null,password varchar(100) not null)";
	  //String query="insert into registeredusers values('"+ vname + "','"+ vemail +"','" + vphone +"','" + vpassword +"')";
	  //String query="select * from regiseteredusers where name='" + vname + "'," + "password='" + vpassword + "'";
	  PreparedStatement st=con.prepareStatement("select * from book");
	  //st.setString(1,vname);
	  //st.setString(2,vpassword);
	  ResultSet rs=st.executeQuery();
	while (rs.next()) {
		String pk=rs.getString("book_name");
%>
<tr bgcolor="#8FBC8F">

<td><%=rs.getString("book_name") %></td>
<td><a href="DeleteBookServlet?deleteid=<%=pk %>">delete</a></td>
</tr>

<%

}
	}catch (Exception e) {
e.printStackTrace();
}
	finally{}
%>
</table>
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