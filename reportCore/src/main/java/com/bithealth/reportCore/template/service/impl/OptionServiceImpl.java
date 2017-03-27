package com.bithealth.reportCore.template.service.impl;

import javax.annotation.Resource; 
import org.springframework.stereotype.Service; 
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.reportCore.template.dao.OptionMapper;
import com.bithealth.reportCore.template.model.Option; 
import com.bithealth.reportCore.template.model.OptionExample;
import com.bithealth.reportCore.template.service.OptionService;
import com.bithealth.reportCore.template.model. OptionKey; 

@Service("optionService") 
public class OptionServiceImpl extends GenericBaseServiceImpl<Option,OptionExample,
      OptionKey> implements OptionService {
          
    @Resource OptionMapper optionMapper;
        
    @Override
    public GenericBaseDao<Option,OptionExample,  OptionKey > getDao() {
        return optionMapper;
    }  
}
