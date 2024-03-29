package com.wvwv.jspMVC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.wvwv.jspMVC.DTO.BDto;

public class BDao {
	//DBCP 사용  : DAO를 통해 DB 접속량과 제어권을 정의
	DataSource dataSource;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
		
	// server context.xml에 설정된 DBCP 정보에서 지정한 값을 lookup하여 context 객체에 저장한 후 dataSource객체에 대입하여 DBCP 생성
	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 게시판 처리에 필요한 게시판 내용 만들기(insert), 게시판 내용보기(select) 수정, 삭제 등
	public int write(String bName, String bTitle, String bContent) {
		int result = -1;
		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO mvc_board(bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) VALUES(mvc_board_seq.NEXTVAL, ?, ?, ?, 0, mvc_board_seq.CURRVAL, 0, 0)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public List<BDto> list() {
		List<BDto> boardList = new ArrayList<BDto>();
		
		try {
			String sql = "SELECT * FROM MVC_BOARD ORDER BY bId DESC, bStep ASC";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			while( rs.next() ) {
				// rs.next를 BDto 객체로 저장
				BDto bDto = new BDto();
				
				bDto.setbId(rs.getInt("bId"));
				bDto.setbName(rs.getString("bName"));
				bDto.setbTitle(rs.getString("bTitle"));
				bDto.setbContent(rs.getString("bContent"));
				bDto.setbDate(rs.getTimestamp("bDate"));
				bDto.setbHit(rs.getInt("bHit"));
				bDto.setbGroup(rs.getInt("bGroup"));
				bDto.setbStep(rs.getInt("bStep"));
				bDto.setbIndent(rs.getInt("bIndent"));
				
				boardList.add(bDto);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if ( rs != null ) {
					rs.close();
				}
				
				if ( pstmt != null ) {
					pstmt.close();
				}
				
				if ( conn != null ) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return boardList;
	}
}
