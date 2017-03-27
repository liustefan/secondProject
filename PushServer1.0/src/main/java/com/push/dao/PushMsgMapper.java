package com.push.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.push.model.HKDeplayPushBean;
import com.push.model.HKPushInfo;


public interface PushMsgMapper {
    
	void updateHkPushMemberMsgStatus(HKPushInfo pushInfo);
	
	List<HKPushInfo> selectHKPushInfoByMemberId(@Param("memberId")String memberId);
	
	/**
	 * 保存msg消息
	 * @param pushInfo
	 * @return
	 */
	int saveMessenger(HKPushInfo pushInfo);
	
	/**
	 * 批量保存msg和member的关联关系
	 * @param pushInfoList
	 * @return
	 */
	int saveMsgMemberBatch(List<HKPushInfo> pushInfoList);
	
	/**
	 * 保存单个msg 和 memberID 的关联关系
	 * @param pushInfo
	 * @return
	 */
	int saveMsgMember(HKPushInfo pushInfo);
	
	
	/**
	 * 查询延迟推送消息
	 * @param time
	 * @return
	 */
	List<HKDeplayPushBean> queryDeplayMsg(Long time);
	
	/**
	 * 通过msgID查询 推行消息内容
	 * @param msgId
	 * @return
	 */
	HKPushInfo queryPushInfoByMsgId(@Param("msgId")String msgId);
	
	
	/**
	 * 更新消息的缓存状态
	 * @param msgId
	 * @return
	 */
	int updateCacheStatusByMsgId(String msgId);
	
	
	
	
}