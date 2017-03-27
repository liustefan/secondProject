/*
 * AlibabaSmsReq.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-02 Created
 */
package com.bithealth.centCore.sms.taobao;



/**
 * 类名称: AlibabaSmsReq  
 * 功能描述: 阿里巴巴短信查询返回实体 
 * 日期: 2016年12月2日 上午10:01:43 
 * 
 * @author 谢美团
 * @version  
 */
public class AlibabaSmsNumQueryRsp {
	
	/**
	 * 发送失败返回的参数实体
	 */
	private ErrorResponse error_response;
	
	/**
	 * 查询成功返回的参数实体
	 */
	private SmsNumQuerySuccessResponse alibaba_aliqin_fc_sms_num_query_response;


	public ErrorResponse getError_response() {
		return error_response;
	}

	public void setError_response(ErrorResponse error_response) {
		this.error_response = error_response;
	}

	public SmsNumQuerySuccessResponse getAlibaba_aliqin_fc_sms_num_query_response() {
		return alibaba_aliqin_fc_sms_num_query_response;
	}

	public void setAlibaba_aliqin_fc_sms_num_query_response(
			SmsNumQuerySuccessResponse alibaba_aliqin_fc_sms_num_query_response) {
		this.alibaba_aliqin_fc_sms_num_query_response = alibaba_aliqin_fc_sms_num_query_response;
	}

}