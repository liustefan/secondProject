package com.bithealth.sdk.  client.common;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

import com.bithealth.sdk.client.http.SignUtils;
 

public class PlatformClientServiceObjectFactory implements ObjectFactory {

	public Object getObjectInstance(Object refObj, Name nm, Context ctx, Hashtable<?, ?> env) throws Exception {
		Reference ref = (Reference) refObj;
		String className = ref.getClassName();

		PlatformClientService service = null;

		Class<?> clazz = null;
		try {
			clazz = Thread.currentThread().getContextClassLoader().loadClass(className);
		} catch (ClassNotFoundException e) {
			// skip
		}
		if (clazz == null) {
			try {
				clazz = Class.forName(className);
			} catch (ClassNotFoundException e) {
				// skip
			}
		}
		
		if (clazz == null) {
			throw new ClassNotFoundException(className);
		}
		
		try {
			if (!PlatformClientService.class.isAssignableFrom(clazz)) {
				return null;
			}

			service = (PlatformClientService) clazz.newInstance();
		} catch (Exception ex) {
			throw new RuntimeException("Unable to create DataSource of " + "class '" + className + "', reason: " + ex.toString());
		}

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

	private String nullSafeRefAddrStringGet(String referenceName, Reference ref) {
		RefAddr refAddr = ref.get(referenceName);

		String asString = refAddr != null ? (String) refAddr.getContent() : null;

		return asString;
	}
}
