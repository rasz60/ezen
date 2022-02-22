package com.wvwv.ch21ex01.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.wvwv.ch21ex01.DTO.BDTO;
import com.wvwv.ch21ex01.util.Constant;

public class BDAO {

	JdbcTemplate template;
	
	public BDAO() {
		this.template = Constant.template;
	}
	
	public ArrayList<BDTO> list() {
		String query = "SELECT * FROM mvc_board ORDER BY bgroup DESC, bindent ASC";
		
		ArrayList<BDTO> dtos = (ArrayList<BDTO>)template.query(query, new BeanPropertyRowMapper<BDTO>(BDTO.class));
	
		return dtos;
	}
	
	// 메서드 내에 선언된 내부 클래스에서 사용할 파라미터는 final로 선언한다.
	public void write(final String bName, final String bTitle, final String bContent) {

		// update(new PreparedStatementCreator()) => PreparedStatementCreator 내부 클래스에 Override 메서드를 구현하여 update 처리
		this.template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "INSERT INTO mvc_board(bid, bname, btitle, bcontent, bhit, bgroup, bstep, bIndent) "
								+ "VALUES(mvc_board_seq.nextVal, ?, ?, ?, 0, mvc_board_seq.currVal, 0, 0)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				
				return pstmt;
			}
		});	
	}
}
