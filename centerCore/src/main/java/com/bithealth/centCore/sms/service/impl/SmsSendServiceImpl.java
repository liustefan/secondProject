package com.bithealth.centCore.sms.service.impl;

import javax.annotation.Resource; 
import org.springframework.stereotype.Service; 
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.centCore.sms.dao.SmsSendMapper;
import com.bithealth.centCore.sms.model.SmsSend; 
import com.bithealth.centCore.sms.model.SmsSendExample;
import com.bithealth.centCore.sms.service.SmsSendService;

@Service("smssendService") 
public class SmsSendServiceImpl extends GenericBaseServiceImpl<SmsSend,SmsSendExample,
      Integer> implements SmsSendService {
          
    @Resource SmsSendMapper smssendMapper;
        
    @Override
    public GenericBaseDao<SmsSend,SmsSendExample,  Integer > getDao() {
        return smssendMapper;
    }  
}
