<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<form role="form" method="post">

	<div class="form-group">
		<label>Bno</label> 
		<input class="form-control" name="bno">
	</div>

	<div class="form-group">
		<label>Title</label> <input class="form-control" name="title">
	</div>

	<div>
		<label>Text area</label>
		<textarea class="form-control" name="content" rows="3"></textarea>
	</div>

	<div class="form-group">
		<label>Writer</label>
		<input class="form-control" name="writer" >
	</div>


	<button type="submit" class="btn btn-default">등록</button>
	<button type="submit" class="btn btn-default">목록</button>
</form>
<%@include file="/WEB-INF/views/includes/footer.jsp"%>