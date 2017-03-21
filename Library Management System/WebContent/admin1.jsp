<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrator login</title>
<script type="text/javascript">
function validate(){
	var id = document.forms[0].id.value;
	var pwd = document.forms[0].password.value;
	if(id==""){
		alert("Please enter Id");
		document.forms[0].id.focus();
		return false;
	}
	if(pwd==""){
		alert("Please enter Password");
		document.forms[0].password.focus();
		return false;
	}
}
</script>
</head>
<body>
<div style=" width:600px;height:500px;margin:0 auto; border:1px solid #000;" align="center">
<form action="AdminServlet" method="POST" onsubmit="return validate()">
ADMINISTRATOR AUTHENTICATION<br>
<img src="add.png"><br>
Name/id:<input type="text" name="id"><br>
Password:<input type="password" name="password"><br>
<input type="submit" name="submit">
</form>
</div>


</body>
</html>