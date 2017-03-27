 
/**
 * @PackageName:      com.bithealth.questionCore.service
 * @FileName:     AuditService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月6日 下午5:01:58  
 * 
 */

package com.bithealth.questionCore.facede.service;

import com.bithealth.questionCore.audit.model.Cam2;
import com.bithealth.questionCore.audit.model.Oasr;
import com.bithealth.questionCore.audit.model.Uai3;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: AuditService  
 * 功能描述: TODO 答卷审核  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月6日 下午5:01:58 
 * 
 * @author baozj
 * @version  
 */
public interface AuditFacedeService {

	/**
	 * 
	 * @Title:selectSingleAnswerAuditByExampleAndPage 
	 * @Description:分页查询待审核单份答卷 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param docId
	 * @return 
	 * @throws
	 * @retrun Page<Oasr>
	 */
	Page<Oasr> selectSingleAnswerAuditByExampleAndPage(Page<Oasr> page, Integer docId);
	
	/**
	 * 
	 * @Title:selectComAnswerAuditByExampleAndPage 
	 * @Description:分页查询待审核组合答卷 
	 * TODO  
	 * @author baozj
	 * @param page
	 * @param docId
	 * @return 
	 * @throws
	 * @retrun Page<Oasr>
	 */
	Page<Oasr> selectComAnswerAuditByExampleAndPage(Page<Oasr> page, Integer docId);
	
	/**
	 * 
	 * @Title:insertSingleAnswerAudit 
	 * @Description:审核单份答卷 
	 * TODO  
	 * @author baozj
	 * @param serialNumber
	 * @param model
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean insertSingleAnswerAudit(Long serialNumber, Uai3 model, Integer memberId, Byte type, String content);
	
	/**
	 * 
	 * @Title:insertComAnswerAudit 
	 * @Description:审核组合答卷 
	 * TODO  
	 * @author baozj
	 * @param serialNumber
	 * @param model
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	boolean insertComAnswerAudit(Long serialNumber, Cam2 model, Integer memberId, String content);
	
	/**
	 * 
	 * @Title:selectLatestSingleAudit 
	 * @Description: 获取会员最新单份答卷审核信息
	 * TODO  
	 * @author baozj
	 * @param memberId
	 * @return 
	 * @throws
	 * @retrun Uai3
	 */
	Uai3 selectLatestSingleAudit(Integer memberId);
	
	/**
	 * 
	 * @Title:selectLatestComAudit 
	 * @Description: 获取会员最新组合答卷审核信息
	 * TODO  
	 * @author baozj
	 * @param memberId
	 * @return 
	 * @throws
	 * @retrun Cam2
	 */
	Cam2 selectLatestComAudit(Integer memberId);
}

