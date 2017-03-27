package com.bithealth.questionCore.audit.service;

import java.util.List;

import com.bithealth.questionCore.audit.model.Oasr;
import com.bithealth.questionCore.audit.model.OasrExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;

public interface OasrService extends GenericBaseService<Oasr,OasrExample,
   Long > {    
	
	List<Oasr> selectSingleAnswerAuditByExampleAndPage(Page<Oasr> page, OasrExample example);
	
	List<Oasr> selectComAnswerAuditByExampleAndPage(Page<Oasr> page, OasrExample example);
	
	int updateByPrimaryKeySelective(Oasr model);
}
