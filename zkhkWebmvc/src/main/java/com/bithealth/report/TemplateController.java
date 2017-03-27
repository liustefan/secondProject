package com.bithealth.report;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bithealth.reportCore.facade.enmu.FunctionEnmu;
import com.bithealth.reportCore.facade.service.ReportIFService;
import com.bithealth.reportCore.facade.service.TemplateIFService;
import com.bithealth.reportCore.report.model.SummaryReport;
import com.bithealth.reportCore.template.model.AuditOpinionTemplate;
import com.bithealth.reportCore.template.model.AuditOpinionTemplateExample;
import com.bithealth.reportCore.template.model.Option;
import com.bithealth.reportCore.template.model.OptionExample;
import com.bithealth.reportCore.template.model.SingleTemplate;
import com.bithealth.reportCore.template.model.SingleTemplateExample;
import com.bithealth.reportCore.template.model.SummaryAuditDetail;
import com.bithealth.reportCore.template.model.SummaryAuditDetailExample;
import com.bithealth.reportCore.template.model.SummaryTemplate;
import com.bithealth.reportCore.template.service.AuditOpinionTemplateService;
import com.bithealth.reportCore.template.service.OptionService;
import com.bithealth.reportCore.template.service.SingleTemplateService;
import com.bithealth.reportCore.template.service.SummaryAuditDetailService;
import com.bithealth.reportCore.template.service.SummaryTemplateService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;


@Controller
@RequestMapping(value = "/template")
public class TemplateController extends BaseSpringController {

    @Resource
    private ReportIFService reportIFService;
    @Resource
    TemplateIFService templateIFService;
    
    @Resource
    AuditOpinionTemplateService   auditOpinionTemplateService;
    
    @Resource
    SummaryTemplateService summaryTemplateService;
    
    @Resource
    SingleTemplateService singleTemplateService;
    
    @Resource
    OptionService optionService;
    
    @Resource
    SummaryAuditDetailService summaryAuditDetailService;
    
    
    
    private static Logger logger=Logger.getLogger(TemplateController.class);

    /**
     * @Title:getOpintionTemplatList 
     * @Description:根据参数获取审核意见模板列表(返回json)
     * @author 谢美团
     * @param session
     * @param page
     * @param type
     * @param orgId
     * @return 
     * @throws
     * @retrun Page<AuditOpinionTemplate>
     */ 
    @ResponseBody
    @RequestMapping(value = "/getOpintionTemplatList")
    public Page<AuditOpinionTemplate> getOpintionTemplatList(Page<AuditOpinionTemplate> page,String type,String orgId) {
    	page = new Page<AuditOpinionTemplate>(page.getPageNo(),page.getPageSize());
        AuditOpinionTemplateExample example = new AuditOpinionTemplateExample();
        example.createCriteria().andTypeEqualTo(Integer.parseInt(type)).andOrgIdEqualTo(Integer.parseInt(orgId));
        //执行查询，查询结果List在page对象中回获取
        auditOpinionTemplateService.selectByExampleAndPage(page, example);
        return page;
    }
   
    /**
     * @Title:getOpintionTemplatByKey 
     * @Description:根据主键获取审核意见模板的详细内容，并以json的格式返回
     * @author 谢美团
     * @param id
     * @return 
     * @throws
     * @retrun AuditOpinionTemplate
     */ 
    @ResponseBody
    @RequestMapping(value = "/getOpintionTemplat")
    public AuditOpinionTemplate getOpintionTemplatByKey(String id){
    	return auditOpinionTemplateService.selectById(Integer.parseInt(id));
    }
    
    
    /**
     * @Title:getMaxMumDay 
     * @Description:根据汇总模板代码获取汇总模板最大间隔天数
     * @author 谢美团
     * @param sumRepTempCode
     * @return 
     * @throws
     * @retrun String
     */ 
    @ResponseBody
    @RequestMapping(value = "/getMaxMumDay")
    public String getMaxMumDay(String sumRepTempCode){
    	
    	SummaryTemplate summaryTemplate = summaryTemplateService.selectById(Integer.parseInt(sumRepTempCode));
    	
    	return summaryTemplate.getMaxMumDay().toString();
    }
    
    
    /**
     * @Title:getSingleTemplateList 
     * @Description:获取组织下的单项模板 列表
     * @author 谢美团
     * @param model
     * @param request
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/getSingleTemplateList")
    public String getSingleTemplateList(ModelMap model){
    	ShiroUser shiroUser =getCurentUser();
    	List<SingleTemplate>  templatelist =singleTemplateService.selectByOrgId(shiroUser.getDept_id());
    	model.put("templatelist", templatelist);
    	return "/report/template/singleTemplate";
    }
    
    
    /**
     * @Title:validateDeleteSingleTemplate 
     * @Description:验证模板是否可删除
     * @author 谢美团
     * @param tempCode
     * @param type
     * @return 
     * @throws
     * @retrun String
     */ 
    @ResponseBody
    @RequestMapping(value = "/validateDeleteTemplate")
    public String validateDeleteTemplate(String tempCode,String type){
    	if(templateIFService.validateDeleteTempalte(tempCode, type)){
    		return "OK";
    	}else{
    		return null;
    	}
    }
    
