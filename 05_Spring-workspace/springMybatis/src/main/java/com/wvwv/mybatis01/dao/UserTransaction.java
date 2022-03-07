package com.wvwv.mybatis01.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wvwv.mybatis01.dto.TicketDTO;

@Service
@Transactional
public class UserTransaction {
	public boolean transactionEx(ContentDao dao, TicketDTO dto) {
		dao.writeCard(dto);
		dao.writeTicket(dto);
		
		// 둘 중 하나라도 실패하면 rollback시킨다.
		return true;
	}

}
