package com.ezen.mini.dao;

import java.util.ArrayList;

import com.ezen.mini.dto.BoardDto;
import com.ezen.mini.dto.JoinDto;
import com.ezen.mini.dto.ProductDto;

public interface IDao {

	// join & login
	public String join(JoinDto dto);
	public JoinDto login(String username);
	
	
	// board
	public ArrayList<BoardDto> list();
	public void write(String bName, String bTitle, String bContent);
	public BoardDto contentView(String bid);
	public void modify(String bId, String bName, String bTitle, String bContent);
	public void delete(String bId);
	public BoardDto reply_view(String bId);
	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent);
	public ArrayList<BoardDto> pageList(String pageNo);
	
	// product
	public ArrayList<ProductDto> productList();
}
