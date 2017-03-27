/**
 * @PackageName:      com.bithealth.memberCore.member.service
 * @FileName:     DiseasesHistoryService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月6日 下午5:38:38  
 * 
 */
package com.bithealth.memberCore.member.service;

import java.util.List;

import com.bithealth.memberCore.member.model.DiseasesHistory;
import com.bithealth.memberCore.member.model.DiseasesHistoryExample;
import com.bithealth.memberCore.member.model.DiseasesHistoryKey;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: DiseasesHistoryService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月6日 下午5:38:38 
 * 
 * @author liuhm
 * @version  
 */
public interface DiseasesHistoryService extends GenericBaseService<DiseasesHistory, DiseasesHistoryExample, DiseasesHistoryKey> {
	
	public int insertOrUpdate(List<DiseasesHistory> diseaseList, Member member);

}
