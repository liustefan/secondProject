/*
 * PhysicalExamination.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.math.BigDecimal;

/**
 * 体格检查(MEM2)
 * 
 * @author ${user}
 * @version 1.0 2016-06-23
 */
public class PhysicalExamination extends GenericModel {

	private static final long serialVersionUID = 1748559200821627985L;
	/**
     * 会员代码
     */
    private Integer memberid;
    /**
     * 血型
     */
    private String bloodtype;
    /**
     * 过敏史(有或者无)
     */
    private String allergichis = "N";
    /**
     * 过敏史
     */
    private String allergichisname;
    /**
     * 身高(cm)
     */
    private Integer height;
    /**
     * 体重(kg)
     */
    private BigDecimal weight;
    /**
     * 腰围(cm)
     */
    private Integer waist;
    /**
     * 臀围(cm)
     */
    private Integer hip;
    /**
     * 脉搏
     */
    private Integer pulse;
    /**
     * 心率
     */
    private Integer heartrate;
    /**
     * 血压
     */
    private Short bloodh;
    /**
     * 舒张压
     */
    private Short bloodl;
    /**
     * 空腹血糖
     */
    private BigDecimal fastingglucose;
    /**
     * 尿酸
     */
    private Integer uricacid;
    /**
     * 总胆固醇
     */
    private BigDecimal totalcholesterol;
    /**
     * 甘油三酯
     */
    private BigDecimal triglyceride;
    /**
     * 高密度脂蛋白
     */
    private BigDecimal densitylipop;
    /**
     * 低密度脂蛋白
     */
    private BigDecimal ldlip;

    public Integer getMemberid() {
        return memberid;
    }
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }
    public String getBloodtype() {
        return bloodtype;
    }
    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }
    public String getAllergichis() {
        return allergichis;
    }
    public void setAllergichis(String allergichis) {
        this.allergichis = allergichis;
    }
    public String getAllergichisname() {
        return allergichisname;
    }
    public void setAllergichisname(String allergichisname) {
        this.allergichisname = allergichisname;
    }
    public Integer getHeight() {
        return height;
    }
    public void setHeight(Integer height) {
        this.height = height;
    }
    public BigDecimal getWeight() {
        return weight;
    }
    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
    public Integer getWaist() {
        return waist;
    }
    public void setWaist(Integer waist) {
        this.waist = waist;
    }
    public Integer getHip() {
        return hip;
    }
    public void setHip(Integer hip) {
        this.hip = hip;
    }
    public Integer getPulse() {
        return pulse;
    }
    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }
    public Integer getHeartrate() {
        return heartrate;
    }
    public void setHeartrate(Integer heartrate) {
        this.heartrate = heartrate;
    }
    public Short getBloodh() {
        return bloodh;
    }
    public void setBloodh(Short bloodh) {
        this.bloodh = bloodh;
    }
    public Short getBloodl() {
        return bloodl;
    }
    public void setBloodl(Short bloodl) {
        this.bloodl = bloodl;
    }
    public BigDecimal getFastingglucose() {
        return fastingglucose;
    }
    public void setFastingglucose(BigDecimal fastingglucose) {
        this.fastingglucose = fastingglucose;
    }
    public Integer getUricacid() {
        return uricacid;
    }
    public void setUricacid(Integer uricacid) {
        this.uricacid = uricacid;
    }
    public BigDecimal getTotalcholesterol() {
        return totalcholesterol;
    }
    public void setTotalcholesterol(BigDecimal totalcholesterol) {
        this.totalcholesterol = totalcholesterol;
    }
    public BigDecimal getTriglyceride() {
        return triglyceride;
    }
    public void setTriglyceride(BigDecimal triglyceride) {
        this.triglyceride = triglyceride;
    }
    public BigDecimal getDensitylipop() {
        return densitylipop;
    }
    public void setDensitylipop(BigDecimal densitylipop) {
        this.densitylipop = densitylipop;
    }
    public BigDecimal getLdlip() {
        return ldlip;
    }
    public void setLdlip(BigDecimal ldlip) {
        this.ldlip = ldlip;
    }
}