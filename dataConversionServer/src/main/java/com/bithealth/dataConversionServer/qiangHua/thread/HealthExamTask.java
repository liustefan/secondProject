package com.bithealth.dataConversionServer.qiangHua.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.dataConversionServer.dataSource.DataSourceSwitch;
import com.bithealth.dataConversionServer.qiangHua.bean.ThealthExam;
import com.bithealth.dataConversionServer.qiangHua.bean.ThealthExamDrug;
import com.bithealth.dataConversionServer.qiangHua.bean.ThealthExamParam;
import com.bithealth.dataConversionServer.qiangHua.service.HealthExamService;
import com.bithealth.dataConversionServer.util.Constants;
import com.bithealth.dataConversionServer.util.SystemUtils;



/**
 * @ClassName:     HealthExamTask.java 
 * @Description:   体检数据定时任务类
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2016年2月26日 上午10:43:16
*****/
@Service("HealthExamTask")
public class HealthExamTask {
	
	private Logger logger = Logger.getLogger(HealthExamTask.class);
	
	@Autowired
	private HealthExamService healthExamService;
	
	
	 /** 
	 * @Title: timingGetHealthExamData 
	 * @Description: 从强华获取体检数据并解析入库
	 *     
	 * @retrun void
	 */
	public void timingGetHealthExamData(){
		try{
	        //将数据源切换到强华数库
	        DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_3);
	        //每次读取的数据量
	        int num = 	SystemUtils.getInt(Constants.QH_EVERY_TIME_NUM);
	        long total = healthExamService.getHealthExamCount(null);
	        int times = getTimes(num,total); 
	        for(int i = 0;i < times;i++){
	        	try{
	        	
	        		ThealthExamParam param = new ThealthExamParam();
	        		param.setNum(num);
			        List<ThealthExam>  thealthExamList = healthExamService.queryHealthExanByParam(param);
			        if(thealthExamList == null ){
			        	logger.error("查询强华体检数据异常。");
			        	return;
			        }else if(thealthExamList.size() == 0){
			        	logger.error("本次获取任务中中科强华无更新的体检数据。");
			        	return;
			        }else{	
			        	List<ThealthExamDrug> drugList =  healthExamService.queryHealthExamDrug(thealthExamList);
			        	List<String> successList = new ArrayList<String>();
			        	List<String> failList = new ArrayList<String>();
			        	// 更换到默认数据库
			        	DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_1);
			        	for(ThealthExam tHealthExam:thealthExamList){
			        		boolean isSuccess = healthExamService.saveWholeHealthexam(tHealthExam, drugList);
			        		if(isSuccess){
			        			successList.add(tHealthExam.getExGid());
			        		}else{
			        			failList.add(tHealthExam.getExGid());
			        		}
			        	}
			        	//更新强华数据库中数据的读取状态
				        //将数据源切换到强华数库
				        DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_3);
				        healthExamService.updateDataStatus(successList, true);
				        healthExamService.updateDataStatus(failList, false);
			        	logger.info("分批次,第 "+(i+1)+" 批次获取强华体检数据和入库成功");
			        }  
			        System.out.println("======================="+new Date());
	        	}catch(Exception e){
	        		logger.info("分批次,第 "+(i+1)+" 批次获取强华体检数据和入库异常");
	        		e.printStackTrace();
	        	}
	        }
		}catch(Exception e){
			logger.error("定时从强华数据库获取数据和入库异常，"+e);
		}
		
	}
	
	
	public int getTimes(float num,float total){
		float times = total/num;
		if(times > (int)times){
			times+=1;
		}
		return (int)times;
	}
	
	
	

}