package com.bithealth.ucCore.uc.task;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.bithealth.ucCore.facade.service.UCService;
import com.bithealth.ucCore.uc.model.MemberBasicInfo;


/**
 * 类名称: MemberRegisterTask  
 * 功能描述: 会员注册异步线程
 * 日期: 2016年8月22日 上午10:20:50 
 * 
 * @author 谢美团
 * @version  
 */
@Component
public class MemberRegisterTask implements Runnable{

	private static Logger logger=Logger.getLogger(MemberRegisterTask.class);
    @Resource
    UCService ucService;
    
    List<MemberBasicInfo> memberInfoList;
    
	public MemberRegisterTask(){
	}
	
	public MemberRegisterTask(List<MemberBasicInfo> memberInfoList){
		this.memberInfoList = memberInfoList;
	}	
	
	@Override
	public void run() {
		try {
			//ucService.memberRegisterSync(memberInfoList);
			logger.error("异步注册会员线程完成。");
		} catch (Exception e) {
			logger.error("异步注册会员线程异常，"+e.getMessage());
		}
	}
}
