package com.bithealth.common.cache.service.impl;

/**
 * 描述 ：
 *
 * @author admin
 * @date 2016年5月4日
 */ 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
 





import com.bithealth.common.cache.dao.CacheLogMapper;
import com.bithealth.common.cache.service.ICacheLogService; 
import com.bithealth.common.cache.model.CacheLog;
import com.bithealth.common.cache.model.CacheLogExample; 
import com.bithealth.sdk.core.generic.GenericDao;
import com.bithealth.sdk.core.generic.GenericServiceImpl; 
 

@Service("cacheLogService")
public class CacheLogServiceImpl extends GenericServiceImpl<CacheLog, Long> implements ICacheLogService {


    @Resource
    private CacheLogMapper cacheLogMapper;
    /* (non-Javadoc)  
     * @see com.bithealth.common.service.ICacheLogService#findListByPrefix(java.lang.String)  
     */
    @Override
    public List<CacheLog> findListByPrefix(String prefix) {
     
        CacheLogExample example = new CacheLogExample(); 
        example.createCriteria().andPrefixEqualTo(prefix);///.andUsernameEqualTo(username);
        final List<CacheLog> list = cacheLogMapper.selectByExample(example);
         return list;
//        return  (list==null||list.size()<=0)?null:list.get(0);
         
    }

    /* (non-Javadoc)  
     * @see com.bithealth.common.service.ICacheLogService#deleteByPrefix(java.lang.String)  
     */
    @Override
    public int deleteByPrefix(String prefix) {
        // TODO Auto-generated method stub
        CacheLogExample example = new CacheLogExample(); 
        example.createCriteria().andPrefixEqualTo(prefix);///.andUsernameEqualTo(username);
//        final List<CacheLog> list = cacheLogMapper.selectByExample(example);
//       for (CacheLog cacheLog: list ){
        return  cacheLogMapper.deleteByExample(example);//deleteByExample( cacheLog);
      
         
     
      
    }

    /* (non-Javadoc)  
     * @see com.bithealth.common.service.ICacheLogService#add(com.bithealth.common.model.CacheLog)  
     */
    @Override
    public void add(CacheLog log) {
        // TODO Auto-generated method stub
         
        cacheLogMapper.insert( log) ;
        
    }

    /* (non-Javadoc)  
     * @see com.bithealth.sdk.core.generic.GenericServiceImpl#getDao()  
     */
    @Override
    public GenericDao<CacheLog, Long> getDao() {
        // TODO Auto-generated method stub
        return cacheLogMapper;
    }
 
}
