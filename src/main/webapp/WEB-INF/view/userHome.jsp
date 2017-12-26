<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home - Contacts Application</title>
<s:url var="url_css" value="static/css/style.css"/>
<link href="${url_css}" rel="stylesheet" type="text/css"/>
</head>
<s:url var="url_indexbg" value="/static/images/indexbg.jpg"/>
<body background="${url_indexbg}">
	<table border="1" width="80%" align="center">
		<tr>
			<td height="80px" align="center">
				<%-- Header --%>
				<jsp:include page="include/header.jsp"/>
			</td>
		</tr>
		<tr>
			<td height="25px">
				<%-- Menu --%>
				<jsp:include page="include/menu.jsp"/>
			</td>
		</tr>
		<tr>
			<td height="350x" valign="top">
				<%-- Context --%>
				<h1>User Login</h1>
				TODO- User Options
			</td>
		</tr>
		<tr>
			<td height="25px">
				<%-- Footer --%>
				<jsp:include page="include/footer.jsp"/>
			</td>
		</tr>
	</table>
</body>
</html>