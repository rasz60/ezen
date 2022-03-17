package com.ezen.mini.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.mini.dto.BoardDto;
import com.ezen.mini.dto.JoinDto;

@Repository
public class MiniDao implements IDao {

	private static final Logger logger = LoggerFactory.getLogger(MiniDao.class);

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public String join(JoinDto dto) {
		logger.info("join(" + dto + ") in >>>>");
		
		int res = sqlSession.insert("join", dto);
		System.out.println(res);
		String result = null;
				
		if ( res > 0 ) {
			result = "success";
		} else {
			result = "failed";
		}
		
		logger.info("join(" + dto + ") result : " + res);
		
		return result;
	}

	@Override
	public JoinDto login(String username) {
		logger.info("login(" + username + ") in >>>>");
		JoinDto dto = sqlSession.selectOne("login", username);
		
		logger.info("login(" + username + ") result : " + dto.getPid() + " loged in");
		return dto;
	}

	@Override
	public ArrayList<BoardDto> list() {
		logger.info("list() in >>>>");
		
		ArrayList<BoardDto> result = (ArrayList)sqlSession.selectList("list");
		
		logger.info("list() result.isEmpty() ? " + result.isEmpty());
		return result;
	}

	@Override
	public void write(String bName, String bTitle, String bContent) {
		logger.info("write() in >>>>");
		
		logger.info("parameterCheck : " + bName + " / " + bTitle + " / " + bContent);
		
		BoardDto dto = new BoardDto(bName, bTitle, bContent);
		
		int res = sqlSession.insert("write", dto);
		
		logger.info("write() result : " + (res == 1 ? "success" : "failed"));
	}

}
