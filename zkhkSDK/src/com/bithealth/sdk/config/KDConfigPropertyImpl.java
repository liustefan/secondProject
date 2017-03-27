package com.bithealth.sdk.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;


public class KDConfigPropertyImpl implements KDConfig {
	private static Logger LOG = Logger.getLogger(KDConfig.class);
	protected String configFile;
	protected final Properties pro = new Properties();

	public KDConfigPropertyImpl(String cfgFile) {
		this.configFile = cfgFile;
		configure();
	}

	public String getProperty(String key) {
		return pro.getProperty(key);
	}

	public String getProperty(String key, String defaultValue) {
		return pro.getProperty(key, defaultValue);
	}

	/**
	 * 不存在，或者不为int型时，返回-1
	 * 
	 * @param key
	 * @return
	 */
	public int getIntProperty(String key) {
		return getIntProperty(key, -1);
	}

	/**
	 * 不存在，或者不为int型时，返回默认值
	 * 
	 * @param key
	 * @return
	 */
	public int getIntProperty(String key, int defaultValue) {
		String temp = pro.getProperty(key);
		if (temp == null) return defaultValue;
		try {
			return Integer.parseInt(temp);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	/**
	 * 不存在，或者不为int型时，返回-1
	 * 
	 * @param key
	 * @return
	 */
	public double getDoubleProperty(String key) {
		return getDoubleProperty(key, -1);
	}

	/**
	 * 不存在，或者不为int型时，返回默认值
	 * 
	 * @param key
	 * @return
	 */
	public double getDoubleProperty(String key, double defaultValue) {
		String temp = pro.getProperty(key);
		if (temp == null) return defaultValue;
		try {
			return Double.parseDouble(temp);
		} catch (NumberFormatException e) {
			return defaultValue;
		}
	}

	/**
	 * 获取一组properties
	 * 
	 * @param pre_key
	 * @return
	 */
	public Properties getPropertiesByKey(String pre_key) {
		Properties proTemp = new Properties();
		Iterator<Object> it = pro.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			if (key.startsWith(pre_key)) {
				String temp = key.substring(pre_key.length(), key.length());
				proTemp.put(temp, pro.getProperty(key));
			}
		}
		return proTemp;
	}

	protected void configure() {
		InputStream ins = KDConfig.class.getClassLoader().getResourceAsStream(configFile);
		try {
			pro.load(ins);
		} catch (Exception e) {
			LOG.error("载入系统配制参数出错", e);
		} finally {
			if (ins != null) {
				try {
					ins.close();
				} catch (IOException e) {}
				ins = null;
			}
		}
	}

	public Properties getProperties() {
		return pro;
	}
}
