/*
 * MemberMovment.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-25 Created
 */
package com.bithealth.memberCore.member.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;

/**
 * [3.0]会员转移
 * 
 * @author ${user}
 * @version 1.0 2016-11-25
 */
public class MemberMovment extends GenericModel {

    /**
     * 转移ID
     */
    private Integer MMovementID;
    /**
     * 会员ID
     */
    private Integer memberID;
    /**
     * 转出组织ID
     */
    private Integer outOrgID;
    /**
     * 转出确认医生
     */
    private Integer outDrID;
    /**
     * 转入组织ID
     */
    private Integer inOrgID;
    /**
     * 转入分组ID列表，以逗号拼接
     */
    private String inMemGrpidList;
    /**
     * 转移状态：1-待确认，2-已同意，3-已拒绝
     */
    private Byte moveStatus;
    /**
     * 确认时间
     */
    private Date confirmTime;
    /**
     * 拒绝原因
     */
    private String refuseReason;
    /**
     * 创建医生ID
     */
    private Integer createID;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新医生ID
     */
    private Integer updateID;
    /**
     * 更新时间
     */
    private Date updateTime;
    
    private Member member;
    
    private String outDrName;
    
    private String createDrName;
    
    private String groupNames;
    
    private String outOrgName;
    
    private String inOrgName;
    
    public String getOutOrgName() {
		return outOrgName;
	}
	public void setOutOrgName(String outOrgName) {
		this.outOrgName = outOrgName;
	}
	public String getInOrgName() {
		return inOrgName;
	}
	public void setInOrgName(String inOrgName) {
		this.inOrgName = inOrgName;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getOutDrName() {
		return outDrName;
	}
	public void setOutDrName(String outDrName) {
		this.outDrName = outDrName;
	}
	public String getCreateDrName() {
		return createDrName;
	}
	public void setCreateDrName(String createDrName) {
		this.createDrName = createDrName;
	}
	public Integer getMMovementID() {
        return MMovementID;
    }
    public void setMMovementID(Integer MMovementID) {
        this.MMovementID = MMovementID;
    }
    public Integer getMemberID() {
        return memberID;
    }
    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }
    public Integer getOutOrgID() {
        return outOrgID;
    }
    public void setOutOrgID(Integer outOrgID) {
        this.outOrgID = outOrgID;
    }
    public Integer getOutDrID() {
        return outDrID;
    }
    public void setOutDrID(Integer outDrID) {
        this.outDrID = outDrID;
    }
    public Integer getInOrgID() {
        return inOrgID;
    }
    public void setInOrgID(Integer inOrgID) {
        this.inOrgID = inOrgID;
    }
    public String getInMemGrpidList() {
        return inMemGrpidList;
    }
    public void setInMemGrpidList(String inMemGrpidList) {
        this.inMemGrpidList = inMemGrpidList;
    }
    public Byte getMoveStatus() {
        return moveStatus;
    }
    public void setMoveStatus(Byte moveStatus) {
        this.moveStatus = moveStatus;
    }
    public Date getConfirmTime() {
        return confirmTime;
    }
    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }
    public String getRefuseReason() {
        return refuseReason;
    }
    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }
    public Integer getCreateID() {
        return createID;
    }
    public void setCreateID(Integer createID) {
        this.createID = createID;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Integer getUpdateID() {
        return updateID;
    }
    public void setUpdateID(Integer updateID) {
        this.updateID = updateID;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
	public String getGroupNames() {
		return groupNames;
	}
	public void setGroupNames(String groupNames) {
		this.groupNames = groupNames;
	}
	@Override
	public String toString() {
		return "MemberMovment [MMovementID=" + MMovementID + ", memberID="
				+ memberID + ", outOrgID=" + outOrgID + ", outDrID=" + outDrID
				+ ", inOrgID=" + inOrgID + ", inMemGrpidList=" + inMemGrpidList
				+ ", moveStatus=" + moveStatus + ", confirmTime=" + confirmTime
				+ ", refuseReason=" + refuseReason + ", createID=" + createID
				+ ", createTime=" + createTime + ", updateID=" + updateID
				+ ", updateTime=" + updateTime + ", member=" + member
				+ ", outDrName=" + outDrName + ", createDrName=" + createDrName
				+ ", groupNames=" + groupNames + "]";
	}
    
}