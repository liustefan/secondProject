package com.bithealth.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.model.AppUser;
import com.bithealth.packagCore.facade.service.PackagIFService;
import com.bithealth.packagCore.packag.model.MemberPackag;
import com.bithealth.packagCore.packag.model.Packag;
import com.bithealth.sdk.core.entity.JSONResult;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.util.MessageUtil;
import com.bithealth.util.TimeUtil;

/**
 * @PackageName: com.bithealth.controller
 * @FileName:   PackageController.java  
 * @Description: 套餐  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuxiaoqin
 * @version      V1.0  
 * @Createdate:  2016年9月26日 
 */
@Controller
@RequestMapping(value = "/package")
public class PackageController extends BaseSpringController{
	
	@Resource
    private PackagIFService packagIFService;
	
	@Resource
    private MemberService memberService;
	
	/**
	 * @Description: 获取我的套餐（已订购或者全部） 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月8日 
	 */
	@RequestMapping(value = "/findMyPackage", method = RequestMethod.POST)
    public void selectMyChatRecord(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	Integer pageNow = StrObject.getInteger("pageNow");
    	Integer pageSize = StrObject.getInteger("pageSize");
    	Integer memberId = user.getUserId();
    	try{
    		String packageType = StrObject.getString("packageType");
			if(StringUtils.isEmpty(packageType)){
	    		value.setStatusCode(1);
				value.setMessage("参数packageType【"+packageType+"】不能为空");
				logger.info("参数packageType【"+packageType+"】不能为空");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return;
	    	}
    		if(packageType.equals("order")){
    			/* 查询会员订购的套餐 begin  */
    			MemberPackag memberPackag = new  MemberPackag();
    			Page<MemberPackag> page = new Page<MemberPackag>(pageNow,pageSize);
    			memberPackag.setMemberid(memberId);
    			List<MemberPackag> list = packagIFService.selectMemberPackagListByParams(page, memberPackag);
    			if(list != null && list.size()>0){
    				List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
	    			for(MemberPackag memberPackage : list){
	    				Map<String,Object> map = convertMemberPackage(memberPackage);
	    				mapList.add(map);
	    			}
    				value.setData(mapList);
    				value.setStatusCode(0);
    				value.setMessage("查询会员订购的套餐成功");
    				logger.info("查询会员订购的套餐成功！");
    				value.setSuccess(true);
    			}else{
    				value.setStatusCode(3);
    				value.setMessage("该会员没有订购的套餐");
    				logger.info("该会员没有订购的套餐");
    				value.setSuccess(false);
    			}
    			/* 查询会员订购的套餐 end  */
    		}else{
    			/* 查询全部的套餐 begin  */
    			Page<Packag> pageNew = new Page<Packag>(pageNow,pageSize);
    			Packag packag = new Packag();
    			Member member = memberService.selectById(user.getUserId());
    			if(member != null){
    				packag.setOrgId(member.getOrgid());
    			}
    			List<Packag> listNew = packagIFService.selectPackagListByParams(pageNew, packag, false);
    			if(listNew != null && listNew.size()>0){
    				List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
	    			for(Packag packageNew : listNew){
	    				Map<String,Object> map = convertPackage(packageNew);
	    				mapList.add(map);
	    			}
    				value.setData(mapList);
    				value.setStatusCode(0);
    				value.setMessage("查询全部套餐成功");
    				logger.info("查询全部套餐成功！");
    				value.setSuccess(true);
    			}else{
    				value.setStatusCode(3);
    				value.setMessage("没有套餐");
    				logger.info("没有套餐");
    				value.setSuccess(false);
    			}
    			/* 查询全部的套餐 end  */
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("获取套餐信息异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 转化会员已订购的套餐属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年9月26日 
	 */
	public Map<String,Object> convertMemberPackage(MemberPackag memberPackage)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("memberId", memberPackage.getMemberid());
		map.put("packageCode", memberPackage.getPackageCode());
		Packag newPackage = memberPackage.getPackag();
		if(newPackage != null){
			map.put("orgId", newPackage.getOrgId());
			map.put("packageName", newPackage.getPackageName());
			map.put("packageDesc", newPackage.getPackageDesc());
			map.put("packageType", newPackage.getPackageType());
			map.put("price", newPackage.getPrice());
			map.put("packageLevel", newPackage.getPackageLevel());
			Date date = newPackage.getCreateTime();
			if(date != null){
				map.put("createTime", TimeUtil.formatDatetime2(date));
			}
			map.put("createId", newPackage.getCreateid());
			map.put("createName", newPackage.getCreateName());
			map.put("useTag", newPackage.getUseTag());
		}
		return map;
	}
	
	/**
	 * @Description: 转化所有套餐属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年9月26日 
	 */
	public Map<String,Object> convertPackage(Packag packageNew)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("packageCode", packageNew.getPackageCode());
		map.put("orgId", packageNew.getOrgId());
		map.put("packageName", packageNew.getPackageName());
		map.put("packageDesc", packageNew.getPackageDesc());
		map.put("packageType", packageNew.getPackageType());
		map.put("price", packageNew.getPrice());
		map.put("packageLevel", packageNew.getPackageLevel());
		Date date = packageNew.getCreateTime();
		if(date != null){
			map.put("createTime", TimeUtil.formatDatetime2(date));
		}
		map.put("createId", packageNew.getCreateid());
		map.put("createName", packageNew.getCreateName());
		map.put("useTag", packageNew.getUseTag());
		return map;
	}
	
}
