package com.bithealth.taskMgrCore.server;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.taskMgrCore.model.MemberMerge;
import com.bithealth.taskMgrCore.model.MemberMergeExample; 

public interface MemberMergeService extends GenericBaseService<MemberMerge,MemberMergeExample,Long > {   
	
	/**
	 * @Title:measureDataMerge 
	 * @Description:会员测量数据合并
	 * @author 谢美团 
	 * @throws
	 * @retrun void
	 */ 
	public void measureDataMerge(MemberMerge memberMerge);
	/**
	 * @Title:careDataMerge 
	 * @Description:会员关注数据合并
	 * @author 谢美团 
	 * @throws
	 * @retrun void
	 */ 
	public void careDataMerge(MemberMerge memberMerge);
	
	
	/**
	 * @Title:memberMerge 
	 * @Description:会员数据（测量，关注数据等）合并
	 * @author 谢美团 
	 * @throws
	 * @retrun void
	 */ 
	public void memberMerge();
	
}
