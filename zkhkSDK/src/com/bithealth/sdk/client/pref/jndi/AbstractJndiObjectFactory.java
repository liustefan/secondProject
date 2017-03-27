package com.bithealth.sdk.client.pref.jndi;

import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

public abstract class AbstractJndiObjectFactory implements ObjectFactory {
	protected String nullSafeRefAddrStringGet(String referenceName, Reference ref) {
		RefAddr refAddr = ref.get(referenceName);

		String asString = refAddr != null ? (String) refAddr.getContent() : null;

		return asString;
	}
}
