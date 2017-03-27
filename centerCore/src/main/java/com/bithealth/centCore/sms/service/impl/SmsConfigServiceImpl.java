package com.bithealth.centCore.sms.service.impl;

import java.util.List;

import javax.annotation.Resource; 
import org.springframework.stereotype.Service; 
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.centCore.sms.dao.SmsConfigMapper;
import com.bithealth.centCore.sms.model.SmsConfig; 
import com.bithealth.centCore.sms.model.SmsConfigExample;
import com.bithealth.centCore.sms.service.SmsConfigService;

@Service("smsConfigService") 
public class SmsConfigServiceImpl extends GenericBaseServiceImpl<SmsConfig,SmsConfigExample,
      Integer> implements SmsConfigService {
          
    @Resource 
    SmsConfigMapper smsconfigMapper;
        
    @Override
    public GenericBaseDao<SmsConfig,SmsConfigExample,  Integer > getDao() {
        return smsconfigMapper;
    }

	@Override
	public List<SmsConfig> selectHaveSendStatusSms() {
		return smsconfigMapper.selectHaveSendStatusSms();
	}  
}
