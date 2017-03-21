<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update returned book status</title>
<script type="text/javascript">
function validate(){
	var bookName = document.forms[0].bookName.value;
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
<img src="rb.png"><br>
Enter bookname:<form action="UpdateReturnedBookServlet" method="post" onsubmit="return validate()">
<!-- updatereturnedbookstatus1.jsp -->
<input type="text" name="bookName">
<input type="submit">
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