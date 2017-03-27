
package com.bithealth.centCore.sms.task;

import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.bithealth.centCore.facade.service.SmsIFService;
import com.bithealth.centCore.sms.dao.SmsConfigMapper;
import com.bithealth.centCore.sms.enmu.SmsEnmu;
import com.bithealth.centCore.sms.model.SmsConfig;
import com.bithealth.centCore.sms.taobao.AlibabaSmsReq;


/**
 * 类名称: SmsSendTask  
 * 功能描述: 短信定时发送Task 
 * 日期: 2016年12月5日 下午1:51:50 
 * 
 * @author 谢美团
 * @version  
 */
@Service("smsSendTask")
public class SmsSendTask extends TimerTask {

	protected static Logger logger = Logger.getLogger(SmsSendTask.class);

	@Autowired
	private SmsIFService smsIFService;
	@Autowired
	SmsConfigMapper smsConfigMapper;



	@Override
	public void run() {
		this.smsSend();
	}

	public void smsSend() {
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			 List<SmsConfig>  smsList = smsConfigMapper.selectToBeSendSms();
			 for(SmsConfig smsConfig:smsList){
				 AlibabaSmsReq alibabaSmsReq = new AlibabaSmsReq();
				 alibabaSmsReq.setAppKey(smsConfig.getAccount());
				 alibabaSmsReq.setAppSecret(smsConfig.getPasswd());
				 alibabaSmsReq.setExtend(smsConfig.getSSendID().toString());
				 alibabaSmsReq.setRecNum(smsConfig.getRecvNumber());
				 alibabaSmsReq.setSmsFreeSignName(smsConfig.getSignature());
				 alibabaSmsReq.setSmsParamString(smsConfig.getContent());
				 alibabaSmsReq.setSmsTemplateCode(smsIFService.getTemplateNo(smsConfig,smsConfig.getSmsType()));
				 smsIFService.smsSendAndUpdate(alibabaSmsReq, smsConfig.getSSendID(),smsConfig.getFailCount());
			 }
			logger.info("短信发送定时任务执行完成");
		} catch (Exception e) {
			logger.error("短信发送定时任务执行异常："+e.getMessage());;
		}
	}

	

	

	
	
}
