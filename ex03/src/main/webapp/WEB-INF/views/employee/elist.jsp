<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
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
							<td><a href="updateEmp?employeeId=${employee.employeeId}">${employee.employeeId}</a></td>
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
		</div>
	</div>
</body>
</html>