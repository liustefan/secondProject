package com.bithealth.cmsCore.service;

import com.bithealth.cmsCore.model.Advertisement;
import com.bithealth.cmsCore.model.AdvertisementExample;
import com.bithealth.cmsCore.model.HealthnewsInfo;
import com.bithealth.cmsCore.model.HealthnewsInfoExample;
import com.bithealth.cmsCore.model.HealthnewsLable;
import com.bithealth.cmsCore.model.HealthnewsLableExample;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;

/**
 * 类名：CmsService
 * 描述：公共接口
 * @author 作者:周玉飞
 * @version 创建时间：2016年8月16日 上午9:23:46
 * 类说明
 */
public interface CmsService {
	
	int updateAdvert(Advertisement pojo);
	
	int insertAdvert(Advertisement pojo);
	
	int publishAdvert(Advertisement pojo);
	
	int deleteAdvertByIds(Integer...ids);
	
	Advertisement selectAdvertById(Integer id);
	
	Page<Advertisement> selectAdvertPage(Page<Advertisement> page, AdvertisementExample pojo);
	
	
	
	int updateHealthnewsInfo(HealthnewsInfo pojo);
	
	int insertHealthnewsInfo(HealthnewsInfo pojo);
	
	int publishNewsInfo(HealthnewsInfo pojo);
	
	int deletenewsInfoByIds(Integer ...ids);
	
	int deletenewsInfoById(Integer id);
	
	HealthnewsInfo selectnewsInfoById(Integer id);
	
	Page<HealthnewsInfo> selectNewsInfoPage(Page<HealthnewsInfo> page,HealthnewsInfoExample model);
	
	Page<HealthnewsInfo> selectNewsInfoList(Page<HealthnewsInfo> page,HealthnewsInfoExample example);
	

	int updateLable(HealthnewsLable pojo);
	    
	int insertLable(HealthnewsLable pojo);
	
	int updateLableByStatus(HealthnewsLable pojo);
	
	HealthnewsLable selectNewsLableById(Integer id);
	    
	Page<HealthnewsLable> selectNewsLablePage(Page<HealthnewsLable> page,HealthnewsLableExample model);

	
	//禁用标签后删除对应关系
	int deleteInfoLable(Integer id);
	
	int deleteMemLable(Integer id);
	
	//删除资讯收藏关系
	int deleteBookmark(Integer id);
		
}
