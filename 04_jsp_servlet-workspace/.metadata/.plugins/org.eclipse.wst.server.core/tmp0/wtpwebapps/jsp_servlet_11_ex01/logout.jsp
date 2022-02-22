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
<title>로그아웃시 쿠키처리</title>
</head>

<body>

<%
	Cookie[] cookies = request.getCookies();
	
	if ( cookies != null ) {
		for ( Cookie c : cookies ) {
			// 유효시간을 0으로 바꾸면 삭제 됨
			c.setMaxAge(0);

			// 유효시간이 0이 된 cookie를 응답하여 client에서도 삭제
			response.addCookie(c);
		}
	}
%>
<script>
$(document).ready(function() {
	alert(document.cookie);
	// client에서는 document 안에 cookie 객체로 jsp와 동일한 name과 value로 저장되어 있음.
});
</script>
</body>
</html>