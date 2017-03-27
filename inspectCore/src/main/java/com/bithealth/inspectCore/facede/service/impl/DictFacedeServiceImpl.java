 
/**
 * @PackageName:      com.bithealth.inspectCore.facede.impl
 * @FileName:     PhDictFacedeServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月1日 上午9:44:14  
 * 
 */

package com.bithealth.inspectCore.facede.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.inspectCore.dict.model.PhDictitem;
import com.bithealth.inspectCore.dict.service.DictService;
import com.bithealth.inspectCore.facede.service.DictFacedeService;


/**
 * 类名称: PhDictFacedeServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月1日 上午9:44:14 
 * 
 * @author baozj
 * @version  
 */
@Service
public class DictFacedeServiceImpl implements DictFacedeService {

	@Autowired
	private DictService dictService;
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.DictFacedeService#selectAllSecond()
	 */
	public Map<String, List<PhDictitem>> selectAllSecond() {
		
		return dictService.selectAllSecond_cache();
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.DictFacedeService#select(java.lang.String, java.lang.String, java.lang.Byte)
	 */
	public PhDictitem select(String source, String dTypeName, Byte dItemId) {
		
		return dictService.select(source, dTypeName, dItemId);
	}

	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.inspectCore.facede.service.DictFacedeService#select(java.lang.String, java.lang.String)
	 */
	public List<PhDictitem> select(String source, String dTypeName) {
		
		return dictService.select(source, dTypeName);
	}

}

