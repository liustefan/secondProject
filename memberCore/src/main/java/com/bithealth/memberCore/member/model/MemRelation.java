/*
 * MemRelation.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-30 Created
 */
package com.bithealth.memberCore.member.model;

import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;

/**
 * 会员档案关联信息表
 * 
 * @author ${user}
 * @version 1.0 2016-06-30
 */
public class MemRelation extends GenericModel {

	private static final long serialVersionUID = 5153973732230732707L;
	/**
     * 合作方数据标识（如：健康档案号）
     */
    private String uniqueId;
    /**
     * 拼音简写 
     */
    private String logogram;
    /**
     * 与户主关系 1户主  2.配偶;3.子女;4.(外)孙子女;5.父母;6.(外)祖父母;7.兄弟姐妹;8.儿媳;9.女婿;10.孙子女;11.侄子女;12.曾孙子女;13.祖父母;99.其他
     */
    private Integer relation;
    /**
     * 工作单位 
     */
    private String company;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String area;
    /**
     * 街道（乡）
     */
    private String village;
    /**
     * 居委会 
     */
    private String neighborhoodCommittee;
    /**
     *  1.本地户籍常住;2.本地户籍不常住;3.外地户籍常住;4.不详;
     */
    private Integer liveStatus;
    /**
     * 民族
     */
    private String nation;
    /**
     * 1.全自费;2.全公费;3.城镇职工基本医疗保险;4.城镇居民基本医疗保险;5.新型农村合作医疗;6.社会医疗保险;7.商业医疗保险;8.贫困救助;99.其他;
     */
    private Integer payType;
    /**
     * 医疗保险号
     */
    private String medicalAccount;
    /**
     * 新农合号
     */
    private String agroAccount;
    /**
     * 调查时间
     */
    private Date surveyTime;
    /**
     * 怀孕情况  0.未孕;1.已孕未生产;2.已生产(随访期内);2.已生产(随访期外);
     */
    private Integer fetationStatus;
    /**
     * 1.身份证;2.护照(外籍人士);3.军官证; 
     */
    private Integer certificateType;
    /**
     * 1.城镇;2.农村;
     */
    private Integer fileType;
    /**
     * 1.活动;2.非活动;
     */
    private Integer fileStatus;
    /**
     * 所属机构
     */
    private String prgid;
    /**
     * 其他支付方式
     */
    private String otherPay;
    /**
     * 家庭档案编号
     */
    private String familyCode;
    /**
     * 所属片区
     */
    private String belongArea;
    /**
     * 档案非活动状态原因，1.死亡;2.失踪;3.迁出;4.其他;5.长期外出
     */
    private Integer fileStatusDesc;
    
    /**
     * 状态：0-原始，1-成功，2-失败
     */
    private Byte state;
    
    private Member member;
    
    public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getUniqueId() {
        return uniqueId;
    }
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
    public String getLogogram() {
        return logogram;
    }
    public void setLogogram(String logogram) {
        this.logogram = logogram;
    }
    public Integer getRelation() {
        return relation;
    }
    public void setRelation(Integer relation) {
        this.relation = relation;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getVillage() {
        return village;
    }
    public void setVillage(String village) {
        this.village = village;
    }
    public String getNeighborhoodCommittee() {
        return neighborhoodCommittee;
    }
    public void setNeighborhoodCommittee(String neighborhoodCommittee) {
        this.neighborhoodCommittee = neighborhoodCommittee;
    }
    public Integer getLiveStatus() {
        return liveStatus;
    }
    public void setLiveStatus(Integer liveStatus) {
        this.liveStatus = liveStatus;
    }
    public String getNation() {
        return nation;
    }
    public void setNation(String nation) {
        this.nation = nation;
    }
    public Integer getPayType() {
        return payType;
    }
    public void setPayType(Integer payType) {
        this.payType = payType;
    }
    public String getMedicalAccount() {
        return medicalAccount;
    }
    public void setMedicalAccount(String medicalAccount) {
        this.medicalAccount = medicalAccount;
    }
    public String getAgroAccount() {
        return agroAccount;
    }
    public void setAgroAccount(String agroAccount) {
        this.agroAccount = agroAccount;
    }
    public Date getSurveyTime() {
        return surveyTime;
    }
    public void setSurveyTime(Date surveyTime) {
        this.surveyTime = surveyTime;
    }
    public Integer getFetationStatus() {
        return fetationStatus;
    }
    public void setFetationStatus(Integer fetationStatus) {
        this.fetationStatus = fetationStatus;
    }
    public Integer getCertificateType() {
        return certificateType;
    }
    public void setCertificateType(Integer certificateType) {
        this.certificateType = certificateType;
    }
    public Integer getFileType() {
        return fileType;
    }
    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }
    public Integer getFileStatus() {
        return fileStatus;
    }
    public void setFileStatus(Integer fileStatus) {
        this.fileStatus = fileStatus;
    }
    public String getPrgid() {
        return prgid;
    }
    public void setPrgid(String prgid) {
        this.prgid = prgid;
    }
    public String getOtherPay() {
        return otherPay;
    }
    public void setOtherPay(String otherPay) {
        this.otherPay = otherPay;
    }
    public String getFamilyCode() {
        return familyCode;
    }
    public void setFamilyCode(String familyCode) {
        this.familyCode = familyCode;
    }
    public String getBelongArea() {
        return belongArea;
    }
    public void setBelongArea(String belongArea) {
        this.belongArea = belongArea;
    }
    public Integer getFileStatusDesc() {
        return fileStatusDesc;
    }
    public void setFileStatusDesc(Integer fileStatusDesc) {
        this.fileStatusDesc = fileStatusDesc;
    }
	public Byte getState() {
		return state;
	}
	public void setState(Byte state) {
		this.state = state;
	}
}