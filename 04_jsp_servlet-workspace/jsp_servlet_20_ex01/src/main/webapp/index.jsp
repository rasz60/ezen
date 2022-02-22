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
<title>EL(Expression Language)</title>
</head>

<body>

<h3>EL 사용법</h3>
<hr />
${10}<br />
${99.99}<br />
${"ABC"}<br />
${true}<br />
<br /><br />


<h3>EL 연산자 사용법</h3>
<hr />
1 + 2 = ${1 + 2}<br />
1 - 2 = ${1 - 2}<br />
1 * 2 = ${1 * 2}<br />
1 / 2 = ${1 / 2}<br />
10 % 2 = ${10 % 2}<br />
1 > 2 = ${1 > 2}<br />
1 < 2 = ${1 < 2}<br />
1 > 2 ? 1 : 2 = ${1 > 2 ? 1 : 2}<br />
(1 > 2) || (1 < 2) = ${(1 > 2) || (1 < 2)}<br />
(1 > 2) && (1 < 2) = ${(1 > 2) && (1 < 2)}<br />
</body>
</html>