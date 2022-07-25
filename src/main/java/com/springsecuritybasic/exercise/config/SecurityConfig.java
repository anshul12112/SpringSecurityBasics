package com.springsecuritybasic.exercise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public UserDetailsServiceImpl getUserDetailsServiceImplBean() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public PasswordEncoder getPasswordEncoderBean() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	protected SecurityFilterChain getBean(HttpSecurity http) throws Exception {
		return http.csrf().disable().authorizeRequests()
				.antMatchers("/fetch/singlePermissionPage").hasAuthority("ADMIN")
				.antMatchers("/fetch/welcomeAll").permitAll()
				.antMatchers("/basicSecurity/*").permitAll()
				.antMatchers("/adminAndPM").hasAnyAuthority("ADMIN","PM")
				.anyRequest().authenticated()
			    .and().httpBasic()
			    .and().build();
	}

	@Bean
	AuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoderBean());
		daoAuthenticationProvider.setUserDetailsService(getUserDetailsServiceImplBean());
		return daoAuthenticationProvider;
	}

}
