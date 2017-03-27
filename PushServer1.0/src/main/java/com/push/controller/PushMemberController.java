package com.push.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.push.constants.Constants;
import com.push.model.HKPushInfo;
import com.push.result.ResultObject;
import com.push.service.PushMemberService;
import com.push.service.PushMsgService;


@Controller
public class PushMemberController {

	private static Logger logger = Logger.getLogger(PushMemberController.class); 
	
    @Autowired
    private PushMemberService pushMemberService;
    @Autowired
    private PushMsgService pushMsgService;
    
    /**
	 * 用户上线接口
	 * @param memberId 角色id
	 * @param channelId 通道ID
	 * @param userId userID
	 * @param platform 推送平台：baidu ，getui，jpush
	 * @param loginPlatform 角色登录的平台：0：android；1：ios
	 * @param sign 数字签名
	 */

    @ResponseBody 
	@RequestMapping(value="/roleOnline",method = RequestMethod.POST)
	public ResultObject roleOnline(HKPushInfo requestParm){
    	ResultObject resultObject = new ResultObject();
		try {
			pushMemberService.memberOnline(requestParm);
			logger.info("用户上线接口调用成功！");
		} catch (Exception e) {
			resultObject.setResult(Constants.SYSTEM_ERROR, Constants.ERROR_MSG, "");
			logger.error("用户上线接口调用异常！",e);
		}		
    	
		return resultObject;
		
	}
	
	/**
	 * 用户离线接口
	 * @param memberId 角色id
	 * @param sign 数字签名
	 */
    @ResponseBody 
	@RequestMapping(value="/roleOffline",method = RequestMethod.POST)
	public ResultObject roleOffline(HKPushInfo requestParm){
		
    	ResultObject resultObject = new ResultObject();
		try {
			requestParm.setLineStatus(Constants.OFF_LINE);
			pushMemberService.updateHkPushMember(requestParm);
			
			logger.info("用户离线接口调用成功！");
		} catch (Exception e) {
			resultObject.setResult(Constants.SYSTEM_ERROR, Constants.ERROR_MSG, "");
			logger.error("用户离线接口调用异常！",e);
		}
    	
    	
		return resultObject;
	}
    
}