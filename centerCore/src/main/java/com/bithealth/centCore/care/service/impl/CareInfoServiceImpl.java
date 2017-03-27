package com.bithealth.centCore.care.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.centCore.care.dao.CareInfoMapper;
import com.bithealth.centCore.care.model.CareInfo; 
import com.bithealth.centCore.care.model.CareInfoExample;
import com.bithealth.centCore.care.service.CareInfoService;

@Service("careinfoService") 
public class CareInfoServiceImpl extends GenericBaseServiceImpl<CareInfo,CareInfoExample,
      Long> implements CareInfoService {
          
    @Resource CareInfoMapper careinfoMapper;
        
    @Override
    public GenericBaseDao<CareInfo,CareInfoExample,  Long > getDao() {
        return careinfoMapper;
    }

	@Override
	public List<CareInfo> selectBySearchParam(String searchParam,String memberGUID) {
		Map<String,String> parmaMap = new HashMap<String,String>();
		parmaMap.put("param", searchParam);
		parmaMap.put("memberGUID", memberGUID);
		return careinfoMapper.selectBySearchParam(parmaMap);
	}

	@Override
	public List<CareInfo> selectMergeData(String memberGUID, String focusGUID) {
		Map<String,String>  parmaMap = new HashMap<String,String>();
		parmaMap.put("memberGUID", memberGUID);
		parmaMap.put("focusGUID", focusGUID);
		return careinfoMapper.selectMergeData(parmaMap);
	}  
}
