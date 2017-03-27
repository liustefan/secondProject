/**
 * @PackageName:      com.bithealth.memberCore.member.service
 * @FileName:     FamilyHistoryService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月7日 上午10:11:14  
 * 
 */
package com.bithealth.memberCore.member.service;

import java.util.List;

import com.bithealth.memberCore.member.model.FamilyHistory;
import com.bithealth.memberCore.member.model.FamilyHistoryExample;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: FamilyHistoryService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月7日 上午10:11:14 
 * 
 * @author liuhm
 * @version  
 */
public interface FamilyHistoryService extends GenericBaseService<FamilyHistory, FamilyHistoryExample, Long> {
	
	/**
	 * 
	 * @Title:insetBatch 
	 * @Description:批量保存家族病史. 
	 * @author liuhm
	 * @param list
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	public int insetOrUpdate(List<FamilyHistory> list, Member member);
}
