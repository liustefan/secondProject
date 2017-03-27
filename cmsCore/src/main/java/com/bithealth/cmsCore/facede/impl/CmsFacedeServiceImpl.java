package com.bithealth.cmsCore.facede.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.cmsCore.facede.CmsFacedeService;
import com.bithealth.cmsCore.model.Advertisement;
import com.bithealth.cmsCore.model.AdvertisementExample;
import com.bithealth.cmsCore.model.HealthnewsInfo;
import com.bithealth.cmsCore.model.HealthnewsInfoExample;
import com.bithealth.cmsCore.model.HealthnewsLable;
import com.bithealth.cmsCore.model.HealthnewsLableExample;
import com.bithealth.cmsCore.model.InfoLabel;
import com.bithealth.cmsCore.model.InfoLabelExample;
import com.bithealth.cmsCore.model.MemberLabel;
import com.bithealth.cmsCore.model.MemberLabelExample;
import com.bithealth.cmsCore.service.BookmarkService;
import com.bithealth.cmsCore.service.CmsService;
import com.bithealth.cmsCore.service.InfoLabelService;
import com.bithealth.cmsCore.service.MemberLabelService;
import com.bithealth.doctorCore.doctor.service.DoctorService;
import com.bithealth.msgCenterCore.facade.service.MessageCenterFacadeService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;

/**
 * 类名：CmsServiceImpl
 * 描述：对外服务接口实现
 * @author 作者:周玉飞
 * @version 创建时间：2016年8月15日 下午5:33:53
 * 类说明
 */

@Service
public class CmsFacedeServiceImpl implements CmsFacedeService {
	
	protected static Logger logger = Logger.getLogger(CmsFacedeServiceImpl.class);
	@Autowired
	private CmsService cmsService;
	@Autowired
	private MessageCenterFacadeService messageCenterFacadeService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private InfoLabelService infoLabelService;
	@Autowired
	private MemberLabelService memberLabelService;
	@Autowired
	private BookmarkService bookmarkService;

	public boolean insertOrUpdateAdvert(Advertisement pojo) {
		if (pojo.getAid()==null) {
			pojo.setStatustype((byte) 1);
			pojo.setCreatetime(new Date());
			return cmsService.insertAdvert(pojo)>0;
		}else {
				return cmsService.updateAdvert(pojo)>0;
		}
			
	}

	public boolean deleteAdverts(Integer ... ids) {

		return cmsService.deleteAdvertByIds(ids)>0;
	}

	public Advertisement selectAdvertById(Integer id) {
		if (id==null) {
			return null;
		}
		return cmsService.selectAdvertById(id);
	}
	
	public Page<Advertisement> slectAdvertPage(Page<Advertisement> page,
			AdvertisementExample pojo) {
		
		return cmsService.selectAdvertPage(page, pojo);
	}

