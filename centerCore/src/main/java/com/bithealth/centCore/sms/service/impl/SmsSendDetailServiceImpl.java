package com.bithealth.centCore.sms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bithealth.centCore.sms.dao.SmsSendDetailMapper;
import com.bithealth.centCore.sms.model.SmsSendDetail;
import com.bithealth.centCore.sms.model.SmsSendDetailExample;
import com.bithealth.centCore.sms.service.SmsSendDetailService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Service("smssenddetailService") 
public class SmsSendDetailServiceImpl extends GenericBaseServiceImpl<SmsSendDetail,SmsSendDetailExample,
      Integer> implements SmsSendDetailService {
          
    @Resource SmsSendDetailMapper smssenddetailMapper;
        
    @Override
    public GenericBaseDao<SmsSendDetail,SmsSendDetailExample,  Integer > getDao() {
        return smssenddetailMapper;
    }

	@Override
	public int insertByBatch(List<SmsSendDetail> list) {
		return smssenddetailMapper.insertByBatch(list);
	}  
    

}
