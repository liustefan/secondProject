 

package com.bithealth.centCore.facade.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.bithealth.agentCore.agent.RedicrectService;
import com.bithealth.centCore.care.enmu.CareAuthorityEnmu;
import com.bithealth.centCore.care.enmu.CareErrorCodeEnmu;
import com.bithealth.centCore.care.enmu.CareSendTypeEnmu;
import com.bithealth.centCore.care.model.CareInfo;
import com.bithealth.centCore.care.model.CareInfoExample;
import com.bithealth.centCore.care.model.FamilyNews;
import com.bithealth.centCore.care.model.FamilyNewsExample;
import com.bithealth.centCore.care.model.KindlyReminder;
import com.bithealth.centCore.care.model.KindlyReminderExample;
import com.bithealth.centCore.care.model.KindlyReminderExample.Criteria;
import com.bithealth.centCore.care.model.KindlyReminderResult;
import com.bithealth.centCore.care.model.MemberBasicInfo;
import com.bithealth.centCore.care.model.MemberBasicInfoExample;
import com.bithealth.centCore.care.service.CareInfoService;
import com.bithealth.centCore.care.service.CareRemarkService;
import com.bithealth.centCore.care.service.FamilyNewsService;
import com.bithealth.centCore.care.service.KindlyReminderService;
import com.bithealth.centCore.care.service.MemberBasicInfoService;
import com.bithealth.centCore.facade.model.MsgCenter;
import com.bithealth.centCore.facade.model.RelateAcount;
import com.bithealth.centCore.facade.service.CareIFService;
import com.bithealth.centCore.msgCenterCore.constants.MessageTypeEnum;
import com.bithealth.centCore.msgCenterCore.constants.UserTypeEnum;
import com.bithealth.centCore.msgCenterCore.model.MessageCenter;
import com.bithealth.centCore.msgCenterCore.service.MessageCenterFacadeService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.ucCore.uc.model.AppServer;
import com.bithealth.ucCore.uc.model.AppServerExample;
import com.bithealth.ucCore.uc.service.AppServerService;
import com.bithealth.ucCore.uc.service.MemberAccountService;


/**
 * 类名称: CareInfoService  
 * 功能描述: 关注模块对外接口实现类
 * 日期: 2016年6月17日 下午3:16:41 
 * 
 * @author 谢美团
 * @version  
 */
@Service("careIFService")
public class CareIFServiceImpl  implements CareIFService {
	 private static Logger logger=Logger.getLogger(CareIFServiceImpl.class);
	
	@Resource
	CareInfoService careInfoService;
	@Resource
	CareRemarkService careRemarkService;
	@Resource
	KindlyReminderService kindlyReminderService;
	@Resource
	RedicrectService  redicrectService;
	@Resource
	AppServerService appServerService;
	@Resource
	MemberAccountService memberAccountService;
	
	@Resource(name="memberInfoService")
	MemberBasicInfoService memberBasicInfoService;
	@Resource
	FamilyNewsService  familyNewsService;
	@Resource
	MessageCenterFacadeService  msgCenterService;

	
	
	@Override
	public List<CareInfo> selectMyCareList(String memberGUID, int isGetNews,boolean isHttpsRequest) throws Exception {
		List<CareInfo> resultList = new ArrayList<CareInfo>();
		//获取我关注的人的列表
		List<String> tagList = new ArrayList<String>();
		tagList.add("N");
		tagList.add("Z");
		CareInfoExample example = new CareInfoExample();
		com.bithealth.centCore.care.model.CareInfoExample.Criteria  criteria  = example.createCriteria();
		criteria.andMemberGUIDEqualTo(memberGUID).andTagIn(tagList);
		if(isGetNews == 0){
			List<Integer> focusStatusList = new ArrayList<Integer>();
			focusStatusList.add(2); //接收状态
			focusStatusList.add(3); //对方已取消状态
			criteria.andFocusStatusIn(focusStatusList);
		}
		List<CareInfo> careList = careInfoService.selectByExample(example);
		//获取我关注的人的基本信息
		for(CareInfo careInfo:careList){
			resultList.add(getBaseInfoFromUC(careInfo,true,isHttpsRequest));
		}
		
		if(isGetNews == 0 ){//是否获取亲友的最新动态，0-获取，1-不获取
			//获取我关注的人的最新动态
			for(CareInfo care:resultList){
				Page<FamilyNews> newsPage = new Page<FamilyNews>(1,2);
				List<FamilyNews>  newsList = familyNewsService.getLastFamilyNewsAndReadStatus(newsPage, care.getFocusGUID(), memberGUID);
				if(null != newsList && newsList.size() > 0){
					FamilyNews news = newsList.get(0);
					if(varifyReadAuthority(care.getFocusP(),care.getFocusPed(),news.getMsgType())){
						String content = news.getContent().substring(news.getContent().lastIndexOf(")")+1, news.getContent().length());
						care.setNews(content);
						care.setNumber(news.getNumber());
					}
				}
			}
		}
		return resultList;
	}

