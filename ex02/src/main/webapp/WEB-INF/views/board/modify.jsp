<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<form role="form" method="post">
	<div>
		<div class="form-group">
			<label>Bno</label> ${board.bno}
		</div>

		<div class="form-group">
			<label>Title</label> <input class="form-control" name="title"
				value="${board.title}" readonly="readonly">
		</div>

		<div>
			<label>Content</label>
			<textarea class="form-control" name="content" rows="3">${board.content}</textarea>
		</div>

		<div class="form-group">
			<label>Writer</label> <input class="form-control" name="writer"
				value="${board.writer}" readonly="readonly">
		</div>

		<button type="submit" class="btn btn-default">수정</button>
		<a href="remove?bno=${board.bno}" class="btn btn-warning">삭제</a>
	</div>
</form>

<%@include file="/WEB-INF/views/includes/footer.jsp"%>