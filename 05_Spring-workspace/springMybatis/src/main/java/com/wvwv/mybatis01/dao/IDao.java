package com.wvwv.mybatis01.dao;

import java.util.ArrayList;

import com.wvwv.mybatis01.dto.ContentDTO;
import com.wvwv.mybatis01.dto.TicketDTO;

public interface IDao {

	public void writeDao(String mWriter, String mContent);
	
	public ArrayList<ContentDTO> listDao();
	
	public void deleteDao(String mId);
	
	public ArrayList<ContentDTO> viewDao(String mId);
	
	public void writeCard(TicketDTO dto);

	public void writeTicket(TicketDTO dto);
}
