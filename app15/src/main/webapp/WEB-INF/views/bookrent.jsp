<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page="include/header.jsp" />
	<table border="1">
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>대여총계</th>
			<th>대여횟수</th>
		</tr>
		<c:forEach items="${list}" var="rent">
			<tr>
				<td>${rent.bookNo}</td>
				<td>${rent.bookName}</td>
				<td>${rent.rentPrice}</td>
				<td>${rent.rentStatus}</td>
			</tr>
		</c:forEach>
	</table>
<jsp:include page="include/footer.jsp" />