package com.bithealth.measureCore.electrocardioPulse.service;

  
import java.util.Date;
import java.util.List;

import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.electrocardio.model.Ecg2Chart;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardioPulse.model.Oppg;
import com.bithealth.measureCore.electrocardioPulse.model.OppgChart;
import com.bithealth.measureCore.electrocardioPulse.model.OppgExample;
import com.bithealth.measureCore.electrocardioPulse.model.OppgOmemVO;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseService;

/**
 * 
 * 类名称: PulseService  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月12日 上午11:06:23 
 * 
 * @author 陈哲
 * @version
 */
 
public interface PulseService extends GenericBaseService<Oppg,OppgExample,Long> {
	Page<OppgOmemVO> selectElectrocardioPluseAndMemListPage(int pageNo, int pageSize, String criteria, Integer docid, String wheAbnTag);

	Page<Oecg> selectElectrocardioPulseAndPage(Integer memberId, int pageNo, int pageSize, Date startTime, Date endTime);
	
	List<Omds> selectMeasureRecordByPulse(Integer memberId);
	
	void deleteElectrocardioPulse(Long docentry);
	
	void deleteBatchElectrocardioPulse(List<Long> docentrys);
	
	List<Ecg2Chart> selectElectrocardioPulseExcTrendChartData(Integer memberId, int reportNo);
	
	List<Ecg2Chart> selectElectrocardioPulseExcTrendChartData(List<Oecg> oecgs);
	
	List<Ecg2Chart> selectElectrocardioPulseExcBarChartData(Integer memberId, int reportNo);
	
	List<Ecg2Chart> selectElectrocardioPulseExcBarChartData(List<Oecg> oecgs);
	
	List<OppgChart> selectPulseIndicatorsTrendChartData(Integer memberId, int reportNo);
	
	List<OppgChart> selectPulseIndicatorsTrendChartData(List<Oecg> oecgs);
	
	OppgChart selectPulseIndicatorsExcBarChartData(Integer memberId, int reportNo);
	
	OppgChart selectPulseIndicatorsExcBarChartData(List<Oecg> oecgs);
	
	Omds selectLastMeasureRecordByPulse(Integer memberId);
	
	Oppg selectElectrocardioPulseByEventId(Long eventId);
	
	/*Long generateOppgdocentry();*/
	
	void saveOppg(Oppg oppg);
	
	Oppg selectOppgByOecg(Long docentry);
	
	Integer selectElectrocardioPulseMeasTotalCount(Integer memberId, Date startTime, Date endTime);
	
	Integer selectElectrocardioPulseMeasExcCount(Integer memberId, Date startTime, Date endTime);
	
	void updatePpgResultOfOppgByEventId(int ppgResult, Long eventId);
	
	void updateStatusTagOfOppgByEventId(int statusTag, Long eventId);
    
}



