 

package com.bithealth.centCore.facade.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bithealth.centCore.facade.service.SmsIFService;
import com.bithealth.centCore.sms.dao.SmsSendDetailMapper;
import com.bithealth.centCore.sms.enmu.SmsEnmu;
import com.bithealth.centCore.sms.enmu.SmsSendStatusEnmu;
import com.bithealth.centCore.sms.model.SmsConfig;
import com.bithealth.centCore.sms.model.SmsConfigExample;
import com.bithealth.centCore.sms.model.SmsSearchParams;
import com.bithealth.centCore.sms.model.SmsSend;
import com.bithealth.centCore.sms.model.SmsSendDetail;
import com.bithealth.centCore.sms.model.SmsSendDetailExample;
import com.bithealth.centCore.sms.model.SmsSendDetailExample.Criteria;
import com.bithealth.centCore.sms.model.SmsSendParams;
import com.bithealth.centCore.sms.model.SmsStatistic;
import com.bithealth.centCore.sms.service.SmsConfigService;
import com.bithealth.centCore.sms.service.SmsSendDetailService;
import com.bithealth.centCore.sms.service.SmsSendService;
import com.bithealth.centCore.sms.taobao.AlibabaSmsReq;
import com.bithealth.centCore.sms.taobao.AlibabaSmsRsp;
import com.bithealth.centCore.sms.taobao.ErrorResponse;
import com.bithealth.centCore.sms.taobao.TaoBaoSmsUtil;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;


/**
 * 类名称: SmsIFService  
 * 功能描述:短信对外接口 实现类
 * 日期: 2016年11月28日 下午2:52:40 
 * 
 * @author 谢美团
 * @version  
 */
@Service("smsIFService")
public class SmsIFServiceImpl  implements SmsIFService {
	 private static Logger logger=Logger.getLogger(SmsIFServiceImpl.class);
	
	@Resource
	SmsConfigService smsConfigService;
	@Resource
	SmsSendService smsSendService;
	@Resource
	SmsSendDetailService smsSendDetailService;
	
	@Resource 
	SmsSendDetailMapper smsSendDetailMapper;
	
	

	@Override
	public boolean saveSmsConfig_trans(SmsConfig smsConfig) throws Exception {
		
		if(smsConfig.getSCfgID() != null && smsConfig.getSCfgID() != 0){ //更新操作
			smsConfig.setCreateTime(null);
			smsConfigService.update(smsConfig);
		}else{ //新增操作
			smsConfig.setCreateTime(smsConfig.getCreateTime() == null? new Date():smsConfig.getCreateTime());
			smsConfigService.insert(smsConfig);
		}
		return true;
	}

	@Override
	public Page<SmsSendDetail> getSmsListByParams(SmsSearchParams smsParams) throws Exception {
		Page<SmsSendDetail> page = new Page<SmsSendDetail>(smsParams.getPageNo(),smsParams.getPageSize());
		smsSendDetailMapper.selectSmsByParams(smsParams,page);
		return page;
	}

