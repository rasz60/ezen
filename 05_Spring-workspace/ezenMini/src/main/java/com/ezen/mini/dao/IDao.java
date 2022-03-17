package com.ezen.mini.dao;

import java.util.ArrayList;

import com.ezen.mini.dto.BoardDto;
import com.ezen.mini.dto.JoinDto;

public interface IDao {
	
	public String join(JoinDto dto);
	
	public JoinDto login(String username);
	
	public ArrayList<BoardDto> list();
	
	public void write(String bName, String bTitle, String bContent);
}
