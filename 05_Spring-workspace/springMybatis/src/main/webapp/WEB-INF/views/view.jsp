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
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	  integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	  crossorigin="anonymous"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>MyBatis Write-form</title>
</head>

<body>
<div class="container mt-3">
<h3>Write Form</h3>
	<form action="write" method="post">
		<div class="form-group">
			<label for="mWriter">작성자</label>
			<input type="text" name="mWriter" id="mWriter" size="15" class="form-control" />
		</div>
		
		<div class="form-group">
			<label for="mContent">내용</label>
			<input type="text" name="mContent" id="mContent" size="150" class="form-control" />
		</div>
		<div class="form-group d-flex justify-content-end">
			<input type="submit" value="입력" class="btn btn-sm btn-primary mr-2" />
			<a href="list"><button class="btn btn-sm btn-success mr-2">목록보기</button></a>
			<a href="#"><button class="btn btn-sm btn-danger mr-2">Ticket Transaction</button></a>	
		</div>
	</form>
</div>



</body>
</html>