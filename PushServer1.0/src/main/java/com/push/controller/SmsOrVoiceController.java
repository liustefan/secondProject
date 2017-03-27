package com.push.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.push.constants.Constants;
import com.push.model.SmsRequestBean;
import com.push.result.ResultObject;
import com.push.service.PushMemberService;
import com.push.service.PushMsgService;
import com.push.service.SmsOrVioceService;



/** 
 * 短信语音发送控制器
 * @ClassName: SmsOrVoiceController 
 * @Description: 
 * @author 谢美团
 * @date 2015年12月8日 下午1:42:07  
 */
@Controller
public class SmsOrVoiceController {

	private static Logger logger = Logger.getLogger(SmsOrVoiceController.class); 
	
    @Autowired
    private PushMemberService pushMemberService;
    @Autowired
    private PushMsgService pushMsgService;
    
    @Resource(name="smsOrVioceService")  
    private SmsOrVioceService smsOrVioceService;
    
    
    /** 
     * 发送短信或者语音
     * @param requestParm
     * @return ResultObject
     * @Description:
     * @author 谢美团   
     * @date 2015年12月8日 下午1:39:01 
     * @version V1.0  
    */
    @ResponseBody 
	@RequestMapping(value="/smsOrVoiceSend",method = RequestMethod.POST)
	public ResultObject smsOrVoiceSend(SmsRequestBean requestParm){
    	ResultObject resultObject = new ResultObject();
		try {
			smsOrVioceService.smsOrVoiceSend(requestParm);
			logger.info("用户短信或语音发送接口调用成功！");
		} catch (Exception e) {
			resultObject.setResult(Constants.SYSTEM_ERROR, Constants.ERROR_MSG, "");
			logger.error("户短信或语音发送接口调用异常！",e);
		}		
    	
		return resultObject;
		
	}
	

    
}