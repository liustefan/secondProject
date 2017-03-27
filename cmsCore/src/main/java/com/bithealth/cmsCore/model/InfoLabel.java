/*
 * infoLabel.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-09-05 Created
 */
package com.bithealth.cmsCore.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

/**
 * [2.1]健康资讯_内容与标签关系表
 * 
 * @author ${user}
 * @version 1.0 2016-09-05
 */
public class InfoLabel extends GenericModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5191108356685657353L;
	/**
     * 自增记录ID
     */
    private Long logID;
    /**
     * 健康资讯_信息ID
     */
    private Integer HNInfoID;
    /**
     * 健康资讯_标签ID
     */
    private Integer HNLabelID;
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
    public Integer getHNInfoID() {
        return HNInfoID;
    }
    public void setHNInfoID(Integer HNInfoID) {
        this.HNInfoID = HNInfoID;
    }
    public Integer getHNLabelID() {
        return HNLabelID;
    }
    public void setHNLabelID(Integer HNLabelID) {
        this.HNLabelID = HNLabelID;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}