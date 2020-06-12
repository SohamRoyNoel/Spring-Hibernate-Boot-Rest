package com.security.demo.servletInitializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.security.demo.config.DemoAppConfig;

public class SpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	/*
	 *
	 * simulates DISPATCHER class on spring.xml
	 * 
	 * */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { DemoAppConfig.class };
	}

	/*
	 *
	 * simulates Servlet mapping on spring.xml
	 * 
	 * */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
