/*
 * MemberMerge.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-21 Created
 */
package com.bithealth.taskMgrCore.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

/**
 * [3.0]日志_同步
 * 
 * @author ${user}
 * @version 1.0 2016-12-21
 */
public class MemberMerge extends GenericModel {

    /**
     * 记录ID
     */
    private Long logID;
    /**
     * 模块类型：1-测量数据，2-好友圈，3-问卷
     */
    private Byte moduleType;
    /**
     * 源服务器ID
     */
    private Integer sourceServiceID;
    /**
     * 源会员GUID
     */
    private String sourceMemberID;
    /**
     * 目标服务器ID
     */
    private Integer targetServiceID;
    /**
     * 目标会员GUID
     */
    private String targetMemberID;
    /**
     * 同步状态：1-待同步，2-同步中，3-成功，4-失败
     */
    private Byte syncStatus;
    /**
     * 同步开始时间
     */
    private Date syncSTime;
    /**
     * 同步结束时间
     */
    private Date syncETime;
    /**
     * 失败原因
     */
    private String failReason;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    
    
    //额外增加的参数
    
    private String targetURL;
    
    private Integer memberId;
    
    
    public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getTargetURL() {
		return targetURL;
	}
	public void setTargetURL(String targetURL) {
		this.targetURL = targetURL;
	}
	public Long getLogID() {
        return logID;
    }
    public void setLogID(Long logID) {
        this.logID = logID;
    }
    public Byte getModuleType() {
        return moduleType;
    }
    public void setModuleType(Byte moduleType) {
        this.moduleType = moduleType;
    }
    public Integer getSourceServiceID() {
        return sourceServiceID;
    }
    public void setSourceServiceID(Integer sourceServiceID) {
        this.sourceServiceID = sourceServiceID;
    }
    public String getSourceMemberID() {
        return sourceMemberID;
    }
    public void setSourceMemberID(String sourceMemberID) {
        this.sourceMemberID = sourceMemberID;
    }
    public Integer getTargetServiceID() {
        return targetServiceID;
    }
    public void setTargetServiceID(Integer targetServiceID) {
        this.targetServiceID = targetServiceID;
    }
    public String getTargetMemberID() {
        return targetMemberID;
    }
    public void setTargetMemberID(String targetMemberID) {
        this.targetMemberID = targetMemberID;
    }
    public Byte getSyncStatus() {
        return syncStatus;
    }
    public void setSyncStatus(Byte syncStatus) {
        this.syncStatus = syncStatus;
    }
    public Date getSyncSTime() {
        return syncSTime;
    }
    public void setSyncSTime(Date syncSTime) {
        this.syncSTime = syncSTime;
    }
    public Date getSyncETime() {
        return syncETime;
    }
    public void setSyncETime(Date syncETime) {
        this.syncETime = syncETime;
    }
    public String getFailReason() {
        return failReason;
    }
    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}