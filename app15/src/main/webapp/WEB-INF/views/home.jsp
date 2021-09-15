<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page="include/header.jsp" />
	<div>
		<h1>도서대여관리 프로그램</h1>
	</div>
	<div>
		<p>
			국제 대여점의 도서등록, 대여정보 데이터베이스를 구축하고, 도서.DVD 대여관리를 위한 프로그램이다.
		</p><br>
		<p>프로그램 작성 순서</p>
		<ul>
			<li>1. 도서정보 테이블을 생성한다.</li>
			<li>2. 대여정보 테이블을 생성한다.</li>
			<li>3. 도서정보,대여정보 테이블에 제시된 문제지의 참조데이터를 추가 생성한다.</li>
			<li>4. 도서정보 입력 화면프로그램을 작성한다.</li>
			<li>5. 도서정보 조회 프로그램을 작성한다.</li>
			<li>6. 대여 정보 조회 프로그램을 작성한다.</li>
		</ul> 
	</div>
<jsp:include page="include/footer.jsp" />