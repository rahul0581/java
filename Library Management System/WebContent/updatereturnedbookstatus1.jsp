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
<img src="ba1.png"><br>
<% 
String bname=request.getParameter("bn");
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
  String query="update book set book_aorn=1 where book_name='" + bname +"'";
  
  
  if(st.executeUpdate(query)>0){
   out.write("Book is now available to other users.");
  }else{
   out.write("oops an error occured. try again");
  }
 }catch(Exception e){
  out.write("Exception : "+e);
 }

%>
Return to home:<a href="admin1.jsp">Admin Home</a>
</div>
</body>
</html>