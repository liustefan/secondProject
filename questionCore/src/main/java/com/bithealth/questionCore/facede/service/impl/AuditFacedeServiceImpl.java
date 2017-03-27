 
/**
 * @PackageName:      com.bithealth.questionCore.facede.service.impl
 * @FileName:     AuditFacedeServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月6日 下午5:07:05  
 * 
 */

package com.bithealth.questionCore.facede.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.chatCore.enmu.ChatRefTypeEnmu;
import com.bithealth.chatCore.enmu.RefStatusEnum;
import com.bithealth.chatCore.facade.service.ChatMessageFacadeService;
import com.bithealth.msgCenterCore.facade.service.MessageCenterFacadeService;
import com.bithealth.questionCore.answer.service.AnswerService;
import com.bithealth.questionCore.audit.model.Cam2;
import com.bithealth.questionCore.audit.model.Oasr;
import com.bithealth.questionCore.audit.model.OasrExample;
import com.bithealth.questionCore.audit.model.Uai3;
import com.bithealth.questionCore.audit.service.AuditService;
import com.bithealth.questionCore.facede.service.AuditFacedeService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: AuditFacedeServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月6日 下午5:07:05 
 * 
 * @author baozj
 * @version  
 */
@Service
public class AuditFacedeServiceImpl extends ChatMessageSendService implements AuditFacedeService{
	
	protected static Logger logger = Logger.getLogger(AuditFacedeServiceImpl.class);

	@Autowired
	private AuditService auditService;
	@Autowired
	private MessageCenterFacadeService messageCenterFacadeService;
	@Autowired
	private AnswerService answerService;
	@Autowired
	ChatMessageFacadeService chatService;
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.facede.service.AuditFacedeService#selectSingleAnswerAuditByExampleAndPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, java.lang.Integer)
	 */
	public Page<Oasr> selectSingleAnswerAuditByExampleAndPage(Page<Oasr> page,
			Integer docId) {
		OasrExample example = new OasrExample();
		example.createCriteria().andAuditStateNotEqualTo("Y").andUseTagEqualTo("T").andCombAnsidIsNull().andFunIdEqualTo((short)3).andDocidEqualTo(docId);
		return auditService.selectSingleAnswerAuditByExampleAndPage(page, example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.facede.service.AuditFacedeService#selectComAnswerAuditByExampleAndPage(com.bithealth.sdk.core.feature.orm.mybatis.Page, java.lang.Integer)
	 */
	public Page<Oasr> selectComAnswerAuditByExampleAndPage(Page<Oasr> page,
			Integer docId) {
		
		OasrExample example = new OasrExample();
		example.createCriteria().andAuditStateNotEqualTo("Y").andUseTagEqualTo("T").andFunIdEqualTo((short)4).andDocidEqualTo(docId);
		return auditService.selectComAnswerAuditByExampleAndPage(page, example);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.facede.service.AuditFacedeService#insertSingleAnswerAudit(java.lang.Long, com.bithealth.questionCore.audit.model.Uai3)
	 */
	public boolean insertSingleAnswerAudit(Long serialNumber, Uai3 model, Integer memberId, Byte type, String content) {
		if(auditService.insertSingleAnswerAudit(serialNumber, model) > 0){
			if(type == 1){//自评发聊天消息
				sendChat(model.getDocid(), memberId, ChatRefTypeEnmu.TYPE_SINGLE_PAPERS_PUBLIC, content, model.getAnsNumber().longValue(), RefStatusEnum.APPROVED);
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
	 * @throws Exception 
	 *  @see com.bithealth.questionCore.facede.service.AuditFacedeService#insertComAnswerAudit(java.lang.Long, com.bithealth.questionCore.audit.model.Cam2)
	 */
	public boolean insertComAnswerAudit(Long serialNumber, Cam2 model, Integer memberId, String content) {
		if(auditService.insertComAnswerAudit(serialNumber, model) > 0){
			sendChat(model.getDocid(), memberId, ChatRefTypeEnmu.TYPE_COMBINATION_AUDIT_PUBLIC, content, model.getCombAnsid().longValue(), RefStatusEnum.APPROVED);
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
	 *  @see com.bithealth.questionCore.facede.service.AuditFacedeService#selectLatestSingleAudit(java.lang.Integer)
	 */
	@Override
	public Uai3 selectLatestSingleAudit(Integer memberId) {
		
		return auditService.selectLatestSingleAudit(memberId);
	}
	
	/** 
	 * @Title: send 
	 * @Description: TODO 简单描述该方法的实现功能（可选）.
	 * @param  
	 * @throws      
	 * @retrun  
	 *  @see com.bithealth.questionCore.facede.service.AuditFacedeService#selectLatestComAudit(java.lang.Integer)
	 */
	@Override
	public Cam2 selectLatestComAudit(Integer memberId) {
		
		return auditService.selectLatestComAudit(memberId);
	}
	
}

