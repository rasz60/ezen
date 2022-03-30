package com.ezen.mini.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.mini.command.BoardContentCommand;
import com.ezen.mini.command.BoardDeleteCommand;
import com.ezen.mini.command.BoardListCommand;
import com.ezen.mini.command.BoardModifyCommand;
import com.ezen.mini.command.BoardPageCommand;
import com.ezen.mini.command.BoardReplyCommand;
import com.ezen.mini.command.BoardReplyViewCommand;
import com.ezen.mini.command.BoardWriteCommand;
import com.ezen.mini.command.JoinCommand;
import com.ezen.mini.command.MiniCommand;
import com.ezen.mini.command.ProductDetailsCommand;
import com.ezen.mini.command.ProductListCommand;
import com.ezen.mini.command.ProductWriteCommand;
import com.ezen.mini.dao.MiniDao;
import com.ezen.mini.dto.ProductDto;
import com.ezen.mini.util.Constant;

@Controller
public class EzenMiniController {
	
	private static final Logger logger = LoggerFactory.getLogger(EzenMiniController.class);
	private MiniDao mdao;
	private BCryptPasswordEncoder passwordEncoder;
	private MiniCommand mcom;
	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	@Autowired
	private OAuth2Parameters googleOAuth2Parameters;
	
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
		logger.info("login_view in >>>>");
		
		// google Code
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		
		// login url
		String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
		model.addAttribute("google_url", url);
		
