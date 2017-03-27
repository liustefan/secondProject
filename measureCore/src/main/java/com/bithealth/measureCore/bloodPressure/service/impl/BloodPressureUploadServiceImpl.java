 
/**
 * @PackageName:      com.bithealth.measureCore.bloodPressure.service.impl
 * @FileName:     BloodPressureFileServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年8月8日 上午11:35:32  
 * 
 */

package com.bithealth.measureCore.bloodPressure.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.careCore.facade.service.CareIFService;
import com.bithealth.measureCore.bloodPressure.model.Osbp;
import com.bithealth.measureCore.bloodPressure.service.BloodPressureService;
import com.bithealth.measureCore.bloodPressure.service.BloodPressureUploadService;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.common.service.OmdsService;
import com.bithealth.measureCore.constant.Constant;
import com.bithealth.measureCore.enmu.BloodPresExcType;
import com.bithealth.measureCore.enmu.BloodPresTimePType;
import com.bithealth.memberCore.member.model.MemScore;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemScoreService;
import com.bithealth.memberCore.member.service.MemberService;


/**
 * 类名称: BloodPressureFileServiceImpl  
 * 功能描述: 上传血压接口实现
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月8日 上午11:35:32 
 * 
 * @author 陈哲
 * @version  
 */
@Service
public class BloodPressureUploadServiceImpl implements BloodPressureUploadService{
	private final static Logger logger = Logger.getLogger(BloodPressureUploadServiceImpl.class);
			
	@Autowired
	private OmdsService omdsService;
	
	@Autowired
	private BloodPressureService bloodPressureService;
	
	@Autowired
	private MemScoreService memScoreService;
	
	@Autowired
	private CareIFService careIFService;
	
	@Autowired
	private MemberService memberService;
	
	/**
	     * @Title: send 
	     * @Description: 上传血压信息
	     * @param  
	     * @throws      
	     * @retrun  
	 * @throws Exception 
	 */
	@Override
	public void saveBloodPress(Osbp osbp) throws Exception{
		// 分析血压数据
		int osbpResult = getOsbpResult(osbp);
		osbp.setAbnormal(String.valueOf(osbpResult));
		
		osbp.setUploadtime(new Date());
		
		Omds omds = new Omds();
		omds.setMemberid(osbp.getMemberid());
		omds.setEventtype("1");
		omds.setStatustag((short)2);
		omds.setUploadtime(osbp.getUploadtime());
		// 结果不为零标示异常
		if (osbpResult != 0) {
			omds.setWheabntag(String.valueOf(1));
		}
		//保存omds测量记录
		 omdsService.saveOmds(omds);
		 Long eventId = omds.getEventid();
		 osbp.setEventid(eventId);
		
		//保存osbp
		bloodPressureService.saveOsbp(osbp);
		
		logger.info("保存会员血压测量信息成功!");

		//添加会员每测量一次血压得1 分
		MemScore memScore = new MemScore();
		memScore.setMemberid(osbp.getMemberid());
		memScore.setScore(Constant.ONCE_MEASURE_BP_SCORE);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		memScore.setUploadtime(sdf.format(osbp.getUploadtime()));
		
		try {
			memScoreService.insert(memScore);
		} catch (Exception e1) {
			logger.error("上传血压测量数据，记录测量得分失败！");
		}
		
		//消息推送
		try {
			Member member = memberService.selectById(osbp.getMemberid());
			
			//获取日期月份和月份天数
			Calendar cal = Calendar.getInstance();
			cal.setTime(osbp.getTesttime());
			int month = cal.get(Calendar.MONTH)+1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			
			//消息推送，内容封装
			String content = member.getMemname()+"(??)"+month+"月"+day+"日血压"+BloodPresExcType.getExcTypeName(osbpResult)+"，"
								+BloodPresTimePType.getTimeTypeName(Integer.valueOf(osbp.getTimeperiod()))+"血压值"
								+osbp.getSbp()+"/"+osbp.getDbp()+"mmHg";
			osbp.getMsgCenter().setLastsourceid(eventId) ; //最新的消息来源ID
			osbp.getMsgCenter().setLastcontent(content);
			osbp.getMsgCenter().setLastContentNotice(content);
			careIFService.sendMsgToCareMeMember(osbp.getMsgCenter());
		} catch (Exception e) {
			logger.error("上传血压测量数据，消息推送失败！");
		}
	}
	
	
	/**
	 * @Title:getOsbpResult 
	 * @Description: 分析血压数据异常状态  0 正常 1 低血压 2 高度高血压 3 中度高血压 4 轻度高血压 5 单纯收缩高血压
	 * @author 陈哲
	 * @param osbp
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun int
	 */
	private int getOsbpResult(Osbp osbp) throws Exception {
		int sbp = osbp.getSbp();
		int dbp = osbp.getDbp();
		if ((sbp > 140 && sbp < 160) && (dbp >= 90 && dbp < 100)) {
			return 4; // "轻度高血压";
		} else if ((sbp >= 160 && sbp < 180) || (dbp >= 100 && dbp < 110)) {
			return 3; // "中度高血压";
		} else if (sbp >= 180 || dbp >= 110) {
			return 2; // "高度高血压";
		} else if (sbp < 90 || dbp < 60) {
			return 1; // "低血压";
		} else if ((sbp >= 90 && sbp <= 130) && (dbp >= 60 && dbp <= 85)) {
			return 0; // "正常";
		} else if ((sbp >= 140 && sbp <160) && (dbp < 90)) {
			return 5; // "单纯收缩高血压";
		} else if (((sbp > 130 && sbp < 140) && (dbp >= 60 && dbp < 90)) || ((sbp >= 90 && sbp <= 130) && (dbp > 85 && dbp < 90))) {
			return 6; // "正常偏高";
		}
		return 0;
	}
}

