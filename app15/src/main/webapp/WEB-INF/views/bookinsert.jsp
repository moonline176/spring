<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<jsp:include page="include/header.jsp" />
<body>
	<div>
		<h1>도서 등록</h1>
	</div>
	<div>
		<form id="frm" name="frm">
			<table>
				<tr>
					<th>도서번호</th>
					<td><input type="text"></td>
				</tr>
				<tr>
					<th>도서명</th>
					<td><input type="text" id="bookName"></td>
				</tr>
				<tr>
					<th>도서표지</th>
					<td><input type="text" id="bookCoverimg"></td>
				</tr>
				<tr>
					<th>출판일자</th>
					<td><input type="date" id="bookDate"></td>
				</tr>
				<tr>
					<th>금액</th>
					<td><input type="text" id="bookPrice"></td>
				</tr>
				<tr>
					<th>출판사</th>
					<td><input type="text" id="bookInfo"></td>
				</tr>
				<tr>
					<th>도서소개</th>
					<td><textarea id="bookPublisher"></textarea></td>
				</tr>
			</table>
		</form>
	</div>
	<button type="button" id="btnRegister">등록</button>
	<button type="button" >조회</button>
	<script type="text/javascript">
	//등록
	$(function(){
		
		function focusOn() {

			  document.getElementById("bookName").focus();

			}
	
	$("#btnRegister").on("click",
		function () {
			$.ajax({
				url: "insertBook",
				type: "post",
				dataType: "json",
				data: JSON.stringify({
					bookName: $("#bookName").val(),
					bookCoverimg: $("#bookCoverimg").val(),
					bookDate: $("#bookDate").val(),
					bookPrice: $("#bookPrice").val(),
					bookInfo:$("#bookInfo").val(),
					bookPublisher: $("#bookPublisher").val()
				}),
				contentType: 'application/json',
				success: function (data) {
					alert("도서등록이 완료 되었습니다");
					console.log(data);
				},
				error: function () {
					alert("도서명이 입력되지 않았습니다."); // 실패 시 처리
					focusOn();
				}
			});
		});
	
	});
	</script>
<jsp:include page="include/footer.jsp" />