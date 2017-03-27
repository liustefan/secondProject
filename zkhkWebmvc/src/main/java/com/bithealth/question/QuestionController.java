 
/**
 * @PackageName:      com.bithealth.question
 * @FileName:     QuestionController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年8月3日 下午3:52:18  
 * 
 */

package com.bithealth.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bithealth.HKEJConfig;
import com.bithealth.Message;
import com.bithealth.memberCore.member.model.SearchCondition;
import com.bithealth.memberCore.member.vo.MemberVo;
import com.bithealth.orgainCore.service.OrgService;
import com.bithealth.questionCore.enmu.ComQuestionStatusEnum;
import com.bithealth.questionCore.enmu.SingleQuestionStatusEnum;
import com.bithealth.questionCore.facede.service.AnswerFacedeService;
import com.bithealth.questionCore.facede.service.QuestionFacedeService;
import com.bithealth.questionCore.question.model.Cqt1;
import com.bithealth.questionCore.question.model.Ocqt;
import com.bithealth.questionCore.question.model.OcqtExample;
import com.bithealth.questionCore.question.model.Omfq;
import com.bithealth.questionCore.question.model.OmfqExample;
import com.bithealth.reportCore.template.model.Option;
import com.bithealth.reportCore.template.model.OptionExample;
import com.bithealth.reportCore.template.service.OptionService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;


/**
 * 类名称: QuestionController  
 * 功能描述: TODO 问卷管理  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月3日 下午3:52:18 
 * 
 * @author baozj
 * @version  
 */
@Controller
@RequestMapping(value = "/question")
public class QuestionController extends BaseSpringController {

	@Autowired
	private QuestionFacedeService questionService;
	@Autowired
	private OptionService optionService;
	@Autowired
	private AnswerFacedeService answerService; 
	@Resource(name="orgService")
	private OrgService orgService;
	
