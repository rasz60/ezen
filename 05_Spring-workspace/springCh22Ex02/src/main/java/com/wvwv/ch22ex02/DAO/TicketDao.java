package com.wvwv.ch22ex02.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.wvwv.ch22ex02.HomeController;
import com.wvwv.ch22ex02.DTO.TicketDto;

@Component
public class TicketDao {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	JdbcTemplate template;

	// Transaction을 처리하는 객체
	@Autowired
	PlatformTransactionManager transactionManager;

	public TicketDao(JdbcTemplate template, PlatformTransactionManager transactionManager) {
		logger.info("TicketDaoConst()-----------------------------");
		
		this.template = template;
		this.transactionManager = transactionManager;
	}
	
	public void buyTicket(final TicketDto dto) {
		// Transaction : 해당 절차에 따라 작업이 끝까지 완료되면 insert, 중단되면 rollback하는 역할
		
		// Transaction 객체
		TransactionDefinition definition = new DefaultTransactionDefinition();
		
		// Transaction으로 정의된 값을 가져온다.
		TransactionStatus status = transactionManager.getTransaction(definition);
		
		try {
			template.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					String cardSql = "INSERT INTO card (consumerID, amount) VALUES (?, ?)";
					PreparedStatement pstmt = con.prepareStatement(cardSql);
					pstmt.setString(1, dto.getConsumerId());
					pstmt.setInt(2, dto.getAmount());
					
					return pstmt;
				}
			});
			
			logger.info("InsertCard Done // InsertTicket Start---------------------");
			
			template.update(new PreparedStatementCreator() {
				
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					String ticketSql = "INSERT INTO ticket (consumerID, countNum) VALUES (?, ?)";
					PreparedStatement pstmt = con.prepareStatement(ticketSql);
					pstmt.setString(1, dto.getConsumerId());
					pstmt.setInt(2, dto.getAmount());
					
					return pstmt;
				}
			});
			// update가 성공하면 커밋
			transactionManager.commit(status);
		} catch (Exception e) {
			e.printStackTrace();
			// update가 실패하면 롤백
			transactionManager.rollback(status);
		} 
		
	}
	
	

}
