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
import com.bithealth.cmsCore.model.Advertisement;
import com.bithealth.cmsCore.model.AdvertisementExample;
import com.bithealth.cmsCore.service.AdvertisementService;
import com.bithealth.constants.Constants;
import com.bithealth.doctorCore.docGroup.model.DocToGroup;
import com.bithealth.doctorCore.docGroup.model.DocToGroupExample;
import com.bithealth.doctorCore.docGroup.service.DoctorToGroupService;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.memberCore.group.model.DoctorGrp;
import com.bithealth.memberCore.group.model.MemGroupExt;
import com.bithealth.memberCore.group.model.MemToGroupExample;
import com.bithealth.memberCore.group.model.MemToGroupKey;
import com.bithealth.memberCore.group.service.MemToGroupService;
import com.bithealth.memberCore.group.service.MemberGroupService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.model.AppUser;
import com.bithealth.packagCore.facade.service.PackagIFService;
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
	
	@Resource
    private MemToGroupService  memToGroupService;
	
	@Resource
    private MemberGroupService memberGroupService;
	
	@Resource
    private DoctorToGroupService doctorToGroupService;
	
	@Resource
    private AdvertisementService advertisementService;
	
	@Resource
    private DoctorService doctorService;
	
	/**
	 * @Description: 获取我的健康服务套餐（已订购或者全部） 
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
    	Byte usePage = Constants.AD_USEPAGE_HEALTH;
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
			
			
//			/* 获取我的同组织下的所有医生id   bengin*/
//			List<Integer> doctorIds = new ArrayList<Integer>();
//			Page<MemToGroupKey> page = new Page<MemToGroupKey>(1,50);
//			MemToGroupExample example = new MemToGroupExample();
//			example.createCriteria().andMemberidEqualTo(memberId);
//			List<MemToGroupKey> list = memToGroupService.selectByExampleAndPage(page, example);
//			if(list != null && list.size() >0){
//				/*获取医生分组编号  begin */
//				List<Integer> doctorGroupIds = new ArrayList<Integer>();
//				for(MemToGroupKey memberGroup : list){
//					MemGroupExt memGroupExt = memberGroupService.selectMemGrpExtById(memberGroup.getMemgrpid());
//					if(memGroupExt != null){
//						List<DoctorGrp> list1 = memGroupExt.getDoctorGrpList();
//						if(list1 != null && list1.size() >0){
//							for(DoctorGrp doctorGrp : list1){
//								doctorGroupIds.add(doctorGrp.getDoctorGrpId());
//							}
//						}
//					}
//				}
//				/*获取医生分组编号  end */
//				
//				if(doctorGroupIds != null && doctorGroupIds.size() >0){
//					/*获取医生ids  begin */
//					DocToGroupExample newExample = new DocToGroupExample();
//					newExample.createCriteria().andOdgpidIn(doctorGroupIds);
//					List<DocToGroup> list2 = doctorToGroupService.selectByExample(newExample);
//					if(list2 != null && list2.size()>0){
//						for(DocToGroup docToGroup : list2){
//							doctorIds.add(docToGroup.getDocid());
//						}
//					}
//	    			/*获取医生ids  end */
//				}
//			}
//			/* 获取我的同组织下的所有医生id   end*/
				
    		if(packageType.equals("order")){
    			/* 查询会员订购的健康服务套餐 begin  */
    			Page<Advertisement> pageHealth = new Page<Advertisement>(pageNow,pageSize);
    			AdvertisementExample exampleHealth = new AdvertisementExample();
    			exampleHealth.createCriteria().andUsepageEqualTo(usePage).andStatustypeEqualTo((byte)2);
//    			exampleHealth.createCriteria().andCreateidIn(doctorIds).andUsepageEqualTo(usePage).andStatustypeEqualTo((byte)2);
    			/*查询我所订购的套餐ids  begin */
    			//List<Integer> orderIds = new ArrayList<Integer>();
    			/*查询我所订购的套餐ids  end */
    			exampleHealth.setOrderByClause("CreateTime DESC");
    			List<Advertisement> listHealth = advertisementService.selectByExampleAndPage(pageHealth, exampleHealth);
    			if(listHealth != null && listHealth.size()>0){
    				List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
	    			for(Advertisement advertise : listHealth){
	    				Map<String,Object> map = convertPackage(advertise);
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
    			/* 查询会员订购的健康服务套餐 end  */
    		}else{
    			/* 查询全部的健康服务套餐 begin  */
    			Page<Advertisement> pageHealth = new Page<Advertisement>(pageNow,pageSize);
    			AdvertisementExample exampleHealth = new AdvertisementExample();
    			exampleHealth.createCriteria().andUsepageEqualTo(usePage).andStatustypeEqualTo((byte)2);
//    			exampleHealth.createCriteria().andCreateidIn(doctorIds).andUsepageEqualTo(usePage).andStatustypeEqualTo((byte)2);
    			exampleHealth.setOrderByClause("CreateTime DESC");
    			List<Advertisement> listHealth = advertisementService.selectByExampleAndPage(pageHealth, exampleHealth);
    			if(listHealth != null && listHealth.size()>0){
    				List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
	    			for(Advertisement advertise : listHealth){
	    				Map<String,Object> map = convertPackage(advertise);
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
    			/* 查询全部的健康服务套餐 end  */
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("获取健康服务套餐信息异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
//	/**
//	 * @Description: 转化会员已订购的健康服务套餐属性名 
//	 * @author:      liuxiaoqin
//	 * @version      V1.0  
//	 * @Createdate:  2016年9月26日 
//	 */
//	public Map<String,Object> convertMemberPackage(MemberPackag memberPackage)throws Exception{
//		Map<String,Object> map = new HashMap<String, Object>();
//		map.put("memberId", memberPackage.getMemberid());
//		map.put("packageCode", memberPackage.getPackageCode());
//		Packag newPackage = memberPackage.getPackag();
//		if(newPackage != null){
//			map.put("orgId", newPackage.getOrgId());
//			map.put("packageName", newPackage.getPackageName());
//			map.put("packageDesc", newPackage.getPackageDesc());
//			map.put("packageType", newPackage.getPackageType());
//			map.put("price", newPackage.getPrice());
//			map.put("packageLevel", newPackage.getPackageLevel());
//			Date date = newPackage.getCreateTime();
//			if(date != null){
//				map.put("createTime", TimeUtil.formatDatetime2(date));
//			}
//			map.put("createId", newPackage.getCreateid());
//			map.put("createName", newPackage.getCreateName());
//			map.put("useTag", newPackage.getUseTag());
//		}
//		return map;
//	}
	
	/**
	 * @Description: 转化所有健康服务套餐属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年9月26日 
	 */
	public Map<String,Object> convertPackage(Advertisement advertise)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("packageCode", advertise.getAid());
		map.put("packageName", advertise.getTitle());
		Date date = advertise.getReleasetime();
		if(date != null){
			map.put("createTime", TimeUtil.formatDatetime2(date));
		}
		map.put("createId", advertise.getCreateid());
		/* 获取医生名字begin  */
		Doctor doctor = doctorService.selectById(advertise.getCreateid());
		if(doctor != null){
			map.put("createName", doctor.getDocname());
		}
		/* 获取医生名字end  */
		return map;
	}
	
}
