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
		<h1>도서 등록</h1>
	</div>
	<div>
		<form id="frm" name="frm" action="insert">
			<table>
				<tr>
					<th>도서번호</th>
					<td><input type="text" id="bookNo" value="${book.bookNo}"></td>
				</tr>
				<tr>
					<th>도서명</th>
					<td><input type="text" id="bookName" value="${book.bookName}"></td>
				</tr>
				<tr>
					<th>도서표지</th>
					<td><input type="text" id="bookCoverimg" value="${book.bookCoverimg}"></td>
				</tr>
				<tr>
					<th>출판일자</th>
					<td><input type="date" id="bookDate" value="${book.bookDate}"></td>
				</tr>
				<tr>
					<th>금액</th>
					<td><input type="text" id="bookPrice" value="${book.bookPrice}"></td>
				</tr>
				<tr>
					<th>도서소개</th>
					<td><textarea id="bookPublisher">${book.bookPublisher}</textarea></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td><input type="text" id="bookInfo" value="${book.bookInfo}"></td>
				</tr>
			</table>
		</form>
	</div>
	<button type="submit" id="btnRegister">등록</button>
	<button type="submit" >조회</button>
	<script type="text/javascript">
	$(function(){
		$("#btnRegister").on(
				"click",
				function (e) {
					e.preventDefault();
					$.ajax({
						url: "insertBook",
						type: "post",
						dataType: "json",
						data: JSON.stringify({
							bookName: $("#bookName").val(),
							bookCoverimg: $("#bookCoverimg").val(),
							bookDate: $("#bookDate").val(),
							bookPrice: $("#bookPrice").val(),
							bookPublishe: $("#bookPublishe").val()
						}),
						contentType: 'application/json',
						success: function (data) {
							console.log(data);
						},
						error: function (request, status, error) {
							alert("code = " + request.status +
								" message = " + request.responseText +
								" error = " + error); // 실패 시 처리
						}
					});
				});	
		
	});
	
	</script>
</body>
</html>