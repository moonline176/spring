<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<style>
	.require {
		color : "red";
	}
	
	.emp {
		cursor: pointer;
	}
	
	.emp:hover {
		color : blue;
	}
</style>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
	$(function() {
		function validation(){ //not null 조건 설정
			if(frm.lastName.value == ""){
				alert("이름입력");
				frm.lastName.focus();
				return false;
			}
			return true;
		}
		
		//등록버튼
		$("btnRegister").on("click	", function(){
			if(validation()){
				frm.submit();
			}
		})
		
		//매니저검색
		$("#btnEmpSearch").on("click", function() {
			//검색페이지를 ajax -> 모달 바디 넣고 -> 모달 
			$.ajax({
				url : "empSearch",
				success : function(data) {
					$("#empModal .modal-body").html(data); //데이터 넣어줌
					$("#empModal").modal('show');
				}
			});
		});

		//매니저 단건검색
		$("#managerId").on("keydown", function(e) {
			$('#name').val("");
			if($("#managerId").val()=="")
				return;
			if (e.keyCode == 13) {
				e.preventDefault();
				$.ajax({
					url : "ajaxEmp",
					data : {
						employeeId : $("#managerId").val()
					},
					success : function(data) {
						if (data) {
							$("#name").val(data.firstName);
						} else {
							$("#btnEmpSearch").click();
						}
					}
				});
			}
		})
	});
</script>
</head>
<body>
	<h3>사원 등록</h3>
	<form name="frm" action="${not empty emp ?  'updateEmp' : 'insertEmp'}" method="post">
		<c:if test="${not empty emp}">
			<input name="employeeId" value="${emp.employeeId}">
		</c:if>
		fistName<span class="require">*</span><input id="fistName" name="fistName" value="${emp.firstName}"><br /> 
		lastName<span class="require">*</span><input id="lastName" name="lastName" value="${emp.firstName}"><br /> 
		email<span class="require">*</span><input id="email" name="email" value="${emp.firstName}"><br /> 
		phoneNumber<input id="phoneNumber" name="phoneNumber" value="${emp.firstName}"><br /> 
		hireDate<span class="require">*</span><input type="date" id="hireDate" name="hireDate" value="${emp.firstName}"><br /> 
		jobId<span class="require">*</span><select name="jobId">
			<option value="">선택</option>
			<c:forEach items="${opt.jobs}" var="job">
				<option value="${job.jobId}">${job.jobTitle}</option>
			</c:forEach>
		</select><br /> 
		salary<input id="salary" name="salary" value="${emp.firstName}"><br />
		commissionPct<input id="commissionPct" name="commissionPct" value="${emp.firstName}"><br />
		managerId<input type="text" id="managerId" name="managerId" value="${emp.firstName}"><input id="name">
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" id="btnEmpSearch">
			검색</button>
		<br /> departmentId<select name="departmentId">
			<option value="">선택</option>
			<c:forEach items="${opt.depts}" var="dept">
				<option value="${dept.departmentId}">${dept.departmentName}</option>
			</c:forEach>
		</select><br /> <br />
		<button type="button" id="btnRegister">등록</button>
	</form>
	<div class="modal" tabindex="-1" id="empModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>Modal body text goes here.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>