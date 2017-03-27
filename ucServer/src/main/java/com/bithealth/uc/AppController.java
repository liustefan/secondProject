package com.bithealth.uc;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.model.RegisterParam;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.ucCore.facade.enmu.ResultCode;
import com.bithealth.ucCore.facade.service.MergeService;
import com.bithealth.ucCore.facade.service.UCService;
import com.bithealth.ucCore.uc.model.AppServer;
import com.bithealth.ucCore.uc.model.MemberBasicInfo;
import com.bithealth.ucCore.uc.model.MergeInfo;
import com.bithealth.ucCore.uc.model.RegisterResult;
import com.bithealth.ucCore.uc.model.ReturnObject;
import com.bithealth.ucCore.uc.result.MergeResult;

@Controller
public class AppController extends BaseSpringController {
	@Resource
    private UCService ucService;
	
	@Resource
	private MergeService mergeService;
    
    private static Logger logger=Logger.getLogger(AppController.class);
	
	@RequestMapping(value = "/checkAccount" ,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String checkAccount(RegisterParam registerParam) {
		
		if(StringUtil.isEmpty(registerParam.getParams())) {
			return JSONObject.toJSONString(new ReturnObject(301, "输入为空"));
		}
		JSONObject obj = JSONObject.parseObject(registerParam.getParams());
		String account = obj.getString("account");
		if(StringUtil.isEmpty(account)) {
			return JSONObject.toJSONString(new ReturnObject(301, account + "账号输入为空"));
		}
		ReturnObject returnObject = new ReturnObject();
    	try {
    		AppServer appServer = ucService.checkAccount(account);
    		if(appServer != null) {
    			JSONObject result = new JSONObject();
    			result.put("serverID", appServer.getId());
    			result.put("url", appServer.getIpAddress());
    			return JSONObject.toJSONString(new ReturnObject(0, "账号存在", result));
    		}
		} catch (Exception e) {
			returnObject.setCode(201);
			logger.error("校验账号异常：" + e.getMessage());
			return JSONObject.toJSONString(new ReturnObject(201, "服务器内部异常"));
		}
        return JSONObject.toJSONString(new ReturnObject(101, "账号不存在"));
	}
	
	@RequestMapping(value = "/appMemberRegist" ,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String appMemberRegist(RegisterParam registerParam) {
		logger.info("APP注册请求参数："+registerParam.toString());
		ReturnObject returnObject = new ReturnObject();
		returnObject.setCode(305);
		returnObject.setMessage("请求参数为空");
		try {
    		List<MemberBasicInfo> lsit = JSONArray.parseArray(registerParam.getParams(), MemberBasicInfo.class);
    		if(lsit != null && registerParam.getServerID() != null){
        		List<RegisterResult> list = ucService.registAppMember(lsit,Integer.parseInt(registerParam.getServerID()));
        		returnObject.setContent(list);
        		returnObject.setCode(0);
        		returnObject.setMessage("");
    		}else{
    			returnObject.setMessage("请求参数为空");
    		}
    		logger.info("基本资料和账号注册，同步处理接口调用完成");
		} catch (Exception e) {
			returnObject.setCode(201);
			returnObject.setMessage("服务器内部异常"+e.getMessage());
			logger.error("基本资料和账号注册，同步处理异常"+e.getMessage());
		}
		return JSONObject.toJSONString(returnObject);
	}
	
	@ResponseBody
	@RequestMapping(value = "/checkMerge", produces = "text/html;charset=UTF-8")
	public String checkMerge(RegisterParam registerParam) {
		logger.info("APP合并资料校验请求参数："+registerParam.toString());
		ReturnObject returnObject = new ReturnObject();
		returnObject.setCode(305);
		returnObject.setMessage("请求参数为空");
		try {
    		MemberBasicInfo member = JSONObject.parseObject(registerParam.getParams(), MemberBasicInfo.class);
    		if(member != null) {
    			return JSONObject.toJSONString(mergeService.checkMerge(member.getMobile(), member.getIDCard(), member.getMemberName()));
    		}
    		returnObject.setCode(305);
			returnObject.setMessage("请求参数为空");
    		logger.info("合并资料校验接口调用完成");
		} catch (Exception e) {
			returnObject.setCode(201);
			returnObject.setMessage("服务器内部异常"+e.getMessage());
			logger.error("合并资料校验处理异常"+e.getMessage());
		}
		return JSONObject.toJSONString(returnObject);
	}
	
	@ResponseBody
	@RequestMapping(value = "/merge", produces = "text/html;charset=UTF-8")
	public String merge(RegisterParam registerParam) {
		logger.info("APP合并资料请求参数："+registerParam.toString());
		MergeResult returnObject = new MergeResult("", 305, "请求参数为空");
		try {
    		MergeInfo member = JSONObject.parseObject(registerParam.getParams(), MergeInfo.class);
    		if(member != null) {
    			member.getMemberTarget().setServerID(Integer.parseInt(registerParam.serverID));
    			MergeResult result = mergeService.merge(member.getSourceGuid(), member.getSourceSrvId(), member.getMemberTarget());
    			result.setSessionId(member.getSessionId());
    			return JSONObject.toJSONString(result);
    		}
    		returnObject.setCode(ResultCode.Parameter_Error.code);
			returnObject.setMsg(ResultCode.Parameter_Error.desc);
    		logger.info("合并资料接口调用完成");
		} catch (Exception e) {
			returnObject.setCode(ResultCode.Server_internal_Error.code);
			returnObject.setMsg("服务器内部异常"+e.getMessage());
			logger.error("合并资料处理异常"+e.getMessage());
		}
		return JSONObject.toJSONString(returnObject);
	}
	
	@ResponseBody
	@RequestMapping(value = "/changeTel", produces = "text/html;charset=UTF-8")
	public String changeTel(RegisterParam registerParam) {
		logger.info("APP修改认证手机请求参数："+registerParam.toString());
		ReturnObject returnObject = new ReturnObject();
		returnObject.setCode(305);
		returnObject.setMessage("请求参数为空");
		try {
			
    		MemberBasicInfo member = JSONObject.parseObject(registerParam.getParams(), MemberBasicInfo.class);
    		if(member != null && registerParam.getServerID() != null){
    			return JSONObject.toJSONString(ucService.changeTelByPwd(member.getMobile(), member.getMemberID(), member.getPwd()));
    		}else{
    			returnObject.setCode(305);
    			returnObject.setMessage("请求参数为空");
    		}
    		logger.info("修改认证手机处理接口调用完成");
		} catch (Exception e) {
			returnObject.setCode(201);
			returnObject.setMessage("服务器内部异常"+e.getMessage());
			logger.error("修改认证手机处理异常"+e.getMessage());
		}
		return JSONObject.toJSONString(returnObject);
	}
	
}
