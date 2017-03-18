<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Products</title>
</head>
<body>
	<h2>ADD PRODUCT </h2>
	<hr />
	<html:errors/>
	<html:form action="/saveProduct.do" method="get">
		
		<table>
			<tr>
			<td><b>NAME</b></td>
			 <td><html:text property="name" name="productForm"/></td>
			</tr><tr> 
			<td><b>BRAND</b></td>
			 <td><html:text property="brand" name="productForm"/></td>
			</tr><tr>
			<td><b>PRICE</b></td>
			 <td><html:text property="price" name="productForm"/></td>
			</tr><tr>
			<td><b>RATING</b></td>
			 <td><html:select property="rating" name="productForm">
			 <html:option value="1">1</html:option>
			 <html:option value="2">2</html:option>
			 <html:option value="3">3</html:option>
			 <html:option value="4">4</html:option>
			 <html:option value="5">5</html:option>
			 </html:select></td>
			</tr><tr>
			<td ><html:submit value="Save Product"></html:submit></td>
			<td><html:reset value="clear"></html:reset></td>
			</tr>
			
		</table>
	</html:form>
</body>
</html>