/*
 * PhDiabetes.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-28 Created
 */
package com.bithealth.inspectCore.inspect.model;

import java.util.Date;
import java.util.List;

import com.bithealth.inspectCore.model.DictEntity;
import com.bithealth.memberCore.member.model.MemRelation;
import com.bithealth.memberCore.member.model.Member;

/**
 * 公共卫生_2型糖尿病随访表
 * 
 * @author ${user}
 * @version 1.0 2016-06-28
 */
public class PhDiabetes extends DictEntity {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 7241425249799463556L;
	/**
     * 糖尿病随访主ID
     */
    private Long diabetesID;
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
     * 随访日期
     */
    private Date visitDate;
    /**
     * 随访医生签名
     */
    private String visitDrName;
    /**
     * 此次随访分类，0-待随访，来源ph_dictitem
     */
    private Byte visitClass;
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
    
    private Long MSETaskID;
    
    private PhDiabetesdetail phDiabetesdetail;
    private List<PhDiabetesdetailmedicine> phDiabetesdetailmedicines;
    
    private Member member;
    
    private MemRelation memRelation;
    
    private Date startVisitDate;
    private Date endVisitDate;
    
    private Boolean pending;
    
    /**仅供移动端模糊查询使用*/
    private String criteria;

    public Long getDiabetesID() {
        return diabetesID;
    }
    public void setDiabetesID(Long diabetesID) {
        this.diabetesID = diabetesID;
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
    public Date getVisitDate() {
        return visitDate;
    }
    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
    public String getVisitDrName() {
        return visitDrName;
    }
    public void setVisitDrName(String visitDrName) {
        this.visitDrName = visitDrName;
    }
    public Byte getVisitClass() {
        return visitClass;
    }
    public void setVisitClass(Byte visitClass) {
        this.visitClass = visitClass;
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
	public PhDiabetesdetail getPhDiabetesdetail() {
		return phDiabetesdetail;
	}
	public void setPhDiabetesdetail(PhDiabetesdetail phDiabetesdetail) {
		this.phDiabetesdetail = phDiabetesdetail;
	}
	public List<PhDiabetesdetailmedicine> getPhDiabetesdetailmedicines() {
		return phDiabetesdetailmedicines;
	}
	public void setPhDiabetesdetailmedicines(
			List<PhDiabetesdetailmedicine> phDiabetesdetailmedicines) {
		this.phDiabetesdetailmedicines = phDiabetesdetailmedicines;
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
	public Date getStartVisitDate() {
		return startVisitDate;
	}
	public void setStartVisitDate(Date startVisitDate) {
		this.startVisitDate = startVisitDate;
	}
	public Date getEndVisitDate() {
		return endVisitDate;
	}
	public void setEndVisitDate(Date endVisitDate) {
		this.endVisitDate = endVisitDate;
	}
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	public Boolean getPending() {
		if(pending == null)
			pending = visitClass != null && visitClass == 0 ? true : false;
		return pending;
	}
	public void setPending(Boolean pending) {
		this.pending = pending;
	}
	public String getVisitClassStr(){
		return convertStr("此次随访分类", "2型糖尿病随访", visitClass);
	}
	/**
	 * mSETaskID.
	 *
	 * @return  the mSETaskID 
	 */
	public Long getMSETaskID() {
		return MSETaskID;
	}
	/**
	 * mSETaskID.
	 *
	 * @param   mSETaskID    the mSETaskID to set 
	 */
	public void setMSETaskID(Long mSETaskID) {
		MSETaskID = mSETaskID;
	}
    
}