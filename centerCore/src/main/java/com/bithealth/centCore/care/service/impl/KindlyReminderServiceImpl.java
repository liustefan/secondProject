package com.bithealth.centCore.care.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bithealth.centCore.care.dao.KindlyReminderMapper;
import com.bithealth.centCore.care.model.KindlyReminder;
import com.bithealth.centCore.care.model.KindlyReminderExample;
import com.bithealth.centCore.care.service.KindlyReminderService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Service("kindlyreminderService") 
public class KindlyReminderServiceImpl extends GenericBaseServiceImpl<KindlyReminder,KindlyReminderExample,
      Integer> implements KindlyReminderService {
          
    @Resource KindlyReminderMapper kindlyreminderMapper;
        
    @Override
    public GenericBaseDao<KindlyReminder,KindlyReminderExample,  Integer > getDao() {
        return kindlyreminderMapper;
    }

	@Override
	public List<KindlyReminder> selectByParam(String memberGUID,Page<KindlyReminder> page) {
		return kindlyreminderMapper.selectByParam(memberGUID, page);
	}  
}
