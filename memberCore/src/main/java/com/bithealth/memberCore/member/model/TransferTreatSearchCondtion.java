package com.bithealth.memberCore.member.model;

import java.io.Serializable;
import java.util.Date;

public class TransferTreatSearchCondtion implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer memberId;
	private String memName;
	private String diseasName;
	private String treatStatus;
	private Date updateStartTime;
	private Date updateEndTime;
	private int docid;
	
	private String tel;
	private String idCard;
	private Integer memGrpId = -1;
	private Integer disease_id = -1;
	private Integer memId = -1;
	private String lItemID_list;
	private String lItemName_list;
	private Integer iCount;
	
	private int pageNo;
	private int pageSize;
	
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
	public String getDiseasName() {
		return diseasName;
	}
	public void setDiseasName(String diseasName) {
		this.diseasName = diseasName;
	}
	public String getTreatStatus() {
		return treatStatus;
	}
	public void setTreatStatus(String treatStatus) {
		this.treatStatus = treatStatus;
	}
	public Date getUpdateStartTime() {
		return updateStartTime;
	}
	public void setUpdateStartTime(Date updateStartTime) {
		this.updateStartTime = updateStartTime;
	}
	public Date getUpdateEndTime() {
		return updateEndTime;
	}
	public void setUpdateEndTime(Date updateEndTime) {
		this.updateEndTime = updateEndTime;
	}
	public int getDocid() {
		return docid;
	}
	public void setDocid(int docid) {
		this.docid = docid;
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
	public Integer getMemGrpId() {
		return memGrpId;
	}
	public void setMemGrpId(Integer memGrpId) {
		this.memGrpId = memGrpId;
	}
	public Integer getDisease_id() {
		return disease_id;
	}
	public void setDisease_id(Integer disease_id) {
		this.disease_id = disease_id;
	}
	public Integer getMemId() {
		return memId;
	}
	public void setMemId(Integer memId) {
		this.memId = memId;
	}
	public String getlItemID_list() {
		return lItemID_list;
	}
	public void setlItemID_list(String lItemID_list) {
		this.lItemID_list = lItemID_list;
	}
	public String getlItemName_list() {
		return lItemName_list;
	}
	public void setlItemName_list(String lItemName_list) {
		this.lItemName_list = lItemName_list;
	}
	public Integer getiCount() {
		return iCount;
	}
	public void setiCount(Integer iCount) {
		this.iCount = iCount;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
