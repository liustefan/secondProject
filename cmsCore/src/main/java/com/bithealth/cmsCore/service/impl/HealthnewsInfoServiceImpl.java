package com.bithealth.cmsCore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.cmsCore.dao.HealthnewsInfoMapper;
import com.bithealth.cmsCore.model.HealthnewsInfo; 
import com.bithealth.cmsCore.model.HealthnewsInfoExample;
import com.bithealth.cmsCore.service.HealthnewsInfoService;
/**
 * 类名称: HealthnewsInfoServiceImpl  
 * 功能描述: 健康资讯信息表服务接口实现
 * 日期: 2016年7月29日 下午3:49:26 
 * 
 * @author 周玉飞
 * @version  
 */
@Service("healthnewsinfoService") 
public class HealthnewsInfoServiceImpl extends GenericBaseServiceImpl<HealthnewsInfo,HealthnewsInfoExample,
      Integer> implements HealthnewsInfoService {
          
    @Autowired 
    HealthnewsInfoMapper healthnewsinfoMapper;

    @Override
    public GenericBaseDao<HealthnewsInfo,HealthnewsInfoExample,  Integer > getDao() {
        return healthnewsinfoMapper;
    }

	public int deleteNewsInfoById(List<Integer> clHninfoids) {
		HealthnewsInfoExample example = new HealthnewsInfoExample();
		example.createCriteria().andHninfoidIn(clHninfoids);
		return deleteByExample(example);
	}

	}

