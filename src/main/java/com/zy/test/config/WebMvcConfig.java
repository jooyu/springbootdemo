package com.zy.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.zy.test.interceptor.AdminInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/system/admin/**");
	}
}
