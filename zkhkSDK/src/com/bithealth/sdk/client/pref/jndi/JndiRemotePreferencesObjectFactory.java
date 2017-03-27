package com.bithealth.sdk.client.pref.jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

import com.bithealth.sdk.client.http.SignUtils;
import com.bithealth.sdk.client.pref.Preferences;
import com.bithealth.sdk.client.pref.PreferencesService;
 

/**
 * 
 * <p>[No description]<p>
 * 
 * @author szujobs
 * @created 2009-4-10 下午10:51:01
 */
public class JndiRemotePreferencesObjectFactory extends AbstractJndiObjectFactory implements ObjectFactory {
	public Object getObjectInstance(Object refObj, Name nm, Context ctx, Hashtable<?, ?> env) throws Exception {
		Reference ref = (Reference) refObj;

		if (!Preferences.class.getName().equals(ref.getClassName())) {
			return null;
		}
		
		PreferencesService service = new PreferencesService();
		
		String url = nullSafeRefAddrStringGet("url", ref);
		if (url != null && url.length() != 0) {
			service.setURL(url);
		}
		
		String vendor = nullSafeRefAddrStringGet("vendor", ref);
		if (vendor != null && vendor.length() != 0) {
			service.setVendor(url);
		} else {
			service.setVendor(null);
		}
		
		String application = nullSafeRefAddrStringGet("application", ref);
		if (application != null && application.length() != 0) {
			service.setApplication(url);
		} else {
			service.setApplication(null);
		}

		String privateKeyString = nullSafeRefAddrStringGet("privateKey", ref);
		if (privateKeyString != null && privateKeyString.length() != 0) {
			service.setPrivateKey(SignUtils.getPrivateKey(privateKeyString));
		}
		
		return service;
	}
}
