/**
 * @PackageName:      com.bithealth.member
 * @FileName:     MovementsController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年11月28日 下午2:55:42  
 * 
 */
package com.bithealth.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bithealth.Message;
import com.bithealth.agentCore.AgentStatus;
import com.bithealth.agentCore.agent.RedicrectService;
import com.bithealth.agentCore.bean.Parameter;
import com.bithealth.agentCore.enums.RequestMethodEnum;
import com.bithealth.agentCore.enums.UCMethodEnum;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.memberCore.constants.Constrants;
import com.bithealth.memberCore.enmu.MovementStatusEnmu;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.facede.service.MemberInterfService;
import com.bithealth.memberCore.group.service.MemberGroupService;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberMovment;
import com.bithealth.memberCore.member.model.MemberMovmentExample;
import com.bithealth.memberCore.member.service.MemberMovmentService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.memberCore.member.vo.MovementCondition;
import com.bithealth.memberCore.memberLabel.service.MemberLabelItemService;
import com.bithealth.memberCore.uc.bean.MemberField;
import com.bithealth.memberCore.uc.bean.MemberInfo;
import com.bithealth.orgainCore.service.OrgService;
import com.bithealth.sdk.client.http.Response;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;

/**
 * 类名称: MovementsController  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年11月28日 下午2:55:42 
 * 
 * @author liuhm
 * @version  
 */
@Controller
@RequestMapping(value="/member")
public class MovementsController extends BaseSpringController {
	
	@Autowired
	private MemberMovmentService memberMovmentService;
	
	@Resource(name="memberService")
	private MemberService memberSevice;
	
	@Resource(name="RedirectImpl")
	private RedicrectService redirect;
	
	@Resource(name="doctorService")
	private DoctorService doctorService;
	
	@Autowired
	private OrgService orgService;
	
	@Autowired
	private MemberGroupService memGrpService;
	
	@Autowired
	private MemberInterfService interfaceService;
	
	@Autowired
	private MemberLabelItemService memberLabelItemService;

	@RequestMapping(value="/momvementsList")
	public String momvementsList(HttpServletRequest request, @ModelAttribute("condition")MovementCondition condition, Page<MemberMovment> page, @ModelAttribute("flag")String flag) {
		if("inner".equalsIgnoreCase(flag)) {
			condition.setCreateDrId(getCurentUser().getId());
		} else if("outer".equalsIgnoreCase(flag)) {
			condition.setConfirmDrId(getCurentUser().getId());
		}
		page = memberMovmentService.selectByPage(condition, page);
		if(page.getResult() != null && page.getResult().size() > 0) {
			for(MemberMovment movement : page.getResult()) {
				StringBuilder path = null;
				if("inner".equalsIgnoreCase(flag)) {
					path = new StringBuilder();
					getOrgPath(orgService.selectById(movement.getOutOrgID()), path);
					movement.setOutOrgName(path.toString());
				}
				if("outer".equalsIgnoreCase(flag)) {
					path = new StringBuilder();
					getOrgPath(orgService.selectById(movement.getInOrgID()), path);
					movement.setInOrgName(path.toString());
				}
			}
		}
		request.setAttribute("page", page);
		request.setAttribute("status", MovementStatusEnmu.values());
		return "/member/momvementsList";
	}
	
	@RequestMapping(value="/editMovment/{id}")
	public String editMovment(@PathVariable("id")int id, HttpServletRequest request) {
		if(id > 0) {
			MemberMovment movement = memberMovmentService.selectById(id);
			StringBuilder path = new StringBuilder();
			getOrgPath(orgService.selectById(movement.getOutOrgID()), path);
			movement.setOutOrgName(path.toString());
			request.setAttribute("movment", movement);
		}
		return "/member/editMovment";
	}
	
