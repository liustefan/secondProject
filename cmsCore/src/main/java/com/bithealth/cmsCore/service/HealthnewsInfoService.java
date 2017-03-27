package com.bithealth.cmsCore.service;

import java.util.List;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.cmsCore.model.HealthnewsInfo;
import com.bithealth.cmsCore.model.HealthnewsInfoExample; 
/**
 * 类名称: HealthnewsInfoService  
 * 功能描述: 健康资讯信息表服务接口
 * 日期: 2016年7月29日 下午3:49:26 
 * 
 * @author 周玉飞
 * @version  
 */
public interface HealthnewsInfoService extends GenericBaseService<HealthnewsInfo,HealthnewsInfoExample,
   Integer > {   
	
	int deleteNewsInfoById(List<Integer> clHninfoids);

}
