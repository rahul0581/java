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
String bn1=request.getParameter("bn");
String author1=request.getParameter("author");
String pb1=request.getParameter("pb");
Double bp1,isbn1;
int quant;
try
{
	bp1=Double.parseDouble(request.getParameter("bp"));
	isbn1=Double.parseDouble(request.getParameter("isbn"));
	quant=Integer.parseInt(request.getParameter("bq"));
}
catch(Exception e)
{
	out.println("Fill all details");
	return;
}
if(bn1.isEmpty() || author1.isEmpty() || pb1.isEmpty() || bp1==0.0 || isbn1==0.0 || quant==0)
{
	out.println("please fill every field mark with *");
	return;
	//response.sendRedirect("Register.jsp");
}

try{
	 Class.forName("com.mysql.jdbc.Driver");
 // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root" );
  Statement st=con.createStatement();
  //String query="insert into product values("+prod_id+",'"+prod_name+"',"+qty+","+price+")";
  //String query="insert into one values(2)";
  //String query="create table one(id int not null)";
  int idd=2;
  //String query="create table registeredusers (name varchar(100) not null,mailid varchar(100) not null,phoneno varchar(10) not null,password varchar(100) not null)";
  String query="insert into book values('"+ bn1 + "','"+ author1 +"','" + pb1 +"'," + bp1 +"," + isbn1 + "," + 1 + "," + quant + ")";
  
  
  if(st.executeUpdate(query)>0){
	  %><br>Book added.
	  <%
  
  }else{
	  %>
	  <br>Cannot add book.
	  <%
  }
 }catch(Exception e){
  out.write("Exception : "+e);
 }
//response.sendRedirect("LoginForm.jsp");
%>




</body>
</html>