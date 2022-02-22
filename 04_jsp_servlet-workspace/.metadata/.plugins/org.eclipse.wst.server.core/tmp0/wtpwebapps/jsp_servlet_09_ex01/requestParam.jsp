<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays" %>
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
<title>Parameter 처리 메서드들</title>
</head>

<body>

<%!
	String name, id, pwd, major, protocol;
	String[] hobbys;
%>

<%
	request.setCharacterEncoding("UTF-8");

	name = request.getParameter("name");
	id = request.getParameter("id");
	pwd = request.getParameter("pwd");
	hobbys = request.getParameterValues("hobby");
	major = request.getParameter("major");
	protocol = request.getParameter("protocol");
%>

이름 : <%= name %> <br />
아이디 : <%= id %> <br />
비밀번호 : <%= pwd %> <br />
취미 : <%= Arrays.toString(hobbys) %> <br />
전공 : <%= major %> <br />
프로토콜 : <%= protocol %> <br />

</body>
</html>