	@Override
	public boolean smsSend(SmsSendParams smsParams,SmsConfig smsConfig) throws Exception {
		try{

			// 验证组织发送短信的总数量限制
			if(!validateOrgTotalLimit(smsConfig.getOrgID(),smsConfig.getTotalSendLimit())){
				updateSendStatus(smsConfig.getSSendID(),null,(byte)4,"组织["+smsConfig.getOrgID()+"]发送的短信总数超过限制",null);
				logger.error("组织["+smsConfig.getOrgID()+"]发送的短信总数超过限制，发送失败");
				return false;
			}
			//验证组织当天发送的短信数量限制
			Date date = new Date(); 
			if(!validateOrgDateLimit(smsConfig.getOrgID(),smsConfig.getDailyMaxSend(),date)){
				updateSendStatus(smsConfig.getSSendID(),null,(byte)4,"组织["+smsConfig.getOrgID()+"]当天发送的短信数量超过限制",null);
				logger.error("组织["+smsConfig.getOrgID()+"]["+TimeUtil.formatDatetime2(date)+"]发送的短信总数超过限制，发送失败");
				return false;
			}
			//验证发送的手机号当天接收的短信的数量是否超过限制
			String[] recvNumbers = smsParams.getRecvNumbers().split(",");
			StringBuffer recvNumbersBuf = new StringBuffer();
			String notSendnumber = "";
			String repeatLimitNumber = "";
			for(String recvNumber:recvNumbers){
				if(!validateOrgDateLimit (recvNumber,smsConfig.getMemberDailyMaxRecv(),date,smsParams.getSmsType())){//验证手机号当天发接收的短信数量是否超过限制
					notSendnumber=notSendnumber+recvNumber+",";
				}else if(!validateRepeatDateLimit(recvNumber,smsConfig.getMemberDailyMaxRepl(),date,smsParams.getSmsType(),smsConfig.getTestSMSTempletNo(),smsParams.getContent())){//验证手机每天接收的重复短信数量是否超过限制
					repeatLimitNumber = repeatLimitNumber+recvNumber+",";
				}else{
					recvNumbersBuf.append(recvNumber+",");
				}
			}
			
			if(!"".equals(notSendnumber)){//更新手机号当天接收短信数量超过限制的发送状态
				updateSendStatus(smsConfig.getSSendID(),notSendnumber,(byte)4,"手机号当天接收的短信数量超过限制",null);
			}
			
			if(!"".equals(repeatLimitNumber)){//更新手机号当天接收重复短信数量超过限制的发送状态
				updateSendStatus(smsConfig.getSSendID(),repeatLimitNumber,(byte)4,"手机号当天接收的重复短信数量超过限制",null);
			}
			
			String validrecvNumbers = recvNumbersBuf.toString();
			if("".equals(validrecvNumbers)){//群发的所有手机号当天条数都超过限制
				logger.error("手机号["+smsParams.getRecvNumbers()+"]["+TimeUtil.formatDatetime3(date)+"]当天接收的短信数超过限制，发送失败");
				return false;
			}
			validrecvNumbers = validrecvNumbers.substring(0, validrecvNumbers.length()-1);
			
			AlibabaSmsReq alibabaSmsReq = new AlibabaSmsReq();
			alibabaSmsReq.setAppKey(smsConfig.getAccount());
			alibabaSmsReq.setAppSecret(smsConfig.getPasswd());
			alibabaSmsReq.setExtend(smsConfig.getSSendID().toString());
			alibabaSmsReq.setRecNum(validrecvNumbers);
			alibabaSmsReq.setSmsFreeSignName(smsConfig.getSignature());
			alibabaSmsReq.setSmsParamString(smsParams.getContent());
			alibabaSmsReq.setSmsTemplateCode(getTemplateNo(smsConfig,smsParams.getSmsType()));
			smsSendAndUpdate(alibabaSmsReq,smsConfig.getSSendID(),null);
		}catch(Exception e){
			logger.error("发送短信发生异常"+e.getMessage());
		}
		return false;
	}
	
	/**
	 * @Title:updateSendStatus 
	 * @Description:更新短信的发送状态
	 * @author 谢美团
	 * @param SSendID
	 * @param recvNumbers
	 * @param sendStatus
	 * @param failReason 
	 * @throws
	 * @retrun void
	 */ 
	private void updateSendStatus(Integer SSendID,String recvNumbers,Byte sendStatus,String failReason,Integer failCount){
		SmsSendDetail smsSendDetail = new SmsSendDetail();
		smsSendDetail.setSendStatus(sendStatus);
		smsSendDetail.setFailReason(failReason);
		smsSendDetail.setSendTime(new Date());
		smsSendDetail.setFailCount(failCount==null?null:failCount+1);
		smsSendDetail.setUpdateTime(new Date());
		SmsSendDetailExample example = new SmsSendDetailExample();
		Criteria  criteria  = example.createCriteria();
		criteria.andSSendIDEqualTo(SSendID);
		if(recvNumbers != null && !"".equals(recvNumbers)){
			if(recvNumbers.endsWith(",")){
				recvNumbers=recvNumbers.substring(0, recvNumbers.length() - 1);
			}
			List<String> lsit = new ArrayList<String>();
			for(String recvNumber:recvNumbers.split(",")){
				lsit.add(recvNumber);
			}
			criteria.andRecvNumberIn(lsit);
		}
		smsSendDetailService.updateByExampleSelective(smsSendDetail, example);
	}
	
	
	
	
	/**
	 * @Title:getTemplateNo 
	 * @Description:根据发送的短信类型获取短信模板id 
	 * @author 谢美团
	 * @param smsConfig
	 * @param smsType
	 * @return 
	 * @throws
	 * @retrun String
	 */ 
	@Override
	public String getTemplateNo(SmsConfig smsConfig,Integer smsType){
		if(smsType == SmsEnmu.SMS_TYPE_INVITE.getValue()){
			return smsConfig.getInviteSMSTempletNo();
		}else if(smsType == SmsEnmu.SMS_TYPE_TEST.getValue()){
			return smsConfig.getTestSMSTempletNo();
		}else{
			return smsConfig.getCaptchaTempletNo();
		}
	}

