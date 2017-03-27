/*
 * AlibabaSmsReq.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-02 Created
 */
package com.bithealth.centCore.sms.taobao;

import java.util.List;



/**
 * 类名称: AlibabaSmsReq  
 * 功能描述: 阿里巴巴短信查询返回实体 
 * 日期: 2016年12月2日 上午10:01:43 
 * 
 * @author 谢美团
 * @version  
 */
public class SmsNumQueryDetail {
	
	private List<SmsNumQueryResult>  fc_partner_sms_detail_dto;

	public List<SmsNumQueryResult> getFc_partner_sms_detail_dto() {
		return fc_partner_sms_detail_dto;
	}

	public void setFc_partner_sms_detail_dto(
			List<SmsNumQueryResult> fc_partner_sms_detail_dto) {
		this.fc_partner_sms_detail_dto = fc_partner_sms_detail_dto;
	}

}