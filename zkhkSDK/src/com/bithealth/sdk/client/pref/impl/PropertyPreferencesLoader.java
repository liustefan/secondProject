package com.bithealth.sdk.client.pref.impl;

import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bithealth.sdk.client.common.PlatformClientService;
import com.bithealth.sdk.client.pref.Preferences;
 
public class PropertyPreferencesLoader {
	private static Log LOG = LogFactory.getLog(PropertyPreferencesLoader.class);

	private static final String FILE_NAME = "zkhk-platform-service.properties";

	private Properties properties = new Properties();

	private String fileName;
	
	private Preferences preferences = new Preferences();

	public PropertyPreferencesLoader() {
		this (FILE_NAME);
	}

	public PropertyPreferencesLoader(String fileName) {
		this.fileName = fileName;
		loadConfig();
	}
	
	public PropertyPreferencesLoader(Properties properties) {
		this.properties.putAll(properties);
	}

	public String getFileName() {
		return fileName;
	}

	public Preferences getPreferences() {
		return preferences;
	}

	@SuppressWarnings("unchecked")
	public void loadConfig() {
		try {
			InputStream in = null;
			try {
				in = Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_NAME);
				if (in == null) {
					in = PlatformClientService.class.getClassLoader().getResourceAsStream(FILE_NAME);
				}
				if (in != null) {
					properties.load(in);
				}
				
				for (Entry entry : properties.entrySet()) {
					preferences.put(entry.getKey().toString(), entry.getValue());
				}
			} finally {
				if (in != null) {
					in.close();
				}
			}
		} catch (Exception e) {
			LOG.error("load properites error", e);
		}
	}
}
