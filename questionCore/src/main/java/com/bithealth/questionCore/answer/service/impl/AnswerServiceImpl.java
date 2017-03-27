 
/**
 * @PackageName:      com.bithealth.questionCore.service.impl
 * @FileName:     AnswerServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月6日 下午5:05:53  
 * 
 */

package com.bithealth.questionCore.answer.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.memberCore.member.service.MemberService;
import com.bithealth.questionCore.answer.model.Cam1;
import com.bithealth.questionCore.answer.model.Ocam;
import com.bithealth.questionCore.answer.model.OcamExample;
import com.bithealth.questionCore.answer.model.Ouai;
import com.bithealth.questionCore.answer.model.OuaiExample;
import com.bithealth.questionCore.answer.model.Uai21;
import com.bithealth.questionCore.answer.model.Uai4;
import com.bithealth.questionCore.answer.service.AnswerService;
import com.bithealth.questionCore.answer.service.Cam1Service;
import com.bithealth.questionCore.answer.service.OcamService;
import com.bithealth.questionCore.answer.service.OuaiService;
import com.bithealth.questionCore.answer.service.Uai21Service;
import com.bithealth.questionCore.answer.service.Uai4Service;
import com.bithealth.questionCore.audit.model.Cam2Key;
import com.bithealth.questionCore.audit.model.Oasr;
import com.bithealth.questionCore.audit.service.Cam2Service;
import com.bithealth.questionCore.audit.service.OasrSerialnumberService;
import com.bithealth.questionCore.audit.service.OasrService;
import com.bithealth.questionCore.audit.service.Uai3Service;
import com.bithealth.questionCore.enmu.ComAnswerStatusEnum;
import com.bithealth.questionCore.enmu.SingleAnswerStatusEnum;
import com.bithealth.questionCore.question.model.Mfq1;
import com.bithealth.questionCore.question.model.Mfq11;
import com.bithealth.questionCore.question.service.OcqtService;
import com.bithealth.questionCore.question.service.OmfqService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: AnswerServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月6日 下午5:05:53 
 * 
 * @author baozj
 * @version  
 */
