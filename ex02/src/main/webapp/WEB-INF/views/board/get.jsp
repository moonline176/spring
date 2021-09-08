<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="/WEB-INF/views/includes/header.jsp"%>
<div>
	<form role="form" action="/board/modify" method="get">
		<div class="form-group">
			<label>Bno</label> <input class="form-control" name="bno"
				value="${board.bno}" readonly="readonly">
		</div>
	</form>
	<div class="form-group">
		<label>Title</label> <input class="form-control" name="title"
			value="${board.title}" readonly="readonly">
	</div>

	<div>
		<label>Text area</label>
		<textarea class="form-control" name="content" rows="3"
			readonly="readonly">${board.content}</textarea>
	</div>

	<div class="form-group">
		<label>Writer</label> <input class="form-control" name="writer"
			value="${board.writer}" readonly="readonly">
	</div>

	<div class="form-group">
		<label>RegDate</label> <input class="form-control" name="regDate"
			value="<fmt:formatDate pattern = "yyyy/MM/dd" value="${board.regdate}"/>"
			readonly="readonly">
	</div>

	<div class="form-group">
		<label>Update Date</label> <input class="form-control"
			name="updateDate"
			value="<fmt:formatDate pattern = "yyyy/MM/dd" value="${board.regdate}"/>"
			readonly="readonly">
	</div>
	<form action="modify" method="post">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
		<a type="button"
			href='modify?bno=${board.bno}&pageNum=${cri.pageNum}&amount=${cri.amount}'
			class="btn btn-default">수정</a> <a class="btn btn-success"
			href="list?pageNum=${cri.pageNum}&amount=${cri.amount}">목록으로</a>
	</form>
</div>
<!-- 댓글 등록 -->
<div class="panel-heading">
	<form id="replyForm">
		<input type="text" name="bno" value="${board.bno}"> <input
			name="replyer" value="user10"> <input name="reply">
		<button type="button" id="saveReply">댓글등록</button>
	</form>
</div>

<!-- 댓글 목록 -->
<h3>댓글 목록</h3>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">댓글</h1>
		<ul class="chat">
		</ul>
	</div>
</div>
<script src="../resources/js/reply.js">
</script>
<script>
let bno ="${board.bno}"
	   $(function(){
	      //등록처리
	      $("#saveReply").on("click", function(){
	         $.ajax({
	            url : "../reply/", //method(or type):"get"
	            method : "post",
	            data :$("#replyForm").serialize(),
	            dataType : "json",
	            success : function(data){
	               console.log(data);
	               $(".chat").append ( makeLi(data) ) ;
	            }
	         
	         })
	      });
	      
	      //
	      function makeLi(data){
	         return '<li class="left clearfix">'
	               + '   <div class="header">'
	               + '      <strong class="primary-font">'+ data.replyer +'</strong>'
	               + '         <small class="pull-right text-muted">'+data.replyDate +'</small>'
	               + '      </div>'
	               + '   <p>'+ data.reply +'</p>'
	               + '   </li>   ';
	      }
	      
	      //목록조회
	      $.ajax({
	         url: "../reply/", //method(or type):"get"
	         data : {bno:bno} , //"bno=524295"
	         dataType : "json", //응답결과가 json
	         success: function(datas){
	            console.log(datas);
	            str = "";
	            for(i=0; i<datas.length; i++){
	               str += makeLi(datas[i]);
	         }
	         $('.chat').html(str);
	         }
	      });      
	   })
	   
	   
	   
	
</script>
<%@include file="/WEB-INF/views/includes/footer.jsp"%>