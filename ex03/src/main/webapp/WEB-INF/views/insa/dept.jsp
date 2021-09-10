<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>부서관리</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<h3>부서관리</h3>
	<div id="list"></div>

	<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#exampleModal">Launch demo modal</button>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="frm" action="insertDept" method="post">
					DEPARTMENT_ID<input id="departmentId" name="departmentId"><br/>
					DEPARTMENT_NAME<input id="departmentName" name="departmentName"><br/>
					MANAGER_ID<input id="managerId" name="managerId"><br/>
					LOCATION_ID<input id="locationId" name="locationId">
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"	data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="btnRegister">등록</button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(function() {
			deptList();
			//등록
			$("#btnRegister").on("click",function(){
				$('#frm').submit();
				$('#exampleModal').modal('hide');
			})
			//수정

			//목록 조회
			function deptList() {
				$.ajax({
					url : "deptList",
					dataType : "json",
					success : function(datas) {
						console.log(datas)
						$.each(datas, function(i, data) {
							$("<div>").append(
									$("<span>").html(data.departmentId))
									.append($("<span>").html(data.departmentName))
									.appendTo($("#list"));
						})
					}
				});
			}

			
		})
	</script>
</body>
</html>