@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	private OuaiService ouaiService;
	@Autowired
	private Uai21Service uai21Service;
	@Autowired
	private Uai4Service uai4Service;
	@Autowired
	private Uai3Service uai3Service;
	@Autowired
	private OcamService ocamService;
	@Autowired
	private Cam1Service cam1Service;
	@Autowired
	private OasrSerialnumberService oasrSerialnumberService;
	@Autowired
	private OasrService oasrService;
	@Autowired
	private Cam2Service cam2Service;
	@Autowired
	private OcqtService ocqtService;
	@Autowired
	private OmfqService omfqService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private DoctorService doctorService; 
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.answer.service.AnswerService#insertSingleAnswer(com.bithealth.questionCore.answer.model.Ouai)
	 */
	public int insertSingleAnswer(Ouai model) {
		
		return ouaiService.insert(model);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.answer.service.AnswerService#selectSingleAnswerById(java.lang.Integer)
	 */
	public Ouai selectSingleAnswerById(Integer ansNumber) {
		
		Ouai model = ouaiService.selectById(ansNumber);
		
		if(!SingleAnswerStatusEnum.UNANSWERED.getCode().equals(model.getQustTag()))//有作答内容
			model.setUai21s(uai21Service.selectByMasterId(model.getAnsNumber()));

		if(SingleAnswerStatusEnum.ANSWERED.getCode().equals(model.getQustTag()) || SingleAnswerStatusEnum.APPROVED.getCode().equals(model.getQustTag()))//已作答、已审核，取结论
			model.setUai4(uai4Service.selectByMasterId(model.getAnsNumber()));
		
		if(SingleAnswerStatusEnum.APPROVED.getCode().equals(model.getQustTag()))//已审核，取审核内容
			model.setUai3(uai3Service.selectByMasterId(model.getAnsNumber()));
		
		return model;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.answer.service.AnswerService#selectHasSingleAnswerReleased(java.lang.Integer)
	 */
	public boolean selectHasSingleAnswerReleased(Integer qustId) {
		OuaiExample example = new OuaiExample();
		example.createCriteria().andQustidEqualTo(qustId);
		return ouaiService.selectByExample(example).size() > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.answer.service.AnswerService#selectHasComAnswerReleased(java.lang.Integer)
	 */
	public boolean selectHasComAnswerReleased(Integer combQustId) {
		
		OcamExample example = new OcamExample();
		example.createCriteria().andCombQustidEqualTo(combQustId);
		return ocamService.selectByExample(example).size() > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.answer.service.AnswerService#selectSingleAnswerByExampleAndPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.questionCore.answer.model.OuaiExample)
	 */
	public Page<Ouai> selectSingleAnswerByExampleAndPage(Page<Ouai> page,
			OuaiExample example) {
		
		ouaiService.selectByExampleAndPage(page, example);
		return page;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.answer.service.AnswerService#insertSingleAnswerResult(java.util.List, com.bithealth.questionCore.answer.model.Ouai)
	 */
	public boolean insertSingleAnswerResult(List<Uai21> results, Ouai model) {

		//从数据中取答案对应分数
		if(model.getOmfq() != null){
			List<Mfq1> mfq1s = model.getOmfq().getMfq1s();
			for(Uai21 u : results){
				u.setAnsNumber(model.getAnsNumber());
				for(Iterator<Mfq1> it = mfq1s.iterator(); it.hasNext();){
					Mfq1 pojo = it.next();
					if(pojo.getProblemid().equals(u.getProblemid())){//
						for(Iterator<Mfq11> itt = pojo.getMfq11s().iterator();itt.hasNext();){
							Mfq11 mfq11 = itt.next();
							if(mfq11.getAnsid().equals(u.getAnsid())){
								u.setScore(mfq11.getScore());
								itt.remove();
								break;
							}
						}
					}
				}
			}
		}else{
			for(Uai21 u : results){
				u.setAnsNumber(model.getAnsNumber());
			}
		}
		
		int n = 0;
		if(!SingleAnswerStatusEnum.UNANSWERED.getCode().equals(model.getQustTag()))//如果已有作答记录，删除之前作答记录
			n += uai21Service.deleteByMasterId(model.getAnsNumber());

		for(Uai21 uai21 : results)
			n += uai21Service.insert(uai21);

		return n > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.answer.service.AnswerService#updateSingleAnswerStatus(com.bithealth.questionCore.enmu.SingleAnswerStatusEnum, java.lang.Integer)
	 */
	public boolean updateSingleAnswerStatusAndProduceAudit(SingleAnswerStatusEnum status,
			Ouai pojo) {
		if(updateSingleAnswerStatus(status, pojo)){
			if(SingleAnswerStatusEnum.ANSWERED.equals(status)){//作答完成，生成一条待审核记录
//				OasrSerialnumber os = new OasrSerialnumber();
//				oasrSerialnumberService.insert(os);
				Oasr oasr = new Oasr();
//				oasr.setTableName(String.valueOf("oasr_"+os.getSerialNumber()%100));
				oasr.setTableName("oasr");
//				oasr.setSerialNumber(os.getSerialNumber());
				oasr.setReportNo(pojo.getAnsNumber());
				oasr.setOptId(pojo.getOptId());
				oasr.setOptName(pojo.getOptName());
				oasr.setMemberid(pojo.getMemberid());
				oasr.setGrenerTime(new Date());
				oasr.setAuditLevel((short)1);
				oasr.setAuditState("N");
				oasr.setSubmitOther("N");
				oasr.setYNTag("Y");
				oasr.setDocid(pojo.getDocid());
				oasrService.insert(oasr);
			}
			return true;
		}
		return false;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.answer.service.AnswerService#updateSingleAnswerStatus(com.bithealth.questionCore.enmu.SingleAnswerStatusEnum, com.bithealth.questionCore.answer.model.Ouai)
	 */
	@Override
	public boolean updateSingleAnswerStatus(SingleAnswerStatusEnum status,
			Ouai pojo) {
		
		Ouai model = new Ouai();
		model.setQustTag(status.getCode());
		model.setAnsNumber(pojo.getAnsNumber());
		model.setAnswerTime(TimeUtil.now());
		return ouaiService.updateByPrimaryKeySelective(model) > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.answer.service.AnswerService#insertConclusion(com.bithealth.questionCore.answer.model.Uai4)
	 */
	public boolean insertConclusion(Uai4 model) {
		
		return uai4Service.insert(model) > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.answer.service.AnswerService#insertComAnswer(com.bithealth.questionCore.answer.model.Ocam)
	 */
	public int insertComAnswer(Ocam model) {
		
		return ocamService.insert(model);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.answer.service.AnswerService#insertComContactSingleAnswer(com.bithealth.questionCore.answer.model.Cam1)
	 */
	public int insertComContactSingleAnswer(Cam1 model) {
		
		return cam1Service.insert(model);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.answer.service.AnswerService#selectComAnswerById(java.lang.Integer)
	 */
	public Ocam selectComAnswerById(Integer combAnsId) {
		
		Ocam model = ocamService.selectById(combAnsId);
		model.setOcqt(ocqtService.selectById(model.getCombQustid()));
		if(model != null){
			model.setCam1s(cam1Service.selectByMasterId(model.getCombAnsid()));
			if(ComAnswerStatusEnum.APPROVED.getCode().equals(model.getCombTag())){//已审核
				Cam2Key key = new Cam2Key();
				key.setCombAnsid(combAnsId);
				key.setLineNum((short)1);
				model.setCam2(cam2Service.selectById(key));
			}
		}
		return model;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.answer.service.AnswerService#updateComAnswerStatus(com.bithealth.questionCore.enmu.ComAnswerStatusEnum, java.lang.Integer)
	 */
	public boolean updateComAnswerStatus(ComAnswerStatusEnum status,
			Ocam pojo) {
		
		Ocam model = new Ocam();
		model.setCombTag(status.getCode());
		model.setCombAnsid(pojo.getCombAnsid());
		model.setAnswerTime(new Date());
		if(ocamService.updateByPrimaryKeySelective(model) > 0){
			if(ComAnswerStatusEnum.COMPLETED.equals(status)){//作答完成，生成一条待审核记录
//				OasrSerialnumber os = new OasrSerialnumber();
//				oasrSerialnumberService.insert(os);
				Oasr oasr = new Oasr();
//				oasr.setTableName(String.valueOf("oasr_"+os.getSerialNumber()%100));
				oasr.setTableName("oasr");
//				oasr.setSerialNumber(os.getSerialNumber());
				oasr.setReportNo(pojo.getCombAnsid());
				oasr.setOptId(pojo.getOptId());
				oasr.setOptName(pojo.getOptName());
				oasr.setMemberid(pojo.getMemberid());
				oasr.setGrenerTime(new Date());
				oasr.setAuditLevel((short)1);
				oasr.setAuditState("N");
				oasr.setSubmitOther("N");
				oasr.setYNTag("Y");
				oasr.setDocid(pojo.getDocid());
				oasrService.insert(oasr);
			}
			return true;
		}
		return false;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.answer.service.AnswerService#selectComAnswerByExampleAndPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, com.bithealth.questionCore.answer.model.OcamExample)
	 */
	public Page<Ocam> selectComAnswerByExampleAndPage(Page<Ocam> page,
			OcamExample example) {
		
		ocamService.selectByExampleAndPage(page, example);
		return page;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.answer.service.AnswerService#selectHealthexamAnswer(java.lang.Long)
	 */
	public List<Ouai> selectHealthexamAnswer(Long HExamID) {
		OuaiExample example = new OuaiExample();
		example.createCriteria().andHExamIDEqualTo(HExamID);
		List<Ouai> list = ouaiService.selectByExample(example);
		return list;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.answer.service.AnswerService#deleteSingleAnswers(java.lang.Integer)
	 */
	@Override
	public boolean deleteSingleAnswers(Integer...ansNumbers) {
		OuaiExample example= new OuaiExample();
		example.createCriteria().andAnsNumberIn(Arrays.asList(ansNumbers));
		return ouaiService.deleteByExample(example) > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.answer.service.AnswerService#deleteComAnswers(java.lang.Integer)
	 */
	@Override
	public boolean deleteComAnswers(Integer...combAnsid) {
		
		OcamExample example= new OcamExample();
		example.createCriteria().andCombAnsidIn(Arrays.asList(combAnsid));
		return ocamService.deleteByExample(example) > 0;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.answer.service.AnswerService#selectBaseSingleAnswer(java.lang.Integer)
	 */
	@Override
	public Ouai selectBaseSingleAnswer(Integer ansNumber) {
		Ouai ouai = ouaiService.selectById(ansNumber);
		if(ouai != null){
			ouai.setMember(memberService.selectById(ouai.getMemberid()));
			ouai.setOmfq(omfqService.selectById(ouai.getQustid()));
		}
		return ouai;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.answer.service.AnswerService#selectBaseComAnswer(java.lang.Integer)
	 */
	@Override
	public Ocam selectBaseComAnswer(Integer combAnsid) {
		Ocam ocam = ocamService.selectById(combAnsid);
		if(ocam != null){
			ocam.setMember(memberService.selectById(ocam.getMemberid()));
			ocam.setOcqt(ocqtService.selectById(ocam.getCombQustid()));
		}
		return ocam;
	}
	
}

