/*
 * PhHypertensiondetail.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-28 Created
 */
package com.bithealth.inspectCore.inspect.model;

import java.util.Date;

/**
 * 公共卫生_高血压随访明细表
 * 
 * @author ${user}
 * @version 1.0 2016-06-28
 */
public class PhHypertensiondetail extends Inspectdetail {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -9010067288690057485L;
	/**
     * 高血压随访主ID，引用ph_hypertension
     */
    private Long hypertensionID;
    /**
     * 随访方式，来源ph_dictitem
     */
    private Byte visitWay;
    /**
     * 症状_列表(以@#拼接)，来源ph_dictitem
     */
    private String symptom;
    /**
     * 症状_其他描述
     */
    private String symptom_Desc;
    /**
     * 体征_心率
     */
    private Short heartRate;
    /**
     * 体征_其他
     */
    private String otherSign;
    /**
     * 生活方式指导_当前摄盐情况（咸淡），来源ph_dictitem
     */
    private Byte intakeSalt;
    /**
     * 生活方式指导_下次目标摄盐情况（咸淡），来源ph_dictitem
     */
    private Byte intakeSalt_Next;
    /**
     * 生活方式指导_心理调整，来源ph_dictitem
     */
    private Byte psychologicalRecovery;
    /**
     * 生活方式指导_遵医行为，来源ph_dictitem
     */
    private Byte complianceBehavior;
    /**
     * 辅助检查
     */
    private String checkResult;
    /**
     * 服药依从性，来源ph_dictitem
     */
    private Byte drugCompliance;
    /**
     * 药物不良反应，来源ph_dictitem
     */
    private Byte drugAdverseReaction;
    /**
     * 药物不良反应描述
     */
    private String drugAdverseReaction_Desc;
    /**
     * 转诊_原因
     */
    private String transferReason;
    /**
     * 转诊_机构及科室
     */
    private String transferOrgAndDept;
    /**
     * 下次随访日期
     */
    private Date visitDate_Next;

    public Long getHypertensionID() {
        return hypertensionID;
    }
    public void setHypertensionID(Long hypertensionID) {
        this.hypertensionID = hypertensionID;
    }
    public Byte getVisitWay() {
        return visitWay;
    }
    public void setVisitWay(Byte visitWay) {
        this.visitWay = visitWay;
    }
    public String getSymptom() {
    	return arrayToJoint(symptom);
    }
    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
    public String getSymptom_Desc() {
        return symptom_Desc;
    }
    public void setSymptom_Desc(String symptom_Desc) {
        this.symptom_Desc = symptom_Desc;
    }
    public Short getHeartRate() {
        return heartRate;
    }
    public void setHeartRate(Short heartRate) {
        this.heartRate = heartRate;
    }
    public String getOtherSign() {
        return otherSign;
    }
    public void setOtherSign(String otherSign) {
        this.otherSign = otherSign;
    }
    public Byte getIntakeSalt() {
        return intakeSalt;
    }
    public void setIntakeSalt(Byte intakeSalt) {
        this.intakeSalt = intakeSalt;
    }
    public Byte getIntakeSalt_Next() {
        return intakeSalt_Next;
    }
    public void setIntakeSalt_Next(Byte intakeSalt_Next) {
        this.intakeSalt_Next = intakeSalt_Next;
    }
    public Byte getPsychologicalRecovery() {
        return psychologicalRecovery;
    }
    public void setPsychologicalRecovery(Byte psychologicalRecovery) {
        this.psychologicalRecovery = psychologicalRecovery;
    }
    public Byte getComplianceBehavior() {
        return complianceBehavior;
    }
    public void setComplianceBehavior(Byte complianceBehavior) {
        this.complianceBehavior = complianceBehavior;
    }
    public String getCheckResult() {
        return checkResult;
    }
    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }
    public Byte getDrugCompliance() {
        return drugCompliance;
    }
    public void setDrugCompliance(Byte drugCompliance) {
        this.drugCompliance = drugCompliance;
    }
    public Byte getDrugAdverseReaction() {
        return drugAdverseReaction;
    }
    public void setDrugAdverseReaction(Byte drugAdverseReaction) {
        this.drugAdverseReaction = drugAdverseReaction;
    }
    public String getDrugAdverseReaction_Desc() {
        return drugAdverseReaction_Desc;
    }
    public void setDrugAdverseReaction_Desc(String drugAdverseReaction_Desc) {
        this.drugAdverseReaction_Desc = drugAdverseReaction_Desc;
    }
    public String getTransferReason() {
        return transferReason;
    }
    public void setTransferReason(String transferReason) {
        this.transferReason = transferReason;
    }
    public String getTransferOrgAndDept() {
        return transferOrgAndDept;
    }
    public void setTransferOrgAndDept(String transferOrgAndDept) {
        this.transferOrgAndDept = transferOrgAndDept;
    }
    public Date getVisitDate_Next() {
        return visitDate_Next;
    }
    public void setVisitDate_Next(Date visitDate_Next) {
        this.visitDate_Next = visitDate_Next;
    }
	public String getVisitWayStr(){
		return convertStr("随访方式",	"高血压随访", visitWay);
	}
	
	public String getSymptomStr(){
		return getExtendNames("症状", "高血压随访", symptom, "其他", symptom_Desc, "未见异常");
	}
	
	public String[] getSymptoms(){
		return getArray(symptom);
	}
	public String getPsychoRecoStr(){
		return convertStr("心理调整", "高血压随访_生活方式指导", psychologicalRecovery);
	}
	
	public String getCompliBehavStr(){
		return convertStr("遵医行为", "高血压随访_生活方式指导", complianceBehavior);
	}
	
	public String getIntakeSaltStr(){
		return convertStr("摄盐情况(咸淡)", "高血压随访", intakeSalt);
	}
	
	public String getDrugCompliStr(){
		return convertStr("服药依从性", "高血压随访", drugCompliance);
	}
	
	public String getDrugAdverReaStr(){
		return convertStr("药物不良反应", "高血压随访", drugAdverseReaction);
	}
}