/**
 * @PackageName:      com.bithealth.memberCore.member.vo
 * @FileName:     MemberVo.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月12日 上午10:30:10  
 * 
 */
package com.bithealth.memberCore.member.vo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 类名称: MemberVo  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月12日 上午10:30:10 
 * 
 * @author liuhm
 * @version  
 */
public class MemberVo implements Serializable {

	private static final long serialVersionUID = 5286477136628499819L;
	
	private String memName;
	
	private Integer memberId;
	
	private String idcard;
	
	private String gender;
	
	private java.sql.Date birthDay;
	
	private String tel;
	
	private String status;
	
	private String diseaseNames;
	
	private String memGrpNames;
	
	private String memGrpIDs;
	
	private String memDesc;
	
    //最近测量时间
	private Timestamp lastTestTime;
	
	private Timestamp createTime;
	
	private String uniqueId;
	
	private Integer designID;
	
	private String schemeTitle;
	
	private Integer execStatus;
	
	/**
	 * 会员标签
	 */
	private String memLabelNames;
	
	public String getMemLabelNames() {
		return memLabelNames;
	}

	public void setMemLabelNames(String memLabelNames) {
		this.memLabelNames = memLabelNames;
	}

	public Integer getExecStatus() {
		return execStatus;
	}

	public void setExecStatus(Integer execStatus) {
		this.execStatus = execStatus;
	}

	public Integer getDesignID() {
		return designID;
	}

	public void setDesignID(Integer designID) {
		this.designID = designID;
	}

	public String getSchemeTitle() {
		return schemeTitle;
	}

	public void setSchemeTitle(String schemeTitle) {
		this.schemeTitle = schemeTitle;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public java.sql.Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(java.sql.Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDiseaseNames() {
		return diseaseNames;
	}

	public void setDiseaseNames(String diseaseNames) {
		this.diseaseNames = diseaseNames;
	}

	public String getMemGrpNames() {
		return memGrpNames;
	}

	public void setMemGrpNames(String memGrpNames) {
		this.memGrpNames = memGrpNames;
	}

	public String getMemGrpIDs() {
		return memGrpIDs;
	}

	public void setMemGrpIDs(String memGrpIDs) {
		this.memGrpIDs = memGrpIDs;
	}

	public String getMemDesc() {
		return memDesc;
	}

	public void setMemDesc(String memDesc) {
		this.memDesc = memDesc;
	}

	public Timestamp getLastTestTime() {
		return lastTestTime;
	}

	public void setLastTestTime(Timestamp lastTestTime) {
		this.lastTestTime = lastTestTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	
}
