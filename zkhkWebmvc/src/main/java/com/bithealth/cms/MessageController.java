 
/**
 * @PackageName:      com.bithealth.cms
 * @FileName:     MessageController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年9月6日 上午11:09:03  
 * 
 */

package com.bithealth.cms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bithealth.FailMessage;
import com.bithealth.Message;
import com.bithealth.SuccessMessage;
import com.bithealth.careCore.care.constants.Constrants;
import com.bithealth.careCore.facade.model.KindlyReminder;
import com.bithealth.careCore.facade.service.CareIFService;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.group.model.MemToGroupExample;
import com.bithealth.memberCore.group.model.MemToGroupKey;
import com.bithealth.memberCore.group.service.MemToGroupService;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.model.MemberExample;
import com.bithealth.memberCore.member.model.SearchCondition;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.memberCore.member.service.MemberTypeService;
import com.bithealth.memberCore.member.vo.MemberVo;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;


/**
 * 类名称: MessageController  
 * 功能描述: TODO 温馨提示  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年9月6日 上午11:09:03 
 * 
 * @author baozj
 * @version  
 */
@Controller
@RequestMapping(value = "/message") 
public class MessageController extends BaseSpringController {
	
	@Resource(name="memberService")
	private MemberService memberService;
	@Resource(name="memberTypeService")
	private MemberTypeService memberTypeService;
	@Autowired
	private MemToGroupService memToGroupService;
	@Autowired
	private CareIFService careIFService;
	@Autowired
	private DoctorService doctorService;
	
