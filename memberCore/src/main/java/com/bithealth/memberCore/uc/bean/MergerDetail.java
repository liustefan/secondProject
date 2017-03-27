/**
 * @PackageName:      com.bithealth.memberCore.uc.bean
 * @FileName:     MergerDetail.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年12月9日 上午11:19:14  
 * 
 */
package com.bithealth.memberCore.uc.bean;

/**
 * 类名称: MergerDetail  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月9日 上午11:19:14 
 * 
 * @author liuhm
 * @version  
 */
public class MergerDetail {
    private String sourceGuid;
	
	private int sourceSrvId;
	
	private String sourceAppSrvUrl;
	
	private String sourceSessionID;
	
	private String targetGuid;
	
	private int targetSrvId;
	
	private String targetAppSrvUrl;

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

	public String getSourceAppSrvUrl() {
		return sourceAppSrvUrl;
	}

	public void setSourceAppSrvUrl(String sourceAppSrvUrl) {
		this.sourceAppSrvUrl = sourceAppSrvUrl;
	}

	public String getSourceSessionID() {
		return sourceSessionID;
	}

	public void setSourceSessionID(String sourceSessionID) {
		this.sourceSessionID = sourceSessionID;
	}

	public String getTargetGuid() {
		return targetGuid;
	}

	public void setTargetGuid(String targetGuid) {
		this.targetGuid = targetGuid;
	}

	public int getTargetSrvId() {
		return targetSrvId;
	}

	public void setTargetSrvId(int targetSrvId) {
		this.targetSrvId = targetSrvId;
	}

	public String getTargetAppSrvUrl() {
		return targetAppSrvUrl;
	}

	public void setTargetAppSrvUrl(String targetAppSrvUrl) {
		this.targetAppSrvUrl = targetAppSrvUrl;
	}

}
