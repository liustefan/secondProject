package com.bithealth.packagCore.packag.service.impl;

import java.util.List;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.packagCore.packag.dao.PackagDetailMapper;
import com.bithealth.packagCore.packag.model.PackagDetail; 
import com.bithealth.packagCore.packag.model.PackagDetailExample;
import com.bithealth.packagCore.packag.service.PackagDetailService;
import com.bithealth.packagCore.packag.model. PackagDetailKey; 

@Service("packagdetailService") 
public class PackagDetailServiceImpl extends GenericBaseServiceImpl<PackagDetail,PackagDetailExample,
      PackagDetailKey> implements PackagDetailService {
          
    @Resource 
    PackagDetailMapper packagdetailMapper;
        
    @Override
    public GenericBaseDao<PackagDetail,PackagDetailExample,  PackagDetailKey > getDao() {
        return packagdetailMapper;
    }

	@Override
	public int insertByBatch(List<PackagDetail> list) {
		return packagdetailMapper.insertByBatch(list);
	}  
}
