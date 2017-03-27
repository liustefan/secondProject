package com.bithealth.reportCore.facade.service;

import java.util.List;

import com.bithealth.reportCore.template.model.SingleTemplate;
import com.bithealth.reportCore.template.model.SingleTemplateExample;
import com.bithealth.reportCore.template.model.SummaryRelation;
import com.bithealth.reportCore.template.model.SummaryTemplate;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;




/**
 * 类名称: TemplateIFService  
 * 功能描述: 模板及而配置对外服务接口  
 * 日期: 2016年7月13日 上午11:52:22 
 * 
 * @author 谢美团
 * @version  
 */
public interface TemplateIFService{

	/**
	 * @Title:getSingleTemplateOrAuditDetailList 
	 * @Description:根据查询参数获取单项模板集合.  
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param page 分页参数
	 * @param example 查询参数
	 * @param isgetAuditDetail  是否关联查询单项模板中的单项审核明细列表
	 * @return 
	 * @throws
	 * @retrun List<SingleTemplate>
	 */ 
	public List<SingleTemplate> selectSingleTemplateOrAuditDetailList(Page<SingleTemplate> page,SingleTemplateExample example,boolean isgetAuditDetail);
	
	/**
	 * @Title:selectSingleTemplateBySummaryCode 
	 * @Description:获取汇总模板关联的单项模板列表. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param sumRepTempCode 汇总模板代码
	 * @return 
	 * @throws
	 * @retrun List<SingleTemplate>
	 */ 
	public List<SingleTemplate> selectSingleTemplateBySummaryCode(Integer sumRepTempCode);
	
	
	/**
	 * @Title:deleteSingleTemplate 
	 * @Description:删除单项模板. 
	 * 前置逻辑：单项模板已经关联汇总模板的，不予于删除。  
	 * @author 谢美团
	 * @param singleTemplate
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	public String deleteSingleTemplate(SingleTemplate singleTemplate);
	
	/**
	 * @Title:updateSingleTemplate 
	 * @Description:更新单项模板及其关联的审核明细. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param singleTemplate
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	public String updateSingleTemplate(SingleTemplate singleTemplate);
	
	/**
	 * @Title:insertSingleTemplate 
	 * @Description:新增单项模板及其关联的审核明细. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param singleTemplate
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	public String insertSingleTemplate(SingleTemplate singleTemplate);
	
	
	
	/**
	 * @Title:selectSummaryTemplateList 
	 * @Description:根据参数查询汇总模板列表. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param page
	 * @param summaryTemplate
	 * @return 
	 * @throws
	 * @retrun List<SummaryTemplate>
	 */ 
	public List<SummaryTemplate> selectSummaryTemplateList(Page<SummaryTemplate> page,SummaryTemplate summaryTemplate);
	
	
	/**
	 * @Title:deleteSummaryTemplate 
	 * @Description:删除汇总模板
	 * 前置逻辑：已关联套餐的汇总模板不予于删除.  
	 * @author 谢美团
	 * @param summaryTemplate
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	public String  deleteSummaryTemplate(SummaryTemplate summaryTemplate);
	
	
	/**
	 * @Title:updateSummaryTemplate 
	 * @Description:更新汇总模板及汇总审核明细
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param summaryTemplate
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	public String updateSummaryTemplate(SummaryTemplate summaryTemplate);
	
	/**
	 * @Title:insertSummaryTemplate 
	 * @Description:新增汇总模板. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param summaryTemplate
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	public String insertSummaryTemplate(SummaryTemplate summaryTemplate);
	
	
	
	/**
	 * @Title:deleteSummaryRelation 
	 * @Description:根据传入的单项模板集合删除汇总模板和单项模板之间的关联关系. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param relationList
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	public String deleteSummaryRelationByList(List<SummaryRelation>  relationList);
	
	
	/**
	 * @Title:deleteSummaryRelationByParam 
	 * @Description:根据参数删除汇总模板和单项模板之间的关联关系. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param summaryRelation
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	public String deleteSummaryRelationByParam(SummaryRelation  summaryRelation);
	
	
	/**
	 * @Title:insertSummaryRelation 
	 * @Description:批量保存汇总模板和单项模板之间的关联关系
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param relationList
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	public String insertSummaryRelation(List<SummaryRelation>  relationList);
	
	
	/**
	 * @Title:validateSingleTemplate 
	 * @Description：验证单项模板是否能够删除
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author 谢美团
	 * @param tempCode
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	public boolean isSingleTemplateCanDelete(Integer tempCode); 
	
	
	
	/**
	 * @Title:validateSingleTemplate 
	 * @Description：验证汇总模板是否能够删除
	 * 验证逻辑：已关联套餐的汇总模板不能删除.  
	 * @author 谢美团
	 * @param tempCode
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	public boolean isSummaryTemplateCanDelete(Integer sumRepTempCode); 
	
	
	/**
	 * @Title:validateSingleTemplateName 
	 * @Description:验证单项模板名称是否重复. 
	 * @author 谢美团
	 * @param name
	 * @return  名称可用 ，返回 true，不可用返回 false
	 * @throws
	 * @retrun boolean
	 */ 
	public boolean validateSingleTemplateName(SingleTemplate singleTemplate);
	
	/**
	 * @Title:validateSummaryTemplateName 
	 * @Description:验证汇总模板名称是否重复
	 * @author 谢美团
	 * @param summaryTemplate
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	public boolean validateSummaryTemplateName(SummaryTemplate summaryTemplate);
	
	
	/**
	 * @Title:validateDeleteTempalte 
	 * @Description:验证单项或汇总模板是否可删除
	 * @author 谢美团
	 * @param temlateCode
	 * @param type
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	public boolean validateDeleteTempalte(String temlateCode,String type);
	

	
	/**
	 * @Title:selectMaxAuditLevelByParams 
	 * @Description:获取单项模板或汇总模板的最大审核级别
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
	 * @Title:addSingelToSumTemplate_trans 
	 * @Description:汇总模板关联单项模板
	 * @author 谢美团
	 * @param sumRepTempCode
	 * @param tempCode
	 * @return 
	 * @throws
	 * @retrun Integer
	 */ 
	public Integer addSingelToSumTemplate_trans(String sumRepTempCodes,String tempCode);
	
	/**
	 * @Title:deleteSumTemplateRelation 
	 * @Description:删除汇总模板关联的单项模板
	 * @author 谢美团
	 * @param sumRepTempCodes
	 * @param tempCode
	 * @return 
	 * @throws
	 * @retrun Integer
	 */ 
	public Integer deleteSumTemplateRelation(String sumRepTempCodes,String tempCode);

	
}



