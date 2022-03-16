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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/b4e02812b5.js" crossorigin="anonymous"></script>
<!-- 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
-->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<style>
.navbar {
	border-radius: 0;
	margin-bottom: 0px;
}

.nav-link {
	font-weight: 400;
}

#searchForm {
	visibility: hidden;
}
</style>

</head>

<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top font-weight-bold">
	<a href="/mini" class="navbar-brand">
		<i class="fa-solid fa-c fa-bounce"></i>
	</a>
	
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a href="home" class="nav-link">Home</a>
			</li>
		
			<li class="nav-item">
				<a href="product" class="nav-link">Products</a>
			</li>
			
			<li class="nav-item">
				<a href="util" class="nav-link">Utils</a>
			</li>
			
			<li class="nav-item">
				<a href="stores" class="nav-link">Stores</a>
			</li>
			
			<li class="nav-item">
				<a href="contact" class="nav-link">Contact</a>
			</li>
			
			<li class="nav-item">
				<a href="portfolio" class="nav-link">Portfolio</a>
			</li>
			
			<!-- Dropdown -->
			<li class="nav-item dropdown">
				<a href="#" class="nav-link dropdown-toggle" id="navbardrop" data-toggle="dropdown">알림</a>
				
				<div class="dropdown-menu">
					<a href="notice" class="dropdown-item">공지사항</a>
					<a href="board" class="dropdown-item">게시판</a>
					<a href="qna" class="dropdown-item">Q&A</a>
				</div>
			</li>
			
			<li class="nav-item">
				<a href="#" class="nav-link btn disabled">Space</a>
			</li>
			
			<li class="nav-item">
				<a href="login_view" class="nav-link">Login</a>
			</li>
			
			<li class="nav-item">
				<a href="logout_view" class="nav-link">Logout</a>
			</li>
			
			<li class="nav-item">
				<a href="join_view" class="nav-link">Join</a>
			</li>
		</ul>
	</div>
	
	<form action="#" id="searchForm" class="form-inline">
		<button class="btn btn-primary mr-sm-2" type="button" disabled>
			<i class="fa fa-search"></i>
		</button>
		<input type="text" id="searchInput" class="form-control mr-sm-2" placeholder="Search"/>
	</form>

</nav>
</body>
</html>
