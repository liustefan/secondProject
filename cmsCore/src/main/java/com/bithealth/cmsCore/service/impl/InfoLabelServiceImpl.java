package com.bithealth.cmsCore.service.impl;

import javax.annotation.Resource; 
import org.springframework.stereotype.Service; 
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.cmsCore.dao.InfoLabelMapper;
import com.bithealth.cmsCore.model.InfoLabel; 
import com.bithealth.cmsCore.model.InfoLabelExample;
import com.bithealth.cmsCore.service.InfoLabelService;

/**
 * 类名称: infoLabelServiceImpl  
 * 功能描述: 资讯标签关系接口实现
 * 日期: 2016年9月5日 上午10:40:49
 * 
 * @author 周玉飞
 * @version  
 */
@Service("infolabelService") 
public class InfoLabelServiceImpl extends GenericBaseServiceImpl<InfoLabel,InfoLabelExample,
      Long> implements InfoLabelService {
          
    @Resource InfoLabelMapper infolabelMapper;
        
    @Override
    public GenericBaseDao<InfoLabel,InfoLabelExample,  Long > getDao() {
        return infolabelMapper;
    }  
}
