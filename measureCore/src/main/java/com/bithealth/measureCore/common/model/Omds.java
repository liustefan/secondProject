/*
 * Omds.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-05 Created
 */
package com.bithealth.measureCore.common.model;

import com.bithealth.memberCore.member.model.Member;
import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;

/**
 * 测量数据记录表（OMDS）
 * 
 * @author ${user}
 * @version 1.0 2016-07-05
 */
public class Omds extends GenericModel {

    private Long eventid;
    /**
     * 会员代码
     */
    private Integer memberid;
    /**
     * 测试时长
     */
    private Integer timelength;
    /**
     * 上传时间
     */
    private Date uploadtime;
    /**
     * 事件类型
     */
    private String eventtype;
    /**
     * 是否有异常
     */
    private String wheabntag;
    /**
     * 分析完成状态
     */
    private Short statustag;
    
    private int tableNum;
    
    private Member member;
    
    private Date measureTime;
    
    private String typeName;

    public Long getEventid() {
        return eventid;
    }
    public void setEventid(Long eventid) {
        this.eventid = eventid;
    }
    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public Integer getTimelength() {
        return timelength;
    }
    public void setTimelength(Integer timelength) {
        this.timelength = timelength;
    }
    public Date getUploadtime() {
        return uploadtime;
    }
    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }
    public String getEventtype() {
        return eventtype;
    }
    public void setEventtype(String eventtype) {
        this.eventtype = eventtype;
    }
    public String getWheabntag() {
        return wheabntag;
    }
    public void setWheabntag(String wheabntag) {
        this.wheabntag = wheabntag;
    }
    public Short getStatustag() {
        return statustag;
    }
    public void setStatustag(Short statustag) {
        this.statustag = statustag;
    }
	public int getTableNum() {
		return tableNum;
	}
	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Date getMeasureTime() {
		return measureTime;
	}
	public void setMeasureTime(Date measureTime) {
		this.measureTime = measureTime;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}