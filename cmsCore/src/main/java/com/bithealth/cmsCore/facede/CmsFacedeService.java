package com.bithealth.cmsCore.facede;

import com.bithealth.cmsCore.model.Advertisement;
import com.bithealth.cmsCore.model.AdvertisementExample;
import com.bithealth.cmsCore.model.HealthnewsInfo;
import com.bithealth.cmsCore.model.HealthnewsInfoExample;
import com.bithealth.cmsCore.model.HealthnewsLable;
import com.bithealth.cmsCore.model.HealthnewsLableExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;

/**
 * 类名：CmsService
 * 描述：对外服务接口
 * @author 作者:周玉飞
 * @version 创建时间：2016年8月15日 下午5:32:47
 * 类说明
 */
public interface CmsFacedeService {

	//广告
	boolean insertOrUpdateAdvert(Advertisement pojo);
	
	boolean deleteAdverts(Integer ... ids);
	
	boolean publishAdvert(Advertisement pojo);
	
	Advertisement selectAdvertById(Integer id);
	
	Page<Advertisement> slectAdvertPage(Page<Advertisement> page,AdvertisementExample pojo);
	
	
	//资讯
	boolean insertOrUpdateNewsInfo(HealthnewsInfo pojo);
	
	boolean insertOrUpdateNewsInfo(HealthnewsInfo pojo, Integer...hnlabelids);
	
	boolean publishNewsInfo(HealthnewsInfo pojo);
	
	boolean deleteNewsIngfos(Integer ... ids);
	
	boolean deleteNewsIngfo(Integer id);
	
	HealthnewsInfo selectNewsIngfoById(Integer id);
	
	Page<HealthnewsInfo> selectNewsInfoPage(Page<HealthnewsInfo> page,HealthnewsInfoExample pojo);
	
	Page<HealthnewsInfo> selectNewsInfoList(Page<HealthnewsInfo> page,HealthnewsInfoExample example);
	
	//标签
	boolean insertOrUpdateLable(HealthnewsLable pojo);
	
	boolean saveMemberLable(Integer memberId, Integer...hnlabelids);
	
	boolean updateLableByStatus(HealthnewsLable pojo);
	
	boolean deleteLable(Integer ... ids);
	
	HealthnewsLable selectLableById(Integer id);
	
	Page<HealthnewsLable> selectLablePage(Page<HealthnewsLable> page, HealthnewsLableExample pojo);
	
	
	//资讯、标签、会员以及收藏关系表
	int deleteInfoLable(Integer id);
	
	int deleteMemLable(Integer id);
	
	int deleteBookmark(Integer id);
	
}
