/*
 * MemFamilyCard.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-11 Created
 */
package com.bithealth.memberCore.member.model;

import java.util.Date;

import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 会员及家庭成员卡号表
 * 
 * @author ${user}
 * @version 1.0 2016-08-11
 */
public class MemFamilyCard extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -8013900187727153174L;
	/**
     * 记录ID
     */
    private Integer logID;
    /**
     * 本人_会员代码(引用omem)
     */
    private Integer memberid;
    /**
     * 家庭成员_会员代码(引用omem)
     */
    private Integer familyMemberid;
    /**
     * 角色：0-本人，1-爸爸，2-妈妈，3-爷爷，4-奶奶，5-儿子，6-女儿，7-其他
     */
    private Byte role;
    
    /**
     * 其他角色名
     */
    private String roleName;
    /**
     * 卡号
     */
    private String cardNo;
    /**
     * 记录创建时间
     */
    private Date createTime;
    /**
     * 记录更新时间
     */
    private Date updateTime;
    
    private Member familyMember;
    
    public Integer getLogID() {
        return logID;
    }
    public void setLogID(Integer logID) {
        this.logID = logID;
    }
    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public Integer getFamilyMemberid() {
        return familyMemberid;
    }
    public void setFamilyMemberid(Integer familyMemberid) {
        this.familyMemberid = familyMemberid;
    }
    public Byte getRole() {
        return role;
    }
    public void setRole(Byte role) {
        this.role = role;
    }
    public String getCardNo() {
        return cardNo;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
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
	public Member getFamilyMember() {
		return familyMember;
	}
	public void setFamilyMember(Member familyMember) {
		this.familyMember = familyMember;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}