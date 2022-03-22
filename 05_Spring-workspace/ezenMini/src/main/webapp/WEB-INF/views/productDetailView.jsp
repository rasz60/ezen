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

img.img-responsive {
	margin: 0px auto;
}

#rContent {
	resize: none;
}
</style>
</head>

<body>
<div class="container mt-5">
	<div class="row">
		<div class="col-sm-6 text-center">
			<img src="images/${productView.rPhoto }" alt="image" class="img-responsive" style="max-width: 100%; height: 500px;" />
		</div>
		
		<div class="col-sm-6">
			<div class="form-group row mx-0">
				<label for="rCuisine" class="col-3 mt-2">요리 구분</label>
				<input type="text" id="rCuisine" class="form-control bg-light col-9" readonly="readonly" value="${productView.rCuisine }"/>
			</div>
			
			<div class="form-group row mx-0">
				<label for="rName" class="col-3 mt-2">식당명</label>
				<input type="text" id="rName" class="form-control bg-light col-9" readonly="readonly" value="${productView.rName }"/>
			</div>
			
			<div class="form-group row mx-0">
				<label for="rCuisine" class="col-3 mt-2">요리명</label>
				<input type="text" id="rCuisine" class="form-control bg-light col-9" readonly="readonly" value="${productView.rTitle }"/>
			</div>

			<div class="form-group row mx-0">
				<label for="rCuisine" class="col-3 mt-2">가격</label>
				<input type="text" id="rCuisine" class="form-control bg-light col-9" readonly="readonly" value="10,700원"/>
			</div>
			
			<div class="form-group row mx-0">
				<label for="rContent">&nbsp;&nbsp;&nbsp;요리 설명</label>
				<textarea id="rContent" rows="5" class="form-control bg-light" readonly="readonly">${productView.rContent }</textarea>
			</div>
			<hr />

			<form action="#" method="post">
				<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
				<input type="hidden" name="rPhoto" value="${productView.rPhoto }" />
				<div class="form-group row mx-0">
					<label for="uOrder" class="col-3 mt-2">주문 수량</label>
					<input type="Number" class="form-control col-9" id="uOrder" name="quantity" min="1" max="5"/>
				</div>
				<div class="row justify-content-between">
					<button type="submit" class="btn btn-info border-white col-4">주문하기</button>
					<button type="reset" class="btn btn-danger border-white col-4">주문 수량 초기화</button>
					<a href="product" class="btn btn-dark border-white col-4">목록으로</a>
				</div>
			</form>
		</div>
		<br /><hr />
	</div>
</div>

</body>
</html>