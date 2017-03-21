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
String emm=request.getParameter("eto");

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
 PreparedStatement st=con.prepareStatement("select user_email from user");
 //st.setString(2,vpassword);
 ResultSet rs=null;
 rs=st.executeQuery();

while(rs.next())
{
	String t=rs.getString("user_email");
	if(emm.equals(t))
	{
		response.sendRedirect("sendmail.jsp");
	}
	else
	{
		out.println("user is not registered");
	}
	}

}
catch(Exception e){out.println(e);}





























%>

</body>
</html>