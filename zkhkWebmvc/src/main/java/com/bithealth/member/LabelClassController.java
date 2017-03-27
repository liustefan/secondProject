package com.bithealth.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bithealth.Message;
import com.bithealth.memberCore.memberLabel.faced.service.LabelFacedService;
import com.bithealth.memberCore.memberLabel.model.LabelTag;
import com.bithealth.memberCore.memberLabel.model.LabelTagExample;
import com.bithealth.memberCore.memberLabel.model.LabelTagExample.Criteria;
import com.bithealth.memberCore.memberLabel.service.LabelService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;
/**
 * 类名称: LabelClassController  
 * 功能描述: 数据导入controller  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年12月05日 
 * 
 * @author 周玉飞
 * @version  
 */
@Controller
@RequestMapping("/labelClass")
public class LabelClassController extends BaseSpringController{
	
	@Autowired
	private LabelFacedService labelFacedService;
	@Autowired
	private LabelService labelService;
	
	@RequestMapping(value="/listLabelClass")
	public String listLabelClass(Page<LabelTag> page, Model model,LabelTag pojo){
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo", pojo);
		model.addAttribute("page",labelFacedService.selectByLabelTagPage(page, pojo));
		return "/member/LabelManage/labelClassifyManage";
		
	}
	
	@RequestMapping(value="/editLabelClass")
	public String editLabelClass(Integer id, Model model){
		LabelTag pojo = labelFacedService.selectById(id);
		if (pojo==null) {
			pojo = new LabelTag();
		}
		model.addAttribute("pojo", pojo);
		return "/member/LabelManage/editlabelClassify";
		
	}
	
	@RequestMapping(value="/deleteLabelClass")
	public @ResponseBody Message  deleteLabelClass(Integer id,Model model){
		LabelTag pojo = labelFacedService.selectById(id);
		List<LabelTag> list =new ArrayList<LabelTag>();
		List<LabelTag> statis = labelFacedService.selectIsHasLabel(id);
		list.addAll(statis);
		if (pojo.getIssystem()==0) {
			if (list.size()==0){ 
			if (labelFacedService.deleteLabelClass(id)) {
				return new Message("删除成功！",true);
			}
			}else {
				return new Message("此标签分类下有会员标签，不可删除！",false);
			}
		}
		return null;
	}
			
	/**
	 * 验证会员标签分类名称是否重复
	 * @param pojo
	 * @return
	 */
	@RequestMapping("/checkNameExists")
	@ResponseBody
	public boolean checkNameExists(LabelTag pojo){
		LabelTag labelClass = labelService.selectExistLabelClassName(pojo.getClassname(),pojo.getLclassid());
		return labelClass == null;
		
	}
	
	@RequestMapping(value="/saveLabelClass")
	public @ResponseBody Message saveLabelClass(LabelTag pojo){
		ShiroUser user = getCurentUser();
		pojo.setCreateid(user.getId());
		pojo.setCreatetime(new Date());
		pojo.setUpdateid(user.getId());
		pojo.setUpdatetime(new Date());
		if (labelFacedService.insertOrUpdateLabelClass(pojo)) {
			return new Message( "保存成功！",true);
		}else
			return new Message( "保存失败！",true);
		}
	
}
