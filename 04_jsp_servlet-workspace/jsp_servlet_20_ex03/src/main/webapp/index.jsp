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
<title>JSP 내부객체를 EL로 사용하기</title>
</head>

<body>

<h3>JSP 내부객체용 FORM</h3>
<hr />

<form action="objelOK.jsp" method="post">
	아이디 : <input type="text" name="id" /><br />
	비밀번호 : <input type="password" name="pwd" /><br />
	<input type="submit" value="login" />
</form>

<%
	// 각각의 범위에 해당하는 객체에 이름과 값 속성을 설정
	application.setAttribute("application_name", "application_value");	
	session.setAttribute("session_name", "session_value");
	
	// page 범위 객체에 속성을 지정할 때는 pageContext를 쓰며, 해당 페이지를 벗어나면 설정한 값이 사라진다.
	pageContext.setAttribute("page_name", "page_value");	
	
	// request는 해당 요청에 대한 동작이 끝나고 나면 설정한 값이 사라진다.
	request.setAttribute("request_name", "request_value");
%>

</body>
</html>