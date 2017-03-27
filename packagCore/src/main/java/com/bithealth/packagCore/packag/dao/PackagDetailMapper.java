/*
 * PackagDetailMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-05 Created
 */
package com.bithealth.packagCore.packag.dao;

import java.util.List;

import com.bithealth.packagCore.packag.model.PackagDetail;
import com.bithealth.packagCore.packag.model.PackagDetailExample;
import com.bithealth.packagCore.packag.model.PackagDetailKey;
import com.bithealth.sdk.core.generic.GenericBaseDao;

public interface PackagDetailMapper extends GenericBaseDao<PackagDetail, PackagDetailExample, PackagDetailKey> {
	
	/**
	 * @Title:batchInsert 
	 * @Description:批量插入. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param list 
	 * @throws
	 * @retrun void
	 */ 
	public int insertByBatch(List<PackagDetail> list) ;
}