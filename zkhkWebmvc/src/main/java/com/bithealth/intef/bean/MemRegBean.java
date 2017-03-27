/**
 * 
 */
package com.bithealth.intef.bean;

import java.io.Serializable;
import java.util.List;

import com.bithealth.memberCore.member.model.DiseasesHistory;

/**
 * @author lhm
 *
 */
public class MemRegBean implements Serializable {

	private static final long serialVersionUID = 2617301277473303494L;
	
	private String idCard;
	
	private String memName;
	
	private String tel;
	
	private String email;
	
	private String birthDate;
	
	private String gender;
	
	private String orgId;
	
	private String memId;
	
	private String memGrpid;
	
	private String height;
	
	private String weight;
	
	private String bloodH;
	
	private List<DiseasesHistory> diseasesList;

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemGrpid() {
		return memGrpid;
	}

	public void setMemGrpid(String memGrpid) {
		this.memGrpid = memGrpid;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBloodH() {
		return bloodH;
	}

	public void setBloodH(String bloodH) {
		this.bloodH = bloodH;
	}

	public List<DiseasesHistory> getDiseasesList() {
		return diseasesList;
	}

	public void setDiseasesList(List<DiseasesHistory> diseasesList) {
		this.diseasesList = diseasesList;
	}

	@Override
	public String toString() {
		return "MemRegBean [idCard=" + idCard + ", memName=" + memName
				+ ", tel=" + tel + ", email=" + email + ", birthDate="
				+ birthDate + ", gender=" + gender + ", orgId=" + orgId
				+ ", memId=" + memId + ", memGrpid=" + memGrpid + ", height="
				+ height + ", weight=" + weight + ", bloodH=" + bloodH
				+ ", diseasesList=" + diseasesList + "]";
	}

}
