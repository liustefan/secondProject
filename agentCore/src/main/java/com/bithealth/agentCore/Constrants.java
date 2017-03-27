package com.bithealth.agentCore;

import com.bithealth.sdk.common.Env;
import com.bithealth.sdk.config.KDConfig;

public final class Constrants {
	private static KDConfig config = null;
	static{
		config = Env.getBean("rdConfig");
	}
	
	public static final String UC_URL = config.getProperty("UC.UNIFIEDAUTH");
	
	
	public static final String PUSH_URL = config.getProperty("PUSH.URL");
	
	
	public static final String MESSAGE_URL = config.getProperty("MESSAGE.URL");

}
