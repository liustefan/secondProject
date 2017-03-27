 
/**
 * @PackageName:      com.bithealth.inspect
 * @FileName:     PhysicalController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月25日 上午10:48:06  
 * 
 */

package com.bithealth.inspect;

import java.util.ArrayList;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bithealth.Message;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.model.DoctorExample;
import com.bithealth.doctorCore.doctor.model.DoctorExample.Criteria;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.inspectCore.facede.service.PhysicalFacedeService;
import com.bithealth.inspectCore.physical.model.PhHealthexam;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetail;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailfamilybed;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailinpatient;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailmedicine;
import com.bithealth.inspectCore.physical.model.PhHealthexamdetailnonimmune;
import com.bithealth.memberCore.member.model.SearchCondition;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.memberCore.member.vo.MemberVo;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;


/**
 * 类名称: PhysicalController  
 * 功能描述: TODO 健康体检  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月25日 上午10:48:06 
 * 
 * @author baozj
 * @version  
 */
@Controller
@RequestMapping(value = "/inspect/physical")
public class PhysicalController extends BaseSpringController {

	@Autowired
	private PhysicalFacedeService physicalService;
	@Resource(name="memberService")
	private MemberService memberService;
	@Resource(name="doctorService")
	private DoctorService doctorService;
	
	/**
	 * 
	 * @Title:list 
	 * @Description: 分页查询健康体检
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/list")
	public String list(Page<PhHealthexam> page, PhHealthexam pojo, Model model){
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo", pojo);
		model.addAttribute("page", physicalService.selectPage(page, pojo, getCurentUser().getId()));
		if(pojo.getMemberID() != null)
			model.addAttribute("isMy", doctorService.isMyMember(getCurentUser().getId(), pojo.getMemberID(), getCurentUser().getDept_id()));
		else
			model.addAttribute("isMy", true);
		return "inspect/physical/list";
	}
	
	/**
	 * 
	 * @Title:view 
	 * @Description: 查看健康体检详情
	 * TODO  
	 * @author baozj
	 * @param id
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/view")
	public String view(Long id, Model model){
		
		model.addAttribute("pojo", physicalService.selectPhHealthexamById(id));
		return "inspect/physical/view";
	}
	
	/**
	 * 
	 * @Title:toEdit 
	 * @Description: 查看健康体检详情（编辑、新增使用）
	 * TODO  
	 * @author baozj
	 * @param id
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/toEdit")
	public String toEdit(Long id, Integer memberID, String memName, String unique_ID, Model model){
		PhHealthexam pojo = physicalService.selectPhHealthexamById(id);
		if(pojo == null){
			pojo = new PhHealthexam();
			pojo.createMember();
			pojo.getMember().setMemname(memName);
			pojo.getMember().setMemberid(memberID);
			pojo.setUnique_ID(unique_ID);
			pojo.setExamDate(TimeUtil.now());
			pojo.setResponsibleDrName(getCurentUser().getRealName());
			pojo.setRefDataPK(UUID.randomUUID().toString());
		}
		if(pojo.getPhHealthexamdetail() == null){
			pojo.setPhHealthexamdetail(new PhHealthexamdetail());
		}
		model.addAttribute("pojo", pojo);
		return "inspect/physical/edit";
	}
	
	/**
	 * 
	 * @Title:save 
	 * @Description: 保存健康体检
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @param redirectAttributes
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/save")
	public String save(PhHealthexam pojo, @RequestParam(defaultValue="false")Boolean singleMembers, RedirectAttributes redirectAttributes){
		ShiroUser su = getCurentUser();
		pojo.setCreateDrID(su.getId());
		pojo.setCreateDrName(su.getRealName());
		pojo.setUpdateDrID(su.getId());
		pojo.setUpdateDrName(su.getRealName());
		pojo.setRefCompany((byte)0);
		pojo.setGetTime(TimeUtil.now());
		if(pojo.getPhHealthexamdetailfamilybeds() == null)
			pojo.setPhHealthexamdetailfamilybeds(new ArrayList<PhHealthexamdetailfamilybed>());
		if(pojo.getPhHealthexamdetailinpatients() == null)
			pojo.setPhHealthexamdetailinpatients(new ArrayList<PhHealthexamdetailinpatient>());
		if(pojo.getPhHealthexamdetailmedicines() == null)
			pojo.setPhHealthexamdetailmedicines(new ArrayList<PhHealthexamdetailmedicine>());
		if(pojo.getPhHealthexamdetailnonimmunes() == null)
			pojo.setPhHealthexamdetailnonimmunes(new ArrayList<PhHealthexamdetailnonimmune>());
		if(physicalService.insertOrUpdatePhHealthexam(pojo))
			redirectAttributes.addFlashAttribute("message", "保存成功！");
		else
			redirectAttributes.addFlashAttribute("message", "保存失败！");
		return "redirect:list" + (singleMembers ? "?memberID=" + pojo.getMemberID() : "");
	}
	
	/**
	 * 
	 * @Title:remove 
	 * @Description: 删除健康体检（支持批量删除）
	 * TODO  
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/remove")
	public @ResponseBody Message remove(Long...ids){
		if(physicalService.deleteSoftPhHealthexam(ids))
			return new Message("删除成功！", true);
		else
			return new Message("删除失败！", false);
	}
	
	/**
	 * 
	 * @Title:getMembers 
	 * @Description: 分页查询我的会员
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/members")
	public String getMembers(Page<MemberVo> page, SearchCondition<MemberVo> pojo, Model model){
		page.setPageNo(page.getPageNo());
		pojo.setPage(page);
		model.addAttribute("pojo", pojo);
		pojo.setDocId(getCurentUser().getId());
		model.addAttribute("page", memberService.listMyMemberByPage(pojo));
		return "inspect/chooseMember";
	}
	
	/**
	 * 
	 * @Title:getDoctors 
	 * @Description: 分页查询当前组织下医生
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/doctors")
	public String getDoctors(Page<Doctor> page, Doctor pojo, Model model){
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo", pojo);
		DoctorExample example = new DoctorExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrgidEqualTo(getCurentUser().getDept_id())
		.andRoleidNotEqualTo((short)1)
		.andTagNotEqualTo("E");
		if(StringUtils.isNotEmpty(pojo.getDocname())){
			criteria.andDocnameLike("%" + pojo.getDocname() + "%");
		}
		if(pojo.getDoctorAccount() != null && StringUtils.isNotEmpty(pojo.getDoctorAccount().getDocacc())){
			criteria.andAccountLike(pojo.getDoctorAccount().getDocacc());
		}
		doctorService.selectByExampleAndPage(page, example);
		model.addAttribute("page", page);
		return "inspect/chooseDoctor";
	}
	
}

