 
/**
 * @PackageName:      com.bithealth.question
 * @FileName:     AuditController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年8月3日 下午5:06:20  
 * 
 */

package com.bithealth.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bithealth.questionCore.answer.model.Ocam;
import com.bithealth.questionCore.answer.model.Ouai;
import com.bithealth.questionCore.audit.model.Cam2;
import com.bithealth.questionCore.audit.model.Oasr;
import com.bithealth.questionCore.audit.model.Uai3;
import com.bithealth.questionCore.facede.service.AnswerFacedeService;
import com.bithealth.questionCore.facede.service.AuditFacedeService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;


/**
 * 类名称: AuditController  
 * 功能描述: TODO 答卷审核  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月3日 下午5:06:20 
 * 
 * @author baozj
 * @version  
 */
@Controller
@RequestMapping(value = "/question")
public class AuditController extends BaseSpringController {
	 
	@Autowired
	private AuditFacedeService auditService;
	@Autowired
	private AnswerFacedeService answerService;
	  
	/**
	 * 
	 * @Title:singleList 
	 * @Description: 分页查询单份答卷待审列表
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/singleAudit/list")
	public String singleList(Page<Oasr> page, Model model){
		page.setPageNo(page.getPageNo());
		model.addAttribute("page", auditService.selectSingleAnswerAuditByExampleAndPage(page, getCurentUser().getId()));
		return "question/singleAudit/list"; 
	} 
	
	/**
	 * 
	 * @Title:comList 
	 * @Description: 分页查询组合答卷待审列表 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/comAudit/list")
	public String comList(Page<Oasr> page, Model model){
		page.setPageNo(page.getPageNo());
		model.addAttribute("page", auditService.selectComAnswerAuditByExampleAndPage(page, getCurentUser().getId()));
		return "question/comAudit/list";
	}
	
	/**
	 * 
	 * @Title:toSingleAudit 
	 * @Description: 查看单份答卷待审核记录 
	 * TODO  
	 * @author baozj
	 * @param serialNumber
	 * @param ansNumber
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/singleAudit/toAudit")
	public String toSingleAudit(Long serialNumber, Integer ansNumber, Model model){
		model.addAttribute("serialNumber", serialNumber);
		Ouai ouai = answerService.selectSingleAnswerById(ansNumber);
		model.addAttribute("pojo", ouai);
		model.addAttribute("audit", auditService.selectLatestSingleAudit(ouai.getMemberid()));	
		return "question/singleAudit/audit";
	}
	
	/**
	 * 
	 * @Title:toComAudit 
	 * @Description:查看组合答卷待审核记录 
	 * TODO  
	 * @author baozj
	 * @param serialNumber
	 * @param combAnsId
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/comAudit/toAudit")
	public String toComAudit(Long serialNumber, Integer combAnsId, Model model){
		model.addAttribute("serialNumber", serialNumber);
		Ocam ocam = answerService.selectComAnswerById(combAnsId);
		model.addAttribute("pojo", ocam);
		model.addAttribute("audit", auditService.selectLatestComAudit(ocam.getMemberid()));
		return "question/comAudit/audit";
	}
	
	/**
	 * 
	 * @Title:singleAudit 
	 * @Description:审核单份答卷待审核记录  
	 * TODO  
	 * @author baozj
	 * @param serialNumber
	 * @param result
	 * @param redirectAttributes
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/singleAudit/audit")
	public String singleAudit(Long serialNumber, Uai3 result, Integer memberId, Byte type, String content, RedirectAttributes redirectAttributes){
		result.setDocid(getCurentUser().getId());
		if(auditService.insertSingleAnswerAudit(serialNumber, result, memberId, type, content))
			redirectAttributes.addFlashAttribute("message", "审核成功！");
		else
			redirectAttributes.addFlashAttribute("message", "审核失败！");
		return "redirect:list";
	}
	
	/**
	 * 
	 * @Title:comAudit 
	 * @Description:审核组合答卷待审核记录 
	 * TODO  
	 * @author baozj
	 * @param serialNumber
	 * @param result
	 * @param redirectAttributes
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/comAudit/audit")
	public String comAudit(Long serialNumber, Cam2 result, Integer memberId, String content, RedirectAttributes redirectAttributes){
		result.setDocid(getCurentUser().getId());
		if(auditService.insertComAnswerAudit(serialNumber, result, memberId, content))
			redirectAttributes.addFlashAttribute("message", "审核成功！");
		else
			redirectAttributes.addFlashAttribute("message", "审核失败！");
		return "redirect:list";
	}
}

