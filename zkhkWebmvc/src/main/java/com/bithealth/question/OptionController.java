 
/**
 * @PackageName:      com.bithealth.question
 * @FileName:     OptionController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年8月19日 上午11:53:49  
 * 
 */

package com.bithealth.question;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bithealth.FailMessage;
import com.bithealth.Message;
import com.bithealth.SuccessMessage;
import com.bithealth.questionCore.question.model.OcqtExample;
import com.bithealth.questionCore.question.model.OmfqExample;
import com.bithealth.questionCore.question.service.OcqtService;
import com.bithealth.questionCore.question.service.OmfqService;
import com.bithealth.reportCore.template.model.Option;
import com.bithealth.reportCore.template.model.OptionExample;
import com.bithealth.reportCore.template.model.OptionKey;
import com.bithealth.reportCore.template.service.OptionService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;


/**
 * 类名称: OptionController  
 * 功能描述: TODO 问卷类型配置  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月19日 上午11:53:49 
 * 
 * @author baozj
 * @version  
 */
@Controller
@RequestMapping(value = "/question")
public class OptionController extends BaseSpringController {

	@Autowired
	private OptionService optionService;
	@Autowired
	private OmfqService omfqService;
	@Autowired
	private OcqtService ocqtService;
	
	@RequestMapping(value="/option/list")
	public String list(Page<Option> page, Option pojo, String criteria, Model model){
		ShiroUser user = getCurentUser();
		OptionExample example = new OptionExample();
		example.setOrderByClause("OptId desc");
		example.createCriteria().andOrgidEqualTo(user.getDept_id())
		.andFunIdIn(Arrays.asList((short)3, (short)4));
		optionService.selectByExampleAndPage(page, example);
		model.addAttribute("page", page);
		return "question/option/list";
	}
	
	@RequestMapping(value="/option/selectById")
	public @ResponseBody Option selectById(OptionKey id){
		return optionService.selectById(id);
	}
	
	@RequestMapping(value="/option/remove")
	public @ResponseBody Message remove(OptionKey id){
		ShiroUser user = getCurentUser();
		if(id.getFunId() == 3){//单份问卷
			OmfqExample example = new OmfqExample();
			example.createCriteria().andOrgIdEqualTo(user.getDept_id())
			.andOptIdEqualTo(id.getOptId());
			if(omfqService.selectByExample(example).size() > 0)
				return new Message("该类别已使用，不允许删除。", false);
		}else if(id.getFunId() == 4){//组合问卷
			OcqtExample example = new OcqtExample();
			example.createCriteria().andOrgIdEqualTo(user.getDept_id())
			.andOptIdEqualTo(id.getOptId());
			if(ocqtService.selectByExample(example).size() > 0)
				return new Message("该类别已使用，不允许删除。", false);
		}
		if(optionService.delete(id) > 0)
			return new Message("删除问卷类别成功", true);
		else
			return new Message("删除问卷类别失败", false);
	}
	
	@RequestMapping(value="/option/checkName")
	public @ResponseBody Message checkName(String name, Short id){
		OptionExample example = new OptionExample();
		example.createCriteria().andOrgidEqualTo(getCurentUser().getDept_id())
		.andOptNameEqualTo(name)
		.andOptIdNotEqualTo(id);
		if(optionService.selectByExample(example).size() > 0)
			return new FailMessage();
		else
			return new SuccessMessage();
	}
	
	@RequestMapping(value="/option/checkDes")
	public @ResponseBody Message checkDes(String des, Short id){
		OptionExample example = new OptionExample();
		example.createCriteria().andOrgidEqualTo(getCurentUser().getDept_id())
		.andOptDesEqualTo(des)
		.andOptIdNotEqualTo(id);
		if(optionService.selectByExample(example).size() > 0)
			return new FailMessage();
		else
			return new SuccessMessage();
	}
	
	@RequestMapping(value="/option/save")
	public String save(Option pojo, RedirectAttributes redirectAttributes){
		ShiroUser user = getCurentUser();
		pojo.setCHLevel((short)1);
		pojo.setOrgid(user.getDept_id());
		int n = 0;
		if(pojo.getOptId() == null)
			n = optionService.insert(pojo);
		else
			n = optionService.update(pojo);
		if(n > 0)
			redirectAttributes.addFlashAttribute("message", "保存成功！");
		else
			redirectAttributes.addFlashAttribute("message", "保存失败！");
		return "redirect:list";
	}
}

