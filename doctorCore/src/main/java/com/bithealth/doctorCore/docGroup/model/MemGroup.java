/**
 * @PackageName:      com.bithealth.doctorCore.docGroup.model
 * @FileName:     MemGroup.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月28日 下午4:58:33  
 * 
 */
package com.bithealth.doctorCore.docGroup.model;

import java.io.Serializable;

/**
 * 类名称: MemGroup  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 下午4:58:33 
 * 
 * @author liuhm
 * @version  
 */
public class MemGroup implements Serializable {

	private static final long serialVersionUID = 5695904986662632297L;
	
	private Integer memberGroupId;
	
	private String memberGrpName;

	public Integer getMemberGroupId() {
		return memberGroupId;
	}

	public void setMemberGroupId(Integer memberGroupId) {
		this.memberGroupId = memberGroupId;
	}

	public String getMemberGrpName() {
		return memberGrpName;
	}

	public void setMemberGrpName(String memberGrpName) {
		this.memberGrpName = memberGrpName;
	}
	
}
