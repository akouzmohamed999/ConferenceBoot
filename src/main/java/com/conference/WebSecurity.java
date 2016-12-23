package com.conference;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService customUserDetailsService;
	@Autowired
	public void globalconfiguration(AuthenticationManagerBuilder auth) throws Exception{
		
	/*auth.jdbcAuthentication().dataSource(datasource).passwordEncoder(passwordEncoder)
	.usersByUsernameQuery("select email as principal, password as credentials, roles from user where email = ?")
	.authoritiesByUsernameQuery("select roles as role, email, password from user where email =?").rolePrefix("ROLE_");*/
		
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordencoder());
	
	}
	
	@Bean
	public PasswordEncoder passwordencoder(){
		PasswordEncoder passwordencoder = new BCryptPasswordEncoder();
		return passwordencoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
			.antMatchers("/css/**","/js/**","/images/**").permitAll()
			.anyRequest()
			.authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			.defaultSuccessUrl("/index");
	}
}
