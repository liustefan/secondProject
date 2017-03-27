package com.bithealth.reportCore.facade.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bithealth.doctorCore.docGroup.model.DoctorGroup;
import com.bithealth.doctorCore.docGroup.model.DoctorGroupExample;
import com.bithealth.doctorCore.docGroup.service.DoctorGroupService;
import com.bithealth.packagCore.packag.model.PackagDetail;
import com.bithealth.packagCore.packag.model.PackagDetailExample;
import com.bithealth.packagCore.packag.service.PackagDetailService;
import com.bithealth.reportCore.facade.constants.ReportConstants;
import com.bithealth.reportCore.facade.service.TemplateIFService;
import com.bithealth.reportCore.template.model.SingleAuditDetail;
import com.bithealth.reportCore.template.model.SingleAuditDetailExample;
import com.bithealth.reportCore.template.model.SingleTemplate;
import com.bithealth.reportCore.template.model.SingleTemplateExample;
import com.bithealth.reportCore.template.model.SummaryAuditDetail;
import com.bithealth.reportCore.template.model.SummaryAuditDetailExample;
import com.bithealth.reportCore.template.model.SummaryRelation;
import com.bithealth.reportCore.template.model.SummaryRelationExample;
import com.bithealth.reportCore.template.model.SummaryRelationKey;
import com.bithealth.reportCore.template.model.SummaryTemplate;
import com.bithealth.reportCore.template.model.SummaryTemplateExample;
import com.bithealth.reportCore.template.service.AuditOpinionTemplateService;
import com.bithealth.reportCore.template.service.SingleAuditDetailService;
import com.bithealth.reportCore.template.service.SingleTemplateService;
import com.bithealth.reportCore.template.service.SummaryAuditDetailService;
import com.bithealth.reportCore.template.service.SummaryRelationService;
import com.bithealth.reportCore.template.service.SummaryTemplateService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: TemplateIFServiceImpl  
 * 功能描述: 模板及而配置对外服务接口 实现类  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月13日 下午1:31:24 
 * 
 * @author 谢美团
 * @version  
 */
@Service("templateIFService") 
public class TemplateIFServiceImpl implements TemplateIFService{
	
	private Logger logger=Logger.getLogger(TemplateIFServiceImpl.class);
	
	@Resource
	SingleTemplateService singleTemplateService;
	
	@Resource
	AuditOpinionTemplateService auditOpinionService;
	
	@Resource
	SingleAuditDetailService singleAuditDetailService;
	
	@Resource
	SummaryRelationService summaryRelationService;
	
	@Resource
	SummaryTemplateService summaryTemplateService;
	
	@Resource
	SummaryAuditDetailService summaryAuditDetailService;
	
	@Resource
	PackagDetailService packagDetailService;
	
	@Resource
	DoctorGroupService doctorGroupService;
	
	@Resource
	SummaryAuditDetailService sumAuditDetailService;
	
	

	public List<SingleTemplate> selectSingleTemplateOrAuditDetailList(Page<SingleTemplate> page, SingleTemplateExample example,boolean isgetAuditDetail) {
		
		List<SingleTemplate> singleTemplateList = new ArrayList<SingleTemplate>();
		singleTemplateList = singleTemplateService.selectByExampleAndPage(page, example);
		if(isgetAuditDetail && singleTemplateList !=null){
			for(SingleTemplate singleTemplate:singleTemplateList){
				SingleAuditDetailExample singleAuditDetailExample = new SingleAuditDetailExample();
				//根据单项模板代码查询单项审核明细列表
				singleAuditDetailExample.createCriteria().andTempCodeEqualTo(singleTemplate.getTempCode()).andTagEqualTo("T");
				List<SingleAuditDetail> detailList = singleAuditDetailService.selectByExample(singleAuditDetailExample);
				singleTemplate.setSingleAuditDetail(detailList);
			}
		}
		return singleTemplateList;
	}

