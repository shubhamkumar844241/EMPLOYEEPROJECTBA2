package com.cts.ba2.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	//Authentication : set user/password details and mention the role.
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("shubham").password("{noop}shu123").roles("USER").and()
				.withUser("debu").password("{noop}deb123").roles("USER", "ADMIN");
	}

	// Authorization : mention which role can access which URL
	protected void configure(HttpSecurity http) throws Exception
	{
		http.httpBasic().and().authorizeRequests()
				.antMatchers("/employee/admin").hasRole("ADMIN")
				.antMatchers("/employee/user").hasRole("USER")
				.antMatchers("/project/user").hasRole("USER")
				.antMatchers("/project/admin").hasRole("ADMIN")
				.antMatchers("/composite/user").hasRole("USER")
				.and().csrf().disable().headers()
				.frameOptions().disable();
	}

}

