/**
 * @PackageName:      com.bithealth.memberCore.group.model
 * @FileName:     MemGroupExt.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月28日 下午5:56:40  
 * 
 */
package com.bithealth.memberCore.group.model;

import java.util.List;

import com.bithealth.memberCore.member.model.Member;

/**
 * 类名称: MemGroupExt  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 下午5:56:40 
 * 
 * @author liuhm
 * @version  
 */
public class MemGroupExt extends MemberGroup {

	private static final long serialVersionUID = -4010327426378644931L;
	
	private List<DoctorGrp> doctorGrpList;
	
	private List<Member> memberList;

	public List<DoctorGrp> getDoctorGrpList() {
		return doctorGrpList;
	}

	public void setDoctorGrpList(List<DoctorGrp> doctorGrpList) {
		this.doctorGrpList = doctorGrpList;
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}
	
}
