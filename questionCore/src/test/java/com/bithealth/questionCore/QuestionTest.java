 
/**
 * @PackageName:      com.bithealth.questionCore
 * @FileName:     QuestionnaireTest.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年7月7日 上午9:59:10  
 * 
 */

package com.bithealth.questionCore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.bithealth.memberCore.member.vo.MemberVo;
import com.bithealth.questionCore.enmu.QuestionType;
import com.bithealth.questionCore.enmu.SingleQuestionStatusEnum;
import com.bithealth.questionCore.facede.service.QuestionFacedeService;
import com.bithealth.questionCore.question.model.Cqt1;
import com.bithealth.questionCore.question.model.Ocqt;
import com.bithealth.questionCore.question.model.OcqtExample;
import com.bithealth.questionCore.question.model.Omfq;
import com.bithealth.questionCore.question.model.OmfqExample;
import com.bithealth.questionCore.question.model.OmfqExample.Criteria;
import com.bithealth.questionCore.question.service.OcqtService;
import com.bithealth.questionCore.question.service.OmfqService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: QuestionnaireTest  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月7日 上午9:59:10 
 * 
 * @author baozj
 * @version  
 */
public class QuestionTest extends BaseTest {
	
	@Autowired
	private QuestionFacedeService service;
	@Autowired
	private OmfqService omfqService;
	@Autowired
	private OcqtService ocqtService;
	
	@Ignore
	@Test
	public void selectSingleQuestionById(){
		logger.info("查询单份问卷详情 =====》" + JSON.toJSONString(service.selectSingleQuestionById(392)));
	}
	
	@Ignore
	@Test
	public void selectSingleQuestionByExampleAndPage(){
		Page<Omfq> page = new Page<Omfq>();
		OmfqExample example = new OmfqExample();
		Criteria crit= example.createCriteria();
		crit.andRoleId(3, null, null, null);
		logger.info("分页查询单份问卷 =====》" + JSON.toJSONString(service.selectSingleQuestionByExampleAndPage(page, example)));
	}
	
	@Ignore
	@Test
	public void selectComQuestionByExampleAndPage(){
		Page<Ocqt> page = new Page<Ocqt>();
		OcqtExample example = new OcqtExample();
		example.createCriteria().andOrgIdEqualTo(93)
		.andCombQustNameOrCreateNameLike("e");
		logger.info("分页查询组合问卷 =====》" + JSON.toJSONString(service.selectComQuestionByExampleAndPage(page, example)));
	}
	
	@Ignore
	@Test
	public void selectComQuestionById(){
		logger.info("查询组合问卷详情 =====》" + JSON.toJSONString(service.selectComQuestionById(63)));
	}
	
	@Ignore
	@Test
	public void insertOrUpdateComQuestion(){
		Ocqt model = new Ocqt();
		model.setCombQustName("组合问卷名称-测试-修改");
		List<Cqt1> cqt1s = new ArrayList<Cqt1>();
		model.setCqt1s(cqt1s);
		Cqt1 cqt1 = new Cqt1();
		cqt1.setQustid(123456);
		cqt1s.add(cqt1);
		logger.info("保存组合问卷=====》" + JSON.toJSONString(service.insertOrUpdateComQuestion(model)));
		logger.info("保存组合问卷主键编号=====》" + model.getCombQustid());
	}
	
	@Ignore
	@Test
	public void deleteComQuestion(){
		logger.info("删除组合问卷=====》" + JSON.toJSONString(service.deleteComQuestion(70)));
	}
	
	@Ignore
	@Test
	public void selectSingleQuestionMaxQustCode(){
		logger.info("=====》" + JSON.toJSONString(omfqService.selectSingleQuestionMaxQustCode(93, SingleQuestionStatusEnum.DELETED.getCode())));
	}
	
	@Ignore
	@Test
	public void selectSingleQuestionMaxQustVerByName(){
		logger.info("=====》" + JSON.toJSONString(omfqService.selectSingleQuestionMaxQustVerByName(93, "测试问题", SingleQuestionStatusEnum.DELETED.getCode())));
	}
	
	@Ignore
	@Test
	public void checkSingleQuestionNameUnique(){
		logger.info("=====》" + JSON.toJSONString(service.selectSingleQuestionNameUnique(93, "aa")));
	}
	
	@Ignore
	@Test
	public void selectComQuestionMaxQustCode(){
		logger.info("=====》" + JSON.toJSONString(ocqtService.selectComQuestionMaxQustCode(356, SingleQuestionStatusEnum.DELETED.getCode())));
	}
	
	@Ignore
	@Test
	public void selectComQuestionMaxQustVerByName(){
		logger.info("=====》" + JSON.toJSONString(ocqtService.selectComQuestionMaxQustVerByName(93, "测试问题", SingleQuestionStatusEnum.DELETED.getCode())));
	}
	
	@Ignore
	@Test
	public void selectComQuestionNameUnique(){
		logger.info("查询组合问卷名称唯一性 =====》" + JSON.toJSONString(service.selectComQuestionNameUnique(93, "aa")));
	}
	
//	@Ignore
	@Test
	public void exProcGetMyMemListByDocId(){
		Page<MemberVo> page = new Page<MemberVo>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("iDocId", 285);
		logger.info("查询我的会员中可以发放单份、组合问卷的会员 =====》" + JSON.toJSONString(service.exProcGetMyMemListByDocId(page, params)));
	}
	
	@Ignore
	@Test
	public void selectHealthexamQuestion(){
		logger.info(" =====》" + JSON.toJSONString(service.selectHealthexamQuestion(93, QuestionType.ONE)));
	}
	
}

