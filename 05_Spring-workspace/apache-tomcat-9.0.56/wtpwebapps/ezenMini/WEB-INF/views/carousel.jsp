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
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#demo {
	margin-top: 3.7rem;
}

/* 이미지 크기만큼 지정해주는 것이 좋음 */
.carousel-inner img {
	width: 100%;
	height: 400px;
}
</style>


</head>

<body>
														   <!-- 슬라이드되는 ms 지정 (default : 5s)-->
<div id="demo" class="carousel slide mb-5" data-ride="carousel" data-interval="6000">
	<ul class="carousel-indicators">
		<!-- data-target : 슬라이드 이미지가 보여질 박스 지정 , data-slide-to : 몇번째 슬라이드인지 지정 , active : 현재 보여지고 있는 이미지 li -->
		<li data-target="#demo" data-slide-to="0" class="active"></li>
		<li data-target="#demo" data-slide-to="1"></li>
		<li data-target="#demo" data-slide-to="2"></li>
	</ul>
	
	<!-- 각각의 이미지가 담긴 박스 -->
	<div class="carousel-inner">
		<div class="carousel-item active">
			<img src="images/4.jpg" alt="glasses" width="1100" height="500" />
		</div>
		
		<div class="carousel-item text-dark">
			<img src="images/5.jpg" alt="shirt" width="1100" height="500" />
		</div>
		
		<div class="carousel-item text-dark">
			<img src="images/6.jpg" alt="tee" width="1100" height="500" />
		</div>
	</div>
	
	<a href="#demo" class="carousel-control-prev" data-slide="prev">
		<span class="carousel-control-prev-icon text-dark"></span>
	</a>
		<a href="#demo" class="carousel-control-next" data-slide="next">
		<span class="carousel-control-next-icon text-dark"></span>
	</a>
	
</div>

</body>
</html>