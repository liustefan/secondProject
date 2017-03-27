package com.bithealth.sdk.config;

import java.util.Properties;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class KDCOnfigPlaceholderConfigurer extends PropertyPlaceholderConfigurer implements InitializingBean {

	private KDConfig config;
	
	public KDCOnfigPlaceholderConfigurer() {
		
	}
	
	public KDCOnfigPlaceholderConfigurer(KDConfig config) {
		this.config = config;
	}



	public KDConfig getConfig() {
		return config;
	}

	public void setConfig(KDConfig config) {
		this.config = config;
	}

	public void afterPropertiesSet() {
	}


	@Override
	protected String resolvePlaceholder(String placeholder, Properties props) {
		return config.getProperties().getProperty(placeholder);
	}
}
