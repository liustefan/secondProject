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
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.cmsCore.facede.CmsFacedeService;
import com.bithealth.cmsCore.model.Advertisement;
import com.bithealth.cmsCore.model.AdvertisementExample;
import com.bithealth.cmsCore.model.HealthnewsBookmark;
import com.bithealth.cmsCore.model.HealthnewsBookmarkExample;
import com.bithealth.cmsCore.model.HealthnewsInfo;
import com.bithealth.cmsCore.model.HealthnewsInfoExample;
import com.bithealth.cmsCore.model.HealthnewsLable;
import com.bithealth.cmsCore.model.HealthnewsLableExample;
import com.bithealth.cmsCore.model.HealthnewsPraise;
import com.bithealth.cmsCore.model.HealthnewsPraiseExample;
import com.bithealth.cmsCore.model.InfoLabel;
import com.bithealth.cmsCore.model.MemberLabel;
import com.bithealth.cmsCore.model.MemberLabelExample;
import com.bithealth.cmsCore.service.AdvertisementService;
import com.bithealth.cmsCore.service.HealthnewsBookmarkService;
import com.bithealth.cmsCore.service.HealthnewsInfoService;
import com.bithealth.cmsCore.service.HealthnewsLableService;
import com.bithealth.cmsCore.service.HealthnewsPraiseService;
import com.bithealth.cmsCore.service.InfoLabelService;
import com.bithealth.cmsCore.service.MemberLabelService;
import com.bithealth.model.AppUser;
import com.bithealth.sdk.core.entity.JSONResult;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.util.MessageUtil;
import com.bithealth.util.TimeUtil;

/**
 * @PackageName: com.bithealth.controller
 * @FileName:    InformationController.java  
 * @Description: 资讯功能  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuxiaoqin
 * @version      V1.0  
 * @Createdate:  2016年7月28日 
 */
@Controller
@RequestMapping(value = "/information")
public class InformationController extends BaseSpringController{
	
	@Resource
    private HealthnewsLableService healthnewsLableService;
	
	@Resource
    private AdvertisementService advertisementService;
	
	@Resource
    private CmsFacedeService cmsFacedeService;
	
	@Resource
    private HealthnewsBookmarkService healthnewsBookmarkService;
	
	@Resource
    private HealthnewsPraiseService healthnewsPraiseService;
	
	@Resource
    private MemberLabelService memberLabelService;
	
	@Resource
    private InfoLabelService infoLabelService;
	
	@Resource
    private HealthnewsInfoService healthnewsInfoService;
	
