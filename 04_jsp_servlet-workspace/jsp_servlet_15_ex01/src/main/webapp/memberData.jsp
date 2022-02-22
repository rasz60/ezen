<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- java.sql 패키지에 있는 필요한 클래스와 변수 선언 --%>
<%@ page import="java.sql.Connection"
		 import="java.sql.Statement"
		 import="java.sql.ResultSet"
		 import="java.sql.DriverManager"
%>

<%!
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	
	//oracle driver class path
	String driver = "oracle.jdbc.driver.OracleDriver";
	
	//oracle driver connection info : url : oracle server 접속 경로 / uid/upw : oracle account info
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "scott";
	String upw = "tiger";
	
	// DB 서버로 보낼 sql문
	String query = "select * from member01";
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
<title>JDBC</title>
</head>

<body>

<h3>JDBC를 이용한 데이터베이스 처리</h3>
<%
	try {
		//forName("path") : Class에 있는 해당 클래스를 찾아서 메모리에 로드
		Class.forName(driver);
	
		// DriveManager.getConnection(url, id, pw) : 해당 주소에 해당 계정으로 접속함
		connection = DriverManager.getConnection(url, uid, upw);
		
		//connection.createStatement() : DB서버로 보낼 sql문을 만들어 저정할 객체 생성
		statement = connection.createStatement();
		
		// statement.executeQuery/Update(query) : DB서버에서 나온 결과를 resultSet에 저장하는 메서드
		// [executQuery : SELECT문, resultSet 객체 반환 / executeUpdate : 이외 DML 명령어, 정수 값으로(true/false) 반환]
		resultSet = statement.executeQuery(query);
		
		// resultSet.next() : resultSet에 저장된 결과를 객체로 하나씩 불러옴
		while( resultSet.next() ) {
			
			// getString("colName") : 결과 값에서 해당 칼럼명의 value를 String형태로 가져옴 [자료형에 따라 getInt/String 사용]
			String id = resultSet.getString("id");
			String pwd = resultSet.getString("pwd");
			String name = resultSet.getString("name");
			String phone = resultSet.getString("phone");
			
			out.println("id : " + id + " / " + "pwd : " + pwd + " / " + "name : " + name + " / " + "phone : " + phone +" / <br />");
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		
		// resultSet, statement, connection을 모든 작업 종료 후 종료해준다.
		try {
			if ( resultSet != null ) {
				resultSet.close();
			}
			
			if ( statement != null ) {
				statement.close();
			}
			
			if ( connection != null ) {
				connection.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
%>
</body>
</html>