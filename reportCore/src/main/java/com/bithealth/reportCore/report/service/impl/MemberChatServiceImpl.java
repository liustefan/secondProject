package com.bithealth.reportCore.report.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bithealth.reportCore.report.dao.MemberChatMapper;
import com.bithealth.reportCore.report.model.MemberChat;
import com.bithealth.reportCore.report.model.MemberChatExample;
import com.bithealth.reportCore.report.service.MemberChatService;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

@Service("MemberChatService")
public class MemberChatServiceImpl 
        extends GenericBaseServiceImpl<MemberChat, MemberChatExample, Integer>
		implements MemberChatService {

	@Resource
	MemberChatMapper MemberChatMapper;

	@Override
	public GenericBaseDao<MemberChat, MemberChatExample, Integer> getDao() {
		return MemberChatMapper;
	}
}
