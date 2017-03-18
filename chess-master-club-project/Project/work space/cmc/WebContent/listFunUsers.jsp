<%@page import="Dao.FunPlayerDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="database.DataBase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
       List of Fun Players
       <table border=1>
<tr>
	<th><p>Player No.</p></th><th><p> Player Email ID</p></th><th><p>Address</p></th>
</tr>
		
		<%
		    DataBase db=new DataBase();
			List<FunPlayerDao> l=new ArrayList<FunPlayerDao>();
			l=db.listOfFunPlayers();
			for(int i=0;i<l.size();i++)
			{
		
		%>

         			
<tr>
	<td><p><%=i+1 %></p></td><td><p><%=l.get(i).getEmailid() %></p></td><td><p><%=l.get(i).getAddress() %></p></td>
</tr>
<%
			}
%>
</table>
</body>
</html>