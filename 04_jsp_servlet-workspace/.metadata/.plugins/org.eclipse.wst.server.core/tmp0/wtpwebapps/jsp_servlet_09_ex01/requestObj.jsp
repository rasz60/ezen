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
<title>request 객체의 정보관련 메서드</title>
</head>

<body>

<div class="container">
	<h3>request 객체의 메서드들</h3>
	
	<%
		out.println(
					"서버 : " + request.getServerName() + "<br />" +
					"포트번호 : " + request.getServerPort()  + "<br />" +
					"요청방식 : " + request.getMethod()  + "<br />" +
					"프로토콜 : " + request.getProtocol()  + "<br />" +
					"URL : " + request.getRequestURL() + "<br />" + // request한 URL 전체 경로
					"URI : " + request.getRequestURI() + "<br />" + // request한 URL의 port번호 이후 경로
					"Query : " + request.getQueryString()
					);
	%>
</div>
</body>
</html>