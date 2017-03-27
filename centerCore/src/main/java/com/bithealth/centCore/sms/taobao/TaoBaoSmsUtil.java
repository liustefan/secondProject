package com.bithealth.centCore.sms.taobao;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSONObject;
import com.bithealth.centCore.sms.constants.SmsConstrants;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumQueryRequest;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumQueryResponse;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;




public class TaoBaoSmsUtil {
 

	
	/**
	 * @Title:smsSend 
	 * @Description:短信发送 
	 * @author 谢美团
	 * @param alibabaSmsReq
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	public static AlibabaSmsRsp smsSend(AlibabaSmsReq alibabaSmsReq){
		AlibabaSmsRsp alibabaSmsRsp = new AlibabaSmsRsp();
		try {
			TaobaoClient client = new DefaultTaobaoClient(SmsConstrants.SMS_ALIBABA_URL, alibabaSmsReq.getAppKey(), alibabaSmsReq.getAppSecret());
			AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
			BeanUtils.copyProperties(alibabaSmsReq, req);
			AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req); 
			if(rsp != null && rsp.getBody() != null){
				alibabaSmsRsp = JSONObject.parseObject(rsp.getBody(), AlibabaSmsRsp.class);
			}else{
				ErrorResponse errorResponse = new ErrorResponse();
				errorResponse.setSub_msg(rsp.getMsg());
				alibabaSmsRsp.setError_response(errorResponse);
			}
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return alibabaSmsRsp;
	};
	
	
	
	public static AlibabaSmsNumQueryRsp getSmsSendStatus(AlibabaSmsNumQueryReq alibabaSmsNumQueryReq){
		AlibabaSmsNumQueryRsp alibabaSmsNumQueryRsp = new AlibabaSmsNumQueryRsp();
		try {
			TaobaoClient client = new DefaultTaobaoClient(SmsConstrants.SMS_ALIBABA_URL, alibabaSmsNumQueryReq.getAppKey(), alibabaSmsNumQueryReq.getAppSecret());
			AlibabaAliqinFcSmsNumQueryRequest req = new AlibabaAliqinFcSmsNumQueryRequest();
			BeanUtils.copyProperties(alibabaSmsNumQueryReq, req);
			AlibabaAliqinFcSmsNumQueryResponse rsp = client.execute(req);
			if(rsp != null && rsp.getBody() != null){
				alibabaSmsNumQueryRsp = JSONObject.parseObject(rsp.getBody(), AlibabaSmsNumQueryRsp.class);
			}else{
				ErrorResponse errorResponse = new ErrorResponse();
				errorResponse.setSub_msg(rsp.getMsg());
				alibabaSmsNumQueryRsp.setError_response(errorResponse);
			}
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return alibabaSmsNumQueryRsp;
	}
	
    
}