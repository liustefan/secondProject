 
/**
 * @PackageName:      com.bithealth.questionCore.dao
 * @FileName:     MemberDao.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月19日 上午11:54:10  
 * 
 */

package com.bithealth.questionCore.dao;

import java.util.List;
import java.util.Map;

import com.bithealth.memberCore.member.vo.MemberVo;


/**
 * 类名称: MemberDao  
 * 功能描述: TODO 分页查询我的会员中可以发放单份、组合问卷的会员 
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月19日 上午11:54:10 
 * 
 * @author baozj
 * @version  
 */
public interface MemberDao {
	
	List<MemberVo> exProcGetMyMemListByDocId(Map<String, Object> params);
	
}

