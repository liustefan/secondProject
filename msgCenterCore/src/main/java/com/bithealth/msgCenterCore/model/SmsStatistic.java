/*
 * SmsSend.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-28 Created
 */
package com.bithealth.msgCenterCore.model;

import com.bithealth.sdk.core.generic.GenericModel;
import java.util.Date;


/**
 * 类名称: SmsStatistic  
 * 功能描述: 短信统计实体类
 * 日期: 2016年12月7日 下午2:19:03 
 * 
 * @author 谢美团
 * @version  
 */
public class SmsStatistic extends GenericModel {

	private static final long serialVersionUID = 1L;

	
    /**
     * 组织ID
     */
    private Integer orgID;
    /**
     * 组织名称
     */
    private String orgName = "";
    /**
     * 发送方式
     */
    private Integer contentType;
    
    private Integer total;
    
    private Integer success;
    
    private Integer fail;
    
    
	public Integer getOrgID() {
		return orgID;
	}
	public void setOrgID(Integer orgID) {
		this.orgID = orgID;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public Integer getContentType() {
		return contentType;
	}
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getSuccess() {
		return success;
	}
	public void setSuccess(Integer success) {
		this.success = success;
	}
	public Integer getFail() {
		return fail;
	}
	public void setFail(Integer fail) {
		this.fail = fail;
	}

}