	/**
	 * @Description: 分页条件查询资讯列表
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月10日 
	 */
	@RequestMapping(value = "/findInformationListByParam", method = RequestMethod.POST)
    public void selectInformationListByParam(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	Integer pageNow = StrObject.getInteger("pageNow");
    	Integer pageSize = StrObject.getInteger("pageSize");
    	try{
    		//已发布或者已推送
    		Byte[] status = {2,3};
    		List<Byte> statustype = new ArrayList<Byte>();
    		for(Byte i : status){
    			statustype.add(i);
    		}
    		/* 我感兴趣的资讯 */
    		List<Integer> myLableIds = new ArrayList<Integer>();
    		String labels = StrObject.getString("labels");
    		if(!StringUtils.isEmpty(labels)){
    			String[] arr = labels.split(",");
    			for(String lable : arr){
    				myLableIds.add(Integer.valueOf(lable));
    			}
    		}
    		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
			/* 查询全部资讯 begin*/
    		Page<HealthnewsInfo> pageNew = new Page<HealthnewsInfo>();
			Page<HealthnewsInfo> page = new Page<HealthnewsInfo>(pageNow,pageSize);
			HealthnewsInfoExample example = new HealthnewsInfoExample();
			com.bithealth.cmsCore.model.HealthnewsInfoExample.Criteria criteria = example.createCriteria();
			criteria.andStatustypeIn(statustype);
			if(myLableIds != null && myLableIds.size() > 0){
				criteria.andHNLabelIDIn(myLableIds);
				example.setOrderByClause("IsStickyPost DESC, UpdateTime DESC ,CreateTime DESC");
				pageNew = cmsFacedeService.selectNewsInfoList(page, example);
			}else{
				example.setOrderByClause("IsStickyPost DESC, UpdateTime DESC ,CreateTime DESC");
				pageNew = cmsFacedeService.selectNewsInfoPage(page, example);
			}
			if(pageNew != null && pageNew.getResult() != null && pageNew.getResult().size()>0){
				for(HealthnewsInfo info : pageNew.getResult()){
					Map<String,Object> map = convertHealthnewsInfo(info,user.getUserId());
					mapList.add(map);
				}
			}
			/* 查询全部资讯 end*/
    		if(mapList != null && mapList.size() > 0){
    			value.setData(mapList);
    			value.setStatusCode(0);
    			value.setMessage("分页条件查询资讯列表成功");
    			logger.info("分页条件查询资讯列表成功！");
    			value.setSuccess(true);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("没有资讯记录 ");
    			logger.info("没有资讯记录");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("获取资讯列表异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 分页条件查询标签列表
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月10日 
	 */
	@RequestMapping(value = "/findAllLables", method = RequestMethod.POST)
    public void selectAllLables(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
		JSONResult<Object> value = new JSONResult<Object>();
    	Integer pageNow = 1;
    	Integer pageSize = 20;
    	try{
    		Map<String,Object> map = new HashMap<String, Object>();
    		/* 查询全部标签 begin  */
    		Byte statusType = 2;
    		HealthnewsLableExample example = new HealthnewsLableExample();
    		Page<HealthnewsLable> page = new Page<HealthnewsLable>(pageNow,pageSize);
    		com.bithealth.cmsCore.model.HealthnewsLableExample.Criteria criteria = example.createCriteria();
    		criteria.andStatustypeEqualTo(statusType);
    		example.setOrderByClause("CreateTime Desc");
    		Page<HealthnewsLable> pages = cmsFacedeService.selectLablePage(page, example);
    		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
    		if(pages != null && pages.getResult() != null && pages.getResult().size()>0){
    			for(HealthnewsLable lable : pages.getResult()){
    				Map<String,Object> mapNew = convertHealthnewsLable(lable);
    				mapList.add(mapNew);
    			}
    		}
    		/* 查询全部标签 end  */
    		
    		/* 查询我的标签 begin  */
    		List<Integer> myLableIds = getMyLables(user.getUserId());
    		/* 查询我的标签 end  */
    		
    		map.put("allLables", mapList);
    		map.put("myLableIds", myLableIds);
    		if(map.isEmpty() == false && map != null){
    			value.setData(map);
    			value.setStatusCode(0);
    			value.setMessage("分页条件查询标签列表成功");
    			logger.info("分页条件查询标签列表成功！");
    			value.setSuccess(true);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("没有标签记录 ");
    			logger.info("没有标签记录");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("获取标签列表异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 分页条件查询我收藏的资讯列表
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月10日 
	 */
	@RequestMapping(value = "/findMyCollectInformation", method = RequestMethod.POST)
    public void selectMyCollectInformation(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
		JSONResult<Object> value = new JSONResult<Object>();
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	Integer pageNow = StrObject.getInteger("pageNow");
    	Integer pageSize = StrObject.getInteger("pageSize");
    	try{
    		Page<HealthnewsBookmark> page = new Page<HealthnewsBookmark>(pageNow,pageSize);
    		HealthnewsBookmarkExample example = new HealthnewsBookmarkExample();
    		com.bithealth.cmsCore.model.HealthnewsBookmarkExample.Criteria criteria = example.createCriteria();
    		criteria.andMemberidEqualTo(user.getUserId());
    		example.setOrderByClause("HNInfoID DESC");
    		List<HealthnewsBookmark> pages = healthnewsBookmarkService.selectByExampleAndPage(page, example);
    		if(pages != null && pages.size()>0){
    			List<Map<String,Object>> mapList = convertHealthnewsBookmark(pages);
    			value.setData(mapList);
    			value.setStatusCode(0);
    			value.setMessage("分页条件查询我收藏的资讯列表成功");
    			logger.info("分页条件查询我收藏的资讯列表成功！");
    			value.setSuccess(true);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("没有收藏记录 ");
    			logger.info("没有收藏记录");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("分页条件查询我收藏的资讯列表异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 分页条件查询最新的广告
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月10日 
	 */
	@RequestMapping(value = "/findNewAdvertisementList", method = RequestMethod.POST)
    public void selectNewAdvertisementList(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	Integer pageNow = StrObject.getInteger("pageNow");
    	Integer pageSize = StrObject.getInteger("pageSize");
    	try{
    		Integer usepage = StrObject.getInteger("usepage");
			if(usepage == null || usepage <= 0){
	    		value.setStatusCode(1);
				value.setMessage("参数usepage【"+usepage+"】应为正整数");
				logger.info("参数usepage【"+usepage+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return;
	    	}
    		Page<Advertisement> page = new Page<Advertisement>(pageNow,pageSize);
    		AdvertisementExample example = new AdvertisementExample();
    		com.bithealth.cmsCore.model.AdvertisementExample.Criteria criteria = example.createCriteria();
    		criteria.andStatustypeEqualTo((byte)2);
    		int newUsepage = usepage;
    		criteria.andUsepageEqualTo((byte)newUsepage);
    		example.setOrderByClause("UpdateTime DESC , CreateTime DESC");
    		Page<Advertisement> list = cmsFacedeService.slectAdvertPage(page, example);
    		if(list != null && list.getResult() != null && list.getResult().size()>0){
    			List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
    			for(Advertisement adver : list.getResult()){
    				Map<String,Object> map = convertAdvertisement(adver);
    				mapList.add(map);
    			}
    			value.setData(mapList);
    			value.setStatusCode(0);
    			value.setMessage("分页条件查询最新的广告成功");
    			logger.info("分页条件查询最新的广告成功！");
    			value.setSuccess(true);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("没有广告记录 ");
    			logger.info("没有广告记录");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("分页条件查询最新的广告异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 查询广告明细
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月11日 
	 */
	@RequestMapping(value = "/findAdvertisementDetail", method = RequestMethod.GET)
    public ModelAndView selectAdvertisementDetail(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ModelAndView mav = new ModelAndView();
		JSONResult<Object> value = new JSONResult<Object>();
		try{
    		String aidStr = request.getParameter("aid");
    		if(StringUtils.isEmpty(aidStr) == true || Integer.valueOf(aidStr) <= 0){
    			PrintWriter out = response.getWriter();
	    		value.setStatusCode(1);
				value.setMessage("参数aid【"+aidStr+"】应为正整数");
				logger.info("参数aid【"+aidStr+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return null;
    		}
    		Integer aid = Integer.valueOf(aidStr);
			Advertisement ad = advertisementService.selectById(aid);
    		if(ad != null){
    			Map<String,Object> map = convertAdvertisement(ad);
    			mav.addObject("data", map);
    			mav.setViewName("advertisement"); 
    			return mav;
    		}else{
    			mav.addObject("data", null);
    			mav.setViewName("advertisement"); 
    			return mav;
    		}
    	}catch(Exception e){
    		PrintWriter out = response.getWriter();
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("查询广告明细异常"+e);
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return null;
    	}
	}
	
	/**
	 * @Description: 查询资讯明细
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月29日 
	 */
	@RequestMapping(value = "/findInformationDetail", method = RequestMethod.GET)
    public ModelAndView selectInformationDetail(HttpServletRequest request,HttpServletResponse response) throws IOException{
		ModelAndView mav = new ModelAndView();
		JSONResult<Object> value = new JSONResult<Object>();
    	try{
    		String memberIdStr = request.getParameter("memberId");
    		if(StringUtils.isEmpty(memberIdStr) == true || Integer.valueOf(memberIdStr) <= 0){
    			PrintWriter out = response.getWriter();
	    		value.setStatusCode(1);
				value.setMessage("参数memberId【"+memberIdStr+"】应为正整数");
				logger.info("参数memberId【"+memberIdStr+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return null;
    		}
    		Integer memberId = Integer.valueOf(memberIdStr);
    		String hninfoidStr = request.getParameter("hninfoid");
    		if(StringUtils.isEmpty(hninfoidStr) == true || Integer.valueOf(hninfoidStr) <= 0){
    			PrintWriter out = response.getWriter();
	    		value.setStatusCode(1);
				value.setMessage("参数hninfoid【"+hninfoidStr+"】应为正整数");
				logger.info("参数hninfoid【"+hninfoidStr+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return null;
    		}
    		Integer hninfoid = Integer.valueOf(hninfoidStr);
			HealthnewsInfo info = cmsFacedeService.selectNewsIngfoById(hninfoid);
    		if(info != null && info.getStatustype() != 4){
    			Map<String,Object> map = convertHealthnewsInfo(info,memberId);
    			mav.addObject("data", map);
    			mav.setViewName("information"); 
    			return mav;
    		}else{
    			mav.addObject("data", null);
    			mav.setViewName("deleted"); 
    			return mav;
    		}
    	}catch(Exception e){
    		PrintWriter out = response.getWriter();
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("查询广告明细异常"+e);
			value.setSuccess(false);
			out.write(JSON.toJSONString(value));
			return null;
    	}
	}
	
	/**
	 * @Description: 给资讯点赞
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月27日 
	 */
	@RequestMapping(value = "/addALikeToInformation", method = RequestMethod.POST)
    public void insertALikeToInformation(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	try{
    		Integer hninfoid = StrObject.getInteger("hninfoid");
			if(hninfoid == null || hninfoid <= 0){
	    		value.setStatusCode(1);
				value.setMessage("参数hninfoid【"+hninfoid+"】应为正整数");
				logger.info("参数hninfoid【"+hninfoid+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return;
	    	}
			HealthnewsPraise praise = new HealthnewsPraise();
			praise.setHNInfoID(hninfoid);
			praise.setMemberID(user.getUserId());
			praise.setUpdateTime(new Date());
			int count = healthnewsPraiseService.insert(praise);
    		if(count > 0){
    			value.setStatusCode(0);
    			value.setMessage("给资讯点赞成功");
    			logger.info("给资讯点赞成功！");
    			value.setSuccess(true);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("给资讯点赞失败 ");
    			logger.info("给资讯点赞失败");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.insert.data"));
			logger.info("给资讯点赞异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 给资讯取消赞
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月27日 
	 */
	@RequestMapping(value = "/cancelALikeToInformation", method = RequestMethod.POST)
    public void deleteALikeToInformation(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	try{
    		Integer hninfoid = StrObject.getInteger("hninfoid");
			if(hninfoid == null || hninfoid <= 0){
	    		value.setStatusCode(1);
				value.setMessage("参数hninfoid【"+hninfoid+"】应为正整数");
				logger.info("参数hninfoid【"+hninfoid+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return;
	    	}
			HealthnewsPraiseExample example = new HealthnewsPraiseExample();
			com.bithealth.cmsCore.model.HealthnewsPraiseExample.Criteria criteria = example.createCriteria();
			criteria.andHNInfoIDEqualTo(hninfoid);
			criteria.andMemberIDEqualTo(user.getUserId());
			int count = healthnewsPraiseService.deleteByExample(example);
    		if(count > 0){
    			value.setStatusCode(0);
    			value.setMessage("给资讯取消赞成功");
    			logger.info("给资讯取消赞成功！");
    			value.setSuccess(true);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("给资讯取消赞失败 ");
    			logger.info("给资讯取消赞失败");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.delete.data"));
			logger.info("给资讯取消赞异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 收藏资讯
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月27日 
	 */
	@RequestMapping(value = "/addACollectToInformation", method = RequestMethod.POST)
    public void insertACollectToInformation(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	try{
    		Integer hninfoid = StrObject.getInteger("hninfoid");
			if(hninfoid == null || hninfoid <= 0){
	    		value.setStatusCode(1);
				value.setMessage("参数hninfoid【"+hninfoid+"】应为正整数");
				logger.info("参数hninfoid【"+hninfoid+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return;
	    	}
			HealthnewsBookmark mark = new HealthnewsBookmark(); 
			mark.setHninfoid(hninfoid);
			mark.setMemberid(user.getUserId());
			mark.setUpdatetime(new Date());
			int count = healthnewsBookmarkService.insert(mark);
    		if(count > 0){
    			value.setStatusCode(0);
    			value.setMessage("收藏资讯成功");
    			logger.info("收藏资讯成功！");
    			value.setSuccess(true);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("收藏资讯失败 ");
    			logger.info("收藏资讯失败");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.insert.data"));
			logger.info("收藏资讯异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 取消收藏资讯
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月27日 
	 */
	@RequestMapping(value = "/cancelACollectToInformation", method = RequestMethod.POST)
    public void deleteACollectToInformation(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	try{
    		Integer hninfoid = StrObject.getInteger("hninfoid");
			if(hninfoid == null || hninfoid <= 0){
	    		value.setStatusCode(1);
				value.setMessage("参数hninfoid【"+hninfoid+"】应为正整数");
				logger.info("参数hninfoid【"+hninfoid+"】应为正整数");
				value.setSuccess(false);
				out.write(JSON.toJSONString(value));
				return;
	    	}
			HealthnewsBookmarkExample example = new HealthnewsBookmarkExample();
			com.bithealth.cmsCore.model.HealthnewsBookmarkExample.Criteria criteria = example.createCriteria();
			criteria.andHninfoidEqualTo(hninfoid);
			criteria.andMemberidEqualTo(user.getUserId());
			int count = healthnewsBookmarkService.deleteByExample(example);
    		if(count > 0){
    			value.setStatusCode(0);
    			value.setMessage("取消收藏资讯成功");
    			logger.info("取消收藏资讯成功！");
    			value.setSuccess(true);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("取消收藏资讯失败 ");
    			logger.info("取消收藏资讯失败");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.delete.data"));
			logger.info("取消收藏资讯异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 修改我感兴趣的标签
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月10日 
	 */
	@RequestMapping(value = "/updateMyLables", method = RequestMethod.POST)
    public void updateMyLables(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		String appUser = (String)request.getAttribute("appUserStr");
    	AppUser user = JSON.parseObject(appUser, AppUser.class);
		JSONResult<Object> value = new JSONResult<Object>();
    	String otherParam = (String)request.getAttribute("otherParamStr");
    	JSONObject StrObject = JSON.parseObject(otherParam);
    	try{
    		Integer memberId = user.getUserId();
    		String lableIds = StrObject.getString("lableIds");
    		Integer[] myLableIds = null;
    		if(!StringUtils.isEmpty(lableIds)){
    			String[] ids = lableIds.split(",");
    			myLableIds = new Integer[ids.length];
    			for(int i=0; i<ids.length; i++){  
    				myLableIds[i] = Integer.parseInt(ids[i]); 
    			}
	    	}
    		boolean count = cmsFacedeService.saveMemberLable(memberId,myLableIds);
    		if(count == false){
    			value.setStatusCode(0);
    			value.setMessage("修改我感兴趣的标签成功");
    			logger.info("修改我感兴趣的标签成功！");
    			value.setSuccess(true);
    		}else{
    			value.setStatusCode(3);
    			value.setMessage("修改我感兴趣的标签失败 ");
    			logger.info("修改我感兴趣的标签失败");
    			value.setSuccess(false);
    		}
    	}catch(Exception e){
    		value.setStatusCode(2);
    		value.setMessage(MessageUtil.getValue("error.update.data"));
			logger.info("修改我感兴趣的标签异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
	/**
	 * @Description: 转化资讯HealthnewsInfo属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月26日 
	 */
	public Map<String,Object> convertHealthnewsInfo(HealthnewsInfo info,Integer memberId)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		Integer hninfoid = info.getHninfoid();
		map.put("hninfoid", hninfoid);
		map.put("title", info.getTitle());
		map.put("author", info.getAuthor());
		map.put("thumbnail", info.getThumbnail());
		map.put("coverimage", info.getCoverimage());
		map.put("content", info.getContent());
		map.put("delreason", info.getDelreason());
		map.put("createid", info.getCreateid());
		map.put("updateid", info.getUpdateid());
		map.put("isstickypost", info.getIsstickypost());
		String date = "";
		Date updateDate = info.getUpdatetime();
		if(updateDate != null){
			map.put("updatetime", TimeUtil.formatDatetime2(updateDate));
			date = TimeUtil.formatDate(updateDate);
		}
		Date createDate = info.getCreatetime();
		if(createDate != null){
			map.put("createtime", TimeUtil.formatDatetime2(createDate));
			if(StringUtils.isEmpty(date)){
				date = TimeUtil.formatDate(createDate);
			}
		}
		map.put("date", date);
		map.put("praiseNumber", countHealthnewsPraise(hninfoid));
		map.put("collectNumber", countHealthnewsCollect(hninfoid));
		map.put("hasCollected", validHasCollectedHealthnews(hninfoid,memberId));
		map.put("hasPraised", validHasPraisedHealthnews(hninfoid,memberId));
		return map;
	}
	
	/**
	 * @Description: 转化标签HealthnewsLable属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月26日 
	 */
	public Map<String,Object> convertHealthnewsLable(HealthnewsLable lable)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("hnlabelid", lable.getHnlabelid());
		map.put("content", lable.getContent());
		map.put("createid", lable.getCreateid());
		map.put("updateid", lable.getUpdateid());
		String date = "";
		Date updateDate = lable.getUpdatetime();
		if(updateDate != null){
			map.put("updatetime", TimeUtil.formatDatetime2(updateDate));
			date = TimeUtil.formatDate(updateDate);
		}
		Date createDate = lable.getCreatetime();
		if(createDate != null){
			map.put("createtime", TimeUtil.formatDatetime2(createDate));
			if(StringUtils.isEmpty(date)){
				date = TimeUtil.formatDate(createDate);
			}
		}
		map.put("date", date);
		return map;
	}
	
	
	/**
	 * @Description: 转化广告Advertisement属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月26日 
	 */
	public Map<String,Object> convertAdvertisement(Advertisement adver)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("aid", adver.getAid());
		map.put("title", adver.getTitle());
		map.put("coverimage", adver.getCoverimage());
		map.put("content", adver.getContent());
		map.put("usepage", adver.getUsepage());
		map.put("createid", adver.getCreateid());
		map.put("updateid", adver.getUpdateid());
		Date date = adver.getReleasetime();
		if(date != null){
			map.put("releasetime", TimeUtil.formatDatetime2(date));
		}
		Date updateDate = adver.getUpdatetime();
		if(updateDate != null){
			map.put("updatetime", TimeUtil.formatDatetime2(updateDate));
		}
		Date createDate = adver.getCreatetime();
		if(createDate != null){
			map.put("createtime", TimeUtil.formatDatetime2(createDate));
		}
		return map;
	}
	
	/**
	 * @Description: 转化我的收藏资讯HealthnewsBookmark属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月26日 
	 */
	public List<Map<String,Object>> convertHealthnewsBookmark(List<HealthnewsBookmark> pages)throws Exception{
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		for(HealthnewsBookmark mark : pages){
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("logid", mark.getLogid());
			Integer memberId = mark.getMemberid();
			map.put("memberId", memberId);
			Integer hninfoid = mark.getHninfoid();
			if(hninfoid != null && hninfoid > 0){
				/*查询资讯begin*/
				HealthnewsInfo info = cmsFacedeService.selectNewsIngfoById(hninfoid);
				if(info != null){
					map.put("title", info.getTitle());
					map.put("thumbnail", info.getThumbnail());
					Date releaseDate = info.getReleasetime();
					if(releaseDate != null){
						map.put("releaseDate", TimeUtil.formatDate(releaseDate));
						map.put("releaseTime", TimeUtil.formatDatetime2(releaseDate));
					}
				}
				/*查询资讯end*/
				
				/*查询点赞个数begin*/
				map.put("praiseNumber", countHealthnewsPraise(hninfoid));
				/*查询点赞个数end*/
				
				/*查询收藏个数begin*/
				map.put("collectNumber", countHealthnewsCollect(hninfoid));
				/*查询收藏个数end*/
			}
			map.put("hasCollected", validHasCollectedHealthnews(hninfoid,memberId));
			map.put("hasPraised", validHasPraisedHealthnews(hninfoid,memberId));
			map.put("hninfoid", mark.getHninfoid());
			Date date = mark.getUpdatetime();
			if(date != null){
				map.put("date", TimeUtil.formatDate(date));
				map.put("updatetime", TimeUtil.formatDatetime2(date));
			}
			mapList.add(map);
		}
		return mapList;
	}
	
	/**
	 * @Description: 查询收藏个数 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月27日 
	 */
	public int countHealthnewsCollect(Integer hninfoid)throws Exception{
		int count = 0;
		HealthnewsBookmarkExample example = new HealthnewsBookmarkExample();
		com.bithealth.cmsCore.model.HealthnewsBookmarkExample.Criteria criteria = example.createCriteria();
		criteria.andHninfoidEqualTo(hninfoid);
		count = healthnewsBookmarkService.countByExample(example);
		return count;
	}
	
	/**
	 * @Description: 判断是否已收藏 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月27日 
	 */
	public int validHasCollectedHealthnews(Integer hninfoid,Integer memberId)throws Exception{
		//默认未收藏
		int count = 0;
		HealthnewsBookmarkExample example = new HealthnewsBookmarkExample();
		com.bithealth.cmsCore.model.HealthnewsBookmarkExample.Criteria criteria = example.createCriteria();
		criteria.andHninfoidEqualTo(hninfoid);
		criteria.andMemberidEqualTo(memberId);
		List<HealthnewsBookmark> list = healthnewsBookmarkService.selectByExample(example);
		if(list != null && list.size() > 0){
			count = 1;
		}
		return count;
	}
	
	/**
	 * @Description: 判断是否已点赞 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月27日 
	 */
	public int validHasPraisedHealthnews(Integer hninfoid,Integer memberId)throws Exception{
		int count = 0;
		HealthnewsPraiseExample example = new HealthnewsPraiseExample();
		com.bithealth.cmsCore.model.HealthnewsPraiseExample.Criteria criteria = example.createCriteria();
		criteria.andHNInfoIDEqualTo(hninfoid);
		criteria.andMemberIDEqualTo(memberId);
		List<HealthnewsPraise> list = healthnewsPraiseService.selectByExample(example);
		if(list != null && list.size() > 0){
			count = 1;
		}
		return count;
	}
	
	/**
	 * @Description: 查询点赞个数 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月27日 
	 */
	public int countHealthnewsPraise(Integer hninfoid)throws Exception{
		int count = 0;
		HealthnewsPraiseExample example = new HealthnewsPraiseExample();
		com.bithealth.cmsCore.model.HealthnewsPraiseExample.Criteria criteria = example.createCriteria();
		criteria.andHNInfoIDEqualTo(hninfoid);
		count = healthnewsPraiseService.countByExample(example);
		return count;
	}
	
	/**
	 * @Description: 获取我的感兴趣的所有标签id 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月26日 
	 */
	public List<Integer> getMyLables(Integer memberId)throws Exception{
		List<Integer> myLables = new ArrayList<Integer>();
		MemberLabelExample memLableExample = new MemberLabelExample();
		memLableExample.createCriteria().andMemberIDEqualTo(memberId);
		List<MemberLabel> memberLableList = memberLabelService.selectByExample(memLableExample);
		if(memberLableList != null &&  memberLableList.size() >0){
			for(MemberLabel memLable : memberLableList){
				myLables.add(memLable.getHNLabelID());
			}
		}
		return myLables;
	}
	
	/**
	 * @Description: 转化我的标签和资讯属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年9月8日 
	 */
	public Map<String,Object> convertMyLablesAndInfo(InfoLabel infoLable,Integer memberId)throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		Integer infoId = infoLable.getHNInfoID();
		HealthnewsInfo info = cmsFacedeService.selectNewsIngfoById(infoId);
		if(info != null){
			map = convertHealthnewsInfo(info,memberId);
		}
		return map;
	}

}
