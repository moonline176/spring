<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="uploadFormAction">
	<input type="file" name="uploadFile" multiple="multiple"> <!-- name 이 파라미터 -->
	<button>등록</button>
</form>
</body>
</html>