/**
 * @PackageName:      com.bithealth.memberCore.member.service.impl
 * @FileName:     MemberLabelItemServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年12月6日 上午10:27:39  
 * 
 */
package com.bithealth.memberCore.memberLabel.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.memberCore.constants.Constrants;
import com.bithealth.memberCore.memberLabel.dao.MemberLabelItemMapper;
import com.bithealth.memberCore.memberLabel.enmu.LabelStatus;
import com.bithealth.memberCore.memberLabel.model.LabelItem;
import com.bithealth.memberCore.memberLabel.model.MemberLabelItem;
import com.bithealth.memberCore.memberLabel.model.MemberLabelItemExample;
import com.bithealth.memberCore.memberLabel.service.MemberLabelItemService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

/**
 * 类名称: MemberLabelItemServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月6日 上午10:27:39 
 * 
 * @author liuhm
 * @version  
 */
@Service
public class MemberLabelItemServiceImpl extends GenericBaseServiceImpl<MemberLabelItem, MemberLabelItemExample, Integer> 
implements MemberLabelItemService {
	
	@Autowired
	private MemberLabelItemMapper memberLabelItemMapper;
	
	@Override
	public GenericBaseDao<MemberLabelItem, MemberLabelItemExample, Integer> getDao() {
		return memberLabelItemMapper;
	}

	@Override
	public int insertBatch(List<MemberLabelItem> list, Integer memberId) {
		if(list == null || list.size() == 0) {
			return 0;
		}
		for(MemberLabelItem item : list) {
			item.setMemberID(memberId);
		}
		return memberLabelItemMapper.insertBatch(list);
	}
	
	@Override
	public int deleteBatch(List<MemberLabelItem> list, Integer memberId) {
		if(list == null || list.size() == 0) {
			return 0;
		}
		List<Integer> itemIds = new ArrayList<Integer>();
		for(MemberLabelItem item : list) {
			itemIds.add(item.getLItemID());
		}
		MemberLabelItemExample example = new MemberLabelItemExample();
		example.createCriteria().andLItemIDIn(itemIds).andMemberIDEqualTo(memberId);
		return memberLabelItemMapper.deleteByExample(example);
	}

	@Override
	public int initializeItemLabel(int memberId, boolean fromApp) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(Constrants.APP_USER);
		list.add(Constrants.WEB_USER);
		MemberLabelItemExample example = new MemberLabelItemExample();
		example.createCriteria().andMemberIDEqualTo(memberId).andLItemIDIn(list);
		List<MemberLabelItem> items = memberLabelItemMapper.selectByExample(example);
		boolean existApp = false;
		boolean existWeb = false;
		if(items != null) {
			for(MemberLabelItem item : items) {
				if(item.getLItemID().intValue() == Constrants.APP_USER) {
					existApp = true;
				}
				if(item.getLItemID().intValue() == Constrants.WEB_USER) {
					existWeb = true;
				}	
			}
		}
		List<MemberLabelItem> insertList = new ArrayList<MemberLabelItem>();
		if(fromApp && !existApp) {
			insertList.add(new MemberLabelItem(memberId, Constrants.APP_USER));
		}
		if(!fromApp && !existWeb) {
			insertList.add(new MemberLabelItem(memberId, Constrants.WEB_USER));
		}
		if(insertList.size() > 0) {
			return memberLabelItemMapper.insertBatch(insertList);
		}
		return 0;
	}
	
	@Override
	public boolean isAppRegist(int memberId, Integer itemId) {
		MemberLabelItemExample example = new MemberLabelItemExample();
		example.createCriteria().andMemberIDEqualTo(memberId).andLItemIDEqualTo(itemId);
		List<MemberLabelItem> items = memberLabelItemMapper.selectByExample(example);
		return !(items == null || items.size() == 0);
	}

	@Override
	public List<LabelItem> selectMemberLabelItems(LabelStatus status, Integer memberId, List<LabelItem> items) {
		if(items == null || items.size() == 0) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", status.getCode());
		map.put("memberId", memberId);
		map.put("items", items);
		return memberLabelItemMapper.selectMemberLabelItems(map);
	}

	@Override
	public int saveOrUpdate(int memberId, List<MemberLabelItem> itemList) {
		
		return 0;
	}

}
