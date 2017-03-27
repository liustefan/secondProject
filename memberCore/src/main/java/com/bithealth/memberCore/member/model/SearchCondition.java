/**
 * @PackageName:      com.bithealth.memberCore.member.model
 * @FileName:     SearchCondition.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月11日 下午5:38:30  
 * 
 */
package com.bithealth.memberCore.member.model;

import java.io.Serializable;

import com.bithealth.sdk.core.feature.orm.mybatis.Page;

/**
 * 类名称: SearchCondition  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月11日 下午5:38:30 
 * 
 * @author liuhm
 * @version  
 */
public class SearchCondition<T> implements Serializable {

	private static final long serialVersionUID = 4440897216127101871L;
	
	private Integer docId;
	
	private String tel;
	
	private String idcard;
	
	private Integer memGrpId = -1;
	
	private String memName;
	
	private String memNameCode;
	
	private String  gender;
	
	private String birthDayStart;
	
	private String birthDayEnd;
	
	private String address;
	
	private String diseaseName;
	
	private String creTimeStart;
	
	private String creTimeEnd;
	
	private Integer qustid = -1;
	
	private Integer combQustid = -1;
	
	private Integer iCount;
	
	private Integer memType = -1;
	
	private Integer diseaseId = -1;
	
	private Integer execStatus = -1;
	
	private String labelItemIds;
	
	private String labelItemNames;
	
	public String getLabelItemNames() {
		return labelItemNames;
	}

	public void setLabelItemNames(String labelItemNames) {
		this.labelItemNames = labelItemNames;
	}

	private Page<T> page = new Page<T>();
	
	
	public Integer getDiseaseId() {
		return diseaseId;
	}

	public void setDiseaseId(Integer diseaseId) {
		this.diseaseId = diseaseId;
	}

	public Integer getExecStatus() {
		return execStatus;
	}

	public void setExecStatus(Integer execStatus) {
		this.execStatus = execStatus;
	}

	public String getLabelItemIds() {
		return labelItemIds;
	}

	public void setLabelItemIds(String labelItemIds) {
		this.labelItemIds = labelItemIds;
	}

	public Integer getMemType() {
		return memType;
	}

	public void setMemType(Integer memType) {
		this.memType = memType;
	}

	public Integer getiCount() {
		return iCount;
	}

	public void setiCount(Integer iCount) {
		this.iCount = iCount;
	}

	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public Integer getMemGrpId() {
		return memGrpId == null ? 0 : memGrpId;
	}

	public void setMemGrpId(Integer memGrpId) {
		this.memGrpId = memGrpId;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemNameCode() {
		return memNameCode;
	}

	public void setMemNameCode(String memNameCode) {
		this.memNameCode = memNameCode;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDayStart() {
		return birthDayStart;
	}

	public void setBirthDayStart(String birthDayStart) {
		this.birthDayStart = birthDayStart;
	}

	public String getBirthDayEnd() {
		return birthDayEnd;
	}

	public void setBirthDayEnd(String birthDayEnd) {
		this.birthDayEnd = birthDayEnd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getCreTimeStart() {
		return creTimeStart;
	}

	public void setCreTimeStart(String creTimeStart) {
		this.creTimeStart = creTimeStart;
	}

	public String getCreTimeEnd() {
		return creTimeEnd;
	}

	public void setCreTimeEnd(String creTimeEnd) {
		this.creTimeEnd = creTimeEnd;
	}

	public Integer getQustid() {
		return qustid;
	}

	public void setQustid(Integer qustid) {
		this.qustid = qustid;
	}

	public Integer getCombQustid() {
		return combQustid;
	}

	public void setCombQustid(Integer combQustid) {
		this.combQustid = combQustid;
	}

}
