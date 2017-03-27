package com.push.service;

import java.util.List;

import com.push.model.HKPushInfo;
import com.push.result.ResultObject;


/**
 * 
 * @author owner
 *
 */
public interface PushMsgService {
    
	/**
	 * 更新消息发送状态
	 * @param pushInfo
	 * @throws Exception
	 */
	public void updateHkPushMemberMsgStatus(HKPushInfo pushInfo) throws Exception;
	
	/**
	 * 根据memberId查询未推送的消息
	 * @param pushInfo
	 * @return
	 * @throws Exception
	 */
	public List<HKPushInfo> selectHKPushInfoByMemberId(HKPushInfo pushInfo) throws Exception;
	
    /**
     * 根据memberId推送消息
     * @param pushInfo
     * @return
     */
    public void pushByMemberId(HKPushInfo pushInfo) ;
    
    /**
     * 根据多个 memberId推送消息
     * @param pushInfo
     * @return
     */
    public void pushByMemberIds(HKPushInfo pushInfo);
    
    /**
     * 根据自定义的tag推送消息
     * @param pushInfo
     * @return
     */
    public ResultObject pushByTag(HKPushInfo pushInfo);
    
    /**
     * 根据多个tag 推送消息
     * @param pushInfo
     */
    public ResultObject pushByTags(HKPushInfo pushInfo);
    
    /**
     * 推送消息到应用所有绑定用户
     * @param pushInfo
     * @return
     */
    public void pushToAll(HKPushInfo pushInfo);
    
    /**
	 * 根据参数封装推送单条消息
	 * @param pushInfo
	 */
    public void pushSingleMsg(HKPushInfo pushInfo);
    
    /**
	 * 根据参数封装推送多条消息
	 * @param pushInfoList
	 */
    public void pushMultiMsg(List<HKPushInfo> pushInfoList);
  
}