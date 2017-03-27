/**
 * @PackageName:      com.bithealth.doctor
 * @FileName:     DoctorGroupController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月3日 下午7:06:22  
 * 
 */
package com.bithealth.doctor;

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
import com.bithealth.doctorCore.docGroup.model.DocGrpToMemGrpExample;
import com.bithealth.doctorCore.docGroup.model.DocGrpToMemGrpKey;
import com.bithealth.doctorCore.docGroup.model.DocToGroup;
import com.bithealth.doctorCore.docGroup.model.DocToGroupExample;
import com.bithealth.doctorCore.docGroup.model.DocToGroupKey;
import com.bithealth.doctorCore.docGroup.model.DoctorGroup;
import com.bithealth.doctorCore.docGroup.model.DoctorGroupExample;
import com.bithealth.doctorCore.docGroup.service.DocGrpToMemGrpService;
import com.bithealth.doctorCore.docGroup.service.DoctorGroupService;
import com.bithealth.doctorCore.docGroup.service.DoctorToGroupService;
import com.bithealth.doctorCore.doctor.model.Doctor;
import com.bithealth.doctorCore.facede.service.DoctorGroupInterfService;
import com.bithealth.reportCore.facade.service.TemplateIFService;
import com.bithealth.reportCore.template.model.Option;
import com.bithealth.reportCore.template.model.OptionExample;
import com.bithealth.reportCore.template.service.OptionService;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.core.exception.BusinessException;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.vo.ZTree;

/**
 * 类名称: DoctorGroupController  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月3日 下午7:06:22 
 * 
 * @author liuhm
 * @version  
 */
@Controller
@RequestMapping("/docGrp")
public class DoctorGroupController extends BaseSpringController {
	
	@Resource(name="doctorToGroupService")
	private DoctorToGroupService docToGrpService;
	
	@Resource(name="doctorGroupService")
	private DoctorGroupService doctorGroupService;
	
	@Resource(name="optionService")
	private OptionService optionService;
	
	@Resource(name="templateIFService")
	private TemplateIFService templateIFService;
	
	@Resource(name="docGrpToMemGrpService")
	private DocGrpToMemGrpService docGrpToMemGrpService;
	
	@Resource(name="doctorGroupInterfService")
	private DoctorGroupInterfService doctorGroupInterfService;
	
	@RequestMapping("/initDocGrpTree")
	@ResponseBody
	public List<ZTree> initDocGrpTree(HttpServletRequest request) {
		String docid = request.getParameter("doctorid");
		List<DocToGroup> docToGrpList = null;
		Integer orgId = getCurentUser().getDept_id();
		if(StringUtil.isNotEmpty(docid)) {
			DocToGroupExample example = new DocToGroupExample();
	    	DocToGroupExample.Criteria c = example.createCriteria();
	    	c.andDocidEqualTo(Integer.parseInt(docid));
	    	c.andOrgidEqualTo(orgId);
	    	docToGrpList = docToGrpService.selectByExample(example);
		}
		Map<String, Short> doctorMap = getDocGroupIds(docToGrpList);  //已分配的医生分组
		List<DoctorGroup> allGroup = this.getRoots(orgId);
		return initTree(allGroup, doctorMap, orgId);
	}
	
	@RequestMapping("/initDocGrpTreeByMemGrp")
	@ResponseBody
	public List<ZTree> initDocGrpTreeByMemGrp(HttpServletRequest request) {
		int memGrpId = Integer.parseInt(request.getParameter("memGrpId"));
		DocGrpToMemGrpExample example = new DocGrpToMemGrpExample();
		example.createCriteria().andMemgrpidEqualTo(memGrpId);
		List<DocGrpToMemGrpKey> docGrpToMemGrpList = docGrpToMemGrpService.selectByExample(example);
		Map<String, Short> doctorMap = this.getGroupByMemGrp(docGrpToMemGrpList);  //已分配的医生分组
		Integer orgId = getCurentUser().getDept_id();
		List<DoctorGroup> allGroup = this.getRoots(orgId);
		List<ZTree> treeList = initTree(allGroup, doctorMap, orgId);
		return treeList;
	}
	
