/**
 * @PackageName:      com.bithealth.organization
 * @FileName:     OrgController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      liuhm
 * @version      V1.0  
 * @Createdate:  2016年8月1日 下午4:40:19  
 * 
 */
package com.bithealth.organization;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bithealth.Message;
import com.bithealth.memberCore.enmu.UseTag;
import com.bithealth.memberCore.member.service.MemberTypeService;
import com.bithealth.orgainCore.enmu.MemMustItemEnum;
import com.bithealth.orgainCore.model.Org;
import com.bithealth.orgainCore.model.OrgConfig;
import com.bithealth.orgainCore.model.OrgExample;
import com.bithealth.orgainCore.service.OrgConfigService;
import com.bithealth.orgainCore.service.OrgService;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.core.exception.BusinessException;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.vo.ZTree;

/**
 * 类名称: OrgController  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月1日 下午4:40:19 
 * 
 * @author liuhm
 * @version  
 */
@Controller
@RequestMapping("/org")
public class OrgController extends BaseSpringController {
	
	@Resource(name="orgService")
	private OrgService orgService;
	
	@Resource(name="orgConfigService")
	private OrgConfigService configService;
	
	@Resource(name="memberTypeService")
	private MemberTypeService typeService;
	
	/**
	 * 
	 * @Title:listAllOrg 
	 * @Description:制定组织ID下的子节点. 
	 * @author liuhm
	 * @param pId
	 * @return 
	 * @param 
	 * @throws
	 * @retrun List<ZTree>
	 */
	@RequestMapping("/listAllOrg")
	@ResponseBody
	public List<ZTree> listAllOrg(Integer pId) {
		OrgExample example = new OrgExample();
		OrgExample.Criteria criteria = example.createCriteria();
		if(pId == null) {
			criteria.andSuperiorEqualTo(0);
		} else {
			criteria.andSuperiorEqualTo(pId);
		}
		List<com.bithealth.orgainCore.model.Org> list = orgService.selectByExample(example);
		List<ZTree> treeList = new ArrayList<ZTree>();
		getTree(treeList, list);
		return treeList;
	}
	
	@RequestMapping("/orgPage")
	public String orgPage(HttpServletRequest request, String id) {
		Integer orgId = 0;
		if(StringUtil.isNotEmpty(id)) {
			orgId = Integer.parseInt(id);
		}
		if(orgId == 0 || orgId == null) {
			OrgExample example = new OrgExample();
			OrgExample.Criteria c = example.createCriteria();
			c.andSuperiorEqualTo(orgId);
			orgId = orgService.selectByExample(example).get(0).getOrgId();
		}
		request.setAttribute("id", orgId);
		return "/orgs/orgPage";
	}
	
	@RequestMapping("/listOrg")
	public String listOrg(HttpServletRequest request, Integer orgId, @ModelAttribute("orgName")String orgName, Page<Org> page) {
		if(orgId == null) {
			orgId = 0;
		}
		Org parent = orgService.selectById(orgId);
		request.setAttribute("parent", parent);
		OrgExample example = new OrgExample();
		OrgExample.Criteria c = example.createCriteria();
		c.andSuperiorEqualTo(orgId);
		if(StringUtil.isNotEmpty(orgName)) {
			c.andOrgNameLike("%" + orgName + "%");
		}
		example.setOrderByClause("`order` ASC");
		page.setResult(orgService.selectByExampleAndPage(page, example));
		request.setAttribute("page", page);
		return "/orgs/listOrg";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id")int id, HttpServletRequest request) {
		Org parent = null;
		if(id > 0) {
			Org org = orgService.selectById(id);
			parent = org.getParentOrg();
			request.setAttribute("org", org);
		} else {
			int pId = Integer.parseInt(request.getParameter("pId"));
			parent = orgService.selectById(pId);
			request.setAttribute("detaultOrder", orgService.getMaxOrger(pId));
		}
		request.setAttribute("parent", parent);
		return "/orgs/edit";
	}
	
	@RequestMapping("/checkNameExists")
	@ResponseBody
	public boolean checkNameExists(Org org) {
		Org data = orgService.selectExistByName(org.getOrgName(), org.getSuperior());
		if(org.getOrgId() == null || org.getOrgId() == 0) {
			if(data == null) {
				return true;
			}
		} else {
			if(org.getOrgId().intValue() == data.getOrgId().intValue()) {
				return true;
			}
		}
		return false;
	}
	
	@RequestMapping("/checkCodeExists")
	@ResponseBody
	public boolean checkCodeExists(Org org) {
		Org data = orgService.selectExistByCode(org.getOrgCode());
		if(org.getOrgId() == null || org.getOrgId() == 0) {
			if(data == null) {
				return true;
			}
		} else {
			if(org.getOrgId().intValue() == data.getOrgId().intValue()) {
				return true;
			}
		}
		return false;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public Message add(Org org) {
		int count = 0;
		try{
			if(org.getOrgId() == null || org.getOrgId() == 0) {
				count = orgService.insert(org);
			} else {
				count = orgService.update(org);
			}
		} catch(BusinessException e) {
			return new Message(e.getMessage(), false);
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
			orgService.delete(id);
		} catch (BusinessException e) {
			return new Message(e.getMessage(), false);
		}
		return new Message("操作成功", true);
	}
	
	@RequestMapping("/setting/{id}")
	public String setting(@PathVariable("id")int id, HttpServletRequest request) {
		Org config = orgService.selectById(id);
		request.setAttribute("org", config);
		request.setAttribute("typeList", typeService.selectListByOrg(id, UseTag.T));
		request.setAttribute("memMustItemSettins", MemMustItemEnum.values());
		if("TV".equalsIgnoreCase(com.bithealth.Constrants.VERSION_TAG)) {
			return "/orgs/TVsetting";
		}
		return "/orgs/setting";
	}
	
	@RequestMapping("/config")
	@ResponseBody
	public Message config(OrgConfig config) {
		String msg = MemMustItemEnum.checked(config.settings());
		if(StringUtil.isNotEmpty(msg)) {
			return new Message("配置失败:" + msg, false);
		}
		if(config.getSharedParentNode() == null) {
			config.setSharedParentNode(new Byte("0"));
		}
		config.setUpdateDrID(getCurentUser().getId());
		config.setUpdateTime(new Date());
		int count = 0;
		if(config.getLogID() == null) {
			config.setCreateDrID(getCurentUser().getId());
			config.setCreateTime(new Date());
			count = configService.insert(config);
		} else {
			count = configService.updateByPrimaryKey(config);
		}
		if(count > 0) {
			return new Message("配置成功", true);
		}
		return new Message("配置失败", false);
	}
	
	
	private void getTree(List<ZTree> treeList, List<com.bithealth.orgainCore.model.Org> orgList) {
		if(orgList == null || orgList.size() == 0) {
			return;
		}
		for(com.bithealth.orgainCore.model.Org org : orgList) {
			ZTree tree = new ZTree(String.valueOf(org.getOrgId()), org.getOrgName(), String.valueOf(org.getSuperior() == null ? 0 : org.getSuperior()));
			tree.setEndTag(org.getIsExternalService());
			treeList.add(tree);
			getTree(treeList, org.getChildren());
		}
	}
	

}
