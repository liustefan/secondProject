package com.bithealth.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.model.DoctorAccount;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.doctorCore.enmu.DeviceEnum;
import com.bithealth.doctorCore.exception.LoginException;
import com.bithealth.doctorCore.facede.service.DoctorInterfService;
import com.bithealth.model.AppUser;
import com.bithealth.sdk.core.entity.JSONResult;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.util.MessageUtil;
import com.bithealth.util.PasswordEncryption;
import com.bithealth.util.TimeUtil;

/**
 * @PackageName: com.bithealth.controller
 * @FileName:    DoctorController.java  
 * @Description: 医生操纵模块  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuxiaoqin
 * @version      V1.0  
 * @Createdate:  2016年7月28日 
 */
@Controller
@RequestMapping(value = "/doctor")
public class DoctorController extends BaseSpringController{
	
	@Resource
    private DoctorService doctorService;
	
	@Resource
    private DoctorInterfService doctorInterfService;
	
	private static Logger logger = Logger.getLogger(DoctorController.class);
	
	/**
	 * @Description: 医生登录 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月28日 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException{
		PrintWriter out = response.getWriter();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
		DeviceEnum deviceType = DeviceEnum.valueOf(user.getDeviceType());
		String password = user.getUserPassword();
		int isNewUser = 0;
		try{
			JSONResult<Object> value = new JSONResult<Object>();
			String newewUser = (String)request.getAttribute("isNewUser");
			if(StringUtils.isEmpty(newewUser)){
				password = PasswordEncryption.getMD5Password(user.getUserPassword()+"zkhk");
			}else{
				isNewUser = 1;
			}
			DoctorAccount account = new DoctorAccount();
			account.setDocacc(user.getUserAccount());
			account.setDocpass(password);
			Doctor doctor = doctorInterfService.login(account, deviceType);
			if(doctor != null){
				String userName = doctor.getDocname();
				Date logTime = doctor.getDoctorSession().getLoginTime();
				if(logTime != null){
					user.setLogTime(TimeUtil.formatDatetime2(logTime));
				}
				user.setSession(doctor.getDoctorSession().getSession());
				user.setUserId(doctor.getDocid());
				user.setUserName(userName);
				user.setUserGUID(doctor.getDocGUID());
				value.setStatusCode(0);
				value.setMessage("医生【"+userName+"】登录成功");
				logger.info("账号为【"+user.getUserAccount()+"】的医生【"+userName+"】登录成功");
				value.setSuccess(true);
				value.setData(user);
				out.write(JSON.toJSONString(value));
			}
		}catch(LoginException e){
			String code = e.getCode();
			if(code.equals(LoginException.ERROR_PWD) && isNewUser == 0){
				request.setAttribute("isNewUser", "Y");
				login(request,response);
			}else{
				JSONResult<Object> value = new JSONResult<Object>();
				String message = "doctor." + code;
				value.setStatusCode(1);
				value.setMessage(MessageUtil.getValue(message));
				logger.info(MessageUtil.getValue(message));
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
			}
		}
    }
	
	/**
	 * @Description: 医生注销 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月28日 
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
		try{
			Doctor doctor = new Doctor();
			doctor.setDocid(user.getUserId());
			doctorInterfService.logout(doctor);
    		value.setStatusCode(0);
			value.setMessage("医生【"+user.getUserName()+"】注销成功");
			logger.info("账号为【"+user.getUserAccount()+"】的医生【"+user.getUserName()+"】注销成功");
			value.setSuccess(true);
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.update.data"));
			logger.info("账号为【"+user.getUserAccount()+"】的会员【"+user.getUserName()+"】注销异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
    }
	
	/**
	 * @Description: 查看医生基本资料明细
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月28日 
	 */
	@RequestMapping(value = "/findDoctorBasicInfo", method = RequestMethod.POST)
    public void selectDoctorBasicInfo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	Integer doctorId = user.getUserId();
    	if(user.getUserType() != null && user.getUserType() == 1){
    		String otherParam = (String)request.getAttribute("otherParamStr");
    		JSONObject StrObject = JSON.parseObject(otherParam);
        	Integer docid = StrObject.getInteger("doctorId");
        	if(docid == null || docid <= 0){
        		value.setStatusCode(1);
    			value.setMessage("参数doctorId【"+doctorId+"】应为正整数");
    			logger.info("参数doctorId【"+doctorId+"】应为正整数");
    			value.setSuccess(false);
    			out.write(JSON.toJSONString(value));
    			return;
        	}else{
        		doctorId = docid;
        	}
    	}
		try{
			Doctor doctor = doctorService.selectById(doctorId);
			if(doctor != null){
				value.setStatusCode(0);
				value.setMessage("查看医生基本资料明细成功");
				logger.info("查看医生基本资料明细成功");
				value.setSuccess(true);
				value.setData(doctor);
			}else{
				value.setStatusCode(3);
				value.setMessage("没有该医生的基本资料信息");
				logger.info("没有该医生的基本资料信息");
				value.setSuccess(true);
			}
    	}catch(Exception e){
    		value.setStatusCode(2);
			value.setMessage("失败");
			value.setMessage(MessageUtil.getValue("error.select.data"));
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
    }

}