	/**
	 * @Title:validateOrgTotalLimit 
	 * @Description:验证组织短信发送总数量是否超过限制
	 * @author 谢美团
	 * @param orgId
	 * @param total
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private boolean validateOrgTotalLimit(int orgId,Integer total){
		if(total == null || total == 0){ //不限制短信数量
			return true;
		}
		Map paramMap = new HashMap();
		paramMap.put("orgId", orgId);
		int count = smsSendDetailMapper.selectSmsSumByParam(paramMap);
		if(count < total){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @Title:validateOrgTotalLimit 
	 * @Description: 验证组织当天发送的短信数量是否超过限制
	 * @author 谢美团
	 * @param orgId
	 * @param dateTotal
	 * @param queryDate
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private boolean validateOrgDateLimit(int orgId,Integer dateNum,Date queryDate){
		if(dateNum == null || dateNum == 0){ //不限制短信数量
			return true;
		}
		Map paramMap = new HashMap();
		paramMap.put("orgId", orgId);
		paramMap.put("queryDate", queryDate);
		int count = smsSendDetailMapper.selectSmsSumByParam(paramMap);
		if(count < dateNum){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @Title:validateOrgDateLimit 
	 * @Description:验证手机号每天接收的短信数量是否超过限制 
	 * @author 谢美团
	 * @param recvNumber
	 * @param memberDailyMaxRepl
	 * @param queryDate
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private boolean validateOrgDateLimit(String recvNumber,Short  memberDailyMaxRecv,Date queryDate,int smsType){
		if(memberDailyMaxRecv == null || memberDailyMaxRecv == 0 || isvalidateCode(smsType)){ //不限制短信数量，短信验证码的不做限制
			return true;
		}
		Map paramMap = new HashMap();
		paramMap.put("recvNumbers", recvNumber);
		paramMap.put("queryDate", queryDate);
		int count = smsSendDetailMapper.selectPhoneSmsSum(paramMap);
		if(count < memberDailyMaxRecv){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @Title:validateRepeatDateLimit 
	 * @Description:验证号码每日重复短信是否超过限制 
	 * @author 谢美团
	 * @param recvNumber
	 * @param memberDailyMaxRecv
	 * @param queryDate
	 * @param smsType
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private boolean validateRepeatDateLimit(String recvNumber,Byte memberDailyMaxRepl,Date queryDate,int smsType,String templetNo,String content){
		if(memberDailyMaxRepl == null || memberDailyMaxRepl == 0 || isvalidateCode(smsType)){ //不限制短信数量，短信验证码的不做限制
			return true;
		}
		Map paramMap = new HashMap();
		paramMap.put("recvNumbers", recvNumber);
		paramMap.put("queryDate", queryDate);
		paramMap.put("content", content);
		paramMap.put("templetNo",templetNo);
		int count = smsSendDetailMapper.selectPhoneSmsSum(paramMap);
		if(count < memberDailyMaxRepl){
			return true;
		}else{
			return false;
		}
	}
	
	
	private boolean isvalidateCode(int smsType){
		if(smsType == SmsEnmu.SMS_TYPE_FORGET_PASSWORD.getValue() || smsType == SmsEnmu.SMS_TYPE_MODIDY.getValue() ||smsType == SmsEnmu.SMS_TYPE_REGISTER.getValue()){
			return true;
		}else{
			return false;
		}
	}

	private List<Integer> getOrgIdListByPath(String path){
		List<Integer> orgIdList = new ArrayList<Integer>();
		if(path != null){
			if(path.startsWith(",")){
				path = path.substring(1, path.length()); 
			}
			if(path.endsWith(",")){
				path = path.substring(0, path.length()-1);
			}
			String[] orgIdStrList = path.split(",");
			for(String orgId:orgIdStrList){
				orgIdList.add(Integer.parseInt(orgId));
			}
		}
		return orgIdList;
	}

	@Override
	public SmsConfig isnertSms(SmsSendParams smsParams) throws Exception {
		//根据组织path查找发送组织的短信配置
		List<Integer> orgIdList = getOrgIdListByPath(smsParams.getOrgPath());
		if(orgIdList.size() == 0){
			logger.error("发送组织path 为空，发送短信失败。");
			return null;
		}
		SmsConfigExample cfgExample = new SmsConfigExample();
		cfgExample.setOrderByClause("OrgID desc");
		cfgExample.createCriteria().andServerIDEqualTo(smsParams.getServerID()).andOrgIDIn(orgIdList);
		List<SmsConfig> smsCfgList = smsConfigService.selectByExample(cfgExample);
		if(smsCfgList.size() == 0){
			logger.error("无组织短信配置信息，发送短信失败。");
			return null;
		}
		SmsConfig smsConfig= smsCfgList.get(0);
		
		//保存短信主表信息	
		SmsSend smsSend  = new SmsSend ();
		smsSend.setAccount(smsConfig.getAccount());
		smsSend.setContent(smsParams.getContent());
		smsSend.setContentType(smsParams.getContentType());
		smsSend.setCreateID(0);
		smsSend.setCreateTime(new Date());
		smsSend.setOrgID(smsConfig.getOrgID());
		smsSend.setPriority(smsParams.getPriority());
		smsSend.setServerID(smsParams.getServerID());
		smsSend.setSmsType(smsParams.getSmsType().byteValue());
		smsSendService.insert(smsSend);
		//保存短信明细表信息
		saveSmsSendDetail(smsParams.getRecvNumbers(),smsSend.getSSendID());

		smsConfig.setSSendID(smsSend.getSSendID());
		return smsConfig;
	}
	
	/**
	 * @Title:saveSmsSendDetail 
	 * @Description:保存短信记录明细表
	 * @author 谢美团
	 * @param recvNumbers
	 * @param SSendID 
	 * @throws
	 * @retrun void
	 */ 
	private void saveSmsSendDetail(String recvNumbers,Integer SSendID){
		List<SmsSendDetail> detailList = new ArrayList<SmsSendDetail>();
		String[] phoneList = recvNumbers.split(",");
		for(String phone:phoneList){
			SmsSendDetail  smsSendDetail  = new SmsSendDetail();
			smsSendDetail.setCreateID(0);
			smsSendDetail.setCreateTime(new Date());
			smsSendDetail.setSendStatus(SmsSendStatusEnmu.TO_BE_SEND.getValue());
			smsSendDetail.setSSendID(SSendID);
			smsSendDetail.setRecvNumber(phone);
			smsSendDetail.setFailCount(0);
			detailList.add(smsSendDetail);
		}
		smsSendDetailService.insertByBatch(detailList);
	}
	

