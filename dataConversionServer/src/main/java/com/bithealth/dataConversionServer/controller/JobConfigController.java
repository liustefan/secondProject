package com.bithealth.dataConversionServer.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bithealth.dataConversionServer.dataSource.DataSourceSwitch;
import com.bithealth.dataConversionServer.model.JobConfig;
import com.bithealth.dataConversionServer.service.IJobConfigService;
import com.bithealth.dataConversionServer.util.Constants;
import com.bithealth.sdk.web.controller.BaseSpringController;



/**
 * @ClassName:     JobConfigController.java 
 * @Description:   定时任务控制
 * @author         zengxuhua  
 * @version        V1.0   
 * @Date           2015年12月19日 下午3:12:28 @RequestMapping("/jobConfig")
 *****/

@Controller
@RequestMapping("/jobConfigController")
public class JobConfigController extends BaseSpringController{

	@Autowired
	private IJobConfigService jobConfigService;
	private JobConfig jobConfig;
	
	@RequestMapping(value = "/list")
	private String selectAll(HttpServletRequest request){
	  DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_2);
	    List<JobConfig> list=jobConfigService.selectAll(Constants.SendDatas);
	    DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_1);
	    request.setAttribute("list", list);
		return "jobList";
	}
	
	/** 
	 * @Title: selectById 
	 * @Description: 查询一条job
	 * @throws Exception    
	 * @retrun String
	 */
	@RequestMapping("/selectById")
	private String selectById(int id){
	    DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_2);
	    jobConfig=jobConfigService.selectByPrimaryKey(id);
	    DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_1);
		return "jobEdit";
	}
	
	
	/** 
	 * @Title: input 
	 * @Description: 跳转到编辑页面
	 * @throws Exception    
	 * @retrun String
	 */
	@RequestMapping("/input")
	public String input(){
	    return "jobInput";
	}
	
	
	/** 
	 * @Title: edit 
	 * @Description: 编辑一条job
	 * @throws Exception    
	 * @retrun String
	 */
	@RequestMapping("/{id}/edit")
	public String edit(@PathVariable int id, HttpServletRequest request){
	    DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_2);
	    jobConfig=jobConfigService.selectByPrimaryKey(id);
	    String expre=jobConfig.getJobTimeExpression();
	    String[] elpre=expre.split(" ");
	    String month,day,hour,minute;
		month=elpre[4];
		day=elpre[3];
		hour=elpre[2];
		minute=elpre[1];
		HashMap map  = new HashMap();
		map.put("month", month);
		map.put("day", day);
		map.put("hour", hour);
		map.put("minute", minute);
	    DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_1);
	    request.setAttribute("jobConfig", jobConfig);
	    request.setAttribute("map", map);
		return "jobInput";
	}
	
	
	/** 
	 * @Title: update 
	 * @Description: 更新和新增一条job
	 * @throws Exception    
	 * @retrun String
	 */
	@RequestMapping("/update")
	public String update(@ModelAttribute("jobConfig") JobConfig jobConfig){
    	    int i=3;	
        	try {
        	    DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_2);
        	    if(jobConfig.getId()==null){
        		jobConfig.setJobType(2);
    		    	i= jobConfigService.insertSelective(jobConfig);
        	    }else{
        	    	jobConfig.setJobType(2);
        	    	i=jobConfigService.updateByPrimaryKeySelective(jobConfig);
        	    }
        	    DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_1);
        	} catch (Exception e) {
        	    e.printStackTrace();
        	}
		return "redirect:/jobConfigController/list.do";
	}


}
