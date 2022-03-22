package com.ezen.mini.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ezen.mini.dao.MiniDao;
import com.ezen.mini.dto.ProductDto;
import com.ezen.mini.util.Constant;

public class ProductDetailsCommand implements MiniCommand {

	@Override
	public void execute(HttpServletRequest request, Model model) {
		MiniDao mdao = Constant.mdao;
		
		String rPhoto = request.getParameter("rPhoto");
		
		ProductDto dto = mdao.productDetailView(rPhoto);
		
		if(dto != null) {
			model.addAttribute("productView", dto);
		}
	}

}
