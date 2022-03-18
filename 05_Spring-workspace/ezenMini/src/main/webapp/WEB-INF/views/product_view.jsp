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
<title>Insert title here</title>
<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#main {
	height: auto;
}

#pwrite_view {
	height: 40%;
}
</style>
</head>

<body>
<%@ include file="nav.jsp" %>
<%@ include file="carousel.jsp" %>

<div id="main" class="container mt-5">
	<div class="d-flex justify-content-between" id="title-box">
		<h3 class="display-4 font-italic">Cuisine</h3>
		<a href="pwrite_view" id="pwrite_view" class="btn btn-secondary mt-4">등록</a>
	</div>
	<hr />
	
	<div class="row mb-3">
		<c:forEach items="${productList }" var="dto">
			<div class="card" style="width:300px;">
				<h5>${dto.rCuisine }</h5>
				<img class="card-img-top" src="images/${dto.rPhoto }" alt="Card image" style="max-width:280px; height:280px;" />
				
				<div class="card-body">
					<p class="card-title h5 font-italic">${dto.rName}</p>
					<p class="card-title">${dto.rTitle}</p>
					
					<a href="productDetails?rPhoto=${dto.rPhoto}" class="pd btn btn-sm btn-default stretched-link">details...</a>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

<%@ include file="footer.jsp" %>

<script>
$(document).ready(function() {
	$('#pwrite_view').click(function(e) {
		e.preventDefault();
		
		$.ajax({
			url: "pwrite_view",
			type: "get",
			success : function(data) {
				$('#main').html(data);
			},
			error : function(data) {
				consol.log(data);
			}
		});
	});
	
	$('.pd').click(function(e) {
		e.preventDefault();
		
		$.ajax({
			url: $(this).attr('href'),
			type: 'get',
			success : function(data) {
				$('#main').html(data);
			},
			error : function(data) {
				consol.log(data);
			}
		});
	});
	
});
</script>
</body>
</html>