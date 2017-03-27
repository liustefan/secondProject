package com.bithealth.sdk.  client.common;

import java.util.Date;

public interface PlatformClientServiceMBean {
	String getURL();
	
	void setURL(String url);

	long getInvokeCount();
	
	long getInvokeSuccessCount();
	
	long getInvokeFailedCount();
	
	long getInvokeTotalTimespan();
	
	Date getInvokeLastTime();
}
