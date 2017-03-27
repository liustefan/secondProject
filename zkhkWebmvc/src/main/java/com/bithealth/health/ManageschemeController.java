 
/**
 * @PackageName:      com.bithealth.health
 * @FileName:     ManageschemeController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年12月13日 下午1:23:09  
 * 
 */

package com.bithealth.health;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bithealth.FailMessage;
import com.bithealth.Message;
import com.bithealth.SuccessMessage;
import com.bithealth.WarnMessage;
import com.bithealth.cmsCore.healthEducation.facede.HealthFacedeService;
import com.bithealth.cmsCore.healthEducation.model.HealthEducation;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.model.DoctorExample;
import com.bithealth.doctorCore.doctor.model.DoctorExample.Criteria;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.healthCore.enmu.ExecuteWayEnum;
import com.bithealth.healthCore.enmu.GroupManageschemeEnum;
import com.bithealth.healthCore.enmu.MassEffectProcessEnum;
import com.bithealth.healthCore.enmu.PersonManageschemeEnum;
import com.bithealth.healthCore.enmu.PlanTimeTypeEnum;
import com.bithealth.healthCore.enmu.SchemeTypeEnum;
import com.bithealth.healthCore.enmu.TaskTypeEnum;
import com.bithealth.healthCore.enmu.TempletStatusEnum;
import com.bithealth.healthCore.facede.service.ManageschemeFacedeService;
import com.bithealth.healthCore.facede.service.TempletFacedeService;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesign;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignDetail;
import com.bithealth.healthCore.managescheme.model.ManageschemeDesignTask;
import com.bithealth.healthCore.managescheme.model.ManageschemeExec;
import com.bithealth.healthCore.managescheme.service.ManageschemeDesignService;
import com.bithealth.healthCore.managescheme.service.ManageschemeExecService;
import com.bithealth.healthCore.templet.model.ManageschemeTemplet;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.member.model.DiseasesHistoryExample;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.DiseaseService;
import com.bithealth.memberCore.member.service.DiseasesHistoryService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.memberCore.member.service.MemberTypeService;
import com.bithealth.memberCore.memberLabel.enmu.LabelStatus;
import com.bithealth.memberCore.memberLabel.model.LabelItem;
import com.bithealth.memberCore.memberLabel.service.LabelService;
import com.bithealth.memberCore.memberLabel.service.MemberLabelItemService;
import com.bithealth.orgainCore.service.OrgService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;


/**
 * 类名称: ManageschemeController  
 * 功能描述: TODO ADD FUNCTION.  个人群体方案管理
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月13日 下午1:23:09 
 * 
 * @author baozj
 * @version  
 */
@Controller
@RequestMapping(value = "/health/managescheme")
public class ManageschemeController extends BaseSpringController {

	@Autowired
	ManageschemeFacedeService service;
	@Resource(name="diseasesHistoryService")
	protected DiseasesHistoryService diseasesHistoryService;
	@Resource(name="memberService")
	private MemberService memberService;
	@Autowired
	private DiseaseService diseaseService;
	@Resource(name="memberTypeService")
	private MemberTypeService memberTypeService;
	@Resource(name="doctorService")
	private DoctorService doctorService;
	@Autowired
	private TempletFacedeService templetService;
	@Resource(name="orgService")
	private OrgService orgService;
	@Autowired
	private MemberLabelItemService memberLabelService;
	@Autowired
	private LabelService labelService;
	@Autowired
	ManageschemeExecService execService;
	@Autowired
	ManageschemeDesignService msdService;
	@Resource(name="taskExecutor")
	ThreadPoolTaskExecutor taskExecutor;
	@Autowired
	private HealthFacedeService healthFacedeService;
	
