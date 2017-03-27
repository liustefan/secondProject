package com.push.model;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the hk_push_member database table.
 * 
 */
public class HkPushMember implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String channelId;

	private String createBy;

	private Date createDate;

	private Integer lineStatus;

	private Integer loginPlatform;

	private String memberId;

	private String roleCookie;

	private Integer roleStatus;

	private Integer thirdPlatform;

	private String updateBy;

	private Date updateDate;

	private String userId;
	
	private Date loginTime;

	public HkPushMember() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChannelId() {
		return this.channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getLineStatus() {
		return this.lineStatus;
	}

	public void setLineStatus(Integer lineStatus) {
		this.lineStatus = lineStatus;
	}

	public Integer getLoginPlatform() {
		return this.loginPlatform;
	}

	public void setLoginPlatform(Integer loginPlatform) {
		this.loginPlatform = loginPlatform;
	}

	public String getMemberId() {
		return this.memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getRoleCookie() {
		return this.roleCookie;
	}

	public void setRoleCookie(String roleCookie) {
		this.roleCookie = roleCookie;
	}

	public int getRoleStatus() {
		return this.roleStatus;
	}

	public void setRoleStatus(Integer roleStatus) {
		this.roleStatus = roleStatus;
	}

	public int getThirdPlatform() {
		return this.thirdPlatform;
	}

	public void setThirdPlatform(Integer thirdPlatform) {
		this.thirdPlatform = thirdPlatform;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

}