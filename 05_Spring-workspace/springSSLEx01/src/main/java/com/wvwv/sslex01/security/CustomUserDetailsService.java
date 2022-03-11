package com.wvwv.sslex01.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.wvwv.sslex01.dao.MemberDao;
import com.wvwv.sslex01.dto.JoinDto;
import com.wvwv.sslex01.util.Constant;

public class CustomUserDetailsService implements UserDetailsService {

	@Override							 //username == id
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberDao mdao = Constant.mdao;
		JoinDto dto = mdao.login(username);
		System.out.println(dto);
		
		if ( dto == null ) {
			System.out.println("null");
			throw new UsernameNotFoundException("No user found with username.");
		}
		
		String pw = dto.getpPw();
		
		// access role은 여러개를 가질 수 있으므로, collection으로 처리 ('ROLE_USER', 'ROLE_ADMIN', 'ROLE_MANAGE' ... )
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		// spring security에서 UserDetails객체를 이용하여 로그인 설정
		UserDetails user = new User(username, pw, roles);
		
		System.out.println(user.getAuthorities());
		// login 완료 후 username을 사용할 수 있도록 함
		Constant.username = username;
		
		return user;
	}

}
