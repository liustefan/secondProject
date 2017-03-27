package com.bithealth.centCore.care.constants;

import com.bithealth.sdk.common.Env;
import com.bithealth.sdk.config.KDConfig;

public final class Constrants {
	private static KDConfig config = null;
	static{
		config = Env.getBean("rdConfig");
	}
	
	//public static final String SERVER_ID = config.getProperty("zkhk.serverId");
	
	
	//public static final String UC_DNS = config.getProperty("zkhk.DNS");
	
	
    /** 数据源1：UnifiedCertification数据库 **/ 
    public static final String  DATA_SOURCE_1= "dataSource1";
    /** 数据源2：appRecode数据库  **/ 
    public static final String  DATA_SOURCE_2 = "dataSource2";
    
    public static final String  IS_HTTPS_REQUEST = "1";

}
