 
/**
 * @PackageName:      com.bithealth.inspectCore.dao
 * @FileName:     InspectDao.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年6月29日 下午2:17:55  
 * 
 */

package com.bithealth.inspectCore.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bithealth.inspectCore.model.Inspect;
import com.bithealth.memberCore.member.vo.MemberVo;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: InspectDao  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年6月29日 下午2:17:55 
 * 
 * @author baozj
 * @version  
 */
public interface InspectDao {
	
	List<MemberVo> exProcGetDiabetesMemList(Map<String, Object> params);
	
	List<MemberVo> exProcGetHypertensionMemList(Map<String, Object> params);
	
	List<Integer> selectOdgpIdsByDocId(Integer docId);
	
	List<Inspect> selectInspectPage(Page<Inspect> page, @Param("memberID")Integer memberId);
}

