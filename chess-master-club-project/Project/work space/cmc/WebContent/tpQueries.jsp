<%@page import="java.util.ArrayList"%>
<%@page import="Dao.QueryDao"%>
<%@page import="java.util.List"%>
<%@page import="database.DataBase"%>
<html>
<head>

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
	             url         : "AddQueryServlet",
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

<script type="text/javascript">

function ajax(serverpage,objID)
{
	XMLHttpRequestObject=new XMLHttpRequest();
	XMLHttpRequestObject.open("GET",serverpage);
	XMLHttpRequestObject.onreadystatechange= function(){
		if (XMLHttpRequestObject.readyState ==4 && XMLHttpRequestObject.status == 200) {
		var obj=document.getElementById(objID);
			obj.innerHTML = XMLHttpRequestObject.responseText;
		}
		
	};
	XMLHttpRequestObject.send(null);
}

function getuser(user,objID)
{

	
	var s="checkEmailID.jsp?user="+user;
	ajax(s,objID);
}


</script>

</head>
<body>

<form id="myForm" action="AddQueryServlet" method="post">
<table >

<tr><td>Subject :</td><td><input type="text" id="sub" name="sub"></td></tr>
<tr><td>Query :</td><td><textarea rows="10" cols="50" name="query"></textarea></td></tr>

<tr><td></td><td><input type="submit" value="Send Query"><br></td></tr>
</table>

</form>

<hr>
<br><br><br><br>
Queries
       <table >

		<%
		    DataBase db=new DataBase();
			
			List<QueryDao> l=new ArrayList<QueryDao>();
			l=db.listQuery();
			for(int i=0;i<l.size();i++)
			{
		
		%>

    
    <tr>
       <td><b>Subject : </b></td><td><%=l.get(i).getqSubject() %></td>
    </tr>
    <tr>
       <td><b>Question : </b></td><td><%=l.get(i).getqQuestion() %></td>
    </tr>
    <tr>
       <td><b>Answer : </b></td><td><%=l.get(i).getqAnswer() %></td>
    </tr>
    <tr></tr>
    <tr></tr>
    <tr><td colspan="2">------------------------------------------------------------------------------------</td></tr>

    
         			

<%
			}
%>
</table>

</body>
</html>