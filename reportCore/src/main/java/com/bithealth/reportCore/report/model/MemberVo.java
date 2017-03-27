/*
 * Member.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.reportCore.report.model;

import java.math.BigDecimal;

import com.bithealth.memberCore.member.model.Member;

/**
 * 会员档案实体扩展类
 * 
 * @author ${user}
 * @version 1.0 2016-06-23
 */
public class MemberVo extends Member {

	private static final long serialVersionUID = 1L;
	
    /**
     * 身高(cm)
     */
    private Integer height;
    /**
     * 体重(kg)
     */
    private BigDecimal weight;
    
    
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	
}