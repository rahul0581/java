<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function validate(){
	var username = document.forms[0].username.value;
	var password = document.forms[0].password.value;
	if(username==""){
		alert("please enter username");
		document.forms[0].username.focus();
		return false;
	}
	if(password==""){
		alert("please enter password");
		document.forms[0].password.focus();
		return false;
	}
	
	
}


</script>
</head>
<body>

<!--  <div style="width:400px; margin-right:auto; margin-left:auto; border:1px solid #000;">-->
<div style=" width:500px;margin:0 auto; border:1px solid #000;" align="center">
LIBRARY MANAGEMENT SOFTWARE<br>
<img src="library.png">
<!-- HomePage.jsp -->

<form action="HomePageServlet" method="post" onsubmit="return validate()">
<table border="1">
<tr>
<td>UserId</td>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td><input type="submit" name="send" value="Send"></td>
</tr>
</table>
</form>	
Dont used brain yet, register now!!!!!!
<a href="Register.jsp">Register......</a><br>
<a href="admin1.jsp">Administrator this way......</a>



</div>
</body>
</html>