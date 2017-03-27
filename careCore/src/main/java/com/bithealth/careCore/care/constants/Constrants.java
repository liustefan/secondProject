package com.bithealth.careCore.care.constants;

import com.bithealth.sdk.common.Env;
import com.bithealth.sdk.config.KDConfig;

public final class Constrants {
	private static KDConfig config = null;
	static{
		config = Env.getBean("rdConfig");
	}
	
	//public static final String SERVER_ID = config.getProperty("zkhk.serverId");
	
	
	//public static final String UC_DNS = config.getProperty("zkhk.DNS");
	
	public static final int MAX_SEND_NUM = 1000;

}
