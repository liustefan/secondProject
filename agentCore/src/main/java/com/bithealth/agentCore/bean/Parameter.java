/**
 * @PackageName:      com.bithealth.agentCore.bean
 * @FileName:     Parameter.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月23日 上午11:07:55  
 * 
 */
package com.bithealth.agentCore.bean;

import java.util.Map;

import com.bithealth.agentCore.enums.RequestMethodEnum;

/**
 * 类名称: Parameter  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月23日 上午11:07:55 
 * 
 * @author liuhm
 * @version  
 */
public class Parameter {
	
	/**
	 * 请求：POST或者GET,默认是POST
	 */
	private RequestMethodEnum method;
	
	/**
	 * 参数key-value，例如：url?key1=val1&key2=val2
	 */
	private Map<String, CharSequence> param;
	
	/**
	 * 调用方的验权地址，调用UC服务时必须
	 */
	private String host;
	
	public Parameter(RequestMethodEnum method) {
		this.method = method;
	}
	
	public Parameter() {
		this(RequestMethodEnum.POST);
	}
	public RequestMethodEnum getMethod() {
		return method;
	}

	public void setMethod(RequestMethodEnum method) {
		this.method = method;
	}

	public Map<String, CharSequence> getParam() {
		return param;
	}

	public void setParam(Map<String, CharSequence> param) {
		this.param = param;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
}
