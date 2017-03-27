package com.bithealth.sdk.client.pref;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.StringRefAddr;

import com.bithealth.sdk.client.common.PlatformClientService;
import com.bithealth.sdk.client.common.PlatformClientServiceConfig;
import com.bithealth.sdk.client.utils.Hex;
import com.bithealth.sdk.client.utils.PlatformClientUtils;
 


@SuppressWarnings("serial")
public class PreferencesService extends PlatformClientService implements PreferencesServiceMBean, PreferencesFactory {
	public static final String CONFIG_NAME = "zkhk.platform.service.pref.url";
	
	private static final AtomicReference<PreferencesService> instanceRef = new AtomicReference<PreferencesService>();
	
	public PreferencesService(String url) {
		super(url);
	}
	
	public PreferencesService() {
		super(PlatformClientServiceConfig.getProperties().getProperty(CONFIG_NAME));
	}
	
	@SuppressWarnings("unchecked")
	public Preferences getPreferences(String prefName) {
		Preferences pref = new Preferences();

		Map<String, Object> map = (Map<String, Object>) super.invoke("getPreferences", prefName);
		
		if (map == null) {
			return null;
		}
		
		pref.setName((String) map.get("name"));
		pref.setDescription((String) map.get("description"));
		
		Map<String, Object> items = (Map<String, Object>) map.get("items");
		for (Entry<String, Object> entry : items.entrySet()) {
			pref.put(entry.getKey(), entry.getValue());
		}
		
		return pref;
	}
	
	public void setPreferences(Preferences pref) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", pref.getName());
		params.put("description", pref.getDescription());
		
		Map<String, Object> items = new HashMap<String, Object>();
		for (Map.Entry<String, Object> entry : pref.entrySet()) {
			items.put(entry.getKey(), entry.getValue());
		}
		
		params.put("items", items);
		
		super.invoke("setPreferences", params);
	}

	public static PreferencesService getInstance() {
		PreferencesService inst = instanceRef.get();
		if (inst == null) {
			PreferencesService newInst = new PreferencesService();
			if (instanceRef.compareAndSet(null, newInst)) {
				PlatformClientUtils.registerJMX(newInst, "PreferencesService");
			}
			inst = instanceRef.get();
		}
		return inst;
	}

	public Reference getReference() throws NamingException {
		String factoryName = "com.mysql.jdbc.jdbc2.optional.MysqlDataSourceFactory";
		Reference ref = new Reference(getClass().getName(), factoryName, null);
		ref.add(new StringRefAddr("url", getURL()));
		ref.add(new StringRefAddr("privateKey", new String(Hex.encodeHex(getPrivateKey().getEncoded()))));
		return ref;
	}
}
