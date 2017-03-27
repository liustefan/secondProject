/*
 * CareInfo.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-21 Created
 */
package com.bithealth.model;




/**
 * 类名称: Care  
 * 功能描述: 关注请求参数实体类
 * 日期: 2016年6月21日 上午11:39:21 
 * 
 * @author 谢美团
 * @version  
 */
public class CareParam{

	private static final long serialVersionUID = 1L;
	/**
	 * 关注方会员id
	 */
	private String memberId;
	/**	
	 * [2.1]会员GUID
	 */
	private String memberGUID;
	/**
	 * 被关在的会员id
	 */
	private Integer focusId;
	/**
	 * [2.1]被关注的会员GUID
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
	/**
	 * 昵称/备注/关系
	 */
	private String remark;


	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}