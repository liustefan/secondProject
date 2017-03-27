package com.bithealth.cmsCore.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.cmsCore.dao.AdvertisementMapper;
import com.bithealth.cmsCore.dao.BookmarkMapper;
import com.bithealth.cmsCore.dao.HealthnewsInfoMapper;
import com.bithealth.cmsCore.dao.HealthnewsLableMapper;
import com.bithealth.cmsCore.dao.InfoLabelMapper;
import com.bithealth.cmsCore.dao.MemberLabelMapper;
import com.bithealth.cmsCore.model.Advertisement;
import com.bithealth.cmsCore.model.AdvertisementExample;
import com.bithealth.cmsCore.model.HealthnewsInfo;
import com.bithealth.cmsCore.model.HealthnewsInfoExample;
import com.bithealth.cmsCore.model.HealthnewsLable;
import com.bithealth.cmsCore.model.HealthnewsLableExample;
import com.bithealth.cmsCore.service.AdvertisementService;
import com.bithealth.cmsCore.service.CmsService;
import com.bithealth.cmsCore.service.HealthnewsInfoService;
import com.bithealth.cmsCore.service.HealthnewsLableService;
import com.bithealth.sdk.common.utils.TimeUtil;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;

/**
 * 类名：CmsServiceImpl
 * 描述：公共接口实现类
 * @author 作者:周玉飞
 * @version 创建时间：2016年8月16日 上午9:25:24
 * 类说明
 */

@Service
public class CmsServiceImpl implements CmsService {
	@Autowired
	private AdvertisementService advertisementService;
	@Autowired
	private HealthnewsInfoService healthnewsInfoService;
	@Autowired
	private HealthnewsLableService healthnewsLableService;
	@Autowired
	private HealthnewsInfoMapper healthnewsInfoMapper;
	@Autowired
	private AdvertisementMapper advertisementMapper;
	@Autowired
	private HealthnewsLableMapper healthnewsLableMapper;
	@Autowired
	private InfoLabelMapper infoLabelMapper;
	@Autowired
	private MemberLabelMapper memberLabelMapper;
	@Autowired
	private BookmarkMapper bookmarkMapper;

	public int updateAdvert(Advertisement pojo) {
		int n=0;
		if (pojo.getAid()!=null && pojo!=null) {
			pojo.setUpdatetime(TimeUtil.now());
			n+=advertisementService.updateByPrimaryKey(pojo);
			
		}
				return n;
	}

	public int insertAdvert(Advertisement pojo) {
		int n=0;
		if (pojo!=null) {
			n+=advertisementService.insert(pojo);
			
		}
				return n;
	}

	public int deleteAdvertByIds(Integer... ids) {
		int n = 0;
		if(ids != null && ids.length > 0){
			List<Integer> values = Arrays.asList(ids);
			n+=advertisementService.deleteAdvertById(values);
		}
		return n;
	}

	public Page<Advertisement> selectAdvertPage(Page<Advertisement> page,
			AdvertisementExample pojo) {
		advertisementService.selectByExampleAndPage(page, pojo);
		return page;
	}

	public Advertisement selectAdvertById(Integer id) {
		
		return advertisementService.selectById(id);
	}

	
	public int updateHealthnewsInfo(HealthnewsInfo pojo) {
		int n=0;
		if (pojo!=null && pojo.getHninfoid()!=null) {
			pojo.setUpdatetime(TimeUtil.now());
			n+=healthnewsInfoService.updateByPrimaryKey(pojo);
		}
		return n;
	}

	public int insertHealthnewsInfo(HealthnewsInfo pojo) {
		int n=0;
		if (pojo!=null) {
			n+=healthnewsInfoService.insert(pojo);
		}
		return n;
	}
	
	public int deletenewsInfoByIds(Integer... ids) {
		int n = 0;
		if(ids != null && ids.length > 0){
			List<Integer> values = Arrays.asList(ids);
			n+=healthnewsInfoService.deleteNewsInfoById(values);
		}
		return n;
	}
	
	
	public HealthnewsInfo selectnewsInfoById(Integer id) {

		return healthnewsInfoService.selectById(id);
	}
	
	public Page<HealthnewsInfo> selectNewsInfoPage(Page<HealthnewsInfo> page,
			HealthnewsInfoExample model) {
		healthnewsInfoService.selectByExampleAndPage(page, model);
		return page;
	}

	public int updateLable(HealthnewsLable pojo) {

		int n=0;
		if (pojo!=null&&pojo.getHnlabelid()!=null) {
			pojo.setUpdatetime(TimeUtil.now());
			n+=healthnewsLableService.updateByPrimaryKey(pojo);
		}
		return n;
	}

	public int insertLable(HealthnewsLable pojo) {
		int n=0;
		if (pojo!=null) {
			n+=healthnewsLableService.insert(pojo);
		}
		return n;
	}
	public HealthnewsLable selectNewsLableById(Integer id) {
		
		return healthnewsLableService.selectById(id);
	}

	public Page<HealthnewsLable> selectNewsLablePage(
			Page<HealthnewsLable> page, HealthnewsLableExample model) {
		healthnewsLableService.selectByExampleAndPage(page, model);
		return page;
	}

	public int deletenewsInfoById(Integer id) {
		int n = 0;
		if(id != null ){
			n+=healthnewsInfoService.delete(id);
		}
		return n;
	}

	@Override
	public int publishNewsInfo(HealthnewsInfo pojo) {
		int n = 0;
		if(pojo != null ){
			n+=healthnewsInfoMapper.publishNewsInfo(pojo);
		}
		return n;
	}

	@Override
	public int publishAdvert(Advertisement pojo) {
		int n = 0;
		if(pojo != null ){
			n+=advertisementMapper.publishAdvert(pojo);
		}
		return n;

	}

	@Override
	public int updateLableByStatus(HealthnewsLable pojo) {
		int n = 0;
		if(pojo != null ){
			n+=healthnewsLableMapper.updateLableByStatus(pojo);
		}
		return n;

	}

	@Override
	public Page<HealthnewsInfo> selectNewsInfoList(Page<HealthnewsInfo> page,
			HealthnewsInfoExample example) {
		healthnewsInfoMapper.selectNewsInfoList(page, example);
		return page;
	}

	@Override
	public int deleteInfoLable(Integer id) {
		
		return infoLabelMapper.deleteInfoLable(id);
	}

	@Override
	public int deleteMemLable(Integer id) {
		return memberLabelMapper.deleteMemLable(id);
	}

	@Override
	public int deleteBookmark(Integer id) {
		return bookmarkMapper.deleteBookmark(id);
	}
}
