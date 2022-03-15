package com.ezen.mini.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ezen.mini.HomeController;
import com.ezen.mini.dto.JoinDto;

@Component
public class MiniDao implements IDao {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public String join(JoinDto dto) {
		logger.info("join() in >>>>");
		
		int res = sqlSession.insert("join", dto);
		System.out.println(res);
		String result = null;
				
		if ( res > 0 ) {
			result = "success";
		} else {
			result = "failed";
		}
		
		logger.info("join() out >>>>");
		
		return result;
	}

}
