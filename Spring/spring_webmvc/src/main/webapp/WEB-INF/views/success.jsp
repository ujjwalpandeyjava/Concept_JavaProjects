<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form success</title>
</head>
<body>
	<h1>The form work has been done successfully.</h1>
	<hr>
	<%-- <h1>For way one</h1>
	<p style="font-style: italic;">This one uses normal old approach of
		using HttpServletRequest object to get and send data.</p>
	<%
	String emailVar = (String) request.getAttribute("email");
	String nameVar = (String) request.getAttribute("name");
	String passVar = (String) request.getAttribute("password");
	String phoneVar = (String) request.getAttribute("phone");
	int amountVar = (Integer) request.getAttribute("amount");
	%>
	The email is:
	<%=emailVar%>
	<br> The name is:
	<%=nameVar%>
	<br> The pass is:
	<%=passVar%>
	<br> The phone is:
	<%=phoneVar%>
	<br> The amount is:
	<%=amountVar%>
	--%>




	<%-- <h1>For way two</h1>
	Using Class and object to get the data
	<br>The email is:  ${details.email }
	<br>The name is:  ${details.name }
	<br>The password is:  ${details.password }
	<br>The phone is:  ${details.phone }
	<br>The amount is:  ${details.amount }
	<br>Side added list without using object is: ${listIn }
	 --%>
	
	
	
	<h1>For way three</h1>
	
	<h3>If using "ClassObject" after @ModuleAttribute annotation</h3>
	${msg }
	<br>The email is: ${user.email }
	<br>The name is: ${user.name }
	<br>The password is: ${user.password }
	<br>The phone is: ${user.phone }
	<br>The amount is: ${user.amount }


	<h3>If using model.addAttribute("__","__");</h3>
	${msg }
	<br>The email is: ${details.email }
	<br>The name is: ${details.name }
	<br>The password is: ${details.password }
	<br>The phone is: ${details.phone }
	<br>The amount is: ${details.amount }
</body>
</html>



















