package com.bithealth.sdk.config;

import java.util.Properties;

public interface KDConfig {
	String getProperty(String key);

	Properties getProperties();

	Properties getPropertiesByKey(String pre_key);
}
