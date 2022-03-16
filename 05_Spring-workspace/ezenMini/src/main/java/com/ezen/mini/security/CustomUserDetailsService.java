package com.ezen.mini.security;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ezen.mini.HomeController;
import com.ezen.mini.dao.MiniDao;
import com.ezen.mini.dto.JoinDto;
import com.ezen.mini.util.Constant;

public class CustomUserDetailsService implements UserDetailsService{

	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("loadUserByUsername(" + username + ") in >>>");
				
		MiniDao mdao = Constant.mdao;
		
		logger.info("mdao.login(" + username + ") in >>>");
		JoinDto dto = mdao.login(username);
		
		logger.info("mdao.login(" + username + ") out >>> " + dto.toString());
		
		if ( dto == null ) {
			throw new UsernameNotFoundException("No user found with username");
		}
		
		String pw = dto.getPpw();
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		// User(id, pw, roles) 객체 생성
		UserDetails user = new User(username, pw, roles);
		Constant.username = user.getUsername();
		
		logger.info("loadUserByUsername() out >>>");
		return user;
	}

}
