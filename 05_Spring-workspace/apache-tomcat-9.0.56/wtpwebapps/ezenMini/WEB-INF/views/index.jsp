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
			<p class="h4">NEW ARRIVALS</p>
			<div class="card" style="width: 300px">
				<img src="images/deals1.jpg" class="card-img-top" style="height: 220px"/>
				<div class="card-body">
					<p class="h5 card-title">신상품</p>
					<p class="card-text">Buy 50 mobiles and get a gift card</p>
					<a href="#" class="btn btn-secondary">See Details</a>
				</div>
			</div>
		</div>
		
		<div class="col-sm-4">
			<p class="h4">BLACK FRIDAY DEAL</p>
			<div class="card" style="width: 300px">
				<img src="images/deals2.jpg" class="card-img-top" style="height: 220px"/>
				<div class="card-body">
					<p class="h5 card-title">블랙 프라이데이 특가</p>
					<p class="card-text">Buy 50 mobiles and get a gift card</p>
					<a href="#" class="btn btn-secondary">See Details</a>
				</div>
			</div>
		</div>
		
		<div class="col-sm-4">
			<p class="h4">MD PICK</p>
			<div class="card" style="width: 300px">
				<img src="images/deals3.jpg" class="card-img-top" style="height: 220px"/>
				<div class="card-body">
					<p class="h5 card-title">2022-03-14</p>
					<p class="card-text">Buy 50 mobiles and get a gift card</p>
					<a href="#" class="btn btn-secondary">See Details</a>
				</div>
			</div>
		</div>
	</div>
</div>


<%@ include file="footer.jsp" %>
	
</body>
</html>