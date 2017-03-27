package com.push.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.push.model.HkPushMember;
import com.push.model.HKPushInfo;
import com.push.model.HkPushMessenger;


public interface PushMemberMapper {
    
	HkPushMember selectHkPushMemberByMemberId(HKPushInfo pushInfo); 
	
	void updateHkPushMember(HKPushInfo pushInfo);

	void saveHkPushMember(HKPushInfo pushInfo);
	
	List<HKPushInfo> queryAllMemberId();
	
	HkPushMember queryPushMemberByMemberId(@Param("memberId")String memberId); 
	
	void updateMemberLineStatus(@Param("tokenList")List<?> tokenList);
	
	
	
}