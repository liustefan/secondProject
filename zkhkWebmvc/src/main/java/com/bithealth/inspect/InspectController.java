 
/**
 * @PackageName:      com.bithealth.inspect
 * @FileName:     InspectController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月25日 上午10:48:34  
 * 
 */

package com.bithealth.inspect;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bithealth.Message;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.inspectCore.facede.service.InspectFacedeService;
import com.bithealth.inspectCore.inspect.model.PhDiabetes;
import com.bithealth.inspectCore.inspect.model.PhDiabetesdetailmedicine;
import com.bithealth.inspectCore.inspect.model.PhHypertension;
import com.bithealth.inspectCore.inspect.model.PhHypertensiondetailmedicine;
import com.bithealth.memberCore.member.model.DiseasesHistoryExample;
import com.bithealth.memberCore.member.model.SearchCondition;
import com.bithealth.memberCore.member.service.DiseasesHistoryService;
import com.bithealth.memberCore.member.vo.MemberVo;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;


/**
 * 类名称: InspectController  
 * 功能描述: TODO 公卫随访  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月25日 上午10:48:34 
 * 
 * @author baozj
 * @version  
 */
@Controller
@RequestMapping(value = "/inspect") 
public class InspectController extends BaseSpringController {

	@Autowired
	private InspectFacedeService inspectService;
	@Resource(name="doctorService")
	private DoctorService doctorService;
	@Resource(name="diseasesHistoryService")
	protected DiseasesHistoryService diseasesHistoryService;
	
