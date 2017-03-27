/**
 * @PackageName:      com.bithealth.ucCore.facade.service
 * @FileName:     MergeService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年12月7日 上午10:32:59  
 * 
 */
package com.bithealth.ucCore.facade.service;

import com.bithealth.ucCore.uc.model.MemberBasicInfo;
import com.bithealth.ucCore.uc.model.ReturnObject;
import com.bithealth.ucCore.uc.result.MergeResult;

/**
 * 类名称: MergeService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月7日 上午10:32:59 
 * 
 * @author liuhm
 * @version  
 */
public interface MergeService {
	
	/**
	 * 
	 * @Title:checkMerge 
	 * @Description:校验会员完善资料时能否合并到其他会员. 
	 * @author liuhm
	 * @param tel
	 * @param idcard
	 * @param name
	 * @return 
	 * @param 
	 * @throws
	 * @retrun ReturnObject
	 */
	ReturnObject checkMerge(String tel, String idcard, String name);
	
	/**
	 * 
	 * @Title:merge 
	 * @Description:合并会员资料，成功后将源GUID清楚. 
	 * @author liuhm
	 * @param sourGuid
	 * @param info
	 * @return 
	 * @param 
	 * @throws
	 * @retrun ReturnObject
	 */
	MergeResult merge(String sourGuid, int sourSrvId, MemberBasicInfo info);
	
}
