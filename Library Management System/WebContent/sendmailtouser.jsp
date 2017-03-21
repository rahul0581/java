<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Send Email using JSP</title>
<script type="text/javascript">
function validate(){
	var email = document.forms[0].email.value;
	if(email==""){
		alert("please enter email id");
		document.forms[0].email.focus();
		return false;
	}
}

</script>
</head>
<body>
<div style="width:600px;height:600px;margin:0 auto; border:1px solid #000;" align="center">
<div style="float:right"><a href="AdminLogout">Logout</a></div>
<form method="post" action="SendMailCheckServlet" onsubmit="return validate()">
<!-- sendmailcheck.jsp -->
<%
session.setAttribute("smid","jspminiproject@gmail.com");
session.setAttribute("smpd","jsp1234@");
session.setAttribute("smsg","Dear User, your date to return book has passed. please return your book to get least fine. Thanking You, Administrator");
session.setAttribute("ssub","return library book");

%>
<img src="em.png">
<br>
Receiver Mail Id:<input type="text" name="email">
<!-- 
sender mail id:<input type="text" name="efrom"><br>
sender password:<input type="password" name="epassword"><br>
subject:<input type="text" name="subject1"><br>
message:<input type="text" name="message1" ><br>
<input type="submit" name="submit">
 -->
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