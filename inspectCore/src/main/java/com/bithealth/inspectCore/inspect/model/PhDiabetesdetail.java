/*
 * PhDiabetesdetail.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-28 Created
 */
package com.bithealth.inspectCore.inspect.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 公共卫生_2型糖尿病随访明细表
 * 
 * @author ${user}
 * @version 1.0 2016-06-28
 */
public class PhDiabetesdetail extends Inspectdetail {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -2960249439789653795L;
	/**
     * 糖尿病随访主ID，引用ph_diabetes
     */
    private Long diabetesID;
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
     * 体征_足背动脉搏动，来源ph_dictitem
     */
    private Byte arteriopalmus;
    /**
     * 体征_其他
     */
    private String otherSign;
    /**
     * 生活方式指导_当前时长(分钟/次)
     */
    private Short sportDuration;
    /**
     * 生活方式指导_下次目标时长(分钟/次)
     */
    private Short sportDuration_Next;
    /**
     * 生活方式指导_当前主食(克/天)
     */
    private Short mainFood;
    /**
     * 生活方式指导_下次目标主食(克/天)
     */
    private Short mainFood_Next;
    /**
     * 生活方式指导_心理调整，来源ph_dictitem
     */
    private Byte psychologicalRecovery;
    /**
     * 生活方式指导_遵医行为，来源ph_dictitem
     */
    private Byte complianceBehavior;
    /**
     * 辅助检查_空腹血糖值(mmol/L)
     */
    private BigDecimal FPG;
    /**
     * 辅助检查_餐后血糖(mmol/L)
     */
    private BigDecimal PGLU;
    /**
     * 辅助检查_糖化血红蛋白(%)
     */
    private BigDecimal HBA1C;
    /**
     * 辅助检查_检查日期
     */
    private Date checkDate;
    /**
     * 辅助检查_检查结果
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
     * 低血糖反应，来源ph_dictitem
     */
    private Byte RHG;
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

    public Long getDiabetesID() {
        return diabetesID;
    }
    public void setDiabetesID(Long diabetesID) {
        this.diabetesID = diabetesID;
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
    public Byte getArteriopalmus() {
        return arteriopalmus;
    }
    public void setArteriopalmus(Byte arteriopalmus) {
        this.arteriopalmus = arteriopalmus;
    }
    public String getOtherSign() {
        return otherSign;
    }
    public void setOtherSign(String otherSign) {
        this.otherSign = otherSign;
    }
    public Short getSportDuration() {
        return sportDuration;
    }
    public void setSportDuration(Short sportDuration) {
        this.sportDuration = sportDuration;
    }
    public Short getSportDuration_Next() {
        return sportDuration_Next;
    }
    public void setSportDuration_Next(Short sportDuration_Next) {
        this.sportDuration_Next = sportDuration_Next;
    }
    public Short getMainFood() {
        return mainFood;
    }
    public void setMainFood(Short mainFood) {
        this.mainFood = mainFood;
    }
    public Short getMainFood_Next() {
        return mainFood_Next;
    }
    public void setMainFood_Next(Short mainFood_Next) {
        this.mainFood_Next = mainFood_Next;
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
    public BigDecimal getFPG() {
        return FPG;
    }
    public void setFPG(BigDecimal FPG) {
        this.FPG = FPG;
    }
    public BigDecimal getPGLU() {
        return PGLU;
    }
    public void setPGLU(BigDecimal PGLU) {
        this.PGLU = PGLU;
    }
    public BigDecimal getHBA1C() {
        return HBA1C;
    }
    public void setHBA1C(BigDecimal HBA1C) {
        this.HBA1C = HBA1C;
    }
    public Date getCheckDate() {
        return checkDate;
    }
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
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
    public Byte getRHG() {
        return RHG;
    }
    public void setRHG(Byte RHG) {
        this.RHG = RHG;
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
		return convertStr("随访方式", "2型糖尿病随访", visitWay);
	}
	
	public String getSymptomStr(){
		return getExtendNames("症状", "2型糖尿病随访", symptom, "其他", symptom_Desc, "未见异常");
	}
	
	public String[] getSymptoms() {
		return getArray(symptom);
	}

	public String getArteriopalmusStr(){
		return convertStr("足背动脉搏动", "2型糖尿病随访_体征", arteriopalmus);
	}
	
	public String getPsychoRecoStr(){
		return convertStr("心理调整", "2型糖尿病随访_生活方式指导", psychologicalRecovery);
	}

	public String getCompliBehavStr(){
		return convertStr("遵医行为", "2型糖尿病随访_生活方式指导", complianceBehavior);
	}

	public String getDrugCompliStr(){
		return convertStr("服药依从性", "2型糖尿病随访", drugCompliance);
	}

	public String getRhgStr(){
		return convertStr("低血糖反应", "2型糖尿病随访", RHG);
	}

	public String getDrugAdverReaStr(){
		return convertStr("药物不良反应", "2型糖尿病随访", drugAdverseReaction);
	}
}