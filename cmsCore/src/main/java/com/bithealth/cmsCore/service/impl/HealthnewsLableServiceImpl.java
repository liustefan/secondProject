package com.bithealth.cmsCore.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.cmsCore.dao.HealthnewsLableMapper;
import com.bithealth.cmsCore.model.HealthnewsLable; 
import com.bithealth.cmsCore.model.HealthnewsLableExample;
import com.bithealth.cmsCore.service.HealthnewsLableService;
/**
 * 类名称: HealthnewsLableServiceImpl  
 * 功能描述: 健康资讯标签服务接口实现
 * 日期: 2016年7月29日 下午3:49:26 
 * 
 * @author 周玉飞
 * @version  
 */
@Service("healthnewslableService") 
public class HealthnewsLableServiceImpl extends GenericBaseServiceImpl<HealthnewsLable,HealthnewsLableExample,
      Integer> implements HealthnewsLableService {
          
    @Autowired 
    HealthnewsLableMapper healthnewslableMapper;
	
    @Override
    public GenericBaseDao<HealthnewsLable,HealthnewsLableExample,  Integer > getDao() {
        return healthnewslableMapper;
        
    }

	public int deleteLableById(List<Integer> clHnlabelids) {
		HealthnewsLableExample example = new HealthnewsLableExample();
		example.createCriteria().andHnlabelidIn(clHnlabelids);
		return deleteByExample(example);
	}

	@Override
	public List<HealthnewsLable> selectAllLable(HealthnewsLable pojo) {
		
		return healthnewslableMapper.selectAllLable(pojo);
	}

}
