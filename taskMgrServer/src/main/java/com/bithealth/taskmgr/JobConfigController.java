package com.bithealth.taskmgr;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bithealth.taskMgrCore.constants.Constants;
import com.bithealth.taskMgrCore.model.JobConfig;
import com.bithealth.taskMgrCore.server.IJobConfigService;



/**
 * @ClassName:     JobConfigController.java 
 * @Description:   定时任务控制
 * @author         zengxuhua  
 * @version        V1.0   
 * @Date           2015年12月19日 下午3:12:28 @RequestMapping("/jobConfig")
 *****/

@Controller
@RequestMapping("/jobConfigController")
public class JobConfigController {
	private static Logger logger=Logger.getLogger(JobConfigController.class);
	@Autowired
	private IJobConfigService jobConfigService;
	private JobConfig jobConfig;
	
	/** 
	 * @Title: list 
	 * @Description: 查询所有的job
	 * @throws Exception    
	 * @retrun String
	 */
	@RequestMapping("/list")
	private String selectAll(HttpServletRequest request){
	    List<JobConfig> list=jobConfigService.selectAll(Constants.detaCenter);
	    logger.info("查询所有JOB的数据！");
	    request.setAttribute("list", list);
		return "jobList";
	}
	
	/** 
	 * @Title: input 
	 * @Description: 跳转到编辑页面
	 * @throws Exception    
	 * @retrun String
	 */
	@RequestMapping("/input")
	public String input(){
	    logger.info("job跳转成功！");
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
	    jobConfig=jobConfigService.selectByPrimaryKey(id);
	    String expre=jobConfig.getJobTimeExpression();
	    String[] elpre=expre.split(" ");
	    String month,day,hour,minute;
		month=elpre[4];
		day=elpre[3];
		hour=elpre[2];
		minute=elpre[1];
		System.out.println("===month:"+month+"day:"+day+"hour:"+hour+"minute:"+minute);
		HashMap map  = new HashMap();
		map.put("month", month);
		map.put("day", day);
		map.put("hour", hour);
		map.put("minute", minute);
	    logger.info("编辑显示！");
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
    	    String message=null;
        	try {
        	    if(jobConfig.getId()==null){
        		jobConfig.setJobType(Constants.detaCenter);
    		    	i= jobConfigService.insertSelective(jobConfig);
        	    }else{
        		jobConfig.setJobType(Constants.detaCenter);
        		i=jobConfigService.updateByPrimaryKeySelective(jobConfig);
        	    }
        	    if(1==i){
        		message="数据保存成功！";
        	    }else{
        		message="数据保存失败！";
        	    }
        	} catch (Exception e) {
        	    message="数据保存失败！出现异常";
        	    e.printStackTrace();
        	}
        	 logger.info(message);
		return "redirect:/jobConfigController/list.do";
	}

	@RequestMapping("/{id}/del")
	public String delete(@PathVariable int id, HttpServletRequest request){
	    String message=null;
	    try {
		int i=jobConfigService.deleteByPrimaryKey(id);
		 if(1==i){
     			message="数据删除成功！";
     	    	}else{
     	    	    message="数据删除失败！";
     	   	}
	    } catch (Exception e) {
     	    	message="数据保存失败！出现异常";
     	    	e.printStackTrace();
     	}
     	 	logger.info(message);
	    return "redirect:/jobConfigController/list.do";
	}
	
}
