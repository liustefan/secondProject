/*
 * Bookmark.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-10-13 Created
 */
package com.bithealth.cmsCore.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

/**
 * [2.1]健康资讯_收藏表
 * 
 * @author ${user}
 * @version 1.0 2016-10-13
 */
public class Bookmark extends GenericModel {

    /**
     * 记录ID
     */
    private Long logID;
    /**
     * 健康资讯ID
     */
    private Integer HNInfoID;
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
    public Integer getHNInfoID() {
        return HNInfoID;
    }
    public void setHNInfoID(Integer HNInfoID) {
        this.HNInfoID = HNInfoID;
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