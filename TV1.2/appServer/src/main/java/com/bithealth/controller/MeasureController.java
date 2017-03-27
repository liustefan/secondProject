package com.bithealth.controller;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.careCore.facade.model.MsgCenter;
import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodPressure.model.OsbpExample;
import com.bithealth.measureCore.bloodPressure.model.OsbpExample.Criteria;
import com.bithealth.measureCore.bloodPressure.service.BloodPressureService;
import com.bithealth.measureCore.bloodPressure.service.BloodPressureUploadService;
import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.bloodSugar.model.ObsrExample;
import com.bithealth.measureCore.bloodSugar.service.BloodSugarService;
import com.bithealth.measureCore.bloodSugar.service.BloodSugarUploadService;
import com.bithealth.measureCore.common.model.ImageParam;
import com.bithealth.measureCore.common.service.OmdsService;
import com.bithealth.measureCore.electrocardio.model.Ecg1;
import com.bithealth.measureCore.electrocardio.model.Ecg1Example;
import com.bithealth.measureCore.electrocardio.model.Ecg2;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardio.model.OecgExample;
import com.bithealth.measureCore.electrocardio.service.Ecg1Service;
import com.bithealth.measureCore.electrocardio.service.Ecg2Service;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioFileService;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioService;
import com.bithealth.measureCore.electrocardioPulse.model.Oppg;
import com.bithealth.measureCore.electrocardioPulse.model.OppgExample;
import com.bithealth.measureCore.electrocardioPulse.service.PulseFileService;
import com.bithealth.measureCore.electrocardioPulse.service.PulseService;
import com.bithealth.measureCore.facade.Facade;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.model.AppUser;
import com.bithealth.model.MeasureData;
import com.bithealth.msgCenterCore.constants.MessageTypeEnum;
import com.bithealth.sdk.core.entity.JSONResult;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.util.MessageUtil;
import com.bithealth.util.TimeUtil;

/**
 * @PackageName: com.bithealth.controller
 * @FileName:    MeasureController.java  
 * @Description: 测量功能  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuxiaoqin
 * @version      V1.0  
 * @Createdate:  2016年7月28日 
 */
@Controller
@RequestMapping(value = "/measure")
public class MeasureController extends BaseSpringController{
	
	@Resource
    private BloodPressureService bloodPressureService;
	
	@Resource
    private BloodPressureUploadService bloodPressureUploadService;
	
	@Resource
    private BloodSugarService bloodSugarService;
	
	@Resource
    private BloodSugarUploadService bloodSugarUploadService;
	
	@Resource
    private ElectrocardioService electrocardioService;
	
	@Resource
    private PulseService pulseService;
	
	@Resource
    private ElectrocardioFileService electrocardioFileService;
	
	@Resource
    private PulseFileService pulseFileService;
	
	@Resource
    private Facade facade;
	
	@Resource
    private OmdsService omdsService;
	
	@Resource
    private Ecg2Service ecg2Service;
	
	@Resource
    private Ecg1Service ecg1Service;
	
	@Resource
    private MemberService memberService;
	
	private static Logger logger = Logger.getLogger(PaperController.class);
	
	/**
	 * @Description: 根据事件id和事件类型查询测量记录明细
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月03日 
	 */
	@RequestMapping(value = "/findMeasRecordByEventIdAndType", method = RequestMethod.POST)
    public void selectMeasRecordByEventIdAndType(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		//String appUser = (String)request.getAttribute("appUserStr");
    	//AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
		JSONObject StrObject = JSON.parseObject(otherParam);
    	Long eventId = StrObject.getLong("eventId");
    	if(eventId == null || eventId <= 0){
    		value.setStatusCode(1);
			value.setMessage("参数eventId【"+eventId+"】应为正整数");
			logger.info("参数eventId【"+eventId+"】应为正整数");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return;
    	}
    	Integer measType = StrObject.getInteger("measType");
    	if(measType == null || measType <= 0){
    		value.setStatusCode(1);
			value.setMessage("参数measType【"+measType+"】应为正整数");
			logger.info("参数measType【"+measType+"】应为正整数");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return;
    	}
    	MeasureData measureData = new MeasureData();
    	try{
    		if(measType == 1){
    			//血压
    			measureData = getBloodPressByEventId(eventId);
    			if(measureData != null && measureData.getData() != null){
    				value.setStatusCode(0);
    				value.setData(measureData);
    				value.setMessage("获取血压数据详情成功");
    				logger.info("获取血压数据详情成功");
    				value.setSuccess(true);
    			}else{
    				value.setStatusCode(3);
    				value.setMessage("没有血压数据");
    				logger.info("没有血压数据");
    				value.setSuccess(false);
    			}
    		}else if(measType == 2){
    			//血糖
    			measureData = getBloodSugarByEventId(eventId);
    			if(measureData != null && measureData.getData() != null){
    				value.setStatusCode(0);
    				value.setData(measureData);
    				value.setMessage("获取血糖数据详情成功");
    				logger.info("获取血糖数据详情成功");
    				value.setSuccess(true);
    			}else{
    				value.setStatusCode(3);
    				value.setMessage("没有血糖数据");
    				logger.info("没有血糖数据");
    				value.setSuccess(false);
    			}
    			
    		}else if(measType == 3){
    			//三合一
    			measureData = getThreeInOneByEventId(eventId);
    			if(measureData != null && measureData.getData() != null){
    				value.setStatusCode(0);
    				value.setData(measureData);
    				value.setMessage("获取三合一数据详情成功");
    				logger.info("获取三合一数据数据详情成功");
    				value.setSuccess(true);
    			}else{
    				value.setStatusCode(3);
    				value.setMessage("没有三合一数据数据");
    				logger.info("没有三合一数据数据");
    				value.setSuccess(false);
    			}
    		}else if(measType == 4){
    			//mini心电
    			measureData = getElectrocardioByEventId(eventId);
    			if(measureData != null && measureData.getData() != null){
    				value.setStatusCode(0);
    				value.setData(measureData);
    				value.setMessage("获取mini心电数据详情成功");
    				logger.info("获取mini心电数据详情成功");
    				value.setSuccess(true);
    			}else{
    				value.setStatusCode(3);
    				value.setMessage("没有mini心电数据");
    				logger.info("没有mini心电数据");
    				value.setSuccess(false);
    			}
    		}
    	}catch(Exception e){
			value.setSuccess(false);
			value.setStatusCode(2);
			value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.error("根据事件id和事件类型查询测量记录明细异常"+e);
		}
		out.write(JSON.toJSONString(value));
    }
	
