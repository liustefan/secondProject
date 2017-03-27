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
import com.push.service.PushMsgService;


@Controller
public class PushMsgController {

	private static Logger logger = Logger.getLogger(PushMsgController.class); 
	
    @Autowired
    private PushMsgService pushMsgService;
    
    
    /**
     * 根据memberId推送消息到指定用户
     * @param requestParm
     * @return
     */
    @ResponseBody 
    @RequestMapping(value="/pushByMemberId")
    public ResultObject pushByMemberId(HKPushInfo requestParm) {
    	ResultObject resultObject = new ResultObject();
    	try{
    		pushMsgService.pushByMemberId(requestParm);
    		logger.info("根据memberId推送消息到指定用户接口调用成功！");	
    	}catch(Exception e){
    		resultObject.setResult(Constants.SYSTEM_ERROR,Constants.ERROR_MSG, "");
    		logger.error("根据memberId推送消息推送异常！",e);
    	}
    	return resultObject;
    }
    
    /**
     * 根据多个 memberId推送消息到指定用户群
     * @param requestParm
     * @return
     */
    @ResponseBody 
    @RequestMapping(value="/pushByMemberIds",method = RequestMethod.POST)
    public ResultObject pushByMemberIds(HKPushInfo requestParm) {
    	ResultObject resultObject = new ResultObject();
    	try{
    		pushMsgService.pushByMemberIds(requestParm);
    		logger.info("根据多个memberId推送消息到指定用户接口调用成功！");
    	}catch(Exception e){
    		resultObject.setResult(Constants.SYSTEM_ERROR,Constants.ERROR_MSG, "");
    		logger.info("根据多个 memberId推送消息异常！",e);
    	}
    	return resultObject;
    }
    
    /**
     * 根据自定义的tag推送消息到有该标签的用户群
     * @param requestParm
     * @return
     */
    @ResponseBody 
    @RequestMapping(value="/pushByTag",method = RequestMethod.POST)
    public ResultObject pushByTag(HKPushInfo requestParm) {
    	ResultObject resultObject = new ResultObject();
    	try{
    		pushMsgService.pushByTag(requestParm);
    		logger.info("根据tag推送消息到指定用户接口调用成功！");
    	}catch(Exception e){
    		resultObject.setResult(Constants.SYSTEM_ERROR,Constants.ERROR_MSG,"");
    		logger.info("根据tag推送消息异常！",e);
    	}
    	return resultObject;
    }
    
    
    
    /**
     * 根据多个tag 推送到指定用户群
     * @param requestParm
     * @return
     */
    @ResponseBody 
    @RequestMapping(value="/pushByTags",method = RequestMethod.POST)
    public ResultObject pushByTags(HKPushInfo requestParm) {
    	ResultObject resultObject = new ResultObject();
    	try{
    		resultObject = pushMsgService.pushByTags(requestParm);
    		logger.info("根据多个tag推送消息到指定用户接口调用成功！");
    	}catch(Exception e){
    		resultObject.setResult(Constants.SYSTEM_ERROR,Constants.ERROR_MSG,"");
    		logger.info("根据tags推送消息异常！",e);
    	}
    	return resultObject;
    }
    
    /**
     * 推送消息到所有用户（广播）
     * @param requestParm
     * @return
     */
    @ResponseBody 
    @RequestMapping(value="/pushToAll",method = RequestMethod.POST)
    public ResultObject pushToAll(HKPushInfo requestParm) {
    	ResultObject resultObject = new ResultObject();
    	try{
    		pushMsgService.pushToAll(requestParm);
    		logger.info("推送消息到所有用户（广播）接口调用成功！");
    	}catch(Exception e){
    		resultObject.setResult(Constants.SYSTEM_ERROR,Constants.ERROR_MSG,"");
    		logger.info("广播异常！",e);
    	}
    	return resultObject;
    }
    

    
    /**
	 * 消息成功接收接口
	 * @param msgId
	 * @param sign 数字签名
	 */
    @ResponseBody 
	@RequestMapping(value="/msgReceived",method = RequestMethod.POST)
	public ResultObject msgReceived(HKPushInfo requestParm){
    	ResultObject resultObject = new ResultObject();
		try {
			requestParm.setMessengerStatus(Constants.MSG_STATUS_RECEIVED);
			pushMsgService.updateHkPushMemberMsgStatus(requestParm);
			logger.info("消息成功接收接口调用成功！");
		} catch (Exception e) {
			resultObject.setResult(Constants.SYSTEM_ERROR, Constants.ERROR_MSG, "");
			logger.error("消息成功接收接口调用异常！",e);
		}
		   	
		return resultObject;
		
	}
	
}