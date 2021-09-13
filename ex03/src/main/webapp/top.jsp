<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>톱 페이지입니다.</h1>
	<ul>
		<li><a href="user/user.jsp">일반 사용자용 페이지로</a></li>
		<li><a href="admin/admin.jsp">관리자 전용 페이지로</a></li>
	</ul>
	<sec:authorize access="isAnonymous()"> <!-- 로그인 안한 경우 -->
		<a href="loginForm">로그인</a>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()"> <!-- 로그인 한 경우 -->
		아이디 : <sec:authentication property="principal.userName"/>
		<form action="logout" method="post">
			<input type="text" name="${_csrf.parameterName}"
				value="${_csrf.token}">
			<button>로그아웃</button>
		</form>
	</sec:authorize>
</body>
</html>