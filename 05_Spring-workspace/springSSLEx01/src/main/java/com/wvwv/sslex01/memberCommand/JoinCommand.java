package com.wvwv.sslex01.memberCommand;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;

import com.wvwv.sslex01.dao.MemberDao;
import com.wvwv.sslex01.dto.JoinDto;
import com.wvwv.sslex01.util.Constant;

public class JoinCommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest request, Model model) {
		BCryptPasswordEncoder passwordEncoder = Constant.passwordEncoder;
		
		String bId = request.getParameter("pid");
		String bPw = request.getParameter("ppw");
		String bAddress = request.getParameter("paddress");
		String bHobby = request.getParameter("phobby");
		String bProfile = request.getParameter("pprofile");
		
		String bPw_org = bPw;
		
		// 암호화된 패스워드로 인코딩
		bPw = passwordEncoder.encode(bPw_org);
		
		System.out.println(bPw + " size " + bPw.length());
		
		JoinDto dto = new JoinDto(bId, bPw, bAddress, bHobby, bProfile);
		
		MemberDao mdao = Constant.mdao;
		
		String result = mdao.join(dto);
		
		request.setAttribute("result", result);
		
	}
	
}
