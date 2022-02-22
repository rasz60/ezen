package com.wvwv.ch20_ex01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//DBCP를 이용하는 DAO
public class DbcpDAO {
	//DataSource : DBCP에서 Connection 객체를 만드는데 사용할 인터페이스의 객체 선언
	private DataSource dataSource;
	
	public DbcpDAO () {
		try {
			// 이름으로 객체를 찾아주는 인터페이스
			// InitialContext는 Context 인터페이스를 Implements한 클래스
			Context context = new InitialContext();
			
			//context.lookup(클래스명) : 찾고자 하는 클래스의 객체를 생성하여 반환
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<MemberDTO> memberSelect() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		
		try {
			// dataSource 객체로 Connection 클래스 객체를 얻어오는걸 제외하고 동일하게 진행
			con = dataSource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM member01");
			
			while ( rs.next() ) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				MemberDTO dto = new MemberDTO(id, pwd, name, phone);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if ( rs != null ) {
					rs.close();
				} 
				
				if ( stmt != null ) {
					stmt.close();
				}
				
				if ( con != null ) {
					con.close();
				}
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
		}
		return dtos;
	}
	
}
