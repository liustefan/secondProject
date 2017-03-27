/**
 * @PackageName:      com.bithealth.memberCore.member.service
 * @FileName:     LinkManService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月7日 上午10:52:19  
 * 
 */
package com.bithealth.memberCore.member.service;

import java.util.List;

import com.bithealth.memberCore.member.model.LinkMan;
import com.bithealth.memberCore.member.model.LinkManExample;
import com.bithealth.memberCore.member.model.LinkManKey;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 类名称: LinkManService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月7日 上午10:52:19 
 * 
 * @author liuhm
 * @version  
 */
public interface LinkManService extends GenericBaseService<LinkMan, LinkManExample, LinkManKey> {
	/**
	 * 
	 * @Title:insertBatch 
	 * @Description:批量保存会员紧急联系人. 
	 * @author liuhm
	 * @param list
	 * @param member
	 * @return 
	 * @param 
	 * @throws
	 * @retrun int
	 */
	public int insertOrUpdate(List<LinkMan> list, Member member);
}
