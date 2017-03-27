package com.bithealth.dataConversionServer.quertzSchedule;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
  //import org.springframework.scheduling.quartz.AdaptableJobFactory;
/** 
 * @FileName:     MyJobFactory.java 
 * @Description: TODO(用一句话描述该文件做什么) 
 * All rights Reserved, Designed By ZKHK.YF  
 * Copyright:    Copyright(C) 2015-2025  
 * Company       SHENZHEN BIT HEALTH TECHNOLOGY CO.,LTD.  
 * @author:      zengxuhua  
 * @version      V1.0  
 * @Createdate:  2015年12月24日 上午11:38:07  
 * 
 * Modification  History: 
 * Date         Author        Version        Discription  *  
 * 2015年12月24日       Administrator 

 */


/**
 * @ClassName:     MyJobFactory.java 
  * @Description:   TODO
  * @author         Administrator  
 * @version        V1.0   
  * @Date           2015年12月24日 上午11:38:07
 *****/
public class MyJobFactory extends AdaptableJobFactorys {

  //这个对象Spring会帮我们自动注入进来,也属于Spring技术范畴.
  	@Autowired
  	private AutowireCapableBeanFactory capableBeanFactory;
  	
  	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
  		//调用父类的方法
  		Object jobInstance =QuertzJobHealthExamTask.class; //super.createJobInstance(bundle);
  		//进行注入,这属于Spring的技术,不清楚的可以查看Spring的API.
  		capableBeanFactory.autowireBean(jobInstance);
  		return jobInstance;
  	}

    
}
