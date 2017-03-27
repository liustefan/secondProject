package com.bithealth.cms;


import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bithealth.Message;
import com.bithealth.cmsCore.facede.CmsFacedeService;
import com.bithealth.cmsCore.model.HealthnewsLable;
import com.bithealth.cmsCore.model.HealthnewsLableExample;
import com.bithealth.cmsCore.model.HealthnewsLableExample.Criteria;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;

/**
 * 类名：HealthnewsLableController
 * 描述：
 * @author 作者:周玉飞
 * @version 创建时间：2016年8月3日 下午2:27:35
 * 类说明
 */
@Controller
@RequestMapping(value = "/msgCenter")
public class HealthnewsLableController extends BaseSpringController  {
	
	@Autowired
	private CmsFacedeService cmsFacedeService;
	
	@RequestMapping(value="/listTitleTag")
	public String listLable(Page<HealthnewsLable> page,HealthnewsLable pojo,Model model){
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo",pojo);
		HealthnewsLableExample example =new HealthnewsLableExample();
		Criteria criteria = example.createCriteria();
		criteria.andContentLike(pojo.getContent())
		.andCreatetimeGreaterThanOrEqualTo(pojo.getStartCreatetime());
		if (pojo.getEndCreatetime()!=null) {
			criteria.andCreatetimeLessThanOrEqualTo(DateUtils.addDays(pojo.getEndCreatetime(), 1));
		}
		
		example.setOrderByClause("CreateTime desc");
		model.addAttribute("page", cmsFacedeService.selectLablePage(page, example));
		return "/msgCenter/titleTag";
		
	}
	
	@RequestMapping(value="/editLable")
	public String lableEdit(Integer id, Model model){
		HealthnewsLable pojo =cmsFacedeService.selectLableById(id);
		if (pojo==null) {
			pojo=new HealthnewsLable();
		}
		model.addAttribute("pojo", pojo);
		return "/msgCenter/editTitle";
	}
	
	@RequestMapping(value="/deleteHealthnewsLable")
	public String deleteHealthnewsLable(Integer id){
		HealthnewsLable pojo =cmsFacedeService.selectLableById(id);
		pojo.setStatustype((byte) 3);
		return "/msgCenter/titleTag";
	}
	
	//启用
	@RequestMapping(value="/userLable")
	public String userLable(Integer id,RedirectAttributes redirectAttributes, Model model){
		HealthnewsLable pojo =cmsFacedeService.selectLableById(id);
		model.addAttribute("pojo", pojo);
		cmsFacedeService.deleteInfoLable(id);
		cmsFacedeService.deleteNewsIngfo(id);
		pojo.setStatustype((byte) 2);
		cmsFacedeService.updateLableByStatus(pojo);
		return "redirect:listTitleTag";
	}
	
	//禁用
	@RequestMapping(value="/banLable")
	public String banLable(Integer id,RedirectAttributes redirectAttributes, Model model){
		HealthnewsLable pojo =cmsFacedeService.selectLableById(id);
		model.addAttribute("pojo", pojo);
		pojo.setStatustype((byte) 3);
		cmsFacedeService.updateLableByStatus(pojo);
		return "redirect:listTitleTag";
		
	}

	@RequestMapping(value="/saveLable")
	public @ResponseBody Message saveLable(HealthnewsLable pojo){
		ShiroUser user = getCurentUser();
		pojo.setCreateid(user.getId());
		pojo.setUpdateid(user.getId());
		if (cmsFacedeService.insertOrUpdateLable(pojo)) {
			return new Message( "保存成功！",true);
		}else
			return new Message( "保存失败！",true);
		}
	
	}

