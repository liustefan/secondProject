/**
 * @PackageName:      com.bithealth.memberCore.constants
 * @FileName:     CodeStatus.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年9月1日 下午3:32:47  
 * 
 */
package com.bithealth.memberCore.constants;

import com.bithealth.agentCore.AgentStatus;

/**
 * 类名称: CodeStatus  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年9月1日 下午3:32:47 
 * 
 * @author liuhm
 * @version  
 */
public interface CodeStatus extends AgentStatus{
	/**
	 * 1-成功，2-失败，3-返回数据格式错误， 4-调用agent失败
	 */
	public final static int OK = 0;
	
	public final static int FAIL = 2;
	
	public final static int DATA_ERROR = 3;
	
	public final static int AGENT_ERROR = 4;
	
	/**  账号不存在     */
	public final static int ACCOUNT_NOT_EXIST = 101;	
	
	/** 	用户不存在 */
	public final static int USER_NOT_EXIST = 102;
	
	/**	服务器内部异常*/
	public final static int SERVER_ERROR = 201;
	
	/**	token错误*/
	public final static int TOKEN_ERROR = 301;
	
	/**	sign错误*/
	public final static int SIGN_ERROR = 302;
	
	/**	无权限登入*/
	public final static int NO_AUTHORITY = 303;
	/**serverID为空*/
	public final static int SERVER_ID_NULL = 304;
	
	/**	请求参数为空*/
	public final static int PARAMETER_NULL = 305;

}
