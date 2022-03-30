<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false"%>
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
<meta id="_csrf" name="_csrf" content="${_csrf.token }">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/b4e02812b5.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Login View</title>
<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#main {
	height: auto;
}
</style>
</head>

<body>
<%@ include file="nav.jsp" %>
<%@ include file="carousel.jsp" %>

<div id="main" class="container mt-5">
	
	<h3 class="display-4">Login</h3>
	<hr />
	
	<form action="login" id="frm1" name="frm1" method="post">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
		
		<h5 id="logincheck" class="text-success mx-2 font-italic text-center"></h5>
		<div class="form-group">
			<label for="uid">아이디</label>
			<input type="email" class="form-control" name="pid" placeholder="email 주소 입력" id="uId" required />
		</div>
		
		<div class="form-group">
			<label for="upw">비밀번호</label>
			<input type="password" class="form-control" name="ppw" placeholder="비밀번호 입력" id="uPw" required />
		</div>
		
		<div class="d-flex justify-content-between mt-4">
			<div class="form-group form-check ">
				<input type="checkbox" class="form-check-input" id="rememberMe" name="remember-me" checked />
				<label for="rememberMe" class="form-check-label font-italic" aria-describedby="rememberMeHelp">Remember me?</label>
			</div>
			<div class="loginBtnbox">
				<%-- social login START --%>
				<a href="${google_url}" id="nlog" class="btn btn-light mr-2">
					<i class="fa-solid fa-g"></i>
				</a>
				<%-- social login END --%>
			
				<input type="submit" value="로그인" class="btn btn-sm btn-primary mr-2" />

				<a href="join_view" class="btn btn-sm btn-dark " >회원가입</a>
			</div>
		</div>
	</form>
</div>
<%@ include file="footer.jsp" %>


<script>
$(document).ready(function() {
	<c:choose>
		<c:when test="${not empty log}">
			$("#logincheck").text("Welcome");
		</c:when>

		<c:when test="${not empty logout}">
			$("#logincheck").text("Logout");
		</c:when>
	
		<c:when test="${not empty error}">
			$("#logincheck").text("Login Error");
		</c:when>
		
		<c:otherwise>
			$("#logincheck").text("Welcome");
		</c:otherwise>
	</c:choose>
})



</script>

</body>
</html>