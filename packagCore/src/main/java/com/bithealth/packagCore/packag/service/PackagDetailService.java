package com.bithealth.packagCore.packag.service;

import java.util.List;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.packagCore.packag.model.PackagDetail;
import com.bithealth.packagCore.packag.model.PackagDetailExample; 
import com.bithealth.packagCore.packag.model. PackagDetailKey; 

public interface PackagDetailService extends GenericBaseService<PackagDetail,PackagDetailExample, PackagDetailKey > {    
	
	/**
	 * @Title:batchInsert 
	 * @Description:批量插入. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param list
	 * @return 
	 * @throws
	 * @retrun int
	 */ 
	public int insertByBatch(List<PackagDetail> list);
	
	
}
