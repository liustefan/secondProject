package com.push.service;

import java.util.List;

import com.push.model.HKPushInfo;
import com.push.model.HkPushMemberTag;


/**
 * 
 * @author owner
 *
 */
public interface PushTagService {
    
	/**
	 * 根据Tag查询HkPushMemberTag
	 * @param pushInfo
	 * @throws Exception
	 * @return
	 */
	public HkPushMemberTag selectHkPushMemberTagByTag(HKPushInfo pushInfo) throws Exception; 
	
	/**
	 * 保存HkPushMemberTag
	 * @param List<HkPushMemberTag>
	 * @throws Exception
	 */
	public void saveHkPushMemberTag(List<HkPushMemberTag> list) throws Exception;

	/**
	 * 更新HkPushMemberTag
	 * @param pushInfo
	 * @throws Exception
	 */
	public void updateHkPushMemberTag(HKPushInfo pushInfo,List<HkPushMemberTag> list) throws Exception;
	
	/**
	 * 根据tag删除HkPushMemberTag
	 * @param pushInfo
	 * @throws Exception
	 */
	public void deleteHkPushMemberTag(HKPushInfo pushInfo) throws Exception;
	
	/**
	 * 将tag和memberIds转换成HkPushMemberTag对象
	 * @param pushInfo
	 * @return
	 */
	public List<HkPushMemberTag> convertHKPushInfo(HKPushInfo pushInfo);
}