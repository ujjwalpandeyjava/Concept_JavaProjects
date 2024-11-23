<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Core -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About page</title>
</head>
<body>
	<h3>By using normal get</h3>
	<%
	String s = (String) request.getAttribute("mav");
	int i = (Integer) request.getAttribute("integ");
	LocalDateTime lc = (LocalDateTime) request.getAttribute("dateTime");
	%>
	<%=s%><br>
	<%=i%><br>
	<%=lc%><br>
	<hr>
	<!-- Or we can use EL (to use it enable EL tag)-->
	<h3>Or we can use El after enabling it, with it we do not have to
		take get objects</h3>
	<br>${mav }
	<br> ${integ }
	<br> ${dateTime }
	<br> ${lit }
	<hr>
	<h3>Or we can use JSTLs</h3>
	<c:forEach items="${lit }" var="v">${v }<br>
	</c:forEach>


</body>
</html>