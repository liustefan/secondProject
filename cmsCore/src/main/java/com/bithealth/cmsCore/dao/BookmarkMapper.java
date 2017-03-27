/*
 * BookmarkMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-10-13 Created
 */
package com.bithealth.cmsCore.dao;

import com.bithealth.cmsCore.model.Bookmark;
import com.bithealth.cmsCore.model.BookmarkExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;
/**
 * 类名称: BookmarkMapper  
 * 功能描述: 资讯收藏
 * 日期: 2016年10月13日 上午13:49:30
 * 
 * @author 周玉飞
 * @version  
 */
public interface BookmarkMapper extends GenericBaseDao<Bookmark, BookmarkExample, Long> {
	
	int deleteBookmark(Integer id);
}