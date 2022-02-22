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
<title>MAIN PAGE</title>
</head>

<body>

<h3>로그인 성공시 설정한 세션의 이름과 속성 값</h3>
<hr />

<%
	/*
	*	Enumeration : 컬렉션에 저장된 여러개의 데이터(객체)를 저장하였다가, 저장된 데이터를 하나씩 불러와서 지정한 동작을 수행
	*	각기 다른 타입의 데이터를 저장할 수 있으며, 특정 타입을 제네릭으로 지정할 수 있다.
	*/
	Enumeration<String> names = session.getAttributeNames();
	
	// hasMoreElements() : Enumeration에 저장된 객체가 있는지를 boolean type return
	while( names.hasMoreElements() ) {
		// nextElement() : Enumeration에 저장된 객체를 순서대로 하나씩 불러온다.
		String name = names.nextElement().toString();
	
		// getAttribute() : session의 name으로 value 값을 불러오고, 반환 타입이 Object이므로 casting하여 사용
		String value = (String)session.getAttribute(name);
		
		if( value.equals("abcde") ) {
			out.println(value + "님 안녕하세요." + "<br />");
		}
 	}
%>
<br />
<a href="logout.jsp">로그 아웃</a>
</body>
</html>