/**
 * @PackageName:      com.bithealth.memberCore.member.vo
 * @FileName:     MovementCondition.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年11月28日 下午1:36:34  
 * 
 */
package com.bithealth.memberCore.member.vo;

/**
 * 类名称: MovementCondition  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年11月28日 下午1:36:34 
 * 
 * @author liuhm
 * @version  
 */
public class MovementCondition {
	
	private String memberName;
	
	private String tel;
	
	private String idcard;
	
	private String applyStartDate;
	
	private String applyEndDate;
	
	private Integer status;
	
	private Integer createDrId;
	
	private Integer confirmDrId;

	public Integer getCreateDrId() {
		return createDrId;
	}

	public void setCreateDrId(Integer createDrId) {
		this.createDrId = createDrId;
	}

	public Integer getConfirmDrId() {
		return confirmDrId;
	}

	public void setConfirmDrId(Integer confirmDrId) {
		this.confirmDrId = confirmDrId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getApplyStartDate() {
		return applyStartDate;
	}

	public void setApplyStartDate(String applyStartDate) {
		this.applyStartDate = applyStartDate;
	}

	public String getApplyEndDate() {
		return applyEndDate;
	}

	public void setApplyEndDate(String applyEndDate) {
		this.applyEndDate = applyEndDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
