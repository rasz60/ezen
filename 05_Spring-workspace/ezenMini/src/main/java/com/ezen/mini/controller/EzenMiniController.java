package com.ezen.mini.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.mini.command.BoardContentCommand;
import com.ezen.mini.command.BoardListCommand;
import com.ezen.mini.command.BoardWriteCommand;
import com.ezen.mini.command.JoinCommand;
import com.ezen.mini.command.MiniCommand;
import com.ezen.mini.command.ProductListCommand;
import com.ezen.mini.dao.MiniDao;
import com.ezen.mini.util.Constant;

@Controller
public class EzenMiniController {
	
	private static final Logger logger = LoggerFactory.getLogger(EzenMiniController.class);
	private MiniDao mdao;
	private BCryptPasswordEncoder passwordEncoder;
	private MiniCommand mcom;
	
	@Autowired
	public void setMiniDao(MiniDao mdao) {
		this.mdao = mdao;		
		Constant.mdao = this.mdao;
	}
	
	@Autowired
	public void setpasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;		
		Constant.passwordEncoder = this.passwordEncoder;
	}

	@RequestMapping("join_view")
	public String join_view() {
		logger.info("join_view >>>>");
		return "join_view";
	}
	
	@RequestMapping(value="/join", produces="application/text; charset=UTF-8")
	@ResponseBody
	public String join(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("join in >>>>");
		mcom = new JoinCommand();
		mcom.execute(request, model);
		String result = (String)request.getAttribute("result");
		
		logger.info(result);
		
		if( result.equals("success") ) {
			logger.info("join result : success >>>>");
			return "join-success";
		} else {
			logger.info("join result : failed >>>>");
			return "join-failed";
		}
	}
	
	@RequestMapping("login_view")
	public String login_view(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		logger.info("login_view >>>>");
		
		session.setAttribute("username", Constant.username);
		
		return "login_view";
	}

	@RequestMapping("/logout_view")
	public String logout_view() {
		logger.info("logout_view >>>>");
		return "logout_view";
	}

	@RequestMapping("/board")
	public String board(HttpServletRequest request, HttpServletResponse response, Model model, Authentication authentication) {
		logger.info("borad in >>>>");
		mcom = new BoardListCommand();
		mcom.execute(request, model);
		
		return "board";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		logger.info("write_view in >>>>");
		model.addAttribute("bName", Constant.username);
		logger.info("write_view result : bName ? " + Constant.username);
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("write in >>>>");
		mcom = new BoardWriteCommand();
		mcom.execute(request, model);
		
		return "redirect:board";
	}
	
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("content_view in >>>>");
		String result = "failed";
		
		mcom = new BoardContentCommand();
		mcom.execute(request, model);
		
		if ( model.containsAttribute("content_view") ) {
			result = "success";
		}
		
		model.addAttribute("username", Constant.username);
		
		logger.info("content_view result : " + result);
		return "content_view";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("reply_view in >>>>");
		
		
		logger.info("reply_view result : ");
		return "reply_view";
	}
	
	
	@RequestMapping("/product")																	// 로그인이 완료된 user의 정보를 가지고 있음
	public String product(HttpServletRequest request, HttpServletResponse response, Model model, Authentication authentication) {
		logger.info("product in >>>>");

		mcom = new ProductListCommand();
		mcom.execute(request, model);
		
		// Authentication 객체의 principal 속성을 이용하여 UserDetails 객체로 생성
		UserDetails userDetails = (UserDetails)authentication.getPrincipal();
		Constant.username = userDetails.getUsername();
		logger.info("userId : " + userDetails.getUsername());
		
		// 권한을 모두 가져와서 컬렉션으로 표시 (GrantedAuthority 클래스를 상속받은 클래스의 값만 들어갈 수 있음)
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		String auth = authorities.toString();
		
		logger.info("userRole : " + auth);
		
		logger.info("product result : userRole = " + auth);		
		return "product_view";
	}
	
	@RequestMapping(value="/processLogin", method=RequestMethod.GET)
	public ModelAndView processLogin(@RequestParam(value = "log", required = false) String log,
									 @RequestParam(value = "error", required = false) String error,
									 @RequestParam(value = "logout", required = false) String logout,
									 HttpSession session) {
		
		logger.info("processLogin in >>>>");
		
		ModelAndView model = new ModelAndView();
		
		// security form이 아닌 곳에서 로그인창 요청시 반환
		if(log != null && log != "") {
			model.addObject("log", "before login!");
			logger.info("processLogin result : log");

		// 로그인 에러시 security에서 반환 (value = 1)
		} else if(error != null && error != "") {
			model.addObject("error", "Invalid username or password!");
			logger.info("processLogin result : error");
			
		// 로그아웃 성공시 security에서 반환 (value = 1)
		} else if(logout != null && logout != "") {
			model.addObject("logout", "logout seccess!");
			logger.info("processLogin result : logout");
		}

		model.setViewName("login_view");

		return model;
	}
	
	
}
