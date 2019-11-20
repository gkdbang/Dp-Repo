package com.quinnox.demo2.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
//@EnableWebMvc
@ComponentScan
public class MvcConfiguration extends WebMvcConfigurationSupport{
	
		// we can also implements WebMvcConfugrer interface
		@Override
		protected void configureViewResolvers(ViewResolverRegistry registry) {
			
			InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
			internalResourceViewResolver.setPrefix("/WEB-INF/views/");
			internalResourceViewResolver.setSuffix(".jsp");
			internalResourceViewResolver.setViewClass(JstlView.class);
			registry.viewResolver(internalResourceViewResolver);
		}
}
