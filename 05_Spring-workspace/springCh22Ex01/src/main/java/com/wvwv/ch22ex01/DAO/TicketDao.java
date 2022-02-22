package com.wvwv.ch22ex01.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Component;

import com.wvwv.ch22ex01.HomeController;
import com.wvwv.ch22ex01.DTO.TicketDto;

@Component
public class TicketDao {
	
	@Autowired
	JdbcTemplate template;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public TicketDao(JdbcTemplate template) {
		logger.info("TicketDaoConst---------------------");

		this.template = template;
	}
	
	public void buyTicket(final TicketDto dto) {
		logger.info("InsertCard&ticekt start---------------------");

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
		
		logger.info("InsertCard&ticekt Done---------------------");
	}
	
}
