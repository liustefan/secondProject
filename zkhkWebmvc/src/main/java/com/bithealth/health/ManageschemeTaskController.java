 
/**
 * @PackageName:      com.bithealth.health
 * @FileName:     ManageschemeTaskController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年12月13日 下午1:23:43  
 * 
 */

package com.bithealth.health;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bithealth.FailMessage;
import com.bithealth.Message;
import com.bithealth.SuccessMessage;
import com.bithealth.cmsCore.healthEducation.facede.HealthFacedeService;
import com.bithealth.healthCore.enmu.ConclusionTypeEnum;
import com.bithealth.healthCore.enmu.ExecuteWayEnum;
import com.bithealth.healthCore.enmu.TaskExecStatusEnum;
import com.bithealth.healthCore.enmu.TaskTypeEnum;
import com.bithealth.healthCore.facede.service.ManageschemeFacedeService;
import com.bithealth.healthCore.facede.service.ManageschemeTaskFacedeService;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignTask;
import com.bithealth.healthCore.managescheme.model.ManageschemeExecTask;
import com.bithealth.healthCore.managescheme.service.ManageschemeDesignTaskService;
import com.bithealth.healthCore.managescheme.service.ManageschemeExecService;
import com.bithealth.inspectCore.facede.service.InspectFacedeService;
import com.bithealth.inspectCore.inspect.model.PhDiabetes;
import com.bithealth.inspectCore.inspect.model.PhDiabetesdetailmedicine;
import com.bithealth.inspectCore.inspect.model.PhHypertension;
import com.bithealth.inspectCore.inspect.model.PhHypertensiondetailmedicine;
import com.bithealth.memberCore.member.model.DiseasesHistoryExample;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.DiseaseService;
import com.bithealth.memberCore.member.service.DiseasesHistoryService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.memberCore.memberLabel.enmu.LabelStatus;
import com.bithealth.memberCore.memberLabel.model.LabelItem;
import com.bithealth.memberCore.memberLabel.service.LabelService;
import com.bithealth.memberCore.memberLabel.service.MemberLabelItemService;
import com.bithealth.orgainCore.service.OrgService;
import com.bithealth.questionCore.answer.model.Ouai;
import com.bithealth.questionCore.facede.service.AnswerFacedeService;
import com.bithealth.questionCore.facede.service.QuestionFacedeService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;


/**
 * 类名称: ManageschemeTaskController  
 * 功能描述: TODO ADD FUNCTION.  方案任务执行、查看
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月13日 下午1:23:43 
 * 
 * @author baozj
 * @version  
 */
@Controller
@RequestMapping(value = "/health/manageschemeTask")
public class ManageschemeTaskController extends BaseSpringController {

	@Autowired
	ManageschemeTaskFacedeService service;
	@Autowired
	private DiseaseService diseaseService;
	@Resource(name="memberService")
	private MemberService memberService;
	@Autowired
	ManageschemeFacedeService msService;
	@Autowired
	private HealthFacedeService healthFacedeService;
	@Autowired
	private InspectFacedeService inspectService;
	@Autowired
	private AnswerFacedeService answerService;
	@Autowired
	QuestionFacedeService questionService;
	@Resource(name="diseasesHistoryService")
	protected DiseasesHistoryService diseasesHistoryService;
	@Autowired
	private MemberLabelItemService memberLabelService;
	@Autowired
	private LabelService labelService;
	@Autowired
	ManageschemeExecService execService;
	@Resource(name="orgService")
	private OrgService orgService;
	
	@Autowired
	private ManageschemeDesignTaskService manageschemeDesignTaskService;
	
