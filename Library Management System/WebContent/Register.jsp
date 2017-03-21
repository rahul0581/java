<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" language="javascript">
function validate(){
	
var userId = document.forms[0].userId.value;

var password = document.forms[0].password.value;

var name = document.forms[0].name.value;
var address = document.forms[0].address.value;
var email = document.forms[0].email.value;
var mobileno = document.forms[0].mobileno.value;

if(userId==""){
	alert("Please enter UserID");
	document.forms[0].userId.focus();
	return false;
	
}
if(password==""){
	alert("Please enter password");
	document.forms[0].password.focus();
	return false;
	
}
if(name==""){
	alert("Please enter name");
	document.forms[0].name.focus();
	return false;
	
}
if(address==""){
	alert("Please enter address");
	document.forms[0].address.focus();
	return false;
	
}
if(email==""){
	alert("Please enter UserID");
	document.forms[0].email.focus();
	return false;
	
}
if(mobileno==""){
	alert("Please enter Mobileno");
	document.forms[0].mobileno.focus();
	return false;
	
}

}



</script>
</head>
<body>

<!--  <div style="width:400px; margin-right:auto; margin-left:auto; border:1px solid #000;">-->
<div style=" width:500px;margin:0 auto; border:1px solid #000;" align="center">
USER REGISTRATION PAGE<br>
<img src="rg.png">
<form action="RegisterServlet" method="post" onsubmit="return validate()">
<!-- rredirect.jsp -->
	<fieldset>
	<legend>Registration Details</legend>
<div style="float:right"><a href="LoginForm.jsp">Login</a></div>
<label>*UserName:</label><input type="text" name="userId" maxlength="20"><br>
<label>*PASSWORD:</label><input type="password" maxlength="20" name="password"><br>
<label>*NAME:</label><input type="text" name="name" ><br>
<label>*ADDRESS:</label><input type="text" name="address" ><br>

<label>*EMAIL:</label><input type="text" name="email" ><br>
<label>*MOBILENO:</label><input type="text" maxlength="10" name="mobileno"><br>
<input type="submit" name="submit"><br>
	</fieldset>
</form>
</div>
</body>
</html>