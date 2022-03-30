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

</head>

<body>

<h3 class="mt-2 mx-2">자바스크립트로 사용자 입력 및 대화</h3>
<hr />

<button type="button" class="btn btn-sm btn-primary">프롬포트 다이얼로그</button>
<button type="button" class="btn btn-sm btn-success">확인 다이얼로그</button>
<button type="button" class="btn btn-sm btn-danger">경고 다이얼로그</button>


<script>
$('.btn-primary').click(function() {
	prompt('입력 창');
});

$('.btn-success').click(function() {
	confirm('확인 창');
});

$('.btn-danger').click(function() {
	alert('경고 창');
});

</script>


</body>
</html>