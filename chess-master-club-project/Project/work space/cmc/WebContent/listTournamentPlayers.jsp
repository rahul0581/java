<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Dao.TournamentDao"%>
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
       List of Tournamment Players
       <table border=1>
<tr>
	<th><p>Player Name</p></th><th><p> Player Age</p></th><th><p>Player Gender</p></th><th><p>Email ID</p></th>
</tr>
		
		<%
		    DataBase db=new DataBase();
			TournamentDao cdb=new TournamentDao();
			List<TournamentDao> l=new ArrayList<TournamentDao>();
			l=db.listTournamentForApproval("Approved");
			for(int i=0;i<l.size();i++)
			{
		
		%>

         			
<tr>
	<td><p><%=l.get(i).getName() %></p></td><td><p><%=l.get(i).getAge() %></p></td><td><p><%=l.get(i).getGender() %></p></td><td><p><%=l.get(i).getEmailID() %></p></td>
</tr>
<%
			}
%>
</table>
</body>
</html>