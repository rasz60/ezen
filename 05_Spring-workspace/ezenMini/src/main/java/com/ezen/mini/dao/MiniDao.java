package com.ezen.mini.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.ezen.mini.dto.BoardDto;
import com.ezen.mini.dto.JoinDto;
import com.ezen.mini.dto.ProductDto;

@Repository
public class MiniDao implements IDao {

	private static final Logger logger = LoggerFactory.getLogger(MiniDao.class);

	@Autowired
	private SqlSession sqlSession;
	
	// join & login
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

	
	
	// board
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

	@Override
	public BoardDto contentView(String bid) {
		logger.info("contentView() in >>>>");
		// 조회수 count++ method
		upHit(bid);
		
		BoardDto dto = sqlSession.selectOne("contentView", Integer.parseInt(bid));
		
		logger.info("contentView() result : bId = " + dto.getbId());
		return dto;
	}

	
	@Override
	public void modify(String bId, String bName, String bTitle, String bContent) {
		logger.info("modify(" + bId + ", " + bName + ", " + bTitle + ", " + bContent + ") in >>>>");
		
		BoardDto dto = new BoardDto(Integer.parseInt(bId), bName, bTitle, bContent);
		
		int res = sqlSession.update("modify", dto);
		
		logger.info("modify result : success ? " + res);
	}

	@Override
	public void delete(String bId) {
		logger.info("productList() in >>>>");
		int bid = Integer.parseInt(bId);
		int res = sqlSession.delete("delete", bid);
		
		logger.info("modify result : success ? " + res);
	}
	
	@Override
	public BoardDto reply_view(String bId) {
		logger.info("reply_view(" + bId + ") in >>>>");
		
		BoardDto dto = sqlSession.selectOne("reply_view", Integer.parseInt(bId));
		
		logger.info("reply_view result : bId ?" + dto.getbId());
		
		return dto;
	}
	
	@Override
	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent) {
		// 댓글의 위치 처리
		replyShape(bGroup, bStep);
		logger.info("reply in >>> ");		
		
		BoardDto dto = new BoardDto(Integer.parseInt(bId), bName, bTitle, bContent, null, 0, Integer.parseInt(bGroup), Integer.parseInt(bStep), Integer.parseInt(bIndent));
		
		int res = sqlSession.insert("reply", dto);
		
		logger.info("reply result : success ? " + res);
	}
	
	public void upHit(String bId) {
		logger.info("upHit(" + bId + ") in >>> ");	
		
		int res = sqlSession.update("upHit", Integer.parseInt(bId));
		
		logger.info("upHit result : " + res);
	}
	
	public void replyShape(String bGroup, String bStep) {
		logger.info("replyShape in >>> ");
		
		int iGroup = Integer.parseInt(bGroup);
		int iStep = Integer.parseInt(bStep);
		
		BoardDto dto = new BoardDto(0, null, null, null, null, 0, iGroup, iStep, 0);
		
		int res = sqlSession.update("replyShape", dto);
		
		logger.info("replyShape result : success ? " + res);
	}

	@Override
	public ArrayList<BoardDto> pageList(String pageNo) {
		logger.info("pageList(" + pageNo + ") in >>>>");
		
		int startBId = ((Integer.parseInt(pageNo) - 1) * 10) + 1;
		
		ArrayList<BoardDto> dtos = (ArrayList)sqlSession.selectList("pageList", startBId);
		
		logger.info("pageList() result.isEmpty() ? " + dtos.isEmpty());
		return dtos;
	}

	
	// product
	@Override
	public ArrayList<ProductDto> productList() {
		logger.info("productList() in >>>>");
		
		ArrayList<ProductDto> dtos = (ArrayList)sqlSession.selectList("productList");
		
		logger.info("productList() result : dtos.isEmpty() ? " + dtos.isEmpty());
		return dtos;
	}

	public String productWrite(ProductDto dto, Model model) {
		logger.info("productWrite(" + dto.getrName() + ") in >>>>");
		
		int res = sqlSession.insert("productWrite", dto);
		
		String result = res > 0 ? "success" : "false";
		
		logger.info("productWrite(" + dto.getrName() + ") result : " + result);
		
		return result;
	}

	public ProductDto productDetailView(String rPhoto) {
		logger.info("productDetailView(" + rPhoto + ") in >>>>");
		
		ProductDto dto = sqlSession.selectOne("productDetailView", rPhoto);
		
		logger.info("productDetailView result : " + (dto != null ? "success" : "failed"));
		
		return dto;
	}
	
}