	public List<SingleTemplate> selectSingleTemplateBySummaryCode(Integer sumRepTempCode) {
		
		return singleTemplateService.selectSingleTemplateBySummaryCode(sumRepTempCode);
		 
	}

	public String deleteSingleTemplate(SingleTemplate singleTemplate) {

		//将单项模板主表数据进行逻辑删除
		singleTemplate.setValiTag("F");
		singleTemplateService.update(singleTemplate);
		
		//逻辑删除单项模板审核明细
		SingleAuditDetailExample  example = new SingleAuditDetailExample ();
		example.createCriteria().andTempCodeEqualTo(singleTemplate.getTempCode());
		SingleAuditDetail  singleAuditDetail  = new SingleAuditDetail ();
		singleAuditDetail.setTag("F");
		singleAuditDetailService.updateByExampleSelective(singleAuditDetail, example);
		
		//同步医生分组审核级别数据
		singleTemplate = singleTemplateService.selectById(singleTemplate.getTempCode());
		syncdoctorGroup(singleTemplate);
		
		return ReportConstants.SUCCESS;
	}

	public String updateSingleTemplate(SingleTemplate singleTemplate) {

		//更新单线模板主表
		singleTemplateService.update(singleTemplate);
		//更新单项模板审核明细
		SingleAuditDetailExample example = new SingleAuditDetailExample();
		example.createCriteria().andTempCodeEqualTo(singleTemplate.getTempCode());
		// 1.先删除原有的明细列表
		singleAuditDetailService.deleteByExample(example);
		
		// 2.插入新的明细列表
		if(singleTemplate.getSingleAuditDetail() != null){
			for(SingleAuditDetail singleAuditDetail:singleTemplate.getSingleAuditDetail()){
				singleAuditDetail.setTempCode(singleTemplate.getTempCode());
				singleAuditDetail.setSubmitOther(singleAuditDetail.getSubmitOther() == null?"N":singleAuditDetail.getSubmitOther());
			}
			singleAuditDetailService.insertBatch(singleTemplate.getSingleAuditDetail());
		}
		
		//同步医生分组审核级别数据
		syncdoctorGroup(singleTemplate);
		
		return ReportConstants.SUCCESS;
	}

	public String insertSingleTemplate(SingleTemplate singleTemplate) {
		
		//插入单项模板主表
		singleTemplateService.insert(singleTemplate);
		if(singleTemplate.getSingleAuditDetail() != null && singleTemplate.getSingleAuditDetail().size() > 0){
			for(SingleAuditDetail singleAuditDetail:singleTemplate.getSingleAuditDetail()){
				singleAuditDetail.setTempCode(singleTemplate.getTempCode());
				singleAuditDetail.setSubmitOther(singleAuditDetail.getSubmitOther() == null?"N":singleAuditDetail.getSubmitOther());
			}
			//批量插入单项模板关联的审核明细
			singleAuditDetailService.insertBatch(singleTemplate.getSingleAuditDetail());
		}
		//同步医生分组审核级别数据
		syncdoctorGroup(singleTemplate);
		
		return ReportConstants.SUCCESS;
	}

	
	
