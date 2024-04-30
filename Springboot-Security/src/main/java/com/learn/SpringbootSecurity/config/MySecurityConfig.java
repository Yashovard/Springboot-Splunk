package com.learn.SpringbootSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity

public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	String normal_User="Yash";
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable() //so we can add and put data using csrf toake
		.authorizeRequests()
		.antMatchers("/public/**").hasRole("NORMAL") //No password required to access this page only one url need this type if controller have get mapping access normal user
		.antMatchers("/users/**").hasRole("ADMIN") // admin access this url
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser(normal_User).password(this.passwordEncoder().encode("Shweta")).roles("NORMAL");   //use this for password encryption
		auth.inMemoryAuthentication().withUser("Shweta").password("Yash").roles("ADMIN");   //This is normal password as it is

	}
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}



}
