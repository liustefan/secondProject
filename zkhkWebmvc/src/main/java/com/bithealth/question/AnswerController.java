 
/**
 * @PackageName:      com.bithealth.question
 * @FileName:     AnswerController.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年8月3日 下午5:05:54  
 * 
 */

package com.bithealth.question;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bithealth.Docx4jUtil;
import com.bithealth.FailMessage;
import com.bithealth.Message;
import com.bithealth.SuccessMessage;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.fileCore.constant.FileTypeEnum;
import com.bithealth.fileCore.facade.service.FileManagerServiceFacade;
import com.bithealth.fileCore.model.FileConfigModel;
import com.bithealth.printCore.service.ExportWordService;
import com.bithealth.questionCore.answer.model.Ocam;
import com.bithealth.questionCore.answer.model.OcamExample;
import com.bithealth.questionCore.answer.model.Ouai;
import com.bithealth.questionCore.answer.model.OuaiExample;
import com.bithealth.questionCore.enmu.ComAnswerStatusEnum;
import com.bithealth.questionCore.facede.service.AnswerFacedeService;
import com.bithealth.questionCore.facede.service.QuestionFacedeService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.web.controller.BaseSpringController;
import com.bithealth.sdk.web.vo.ShiroUser;
 

/**
 * 类名称: AnswerController  
 * 功能描述: TODO 答卷管理 
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月3日 下午5:05:54 
 * 
 * @author baozj
 * @version  
 */
@Controller
@RequestMapping(value = "/question")
public class AnswerController extends BaseSpringController {
	   
