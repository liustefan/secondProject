/**
 * @PackageName:      com.bithealth.memberCore.member.service
 * @FileName:     HabitService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月7日 上午10:29:18  
 * 
 */
package com.bithealth.memberCore.member.service;

import com.bithealth.memberCore.member.model.Habit;
import com.bithealth.memberCore.member.model.HabitExample;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: HabitService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月7日 上午10:29:18 
 * 
 * @author liuhm
 * @version  
 */
public interface HabitService extends GenericBaseService<Habit, HabitExample, Integer> {
	
	/**
	 * 
	 * @Title:insertOrUpdate 
	 * @Description:新增或更新. 
	 * @author liuhm
	 * @param habit
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	public int insertOrUpdate(Habit habit);

}
