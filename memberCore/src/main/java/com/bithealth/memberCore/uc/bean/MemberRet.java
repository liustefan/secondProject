/**
 * 
 */
package com.bithealth.memberCore.uc.bean;

import com.bithealth.memberCore.member.model.Member;

/**
 * 
 * 类名称: MemberRet  
 * 功能描述: 会员注册返回类.  
 * 日期: 2016年7月4日 上午11:39:34 
 * 
 * @author liuhm
 * @version
 */
public class MemberRet {
	
	public final static int FAIL = 2;
	
	public final static int SUCCESS = 1;
	
	private Member member;
	
	/**
	 * 注册返回信息
	 */
	private String message;
	
	/**
	 * 注册编码 1：成功，2-失败
	 */
	private int code;
	
	public MemberRet(Member member) {
		this(member, "成功", SUCCESS);
	}
	
	public MemberRet(Member member, String message, int code) {
		this.member = member;
		this.message = message;
		this.code = code;
	}
	
	public MemberRet(){
		
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
