package com.bithealth.memberCore.member.vo;

import java.util.Date;

import com.bithealth.memberCore.member.model.TransferTreatment;

public class TransferTreatAndMemVo extends TransferTreatment{
	private static final long serialVersionUID = 1L;
	private Integer ttreatmentid;
	private Integer memberId;
	private String memName;
	private String gender;
	private String diseasNames;
	private Date birthDate;
	private String tel;
	private String idCard;
	private String status; // "T":正常  ， "F": 冻结
	private String omemLabel;
	
	private String treatStatusName;
	private String createDocName;
	private String updateDocName;
	
	private String memGrpNames;

	private String memberTypeName;
	
	public Integer getTtreatmentid() {
		return ttreatmentid;
	}
	public void setTtreatmentid(Integer ttreatmentid) {
		this.ttreatmentid = ttreatmentid;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOmemLabel() {
		return omemLabel;
	}
	public void setOmemLabel(String omemLabel) {
		this.omemLabel = omemLabel;
	}
	public String getDiseasNames() {
		return diseasNames;
	}
	public void setDiseasNames(String diseasNames) {
		this.diseasNames = diseasNames;
	}
	public String getTreatStatusName() {
		return treatStatusName;
	}
	public void setTreatStatusName(String treatStatusName) {
		this.treatStatusName = treatStatusName;
	}
	public String getCreateDocName() {
		return createDocName;
	}
	public void setCreateDocName(String createDocName) {
		this.createDocName = createDocName;
	}
	public String getUpdateDocName() {
		return updateDocName;
	}
	public void setUpdateDocName(String updateDocName) {
		this.updateDocName = updateDocName;
	}
	public String getMemGrpNames() {
		return memGrpNames;
	}
	public void setMemGrpNames(String memGrpNames) {
		this.memGrpNames = memGrpNames;
	}
	public String getMemberTypeName() {
		return memberTypeName;
	}
	public void setMemberTypeName(String memberTypeName) {
		this.memberTypeName = memberTypeName;
	}
	
}
