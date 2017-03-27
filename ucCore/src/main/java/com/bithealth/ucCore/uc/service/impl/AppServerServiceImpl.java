package com.bithealth.ucCore.uc.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.ucCore.uc.dao.AppServerMapper;
import com.bithealth.ucCore.uc.model.AppServer; 
import com.bithealth.ucCore.uc.model.AppServerExample;
import com.bithealth.ucCore.uc.service.AppServerService;

@Service("appServerService") 
public class AppServerServiceImpl extends GenericBaseServiceImpl<AppServer,AppServerExample,
      Integer> implements AppServerService {
          
    @Autowired
    AppServerMapper appserverMapper;
        
    @Override
    public GenericBaseDao<AppServer,AppServerExample,  Integer > getDao() {
        return appserverMapper;
    }  
}
