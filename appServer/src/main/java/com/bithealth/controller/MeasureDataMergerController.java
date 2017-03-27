package com.bithealth.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.common.model.MiniData;
import com.bithealth.measureCore.common.model.OmdsExtend;
import com.bithealth.measureCore.common.model.ThreeOneData;
import com.bithealth.measureCore.common.service.OmdsService;
import com.bithealth.sdk.core.entity.JSONResult;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.util.MessageUtil;


/**
 * 类名称: MeasureDataMergerController  
 * 功能描述: 测量数据合并控制器
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2017年1月3日 上午11:33:49 
 * 
 * @author 谢美团
 * @version  
 */
@Controller
@RequestMapping(value = "/measure")
public class MeasureDataMergerController extends BaseSpringController{
	
	@Resource
    private OmdsService omdsService;
	
	
	
	private static Logger logger = Logger.getLogger(PaperController.class);

	/**
	 * @Title:selectMeasRecordByEventIdAndType 
	 * @Description:合并血糖测量数据
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param request
	 * @param response
	 * @throws Exception 
	 * @throws
	 * @retrun void
	 */ 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/mergerBloodSugar", method = RequestMethod.POST)
    public void mergerBloodSugar(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
    	try{
        	String otherParam = (String)request.getAttribute("otherParamStr");
        	List<OmdsExtend> omdsList = JSONArray.parseArray(otherParam, OmdsExtend.class);
        	for(OmdsExtend omdsExtend:omdsList){
        		if(omdsExtend.getData() != null){
        			omdsExtend.setData(JSONObject.parseObject(omdsExtend.getData().toString(), Obsr.class));
        			omdsService.insertBloodSugar(omdsExtend);
        		}
        	}
    	}catch(Exception e){
			value.setSuccess(false);
			value.setStatusCode(2);
			value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.error("合并血糖测量数据异常"+e);
		}
		out.write(JSON.toJSONString(value));
    }
	
	/**
	 * @Title:mergerBloodPressure 
	 * @Description:合并血压测量数据
	 * @author 谢美团
	 * @param request
	 * @param response
	 * @throws Exception 
	 * @throws
	 * @retrun void
	 */ 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/mergerBloodPressure", method = RequestMethod.POST)
    public void mergerBloodPressure(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
    	try{
        	String otherParam = (String)request.getAttribute("otherParamStr");
        	List<OmdsExtend> omdsList = JSONArray.parseArray(otherParam, OmdsExtend.class);
        	for(OmdsExtend omdsExtend:omdsList){
        		if(omdsExtend.getData() != null){
        			omdsExtend.setData(JSONObject.parseObject(omdsExtend.getData().toString(), Osbp.class));
        			omdsService.insertBloodPressure(omdsExtend);
        		}
        	}
    	}catch(Exception e){
			value.setSuccess(false);
			value.setStatusCode(2);
			value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.error("合并血压测量数据异常"+e);
		}
		out.write(JSON.toJSONString(value));
    }
	
	/**
	 * @Title:mergerMini 
	 * @Description:合并mini测量数据
	 * @author 谢美团
	 * @param request
	 * @param response
	 * @throws Exception 
	 * @throws
	 * @retrun void
	 */ 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/mergerMini", method = RequestMethod.POST)
    public void mergerMini(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
    	try{
        	String otherParam = (String)request.getAttribute("otherParamStr");
        	List<OmdsExtend> omdsList = JSONArray.parseArray(otherParam, OmdsExtend.class);
        	for(OmdsExtend omdsExtend:omdsList){
        		if(omdsExtend.getData() != null){
        			omdsExtend.setData(JSONObject.parseObject(omdsExtend.getData().toString(), MiniData.class));
        			omdsService.insertMiniData(omdsExtend);
        		}
        	}
    	}catch(Exception e){
			value.setSuccess(false);
			value.setStatusCode(2);
			value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.error("合并mini测量数据异常"+e);
		}
		out.write(JSON.toJSONString(value));
    }
	
	/**
	 * @Title:mergerThreeInOne 
	 * @Description:合并三合一
	 * @author 谢美团
	 * @param request
	 * @param response
	 * @throws Exception 
	 * @throws
	 * @retrun void
	 */ 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/mergerThreeInOne", method = RequestMethod.POST)
    public void mergerThreeInOne(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PrintWriter out = response.getWriter();
		JSONResult<Object> value = new JSONResult<Object>();
    	try{
        	String otherParam = (String)request.getAttribute("otherParamStr");
        	List<OmdsExtend> omdsList = JSONArray.parseArray(otherParam, OmdsExtend.class);
        	for(OmdsExtend omdsExtend:omdsList){
        		if(omdsExtend.getData() != null){
        			omdsExtend.setData(JSONObject.parseObject(omdsExtend.getData().toString(), ThreeOneData.class));
        			omdsService.insertThreeOneData(omdsExtend);
        		}
        	}
    	}catch(Exception e){
			value.setSuccess(false);
			value.setStatusCode(2);
			value.setMessage(MessageUtil.getValue("error.select.data"));
			logger.error("合并三合一测量数据异常"+e);
		}
		out.write(JSON.toJSONString(value));
    }
	
}
