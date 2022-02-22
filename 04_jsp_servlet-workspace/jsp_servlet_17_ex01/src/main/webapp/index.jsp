<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ 
	page import="com.wvwv.ch20_ex01.MemberDAO" 
		 import="com.wvwv.ch20_ex01.MemberDTO"
		 import="com.wvwv.ch20_ex01.DbcpDAO"
		 import="java.util.ArrayList"
%>
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
<title>DAO / DTO의 index 파일</title>
</head>

<body>

<h3>DAT / DTO 클래스 사용 </h3>
<hr />
<%
	DbcpDAO dbcpDAO = new DbcpDAO();

	ArrayList<MemberDTO> members = dbcpDAO.memberSelect();
	
	for( int i = 0; i < members.size(); i++ ) {
		MemberDTO member = members.get(i); // get(idx) : ArrayList의 원소를 반환하는 메서드
		
		String id = member.getId();
		String pwd = member.getPwd();
		String name = member.getName();
		String phone = member.getPhone();
		
		out.println("이름 :" + name + " / 아이디 : " + id + " / 비밀번호 : " + pwd + " / 전화번호 : " + phone + " / <br />");
	}
%>
</body>
</html>