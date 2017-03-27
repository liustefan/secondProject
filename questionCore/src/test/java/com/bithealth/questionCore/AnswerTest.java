 
/**
 * @PackageName:      com.bithealth.questionCore
 * @FileName:     AnswerTest.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月18日 上午10:30:59  
 * 
 */

package com.bithealth.questionCore;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.bithealth.questionCore.answer.model.Ocam;
import com.bithealth.questionCore.answer.model.OcamExample;
import com.bithealth.questionCore.answer.model.Ouai;
import com.bithealth.questionCore.answer.model.OuaiExample;
import com.bithealth.questionCore.answer.model.Uai21;
import com.bithealth.questionCore.enmu.SingleAnswerStatusEnum;
import com.bithealth.questionCore.facede.service.AnswerFacedeService;
import com.bithealth.questionCore.model.Answer;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: AnswerTest  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月18日 上午10:30:59 
 * 
 * @author baozj
 * @version  
 */
public class AnswerTest extends BaseTest {
	
	@Autowired
	AnswerFacedeService service;
	
	@Ignore
	@Test
	public void insertAnswers(){
		logger.info("发放单份答卷 =====》" + JSON.toJSONString(service.insertSingleAnswers(399, 285, "医生测试1", 78441)));
	}
	
	@Ignore
	@Test
	public void selectSingleAnswerById(){
		logger.info("单份答卷详情 =====》" + JSON.toJSONString(service.selectSingleAnswerById(1830)));
	}
	
	@Ignore
	@Test
	public void selectByExampleAndPage(){
		Page<Ouai> page = new Page<Ouai>();
		OuaiExample example = new OuaiExample();
		example.createCriteria().andOrgIdEqualTo(93);
		logger.info("分页查询单份答卷 =====》" + JSON.toJSONString(service.selectSingleAnswerByExampleAndPage(page, example)));
	}
	
	@Ignore
	@Test
	public void insertSingleAnswerResult(){
		List<Uai21> results = new ArrayList<Uai21>();
		Uai21 item = new Uai21();
		item.setProblemid(1);
		item.setAnsid((short)2);
		results.add(item);
		Uai21 item2 = new Uai21();
		item2.setProblemid(2);
		item2.setAnsid((short)1);
		results.add(item2);
		Ouai model = new Ouai();
		model.setAnsNumber(1912);
		model.setQustTag(SingleAnswerStatusEnum.ANSWERED.getCode());
		logger.info("作答单份答卷 =====》" + JSON.toJSONString(service.insertSingleAnswerResult(results, model)));
	}
	
	@Ignore
	@Test
	public void insertComAnswers(){
		logger.info("发放组合答卷 =====》" + JSON.toJSONString(service.insertComAnswers(59, 285, "医生测试1", 78441)));
	}
	
	@Ignore
	@Test
	public void insertComAnswerResult(){
		List<Uai21> results = new ArrayList<Uai21>();
		Uai21 item = new Uai21();
		item.setProblemid(1);
		item.setAnsid((short)2);
		results.add(item);
		Uai21 item2 = new Uai21();
		item2.setProblemid(2);
		item2.setAnsid((short)1);
		results.add(item2);
		Ouai model = new Ouai();
		model.setAnsNumber(1914);
		model.setQustTag(SingleAnswerStatusEnum.ANSWERED.getCode());
		logger.info("作答组合答卷中的单份答卷 =====》" + JSON.toJSONString(service.insertComAnswerResult(results, model, 168)));
	}
	
	@Ignore
	@Test
	public void selectComAnswerById(){
		logger.info("组合答卷详情 =====》" + JSON.toJSONString(service.selectComAnswerById(168)));
	}
	
	@Ignore
	@Test
	public void selectComAnswerByExampleAndPage(){
		Page<Ocam> page = new Page<Ocam>();
		OcamExample example = new OcamExample();
		example.createCriteria().andOrgIdEqualTo(93);
		logger.info("分页查询组合答卷 =====》" + JSON.toJSONString(service.selectComAnswerByExampleAndPage(page, example)));
	}
	
	@Ignore
	@Test
	public void selectAnswerPage(){
		
		logger.info("分页查询会员答卷信息（单份、组合合并分页查询） =====》" + JSON.toJSONString(service.selectAnswerPage(new Page<Answer>(), 78740, true)));
	}
}

