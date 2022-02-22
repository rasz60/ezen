<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- isErrorPage="true" : 해당 페이지가 예외 처리 페이지임을 선언 --%>
<%@ page isErrorPage="true" %>

<%-- setStatus(200) : 에러가 발생해서 넘어오지만 해당 페이지의 응답 상태를 정상 상태로 처리 --%>
<% response.setStatus(200); %>

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
<title>예외 처리 페이지</title>
</head>

<body>

<h3>예외 처리 페이지</h3>
<hr />

<!-- exception은 jsp 내장 객체로 예외가 발생했을 때 자동 생성되며, getMessage()로 발생한 예외 내용을 알 수 있다. -->
<%=	exception.getMessage() %>
</body>
</html>