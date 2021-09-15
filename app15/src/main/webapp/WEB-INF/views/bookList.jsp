<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page="include/header.jsp" />
	<div>
		<h1>도서 조회/수정</h1>
	</div>
	<div>
		<table border="1">
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
				<c:forEach items="${list}" var="book">
					<tr>
						<td>${book.bookNo}</td>
						<td>${book.bookName}</td>
						<td>${book.bookCoverimg}</td>
						<td>${book.bookDate}</td>
						<td>${book.bookPrice}</td>
						<td>${book.bookPublisher}</td>
						<td>${book.bookInfo}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<jsp:include page="include/footer.jsp" />