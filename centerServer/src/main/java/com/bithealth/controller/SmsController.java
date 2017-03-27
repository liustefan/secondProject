package com.bithealth.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.bithealth.centCore.facade.service.SmsIFService;
import com.bithealth.centCore.sms.enmu.SmsSendStatusEnmu;
import com.bithealth.centCore.sms.model.SmsConfig;
import com.bithealth.centCore.sms.model.SmsSearchParams;
import com.bithealth.centCore.sms.model.SmsSendDetail;
import com.bithealth.centCore.sms.model.SmsSendDetailExample;
import com.bithealth.centCore.sms.model.SmsSendParams;
import com.bithealth.centCore.sms.model.SmsStatistic;
import com.bithealth.centCore.sms.service.SmsConfigService;
import com.bithealth.centCore.sms.service.SmsSendDetailService;
import com.bithealth.model.ResponseObject;
import com.bithealth.sdk.web.controller.BaseSpringController;



/**
 * 类名称: SmsController  
 * 功能描述: 短信业务控制器
 * 日期: 2016年11月28日 下午3:28:15 
 * 
 * @author 谢美团
 * @version  
 */
@Controller
@RequestMapping(value = "/sms")
public class SmsController extends BaseSpringController{
	
	
	@Resource
	SmsConfigService smsConfigService;
	@Resource
	SmsIFService smsIFService;
	@Resource
	SmsSendDetailService smsSendDetailService;

    /**
     * @Title:saveSmsConfig 
     * @Description:新增或更新组织短信配置
     * @author 谢美团
     * @param SmsConfig
     * @param response
     * @throws IOException 
     * @throws
     * @retrun void
     */ 
    @RequestMapping(value = "/saveSmsConfig")
    public void saveSmsConfig(SmsConfig smsConfig,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		smsIFService.saveSmsConfig_trans(smsConfig);
    		returnObject.setMessage("保存组织短信配置成功。");
    		logger.info("保存组织短信配置成功");
		} catch (Exception e) {
			returnObject.setStatusCode(201);
			returnObject.setMessage("服务器内部异常");
			logger.error("保存组织短信配置成功异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
    
    /**
     * @Title:getSmsConfig 
     * @Description:获取组织短息配置
     * @author 谢美团
     * @param smsConfig
     * @param response
     * @throws IOException 
     * @throws
     * @retrun void
     */ 
    @RequestMapping(value = "/getSmsConfig")
    public void getSmsConfig(SmsConfig smsConfig,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		SmsConfig  config = smsIFService.getSmsConfigByOrgid(smsConfig);
    		returnObject.setData(config);
    		returnObject.setMessage("获取组织短信配置成功。");
    		logger.info("获取组织短信配置成功");
		} catch (Exception e) {
			returnObject.setStatusCode(201);
			returnObject.setMessage("服务器内部异常");
			logger.error("获取组织短信配置成功异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
	
    /**
     * @Title:getSmsList 
     * @Description:根据参数查询短信发送记录
     * @author 谢美团
     * @param smsParams
     * @param response
     * @throws IOException 
     * @throws
     * @retrun void
     */ 
    @RequestMapping(value = "/getSmsList")
    public void getSmsList(SmsSearchParams smsParams,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		returnObject.setData(smsIFService.getSmsListByParams(smsParams));
    		returnObject.setMessage("根据参数查询短信发送记录成功。");
    		logger.info("根据参数查询短信发送记录成功");
		} catch (Exception e) {
			returnObject.setStatusCode(201);
			returnObject.setMessage("服务器内部异常");
			logger.error("根据参数查询短信发送记录异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
	

    
    
    
    
    /**
     * @Title:smsSend 
     * @Description:发送短信
     * @author 谢美团
     * @param smsParams
     * @param response
     * @throws IOException 
     * @throws
     * @retrun void
     */ 
    @RequestMapping(value = "/smsSend")
    public void smsSend(SmsSendParams smsParams,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		SmsConfig smsConfig  = smsIFService.isnertSms(smsParams);
    		if(smsConfig != null){
    			smsIFService.smsSend(smsParams,smsConfig);
    			returnObject.setMessage("发送短信接口调用成功");
    			logger.info("发送短信接口调用成功");
    		}else{
    			returnObject.setStatusCode(305);
    			returnObject.setMessage("必要参数为空，发送失败");
    		}
		} catch (Exception e) {
			returnObject.setStatusCode(201);
			returnObject.setMessage("服务器内部异常");
			logger.error("根据参数查询短信发送记录异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
    
    /**
     * @Title:getSmsStatistic 
     * @Description:获取短信发送统计数据
     * @author 谢美团
     * @param smsParams
     * @param response
     * @throws IOException 
     * @throws
     * @retrun void
     */ 
    @RequestMapping(value = "/getSmsStatistic")
    public void getSmsStatistic(SmsSearchParams smsParams,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		List<SmsStatistic> list= smsIFService.selectSmsStatistic(smsParams);
    		returnObject.setData(list);
    		returnObject.setMessage("获取短信发送统计数据成功");
    		logger.info("获取短信发送统计数据成功");
		}catch (Exception e) {
			returnObject.setStatusCode(201);
			returnObject.setMessage("服务器内部异常");
			logger.error("获取短信统计数据异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
    
    @RequestMapping(value = "/deleteSmsConfig")
    public void deleteSmsConfig(SmsConfig smsConfig,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		smsConfigService.delete(smsConfig.getSCfgID());
    		returnObject.setMessage("删除组织短信配置成功。");
    		logger.info("删除组织短信配置成功");
		} catch (Exception e) {
			returnObject.setStatusCode(201);
			returnObject.setMessage("删除组织短信配置成功异常");
			logger.error("删除组织短信配置成功异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
 

}
