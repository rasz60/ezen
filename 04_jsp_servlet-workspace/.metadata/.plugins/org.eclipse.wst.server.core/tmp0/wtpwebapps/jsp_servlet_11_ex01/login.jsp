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
<title>로그인 처리</title>
</head>

<body>

<%!
	String id, pwd;
%>

<%
	id = request.getParameter("id");
	pwd = request.getParameter("pwd");
	
	if ( id.equals("abcde") && pwd.equals("12345") ) {
		// 응답이 끝나면 소멸되는 정보를 Cookie 객체에 저장하여 사용한다(max-size : 4kb)
		// Cookie 객체의 name/value를 매개변수로 넣어줌 ("name", "value")
		Cookie cookie = new Cookie("id", id);
		cookie.setMaxAge(60); // 최대 유지시간 60초로 지정
		response.addCookie(cookie); // response 객체에 쿠키를 등록
		response.sendRedirect("welcome.jsp");
	} else {
		response.sendRedirect("login.html");
	}
	
	// javaScript의 cookie 접근을 막으려면, cookie.setHttpOnly(true) 메서드 사용
%>


</body>
</html>