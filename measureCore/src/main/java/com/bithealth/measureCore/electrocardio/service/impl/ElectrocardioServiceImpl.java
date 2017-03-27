 
/**
 * @PackageName:      com.bithealth.measureCore.electrocardio.service.impl
 * @FileName:     ElectrocardioServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月11日 下午5:48:00  
 * 
 */

package com.bithealth.measureCore.electrocardio.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bithealth.measureCore.common.model.Omds;
import com.bithealth.measureCore.electrocardio.dao.MultiOecgMapper;
import com.bithealth.measureCore.electrocardio.dao.OecgMapper;
import com.bithealth.measureCore.electrocardio.model.Ecg1;
import com.bithealth.measureCore.electrocardio.model.Ecg2;
import com.bithealth.measureCore.electrocardio.model.Ecg2Chart;
import com.bithealth.measureCore.electrocardio.model.Ecg3;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardio.model.OecgExample;
import com.bithealth.measureCore.electrocardio.model.OecgExample.Criteria;
import com.bithealth.measureCore.electrocardio.model.OecgOmemVO;
import com.bithealth.measureCore.electrocardio.service.Ecg1Service;
import com.bithealth.measureCore.electrocardio.service.Ecg2Service;
import com.bithealth.measureCore.electrocardio.service.Ecg3Service;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioService;
import com.bithealth.sdk.core.feature.orm.mybatis.Page;
import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.sdk.core.generic.GenericBaseServiceImpl;


/**
 * 类名称: ElectrocardioServiceImpl  
 * 功能描述:动态心电接口实现 
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月11日 下午5:48:00 
 * 
 * @author 陈哲
 * @version  
 */