		logger.info("login_view google_url : " + url);
		return "login_view";
	}
	
	@RequestMapping(value="/redirect", produces="application/json; charset=UTF-8")
	public String googleCallBack(Model model, @RequestParam String code, HttpServletResponse response) throws IOException {
		logger.info("googleCallBack in >>>>");

		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		
		AccessGrant accessGrant = oauthOperations.exchangeForAccess(code, googleOAuth2Parameters.getRedirectUri(), null);
		String accessToken = accessGrant.getAccessToken();
		
		logger.info(accessToken);
		
		
		getGoogleUserInfo(accessToken, response);
		
		return "glogin";
	}
	
	
	private void getGoogleUserInfo(String access_Token, HttpServletResponse response) {
		logger.info("getGoogleUserInfo in >>>>");
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HashMap<String, Object> googleUserInfo = new HashMap<String, Object>();
		
		String reqURL = "https://www.googleapis.com/userinfo/v2/me?access_token=" + access_Token;
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestProperty("Authorization", "Bearer " + access_Token);
			
			int responseCode = conn.getResponseCode();
			
			if (responseCode == 200 ) {
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
				
				String line = "";
				String result = "";
				
				while ( (line = br.readLine()) != null ) {
					result += line;
				}
				
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(result);
				JSONObject jsonObj = (JSONObject) obj;
				
				String name_obj = (String)jsonObj.get("name");
				String email_obj = (String)jsonObj.get("email");
				String id_obj = "GOOGLE_" + (String)jsonObj.get("id");
				
				logger.info("getGoogleUserInfo result : name_obj - " + name_obj + " email_obj - " + email_obj + " id_obj - " + id_obj);
				
				googleUserInfo.put("name", name_obj);
				googleUserInfo.put("email", email_obj);
				googleUserInfo.put("id", id_obj);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/logout_view")
	public String logout_view() {
		logger.info("logout_view >>>>");
		return "logout_view";
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
	
	@RequestMapping("/Login")
	public String Login(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
		logger.info("Login in >>>");
		return "login_view";
	}
	
	
	@RequestMapping("/board")
	public String board(HttpServletRequest request, HttpServletResponse response, Model model, Authentication authentication) {
		logger.info("borad in >>>>");
		mcom = new BoardListCommand();
		mcom.execute(request, model);
		model.addAttribute("username", Constant.username);
		
		
		
		logger.info("borad result : username ? " + Constant.username);
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
		logger.info("content_view result 1 : " + result);
		logger.info("content_view result 2 : username ? " + Constant.username);
		return "content_view";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("modify in >>>>");
		mcom = new BoardModifyCommand();
		mcom.execute(request, model);
		
		return "redirect:board";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("delete in >>>> " + request.getParameter("bId"));
		mcom = new BoardDeleteCommand();
		mcom.execute(request, model);
		
		return "redirect:board";
	}

	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("reply_view in >>>>");
		mcom = new BoardReplyViewCommand();
		mcom.execute(request, model);
		model.addAttribute("username", Constant.username);
		logger.info("reply_view result : username ? " + Constant.username);
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("reply in >>>>");
		mcom = new BoardReplyCommand();
		mcom.execute(request, model);
		
		logger.info("reply result : ");
		return "redirect:board";
	}
	
	@RequestMapping("/plist")
	public String plist(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("plist (" + request.getParameter("pageNo") + ") in >>>>");
		
		mcom = new BoardPageCommand();
		mcom.execute(request, model);
		
		return "plist";
	}
	
	
	// product
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

	@RequestMapping("/pwrite_view")
	public String pwrite_view() {
		logger.info("pwrite_view in >>>>");		
		
		return "pwrite_reg_view";
	}
	
	@RequestMapping("/test")
	public String test() {
		logger.info("test in >>>>");		
		
		return "test";
	}
	
	
	@RequestMapping("/product_write")
	public String product_write(MultipartHttpServletRequest mtpRequest, HttpServletRequest request, Model model) {
		logger.info("product_write in >>>>");
		
		String rCuisine = mtpRequest.getParameter("rCuisine");
		String rName = mtpRequest.getParameter("rName");
		String rTitle = mtpRequest.getParameter("rTitle");
		String rContent = mtpRequest.getParameter("rContent");
		String rPhoto = null;
		
		//client에서 넘어오는 파일
		MultipartFile mf = mtpRequest.getFile("rFile");
		// 지속 저장을 위한 경로 (프로젝트 내부 리소스 이미지 폴더)
		String path1 = "D:/EzenClass/05_Spring-workspace/ezenMini/src/main/webapp/resources/images/";
		// 등록시 바로 보여주기 위한 경로 (WAS 리소스 이미지 폴더)
		String path2 = "D:/EzenClass/05_Spring-workspace/apache-tomcat-9.0.56/wtpwebapps/ezenMini/resources/images/";
		
		String originalFileName = mf.getOriginalFilename();
		long prefix_name = System.currentTimeMillis();
		
		String safeFile1 = path1 + prefix_name + originalFileName;
		String safeFile2 = path2 + prefix_name + originalFileName;
		
		// DB 저장용 파일명
		rPhoto = prefix_name + originalFileName;
		
		ProductDto dto = new ProductDto(rPhoto, rCuisine, rName, rTitle, rContent);
		
		mcom = new ProductWriteCommand();
		request.setAttribute("pdto", dto);
		mcom.execute(request, model);
		
		Map<String, Object> map = model.asMap();
		String res = (String)map.get("result");

		if(res.equals("success")) {
			try {
				mf.transferTo(new File(safeFile1));
				mf.transferTo(new File(safeFile2));
			} catch(Exception e) {
				e.printStackTrace();
			}
			logger.info("product_write result : file ? success");
			return "redirect:product";
		} else { 
			logger.info("product_write result : file ? failed");
			return "product_view";
		}
	}
	
	@RequestMapping("/productDetails")
	public String productDetails(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("productDetails in >>> ");
		String result = null;
		
		mcom = new ProductDetailsCommand();
		mcom.execute(request, model);
		if(model.containsAttribute("productView")) {
			result = "success";
		}
		
		logger.info("productDetails result : " + result);
		
		return "productDetailView";
	}
	
	
	@RequestMapping("/folio")
	public String folio() {
		logger.info("folio in >>> ");
		
		return "folio";
	}
	
	
	//dash
	@RequestMapping("/dash")
	public String dash() {
		return "dashBoard";
	}
	
	@RequestMapping("/bar")
	public String bar() {
		return "bar";
	}
	
	@RequestMapping("/pie")
	public String pie() {
		return "pie";
	}
	
	@RequestMapping("/line")
	public String line() {
		return "line";
	}
	
	 //===== DashBoard : dashView =====
	@RequestMapping(value = "/dashView", produces = "application/json; charset=UTF8")
	//json은 return타입
	@ResponseBody //jsp형태가 아닌 다른 문자열이나 객체형시
	public JSONObject dashView(HttpServletRequest request, HttpServletResponse response) {
		String subcmd = request.getParameter("subcmd");
		logger.info("dashView(" + subcmd + ") in");
		
		
		JSONObject jobj_data = null; //JSONObject는 Map 지원
		if(subcmd.equals("line")) {
			jobj_data = getAddData(request, response);
		}
		return jobj_data;
	}
	   
	   private JSONObject getAddData(HttpServletRequest request, HttpServletResponse response) {
		   JSONArray datas = new JSONArray();
		   JSONObject data1 = new JSONObject();
		   //JSONObject는 map을 지원한다(즉 map형임)
		   //DB이용시는 dao의 리턴값이 db매핑 dto를 갖는 AllayList이므로 여기서 for문으로 반복 처리 
		   data1.put("month", "1월");
		   data1.put("pc", 100);
		   data1.put("monitor", 80);
		   datas.add(data1);
		   
		   JSONObject data2 = new JSONObject();
		   //JSONObject는 map을 지원한다
		   data2.put("month", "2월");
		   data2.put("pc", 80);
		   data2.put("monitor", 70);
		   datas.add(data2);
		   
		   JSONObject data3 = new JSONObject();
		   //JSONObject는 map을 지원한다
		   data3.put("month", "3월");
		   data3.put("pc", 70);
		   data3.put("monitor", 60);
		   datas.add(data3);
		   
		   JSONObject data4 = new JSONObject();
		   //JSONObject는 map을 지원한다
		   data4.put("month", "4월");
		   data4.put("pc", 85);
		   data4.put("monitor", 50);
		   datas.add(data4);
		   
		   JSONObject data5 = new JSONObject();
		   //JSONObject는 map을 지원한다
		   data5.put("month", "5월");
		   data5.put("pc", 90);
		   data5.put("monitor", 105);
		   datas.add(data5);
		   
		   JSONObject result = new JSONObject(); //마지막으로 보낼 땐 JSONObject 형으로
	 	   result.put("datas", datas);
		   
		   return result;
	   }
	   
		@RequestMapping("/contact")
		public String contact() {
			return "contact";
		}
	   
}