	/**
	 * 
	 * @Title:dPList 
	 * @Description:糖尿病随访列表 (待随访) 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/diabetes/plist")
	public String dPList(Page<PhDiabetes> page, PhDiabetes pojo, Model model){
		pojo.setPending(true);
		return diabetesList(page, pojo, model);
	}
	
	/**
	 * 
	 * @Title:dList 
	 * @Description:糖尿病随访列表 (已随访) 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/diabetes/list")
	public String dList(Page<PhDiabetes> page, PhDiabetes pojo, Model model){
		page.setPageNo(page.getPageNo());
		pojo.setPending(false);
		return diabetesList(page, pojo, model);
	}
	
	/**
	 * 
	 * @Title:diabetesList 
	 * @Description: 分页查询糖尿病随访
	 * TODO
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	private String diabetesList(Page<PhDiabetes> page, PhDiabetes pojo, Model model){
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo", pojo);
		model.addAttribute("page", inspectService.selectPhDiabetesPage(page, pojo, getCurentUser().getId()));
		if(pojo.getMemberID() != null){
			boolean isMy = doctorService.isMyMember(getCurentUser().getId(), pojo.getMemberID(), getCurentUser().getDept_id());
			if(!isMy)
				pojo.setPending(false);
			else if(!pojo.getPending())
				pojo.setPending(false);
			else
				pojo.setPending(true);
			model.addAttribute("isMy", isMy);
			model.addAttribute("hasDiseases", hasDiseasesHistory(2, pojo.getMemberID()));
		}else{
			model.addAttribute("isMy", true);
		}
		return "inspect/diabetes/list";
	}
	
	/**
	 * 
	 * @Title:diabetesView 
	 * @Description: 查看糖尿病随访详情
	 * TODO
	 * @author baozj
	 * @param id
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/diabetes/view")
	public String diabetesView(Long id, Model model){
		PhDiabetes pojo = inspectService.selectPhDiabetesById(id);
		model.addAttribute("pojo", pojo);
		return "inspect/diabetes/view";
	}
	
	/**
	 * 
	 * @Title:toDiabetesEdit 
	 * @Description: 查看糖尿病随访详情（编辑、新增使用）
	 * TODO
	 * @author baozj
	 * @param id
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/diabetes/toEdit")
	public String toDiabetesEdit(Long id, Integer memberID, String memName, String unique_ID, Model model){
		PhDiabetes pojo = inspectService.selectPhDiabetesById(id);
		if(pojo == null){
			pojo = new PhDiabetes();
			pojo.setVisitDrName(getCurentUser().getRealName());
			pojo.setMember(pojo.createMember());
			pojo.getMember().setMemname(memName);
			pojo.getMember().setMemberid(memberID);
			pojo.setUnique_ID(unique_ID);
			pojo.setVisitClass((byte)0);
			pojo.setVisitDate(TimeUtil.now());
		}
		model.addAttribute("pojo", pojo);
		return "inspect/diabetes/edit";
	}
	
	/**
	 * 
	 * @Title:diabetesSave 
	 * @Description: 保存糖尿病随访
	 * TODO
	 * @author baozj
	 * @param pojo
	 * @param redirectAttributes
	 * @return 
	 * @throws
	 * @retrun String
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/diabetes/save")
	public String diabetesSave(PhDiabetes pojo, @RequestParam(defaultValue="false")Boolean singleMembers, RedirectAttributes redirectAttributes) throws UnsupportedEncodingException{
		if(!hasDiseasesHistory(2, pojo.getMemberID())){
			redirectAttributes.addFlashAttribute("message", "保存失败！当前会员没有糖尿病史，请添加");
		}else{
			ShiroUser su = getCurentUser();
			pojo.setCreateDrID(su.getId());
			pojo.setCreateDrName(su.getRealName());
			pojo.setUpdateDrID(su.getId());
			pojo.setUpdateDrName(su.getRealName());
			pojo.setRefCompany((byte)0);
			pojo.setGetTime(TimeUtil.now());
			if(pojo.getPhDiabetesdetailmedicines() == null)
				pojo.setPhDiabetesdetailmedicines(new ArrayList<PhDiabetesdetailmedicine>());
			if(inspectService.insertOrUpdateDiabetes(pojo))
				redirectAttributes.addFlashAttribute("message", "保存成功！");
			else
				redirectAttributes.addFlashAttribute("message", "保存失败！当前会员已存在待随访记录");
		}
		if(pojo.getPending())
			return "redirect:plist" + (singleMembers ? "?memberID=" + pojo.getMemberID() + "&name=" + URLEncoder.encode(pojo.getName(), "UTF-8") + "&unique_ID=" + pojo.getUnique_ID() + "" : "");
		else
			return "redirect:list" + (singleMembers ? "?memberID=" + pojo.getMemberID() : "");
	}
	
	/**
	 * 
	 * @Title:diabetesRemove 
	 * @Description: 删除糖尿病随访（支持批量删除）
	 * TODO
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/diabetes/remove")
	public @ResponseBody Message diabetesRemove(Long...ids){
		if(inspectService.deleteSoftPhDiabetes(ids))
			return new Message("删除成功！", true);
		else
			return new Message("删除失败！", false);
	}
	
	/**
	 * 
	 * @Title:PPList 
	 * @Description: 分页查询高血压随访列表 (待随访) 
	 * TODO
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/hypertension/plist")
	public String PPList(Page<PhHypertension> page, PhHypertension pojo, Model model){
		pojo.setPending(true);
		return hypertensionList(page, pojo, model);
	}
	
	/**
	 * 
	 * @Title:PList 
	 * @Description: 分页查询高血压随访列表 (已随访) 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/hypertension/list")
	public String PList(Page<PhHypertension> page, PhHypertension pojo, Model model){
		pojo.setPending(false);
		return hypertensionList(page, pojo, model);
	}
	
	/**
	 * 
	 * @Title:hypertensionList 
	 * @Description: 分页查询高血压随访
	 * TODO
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	private String hypertensionList(Page<PhHypertension> page, PhHypertension pojo, Model model){
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo", pojo);
		model.addAttribute("page", inspectService.selectPhHypertensionPage(page, pojo, getCurentUser().getId()));
		if(pojo.getMemberID() != null){
			boolean isMy = doctorService.isMyMember(getCurentUser().getId(), pojo.getMemberID(), getCurentUser().getDept_id());
			if(!isMy)
				pojo.setPending(false);
			else if(!pojo.getPending())
				pojo.setPending(false);
			else
				pojo.setPending(true);
			model.addAttribute("isMy", isMy);
			model.addAttribute("hasDiseases", hasDiseasesHistory(1, pojo.getMemberID()));
		}else{
			model.addAttribute("isMy", true);
		}
		return "inspect/hypertension/list";
	}
	
	/**
	 * 
	 * @Title:hypertensionView 
	 * @Description: 查看高血压随访详情
	 * TODO
	 * @author baozj
	 * @param id
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/hypertension/view")
	public String hypertensionView(Long id, Model model){
		PhHypertension pojo = inspectService.selectPhHypertensionById(id);
		model.addAttribute("pojo", pojo);
		return "inspect/hypertension/view";
	}
	
	/**
	 * 
	 * @Title:toHypertensionEdit 
	 * @Description: 查看高血压随访详情（编辑、新增使用）
	 * TODO
	 * @author baozj
	 * @param id
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/hypertension/toEdit")
	public String toHypertensionEdit(Long id, Integer memberID, String memName, String unique_ID, Model model){
		PhHypertension pojo = inspectService.selectPhHypertensionById(id);
		if(pojo == null){
			pojo = new PhHypertension();
			pojo.setVisitDrName(getCurentUser().getRealName());
			pojo.setMember(pojo.createMember());
			pojo.getMember().setMemname(memName);
			pojo.getMember().setMemberid(memberID);
			pojo.setUnique_ID(unique_ID);
			pojo.setVisitClass((byte)0);
			pojo.setVisitDate(TimeUtil.now());
		}
		model.addAttribute("pojo", pojo);
		return "inspect/hypertension/edit";
	}
	
	/**
	 * 
	 * @Title:hypertensionSave 
	 * @Description: 保存高血压随访
	 * TODO
	 * @author baozj
	 * @param pojo
	 * @param redirectAttributes
	 * @return 
	 * @throws
	 * @retrun String
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/hypertension/save")
	public String hypertensionSave(PhHypertension pojo, @RequestParam(defaultValue="false")Boolean singleMembers, RedirectAttributes redirectAttributes) throws UnsupportedEncodingException{
		if(!hasDiseasesHistory(1, pojo.getMemberID())){
			redirectAttributes.addFlashAttribute("message", "保存失败！当前会员没有高血压病史，请添加");
		}else{
			ShiroUser su = getCurentUser();
			pojo.setCreateDrID(su.getId());
			pojo.setCreateDrName(su.getRealName());
			pojo.setUpdateDrID(su.getId());
			pojo.setUpdateDrName(su.getRealName());
			pojo.setRefCompany((byte)0);
			pojo.setGetTime(TimeUtil.now());
			if(pojo.getPhHypertensiondetailmedicines() == null)
				pojo.setPhHypertensiondetailmedicines(new ArrayList<PhHypertensiondetailmedicine>());
			if(inspectService.insertOrUpdateHypertension(pojo))
				redirectAttributes.addFlashAttribute("message", "保存成功！");
			else
				redirectAttributes.addFlashAttribute("message", "保存失败！当前会员已存在待随访记录");
		}
		if(pojo.getPending())
			return "redirect:plist" + (singleMembers ? "?memberID=" + pojo.getMemberID() + "&name=" + URLEncoder.encode(pojo.getName(), "UTF-8") + "&unique_ID=" + pojo.getUnique_ID() + "" : "");
		else
			return "redirect:list" + (singleMembers ? "?memberID=" + pojo.getMemberID() : "");
	}
	
	/**
	 * 
	 * @Title:hasDiseasesHistory 
	 * @Description: 判断会员是否有某种疾病史 
	 * TODO  
	 * @author baozj
	 * @param type
	 * @param memberId
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	private boolean hasDiseasesHistory(Integer type, Integer memberId){
		if(memberId == null)
			return true;
		DiseasesHistoryExample example = new DiseasesHistoryExample();
		example.createCriteria()
		.andMemberidEqualTo(memberId)
		.andDiseaseidEqualTo(type);
		return diseasesHistoryService.selectByExample(example).size() > 0;
	}
	
	/**
	 * 
	 * @Title:hypertensionRemove 
	 * @Description: 删除高血压随访（支持批量删除）
	 * TODO
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/hypertension/remove")
	public @ResponseBody Message hypertensionRemove(Long...ids){
		if(inspectService.deletePhHypertension(ids))
			return new Message("删除成功！", true);
		else
			return new Message("删除失败！", false);
	}
	
	/**
	 * 
	 * @Title:getDMembers 
	 * @Description: 分页查询可以进行糖尿病随访的会员
	 * TODO
	 * @author baozj
	 * @param page
	 * @param condition
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/diabetes/members")
	public String getDMembers(Page<MemberVo> page, SearchCondition<MemberVo> condition, Model model){
		model.addAttribute("page", inspectService.exProcGetDiabetesMemList(page, getParams(condition, model)));
		return "inspect/chooseMember";
	}
	
	/**
	 * 
	 * @Title:getHMembers 
	 * @Description: 分页查询可以进行高血压随访的会员
	 * TODO
	 * @author baozj
	 * @param page
	 * @param condition
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/hypertension/members")
	public String getHMembers(Page<MemberVo> page, SearchCondition<MemberVo> condition, Model model){
		model.addAttribute("page", inspectService.exProcGetHypertensionMemList(page, getParams(condition, model)));
		return "inspect/chooseMember";
	} 
	
	/**
	 * 
	 * @Title:getParams 
	 * @Description: 查询条件转map
	 * TODO
	 * @author baozj
	 * @param condition
	 * @param model
	 * @return 
	 * @throws
	 * @retrun Map<String,Object>
	 */
	private Map<String, Object> getParams(SearchCondition<MemberVo> condition, Model model){
		model.addAttribute("pojo", condition);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iDocId", getCurentUser().getId());
		params.put("vMemName", condition.getMemName());
		params.put("vTel", condition.getTel());
		params.put("vIdCard", condition.getIdcard());
		params.put("dSCreateTime", condition.getCreTimeStart());
		params.put("dECreateTime", condition.getCreTimeEnd());
		return params;
	}
	
	/**
	 * 
	 * @Title:getDLatestInfoByMemberId 
	 * @Description: 根据会员编号查询会员最近糖尿病随访相关信息
	 * TODO
	 * @author baozj
	 * @param id
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/diabetes/getLatestInfoByMemberId")
	public @ResponseBody Message getDLatestInfoByMemberId(Integer id){
		return new Message(null, null, true, inspectService.selectLatestPhDiabetesInfo(id));
	}
	
	/**
	 * 
	 * @Title:getHLatestInfoByMemberId 
	 * @Description: 根据会员编号查询会员最近高血压随访相关信息
	 * TODO
	 * @author baozj
	 * @param id
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/hypertension/getLatestInfoByMemberId")
	public @ResponseBody Message getHLatestInfoByMemberId(Integer id){
		return new Message(null, null, true, inspectService.selectLatestPhHypertensionInfo(id));
	}
}

