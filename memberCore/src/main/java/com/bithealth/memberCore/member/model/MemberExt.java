/**
 * @PackageName:      com.bithealth.memberCore.member.model
 * @FileName:     MemberExt.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月29日 下午5:45:54  
 * 
 */
package com.bithealth.memberCore.member.model;

import java.util.ArrayList;
import java.util.List;

import com.bithealth.memberCore.group.model.MemberGroup;
import com.bithealth.memberCore.memberLabel.model.MemberLabelItem;

/**
 * 类名称: MemberExt  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月29日 下午5:45:54 
 * 
 * @author liuhm
 * @version  
 */
public class MemberExt extends Member {

	private static final long serialVersionUID = -7317889067646276046L;
	
	 /**
     * 会员所属分组
     */
    private List<MemberGroup> memberGroupList = new ArrayList<MemberGroup>();
    
    /**
     * 会员疾病史
     */
    private List<DiseasesHistory> diseasesHistoryList = new ArrayList<DiseasesHistory>();
    
    
    /**
     * 家族疾病史
     */
    private List<FamilyHistory> familyHistoryList = new ArrayList<FamilyHistory>();
    
    /**
     * 会员习惯信息
     */
    private Habit habit;
    
    /**
     * 紧急联系人
     */
    private List<LinkMan> linkmanList = new ArrayList<LinkMan>();
    
    /**
     * 会员账号
     */
    private List<MemAccount> accountList = new ArrayList<MemAccount>();
    
    /**
     * 会员积分
     */
    private List<MemScore> memScoreList = new ArrayList<MemScore>();
    
    /**
     * 会员登录session
     */
    private MemSession memSession;
    
    /**
     * 会员体格检查
     */
    private PhysicalExamination physical;
    
    /**
     * 活力指数
     */
    private VitalIndex vitalIndex;
    
    private MemRelation relation;
    
    /**
     * 家庭成员
     */
    private List<MemFamilyCardExt> omemFamilyCards;
    
    /**
     * 会员只能卡号
     */
    private List<MemFamilyCard> omemCardNos;
    
    private MemImportLog importLog;
     
    private List<MemberLabelItem> addLabelItems;
    
    private List<MemberLabelItem> removeLabelItems;
    
    private String labelItemIds;
    
    private String labelItemNames;
    
	public List<MemberLabelItem> getAddLabelItems() {
		return addLabelItems;
	}

	public void setAddLabelItems(List<MemberLabelItem> addLabelItems) {
		this.addLabelItems = addLabelItems;
	}

	public List<MemberLabelItem> getRemoveLabelItems() {
		return removeLabelItems;
	}

	public void setRemoveLabelItems(List<MemberLabelItem> removeLabelItems) {
		this.removeLabelItems = removeLabelItems;
	}

	public String getLabelItemIds() {
		return labelItemIds;
	}

	public void setLabelItemIds(String labelItemIds) {
		this.labelItemIds = labelItemIds;
	}

	public String getLabelItemNames() {
		return labelItemNames;
	}

	public void setLabelItemNames(String labelItemNames) {
		this.labelItemNames = labelItemNames;
	}

	public MemRelation getRelation() {
		return relation;
	}

	public void setRelation(MemRelation relation) {
		this.relation = relation;
	}

	public List<MemberGroup> getMemberGroupList() {
		return memberGroupList;
	}

	public void setMemberGroupList(List<MemberGroup> memberGroupList) {
		this.memberGroupList = memberGroupList;
	}

	public List<DiseasesHistory> getDiseasesHistoryList() {
		return diseasesHistoryList;
	}

	public void setDiseasesHistoryList(List<DiseasesHistory> diseasesHistoryList) {
		this.diseasesHistoryList = diseasesHistoryList;
	}

	public List<FamilyHistory> getFamilyHistoryList() {
		return familyHistoryList;
	}

	public void setFamilyHistoryList(List<FamilyHistory> familyHistoryList) {
		this.familyHistoryList = familyHistoryList;
	}

	public Habit getHabit() {
		return habit;
	}

	public void setHabit(Habit habit) {
		this.habit = habit;
	}

	public List<LinkMan> getLinkmanList() {
		return linkmanList;
	}

	public void setLinkmanList(List<LinkMan> linkmanList) {
		this.linkmanList = linkmanList;
	}

	public List<MemAccount> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<MemAccount> accountList) {
		this.accountList = accountList;
	}

	public List<MemScore> getMemScoreList() {
		return memScoreList;
	}

	public void setMemScoreList(List<MemScore> memScoreList) {
		this.memScoreList = memScoreList;
	}

	public MemSession getMemSession() {
		return memSession;
	}

	public void setMemSession(MemSession memSession) {
		this.memSession = memSession;
	}

	public PhysicalExamination getPhysical() {
		return physical;
	}

	public void setPhysical(PhysicalExamination physical) {
		this.physical = physical;
	}

	public VitalIndex getVitalIndex() {
		return vitalIndex;
	}

	public void setVitalIndex(VitalIndex vitalIndex) {
		this.vitalIndex = vitalIndex;
	}
	
	public List<MemFamilyCardExt> getOmemFamilyCards() {
		return omemFamilyCards;
	}

	public void setOmemFamilyCards(List<MemFamilyCardExt> omemFamilyCards) {
		this.omemFamilyCards = omemFamilyCards;
	}
	
	public List<MemFamilyCard> getOmemCardNos() {
		return omemCardNos;
	}

	public void setOmemCardNos(List<MemFamilyCard> omemCardNos) {
		this.omemCardNos = omemCardNos;
	}

	public String getMemberGroupIds() {
		if(this.getMemberGroupList() != null && this.getMemberGroupList().size() > 0) {
			StringBuilder sb = null;
			for(MemberGroup group : this.getMemberGroupList()) {
				if(null == sb) {
					sb = new StringBuilder();
					sb.append(group.getMemgrpid());
				} else {
					sb.append(",").append(group.getMemgrpid());
				}
			}
			return sb.toString();
		}
		return null;
	}

	public MemImportLog getImportLog() {
		return importLog;
	}

	public void setImportLog(MemImportLog importLog) {
		this.importLog = importLog;
	}

	@Override
	public String toString() {
		return "MemberExt [memberGroupList=" + memberGroupList
				+ ", diseasesHistoryList=" + diseasesHistoryList
				+ ", familyHistoryList=" + familyHistoryList + ", habit="
				+ habit + ", linkmanList=" + linkmanList + ", accountList="
				+ accountList + ", memScoreList=" + memScoreList
				+ ", memSession=" + memSession + ", physical=" + physical
				+ ", vitalIndex=" + vitalIndex + ", relation=" + relation + "]";
	}
	
    
}
