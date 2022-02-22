<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<%!
	String id, pwd, pwdCheck, name, email, phoneNum;
%>

<%
	id = request.getParameter("id");
	pwd = request.getParameter("pwd");
	pwdCheck = request.getParameter("pwdCheck");
	name = request.getParameter("name");
	email = request.getParameter("email") + "@" + request.getParameter("domain");
	phoneNum = request.getParameter("phoneNumber1")+request.getParameter("phoneNumber2")+request.getParameter("phoneNumber3");		
	
	if (! pwd.equals(pwdCheck) ) {
%>
		<script>
			alert("비밀번호 확인란에 입력한 내용이 비밀번호와 일지하지 않습니다.");
			history.go(-1);
		</script>
<%
	} else {
%>
		<jsp:forward page="main.jsp"/>
<% 	} %>
