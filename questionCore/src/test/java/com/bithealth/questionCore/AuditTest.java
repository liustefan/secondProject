 
/**
 * @PackageName:      com.bithealth.questionCore
 * @FileName:     AuditTest.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月7日 下午4:46:31  
 * 
 */

package com.bithealth.questionCore;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.bithealth.questionCore.audit.model.Cam2;
import com.bithealth.questionCore.audit.model.Oasr;
import com.bithealth.questionCore.audit.model.Uai3;
import com.bithealth.questionCore.facede.service.AuditFacedeService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;




/**
 * 类名称: AuditTest  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月7日 下午4:46:31 
 * 
 * @author baozj
 * @version  
 */
public class AuditTest extends BaseTest {

	@Autowired
	private AuditFacedeService service;
	
	@Ignore
	@Test
	public void selectSingleAnswerAuditByExampleAndPage(){
		Page<Oasr> page = new Page<Oasr>();
		Integer docId = 285;
		logger.info("分页查询待审核单份答卷  =====》" + JSON.toJSONString(service.selectSingleAnswerAuditByExampleAndPage(page, docId)));
	}
	
	@Ignore
	@Test
	public void selectComAnswerAuditByExampleAndPage(){
		Page<Oasr> page = new Page<Oasr>();
		Integer docId = 285;
		logger.info("分页查询待审核组合答卷  =====》" + JSON.toJSONString(service.selectComAnswerAuditByExampleAndPage(page, docId)));
	}
	
//	@Ignore
//	@Test
//	public void insertSingleAnswerAudit(){
//		Uai3 model = new Uai3();
//		model.setDocid(285);
//		model.setAuditDesc("审核意见");
//		model.setDiagnosis("诊断");
//		try {
//			logger.info("审核单份答卷  =====》" + JSON.toJSONString(service.insertSingleAnswerAudit(11576L, model)));
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//			
//		}
//	}
	
//	@Ignore
//	@Test
//	public void insertComAnswerAudit(){
//		Cam2 model = new Cam2();
//		model.setDocid(285);
//		model.setAuditDesc("审核意见");
//		model.setDiagnosis("诊断");
//		try {
//			logger.info("审核组合答卷  =====》" + JSON.toJSONString(service.insertComAnswerAudit(11579L, model)));
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//			
//		}
//	}
}

