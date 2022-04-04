package com.ezen.mini.naver;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;

@Service
public class NaverLoginBo {
	// 인증 요청문을 구성하는 파라미터
	// client_id : 어플리케이션 등록 후 발급받는 클라이언트 아이디
	// response_type : 인증 과정에 대한 구분 값. code 값으로 고정되어 있음
	// redirect_uri : 네이버 로그인 인증 결과를 전달받을 콜백 URL
	// 어플리케이션을 등록할 때, Callback URL에 설정한 정보
	// state : 어플리케이션이 생성한 상태 토큰 (네이버 개발자 사이트에서 등록시 주어진 값)
	
	private final static String CLIENT_ID = "wbrACOZjnqrurUANjevI";
	private final static String CLIENT_SECRET = "si8sN3gx1M";
	private final static String REDIRECT_URI = "https://localhost:8443/ezenpj/nredirect";
	private final static String SESSION_STATE = "oauth_state";
	
	private final static String PROFILE_API_URL = "https://openapi.naver.com/v1/nid/me";
	
	public String getAuthorizationUrl(HttpSession session) {
		// 세션 유효성 검증을 위하여 난수를 생성
		String state = generateRandomString();
		setSession(session, state);
		
		// Scribe에서 제공하는 인증 URL 생성 기능을 이용하여 URL 생성
		OAuth20Service oauthService = new ServiceBuilder()
										.apiKey(CLIENT_ID)
										.apiSecret(CLIENT_SECRET)
										.callback(REDIRECT_URI)
										.state(state)
										.build(NaverLoginApi.instance());
		
		return oauthService.getAuthorizationUrl();
	}
	
	public String generateRandomString() {
		return UUID.randomUUID().toString();
	}
	
	public void setSession(HttpSession session, String state) {
		session.setAttribute(SESSION_STATE, state);
	}
	
	public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws IOException {
		String sessionState = getSession(session);
		
		if ( StringUtils.pathEquals(sessionState, state) ) {
			OAuth20Service oauthService = new ServiceBuilder()
											.apiKey(CLIENT_ID)
											.apiSecret(CLIENT_SECRET)
											.callback(REDIRECT_URI)
											.state(state)
											.build(NaverLoginApi.instance());
			
			// Scribe에서 제공하는 AccessToken 획득 기능
			OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
			return accessToken;
		}
		return null;
	}
	
	private String getSession(HttpSession session) {
		return (String)session.getAttribute(SESSION_STATE);
	}
	
	//Access Token을 이용하여 네이버 사용자 프로필 API를 호출
		public String getUserProfile(OAuth2AccessToken oauthToken) throws IOException {
			OAuth20Service oauthService =new ServiceBuilder()
				.apiKey(CLIENT_ID)
		        .apiSecret(CLIENT_SECRET)
		        .callback(REDIRECT_URI)
		        .build(NaverLoginApi.instance());
			OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oauthService);
			oauthService.signRequest(oauthToken, request);
			Response response = request.send();
		    return response.getBody();
		}

	
}
