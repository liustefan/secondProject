/**
 * @PackageName:      com.bithealth.ucCore.uc.model
 * @FileName:     MergeInfo.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年12月12日 下午5:26:43  
 * 
 */
package com.bithealth.ucCore.uc.model;

/**
 * 类名称: MergeInfo  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月12日 下午5:26:43 
 * 
 * @author liuhm
 * @version  
 */
public class MergeInfo {
	
	private MemberBasicInfo memberTarget;

	private String sourceGuid;
	
	private int sourceSrvId;
	
	private String sessionId;
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public MemberBasicInfo getMemberTarget() {
		return memberTarget;
	}

	public void setMemberTarget(MemberBasicInfo memberTarget) {
		this.memberTarget = memberTarget;
	}

	public String getSourceGuid() {
		return sourceGuid;
	}

	public void setSourceGuid(String sourceGuid) {
		this.sourceGuid = sourceGuid;
	}

	public int getSourceSrvId() {
		return sourceSrvId;
	}

	public void setSourceSrvId(int sourceSrvId) {
		this.sourceSrvId = sourceSrvId;
	}
	
}
