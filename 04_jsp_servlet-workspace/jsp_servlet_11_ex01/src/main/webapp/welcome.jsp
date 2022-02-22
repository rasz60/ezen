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
<title>로그인 성공시 쿠키 처리</title>
</head>

<body>

<%
	Cookie[] cookies = request.getCookies();
	// 쿠키는 여러 개를 저장할 수 있으므로, 배열로 get
	for( int i = 0 ; i < cookies.length; i++ ) {
		String id = cookies[i].getValue();
		if ( id.equals("abcde") ) {
			out.println(id + "님 안녕하세요." + "<br />");
		}
		out.println(id);
	}
%>
<br />
<a href="logout.jsp">로그아웃</a>

<script>
$(document).ready(function() {
	alert(document.cookie);
	// client에서는 document 안에 cookie 객체로 jsp와 동일한 name과 value로 저장되어 있음.
});
</script>
</body>
</html>