	@Autowired
	private AnswerFacedeService answerService;
	@Autowired
	private ExportWordService exportWordService;
	@Autowired
	private FileManagerServiceFacade fileManagerServiceFacade;
	@Resource(name="doctorService")
	private DoctorService doctorService;
	@Autowired
	QuestionFacedeService questionService;
	/**
	 * 
	 * @Title:singleList 
	 * @Description:分页查询单份答卷列表 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param criteria
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/singleAnswer/list")
	public String singleList(Page<Ouai> page, Ouai pojo, String criteria, Model model){
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo", pojo);
		model.addAttribute("criteria", criteria);
		OuaiExample example = new OuaiExample();
		example.createCriteria().andOrgIdEqualTo(getCurentUser().getDept_id())
		.andQustTagEqualTo(pojo.getQustTag())
		.andMemberNameOrDocNameOrQustNameLike(criteria)
		.andMemberidEqualTo(pojo.getMemberid());
		if(pojo.getMemberid() != null)
			model.addAttribute("isMy", doctorService.isMyMember(getCurentUser().getId(), pojo.getMemberid(), getCurentUser().getDept_id()));
		else
			model.addAttribute("isMy", true);
		model.addAttribute("page", answerService.selectSingleAnswerByExampleAndPage(page, example));
		return "question/singleAnswer/list";
	}
	
	/**
	 * 
	 * @Title:comList 
	 * @Description:分页查询组合答卷列表 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param pojo
	 * @param criteria
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/comAnswer/list")
	public String comList(Page<Ocam> page, Ocam pojo, String criteria, Model model){
		page.setPageNo(page.getPageNo());
		model.addAttribute("pojo", pojo);
		model.addAttribute("criteria", criteria);
		OcamExample example = new OcamExample();
		example.createCriteria().andOrgIdEqualTo(getCurentUser().getDept_id())
		.andCombTagEqualTo(pojo.getCombTag())
		.andMemberNameOrDocNameOrCombQustNameLike(criteria);
		model.addAttribute("combTags", ComAnswerStatusEnum.values());
		model.addAttribute("page", answerService.selectComAnswerByExampleAndPage(page, example));
		return "question/comAnswer/list";
	}
	
	/**
	 * 
	 * @Title:singleGive 
	 * @Description:发放、批量发放单份答卷 
	 * TODO  
	 * @author baozj
	 * @param qustId
	 * @param memberIds
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/singleAnswer/give")
	public @ResponseBody Message singleGive(Integer qustId, Integer...memberIds){
		ShiroUser user = getCurentUser();
		if(answerService.insertSingleAnswers(qustId, user.getId(), user.getRealName(), memberIds))
			return new SuccessMessage();
		else
			return new FailMessage();
	}
	
	/**
	 * 
	 * @Title:comGive 
	 * @Description:发放、批量发放组合答卷 
	 * TODO  
	 * @author baozj
	 * @param qustId
	 * @param memberIds
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/comAnswer/give")
	public @ResponseBody Message comGive(Integer qustId, Integer...memberIds){
		ShiroUser user = getCurentUser();
		if(answerService.insertComAnswers(qustId, user.getId(), user.getRealName(), memberIds))
			return new SuccessMessage();
		else
			return new FailMessage();
	}
	
	/**
	 * 
	 * @Title:singleAnswer 
	 * @Description:作答单份答卷 
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/singleAnswer/answer")
	public @ResponseBody Message singleAnswer(@RequestBody Ouai pojo){
		
		if(answerService.insertSingleAnswerResult(pojo.getUai21s(), pojo))
			return new SuccessMessage("list");
		else
			return new FailMessage();
	}
	
	/**
	 * 
	 * @Title:comAnswer 
	 * @Description:作答组合答卷中的单份答卷
	 * TODO  
	 * @author baozj
	 * @param pojo
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/comAnswer/answer")
	public @ResponseBody Message comAnswer(@RequestBody Ouai pojo){
		if(answerService.insertComAnswerResult(pojo.getUai21s(), pojo, pojo.getCombQustId()))
			return new SuccessMessage("../comAnswer/answerInfo?combAnsId="+pojo.getCombQustId());
		else
			return new FailMessage();
	}
	
	/**
	 * 
	 * @Title:answerInfo 
	 * @Description:跳转单价答卷作答页面 
	 * TODO  
	 * @author baozj
	 * @param ansNumber
	 * @param combAnsId
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/singleAnswer/answerInfo")
	public String answerInfo(Integer ansNumber, Integer combAnsId, Model model){
		model.addAttribute("combAnsId", combAnsId);
		model.addAttribute("ansNumber", ansNumber);
		Ouai pojo = answerService.selectSingleAnswerById(ansNumber);
		model.addAttribute("omfq", JSON.toJSONString(pojo.getOmfq(), SerializerFeature.BrowserCompatible));
		model.addAttribute("uai21", JSON.toJSONString(pojo.getUai21s(), SerializerFeature.BrowserCompatible));
		return "question/singleAnswer/answerInfo";
	}
	
	@RequestMapping(value="/questionInfo")
	public String questionInfo(Integer qustId, Integer memberId, Integer ansNumber, Model model){
		if(ansNumber == null){
			model.addAttribute("omfq", JSON.toJSONString(questionService.selectSingleQuestionById(qustId), SerializerFeature.BrowserCompatible));
			model.addAttribute("uai21", JSON.toJSONString(new ArrayList<Object>(), SerializerFeature.BrowserCompatible));
		}else{
			Ouai pojo = answerService.selectSingleAnswerById(ansNumber);
			model.addAttribute("omfq", JSON.toJSONString(pojo.getOmfq(), SerializerFeature.BrowserCompatible));
			model.addAttribute("uai21", JSON.toJSONString(pojo.getUai21s(), SerializerFeature.BrowserCompatible));
		}
		return "question/singleAnswer/questionInfo";
	}
	
	/**
	 * 
	 * @Title:answerView 
	 * @Description:查看单份答卷详情
	 * TODO  
	 * @author baozj
	 * @param ansNumber
	 * @param combAnsId
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/singleAnswer/answerView")
	public String answerView(Integer ansNumber, Integer combAnsId, Model model){
		model.addAttribute("combAnsId", combAnsId);
		model.addAttribute("pojo", answerService.selectSingleAnswerById(ansNumber));
		return "question/singleAnswer/answerView";
	}
	
	/**
	 * 
	 * @Title:comAnswerInfo 
	 * @Description:查看组合答卷详情
	 * TODO  
	 * @author baozj
	 * @param combAnsId
	 * @param model
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/comAnswer/answerInfo")
	public String comAnswerInfo(Integer combAnsId, Model model){
		model.addAttribute("pojo", answerService.selectComAnswerById(combAnsId));
		return "question/comAnswer/sList";
	}
	
	/**
	 * 
	 * @Title:singleRemove 
	 * @Description:删除单份答卷 （支持批量删除）
	 * TODO  
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/singleAnswer/remove")
	public @ResponseBody Message singleRemove(Integer...ids){
		if(answerService.deleteSingleAnswers(ids))
			return new SuccessMessage();
		else
			return new FailMessage();
	}
	
	/**
	 * 
	 * @Title:comRemove 
	 * @Description:删除组合答卷 （支持批量删除）
	 * TODO  
	 * @author baozj
	 * @param ids
	 * @return 
	 * @throws
	 * @retrun Message
	 */
	@RequestMapping(value="/comAnswer/remove")
	public @ResponseBody Message comRemove(Integer...ids){
		if(answerService.deleteComAnswers(ids))
			return new SuccessMessage();
		else
			return new FailMessage();
	}
	
