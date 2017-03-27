package com.bithealth.packagCore.packag.service.impl;

import javax.annotation.Resource; 
import org.springframework.stereotype.Service; 
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.packagCore.packag.dao.PackagMapper;
import com.bithealth.packagCore.packag.model.Packag; 
import com.bithealth.packagCore.packag.model.PackagExample;
import com.bithealth.packagCore.packag.service.PackagService;

@Service("packagService") 
public class PackagServiceImpl extends GenericBaseServiceImpl<Packag,PackagExample,
      Integer> implements PackagService {
          
    @Resource PackagMapper packagMapper;
        
    @Override
    public GenericBaseDao<Packag,PackagExample,  Integer > getDao() {
        return packagMapper;
    }  
}
