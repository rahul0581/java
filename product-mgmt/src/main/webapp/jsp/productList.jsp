<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Products</title>
</head>
<body>
	<h2>PRODUCT LIST</h2>
	<hr />
	<!-- change the homepage.do to dashboard.do -->
	<html:form action="/homepage.do?KEY=PRDMGMT" method="get">
		<a href="productAdd.do">add</a>
		<table>
			<tr>
			<td><b>ID</b></td>
			<td><b>NAME</b></td>
			<td><b>BRAND</b></td>
			<td><b>PRICE</b></td>
			<td><b>RATING</b></td>
			<td> <b>ACTIONS</b></td>
			</tr>
			<logic:iterate id="product" name="productListForm"
			 property="products" type="web.shp.online.model.Product">
			
			<tr>
			
				 <td>${ product.id}</td>
				  <td>${ product.name}</td>
				   <td>${ product.brand}</td>
				    <td>${ product.price}</td>
				     <td>${ product.rating}</td>
				     <td><a href="#">edit</a> &nbsp;|&nbsp;<a href="#">delete</a></td>
			</tr>
			
			</logic:iterate>
		</table>
	</html:form>
</body>
</html>