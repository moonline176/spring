<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>custom login</h3>
	<form action="login" method="post">
		<input type="text" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input name="id">
		<input type="password" name="password">
		<button>로그인</button>
	</form>
</body>
</html>