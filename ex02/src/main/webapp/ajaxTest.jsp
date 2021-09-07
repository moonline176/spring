<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajaxTest.jsp</title>
<!-- jQuery -->
<script
	src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script>
$(function(){ //$(function(){ : load event / 이부분이 있어야 body 출력이후 스크립트가 적용된다

	//$('#btn1').on("click",function(){ alert("aaa");}) // .on은 해당 이벤트가 누적되어 추가된다 , .click은 단 한번만 가능
	//btn1.addEventListener = ("click",function(){}) // 한버튼에 위에 addE~ 기능 3개가 동시에 적용된다.
	
	$("#btn1").on("click",function(){
		$.ajax({
			url : "ajax1",
			method : "get", //post 
			data : { writer: $('#writer').val() },
			//async : false, //동기식 
			dataType : "json", //plain=text, json, xml
			success : function(data){ // data : callback 함수의 매개변수, 명칭은 상관없음
				$("#result").append(data.content+"<br>");
				$("#result").append(data.writer+"<br>");
			}
		});
		$("#result").append("클릭됨<br>");
	}) //btn1 click end
	
	$("#btn2").on("click",function(){
		$.ajax({
			url : "ajax2",
			method : "post",  
			data : JSON.stringify({writer : $("#writer").val()}),
			contentType : "application/json",
			dataType: "json",
			success : function(data){ 
				/* $("#result").append(data.content+"<br>");
				$("#result").append(data.writer+"<br>"); */
				//$("#result").append($("<p>").append(data.content)
				//							.append("<br>")
				//							.append(data.writer))
				$("#result").append($(`<p>\${data.writer}<br>\${data.content}</p>`))
				//$("#result").append($('<p>'+data.content+'</p>'))
			} //success end
		}); //ajax end
	}) // btn2 click
	
	//그룹 이벤트 : 위임 -> 동적으로 추가될 태그에도 미리 이벤트 지정
	$("#result").on("click","p",function(){
		$(this).remove();
	})
}) //end of $(function(){})
</script>
</head>
<body>
	<input name="writer" id="writer">
	<button type="button" id="btn1">문자열</button>
	<button type="button" id="btn2">파라미터(json)</button>
	<div id="result"></div>
</body>
</html>