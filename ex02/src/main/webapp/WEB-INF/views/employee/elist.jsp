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
	<table class="table" id="employee">
		<thead>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>성</th>
				<th>전화번호</th>
				<th>입사일</th>
				<th>직책명</th>
				<th>봉급</th>
				<th>커미션</th>
				<th>매니져</th>
				<th>부서번호</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="employee">
				<tr>
					<td><a class="move" href="${employee.employeeId}">${employee.employeeId}</a></td>
					<td>${employee.firstName}</td>
					<td>${employee.lastName}</td>
					<td>${employee.phoneNumber}</td>
					<td><fmt:formatDate value="${employee.hireDate}" type="both"
							pattern="yy-MM-dd" /></td>
					<td>${employee.jobId}</td>
					<td>${employee.salary}</td>
					<td>${employee.commissionPct}</td>
					<td>${employee.managerId}</td>
					<td>${employee.departmentId}</td>
				</tr>	
			</c:forEach>
		</tbody>
	</table>
	<form id="actionForm" action="list" method="get"> <!-- 메소드 생략시 자동으로 get로 전환 -->
		<select name="type">
			<option value="" ${empty pageMaker.cri.type ? selected : ""}>선택</option>
			<option value="T" ${empty pageMaker.cri.type =='T' ? selected : ""}>사번</option>
			<option value="C" ${empty pageMaker.cri.type =='C' ? selected : ""}>이름</option>
			<option value="W" <c:out value="${pageMaker.cri.type eq 'W' ? 'selected':''}"/>>부서번호</option>
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
	<c:if test="${pageMaker.prev}"><a href="${pageMaker.startPage-1}">이전</a></c:if>
	<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="num"><a href="${num}">${num}</a></c:forEach>
	<c:if test="${pageMaker.next}"><a href="${pageMaker.endPage+1}">다음</a></c:if>
	</div>
</div>
<script type="text/javascript">
	
	$(function() {
		var actionForm = $("#actionForm")
		
	 	$(".move").on("click",function(e){
			e.preventDefault();
			var employeeId = $(this).attr("href")
			actionForm.append('<input type="hidden" name="employeeId" value="'+employeeId+'">')
			actionForm.attr("action","get")
			actionForm.submit();
		});
		 
		$("#pageButton a").on("click",function(e){
			e.preventDefault();	//a, submit
			var p = $(this).attr("href") //클릭한 값
			$('[name="pageNum"]').val(p)
			actionForm.submit();
		})
	})
</script>
<%@include file="/WEB-INF/views/includes/footer.jsp"%>