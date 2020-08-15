package com.quinnox.qtvt.configuration;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
																			   
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.bind.annotation.CrossOrigin;





@EnableWebSecurity
				   
  
   
@Configuration
	  
	public class SpringSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;
	
		@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.authenticationProvider(customAuthenticationProvider);

	}
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class);
	        http
	                .authorizeRequests()
	                .antMatchers("/*")
                    .permitAll()
	                .anyRequest()
	                .authenticated()
	                .and()
	                .httpBasic()
	                .and().csrf().disable();
	        http
	         .sessionManagement()
	           .maximumSessions(1)
	           .expiredUrl("/login?expired")
	           .and()
	           .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
	           .invalidSessionUrl("/login");

		}
	    }
  
