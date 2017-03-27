package com.bithealth.centCore.sms.constants;

import com.bithealth.sdk.common.Env;
import com.bithealth.sdk.config.KDConfig;

public final class SmsConstrants {
	private static KDConfig config = null;
	static{
		config = Env.getBean("rdConfig");
	}
	
	public static final String SMS_ALIBABA_URL = config.getProperty("sms.alibaba.url");
	
	

	


}
