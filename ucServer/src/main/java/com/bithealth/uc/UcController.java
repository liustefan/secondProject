package com.bithealth.uc;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.model.RegisterParam;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.ucCore.facade.enmu.ResultCode;
import com.bithealth.ucCore.facade.service.UCService;
import com.bithealth.ucCore.uc.model.AppServer;
import com.bithealth.ucCore.uc.model.MemberBasicInfo;
import com.bithealth.ucCore.uc.model.RegisterResult;
import com.bithealth.ucCore.uc.model.ReturnObject;


@Controller
public class UcController extends BaseSpringController {

    @Resource
    private UCService ucService;
    
    private static Logger logger=Logger.getLogger(UcController.class);

   
  
    /**
     * @Title:memberRegisterSync 
     * @Description:本资料和账号注册，同步处理
     * @author 谢美团
     * @param registerParam
     * @return 
     * @throws
     * @retrun ReturnObject
     */ 
    @RequestMapping(value = "/memberRegisterSync" ,produces = "text/html;charset=UTF-8")
    @ResponseBody 
    public String memberRegisterSync(RegisterParam registerParam) {
    	logger.info("同步注册请求参数："+registerParam.toString());
    	ReturnObject returnObject = new ReturnObject();
    	try {
    		List<MemberBasicInfo> lsit = JSONArray.parseArray(registerParam.getParams(), MemberBasicInfo.class);
    		if(lsit != null && registerParam.getServerID() != null){
        		List<RegisterResult> list = ucService.memberRegisterSync(lsit,Integer.parseInt(registerParam.getServerID()));
        		returnObject.setContent(list);
    		}else{
    			returnObject.setCode(305);
    			returnObject.setMessage("请求参数为空");
    		}
    		logger.info("基本资料和账号注册，同步处理接口调用完成");
		} catch (Exception e) {
			returnObject.setCode(201);
			returnObject.setMessage("服务器内部异常"+e.getMessage());
			logger.error("基本资料和账号注册，同步处理异常"+e.getMessage());
		}
        return JSON.toJSONString(returnObject);
    }
   
    /**
     * @Title:memberRegisterAsync 
     * @Description:本资料和账号注册，异步处理
     * @author 谢美团
     * @param registerParam
     * @return 
     * @throws
     * @retrun ReturnObject
     */ 
    @RequestMapping(value = "/memberRegisterAsync")
    @ResponseBody 
    public ReturnObject memberRegisterAsync(RegisterParam registerParam) {
    	logger.info("异步注册请求参数："+registerParam.toString());
    	ReturnObject returnObject = new ReturnObject();
    	try {
    		List<MemberBasicInfo> lsit = JSONArray.parseArray(registerParam.getParams(), MemberBasicInfo.class);
     		if(lsit != null && registerParam.getServerID() != null){
     			ucService.memberRegisterAsyn(lsit,Integer.parseInt(registerParam.getServerID()));
    		}else{
    			returnObject.setCode(305);
    			returnObject.setMessage("请求参数为空");
    		}
    		 logger.info("基本资料和账号注册，异步处理接口调用完成");
		} catch (Exception e) {
			returnObject.setCode(201);
			returnObject.setMessage("服务器内部异常");
			logger.error("基本资料和账号注册，异步处理异常");
		}
        return returnObject;
    }

    
    /**
     * @Title:getRegisterResult 
     * @Description:获取基本资料和账号注册结果
     * @author 谢美团
     * @param registerParam
     * @return 
     * @throws
     * @retrun ReturnObject
     */ 
    @RequestMapping(value = "/getRegisterResult" ,produces = "text/html;charset=UTF-8")
    @ResponseBody 
    public String  getRegisterResult(RegisterParam registerParam) {
    	ReturnObject returnObject = new ReturnObject();
    	try {
    		List<String> guidList = JSONArray.parseArray(registerParam.getParams(), String.class);
    		List<RegisterResult> list = ucService.getRegisterResult(guidList);
    		returnObject.setContent(list);
    		logger.info("获取基本资料和账号注册结果接口调用完成");
		} catch (Exception e) {
			returnObject.setCode(201);
			returnObject.setMessage("服务器内部异常");
			logger.error("获取基本资料和账号注册结果异常");
		}
        return JSON.toJSONString(returnObject);
    }
    
    
    /**
     * @Title:getAddress 
     * @Description:据账号获取该账号所属的的确服务地址
     * @author 谢美团
     * @param account
     * @return 
     * @throws
     * @retrun ReturnObject
     */ 
    @RequestMapping(value = "/getAddress")
    @ResponseBody 
    public ReturnObject getAddress(String account, String isHttpsRequest) {
    	ReturnObject returnObject = new ReturnObject();
    	try {
    		boolean isHttp = StringUtil.isNotEmpty(isHttpsRequest) && "1".equals(isHttpsRequest);
    		returnObject = ucService.getAddressByAccount(account, isHttp);
    		logger.info("据账号获取该账号所属的的确服务地址接口调用完成");
		} catch (Exception e) {
			returnObject.setCode(201);
			returnObject.setMessage("服务器内部异常");
			logger.error("据账号获取该账号所属的的确服务地址异常");
		}
        return returnObject;
    }
    
