package com.bithealth.cmsCore.service;


import java.util.List;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.cmsCore.model.Advertisement;
import com.bithealth.cmsCore.model.AdvertisementExample; 
/**
 * 类名称: AdvertisementService  
 * 功能描述: 广告服务类接口
 * 日期: 2016年7月29日 下午3:49:26 
 * 
 * @author 周玉飞
 * @version  
 */
public interface AdvertisementService extends GenericBaseService<Advertisement,AdvertisementExample,
   Integer > {    
	
	int deleteAdvertById(List<Integer> clAids);
	
	
}
