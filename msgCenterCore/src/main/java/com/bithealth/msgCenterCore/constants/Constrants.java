package com.bithealth.msgCenterCore.constants;

import com.bithealth.sdk.common.Env;
import com.bithealth.sdk.config.KDConfig;

public class Constrants {
	private static KDConfig config = null;
	static{
		config = Env.getBean("rdConfig");
	}
	
	public static final String SERVERID = config.getProperty("SERVERID");
	
}
