package com.push.init;

import java.util.List;

import javax.annotation.Resource;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.push.constants.Constants;
import com.push.controller.PushTagController;
import com.push.dao.SmsOrVioceDao;
import com.push.model.SmsConfig;
import com.push.service.SmsOrVioceService;
import com.push.thread.EcacheManager;


/**
 * @ClassName:     InitConfig.java 
 * @Description:   初始化配置信息
 * @author         谢美团  
 * @version        V1.0   
 * @Date           2015年12月9日 下午4:32:53
*****/
public class InitConfig implements ApplicationListener<ContextRefreshedEvent> {
	
	
	private static Logger logger = Logger.getLogger(InitConfig.class); 
    @Resource(name="smsOrVioceService")  
    private SmsOrVioceService smsOrVioceService;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try{
			//获取配置的缓存 
			Cache cache = EcacheManager.getCache(Constants.CACHE_SMS_CONFIG);
			if(cache != null){
				if(cache.getSize()==0){//缓存中无对象，则进行初始化
					smsOrVioceService.initConfig();
				}
			}else{
				logger.info("cache缓存未配置，初始化短信推送配置信息失败。");
			}
		}catch(Exception e){
			logger.info("初始化短信推送配置信息发生异常。"+e);
		}


	}

	
}