	@Override
	public List<CareInfo> selectCareMeList(String memberGUID,boolean isHttpsRequest) throws Exception {
		List<CareInfo> resultList = new ArrayList<CareInfo>();
		//获取关注我的人的列表
		List<String> tagList = new ArrayList<String>();
		tagList.add("N");
		tagList.add("Y");
		CareInfoExample example = new CareInfoExample();
		example.createCriteria().andFocusGUIDEqualTo(memberGUID).andTagIn(tagList);
		
		List<CareInfo> careList = careInfoService.selectByExample(example);
		//获取我关注的人的基本信息
		for(CareInfo careInfo:careList){
			resultList.add(getBaseInfoFromUC(careInfo,false,isHttpsRequest));
		}
		return resultList;
	}

	private CareInfo getBaseInfoFromUC(CareInfo careInfo,boolean isGetMyCareList,boolean isHttpsRequest) throws Exception{
		
		String memberId = isGetMyCareList==true?careInfo.getFocusGUID():careInfo.getMemberGUID();
		MemberBasicInfoExample infoExample = new MemberBasicInfoExample();
		infoExample.createCriteria().andMemberIDEqualTo(memberId);
		
		List<MemberBasicInfo> infoList = memberBasicInfoService.selectByExample(infoExample);
		if(infoList != null && infoList.size() > 0){
			MemberBasicInfo memberBasicInfo = infoList.get(0);
			BeanUtils.copyProperties(memberBasicInfo, careInfo);
			careInfo.setMemberSex(memberBasicInfo.getMemberSex()==null?"":memberBasicInfo.getMemberSex().toString());
			if(isGetMyCareList){
				careInfo.setFocusGUID(memberBasicInfo.getMemberID());
			}else{
				careInfo.setMemberGUID(memberBasicInfo.getMemberID());
			}
			AppServer appServer = appServerService.selectById(memberBasicInfo.getServerID());
			if(isHttpsRequest){
				careInfo.setUrl(appServer.getHttpsAddress());
			}else{
				careInfo.setUrl(appServer.getIpAddress());
			}
			
		}
		return careInfo;
	}
	
	
	
	
	@Override
	public List<CareInfo> selectMemberByParams(String searchParam, String memberGUID,boolean isHttpsRequest) throws Exception {
		
		List<CareInfo> careList = careInfoService.selectBySearchParam(searchParam, memberGUID);
		for(CareInfo careInfo:careList){
			AppServer appServer = appServerService.selectById(careInfo.getServerID());
			if(isHttpsRequest){
				careInfo.setUrl(appServer.getHttpsAddress());
			}else{
				careInfo.setUrl(appServer.getIpAddress());
			}
		}
		return careList;
	}

