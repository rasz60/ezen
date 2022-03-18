package com.ezen.mini.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.ezen.mini.dao.MiniDao;
import com.ezen.mini.dto.ProductDto;
import com.ezen.mini.util.Constant;

public class ProductListCommand implements MiniCommand {

	@Override
	public void execute(HttpServletRequest request, Model model) {
		MiniDao mdao = Constant.mdao;
		
		ArrayList<ProductDto> dtos = mdao.productList();
		
		model.addAttribute("productList", dtos);
	}

}
