/**
 * @PackageName:      com.bithealth.memberCore.uc.service
 * @FileName:     UCAgentService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年12月9日 下午12:36:41  
 * 
 */
package com.bithealth.memberCore.uc.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.bithealth.agentCore.agent.RedicrectService;
import com.bithealth.agentCore.bean.Parameter;
import com.bithealth.agentCore.enums.RequestMethodEnum;
import com.bithealth.agentCore.enums.UCMethodEnum;
import com.bithealth.memberCore.constants.Constrants;
import com.bithealth.sdk.client.http.Response;

/**
 * 类名称: UCAgentService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月9日 下午12:36:41 
 * 
 * @author liuhm
 * @version  
 */
public class UCAgentService {
	
	@Resource(name="RedirectImpl")
	private RedicrectService redirect;
	
	public Response getAgentResult(Object obj, UCMethodEnum method) {
		Map<String, CharSequence> param = new HashMap<String, CharSequence>();
		param.put("params", obj.toString());
		String serverId = Constrants.SERVERID;
		param.put("serverID", serverId);
		Parameter parameters = new Parameter(RequestMethodEnum.POST);
		parameters.setHost(Constrants.DNS);
		parameters.setParam(param);
		return redirect.redirect(method, parameters);
	}

}
