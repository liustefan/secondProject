package com.bithealth.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alibaba.fastjson.JSON;
import com.bithealth.sdk.core.entity.JSONResult;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.util.FileUtil;
import com.bithealth.util.MessageUtil;

/**
 * @PackageName: com.bithealth.controller
 * @FileName:    ChatController.java  
 * @Description: 获取mini配置文件  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuxiaoqin
 * @version      V1.0  
 * @Createdate:  2016年11月22日 
 */
@Controller
@RequestMapping(value = "/config")
public class ConfigController extends BaseSpringController{
	
	/**
	 * @Description: 获取mini的配置文件 
	 * @author:      liuxiaoqin
	 * @version      V1.0  
	 * @Createdate:  2016年11月22日 
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getConfigFile", method = RequestMethod.POST)
    public void selectConfigFile(HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
    	String otherParam = (String)request.getAttribute("otherParamStr");
		Map map = JSON.parseObject(otherParam,Map.class);
		try{
	    	String fileName = map.get("fileName").toString();
	    	String filePath = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"/"+fileName;
			String fileStr = FileUtil.feadFileToString(filePath);
			value.setData(fileStr);
			value.setStatusCode(0);
			value.setMessage("获取配置文件成功");
			logger.info("获取配置文件成功");
			value.setSuccess(true);
    	}catch(Exception e){
    		value.setStatusCode(2);
			value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.info("获取配置文件异常"+e);
			value.setSuccess(false);
    	}
    	out.write(JSON.toJSONString(value));
	}
	
}
