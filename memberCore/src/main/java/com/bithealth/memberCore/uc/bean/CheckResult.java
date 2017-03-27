/**
 * @PackageName:      com.bithealth.memberCore.uc.bean
 * @FileName:     CheckResult.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年12月9日 上午11:17:36  
 * 
 */
package com.bithealth.memberCore.uc.bean;

/**
 * 类名称: CheckResult  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月9日 上午11:17:36 
 * 
 * @author liuhm
 * @version  
 */
public class CheckResult extends UCRetBase {

	private static final long serialVersionUID = -7749437893474095336L;
	public static final int NEW_MEMBER = 9999;
	public static final int CONFIRM_MEMBER = 6666;
	public static final int MERGE_MEMBER = 8888;
	public static final int CONCAT_CUSTOM = 7777;

	/**
	 * 301-参数错误、201-服务器内部异常，101-会员不存在，8888-存在可以合并会员，9999-新会员，直接可以保存，
	 * 6666-存在简码相同会员，需页面确定再合并，7777-需要联系客服,408-连接超时
	 * 
	 */
	private MergerDetail content;
	
	public CheckResult() {
		
	}
	public CheckResult(int code, String message) {
		super(code, message);
	}

	public MergerDetail getContent() {
		return content;
	}

	public void setContent(MergerDetail content) {
		this.content = content;
	}
	
}
