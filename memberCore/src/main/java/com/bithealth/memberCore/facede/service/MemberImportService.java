/**
 * @PackageName:      com.bithealth.memberCore.facede.service
 * @FileName:     MemberImportService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年9月12日 下午2:54:31  
 * 
 */
package com.bithealth.memberCore.facede.service;

import java.util.List;
import java.util.Map;

import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberExt;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;

/**
 * 类名称: MemberImportService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年9月12日 下午2:54:31 
 * 
 * @author liuhm
 * @version  
 */
public interface MemberImportService {
	/**
	 * 分页查询导入出错的会员
	 * @Title:selectErrorMemberList 
	 * @Description:(这里用一句话描述这个方法的作用). 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param page
	 * @param member
	 * @return 
	 * @param 
	 * @throws
	 * @retrun Page<Map<String,Object>>
	 */
	public Page<Map<String, Object>> selectErrorMemberList(Page<Map<String, Object>> page, Member member);
	
	/**
	 * 
	 * @Title:deleteErrorMember 
	 * @Description:(这里用一句话描述这个方法的作用). 
	 * @author liuhm
	 * @param uidList
	 * @return 
	 * @param 
	 * @throws
	 * @retrun String
	 */
	public String deleteErrorMember(String[] uidList);
	
	
	public String insert(MemberExt member);
	
	public String insertErrorData(List<MemberExt> memberList);
	
	public String exist(Member member);
	
	public int deleteAll(Integer docId);
	
	public int countMemberInporting(int docId, UseTag tag);

}