	/**
	 * 
	 * @Title:listGroup 
	 * @Description: 分页查询方案任务
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/list")
	public String listGroup(Page<ManageschemeExecTask> page, ManageschemeExecTask pojo, Model model){
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo", pojo);
		ShiroUser user = getCurentUser();
		pojo.setExecDrID(user.getId());
		if(pojo.getExecStatus() == null)
			pojo.setExecStatus(TaskExecStatusEnum.EXECUTORY.getCode());
		if(pojo.getPlanTimeS() == null && pojo.getPlanTimeE() == null){
			pojo.setPlanTimeE(TimeUtil.now("yyyy-MM-dd"));
		}
		model.addAttribute("page", service.selectManageschemeTaskPage(page, pojo));
		model.addAttribute("diseases", diseaseService.selectAll_cache());
		return "health/task/list";
	}
	
	/**
	 * 
	 * @Title:toExec 
	 * @Description: 跳转方案任务执行页面
	 * TODO  
	 * @author baozj
	 * @param id
	 * @param memberId
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/toExec")
	public String toExec(Long id, Integer memberId, Model model){
		ManageschemeExecTask eTask = service.selectExecTask(id);
		eTask.setExecTime(TimeUtil.now());
		model.addAttribute("pojo", eTask);
		Member member = memberService.selectById(memberId);
		model.addAttribute("member", member);
//		model.addAttribute("labels", execService.selectMemberLabels(memberId));
		String orgIds = orgService.selectAllSharedOrg(getCurentUser().getDept_id(), true);
		List<LabelItem> items = labelService.selectByDoc(getCurentUser().getId(), orgIds);
		List<LabelItem> itemList = memberLabelService.selectMemberLabelItems(LabelStatus.EFFECT, member.getMemberid(), items);
		model.addAttribute("labels", itemList);
		DiseasesHistoryExample example = new DiseasesHistoryExample();
		example.createCriteria().andMemberidEqualTo(memberId);
		model.addAttribute("diseases", diseasesHistoryService.selectByExample(example));
		try {
			model.addAttribute("age", TimeUtil.getAge(member.getBirthdate()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "health/task/exec";
	}
	
	/**
	 * 
	 * @Title:exec 
	 * @Description: 执行方案任务
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @param source
	 * @param termination
	 * @param model
	 * @param redirectAttributes
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/exec")
	public String exec(ManageschemeExecTask pojo, String source, boolean termination, Model model, RedirectAttributes redirectAttributes){
		ShiroUser user = getCurentUser();
		/* begin */
		ManageschemeDesignTask oldTask = pojo.getDesignTask();
		Integer  designID = pojo.getMSDTaskID();
		ManageschemeDesignTask newTask = manageschemeDesignTaskService.selectById(designID);
		oldTask.setSummary(newTask.getSummary());
		pojo.setDesignTask(oldTask);
		/* end */
		pojo.setUpdateID(user.getId());
		pojo.getDesign().setExecDrID(user.getId());
		pojo.getDesign().setExecDrName(user.getRealName());
		String url = "";
		if(StringUtils.isNotEmpty(source))
			url = "redirect:"+source;
		else
			url = "redirect:list";
		if(!service.updateExecTaskResult(pojo, isFinish(pojo), termination)){
			redirectAttributes.addFlashAttribute("message", "执行失败！");
		}else{
			if(TaskTypeEnum.SUMMARY.getCode().equals(pojo.getDesignTask().getTaskType()) && ConclusionTypeEnum.NEXT.getCode().equals(pojo.getConclusionType())){
				url = "redirect:../managescheme/toEditPerson?memberId=" + pojo.getMemberId() + "&source=../manageschemeTask/"+source;
			}
		}
		return url;
	}
	
	/**
	 * 
	 * @Title:isFinish 
	 * @Description: 判断当前任务是可以执行的，还是只是保存信息并不执行
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	private boolean isFinish(ManageschemeExecTask pojo){
		//1-健教，2-复诊，3-测量，4-问卷调查，5-高血压随访(公卫)，6-糖尿病随访(公卫)，7-阶段总结
		boolean finish = false;
		if(ExecuteWayEnum.MESSAGE.getCode().equals(pojo.getDesignTask().getExecWay())){
			finish = true;
		}else{
			if(TaskTypeEnum.SUMMARY.getCode().equals(pojo.getDesignTask().getTaskType())){
				if(pojo.getConclusionType() != null){
					finish = true;
				}
			}else if(StringUtils.isNotEmpty(pojo.getExecResult())){
				if(TaskTypeEnum.HEALTHEDUCATION.getCode().equals(pojo.getDesignTask().getTaskType())
						|| TaskTypeEnum.CPN.getCode().equals(pojo.getDesignTask().getTaskType())
						|| TaskTypeEnum.MEASURE.getCode().equals(pojo.getDesignTask().getTaskType())){
					finish = true;
				}else if(TaskTypeEnum.QUESTION.getCode().equals(pojo.getDesignTask().getTaskType())
						|| TaskTypeEnum.HYPERTENSION.getCode().equals(pojo.getDesignTask().getTaskType())
						||TaskTypeEnum.DIABETES.getCode().equals(pojo.getDesignTask().getTaskType())){
					if(pojo.getRef() != null && pojo.getRef().get("done") != null && Boolean.parseBoolean(pojo.getRef().get("done").toString())){
						finish = true;
					}
				}
			}
		}
		return finish;
	}
	
	/**
	 * 
	 * @Title:detail 
	 * @Description: 查看已执行方案任务
	 * TODO  
	 * @author baozj
	 * @param id
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/detail")
	public String detail(Long id, Model model){
		model.addAttribute("pojo", service.selectExecTask(id));
		return "health/task/detail";
	}
	
	/**
	 * 
	 * @Title:listDesktop 
	 * @Description: 分页查询待执行任务
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/listDesktop")
	public String listDesktop(Page<ManageschemeExecTask> page, ManageschemeExecTask pojo, Model model){
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo", pojo);
		pojo.setExecStatus(TaskExecStatusEnum.EXECUTORY.getCode());
		if(pojo.getPlanTimeS() == null && pojo.getPlanTimeE() == null){
			pojo.setPlanTimeE(TimeUtil.now("yyyy-MM-dd"));
		}
		if(pojo.getDesignTask() == null)
			pojo.setDesignTask(new ManageschemeDesignTask());
		pojo.getDesignTask().setExcludeExecWay(ExecuteWayEnum.MESSAGE.getCode());
		ShiroUser user = getCurentUser();
		pojo.setExecDrID(user.getId());;
		model.addAttribute("page", service.selectManageschemeTaskPage(page, pojo));
		model.addAttribute("diseases", diseaseService.selectAll_cache());
		return "health/task/listDesktop";
	}
	
	@RequestMapping(value = "/member/list")
	public String mList(Page<ManageschemeExecTask> page, ManageschemeExecTask pojo, Model model){
//		page.setPageNo(page.getPageNo());
//		model.addAttribute("pojo", pojo);
//		ShiroUser user = getCurentUser();
//		pojo.setExecDrID(user.getId());;
//		model.addAttribute("page", service.selectManageschemeTaskPage(page, pojo));
//		model.addAttribute("diseases", diseaseService.selectAll_cache());
		return "health/task/mList";
	}
	
	/**
	 * 
	 * @Title:saveEditPlanTime 
	 * @Description: 保存计划执行时间
	 * TODO  
	 * @author baozj
	 * @param MSETaskID
	 * @param planTime
	 * @param source
	 * @param redirectAttributes
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/saveEditPlanTime")
	public String saveEditPlanTime(Long MSETaskID, Date planTime, String source, RedirectAttributes redirectAttributes){
		
		if(!msService.updateTaskPlanTime(MSETaskID, planTime, getCurentUser().getId()))
			redirectAttributes.addFlashAttribute("message", "修改计划时间失败!");
		if(StringUtils.isNotEmpty(source))
			return "redirect:"+source;
		else
			return "redirect:list";
	}
	
	/**
	 * 
	 * @Title:getHealthEducationDetail 
	 * @Description: 查看任务中健教详情
	 * TODO  
	 * @author baozj
	 * @param id
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/getHealthEducationDetail")
	public String getHealthEducationDetail(Integer id, Model model){
		model.addAttribute("pojo", healthFacedeService.selectHealthById(id));
		return "health/task/healthEducationDetail";
	}
	
	/**
	 * 
	 * @Title:toAnswerQuestion 
	 * @Description: 跳转方案任务中问卷作答页面
	 * TODO  
	 * @author baozj
	 * @param MSETaskID
	 * @param qustId
	 * @param memberId
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/toAnswerQuestion")
	public String toAnswerQuestion(Long MSETaskID, Integer qustId, Integer memberId, Model model){
		Ouai pojo = answerService.selectOuaiByMSETaskID(MSETaskID);
		if(pojo != null){
			pojo = answerService.selectSingleAnswerById(pojo.getAnsNumber());
		}else{
			pojo = new Ouai();
			pojo.setMemberid(memberId);
			pojo.setMSETaskID(MSETaskID);
			pojo.setOmfq(questionService.selectSingleQuestionById(qustId));
		}
		model.addAttribute("omfq", JSON.toJSONString(pojo.getOmfq(), SerializerFeature.BrowserCompatible));
		model.addAttribute("uai21", JSON.toJSONString(pojo.getUai21s(), SerializerFeature.BrowserCompatible));
		model.addAttribute("pojo", pojo);
		return "health/task/answerInfo";
	}
	
	/**
	 * 
	 * @Title:answerQuestion 
	 * @Description: 作答问卷
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/answerQuestion")
	public @ResponseBody Message answerQuestion(@RequestBody Ouai pojo){
		ShiroUser user = getCurentUser();
		pojo.setDocid(user.getId());
		pojo.setDocName(user.getRealName());
		if(service.insertTaskAnswerResult(pojo)){
			return new SuccessMessage("toExec?id="+pojo.getMSETaskID()+"&memberId="+pojo.getMemberid()+"&source="+pojo.getSource());
		}else{
			return new FailMessage();
		}
		
	}
	
	/**
	 * 
	 * @Title:toDiabetes 
	 * @Description: 跳转糖尿病随访录入页面
	 * TODO  
	 * @author baozj
	 * @param MSETaskID
	 * @param memberId
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/toDiabetes")
	public String toDiabetes(Long MSETaskID, Integer memberId, Model model){
		
		PhDiabetes pojo = inspectService.selectDiabetesByMSETaskID(MSETaskID);
		if(pojo == null){
			pojo = new PhDiabetes();
			pojo.setMSETaskID(MSETaskID);
			pojo.setMemberID(memberId);
			pojo.setVisitDrName(getCurentUser().getRealName());
			pojo.setVisitClass((byte)0);
			pojo.setVisitDate(TimeUtil.now());
		}
		model.addAttribute("pojo", pojo);
		return "health/task/diabetesEdit";
	}
	
	/**
	 * 
	 * @Title:diabetes 
	 * @Description: 录入糖尿病随访
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @param source
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/diabetes")
	public String diabetes(PhDiabetes pojo, String source){
		ShiroUser su = getCurentUser();
		pojo.setCreateDrID(su.getId());
		pojo.setCreateDrName(su.getRealName());
		pojo.setUpdateDrID(su.getId());
		pojo.setUpdateDrName(su.getRealName());
		pojo.setRefCompany((byte)0);
		pojo.setGetTime(TimeUtil.now());
		pojo.setVisitDate(TimeUtil.now());
		pojo.setVisitDrName(su.getRealName());
		pojo.getPhDiabetesdetail().setVisitDate_Next(DateUtils.addMonths(TimeUtil.now(), 3));
		if(pojo.getPhDiabetesdetailmedicines() == null)
			pojo.setPhDiabetesdetailmedicines(new ArrayList<PhDiabetesdetailmedicine>());
		if(inspectService.insertOrUpdateDiabetes(pojo) && pojo.getVisitClass() != null){
			ManageschemeExecTask eTask = new ManageschemeExecTask();
			eTask.setMSETaskID(pojo.getMSETaskID());
			eTask.setExecResult(pojo.getVisitClassStr());
			eTask.setUpdateID(su.getId());
			service.updateExecTaskResult(eTask, false, false);
		}
		return "redirect:toExec?id="+pojo.getMSETaskID()+"&memberId="+pojo.getMemberID()+"&source="+source;
	}
	
	/**
	 * 
	 * @Title:toHypertension 
	 * @Description: 跳转高血压随访录入页面
	 * TODO  
	 * @author baozj
	 * @param MSETaskID
	 * @param memberId
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/toHypertension")
	public String toHypertension(Long MSETaskID, Integer memberId, Model model){
		
		PhHypertension pojo = inspectService.selectHypertensionByMSETaskID(MSETaskID);
		if(pojo == null){
			pojo = new PhHypertension();
			pojo.setMSETaskID(MSETaskID);
			pojo.setMemberID(memberId);
			pojo.setVisitDrName(getCurentUser().getRealName());
			pojo.setVisitClass((byte)0);
			pojo.setVisitDate(TimeUtil.now());
		}
		model.addAttribute("pojo", pojo);
		return "health/task/hypertensionEdit";
	}
	
	/**
	 * 
	 * @Title:hypertension 
	 * @Description: 录入高血压随访
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @param source
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/hypertension")
	public String hypertension(PhHypertension pojo, String source){
		ShiroUser su = getCurentUser();
		pojo.setCreateDrID(su.getId());
		pojo.setCreateDrName(su.getRealName());
		pojo.setUpdateDrID(su.getId());
		pojo.setUpdateDrName(su.getRealName());
		pojo.setRefCompany((byte)0);
		pojo.setGetTime(TimeUtil.now());
		pojo.setVisitDate(TimeUtil.now());
		pojo.setVisitDrName(su.getRealName());
		pojo.getPhHypertensiondetail().setVisitDate_Next(DateUtils.addMonths(TimeUtil.now(), 3));
		if(pojo.getPhHypertensiondetailmedicines() == null)
			pojo.setPhHypertensiondetailmedicines(new ArrayList<PhHypertensiondetailmedicine>());
		if(inspectService.insertOrUpdateHypertension(pojo) && pojo.getVisitClass() != null){
			ManageschemeExecTask eTask = new ManageschemeExecTask();
			eTask.setMSETaskID(pojo.getMSETaskID());
			eTask.setExecResult(pojo.getVisitClassStr());
			eTask.setUpdateID(su.getId());
			service.updateExecTaskResult(eTask, false, false);
		}
		return "redirect:toExec?id="+pojo.getMSETaskID()+"&memberId="+pojo.getMemberID()+"&source="+source;
	}
	
//	@RequestMapping(value = "/singlelist")
//	public String singlelist(Page<ManageschemeExecTask> page, ManageschemeExecTask pojo, Model model){
//		page.setPageNo(page.getPageNo());
//		model.addAttribute("pojo", pojo);
//		if(pojo.getExecStatus() == null)
//			pojo.setExecStatus(TaskExecStatusEnum.EXECUTORY.getCode());
//		model.addAttribute("page", service.selectManageschemeTaskPage(page, pojo));
//		return "health/task/singleList";
//	}
	
	/**
	 * 
	 * @Title:singleList 
	 * @Description: 单一会员页面分页查询会员任务
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/singleList")
	public String singleList(Page<ManageschemeExecTask> page, ManageschemeExecTask pojo, Model model){
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo", pojo);
		if(pojo.getExecStatus() == null)
			pojo.setExecStatus(TaskExecStatusEnum.EXECUTORY.getCode());
		model.addAttribute("page", service.selectManageschemeTaskPage(page, pojo));
		return "health/task/singleList";
	}
	
	/**
	 * 
	 * @Title:hasDiseasesHistory 
	 * @Description: 判断当前会员是否有type对应的疾病
	 * TODO  
	 * @author baozj
	 * @param type
	 * @param memberId
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/hasDiseasesHistory")
	public @ResponseBody Message hasDiseasesHistory(Integer type, Integer memberId){
		DiseasesHistoryExample example = new DiseasesHistoryExample();
		example.createCriteria()
		.andMemberidEqualTo(memberId)
		.andDiseaseidEqualTo(type);
		return new SuccessMessage(diseasesHistoryService.selectByExample(example).size() > 0);
	}
	
	/**
	 * 
	 * @Title:answerView 
	 * @Description: 查看已执行任务中问卷详情
	 * TODO  
	 * @author baozj
	 * @param MSETaskID
	 * @param qustId
	 * @param memberId
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/answerView")
	public String answerView(Long MSETaskID, Integer qustId, Integer memberId, Model model){
		Ouai pojo = answerService.selectOuaiByMSETaskID(MSETaskID);
		if(pojo != null){
			pojo = answerService.selectSingleAnswerById(pojo.getAnsNumber());
		}else{
			pojo = new Ouai();
			pojo.setMember(memberService.selectById(memberId));
			pojo.setOmfq(questionService.selectSingleQuestionById(qustId));
		}
		model.addAttribute("pojo", pojo);
		return "question/singleAnswer/answerView";
	}
	
	/**
	 * 
	 * @Title:diabetesView 
	 * @Description: 查看已执行任务中糖尿病随访详情
	 * TODO  
	 * @author baozj
	 * @param MSETaskID
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/diabetesView")
	public String diabetesView(Long MSETaskID, Model model){
		PhDiabetes pojo = inspectService.selectDiabetesByMSETaskID(MSETaskID);
		model.addAttribute("pojo", pojo);
		return "inspect/diabetes/view";
	}
	
	/**
	 * 
	 * @Title:hypertensionView 
	 * @Description: 查看已执行任务中高血压随访详情
	 * TODO  
	 * @author baozj
	 * @param MSETaskID
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/hypertensionView")
	public String hypertensionView(Long MSETaskID, Model model){
		PhHypertension pojo = inspectService.selectHypertensionByMSETaskID(MSETaskID);
		model.addAttribute("pojo", pojo);
		return "inspect/hypertension/view";
	}
}

