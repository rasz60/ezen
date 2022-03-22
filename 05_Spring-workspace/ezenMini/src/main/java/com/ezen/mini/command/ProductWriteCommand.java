package com.ezen.mini.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ezen.mini.dao.MiniDao;
import com.ezen.mini.dto.ProductDto;
import com.ezen.mini.util.Constant;

public class ProductWriteCommand implements MiniCommand {

	@Override
	public void execute(HttpServletRequest request, Model model) {
		MiniDao mdao = Constant.mdao;
		
		String result = mdao.productWrite((ProductDto)request.getAttribute("pdto"), model);
		
		model.addAttribute("result", result);
		
	}

}
