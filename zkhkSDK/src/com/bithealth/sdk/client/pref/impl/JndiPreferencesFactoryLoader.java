package com.bithealth.sdk.client.pref.impl;

import javax.naming.InitialContext;

import com.bithealth.sdk.client.YoushangClientException;
import com.bithealth.sdk.client.pref.Preferences;
 
public class JndiPreferencesFactoryLoader {
	public static final String DEFAULT_JNDI_NAME = "java:comp/env/platform/preferencesFactory";
	
	private String jndiName;
	
	public JndiPreferencesFactoryLoader() {
		this(DEFAULT_JNDI_NAME);
	}
	
	public JndiPreferencesFactoryLoader(String jndiName) {
		this.jndiName = jndiName;
	}

	public Preferences getPreferences() {
		try {
			InitialContext initCtx = new InitialContext();
			return (Preferences) initCtx.lookup(jndiName);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new YoushangClientException("getPreferences error", e);
		}
	}
}
