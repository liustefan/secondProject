package com.bithealth.report;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bithealth.reportCore.facade.service.ReportIFService;
import com.bithealth.sdk.web.controller.BaseSpringController;


/**
 * 类名称: RepStatisticController  
 * 功能描述:报告统计分析 
 * 日期: 2016年9月10日 下午5:46:36 
 * 
 * @author 谢美团
 * @version  
 */
@Controller
@RequestMapping(value = "/statistic")
public class RepStatisticController extends BaseSpringController {

    @Resource
    private ReportIFService reportIFService;
    
    
    private static Logger logger=Logger.getLogger(RepStatisticController.class);

 
    @RequestMapping(value = "/toRepStatistcPage")
    public String toRepStatistcPage(ModelMap model,Integer memberid){
    	 Map<String, Object> resultMap = new HashMap<String, Object>();
    	try {
    		resultMap = reportIFService.getRepStatist(memberid);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	model.put("reps", resultMap.get("reps"));
    	model.put("strs", resultMap.get("strs"));
    	return "/report/statistic/memRepStatistl";
    }
    
    
    
}
