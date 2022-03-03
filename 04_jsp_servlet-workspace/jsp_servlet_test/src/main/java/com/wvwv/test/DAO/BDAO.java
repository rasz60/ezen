package com.wvwv.test.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.wvwv.test.DTO.BDTO;

public class BDAO {
	
	DataSource dataSource;
	
	public BDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BDTO> getBList() {
		ArrayList<BDTO> bDtos = new ArrayList<BDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM mvc_board ORDER BY bId DESC";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while ( rs.next() ) {
				BDTO bDto = new BDTO();
				bDto.setbId(rs.getInt("bId"));
				bDto.setbName(rs.getString("bName"));
				bDto.setbTitle(rs.getString("bTitle"));
				bDto.setbContent(rs.getString("bContent"));
				bDto.setbDate(rs.getTimestamp("bDate"));
				bDto.setbHit(rs.getInt("bHit"));
				bDto.setbGroup(rs.getInt("bGroup"));
				bDto.setbStep(rs.getInt("bStep"));
				bDto.setbIndent(rs.getInt("bIndent"));
				bDtos.add(bDto);
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if ( rs != null ) {
					rs.close();
				}
				
				if ( pstmt != null ) {
					pstmt.close();
				}
				
				if ( conn != null) {
					conn.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();				
			}
		}
		return bDtos;
	}
	
	
}
