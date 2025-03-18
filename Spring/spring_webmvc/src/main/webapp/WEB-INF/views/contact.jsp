<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.center {
	display: flex;
	padding: 15px;
	min-height: 80vh;
	flex-direction: row;
	flex-wrap: wrap;
	align-content: center;
	justify-content: center;
	align-items: center;
}
</style>
<body>
	<div class="center">
		<form action="formProcess/registerWay3_1" method="post">
			email: <input name="email" type="text"> <br> <br>
			name: <input name="name" type="text"> <br> <br>
			password <input name="password" type="text"> <br> <br>
			phone no: <input name="phone" type="text"> <br> <br>
			Amount paid: <input name="amount" type="number"> <br> <br>
			<input type="submit">
		</form>
	</div>
</body>
</html>