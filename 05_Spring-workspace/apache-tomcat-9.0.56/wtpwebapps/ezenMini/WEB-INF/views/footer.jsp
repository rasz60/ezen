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
footer {
	height: auto;
	background-color: #f2f2f2;
	padding: 25px;	
}

.footer-title {
	font-style: italic;
}

</style>
</head>

<body>

<footer class="mt-5">
	<div class="container">
		<h6 class="text-center display-4 footer-title mb-3">Online Store Copyright</h6>

		<form action="#" method="post" class="footer-frm row">
			<div class="formgroup col-11">
				<label for="email">&nbsp;&nbsp;Get deals</label>
				<input type="text" class="form-control" id="email" placeholder="Enter email" />
			</div>
			
			<button type="submit" class="btn btn-danger col-1">Sing Up</button>
		</form>
	</div>
</footer>

</body>
</html>