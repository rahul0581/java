<%@page import="Dao.VideoDao"%>
<%@page import="Dao.QueryDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Dao.TournamentDao"%>
<%@page import="database.DataBase,video.Video"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String keyword =request.getParameter("keyword");
DataBase db=new DataBase();
List<VideoDao> ls=new ArrayList<VideoDao>();
ls=db.searchVideo(keyword);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<table border=1>
   <tr>
      <th>videoId</th>
      <th>videoName</th>
      <th>videoLink</th>
      </tr>
<%   for(int i=0;i<ls.size();i++)
{ 
	%>
	<tr><td><%=ls.get(i).getId() %></td>
	<td><%=ls.get(i).getName()%></td>
	<td><%=ls.get(i).getLink() %></td>
	</tr>
	<%
}
	%>
	
</table>      
</body>
</html>
