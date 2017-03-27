package com.bithealth.cmsCore.service.impl;

import javax.annotation.Resource; 
import org.springframework.stereotype.Service; 
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.cmsCore.dao.HealthnewsPraiseMapper;
import com.bithealth.cmsCore.model.HealthnewsPraise; 
import com.bithealth.cmsCore.model.HealthnewsPraiseExample;
import com.bithealth.cmsCore.service.HealthnewsPraiseService;

/**
 * 类名称: HealthnewsPraiseServiceImpl  
 * 功能描述: 点赞服务接口实现类
 * 日期: 2016年8月26日 下午3:17:26 
 * 
 * @author 周玉飞
 * @version  
 */
@Service("healthnewspraiseService") 
public class HealthnewsPraiseServiceImpl extends GenericBaseServiceImpl<HealthnewsPraise,HealthnewsPraiseExample,
      Long> implements HealthnewsPraiseService {
          
    @Resource HealthnewsPraiseMapper healthnewspraiseMapper;
        
    @Override
    public GenericBaseDao<HealthnewsPraise,HealthnewsPraiseExample,  Long > getDao() {
        return healthnewspraiseMapper;
    }  
}
