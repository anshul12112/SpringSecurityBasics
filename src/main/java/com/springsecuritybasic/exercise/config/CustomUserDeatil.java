package com.springsecuritybasic.exercise.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springsecuritybasic.exercise.domain.User;

public class CustomUserDeatil implements UserDetails {

	private static final long serialVersionUID = -4687452768377595016L;
	private User user;

	public CustomUserDeatil(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.stream(user.getRole().split("\\|")).map(e -> new SimpleGrantedAuthority(e.trim()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return user.getUserPswd();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
