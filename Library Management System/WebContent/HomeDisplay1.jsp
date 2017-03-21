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
<div>
welcome,<%=session.getAttribute("username") %>
<a href="UserLogout">Logout</a>
</div>
<div style="width:200px;float:left;">
<a href="Home">Home</a><br>
<a href="BookHistory">Book History</a>

</div>
<br>
<img src="bks2.png"><br>

<table align="center" cellpadding="4" cellspacing="4">
<tr>

</tr>
<tr >
<td><b>Book Names</b></td>
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
	  //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root" );
	  //Statement st=con.createStatement();
	  //String query="insert into product values("+prod_id+",'"+prod_name+"',"+qty+","+price+")";
	  //String query="insert into one values(2)";
	  //String query="create table one(id int not null)";
	  //int idd=2;
	  //String query="create table registeredusers (name varchar(100) not null,mailid varchar(100) not null,phoneno varchar(10) not null,password varchar(100) not null)";
	  //String query="insert into registeredusers values('"+ vname + "','"+ vemail +"','" + vphone +"','" + vpassword +"')";
	  //String query="select * from regiseteredusers where name='" + vname + "'," + "password='" + vpassword + "'";
	  PreparedStatement st=con.prepareStatement("select * from book where book_aorn=1");
	  //st.setString(1,vname);
	  //st.setString(2,vpassword);
	  ResultSet rs=st.executeQuery();
	while (rs.next()) {
		String pk=rs.getString("book_name");
%>
<tr bgcolor="#8FBC8F">

<td><%=rs.getString("book_name")%></td>

<td><a href="BookDetailsServlet?bname=<%=pk %>">borrow book</a></td>
<!-- bookdetailsx.jsp -->
<!-- 
<td><%=rs.getString("book_name")%></td>
<td><%=rs.getString("book_author")%></td>
<td><%=rs.getString("book_publisher")%></td>
<td><%=rs.getString("book_price")%></td>
<td><%=rs.getString("book_isbn")%></td>
<td><%=rs.getString("book_aorn")%></td>
-->

</tr>

<%


}
	}catch (Exception e) {
e.printStackTrace();
}
	finally{}
%>
</table>
</div>
</body>
</html>