//package com.bithealth.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.bithealth.careCore.care.model.CareInfo;
//import com.bithealth.careCore.care.model.KindlyReminder;
//import com.bithealth.careCore.facade.model.Care;
//import com.bithealth.careCore.facade.model.RelateAcount;
//import com.bithealth.careCore.facade.service.CareIFService;
//import com.bithealth.model.ReturnObject;
//import com.bithealth.sdk.common.utils.TimeUtil;
//import com.bithealth.sdk.core.feature.orm.mybatis.Page;
//import com.bithealth.sdk.web.controller.BaseSpringController;
//
//
///**
// * 类名称: CareController  
// * 功能描述:关注模块控制器
// * 日期: 2016年8月30日 上午9:22:23 
// * 
// * @author 谢美团
// * @version  
// */
//@Controller
//@RequestMapping(value = "/care")
//public class CareController extends BaseSpringController{
//	
//	
//	@Resource
//	CareIFService careIFService;
//	
//	
//    /**
//     * @Title:getMyCareList 
//     * @Description:获取我关注的人列表（亲友关怀）
//     * @author 谢美团
//     * @param accessParam
//     * @return 
//     * @throws
//     * @retrun String
//     * @throws IOException 
//     */ 
//    @RequestMapping(value = "/getMyCareList")
//    public void getMyCareList(HttpServletRequest request,HttpServletResponse response) throws IOException {
//    	ReturnObject returnObject = new ReturnObject();
//    	try {
//    		JSONObject paramObj = JSONObject.parseObject(request.getAttribute("otherParamStr").toString());
//    		Page<Care> page = new Page<Care>(paramObj.getIntValue("pageNow"),paramObj.getIntValue("pageSize"));
//    		List<Care> careList = careIFService.selectMyCareList(paramObj.getString("memberGUID"), paramObj.getIntValue("isGetNews"), page);
//    		returnObject.setData(careList);
//    		logger.info("获取我关注的人列表（亲友关怀）完成");
//		} catch (Exception e) {
//			returnObject.setStatusCode(1);;
//			returnObject.setMessage("服务器内部异常");
//			logger.error("获取我关注的人列表（亲友关怀）异常");
//		}
//    	PrintWriter out = response.getWriter();
//        out.write(JSON.toJSONString(returnObject));
//    }
//	
//	
//    /**
//     * @Title:getCareMeList 
//     * @Description:获取关注我的人列表
//     * @author 谢美团
//     * @param accessParam
//     * @return 
//     * @throws
//     * @retrun String
//     * @throws IOException 
//     */ 
//    @RequestMapping(value = "/getCareMeList")
//    public void getCareMeList(HttpServletRequest request,HttpServletResponse response) throws IOException {
//    	ReturnObject returnObject = new ReturnObject();
//    	try {
//    		JSONObject paramObj = JSONObject.parseObject(request.getAttribute("otherParamStr").toString());
//    		Page<Care> page = new Page<Care>(paramObj.getIntValue("pageNow"),paramObj.getIntValue("pageSize"));
//    		List<Care> careList = careIFService.selectCareMeList(paramObj.getString("memberGUID"), page);
//    		returnObject.setData(careList);
//    		logger.info("获取关注我的人列表完成");
//		} catch (Exception e) {
//			returnObject.setStatusCode(1);;
//			returnObject.setMessage("服务器内部异常");
//			logger.error("获取关注我的人列表异常");
//		}
//    	PrintWriter out = response.getWriter();
//        out.write(JSON.toJSONString(returnObject));
//    }
//    
//    
//    /**
//     * @Title:getMember 
//     * @Description:通过条件精确查找会员
//     * @author 谢美团
//     * @param accessParam
//     * @return 
//     * @throws
//     * @retrun String
//     * @throws IOException 
//     */ 
//    @RequestMapping(value = "/getMember")
//    
//    public void getMember(HttpServletRequest request,HttpServletResponse response) throws IOException {
//    	ReturnObject returnObject = new ReturnObject();
//    	try {
//    		JSONObject paramObj = JSONObject.parseObject(request.getAttribute("otherParamStr").toString());
//    		Page<Care> page = new Page<Care>(paramObj.getIntValue("pageNow"),paramObj.getIntValue("pageSize"));
//    		List<Care> careList = careIFService.selectMemberByParams(paramObj.getString("searchParam"), paramObj.getString("memberGUID"), page);
//    		returnObject.setData(careList);
//    		logger.info("通过条件精确查找会员完成");
//		} catch (Exception e) {
//			returnObject.setStatusCode(1);;
//			returnObject.setMessage("服务器内部异常");
//			logger.error("通过条件精确查找会员异常");
//		}
//    	PrintWriter out = response.getWriter();
//        out.write(JSON.toJSONString(returnObject));
//    }
//	
//	
//    /**
//     * @Title:addCare 
//     * @Description:添加关注
//     * @author 谢美团
//     * @param accessParam
//     * @return 
//     * @throws
//     * @retrun String
//     * @throws IOException 
//     */ 
//    @RequestMapping(value = "/addCare")
//    
//    public void addCare(HttpServletRequest request,HttpServletResponse response) throws IOException {
//    	ReturnObject returnObject = new ReturnObject();
//    	try {
//    		CareInfo careInfo = JSONObject.parseObject(request.getAttribute("otherParamStr").toString(),CareInfo.class);
//    		careIFService.addCare_trans(careInfo);
//    		logger.info("添加关注完成");
//		} catch (Exception e) {
//			returnObject.setStatusCode(1);;
//			returnObject.setMessage("服务器内部异常");
//			logger.error("添加关注异常");
//		}
//    	PrintWriter out = response.getWriter();
//        out.write(JSON.toJSONString(returnObject));
//    }
//    
//    
//    /**
//     * @Title:relateAcount 
//     * @Description:通过关联账号来关注亲友
//     * @author 谢美团
//     * @param accessParam
//     * @return 
//     * @throws
//     * @retrun String
//     * @throws IOException 
//     */ 
//    @RequestMapping(value = "/relateAcount")
//    
//    public void relateAcount(HttpServletRequest request,HttpServletResponse response) throws IOException {
//    	ReturnObject returnObject = new ReturnObject();
//    	try {
//    		RelateAcount relateAcount = JSONObject.parseObject(request.getAttribute("otherParamStr").toString(),RelateAcount.class);
//    		int rows = careIFService.relateAcount_trans(relateAcount);
//    		if(rows != 1){
//    			returnObject.setStatusCode(1);
//    			returnObject.setMessage("通过关联账号来关注亲友失败");
//    		}
//    		logger.info("通过关联账号来关注亲友完成");
//		} catch (Exception e) {
//			returnObject.setStatusCode(1);;
//			returnObject.setMessage("服务器内部异常");
//			logger.error("通过关联账号来关注亲友异常");
//		}
//    	PrintWriter out = response.getWriter();
//        out.write(JSON.toJSONString(returnObject));
//    }
//    
//	
//    /**
//     * @Title:updateCare 
//     * @Description:修改 关注信息
//     * @author 谢美团
//     * @param accessParam
//     * @return 
//     * @throws
//     * @retrun String
//     * @throws IOException 
//     */ 
//    @RequestMapping(value = "/updateCare")
//    public void updateCare(HttpServletRequest request,HttpServletResponse response) throws IOException {
//    	ReturnObject returnObject = new ReturnObject();
//    	try {
//    		CareInfo careInfo = JSONObject.parseObject(request.getAttribute("otherParamStr").toString(),CareInfo.class);
//    		careIFService.updateCare(careInfo);
//    		logger.info("修改 关注信息完成");
//		} catch (Exception e) {
//			returnObject.setStatusCode(1);;
//			returnObject.setMessage("服务器内部异常");
//			logger.error("修改 关注信息异常");
//		}
//    	PrintWriter out = response.getWriter();
//        out.write(JSON.toJSONString(returnObject));
//    }
//	
//	
//    /**
//     * @Title:getMyCareMessage 
//     * @Description:获取我的温馨提示
//     * @author 谢美团
//     * @param accessParam
//     * @return 
//     * @throws
//     * @retrun String
//     * @throws IOException 
//     */ 
//    @RequestMapping(value = "/getMyCareMessage")
//    
//    public void getMyCareMessage(HttpServletRequest request,HttpServletResponse response) throws IOException {
//    	ReturnObject returnObject = new ReturnObject();
//    	try {
//    		JSONObject paramObj = JSONObject.parseObject(request.getAttribute("otherParamStr").toString());
//    		Page<KindlyReminder> page = new Page<KindlyReminder>(paramObj.getIntValue("pageNow"),paramObj.getIntValue("pageSize"));
//    		KindlyReminder kindlyReminder = new KindlyReminder(paramObj.getString("senderGUID"),paramObj.getString("receiverGUID"),paramObj.getIntValue("msgType"));
//    		List<KindlyReminder>  list = careIFService.getMyCareMessage(kindlyReminder, page);
//    		returnObject.setData(list);
//    		logger.info("获取我的温馨提示接口调用完成");
//		} catch (Exception e) {
//			returnObject.setStatusCode(1);;
//			returnObject.setMessage("服务器内部异常");
//			logger.error("获取我的温馨提示接口调用异常");
//		}
//    	PrintWriter out = response.getWriter();
//        out.write(JSON.toJSONString(returnObject));
//    }
//    
//    /**
//     * @Title:sendKindlyReminder 
//     * @Description:发送温馨提示消息
//     * @author 谢美团
//     * @param accessParam
//     * @return 
//     * @throws
//     * @retrun String
//     * @throws IOException 
//     */ 
//    @RequestMapping(value = "/sendKindlyReminder")
//    public void sendKindlyReminder(HttpServletRequest request,HttpServletResponse response) throws IOException {
//    	ReturnObject returnObject = new ReturnObject();
//    	try {
//    		KindlyReminder kindlyReminder = JSONObject.parseObject(request.getAttribute("otherParamStr").toString(),KindlyReminder.class);
//    		kindlyReminder.setSender(kindlyReminder.getSenderGUID());
//    		kindlyReminder.setReceiver(kindlyReminder.getReceiverGUID());
//    		kindlyReminder.setScheduleTime(TimeUtil.parseDatetime2(kindlyReminder.getSendTime()));
//    		 careIFService.sendKindlyReminder_trans(kindlyReminder);
//    		logger.info("发送温馨提示消息完成");
//		} catch (Exception e) {
//			returnObject.setStatusCode(1);;
//			returnObject.setMessage("服务器内部异常");
//			logger.error("发送温馨提示消息异常");
//		}
//    	PrintWriter out = response.getWriter();
//        out.write(JSON.toJSONString(returnObject));
//    }
//    
//    /**
//     * @Title:getMemberByGuid 
//     * @Description:根据GUID回去该会员的服务地址
//     * @author 谢美团
//     * @param accessParam
//     * @return 
//     * @throws
//     * @retrun String
//     * @throws IOException 
//     */ 
//    @RequestMapping(value = "/getMemberByGuid")
//    public void getMemberByGuid(HttpServletRequest request,HttpServletResponse response) throws IOException {
//    	ReturnObject returnObject = new ReturnObject();
//    	try {
//    		JSONObject paramObj = JSONObject.parseObject(request.getAttribute("otherParamStr").toString());
//    		Care care = careIFService.getmemberByGUID(paramObj.getString("memberGUID"));
//    		if( care != null ){
//    			returnObject.setData(care);
//    		}else{
//    			returnObject.setStatusCode(2);
//    			returnObject.setMessage("无数据");
//    		}
//    		logger.info("根据GUID回去该会员的服务地址完成");
//		} catch (Exception e) {
//			returnObject.setStatusCode(1);;
//			returnObject.setMessage("服务器内部异常");
//			logger.error("根据GUID回去该会员的服务地址异常");
//		}
//    	PrintWriter out = response.getWriter();
//        out.write(JSON.toJSONString(returnObject));
//    }
//
//}
