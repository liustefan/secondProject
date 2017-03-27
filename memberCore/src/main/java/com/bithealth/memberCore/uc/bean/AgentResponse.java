/**
 * @PackageName:      com.bithealth.memberCore.uc.bean
 * @FileName:     AgentResponse.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月24日 上午10:01:56  
 * 
 */
package com.bithealth.memberCore.uc.bean;

import java.io.Serializable;
import java.util.List;

import com.bithealth.memberCore.constants.CodeStatus;

/**
 * 类名称: AgentResponse  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月24日 上午10:01:56 
 * 
 * @author liuhm
 * @version  
 */
public class AgentResponse extends UCRetBase implements Serializable, CodeStatus {

	private static final long serialVersionUID = 346012592532051052L;
	
	private List<MemberResponse> content;
	
	public AgentResponse() {
		
	}
	
	public AgentResponse(int code, String message) {
		super(code, message);
	}

	public List<MemberResponse> getContent() {
		return content;
	}

	public void setContent(List<MemberResponse> content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "AgentResponse [code=" + super.getCode() + ", message=" + super.getMessage()
				+ ", content=" + content + "]";
	}
	
}
