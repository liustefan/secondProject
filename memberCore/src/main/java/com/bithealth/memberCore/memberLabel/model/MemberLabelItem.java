/*
 * MemberLabelItem.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-02 Created
 */
package com.bithealth.memberCore.memberLabel.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

/**
 * [3.0]会员与标签小项关系
 * 
 * @author ${user}
 * @version 1.0 2016-12-02
 */
public class MemberLabelItem extends GenericModel {

    /**
     * 记录ID
     */
    private Integer logID;
    /**
     * 会员ID
     */
    private Integer memberID;
    /**
     * 标签小项ID
     */
    private Integer LItemID;
    /**
     * 更新时间
     */
    private Date updateTime;
    
    private String itemName;
    
    public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public MemberLabelItem(){
    	this.updateTime = new java.sql.Date(System.currentTimeMillis());
    }
    public MemberLabelItem(Integer memberID, Integer LItemID){
    	this.updateTime = new java.sql.Date(System.currentTimeMillis());
    	this.LItemID = LItemID;
    	this.memberID = memberID;
    }

    public Integer getLogID() {
        return logID;
    }
    public void setLogID(Integer logID) {
        this.logID = logID;
    }
    public Integer getMemberID() {
        return memberID;
    }
    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }
    public Integer getLItemID() {
        return LItemID;
    }
    public void setLItemID(Integer LItemID) {
        this.LItemID = LItemID;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}