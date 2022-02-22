<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
	String id, pwd;
%>

<%
	id = request.getParameter("id");
	pwd = request.getParameter("pwd");
	
	if ( id.equals("abcde") && pwd.equals("12345") ) {
		// value값은 어떤 자료형의 값이 와도 상관없음 (Object로 받음)
		session.setAttribute("id", id);
%>
	<script>
		alert("로그인 성공.");
		location.href = "welcome.jsp";
	</script>
<%
	} else {
%>

	<script>
		alert("로그인 실패.");
		location.href = "login.html";
	</script>
<%  } %>