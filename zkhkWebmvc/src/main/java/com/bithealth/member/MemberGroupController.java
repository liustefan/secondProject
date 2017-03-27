/**
 * @PackageName:      com.bithealth.member
 * @FileName:     MemberGroupController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年7月23日 下午2:21:07  
 * 
 */
package com.bithealth.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bithealth.Message;
import com.bithealth.doctorCore.docGroup.model.DocGrpToMemGrpKey;
import com.bithealth.doctorCore.docGroup.service.DocGrpToMemGrpService;
import com.bithealth.memberCore.group.model.MemberGroup;
import com.bithealth.memberCore.group.model.MemberGroupExample;
import com.bithealth.memberCore.group.service.MemToGroupService;
import com.bithealth.memberCore.group.service.MemberGroupService;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.orgainCore.service.OrgService;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.core.exception.BusinessException;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;
import com.bithealth.vo.ZTree;

/**
 * 类名称: MemberGroupController  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月23日 下午2:21:07 
 * 
 * @author liuhm
 * @version  
 */
@Controller
@RequestMapping(value = "/memberGrp")
public class MemberGroupController extends BaseSpringController {
	
	@Resource(name="memberGroupService")
	private MemberGroupService groupService;
	
	@Resource(name="orgService")
	private OrgService orgService;
	
	@Resource(name="memToGroupService")
	private MemToGroupService mtgService;
	
	@Resource(name="docGrpToMemGrpService")
	private DocGrpToMemGrpService docGrpToMemGrpService;
	
