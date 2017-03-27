/**
 * @PackageName:      com.bithealth.memberCore.member.service.impl
 * @FileName:     DiseasesHistoryServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月6日 下午5:39:56  
 * 
 */
package com.bithealth.memberCore.member.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.member.dao.DiseasesHistoryMapper;
import com.bithealth.memberCore.member.model.DiseasesHistory;
import com.bithealth.memberCore.member.model.DiseasesHistoryExample;
import com.bithealth.memberCore.member.model.DiseasesHistoryKey;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.DiseasesHistoryService;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: DiseasesHistoryServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月6日 下午5:39:56 
 * 
 * @author liuhm
 * @version  
 */
@Service("diseasesHistoryService")
public class DiseasesHistoryServiceImpl extends GenericBaseServiceImpl<DiseasesHistory, DiseasesHistoryExample, DiseasesHistoryKey> implements DiseasesHistoryService {

	@Autowired
	private DiseasesHistoryMapper mapper;
	@Override
	public GenericBaseDao<DiseasesHistory, DiseasesHistoryExample, DiseasesHistoryKey> getDao() {
		return mapper;
	}
	
	@Override
	public int insertOrUpdate(List<DiseasesHistory> diseaseList, Member member) {
		DiseasesHistoryExample example = new DiseasesHistoryExample();
		example.createCriteria().andMemberidEqualTo(member.getMemberid());
		int count = mapper.deleteByExample(example);
		
		if(diseaseList == null || diseaseList.size() == 0) {
			return count;
		}
		Iterator<DiseasesHistory> it = diseaseList.iterator();
		Short i = 0;
		while(it.hasNext()) {
			DiseasesHistory disease = it.next();
			if(StringUtil.isNotEmpty(disease.getDiseasename())) {
				disease.setCreatetime(new Date());
				disease.setLinenum(new Short(i++));
				disease.setMemberid(member.getMemberid());
			} else {
				it.remove();
			}
		}
		if(diseaseList.size() > 0) {
			return mapper.insertBatch(diseaseList);
		}
		return count;
	}
	
	

}
