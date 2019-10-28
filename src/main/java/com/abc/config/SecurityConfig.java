package com.abc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.abc.dao.UserRepository;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("manju").password(passwordEncoder().encode("abc")).roles("ADMIN").and().
//		withUser("aksh").password(passwordEncoder().encode("manju")).authorities("test");
//		
		
		auth.authenticationProvider(authenticationProvider());
	}
	

	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider  authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		authenticationProvider.setUserDetailsService(userDetailsServices());
		return  authenticationProvider;
	}
	
	
	@Bean
	UserDetailsService userDetailsServices() {
		return new UserDetailsServices(userRepository);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		http.authorizeRequests().
		antMatchers("/user").hasAnyRole("ADMIN").and().authorizeRequests().
		anyRequest().authenticated().and().
		// form auth
		formLogin();
//		formLogin().
		//	usernameParameter("").//custom define paramter name
		//	and().logout().and().rememberMe();
		//basic auth
		//httpBasic();
	}
	
	

}