	/**
	 * @Title:syncdoctorGroup 
	 * @Description:同步医生分组审核级别数据 
	 * @author 谢美团
	 * @param singleTemplate 
	 * @throws
	 * @retrun void
	 */ 
	private void syncdoctorGroup(SingleTemplate singleTemplate){
		//根据医生分组确定单项测量的审核级别
		DoctorGroupExample example = new DoctorGroupExample();
		example.createCriteria().andOptidEqualTo(singleTemplate.getOptId()).andFunidEqualTo(singleTemplate.getFunId()).andOrgidEqualTo(singleTemplate.getOrgId());
		example.setOrderByClause("chlevel desc");
		List<DoctorGroup>  doctorGrouplsit = doctorGroupService.selectByExample(example);
		if(doctorGrouplsit != null && doctorGrouplsit.size() > 0 && doctorGrouplsit.get(0).getChlevel() != null){
			Integer maxAuditLevel = selectMaxAuditLevelByParams(singleTemplate.getOrgId(),singleTemplate.getFunId(),singleTemplate.getOptId());
			if(maxAuditLevel != null){
				DoctorGroupExample exampleUpdate = new DoctorGroupExample();
				exampleUpdate.createCriteria().andOrgidEqualTo(singleTemplate.getOrgId())
							 .andOptidEqualTo(singleTemplate.getOptId()).andFunidEqualTo(singleTemplate.getOptId());
				DoctorGroup doctorGroup = new DoctorGroup();
				doctorGroup.setChlevel(maxAuditLevel.shortValue());
				doctorGroupService.updateByExampleSelective(doctorGroup, exampleUpdate);
			}else{
				doctorGroupService.updateTemParamClear(singleTemplate.getOrgId(), singleTemplate.getOptId(), singleTemplate.getOptId());
			}
		}
	}
	
	
	public List<SummaryTemplate> selectSummaryTemplateList(Page<SummaryTemplate> page, SummaryTemplate summaryTemplate) {
		
		SummaryTemplateExample example = new SummaryTemplateExample();
		example.createCriteria().andValiTagEqualTo("T").andOrgIdEqualTo(summaryTemplate.getOrgId());
		List<SummaryTemplate> summaryTemplateList = summaryTemplateService.selectByExampleAndPage(page, example);
		
		//比较汇总模板的最大间隔天数是否大于其所关联的任意一单项模板的周期
		for(SummaryTemplate template:summaryTemplateList){
			List<SingleTemplate> singleList = singleTemplateService.selectSingleTemplateBySummaryCode(template.getSumRepTempCode());
			String warnFlag = compareSummaryMaxMumDay(singleList,template.getMaxMumDay());
			template.setWarnFlag(warnFlag);
			SummaryRelationExample relationExample = new SummaryRelationExample();
			relationExample.createCriteria().andSumRepTempCodeEqualTo(template.getSumRepTempCode());
			List<SummaryRelation> lsit = summaryRelationService.selectByExample(relationExample);
			if(lsit != null && lsit.size() > 0){
				template.setIsAddSingleTempalte("T");
			}else{
				template.setIsAddSingleTempalte("F");
			}
		}
		return summaryTemplateList;
	}

