
package com.bithealth.centCore.sms.task;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.bithealth.centCore.sms.dao.SmsSendDetailMapper;
import com.bithealth.centCore.sms.enmu.SmsSendStatusEnmu;
import com.bithealth.centCore.sms.model.SmsConfig;
import com.bithealth.centCore.sms.model.SmsSendDetail;
import com.bithealth.centCore.sms.model.SmsSendDetailExample;
import com.bithealth.centCore.sms.service.SmsConfigService;
import com.bithealth.centCore.sms.service.SmsSendDetailService;
import com.bithealth.centCore.sms.taobao.AlibabaSmsNumQueryReq;
import com.bithealth.centCore.sms.taobao.AlibabaSmsNumQueryRsp;
import com.bithealth.centCore.sms.taobao.ErrorResponse;
import com.bithealth.centCore.sms.taobao.SmsNumQueryResult;
import com.bithealth.centCore.sms.taobao.TaoBaoSmsUtil;
import com.bithealth.sdk.common.utils.TimeUtil;


/**
 * 类名称: SmsSendTask  
 * 功能描述: 短信发送状态更新Task 
 * 日期: 2016年12月5日 下午1:51:50 
 * 
 * @author 谢美团
 * @version  
 */
@Service("smsUpdateTask")
public class SmsSendStatusUpdateTask extends TimerTask {

	protected static Logger logger = Logger.getLogger(SmsSendStatusUpdateTask.class);


	@Autowired
	SmsConfigService smsConfigService;
	@Autowired
	SmsSendDetailService smsSendDetailService;



	@Override
	public void run() {
		this.getSmsSendStatusAndUpdate();
	}

	public void getSmsSendStatusAndUpdate() {
		try {
			SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
			List<SmsConfig> smsList =  smsConfigService.selectHaveSendStatusSms();
			for(SmsConfig smsConfig:smsList){
				AlibabaSmsNumQueryReq alibabaSmsNumQueryReq = new AlibabaSmsNumQueryReq();
				alibabaSmsNumQueryReq.setAppKey(smsConfig.getAccount());
				alibabaSmsNumQueryReq.setAppSecret(smsConfig.getPasswd());
				alibabaSmsNumQueryReq.setQueryDate(smsConfig.getQueryDate());
				alibabaSmsNumQueryReq.setRecNum(smsConfig.getRecvNumber());
				AlibabaSmsNumQueryRsp  rsp = TaoBaoSmsUtil.getSmsSendStatus(alibabaSmsNumQueryReq);
				if(rsp.getAlibaba_aliqin_fc_sms_num_query_response() != null && rsp.getAlibaba_aliqin_fc_sms_num_query_response().getValues() != null){
					List<SmsNumQueryResult> detailList = rsp.getAlibaba_aliqin_fc_sms_num_query_response().getValues().getFc_partner_sms_detail_dto();
					if(detailList != null){
						for(SmsNumQueryResult result:detailList){
							SmsSendDetail record = new  SmsSendDetail();
							if(result.getSms_status() == 3){//发送成功
								record.setRecvTime(TimeUtil.parseDatetime2(result.getSms_receiver_time()));
								record.setSendStatus(SmsSendStatusEnmu.SEND_SUCCESS.getValue());
							}else if(result.getSms_status() == 2){//发送失败
								record.setSendStatus(SmsSendStatusEnmu.SEND_FAIL.getValue());
							}
							record.setUpdateTime( new Date());
							SmsSendDetailExample example = new SmsSendDetailExample();
							example.createCriteria().andSSendIDEqualTo(Integer.parseInt(result.getExtend())).andRecvNumberEqualTo(result.getRec_num());
							smsSendDetailService.updateByExampleSelective(record, example);
						}
					}
				}else{
					ErrorResponse  errorResponse  = rsp.getError_response();
					SmsSendDetail model = new  SmsSendDetail();
					model.setSSDetailID(smsConfig.getSSDetailID());
					model.setFailReason(errorResponse.getMsg());
					model.setSendStatus(SmsSendStatusEnmu.SEND_FAIL.getValue());
					model.setUpdateTime( new Date());
					smsSendDetailService.update(model);
				}
			}
			logger.info("短信定时更新发送状态任务执行完成");
		} catch (Exception e) {
			logger.error("短信定时更新发送状态任务执行异常："+e.getMessage());;
		}
	}

	

	

	
	
}
