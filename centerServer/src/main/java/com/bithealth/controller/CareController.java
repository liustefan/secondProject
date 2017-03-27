package com.bithealth.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.centCore.care.constants.Constrants;
import com.bithealth.centCore.care.enmu.CareErrorCodeEnmu;
import com.bithealth.centCore.care.model.CareInfo;
import com.bithealth.centCore.care.model.FamilyNews;
import com.bithealth.centCore.care.model.KindlyReminder;
import com.bithealth.centCore.care.model.KindlyReminderResult;
import com.bithealth.centCore.care.service.FamilyNewsService;
import com.bithealth.centCore.dataSource.DataSourceSwitch;
import com.bithealth.centCore.facade.model.MsgCenter;
import com.bithealth.centCore.facade.model.RelateAcount;
import com.bithealth.centCore.facade.service.CareIFService;
import com.bithealth.centCore.msgCenterCore.model.MessageCenter;
import com.bithealth.centCore.msgCenterCore.service.MessageCenterFacadeService;
import com.bithealth.model.KindlyReminderRequest;
import com.bithealth.model.MsgCenterReq;
import com.bithealth.model.ResponseObject;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;


/**
 * 类名称: CareController  
 * 功能描述:关注模块控制器
 * 日期: 2016年8月30日 上午9:22:23 
 * 
 * @author 谢美团
 * @version  
 */
@Controller
@RequestMapping(value = "/care")
public class CareController extends BaseSpringController{
	
	
	@Resource
	CareIFService careIFService;

	
	