	/**
	 * 
	 * @Title:memberList 
	 * @Description: 选择发送温馨提示会员分页列表
	 * TODO  
	 * @author baozj
	 * @param request
	 * @param condition
	 * @param flag
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/memberList")
	public String memberList(HttpServletRequest request, SearchCondition<MemberVo> condition, String flag) {
        ShiroUser user = getCurentUser();
        condition.setDocId(user.getId());
        condition.getPage().setPageNo(condition.getPage().getPageNo());
		Page<MemberVo> page = memberService.listAllMemberByPage(condition);
		request.setAttribute("page", page);
		request.setAttribute("flag", flag);
		request.setAttribute("condition", condition);
		request.setAttribute("typeList", memberTypeService.selectListByOrg(user.getDept_id(), UseTag.T));
		return "msgCenter/message/memberList";
	}
	
	/**
	 * 
	 * @Title:toSendMsg 
	 * @Description: 选择一个发送温馨提示会员
	 * TODO  
	 * @author baozj
	 * @param memberId
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/toSendMsg")
	public String toSendMsg(Integer memberId, KindlyReminder pojo, Model model){
		selectPageByMemberId(memberId, null, null, pojo, model);
		return "msgCenter/message/messageNew";
	}
	
	/**
	 * 
	 * @Title:msgView 
	 * @Description: 跳转分页查看发送给单个会员的温馨提示页面
	 * TODO  
	 * @author baozj
	 * @param memberId
	 * @param pojo
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/msgView")
	public String msgView(Integer memberId, Date startTime, Date endTime, @ModelAttribute("pojo")KindlyReminder pojo, Model model){
		model.addAttribute("startTime", startTime);
		model.addAttribute("endTime", endTime);
		selectPageByMemberId(memberId, startTime, endTime, pojo, model);
		return "msgCenter/message/messagelist";
	}
	
	/**
	 * 
	 * @Title:selectPageByMemberId 
	 * @Description: 分页查看发送给单个会员的温馨提示数据
	 * TODO  
	 * @author baozj
	 * @param memberId
	 * @param pojo
	 * @param model 
	 * @throws
	 * @retrun void
	 */
	private void selectPageByMemberId(Integer memberId, Date startTime, Date endTime, KindlyReminder pojo, Model model){
		try {
			Member member = memberService.selectById(memberId);
			ShiroUser user = getCurentUser();
			Doctor doctor = doctorService.selectById(user.getId());
			pojo.setPageNo(pojo.getPageNo());
			pojo.setSenderGUID(doctor.getDocGUID());
			pojo.setReceiverGUID(member.getMemberGUID());
			pojo.setPageNo(pojo.getPageNo());
			if(startTime != null)
				pojo.setStartDate(TimeUtil.formatDate(startTime));
			if(endTime != null)
				pojo.setEndDate(TimeUtil.formatDate(DateUtils.addDays(endTime, 1)));
			model.addAttribute("member", member);
			model.addAttribute("page", careIFService.getMsgListFormCenterServer(pojo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Title:sendMsgByMemberId 
	 * @Description: 发送温馨提示（单人会员）
	 * TODO  
	 * @author baozj
	 * @param memberId
	 * @param content
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/sendMsgByMemberId")
	public @ResponseBody Message sendMsgByMemberId(Integer memberId, String content){
		
		Member member = memberService.selectById(memberId);
		ArrayList<String> memberGUIDs = new ArrayList<String>();
		memberGUIDs.add(member.getMemberGUID());
		return sendMsg(content, memberGUIDs);
	}
	
	/**
	 * 
	 * @Title:sendMsgByGroupId 
	 * @Description: 发送温馨提示（单人会员分组<群发>）
	 * TODO  
	 * @author baozj
	 * @param groupId
	 * @param content
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/sendMsgByGroupId")
	public @ResponseBody Message sendMsgByGroupId(Integer groupId, String content){
		
		MemToGroupExample example = new MemToGroupExample();
		example.createCriteria().andMemgrpidEqualTo(groupId);
		List<MemToGroupKey> list = memToGroupService.selectByExample(example);
		if(list != null && list.size() > 0){
			List<Integer> memberIds = new ArrayList<Integer>();
			for(Iterator<MemToGroupKey> it = list.iterator(); it.hasNext();){
				memberIds.add(it.next().getMemberid());
			}
			MemberExample mExample = new MemberExample();
			mExample.createCriteria().andMemberidIn(memberIds);
			List<Member> mems = memberService.selectByExample(mExample);
			ArrayList<String> memberGUIDs = new ArrayList<String>();
			for(Iterator<Member> it = mems.iterator(); it.hasNext();){
				memberGUIDs.add(it.next().getMemberGUID());
			}
			return sendMsg(content, memberGUIDs);
		}else{
			return new FailMessage();
		}
	}
	
	/**
	 * 
	 * @Title:sendMsg 
	 * @Description: 发送温馨提示
	 * TODO  
	 * @author baozj
	 * @param content
	 * @param memberGUIDs
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	private Message sendMsg(String content, ArrayList<String> memberGUIDs){
		try {
			ShiroUser user = getCurentUser();
			Doctor doctor = doctorService.selectById(user.getId());
			KindlyReminder pojo = new KindlyReminder();
			pojo.setSendType(1);
			pojo.setSenderGUID(doctor.getDocGUID());
			pojo.setSenderName(doctor.getDocname());
			pojo.setMsgType(1);
			pojo.setContent(content);
			if(memberGUIDs.size() > Constrants.MAX_SEND_NUM){
				int times = memberGUIDs.size()/Constrants.MAX_SEND_NUM + (memberGUIDs.size()%Constrants.MAX_SEND_NUM > 0 ? 1 : 0);
				int flag = 0;
				for(int i = 1; i <= times; i++){
					pojo.setReceiverGUIDList(new ArrayList<String>(memberGUIDs.subList((i-1)*Constrants.MAX_SEND_NUM, i == times ? memberGUIDs.size() : i*Constrants.MAX_SEND_NUM)));
					if(!"success".equals(careIFService.sendKindlyReminder(pojo))){
						if(i == 1)//第一批次消息失败，发送失败
							flag = 2;
						else//非第一批次消息失败，部分发送成功
							flag = 1;
						break;
					}
				}
				if(flag == 0)
					return new SuccessMessage("发送成功！");
				else if(flag == 1)
					return new SuccessMessage("部分发送成功！");
				else
					return new FailMessage("发送失败！");
			}else{
				pojo.setReceiverGUIDList(memberGUIDs);
				if("success".equals(careIFService.sendKindlyReminder(pojo)))
					return new SuccessMessage("发送成功！");
				else
					return new FailMessage("发送失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new FailMessage("发送失败！");
		}
	}
	
	/**
	 * 
	 * @Title:remove 
	 * @Description: 删除、批量删除温馨提示
	 * TODO  
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/remove")
	public @ResponseBody Message remove(Integer...ids){
		try {
			if(careIFService.deleteMsg(Arrays.asList(ids)))
				return new SuccessMessage();
			else
				return new FailMessage();
		} catch (Exception e) {
			
			e.printStackTrace();
			return new FailMessage();
		}
	}
}

