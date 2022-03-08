package com.wvwv.mybatis01.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wvwv.mybatis01.dto.ContentDTO;
import com.wvwv.mybatis01.dto.TicketDTO;

@Component
public class ContentDao implements IDao {
	
	private final SqlSession sqlSession;
		
	@Autowired
	public ContentDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void writeDao(String mWriter, String mContent) {
		ContentDTO dto = new ContentDTO(0, mWriter, mContent);
		// insert query를 처리하는 SqlSession 메서드 insert.('method name or xml id', object)
		sqlSession.insert("writeDao", dto);
	}

	@Override
	public ArrayList<ContentDTO> listDao() {
		ArrayList<ContentDTO> result = (ArrayList)sqlSession.selectList("listDao");
		
		return result;
	}

	@Override
	public void deleteDao(String mId) {
		sqlSession.delete("deleteDao", Integer.parseInt(mId));
	}

	@Override
	public ArrayList<ContentDTO> viewDao(String mId) {
		ContentDTO result = sqlSession.selectOne("viewDao", Integer.parseInt(mId));
		ArrayList<ContentDTO> dtos = new ArrayList<ContentDTO>();
		dtos.add(result);
		
		return dtos;
	}
	
	@Override
	public void writeCard(TicketDTO dto) {
		sqlSession.insert("writeCard", dto);
	}

	@Override
	public void writeTicket(TicketDTO dto) {
		sqlSession.insert("writeTicket", dto);		
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	@Override
	public ArrayList<ContentDTO> selectTest(ArrayList<Integer> mId) {
		ArrayList<ContentDTO> result = (ArrayList)sqlSession.selectList("list", mId);
		
		return result;
	}

	
	
}
