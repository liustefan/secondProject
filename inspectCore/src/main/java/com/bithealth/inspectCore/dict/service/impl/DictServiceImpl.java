 
/**
 * @PackageName:      com.bithealth.inspectCore.service.impl
 * @FileName:     PhDictServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月28日 上午11:29:19  
 * 
 */

package com.bithealth.inspectCore.dict.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.inspectCore.Constants;
import com.bithealth.inspectCore.dao.PhDictDao;
import com.bithealth.inspectCore.dict.model.PhDictitem;
import com.bithealth.inspectCore.dict.service.DictService;
import com.bithealth.inspectCore.dict.service.PhDictitemService;
import com.bithealth.inspectCore.dict.service.PhDicttypeService;


/**
 * 类名称: PhDictServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午11:29:19 
 * 
 * @author baozj
 * @version  
 */
@Service
public class DictServiceImpl implements DictService {
	
	protected static Logger logger = Logger.getLogger(DictServiceImpl.class);
	
	@Autowired
	private PhDicttypeService phDicttypeService;
	@Autowired
	private PhDictitemService phDictitemService;
	@Autowired
	private PhDictDao dao;
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.dict.service.DictService#selectAllSecond_cache()
	 */
	public Map<String, List<PhDictitem>> selectAllSecond_cache() {
		List<PhDictitem> list = dao.selectAllSecond();
		Map<String, List<PhDictitem>> map = new HashMap<String, List<PhDictitem>>();
		PhDictitem pojo;
		String key;
		for(Iterator<PhDictitem> it = list.iterator(); it.hasNext();){
			pojo = it.next();
			key = pojo.getSource() + Constants.PH_DICTIONARY_SEPARATOR + pojo.getDTypeName();
			if(map.get(key) == null)
				map.put(key, new ArrayList<PhDictitem>());
			map.get(key).add(pojo);
		}
		return map;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.dict.service.DictService#select(java.lang.String, java.lang.String)
	 */
	public List<PhDictitem> select(String source, String dTypeName) {
		return selectAllSecond_cache().get(source + Constants.PH_DICTIONARY_SEPARATOR + dTypeName);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.dict.service.DictService#select(java.lang.String, java.lang.String, java.lang.Byte)
	 */
	public PhDictitem select(String source, String dTypeName, Byte dItemId) {
		List<PhDictitem> list = select(source, dTypeName);
		if(list != null && list.size() > 0){
			for(Iterator<PhDictitem> it = list.iterator(); it.hasNext();){
				PhDictitem pojo = it.next();
				if(pojo.getDItemID().equals(dItemId))
					return pojo;
			}
		}
		return null;
	}
}