    /**
     * @Title:deleteTemplate 
     * @Description:删除单项或者汇总模板
     * @author 谢美团
     * @param tempCode
     * @param type
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/deleteTemplate")
    public String deleteTemplate(String tempCode,String type){
    	
    	if("1".equals(type)){
    		SingleTemplate singleTemplate = new SingleTemplate();
    		singleTemplate.setTempCode(Integer.parseInt(tempCode));
    		templateIFService.deleteSingleTemplate(singleTemplate);
    		return "redirect:/template/getSingleTemplateList";
    	}else{
    		SummaryTemplate summaryTemplate = new SummaryTemplate();
    		summaryTemplate.setSumRepTempCode(Integer.parseInt(tempCode));
    		templateIFService.deleteSummaryTemplate(summaryTemplate);
    		return "redirect:/template/getSumTemplateList";
    	}
    }
    
    
    @RequestMapping(value = "/toEditSingleTemplate")
    public String toEditSingleTemplate(String tempCode,ModelMap model){
    	//获取单项模板及其明细
    	Page<SingleTemplate> page = new Page<SingleTemplate>();
    	SingleTemplateExample templateExample = new SingleTemplateExample();
    	templateExample.createCriteria().andTempCodeEqualTo(Integer.parseInt(tempCode));
    	List<SingleTemplate> singleTemplateList = templateIFService.selectSingleTemplateOrAuditDetailList(page, templateExample, true);
    	SingleTemplate singleTemplate = singleTemplateList.get(0);
    	singleTemplate.setOrgId(getCurentUser().getDept_id());
    	
    	//获取选项列表
    	OptionExample example = new OptionExample();
    	example.createCriteria().andFunIdEqualTo((short)FunctionEnmu.SINGLE_MEASURE.getValue());
    	List<Option> optionList = optionService.selectByExample(example);
    	
    	model.put("optionList", optionList);
    	model.put("singleTemplate", singleTemplate);
    	return "/report/template/singleTemplateEdit";
    }
    
    
    
    /**
     * @Title:toAddSingleTemplatePage 
     * @Description:跳转到单项模板新增页面
     * @author 谢美团
     * @param request
     * @param funId
     * @param model
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/toAddSingleTemplatePage")
    public String toAddSingleTemplatePage(String funId,ModelMap model){
    	ShiroUser shiroUser = getCurentUser();
    	SingleTemplate singleTemplate = new SingleTemplate();
    	singleTemplate.setOrgId(shiroUser.getDept_id());
    	singleTemplate.setFunId(Short.parseShort(funId));
    	//获取选项列表
    	OptionExample example = new OptionExample();
    	example.createCriteria().andFunIdEqualTo(Short.parseShort(funId));
    	List<Option> optionList = optionService.selectByExample(example);
    	model.put("optionList", optionList);
    	model.put("orts", singleTemplate);
    	return "/report/template/singleTemplateAdd";
    }
    
    
    /**
     * @Title:validateSingleTemplateName 
     * @Description:验证单项模板名称是否可用
     * @author 谢美团
     * @param request
     * @param templateName
     * @return 
     * @throws
     * @retrun String
     */ 
    @ResponseBody
    @RequestMapping(value = "/validateSingleTemplateName")
    public String validateSingleTemplateName(String templateName){
    	ShiroUser shiroUser =getCurentUser();
    	SingleTemplate singleTemplate = new SingleTemplate();
    	singleTemplate.setTempName(templateName);
    	singleTemplate.setOrgId(shiroUser.getDept_id());
    	if(templateIFService.validateSingleTemplateName(singleTemplate)){
    		return "OK";
    	}else{
    		return null;
    	}
    }
    
