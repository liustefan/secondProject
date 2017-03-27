/**
 * @PackageName:      com.bithealth.doctorCore.docGroup.service
 * @FileName:     DocGrpToMemGrpService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年6月28日 上午10:00:06  
 * 
 */
package com.bithealth.doctorCore.docGroup.service;

import java.util.List;

import com.bithealth.doctorCore.docGroup.model.DocGrpToMemGrpExample;
import com.bithealth.doctorCore.docGroup.model.DocGrpToMemGrpKey;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: DocGrpToMemGrpService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月28日 上午10:00:06 
 * 
 * @author liuhm
 * @version  
 */
public interface DocGrpToMemGrpService extends
		GenericBaseService<DocGrpToMemGrpKey, DocGrpToMemGrpExample, DocGrpToMemGrpKey> {
	
	/**
	 * 
	 * @Title:insertBatchByMemGroup 
	 * @Description:给指定的会员分组绑定医生分组
	 * @author liuhm
	 * @param list
	 * @param memberGroupId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	int insertBatchByMemGroup(List<DocGrpToMemGrpKey> list, int memberGroupId);
	
	int deleteByDoctorGroup(Integer doctorGrpId);
	
	int deleteByMemGroup(Integer memGroupId);
	
}
