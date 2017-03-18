<%@page import="java.util.ArrayList"%>
<%@page import="Dao.TourDao"%>
<%@page import="java.util.List"%>
<%@page import="database.DataBase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String tid=request.getParameter("tid");
    System.out.println(tid);
    session.setAttribute("tid", tid);
    DataBase db=new DataBase();
    List<TourDao> l=new ArrayList<TourDao>(); 
    l=db.getResultTournamentID(tid);
  if(l==null)
  {
	  out.println("no record avilable");
  }
  else
  {
    %>
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

		 $("#myForm").submit(function() {
	         $.fancybox.showLoading(); // start fancybox loading animation
	         $.ajax({
	             type        : "POST",
	             cache       : false,
	             url         : "TournamentAddServlet",
	             data        : $(this).serializeArray(),
	             success: function(data) {
	                 $.fancybox(data);
	             }
	         });
	         $.fancybox({
	        	 'onClosed': function() {
		        	    parent.location.reload(true);
		        	  }
	         });
	         
	         

	         return false; // stop default submit event propagation
	     }); 
		

	});
</script>
<style type="text/css">
.fancybox-custom .fancybox-skin {
	box-shadow: 0 0 50px #222;
}
</style>
</head>
<body>
<form id="myForm" action="TournamentAddServlet" method="post">
<table >
<tr><td><div id="error"></div></td> </tr>
<tr><td>Tournament ID :</td><td><input type="text" id="tid" name="tid" value="<%=l.get(0).getTid()%>"></td></tr>
<tr><td>Tournament Name :</td><td><input type="text" name="tname"  value="<%=l.get(0).getTname()%>"></td></tr>
<tr><td>Tournament Date :</td><td><input type="text" id="datepicker" name="date" value="<%=l.get(0).getDate()%>" /></td></tr>

<tr><td>Tournament Venu :</td><td><input type="text" name="venu"  value="<%=l.get(0).getVenu()%>"></td></tr>

<tr><td></td><td><input type="submit" value="Update Tournament"><br></td></tr>
</table>

</form>


</body>
</html>

<%
}
%>