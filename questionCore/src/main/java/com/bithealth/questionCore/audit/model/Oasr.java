/*
 * Oasr.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-19 Created
 */
package com.bithealth.questionCore.audit.model;

import java.util.Date;

import com.bithealth.memberCore.member.model.Member;
import com.bithealth.questionCore.answer.model.Ocam;
import com.bithealth.questionCore.answer.model.Ouai;
import com.bithealth.questionCore.question.model.Ocqt;
import com.bithealth.questionCore.question.model.Omfq;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 当生成测量报告或会员提交答卷时，根据对应的审核模板生成所有审核步骤记录
 * 
 * @author ${user}
 * @version 1.0 2016-07-19
 */
public class Oasr extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 7180149585926166654L;
	/**
     * 进度流水号
     */
    private Long serialNumber;
    /**
     * 报告单号
     */
    private Integer reportNo;
    /**
     * 选项代码
     */
    private Short optId;
    /**
     * 选项名称
     */
    private String optName;
    /**
     * 会员代码
     */
    private Integer memberid;
    /**
     * 医生分组
     */
    private Integer docGrpCode;
    /**
     * 模板代码
     */
    private Integer tempCode;
    /**
     * 测量起始时间
     */
    private Date measTime;
    /**
     * 测量终止时间
     */
    private Date measTermTime;
    /**
     * 测量次数
     */
    private Short measNum;
    /**
     * 产生时间
     */
    private Date grenerTime;
    /**
     * 审核级别
     */
    private Short auditLevel;
    /**
     * 审核状态    W: 正在审核中，N：未处理，Y：已审核
     */
    private String auditState;
    /**
     * 是否提交其他组   Y：提交，N： 不提交
     */
    private String submitOther;
    /**
     * 是否是终审  N：不是，Y： 是
     */
    private String YNTag;
    /**
     * 审核医生
     */
    private Integer docid;
    /**
     * 审核时间
     */
    private Date auditDatetime;
    
    private String tableName;
    
    private Member member;
    
    private Ouai ouai;
    
    private Omfq omfq;
    
    private Ocam ocam;
    
    private Ocqt ocqt;

    public Long getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }
    public Integer getReportNo() {
        return reportNo;
    }
    public void setReportNo(Integer reportNo) {
        this.reportNo = reportNo;
    }
    public Short getOptId() {
        return optId;
    }
    public void setOptId(Short optId) {
        this.optId = optId;
    }
    public String getOptName() {
        return optName;
    }
    public void setOptName(String optName) {
        this.optName = optName;
    }
    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public Integer getDocGrpCode() {
        return docGrpCode;
    }
    public void setDocGrpCode(Integer docGrpCode) {
        this.docGrpCode = docGrpCode;
    }
    public Integer getTempCode() {
        return tempCode;
    }
    public void setTempCode(Integer tempCode) {
        this.tempCode = tempCode;
    }
    public Date getMeasTime() {
        return measTime;
    }
    public void setMeasTime(Date measTime) {
        this.measTime = measTime;
    }
    public Date getMeasTermTime() {
        return measTermTime;
    }
    public void setMeasTermTime(Date measTermTime) {
        this.measTermTime = measTermTime;
    }
    public Short getMeasNum() {
        return measNum;
    }
    public void setMeasNum(Short measNum) {
        this.measNum = measNum;
    }
    public Date getGrenerTime() {
        return grenerTime;
    }
    public void setGrenerTime(Date grenerTime) {
        this.grenerTime = grenerTime;
    }
    public Short getAuditLevel() {
        return auditLevel;
    }
    public void setAuditLevel(Short auditLevel) {
        this.auditLevel = auditLevel;
    }
    public String getAuditState() {
        return auditState;
    }
    public void setAuditState(String auditState) {
        this.auditState = auditState;
    }
    public String getSubmitOther() {
        return submitOther;
    }
    public void setSubmitOther(String submitOther) {
        this.submitOther = submitOther;
    }
    public String getYNTag() {
        return YNTag;
    }
    public void setYNTag(String YNTag) {
        this.YNTag = YNTag;
    }
    public Integer getDocid() {
        return docid;
    }
    public void setDocid(Integer docid) {
        this.docid = docid;
    }
    public Date getAuditDatetime() {
        return auditDatetime;
    }
    public void setAuditDatetime(Date auditDatetime) {
        this.auditDatetime = auditDatetime;
    }
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Ouai getOuai() {
		return ouai;
	}
	public void setOuai(Ouai ouai) {
		this.ouai = ouai;
	}
	public Omfq getOmfq() {
		return omfq;
	}
	public void setOmfq(Omfq omfq) {
		this.omfq = omfq;
	}
	public Ocam getOcam() {
		return ocam;
	}
	public void setOcam(Ocam ocam) {
		this.ocam = ocam;
	}
	public Ocqt getOcqt() {
		return ocqt;
	}
	public void setOcqt(Ocqt ocqt) {
		this.ocqt = ocqt;
	}
	
	
    
}