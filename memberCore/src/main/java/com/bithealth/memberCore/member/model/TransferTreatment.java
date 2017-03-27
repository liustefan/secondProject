/*
 * TransferTreatment.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-28 Created
 */
package com.bithealth.memberCore.member.model;

import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;

/**
 * [3.0]转诊
 * 
 * @author ${user}
 * @version 1.0 2016-11-28
 */
public class TransferTreatment extends GenericModel {

    /**
     * 转诊ID
     */
    private Integer ttreatmentid;
    /**
     * 会员ID
     */
    private Integer memberid;
    /**
     * 转诊机构和科室
     */
    private String organddept;
    /**
     * 转诊原因
     */
    private String reason;
    /**
     * 转诊原因
     */
    private String result;
    /**
     * 转诊时间
     */
    private Date treattime;
    /**
     * 转诊状态：1-转诊申请，2-取消转诊，3-已转诊
     */
    private Byte treatstatus;
    /**
     * 创建医生ID
     */
    private Integer createid;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 更新医生ID
     */
    private Integer updateid;
    /**
     * 更新时间
     */
    private Date updatetime;
    
    private Date startUpdatetime;
    
    private Date endUpdatetime;
    
    private Member member;
    
    private String memname;
    
    private String createDrName;
    
    private String updateDrName;

    public Integer getTtreatmentid() {
        return ttreatmentid;
    }
    public void setTtreatmentid(Integer ttreatmentid) {
        this.ttreatmentid = ttreatmentid;
    }
    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public String getOrganddept() {
        return organddept;
    }
    public void setOrganddept(String organddept) {
        this.organddept = organddept;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    public Date getTreattime() {
        return treattime;
    }
    public void setTreattime(Date treattime) {
        this.treattime = treattime;
    }
    public Byte getTreatstatus() {
        return treatstatus;
    }
    public void setTreatstatus(Byte treatstatus) {
        this.treatstatus = treatstatus;
    }
    public Integer getCreateid() {
        return createid;
    }
    public void setCreateid(Integer createid) {
        this.createid = createid;
    }
    public Date getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    public Integer getUpdateid() {
        return updateid;
    }
    public void setUpdateid(Integer updateid) {
        this.updateid = updateid;
    }
    public Date getUpdatetime() {
        return updatetime;
    }
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
	public Date getStartUpdatetime() {
		return startUpdatetime;
	}
	public void setStartUpdatetime(Date startUpdatetime) {
		this.startUpdatetime = startUpdatetime;
	}
	public Date getEndUpdatetime() {
		return endUpdatetime;
	}
	public void setEndUpdatetime(Date endUpdatetime) {
		this.endUpdatetime = endUpdatetime;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}

	public String getMemname() {
		return memname;
	}
	public void setMemname(String memname) {
		this.memname = memname;
	}
	public String getCreateDrName() {
		return createDrName;
	}
	public void setCreateDrName(String createDrName) {
		this.createDrName = createDrName;
	}
	public String getUpdateDrName() {
		return updateDrName;
	}
	public void setUpdateDrName(String updateDrName) {
		this.updateDrName = updateDrName;
	}
	public Member createMember(){
    	this.member =  new Member();
    	return this.member;
    }
}