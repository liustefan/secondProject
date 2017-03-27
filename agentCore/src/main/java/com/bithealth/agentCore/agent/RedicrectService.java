/**
 * @PackageName:      com.bithealth.agentCore.agent
 * @FileName:     RedicrectService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月23日 上午11:01:37  
 * 
 */
package com.bithealth.agentCore.agent;

import com.bithealth.agentCore.bean.Parameter;
import com.bithealth.agentCore.enums.Method;
import com.bithealth.sdk.client.http.Response;

/**
 * 类名称: RedicrectService  
 * 功能描述: 跳转统一接口.  
 * 日期: 2016年8月23日 上午11:01:37 
 * 
 * @author liuhm
 * @version  
 */
public interface RedicrectService {
	
	/**
	 * 
	 * @Title:redirect 
	 * @Description:跳转统一接口. 
	 * @author liuhm
	 * @param method 方法枚举接口
	 * @param parameter 参数
	 * @param 
	 * @throws
	 * @retrun Response
	 */
	public Response redirect(Method method, Parameter parameter);

}