	public boolean insertOrUpdateNewsInfo(HealthnewsInfo pojo) {
	
		if (pojo.getHninfoid()==null){
			pojo.setStatustype((byte) 1);
		    pojo.setCreatetime(TimeUtil.now());
			if(cmsService.insertHealthnewsInfo(pojo) > 0){
				/*sendMessage(pojo);*/
				return true;
			}
		}else {
			if(cmsService.updateHealthnewsInfo(pojo)>0){
				/*sendMessage(pojo);*/
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean insertOrUpdateNewsInfo(HealthnewsInfo pojo,
			Integer... hnlabelids) {
		if (pojo.getHninfoid()==null){
			pojo.setStatustype((byte) 1);
		    pojo.setCreatetime(TimeUtil.now());
		    pojo.setUpdatetime(TimeUtil.now());
			if(cmsService.insertHealthnewsInfo(pojo) > 0){
				/*sendMessage(pojo);*/
				InfoLabelExample example = new InfoLabelExample();
				example.createCriteria().andHNInfoIDEqualTo(pojo.getHninfoid());
				infoLabelService.deleteByExample(example);
				if(hnlabelids != null && hnlabelids.length > 0){
					for(Integer hnlabelid : hnlabelids){
						InfoLabel model = new InfoLabel();
						model.setHNInfoID(pojo.getHninfoid());
						model.setHNLabelID(hnlabelid);
						model.setUpdateTime(TimeUtil.now());
						infoLabelService.insert(model);
						
					}
				}
				return true;
			}
		}else {
			if(cmsService.updateHealthnewsInfo(pojo)>0){
				/*sendMessage(pojo);*/
			InfoLabelExample example = new InfoLabelExample();
			example.createCriteria().andHNInfoIDEqualTo(pojo.getHninfoid());
			infoLabelService.deleteByExample(example);
			if(hnlabelids != null && hnlabelids.length > 0){
				for(Integer hnlabelid : hnlabelids){
					InfoLabel model = new InfoLabel();
					model.setHNInfoID(pojo.getHninfoid());
					model.setHNLabelID(hnlabelid);
					model.setUpdateTime(TimeUtil.now());
					infoLabelService.insert(model);
				}
			}
			return true;
			}
		}
		return false;
	}

	/*private void sendMessage(HealthnewsInfo pojo){
	try {
		HealthnewsInfo heaInfo =cmsService.selectnewsInfoById(pojo.getHninfoid());
		Doctor doctor = doctorService.selectById(pojo.getUpdateid() == null ? pojo.getCreateid() : pojo.getUpdateid());
		MessageCenter messageCenter = new MessageCenter();
		messageCenter.setMsgtype(MessageTypeEnum.HEALTH_INFORMATION.getType());
		messageCenter.setSendtype(UserTypeEnum.DOCTOR.getType());
		messageCenter.setSender(doctor.getDocGUID());
		messageCenter.setReceivetype(UserTypeEnum.MEMBER.getType());
		messageCenter.setReceiver("sz");
		messageCenter.setLastsourceid((long)pojo.getHninfoid());
		messageCenter.setLastcontent(heaInfo.getTitle());
		messageCenterFacadeService.insertOrUpdateMessageSynchronized(messageCenter);
	} catch (Exception e) {
		logger.error("健康资讯消息发送失败", e);
	}
}*/
	public boolean deleteNewsIngfos(Integer... ids) {
		return cmsService.deletenewsInfoByIds(ids)>0;
	}

	public HealthnewsInfo selectNewsIngfoById(Integer id) {
		if (id==null) {
			return null;
		}
		return cmsService.selectnewsInfoById(id);
	}

	public Page<HealthnewsInfo> selectNewsInfoPage(Page<HealthnewsInfo> page,
			HealthnewsInfoExample pojo) {

		return cmsService.selectNewsInfoPage(page, pojo);
	}

	public boolean insertOrUpdateLable(HealthnewsLable pojo) {
	if (pojo.getHnlabelid()==null){
		pojo.setStatustype((byte) 1);
		pojo.setCreatetime(TimeUtil.now());
		return cmsService.insertLable(pojo)>0;
	}else{ 
		return cmsService.updateLable(pojo)>0;
	}
	}

	public boolean deleteLable(Integer... ids) {

		return cmsService.deleteAdvertByIds(ids)>0;
	}

	public HealthnewsLable selectLableById(Integer id) {
		if (id==null) {
			return null;
		}
		return cmsService.selectNewsLableById(id);
	}

	public Page<HealthnewsLable> selectLablePage(Page<HealthnewsLable> page,
			HealthnewsLableExample pojo) {
		return cmsService.selectNewsLablePage(page, pojo);
	}

	public boolean deleteNewsIngfo(Integer id) {
		
		return cmsService.deletenewsInfoById(id)>0;
	}

	@Override
	public boolean publishNewsInfo(HealthnewsInfo pojo) {
		
		return cmsService.publishNewsInfo(pojo)>0;
	
	}

	@Override
	public boolean publishAdvert(Advertisement pojo) {

		return cmsService.publishAdvert(pojo)>0;
	}

	@Override
	public boolean updateLableByStatus(HealthnewsLable pojo) {
		
		return cmsService.updateLableByStatus(pojo)>0;
	}

	@Override
	public boolean saveMemberLable(Integer memberId, Integer...hnlabelids){
		MemberLabelExample example = new MemberLabelExample();
		example.createCriteria().andMemberIDEqualTo(memberId);
		memberLabelService.deleteByExample(example);
		if(hnlabelids != null && hnlabelids.length > 0){
			for(Integer hnlabelid : hnlabelids){
				MemberLabel model = new MemberLabel();
				model.setMemberID(memberId);
				model.setHNLabelID(hnlabelid);
				model.setUpdateTime(TimeUtil.now());
				memberLabelService.insert(model);
			}
		}
		return false;
	}

	@Override
	public Page<HealthnewsInfo> selectNewsInfoList(Page<HealthnewsInfo> page,
			HealthnewsInfoExample example) {
		return cmsService.selectNewsInfoList(page, example);
	}

	@Override
	public int deleteInfoLable(Integer id) {
		return cmsService.deleteInfoLable(id);
	}

	@Override
	public int deleteMemLable(Integer id) {
		return cmsService.deleteMemLable(id);
	}

	@Override
	public int deleteBookmark(Integer id) {
		
		return cmsService.deleteBookmark(id);
	}
}
