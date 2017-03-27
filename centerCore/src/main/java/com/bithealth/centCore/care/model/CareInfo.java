/*
 * CareInfo.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-08-23 Created
 */
package com.bithealth.centCore.care.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.bithealth.sdk.core.generic.GenericModel;

/**
 * [1.1]关注表
 * 
 * @author ${user}
 * @version 1.0 2016-09-05
 */
public class CareInfo extends GenericModel {

    private Long id;
    /**
     * 关注类型 1表示主动添加，2表示被邀请
     */
    private Integer focusType;
    /**
     * 关注方会员id
     */
    private Integer memberId;
    /**
     * 会员GUID
     */
    private String memberGUID;
    /**
     * 被关注方的会员id
     */
    private Integer focusId;
    /**
     * 被关注的会员GUID
     */
    private String focusGUID;
    /**
     * 关注状态：1-表示未处理，2-表示接受，3-表示拒绝
     */
    private Integer focusStatus;
    /**
     * 允许关注项，格式如下1，2，3关注项的id字符
     */
    private String focusP;
    /**
     * 已关注项，格式如下1，2，3关注项的id字符
     */
    private String focusPed;
    /**
     * 关注是否过期，N表示未过期Y表示关注方取消Z表示被关注方取消
     */
    private String tag;
    private String createTime;
    /**
     * <废弃> 1表示关注方接受信息2表示不接收
     */
    private Short newsLetter;
    /**
     * 关注方备注
     */
    private String memberRemark;
    /**
     * 被关注方备注
     */
    private String focusRemark;
    

    //额外增加的参数   
	/**
     * 服务器ID(引用appRecode.app_server.id)
     */
    private Integer serverID;
    /**
     * 名称
     */
    private String memberName;
    /**
     * 性别：1-男；2-女；3-未知
     */
    private String memberSex;
    
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 身份证号
     */
    private String IDCard;

    /**
     * 最新动态
     */
    private String news;
    
    /**
     * 最新动态的阅读状态，0：已读，1：未读
     */
    private Integer number = 0;
    
    /**
     * 头像地址
     */
    private String headAddress;
    /**
     *服务地址
     */
    private String url;
    
    /**
     * 出生日期
     */
    @JSONField (format="yyyy-MM-dd HH:mm:ss") 
    private Date birthday;
    
 
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getFocusType() {
        return focusType;
    }
    public void setFocusType(Integer focusType) {
        this.focusType = focusType;
    }
    public Integer getMemberId() {
        return memberId;
    }
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
    public String getMemberGUID() {
        return memberGUID;
    }
    public void setMemberGUID(String memberGUID) {
        this.memberGUID = memberGUID;
    }
    public Integer getFocusId() {
        return focusId;
    }
    public void setFocusId(Integer focusId) {
        this.focusId = focusId;
    }
    public String getFocusGUID() {
        return focusGUID;
    }
    public void setFocusGUID(String focusGUID) {
        this.focusGUID = focusGUID;
    }
    public Integer getFocusStatus() {
        return focusStatus;
    }
    public void setFocusStatus(Integer focusStatus) {
        this.focusStatus = focusStatus;
    }
    public String getFocusP() {
        return focusP;
    }
    public void setFocusP(String focusP) {
        this.focusP = focusP;
    }
    public String getFocusPed() {
        return focusPed;
    }
    public void setFocusPed(String focusPed) {
        this.focusPed = focusPed;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public Short getNewsLetter() {
        return newsLetter;
    }
    public void setNewsLetter(Short newsLetter) {
        this.newsLetter = newsLetter;
    }
    public String getMemberRemark() {
        return memberRemark;
    }
    public void setMemberRemark(String memberRemark) {
        this.memberRemark = memberRemark;
    }
    public String getFocusRemark() {
        return focusRemark;
    }
    public void setFocusRemark(String focusRemark) {
        this.focusRemark = focusRemark;
    }
	public Integer getServerID() {
		return serverID;
	}
	public void setServerID(Integer serverID) {
		this.serverID = serverID;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberSex() {
		return memberSex;
	}
	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	public String getNews() {
		return news;
	}
	public void setNews(String news) {
		this.news = news;
	}
	public String getHeadAddress() {
		return headAddress;
	}
	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
    
    
}