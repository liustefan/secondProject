package com.bithealth.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.bithealth.memberCore.member.model.Disease;
import com.bithealth.memberCore.member.service.DiseaseService;
import com.bithealth.sdk.core.entity.JSONResult;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.util.MessageUtil;

/**
 * @PackageName: com.bithealth.controller
 * @FileName:    FocusController.java  
 * @Description: 关注功能  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuxiaoqin
 * @version      V1.0  
 * @Createdate:  2016年7月28日 
 */
@Controller
@RequestMapping(value = "/dictionary")
public class DictionaryController extends BaseSpringController{
	
	@Resource
    private DiseaseService diseaseService;
	
	/**
	 * @Description: 查询疾病字典 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年7月28日 
	 */
	@RequestMapping(value = "/findDiseaseDic", method = RequestMethod.POST)
    public void selectDiseaseDic(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
		try{
			List<Disease> list = diseaseService.selectAll_cache();
			if(list != null && list.size() >0){
				List<Map<String,Object>> mapList = convertDisease(list);
				if(mapList != null && mapList.size() > 0){
					value.setStatusCode(0);
					value.setMessage("获取疾病字典成功");
					logger.info("获取疾病字典成功");
					value.setSuccess(true);
					value.setData(mapList);
				}else{
					value.setStatusCode(0);
					value.setMessage(MessageUtil.getValue("error.select.data"));
					logger.info("没有疾病字典");
					value.setSuccess(true);
				}
			}
    	}catch(Exception e){
    		value.setStatusCode(2);
			value.setMessage("获取疾病字典异常");
			logger.info("获取疾病字典异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
    }
	
	/**
	 * @Description: 转化疾病属性名 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年8月9日 
	 */
	public List<Map<String,Object>> convertDisease(List<Disease> list)throws Exception{
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		for(Disease disease : list){
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("itemId",disease.getDisease_id());
			map.put("itemName",disease.getDisease_name());
			mapList.add(map);
		}
		return mapList;
	}

}