	@RequestMapping(value="/viewMovment/{id}")
	public String viewMovment(@PathVariable("id")int id, HttpServletRequest request) {
		request.setAttribute("view", true);
		request.setAttribute("status", MovementStatusEnmu.values());
		return editMovment(id, request);
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteMovement/{id}")
	public Message deleteMovement(@PathVariable("id")int id) {
		MemberMovment movement = memberMovmentService.selectById(id);
		if(movement == null) {
			return new Message(false, "申请不存在");
		}
		if(new Integer(MovementStatusEnmu.affirm.getStatus()).byteValue() != movement.getMoveStatus().byteValue()) {
			return new Message(false, "只有待确认的申请才能删除");
		}
		MemberMovmentExample example = new MemberMovmentExample();
		example.createCriteria().andMoveStatusEqualTo(new Integer(MovementStatusEnmu.affirm.getStatus()).byteValue())
		.andCreateIDEqualTo(getCurentUser().getId()).andMMovementIDEqualTo(movement.getMMovementID());
		memberMovmentService.deleteByExample(example);
		return new Message(true);
	}

	@RequestMapping(value="/addMovement")
	@ResponseBody
	public Message addMovement(MemberMovment movement) {
		if(movement.getMMovementID() == null || movement.getMMovementID().intValue() == 0) {
			Message message = checkConfirmMember(movement.getMemberID());
			if(message != null) {
				return message;
			}
			movement.setCreateTime(new java.sql.Timestamp(System.currentTimeMillis()));
		}
		movement.setCreateID(getCurentUser().getId());
		movement.setUpdateID(getCurentUser().getId());
		movement.setUpdateTime(new java.sql.Timestamp(System.currentTimeMillis()));
		movement.setMoveStatus(new Integer(MovementStatusEnmu.affirm.getStatus()).byteValue());
		movement.setInOrgID(getCurentUser().getDept_id());
		if(movement.getOutDrID() == null || movement.getOutDrID().intValue() == 0) {
			movement.setMoveStatus(new Integer(MovementStatusEnmu.agree.getStatus()).byteValue());
			interfaceService.updateMoveConfirm(movement, false);
			return new Message(true);
		}
		int count = 0;
		if(movement.getMMovementID() == null || movement.getMMovementID().intValue() == 0) {
			count = memberMovmentService.insert(movement);
		} else {
			count = memberMovmentService.update(movement);
		}
		if(count > 0) {
			return new Message(true);
		}
		return new Message(false, "操作失败");
	}
	
	@RequestMapping(value="/ucMembers")
	public String ucMembers(@ModelAttribute("omem")Member member, HttpServletRequest request) {
		String tel = member.getTel();
		String idcard = member.getIdcard();
		String memberName = member.getMemname();
		if(StringUtil.isEmpty(memberName) && StringUtil.isEmpty(idcard) && StringUtil.isEmpty(tel)) {
			request.setAttribute("msg", "请输入查询条件");
			return "/member/ucMembers";
		}
		MemberInfo info = MemberField.getInfo(member);
		Map<String, CharSequence> param = new HashMap<String, CharSequence>();
		param.put("params", JSONObject.toJSONString(info));
		String serverId = Constrants.SERVERID;
		param.put("serverID", serverId);
		Parameter parameters = new Parameter(RequestMethodEnum.POST);
		parameters.setHost(Constrants.DNS);
		parameters.setParam(param);
		Response response = redirect.redirect(UCMethodEnum.GetMembers, parameters);
		if(response == null) {
			request.setAttribute("msg", "请求UCUC服务超时");
			return  "/member/ucMembers";
		}
		if(response.getStatus() == AgentStatus.SC_OK) {
			String body = response.getBody();
			if(StringUtil.isEmpty(body)) {
				request.setAttribute("msg", "没有符合条件的数据");
			} else {
				try{
					request.setAttribute("memberList", JSONArray.parseArray(body));
				} catch(Exception e) {
					request.setAttribute("msg", "无权访问认证系统");
				}
			}
		} else {
			request.setAttribute("msg", "请求UC异常");
		}
		return "/member/ucMembers";
	}
	
	@RequestMapping(value="/checkUCMember")
	@ResponseBody
	public Message checkUCMember(String memberGUID, String serverID) {
		String localServerId = Constrants.SERVERID;
		if(!localServerId.equalsIgnoreCase(serverID)) {
			return new Message("Not Included", false);
		}
		Member member = memberSevice.selectByUUID(memberGUID, null);
		if(member == null || UseTag.E.name().equals(member.getUsetag())) {
			return new Message("会员不存在当前系统", false);
		}
		com.bithealth.memberCore.member.model.Org memberOrg = member.getOrg();
		if(memberOrg == null) {
			return new Message("当前会员不隶属任何组织", false);
		}
		if(memberOrg.getOrgId() == getCurentUser().getDept_id().intValue()) {
			return new Message("当前会员与您属于同一组织，申请失败", false);
		}
		boolean isApp = memberLabelItemService.isAppRegist(member.getMemberid(), com.bithealth.memberCore.constants.Constrants.APP_USER);
		boolean isWeb = memberLabelItemService.isAppRegist(member.getMemberid(), com.bithealth.memberCore.constants.Constrants.WEB_USER);
		if(isApp && !isWeb && member.getIsInfoPerfect().byteValue() == 0) {
			return new Message("会员资料未完善", false);
		}
//		boolean isMy = doctorService.isMyMember(getCurentUser().getId(), member.getMemberid(), getCurentUser().getDept_id());
//		if(isMy) {
//			return new Message("当前会员已经属于您的会员，名称为【" + member.getMemname() + "】,无需申请转入", false);
//		}
		Message message = checkConfirmMember(member.getMemberid());
		if(message != null) {
			return message;
		}
		JSONObject obj = new JSONObject();
		obj.put("memberID", member.getMemberid());
		com.bithealth.orgainCore.model.Org org = orgService.selectById(member.getOrgid());
		if(org == null) {
			return new Message(true, obj);
		}
		StringBuilder path = new StringBuilder();
		getOrgPath(org, path);
		obj.put("orgId", org.getOrgId());
		obj.put("orgName", path);
		Integer docCount = doctorService.countByMember(member.getMemberid());
		obj.put("hasDoc", (docCount == null || docCount == 0) ? false : true);
		return new Message(true, obj);
	}
	
	private Message checkConfirmMember(Integer memberId) {
		MemberMovment movment = getConfirmMovmentByMember(memberId, MovementStatusEnmu.affirm);
		if(movment != null) {
			return new Message("此会员当前已被【" + movment.getCreateDrName() + "】医生申请转入,且还未处理,您不可再申请!", false);
		}
		return null;
	}
	
	private MemberMovment getConfirmMovmentByMember(Integer memberId, MovementStatusEnmu status) {
		MemberMovmentExample example = new MemberMovmentExample();
		example.createCriteria().andMoveStatusEqualTo(new Integer(status.getStatus()).byteValue())
		.andMemberIDEqualTo(memberId);
		List<MemberMovment> movements = memberMovmentService.selectByExample(example);
		if(movements == null || movements.size() == 0) {
			return null;
		}
		return movements.get(0);
	}
	
	@RequestMapping(value="/memberDoctors")
	public String memberDoctors(@ModelAttribute("memberId")String memberId, Page<Doctor> page, HttpServletRequest request) {
		page = doctorService.selectByMember(Integer.parseInt(memberId), page);
		request.setAttribute("page", page);
		return "/member/memberDoctors";
	}
	
	@RequestMapping(value = "/confirmResult/{id}")
	public String confirmResult(@PathVariable("id")int id, HttpServletRequest request) {
		MemberMovment movement = memberMovmentService.selectById(id);
		StringBuilder path = new StringBuilder();
		getOrgPath(orgService.selectById(movement.getInOrgID()), path);
		movement.setInOrgName(path.toString());
		request.setAttribute("movement", movement);
		return "/member/confirmResult";
	}
	
	@RequestMapping(value="/confirm")
	@ResponseBody
	public Message confirm(MemberMovment movement) {
		MemberMovment model = memberMovmentService.selectById(movement.getMMovementID());
		if(model == null) {
			return new Message("申请不存在", false);
		}
		if(getCurentUser().getId().intValue() != model.getOutDrID().intValue()) {
			return new Message("该申请，您无权操作", false);
		}
		movement.setConfirmTime(new java.sql.Timestamp(System.currentTimeMillis()));
		movement.setUpdateID(getCurentUser().getId());
		movement.setUpdateTime(new java.sql.Timestamp(System.currentTimeMillis()));
		try{
			if(new Integer(MovementStatusEnmu.agree.getStatus()).byteValue() == movement.getMoveStatus().byteValue()) {
				interfaceService.updateMoveConfirm(movement, true);
			}
			if(new Integer(MovementStatusEnmu.refuse.getStatus()).byteValue() == movement.getMoveStatus().byteValue()) {
				memberMovmentService.update(movement);
			}
		} catch (Exception e) {
			return new Message(e.getMessage(), false);
		}
		return new Message(true);
	}
	
	private void getOrgPath(com.bithealth.orgainCore.model.Org org, StringBuilder path) {
		if(path.length() == 0) {
			path.append(org.getOrgName());
		} else {
			path.insert(0, org.getOrgName() + "->>");
		}
		if(org.getParentOrg() != null) {
			getOrgPath(org.getParentOrg(), path);
		}
	}
}