	@RequestMapping(value="/listMemGrpByDoctor")
	@ResponseBody
	public List<ZTree> listMemGrpByDoctor(String memGrpid) {
		ShiroUser user = getCurentUser();
		List<ZTree> list = new ArrayList<ZTree>();
		ZTree root = new ZTree("0", user.getOrgName(), null);
		root.setNocheck(true);
		root.setHasAuth(false);
		root.setChecked(false);
		list.add(root);

		List<MemberGroup> grpList = groupService.selectByDoctorAndOrg(user.getId(), user.getDept_id());
		if(grpList == null || grpList.size() == 0) {
			return list;
		}
		Map<String, MemberGroup> data = new HashMap<String, MemberGroup>();  //整棵树节点，包含一些医生无法管理的节点
		Map<String, MemberGroup> enableMap = new HashMap<String, MemberGroup>();  //医生管理的节点
		for(MemberGroup group : grpList) {
			recursiviteGroupUp(group, data);
			enableMap.put(String.valueOf(group.getMemgrpid().intValue()), group);  //有权限的分组集合
		}
		List<String> ids = new ArrayList<String>();
		if(StringUtil.isNotEmpty(memGrpid)) {
			String[] arr = memGrpid.split(",");
			for(String id : arr) {
				ids.add(id);
			}
		}
		
		for(MemberGroup group : data.values()) {
			String id = String.valueOf(group.getMemgrpid());
			ZTree tree = new ZTree(id, group.getMemgrpname(), String.valueOf(group.getFamemid()));
			tree.setNocheck(!enableMap.containsKey(id));
			tree.setHasAuth(enableMap.containsKey(id));
			tree.setChecked(ids.contains(id));
			list.add(tree);
		}
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/editMemberToGroup")
	public Message editMemberToGroup(HttpServletRequest request) {
		String memberids = request.getParameter("memberid");
		if(StringUtil.isEmpty(memberids)) {
			return new Message("会员为空", false);
		}
		List<Member> memberList = new ArrayList<Member>();
		String[] memberIdArr = memberids.split(",");
		for(String memberId : memberIdArr) {
			Member member = new Member();
			member.setMemberid(Integer.parseInt(memberId));
			memberList.add(member);
		}
		
		String grpIds = request.getParameter("grpids");
		List<MemberGroup> groupList = new ArrayList<MemberGroup>();
		if(StringUtil.isNotEmpty(grpIds)) {
			String[] ids = grpIds.split(",");
			for(String id : ids) {
				MemberGroup group = new MemberGroup();
				group.setMemgrpid(Integer.parseInt(id));
				groupList.add(group);
			}
		}
		ShiroUser user = getCurentUser();
		int count = 0;
		if(!"Y".equals(request.getParameter("batch"))) {
			List<MemberGroup> docGrpList = groupService.selectByDoctorAndOrg(user.getId(), user.getDept_id());
			count = mtgService.insertBatchByMember(groupList, memberList.get(0), docGrpList);
		} else {
			count = mtgService.insertBatch(groupList, memberList);
		}
		
		if(count < 1) {
			return new Message("修改失败", false);
		}
		return new Message("修改成功", true);
	}
	
	@RequestMapping("/groupTotal")
	public String groupTotal(HttpServletRequest request) {
		String pid = request.getParameter("pId");
		request.setAttribute("pId", StringUtil.isEmpty(pid) ? 0 : Integer.parseInt(pid));
		return "/member/groupTotal";
	}
	
	@RequestMapping("/listAllGroup")
	@ResponseBody
	public List<ZTree> listAllGroup() {
		MemberGroupExample example = new MemberGroupExample();
		example.setOrderByClause("`order` asc");
		int orgId = getCurentUser().getDept_id() == null ? 0 : getCurentUser().getDept_id();
		example.createCriteria().andOrgidEqualTo(orgId).andFamemidEqualTo(0);
		List<MemberGroup> list = groupService.selectByExample(example);
		List<ZTree> treeList = new ArrayList<ZTree>();
		treeList.add(getTreeNode(null));
		recursiviteGroupDown(list, treeList, orgId);
		return treeList;
	}
	
	@RequestMapping("/listMemberGroup")
	public String listMemberGroup(HttpServletRequest request, Page<MemberGroup> page, @ModelAttribute("memGrpName")String memGrpName) {
		String pId = request.getParameter("pId");
		int fId = StringUtil.isEmpty(pId) ? 0 : Integer.parseInt(pId);
		MemberGroupExample example = new MemberGroupExample();
		example.setOrderByClause("`order` DESC");
		int orgId = getCurentUser().getDept_id() == null ? 0 : getCurentUser().getDept_id();
		MemberGroupExample.Criteria criteria  = example.createCriteria();
		criteria.andOrgidEqualTo(orgId).andFamemidEqualTo(fId);
		if(StringUtil.isNotEmpty(memGrpName)) {
			criteria.andMemgrpnameLike("%" + memGrpName + "%");
		}
		List<MemberGroup> list = groupService.selectByExampleAndPage(page, example);
		page.setResult(list);
		request.setAttribute("page", page);
		request.setAttribute("group", getParent(fId));
		return "/member/listMemberGroup";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id")int id, HttpServletRequest request) {
		String parentId = request.getParameter("pId");
		MemberGroup parent = null;
		int pId = 0;
		if(id > 0) {
			MemberGroup pojo = groupService.selectById(id);
			if(pojo.getFamemid() == null || pojo.getFamemid().intValue() == 0) {
				parent = getParent(0);
			} else {
				parent = pojo.getParentGroup();
			}
			request.setAttribute("pojo", pojo);
		} else {
			pId = StringUtil.isEmpty(parentId) ? 0 : Integer.parseInt(parentId);
			parent = getParent(pId);
			request.setAttribute("detaultOrder", groupService.getMaxOrder(pId, getCurentUser().getDept_id()));
		}
		request.setAttribute("parent", parent);
		return "/member/editGroup";
	}
	
	@RequestMapping("/checkNameExists")
	@ResponseBody
	public boolean checkNameExists(MemberGroup group) {
		MemberGroup data = groupService.checkGroupExist(getCurentUser().getDept_id(), group.getFamemid(), group.getMemgrpname());
		if(data == null) {
			return true;
		} else {
			if(group.getMemgrpid() == null || group.getMemgrpid().intValue() == 0) {
				return false;
			}
			if(data.getMemgrpid().intValue() != group.getMemgrpid().intValue()) {
				return false;
			}
		}
		return true;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Message add(MemberGroup group) {
		if(!this.checkNameExists(group)) {
			return new Message("会员分组名重复", false);
		}
		int count = 0;
		if(group.getMemgrpid() == null || group.getMemgrpid() == null) {
			group.setOrgid(getCurentUser().getDept_id() == null ? 0 : getCurentUser().getDept_id());
			count = groupService.insert(group);
		} else {
			count = groupService.updateByPrimaryKey(group);
		}
		if(count < 1) {
			return new Message("操作失败", false);
		}
		return new Message("操作成功", true);
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Message delete(@PathVariable("id")int id) {
		try {
			if(mtgService.countByMemAndGrpId(null,id) > 0) {
				return new Message("分组已经绑定会员，不能删除", false);
			}
			int count = groupService.delete(id);
			if(count > 0) {
				return new Message("删除成功", true);
			}
		} catch (BusinessException e) {
			return new Message(e.getMessage(), false);
		}
		
		return new Message("删除失败", false);
	}
	
	@RequestMapping("/bindDoctorGroup")
	@ResponseBody
	public Message bindDoctorGroup(HttpServletRequest request) {
		String json = request.getParameter("json");
		List<DocGrpToMemGrpKey> list = JSON.parseArray(json, DocGrpToMemGrpKey.class);
		Integer memGrpid = Integer.parseInt(request.getParameter("memGrpid"));
		int count = docGrpToMemGrpService.insertBatchByMemGroup(list, memGrpid);
		if(count > 0) {
			return new Message("绑定成功", true);
		}
		return new Message("绑定失败", false);
	}
	
	private MemberGroup getParent(Integer id) {
		MemberGroup group = null;
		if(id == null || id.intValue() == 0) {
			group = new MemberGroup();
			group.setMemgrpid(0);
			group.setMemgrpname(getCurentUser().getOrgName());
			group.setPath(",0,");
		} else {
			group = groupService.selectById(id);
		}
		return group;
	}
	
	/**
	 * 
	 * @Title:recursiviteGroupUp 
	 * @Description:子节点向父节点遍历. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param group
	 * @param data 
	 * @param 
	 * @throws
	 * @retrun void
	 */
	private void  recursiviteGroupUp(MemberGroup group, Map<String, MemberGroup> data) {
		if(!data.containsKey(group.getMemgrpid().intValue())) {
			data.put(String.valueOf(group.getMemgrpid().intValue()), group);
		}
		if(group.getParentGroup() != null) {
			recursiviteGroupUp(group.getParentGroup(), data);
		}
	}
	
	/**
	 * 
	 * @Title:recursiviteGroupDown 
	 * @Description:父节点向子节点遍历. 
	 * TODO(这里描述这个方法适用条件  执行流程  使用方法 注意事项– 可选).  
	 * @author liuhm
	 * @param list
	 * @param treeList 
	 * @param 
	 * @throws
	 * @retrun void
	 */
	private void recursiviteGroupDown(List<MemberGroup> list, List<ZTree> treeList, int orgId) {
		if(list == null || list.size() == 0) {
			return;
		}
		for(MemberGroup group : list) {
			if(group.getOrgid().intValue() != orgId) {
				continue;
			}
			treeList.add(getTreeNode(group));
			recursiviteGroupDown(group.getChildren(), treeList, orgId);
		}
	}
	
	private ZTree getTreeNode(MemberGroup group) {
		ZTree root = null;
		if(group == null) {
			root = new ZTree("0", getCurentUser().getOrgName(), null);
			root.setOpen(true);
		} else {
			root = new ZTree(String.valueOf(group.getMemgrpid()), group.getMemgrpname(), String.valueOf((group.getFamemid() == null ? 0 : group.getFamemid())));
		    root.setOpen(true);
		}
		return root;
	}
	

}
