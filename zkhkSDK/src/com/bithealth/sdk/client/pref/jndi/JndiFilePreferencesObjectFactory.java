package com.bithealth.sdk.client.pref.jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.bithealth.sdk.client.pref.PreferencesFactory;
import com.bithealth.sdk.client.pref.impl.FileSystemPreferencesFactory;
 


public class JndiFilePreferencesObjectFactory extends AbstractJndiObjectFactory implements ObjectFactory {
	private static Log LOG = LogFactory.getLog(JndiFilePreferencesObjectFactory.class);
	
	public Object getObjectInstance(Object refObj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
		Reference ref = (Reference) refObj;
		
		String className = ref.getClassName();
		
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
		
		if (!PreferencesFactory.class.isAssignableFrom(clazz)) {
			throw new IllegalStateException("not support class '" + className + "'");
		}
		
		String path = nullSafeRefAddrStringGet("path", ref);
		if (path != null && path.length() != 0) {
			FileSystemPreferencesFactory factory = new FileSystemPreferencesFactory(path);
			
			if (LOG.isInfoEnabled()) {
				LOG.info("preferences factory created");
			}
			
			return factory;
		}
		
		return null;
	}
}