	@Override
	public int addCare_trans(CareInfo careInfo) {
		careInfo.setTag("N");
		careInfo.setCreateTime(TimeUtil.formatDatetime2(new Date()));
		if(careInfo.getFocusStatus() == null || careInfo.getFocusStatus() == 0){
			careInfo.setFocusStatus(1); // 关注请求未处理
		}
		careInfo.setFocusP(CareAuthorityEnmu.ALLOW_ITEM_ALL.getValue());//添加关注，默认关注权限为全部
		careInfo.setFocusPed(CareAuthorityEnmu.RECEIVE_ITEM_ALL.getValue());//添加关注时，接收消息项默认为全部
		careInfo.setFocusType(1);
		
		//去重判断
		CareInfoExample example = new CareInfoExample();
		example.createCriteria().andMemberGUIDEqualTo(careInfo.getMemberGUID()).andFocusGUIDEqualTo(careInfo.getFocusGUID());
		
		List<CareInfo> careList = careInfoService.selectByExample(example);
		if(careList != null && careList.size() > 0){
			careInfo.setId(careList.get(0).getId());
			careInfoService.updateByPrimaryKey(careInfo);
		}else{
			careInfoService.insert(careInfo);
		}
		
		try{
			//发送消息到APP显示红点
			MessageCenter message = new MessageCenter();
			// 消息类型：1-温馨提示，2-我的咨询，3-单项报告，4-汇总报告，5-单份答卷审核，6-组合答卷审核，7-关注亲友，8-健康资讯，9-广告，10-测量数据，11-体检随访，12-高血压随访，13-II型糖尿病随访
			message.setMsgType(MessageTypeEnum.ATTENTION_FRIENDS.getType()); 
			message.setSendType(UserTypeEnum.MEMBER.getType());//发送类型：0-系统，1-医生，2-会员
			message.setSender(careInfo.getMemberGUID());
			message.setReceiveType(UserTypeEnum.MEMBER.getType()); //接收类型：1-医生，2-会员，3-tag
			message.setReceiver(careInfo.getFocusGUID());
			message.setLastSourceID(careInfo.getId());
			message.setLastContent("");
			msgCenterService.insertOrUpdateMessageSynchronized(message);
		}catch(Exception e){
			e.printStackTrace();
			logger.error("添加关注时发送消息给关注人显示红点失败。"+e.getMessage());
		}
		return 0;
	}

	@Override
	public int relateAcount_trans(RelateAcount relateAcount) throws Exception {
		//验证账号和密码并获取该账号的基本信息
		List<MemberBasicInfo> memberList =  memberBasicInfoService.selectMemberByAccountAndPwd(relateAcount.getAccount(), relateAcount.getPassword());
		//保存关注信息
		if(memberList != null && memberList.size() > 0){
			//判断关联的账号是否是自己的账号
			MemberBasicInfo info = memberList.get(0);
			if(info.getMemberID() != null && info.getMemberID().equals(relateAcount.getMemberGUID())){ 
				return CareErrorCodeEnmu.CARE_ONESELF_ONT_ALLOW.getValue();
			}
			//判断关联的账号是否是已经关注的账号
			CareInfoExample example = new CareInfoExample();
			example.createCriteria().andMemberGUIDEqualTo(relateAcount.getMemberGUID()).andFocusGUIDEqualTo(info.getMemberID());
			List<CareInfo> careList = careInfoService.selectByExample(example);
			if(careList != null && careList.size() > 0 ){
				CareInfo temp = careList.get(0);
				if(temp.getFocusStatus() == 2){
					return CareErrorCodeEnmu.ALREADY_FOLLOW.getValue();
				}
			}
			
			CareInfo careInfo = new CareInfo();
			careInfo.setFocusGUID(info.getMemberID());
			careInfo.setFocusType(1);
			careInfo.setMemberId(relateAcount.getMemberId());
			careInfo.setMemberGUID(relateAcount.getMemberGUID());
			careInfo.setMemberRemark(relateAcount.getMemberRemark());
			careInfo.setFocusRemark(relateAcount.getFocusRemark());
			careInfo.setFocusStatus(2); //关注已接受
			careInfo.setFocusP(CareAuthorityEnmu.ALLOW_ITEM_ALL.getValue());//通过账号关联关注，默认关注权限为全部
			careInfo.setTag("N");
			careInfo.setCreateTime(TimeUtil.formatDatetime2(new Date()));
			careInfo.setFocusPed(CareAuthorityEnmu.RECEIVE_ITEM_ALL.getValue());//添加关注时，接收消息项默认为全部

			if(careList != null && careList.size() > 0){
				careInfo.setId(careList.get(0).getId());
				return careInfoService.update(careInfo);
			}else{
				return careInfoService.insert(careInfo);
			}
		}else{
			return CareErrorCodeEnmu.MEMBER_NOT_EXIST.getValue();
		}

	}
	
