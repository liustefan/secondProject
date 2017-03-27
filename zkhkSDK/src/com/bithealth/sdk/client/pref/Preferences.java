package com.bithealth.sdk.client.pref;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Preferences {


	private String name; // 配置的显示名称，可重复

	private String description; // 配置的描述信息

	private Map<String, Object> items = new HashMap<String, Object>();

	public Preferences() {}



	/**
	 * 配置的显示名称，可重复
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置配置的显示名称，可重复
	 * 
	 * @param name 配置的显示名称，可重复
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 配置的描述信息
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设置配置的描述信息
	 * 
	 * @param description 配置的描述信息
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public Object get(String key) {
		return items.get(key);
	}

	public Object put(String key, Object value) {
		return items.put(key, value);
	}
	
	public boolean containsKey(String key) {
		return items.containsKey(key);
	}
	
	public Set<Map.Entry<String, Object>> entrySet() {
		return items.entrySet();
	}
	
	public String toString() {
		return items.toString();
	}
}