	/**
	 * 
	 * @Title:delete 
	 * @Description: 删除方案
	 * TODO  
	 * @author baozj
	 * @param id
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/delete")
	public @ResponseBody Message delete(Integer id){
		return new SuccessMessage(service.deleteManagescheme(id));
	}
	
	/**
	 * 
	 * @Title:deleteTask 
	 * @Description: 删除方案任务
	 * TODO  
	 * @author baozj
	 * @param id
	 * @param type 1、个人	2、群体
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/deleteTask")
	public @ResponseBody Message deleteTask(Integer id, Byte type){
		return new SuccessMessage(service.deleteManageschemeTask(id, SchemeTypeEnum.getEnumByCode(type)));
	}
	
	/**
	 * 
	 * @Title:insertOrUpdate 
	 * @Description: 保存方案
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @param response 
	 * @throws
	 * @retrun void
	 */
	@RequestMapping(value = "/save", method =RequestMethod.POST)
	public void insertOrUpdate(ManageschemeDesign pojo, HttpServletResponse response){
		try {
			ShiroUser user = getCurentUser();
			pojo.setCreateID(user.getId());
			pojo.setUpdateID(user.getId());
			if(!pojo.getDesignDetail().getFile().isEmpty()){
				pojo.getDesignDetail().setFileName(pojo.getDesignDetail().getFile().getOriginalFilename());
				pojo.getDesignDetail().setFilePath(ManageschemeTempletController.uploadFile(pojo.getDesignDetail().getFile()));
			}else{
				if(StringUtils.isEmpty(pojo.getDesignDetail().getFileName()))
					pojo.getDesignDetail().setFileName(null);
				if(StringUtils.isEmpty(pojo.getDesignDetail().getFilePath()))
					pojo.getDesignDetail().setFilePath(null);
			}
			if(StringUtils.isNotEmpty(pojo.getTasks())){
				pojo.setDesignTasks(JSON.parseArray(pojo.getTasks(), ManageschemeDesignTask.class));
			}
			if(service.insertOrUpdateManagescheme(pojo)){
				ManageschemeTempletController.writeJS(response, "parent.callback(true, " 
			+ pojo.getMSDesignID() + ",  " 
						+ (pojo.getExec() != null ? pojo.getExec().getMSExecID() : null) + ", '" 
			+ (pojo.getDesignDetail().getFileName() == null ? "" : pojo.getDesignDetail().getFileName())+"', '" 
						+ (pojo.getDesignDetail().getFilePath()==null ? "" : pojo.getDesignDetail().getFilePath())+"', " 
			+ JSON.toJSONString(pojo.getDesignTasks()) + ")");
			}else{
				ManageschemeTempletController.writeJS(response, "parent.callback(false)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ManageschemeTempletController.writeJS(response, "parent.callback(false)");
		}
	}
	
	/**
	 * 
	 * @Title:saveTask 
	 * @Description: 保存方案任务
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @param MSExecID
	 * @param type
	 * @param memberId
	 * @param checkDis
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	private Message saveTask(ManageschemeDesignTask pojo, Long MSExecID, SchemeTypeEnum type, Integer memberId, boolean checkDis){
		ShiroUser user = getCurentUser();
		pojo.setCreateID(user.getId());
		pojo.setUpdateID(user.getId());
		if(SchemeTypeEnum.PERSON.equals(type)){
			if(checkDis){
				if(TaskTypeEnum.HYPERTENSION.getCode().equals(pojo.getTaskType())){
					if(!hasDiseasesHistory(1, memberId)){
						return new WarnMessage("当前会员没有高血压疾病,您是否要创建高血压随访任务？");
					}
				}else if(TaskTypeEnum.DIABETES.getCode().equals(pojo.getTaskType())){
					if(!hasDiseasesHistory(2, memberId)){
						return new WarnMessage("当前会员没有糖尿病疾病,您是否要创建糖尿病随访任务？");
					}
				}
			}
		}
		if(service.insertOrUpdateManageschemeTask(pojo, type, MSExecID))
			return new SuccessMessage(pojo);
		else
			return new FailMessage("当前资料保存失败，请稍后重试！");
	}
	
	/**
	 * 
	 * @Title:insertOrUpdatePersonTask 
	 * @Description: 保存个人方案任务
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @param MSExecID
	 * @param memberId
	 * @param checkDis
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/savePersonTask")
	public @ResponseBody Message insertOrUpdatePersonTask(ManageschemeDesignTask pojo, Long MSExecID, Integer memberId, @RequestParam(defaultValue="true")boolean checkDis){
		return saveTask(pojo, MSExecID, SchemeTypeEnum.PERSON, memberId, checkDis);
	}
	
	/**
	 * 
	 * @Title:insertOrUpdateGroupTask 
	 * @Description: 保存群体方案任务
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/saveGroupTask")
	public @ResponseBody Message insertOrUpdateGroupTask(ManageschemeDesignTask pojo){
		return saveTask(pojo, null, SchemeTypeEnum.GROUP, null, false);
	}
	
	/**
	 * 
	 * @Title:toEditPerson 
	 * @Description: 跳转新增、编辑个人方案页面
	 * TODO  
	 * @author baozj
	 * @param id
	 * @param memberId
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/toEditPerson")
	public String toEditPerson(Integer id, Integer memberId, Model model){
		ManageschemeDesign pojo = service.selectManageschemeById(id);
		if(pojo != null)
			memberId = pojo.getExec().getMemberID();
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
		if(pojo != null){
			model.addAttribute("tasks", JSON.toJSONString(pojo.getDesignTasks(), SerializerFeature.BrowserCompatible));
		}else{
			ShiroUser user = getCurentUser();
			pojo = new ManageschemeDesign();
			pojo.setMassStatus(GroupManageschemeEnum.MAKING.getCode());
			pojo.setExecDrID(user.getId());
			pojo.setExecDrName(user.getRealName());
			pojo.setDesignDetail(new ManageschemeDesignDetail());
			pojo.getDesignDetail().setSrvLimitType((byte)3);
			model.addAttribute("tasks", JSON.toJSONString(new ArrayList<Object>()));
		}
		model.addAttribute("pojo", pojo);
		model.addAttribute("executeWay", JSON.toJSONString(ExecuteWayEnum.allValues(), SerializerFeature.BrowserCompatible));
		model.addAttribute("planTimeType", JSON.toJSONString(PlanTimeTypeEnum.allValues(), SerializerFeature.BrowserCompatible));
		model.addAttribute("taskType", JSON.toJSONString(TaskTypeEnum.allValues(), SerializerFeature.BrowserCompatible));
		return "health/managescheme/editPerson";
	}
	
	/**
	 * 
	 * @Title:toEditGroup 
	 * @Description: 跳转新增、编辑群体方案页面
	 * TODO  
	 * @author baozj
	 * @param id
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/toEditGroup")
	public String toEditGroup(Integer id, Model model){
		ManageschemeDesign pojo = service.selectManageschemeById(id);
		if(pojo == null){
			ShiroUser user = getCurentUser();
			pojo = new ManageschemeDesign();
			pojo.setMassStatus(GroupManageschemeEnum.MAKING.getCode());
			pojo.setExecDrID(user.getId());
			pojo.setExecDrName(user.getRealName());
			pojo.setDesignDetail(new ManageschemeDesignDetail());
			pojo.getDesignDetail().setSrvLimitType((byte)3);
		}
		model.addAttribute("pojo", pojo);
		model.addAttribute("tasks", JSON.toJSONString(pojo.getDesignTasks(), SerializerFeature.BrowserCompatible));
		model.addAttribute("executeWay", JSON.toJSONString(ExecuteWayEnum.allValues(), SerializerFeature.BrowserCompatible));
		model.addAttribute("planTimeType", JSON.toJSONString(PlanTimeTypeEnum.allValues(), SerializerFeature.BrowserCompatible));
		model.addAttribute("taskType", JSON.toJSONString(TaskTypeEnum.allValues(), SerializerFeature.BrowserCompatible));
		return "health/managescheme/editGroup";
	}
	
	/**
	 * 
	 * @Title:toEdit 
	 * @Description: 单一会员页面，跳转编辑方案页面
	 * TODO  
	 * @author baozj
	 * @param id
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/toEdit")
	public String toEdit(Integer id, Model model){
		ManageschemeDesign pojo = msdService.selectById(id);
		if(SchemeTypeEnum.PERSON.getCode().equals(pojo.getSchemeType()))
			return toEditPerson(id, null, model);
		else
			return toEditGroup(id, model);
	}
	
	/**
	 * 
	 * @Title:listPerson 
	 * @Description: 分页查询个人方案
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/listPerson")
	public String listPerson(Page<ManageschemeExec> page, ManageschemeExec pojo, Model model){
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo", pojo);
		ShiroUser user = getCurentUser();
		pojo.setCreateID(user.getId());
		if(pojo.getDesign() == null)
			pojo.setDesign(new ManageschemeDesign());
		pojo.getDesign().setSchemeType(SchemeTypeEnum.PERSON.getCode());
		model.addAttribute("page", service.selectPersonManageschemePage(page, pojo));
		return "health/managescheme/listPerson";
	}
	
	/**
	 * 
	 * @Title:listGroup 
	 * @Description: 分页查询群体方案
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/listGroup")
	public String listGroup(Page<ManageschemeDesign> page, ManageschemeDesign pojo, Model model){
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo", pojo);
		ShiroUser user = getCurentUser();
		pojo.setCreateID(user.getId());
		model.addAttribute("page", service.selectGroupManageschemePage(page, pojo));
		return "health/managescheme/listGroup";
	}
	
	/**
	 * 
	 * @Title:terminatedManagescheme 
	 * @Description: 终止方案
	 * TODO  
	 * @author baozj
	 * @param id
	 * @param massOffReason
	 * @param schemeType 1、个人	2、群体
	 * @param redirectAttributes
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/terminatedManagescheme")
	public String terminatedManagescheme(Integer id, String massOffReason, Byte schemeType, RedirectAttributes redirectAttributes){
		if(!service.updateManagescheme(getCurentUser().getId(), id, GroupManageschemeEnum.TERMINATED, null, massOffReason))
			redirectAttributes.addFlashAttribute("message", "终止失败！");
		else
			redirectAttributes.addFlashAttribute("message", "终止成功！");
		if(schemeType == 1)
			return "redirect:listPerson";
		else
			return "redirect:listGroup";
	}
	
	/**
	 * 
	 * @Title:singleTerminatedManagescheme 
	 * @Description: 终止单个会员方案（包括群体中的）
	 * TODO  
	 * @author baozj
	 * @param id
	 * @param MSExecID
	 * @param massOffReason
	 * @param schemeType
	 * @param source
	 * @param redirectAttributes
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/singleTerminatedManagescheme")
	public String singleTerminatedManagescheme(Integer id, Long MSExecID, String massOffReason, Byte schemeType, String source, RedirectAttributes redirectAttributes){
		if(!service.updateSingleTerminatedManagescheme(getCurentUser().getId(), id, MSExecID, SchemeTypeEnum.getEnumByCode(schemeType), GroupManageschemeEnum.TERMINATED, massOffReason))
			redirectAttributes.addFlashAttribute("message", "终止失败！");
		else
			redirectAttributes.addFlashAttribute("message", "终止成功！");
		return "redirect:"+source;
	}
	
	/**
	 * 
	 * @Title:hasDiseasesHistory 
	 * @Description: 判断当前会员是否有type类型疾病
	 * TODO  
	 * @author baozj
	 * @param type
	 * @param memberId
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	private boolean hasDiseasesHistory(Integer type, Integer memberId){
		DiseasesHistoryExample example = new DiseasesHistoryExample();
		example.createCriteria()
		.andMemberidEqualTo(memberId)
		.andDiseaseidEqualTo(type);
		return diseasesHistoryService.selectByExample(example).size() > 0;
	}
	
	/**
	 * 
	 * @Title:selectHasManageschemeExec 
	 * @Description: 判断会员是否制定中及执行中的个人方案
	 * TODO  
	 * @author baozj
	 * @param memberId
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/checkMemberHasMs")
	public @ResponseBody Message selectHasManageschemeExec(Integer memberId){
		ManageschemeExec model = service.selectHasManageschemeExec(memberId);
		if(model == null){
			return new SuccessMessage();
		}else{
			return new FailMessage(model.getCreateName() + "医生已经为会员" + model.getMemName() + "创建了个人管理方案");
		}
	}
	
	/**
	 * 
	 * @Title:listPMembers 
	 * @Description: 分页查询可以制定个人、群体方案会员
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param params
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/listMember")
	public String listPMembers(Page<Map<String, Object>> page, @RequestParam Map<String, Object> params, Model model){
		page.setTotalCount(-1);
		if(hasParams(params)){
			if(params.get("iMSDesignID") == null || String.valueOf(params.get("iMSDesignID")).length() == 0){
				params.put("iDocId", getCurentUser().getId());
				service.exProcMschemeGetMemberByDocId(page, params);
			}else{
//				params.put("iDocId", getCurentUser().getId());
				service.exProcMschemeGetoraddMemberByDocId(page, params);
			}
		}
		ShiroUser user = getCurentUser();
		model.addAttribute("typeList", memberTypeService.selectListByOrg(user.getDept_id(), UseTag.T));
		model.addAttribute("map", params);
		model.addAttribute("page", page);
		model.addAttribute("diseases", diseaseService.selectAll_cache());
		return "health/managescheme/chooseMembers";
	}
	
	/**
	 * 
	 * @Title:hasParams 
	 * @Description: 判断参数是否有值
	 * TODO  
	 * @author baozj
	 * @param params
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean hasParams(Map<String, Object> params){
		if(params.get("vMemName") != null && String.valueOf(params.get("vMemName")).trim().length() == 0){
			params.remove("vMemName");
		}
		if(params.get("vTel") != null && String.valueOf(params.get("vTel")).trim().length() == 0){
			params.remove("vTel");
		}
		if(params.get("vIdCard") != null && String.valueOf(params.get("vIdCard")).trim().length() == 0){
			params.remove("vIdCard");
		}
		if(params.get("iMemGrpid") != null && String.valueOf(params.get("iMemGrpid")).trim().length() == 0){
			params.remove("iMemGrpid");
		}
		if(params.get("iMemId") != null && String.valueOf(params.get("iMemId")).trim().length() == 0){
			params.remove("iMemId");
		}
		if(params.get("idisease_id") != null && String.valueOf(params.get("idisease_id")).trim().length() == 0){
			params.remove("idisease_id");
		}
		if(params.get("vLItemID_list") != null && String.valueOf(params.get("vLItemID_list")).trim().length() == 0){
			params.remove("vLItemID_list");
		}
		if(params.get("vMemName")==null
				 && params.get("vTel")==null 
				 && params.get("vIdCard")==null
				 && params.get("iMemGrpid")==null
				 && params.get("iMemId")==null
				 && params.get("idisease_id")==null
				 && params.get("vLItemID_list")==null){
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @Title:deleteAttached 
	 * @Description: 清空附件记录
	 * TODO  
	 * @author baozj
	 * @param id
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/deleteAttached")
	public @ResponseBody Message deleteAttached(Integer id){
		return new SuccessMessage(service.deleteAttached(id));
	}
	
	/**
	 * 
	 * @Title:saveEditPlanTime 
	 * @Description: 修改任务执行时间
	 * TODO  
	 * @author baozj
	 * @param MSDTaskID
	 * @param planTimeValue
	 * @param planTimeType
	 * @param planTime
	 * @param type
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/saveEditPlanTime")
	public @ResponseBody Message saveEditPlanTime(Integer MSDTaskID, Short planTimeValue, Byte planTimeType, Date planTime, Byte type){
		if(service.updateTaskPlanTime(MSDTaskID, planTimeValue, planTimeType, planTime, getCurentUser().getId(), SchemeTypeEnum.getEnumByCode(type)))
			return new SuccessMessage();
		else
			return new FailMessage();
	}
	
	/**
	 * 
	 * @Title:getDoctors 
	 * @Description: 分页查询可以执行方案的医生
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param model
	 * @param memberId
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/doctors")
	public String getDoctors(Page<Doctor> page, Doctor pojo, Model model, Integer memberId){
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo", pojo);
		DoctorExample example = new DoctorExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrgidEqualTo(getCurentUser().getDept_id())
		.andRoleidNotEqualTo((short)1)
		.andTagNotEqualTo("E");
		criteria.andInMemberAndOrg(getCurentUser().getDept_id(), memberId);
		if(StringUtils.isNotEmpty(pojo.getDocname())){
			criteria.andDocnameLike("%" + pojo.getDocname() + "%");
		}
		if(pojo.getDoctorAccount() != null && StringUtils.isNotEmpty(pojo.getDoctorAccount().getDocacc())){
			criteria.andAccountLike(pojo.getDoctorAccount().getDocacc());
		}
		doctorService.selectByExampleAndPage(page, example);
		model.addAttribute("page", page);
		model.addAttribute("memberId", memberId);
		return "health/managescheme/chooseDoctor";
	}
	
	/**
	 * 
	 * @Title:selectTempletPage 
	 * @Description: 分页查询可以被使用方案模板
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/chooseTemplet")
	public String selectTempletPage(Page<ManageschemeTemplet> page, ManageschemeTemplet pojo, Model model){
		page.setPageNo(page.getPageNo());
		page.setTotalCount(-1);
		model.addAttribute("pojo", pojo);
		if(StringUtils.isNotEmpty(pojo.getSchemeTitle()) || StringUtils.isNotEmpty(pojo.getMSDiseaseIDs()) || pojo.getUpdateTimeS() != null || pojo.getUpdateTimeE() != null){
			ShiroUser user = getCurentUser();
			if(user.getDept_id() != null)
				pojo.setSuperOrgIds(orgService.selectAllSharedOrg(user.getDept_id(), true));
			pojo.setOrgID(user.getDept_id());
			pojo.setRoleId(user.getRoleid());
			pojo.setCreateID(user.getId());
			pojo.setTempletStatus(TempletStatusEnum.EFFECT.getCode());
			page = templetService.selectTempletPage(page, pojo);
		}
		model.addAttribute("page", page);
		return "health/managescheme/chooseTemplet";
	}
	
	/**
	 * 
	 * @Title:listGroup_members 
	 * @Description: 分页查询群体方案中的会员
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value = "/listGroup_members")
	public String listGroup_members(Page<ManageschemeExec> page, ManageschemeExec pojo, Model model){
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo", pojo);
		if(pojo.getMSDesignID() != null)
			model.addAttribute("page", service.selectPersonManageschemePage(page, pojo));
		return "health/managescheme/listGroup_members";
	}
	
	/**
	 * 
	 * @Title:addGroupMember 
	 * @Description: 群体方案添加会员
	 * TODO  
	 * @author baozj
	 * @param exec
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/addGroupMember")
	public @ResponseBody Message addGroupMember(ManageschemeExec exec){
		exec.setCreateID(getCurentUser().getId());
		exec.setCreateTime(TimeUtil.now());
		exec.setExecStatus(PersonManageschemeEnum.MAKING.getCode());
		exec.setMEPersonProcess(MassEffectProcessEnum.NOTRIGGER.getCode());
		if(service.insertManageschemeExecs(exec))
			return new SuccessMessage();
		else
			return new FailMessage();
	}
	
	/**
	 * 
	 * @Title:addGroupMembers 
	 * @Description: 群体方案批量添加会员
	 * TODO  
	 * @author baozj
	 * @param params
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/addGroupMembers")
	public @ResponseBody Message addGroupMembers(@RequestParam Map<String, Object> params){
		if(hasParams(params)){
			params.put("iDocId", getCurentUser().getId());
			if(service.exProcMschemeAddMemberByDocId(params))
				return new SuccessMessage();
			else
				return new FailMessage();
		}else{
			return new FailMessage();
		}
	}
	
	/**
	 * 
	 * @Title:groupEffect 
	 * @Description: 群体方案生成或生效并且生成任务
	 * TODO  
	 * @author baozj
	 * @param MSDesignID
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/groupEffect")
	public @ResponseBody Message groupEffect(Integer MSDesignID){
		int status = service.updateCanGenerateMscheme(MSDesignID);
		if(status == 1){//0、失败   1、成功	2、方案已在生成中	3、方案无任务
			taskExecutor.execute((new Runnable() {
				private Integer MSDesignID;
				public Runnable setMSDesignID(Integer mSDesignID) {
					MSDesignID = mSDesignID;
					return this;
				}
				@Override
				public void run() {
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("iMSDesignID", this.MSDesignID);
					params.put("iDocID", getCurentUser().getId());
					service.exProcMschemeAddExecTaskByMSDesignID(params);
				}
			}).setMSDesignID(MSDesignID));
			return new SuccessMessage();
		}else if(status == 2)
			return new FailMessage("方案已在生成中，不可重复生成！");
		else if(status == 3)
			return new FailMessage("你还未创建任务，不可生效！");
		else
			return new FailMessage();
	}
	
	/**
	 * 
	 * @Title:deleteGroupMember 
	 * @Description: 移除群体方案中的制定中及生成失败会员
	 * TODO  
	 * @author baozj
	 * @param id
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/deleteGroupMember")
	public  @ResponseBody Message deleteGroupMember(Long id){
		if(service.deleteGroupMember(id))
			return new SuccessMessage();
		else
			return new FailMessage();
	}
	
	/**
	 * 
	 * @Title:singleList 
	 * @Description: 单一会员中分页查询方案
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
	public String singleList(Page<ManageschemeExec> page, ManageschemeExec pojo, Model model){
		page.setPageNo(page.getPageNo());
		model.addAttribute("member", memberService.selectById(pojo.getMemberID()));
		model.addAttribute("hasMs", service.selectHasManageschemeExec(pojo.getMemberID()));
		model.addAttribute("isMy", doctorService.isMyMember(getCurentUser().getId(), pojo.getMemberID(), getCurentUser().getDept_id()));
		model.addAttribute("pojo", pojo);
		model.addAttribute("page", service.selectManageschemePage(page, pojo));
		return "health/managescheme/singleList";
	}
	
	/**
	 * 
	 * @Title:chooseHealthTemp 
	 * @Description: 分页查询可以选择的健教信息
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping("/chooseHealthTemp")
	public String chooseHealthTemp(Page<HealthEducation> page,HealthEducation pojo,Model model){
		page.setPageNo(page.getPageNo());
		page.setTotalCount(-1);
		model.addAttribute("pojo", pojo);
		if(pojo.getHeducationtype() != null || pojo.getMSDiseaseID() != null || StringUtils.isNotEmpty(pojo.getTitle()) || StringUtils.isNotEmpty(pojo.getMSDiseaseIDs())){
			ShiroUser user = getCurentUser();
			if(user.getDept_id() != null)
				pojo.setSuperOrgIds(orgService.selectAllSharedOrg(user.getDept_id(), true));
			pojo.setOrgid(user.getDept_id());
			pojo.setRoleId(user.getRoleid());
			pojo.setCreateid(user.getId());
			page = healthFacedeService.selectHealthEducationPage(page, pojo);
		}
		model.addAttribute("page", page);
		return "health/managescheme/chooseHealthTemp";
		
	}
	
	/**
	 * 
	 * @Title:selectHasOtherExecutoryTask 
	 * @Description: 判断当前任务是否有其它待执行任务
	 * TODO  
	 * @author baozj
	 * @param MSExecID
	 * @param MSETaskID
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value = "/selectHasOtherExecutoryTask")
	public @ResponseBody Message selectHasOtherExecutoryTask(Long MSExecID, Long MSETaskID){
		return new SuccessMessage(service.selectHasOtherExecutoryTask(MSExecID, MSETaskID));
	}
	
}

