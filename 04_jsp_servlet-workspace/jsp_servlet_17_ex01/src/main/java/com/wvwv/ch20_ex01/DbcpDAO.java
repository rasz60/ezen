package com.wvwv.ch20_ex01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//DBCP�� �̿��ϴ� DAO
public class DbcpDAO {
	//DataSource : DBCP���� Connection ��ü�� ����µ� ����� �������̽��� ��ü ����
	private DataSource dataSource;
	
	public DbcpDAO () {
		try {
			// �̸����� ��ü�� ã���ִ� �������̽�
			// InitialContext�� Context �������̽��� Implements�� Ŭ����
			Context context = new InitialContext();
			
			//context.lookup(Ŭ������) : ã���� �ϴ� Ŭ������ ��ü�� �����Ͽ� ��ȯ
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
			// dataSource ��ü�� Connection Ŭ���� ��ü�� �����°� �����ϰ� �����ϰ� ����
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
