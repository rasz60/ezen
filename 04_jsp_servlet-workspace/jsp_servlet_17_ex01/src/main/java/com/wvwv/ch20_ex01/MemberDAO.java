package com.wvwv.ch20_ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String uid = "scott";
	private String upw = "tiger";
	
	public MemberDAO() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MemberDTO> memberSelect() {
		
		//MemberDTO 객체를 원소로 갖는 ArrayList 객체 dtos 생성
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		
		try {
			con = DriverManager.getConnection(url, uid, upw);
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
