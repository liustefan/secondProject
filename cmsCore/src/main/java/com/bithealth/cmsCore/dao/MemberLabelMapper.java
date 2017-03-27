/*
 * MemberLabelMapper.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-09-02 Created
 */
package com.bithealth.cmsCore.dao;

import com.bithealth.cmsCore.model.MemberLabel;
import com.bithealth.cmsCore.model.MemberLabelExample;
import com.bithealth.sdk.core.generic.GenericBaseDao;

/**
 * 类名称: MemberLabelMapper  
 * 功能描述: 会员标签关系MemberLabelMapper接口
 * 日期: 2016年9月2日 下午1:35:26 
 * 
 * @author 周玉飞
 * @version  
 */
public interface MemberLabelMapper extends GenericBaseDao<MemberLabel, MemberLabelExample, Long> {

	int deleteMemLable(Integer id);

}