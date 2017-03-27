/*
 * SingleReportAudit.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-25 Created
 */
package com.bithealth.reportCore.report.model;

import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;

/**
 * 单项测量报告审核结果（MRR1）
 * 
 * @author ${user}
 * @version 1.0 2016-07-25
 */
public class SingleReportAudit extends GenericModel {

    private Integer logid;
    private Integer ID;
    /**
     * 医生分组
     */
    private Integer docGrpCode;
    /**
     * 审核级别
     */
    private Short auditLevel;
    /**
     * 审核医生
     */
    private Integer docid;
    /**
     * 审核意见
     */
    private String auditDesc;
    /**
     * 审核时间
     */
    private Date auditTime;
    /**
     * 审核方式
     */
    private String auditMode;
    
    
    private String doctorName;
    
    private String signaddress;
    
    private String docGrpName;
    
    public String getDocGrpName() {
		return docGrpName;
	}
	public void setDocGrpName(String docGrpName) {
		this.docGrpName = docGrpName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSignaddress() {
		return signaddress;
	}
	public void setSignaddress(String signaddress) {
		this.signaddress = signaddress;
	}
	public Integer getLogid() {
        return logid;
    }
    public void setLogid(Integer logid) {
        this.logid = logid;
    }
    public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }
    public Integer getDocGrpCode() {
        return docGrpCode;
    }
    public void setDocGrpCode(Integer docGrpCode) {
        this.docGrpCode = docGrpCode;
    }
    public Short getAuditLevel() {
        return auditLevel;
    }
    public void setAuditLevel(Short auditLevel) {
        this.auditLevel = auditLevel;
    }
    public Integer getDocid() {
        return docid;
    }
    public void setDocid(Integer docid) {
        this.docid = docid;
    }
    public String getAuditDesc() {
        return auditDesc;
    }
    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }
    public Date getAuditTime() {
        return auditTime;
    }
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }
    public String getAuditMode() {
        return auditMode;
    }
    public void setAuditMode(String auditMode) {
        this.auditMode = auditMode;
    }
}