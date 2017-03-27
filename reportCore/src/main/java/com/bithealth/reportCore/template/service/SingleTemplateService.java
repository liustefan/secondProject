package com.bithealth.reportCore.template.service;

import java.util.List;
import java.util.Map;

import com.bithealth.sdk.core.generic.GenericBaseService;
import com.bithealth.reportCore.template.model.SingleTemplate;
import com.bithealth.reportCore.template.model.SingleTemplateExample; 

public interface SingleTemplateService extends GenericBaseService<SingleTemplate,SingleTemplateExample,Integer > {    
	
	
	/**
	 * @Title:selectSingleTemplateBySummaryCode 
	 * @Description:获取汇总模板关联的单项模板列表
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param sumRepTempCode
	 * @return 
	 * @throws
	 * @retrun List<SingleTemplate>
	 */ 
	public List<SingleTemplate> selectSingleTemplateBySummaryCode(Integer sumRepTempCode);
	
	/**
	 * @Title:selectByOrgId 
	 * @Description:查询组织下的单项模板及其相关信息
	 * @author 谢美团
	 * @param orgId
	 * @return 
	 * @throws
	 * @retrun List<SingleTemplate>
	 */ 
	public List<SingleTemplate> selectByOrgId(Integer orgId) ;
	
	
	/**
	 * @Title:selectMaxAuditLevelByParams 
	 * @Description::获取单项模板模板的最大审核级别
	 * @author 谢美团
	 * @param orgId
	 * @param funId
	 * @param optId
	 * @return 
	 * @throws
	 * @retrun Integer
	 */ 
	public Integer selectMaxAuditLevelByParams(Integer orgId,Short funId,Short optId);
	
	
	/**
	 * @Title:selectOtherSingelTemplateList 
	 * @Description:获取汇总模板关联之外的单项模板集合
	 * @author 谢美团
	 * @param sumRepTempCode
	 * @param orgId
	 * @return 
	 * @throws
	 * @retrun List<SingleTemplate>
	 */ 
	public List<SingleTemplate> selectOtherSingelTemplateList(Integer sumRepTempCode,Integer orgId);
	
	
	
	
	
}
