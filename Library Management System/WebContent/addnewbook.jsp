<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function validate(){
	var bookName = document.forms[0].bookName.value;
	var author = document.forms[0].author.value;
	var publication = document.forms[0].publication.value;
	var price = document.forms[0].price.value;
	var isbn = document.forms[0].isbn.value;
	var quantity = document.forms[0].bookQuantity.value;
	if(bookName==""){
		alert("Please enter the bookName");
		document.forms[0].bookName.focus();
		return false;
	}
	if(author==""){
		alert("Please enter the author");
		document.forms[0].author.focus();
		return false;
	}
	if(publication==""){
		alert("Please enter the publication");
		document.forms[0].publication.focus();
		return false;
	}
	if(price==""){
		alert("Please enter the price");
		document.forms[0].price.focus();
		return false;
	}
	if(isbn==""){
		alert("Please enter the isbn");
		document.forms[0].isbn.focus();
		return false;
	}
	if(quantity==""){
		alert("Please enter bookQuantity");
		document.forms[0].bookQuantity.focus();
		return false;
	}
}

</script>
</head>
<body>
<div style=" width:500px;margin:0 auto; border:1px solid #000;" align="center">
<div style="float:right"><a href="AdminLogout">Logout</a></div>
<form action="BookInsertServlet" onsubmit="return validate()">
<img src="addbook.png" width="250" height="250" ><BR>
Book Name:<input type="text" name="bookName"><br>
Authors:<input type="text" name="author"><br>
Publication:<input type="text" name="publication"><br>
Price:<input type="text" name="price"><br>
Book isbn:<input type="text" name="isbn"><br>
Book quantity:<input type="text" name="bookQuantity"><br>
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