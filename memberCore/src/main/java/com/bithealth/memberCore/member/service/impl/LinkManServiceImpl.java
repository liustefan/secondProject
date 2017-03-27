/**
 * @PackageName:      com.bithealth.memberCore.member.service.impl
 * @FileName:     LinkManServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月7日 上午10:53:06  
 * 
 */
package com.bithealth.memberCore.member.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.member.dao.LinkManMapper;
import com.bithealth.memberCore.member.model.LinkMan;
import com.bithealth.memberCore.member.model.LinkManExample;
import com.bithealth.memberCore.member.model.LinkManKey;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.LinkManService;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: LinkManServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月7日 上午10:53:06 
 * 
 * @author liuhm
 * @version  
 */
@Service("linkManService")
public class LinkManServiceImpl extends GenericBaseServiceImpl<LinkMan, LinkManExample, LinkManKey> implements LinkManService {
	
	@Autowired
	private LinkManMapper mapper;
	
	@Override
	public GenericBaseDao<LinkMan, LinkManExample, LinkManKey> getDao() {
		return mapper;
	}
	
	@Override
	public int insertOrUpdate(List<LinkMan> list, Member member) {
		LinkManExample example = new LinkManExample();
		LinkManExample.Criteria criteria = example.createCriteria();
		criteria.andMemberidEqualTo(member.getMemberid());
		int count = mapper.deleteByExample(example);
		if(list == null || list.size() == 0) {
			return count;
		}
		
		Iterator<LinkMan> it = list.iterator();
		while(it.hasNext()) {
			LinkMan linkMan = it.next();
			if(StringUtil.isEmpty(linkMan.getContactname())) {
				it.remove();
			} else {
				linkMan.setMemberid(member.getMemberid());
			}
		}
		if(list == null || list.size() == 0) {
			return count;
		}
		return mapper.insertBatch(list);
	}

}
