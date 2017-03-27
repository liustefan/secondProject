/*
 * OrgConfig.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-11 Created
 */
package com.bithealth.orgainCore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.bithealth.orgainCore.enmu.MemMustItemEnum;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * 组织配置表
 * 
 * @author ${user}
 * @version 1.0 2016-08-11
 */
public class OrgConfig extends GenericModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1326131674730526293L;
	/**
     * 记录ID
     */
    private Integer logID;
    /**
     * 组织ID(引用orgs)
     */
    private Integer orgID;
    /**
     * 会员信息必填项(位运算)：1-姓名，2-性别，4-出生日期，8-身份证，16-手机号
     */
    private Long memMustSetItem;
    
    private String memMustSetItemStr;
    /**
     * 会员类型(引用omes)
     */
    private Short memId;
    
    /**
     * 会员类型名
     */
    private String memberTypeName;
    /**
     * 体验会员数量(个)
     */
    private Integer experienceNum;
    /**
     * 体验时长(天)
     */
    private Integer experienceDay;
    /**
     * 是否显示智能卡号：0-否，1-是
     */
    private Byte isDisplayCard;
    
    /**
     * 是否与上级节点共享：0-否，1-是
     */
    private Byte sharedParentNode;
    /**
     * 创建医生ID(引用odoc表)，0-系统
     */
    private Integer createDrID;
    /**
     * 记录创建时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 更新医生ID(引用odoc表)，0-系统
     */
    private Integer updateDrID;
    /**
     * 记录更新时间
     */
    private Date updateTime;
    
    public Integer getLogID() {
        return logID;
    }
    public void setLogID(Integer logID) {
        this.logID = logID;
    }
    public Integer getOrgID() {
        return orgID;
    }
    public void setOrgID(Integer orgID) {
        this.orgID = orgID;
    }
    public Long getMemMustSetItem() {
        return memMustSetItem;
    }
    public void setMemMustSetItem(Long memMustSetItem) {
        this.memMustSetItem = memMustSetItem;
    }
    public Short getMemId() {
        return memId;
    }
    public void setMemId(Short memId) {
        this.memId = memId;
    }
    public String getMemberTypeName() {
		return memberTypeName;
	}
	public void setMemberTypeName(String memberTypeName) {
		this.memberTypeName = memberTypeName;
	}
	public Integer getExperienceNum() {
        return experienceNum;
    }
    public void setExperienceNum(Integer experienceNum) {
        this.experienceNum = experienceNum;
    }
    public Integer getExperienceDay() {
        return experienceDay;
    }
    public void setExperienceDay(Integer experienceDay) {
        this.experienceDay = experienceDay;
    }
    public Byte getIsDisplayCard() {
        return isDisplayCard;
    }
    public void setIsDisplayCard(Byte isDisplayCard) {
        this.isDisplayCard = isDisplayCard;
    }
    public Integer getCreateDrID() {
        return createDrID;
    }
    public void setCreateDrID(Integer createDrID) {
        this.createDrID = createDrID;
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
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
	public Byte getSharedParentNode() {
		return sharedParentNode;
	}
	public void setSharedParentNode(Byte sharedParentNode) {
		this.sharedParentNode = sharedParentNode;
	}
	public String getMemMustSetItemStr() {
		return memMustSetItemStr;
	}
	public void setMemMustSetItemStr(String memMustSetItemStr) {
		this.memMustSetItemStr = memMustSetItemStr;
		
		//将memMustSetItemStr转化为整数求和赋给memMustSetItem
		if(memMustSetItemStr != null && !memMustSetItemStr.isEmpty()){
			String[] arr = memMustSetItemStr.split(",");
			Long total = 0L;
			for(String str : arr){
				total += Integer.valueOf(str.trim());
			}
			this.memMustSetItem = total;
		}
	}
	
	public MemMustItemEnum[] settings(){
		String[] arr = getMemMustSetItemArr();
		if(arr.length > 0) {
			MemMustItemEnum[] enums = new MemMustItemEnum[arr.length];
			for(int i = 0; i < arr.length; i++) {
				enums[i] = MemMustItemEnum.get(Integer.parseInt(arr[i]));
			}
			return enums;
		}
		return null;
	}
	
	public String[] getMemMustSetItemArr(){
		//1-姓名，2-性别，4-出生日期，8-身份证，16-手机号，32-智能卡号，64-会员类型
		
		if(memMustSetItem != null){
			List<String> list = new ArrayList<String>();
			decompose(memMustSetItem.intValue(), list);
			
			return (String[])list.toArray(new String[list.size()]);
		}
		return null;
	}
	
	//分解memMustSetItem的值，值是由1，2，4，8，16，32求和而成
	public List<String> decompose(int param, List<String> list){
		int[] num = {1,2,4,8,16,32};
		for(int i=0; i<num.length; i++){
			if(i == num.length -1){
				if(num[i] <= param){
					int temp = param - num[i];
					list.add(String.valueOf(num[i]));
					decompose(temp,list);
				}
			}else{
				if(num[i] <= param && param < num[i+1]){
					int temp = param - num[i];
					list.add(String.valueOf(num[i]));
					decompose(temp,list);
				}
			}
		}
		return list;
	}
}