package com.bithealth.dataConversionServer.init;

import org.apache.log4j.Logger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import com.bithealth.dataConversionServer.qiangHua.thread.DiabetesVisitsTask;
import com.bithealth.dataConversionServer.qiangHua.thread.HealthExamTask;
import com.bithealth.dataConversionServer.qiangHua.thread.HealthRecordsTask;
import com.bithealth.dataConversionServer.qiangHua.thread.HypertensionVisitsTask;
import com.bithealth.dataConversionServer.zhongLian.thread.ZKHKSendDatasTask;
import com.bithealth.sdk.common.rabbit.bean.MqMsgBean;


public class InitConfig implements ApplicationListener<ApplicationEvent>{
	
	private static Logger logger = Logger.getLogger(InitConfig.class); 
	
	private static boolean isCalled = false;
	

	//@Resource(name="jobConfigService")
	//private IJobConfigService jobConfigService;
	private  Scheduler scheduler;
	@Autowired
	private DiabetesVisitsTask diabetesVisitsTask;
	@Autowired
	private HealthExamTask healthExamTask;
	@Autowired
	private HypertensionVisitsTask hypertensionVisitsTask;
	@Autowired
	private HealthRecordsTask healthRecordsTask;
	@Autowired
	private ZKHKSendDatasTask zkhkSendDatasTask;
	
	

	public void onApplicationEvent(ApplicationEvent event) {
			if(!isCalled){
				isCalled = true;
				MqMsgBean msg = new MqMsgBean();
				try {
					//consumeMsg.parseUserXmlDataAndSave(msg, CompanyConfigEnmu.COMPANY_ZLJY);
					logger.info("解析完成！");
				} catch (Exception e) {
					logger.info("解析失败！");
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
			 	
			}
		
	}

}