	private List<ZTree> initTree(List<DoctorGroup> allGroup, Map<String, Short> checkedMap, Integer orgId) {
		List<ZTree> treeList = new ArrayList<ZTree>();
		ZTree tree = new ZTree("0", getCurentUser().getOrgName(), null);
		tree.setOpen(true);
		tree.setNocheck(true);
		treeList.add(tree);
		getTree(treeList, allGroup, checkedMap, orgId);
		return treeList;
	}
	
	@RequestMapping("/bindGroup")
	@ResponseBody
	public Message bindGroup(HttpServletRequest request){
		if(getCurentUser().getRoleid().intValue() != 1) {
			return new Message("无权操作", false);
		}
		
		Integer orgId = getCurentUser().getDept_id();
		String json = request.getParameter("json");
		List<DocToGroup> docToGrpList = JSON.parseArray(json, DocToGroup.class);
		if(docToGrpList != null && docToGrpList.size() > 0) {
			for(DocToGroup group : docToGrpList) {
				group.setOrgid(orgId);
			}
		}
		
		Doctor doctor = new Doctor();
		doctor.setDocid(Integer.parseInt(request.getParameter("docId")));
		doctor.setOrgid(orgId);
		
		int count = docToGrpService.insertBatchByDoctor(docToGrpList, doctor);
		if(count > 0) {
			return new Message("操作成功", true);
		}
		return new Message("操作失败", false);
	}
	
	@RequestMapping("/groupTotal")
	public String groupTotal(@ModelAttribute("pId")String pId) {
		return "/doctor/groupTotal";
	}
	
