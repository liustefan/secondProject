package com.bithealth.centCore.care.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource; 

import org.springframework.stereotype.Service; 

import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.centCore.care.dao.FamilyNewsMapper;
import com.bithealth.centCore.care.model.FamilyNews; 
import com.bithealth.centCore.care.model.FamilyNewsExample;
import com.bithealth.centCore.care.service.FamilyNewsService;

@Service("familynewsService") 
public class FamilyNewsServiceImpl extends GenericBaseServiceImpl<FamilyNews,FamilyNewsExample,
      Integer> implements FamilyNewsService {
          
    @Resource FamilyNewsMapper familynewsMapper;
        
    @Override
    public GenericBaseDao<FamilyNews,FamilyNewsExample,  Integer > getDao() {
        return familynewsMapper;
    }

	@Override
	public List<FamilyNews> getMyCareMemberNews(Page<FamilyNews> page,String memberGUID) {
		
		return familynewsMapper.getMyCareMemberNews(page, memberGUID);
	}

	@Override
	public List<FamilyNews> getLastFamilyNewsAndReadStatus(Page<FamilyNews> page, String sender, String receiver) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("sender", sender);
		paramMap.put("receiver", receiver);
		return familynewsMapper.getLastFamilyNewsAndReadStatus(page, paramMap);
	}  
}
