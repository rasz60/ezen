<!-- 
	@ page 속성="value" : JSP 페이지 내에 속성을 지정하는 지시자
 	  import="class path" : jsp 파일에 해당 package혹은 class를 import 
-->
<%@ page import="java.util.Arrays" %>
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
<title>JSP 지시자 page</title>
</head>

<body>

<div class="container">
	<h3>page 지시자</h3>
	<hr />
	<%
		int[] iArr = {10, 20, 30};
		out.println("iArr = " + Arrays.toString(iArr));
		// java.util.Arrays toString() 메서드를 사용하기 위해서는 jsp파일에 import 필요 (java.lang 외에 패키지는 import 필요)
	%>
</div>
</body>
</html>