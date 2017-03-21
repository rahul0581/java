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
String vname=request.getParameter("name1");
String vpassword=request.getParameter("password1");
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
  PreparedStatement st=con.prepareStatement("select * from user where user_id=? and user_password=?");
  st.setString(1,vname);
  st.setString(2,vpassword);
  ResultSet rs=st.executeQuery();
  if(rs.next())
  {
 // if(st.executeQuery(query)>0){
   out.write("welcome" + vname);
   session.setAttribute("username",vname);
   response.sendRedirect("HomeDisplay1.jsp");
  }else{
   out.write("register first");
   response.sendRedirect("Register.jsp");
  }
 }catch(Exception e){
  out.write("Exception : "+e);
 }
//response.sendRedirect("Loginform.jsp");
%>
</body>
</html>