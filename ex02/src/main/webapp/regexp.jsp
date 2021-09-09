<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="pass" name="pass" />
	<button type="button" id="btnCheck">확인</button>
	<!-- jQuery -->
	<script	src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
	<script>
	//숫자와 문자 포함 형태의 6~12자리 이내의 암호 정규식
		var passRule = /^[A-Za-z0-9]{6,12}$/; 
		var passRule2 = /^[0-9]{3}-[0-9]{3}$/ // 앞,뒤 3자리 숫자
		$("#btnCheck").on("click",function(){
			if (!passRule2.test($("#pass").val())) {
				//경고
				alert("error");
				return false;
			}
		});
	</script>
</body>
</html>