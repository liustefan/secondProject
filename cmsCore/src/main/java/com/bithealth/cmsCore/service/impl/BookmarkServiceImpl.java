package com.bithealth.cmsCore.service.impl;

import javax.annotation.Resource; 
import org.springframework.stereotype.Service; 
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl; 
import com.bithealth.cmsCore.dao.BookmarkMapper;
import com.bithealth.cmsCore.model.Bookmark; 
import com.bithealth.cmsCore.model.BookmarkExample;
import com.bithealth.cmsCore.service.BookmarkService;
/**
 * 类名称: BookmarkServiceImpl  
 * 功能描述: 资讯收藏接口实现
 * 日期: 2016年10月13日 上午13:49:30
 * 
 * @author 周玉飞
 * @version  
 */
@Service("bookmarkService") 
public class BookmarkServiceImpl extends GenericBaseServiceImpl<Bookmark,BookmarkExample,
      Long> implements BookmarkService {
          
    @Resource BookmarkMapper bookmarkMapper;
        
    @Override
    public GenericBaseDao<Bookmark,BookmarkExample,  Long > getDao() {
        return bookmarkMapper;
    }  
}
