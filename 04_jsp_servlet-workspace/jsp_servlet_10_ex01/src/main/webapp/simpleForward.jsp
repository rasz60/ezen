<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>simpleforward.jsp</title>
</head>

<body>

<h1>simpleforward.jsp 페이지 입니다.</h1>
<jsp:forward page="sub.jsp"/>
<!-- 
	jsp:forward : 액션태그 forward를 사용하면 페이지를 강제로 이동시키며, URL은 현재 페이지 그대로 이동한다.
	response.getRedirect()는 client가 요청(request)에 따른 응답 반응이고, forward는 request/response 상관없이 서버에서 강제로 이동시킨다.
-->
</body>
</html>