	/**
	 * @Description: 上传血压数据
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月03日 
	 */
	@RequestMapping(value = "/uploadBloodPressure", method = RequestMethod.POST)
    public void insertBloodPressure(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	Integer memberId = user.getUserId();
		JSONObject StrObject = JSON.parseObject(otherParam);
		if(user.getUserType() == 2){
			memberId = StrObject.getInteger("memberId");
			if(memberId == null || memberId <= 0){
				value.setStatusCode(1);
				value.setMessage("参数memberId【"+memberId+"】应为正整数");
				logger.info("参数memberId【"+memberId+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value)); 
				return;
			}
		}
    	try{
    		String testTime = StrObject.getString("testTime");
    		/*验证是否已有数据，防止重复上传   begin*/
    		OsbpExample example = new OsbpExample();
    		example.createCriteria().andMemberidEqualTo(memberId).andTesttimeEqualTo(TimeUtil.datetimeFormat2.parse(testTime)).andDeltagEqualTo("0");
    		List<Osbp> oldOsbpList = bloodPressureService.selectByExample(example);
    		if(oldOsbpList != null && oldOsbpList.size() >0){
    			value.setStatusCode(7);
				value.setMessage("该血压数据已存在，请勿重复上传");
				logger.info("该血压数据已存在，请勿重复上传");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value)); 
				return;
    		}
    		/*验证是否已有数据，防止重复上传   end*/
    		Osbp osbp = JSON.parseObject(otherParam, Osbp.class);
    		String timePeriod = StrObject.getString("timePeriod");
    		String bluetoothMacAddr = StrObject.getString("bluetoothMacAddr");
    		String deviceCode = StrObject.getString("deviceCode");
    		Integer pulseRate = StrObject.getInteger("pulseRate");
    		osbp.setTesttime(TimeUtil.datetimeFormat2.parse(testTime));
    		osbp.setMemberid(memberId);
    		osbp.setTimeperiod(timePeriod);
    		osbp.setBluetoothmacaddr(bluetoothMacAddr);
    		osbp.setPulserate(pulseRate);
    		osbp.setDevicecode(deviceCode);
    		/* 设置消息参数  begin */
    		MsgCenter msgCenter = new MsgCenter();
    		Byte sendType = 2;
    		msgCenter.setSendtype(sendType);
    		msgCenter.setSender(user.getUserGUID());
    		msgCenter.setMsgtype(MessageTypeEnum.BLOOD_PRESSURE.getType());
    		osbp.setMsgCenter(msgCenter);
    		/* 设置消息参数  end */
    		bloodPressureUploadService.saveBloodPress(osbp);
    		value.setData(convertOsbp(osbp));
    		value.setStatusCode(0);
			value.setMessage("上传血压数据成功");
			logger.info("上传血压数据成功");
			value.setSuccess(true);
    	}catch(Exception e){
			value.setSuccess(false);
			value.setStatusCode(2);
			value.setMessage(MessageUtil.getValue("error.insert.data"));
			logger.error("上传血压数据异常"+e);
		}
		out.write(JSON.toJSONString(value));
	}

	/**
	 * @Description: 上传血糖数据
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月03日 
	 */
	@RequestMapping(value = "/uploadBloodSugar", method = RequestMethod.POST)
    public void insertBloodSugar(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	Integer memberId = user.getUserId();
		JSONObject StrObject = JSON.parseObject(otherParam);
		if(user.getUserType() == 2){
			memberId = StrObject.getInteger("memberId");
			if(memberId == null || memberId <= 0){
				value.setStatusCode(1);
				value.setMessage("参数memberId【"+memberId+"】应为正整数");
				logger.info("参数memberId【"+memberId+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return;
			}
		}
    	try{
    		String testTime = StrObject.getString("testTime");
    		/*验证是否已有数据，防止重复上传   begin*/
    		ObsrExample example = new ObsrExample();
    		example.createCriteria().andMemberidEqualTo(memberId).andTesttimeEqualTo(TimeUtil.datetimeFormat2.parse(testTime)).andDeltagEqualTo("0");
    		List<Obsr> obsrList = bloodSugarService.selectByExample(example);
    		if(obsrList != null && obsrList.size() >0){
    			value.setStatusCode(7);
				value.setMessage("该血糖数据已存在，请勿重复上传");
				logger.info("该血糖数据已存在，请勿重复上传");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value)); 
				return;
    		}
    		/*验证是否已有数据，防止重复上传   end*/
    		Obsr obsr = new Obsr();
    		String timePeriod = StrObject.getString("timePeriod");
    		String bluetoothMacAddr = StrObject.getString("bluetoothMacAddr");
    		String deviceCode = StrObject.getString("deviceCode");
    		Double bsValue = StrObject.getDouble("bsValue");
    		obsr.setTesttime(TimeUtil.datetimeFormat2.parse(testTime));
    		obsr.setMemberid(memberId);
    		obsr.setTimeperiod(timePeriod);
    		obsr.setBluetoothmacaddr(bluetoothMacAddr);
    		obsr.setDevicecode(deviceCode);
    		obsr.setBsvalue(bsValue);
    		/* 设置消息参数  begin */
    		MsgCenter msgCenter = new MsgCenter();
    		Byte sendType = 2;
    		msgCenter.setSendtype(sendType);
    		msgCenter.setSender(user.getUserGUID());
    		msgCenter.setMsgtype(MessageTypeEnum.BLOOD_SUGAR.getType());
    		obsr.setMsgCenter(msgCenter);
    		/* 设置消息参数  end */
    		bloodSugarUploadService.saveBloodSugar(obsr);
    		value.setData(convertObsr(obsr));
    		value.setStatusCode(0);
			value.setMessage("上传血糖数据成功");
			logger.info("上传血糖数据成功");
			value.setSuccess(true);
    	}catch(Exception e){
			value.setSuccess(false);
			value.setMessage(MessageUtil.getValue("error.insert.data"));
			value.setMessage("上传血糖数据异常");
			logger.error("上传血糖数据异常"+e);
		}
		out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 上传mini心电数据数据
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月03日 
	 */
	@RequestMapping(value = "/uploadMini", method = RequestMethod.POST)
    public void insertMini(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	Integer memberId = user.getUserId();
		JSONObject StrObject = JSON.parseObject(otherParam);
		if(user.getUserType() == 2){
			memberId = StrObject.getInteger("memberId");
			if(memberId == null || memberId <= 0){
				value.setStatusCode(1);
				value.setMessage("参数memberId【"+memberId+"】应为正整数");
				logger.info("参数memberId【"+memberId+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value)); 
				return;
			}
		}
    	try{
    		String measureTime = StrObject.getString("measureTime");
    		/*验证是否已有数据，防止重复上传   begin*/
    		OecgExample example = new OecgExample();
    		example.createCriteria().andMemberidEqualTo(memberId).andDeltagEqualTo("0").andMeastimeEqualTo(TimeUtil.datetimeFormat2.parse(measureTime)).andFsEqualTo((short)150);
    		List<Oecg> oecgList = electrocardioService.selectByExample(example);
    		if(oecgList != null && oecgList.size()>0){
    			value.setStatusCode(7);
				value.setMessage("该MINI心电数据已存在，请勿重复上传");
				logger.info("该MINI心电数据已存在，请勿重复上传");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value)); 
				return;
    		}
    		/*验证是否已有数据，防止重复上传   end*/
    		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
    		MultipartFile file = multipartRequest.getFile("miniFile");
    		if(file.isEmpty()){
    			value.setStatusCode(1);
				value.setMessage("文件miniFile【"+file+"】不能为空");
				logger.info("文件miniFile【"+file+"】不能为空");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return;
    		}
    		Short fs = StrObject.getShort("fs");
    		String bluetoothMacAddr = StrObject.getString("bluetoothMacAddr");
    		String deviceCode = StrObject.getString("deviceCode");
    		int timeLength = StrObject.getInteger("timeLength");
    		Oecg oecg = new Oecg();
    		oecg.setMemberid(memberId);
    		oecg.setBluetoothmacaddr(bluetoothMacAddr);
    		oecg.setDevicecode(deviceCode);
    		oecg.setMeastime(TimeUtil.datetimeFormat2.parse(measureTime));
    		oecg.setTimelength(timeLength);
    		oecg.setFs(fs);
    		oecg.setMemberid(memberId);
    		/* 设置消息参数  begin */
    		MsgCenter msgCenter = new MsgCenter();
    		Byte sendType = 2;
    		msgCenter.setSendtype(sendType);
    		msgCenter.setSender(user.getUserGUID());
    		msgCenter.setMsgtype(MessageTypeEnum.ECG_MEASURE.getType());
    		oecg.setMsgCenter(msgCenter);
    		/* 设置消息参数  end */
    		electrocardioFileService.saveElectrocardioFile(file.getInputStream(), oecg);
    		value.setData(convertOecg(oecg));
			value.setStatusCode(0);
			value.setMessage("上传mini心电数据成功");
			logger.info("上传mini心电数据成功");
			value.setSuccess(true);
    	}catch(Exception e){
			value.setSuccess(false);
			value.setStatusCode(2);
			value.setMessage(MessageUtil.getValue("error.insert.data"));
			logger.error("上传mini心电数据异常"+e);
		}
		out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 上传三合一数据
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月03日 
	 */
	@RequestMapping(value = "/uploadThreeInOne", method = RequestMethod.POST)
    public void insertThreeInOne(MultipartHttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	Integer memberId = user.getUserId();
		JSONObject StrObject = JSON.parseObject(otherParam);
		if(user.getUserType() == 2){
			memberId = StrObject.getInteger("memberId");
			if(memberId == null || memberId <= 0){
				value.setStatusCode(1);
				value.setMessage("参数memberId【"+memberId+"】应为正整数");
				logger.info("参数memberId【"+memberId+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return;
			}
		}
    	try{
    		String measureTime = StrObject.getString("measureTime");
    		/*验证是否已有数据，防止重复上传   begin*/
    		OppgExample example = new OppgExample();
    		example.createCriteria().andMemberidEqualTo(memberId).andDeltagEqualTo("0").andMeasuretimeEqualTo(TimeUtil.datetimeFormat2.parse(measureTime));
    		List<Oppg> oppgList = pulseService.selectByExample(example);
    		if(oppgList != null && oppgList.size()>0){
    			value.setStatusCode(7);
				value.setMessage("该三合一数据已存在，请勿重复上传");
				logger.info("该三合一数据已存在，请勿重复上传");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value)); 
				return;
    		}
    		/*验证是否已有数据，防止重复上传   end*/
    		MultipartFile oecgFile = request.getFile("oecgFile");
    		if(oecgFile.isEmpty()){
    			value.setStatusCode(1);
				value.setMessage("文件oecgFile【"+oecgFile+"】不能为空");
				logger.info("文件oecgFile【"+oecgFile+"】不能为空");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return;
    		}
    		MultipartFile oppgFile = request.getFile("oppgFile");
    		if(oppgFile.isEmpty()){
    			value.setStatusCode(1);
				value.setMessage("文件oppgFile【"+oppgFile+"】不能为空");
				logger.info("文件oppgFile【"+oppgFile+"】不能为空");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return;
    		}
    		Short ecgFs = StrObject.getShort("ecgFs");
    		Short ppgFs = StrObject.getShort("ppgFs");
    		Short spo = StrObject.getShort("spo");
    		String bluetoothMacAddr = StrObject.getString("bluetoothMacAddr");
    		String deviceCode = StrObject.getString("deviceCode");
    		int timeLength = StrObject.getInteger("timeLength");
    		Oecg oecg = new Oecg();
    		oecg.setMemberid(memberId);
    		oecg.setBluetoothmacaddr(bluetoothMacAddr);
    		oecg.setDevicecode(deviceCode);
    		oecg.setMeastime(TimeUtil.datetimeFormat2.parse(measureTime));
    		oecg.setTimelength(timeLength);
    		oecg.setFs(ecgFs);
    		Oppg oppg = new Oppg();
    		oppg.setMemberid(memberId);
    		oppg.setBluetoothmacaddr(bluetoothMacAddr);
    		oppg.setDevicecode(deviceCode);
    		oppg.setMeasuretime(TimeUtil.datetimeFormat2.parse(measureTime));
    		oppg.setTimelength(timeLength);
    		oppg.setFs(ppgFs);
    		oppg.setSpo(spo);
    		/* 设置消息参数  begin */
    		MsgCenter msgCenter = new MsgCenter();
    		Byte sendType = 2;
    		msgCenter.setSendtype(sendType);
    		msgCenter.setSender(user.getUserGUID());
    		msgCenter.setMsgtype(MessageTypeEnum.TRE_MEASURE.getType());
    		oecg.setMsgCenter(msgCenter);
    		/* 设置消息参数  end */
    		pulseFileService.saveElectrocardioPulseFile(oecgFile.getInputStream(), oecg, oppgFile.getInputStream(), oppg);
    		Map<String,Object> map = new HashMap<String, Object>();
    		map.put("oecg", convertOppg(oppg));
    		map.put("oppg", convertOecg(oecg));
    		value.setData(map);
			value.setStatusCode(0);
			value.setMessage("上传三合一数据成功");
			logger.info("上传三合一数据成功");
			value.setSuccess(true);
    	}catch(Exception e){
    		String errorMsg =  e.getMessage();
    		if(StringUtils.isEmpty(errorMsg) == false && (errorMsg.equals("没有相应的血压测量信息") || errorMsg.equals("无法获取该会员的年龄") || errorMsg.equals("无法获取该会员的身高"))){
    			value.setSuccess(false);
    			value.setStatusCode(1);
    			value.setMessage(errorMsg);
    			logger.error(errorMsg);
    		}else{
    			value.setSuccess(false);
    			value.setStatusCode(2);
    			value.setMessage(MessageUtil.getValue("error.insert.data"));
    			logger.error("上传三合一数据异常"+e);
    		}
		}
		out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 根据测量数据id和测量类型删除测量记录
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月03日 
	 */
	@RequestMapping(value = "/deleteMeasRecordByIdAndType", method = RequestMethod.POST)
    public void deleteMeasRecordByIdAndType(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	Long eventId = StrObject.getLong("eventId");
    	if(eventId == null || eventId <= 0){
    		value.setStatusCode(1);
			value.setMessage("参数eventId【"+eventId+"】应为正整数");
			logger.info("参数eventId【"+eventId+"】应为正整数");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return;
    	}
    	Integer measType = StrObject.getInteger("measType");
    	if(measType == null || measType <= 0){
    		value.setStatusCode(1);
			value.setMessage("参数measType【"+measType+"】应为正整数");
			logger.info("参数measType【"+measType+"】应为正整数");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return;
    	}
    	try{
    		if(measType == 1){
    			OsbpExample osbpExample = new OsbpExample();
    			Criteria osbpCri = osbpExample.createCriteria();
    			osbpCri.andEventidEqualTo(eventId);
    			int countObsp = bloodPressureService.deleteByExample(osbpExample);
    			if(countObsp >0){
    				value.setStatusCode(0);
    				value.setMessage("删除血压数据成功");
    				logger.info("删除血压数据成功");
    				value.setSuccess(true);
    			}else{
    				value.setStatusCode(1);
    				value.setMessage("删除血压数据失败");
    				logger.info("删除血压数据失败");
    				value.setSuccess(false);
    			}
    		}else if(measType == 2){
    			ObsrExample obsrExample = new ObsrExample();
    			com.bithealth.measureCore.bloodSugar.model.ObsrExample.Criteria obsrCri = obsrExample.createCriteria();
    			obsrCri.andEventidEqualTo(eventId);
    			int countObsr = bloodSugarService.deleteByExample(obsrExample);
    			if(countObsr >0){
    				value.setStatusCode(0);
    				value.setMessage("删除血糖数据成功");
    				logger.info("删除血糖数据成功");
    				value.setSuccess(true);
    			}else{
    				value.setStatusCode(1);
    				value.setMessage("删除血压数据失败");
    				logger.info("删除血压数据失败");
    				value.setSuccess(false);
    			}
    		}else if(measType == 3){
    			OecgExample oecgExample = new OecgExample();
    			com.bithealth.measureCore.electrocardio.model.OecgExample.Criteria oecgCri = oecgExample.createCriteria();
    			oecgCri.andEventidEqualTo(eventId);
    			int countOecg = electrocardioService.deleteByExample(oecgExample);
    			OppgExample oppgExample = new OppgExample();
    			com.bithealth.measureCore.electrocardioPulse.model.OppgExample.Criteria oppgCri = oppgExample.createCriteria();
    			oppgCri.andEventidEqualTo(eventId);
    			int countOppg = pulseService.deleteByExample(oppgExample);
    			if(countOecg >0 && countOppg >0){
    				value.setStatusCode(0);
        			value.setMessage("删除三合一数据成功");
        			logger.info("删除三合一数据成功");
        			value.setSuccess(true);
    			}else{
    				value.setStatusCode(1);
    				value.setMessage("删除mini数据失败");
    				logger.info("删除mini数据失败");
    				value.setSuccess(false);
    			}
    		}else if(measType == 4){
    			OecgExample oecgExample = new OecgExample();
    			com.bithealth.measureCore.electrocardio.model.OecgExample.Criteria oecgCri = oecgExample.createCriteria();
    			oecgCri.andEventidEqualTo(eventId);
    			int countOecg = electrocardioService.deleteByExample(oecgExample);
    			if(countOecg >0){
    				value.setStatusCode(0);
    				value.setMessage("删除mini数据成功");
    				logger.info("删除mini数据成功");
    				value.setSuccess(true);
    			}else{
    				value.setStatusCode(1);
    				value.setMessage("删除mini数据失败");
    				logger.info("删除mini数据失败");
    				value.setSuccess(false);
    			}
    		}
    	}catch(Exception e){
			value.setSuccess(false);
			value.setStatusCode(2);
			value.setMessage(MessageUtil.getValue("error.delete.data"));
			logger.error("删除测量数据异常"+e);
		}
		out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 获取测量数据图片(心电和脉搏)
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月03日 
	 */
	@RequestMapping(value = "/findMeasDataImages", method = RequestMethod.GET)
    public ModelAndView selectMeasDataImages(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
    	String imgType = request.getParameter("imgType");
    	if(StringUtils.isEmpty(imgType)){
    		JSONResult<Object> value = new JSONResult<Object>();
    		PrintWriter out = response.getWriter();
    		value.setStatusCode(1);
			value.setMessage("参数imgType【"+imgType+"】不能为空");
			logger.info("参数imgType【"+imgType+"】不能为空");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return null;
    	}
    	String width = request.getParameter("width");
    	if(StringUtils.isEmpty(width)){
    		JSONResult<Object> value = new JSONResult<Object>();
    		PrintWriter out = response.getWriter();
    		value.setStatusCode(1);
			value.setMessage("参数width【"+width+"】不能为空");
			logger.info("参数width【"+width+"】不能为空");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return null;
    	}
    	String height = request.getParameter("height");
    	if(StringUtils.isEmpty(height)){
    		JSONResult<Object> value = new JSONResult<Object>();
    		PrintWriter out = response.getWriter();
    		value.setStatusCode(1);
			value.setMessage("参数height【"+height+"】不能为空");
			logger.info("参数height【"+height+"】不能为空");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return null;
    	}
    	String page = request.getParameter("page");
    	if(StringUtils.isEmpty(page)){
    		JSONResult<Object> value = new JSONResult<Object>();
    		PrintWriter out = response.getWriter();
    		value.setStatusCode(1);
			value.setMessage("参数page【"+page+"】不能为空");
			logger.info("参数page【"+page+"】不能为空");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return null;
    	}
    	Long oecgIdNew = null;
    	Long oppgIdNew = null;
    	String oecgId = request.getParameter("oecgId");
    	if(StringUtils.isEmpty(oecgId)){
    		JSONResult<Object> value = new JSONResult<Object>();
    		PrintWriter out = response.getWriter();
    		value.setStatusCode(1);
			value.setMessage("参数oecgId【"+oecgId+"】应该为正整数");
			logger.info("参数oecgId【"+oecgId+"】应该为正整数");
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return null;
    	}
    	String oppgId = request.getParameter("oppgId");
    	if(!StringUtils.isEmpty(oppgId)){
    		oppgIdNew = Long.valueOf(oppgId);
    	}
    	oecgIdNew = Long.valueOf(oecgId);
    	/*从表中获取参数 begin*/
    	Oecg oecg = electrocardioService.selectElectrocardioByDocentry(oecgIdNew);
    	Oppg oppg = pulseService.selectById(oppgIdNew);
    	/*从表中获取参数 end*/
    	ImageParam param = new ImageParam();
    	param.setDeviceCode(oecg.getDevicecode());
    	param.setType(imgType);
    	param.setFs(oecg.getFs());
    	param.setHeight(Integer.valueOf(height));
    	param.setWidth(Integer.valueOf(width));
    	param.setMeasureTime(oecg.getMeastime());
    	param.setPage(Integer.valueOf(page));
    	/* 未知参数 begin  */
    	Map<String, Object> map = new HashMap<String, Object>();
    	
		if("ecg".equals(imgType)||"mi_ecg".equals(imgType)||"ab_ecg".equals(imgType)){
			if("ab_ecg".equals(imgType)){
				/* 异常心电图文件的id begin*/
				String abnEcgFileId = request.getParameter("abnEcgFileId");
				if(!StringUtils.isEmpty(abnEcgFileId)){
				    param.setRawImage(abnEcgFileId);
				}
				map = electrocardioFileService.getExcElectrocardioChartFileData(param);
			}else if("mi_ecg".equals(imgType)){
				if(oecg != null){
					String rawECGImg = oecg.getRawecgimg();
					if(!StringUtils.isEmpty(rawECGImg)){
						param.setRawImage(rawECGImg);
					}else{
						param.setRawImage(oecg.getRawecg());
					}
				}
				/*获取总页数和开始和结束时间 begin*/
				String totalPage = request.getParameter("totalPage");
				param.setTotalPage(Integer.valueOf(totalPage));
				int showTimeLength = 1;
				int startTimeQueryDis = 0;
				int endTimeQueryDis = 0;
				Date testTime = oecg.getMeastime();
				long measTime = testTime.getTime() + showTimeLength*6*1000*(Integer.valueOf(page)-1);
				long beginDate = testTime.getTime()+ 6000*(Integer.valueOf(page)-1);
				long endDate = beginDate + 6000;
				startTimeQueryDis = (int)((beginDate - testTime.getTime())/1000);
				endTimeQueryDis = (int)((endDate - beginDate)/1000);
				param.setMeasureTime(new Date(measTime));
				param.setShowTimeLength(showTimeLength);
				param.setStartTimeQueryDis(startTimeQueryDis);
				param.setEndTimeQueryDis(endTimeQueryDis);
				param.setTimeQuery(true);
				/*获取总页数和开始和结束时间 end*/
				map = electrocardioFileService.getElectrocardioChartFileDataApp(param);
				if(map != null && map.isEmpty() == false){
					map.put("measureTime", new Date(measTime));
				}
			}else{
				if(oecg != null){
					String rawECGImg = oecg.getRawecgimg();
					if(!StringUtils.isEmpty(rawECGImg)){
						param.setRawImage(rawECGImg);
					}else{
						param.setRawImage(oecg.getRawecg());
					}
				}
				/*获取总页数和开始和结束时间 begin*/
				String totalPage = request.getParameter("totalPage");
				param.setTotalPage(Integer.valueOf(totalPage));
				int showTimeLength = 1;
				int startTimeQueryDis = 0;
				int endTimeQueryDis = 0;
				Date testTime = oecg.getMeastime();
				long measTime = testTime.getTime() + showTimeLength*6*1000*(Integer.valueOf(page)-1);
				long beginDate = testTime.getTime()+ 6000*(Integer.valueOf(page)-1);
				long endDate = beginDate + 6000;
				startTimeQueryDis = (int)((beginDate - testTime.getTime())/1000);
				endTimeQueryDis = (int)((endDate - beginDate)/1000);
				param.setMeasureTime(new Date(measTime));
				param.setShowTimeLength(showTimeLength);
				param.setStartTimeQueryDis(startTimeQueryDis);
				param.setEndTimeQueryDis(endTimeQueryDis);
				param.setTimeQuery(true);
				/*获取总页数和开始和结束时间 end*/
				map = pulseFileService.getElectrocardioPulseChartFileDataApp(param);
			}
			if(map != null && map.isEmpty() == false){
				map.put("measureTime", oecg.getMeastime());
				map.put("page", Integer.valueOf(page));
				mav.addObject("data", JSON.toJSONString(map)); 
				mav.setViewName("highChart");  
			}else{
				mav.setViewName("noChart");
			}
			return mav; 
		}
		else if("ppg".equals(imgType)){
			if(oppg != null){
				param.setFs(oppg.getFs());
				param.setRawImage(oppg.getRawppg());
			}
			map = pulseFileService.getPulseChartFileData(param);
			if(map != null && map.isEmpty() == false){
				map.put("page", Integer.valueOf(page));
				mav.addObject("data", JSON.toJSONString(map));
				mav.setViewName("ppgChart");  
			}else{
				mav.setViewName("noChart");
			}
			return mav;  
		}else if("hr_ppg".equals(imgType)){
			if(oppg != null){
				param.setFs(oppg.getFs());
				param.setRawImage(oppg.getPpgrr());
			}
			map = pulseFileService.getInstantPulseChartFileData(param);
			if(map != null && map.isEmpty() == false){
				map.put("page", Integer.valueOf(page));
				mav.addObject("data", JSON.toJSONString(map));
				mav.setViewName("hrppgChart"); 
			}else{
				mav.setViewName("noChart");
			}
			return mav;   
		}else if("hr_ecg".equals(imgType)){
			if(oecg != null){
				param.setRawImage(oecg.getRrinterval());
			}
			map = electrocardioFileService.getInstantHeartRateChartFileData(param);
			if(map != null && map.isEmpty() == false){
				map.put("page", Integer.valueOf(page));
				mav.addObject("data", JSON.toJSONString(map));
				mav.setViewName("hrecgChart"); 
			}else{
				mav.setViewName("noChart");
			}
			return mav;
		}	
		return null;
	}
	
	/**
	 * @Description: 获取测量数据图片(心电和脉搏)的总页数
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月03日 
	 */
	@RequestMapping(value = "/findMeasDataImagesPages", method = RequestMethod.POST)
    public void selectMeasDataImagesPages(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		try{
    		String otherParam = (String)request.getAttribute("otherParamStr");
    		JSONObject StrObject = JSON.parseObject(otherParam);
    		String imgType = StrObject.getString("imgType");
    		if(StringUtils.isEmpty(imgType)){
    			value.setStatusCode(1);
    			value.setMessage("参数imgType【"+imgType+"】不能为空");
    			logger.info("参数imgType【"+imgType+"】不能为空 ");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return;
    		}
    		Long oppgId = StrObject.getLong("oppgId");
    		Long oecgId = StrObject.getLong("oecgId");
    		if(oecgId == null || oecgId <= 0){
    			value.setStatusCode(1);
    			value.setMessage("参数oecgId【"+oecgId+"】应为正整数");
    			logger.info("参数oecgId【"+oecgId+"】应为正整数 ");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return;
    		}
    		Oecg oecg = electrocardioService.selectElectrocardioByDocentry(oecgId);
        	Oppg oppg = pulseService.selectById(oppgId);
    		int page = 0;
    		ImageParam param = new ImageParam();
    		param.setFs(oecg.getFs());
    		String rawImage = "";
    		if("ecg".equals(imgType)){
    			if(oecg != null){
    				if(!StringUtils.isEmpty(oecg.getRawecgimg())){
    					rawImage = oecg.getRawecgimg();
    				}else{
    					if(!StringUtils.isEmpty(oecg.getRawecg())){
    						rawImage = oecg.getRawecg();
    					}
    				}
    			}
    			if(!StringUtils.isEmpty(rawImage)){
    				param.setRawImage(rawImage);
    				page = pulseFileService.getElectrocardioPulsePageByparam(param);
    			}
    		}else if("mi_ecg".equals(imgType)){
    			if(oecg != null){
    				if(!StringUtils.isEmpty(oecg.getRawecgimg())){
    					rawImage = oecg.getRawecgimg();
    				}else{
    					if(!StringUtils.isEmpty(oecg.getRawecg())){
    						rawImage = oecg.getRawecg();
    					}
    				}
    			}
    			if(!StringUtils.isEmpty(rawImage)){
    				param.setRawImage(rawImage);
    				page = electrocardioFileService.getElectrocardioPageByParam(param);
    			}
    		}else if("ab_ecg".equals(imgType)){
    			page = 1;
    		}else if("ppg".equals(imgType)){
    			if(oppg != null && StringUtils.isEmpty(oppg.getRawppg()) == false){
    				param.setFs(oppg.getFs());
    				rawImage = oppg.getRawppg();
    			}
    			if(!StringUtils.isEmpty(rawImage)){
    				param.setRawImage(rawImage);
    				page = pulseFileService.getPulsePageByParam(param);
    			}
    			
    		}else if("hr_ppg".equals(imgType)){
    			page = 1;
    		}else if("hr_ecg".equals(imgType)){
    			if(oecg != null){
    				if(!StringUtils.isEmpty(oecg.getRrinterval())){
    					rawImage = oecg.getRrinterval();
    				}
    			}
    			if(!StringUtils.isEmpty(rawImage)){
    				param.setRawImage(rawImage);
    				page = electrocardioFileService.getInstantHeartRatePageByParam(param);
    			}
    		}
    		value.setSuccess(true);
    		value.setData(page);
			value.setStatusCode(0);
			value.setMessage("获取测量数据图片的总页数成功！");
			logger.error("获取测量数据图片的总页数成功！");
		}catch(Exception e){
			value.setSuccess(false);
			value.setStatusCode(2);
			value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.error("获取测量数据图片的总页数异常"+e);
		}
		out.write(JSON.toJSONString(value));	
    }
	
	/**
	 * @Description: 分页条件查询我的测量记录列表
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月17日 
	 */
	@RequestMapping(value = "/findMeasRecordList", method = RequestMethod.POST)
    public void selectMeasRecordList(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
    	try{
    		String appUser = (String)request.getAttribute("appUserStr");
    		AppUser user = JSON.parseObject(appUser, AppUser.class);
    		String otherParam = (String)request.getAttribute("otherParamStr");
    		Integer memberId = user.getUserId();
    		JSONObject StrObject = JSON.parseObject(otherParam);
    		if(user.getUserType() == 2){
    			memberId = StrObject.getInteger("memberId");
    			if(memberId == null || memberId <= 0){
    				value.setStatusCode(1);
    				value.setMessage("参数memberId【"+memberId+"】应为正整数");
    				logger.info("参数memberId【"+memberId+"】应为正整数");
    				value.setSuccess(false);
    				out.write(JSON.toJSONString(value));
    				return;
    			}
    		}
    		String memberGUID = StrObject.getString("memberGUID");
    		if(!StringUtils.isEmpty(memberGUID)){
    			Member member = memberService.selectByUUID(memberGUID,UseTag.T);
    			if(member != null){
    				memberId = member.getMemberid();
    			}
    		}
    		Integer eventType = null;
    		Integer pageNow = 1;
    		Integer pageSize = 10;
    		Integer newPageNow = StrObject.getInteger("pageNow");
    		if(newPageNow != null && newPageNow >0){
    			pageNow = newPageNow;
    		}
        	Integer newPageSize = StrObject.getInteger("pageSize");
        	if(newPageSize != null && newPageSize >0){
        		pageSize = newPageSize;
    		}
        	Integer newEventType = StrObject.getInteger("measType");
        	if(newEventType != null && newEventType >0){
        		eventType = newEventType;
        		if(newEventType ==5){
        			eventType = null;
        		}
    		}
        	Map<String, List<Map<String, Object>>> map = omdsService.findAllMeasureRecordByParam(memberId, eventType, null, null, null, pageNow, pageSize);
    		if(map != null && map.isEmpty() == false){
    			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();          
    			Set<String> keyList = map.keySet();
    			for(String key : keyList){
    				Map<String,Object> newMap = new HashMap<String, Object>();
    				newMap.put("testDate", key);
    				newMap.put("dateAlias", TimeUtil.getDateAlias(key));
    				newMap.put("measureData", getMeasureDate(map.get(key)));
    				list.add(newMap);
    			}
    			value.setStatusCode(0);
    			value.setData(list);
				value.setMessage("分页条件查询我的测量记录列表成功");
				logger.info("分页条件查询我的测量记录列表成功");
				value.setSuccess(true);
    		}else{
    			value.setStatusCode(3);
				value.setMessage("没有测量记录");
				logger.info("没有测量记录");
				value.setSuccess(true);
    		}
    	}catch(Exception e){
			value.setSuccess(false);
			value.setStatusCode(2);
			value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.error("分页条件查询我的测量记录列表异常"+e);
		}
		out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 根据事件ids和事件类型查询测量记录明细List
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月24日 
	 */
	@RequestMapping(value = "/findRecordListByEventIdsAndType", method = RequestMethod.POST)
    public void selectRecordListByEventIdsAndType(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		//String appUser = (String)request.getAttribute("appUserStr");
    	//AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	try{
    		JSONObject StrObject = JSON.parseObject(otherParam);
    		String eventIds = StrObject.getString("eventIds");
    		if(StringUtils.isEmpty(eventIds)){
    			value.setStatusCode(1);
    			value.setMessage("参数eventIds【"+eventIds+"】不能为空");
    			logger.info("参数eventIds【"+eventIds+"】不能为空 ");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return;
    		}
    		Set<String> eventIdsStr = StringUtils.commaDelimitedListToSet(eventIds);
    		List<Long> ids = new ArrayList<Long>();
    		for(String id : eventIdsStr){
    			ids.add(Long.valueOf(id));
    		}
    		Integer measType = StrObject.getInteger("measType");
    		if(measType == null || measType <= 0){
    			value.setStatusCode(1);
    			value.setMessage("参数measType【"+measType+"】应为正整数");
    			logger.info("参数measType【"+measType+"】应为正整数");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return;
    		}
    		List<MeasureData> dataList = new ArrayList<MeasureData>();
    		if(measType == 1){
    			//血压
    			for(Long id : ids){
    				MeasureData data = getBloodPressByEventId(id);
    				if(data != null && data.getData() != null){
    					dataList.add(data);
    				}
    			}
    			if(dataList != null && dataList.size() >0){
    				value.setStatusCode(0);
    				value.setData(dataList);
    				value.setMessage("获取血压数据list成功");
    				logger.info("获取血压数据list成功");
    				value.setSuccess(true);
    			}else{
    				value.setStatusCode(3);
    				value.setMessage("没有血压数据");
    				logger.info("没有血压数据");
    				value.setSuccess(false);
    			}
    		}else if(measType == 2){
    			//血糖
    			for(Long id : ids){
    				MeasureData data = getBloodSugarByEventId(id);
    				if(data != null && data.getData() != null){
    					dataList.add(data);
    				}
    			}
    			if(dataList != null && dataList.size() >0){
    				value.setStatusCode(0);
    				value.setData(dataList);
    				value.setMessage("获取血糖数据list成功");
    				logger.info("获取血糖数据list成功");
    				value.setSuccess(true);
    			}else{
    				value.setStatusCode(3);
    				value.setMessage("没有血糖数据");
    				logger.info("没有血糖数据");
    				value.setSuccess(false);
    			}
    		}else if(measType == 3){
    			//三合一
    			for(Long id : ids){
    				MeasureData data = getThreeInOneByEventId(id);
    				if(data != null && data.getData() != null){
    					dataList.add(data);
    				}
    			}
    			if(dataList != null && dataList.size() >0){
    				value.setStatusCode(0);
    				value.setData(dataList);
    				value.setMessage("获取三合一数据list成功");
    				logger.info("获取三合一数据list成功");
    				value.setSuccess(true);
    			}else{
    				value.setStatusCode(3);
    				value.setMessage("没有三合一数据");
    				logger.info("没有三合一数据");
    				value.setSuccess(false);
    			}
    		}else if(measType == 4){
    			//mini心电
    			for(Long id : ids){
    				MeasureData data = getElectrocardioByEventId(id);
    				if(data != null && data.getData() != null){
    					dataList.add(data);
    				}
    			}
    			if(dataList != null && dataList.size() >0){
    				value.setStatusCode(0);
    				value.setData(dataList);
    				value.setMessage("获取mini心电数据list成功");
    				logger.info("获取mini心电数据list成功");
    				value.setSuccess(true);
    			}else{
    				value.setStatusCode(3);
    				value.setMessage("没有mini心电数据");
    				logger.info("没有mini心电数据");
    				value.setSuccess(false);
    			}
    		}
    	}catch(Exception e){
			value.setSuccess(false);
			value.setStatusCode(2);
			value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.error("根据事件id和事件类型查询测量记录明细异常"+e);
		}
		out.write(JSON.toJSONString(value));
    }
	
	/**
	 * @Description: 根据事件id查找血压数据
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月17日 
	 */
	public MeasureData getBloodPressByEventId(Long eventId) throws Exception{
		MeasureData data = new MeasureData();
		Osbp osbp = bloodPressureService.selectBloodPressByEventId(eventId);
		if(osbp != null){
			data.setData(convertOsbp(osbp));
			data.setMeasType(1);
			String isAbnormal = osbp.getAbnormal();
			if(!StringUtils.isEmpty(isAbnormal) && isAbnormal.equals("0")){
				data.setIsAbnormal(0);
			}else{
				data.setIsAbnormal(1);
			}
			Date date = osbp.getTesttime();
			if(date != null){
				data.setMeasureTime(TimeUtil.formatDatetime2(date));	
			}
		}
		return data;
	}
	
	/**
	 * @Description: 根据事件id查找血糖数据
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月17日 
	 */
	public MeasureData getBloodSugarByEventId(Long eventId) throws Exception{
		MeasureData data = new MeasureData();
		Obsr obsr = bloodSugarService.selectBloodSugarByEventId(eventId);
		if(obsr != null){
			data.setData(convertObsr(obsr));
			data.setMeasType(2);
			String isAbnormal = obsr.getAnalysisresult();
			if(!StringUtils.isEmpty(isAbnormal) && isAbnormal.equals("0")){
				data.setIsAbnormal(0);
			}else{
				data.setIsAbnormal(1);
			}
			Date date = obsr.getTesttime();
			if(date != null){
				data.setMeasureTime(TimeUtil.formatDatetime2(date));	
			}
		}
		return data;
	}
	
	/**
	 * @Description: 根据事件id查找三合一数据
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月17日 
	 */
	public MeasureData getThreeInOneByEventId(Long eventId) throws Exception{
		MeasureData data = new MeasureData();
		Oecg oecg = electrocardioService.selectElectrocardioByEventId(eventId);
		Oppg oppg = pulseService.selectElectrocardioPulseByEventId(eventId);
		if(oecg != null && oppg != null){
//			Long docentry = oecg.getDocentry();
//			List<Ecg2> list = getAbnormalEcgDataList(docentry);
//			if(list != null && list.size() > 0){
//				oecg.setEcg2s(list);
//			}
//			List<String> abnormalList = oppg.getMeasureResult();
//			if(abnormalList != null && abnormalList.size() > 0){
//				oppg.setExtName(abnormalList);
//			}
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("oppg", convertOppg(oppg));
			map.put("oecg", convertOecg(oecg));
			data.setData(map);
			data.setMeasType(3);
			Integer isAbnormalOppg = (int)oppg.getPpgresult();
			Integer isAbnormalOecg = (int)oecg.getEcgresult();
			if(StringUtils.isEmpty(isAbnormalOppg) == false && isAbnormalOppg == 0 &&
				StringUtils.isEmpty(isAbnormalOecg) == false && isAbnormalOecg == 0){
				data.setIsAbnormal(0);
			}else{
				data.setIsAbnormal(1);
			}
			Date date = oecg.getMeastime();
			if(date != null){
				data.setMeasureTime(TimeUtil.formatDatetime2(date));	
			}
		}
		return data;
	}
	
	/**
	 * @Description: 根据事件id查找心电mini数据
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月17日 
	 */
	public MeasureData getElectrocardioByEventId(Long eventId) throws Exception{
		MeasureData data = new MeasureData();
		Oecg oecg = electrocardioService.selectElectrocardioByEventId(eventId);
		if(oecg != null){
			data.setData(convertOecg(oecg));
			data.setMeasType(4);
			Integer isAbnormal = (int)oecg.getEcgresult();
			if(!StringUtils.isEmpty(isAbnormal) && isAbnormal == 0){
				data.setIsAbnormal(0);
			}else{
				data.setIsAbnormal(1);
			}
			Date date = oecg.getMeastime();
			if(date != null){
				data.setMeasureTime(TimeUtil.formatDatetime2(date));	
			}
		}
		return data;
	}
	
	/**
	 * @Description: 获取脉搏异常数据
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月17日 
	 */
	public static List<Map<String,Object>> getAbnormalOppgDataList(Oppg oppg) throws Exception{
		if(oppg.getStatustag() != null && oppg.getStatustag() == 2){
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			/* 偏低1；偏高2*/
			int abnormalDesc = 0;
			/* 平均脉率 begin */
			Map<String,Object> pulserateMap = new HashMap<String, Object>();
			Short pulserate = oppg.getPulserate();
			if(pulserate == null){
				pulserate = 0;
			}
			if(pulserate < 55){
				abnormalDesc = 1;
			}else if(pulserate > 100){
				abnormalDesc = 2;
			}
			if(abnormalDesc != 0){
				pulserateMap.put("abnormalName", "pulserate");
				pulserateMap.put("abnormalValue", pulserate);
				pulserateMap.put("abnormalDesc", abnormalDesc);
				list.add(pulserateMap);
				abnormalDesc = 0;
			}
			/* 平均脉率 end */
			
			/* 射血量 begin */
			Map<String,Object> coMap = new HashMap<String, Object>();
			BigDecimal co = oppg.getCo();
			if(co == null){
				co = BigDecimal.ZERO;
			}
			if(co.compareTo(new BigDecimal(3)) < 0){
				abnormalDesc = 1;
			}else if(co.compareTo(new BigDecimal(7.5)) > 0){
				abnormalDesc = 2;
			}
			if(abnormalDesc != 0){
				coMap.put("abnormalName", "co");
				coMap.put("abnormalValue", co);
				coMap.put("abnormalDesc", abnormalDesc);
				list.add(coMap);
				abnormalDesc = 0;
			}
			/* 射血量  end */

			/* 心脏每搏射血量 begin */
			Map<String,Object> svMap = new HashMap<String, Object>();
			BigDecimal sv = oppg.getSv();
			if(sv == null){
				sv = BigDecimal.ZERO;
			}
			if(sv.compareTo(new BigDecimal(55)) < 0){
				abnormalDesc = 1;
			}else if(sv.compareTo(new BigDecimal(105)) > 0){
				abnormalDesc = 2;
			}
			if(abnormalDesc != 0){
				svMap.put("abnormalName", "sv");
				svMap.put("abnormalValue", sv);
				svMap.put("abnormalDesc", abnormalDesc);
				list.add(svMap);
				abnormalDesc = 0;
			}
			/* 心脏每搏射血量 end */

			/* 血氧饱和度SO begin */
			Map<String,Object> spoMap = new HashMap<String, Object>();
			Short spo = oppg.getSpo();
			if(spo == null){
				spo = 0;
			}
			if(spo < 95){
				abnormalDesc = 1;
			}else if(spo > 100){
				abnormalDesc = 2;
			}
			if(abnormalDesc != 0){
				spoMap.put("abnormalName", "spo");
				spoMap.put("abnormalValue", spo);
				spoMap.put("abnormalDesc", abnormalDesc);
				list.add(spoMap);
				abnormalDesc = 0;
			}
			/* 血氧饱和度SOend */

			/* 心指数 CI begin */
			Map<String,Object> ciMap = new HashMap<String, Object>();
			BigDecimal ci = oppg.getCi();
			if(ci == null){
				ci = BigDecimal.ZERO;
			}
			if(ci.compareTo(new BigDecimal(2.3)) < 0){
				abnormalDesc = 1;
			}else if(ci.compareTo(new BigDecimal(100)) > 0){
				abnormalDesc = 2;
			}
			if(abnormalDesc != 0){
				ciMap.put("abnormalName", "ci");
				ciMap.put("abnormalValue", ci);
				ciMap.put("abnormalDesc", abnormalDesc);
				list.add(ciMap);
				abnormalDesc = 0;
			}
			/* 心指数 CI率 end */

			/* 心搏指数SPI begin */
			Map<String,Object> spiMap = new HashMap<String, Object>();
			BigDecimal spi = oppg.getSpi();
			if(spi == null){
				spi = BigDecimal.ZERO;
			}
			if(spi.compareTo(new BigDecimal(33)) < 0){
				abnormalDesc = 1;
			}else if(spi.compareTo(new BigDecimal(200)) > 0){
				abnormalDesc = 2;
			}
			if(abnormalDesc != 0){
				spiMap.put("abnormalName", "spi");
				spiMap.put("abnormalValue", spi);
				spiMap.put("abnormalDesc", abnormalDesc);
				list.add(spiMap);
				abnormalDesc = 0;
			}
			/* 心搏指数SPI end */

			/* 波形特征量 K begin */
			Map<String,Object> kMap = new HashMap<String, Object>();
			BigDecimal k = oppg.getK();
			if(k == null){
				k = BigDecimal.ZERO;
			}
			if(k.compareTo(new BigDecimal(0.29)) < 0){
				abnormalDesc = 1;
			}else if(k.compareTo(new BigDecimal(0.46)) > 0){
				abnormalDesc = 2;
			}
			if(abnormalDesc != 0){
				kMap.put("abnormalName", "k");
				kMap.put("abnormalValue", k);
				kMap.put("abnormalDesc", abnormalDesc);
				list.add(kMap);
				abnormalDesc = 0;
			}
			/* 波形特征量 K end */

			/* 血液黏度 begin */
			Map<String,Object> vMap = new HashMap<String, Object>();
			BigDecimal v = oppg.getV();
			if(v == null){
				v = BigDecimal.ZERO;
			}
			if(v.compareTo(new BigDecimal(3)) < 0){
				abnormalDesc = 1;
			}else if(v.compareTo(new BigDecimal(5.04)) > 0){
				abnormalDesc = 2;
			}
			if(abnormalDesc != 0){
				vMap.put("abnormalName", "v");
				vMap.put("abnormalValue", v);
				vMap.put("abnormalDesc", abnormalDesc);
				list.add(vMap);
				abnormalDesc = 0;
			}
			/* 血液黏度 end */

			/* 外周阻力 TPR begin */
			Map<String,Object> tprMap = new HashMap<String, Object>();
			BigDecimal tpr = oppg.getTpr();
			if(tpr == null){
				tpr = BigDecimal.ZERO;
			}
			if(tpr.compareTo(new BigDecimal(750)) < 0){
				abnormalDesc = 1;
			}else if(tpr.compareTo(new BigDecimal(1450)) > 0){
				abnormalDesc = 2;
			}
			if(abnormalDesc != 0){
				tprMap.put("abnormalName", "tpr");
				tprMap.put("abnormalValue", tpr);
				tprMap.put("abnormalDesc", abnormalDesc);
				list.add(tprMap);
				abnormalDesc = 0;
			}
			/* 外周阻力 TPR end */

			/* 血管顺应度 AC begin */
			Map<String,Object> acMap = new HashMap<String, Object>();
			BigDecimal ac = oppg.getAc();
			if(ac == null){
				ac = BigDecimal.ZERO;
			}
			if(ac.compareTo(new BigDecimal(1.2)) < 0){
				abnormalDesc = 1;
			}else if(ac.compareTo(new BigDecimal(3)) > 0){
				abnormalDesc = 2;
			}
			if(abnormalDesc != 0){
				acMap.put("abnormalName", "ac");
				acMap.put("abnormalValue", ac);
				acMap.put("abnormalDesc", abnormalDesc);
				list.add(acMap);
				abnormalDesc = 0;
			}
			/* 血管顺应度 AC end */

			/* 平均动脉压 begin */
			Map<String,Object> pmMap = new HashMap<String, Object>();
			BigDecimal pm = oppg.getPm();
			if(pm == null){
				pm = BigDecimal.ZERO;
			}
			if(pm.compareTo(new BigDecimal(70)) < 0){
				abnormalDesc = 1;
			}else if(pm.compareTo(new BigDecimal(105)) > 0){
				abnormalDesc = 2;
			}
			if(abnormalDesc != 0){
				pmMap.put("abnormalName", "pm");
				pmMap.put("abnormalValue", pm);
				pmMap.put("abnormalDesc", abnormalDesc);
				list.add(pmMap);
				abnormalDesc = 0;
			}
			/* 平均动脉压 end */

			/* 血管硬化指数begin */
			Map<String,Object> siMap = new HashMap<String, Object>();
			BigDecimal si = oppg.getSi();
			if(si == null){
				si = BigDecimal.ZERO;
			}
			if(si.compareTo(new BigDecimal(0)) < 0){
				abnormalDesc = 1;
			}else if(si.compareTo(new BigDecimal(8)) > 0){
				abnormalDesc = 2;
			}
			if(abnormalDesc != 0){
				siMap.put("abnormalName", "si");
				siMap.put("abnormalValue", si);
				siMap.put("abnormalDesc", abnormalDesc);
				list.add(siMap);
				abnormalDesc = 0;
			}
			/* 血管硬化指数 end */
			return list;
		}else{
			return null;
		}
	}
	
	/**
	 * @Description: 转化测量数据
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月17日 
	 */
	public List<Map<String, Object>> getMeasureDate(List<Map<String, Object>> list)throws Exception{
		for(Map<String, Object> map : list){
			Date testTime = (Date)map.get("testTime");
			if(testTime != null){
				Calendar c = Calendar.getInstance(); 
			    c.setTime(testTime);
			    int hour = c.get(Calendar.HOUR_OF_DAY);
			    int minute = c.get(Calendar.MINUTE);
			    String realMinute = "";
			    if(minute < 10){
			    	if(minute == 0){
			    		realMinute = "00";
			    	}else{
			    		realMinute = "0" + minute;
			    	}
			    }else{
			    	realMinute = String.valueOf(minute);
			    }
			    String time = hour + ":" + realMinute;
				map.put("realTime", time);
				String measTime = TimeUtil.formatDatetime2(testTime);
				map.put("testTime", measTime);
				String analysisResult = (String)map.get("analysisResult");
				String eventType = (String)map.get("eventType");
				String analysisResultStr = "";
				if(StringUtils.isEmpty(analysisResult) == false && StringUtils.isEmpty(eventType) == false){
					int analysisResultNew = Integer.valueOf(analysisResult);
					int eventTypeNew = Integer.valueOf(eventType);
					if(eventTypeNew == 1){
						//分析血压数据异常状态 0 正常1 低血压2 高度高血压3 中度高血压4 轻度高血压5 单纯收缩高血压
						if(analysisResultNew == 0){
							analysisResultStr = "正常";
						}else if(analysisResultNew == 1){
							analysisResultStr = "低血压";
						}else if(analysisResultNew == 2){
							analysisResultStr = "高度高血压";
						}else if(analysisResultNew == 3){
							analysisResultStr = "中度高血压";
						}else if(analysisResultNew == 4){
							analysisResultStr = "轻度高血压";
						}else if(analysisResultNew == 5){
							analysisResultStr = "单纯收缩高血压";
						}
						map.put("analysisResultStr", analysisResultStr);
					}else if(eventTypeNew == 2){
						//分析结果值(1:血糖偏低;2:血糖偏高;0：正常)
						if(analysisResultNew == 0){
							analysisResultStr = "正常";
						}else if(analysisResultNew == 1){
							analysisResultStr = "偏低";
						}else if(analysisResultNew == 2){
							analysisResultStr = "偏高";
						}
						map.put("analysisResultStr", analysisResultStr);
					}
				}
				
				String timePeriod = (String)map.get("timePeriod");
				String timePeriodStr = "";
				if(StringUtils.isEmpty(timePeriod) == false && StringUtils.isEmpty(eventType) == false){
					int timePeriodNew = Integer.valueOf(timePeriod);
					int eventTypeNew = Integer.valueOf(eventType);
					timePeriodStr = convertTimePeriod(timePeriodNew,eventTypeNew);
					map.put("timePeriodStr", timePeriodStr);
				}
				
			}
		}
		return list;
	}
	
	/**
	 * @Description: 转化oppg属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月24日 
	 */
	public Map<String,Object> convertOppg(Oppg oppg)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("docentry", oppg.getDocentry());
		map.put("eventId", oppg.getEventid());
		map.put("memberId", oppg.getMemberid());
		map.put("timeLength", oppg.getTimelength());
		Date dateUpload = oppg.getUploadtime();
		if(dateUpload != null){
			map.put("uploadTime", TimeUtil.formatDatetime2(dateUpload));
		}
		Date dateMeas = oppg.getMeasuretime();
		if(dateMeas != null){
			map.put("testTime", TimeUtil.formatDatetime2(dateMeas));
		}
		map.put("pulseBeatCount", oppg.getPulsebeatcount());
		map.put("slowPulse", oppg.getSlowpulse());
		map.put("slowTime", oppg.getSlowtime());
		map.put("quickPulse", oppg.getQuickpulse());
		map.put("quickTime", oppg.getQuicktime());
		map.put("pulseRate", oppg.getPulserate());
		map.put("spo", oppg.getSpo());
		map.put("spo1", oppg.getSpo1());
		map.put("co", oppg.getCo());
		map.put("si", oppg.getSi());
		map.put("sv", oppg.getSv());
		map.put("ci", oppg.getCi());
		map.put("spi", oppg.getSpi());
		map.put("k", oppg.getK());
		map.put("k1", oppg.getK1());
		map.put("v", oppg.getV());
		map.put("tpr", oppg.getTpr());
		map.put("pwtt", oppg.getPwtt());
		map.put("pm", oppg.getPm());
		map.put("ac", oppg.getAc());
		map.put("imageNum", oppg.getImagenum());
		map.put("prlevel", oppg.getPrlevel());
		map.put("klevel", oppg.getKlevel());
		map.put("svlevel", oppg.getSvlevel());
		map.put("colevel", oppg.getColevel());
		map.put("aclevel", oppg.getAclevel());
		map.put("silevel", oppg.getSilevel());
		map.put("vlevel", oppg.getVlevel());
		map.put("tprlevel", oppg.getTprlevel());
		map.put("spolevel", oppg.getSpolevel());
		map.put("cilevel", oppg.getCilevel());
		map.put("spilevel", oppg.getSpilevel());
		map.put("pwttlevel", oppg.getPwttlevel());
		map.put("ppgRr", oppg.getPpgrr());
		map.put("rawPpg", oppg.getRawppg());
		map.put("bluetoothMacAddr", oppg.getBluetoothmacaddr());
		map.put("deviceCode", oppg.getDevicecode());
		map.put("icount", oppg.getIcount());
		map.put("addValue", oppg.getAddvalue());
		map.put("fs", oppg.getFs());
		map.put("ppgResult", oppg.getPpgresult());
		map.put("statusTag", oppg.getStatustag());
		map.put("delTag", oppg.getDeltag());
		map.put("tableNum", oppg.getTableNum());
		map.put("oppgAbnormal", getAbnormalOppgDataList(oppg));
		return map;
	}
	
	/**
	 * @Description: 转化oecg属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月24日 
	 */
	public Map<String,Object> convertOecg(Oecg oecg)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("docentry", oecg.getDocentry());
		map.put("eventId", oecg.getEventid());
		map.put("memberId", oecg.getMemberid());
		map.put("timeLength", oecg.getTimelength());
		Date dateUpload = oecg.getUploadtime();
		if(dateUpload != null){
			map.put("uploadTime", TimeUtil.formatDatetime2(dateUpload));
		}
		Date dateMeas = oecg.getMeastime();
		if(dateMeas != null){
			map.put("testTime", TimeUtil.formatDatetime2(dateMeas));
		}
		Date dateEcg = oecg.getEcgtime();
		if(dateEcg != null){
			map.put("ecgTime", TimeUtil.formatDatetime2(dateEcg));
		}
		map.put("imageNum", oecg.getImagenum());
		map.put("heartNum", oecg.getHeartnum());
		map.put("slowestBeat", oecg.getSlowestbeat());
		map.put("slowestTime", oecg.getSlowesttime());
		map.put("fastestBeat", oecg.getFastestbeat());
		map.put("fastestTime", oecg.getFastestbeat());
		map.put("averageHeart", oecg.getAverageheart());
		map.put("sdnn", oecg.getSdnn());
		map.put("pnn50", oecg.getPnn50());
		map.put("hrvi", oecg.getHrvi());
		map.put("rmssd", oecg.getRmssd());
		map.put("tp", oecg.getTp());
		map.put("vlf", oecg.getVlf());
		map.put("lf", oecg.getLf());
		map.put("hf", oecg.getHf());
		map.put("lfHf", oecg.getLfHf());
		map.put("sd1", oecg.getSd1());
		map.put("sd2", oecg.getSd2());
		map.put("icount", oecg.getIcount());
		map.put("fs", oecg.getFs());
		map.put("sdnnlevel", oecg.getSdnnlevel());
		map.put("pnn50level", oecg.getPnn50level());
		map.put("hrvilevel", oecg.getHrvilevel());
		map.put("rmssdlevel", oecg.getRmssdlevel());
		map.put("tplevel", oecg.getTplevel());
		map.put("vlflevel", oecg.getVlflevel());
		map.put("lflevel", oecg.getLflevel());
		map.put("hflevel", oecg.getHflevel());
		map.put("lhrlevel", oecg.getLhrlevel());
		map.put("hrlevel", oecg.getHrlevel());
		map.put("addValue", oecg.getAddvalue());
		map.put("deviceCode", oecg.getDevicecode());
		map.put("bluetoothMacAddr", oecg.getBluetoothmacaddr());
		map.put("rawEcgImg", oecg.getRawecgimg());
		map.put("freqPsd", oecg.getFreqpsd());
		map.put("rrInterval", oecg.getRrinterval());
		map.put("rawEcg", oecg.getRawecg());
		map.put("delTag", oecg.getDeltag());
		map.put("ecgResult", oecg.getEcgresult());
		map.put("statuStag", oecg.getStatustag());
		map.put("tableNum", oecg.getTableNum());
		map.put("dataType", oecg.getDataType());
		map.put("oecgAbnormal", getAbnormalOecgDataList(oecg));
		return map;
	}
	
	/**
	 * @Description: 转化测量时间点属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月24日 
	 */
	public static String convertTimePeriod(Integer timePeriod,Integer eventType)throws Exception{
		String str = "";
		if(eventType == 1){
			//血压测量时间段 0 其他时间段 1 起床后2小时 2 睡觉前
			if(timePeriod == 0){
				str = "随机";
			}else if(timePeriod == 1){
				str = "起床后2小时";
			}else if(timePeriod == 2){
				str = "睡觉前";
			}
		}else if(eventType == 2){
			//血糖测量时间段0 其他随机时间段1 早晨空腹2 早餐后2小时3 午餐前4 午餐后2小时5 晚餐前6 晚餐后2小时7 睡觉前8 夜间(下半夜)
			if(timePeriod == 0){
				str = "随机";
			}else if(timePeriod == 1){
				str = "早晨空腹";
			}else if(timePeriod == 2){
				str = "早餐后2小时";
			}else if(timePeriod == 3){
				str = "午餐前";
			}else if(timePeriod == 4){
				str = "午餐后2小时";
			}else if(timePeriod == 5){
				str = "晚餐前";
			}else if(timePeriod == 6){
				str = "晚餐后2小时";
			}else if(timePeriod == 7){
				str = " 睡觉前";
			}else if(timePeriod == 8){
				str = "夜间";
			}
		}
		return str;
	}
	
	/**
	 * @Description: 获取心电异常数据
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月29日 
	 */
	public List<Map<String,Object>> getAbnormalOecgDataList(Oecg oecg) throws Exception{
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Long docentry = oecg.getDocentry();
		List<Ecg2> ecg2List = ecg2Service.selectEcg2ListByDocentry(docentry);
		if(ecg2List != null && ecg2List.size() > 0){
			for(Ecg2 ecg2 :ecg2List ){
				Map<String,Object> map = new HashMap<String, Object>();
				int abnnum = ecg2.getAbnnum();
				map.put("abnnum", abnnum);
				map.put("abnname", ecg2.getAbnname());
				map.put("docentry", docentry);
				Ecg1Example example = new Ecg1Example();
				com.bithealth.measureCore.electrocardio.model.Ecg1Example.Criteria criteria = example.createCriteria();
				criteria.andDocentryEqualTo(docentry);
				criteria.andLinenumEqualTo((short)abnnum);
				List<Ecg1> ecg1List = findAnomalyEcgbyId(docentry,ecg2.getAbnname());
				if(ecg1List != null && ecg1List.size() > 0){
					map.put("anomalyEcg", ecg1List);
				}
				list.add(map);
			}
		}
		return list;
	}
	
	/**
	 * @Description: 获取心电异常数据
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月29日 
	 */
	public List<Ecg1> findAnomalyEcgbyId(long docentry, String name)throws Exception {
		List<Ecg1> ecg1List = new ArrayList<Ecg1>();
		String abnTypeName = getAbnTypeName(name);
		Ecg1Example example = new Ecg1Example();
		com.bithealth.measureCore.electrocardio.model.Ecg1Example.Criteria criteria = example.createCriteria();
		criteria.andDocentryEqualTo(docentry);
		criteria.andAbecgtypeLike("%" + abnTypeName + "%");
		ecg1List = ecg1Service.selectByExample(example);
		return ecg1List;
	}
	
	/**
	 * @Description: 获取心电异常类型名
	 * @author:      liuxiaoqin
	 * @param        
	 * @version      V1.0  
	 * @Createdate:  2016年8月29日 
	 */
	private String getAbnTypeName(String name)throws Exception{
		if ("Polycardia".equals(name)) {
			name = "ST";
		} else if ("Bradycardia".equals(name)) {
			name = "SB";
		} else if ("Arrest".equals(name)) {
			name = "SA";
		} else if ("Missed".equals(name)) {
			name = "MB";
		} else if ("Wide".equals(name)) {
			name = "WS";
		} else if ("PVB".equals(name)) {
			name = "VPB";
		} else if ("PAB".equals(name)) {
			name = "APB";
		} else if ("Insert_PVB".equals(name)) {
			name = "IVBP";
		} else if ("VT".equals(name)) {
			name = "VT";
		} else if ("Bigeminy".equals(name)) {
			name = "BG";
		} else if ("Trigeminy".equals(name)) {
			name = "TRG";
		} else if ("Arrhythmia".equals(name)) {
			name = "AR";
		}
		return name;
	}
	
	/**
	 * @Description: 转化血压osbp属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年9月21日 
	 */
	public Map<String,Object> convertOsbp(Osbp osbp)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("docentry", osbp.getDocentry());
		map.put("eventId", osbp.getEventid());
		map.put("bluetoothMacAddr", osbp.getBluetoothmacaddr());
		map.put("deviceCode", osbp.getDevicecode());
		map.put("memberId", osbp.getMemberid());
		Date dateTest = osbp.getTesttime();
		if(dateTest != null){
			map.put("testTime", TimeUtil.formatDatetime2(dateTest));
		}
		Date dateUpload = osbp.getUploadtime();
		if(dateUpload != null){
			map.put("uploadTime", TimeUtil.formatDatetime2(dateUpload));
		}
		map.put("pulseRate", osbp.getPulserate());
		String timePeriod = osbp.getTimeperiod();
		map.put("timePeriod", timePeriod);
		map.put("timePeriodStr", convertTimePeriod(Integer.valueOf(timePeriod),1));
		map.put("abnormal", osbp.getAbnormal());
		map.put("sbp", osbp.getSbp());
		map.put("dbp", osbp.getDbp());
		return map;
	}
	
	/**
	 * @Description: 转化血压obsr属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年9月21日 
	 */
	public Map<String,Object> convertObsr(Obsr obsr)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("docentry", obsr.getDocentry());
		map.put("eventId", obsr.getEventid());
		map.put("bluetoothMacAddr", obsr.getBluetoothmacaddr());
		map.put("deviceCode", obsr.getDevicecode());
		map.put("memberId", obsr.getMemberid());
		Date dateTest = obsr.getTesttime();
		if(dateTest != null){
			map.put("testTime", TimeUtil.formatDatetime2(dateTest));
		}
		Date dateUpload = obsr.getUploadtime();
		if(dateUpload != null){
			map.put("uploadTime", TimeUtil.formatDatetime2(dateUpload));
		}
		map.put("bsValue", obsr.getBsvalue());
		String timePeriod = obsr.getTimeperiod();
		map.put("timePeriod", timePeriod);
		map.put("timePeriodStr", convertTimePeriod(Integer.valueOf(timePeriod),2));
		map.put("analysisResult", obsr.getAnalysisresult());
		return map;
	}
	
}
