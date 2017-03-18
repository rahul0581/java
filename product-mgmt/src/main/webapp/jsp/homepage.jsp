<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>PRODUCT MANAGEMENT</h2>
	<hr />
	<!-- change the homepage.do to dashboard.do -->
	<html:form action="/productList.do" method="get">
	<input type="hidden" id="key" name="KEY" value="PRDMGMT">
		<bean:write name="homepageForm" property="message" />
		<br />
		<br />
		<html:submit value="Dashboard"></html:submit>
	</html:form>
</body>
</html>