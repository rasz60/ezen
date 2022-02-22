package com.wvwv.ch21ex01.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.wvwv.ch21ex01.DAO.BDAO;
import com.wvwv.ch21ex01.DTO.WriteFormDTO;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		//modle 안에 저장된 파라미터를 map으로 출력
		Map<String, Object> map = model.asMap();
		
		// model에 싣어보낸 dto 객체를 캐스팅하여 대입
		WriteFormDTO dto = (WriteFormDTO)map.get("wfdto");
		
		String bName = dto.getbName();
		String bTitle = dto.getbTitle();
		String bContent = dto.getbContent();
		
		BDAO bDao = new BDAO();
		bDao.write(bName, bTitle, bContent);
	
	}

}
