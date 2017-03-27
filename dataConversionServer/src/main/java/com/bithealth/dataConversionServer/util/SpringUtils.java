package com.bithealth.dataConversionServer.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtils implements ApplicationContextAware, DisposableBean {
	
	private static ApplicationContext context;
	
	private SpringUtils() {
		
	}

	public void destroy() throws Exception {
		context= null;
	}

	
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		SpringUtils.context = arg0;
	}
	
	public static Object getBean(String beanName) {
		return context.getBean(beanName);
	}

}
