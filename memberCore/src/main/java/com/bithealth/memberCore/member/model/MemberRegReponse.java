/**
 * @PackageName:      com.bithealth.memberCore.member.model
 * @FileName:     MemberRegReponse.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月6日 上午9:40:10  
 * 
 */
package com.bithealth.memberCore.member.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bithealth.memberCore.uc.bean.MemberRet;

/**
 * 类名称: MemberRegReponse  
 * 功能描述: 会员注册时返回数据.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月6日 上午9:40:10 
 * 
 * @author liuhm
 * @version  
 */
public class MemberRegReponse implements Serializable {

	private static final long serialVersionUID = 3691009992906997739L;
	
	/**
	 * 注册成功的会员集合
	 */
	private List<MemberRet> successList = new ArrayList<MemberRet>();
	
	/**
	 * 注册失败的会员集合
	 */
	private List<MemberRet> errorList = new ArrayList<MemberRet>();
	
	/**
	 * 已经被注册的会员集合
	 */
	private List<MemberRet> existsList = new ArrayList<MemberRet>();

	public List<MemberRet> getSuccessList() {
		return successList;
	}

	public void setSuccessList(List<MemberRet> successList) {
		this.successList = successList;
	}

	public List<MemberRet> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<MemberRet> errorList) {
		this.errorList = errorList;
	}

	public List<MemberRet> getExistsList() {
		return existsList;
	}

	public void setExistsList(List<MemberRet> existsList) {
		this.existsList = existsList;
	}
	
}
