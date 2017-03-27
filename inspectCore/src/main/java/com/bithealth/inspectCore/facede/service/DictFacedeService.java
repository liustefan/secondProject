 
/**
 * @PackageName:      com.bithealth.inspectCore.facede
 * @FileName:     PhDictFacedeService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月1日 上午9:41:59  
 * 
 */

package com.bithealth.inspectCore.facede.service;

import java.util.List;
import java.util.Map;

import com.bithealth.inspectCore.dict.model.PhDictitem;


/**
 * 类名称: PhDictFacedeService  
 * 功能描述: TODO 公卫数据字典  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月1日 上午9:41:59 
 * 
 * @author baozj
 * @version  
 */
public interface DictFacedeService {

	/**
	 * 
	 * @Title:selectAllSecond 
	 * @Description:查询公卫数据字典所有数据封闭到map中 
	 * TODO  
	 * @author baozj
	 * @return 
	 * @throws
	 * @retrun Map<String,List<PhDictitem>>
	 */
	Map<String, List<PhDictitem>> selectAllSecond();
	
	/**
	 * 
	 * @Title:select 
	 * @Description:查询公卫数据字典某二级的所有数据 
	 * TODO  
	 * @author baozj
	 * @param source
	 * @param dTypeName
	 * @param dItemId
	 * @return 
	 * @throws
	 * @retrun PhDictitem
	 */
	PhDictitem select(String source, String dTypeName, Byte dItemId);
	
	/**
	 * 
	 * @Title:select 
	 * @Description:查询公卫数据字典三级对应的数据 
	 * TODO  
	 * @author baozj
	 * @param source
	 * @param dTypeName
	 * @return 
	 * @throws
	 * @retrun List<PhDictitem>
	 */
	List<PhDictitem> select(String source, String dTypeName);
}

