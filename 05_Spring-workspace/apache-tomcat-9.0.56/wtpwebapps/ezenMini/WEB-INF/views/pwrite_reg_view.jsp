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
<title>Cuisine Register</title>
<style>
#content {
	resize: none;
}
</style>
</head>

<body>

<div class="container mt-5">
	<h3 class="display-4 font-italic">Register</h3>
	<hr />
	
	<!-- file 전송 시에는 action url에 parameter로 _csrf를 전달 -->
	<form action="product_write?${_csrf.parameterName }=${_csrf.token}" method="post" enctype="multipart/form-data">
		<br />
		<p class="h5 font-italic">요리 구분</p>
		<hr />
		<div class="form-check-inline">
			<input type="radio" class="form-check-input" id="radio1" name="rCuisine" value="Korean" checked/>
			<label for="radio1" class="form-checklabel">한식</label>
		</div>
	
		<div class="form-check-inline">
			<input type="radio" class="form-check-input" id="radio2" name="rCuisine" value="Japanese" />
			<label for="radio2" class="form-checklabel">일식</label>
		</div>

		<div class="form-check-inline">
			<input type="radio" class="form-check-input" id="radio3" name="rCuisine" value="Chinese" />
			<label for="radio3" class="form-checklabel">중식</label>
		</div>
		
		<div class="form-check-inline">
			<input type="radio" class="form-check-input" id="radio4" name="rCuisine" value="Euroupean" />
			<label for="radio4" class="form-checklabel">양식</label>
		</div>

		<br /><br /><hr />
		<div class="form-group">
			<p class="h5 font-italic">식당명</p>
			<hr />
			<input type="text" class="form-control" id="rName" placeholder="식당명" name="rName" required />
		</div>

		<br /><hr />
		<div class="form-group">
			<p class="h5 font-italic">요리명</p>
			<hr />
			<input type="text" class="form-control" id="title" placeholder="요리명" name="rTitle" required />
		</div>
		
		<br /><hr />
		<div class="form-group">
			<p class="h5 font-italic">사진</p>
			<hr />
			<input type="file" class="form-control" id="photo" name="rFile" required />
		</div>
		
		<br /><hr />
		<div class="form-group">
			<p class="h5 font-italic">요리설명</p>
			<hr />
			<textarea class="form-control" id="content" placeholder="요리 설명" name="rContent" rows=10 required ></textarea>
		</div>
		
		<button type="submit" class="btn btn-sm btn-secondary float-right">등록</button>
		<br />
	</form>
</div>

</body>
</html>