	/**
	 * 
	 * @Title:singleList 
	 * @Description: 分页查询单份问卷
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param criteria
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/singleQuestion/list")
	public String singleList(Page<Omfq> page, Omfq pojo, String criteria, Model model){
		page.setPageNo(page.getPageNo());
		ShiroUser user = getCurentUser();
		model.addAttribute("pojo", pojo);
		model.addAttribute("criteria", criteria);
		model.addAttribute("options", queryOptionList(user.getDept_id() == null ? pojo.getOrgId() : user.getDept_id(), 3));
		if(user.getDept_id() != null)
			pojo.setSuperOrgIds(orgService.selectAllSharedOrg(user.getDept_id(), true));
		OmfqExample example = new OmfqExample();
		example.createCriteria()
		.andRoleId(user.getRoleid(), pojo.getUseRange(), user.getDept_id() != null ? user.getDept_id() : pojo.getOrgId(), pojo.getSuperOrgIds())
		.andOptIdEqualTo(pojo.getOptId())
		.andAnsModeEqualTo(pojo.getAnsMode())
		.andQustTagEqualTo(pojo.getQustTag())
		.andQustnameLike(pojo.getQustname());
		
		model.addAttribute("page", questionService.selectSingleQuestionByExampleAndPage(page, example));
		return "question/singleQuestion/list";
	}
	
	/**
	 * 
	 * @Title:chooseQuestions 
	 * @Description: 分页查询可以加入组合问卷中的单份问卷
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/singleQuestion/chooseQuestions")
	public String chooseQuestions(Page<Omfq> page, Model model){
		page.setPageNo(page.getPageNo());
		ShiroUser user = getCurentUser();
		Omfq pojo = new Omfq();
		if(user.getDept_id() != null)
			pojo.setSuperOrgIds(orgService.selectAllSharedOrg(user.getDept_id(), true));
		OmfqExample example = new OmfqExample();
//		example.createCriteria().andOrgIdIn(Arrays.asList(0, getCurentUser().getDept_id()))
		example.createCriteria().andRoleId(user.getRoleid(), null, user.getDept_id(), pojo.getSuperOrgIds())
		.andQustTagEqualTo(SingleQuestionStatusEnum.VALID.getCode());
		model.addAttribute("page", questionService.selectSingleQuestionByExampleAndPage(page, example));
		return "question/singleQuestion/chooseQuestions";
	}
	
	/**
	 * 
	 * @Title:comList 
	 * @Description: 组合问卷列表
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param criteria
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/comQuestion/list")
	public String comList(Page<Ocqt> page, Ocqt pojo, String criteria, Model model){
		page.setPageNo(page.getPageNo());
		ShiroUser user = getCurentUser();
		model.addAttribute("pojo", pojo);
		model.addAttribute("criteria", criteria);
		OcqtExample example = new OcqtExample();
		example.createCriteria().andOrgIdEqualTo(user.getDept_id())
		.andOptIdEqualTo(pojo.getOptId())
		.andQustTagEqualTo(pojo.getQustTag())
		.andCombQustNameOrCreateNameLike(criteria);
		model.addAttribute("options", queryOptionList(user.getDept_id(), 4));
		model.addAttribute("page", questionService.selectComQuestionByExampleAndPage(page, example));
		return "question/comQuestion/list";
	}
	
	/**
	 * 
	 * @Title:toSingleEdit 
	 * @Description: 单份问卷详情
	 * TODO  
	 * @author baozj
	 * @param id
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/singleQuestion/toEdit")
	public String toSingleEdit(Integer id, Model model){
		Omfq pojo = questionService.selectSingleQuestionById(id);
		if(pojo == null)
			pojo = new Omfq();
		if(HKEJConfig.getConfig().getQuestionnaire().getEvaluationWay().containsKey(pojo.getQustname()))
			pojo.setQustNameType("固定名称");
		else
			pojo.setQustNameType("自定义名称");
		model.addAttribute("pojo", pojo);
		model.addAttribute("json", JSON.toJSONString(pojo, SerializerFeature.BrowserCompatible));
		model.addAttribute("fixedNames", HKEJConfig.getConfig().getQuestionnaire().getEvaluationWay());
		return "question/singleQuestion/edit";
	}
	
	/**
	 * 
	 * @Title:toSingleView 
	 * @Description: 查看单份问卷详情 
	 * TODO  
	 * @author baozj
	 * @param id
	 * @param model
	 * @param request
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/singleQuestion/toView")
	public String toSingleView(Integer id, Model model, HttpServletRequest request){
		Omfq pojo = questionService.selectSingleQuestionById(id);
		if(HKEJConfig.getConfig().getQuestionnaire().getEvaluationWay().containsKey(pojo.getQustname()))
			pojo.setQustNameType("固定名称");
		else
			pojo.setQustNameType("自定义名称");
		model.addAttribute("pojo", pojo);
		model.addAttribute("json", JSON.toJSONString(pojo, SerializerFeature.BrowserCompatible));
		model.addAttribute("fixedNames", HKEJConfig.getConfig().getQuestionnaire().getEvaluationWay());
		model.addAttribute("view", true);
		return "question/singleQuestion/edit";
	}
	
	
	/**
	 * 
	 * @Title:toComEdit 
	 * @Description: 组合问卷详情
	 * TODO  
	 * @author baozj
	 * @param id
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/comQuestion/toEdit")
	public String toComEdit(Integer id, Model model){
		Ocqt pojo = questionService.selectComQuestionById(id);
		if(pojo == null){
			pojo = new Ocqt();
			pojo.setQustTag(ComQuestionStatusEnum.DRAFT.getCode());
		}
		model.addAttribute("options", queryOptionList(getCurentUser().getDept_id(), 4));
		model.addAttribute("pojo", pojo);
		return "question/comQuestion/edit";
	}
	
	/**
	 * 
	 * @Title:singleRemove 
	 * @Description: 删除单份问卷（支持批量删除）
	 * TODO  
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/singleQuestion/remove")
	public @ResponseBody Message singleRemove(Integer...ids){
		if(questionService.selectSingleQuestionCanDelete(ids)){
			if(questionService.deleteSingleQuestion(ids))
				return new Message("删除成功！", true);
			else
				return new Message("删除失败！", false);
		}else{
			return new Message("单份问卷已发放或组合问卷已关联，不可删除", false);
		}
	}
	
	/**
	 * 
	 * @Title:comRemove 
	 * @Description: 删除组合问卷（支持批量删除）
	 * TODO  
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/comQuestion/remove")
	public @ResponseBody Message comRemove(Integer...ids){
		if(questionService.selectComQuestionCanDelete(ids)){
			if(questionService.deleteComQuestion(ids))
				return new Message("删除成功！", true);
			else
				return new Message("删除失败！", false);
		}else{
			return new Message("组合问卷已发放，不可删除", false);
		}
	}
	
	/**
	 * 
	 * @Title:singleSave 
	 * @Description: 保存单份问卷
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/singleQuestion/save")
	public @ResponseBody Message singleSave(@RequestBody Omfq pojo){
		ShiroUser user = getCurentUser();
		pojo.setFunId((short)3);
		pojo.setCreateid(user.getId());
		pojo.setCreateName(user.getRealName());
		if(user.getRoleid() != 6){//非系统管理员账号
			pojo.setOrgId(getCurentUser().getDept_id());
			pojo.setUseRange((byte)3);
		}else{
			if(pojo.getOrgId() == null)
				pojo.setOrgId(0);
		}
		if(questionService.insertOrUpdateQuestion(pojo))
			return new Message( "保存成功！", true, pojo);
		else
			return new Message("保存失败！", false);
	}
	
	/**
	 * 
	 * @Title:comSave 
	 * @Description: 保存组合问卷
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @param questIds
	 * @param redirectAttributes
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/comQuestion/save")
	public String comSave(Ocqt pojo, String questIds, RedirectAttributes redirectAttributes){
		ShiroUser user = getCurentUser();
		pojo.setOrgId(getCurentUser().getDept_id());
		pojo.setCreateid(user.getId());
		pojo.setCreateName(user.getRealName());
		pojo.setCqt1s(new ArrayList<Cqt1>());
		String[] qIds = questIds.split(",");
		for(String qId : qIds){
			Cqt1 cqt1 = new Cqt1();
			Omfq omfq = questionService.selctSingleQuestionBaseInfoById(Integer.parseInt(qId));
			if(omfq != null){
				cqt1.setFunId(omfq.getFunId());
				cqt1.setOptId(omfq.getOptId());
				cqt1.setQustCode(omfq.getQustCode());
				cqt1.setQustid(omfq.getQustid());
				cqt1.setQustname(omfq.getQustname());
				cqt1.setQustVer(omfq.getQustVer());
				pojo.getCqt1s().add(cqt1);
			}
		}
		if(questionService.insertOrUpdateComQuestion(pojo))
			redirectAttributes.addFlashAttribute("message", "保存成功！");
		else
			redirectAttributes.addFlashAttribute("message", "保存失败！");
		return "redirect:list";
	}
	
	/**
	 * 
	 * @Title:queryOption 
	 * @Description: 异步查询选项
	 * TODO  
	 * @author baozj
	 * @param orgId
	 * @param funId
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/queryOption")
	public @ResponseBody Message queryOption(Integer orgId, Short funId){
		return new Message( "保存成功！", true, queryOptionList(orgId == null ? getCurentUser().getDept_id() : orgId, funId));
	}
	
	/**
	 * 
	 * @Title:checkSingleNameUnique 
	 * @Description: 单份问卷名称是否唯一
	 * TODO  
	 * @author baozj
	 * @param orgId
	 * @param name
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/singleQuestion/checkNameUnique")
	public @ResponseBody Message checkSingleNameUnique(Integer orgId, String name){
		ShiroUser user = getCurentUser();
		if(!user.getRoleid().equals(6)){
			if(HKEJConfig.getConfig().getQuestionnaire().getEvaluationWay().containsKey(name))
				return new Message("系统保留问卷名称", false);
		}
		return new Message(true, questionService.selectSingleQuestionNameUnique(user.getDept_id(), name));
	}
	
	/**
	 * 
	 * @Title:checkComNameUnique 
	 * @Description: 组合问卷名称是否唯一
	 * TODO  
	 * @author baozj
	 * @param name
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/comQuestion/checkNameUnique")
	public @ResponseBody boolean checkComNameUnique(String name){
		ShiroUser user = getCurentUser();
		return questionService.selectComQuestionNameUnique(user.getDept_id(), name);
	}
	
	/**
	 * 
	 * @Title:hasDraft 
	 * @Description: 组织下同名单份问卷是否有草稿问卷
	 * TODO  
	 * @author baozj
	 * @param name
	 * @param orgId
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/singleQuestion/hasDraft")
	public @ResponseBody Message hasDraft(String name, Integer orgId){
		return new Message(true, questionService.hasDraft(name, orgId));
	}
	
	/**
	 * 
	 * @Title:hasComDraft 
	 * @Description: 组织下同名组合问卷是否有草稿问卷
	 * TODO  
	 * @author baozj
	 * @param name
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/comQuestion/hasDraft")
	public @ResponseBody Message hasComDraft(String name){
		return new Message(true, questionService.hasComDraft(name, getCurentUser().getDept_id()));
	}
	
	/**
	 * 
	 * @Title:memberList 
	 * @Description: 分页查询我的会员中满足可以发放单份、组合问卷的会员列表
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param condition
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/members")
	public String memberList(Page<MemberVo> page, SearchCondition<MemberVo> condition, Model model){
		model.addAttribute("condition", condition);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iDocId", getCurentUser().getId());
		params.put("iMemGrpid", condition.getMemGrpId());
		params.put("vMemName", condition.getMemName());
		params.put("cGender", condition.getGender());
		params.put("vTel", condition.getTel());
		params.put("vIdCard", condition.getIdcard());
		params.put("dSBirthDate", condition.getBirthDayStart());
		params.put("dEBirthDate", condition.getBirthDayEnd());
		params.put("vAddress", condition.getAddress());
		params.put("vDiseaseName", condition.getDiseaseName());
		params.put("iMemId", condition.getMemType());
		params.put("iQustid", condition.getQustid());
		params.put("iCombQustid", condition.getCombQustid());
		model.addAttribute("page", questionService.exProcGetMyMemListByDocId(page, params));
		return "question/memberList";
	}
	
	/**
	 * 
	 * @Title:queryOptionList 
	 * @Description: 查询选项
	 * TODO  
	 * @author baozj
	 * @param orgId
	 * @param funId
	 * @return 
	 * @throws
	 * @retrun List<Option>
	 */
	private List<Option> queryOptionList(Integer orgId, int funId){
		if(orgId != null){
			OptionExample example = new OptionExample();
			example.createCriteria()
			.andOrgidEqualTo(orgId)
			.andFunIdEqualTo((short)funId);
			return optionService.selectByExample(example);
		}
		return null;
	}
	
