package com.wvwv.sslex01.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wvwv.sslex01.dto.JoinDto;

@Repository
public class MemberDao implements MemberIDao {
	@Autowired
	private SqlSession sqlSession;
	
	public String join(JoinDto dto) {
		int res = sqlSession.insert("join", dto);

		String result = res > 0 ? "success" : "failed";	
		
		return result;
	}

	public JoinDto login(String pId) {
		System.out.println(pId);
		JoinDto dto = sqlSession.selectOne("login", pId);
		
		return dto;
	};
}
