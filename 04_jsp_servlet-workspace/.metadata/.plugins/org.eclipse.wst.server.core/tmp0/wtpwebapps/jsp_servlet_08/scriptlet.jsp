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
<title>JSP scriptlet</title>
</head>

<body>

<div class="container">
	<h3>구구단 2단</h3>
	<hr />
	<!-- Scriptlet 작성 중간에 자바 코드가 아닌 문장이 나오면 분할 사용할 수 있다. -->
	
	<%
		int i = 0;
		while(true) {
			i++;
			// out : jsp에서 제공하는 PrintWriter 객체
			out.println("2 x " + i + " = " + (2*i) + "<br />" );
	%>
	
	_________________________<br />
	
	<%	
			if ( i >= 9 ) {
				break;
			}
		}
	%>
</div>
</body>
</html>