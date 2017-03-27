/*
 * HealthnewsBookmark.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-26 Created
 */
package com.bithealth.cmsCore.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

/**
 * [2.1]健康资讯_收藏表
 * 
 * @author ${user}
 * @version 1.0 2016-08-26
 */
public class HealthnewsBookmark extends GenericModel {

    /**
	 * 序列化id
	 */
	private static final long serialVersionUID = 6188888822412435887L;
	/**
     * 记录ID
     */
    private Long logid;
    /**
     * 健康资讯ID
     */
    private Integer hninfoid;
    /**
     * 会员ID
     */
    private Integer memberid;
    /**
     * 更新时间
     */
    private Date updatetime;

    public Long getLogid() {
        return logid;
    }
    public void setLogid(Long logid) {
        this.logid = logid;
    }
    public Integer getHninfoid() {
        return hninfoid;
    }
    public void setHninfoid(Integer hninfoid) {
        this.hninfoid = hninfoid;
    }
    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public Date getUpdatetime() {
        return updatetime;
    }
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}