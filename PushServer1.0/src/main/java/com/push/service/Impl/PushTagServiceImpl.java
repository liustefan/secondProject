package com.push.service.Impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.push.constants.Constants;
import com.push.controller.PushTagController;
import com.push.dao.PushTagMapper;
import com.push.model.HKPushInfo;
import com.push.model.HkPushMemberTag;
import com.push.service.PushTagService;

@Service("pushTagService")
public class PushTagServiceImpl implements PushTagService {
	
	private static Logger logger = Logger.getLogger(PushTagController.class); 
	
	@Autowired
	private PushTagMapper pushTagMapper;
	
	@Override
	public HkPushMemberTag selectHkPushMemberTagByTag(HKPushInfo pushInfo) throws Exception{

		return pushTagMapper.selectHkPushMemberTagByTag(pushInfo);
	}

	@Override
	public void saveHkPushMemberTag(List<HkPushMemberTag> list) throws Exception{
		pushTagMapper.saveHkPushMemberTag(list);
	}

	@Override
	public void updateHkPushMemberTag(HKPushInfo pushInfo,List<HkPushMemberTag> list) throws Exception{
		if(Constants.UPDATE_TAG_MEMBER.equals(pushInfo.getType())){
			pushTagMapper.deleteHkPushMemberTag(pushInfo);
		}
		pushTagMapper.saveHkPushMemberTag(list);
	}

	@Override
	public void deleteHkPushMemberTag(HKPushInfo pushInfo) throws Exception {
		pushTagMapper.deleteHkPushMemberTag(pushInfo);
	}

	
	/**
	 * 将tag和memberIds转换成HkPushMemberTag对象
	 * @param pushInfo
	 * @return
	 */
	public List<HkPushMemberTag> convertHKPushInfo(HKPushInfo pushInfo){
		try {
			List<HkPushMemberTag> list = new ArrayList<HkPushMemberTag>();
			JSONArray json = JSONArray.fromObject(pushInfo.getMemberIds());
			/* 与业务系统约定(model_tag)等于推送平台一个tag */
			pushInfo.setTag(pushInfo.getModel() + "_" + pushInfo.getTag());
			if(json.size() == 0){
				HkPushMemberTag hkPushMemberTag = new HkPushMemberTag();
				hkPushMemberTag.setTag(pushInfo.getTag());
				list.add(hkPushMemberTag);
			}else{
				for(int i = 0;i < json.size();i++){
					HkPushMemberTag hkPushMemberTag = new HkPushMemberTag();
					hkPushMemberTag.setMemberId(json.getString(i));
					hkPushMemberTag.setTag(pushInfo.getTag());
					list.add(hkPushMemberTag);
				}
			}
			return list;
		} catch (Exception e) {
			logger.error("将tag和memberIds转换成HkPushMemberTag对象出错了",e);
		}
		return null;
	}
}