	@Override
	public SmsConfig getSmsConfigByOrgid(SmsConfig smsConfig) throws Exception {
		SmsConfigExample example = new SmsConfigExample();
		example.createCriteria().andServerIDEqualTo(smsConfig.getServerID()).andOrgIDEqualTo(smsConfig.getOrgID());
		List<SmsConfig> smsConfigList = smsConfigService.selectByExample(example);
		if(smsConfigList != null && smsConfigList.size() > 0){
			return smsConfigList.get(0);
		}
		return null;
	}

	@Override
	public boolean smsSendAndUpdate(AlibabaSmsReq alibabaSmsReq,Integer sSendID,Integer failCount) throws Exception {
		Byte sendStatus = null;
		String failReason = null;
		try{
			AlibabaSmsRsp alibabaSmsRsp = TaoBaoSmsUtil.smsSend(alibabaSmsReq);
			ErrorResponse  errorResponse =alibabaSmsRsp.getError_response();
			if(errorResponse != null){ //发送失败
				sendStatus = SmsSendStatusEnmu.SEND_FAIL.getValue();
				failReason = errorResponse.getMsg()==null?"":errorResponse.getMsg()+errorResponse.getSub_msg()==null?"":errorResponse.getSub_msg();
			}else if(alibabaSmsRsp.getAlibaba_aliqin_fc_sms_num_send_response() != null && "true".equals(alibabaSmsRsp.getAlibaba_aliqin_fc_sms_num_send_response().getResult().getSuccess())){ 
				sendStatus = SmsSendStatusEnmu.HAVED_SEND.getValue();
			}else{
				sendStatus = SmsSendStatusEnmu.SEND_FAIL.getValue();
				failReason = "未知错误，请求id:"+alibabaSmsRsp.getAlibaba_aliqin_fc_sms_num_send_response().getRequest_id();
			}
			//sendStatus = SmsSendStatusEnmu.HAVED_SEND.getValue();
		}catch(Exception e){
			failCount = failCount==null?1:failCount;
			sendStatus = SmsSendStatusEnmu.TO_BE_SEND.getValue();
			failReason ="发送短信到第三方连接超时";
		}
		updateSendStatus(sSendID,alibabaSmsReq.getRecNum(),sendStatus,failReason,failCount);
		return true;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<SmsStatistic> selectSmsStatistic(SmsSearchParams smsParams) throws Exception {
		if(smsParams.getServerID() == null ){
			logger.error("参数 serverID为空，无法进行统计短信记录。");
			return null;
		}
		String startTime= smsParams.getStartTime() == null?"":TimeUtil.formatDatetime2(smsParams.getStartTime());
		String endTime= smsParams.getEndTime() == null?"":TimeUtil.formatDatetime2(smsParams.getEndTime());
		if(smsParams.getSmsType() == null || smsParams.getSmsType() == 0){
			smsParams.setSmsType(-1);
		}
		Map paramMap= new HashMap();
		paramMap.put("serverId", smsParams.getServerID());
		paramMap.put("orgIdListStr", smsParams.getOrgIDs());
		paramMap.put("startTime", startTime);
		paramMap.put("endTime", endTime);
		paramMap.put("smsType", smsParams.getSmsType());
		paramMap.put("recvNumber", smsParams.getRecvNumber());
		List<SmsStatistic>  list = smsSendDetailMapper.exProc_proc_smssend_getStatisticByOrgID(paramMap);
		return list ;
	}
	




}

