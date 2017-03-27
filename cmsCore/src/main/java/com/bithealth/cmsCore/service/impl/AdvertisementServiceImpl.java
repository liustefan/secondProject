package com.bithealth.cmsCore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.cmsCore.dao.AdvertisementMapper;
import com.bithealth.cmsCore.model.Advertisement; 
import com.bithealth.cmsCore.model.AdvertisementExample;
import com.bithealth.cmsCore.service.AdvertisementService;
/**
 * 类名称: AdvertisementServiceImpl  
 * 功能描述: 广告服务类接口实现
 * 日期: 2016年7月29日 下午3:49:26 
 * 
 * @author 周玉飞
 * @version  
 */
@Service("advertisementService") 
public class AdvertisementServiceImpl extends GenericBaseServiceImpl<Advertisement,AdvertisementExample,
      Integer> implements AdvertisementService {
          
    @Autowired 
    AdvertisementMapper advertisementMapper;
        
    @Override
    public GenericBaseDao<Advertisement,AdvertisementExample,  Integer > getDao() {
        return advertisementMapper;
    }
    
	public int deleteAdvertById(List<Integer> clAids) {
		AdvertisementExample example = new AdvertisementExample();
		example.createCriteria().andAidIn(clAids);
		return deleteByExample(example);
	}

}
