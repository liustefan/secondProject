/*
 * SingleReport.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-20 Created
 */
package com.bithealth.reportCore.report.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardioPulse.model.Oppg;
import com.bithealth.sdk.core.generic.GenericModel;


/**
 * 单项测量报告（OMRR）
 * 
 * @author ${user}
 * @version 1.0 2016-07-20
 */
public class SingleReport extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ID;
    /**
     * 组织代码
     */
    private Integer orgId;
    /**
     * 报告编号
     */
    private String reportCode;
    /**
     * 模板代码
     */
    private Integer tempCode;
    /**
     * 会员代码
     */
    private Integer memberid;
    /**
     * 选项代码
     */
    private Short optId;
    /**
     * 产生时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date grenerTime;
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
    private Integer measNum;
    /**
     * 测量对应起始号
     */
    private Long measCorrNo;
    /**
     * 测量对应终止号
     */
    private Long measCorrTermNo;
    /**
     * 报告状态
     */
    private String reportState;
    /**
     * 待审级别
     */
    private Short pendingLevel;
    /**
     * 退审理由
     */
    private String retrialBackTag;
    /**
     * 退审理由
     */
    private String approvalReason;
    /**
     * 审核内容
     */
    private String chkDesc;
    
    /**
     * 单项报告审核明细
     */
    private List<SingleReportAudit>  auditList;
    
    
    /**
     * 额外封装参数：审核级别
     */
    private Short auditLevel;
    
    /**
     *  额外封装参数：会员姓名
     */
    private String memName;
    
    /**
     *  额外封装参数：模板名
     */
    private String templateName;
     
    
	private List<Oppg> oppgs;
	private List<Oecg> oecgs;
	private List<Obsr> obsrs;
	private List<Osbp> osbps;
    
    public List<Oppg> getOppgs() {
		return oppgs;
	}
	public void setOppgs(List<Oppg> oppgs) {
		this.oppgs = oppgs;
	}
	public List<Oecg> getOecgs() {
		return oecgs;
	}
	public void setOecgs(List<Oecg> oecgs) {
		this.oecgs = oecgs;
	}
	public List<Obsr> getObsrs() {
		return obsrs;
	}
	public void setObsrs(List<Obsr> obsrs) {
		this.obsrs = obsrs;
	}
	public List<Osbp> getOsbps() {
		return osbps;
	}
	public void setOsbps(List<Osbp> osbps) {
		this.osbps = osbps;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public Short getAuditLevel() {
		return auditLevel;
	}
	public void setAuditLevel(Short auditLevel) {
		this.auditLevel = auditLevel;
	}
	public List<SingleReportAudit> getAuditList() {
		return auditList;
	}
	public void setAuditList(List<SingleReportAudit> auditList) {
		this.auditList = auditList;
	}
	public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }
    public Integer getOrgId() {
        return orgId;
    }
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
    public String getReportCode() {
        return reportCode;
    }
    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }
    public Integer getTempCode() {
        return tempCode;
    }
    public void setTempCode(Integer tempCode) {
        this.tempCode = tempCode;
    }
    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public Short getOptId() {
        return optId;
    }
    public void setOptId(Short optId) {
        this.optId = optId;
    }
    public Date getGrenerTime() {
        return grenerTime;
    }
    public void setGrenerTime(Date grenerTime) {
        this.grenerTime = grenerTime;
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
    public Integer getMeasNum() {
        return measNum;
    }
    public void setMeasNum(Integer measNum) {
        this.measNum = measNum;
    }
    public Long getMeasCorrNo() {
        return measCorrNo;
    }
    public void setMeasCorrNo(Long measCorrNo) {
        this.measCorrNo = measCorrNo;
    }
    public Long getMeasCorrTermNo() {
        return measCorrTermNo;
    }
    public void setMeasCorrTermNo(Long measCorrTermNo) {
        this.measCorrTermNo = measCorrTermNo;
    }
    public String getReportState() {
        return reportState;
    }
    public void setReportState(String reportState) {
        this.reportState = reportState;
    }
    public Short getPendingLevel() {
        return pendingLevel;
    }
    public void setPendingLevel(Short pendingLevel) {
        this.pendingLevel = pendingLevel;
    }
    public String getRetrialBackTag() {
        return retrialBackTag;
    }
    public void setRetrialBackTag(String retrialBackTag) {
        this.retrialBackTag = retrialBackTag;
    }
    public String getApprovalReason() {
        return approvalReason;
    }
    public void setApprovalReason(String approvalReason) {
        this.approvalReason = approvalReason;
    }
    public String getChkDesc() {
        return chkDesc;
    }
    public void setChkDesc(String chkDesc) {
        this.chkDesc = chkDesc;
    }
}