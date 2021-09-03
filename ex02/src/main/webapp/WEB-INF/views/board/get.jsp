<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<h3>게시판</h3>
<table border="1">
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>입력날짜</th>
		<th>수정날짜</th>
	</tr>
	<tr>
		<td>${board.bno}</td>
		<td>${board.title}</td>
		<td>${board.content}</td>
		<td><fmt:formatDate value="${board.regdate }" type="both"
				pattern="yy-MM-dd" /></td>
		<td><fmt:formatDate value="${board.updatedate }" type="both"
				pattern="yy-MM-dd" /></td>
	</tr>
</table>
<%@include file="/WEB-INF/views/includes/footer.jsp"%>