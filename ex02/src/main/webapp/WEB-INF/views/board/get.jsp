<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<form role="form" action="/board/modify" method="get">
	<div class="form-group">
		<label>Bno</label> <input class="form-control" name="bno"
			value="${board.bno}" readonly="readonly">
	</div>
</form>
<div class="form-group">
	<label>Title</label> <input class="form-control" name="title"
		value="${board.title}" readonly="readonly">
</div>

<div>
	<label>Text area</label>
	<textarea class="form-control" name="content" rows="3"
		readonly="readonly">${board.content}</textarea>
</div>

<div class="form-group">
	<lable>Writer</lable>
	<input class="form-control" name="writer" value="${board.writer}"
		readonly="readonly">
</div>

<div class="form-group">
	<lable>RegDate</lable>
	<input class="form-control" name="regDate"
		value="<fmt:formatDate pattern = "yyyy/MM/dd" value="${board.regdate}"/>"
		readonly="readonly">
</div>

<div class="form-group">
	<lable>Update Date</lable>
	<input class="form-control" name="updateDate"
		value="<fmt:formatDate pattern = "yyyy/MM/dd" value="${board.regdate}"/>"
		readonly="readonly">
</div>
<form action="modify" method="post">
	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
	<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
	<a type="button" href='modify?bno=${board.bno}&pageNum=${cri.pageNum}&amount=${cri.amount}'
		class="btn btn-default">수정</a>
	<a class="btn btn-success"
		href="list?pageNum=${cri.pageNum}&amount=${cri.amount}">목록으로</a>
</form>
<%@include file="/WEB-INF/views/includes/footer.jsp"%>