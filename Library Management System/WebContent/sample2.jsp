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
try
{
	String recordToDelete = request.getParameter("deleteid");
 Class.forName("com.mysql.jdbc.Driver");
 //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root" );
 PreparedStatement st=con.prepareStatement("delete from sample where name=?");
 st.setString(1,recordToDelete); 
 
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


     response.sendRedirect("sample1.jsp"); // redirect to JSP one, which will again reload.
%>

</body>
</html>