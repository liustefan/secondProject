package com.bithealth.health;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bithealth.Message;
import com.bithealth.cmsCore.healthEducation.dao.HealthEducationDiseaseMapper;
import com.bithealth.healthCore.diseaseManage.dao.ManageDiseaseMapper;
import com.bithealth.healthCore.diseaseManage.model.ManageDisease;
import com.bithealth.healthCore.diseaseManage.model.ManageDiseaseExample;
import com.bithealth.healthCore.diseaseManage.service.ManageDiseaseService;
import com.bithealth.healthCore.templet.service.ManageschemeTempletDiseaseService;
import com.bithealth.sdk.common.utils.StringUtil;
import com.bithealth.sdk.core.exception.BusinessException;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;
import com.bithealth.vo.DiseaseTree;


/**
 * 类名称:DiseaseManageController 
 * 功能描述: 疾病管理控制层
 * 日期: 2016年11月29日 
 * 
 * @author 周玉飞
 * @version  
 */
@Controller
@RequestMapping(value = "/health")
public class DiseaseManageController extends BaseSpringController{

	@Autowired
	private ManageDiseaseService manageDiseaseService;
	@Autowired
	HealthEducationDiseaseMapper healthEducationDiseaseMapper;
	@Autowired
	ManageDiseaseMapper manageDiseaseMapper;
	@Autowired
	ManageschemeTempletDiseaseService manageschemeTempletDiseaseService;
	
	@RequestMapping("/listAllDisease")
	@ResponseBody
	public List<DiseaseTree> listAllDisease(Integer pId) {
		ManageDiseaseExample example = new ManageDiseaseExample();
		ManageDiseaseExample.Criteria criteria= example.createCriteria();
		if (pId==null) {
			criteria.andParentidEqualTo(0);
		}else{
			criteria.andParentidEqualTo(pId);
		}
		List<ManageDisease> list = manageDiseaseService.selectByExample(example);
		List<DiseaseTree> treeList = new ArrayList<DiseaseTree>();
		getTree(treeList, list);
		return treeList;
	}
	
	
	@RequestMapping("/illType")
	public String orgPage(HttpServletRequest request, String id) {
		Integer msdiseaseid=0;
		if(StringUtil.isNotEmpty(id)) {
			msdiseaseid = Integer.parseInt(id);
		}
		if(msdiseaseid == 0 || msdiseaseid == null) {
			ManageDiseaseExample example = new ManageDiseaseExample();
			ManageDiseaseExample.Criteria criteria= example.createCriteria();
			criteria.andParentidEqualTo(msdiseaseid);
				if (!manageDiseaseService.selectByExample(example).isEmpty()) {
					msdiseaseid =manageDiseaseService.selectByExample(example).get(0).getMsdiseaseid();
				}
		}	
		request.setAttribute("id",msdiseaseid);
		return "/health/illType"; 
	}
	

	@RequestMapping("/illManagement")
	public String listDisease(HttpServletRequest request, Integer msdiseaseid, @ModelAttribute("diseasename")String diseasename, Page<ManageDisease> page) {
		if(msdiseaseid == null) {
			msdiseaseid = 0;
		}
		ManageDisease parent =manageDiseaseService.selectById(msdiseaseid);
		request.setAttribute("parent", parent);
		ManageDiseaseExample example=new ManageDiseaseExample();
		ManageDiseaseExample.Criteria criteria =example.createCriteria();
		criteria.andParentidEqualTo(msdiseaseid);
		example.setOrderByClause("`SortNo`");
		page.setResult(manageDiseaseService.selectByExampleAndPage(page, example));
		request.setAttribute("page", page);
		return "/health/illManagement";
		
	}
	
	/**
	 * 新增疾病分类
	 * @param pojo
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public Message add(ManageDisease pojo){
		int count = 0;
		try {
			if (pojo.getMsdiseaseid()==null || pojo.getMsdiseaseid()==0) {
				ShiroUser user = getCurentUser();
				pojo.setCreateid(user.getId());
				pojo.setUpdateid(user.getId());
				pojo.setCreatetime(new Date());
				pojo.setUpdatetime(new Date());
				count = manageDiseaseService.insert(pojo);
			}else {
				pojo.setUpdatetime(new Date());
				pojo.setUpdateid(getCurentUser().getId());
				count = manageDiseaseService.update(pojo);
			}
		} catch (BusinessException e) {
			return new Message(e.getMessage(), false);
			}
		if(count > 0) {
		return new Message("操作成功", true);
		}
		return new Message("操作失败", false);
	}
	
	/**
	 * 编辑疾病分类
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id")int id, HttpServletRequest request) {
		ManageDisease parent =null;
		ManageDisease pojo =manageDiseaseService.selectById(id);
		if (id>0) {
			pojo =manageDiseaseService.selectById(id);
			parent =pojo.getParentDisease();
			pojo.setUpdatetime(new Date());
			request.setAttribute("pojo", pojo);
		}else {
			int pId = Integer.parseInt(request.getParameter("pId"));
			parent =manageDiseaseService.selectById(pId);
			request.setAttribute("MaxParentId", manageDiseaseService.getMaxParentId(pId));
		}
		request.setAttribute("parent", parent);
		return "/health/editIlltype";
		
	}
	
	/**
	 * 删除疾病分类
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public Message delete(@PathVariable("id")int id) {
		try {
			ManageDisease pojo =manageDiseaseService.selectById(id);
			manageDiseaseMapper.deleteByPrimaryKey(id);
			manageDiseaseMapper.deleteChildren(id);
			healthEducationDiseaseMapper.deleteHealthEducationDisease(id);
			manageschemeTempletDiseaseService.deleteByMasterId(id);
			manageDiseaseService.update(pojo);
		} catch (BusinessException e) {
			return new Message(e.getMessage(), false);
		}
		return new Message("操作成功", true);
		
	}
	
	/**
	 * 验证疾病分类名称是否重复（全局不可重复）
	 * @param pojo
	 * @return
	 */
	@RequestMapping("/checkNameExists")
	@ResponseBody
	public boolean checkNameExists(ManageDisease pojo){
		ManageDisease disease= manageDiseaseService.selectExistByName(pojo.getDiseasename());
		if(pojo.getMsdiseaseid() == null || pojo.getMsdiseaseid() == 0) {
			if(disease == null) {
				return true;
			}
		} else {
			if(pojo.getMsdiseaseid().intValue() == disease.getMsdiseaseid().intValue()) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	private void getTree(List<DiseaseTree> treeList,List<ManageDisease> manageDiseaseList){
		if (manageDiseaseList==null || manageDiseaseList.size()==0) {
			return ;
		}
			for(ManageDisease manageDisease :manageDiseaseList){
				DiseaseTree tree = new DiseaseTree(String.valueOf(manageDisease.getMsdiseaseid()),manageDisease.getDiseasename(),
						String.valueOf(manageDisease.getParentid()==null ? 0 :manageDisease.getParentid()));
				tree.setSortno(manageDisease.getSortno());
				tree.setUpdateid(manageDisease.getUpdateid());
				tree.setUpdatetime(manageDisease.getUpdatetime());
				treeList.add(tree);
				getTree(treeList, manageDisease.getChildren());
			
		}
	}
}
