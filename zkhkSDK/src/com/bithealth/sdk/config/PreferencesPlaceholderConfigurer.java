package com.bithealth.sdk.config;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
// 
import com.bithealth.sdk.client.pref.Preferences;
import com.bithealth.sdk.client.pref.PreferencesFactory;
import com.bithealth.sdk.common.Env;

public class PreferencesPlaceholderConfigurer extends PropertyPlaceholderConfigurer implements InitializingBean {
	private final AtomicReference<Preferences> preferencesRef = new AtomicReference<Preferences>();

	private PreferencesFactory preferencesFactory;

	private String preferencesName;
	
	public PreferencesPlaceholderConfigurer() {
		
	}
	
	public PreferencesPlaceholderConfigurer(PreferencesFactory preferencesFactory, String preferencesName) {
		super();
		this.preferencesFactory = preferencesFactory;
		this.preferencesName = preferencesName;
	}



	public PreferencesFactory getPreferencesFactory() {
		return preferencesFactory;
	}

	public void setPreferencesFactory(PreferencesFactory preferencesFactory) {
		this.preferencesFactory = preferencesFactory;
	}

	public void afterPropertiesSet() {
	}


	@Override
	protected String resolvePlaceholder(String placeholder, Properties props) {
		String key = placeholder;
		String value = resolvePlaceholder(key, getPreferences());
		return value;
	}

	protected String resolvePlaceholder(String key, Preferences preferences) {
		if (preferences == null) {
			throw new IllegalArgumentException("preferences '" + preferencesName + "' is null");
		}
		
		Object value = preferences.get(key);
		if (value == null) {
			return null;
		} else {
			return value.toString();
		}
	}

	public Preferences getPreferences() {
		Preferences preferences = preferencesRef.get();

		if (preferences != null) {
			return preferences;
		}

		try {
			PreferencesFactory preferencesFactory = this.preferencesFactory;
			
			if (preferencesFactory == null) {
				preferencesFactory = Env.getBean("preferencesFactory");
			}
			
			preferences = preferencesFactory.getPreferences(preferencesName);

			preferencesRef.compareAndSet(null, preferences);

			return preferencesRef.get();
		} catch (RuntimeException e) {
			throw e;
		}
	}
}
