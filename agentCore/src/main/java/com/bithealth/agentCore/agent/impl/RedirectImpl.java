/**
 * @PackageName:      com.bithealth.agentCore.agent.impl
 * @FileName:     RedirectImpl.java  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月23日 上午11:26:02  
 * 
 */
package com.bithealth.agentCore.agent.impl;


import org.springframework.stereotype.Service;

import com.bithealth.agentCore.agent.RedicrectService;
import com.bithealth.agentCore.bean.Parameter;
import com.bithealth.agentCore.enums.Method;
import com.bithealth.agentCore.enums.RequestMethodEnum;
import com.bithealth.sdk.client.http.HttpUtils;
import com.bithealth.sdk.client.http.Response;

/**
 * 类名称: RedirectImpl  
 * 功能描述: 跳转接口实现类.  
 * 日期: 2016年8月23日 上午11:26:02 
 * 
 * @author liuhm
 * @version  
 */
@Service("RedirectImpl")
public class RedirectImpl implements RedicrectService {

	@Override
	public Response redirect(Method method, Parameter parameter) {
		RequestMethodEnum request = parameter.getMethod();
		if(request != null && request == RequestMethodEnum.GET) {
			return HttpUtils.sendGet(method.getUrl(), parameter.getParam(), parameter.getHost());
		} else {
			return HttpUtils.sendPost(method.getUrl(), parameter.getParam(), parameter.getHost());
		}
	}
	

}
