package com.wvwv.ch23ex01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.wvwv.ch23ex01.dto.TicketDto;

@Component
public class TicketDao {

	JdbcTemplate template;
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		System.out.println("JdbcTemplate Construct()");
		
		this.template = template;
	}
	
	TransactionTemplate transactionTemplate;
	@Autowired
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		System.out.println("TransactionTemplate Construct()");
		
		this.transactionTemplate = transactionTemplate;
	}
	
	public TicketDao(JdbcTemplate template, TransactionTemplate transactionTemplate) {
		System.out.println("DAO Construct()");
		
		this.template = template;
		this.transactionTemplate = transactionTemplate;
	}

	public void buyTicekt(TicketDto dto) {
		System.out.println("buyTicekt logging");
		
		//transactionTemplate의 execute()를 실행하면 commit, rollback 자동 실행
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				System.out.println("doInTransactionWithoutResult logging");
				
				template.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						System.out.println("createPreparedStatement Ticket logging");
						
						String query = "INSERT INTO ticket (consumerId, countNum) VALUES (?, ?)";
						
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, dto.getConsumerId());
						pstmt.setInt(2, dto.getAmount());
						
						return pstmt;
					}
				});
				
				template.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						System.out.println("createPreparedStatement Card logging");
						
						String query = "INSERT INTO card (consumerId, amount) VALUES (?, ?)";
						
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, dto.getConsumerId());
						pstmt.setInt(2, dto.getAmount());
						
						return pstmt;
					}
				});
			}
			
		});		
	}
	
	
	
}
