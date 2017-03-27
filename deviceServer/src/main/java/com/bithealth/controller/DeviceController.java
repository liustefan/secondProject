package com.bithealth.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.deviceCore.model.MeasureReqParam;
import com.bithealth.deviceCore.service.DeviceMeasureService;
import com.bithealth.model.ResponseObject;
import com.bithealth.sdk.web.controller.BaseSpringController;




/**
 * 类名称: DeviceController  
 * 功能描述:血压计等设备测量数据上传控制器 
 * 日期: 2017年1月13日 下午5:23:48 
 * 
 * @author 谢美团
 * @version  
 */
@Controller
@RequestMapping(value = "/")
public class DeviceController extends BaseSpringController{
	
	private static Logger logger = Logger.getLogger(DeviceController.class);
	
	@Autowired
	DeviceMeasureService deviceMeasureService;


    /**
     * @Title:measureDataUpload 
     * @Description:测量数据上传
     * @author 谢美团
     * @param measureReqParam
     * @param response
     * @throws Exception 
     * @throws
     * @retrun void
     */ 
    @RequestMapping(value = "/upload")
    public void measureDataUpload(MeasureReqParam measureReqParam,HttpServletResponse response) throws Exception{
    	String responseData="";
    	try {
    		logger.info("data:"+measureReqParam.getData());
    		boolean isSuccess = deviceMeasureService.uploadMeasureData(measureReqParam);
    		if(!isSuccess){
    			throw new Exception("测量数据上传失败");
    		}else{
    			responseData = deviceMeasureService.getResopneString().toUpperCase();
    			logger.info("测量数据上传成功");
    		}
		} catch (Exception e) {
			logger.error("测量数据上传异常："+JSONObject.toJSONString(measureReqParam));
			logger.error(e.getMessage());
		}
    	PrintWriter out = response.getWriter();
        out.write(responseData);
    }
    
  

}
