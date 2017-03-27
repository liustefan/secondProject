/*
 * MemberLabel.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-09-02 Created
 */
package com.bithealth.cmsCore.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

/**
 * [2.1]健康资讯_标签与会员关系表
 * 
 * @author 周玉飞
 * @version 1.0 2016-09-02
 */
public class MemberLabel extends GenericModel {

    /**
	 * 序列化id
	 */
	private static final long serialVersionUID = -6209031155430534483L;
	/**
     * 自增记录ID
     */
    private Long logID;
    /**
     * 健康资讯_标签ID
     */
    private Integer HNLabelID;
    /**
     * 会员ID
     */
    private Integer memberID;
    /**
     * 更新时间
     */
    private Date updateTime;

    public Long getLogID() {
        return logID;
    }
    public void setLogID(Long logID) {
        this.logID = logID;
    }
    public Integer getHNLabelID() {
        return HNLabelID;
    }
    public void setHNLabelID(Integer HNLabelID) {
        this.HNLabelID = HNLabelID;
    }
    public Integer getMemberID() {
        return memberID;
    }
    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}