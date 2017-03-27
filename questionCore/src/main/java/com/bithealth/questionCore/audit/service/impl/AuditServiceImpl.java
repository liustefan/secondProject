 
/**
 * @PackageName:      com.bithealth.questionCore.service.impl
 * @FileName:     AuditServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月6日 下午5:06:10  
 * 
 */

package com.bithealth.questionCore.audit.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.questionCore.answer.model.Ocam;
import com.bithealth.questionCore.answer.model.Ouai;
import com.bithealth.questionCore.answer.service.OcamService;
import com.bithealth.questionCore.answer.service.OuaiService;
import com.bithealth.questionCore.audit.model.Cam2;
import com.bithealth.questionCore.audit.model.Oasr;
import com.bithealth.questionCore.audit.model.OasrExample;
import com.bithealth.questionCore.audit.model.Uai3;
import com.bithealth.questionCore.audit.service.AuditService;
import com.bithealth.questionCore.audit.service.Cam2Service;
import com.bithealth.questionCore.audit.service.OasrService;
import com.bithealth.questionCore.audit.service.Uai3Service;
import com.bithealth.questionCore.enmu.ComAnswerStatusEnum;
import com.bithealth.questionCore.enmu.SingleAnswerStatusEnum;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: AuditServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月6日 下午5:06:10 
 * 
 * @author baozj
 * @version  
 */
@Service
public class AuditServiceImpl implements AuditService {

	@Autowired
	private OasrService oasrService;
	@Autowired
	private Uai3Service uai3Service;
	@Autowired
	private Cam2Service cam2Service;
	@Autowired
	private OuaiService ouaiService;
	@Autowired
	private OcamService ocamService;
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.audit.service.AuditService#selectSingleAnswerAuditByExampleAndPage(com.bithealth.questionCore.audit.model.OasrExample)
	 */
	public Page<Oasr> selectSingleAnswerAuditByExampleAndPage(Page<Oasr> page, OasrExample example) {
		
		oasrService.selectSingleAnswerAuditByExampleAndPage(page, example);
		return page;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.audit.service.AuditService#selectComAnswerAuditByExampleAndPage(com.bithealth.questionCore.audit.model.OasrExample)
	 */
	public Page<Oasr> selectComAnswerAuditByExampleAndPage(Page<Oasr> page, OasrExample example) {
		
		oasrService.selectComAnswerAuditByExampleAndPage(page, example);
		return page;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.audit.service.AuditService#insertSingleAnswerAudit(java.lang.Long, com.bithealth.questionCore.audit.model.Uai3)
	 */
	public int insertSingleAnswerAudit(Long serialNumber, Uai3 model) {
		
		int n = 0;
		Oasr oasr = oasrService.selectById(serialNumber);
		if(!"Y".equals(oasr.getAuditState())){
			model.setAnsNumber(oasr.getReportNo());
			model.setLineNum((short)1);
			model.setFunId((short)3);
			model.setOptId(oasr.getOptId());
			model.setAuditLevel(oasr.getAuditLevel());
			model.setAuditTime(new Date());
			n += uai3Service.insert(model);
			Oasr o = new Oasr();
			o.setSerialNumber(serialNumber);
			o.setAuditState("Y");
			n += oasrService.updateByPrimaryKeySelective(o);
			Ouai ouai = new Ouai();
			ouai.setAnsNumber(oasr.getReportNo());
			ouai.setQustTag(SingleAnswerStatusEnum.APPROVED.getCode());
			n += ouaiService.updateByPrimaryKeySelective(ouai);
		}
		return n;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.audit.service.AuditService#insertComAnswerAudit(java.lang.Long, com.bithealth.questionCore.audit.model.Cam2)
	 */
	public int insertComAnswerAudit(Long serialNumber, Cam2 model) {
		
		int n = 0;
		Oasr oasr = oasrService.selectById(serialNumber);
		if(!"Y".equals(oasr.getAuditState())){
			model.setCombAnsid(oasr.getReportNo());
			model.setLineNum((short)1);
			model.setFunId((short)3);
			model.setOptId(oasr.getOptId());
			model.setAuditLevel(oasr.getAuditLevel());
			model.setAuditTime(new Date());
			n += cam2Service.insert(model);
			Oasr o = new Oasr();
			o.setSerialNumber(serialNumber);
			o.setAuditState("Y");
			n += oasrService.updateByPrimaryKeySelective(o);
			Ocam ocam = new Ocam();
			ocam.setCombAnsid(oasr.getReportNo());
			ocam.setCombTag(ComAnswerStatusEnum.APPROVED.getCode());
			n += ocamService.updateByPrimaryKeySelective(ocam);
		}
		return n;
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.audit.service.AuditService#selectLatestSingleAudit(java.lang.Integer)
	 */
	@Override
	public Uai3 selectLatestSingleAudit(Integer memberId) {
		
		return uai3Service.selectLatestAudit(memberId);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.audit.service.AuditService#selectLatestComAudit(java.lang.Integer)
	 */
	@Override
	public Cam2 selectLatestComAudit(Integer memberId) {
		
		return cam2Service.selectLatestAudit(memberId);
	}
}