    /**
     * @Title:getAddressByMemberID 
     * @Description:根据会员ID获取该会员所属的的确的服务地址 
     * @author 谢美团
     * @param memberID
     * @return 
     * @throws
     * @retrun ReturnObject
     */ 
    @RequestMapping(value = "/getAddressByMemberID",produces = "text/html;charset=UTF-8")
    @ResponseBody 
    public String getAddressByMemberID(RegisterParam registerParam) {
    	ReturnObject returnObject = new ReturnObject();
    	try {
    		List<String> memberIDList = JSONArray.parseArray(registerParam.getParams(), String.class);
    		returnObject = ucService.getAddressByMemberIDs(memberIDList);
    		logger.info("根据会员ID获取该会员所属的的确的服务地址接口调用完成");
		} catch (Exception e) {
			returnObject.setCode(201);
			returnObject.setMessage("服务器内部异常");
			logger.error("根据会员ID获取该会员所属的的确的服务地址异常");
		}
        return JSON.toJSONString(returnObject);
    }
    
    
    /**
     * @Title:memberDelete 
     * @Description:删除会员基本资料和账号
     * @author 谢美团
     * @param registerParam
     * @return 
     * @throws
     * @retrun ReturnObject
     */ 
    @RequestMapping(value = "/memberDelete")
    @ResponseBody 
    public ReturnObject memberDelete(RegisterParam registerParam) {
    	ReturnObject returnObject = new ReturnObject();
    	try {
    		List<String> memberIdList = JSONArray.parseArray(registerParam.getParams(), String.class);
    		if(memberIdList != null && registerParam.getServerID() != null){
        		List<RegisterResult> list = ucService.memberDelete(memberIdList,Integer.parseInt(registerParam.getServerID()));
        		returnObject.setContent(list);
    		}else{
    			returnObject.setCode(305);
    			returnObject.setMessage("请求参数为空");
    		}
    		logger.info("删除会员基本资料和账号接口调用完成");
		} catch (Exception e) {
			returnObject.setCode(201);
			returnObject.setMessage("服务器内部异常");
			logger.error("删除会员基本资料和账号异常");
		}
        return returnObject;
    }
    
