/**
 * @PackageName:      com.bithealth.ucCore.uc.result
 * @FileName:     MergeResult.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年12月12日 下午5:02:39  
 * 
 */
package com.bithealth.ucCore.uc.result;

import com.bithealth.ucCore.uc.model.RegisterResult;

/**
 * 类名称: MergeResult  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月12日 下午5:02:39 
 * 
 * @author liuhm
 * @version  
 */
public class MergeResult extends RegisterResult {
	
	private int srvId;
	
	private String appSrvUrl;
	
	private String password;
	
	private String sessionId;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public MergeResult() {
		super();
	}

	public MergeResult(String guid, Integer code, String message) {
		super(guid, code, message);
	}
	
	public MergeResult(String guid, Integer code, String message,int srvId, String appSrvUrl) {
		super(guid, code, message);
		this.appSrvUrl = appSrvUrl;
		this.srvId = srvId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSrvId() {
		return srvId;
	}

	public void setSrvId(int srvId) {
		this.srvId = srvId;
	}

	public String getAppSrvUrl() {
		return appSrvUrl;
	}

	public void setAppSrvUrl(String appSrvUrl) {
		this.appSrvUrl = appSrvUrl;
	}
	
}
