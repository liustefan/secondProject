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
 * 功能描述: 阿里巴巴短信发送返回实体 
 * 日期: 2016年12月2日 上午10:01:43 
 * 
 * @author 谢美团
 * @version  
 */
public class AlibabaSmsRsp {
	
	/**
	 * 发送失败返回的参数实体
	 */
	private ErrorResponse error_response;
	
	/**
	 * 发送成功返回的参数实体
	 */
	private SuccessResponse alibaba_aliqin_fc_sms_num_send_response;
	
	
	public ErrorResponse getError_response() {
		return error_response;
	}
	public void setError_response(ErrorResponse error_response) {
		this.error_response = error_response;
	}
	public SuccessResponse getAlibaba_aliqin_fc_sms_num_send_response() {
		return alibaba_aliqin_fc_sms_num_send_response;
	}
	public void setAlibaba_aliqin_fc_sms_num_send_response(
			SuccessResponse alibaba_aliqin_fc_sms_num_send_response) {
		this.alibaba_aliqin_fc_sms_num_send_response = alibaba_aliqin_fc_sms_num_send_response;
	}
	
	
}