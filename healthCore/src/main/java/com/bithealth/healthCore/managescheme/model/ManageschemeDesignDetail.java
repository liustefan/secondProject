/*
 * ManageschemeDesignDetail.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-08 Created
 */
package com.bithealth.healthCore.managescheme.model;

import com.bithealth.sdk.core.generic.GenericModel;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

/**
 * [3.0]管理方案_制定_明细
 * 
 * @author ${user}
 * @version 1.0 2016-12-08
 */
public class ManageschemeDesignDetail extends GenericModel {

    /**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -7186915428361682678L;
	/**
     * 管理方案_制定ID
     */
    private Integer MSDesignID;
    /**
     * 总体管理目标
     */
    private String manageGoal;
    /**
     * 基准时间：1-方案触发时间
     */
    private Byte benchmarkTime;
    /**
     * 服务期限数值
     */
    private Byte srvLimitValue;
    /**
     * 服务期限类型：1-天，2-周，3-月，4-年
     */
    private Byte srvLimitType;
    /**
     * 是否收费：0-否，1-是
     */
    private Byte isCharge;
    /**
     * 收费价格(元)
     */
    private BigDecimal price;
    /**
     * 附件显示名称
     */
    private String fileName;
    /**
     * 附件路径+文件名
     */
    private String filePath;
    /**
     * 方案介绍
     */
    private String introduction;
    /**
     * 创建医生ID
     */
    private Integer createID;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新医生ID
     */
    private Integer updateID;
    /**
     * 更新时间
     */
    private Date updateTime;
    
    private MultipartFile file;

    public Integer getMSDesignID() {
        return MSDesignID;
    }
    public void setMSDesignID(Integer MSDesignID) {
        this.MSDesignID = MSDesignID;
    }
    public String getManageGoal() {
        return manageGoal;
    }
    public void setManageGoal(String manageGoal) {
        this.manageGoal = manageGoal;
    }
    public Byte getBenchmarkTime() {
        return benchmarkTime;
    }
    public void setBenchmarkTime(Byte benchmarkTime) {
        this.benchmarkTime = benchmarkTime;
    }
    public Byte getSrvLimitValue() {
        return srvLimitValue;
    }
    public void setSrvLimitValue(Byte srvLimitValue) {
        this.srvLimitValue = srvLimitValue;
    }
    public Byte getSrvLimitType() {
        return srvLimitType;
    }
    public void setSrvLimitType(Byte srvLimitType) {
        this.srvLimitType = srvLimitType;
    }
    public Byte getIsCharge() {
        return isCharge;
    }
    public void setIsCharge(Byte isCharge) {
        this.isCharge = isCharge;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public Integer getCreateID() {
        return createID;
    }
    public void setCreateID(Integer createID) {
        this.createID = createID;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Integer getUpdateID() {
        return updateID;
    }
    public void setUpdateID(Integer updateID) {
        this.updateID = updateID;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
	/**
	 * file.
	 *
	 * @return  the file 
	 */
	public MultipartFile getFile() {
		return file;
	}
	/**
	 * file.
	 *
	 * @param   file    the file to set 
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
	}
    
}