    @ResponseBody
    @RequestMapping(value = "/validateSumTemplateName")
    public String validateSumTemplateName(String templateName){
    	ShiroUser shiroUser =getCurentUser();
    	SummaryTemplate sumTemplate = new SummaryTemplate();
    	sumTemplate.setTempName(templateName);
    	sumTemplate.setOrgId(shiroUser.getDept_id());
    	if(templateIFService.validateSummaryTemplateName(sumTemplate)){
    		return "OK";
    	}else{
    		return null;
    	}
    }
    
    
    /**
     * @Title:saveOrUpdateSingleTemplate 
     * @Description:新增或者修改单项模板
     * @author 谢美团
     * @param singleTemplate
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/saveOrUpdateSingleTemplate")
    public String saveOrUpdateSingleTemplate(SingleTemplate singleTemplate){
    	singleTemplate.setOrgId(getCurentUser().getDept_id());
    	if(singleTemplate.getTempCode() == null){ //新增
    		templateIFService.insertSingleTemplate(singleTemplate);
    	}else{ //修改
    		templateIFService.updateSingleTemplate(singleTemplate);
    	}
    	return "redirect:/template/getSingleTemplateList";
    }
    
    
    /**
     * @Title:getSumTemplateList 
     * @Description:获取组织下的汇总模板列表
     * @author 谢美团
     * @param model
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/getSumTemplateList")
    public String getSumTemplateList(ModelMap model){
    	Page<SummaryTemplate> page = new Page<SummaryTemplate>(1,100);
    	SummaryTemplate summaryTemplate = new SummaryTemplate();
    	summaryTemplate.setOrgId(getCurentUser().getDept_id());
    	List<SummaryTemplate>  sumTemplatelist = templateIFService.selectSummaryTemplateList(page, summaryTemplate);
    	model.put("sumTemplatelist", sumTemplatelist);
    	return "/report/template/sumTemplateList";
    }
    
    
    /**
     * @Title:saveOrUpdateSummaryTemplate 
     * @Description:新增或修改汇总模板
     * @author 谢美团
     * @param summaryTemplate
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/saveOrUpdateSummaryTemplate")
    public String saveOrUpdateSummaryTemplate(SummaryTemplate summaryTemplate){
    	summaryTemplate.setOrgId(getCurentUser().getDept_id());
    	if(summaryTemplate.getSumRepTempCode() == null){ //新增
    		templateIFService.insertSummaryTemplate(summaryTemplate);
    	}else{//修改
    		templateIFService.updateSummaryTemplate(summaryTemplate);
    	}
    	
    	return "redirect:/template/getSumTemplateList";
    }
    
    /**
     * @Title:toAddSummaryTemplatePage 
     * @Description:跳转到新增汇总模板页面
     * @author 谢美团
     * @param summaryTemplate
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/toAddSummaryTemplatePage")
    public String toAddSummaryTemplatePage(SummaryTemplate summaryTemplate){
    	return "/report/template/SumTemplateAdd";
    }
    
    
    /**
     * @Title:toEditSumTemplate 
     * @Description:跳转到汇总模板编辑页面
     * @author 谢美团
     * @param sumRepTempCode
     * @param model
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/toEditSumTemplate")
    public String toEditSumTemplate(String sumRepTempCode,ModelMap model){
    	//获取汇总模板及其明细
    	SummaryTemplate  summaryTemplate  = summaryTemplateService.selectById(Integer.parseInt(sumRepTempCode));
    	SummaryAuditDetailExample  example  = new SummaryAuditDetailExample ();
    	example.createCriteria().andSumRepTempCodeEqualTo(Integer.parseInt(sumRepTempCode));
    	List<SummaryAuditDetail>  list = summaryAuditDetailService.selectByExample(example);
    	summaryTemplate.setSummaryAuditDetail(list);
    	
    	model.put("sumTemplate", summaryTemplate);
    	return "/report/template/sumTemplateEdit";
    }
    
    
    /**
     * @Title:getOtherSingleTemplateList 
     * @Description:获取汇总模板已经关联 之外的单项模板集合
     * @author 谢美团
     * @param sumRepTempCode
     * @param model
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/getOtherSingleTemplateList")
    public String getOtherSingleTemplateList(String sumRepTempCode,ModelMap model){
    	//获取汇总模板已关联之外的该组织下的所有单项模板
    	List<SingleTemplate>  list = singleTemplateService.selectOtherSingelTemplateList(Integer.parseInt(sumRepTempCode), getCurentUser().getDept_id());
    	model.put("SingleTemplateList", list);
    	model.put("sumRepTempCode", sumRepTempCode);
    	return "/report/template/addSingleToSum";
    }
    
    
    /**
     * @Title:addSingelToSumTemplate 
     * @Description:汇总模板关联添加单项模板
     * @author 谢美团
     * @param sumRepTempCodes
     * @param tempCode
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/addSingelToSumTemplate")
    public String addSingelToSumTemplate(String sumRepTempCode,String tempCodes){
    	
    	templateIFService.addSingelToSumTemplate_trans(sumRepTempCode,tempCodes);

    	return "redirect:/template/getSumTemplateList";
    }
    
    
    /**
     * @Title:getSumRelationSinglTemplate 
     * @Description:获取汇总模板关联的单项目模板
     * @author 谢美团
     * @param sumRepTempCode
     * @param model
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/getSumRelationSinglTemplate")
    public String getSumRelationSinglTemplate(String sumRepTempCode,ModelMap model){
    	
    	List<SingleTemplate>  list = singleTemplateService.selectSingleTemplateBySummaryCode(Integer.parseInt(sumRepTempCode));
    	model.put("singleTemplateList", list);
    	model.put("sumRepTempCode", sumRepTempCode);
    	return "/report/template/sumTemplateRelationPage";
    }
    
    /**
     * @Title:delSumTemplateRelation 
     * @Description:删除汇总模板关联的单项模板 
     * @author 谢美团
     * @param sumRepTempCodes
     * @param tempCode
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/delSumTemplateRelation")
    public String delSumTemplateRelation(String sumRepTempCode,String tempCodes){
    	templateIFService.deleteSumTemplateRelation(sumRepTempCode, tempCodes);
    	return "redirect:/template/getSumRelationSinglTemplate?sumRepTempCode="+sumRepTempCode;
    }
   

    /**
     * @Title:toOpintionTemplatPage 
     * @Description:获取审核意见模板，并跳转到审核意见模板列表页面
     * @author 谢美团
     * @param page
     * @param model
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/toOpintionTemplatPage")
    public String toOpintionTemplatPage(Page<AuditOpinionTemplate> page,ModelMap model) {
    	page = new Page<AuditOpinionTemplate>(page.getPageNo(),page.getPageSize());
        AuditOpinionTemplateExample example = new AuditOpinionTemplateExample();
        example.createCriteria().andOrgIdEqualTo(getCurentUser().getDept_id());
        //执行查询，查询结果List在page对象中回获取
        auditOpinionTemplateService.selectByExampleAndPage(page, example);
        model.put("page", page);
        
        return "/report/template/opinionTemplateList";
    }
    
    /**
     * @Title:toAddTemplatePage 
     * @Description:跳转到审核意见模板新增页面
     * @author 谢美团
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/toAddTemplatePage")
    public String toAddTemplatePage() {
        return "/report/template/opinionTemplateListAdd";
    }
    
    /**
     * @Title:addTemplate 
     * @Description:保存新增的审核意见模板
     * @author 谢美团
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/addOpinionTemplate")
    public String addOpinionTemplate(AuditOpinionTemplate opinionTemplate) {
    	opinionTemplate.setOrgId(getCurentUser().getDept_id());
    	opinionTemplate.setCreateTime(TimeUtil.formatDatetime2(new Date()));
    	auditOpinionTemplateService.insert(opinionTemplate);
        return "redirect:/template/toOpintionTemplatPage";
    }
    
    /**
     * @Title:updateOpinionTemplate 
     * @Description:更新模板信息
     * @author 谢美团
     * @param opinionTemplate
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/updateOpinionTemplate")
    public String updateOpinionTemplate(AuditOpinionTemplate opinionTemplate) {
    	opinionTemplate.setOrgId(getCurentUser().getDept_id());
    	auditOpinionTemplateService.update(opinionTemplate);
    	return "redirect:/template/toOpintionTemplatPage";
    }
    
    
    /**
     * @Title:deleteOpinionTemplate 
     * @Description:删除审核意见模板
     * @author 谢美团
     * @param id
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/deleteOpinionTemplate")
    public String deleteOpinionTemplate(String  id) {
    	auditOpinionTemplateService.delete(Integer.parseInt(id));
    	return "redirect:/template/toOpintionTemplatPage";
    }
    
    /**
     * @Title:getOpinionTemplate 
     * @Description:获取审核意见模板具体内容，并跳转的展示页面
     * @author 谢美团
     * @param id
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/getOpinionTemplate")
    public String getOpinionTemplate(String  id,ModelMap model) {
    	AuditOpinionTemplate  opinionTemplate  = auditOpinionTemplateService.selectById(Integer.parseInt(id));
    	model.put("template", opinionTemplate);
    	return "/report/template/opinionTemplateListView";
    }
    
    
    /**
     * @Title:toEditOpinionTemplatePage 
     * @Description:跳转难道编辑页面
     * @author 谢美团
     * @param id
     * @param model
     * @return 
     * @throws
     * @retrun String
     */ 
    @RequestMapping(value = "/toEditOpinionTemplatePage")
    public String toEditOpinionTemplatePage(String  id,ModelMap model) {
    	AuditOpinionTemplate  opinionTemplate  = auditOpinionTemplateService.selectById(Integer.parseInt(id));
    	model.put("template", opinionTemplate);
    	return "/report/template/opinionTemplateListEdit";
    }
    
}
