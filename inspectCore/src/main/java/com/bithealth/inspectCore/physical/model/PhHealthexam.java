/*
 * PhHealthexam.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-27 Created
 */
package com.bithealth.inspectCore.physical.model;

import java.util.Date;
import java.util.List;

import com.bithealth.memberCore.member.model.MemRelation;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 公共卫生_健康体检表
 * 
 * @author ${user}
 * @version 1.0 2016-06-27
 */
public class PhHealthexam extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -6221697574227134057L;
	/**
     * 体检主ID
     */
    private Long HExamID;
    /**
     * 会员ID，引用omem
     */
    private Integer memberID;
    /**
     * 健康档案号，引用omem
     */
    private String unique_ID;
    /**
     * 合作公司，0-录入，来源ph_dictitem
     */
    private Byte refCompany;
    /**
     * 合作公司的业务数据主键值
     */
    private String refDataPK;
    /**
     * 身份证号
     */
    private String IDCard;
    /**
     * 姓名
     */
    private String name;
    /**
     * 体检日期
     */
    private Date examDate;
    /**
     * 责任医生
     */
    private String responsibleDrName;
    /**
     * 最近入库时间
     */
    private Date getTime;
    /**
     * 是否已删除：0-否，1-是
     */
    private Byte isDeleted;
    /**
     * 创建医生ID，0-系统(对接)，引用odoc表
     */
    private Integer createDrID;
    /**
     * 创建医生名称
     */
    private String createDrName;
    /**
     * 记录创建时间
     */
    private Date createTime;
    /**
     * 更新医生ID，0-系统，引用odoc表
     */
    private Integer updateDrID;
    /**
     * 更新医生名称
     */
    private String updateDrName;
    /**
     * 记录更新时间
     */
    private Date updateTime;
    
    private Date latestTime;
    
    private PhHealthexamdetail phHealthexamdetail;
    private List<PhHealthexamdetailfamilybed> phHealthexamdetailfamilybeds;
    private List<PhHealthexamdetailinpatient> phHealthexamdetailinpatients;
    private List<PhHealthexamdetailmedicine> phHealthexamdetailmedicines;
    private List<PhHealthexamdetailnonimmune> phHealthexamdetailnonimmunes;
    
    private Member member;
    
    private MemRelation memRelation;
    
    private Date startExamDate;
    private Date endExamDate;
    
    /**仅供移动端模糊查询使用*/
    private String criteria;
    
    public Long getHExamID() {
        return HExamID;
    }
    public void setHExamID(Long HExamID) {
        this.HExamID = HExamID;
    }
    public Integer getMemberID() {
        return memberID;
    }
    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }
    public String getUnique_ID() {
        return unique_ID;
    }
    public void setUnique_ID(String unique_ID) {
        this.unique_ID = unique_ID;
    }
    public Byte getRefCompany() {
        return refCompany;
    }
    public void setRefCompany(Byte refCompany) {
        this.refCompany = refCompany;
    }
    public String getRefDataPK() {
        return refDataPK;
    }
    public void setRefDataPK(String refDataPK) {
        this.refDataPK = refDataPK;
    }
    public String getIDCard() {
        return IDCard;
    }
    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getExamDate() {
        return examDate;
    }
    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }
    public String getResponsibleDrName() {
        return responsibleDrName;
    }
    public void setResponsibleDrName(String responsibleDrName) {
        this.responsibleDrName = responsibleDrName;
    }
    public Date getGetTime() {
        return getTime;
    }
    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }
    public Byte getIsDeleted() {
        return isDeleted;
    }
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }
    public Integer getCreateDrID() {
        return createDrID;
    }
    public void setCreateDrID(Integer createDrID) {
        this.createDrID = createDrID;
    }
    public String getCreateDrName() {
        return createDrName;
    }
    public void setCreateDrName(String createDrName) {
        this.createDrName = createDrName;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Integer getUpdateDrID() {
        return updateDrID;
    }
    public void setUpdateDrID(Integer updateDrID) {
        this.updateDrID = updateDrID;
    }
    public String getUpdateDrName() {
        return updateDrName;
    }
    public void setUpdateDrName(String updateDrName) {
        this.updateDrName = updateDrName;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
	public Date getLatestTime() {
		return latestTime;
	}
	public void setLatestTime(Date latestTime) {
		this.latestTime = latestTime;
	}
	public PhHealthexamdetail getPhHealthexamdetail() {
		return phHealthexamdetail;
	}
	public void setPhHealthexamdetail(PhHealthexamdetail phHealthexamdetail) {
		this.phHealthexamdetail = phHealthexamdetail;
	}
	public List<PhHealthexamdetailfamilybed> getPhHealthexamdetailfamilybeds() {
		return phHealthexamdetailfamilybeds;
	}
	public void setPhHealthexamdetailfamilybeds(
			List<PhHealthexamdetailfamilybed> phHealthexamdetailfamilybeds) {
		this.phHealthexamdetailfamilybeds = phHealthexamdetailfamilybeds;
	}
	public List<PhHealthexamdetailinpatient> getPhHealthexamdetailinpatients() {
		return phHealthexamdetailinpatients;
	}
	public void setPhHealthexamdetailinpatients(
			List<PhHealthexamdetailinpatient> phHealthexamdetailinpatients) {
		this.phHealthexamdetailinpatients = phHealthexamdetailinpatients;
	}
	public List<PhHealthexamdetailmedicine> getPhHealthexamdetailmedicines() {
		return phHealthexamdetailmedicines;
	}
	public void setPhHealthexamdetailmedicines(
			List<PhHealthexamdetailmedicine> phHealthexamdetailmedicines) {
		this.phHealthexamdetailmedicines = phHealthexamdetailmedicines;
	}
	public List<PhHealthexamdetailnonimmune> getPhHealthexamdetailnonimmunes() {
		return phHealthexamdetailnonimmunes;
	}
	public void setPhHealthexamdetailnonimmunes(
			List<PhHealthexamdetailnonimmune> phHealthexamdetailnonimmunes) {
		this.phHealthexamdetailnonimmunes = phHealthexamdetailnonimmunes;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public MemRelation getMemRelation() {
		return memRelation;
	}
	public void setMemRelation(MemRelation memRelation) {
		this.memRelation = memRelation;
	}
    public Member createMember(){
    	this.member =  new Member();
    	return this.member;
    }
    public MemRelation createMemRelation(){
    	this.memRelation =  new MemRelation();
    	return this.memRelation;
    }
	public Date getStartExamDate() {
		return startExamDate;
	}
	public void setStartExamDate(Date startExamDate) {
		this.startExamDate = startExamDate;
	}
	public Date getEndExamDate() {
		return endExamDate;
	}
	public void setEndExamDate(Date endExamDate) {
		this.endExamDate = endExamDate;
	}
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
    
	public boolean isElderly(){
		try {
			if(this.member != null)
				return TimeUtil.getAge(this.member.getBirthdate())>=65;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}