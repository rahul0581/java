<%@page import="Dao.TourDao"%>
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
List of Played games
<table border=1>
<tr>
	<th><p>Tournamment Name</p></th><th><p> Tournamment Date </p></th><th><p>Played with</p></th><th><p>Result</p></th>
</tr>
<%
		    DataBase db=new DataBase();
			List<TourDao> l=new ArrayList<TourDao>();
			l=db.listTournament();
			for(int i=0;i<l.size();i++)
			{
		
		%>
		
<%
			}
%>
</table>
</body>
</html>