	@Override
	public int updateCare(CareInfo careInfo) {
		if(careInfo.getId() != null){
			if(careInfo.getTag() != null){  //涉及更新tag需要判断双发是否都已删除。
				CareInfo  tempCareInfo  = careInfoService.selectById(careInfo.getId());
				if(!"N".equals(tempCareInfo.getTag()) && !careInfo.getTag().equals(tempCareInfo.getTag()) && !tempCareInfo.getFocusStatus().equals(1)){
					careInfoService.delete(careInfo.getId());
				}else{
					return careInfoService.update(careInfo);
				}
			}else{
				return careInfoService.update(careInfo);
			}
		}
		return 0;
	}

	@Override
	public List<KindlyReminder> getMyCareMessage(KindlyReminder kindlyReminders,Page<KindlyReminder> page) throws Exception {
		
		KindlyReminderExample example = new KindlyReminderExample();
		
		Criteria  criteria  = example.createCriteria();
		criteria.andSenderEqualTo(kindlyReminders.getSenderGUID());
		if(kindlyReminders.getReceiverGUID() != null && !kindlyReminders.getReceiverGUID().equals("")){
			criteria.andReceiverEqualTo(kindlyReminders.getReceiverGUID());
		}
		if(kindlyReminders.getMsgType() == 1){
			criteria.andScheduleTimeIsNull();
		}else if(kindlyReminders.getMsgType() == 2){
			criteria.andScheduleTimeIsNotNull();
		}
		if(kindlyReminders.getStartDate() != null){
			criteria.andCreateTimeGreaterThanOrEqualTo(TimeUtil.parseDate(kindlyReminders.getStartDate()));
		}
		if(kindlyReminders.getEndDate() != null){
			criteria.andCreateTimeLessThanOrEqualTo(TimeUtil.parseDate(kindlyReminders.getEndDate()));
		}
		if(kindlyReminders.getSendType() != null && CareSendTypeEnmu.TYPE_DOCTOR.getValue() == kindlyReminders.getSendType()){
			criteria.andSendTypeEqualTo((byte)CareSendTypeEnmu.TYPE_DOCTOR.getValue());
		}
		example.setOrderByClause("ScheduleTime desc");
		List<KindlyReminder> kindlyList = kindlyReminderService.selectByExampleAndPage(page, example);
		return kindlyList;
		
	}



	@Override
	public void sendMsgToCareMeMember(MsgCenter msgCenter) throws Exception {
		if(msgCenter.getSender() ==null ){
			logger.error("发送者为空，发送测量数据消息或公卫数据消息给关注我的人失败。");
			return;
		}
		//根据发送者获取关注发送者的人员列表(获取关注我的人列表)
		CareInfoExample example = new CareInfoExample();
		example.createCriteria().andFocusGUIDEqualTo(msgCenter.getSender()).andTagEqualTo("N");
		
		List<CareInfo> careList = careInfoService.selectByExample(example);
		//根据获取的人员关注权限选择性发送消息
		for(CareInfo careInfo:careList){
			try{
				//根据关注权限发送亲友动态消息到消息中心
				if(varifyReadAuthority(careInfo.getFocusP(),careInfo.getFocusPed(),msgCenter.getMsgtype())){//需要发送消息
					
					//保存亲友动态消息
					FamilyNews familyNews = new FamilyNews();
					familyNews.setSender(msgCenter.getSender());
					familyNews.setContent(msgCenter.getLastcontent().replace("??", careInfo.getMemberRemark()));
					familyNews.setCreateTime(new Date());
					familyNews.setMsgType(msgCenter.getMsgtype());
					familyNews.setReceiver(careInfo.getMemberGUID());
					familyNews.setSourceID(msgCenter.getLastsourceid());
					familyNews.setIsSend((byte)0);//不发送消息
					
					if(varifyRecieveAuthority(careInfo.getFocusP(),careInfo.getFocusPed(),msgCenter.getMsgtype(),msgCenter.getLastcontent())){
						MessageCenter message = new MessageCenter();
						message.setLastContent(familyNews.getContent());
						message.setLastContentNotice(familyNews.getContent());
						message.setLastSourceID(familyNews.getSourceID());
						message.setMsgType(familyNews.getMsgType());
						message.setReceiver(careInfo.getMemberGUID());
						message.setReceiveType(UserTypeEnum.MEMBER.getType());//接收类型：1-医生，2-会员，3-tag
						message.setSender(familyNews.getSender());
						message.setSendType(UserTypeEnum.MEMBER.getType());
						msgCenterService.insertOrUpdateMessageSynchronized(message);
						familyNews.setIsSend((byte)1);//发送消息
					}
					
					familyNewsService.insert(familyNews);
				}
			}catch(Exception e){
				e.printStackTrace();
				logger.error("发送测量数据消息或公卫数据消息给["+careInfo.getMemberGUID()+"]失败。");
			}
		}
	}

