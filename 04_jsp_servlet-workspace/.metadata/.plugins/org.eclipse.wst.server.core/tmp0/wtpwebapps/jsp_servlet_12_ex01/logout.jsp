<%@ page import="java.util.Enumeration" %>
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
<title>Logout</title>
</head>

<body>

<h3>로그아웃 처리시는 해당 세션을 찾아서 제거한다.</h3>

<%
	Enumeration<String> names = session.getAttributeNames();
	while( names.hasMoreElements() ) {
		String name = names.nextElement().toString();
		String value = (String)session.getAttribute(name).toString();
		
		if ( value.equals("abcde") ) {
			session.removeAttribute("name");			
%>
	<script>
		alert("로그아웃했습니다.");
		location.href = "login.html";
	</script>
<%
		}
	}
%>
</body>
</html>