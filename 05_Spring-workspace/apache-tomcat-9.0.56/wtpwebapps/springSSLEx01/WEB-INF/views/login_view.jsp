<!-- jsp setting -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>

<!-- jstl setting -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>   
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- security csrf Token -->
<meta id="_csrf" name="_csrf" content="${_csrf.token}" />
<!-- bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- fontawesome -->
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	  integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	  crossorigin="anonymous"/>
<!-- jquery 3.5.1 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Login Page</title>
</head>

<body>

<div class="container mt-2 py-5 border rounded">
	<h3 class="text-center text-info pb-2">로그인</h3>
	<hr />
	
	<!-- 로그인 이 후 서버 메세지를 띄워줄 박스 -->
	<div id="div1" class="text-success"></div>
	<form action="login" id="frm1" name="frm1" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

		<div class="form-group">
			<label for="user_id">아이디</label>
			<input type="email" class="form-control" name="pid" id="user_id" placeholder="이메일 주소 입력" required />
		</div>
		
		<div class="form-group">
			<label for="user_pwd">비밀번호</label>
			<input type="password" class="form-control" name="ppw" id="user_pwd" placeholder="비밀번호 입력" required />
		</div>
		<div class="form-group form-check">
			<input type="checkbox" class="form-check-input" id="rememberMe" name="remebber-me" checked />
			<!-- aria-describedby : 스크린리더(맹인용 웹)에 쓰일 안내말 -->
			<label for="rememberMe" class="form-check-label" aria-describedby="rememberMeHelp">Remember Me?</label>
		</div>
		<div class="d-flex justify-content-end">
			<input type="submit" value="로그인" class="btn btn-sm btn-secondary"/>&nbsp;&nbsp;
			<a href="join_view"><button type="button" class="btn btn-sm btn-secondary">가입하기</button></a>
		</div>
	</form>
</div>


<script>
// server compile 순서는 java - jstl - html - javascript[jstl 사용 가능]
$(document).ready(function() {
	// model에 포함된 log, logout, error의 값을 jstl변수로 처리
	<c:choose>
		<c:when test="${not empty log}">
			$('#div1').text('Welcome!');
		</c:when>
		
		<c:when test="${not empty logout}">
			$('#div1').text('Logout 성공');
		</c:when>
		
		<c:when test="${not empty error}">
			$('#div1').text('로그인 실패');
		</c:when>
		
		<c:otherwise>
			$('#div1').text('Welcome!');
		</c:otherwise>		
	</c:choose>
})

</script>

</body>
</html>