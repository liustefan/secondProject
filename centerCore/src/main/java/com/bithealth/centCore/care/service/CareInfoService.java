package com.bithealth.centCore.care.service;

import java.util.List;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.centCore.care.model.CareInfo;
import com.bithealth.centCore.care.model.CareInfoExample; 

public interface CareInfoService extends GenericBaseService<CareInfo,CareInfoExample,Long > { 
	
	/**
	 * @Title:selectBySearchParam 
	 * @Description:根据参数查询会员(多表关联)
	 * @author 谢美团
	 * @param searchParam
	 * @return 
	 * @throws
	 * @retrun List<CareInfo>
	 */ 
	public List<CareInfo> selectBySearchParam(String searchParam,String memberGUID);
	
	
	
	public List<CareInfo> selectMergeData(String memberGUID,String focusGUID);
	
	
}
