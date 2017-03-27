/*
 * MemberBasicInfo.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-18 Created
 */
package com.bithealth.ucCore.uc.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bithealth.sdk.core.generic.GenericModel;

import java.util.Date;
import java.util.List;

/**
 * [1.1]会员表
 * 
 * @author ${user}
 * @version 1.0 2016-08-18
 */
public class MemberBasicInfo extends GenericModel {

    /**
     * 自增记录ID
     */
    private Integer logID;
    /**
     * 服务器ID(引用appRecode.app_server.id)
     */
    private Integer serverID;
    /**
     * 会员ID
     */
    private String memberID;
    
    /**
     * 会员ID
     */
	private String memberGUID;
    /**
     * 名称
     */
    private String memberName = "";
    /**
     * 性别：1-男；2-女；3-未知
     */
    private Byte memberSex;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 身份证号
     */
    private String IDCard;
    /**
     * 头像地址
     */
    private String headAddress;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 同步时间戳
     */
    private Long syncTimestamp;
    /**
     * [3.0]认证类型(位运算)：0-无，1-手机认证
     */
    private Byte verifyType = 0;
    /**
     * [3.0]是否资料完善：0-否，1-是
     */
    private Byte isInfoPerfect = 0;
    /**
     * 创建时间
     */
    private Date createTime = new Date();
    /**
     * 更新时间
     */
    private Date updateTime;
    
    /**
     * [3.0]会员名称简码
     */
    private String memNameCode;
    
    /**
     *服务地址
     */
    private String url;
    

	public String getMemberGUID() {
		return memberGUID;
	}
	public void setMemberGUID(String memberGUID) {
		this.memberGUID = memberGUID;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	private List<MemberAccount> accountList;
    
    public List<MemberAccount> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<MemberAccount> accountList) {
		this.accountList = accountList;
	}
	public Integer getLogID() {
        return logID;
    }
    public void setLogID(Integer logID) {
        this.logID = logID;
    }
    public Integer getServerID() {
        return serverID;
    }
    public void setServerID(Integer serverID) {
        this.serverID = serverID;
    }
    public String getMemberID() {
        return memberID;
    }
    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public Byte getMemberSex() {
        return memberSex;
    }
    public void setMemberSex(Byte memberSex) {
        this.memberSex = memberSex;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    @JSONField(name = "IDCard") 
    public String getIDCard() {
        return IDCard;
    }
    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }
    public String getHeadAddress() {
        return headAddress;
    }
    public void setHeadAddress(String headAddress) {
        this.headAddress = headAddress;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public Long getSyncTimestamp() {
        return syncTimestamp;
    }
    public void setSyncTimestamp(Long syncTimestamp) {
        this.syncTimestamp = syncTimestamp;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
	public Byte getVerifyType() {
		return verifyType;
	}
	public void setVerifyType(Byte verifyType) {
		this.verifyType = verifyType;
	}
	public Byte getIsInfoPerfect() {
		return isInfoPerfect;
	}
	public void setIsInfoPerfect(Byte isInfoPerfect) {
		this.isInfoPerfect = isInfoPerfect;
	}
	public String getMemNameCode() {
		return memNameCode;
	}
	public void setMemNameCode(String memNameCode) {
		this.memNameCode = memNameCode;
	}
}