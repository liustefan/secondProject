/**
 * @PackageName:      com.bithealth.ucCore.uc.result
 * @FileName:     MemberBase.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年11月29日 上午11:20:49  
 * 
 */
package com.bithealth.ucCore.uc.result;

import java.io.Serializable;

/**
 * 类名称: MemberBase  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年11月29日 上午11:20:49 
 * 
 * @author liuhm
 * @version  
 */
public class MemberBase implements Serializable {

	private static final long serialVersionUID = 4704378303893330510L;
	
	private String memberGUID;
	
	private String memberName;
	
	private String gender;
	
	private String idcard;
	
	private String tel;
	
	private String serverName;
	
	private Integer serverId;

	public String getMemberGUID() {
		return memberGUID;
	}

	public void setMemberGUID(String memberGUID) {
		this.memberGUID = memberGUID;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public Integer getServerId() {
		return serverId;
	}

	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}
	
}
