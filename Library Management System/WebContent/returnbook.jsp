<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function validate(){
	var userid = document.forms[0].userid.value;
	var bookName = document.forms[0].bookName.value;
	if(userid==""){
		alert("Please enter userid");
		document.forms[0].userid.focus();
		return false;
	}
	if(bookName==""){
		alert("Please enter bookName");
		document.forms[0].bookName.focus();
		return false;
	}
}
</script>
</head>
<body>
<div style=" width:500px;margin:0 auto; border:1px solid #000;" align="center">
<div style="float:right"><a href="AdminLogout">Logout</a></div>
<form method="post" action="ReturnBookServlet" onsubmit="return validate()">
<img src="br.png">
<br>
Enter user id<input type="text" name="userid"><br>
Enter book name<input type="text" name="bookName"><br>
<input type="submit" name="submit">

</form>
1.<a href="AuthenticationServlet?cnt=1">update returned book status</a><br>
<!-- updatereturnedbookstatus.jsp -->
2.<a href="AuthenticationServlet?cnt=2">check available books</a><br>
<!-- checkavailablebooks.jsp -->
3.<a href="AuthenticationServlet?cnt=3">check registered users</a><br>
<!-- checkregisteredusers.jsp -->
4.<a href="AuthenticationServlet?cnt=4">Issued Books</a><br>
<!-- sendmailtouser.jsp -->
5.<a href="AuthenticationServlet?cnt=5">delete user</a><br>
<!-- deleteusers.jsp -->
6.<a href="AuthenticationServlet?cnt=6">return book</a><br>
<!--returnbook.jsp  -->
7.<a href="AuthenticationServlet?cnt=7">add new book</a><br>
<!-- addnewbook.jsp -->
8.<a href="AuthenticationServlet?cnt=8">delete book</a><br>
<!-- deletebook.jsp -->












</div>
</body>
</html>