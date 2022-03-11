package com.wvwv.sslex01.dao;

import com.wvwv.sslex01.dto.JoinDto;

public interface MemberIDao {

	public String join(JoinDto dto);
	
	public JoinDto login(String pId);
}
