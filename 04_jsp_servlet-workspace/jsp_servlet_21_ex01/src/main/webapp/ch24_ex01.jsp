<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>   
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
<title>JSTL</title>
</head>

<body>

<h3>JSTL CORE Lib</h3>
<hr />
<h4>c:set 변수 선언</h4>
<!-- c:set : var="NAME", value="value", [default="d_value"] 변수 선언 -->
<c:set var="varName" value="varValue" />↓<br />

<h4>c:out 출력</h4>
<!-- c:out : value="value" value값을 html로 출력 -->
<c:out value="${varName}" /><br />↓<br />

<h4>c:remove 변수 제거</h4>
<!-- c:remove : var="varName" 지정한 이름의 변수를 제거 -->
<c:remove var="varName" />↓<br />

<h4>c:remove 후 c:out</h4>
<c:out value="${varName}" /><br />

<h4>c:catch 예외 처리문</h4>
<!-- c:catch var="varName" /throw exception/ /c:catch : 예외발생가능한 문장을 c:catch로 감싸면 예외내용에 변수에 저장된다.-->
<c:catch var="exception"><%= 5/0 %></c:catch>
<p>'5 / 0'의 예외 내용 : <c:out value="${exception}"/></p>
<hr />

<h4>c:if 조건처리문</h4>
<!-- c:if test="validation" var="resultVarName" scope="scope" //true일 때 수행할 내용 /c:if -->
\${1+2 == 3} = 
<c:if test="${1+2 == 3}" var="result" scope="page" >
	<c:out value="${result}"/><br />
</c:if>

\${1+2 != 3} = 
<c:if test="${1+2 != 3}" var="result" scope="page">
	<c:out value="${result}"/><br />
</c:if>
<br /><br />

<h4>c:choose if-else if-else 처리문</h4>
<c:set var="name" value="홍길동" />
<!-- c:choose >
				 c:when test="Validation" //수행식 c:when ==> if - 무한개 생성 가능 
				 c:otherwise //수행식 c:otherwise			==> else - 1개 생성 가능
	 /c:choose
-->
<c:choose>
	<c:when test="${name eq '철수'}">철수 입니다.</c:when>
	<c:when test="${name eq '홍길동'}">홍길동 입니다.</c:when>
	<c:otherwise>이름이 일치하는 사람이 없습니다.</c:otherwise>
</c:choose>
<br /><br />

<h4>form을 이용한 c:choose</h4>
<c:choose>
	<%-- EL empty : 지정한 객체의 값이 비어있는지 확인하여 true / false 반환, 반대는 not empty --%>
	<c:when test="${empty param.name}">
	 <form>
	 	이름 : <input type="text" name="name" />
   	 		  <input type="submit" name="확인" />
	 </form>
	</c:when>
	
	<c:when test="${param.name == 'admin' }">
		관리자 작업
	</c:when>
	
	<c:when test="${param.name eq 'user' }">
		일반 사용자. 회원 ${param.name}
	</c:when>
	
	<c:when test="${param.name eq 'naver'}">
		<%-- c:redirect : 지정한 url로 이동 --%>
		<c:redirect url="https://www.naver.com" />
	</c:when>
	
	<c:otherwise>기타 작업</c:otherwise>
</c:choose>
<hr />

<h4>반복 처리 forEach</h4>
<!-- c:forEach
  -- var="변수명"   ==> 반복식의 결과를 저장하는 변수
  -- items="객체명" ==> 반복 작업을 수행할 대상이 될 객체명 (일반적으로 배열), 생략 가능
  -- begin / end  ==> 반복 작업의 횟수
  -- step 		  ==> begin 부터 end까지 반복이 한 번 끝났을 때, count값의 증감 조건
  -- varStatus="name"==> 반복식의 정보를 저장하는 변수 선언 (index, count, first, last) 
 -->
begin 0 / end 30 / step 3 result : 
<c:forEach var="fEach" begin="0" end="30" step="3" >
	${fEach}
</c:forEach>
<br /><br />

<h4>배열 변수를 이용한 반복문</h4>
<c:set var="arr" value="<%= new int[]{1, 2, 3, 4, 5}%>" />
\${arr} = 
<c:forEach items="${arr}" var="i">
	${i}
</c:forEach>
<hr />

</body>
</html>