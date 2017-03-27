 
/**
 * @PackageName:      com.bithealth.measureCore.electrocardio.service
 * @FileName:     ElectrocardioService.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月11日 下午5:47:36  
 * 
 */

package com.bithealth.measureCore.electrocardio.service;

import java.util.Date;
import java.util.List;

import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.electrocardio.model.Ecg1;
import com.bithealth.measureCore.electrocardio.model.Ecg2;
import com.bithealth.measureCore.electrocardio.model.Ecg2Chart;
import com.bithealth.measureCore.electrocardio.model.Ecg3;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardio.model.OecgExample;
import com.bithealth.measureCore.electrocardio.model.OecgOmemVO;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;


/**
 * 类名称: ElectrocardioService  
 * 功能描述: 动态心电接口.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月11日 下午5:47:36 
 * 
 * @author 陈哲
 * @version  
 */
public interface ElectrocardioService extends GenericBaseService<Oecg,OecgExample,Long>{
	Page<OecgOmemVO> selectElectrocardioAndMemListPage(int pageNo, int pageSize, String criteria, Integer docid, String wheAbnTag);
	
	Page<Oecg> selectElectrocardioAndPage(Integer memberId, int pageNo, int pageSize, Date startTime, Date endTime);
	
	List<Oecg> selectElectrocardioListByMemberId(Integer memberId, String eventType);
	
	Oecg selectElectrocardioByEventId(Long eventId);
	
	Oecg selectElectrocardioByDocentry(Long docentry);
	
	void deleteElectrocardio(Long docentry);
	
	void deleteBatchElectrocardio(List<Long> docentrys);
	
	List<Ecg1> selectElectrocardioExcListByDocentry(Long docentry);
	
	List<Ecg2> selectElectrocardioExcStatisListByDocentry(Long docentry);
	
	List<Ecg3> selectElectrocardioDelListByDocentry(Long docentry);
	
	List<Ecg2Chart> selectElectrocardioExcTrendChartData(Integer memberId, int reportNo);
	
	List<Ecg2Chart> selectElectrocardioExcTrendChartData(List<Oecg> oecgs);
	
	List<Ecg2Chart> selectElectrocardioExcBarChartData(Integer memberId, int reportNo);
	
	List<Ecg2Chart> selectElectrocardioExcBarChartData(List<Oecg> oecgs);
	
	List<Omds> selectMeasureRecordByElectro(Integer memberId);
	
	Omds selectLastMeasureRecordByElectro(Integer memberId);
	
	Long generateDocentry();
	
	void updateEcgResultOfOecgByDocentry(int ecgResult, long docentry);
	
	void updateStatusTagOfOecgByDocentry(int statusTag, long docentry);
	
	void saveOecg(Oecg oecg);
	
	Integer selectElectrocardioMeasTotalCount(Integer memberId, Date startTime, Date endTime);
	
	Integer selectElectrocardioMeasExcCount(Integer memberId, Date startTime, Date endTime);
	
	boolean findOecgByRawImg(String rawImage);

}

