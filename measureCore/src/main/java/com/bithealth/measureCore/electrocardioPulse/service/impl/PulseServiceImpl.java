package com.bithealth.measureCore.electrocardioPulse.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.electrocardio.model.Ecg2Chart;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardioPulse.dao.MultiOppgMapper;
import com.bithealth.measureCore.electrocardioPulse.dao.OppgMapper;
import com.bithealth.measureCore.electrocardioPulse.model.Oppg;
import com.bithealth.measureCore.electrocardioPulse.model.OppgChart;
import com.bithealth.measureCore.electrocardioPulse.model.OppgExample;
import com.bithealth.measureCore.electrocardioPulse.model.OppgExample.Criteria;
import com.bithealth.measureCore.electrocardioPulse.model.OppgOmemVO;
import com.bithealth.measureCore.electrocardioPulse.service.PulseService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;

  
/**
 * 
 * 类名称: PulseServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月12日 上午11:07:44 
 * 
 * @author 陈哲
 * @version
 */
@Service 
public class PulseServiceImpl extends GenericBaseServiceImpl<Oppg,OppgExample,Long>    
		implements PulseService {
     
    @Resource 
    OppgMapper oppgMapper;
    
    @Autowired
    MultiOppgMapper multiOppgMapper;
    
    @Override
    public GenericBaseDao<Oppg, OppgExample, Long> getDao() {
        return oppgMapper;
    }

	/** 
	     * @Title: send 
	     * @Description: 通过条件查找三合一以及与之有关的会员信息并分页
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseService#selectElectrocardioPluseAndMemListPage(int, int, java.lang.String, java.lang.Integer, java.lang.String)
	     */
	public Page<OppgOmemVO> selectElectrocardioPluseAndMemListPage(int pageNo,
			int pageSize, String criteria, Integer docid, String wheAbnTag) {
		Page<OppgOmemVO> page = new Page<OppgOmemVO>(pageNo, pageSize);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("docId", docid);
		if(criteria != null && !"".equals(criteria.trim())){
			param.put("criteria", "%"+criteria.trim()+"%");
		}
		param.put("wheAbnTag", wheAbnTag);
		
		multiOppgMapper.selectOppgListAndPage(page,param);
		return page;
	}

	
	/** 
	     * @Title: send 
	     * @Description:查找某一时间段的三合一信息并分页
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseService#selectElectrocardioPulseAndPage(java.lang.Integer, int, int, java.util.Date, java.util.Date)
	     */
	@Override
	public Page<Oecg> selectElectrocardioPulseAndPage(Integer memberId,
			int pageNo, int pageSize, Date startTime, Date endTime) {
		Page<Oecg> page = new Page<Oecg>(pageNo, pageSize);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("startTime", startTime);
		param.put("endTime", endTime);
		multiOppgMapper.selectOecgPulseAndPage(page, param);
		return page;
	}

	/** 
	     * @Title: send 
	     * @Description: 通过会员id获取测量记录
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseService#selectMeasureRecordByPulse(java.lang.Integer)
	     */
	public List<Omds> selectMeasureRecordByPulse(Integer memberId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		return multiOppgMapper.selectOmdsByOppg(param);
	}
	
	
	/** 
     * @Title: send 
     * @Description: 通过会员id获取最近一条的测量记录.
     * @param  
     * @throws      
     * @retrun  
     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseService#selectLastMeasureRecordByPulse(java.lang.Integer)
     */
	public Omds selectLastMeasureRecordByPulse(Integer memberId) {
		List<Omds> omdsList = selectMeasureRecordByPulse(memberId);
		
		Omds omds = null;
		if(omdsList != null && !omdsList.isEmpty()){
			omds = omdsList.get(0);
		}
		return omds;
	}

	
	/** 
	     * @Title: send 
	     * @Description: 逻辑删除三合一信息
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseService#deleteElectrocardioPulse(java.lang.Long)
	     */
	public void deleteElectrocardioPulse(Long docentry) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("delTag", "1");
		param.put("docentry", docentry);
		multiOppgMapper.updateOppgOecgByDocentry(param);
	}
	
	/**
	     * @Title: send 
	     * @Description: 批量删除三合一信息（逻辑删除）
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseService#deleteBatchElectrocardioPulse(java.util.List)
	 */
	public void deleteBatchElectrocardioPulse(List<Long> docentrys) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("delTag", "1");
		param.put("docentryList", docentrys);
		multiOppgMapper.updateBatchOppgOecgByDocentry(param);
	}
	
	/** 
	     * @Title: send 
	     * @Description: 三合一异常趋势图数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseService#selectElectrocardioPulseExcTrendChartData(java.lang.Integer, int)
	     */
	public List<Ecg2Chart> selectElectrocardioPulseExcTrendChartData(
			Integer memberId, int reportNo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("reportNo", reportNo);
		
		return multiOppgMapper.selectOecgOppgExcTrendChart(param);
	}
	
	public List<Ecg2Chart> selectElectrocardioPulseExcTrendChartData(List<Oecg> oecgs) {
		List<Long> list = new ArrayList<Long>();
		for(Oecg oecg : oecgs){
			list.add(oecg.getDocentry());
		}
		
		return multiOppgMapper.selectOecgOppgExcTrendChart1(list);
	}

	
	/** 
	     * @Title: send 
	     * @Description:三合一异常柱状图数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseService#selectElectrocardioPulseExcBarChartData(java.lang.Integer, int)
	     */
	public List<Ecg2Chart> selectElectrocardioPulseExcBarChartData(
			Integer memberId, int reportNo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("reportNo", reportNo);
		
		return multiOppgMapper.selectOecgOppgExcBarChart(param);
	}
	
	public List<Ecg2Chart> selectElectrocardioPulseExcBarChartData(List<Oecg> oecgs) {
		List<Long> list = new ArrayList<Long>();
		for(Oecg oecg : oecgs){
			list.add(oecg.getDocentry());
		}
		
		return multiOppgMapper.selectOecgOppgExcBarChart1(list);
	}

	
	/** 
	     * @Title: send 
	     * @Description: 脉搏指标趋势图数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseService#selectPulseIndicatorsTrendChartData(java.lang.Integer, int)
	     */
	public List<OppgChart> selectPulseIndicatorsTrendChartData(
			Integer memberId, int reportNo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("reportNo", reportNo);
		
		return multiOppgMapper.selectOppgIndicatorsTrendChart(param);
	}
	
	public List<OppgChart> selectPulseIndicatorsTrendChartData(List<Oecg> oecgs) {
		List<Long> list = new ArrayList<Long>();
		for(Oecg oecg : oecgs){
			list.add(oecg.getDocentry());
		}
		
		return multiOppgMapper.selectOppgIndicatorsTrendChart1(list);
	}

	
	/** 
	     * @Title: send 
	     * @Description: 脉搏指标异常柱状图数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseService#selectPulseIndicatorsExcBarChartData(java.lang.Integer, int)
	     */
	public OppgChart selectPulseIndicatorsExcBarChartData(
			Integer memberId, int reportNo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("reportNo", reportNo);
		
		return multiOppgMapper.selectOppgIndicatorsExcBarChart(param);
	}
	
	public OppgChart selectPulseIndicatorsExcBarChartData(List<Oecg> oecgs) {
		List<Long> list = new ArrayList<Long>();
		for(Oecg oecg : oecgs){
			list.add(oecg.getDocentry());
		}
		
		return multiOppgMapper.selectOppgIndicatorsExcBarChart1(list);
	}

	
	/** 
	     * @Title: send 
	     * @Description: 通过事件id查找脉搏信息
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseService#selectElectrocardioPulseByEventId(java.lang.Long)
	     */
	public Oppg selectElectrocardioPulseByEventId(Long eventId) {
		OppgExample example = new OppgExample();
		Criteria criteria = example.createCriteria();
		criteria.andEventidEqualTo(eventId);
		List<Oppg> oppgs = oppgMapper.selectByExample(example);
		
		Oppg oppg = null;
		if(oppgs != null && !oppgs.isEmpty()){
			oppg = oppgs.get(0);
		}
		return oppg;
	}
	
	/** 
	     * @Title: send 
	     * @Description: 新增oppg
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioService#saveOecg()
	     */
	@Override
	public void saveOppg(Oppg oppg) {
		oppg.setDeltag("0");
		oppg.setStatustag((short)0);
		multiOppgMapper.insertOppg(oppg);
		
	}
	
	/**
	     * @Title: send 
	     * @Description: 通过oecg信息查找oppg脉搏信息
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseService#selectOppgByOecg(java.lang.Long)
	 */
	@Override
	public Oppg selectOppgByOecg(Long docentry){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("docentry", docentry);
		return multiOppgMapper.selectOppgByOecg(param);
	} 
	
	/**
	     * @Title: send 
	     * @Description: 统计三合一在某一时间段上的测量数量
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseService#selectElectrocardioPulseMeasTotalCount(java.lang.Integer, java.util.Date, java.util.Date)
	 */
	public Integer selectElectrocardioPulseMeasTotalCount(Integer memberId, Date startTime, Date endTime){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("startTime", startTime);
		param.put("endTime", endTime);
		return multiOppgMapper.selectOecgPulseCount(param);
	}
	
	/**
	     * @Title: send 
	     * @Description: 统计三合一在某一时间段上的测量异常数据数量
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardioPulse.service.PulseService#selectElectrocardioPulseMeasExcCount(java.lang.Integer, java.util.Date, java.util.Date)
	 */
	public Integer selectElectrocardioPulseMeasExcCount(Integer memberId, Date startTime, Date endTime){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("ecgResult", "1");
		param.put("startTime", startTime);
		param.put("endTime", endTime);
		return multiOppgMapper.selectOecgPulseCount(param);
	}
	
	/**
	 * @Title:updatePpgResultOfOppgByEventId 
	 * @Description:根据eventid查询记录，并更新ppgResult字段
	 * @author 陈哲
	 * @param ppgResult
	 * @param eventId 
	 * @throws
	 * @retrun void
	 */
	public void updatePpgResultOfOppgByEventId(int ppgResult, Long eventId){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ppgResult", ppgResult);
		param.put("eventId", eventId);
		multiOppgMapper.updatePpgResultOfOppg(param);
	}
	
	/**
	 * @Title:updateStatusTagOfOppgByEventId 
	 * @Description:根据eventid查询记录，并更新stausTag字段
	 * @author 陈哲
	 * @param statusTag
	 * @param eventId 
	 * @throws
	 * @retrun void
	 */
	public void updateStatusTagOfOppgByEventId(int statusTag, Long eventId){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("statusTag", statusTag);
		param.put("eventId", eventId);
		multiOppgMapper.updateStatusTagOfOppg(param);
	}
}