	/**
	 * 
	 * @Title:chooseQust 
	 * @Description:新版选择问卷弹窗 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/singleQuestion/chooseQust")
	public String chooseQust(Page<Omfq> page, String qustName, String ansMode, Model model){
		page.setPageNo(page.getPageNo());
		page.setTotalCount(-1);
		if(StringUtils.isNotEmpty(qustName)){
			ShiroUser user = getCurentUser();
			Omfq pojo = new Omfq();
			if(user.getDept_id() != null)
				pojo.setSuperOrgIds(orgService.selectAllSharedOrg(user.getDept_id(), true));
			OmfqExample example = new OmfqExample();
//			example.createCriteria().andOrgIdIn(Arrays.asList(0, getCurentUser().getDept_id()))
			example.createCriteria().andRoleId(user.getRoleid(), null, user.getDept_id(), pojo.getSuperOrgIds())
			.andQustTagEqualTo(SingleQuestionStatusEnum.VALID.getCode())
			.andQustnameLike(qustName)
			.andAnsModeEqualTo(ansMode);
			page = questionService.selectSingleQuestionByExampleAndPage(page, example);
		}
		model.addAttribute("page", page);
		model.addAttribute("qustName", qustName);
		model.addAttribute("ansMode", ansMode);
		return "question/singleQuestion/chooseQust";
	}
}

