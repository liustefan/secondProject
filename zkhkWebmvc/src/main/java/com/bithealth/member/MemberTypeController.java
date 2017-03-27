/**
 * @PackageName:      com.bithealth.member
 * @FileName:     MemberTypeController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月30日 下午2:45:24  
 * 
 */
package com.bithealth.member;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bithealth.Message;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.member.model.MemberExample;
import com.bithealth.memberCore.member.model.MemberType;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.memberCore.member.service.MemberTypeService;
import com.bithealth.sdk.core.exception.BusinessException;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;

/**
 * 类名称: MemberTypeController  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月30日 下午2:45:24 
 * 
 * @author liuhm
 * @version  
 */

@Controller
@RequestMapping("/memberType")
public class MemberTypeController extends BaseSpringController {
	
	@Resource(name="memberTypeService")
	private MemberTypeService typeService;
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	@RequestMapping("/listMemberType")
	public String listMemberType(HttpServletRequest request) {
		ShiroUser user = getCurentUser();
		List<MemberType> typeList = typeService.selectListByOrg(user.getDept_id(), null);
		request.setAttribute("typeList", typeList);
		return "/member/listMemberType";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id")Short id, HttpServletRequest request) {
		if(id != null && id.intValue() > 0) {
			request.setAttribute("memberType", typeService.selectById(id));
		}
		request.setAttribute("tags", new String[]{UseTag.T.name(), UseTag.F.name()});
		request.setAttribute("msg", request.getAttribute("msg"));
		return "/member/editType";
	}
	
	@RequestMapping("/add")
	public String add(MemberType type, HttpServletRequest request) {
		type.setOrgid(getCurentUser().getDept_id());
		int count = 0;
		try{
			if(type.getMemid() == null) {
				count = typeService.insert(type);
			} else {
				count = typeService.update(type);
			}
		} catch (BusinessException e) {
			request.setAttribute("msg", e.getMessage());
			return "forward:/memberType/edit/" + (type.getMemid() == null ? 0 : type.getMemid());
		}
		if(count < 1) {
			request.setAttribute("msg", "操作失败");
			return "forward:/memberType/edit/" + (type.getMemid() == null ? 0 : type.getMemid());
		}
		return "redirect:/memberType/listMemberType";
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Message delete(@PathVariable("id")Short id) {
		MemberExample example = new MemberExample();
		MemberExample.Criteria criteria = example.createCriteria();
		criteria.andMemidEqualTo(id);
		criteria.andUsetagEqualTo(UseTag.T.name());
		if( memberService.countByExample(example) > 0 ) {
			return new Message("删除失败，存在关联会员", false);
		}
		if(typeService.delete(id) > 0) {
			return new Message("删除成功", true);
		}
		return new Message("删除失败", false);
	}

}
