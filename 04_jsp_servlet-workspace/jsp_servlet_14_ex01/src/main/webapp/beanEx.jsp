<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
  -- jsp:useBean : Bean을 사용하는 클래스임을 선언하는 액션 태그
  -- id="Bean의 이름" , class="객체 생성할 클래스 경로" , scope="사용 범위(page < request < session < application)"
  -- Student 클래스를 student라는 객체로 가져와 이 페이지에서 사용할 수 있게된다.
--%>
<jsp:useBean id="student" class="com.wvwv.ch16_ex01.Student" scope="page" />
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
<title>Bean 관련 액션 태그 사용</title>
</head>

<body>

<h3>Bean 관련 액션태그 사용</h3>
<hr />

<!-- 
  -- jsp:setProperty : useBean으로 가져온 객체에 속성 값을 부여
  -- name : bean 이름 (useBean에서 지정한 id 값)
  -- property : 해당 클래스의 속성 값으로 선언된 변수의 이름
  -- value : 해당 변수의 대입할 값 (문자열) 
 -->
<jsp:setProperty name="student" property="name" value="홍길동" />
<jsp:setProperty name="student" property="age" value="13" />
<jsp:setProperty name="student" property="grade" value="6" />
<jsp:setProperty name="student" property="studentNum" value="7" />

<!-- 
  -- jsp:getProperty : setProperty로 지정한 객체에 속성 값을 가져옴
  -- name : bean 이름 (useBean에서 지정한 id 값)
  -- property : 해당 클래스의 속성 값으로 선언된 변수의 이름
 -->
<h5>이름 : <jsp:getProperty name="student" property="name"/></h5>
<h5>나이 : <jsp:getProperty name="student" property="age"/></h5>
<h5>학년 : <jsp:getProperty name="student" property="grade"/></h5>
<h5>번호 : <jsp:getProperty name="student" property="studentNum"/></h5>
</body>
</html>