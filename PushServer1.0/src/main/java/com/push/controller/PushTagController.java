package com.push.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.push.constants.Constants;
import com.push.model.HKPushInfo;
import com.push.model.HkPushMemberTag;
import com.push.result.ResultObject;
import com.push.service.PushTagService;


@Controller
public class PushTagController {

	private static Logger logger = Logger.getLogger(PushTagController.class); 
	
    @Autowired
    private PushTagService pushTagService;
    
    /**
	 * 新增tag群组接口
	 * @param tag tag群组标识
	 * @param memberIds 角色id （一个或多个，多个id中间用 ， 隔开）
	 * @param model tag对应的模块id
	 * @param sign 数字签名
	 */
    @ResponseBody 
	@RequestMapping(value="/addNewTag",method = RequestMethod.POST)
	public ResultObject addNewTag(HKPushInfo requestParm){
    	ResultObject resultObject = new ResultObject();
		try {
			List<HkPushMemberTag> list = pushTagService.convertHKPushInfo(requestParm);
			if(list == null || list.size() == 0){
				resultObject.setResult(Constants.SYSTEM_ERROR, Constants.ERROR_MSG, "");
				return resultObject;
			}
			pushTagService.saveHkPushMemberTag(list);
			logger.info("新增tag群组接口调用成功！");
		} catch (Exception e) {
			resultObject.setResult(Constants.SYSTEM_ERROR, Constants.ERROR_MSG, "");
			logger.error("新增tag群组接口调用异常！",e);
		}
		   	
		return resultObject;
		
	}
	
    /**
	 * tag更新接口
	 * @param tag tag群组标识
	 * @param memberIds 角色id （一个或多个，多个id中间用 ， 隔开）
	 * @param model tag对应的模块id
	 * @param type 操作类型，参数值：0：更新；1：增加更新：更新tag原有用户为新的用户   增加：在原有tag群组用户中添加新用户
	 * @param sign 数字签名
	 */
    @ResponseBody 
	@RequestMapping(value="/updateTag",method = RequestMethod.POST)
	public ResultObject updateTag(HKPushInfo requestParm){
		
    	ResultObject resultObject = new ResultObject();
		try {
			List<HkPushMemberTag> list = pushTagService.convertHKPushInfo(requestParm);
			if(list == null || list.size() == 0){
				resultObject.setResult(Constants.SYSTEM_ERROR, Constants.ERROR_MSG, "");
				return resultObject;
			}
			pushTagService.updateHkPushMemberTag(requestParm,list);
			logger.info("tag更新接口调用成功！");
		} catch (Exception e) {
			resultObject.setResult(Constants.SYSTEM_ERROR, Constants.ERROR_MSG, "");
			logger.error("tag更新接口调用异常！",e);
		}  	
    	
		return resultObject;
	}
    
    /**
	 * 删除tag接口
	 * @param tag tag群组标识
	 * @param model tag对应的模块id
	 * @param sign 数字签名
	 */
    @ResponseBody 
	@RequestMapping(value="/deleteTag",method = RequestMethod.POST)
	public ResultObject deleteTag(HKPushInfo requestParm){
    	ResultObject resultObject = new ResultObject();
		try {
			/* 与业务系统约定(model_tag)等于推送平台一个tag */
			requestParm.setTag(requestParm.getModel() + "_" + requestParm.getTag());
			pushTagService.deleteHkPushMemberTag(requestParm);
			logger.info("删除tag接口调用成功！");
		} catch (Exception e) {
			resultObject.setResult(Constants.SYSTEM_ERROR, Constants.ERROR_MSG, "");
			logger.error("删除tag接口调用异常！",e);
		}
		
		return resultObject;
		
	}
}