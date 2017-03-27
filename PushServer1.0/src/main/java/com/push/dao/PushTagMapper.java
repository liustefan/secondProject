package com.push.dao;
import java.util.List;

import com.push.model.HkPushMemberTag;

import java.util.List;

import net.sf.json.JSONArray;

import com.push.model.HKPushInfo;
import com.push.model.HkPushMemberTag;


public interface PushTagMapper {
    
	HkPushMemberTag selectHkPushMemberTagByTag(HKPushInfo pushInfo); 
	
	void saveHkPushMemberTag(List<HkPushMemberTag> list);

	void updateHkPushMemberTag(HKPushInfo pushInfo);
	
	void deleteHkPushMemberTag(HKPushInfo pushInfo);
	
	/**
	 * 根据tag查询其关联用户
	 * @param tag
	 * @return
	 */
	List<HKPushInfo> queryMemberByTag(String tag);
	
	/**
	 * 根据多个tag查询其关联用户
	 * @param tags
	 * @return
	 */
	List<HKPushInfo> queryMemberByTags(List<?> tags);
}