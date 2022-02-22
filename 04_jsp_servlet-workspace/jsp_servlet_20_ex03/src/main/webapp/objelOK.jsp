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
<title>Param 객체</title>
</head>

<body>

<h3>form의 파라메터 처리 객체 [getParameter()]</h3>
<hr />

<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
%>

아이디 : <%= id %><br />
비밀번호 : <%= pwd %><br />
<br /><br />

<h3>form의 파라메터 처리 객체 [param]</h3>
<hr />
<!-- param : request로 넘어오는 모든 파라메타를 모아놓은 객체 -->
아이디 : ${param.id}<br />
비밀번호 : ${param.pwd}<br />
<br /><br />

<h3>form의 파라메터 처리 객체 [XXXScope]</h3>
<hr />
<!-- xxxScope : 사용 범위(scope)별로 구분하여 객체를 저장하였다가 불러옴 -->
applicationScope : ${applicationScope.application_name}<br />
sessionScope : ${sessionScope.session_name}<br />
pageScope : ${pageScope.page_name}<br />
requestScope : ${requestScope.request_name}<br />
<br /><br />

<h3>form의 파라메터 처리 객체 [initParam]</h3>
<hr />
<!-- initParam : web.xml에서 설정한 initParam을 출력 -->
${initParam.con_name}<br />
${initParam.con_id}<br />
${initParam.con_pwd}<br />


</body>
</html>