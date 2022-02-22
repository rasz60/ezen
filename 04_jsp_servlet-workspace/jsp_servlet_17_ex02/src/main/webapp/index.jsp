<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%!
	Connection con;
	// java server에서 sql문을 Statement객체와 PreparedStatement 객체를 사용하여 전달할 수 있다.
	PreparedStatement preStmt;
	ResultSet rs;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "scott";
	String upw = "tiger";
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
<title>PreparedStatement 클래스 사용</title>
</head>

<body>


<h3>PreparedStatement 클래스 사용</h3>
<hr />

<%
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(url, uid, upw);
		
		// PreparedStatement sql문을 실행하면 결과는 정수 값을 반환한다. (SELECT 제외)
		int n = 0;

		// PreparedStatement 에 들어갈 query문에는 값이 들어갈 자리를 ?으로 처리
		String query = "INSERT INTO member01 (id, pwd, name, phone) VALUES (?, ?, ?, ?)";
		
		preStmt = con.prepareStatement(query);
		
		// preStmt.set[자료형](? idx, "value") : 지정한 번째로 등장하는 ? 자리에 들어갈 값을 설정
		preStmt.setString(1, "006");
		preStmt.setString(2, "123");
		preStmt.setString(3, "홍길동");
		preStmt.setString(4, "010-1234-5678");
		n = preStmt.executeUpdate();
		
		preStmt.setString(1, "007");
		preStmt.setString(2, "456");
		preStmt.setString(3, "홍길자");
		preStmt.setString(4, "010-9012-3456");
		n = preStmt.executeUpdate();
		
		preStmt.setString(1, "008");
		preStmt.setString(2, "789");
		preStmt.setString(3, "홍길순");
		preStmt.setString(4, "010-7890-1234");
		n = preStmt.executeUpdate();
		
		if ( n == 1 ) {
			out.println("Insert Successed.");
		} else {
			out.println("Insert failed.");
		}
		
	} catch (Exception e) {
		e.printStackTrace();	
	} finally {
		try {
			if ( preStmt != null ) {
				preStmt.close();
			}
			
			if ( con != null ) {
				con.close();
			}
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}
	}
%>
</body>
</html>