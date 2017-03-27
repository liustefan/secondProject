 
/**
 * @PackageName:      com.bithealth.measureCore.bloodSugar.service.impl
 * @FileName:     BloodSugarUploadServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年8月8日 下午2:48:20  
 * 
 */

package com.bithealth.measureCore.bloodSugar.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.careCore.facade.service.CareIFService;
import com.bithealth.measureCore.bloodSugar.model.Obsr;
import com.bithealth.measureCore.bloodSugar.service.BloodSugarService;
import com.bithealth.measureCore.bloodSugar.service.BloodSugarUploadService;
import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.common.service.OmdsService;
import com.bithealth.measureCore.constant.Constant;
import com.bithealth.measureCore.enmu.BloodSugarExcType;
import com.bithealth.measureCore.enmu.BloodSugarTimeQType;
import com.bithealth.memberCore.member.model.MemScore;
import com.bithealth.memberCore.member.model.Member;
import com.bithealth.memberCore.member.service.MemScoreService;
import com.bithealth.memberCore.member.service.MemberService;


/**
 * 类名称: BloodSugarUploadServiceImpl  
 * 功能描述: 上传血糖接口实现
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月8日 下午2:48:20 
 * 
 * @author 陈哲
 * @version  
 */
@Service
public class BloodSugarUploadServiceImpl implements BloodSugarUploadService{
	private final static Logger logger = Logger.getLogger(BloodSugarUploadServiceImpl.class);
	
	@Autowired
	private OmdsService omdsService;
	
	@Autowired
	private BloodSugarService bloodSugarService;
	
	@Autowired
	private MemScoreService memScoreService;
	
	@Autowired
	private CareIFService careIFService;
	
	@Autowired
	private MemberService memberService;

	/** 
	     * @Title: send 
	     * @Description: 上传血糖信息
	     * @param  
	     * @throws      
	     * @retrun  
	 * @throws Exception 
	     *  @see com.bithealth.measureCore.bloodSugar.service.BloodSugarUploadService#saveBloodSugar()
	     */
	@Override
	public void saveBloodSugar(Obsr obsr) throws Exception {
		//分析血糖
		int obsrResult = getObsrResult(obsr);
		obsr.setAnalysisresult(String.valueOf(obsrResult));
		obsr.setUploadtime(new Date());
		
		Omds omds = new Omds();
		omds.setMemberid(obsr.getMemberid());
		omds.setEventtype("2");
		omds.setStatustag((short)2);
		omds.setUploadtime(obsr.getUploadtime());
		
		// 结果不为零标示异常
		if (obsrResult != 0) {
			omds.setWheabntag(String.valueOf(1));
		}
		
		//保存omds测量记录
		 omdsService.saveOmds(omds);
		 Long eventId = omds.getEventid();
		 obsr.setEventid(eventId);
		//保存obsr
		bloodSugarService.saveObsr(obsr);
		
		logger.info("保存会员血糖测量信息成功!");
		
		//添加会员测量一次血糖得3 分
		MemScore memScore = new MemScore();
		memScore.setMemberid(obsr.getMemberid());
		memScore.setScore(Constant.ONCE_MEASURE_BG_SCORE);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		memScore.setUploadtime(sdf.format(obsr.getUploadtime()));
		
		try {
			memScoreService.insert(memScore);
		} catch (Exception e1) {
			logger.error("上传血糖测量数据，记录测量得分失败！");
		}
		
		//消息推送
		try {
			Member member = memberService.selectById(obsr.getMemberid());
			
			//获取日期月份和月份天数
			Calendar cal = Calendar.getInstance();
			cal.setTime(obsr.getTesttime());
			int month = cal.get(Calendar.MONTH)+1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			
			String content = member.getMemname()+"(??)"+month+"月"+day+"日血糖"+BloodSugarExcType.getExcTypeName(obsrResult)+"，"
							+BloodSugarTimeQType.getTimeQTypeName(Integer.valueOf(obsr.getTimeperiod()))
							+"血糖值"+obsr.getBsvalue()+"mmol/L";
			obsr.getMsgCenter().setLastsourceid(eventId); //最新的消息来源ID
			obsr.getMsgCenter().setLastcontent(content);
			obsr.getMsgCenter().setLastContentNotice(content);
			careIFService.sendMsgToCareMeMember(obsr.getMsgCenter());
		} catch (Exception e) {
			logger.error("上传血糖测量数据，消息推送失败！");
		}
	}
	

	/**
	 * @Title:getOsbpResult 
	 * @Description:血糖分析结果 
	 * @author 陈哲
	 * @param obsr
	 * @return
	 * @throws Exception 
	 * @throws
	 * @retrun int
	 */
	private int getObsrResult(Obsr obsr) throws Exception 
	{
	    Double value = obsr.getBsvalue();
	    int timePeriod = Integer.valueOf(obsr.getTimeperiod());
	    //分析结果值(1:血糖偏低;2:血糖偏高;0：正常)
	    int analysisResult = 0; 
	    //早晨空腹(1),午餐前(3),晚餐前(5),睡前(7),夜间(8)  值为：3.9-6.1mmol/L(正常值：包括前者，不包括后者)
	    if(timePeriod == 1 || timePeriod == 3 || timePeriod == 5 || timePeriod == 7 || timePeriod == 8){
	        if(value <= 3.9d){
	            analysisResult = 1; 
           }
           else if(value >= 6.1d){
               analysisResult = 2;
           }
	    }
	    //早餐后2小时(2),午餐后2小时(4),晚餐后2小时(6)  值为：3.9-7.8mmol/L(正常值：包括前者，不包括后者)
	    else if(timePeriod == 2 || timePeriod == 4 || timePeriod == 6){
	        if(value <=3.9d){
	            analysisResult = 1;
	        }
	        else if(value >= 7.8d){
	            analysisResult = 2;
	        }
	    }
	    //随机血糖(0) 值为：3.9-11.1mmol/L(正常值：包括前者，不包括后者)
	    else
       {
           if(value < 3.9d){
               analysisResult = 1;
           }
           else if(value >= 11.1d){
               analysisResult = 2;
           }
       }
       return analysisResult;
	}

}

