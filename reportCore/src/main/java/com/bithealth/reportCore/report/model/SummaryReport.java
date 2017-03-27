/*
 * SummaryReport.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-20 Created
 */
package com.bithealth.reportCore.report.model;

import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * 汇总测量报告（OSMR）
 * 
 * @author ${user}
 * @version 1.0 2016-07-20
 */
/**
 * 类名称: SummaryReport  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月3日 上午9:54:30 
 * 
 * @author 谢美团
 * @version  
 */
public class SummaryReport extends GenericModel {

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
     * 汇总报告编号
     */
    private String sumRepCode;
    /**
     * 汇总报告审核模板
     */
    private Integer sumRepTempCode;
    /**
     * 会员代码
     */
    private Integer memberid;
    /**
     * 产生时间
     */
    private Date grenerTime;
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
     * 是否已读报告：0:已读;1:未读
     */
    private Integer readStatus;
    
    /**
     *  汇总测量审核结果集合
     */
    private List<SummaryReportAudit> sumRepAuditList;
    
    /**
     *  汇总测量报告和单项测量报告关联关系
     */
    private List<SummaryReportRelation> sumRepRelationList;
    
    /**
     *  汇总测量报告关联的单项测量报告
     */
    private List<SingleReport> singleReportList;
    
    // 额外封装参数
    private String memName;
    private String templateName;
    private Short auditLevel;
    private int maxMumDay;
    private Date startTime;
    
	public int getMaxMumDay() {
		return maxMumDay;
	}
	public void setMaxMumDay(int maxMumDay) {
		this.maxMumDay = maxMumDay;
	}
	public Date getStartTime() {
		Calendar c = new GregorianCalendar();
		c.setTime(grenerTime);
		c.add(Calendar.DATE, -maxMumDay);
		return c.getTime();
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Short getAuditLevel() {
		return auditLevel;
	}
	public void setAuditLevel(Short auditLevel) {
		this.auditLevel = auditLevel;
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
	public List<SummaryReportAudit> getSumRepAuditList() {
		return sumRepAuditList;
	}
	public void setSumRepAuditList(List<SummaryReportAudit> sumRepAuditList) {
		this.sumRepAuditList = sumRepAuditList;
	}

	public List<SummaryReportRelation> getSumRepRelationList() {
		return sumRepRelationList;
	}
	public void setSumRepRelationList(List<SummaryReportRelation> sumRepRelationList) {
		this.sumRepRelationList = sumRepRelationList;
	}
	public List<SingleReport> getSingleReportList() {
		return singleReportList;
	}
	public void setSingleReportList(List<SingleReport> singleReportList) {
		this.singleReportList = singleReportList;
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
    public String getSumRepCode() {
        return sumRepCode;
    }
    public void setSumRepCode(String sumRepCode) {
        this.sumRepCode = sumRepCode;
    }
    public Integer getSumRepTempCode() {
        return sumRepTempCode;
    }
    public void setSumRepTempCode(Integer sumRepTempCode) {
        this.sumRepTempCode = sumRepTempCode;
    }
    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public Date getGrenerTime() {
        return grenerTime;
    }
    public void setGrenerTime(Date grenerTime) {
        this.grenerTime = grenerTime;
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
    public Integer getReadStatus() {
        return readStatus;
    }
    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }
}