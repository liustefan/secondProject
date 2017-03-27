/**
 * @PackageName:      com.bithealth.agentCore.enums
 * @FileName:     UCMethodEnum.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月23日 上午10:26:32  
 * 
 */
package com.bithealth.agentCore.enums;

import com.bithealth.agentCore.Constrants;

/**
 * 类名称: UCMethodEnum  
 * 功能描述: UC方法名定义.  
 * 日期: 2016年8月23日 上午10:26:32 
 * 
 * @author liuhm
 * @version  
 */
public enum UCMethodEnum implements Method {
	Address_Route("getAddress", "获取账号登入服务地址"),
	Address_Member("getAddressByMemberID", "会员的服务地址"),
	member_delete("memberDelete", "会员删除"),
	RegisterResult("getRegisterResult", "获取注册结果"),
	RegisterAsync("memberRegisterAsync", "异步注册"),
	RegisterSync("memberRegisterSync","同步注册"),
	QueryMember("getMemberBySearchParam","同步注册"),
	ModifyPwd("pwdModify","密码修改同步"),
	GetMemberByAccount("getMemberByAccountAndPwd","通过账号和密码获取会员"),
	GetMembers("getMembers", "获取会员"),
	AppMemberRegist("appMemberRegist", "App会员手机号注册"),
	CheckMerge("checkMerge", "校验是否可以合并"),
	CheckAccount("checkAccount", "校验账号是否存在"),
	Merge("merge", "合并资料或者会员在App完善资料"),
	ChangeTel("changeTel", "修改认证手机"),
	GetAppServer("getAppServer", "获取appserver的地址")
	;
	
	

    private String method;
	
	private String description;
	
	private UCMethodEnum(String method, String description) {
		this.method = method;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String getUrl() {
		return Constrants.UC_URL + "/" + this.method;
	}

}
