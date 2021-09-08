<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>

<!-- DataTables CSS -->
<link href="${pageContext.request.contextPath}/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="${pageContext.request.contextPath}/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
<!-- DataTables JavaScript -->
<script src="${pageContext.request.contextPath}/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시판</h1>
	</div>
	<!-- /.col-lg-12 -->
	<table class="table" id="board">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성일자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="board">
				<tr>
					<td>${board.bno}</td>
					<td><a class="move" href="${board.bno}">${board.title} [${board.replycnt}]</a></td>
					<td><fmt:formatDate value="${board.regdate }" type="both"
							pattern="yy-MM-dd" /></td>
			</c:forEach>
		</tbody>
	</table>
	<form id="actionForm" action="list" method="get"> <!-- 메소드 생략시 자동으로 get로 전환 -->
		<select name="type">
			<option value="" ${empty pageMaker.cri.type ? selected : ""}>선택</option>
			<option value="T" ${empty pageMaker.cri.type =='T' ? selected : ""}>제목검색</option>
			<option value="C" ${empty pageMaker.cri.type =='C' ? selected : ""}>내용</option>
			<option value="W" <c:out value="${pageMaker.cri.type eq 'W' ? 'selected':''}"/>>작성자</option>
			<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC' ? 'selected':''}"/>>제목 or 내용</option>
			<option value="TW" <c:out value="${pageMaker.cri.type eq 'TW' ? 'selected':''}"/>>제목 or 작성자</option>
			<option value="TWC" <c:out value="${pageMaker.cri.type eq 'TWC' ? 'selected':''}"/>>제목 or 작성자 or 내용</option>
		</select>
		<input name="keyword" value="${pageMaker.cri.keyword}">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">		
		<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
		<button class="btn btn-default">Search</button>		
	</form>
	<div id="pageButton">
	<c:if test="${pageMaker.prev == true}"><a href="${pageMaker.startPage-1}">이전</a></c:if>
	<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="num"><a href="${num}">${num}</a></c:forEach>
	<c:if test="${pageMaker.next == true}"><a href="${pageMaker.endPage+1}">다음</a></c:if>
	</div>
</div>
<div>
	<input type="button" class="btn btn-default" onclick="location.href='register'" value="게시글 작성"/>
</div>
<script type="text/javascript">
	$(function() {
		var actionForm = $("#actionForm")
		
		$(".move").on("click",function(e){
			e.preventDefault();
			var bno = $(this).attr("href")
			actionForm.append('<input type="hidden" name="bno" value="'+bno+'">')
			actionForm.attr("action","get")
			actionForm.submit();
		});
		
		$("#pageButton a").on("click",function(e){
			e.preventDefault();	//a, submit
			var p = $(this).attr("href") //클릭한 값
			$('[name="pageNum"]').val(p)
			actionForm.submit();
		})
		//$('#board').DataTable();
	})
</script>
<%@include file="/WEB-INF/views/includes/footer.jsp"%>