@Service
public class ElectrocardioServiceImpl extends GenericBaseServiceImpl<Oecg,OecgExample,Long> 
		implements ElectrocardioService{
	
	@Resource 
	OecgMapper oecgMapper;
	
	@Resource
	MultiOecgMapper multiOecgMapper;
	
	@Resource
	Ecg1Service ecg1Service;
	
	@Resource
	Ecg2Service ecg2Service;
	
	@Resource
	Ecg3Service ecg3Service;
    
   @Override
   public GenericBaseDao<Oecg,OecgExample,  Long > getDao() {
       return oecgMapper;
   }

	/** 
	     * @Title: send 
	     * @Description: 根据自定义条件查找心电测量信息以及相关的会员部分信息，并分页
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioService#selectElectrocardioAndMemListPage(int, int, java.lang.String, java.lang.Integer, java.lang.String)
	     */
	public Page<OecgOmemVO> selectElectrocardioAndMemListPage(int pageNo, int pageSize,
			String criteria, Integer docid, String wheAbnTag) {
		Page<OecgOmemVO> page = new Page<OecgOmemVO>(pageNo, pageSize);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("docId", docid);
		if(criteria != null && !"".equals(criteria.trim())){
			param.put("criteria", "%"+criteria.trim()+"%");
		}
		param.put("wheAbnTag", wheAbnTag);
		multiOecgMapper.selectOecgListAndPage(page, param);
		return page;
	}

	
	/**
	     * @Title: send 
	     * @Description: TODO 简单描述该方法的实现功能（可选）.
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioService#selectElectrocardioAndPage(java.lang.Integer, int, int, java.util.Date, java.util.Date)
	 */
	@Override
	public Page<Oecg> selectElectrocardioAndPage(Integer memberId, int pageNo, int pageSize, Date startTime, Date endTime) {
		Page<Oecg> page = new Page<Oecg>(pageNo, pageSize);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("startTime", startTime);
		param.put("endTime", endTime);
		multiOecgMapper.selectOecgAndPage(page, param);
		return page;
	}
	
	
	
	
	/** 
	     * @Title: send 
	     * @Description: 通过会员id查找心电测量记录信息
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioService#selectElectrocardioListByMemberId(java.lang.Integer, java.lang.String)
	     */
	public List<Oecg> selectElectrocardioListByMemberId(Integer memberId,
			String eventType) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("eventType", eventType);
		param.put("delTag", "0");
	
		return multiOecgMapper.selectOecgOmdsList(param);
	}
	
	
	/** 
	     * @Title: send 
	     * @Description: 通过事件id查找心电信息
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioService#selectElectrocardioByEventId(java.lang.Long)
	     */
	public Oecg selectElectrocardioByEventId(Long eventId) {
		OecgExample example = new OecgExample();
		Criteria criteria = example.createCriteria();
		criteria.andEventidEqualTo(eventId);
		List<Oecg> oecgs = oecgMapper.selectByExample(example);
		
		Oecg oecg = null;
		if(oecgs != null && !oecgs.isEmpty()){
			oecg = oecgs.get(0);
		}
		return oecg;
	}

	
	/** 
	     * @Title: send 
	     * @Description: TODO 简单描述该方法的实现功能（可选）.
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioService#selectElectrocardioByDocentry(java.lang.Long)
	     */
	public Oecg selectElectrocardioByDocentry(Long docentry) {
		
		// TODO Auto-generated method stub
		return oecgMapper.selectByPrimaryKey(docentry);
	}
	

	/** 
	     * @Title: send 
	     * @Description: 逻辑删除心电信息
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioService#deleteElectrocardio(java.lang.Long)
	     */
	@Override
	public void deleteElectrocardio(Long docentry) {
		Oecg oecg = new Oecg();
		oecg.setDeltag("1");
		oecg.setDocentry(docentry);
		oecgMapper.updateByPrimaryKeySelective(oecg);
	}
	
	/**
	 * @Title:deleteBatchElectrocardio 
	 * @Description:批量删除心电信息（逻辑删除） 
	 * @author 陈哲
	 * @param docentrys 
	 * @throws
	 * @retrun void
	 */
	@Override
	public void deleteBatchElectrocardio(List<Long> docentrys){
		Oecg oecg = new Oecg();
		oecg.setDeltag("1");
		
		OecgExample example = new OecgExample();
		Criteria criteria = example.createCriteria();
		criteria.andDocentryIn(docentrys);
		oecgMapper.updateByExampleSelective(oecg, example);
	}

	/** 
	     * @Title: send 
	     * @Description: 通过docentry查找心电异常详细信息.
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioService#selectElectrocardioiExcListByDocentry(java.lang.Long)
	     */
	public List<Ecg1> selectElectrocardioExcListByDocentry(Long docentry) {
		
		return ecg1Service.selectEcg1ListByDocentry(docentry);
	}
	
	
	/** 
	     * @Title: send 
	     * @Description: TODO 通过docentry查找心电类型统计信息
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioService#selectElectrocardioiExcStatisListByDocentry(java.lang.Long)
	     */
	public List<Ecg2> selectElectrocardioExcStatisListByDocentry(Long docentry) {
		
		return ecg2Service.selectEcg2ListByDocentry(docentry);
	}
	

	/** 
	     * @Title: send 
	     * @Description: TODO 通过docentry查找ecg3逻辑删除的异常信息
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioService#selectElectrocardioiDelListByDocentry(java.lang.Long)
	     */
	public List<Ecg3> selectElectrocardioDelListByDocentry(Long docentry) {
		
		return ecg3Service.selectEcg3ListByDocentry(docentry);
	}

	/** 
	     * @Title: send 
	     * @Description: TODO 24小时异常心电分布图数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioService#selectElectrocardioExcTrendChartData(java.lang.Integer, int)
	     */
	public List<Ecg2Chart> selectElectrocardioExcTrendChartData(
			Integer memberId, int reportNo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("reportNo", reportNo);
		
		return multiOecgMapper.selectOecgExcTrendChart(param);
	}
	
	public List<Ecg2Chart> selectElectrocardioExcTrendChartData(List<Oecg> oecgs) {
		List<Long> list = new ArrayList<Long>();
		for(Oecg oecg : oecgs){
			list.add(oecg.getDocentry());
		}
		
		return multiOecgMapper.selectOecgExcTrendChart1(list);
	}

	/** 
	     * @Title: send 
	     * @Description: 异常心电柱状图数据
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioService#selectElectrocardioExcBarChartData(java.lang.Integer, int)
	     */
	public List<Ecg2Chart> selectElectrocardioExcBarChartData(Integer memberId,
			int reportNo) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("reportNo", reportNo);
		
		return multiOecgMapper.selectOecgExcBarChart(param);
	}
	
	public List<Ecg2Chart> selectElectrocardioExcBarChartData(List<Oecg> oecgs) {
		List<Long> list = new ArrayList<Long>();
		for(Oecg oecg : oecgs){
			list.add(oecg.getDocentry());
		}
		
		return multiOecgMapper.selectOecgExcBarChart1(list);
	}

	
	/** 
	     * @Title: send 
	     * @Description: 查找测量记录信息
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioService#selectMeasureRecordByElectro(java.lang.Integer)
	     */
	public List<Omds> selectMeasureRecordByElectro(Integer memberId) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		
		return multiOecgMapper.selectOmdsByOecg(param);
	}

	
	/** 
	     * @Title: send 
	     * @Description: 查找最新的一条测量记录omds
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioService#selectLastMeasureRecordByElectro(java.lang.Integer)
	     */
	public Omds selectLastMeasureRecordByElectro(Integer memberId) {
		List<Omds> omdsList = selectMeasureRecordByElectro(memberId);
				
		Omds omds = null;
		if(omdsList != null && !omdsList.isEmpty()){
			omds = omdsList.get(0);
		}
		
		return omds;
	}

	
	/** 
	     * @Title: send 
	     * @Description: 新增心电信息，生成docentry主键值
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioService#generateDocentry()
	     */
	@Override
	public Long generateDocentry() {
		Long docentry = multiOecgMapper.selectMaxDocentry();
		return docentry;
	}

	/** 
	     * @Title: send 
	     * @Description: 保存心电信息
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioService#saveOecg()
	     */
	@Override
	public void saveOecg(Oecg oecg) {
		oecg.setDeltag("0");
		oecg.setStatustag((short)0);
		multiOecgMapper.insertOecg(oecg);
		
	}
	
	/**
	     * @Title: send 
	     * @Description: 更新心电分析结果
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioService#updateOecgByDocentry(int, long)
	 */
	public void updateEcgResultOfOecgByDocentry(int ecgResult, long docentry){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ecgResult", ecgResult);
		param.put("docentry", docentry);		
		
		multiOecgMapper.updateEcgResultOfOecg(param);
	}
	
	/**
	 * @Title:updateStatusTagOfOecgByDocentry 
	 * @Description:根据docentry查询记录，更新statusTag字段
	 * @author 陈哲
	 * @param statusTag
	 * @param docentry 
	 * @throws
	 * @retrun void
	 */
	public void updateStatusTagOfOecgByDocentry(int statusTag, long docentry){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("statusTag", statusTag);
		param.put("docentry", docentry);		
		
		multiOecgMapper.updateStatusTagOfOecg(param);
	}
	
	/**
	     * @Title: send 
	     * @Description: 统计动态心电某一时间段的总数量
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioService#selectElectrocardioMeasTotalCount(java.lang.Integer, java.util.Date, java.util.Date)
	 */
	public Integer selectElectrocardioMeasTotalCount(Integer memberId, Date startTime, Date endTime){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("startTime", startTime);
		param.put("endTime", endTime);
		return multiOecgMapper.selectOecgCount(param);
	}
	
	/**
	     * @Title: send 
	     * @Description: 统计动态心电某一时间段的异常心电数量
	     * @param  
	     * @throws      
	     * @retrun  
	     *  @see com.bithealth.measureCore.electrocardio.service.ElectrocardioService#selectElectrocardioMeasExcCount(java.lang.Integer, java.util.Date, java.util.Date)
	 */
	public Integer selectElectrocardioMeasExcCount(Integer memberId, Date startTime, Date endTime){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("memberId", memberId);
		param.put("ecgResult", "1");
		param.put("startTime", startTime);
		param.put("endTime", endTime);
		return multiOecgMapper.selectOecgCount(param);
	}
	
	
	/**
	 * @Title:findOecgByRawImg 
	 * @Description:判断动态心电是否由web端上传 
	 * @author 陈哲
	 * @param rawImage
	 * @return 
	 * @throws
	 * @retrun boolean
	 */
	public boolean findOecgByRawImg(String rawImage){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("rawEcg", rawImage);
		Oecg oecg = multiOecgMapper.selectOecgByRawEcg(param);
		if(oecg == null){
			return false;
		}
		return true;
	}
}

