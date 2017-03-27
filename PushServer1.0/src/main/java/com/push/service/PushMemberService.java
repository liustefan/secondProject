package com.push.service;

import com.push.model.HKPushInfo;


/**
 * 
 * @author owner
 *
 */
public interface PushMemberService {
    
    /**
     * 更新HkPushMember
     * @param pushInfo
     */
    public void updateHkPushMember(HKPushInfo pushInfo) throws Exception;
    
    /**
     * 用户上线
     * @param pushInfo
     * @throws Exception
     */
    public void memberOnline(HKPushInfo pushInfo) throws Exception;
    
    
}