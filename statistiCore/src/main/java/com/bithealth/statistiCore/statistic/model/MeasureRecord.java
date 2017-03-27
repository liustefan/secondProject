 
/**
 * @PackageName:      com.bithealth.measureCore.common.model
 * @FileName:     MesaureRecord.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年8月15日 上午11:01:20  
 * 
 */

package com.bithealth.statistiCore.statistic.model;

import java.util.Date;

import com.bithealth.sdk.core.generic.GenericModel;


/**
 * 类名称: MesaureRecord  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月15日 上午11:01:20 
 * 
 * @author 陈哲
 * @version  
 */
public class MeasureRecord extends GenericModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7612050226549561338L;

	private String eventType;
	
	private String isAbnormal;
	
	private Integer memberId;
	
	private Long eventId;
	
	private Date testTime;
	
	private Long id;
	
	private Integer systolic;
	
	private Integer diastolic;
	
	private Integer pulseRate;
	
	private Double bloodSugar;
	
	private String timePeriod; 
	
	private String analysisResult;
	
	private Integer averageHeart;
	
	private Integer averagePulseRate;
	
	private String analysisStatus;

	private String sTestTime;
	
	private String eTestTime;
	
	private String sBirthday;
	private String eBirthday;
	/**
     * 性别：1男；2女；3未知
     */
    private String gender;
    
    private String diseaseIds;
	/**
	 * eventType.
	 *
	 * @return  the eventType 
	 */
	public String getEventType() {
		return eventType;
	}

	/**
	 * eventType.
	 *
	 * @param   eventType    the eventType to set 
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	/**
	 * isAbnormal.
	 *
	 * @return  the isAbnormal 
	 */
	public String getIsAbnormal() {
		return isAbnormal;
	}

	/**
	 * isAbnormal.
	 *
	 * @param   isAbnormal    the isAbnormal to set 
	 */
	public void setIsAbnormal(String isAbnormal) {
		this.isAbnormal = isAbnormal;
	}

	/**
	 * memberId.
	 *
	 * @return  the memberId 
	 */
	public Integer getMemberId() {
		return memberId;
	}

	/**
	 * memberId.
	 *
	 * @param   memberId    the memberId to set 
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/**
	 * eventId.
	 *
	 * @return  the eventId 
	 */
	public Long getEventId() {
		return eventId;
	}

	/**
	 * eventId.
	 *
	 * @param   eventId    the eventId to set 
	 */
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	/**
	 * testTime.
	 *
	 * @return  the testTime 
	 */
	public Date getTestTime() {
		return testTime;
	}

	/**
	 * testTime.
	 *
	 * @param   testTime    the testTime to set 
	 */
	public void setTestTime(Date testTime) {
		this.testTime = testTime;
	}

	/**
	 * id.
	 *
	 * @return  the id 
	 */
	public Long getId() {
		return id;
	}

	/**
	 * id.
	 *
	 * @param   id    the id to set 
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * systolic.
	 *
	 * @return  the systolic 
	 */
	public Integer getSystolic() {
		return systolic;
	}

	/**
	 * systolic.
	 *
	 * @param   systolic    the systolic to set 
	 */
	public void setSystolic(Integer systolic) {
		this.systolic = systolic;
	}

	/**
	 * diastolic.
	 *
	 * @return  the diastolic 
	 */
	public Integer getDiastolic() {
		return diastolic;
	}

	/**
	 * diastolic.
	 *
	 * @param   diastolic    the diastolic to set 
	 */
	public void setDiastolic(Integer diastolic) {
		this.diastolic = diastolic;
	}

	/**
	 * pulseRate.
	 *
	 * @return  the pulseRate 
	 */
	public Integer getPulseRate() {
		return pulseRate;
	}

	/**
	 * pulseRate.
	 *
	 * @param   pulseRate    the pulseRate to set 
	 */
	public void setPulseRate(Integer pulseRate) {
		this.pulseRate = pulseRate;
	}

	/**
	 * bloodSugar.
	 *
	 * @return  the bloodSugar 
	 */
	public Double getBloodSugar() {
		return bloodSugar;
	}

	/**
	 * bloodSugar.
	 *
	 * @param   bloodSugar    the bloodSugar to set 
	 */
	public void setBloodSugar(Double bloodSugar) {
		this.bloodSugar = bloodSugar;
	}

	/**
	 * timePeriod.
	 *
	 * @return  the timePeriod 
	 */
	public String getTimePeriod() {
		return timePeriod;
	}

	/**
	 * timePeriod.
	 *
	 * @param   timePeriod    the timePeriod to set 
	 */
	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}

	/**
	 * analysisResult.
	 *
	 * @return  the analysisResult 
	 */
	public String getAnalysisResult() {
		return analysisResult;
	}

	/**
	 * analysisResult.
	 *
	 * @param   analysisResult    the analysisResult to set 
	 */
	public void setAnalysisResult(String analysisResult) {
		this.analysisResult = analysisResult;
	}

	/**
	 * averageHeart.
	 *
	 * @return  the averageHeart 
	 */
	public Integer getAverageHeart() {
		return averageHeart;
	}

	/**
	 * averageHeart.
	 *
	 * @param   averageHeart    the averageHeart to set 
	 */
	public void setAverageHeart(Integer averageHeart) {
		this.averageHeart = averageHeart;
	}

	/**
	 * averagePulseRate.
	 *
	 * @return  the averagePulseRate 
	 */
	public Integer getAveragePulseRate() {
		return averagePulseRate;
	}

	/**
	 * averagePulseRate.
	 *
	 * @param   averagePulseRate    the averagePulseRate to set 
	 */
	public void setAveragePulseRate(Integer averagePulseRate) {
		this.averagePulseRate = averagePulseRate;
	}

	/**
	 * analysisStatus.
	 *
	 * @return  the analysisStatus 
	 */
	public String getAnalysisStatus() {
		return analysisStatus;
	}

	/**
	 * analysisStatus.
	 *
	 * @param   analysisStatus    the analysisStatus to set 
	 */
	public void setAnalysisStatus(String analysisStatus) {
		this.analysisStatus = analysisStatus;
	}

	public String getsTestTime() {
		return sTestTime;
	}

	public void setsTestTime(String sTestTime) {
		this.sTestTime = sTestTime;
	}

	public String geteTestTime() {
		return eTestTime;
	}

	public void seteTestTime(String eTestTime) {
		this.eTestTime = eTestTime;
	}

	public String getsBirthday() {
		return sBirthday;
	}

	public void setsBirthday(String sBirthday) {
		this.sBirthday = sBirthday;
	}

	public String geteBirthday() {
		return eBirthday;
	}

	public void seteBirthday(String eBirthday) {
		this.eBirthday = eBirthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDiseaseIds() {
		return diseaseIds;
	}

	public void setDiseaseIds(String diseaseIds) {
		this.diseaseIds = diseaseIds;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}

