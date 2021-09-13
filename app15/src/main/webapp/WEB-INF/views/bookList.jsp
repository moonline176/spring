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
	<div>
		<h1>도서 조회/수정</h1>
	</div>
	<div>
		<table>
			<thead>
				<tr>
					<th>도서번호</th>
					<th>도서명</th>
					<th>표지</th>
					<th>출판일자</th>
					<th>금액</th>
					<th>출판자</th>
					<th>도서소개</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${list.bookNo}</td>
					<td>${list.bookName}</td>
					<td>${list.bookCoverimg}</td>
					<td>${list.bookDate}</td>
					<td>${list.bookPrice}</td>
					<td>${list.bookPublisher}</td>
					<td>${bookInfo}</td>
				</tr>
			</tbody>			
		</table>
	</div>
</body>
</html>