	/**
	 * 
	 * @Title:queryPrintSingleQuestionInfoBycombAnsIds 
	 * @Description:批量打印已审核问卷 
	 * TODO  
	 * @author baozj
	 * @param ansNumbers
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/singleAnswer/queryPrintQuestionInfoByIds")
	public String queryPrintSingleQuestionInfoByIds(Model model, Integer...ansNumbers){
		model.addAttribute("ansNumbers", ansNumbers);
		model.addAttribute("baseInfos", answerService.selectPrintSingleQuestionInfoByIds(ansNumbers));
		return "question/singleAnswer/printQuestionInfos";
	}
	
	/**
	 * 
	 * @Title:queryPrintComQuestionInfoBycombAnsIds 
	 * @Description:批量打印已审核组合问卷 
	 * TODO  
	 * @author baozj
	 * @param combAnsIds
	 * @return 
	 * @throws
	 * @retrun String
	 */
	@RequestMapping(value="/comAnswer/queryPrintQuestionInfoByIds")
	public String queryPrintComQuestionInfoByIds(Model model, Integer...combAnsIds){
		model.addAttribute("combAnsIds", combAnsIds);
		model.addAttribute("baseCInfos", answerService.selectPrintComQuestionInfoByIds(combAnsIds));
		return "question/comAnswer/printQuestionInfos";
	}
	
	/**
	 * 
	 * @Title:downSingleQuestionWord 
	 * @Description: 下载单份答卷word文档
	 * TODO  
	 * @author baozj
	 * @param request
	 * @param response
	 * @param ansNumbers
	 * @throws Exception 
	 * @throws
	 * @retrun void
	 */
	@RequestMapping(value="/singleAnswer/downWord")
	public void downSingleQuestionWord(HttpServletRequest request, HttpServletResponse response, Integer...ansNumbers) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		List<Ouai> answers = answerService.selectPrintSingleQuestionInfoByIds(ansNumbers);
		for(Ouai ouai : answers){
			if(ouai.getUai3() != null){
				ouai.getUai3().setAuditDesc(Docx4jUtil.getDocxXmlContent(ouai.getUai3().getAuditDesc()));
				ouai.getUai3().setDocSign(getBase64(ouai.getUai3().getDoctor().getSignaddress()));
			}
		}
		map.put("baseInfos", answers);
		map.put("user", getCurentUser());
		exportWordService.ExportWord(request, response, map, new SimpleDateFormat("yyyyMMddHH:mm:ss").format(new Date()), "singleAnswer.ftl");
	}
	
	/**
	 * 
	 * @Title:downComQuestionWord 
	 * @Description: 下载组合答卷word文档
	 * TODO  
	 * @author baozj
	 * @param request
	 * @param response
	 * @param combAnsIds
	 * @throws Exception 
	 * @throws
	 * @retrun void
	 */
	@RequestMapping(value="/comAnswer/downWord")
	public void downComQuestionWord(HttpServletRequest request, HttpServletResponse response, Integer...combAnsIds) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		List<Ocam> answers = answerService.selectPrintComQuestionInfoByIds(combAnsIds);
		for(Ocam ocam : answers){
			ocam.getCam2().setAuditDesc(Docx4jUtil.getDocxXmlContent(ocam.getCam2().getAuditDesc()));
			ocam.getCam2().setDocSign(getBase64(ocam.getCam2().getDoctor().getSignaddress()));
		}
		map.put("baseCInfos", answers);
		map.put("user", getCurentUser());
		exportWordService.ExportWord(request, response, map, new SimpleDateFormat("yyyyMMddHH:mm:ss").format(new Date()), "comAnswer.ftl");
	}
	
	private String getBase64(String signAddress){
		if(StringUtils.isNotEmpty(signAddress)){
			ByteArrayOutputStream outSteam = null;
			InputStream in = null;
			try {
				FileConfigModel model = new FileConfigModel();
				model.setUniqueId(signAddress);
				FileTypeEnum fileTypeEnum = FileTypeEnum.CUSTOM_FILE;
				fileTypeEnum.setFormat("headImage");
				model.setTypeEnum(fileTypeEnum);
				model.setNeedCompress(false);
				byte[] byteArray = fileManagerServiceFacade.downloadFile(model);
				outSteam = new ByteArrayOutputStream(); 
				outSteam.write(byteArray, 0, byteArray.length);
				return new sun.misc.BASE64Encoder().encode(outSteam.toByteArray());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(outSteam != null)
						outSteam.close();
					if(in != null)
						in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "";
	}
}

