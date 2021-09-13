<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
	<table border="1">
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>대여총계</th>
			<th>대여횟수</th>
		</tr>
		<tr>
			<td>${rlist.bookNo}</td>
			<td>${rlist.bookName}</td>
			<td>${rlist.rentPrice}</td>
			<td>${rlist.rentStatus}</td>
		</tr>
	</table>
</body>
</html>