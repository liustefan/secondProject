package com.bithealth.cmsCore.service;

import java.util.List;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.cmsCore.model.HealthnewsLable;
import com.bithealth.cmsCore.model.HealthnewsLableExample; 
/**
 * 类名称: HealthnewsLableService  
 * 功能描述: 健康资讯标签服务接口
 * 日期: 2016年7月29日 下午3:49:26 
 * 
 * @author 周玉飞
 * @version  
 */
public interface HealthnewsLableService extends GenericBaseService<HealthnewsLable,HealthnewsLableExample,
   Integer > {   
	
	int deleteLableById(List<Integer> clHnlabelids);
	
	List<HealthnewsLable> selectAllLable(HealthnewsLable pojo);
	
}
