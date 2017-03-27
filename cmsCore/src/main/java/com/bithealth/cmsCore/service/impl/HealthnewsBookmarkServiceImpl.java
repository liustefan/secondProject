package com.bithealth.cmsCore.service.impl;

import javax.annotation.Resource; 
import org.springframework.stereotype.Service; 
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.cmsCore.dao.HealthnewsBookmarkMapper;
import com.bithealth.cmsCore.model.HealthnewsBookmark; 
import com.bithealth.cmsCore.model.HealthnewsBookmarkExample;
import com.bithealth.cmsCore.service.HealthnewsBookmarkService;

/**
 * 类名称: HealthnewsBookmarkServiceImpl  
 * 功能描述: 收藏服务接口实现类
 * 日期: 2016年8月26日 下午3:17:26 
 * 
 * @author 周玉飞
 * @version  
 */
@Service("healthnewsbookmarkService") 
public class HealthnewsBookmarkServiceImpl extends GenericBaseServiceImpl<HealthnewsBookmark,HealthnewsBookmarkExample,
      Long> implements HealthnewsBookmarkService {
          
    @Resource HealthnewsBookmarkMapper healthnewsbookmarkMapper;
        
    @Override
    public GenericBaseDao<HealthnewsBookmark,HealthnewsBookmarkExample,  Long > getDao() {
        return healthnewsbookmarkMapper;
    }  
}
