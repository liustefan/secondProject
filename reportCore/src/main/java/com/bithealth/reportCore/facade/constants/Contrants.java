 

package com.bithealth.reportCore.facade.constants;

import com.bithealth.sdk.common.Env;
import com.bithealth.sdk.config.KDConfig;


public final class Contrants {
	private static KDConfig config = null;
	static{
		config = Env.getBean("rdConfig");
	}
	
	public static final Integer INTERVAL_TIME = Integer.valueOf(config.getProperty("INTERVAL_TIME"));
	

}

