package com.bithealth.sdk.  client.common;

import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bithealth.sdk.client.pref.Preferences;
import com.bithealth.sdk.client.pref.PreferencesFactoryLoader;
 

public class PlatformClientServiceConfig {
	private static Log LOG = LogFactory.getLog(PlatformClientServiceConfig.class);

	private static AtomicReference<Properties> propertiesRef = new AtomicReference<Properties>();

	public static final String PREFERENCE_NAME = "platform-client";

	public static final String FILE_NAME = "zkhk-platform-service.properties";

	public static Properties loadConfig() {
		try {
			InputStream in = null;
			try {
				in = Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_NAME);
				if (in == null) {
					in = PlatformClientService.class.getClassLoader().getResourceAsStream(FILE_NAME);
				}
				if (in != null) {
					Properties propertes = new Properties();
					propertes.load(in);
					return propertes;
				}
			} finally {
				if (in != null) {
					in.close();
				}
			}
		} catch (Exception e) {
			LOG.error("load properites error", e);
		}
		return null;
	}

	public static Properties getProperties() {
		Properties properties = propertiesRef.get();
		if (properties != null) {
			return properties;
		}

		try {
			properties = new Properties();

			Preferences preferences = PreferencesFactoryLoader.getPreferencesFactory().getPreferences(PREFERENCE_NAME);
			for (Entry<String, Object> entry : preferences.entrySet()) {
				properties.put(entry.getKey(), entry.getValue());
			}
		} catch (Exception e) {
			properties = null;
			if (LOG.isWarnEnabled()) LOG.warn("load preferences from PreferencesFactoryLoader error");
		}
		
		if (properties == null) {
			properties = loadConfig();
		}

		propertiesRef.compareAndSet(null, properties);

		return propertiesRef.get();
	}

	public static long getLong(String propertyName, long defaultValue) {
		String propValue = getProperties().getProperty("propertyName");
		if (propValue == null || propValue.trim().length() == 0) {
			return defaultValue;
		}

		return Long.parseLong(propValue.trim());
	}
}
