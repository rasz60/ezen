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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>

<style>
/* browser별 기본 설정 값에 영향을 받지않기 위한 세팅 */
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

.h4 {
	font-style: italic;
	color: #373839;
	text-shadow: 1px 1px 2px grey;
}

</style>
</head>

<!-- nav-menu, carousel, footer는 모든 페이지에 include (* jquery CDN은 주석처리) -->
<body>

<%@ include file="nav.jsp" %>
<%@ include file="carousel.jsp" %>

<div id="main" class="container mt-5">
	<div class="row">
		<div class="col-sm-4">
			<p class="h4 mb-5 d-flex justify-content-around">
				NEW ARRIVALS
				<a href="#" class="btn btn-sm btn-default text-secondary">See Details&gt;&gt;</a>
			</p>
			<div class="card" style="width: 300px; border: none;">
				<img src="images/deals1.jpg" class="card-img-top" style="height: 220px"/>
				<div class="card-body text-center">
					<p class="h5 card-title">MADISON JACKET</p>
					<p class="card-text text-secondary">TAWNY/TAWNY RINSED</p>
				</div>
			</div>
		</div>
		
		<div class="col-sm-4">
			<p class="h4 mb-5 d-flex justify-content-around">
				BLACK FRIDAY DEAL
				<a href="#" class="btn btn-sm btn-default text-secondary">See Details&gt;&gt;</a>
			</p>
			
			<div class="card" style="width: 300px; border: none;">
				<img src="images/deals2.jpg" class="card-img-top" style="height: 220px"/>
				<div class="card-body text-center">
					<p class="h5 card-title">HOODED SWEATSHIRT</p>
					<p class="card-text text-secondary">ASTRO</p>
				</div>
			</div>
		</div>
		
		<div class="col-sm-4">
			<p class="h4 mb-5 d-flex justify-content-around">
				MD PICK
				<a href="#" class="btn btn-sm btn-default text-secondary">See Details&gt;&gt;</a>
			</p>

			<div class="card" style="width: 300px; border: none;">
				<img src="images/deals3.jpg" class="card-img-top" style="height: 220px"/>
				<div class="card-body text-center">
					<p class="h5 card-title">DENNIS CAP</p>
					<p class="card-text text-secondary">HELIOS/BLACK</p>
				</div>
			</div>
		</div>
	</div>
</div>


<%@ include file="footer.jsp" %>
	
</body>
</html>