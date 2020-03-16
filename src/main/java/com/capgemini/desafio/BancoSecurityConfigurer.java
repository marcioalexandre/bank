package com.capgemini.desafio;

import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
 
@EnableWebSecurity
public class BancoSecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	private static final Logger LOGGER = Logger.getLogger(BancoSecurityConfigurer.class.getName());
 
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/**").fullyAuthenticated().and().httpBasic();
	}
 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		LOGGER.info(LOGGER.getName());
		auth.inMemoryAuthentication().withUser("your-user").password("your-password").roles("USER");
	}
 
	@Bean
	public PasswordEncoder passworEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}