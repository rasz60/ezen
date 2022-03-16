package com.ezen.mini.dao;

import com.ezen.mini.dto.JoinDto;

public interface IDao {
	
	public String join(JoinDto dto);
	
	public JoinDto login(String username);
	
}
