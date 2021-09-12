<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
	<meta charset="UTF-8">
	<title>부서관리</title>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<h3>부서관리</h3>
	<div id="list"></div>
	<br>
	<div>
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">부서등록</button>
		<button type="button" class="btn btn-primary" id="btnUpdate">수정</button>
	</div>
	<br>

	<form id="update">
		DEPARTMENT_ID<input id="departmentId" name="departmentId"><br />
		DEPARTMENT_NAME<input id="departmentName" name="departmentName"><br />
		MANAGER_ID<input id="managerId" name="managerId"><br />
		LOCATION_ID<input id="locationId" name="locationId">
	</form>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="frm">
						DEPARTMENT_ID<input id="departmentId2" name="departmentId2"><br />
						DEPARTMENT_NAME<input id="departmentName2" name="departmentName2"><br />
						MANAGER_ID<input id="managerId2" name="managerId2"><br />
						LOCATION_ID<input id="locationId2" name="locationId2">
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="btnRegister">등록</button>
					
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(function () {
					deptList();

					//목록 조회
					function deptList() {
						$
							.ajax({
								url: "deptList",
								dataType: "json",
								success: function (datas) {
									console.log(datas)
									$
										.each(
											datas,
											function (i, data) {
												$("<div>")
													.append(
														$("<span>")
														.html(
															data.departmentId))
													.append(
														$("<span>")
														.html(
															" / " +
															data.departmentName))
													.append(
														$("<span>")
														.html(
															" / " +
															data.managerId))
													.append(
														$("<span>")
														.html(
															" / " +
															data.locationId))
													.appendTo(
														$("#list"));
											})
								}
							});
					}

					//등록
					$("#btnRegister").on(
						"click",
						function (e) {
							e.preventDefault();
							$.ajax({
								url: "insertDept",
								type: "post",
								dataType: "json",
								data: JSON.stringify({
									departmentId: $("#departmentId2").val(),
									departmentName: $("#departmentName2").val(),
									managerId: $("#managerId2").val(),
									locationId: $("#locationId2").val()
								}),
								contentType: 'application/json',
								/* data : $("#frm").serialize(), */
								success: function (data) {
									console.log(data);
									$("#exampleModal").modal('hide');
									/* if(data.result == true){
										$("#exampleModal").modal('hide');
										deptList();
									} */
									$("#list").empty();
									deptList();
								},
								error: function (request, status, error) {
									alert("code = " + request.status +
										" message = " + request.responseText +
										" error = " + error); // 실패 시 처리
								}
							});
						});

					// //단건조회
					// function deptGet() {
					// 	$.ajax({
					// 		url: "getDept",
					// 		dataType: "json",
					// 		success: function (data) {
					// 			console.log(data);
					// 			$("#departmentId2").text(data.departmentId);
					// 			$("#departmentName2").html(data.departmentName);
					// 			$("#managerId2").html(data.managerId);
					// 			$("#locationId2").html(data.locationId);
					// 		}
					// 	});
					// }

					$("#btnUpdate").on("click",function (e) {
							e.preventDefault(); 
							deptUpdate();
						});

							//수정
							function deptUpdate() {
								$.ajax({
									url: "updateDept",
									type: "put",
									dataType: "json",
									data: JSON.stringify({
										departmentId: $("#departmentId").val(),
										departmentName: $("#departmentName").val(),
										managerId: $("#managerId").val(),
										locationId: $("#locationId").val()
									}),
									contentType: 'application/json',
									success: function (datas) {
										console.log(datas)
										$("#list").empty();
										deptList();
									},
									error: function (request, status, error) {
										alert("code = " + request.status + " message = " +
											request.responseText + " error = " + error); // 실패 시 처리
									}
								});
							}


						});
	</script>
</body>

</html>