    /**
     * @Title:getMemberBySearchParam 
     * @Description:根据参数查询会员
     * @author 谢美团
     * @param registerParam
     * @return 
     * @throws
     * @retrun ReturnObject
     */ 
    @RequestMapping(value = "/getMemberBySearchParam" ,produces = "text/html;charset=UTF-8")
    @ResponseBody 
    public String  getMemberBySearchParam(RegisterParam registerParam) {
    	ReturnObject returnObject = new ReturnObject();
    	try {
    		JSONObject jsonObj = JSONObject.parseObject(registerParam.getParams(), JSONObject.class);
    		returnObject = ucService.getMemberBySearchParam(jsonObj.getString("searchParam"));
    		logger.info("根据参数查询会员接口调用完成");
		} catch (Exception e) {
			returnObject.setCode(201);
			returnObject.setMessage("服务器内部异常");
			logger.error("根据参数查询会员异常");
		}
        return JSONObject.toJSONString(returnObject);
    }
    
    
    /**
     * @Title:pwdModify 
     * @Description:修改密码，支持批量
     * @author 谢美团
     * @param registerParam
     * @return 
     * @throws
     * @retrun ReturnObject
     */ 
    @RequestMapping(value = "/pwdModify")
    @ResponseBody 
    public ReturnObject pwdModify(RegisterParam registerParam) {
    	ReturnObject returnObject = new ReturnObject();
    	try {
    		List<JSONObject> objList  = JSONArray.parseArray(registerParam.getParams(), JSONObject.class);
    		List<JSONObject> resultObjList = ucService.updatePwd(objList);
    		returnObject.setContent(resultObjList);
    		logger.info("修改密码接口调用完成");
		} catch (Exception e) {
			returnObject.setCode(201);
			returnObject.setMessage("服务器内部异常");
			logger.error("修改密码异常");
		}
        return returnObject;
    }
    
    
    /**
     * @Title:getMemberByAccountAndPwd 
     * @Description:根据账号和密码获取会员的基本信息
     * @author 谢美团
     * @param registerParam
     * @return 
     * @throws
     * @retrun ReturnObject
     */ 
    @RequestMapping(value = "/getMemberByAccountAndPwd", produces = "text/html;charset=UTF-8")
    @ResponseBody 
    public String getMemberByAccountAndPwd(RegisterParam registerParam) {
    	ReturnObject returnObject = new ReturnObject();
    	try {
    		JSONObject paramObj  = JSONObject.parseObject(registerParam.getParams(), JSONObject.class);
    		returnObject = ucService.getMemberByAccountAndPwd(paramObj.getString("account"), paramObj.getString("pwd"));
    		logger.info("修改密码接口调用完成");
		} catch (Exception e) {
			returnObject.setCode(201);
			returnObject.setMessage("服务器内部异常");
			logger.error("修改密码异常");
		}
        return  JSONObject.toJSONString(returnObject);
    }
    
    @RequestMapping(value = "/getMembers",produces = "text/html;charset=UTF-8")
    @ResponseBody 
    public String getMembers(RegisterParam registerParam) {
    	MemberBasicInfo paramObj  = JSONObject.parseObject(registerParam.getParams(), MemberBasicInfo.class);
    	if(paramObj == null) {
    		return "";
    	}
    	String memberName = paramObj.getMemberName();
    	String idcard = paramObj.getIDCard();
    	String tel = paramObj.getMobile();
    	if(StringUtil.isEmpty(memberName) && StringUtil.isEmpty(idcard) && StringUtil.isEmpty(tel)) {
    		return "";
    	}
    	return JSONArray.toJSONString(ucService.selectMemberByDetail(memberName, idcard, tel));
    }
    
    @ResponseBody
    @RequestMapping(value = "/getAppServer", produces = "text/html;charset=UTF-8")
    public String getAppServer(RegisterParam registerParam) {
    	ReturnObject returnObject = null;
    	JSONObject paramObj  = JSONObject.parseObject(registerParam.getParams(), JSONObject.class);
    	if(paramObj == null) {
    		returnObject = new ReturnObject(ResultCode.Parameter_Error.code, "serverID为空");
    	} else {
    		try{
    			List<AppServer> servers = ucService.getAppServer(paramObj.getString("serverIds"));
        		if(null == servers || servers.size() == 0) {
        			returnObject = new ReturnObject(ResultCode.User_Unknow.code, "ServerID：" + paramObj.getString("serverIds") + "不存在");
        		} else {
        			List<JSONObject> list = new ArrayList<JSONObject>();
        			for(AppServer app : servers) {
        				JSONObject obj = new JSONObject();
        				obj.put("serverId", app.getId());
        				obj.put("url", app.getIpAddress());
        				list.add(obj);
        			}
        			returnObject = new ReturnObject(0, "", list);
        		}
    		} catch(Exception e) {
    			returnObject = new ReturnObject(ResultCode.Parameter_Error.code, "ServerId参数格式错误：" + e.getLocalizedMessage());
    		}
    	}
    	
    	return JSONObject.toJSONString(returnObject);
    }
}
