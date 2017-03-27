package com.bithealth.sdk.client.pref;

import java.util.concurrent.atomic.AtomicReference;

import javax.naming.InitialContext;

import com.bithealth.sdk.client.YoushangClientException;
 

public class PreferencesFactoryLoader {
	public static AtomicReference<PreferencesFactory> factoryRef = new AtomicReference<PreferencesFactory>();
	
	public static void setPreferencesFactory(PreferencesFactory factory) {
		factoryRef.set(factory);
	}
	
	public static PreferencesFactory getPreferencesFactory() {
		PreferencesFactory factory = factoryRef.get();
		
		if (factory != null) {
			return factory;
		}
		
		try {
			String jndiName = "java:comp/env/platform/preferencesFactory";
			InitialContext initCtx = new InitialContext();
			factory = (PreferencesFactory) initCtx.lookup(jndiName);
			
			factoryRef.compareAndSet(null, factory);
			
			return factoryRef.get();
		} catch (Exception e) {
			throw new YoushangClientException("getPreferencesFactory error", e);
		}
	}
}