    /**
     * @Title:getMyCareList 
     * @Description:获取我关注的人列表（亲友关怀）
     * @author 谢美团
     * @param accessParam
     * @return 
     * @throws
     * @retrun String
     * @throws IOException 
     */ 
    @RequestMapping(value = "/getMyCareList")
    public void getMyCareList(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		JSONObject appUserObj = JSONObject.parseObject(request.getAttribute("appUserStr").toString());
    		boolean isHttpsRequest = false;
    		if(appUserObj.get("isHttpsRequest") != null && Constrants.IS_HTTPS_REQUEST.equals(appUserObj.get("isHttpsRequest"))){
    			isHttpsRequest = true;
    		}
    		JSONObject paramObj = JSONObject.parseObject(request.getAttribute("otherParamStr").toString());
    		List<CareInfo> careList = careIFService.selectMyCareList(paramObj.getString("memberGUID"), paramObj.getIntValue("isGetNews"),isHttpsRequest);
    		returnObject.setData(careList);
    		logger.info("获取我关注的人列表（亲友关怀）完成");
		} catch (Exception e) {
			returnObject.setStatusCode(1);
			returnObject.setMessage("服务器内部异常");
			logger.error("获取我关注的人列表（亲友关怀）异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
	
	
    /**
     * @Title:getCareMeList 
     * @Description:获取关注我的人列表
     * @author 谢美团
     * @param accessParam
     * @return 
     * @throws
     * @retrun String
     * @throws IOException 
     */ 
    @RequestMapping(value = "/getCareMeList")
    public void getCareMeList(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		JSONObject appUserObj = JSONObject.parseObject(request.getAttribute("appUserStr").toString());
    		boolean isHttpsRequest = false;
    		if(appUserObj.get("isHttpsRequest") != null && Constrants.IS_HTTPS_REQUEST.equals(appUserObj.get("isHttpsRequest"))){
    			isHttpsRequest = true;
    		}
    		JSONObject paramObj = JSONObject.parseObject(request.getAttribute("otherParamStr").toString());
    		List<CareInfo> careList = careIFService.selectCareMeList(paramObj.getString("memberGUID"),isHttpsRequest);
    		returnObject.setData(careList);
    		logger.info("获取关注我的人列表完成");
		} catch (Exception e) {
			returnObject.setStatusCode(1);;
			returnObject.setMessage("服务器内部异常");
			logger.error("获取关注我的人列表异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
    
    
    /**
     * @Title:getMember 
     * @Description:通过条件精确查找会员
     * @author 谢美团
     * @param accessParam
     * @return 
     * @throws
     * @retrun String
     * @throws IOException 
     */ 
    @RequestMapping(value = "/getMember")
    
    public void getMember(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		JSONObject appUserObj = JSONObject.parseObject(request.getAttribute("appUserStr").toString());
    		boolean isHttpsRequest = false;
    		if(appUserObj.get("isHttpsRequest") != null && Constrants.IS_HTTPS_REQUEST.equals(appUserObj.get("isHttpsRequest"))){
    			isHttpsRequest = true;
    		}
    		JSONObject paramObj = JSONObject.parseObject(request.getAttribute("otherParamStr").toString());
    		List<CareInfo> careList = careIFService.selectMemberByParams(paramObj.getString("searchParam"), paramObj.getString("memberGUID"),isHttpsRequest);
    		returnObject.setData(careList);
    		logger.info("通过条件精确查找会员完成");
		} catch (Exception e) {
			returnObject.setStatusCode(1);;
			returnObject.setMessage("服务器内部异常");
			logger.error("通过条件精确查找会员异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
	
	
    /**
     * @Title:addCare 
     * @Description:添加关注
     * @author 谢美团
     * @param accessParam
     * @return 
     * @throws
     * @retrun String
     * @throws IOException 
     */ 
    @RequestMapping(value = "/addCare")
    
    public void addCare(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		CareInfo careInfo = JSONObject.parseObject(request.getAttribute("otherParamStr").toString(),CareInfo.class);
    		careIFService.addCare_trans(careInfo);
    		logger.info("添加关注完成");
		} catch (Exception e) {
			returnObject.setStatusCode(1);;
			returnObject.setMessage("服务器内部异常");
			logger.error("添加关注异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
    
    
    /**
     * @Title:relateAcount 
     * @Description:通过关联账号来关注亲友
     * @author 谢美团
     * @param accessParam
     * @return 
     * @throws
     * @retrun String
     * @throws IOException 
     */ 
    @RequestMapping(value = "/relateAcount")
    
    public void relateAcount(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		RelateAcount relateAcount = JSONObject.parseObject(request.getAttribute("otherParamStr").toString(),RelateAcount.class);
    		int rows = careIFService.relateAcount_trans(relateAcount);
    		if(rows == CareErrorCodeEnmu.MEMBER_NOT_EXIST.getValue()){
    			returnObject.setStatusCode(CareErrorCodeEnmu.MEMBER_NOT_EXIST.getValue());
    			returnObject.setMessage("账户或密码输入错误。");
    			logger.info("账户或密码错误，无法完成账号关联");
    		}else if (rows == CareErrorCodeEnmu.CARE_ONESELF_ONT_ALLOW.getValue()){
    			returnObject.setStatusCode(CareErrorCodeEnmu.CARE_ONESELF_ONT_ALLOW.getValue());
    			returnObject.setMessage(CareErrorCodeEnmu.CARE_ONESELF_ONT_ALLOW.getDesc());
    			logger.info(CareErrorCodeEnmu.CARE_ONESELF_ONT_ALLOW.getDesc());
    		}else if(rows == CareErrorCodeEnmu.ALREADY_FOLLOW.getValue()){
    			returnObject.setStatusCode(CareErrorCodeEnmu.ALREADY_FOLLOW.getValue());
    			returnObject.setMessage(CareErrorCodeEnmu.ALREADY_FOLLOW.getDesc());
    			logger.info(CareErrorCodeEnmu.ALREADY_FOLLOW.getDesc());
    		}
		} catch (Exception e) {
			returnObject.setStatusCode(1);;
			returnObject.setMessage("服务器内部异常");
			logger.error("通过关联账号来关注亲友异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
    
	
    /**
     * @Title:updateCare 
     * @Description:修改 关注信息
     * @author 谢美团
     * @param accessParam
     * @return 
     * @throws
     * @retrun String
     * @throws IOException 
     */ 
    @RequestMapping(value = "/updateCare")
    public void updateCare(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		CareInfo careInfo = JSONObject.parseObject(request.getAttribute("otherParamStr").toString(),CareInfo.class);
    		careIFService.updateCare(careInfo);
    		logger.info("修改 关注信息完成");
		} catch (Exception e) {
			returnObject.setStatusCode(1);;
			returnObject.setMessage("服务器内部异常");
			logger.error("修改 关注信息异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
	
	
    /**
     * @Title:getMyCareMessage 
     * @Description:获取我发送的温馨提示列表
     * @author 谢美团
     * @param accessParam
     * @return 
     * @throws
     * @retrun String
     * @throws IOException 
     */ 
    @RequestMapping(value = "/getMyCareMessage")
    
    public void getMyCareMessage(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		KindlyReminder kindlyReminder = JSONObject.parseObject(request.getAttribute("otherParamStr").toString(),KindlyReminder.class);
    		Page<KindlyReminder> page = new Page<KindlyReminder>();
    		page.setPageSize(kindlyReminder.getPageSize());
    		page.setPageNo(kindlyReminder.getPageNow());
    		List<KindlyReminder>  list = careIFService.getMyCareMessage(kindlyReminder, page);
    		returnObject.setData(list);
    		logger.info("获取我发送的温馨提示列表接口调用完成");
		} catch (Exception e) {
			returnObject.setStatusCode(1);;
			returnObject.setMessage("服务器内部异常");
			logger.error("获取我发送的温馨提示列表接口调用异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
    
    /**
     * @Title:sendKindlyReminder 
     * @Description:发送温馨提示消息
     * @author 谢美团
     * @param accessParam
     * @return 
     * @throws
     * @retrun String
     * @throws IOException 
     */ 
    @RequestMapping(value = "/sendKindlyReminder")
    public void sendKindlyReminder(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		KindlyReminder kindlyReminder = JSONObject.parseObject(request.getAttribute("otherParamStr").toString(),KindlyReminder.class);
    		kindlyReminder.setSender(kindlyReminder.getSenderGUID());
    		kindlyReminder.setReceiver(kindlyReminder.getReceiverGUID());
    		careIFService.sendKindlyReminder_trans(kindlyReminder);
    		logger.info("发送温馨提示消息完成");
		} catch (Exception e) {
			e.printStackTrace();
			returnObject.setStatusCode(1);;
			returnObject.setMessage("服务器内部异常");
			logger.error("发送温馨提示消息异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
    
    
    /**
     * @Title:getMyCareMessage 
     * @Description:获取我的温馨提示(医生端调用)
     * @author 谢美团
     * @param accessParam
     * @return 
     * @throws
     * @retrun String
     * @throws IOException 
     */ 
    @RequestMapping(value = "/getMyCareMessageForWebClient")
    
    public void getMyCareMessageForWebClient(KindlyReminder kindlyReminder,Page<KindlyReminder> page,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		careIFService.getMyCareMessage(kindlyReminder, page);
    		returnObject.setData(page);
    		logger.info("获取我的温馨提示接口调用完成");
		} catch (Exception e) {
			returnObject.setStatusCode(1);;
			returnObject.setMessage("服务器内部异常");
			logger.error("获取我的温馨提示接口调用异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
    
    /**
     * @Title:sendKindlyReminder 
     * @Description:根据关注设置的权限发送提示信息给关注我的人或者发送咨询消息给会员群体(医生端调用发送亲友动态)
     * @author 谢美团
     * @param accessParam
     * @return 
     * @throws
     * @retrun String
     * @throws IOException 
     */ 
    @RequestMapping(value = "/sendMsgToCareMeMemberForWeb")
    public void sendMsgToCareMeMember(MsgCenterReq msgCenterReq,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		MsgCenter msgCenter = new MsgCenter();
    		String scheduletime = msgCenterReq.getScheduletime();
    		msgCenterReq.setScheduletime(null);
    		BeanUtils.copyProperties(msgCenter, msgCenterReq);
    		if(scheduletime != null){
    			msgCenter.setScheduletime(TimeUtil.parseDatetime2(scheduletime));
    		}
    		careIFService.sendMsgToCareMeMember(msgCenter);
    		logger.info("发送温馨提示消息完成");
		} catch (Exception e) {
			returnObject.setStatusCode(1);;
			returnObject.setMessage("服务器内部异常");
			logger.error("发送温馨提示消息异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
    
    
    
    /**
     * @Title:sendKindlyReminderForWebClient 
     * @Description:医生端发送温馨提示给会员
     * @author 谢美团
     * @param kindlyReminderReq
     * @param response
     * @throws IOException 
     * @throws
     * @retrun void
     */ 
    @RequestMapping(value = "/sendKindlyReminderForWebClient")
    public void sendKindlyReminderForWebClient(KindlyReminderRequest  kindlyReminderReq,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		KindlyReminder kindlyReminder = new KindlyReminder();
    		String scheduleTime = kindlyReminderReq.getScheduleTime();
    		kindlyReminderReq.setScheduleTime(null);
    		BeanUtils.copyProperties(kindlyReminder, kindlyReminderReq);
    		if(scheduleTime != null){
    			kindlyReminder.setScheduleTime(TimeUtil.parseDatetime2(scheduleTime));
    		}
    		kindlyReminder.setSender(kindlyReminder.getSenderGUID());
    		if(kindlyReminderReq.getReceiverGUIDList() != null){
    			List<String> lsit = JSONArray.parseArray(kindlyReminderReq.getReceiverGUIDList(),String.class);
        		for(String receiverGUID:lsit){
        			kindlyReminder.setReceiver(receiverGUID);
        			kindlyReminder.setCreateTime(new Date());
        			kindlyReminder.setLogID(null);
        			careIFService.sendKindlyReminder_trans(kindlyReminder);
        		}
    		}
    		logger.info("医生端调用发送温馨提示消息完成");
		} catch (Exception e) {
			returnObject.setStatusCode(1);
			returnObject.setMessage("服务器内部异常");
			logger.error("医生端调用发送温馨提示消息接口异常"+e.getMessage());
			e.printStackTrace();
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
    
    
    /**
     * @Title:getMemberByGuid 
     * @Description:根据GUID回去该会员的服务地址
     * @author 谢美团
     * @param accessParam
     * @return 
     * @throws
     * @retrun String
     * @throws IOException 
     */ 
    @RequestMapping(value = "/getMemberByGuid")
    public void getMemberByGuid(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		JSONObject appUserObj = JSONObject.parseObject(request.getAttribute("appUserStr").toString());
    		boolean isHttpsRequest = false;
    		if(appUserObj.get("isHttpsRequest") != null && Constrants.IS_HTTPS_REQUEST.equals(appUserObj.get("isHttpsRequest"))){
    			isHttpsRequest = true;
    		}
    		JSONObject paramObj = JSONObject.parseObject(request.getAttribute("otherParamStr").toString());
    		CareInfo care = careIFService.getmemberByGUID(paramObj.getString("memberGUID"),isHttpsRequest);
    		if( care != null ){
    			returnObject.setData(care);
    		}else{
    			returnObject.setStatusCode(2);
    			returnObject.setMessage("无数据");
    		}
    		logger.info("根据GUID回去该会员的服务地址完成");
		} catch (Exception e) {
			returnObject.setStatusCode(1);;
			returnObject.setMessage("服务器内部异常");
			logger.error("根据GUID回去该会员的服务地址异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
    
    
    @RequestMapping(value = "/deleteKindlyReminderForWebClient")
    public void deleteKindlyReminderForWebClient(String logIDList,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		List<Integer> lsit = JSONArray.parseArray(logIDList, Integer.class);
    		careIFService.batchDeleteKindlyReminder_trans(lsit);
    		logger.info("医生端删除温馨提示接口调用成功。");
		} catch (Exception e) {
			returnObject.setStatusCode(1);;
			returnObject.setMessage("服务器内部异常");
			logger.error("医生端删除温馨提示接口异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
    
    /**
     * @Title:getCareMemberNews 
     * @Description:获取我的亲友动态
     * @author 谢美团
     * @param request
     * @param response
     * @throws IOException 
     * @throws
     * @retrun void
     */ 
    @RequestMapping(value = "/getCareMemberNews")
    public void getCareMemberNews(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		JSONObject appUserObj = JSONObject.parseObject(request.getAttribute("appUserStr").toString());
    		boolean isHttpsRequest = false;
    		if(appUserObj.get("isHttpsRequest") != null && Constrants.IS_HTTPS_REQUEST.equals(appUserObj.get("isHttpsRequest"))){
    			isHttpsRequest = true;
    		}
    		JSONObject paramObj = JSONObject.parseObject(request.getAttribute("otherParamStr").toString());
    		Page<FamilyNews> page = new Page<FamilyNews>();
    		page.setPageNo(paramObj.getIntValue("pageNow"));
    		page.setPageSize(paramObj.getIntValue("pageSize"));
    		List<FamilyNews> list = careIFService.getMyCareMemberNews(page, paramObj.getString("memberGUID"),isHttpsRequest);
    		returnObject.setData(list);
    		logger.info("获取亲友最新动态列表接口调用成功。");
		} catch (Exception e) {
			returnObject.setStatusCode(1);;
			returnObject.setMessage("服务器内部异常");
			logger.error("获取亲友最新动态列表接口调用异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
    
    
    /**
     * @Title:getMyKindlyReminder 
     * @Description:获取发送给我的温馨提示
     * @author 谢美团
     * @param request
     * @param response
     * @throws IOException 
     * @throws
     * @retrun void
     */ 
    @RequestMapping(value = "/getMyKindlyReminder")
    public void getMyKindlyReminder(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
    	try {
    		JSONObject paramObj = JSONObject.parseObject(request.getAttribute("otherParamStr").toString());
    		Page<KindlyReminder> page = new Page<KindlyReminder>();
    		page.setPageNo(paramObj.getIntValue("pageNow")==0?1:paramObj.getIntValue("pageNow"));
    		page.setPageSize(paramObj.getIntValue("pageSize")==0?10:paramObj.getIntValue("pageSize"));
    		List<KindlyReminderResult> list = careIFService.toGetMyKindlyReminder_trans(page, paramObj.getString("memberGUID"));
    		returnObject.setData(list);
    		logger.info("获取发送给我的温馨提示接口调用成功。");
		} catch (Exception e) {
			returnObject.setStatusCode(1);;
			returnObject.setMessage("服务器内部异常");
			logger.error("获取发送给我的温馨提示接口调用异常"+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
    
    @RequestMapping(value = "/MergeCareData")
    public void MergeCareData(String sourceGUID,String targetGUID,HttpServletResponse response) throws IOException {
    	ResponseObject returnObject = new ResponseObject();
       	try {
       		careIFService.MergeCareData(sourceGUID, targetGUID);
    		logger.info("合并关注数据成功，sourceGUID："+sourceGUID+",targetGUID"+targetGUID);
		} catch (Exception e) {
			returnObject.setStatusCode(1);;
			returnObject.setMessage("服务器内部异常");
			logger.error("合并关注数据异常，sourceGUID："+sourceGUID+",targetGUID"+targetGUID+e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(returnObject));
    }
    
    
    

}
