package com.bithealth.report;


import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bithealth.reportCore.template.model.Function;
import com.bithealth.reportCore.template.model.FunctionExample;
import com.bithealth.reportCore.template.service.FunctionService;
import com.bithealth.sdk.web.controller.BaseSpringController;


@Controller
@RequestMapping(value = "/ofun")
public class OfunController extends BaseSpringController {

    @Resource
    FunctionService functionService;
    
    
    private static Logger logger=Logger.getLogger(OfunController.class);

    
    /**
     * @Title:getOfunList 
     * @Description:获取功能列表
     * @author 谢美团
     * @param model
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/getOfunList")
    public String getOfunList(ModelMap model){
    	FunctionExample example = new FunctionExample();
    	List<Function> functionList = functionService.selectByExample(example);
    	model.put("ofunlist", functionList);
    	return "/report/ofun/ofunList";
    }
    
    
    
}
