package com.cos.security1.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.security1.model.User;

public class PrincipalDetails implements UserDetails {

	private User user;
	
	public PrincipalDetails(User user) {
		this.user = user;
	}
	
	//해당 User 권한 리턴
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<GrantedAuthority>();
		collect.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return user.getRole();
			}
		});
		return collect;
	}

	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	//계정 만료 확인
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//계정 잠금 확인
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//계정 유효 기간 확인
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	//계정 활성화
	@Override
	public boolean isEnabled() {
		return true;
	}
}
