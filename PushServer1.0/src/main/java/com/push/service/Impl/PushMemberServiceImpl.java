package com.push.service.Impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.push.constants.Constants;
import com.push.controller.PushMemberController;
import com.push.dao.PushMemberMapper;
import com.push.model.HKPushInfo;
import com.push.model.HkPushMember;
import com.push.service.PushMemberService;
import com.push.service.PushMsgService;

@Service("pushMemberService")
public class PushMemberServiceImpl implements PushMemberService {
	
	private static Logger logger = Logger.getLogger(PushMemberServiceImpl.class); 

	@Autowired
	private PushMemberMapper pushMemberMapper;
	
    @Autowired
    private PushMsgService pushMsgService;

	@Override
	public void updateHkPushMember(HKPushInfo pushInfo) throws Exception {
		pushMemberMapper.updateHkPushMember(pushInfo);
	}

	@Override
	public void memberOnline(HKPushInfo pushInfo) throws Exception {
		
		pushInfo.setLineStatus(Constants.ON_LINE);
		pushInfo.setLoginTime(new Date());
		HkPushMember pushMember = pushMemberMapper.selectHkPushMemberByMemberId(pushInfo);
		/*如果用户存在，进行更新channelID,userId以及在线状态*/
		if(pushMember != null){
			pushMemberMapper.updateHkPushMember(pushInfo);
		/*如果不存在，进行保存用户信息*/
		}else{
			pushMemberMapper.saveHkPushMember(pushInfo);
		}
		/* 查询该用户是否有未推送数据 */
		List<HKPushInfo> list = pushMsgService.selectHKPushInfoByMemberId(pushInfo);
		/* 如果有未推送的数据，则调用第三方平台进行推送 */
		if(list != null && list.size() > 0){
			pushMsgService.pushMultiMsg(list);
		}
	}

}