	/**
	 * @Title:compareSummaryMaxMumDay 
	 * @Description:比较汇总模板最大间隔天数是否大于其所关联的任一单项模板的周期
	 * @author 谢美团
	 * @param singleList
	 * @param maxMumDay
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	private String compareSummaryMaxMumDay(List<SingleTemplate> singleList,Short maxMumDay){
		
		for(SingleTemplate singleTemplate:singleList){
			if(singleTemplate.getMaxCycle() != null && singleTemplate.getMaxCycle() > maxMumDay){
				return "T";
			}
		}
		return "F";
	}
	
	

	public String deleteSummaryTemplate(SummaryTemplate summaryTemplate) {
		
		//逻辑删除汇总套餐主表数据
		summaryTemplate.setValiTag("T");
		summaryTemplateService.update(summaryTemplate);
		
		//逻辑删除汇总套餐关联的审核明细列表(由于表中没有 字段标识 删除状态，只能物理删除)
		SummaryAuditDetailExample  example = new SummaryAuditDetailExample();
		example.createCriteria().andSumRepTempCodeEqualTo(summaryTemplate.getSumRepTempCode());
		summaryAuditDetailService.deleteByExample(example);
		
		return ReportConstants.SUCCESS;
	}

	public String updateSummaryTemplate(SummaryTemplate summaryTemplate) {
		//更新汇总模板主表数据
		summaryTemplateService.update(summaryTemplate);
		
		//更新汇总目标关联的审核明细
		SummaryAuditDetailExample  example = new SummaryAuditDetailExample();
		example.createCriteria().andSumRepTempCodeEqualTo(summaryTemplate.getSumRepTempCode());
		// 1.删除原有汇总模板审核明细
		summaryAuditDetailService.deleteByExample(example);
		if(summaryTemplate.getSummaryAuditDetail() != null){
			for(SummaryAuditDetail detail:summaryTemplate.getSummaryAuditDetail()){
				detail.setSumRepTempCode(summaryTemplate.getSumRepTempCode());
			}
			// 2.批量获取汇总模板审核明细
			summaryAuditDetailService.insertBatch(summaryTemplate.getSummaryAuditDetail());
		}
		
		return ReportConstants.SUCCESS;
	}

	public String insertSummaryTemplate(SummaryTemplate summaryTemplate) {
		
		//插入汇总模板主表数据
		summaryTemplateService.insert(summaryTemplate);
		
		if(summaryTemplate.getSummaryAuditDetail() != null){
			for(SummaryAuditDetail detail:summaryTemplate.getSummaryAuditDetail()){
				detail.setSumRepTempCode(summaryTemplate.getSumRepTempCode());
				if(detail.getSubmitOther() == null || detail.getSubmitOther().equals("")){
					detail.setSubmitOther("N");
				}else{
					detail.setSubmitOther("Y");
				}
			}
			//批量插入汇总模板审核明细列表
			summaryAuditDetailService.insertBatch(summaryTemplate.getSummaryAuditDetail());
		}

		return ReportConstants.SUCCESS;
	}

	public String deleteSummaryRelationByList(List<SummaryRelation> relationList) {
		int rows = summaryRelationService.deleteSummaryRelationByList(relationList);
		if(rows == 0){
			return "没有删除任何的汇总模板关联的单项模板";
		}else{
			return ReportConstants.SUCCESS;
		}
		
	}

	public String deleteSummaryRelationByParam(SummaryRelation summaryRelation) {
		if(summaryRelation.getSumRepTempCode() == null ){
			logger.error("汇总模板代码为空，删除失败");
			return "汇总模板代码为空，删除失败";
		}
		SummaryRelationExample example = new SummaryRelationExample();
		example.createCriteria().andSumRepTempCodeEqualTo(summaryRelation.getSumRepTempCode());
		summaryRelationService.deleteByExample(example);
		
		return ReportConstants.SUCCESS;
	}

	public String insertSummaryRelation(List<SummaryRelation> relationList) {
		
		int rows = summaryRelationService.insertByBatch(relationList);
		if(rows == 0){
			logger.error("list参数为空，没有插入任何汇总模板关联和单项模板之间的关联关系");
			return "list参数为空";
		}else{
			return ReportConstants.SUCCESS;
		}
	}

	
	
	public boolean isSingleTemplateCanDelete(Integer tempCode) {
		SummaryRelationExample example = new SummaryRelationExample();
		example.createCriteria().andTempCodeEqualTo(tempCode);
		List<SummaryRelation> summaryRelationList = summaryRelationService.selectByExample(example);
		if(summaryRelationList == null || summaryRelationList.size() == 0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isSummaryTemplateCanDelete(Integer sumRepTempCode) {
		//根据汇总模板代码验证其是否已关联套餐（包括有效的套餐和无效的套餐）
		PackagDetailExample example = new PackagDetailExample ();
		example.createCriteria().andSumRepTempCodeEqualTo(sumRepTempCode);
		Page<PackagDetail> page = new Page<PackagDetail>();
		List<PackagDetail>  lsit = packagDetailService.selectByExampleAndPage(page, example);
		if(lsit != null && lsit.size() == 0){
			return true;
		}else{
			return false;
		}
	}
	
	

	public boolean validateSingleTemplateName(SingleTemplate singleTemplate) {
		if(singleTemplate.getTempName() == null || singleTemplate.getOrgId() == null ){
			logger.info("单项模板名称或组织id为空，验证单项模板名称是否可用失败。");
			return false;
		}
		SingleTemplateExample example = new SingleTemplateExample();
		example.createCriteria().andTempNameEqualTo(singleTemplate.getTempName()).andOrgIdEqualTo(singleTemplate.getOrgId()).andValiTagEqualTo("T");
		Page<SingleTemplate> page = new Page<SingleTemplate>();
		List<SingleTemplate> list = singleTemplateService.selectByExampleAndPage(page, example);
		if(list != null && list.size() == 0){
			return true;
		}else{
			return false;
		}
	}

	public boolean validateSummaryTemplateName(SummaryTemplate summaryTemplate) {
		if(summaryTemplate.getTempName() == null || summaryTemplate.getOrgId() == null ){
			logger.info("汇总模板名称或组织id为空，验证汇总模板名称是否可用失败。");
			return false;
		}
		Page<SummaryTemplate> page = new Page<SummaryTemplate>();
		SummaryTemplateExample example = new SummaryTemplateExample();
		example.createCriteria().andTempNameEqualTo(summaryTemplate.getTempName()).andOrgIdEqualTo(summaryTemplate.getOrgId()).andValiTagEqualTo("T");
		List<SummaryTemplate>  lsit = summaryTemplateService.selectByExampleAndPage(page, example);
		if(lsit != null && lsit.size() == 0){
			return true;
		}else{
			return false;
		}
	}

	public boolean validateDeleteTempalte(String temlateCode, String type) {
		if("1".equals(type)){ //单项模板
			SummaryRelationExample example = new SummaryRelationExample();
			example.createCriteria().andTempCodeEqualTo(Integer.parseInt(temlateCode));
			 List<SummaryRelation> lsit = summaryRelationService.selectByExample(example);
			 if(lsit != null && lsit.size() > 0){
				 return false;
			 }else{
				 return true;
			 }
    	}else if("2".equals(type)){// 汇总模板
    		if(isSummaryTemplateCanDelete(Integer.parseInt(temlateCode))){
    			return true;
    		} else{
    			return false;
    		}
    	}else{
    		return false;
    	}
	}

	public Integer selectMaxAuditLevelByParams(Integer orgId, Short funId,Short optId) {
		if(funId == 1){ //单项测量模板
			return singleTemplateService.selectMaxAuditLevelByParams(orgId, funId, optId);
		}else if(funId == 2){//汇总测量模板
			return summaryTemplateService.selectMaxAuditLevelByParams(orgId);
		}else{
			return null;
		}
	}

	public Integer addSingelToSumTemplate_trans(String sumRepTempCode,String tempCodes) {
		
		String[] tempCodeList =  tempCodes.split(",");
		List<SummaryRelation> list = new ArrayList<SummaryRelation>();
		for(String tempCode:tempCodeList){
			SummaryRelation summaryRelation = new SummaryRelation();
			summaryRelation.setSumRepTempCode(Integer.parseInt(sumRepTempCode));
			summaryRelation.setTempCode(Integer.parseInt(tempCode));
			list.add(summaryRelation);
		}
		return summaryRelationService.insertByBatch(list);
	}

	public Integer deleteSumTemplateRelation(String sumRepTempCode,String tempCodes) {
		String[] tempCodeList =  tempCodes.split(",");
		for(String tempCode:tempCodeList){
			if(!"".equals(tempCode) && sumRepTempCode != null && !"".equals(sumRepTempCode)){
				SummaryRelationKey summaryRelation = new SummaryRelationKey();
				summaryRelation.setSumRepTempCode(Integer.parseInt(sumRepTempCode));
				summaryRelation.setTempCode(Integer.parseInt(tempCode));
				summaryRelationService.delete(summaryRelation);
			}
		}
		return 0;
	}


	
	
	
	
	
}