	@RequestMapping("/listDoctorGrp")
	public String listDoctorGrp(@ModelAttribute("pId")String pId, @ModelAttribute("odgpname")String odgpname, HttpServletRequest request, Page<DoctorGroup> page) {
		int fId = 0;
		if(StringUtil.isNotEmpty(pId)) {
			fId = Integer.parseInt(pId);
		}
		request.setAttribute("parent", getParentById(fId));
		
		DoctorGroupExample example = new DoctorGroupExample();
		example.setOrderByClause("`order` DESC");
		DoctorGroupExample.Criteria criteria = example.createCriteria();
		criteria.andOrgidEqualTo(getCurentUser().getDept_id());
		criteria.andFathidEqualTo(fId);
		if(StringUtil.isNotEmpty(odgpname)) {
			criteria.andOdgpnameLike("%" + odgpname.trim() + "%");
		}
		List<DoctorGroup> list = doctorGroupService.selectByExampleAndPage(page, example);
		page.setResult(list);
		request.setAttribute("page", page);
		return "/doctor/listDoctorGrp";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id")int id, HttpServletRequest request){
		String fid = request.getParameter("pId");
		int pId = 0;
		if(StringUtil.isNotEmpty(fid)) {  //新增时才有fid
			pId = Integer.parseInt(fid);
			request.setAttribute("parent", getParentById(pId));
			request.setAttribute("defaultOrder", doctorGroupService.getDefaultOrder(pId, getCurentUser().getDept_id()));
		}
		
		if(id > 0) {
			DoctorGroup group = doctorGroupService.selectById(id);
			request.setAttribute("group", group);
			request.setAttribute("parent", group.getParentGroup());
		}
		
		return "/doctor/editGroup";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Message add(DoctorGroup group) {
		if(!checkNameExists(group)) {
			return new Message("分组名在组织下已经存在", false);
		}
		int count  = 0;
		if(group.getOdgpid() == null) {
			count = doctorGroupService.insert(group);
		} else {
			DoctorGroup dg = null;
			if(!group.getEndblocktag()) {
				if(docToGrpService.countByDoctorAndGrop(null, group.getOdgpid()) > 0) {
					return new Message("分组下存在医生，只能为终节点", false);
				}
				dg = doctorGroupService.selectById(group.getOdgpid());
				if(dg.getChlevel() != null || dg.getFunid() != null || dg.getOptid() != null) {
					return new Message("分组已设置了审核权限，只能为终节点", false);
				}
			} else {
				dg = doctorGroupService.selectById(group.getOdgpid());
				if(dg.getChildren() != null && dg.getChildren().size() > 0) {
					return new Message("分组下存在下级分组，不能设置为终节点", false);
				}
			}
			dg.setEndblocktag(group.getEndblocktag());
			dg.setOdgpname(group.getOdgpname());
			dg.setRemark(group.getRemark());
			dg.setOrder(group.getOrder());
			count = doctorGroupService.updateByPrimaryKey(dg);
		}
		if(count > 0) {
			return new Message("操作成功", true);
		}
		return new Message("操作失败", false);
	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Message delete(@PathVariable("id")int id) {
		try{
			int count = doctorGroupInterfService.deleteDoctorGroup(id);
			if(count > 0) {
				return new Message("删除成功", true);
			}
		} catch (BusinessException e) {
			return new Message(e.getMessage(), false);
		}
		return new Message("删除失败", false);
	}
	
	@RequestMapping("/checkNameExists")
	@ResponseBody
	public boolean checkNameExists(DoctorGroup group) {
		DoctorGroup dg = doctorGroupService.checkGroupExist(getCurentUser().getDept_id(), group.getParentGroup().getOdgpid(), group.getOdgpname());
	    if(dg == null) {
	    	return true;
	    }
	    if(group.getOdgpid() != null && dg.getOdgpid().intValue() != group.getOdgpid().intValue()) {
	    	return false;
	    }
	    if(group.getOdgpid() == null && dg != null) {
	    	return false;
	    }
	    return true;
	}
	
	@RequestMapping("/listDocByGrp")
	public String listDocByGrp(HttpServletRequest request,Page<DocToGroup> page) {
		int groupId = Integer.parseInt(request.getParameter("groupId"));
		DoctorGroup group = getParentById(groupId);
		request.setAttribute("group", group);
		List<DoctorGroup> parentList = new ArrayList<DoctorGroup>();
		getParentList(group, parentList);
		request.setAttribute("parentList", parentList);
		DocToGroupExample example = new DocToGroupExample();
		example.createCriteria().andOdgpidEqualTo(groupId);
		example.setOrderByClause("Docid DESC");
		List<DocToGroup> list = docToGrpService.selectByExampleAndPage(page, example);
		page.setResult(list);
		request.setAttribute("page", page);
		return "/doctor/listDocByGrp";
	}
	
	@RequestMapping("/removeDoctor")
	@ResponseBody
	public Message removeDoctor(DocToGroupKey docToGroup) {
		int count = docToGrpService.delete(docToGroup);
		if(count > 0) {
			return new Message("移除成功", true);
		}
		return new Message("移除失败", false);
	}
	
	@RequestMapping("/reviseAuthority/{id}")
	public String reviseAuthority(@PathVariable("id")int id, HttpServletRequest request) {
		request.setAttribute("pojo", getParentById(id));
		return "/doctor/reviseAuthority";
	}
	
	@ResponseBody
	@RequestMapping("/listOption")
	public List<Option> listOption(Short funId) {
		List<Integer> orgList = new ArrayList<Integer>();
		orgList.add(-1);
		orgList.add(getCurentUser().getDept_id());
		OptionExample example = new OptionExample();
		example.createCriteria().andFunIdEqualTo(funId).andOrgidIn(orgList);
		example.setOrderByClause("OptId ASC");
		return optionService.selectByExample(example);
	}
	
	@RequestMapping("/getMaxLevel")
	@ResponseBody
	public Integer getMaxLevel(Short optId, Short funId) {
		Integer cheLevel = templateIFService.selectMaxAuditLevelByParams(getCurentUser().getDept_id(), funId, optId);
		return cheLevel;
	}
	
	@ResponseBody
	@RequestMapping("/grant")
	public Message grant(DoctorGroup group) {
		DoctorGroup docGrp = doctorGroupService.selectById(group.getOdgpid());
		docGrp.setChlevel(group.getChlevel());
		docGrp.setOptid(group.getOptid());
		docGrp.setFunid(group.getFunid());
		int count = doctorGroupService.updateByPrimaryKey(docGrp);
		if(count > 0) {
			return new Message("设置权限成功", true);
		}
		return new Message("设置权限失败", false);
	}
	
	private void getParentList(DoctorGroup group, List<DoctorGroup> list) {
		if(group.getParentGroup() != null) {
			DoctorGroup parent = group.getParentGroup();
			list.add(0, parent);
			getParentList(parent, list);
		} else {
			if(group.getFathid() == null || group.getFathid().intValue() == 0) {
				list.add(0, getParentById(0));
			}
		}
	}
	
	private DoctorGroup getParentById(int pId) {
		DoctorGroup parent = null;
		if(pId == 0) {
			parent = new DoctorGroup();
			parent.setOdgpname(getCurentUser().getOrgName());
			parent.setOdgpid(pId);
			parent.setEndblocktag(false);
			parent.setPath(",0,");
		} else {
			parent = doctorGroupService.selectById(pId);
		}
		return parent;
	}
	
	
	private Map<String, Short> getDocGroupIds(List<DocToGroup> docToGrpList) {
		Map<String, Short> ids = new HashMap<String, Short>();
		if(docToGrpList == null) {
			return ids;
		}
		for(DocToGroup group : docToGrpList) {
			String id = String.valueOf(group.getOdgpid());
			if(!ids.containsKey(id)) {
				ids.put(id, group.getAuditlevel());
			}
		}
		return ids;
	}
	
	private Map<String, Short> getGroupByMemGrp(List<DocGrpToMemGrpKey> docToGrpList) {
		Map<String, Short> ids = new HashMap<String, Short>();
		if(docToGrpList == null) {
			return ids;
		}
		for(DocGrpToMemGrpKey group : docToGrpList) {
			String id = String.valueOf(group.getOdgpid());
			if(!ids.containsKey(id)) {
				ids.put(id, Short.MIN_VALUE);
			}
		}
		return ids;
	}
	
	
	private void getTree(List<ZTree> treeList, List<DoctorGroup> allGroup, Map<String, Short> doctorMap, Integer orgId) {
		if(allGroup == null || allGroup.size() == 0) {
			return;
		}
		for(DoctorGroup group : allGroup) {
			if(orgId != null && group.getOrgid().intValue() != orgId) {
				continue;
			}
			ZTree tree = new ZTree(String.valueOf(group.getOdgpid()), group.getOdgpname(), String.valueOf(group.getFathid()));
			tree.setOpen(true);
			tree.setNocheck(!group.getEndblocktag());
			tree.setMaxLevel(group.getChlevel());
			if(doctorMap.containsKey(String.valueOf(group.getOdgpid()))) {
				tree.setChecked(true);
				tree.setAuditLevel(doctorMap.get(String.valueOf(group.getOdgpid())));
			}
			treeList.add(tree);
			getTree(treeList, group.getChildren(), doctorMap, orgId);
		}
	}
	
	/**
	 * 
	 * @Title:getRoots 
	 * @Description:当前组织下的医生分组根节点. 
	 * @author liuhm
	 * @param orgId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<DoctorGroup>
	 */
	private List<DoctorGroup> getRoots(int orgId) {
		DoctorGroupExample docExam = new DoctorGroupExample();
		DoctorGroupExample.Criteria docCriteria = docExam.createCriteria();
		docCriteria.andOrgidEqualTo(orgId);
		docCriteria.andFathidEqualTo(0);
		docExam.setOrderByClause("`order`");
		List<DoctorGroup> allGroup = doctorGroupService.selectByExample(docExam);
		return allGroup;
	}
	
}
