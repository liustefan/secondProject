package com.bithealth.sdk.config;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

import com.bithealth.sdk.client.pref.Preferences;
import com.bithealth.sdk.client.pref.PreferencesFactory;


public class ZKHKConfigPreferencesImpl implements KDConfig {
	private final AtomicReference<Preferences> preferencesRef = new AtomicReference<Preferences>();

	private final AtomicReference<Properties> propertiesRef = new AtomicReference<Properties>();

	private PreferencesFactory preferencesFactory;

	private String preferencesName;

	public ZKHKConfigPreferencesImpl() {

	}

	public ZKHKConfigPreferencesImpl(PreferencesFactory preferencesFactory, String preferencesName) {
		this.preferencesFactory = preferencesFactory;
		this.preferencesName = preferencesName;
	}
	
	public PreferencesFactory getPreferencesFactory() {
		return preferencesFactory;
	}

	public void setPreferencesFactory(PreferencesFactory preferencesFactory) {
		this.preferencesFactory = preferencesFactory;
	}

	public Properties getProperties() {
		Properties properties = propertiesRef.get();
		if (properties != null) {
			return properties;
		}

		properties = new Properties();

		Preferences preferences = getPreferences();
		for (Entry<String, Object> entry : preferences.entrySet()) {
			properties.put(entry.getKey(), entry.getValue());
		}

		propertiesRef.compareAndSet(null, properties);

		return propertiesRef.get();
	}

	public Properties getPropertiesByKey(String pre_key) {
		Properties proTemp = new Properties();
		Iterator<Object> it = getProperties().keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			if (key.startsWith(pre_key)) {
				String temp = key.substring(pre_key.length(), key.length());
				proTemp.put(temp, getProperties().getProperty(key));
			}
		}
		return proTemp;
	}

	public String getProperty(String key) {
		return getProperties().getProperty(key);
	}

	public Preferences getPreferences() {
		Preferences preferences = preferencesRef.get();

		if (preferences != null) {
			return preferences;
		}

		try {
			preferences = preferencesFactory.getPreferences(preferencesName);

			preferencesRef.compareAndSet(null, preferences);

			return preferencesRef.get();
		} catch (RuntimeException e) {
			throw e;
		}
	}
}
