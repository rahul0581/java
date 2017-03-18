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

<!-- Add jQuery library -->
<script type="text/javascript" src="lib/jquery-1.9.0.min.js"></script>

<!-- Add mousewheel plugin (this is optional) -->
<script type="text/javascript" src="lib/jquery.mousewheel-3.0.6.pack.js"></script>

<!-- Add fancyBox main JS and CSS files -->
<script type="text/javascript" src="source/jquery.fancybox.js?v=2.1.4"></script>
<link rel="stylesheet" type="text/css"
	href="source/jquery.fancybox.css?v=2.1.4" media="screen" />

<!-- Add Button helper (this is optional) -->
<link rel="stylesheet" type="text/css"
	href="source/helpers/jquery.fancybox-buttons.css?v=1.0.5" />
<script type="text/javascript"
	src="../source/helpers/jquery.fancybox-buttons.js?v=1.0.5"></script>

<!-- Add Thumbnail helper (this is optional) -->
<link rel="stylesheet" type="text/css"
	href="source/helpers/jquery.fancybox-thumbs.css?v=1.0.7" />
<script type="text/javascript"
	src="source/helpers/jquery.fancybox-thumbs.js?v=1.0.7"></script>

<!-- Add Media helper (this is optional) -->
<script type="text/javascript"
	src="source/helpers/jquery.fancybox-media.js?v=1.0.5"></script>

<script type="text/javascript">
	$(document).ready(function() {

		$('.fancybox').fancybox();

	});
</script>
<style type="text/css">
.fancybox-custom .fancybox-skin {
	box-shadow: 0 0 50px #222;
}
</style>


</head>
<body>
       Authoriziation of Tournamment Players
       <table border=1>
<tr>
	<th><p>Player Name</p></th><th><p> Player Age</p></th><th><p>Player Gender</p></th><th><p>Email ID</p></th>
</tr>
		
		<%
		    DataBase db=new DataBase();
			TournamentDao cdb=new TournamentDao();
			List<TournamentDao> l=new ArrayList<TournamentDao>();
			l=db.listTournamentForApproval("x");
			for(int i=0;i<l.size();i++)
			{
		
		%>

         			
<tr>
	<td><p><%=l.get(i).getName() %></p></td><td><p><%=l.get(i).getAge() %></p></td><td><p><%=l.get(i).getGender() %></p></td><td><p><%=l.get(i).getEmailID() %></p></td><td><a class="fancybox fancybox.ajax" href="admin_approve.jsp?emailid=<%=l.get(i).getEmailID() %>"> Approve</a></td>
</tr>
<%
			}
%>
</table>
</body>
</html>