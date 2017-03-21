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

<%
String vid=request.getParameter("id1");
String vname=request.getParameter("name1");
String vaddress=request.getParameter("address1");
String vpassword=request.getParameter("password1");
String vemail=request.getParameter("email1");
Double vphone=0.0;
try
{
vphone=Double.parseDouble(request.getParameter("phone1"));
}
catch(Exception e)
{
	out.println("PHONE NUMBER CANNOT BE EMPTY");
	return;
}
if(vid.isEmpty() || vname.isEmpty() || vaddress.isEmpty() || vpassword.isEmpty() || vemail.isEmpty() || vphone==0.0)
{
	out.println("please fill every field mark with *");
	return;
	//response.sendRedirect("Register.jsp");
}

try{
	 Class.forName("com.mysql.jdbc.Driver");
  //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root" );
  Statement st=con.createStatement();
  //String query="insert into product values("+prod_id+",'"+prod_name+"',"+qty+","+price+")";
  //String query="insert into one values(2)";
  //String query="create table one(id int not null)";
  int idd=2;
  //String query="create table registeredusers (name varchar(100) not null,mailid varchar(100) not null,phoneno varchar(10) not null,password varchar(100) not null)";
  String query="insert into user values('"+ vid + "','"+ vname +"','" + vaddress +"','" + vpassword +"','" + vemail + "'," + vphone + ")";
  
  
  if(st.executeUpdate(query)>0){
	  %><img src="rs.png"><br>Registration Successful.
	  <%
  
  }else{
	  %>
	  <img src="x.png"><br>Registration Not Successful.
	  <%
  }
 }catch(Exception e){
  out.write("Exception : "+e);
 }
response.sendRedirect("LoginForm.jsp");
%>




</body>
</html>