	/**
	 * @Title:varifyReadAuthority 
	 * @Description:验证是否设置了可查看权限
	 * @author 谢美团
	 * @param focusPStr
	 * @param focusPedStr
	 * @param msgType
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	private boolean varifyReadAuthority(String focusPStr,String focusPedStr,int msgType){
		boolean allowItem = false;
		if(focusPStr != null && !focusPStr.equals("")){
			//根据消息类型和发送者设置的权限判断关注我的人是否有权限获取消息 
			String[]  focusPs = focusPStr.split(",");
			for(String focusP:focusPs){
				if(CareAuthorityEnmu.ALLOW_ITEM_1.getValue().equals(focusP) && (msgType == 10 || msgType == 15 || msgType == 16 || msgType == 17 || msgType == 18)){ //测量数据权限
					allowItem = true;
					break;
				}else if(CareAuthorityEnmu.ALLOW_ITEM_2.getValue().equals(focusP) && (msgType == 11 || msgType == 12 || msgType == 13)){ //公卫服务数据权限
					allowItem = true;
					break;
				}
			}
		}
		return allowItem;
	}
	
	
	/**
	 * @Title:varifyRecieveAuthority 
	 * @Description:验证是否设置了接收权限
	 * @author 谢美团
	 * @param focusPStr
	 * @param focusPedStr
	 * @param msgType
	 * @return 
	 * @throws
	 * @retrun boolean
	 */ 
	private boolean varifyRecieveAuthority(String focusPStr,String focusPedStr,int msgType,String context){
		if(focusPedStr!= null && !focusPedStr.equals("")){
			//根据消息类型和接收者设置的接收权限判断是否需要给关注我的人发送消息
			String[]  focusPeds = focusPedStr.split(",");
			for(String focusPed:focusPeds){
				if(CareAuthorityEnmu.RECEIVE_ITEM_1.getValue().equals(focusPed) && (msgType == 10 || msgType == 15 || msgType == 16 || msgType == 17 || msgType == 18)){
					return true;
				}else if (CareAuthorityEnmu.RECEIVE_ITEM_2.getValue().equals(focusPed) && (msgType == 10 || msgType == 15 || msgType == 16 || msgType == 17 || msgType == 18) ){
					if(context.indexOf("正常") == -1){//测量结果异常
						return true;
					}
				}else if(CareAuthorityEnmu.RECEIVE_ITEM_3.getValue().equals(focusPed) && msgType == 11 ){
					return true;
				}else if(CareAuthorityEnmu.RECEIVE_ITEM_4.getValue().equals(focusPed) && (msgType == 12 || msgType == 13 )){
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	
	

	@Override
	public void sendKindlyReminder_trans(KindlyReminder kindlyReminder) throws Exception {
		
		//获取发送者基本信息
		MemberBasicInfoExample example = new MemberBasicInfoExample();
		example.createCriteria().andMemberIDEqualTo(kindlyReminder.getSender());
		List<MemberBasicInfo> list = memberBasicInfoService.selectByExample(example);
		MemberBasicInfo senderInfo = new MemberBasicInfo();
		if(list != null && list.size() > 0){
			senderInfo = list.get(0);
		}
		
		//手机栏弹出内容格式组装
		String lastcontentNotice = "";
		if(kindlyReminder.getSenderName() == null){//会员发送
			kindlyReminder.setSenderName(senderInfo.getMemberName());
			lastcontentNotice = senderInfo.getMemberName()+":"+kindlyReminder.getContent();
		}else{// 医生发送
			lastcontentNotice = kindlyReminder.getSenderName()+"医生:"+kindlyReminder.getContent();
		}
		
		//保存温馨提示明细
		kindlyReminder.setCreateTime( new Date());
		if(kindlyReminder.getScheduleTime() == null){
			kindlyReminder.setScheduleTime(new Date());
		}
		kindlyReminderService.insert(kindlyReminder);

		//保存发送信息到消息中心表中
		MessageCenter message = new MessageCenter();
		// 消息类型：1-温馨提示，2-我的咨询，3-单项报告，4-汇总报告，5-单份答卷审核，6-组合答卷审核，7-关注亲友，8-健康资讯，9-广告，10-测量数据，11-体检随访，12-高血压随访，13-II型糖尿病随访
		message.setMsgType(MessageTypeEnum.KINDLY_REMINDER.getType());
		message.setSendType(kindlyReminder.getSendType());
		message.setSender(kindlyReminder.getSender());
		message.setReceiveType(UserTypeEnum.MEMBER.getType()); //接收类型：1-医生，2-会员，3-tag
		message.setReceiver(kindlyReminder.getReceiver());
		message.setLastSourceID(Long.valueOf(kindlyReminder.getLogID()));
		message.setLastContent(kindlyReminder.getContent());
		message.setLastContentNotice(lastcontentNotice);
		if(kindlyReminder.getMsgType() == 2){//定时消息
			message.setScheduleTime(kindlyReminder.getScheduleTime());
			msgCenterService.insertOrUpdateMessageAsynchronous(message);
		}else{//即时消息
			msgCenterService.insertOrUpdateMessageSynchronized(message);
		}
	}

	@Override
	public CareInfo getmemberByGUID(String memberGUID,boolean isHttpsRequest) throws Exception {
		List<CareInfo> lsit = new ArrayList<CareInfo>();
		CareInfo careInfo = new CareInfo();
		careInfo.setMemberGUID(memberGUID);
		lsit.add(careInfo);
		CareInfo  care = getBaseInfoFromUC(careInfo,false,isHttpsRequest);
		return care;
	}

	@Override
	public int batchDeleteKindlyReminder_trans(List<Integer> idList)throws Exception {
		if(idList != null){
			KindlyReminderExample example = new KindlyReminderExample();
			example.createCriteria().andLogIDIn(idList);
			
			return kindlyReminderService.deleteByExample(example);
		}else{
			return 0;
		}
	}

	@Override
	public List<FamilyNews> getMyCareMemberNews(Page<FamilyNews> page,String memberGUID,boolean isHttpsRequest) {
		
		List<FamilyNews> familyNewsList = familyNewsService.getMyCareMemberNews(page, memberGUID);
		if(familyNewsList != null && familyNewsList.size() > 0){
			List<Integer> idList = new ArrayList<Integer>();
			for(FamilyNews familyNews:familyNewsList){
				if(familyNews.getServerId() != null){
					idList.add(familyNews.getServerId());
				}
			}
			AppServerExample example = new AppServerExample();
			example.createCriteria().andIdIn(idList);
			List<AppServer> appList = appServerService.selectByExample(example);
			for(FamilyNews familyNews:familyNewsList){
				for(AppServer appServer:appList){
					if(familyNews.getServerId() != null && familyNews.getServerId().equals(appServer.getId())){
						if(isHttpsRequest){
							familyNews.setUrl(appServer.getHttpsAddress());
						}else{
							familyNews.setUrl(appServer.getIpAddress());
						}
						
					}
				}
			}
		}
		// 删除消息中心数据
		try{
			msgCenterService.deleteMsgByParams(memberGUID, null, MessageTypeEnum.FRIENDS_DYNAMIC.getType());
		}catch(Exception e){
			logger.error("删除["+memberGUID+"]的亲友动态异常");
		}
		
		return familyNewsList;
	}
	


	@Override
	public List<KindlyReminderResult> toGetMyKindlyReminder_trans(Page<KindlyReminder> page,String memberGUID) {
		List<KindlyReminderResult> resultList = new ArrayList<KindlyReminderResult>();
		KindlyReminderExample example = new KindlyReminderExample();
		example.setOrderByClause("CreateTime desc");
		example.createCriteria().andReceiverEqualTo(memberGUID).andScheduleTimeLessThanOrEqualTo(new Date());
		List<KindlyReminder> lsit = kindlyReminderService.selectByExampleAndPage(page, example);
		for(KindlyReminder kindlyReminder:lsit){
			KindlyReminderResult KindlyReminderResult = new KindlyReminderResult();
			BeanUtils.copyProperties(kindlyReminder, KindlyReminderResult);
			resultList.add(KindlyReminderResult);
		}
		//删除消息中心数据
		try{
			msgCenterService.deleteMsgByParams(memberGUID, null, MessageTypeEnum.KINDLY_REMINDER.getType());
		}catch(Exception e){
			e.printStackTrace();
			logger.error("删除消息中心["+memberGUID+"]会员的温馨提示异常。");
		}
		return resultList;
	}

	@Override
	public boolean MergeCareData(String sourceGUID, String targetGUID) {
		//合并关注主表的数据
		List<CareInfo> list = careInfoService.selectMergeData(sourceGUID, targetGUID);
		for(CareInfo careInfo:list){
			CareInfoExample example = new CareInfoExample();
			example.createCriteria().andMemberGUIDEqualTo(careInfo.getMemberGUID()).andFocusGUIDEqualTo(sourceGUID);
			careInfoService.deleteByExample(example);// 删除一个同时关注要合并的两个账号中的一条数据
		}

		CareInfo model = new CareInfo();
		model.setMemberGUID(targetGUID);
		CareInfoExample example = new CareInfoExample();
		example.createCriteria().andMemberGUIDEqualTo(sourceGUID);
		careInfoService.updateByExampleSelective(model, example);//替换memberGUID
		
		model = new CareInfo();
		model.setFocusGUID(targetGUID);
		example = new CareInfoExample();
		example.createCriteria().andFocusGUIDEqualTo(sourceGUID);
		careInfoService.updateByExampleSelective(model, example); //替换FocusGUID
		
		//合并温馨提示的数据
		KindlyReminder kindlyReminder = new KindlyReminder();
		KindlyReminderExample kindlyExample = new KindlyReminderExample();
		kindlyReminder.setSender(targetGUID);
		kindlyExample.createCriteria().andSenderEqualTo(sourceGUID);
		kindlyReminderService.updateByExampleSelective(kindlyReminder, kindlyExample);
		
		kindlyReminder = new KindlyReminder();
		kindlyExample = new KindlyReminderExample();
		kindlyReminder.setReceiver(targetGUID);
		kindlyExample.createCriteria().andReceiverEqualTo(sourceGUID);
		kindlyReminderService.updateByExampleSelective(kindlyReminder, kindlyExample);
		
		//合并亲友关怀的数据
		FamilyNews familyNews = new FamilyNews();
		FamilyNewsExample familyNewsExample = new  FamilyNewsExample();
		familyNews.setSender(targetGUID);
		familyNewsExample.createCriteria().andSenderEqualTo(sourceGUID);
		familyNewsService.updateByExampleSelective(familyNews, familyNewsExample);
		
		familyNews = new FamilyNews();
		familyNewsExample = new  FamilyNewsExample();
		familyNews.setReceiver(targetGUID);
		familyNewsExample.createCriteria().andReceiverEqualTo(sourceGUID);
		familyNewsService.updateByExampleSelective(familyNews, familyNewsExample);
		
		return true;
	}

}

