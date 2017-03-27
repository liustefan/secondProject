 
/**
 * @PackageName:      com.bithealth.measureCore.electrocardio.service.impl
 * @FileName:     ElectrocardioExcServiceImpl.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      陈哲 
 * @version      V1.0  
 * @Createdate:  2016年7月15日 上午9:52:59  
 * 
 */

package com.bithealth.measureCore.electrocardio.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.measureCore.electrocardio.model.Ecg1;
import com.bithealth.measureCore.electrocardio.model.Ecg2;
import com.bithealth.measureCore.electrocardio.model.Oecg;
import com.bithealth.measureCore.electrocardio.model.OecgExc;
import com.bithealth.measureCore.electrocardio.service.Ecg1Service;
import com.bithealth.measureCore.electrocardio.service.Ecg2Service;
import com.bithealth.measureCore.electrocardio.service.Ecg3Service;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioExcService;
import com.bithealth.measureCore.electrocardio.service.ElectrocardioFileService;
import com.bithealth.measureCore.enmu.ElectrocardioType;


/**
 * 类名称: ElectrocardioExcServiceImpl  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年7月15日 上午9:52:59 
 * 
 * @author 陈哲
 * @version  
 */
@Service
public class ElectrocardioExcServiceImpl implements ElectrocardioExcService{
	private final static Logger logger = Logger.getLogger(ElectrocardioExcServiceImpl.class);
	
	@Autowired
	private Ecg1Service ecg1Service;
	
	@Autowired
	private Ecg2Service ecg2Service;
	
	@Autowired
	private Ecg3Service ecg3Service;
	
	@Autowired
	private ElectrocardioFileService electrocardioFileService;
	

	public List<OecgExc> doElectrocardioExcInfo(List<Ecg1> ecg1s, List<Ecg2> ecg2s, Oecg oecg){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<OecgExc> oecgExcList = new ArrayList<OecgExc>();
		
		long time = oecg.getMeastime().getTime();
		for(Ecg2 e2 : ecg2s){
			List<Long> excMsList = new ArrayList<Long>();
			List<String> excTimeStrList = new ArrayList<String>(); 
			List<String> objectIdList = new ArrayList<String>();
			
			OecgExc oecgExc = new OecgExc();
			String name = e2.getAbnname();
			String cname = null;
			for(Ecg1 e1 : ecg1s){
				String[] abEcgType = e1.getAbecgtype().split(",")[0].split(":");
				cname = ElectrocardioType.getTypeChinaName(name, abEcgType[0]);
				
				if(cname != null){
					oecgExc.setExpName(ElectrocardioType.getTypeEcg1Name(name));
					oecgExc.setExpCname(cname);
					int ext = e1.getAbecgtime();
					int dataPoint = Integer.parseInt(abEcgType[1]);
					int startMs = (int) (((float) dataPoint / oecg.getFs()) * 1000);
					long extMs = ext * 1000 + startMs + time;
					
					excMsList.add(extMs);
					excTimeStrList.add("'"+dateFormat.format(time+ext*1000)+"'");
					objectIdList.add("'"+e1.getObjectid()+"'");
				}
				oecgExc.setExtMss(excMsList);
				oecgExc.setExtimes(excTimeStrList);
				oecgExc.setObjectIds(objectIdList);
			}
			
			Integer abnnum = e2.getAbnnum();
			oecgExc.setExpNum(abnnum);
			if (oecg.getHeartnum() > 0) {
				oecgExc.setExpRate((float) (abnnum * 1.0f) * 100/ (oecg.getHeartnum() * 1.0f));
			}
			oecgExcList.add(oecgExc);
		}
		
		return doNoExcOtherType(oecgExcList);
	}
	
	
	/**
	 * @Title:doNoExcOtherType
	 * @Description:将没有异常类型的心电装进List<OecgExc>集合中
	 * @author 陈哲
	 * @param oecgExcList
	 * @return 
	 * @throws
	 * @retrun List<OecgExc>
	 */
	private List<OecgExc> doNoExcOtherType(List<OecgExc> oecgExcList){
		List<String> excTypes = new ArrayList<String>();
		for(ElectrocardioType type : ElectrocardioType.values()){
			excTypes.add(type.getChinaName());
		}
		
		for(OecgExc oecgExc : oecgExcList){
			excTypes.remove(oecgExc.getExpCname());
		}
		
		for(String str : excTypes){
			OecgExc exc = new OecgExc();
			exc.setExpCname(str);
			exc.setExpNum(0);
			exc.setExpRate(0);
			oecgExcList.add(exc);
		}
		
		return oecgExcList;
	}
	
	/**
	 * @Title:deleteExcElectrocardio 
	 * @Description:通过docentry删除异常心电信息
	 * @author 陈哲
	 * @param docentry 
	 * @throws
	 * @retrun void
	 */
	public Integer deleteExcElectrocardio(Long docentry){
		ecg1Service.deleteEcg1Bydocentry(docentry);
		ecg2Service.deleteEcg2ByDocentry(docentry);
		ecg3Service.deleteEcg3ByDocentry(docentry);
		return 1;
	}
	
	/**
	 * @Title:getElectrocardioExcTime 
	 * @Description:异常心电的异常时间段，单位毫秒
	 * @author 陈哲
	 * @param objectId
	 * @param oecg
	 * @return 
	 * @throws
	 * @retrun int
	 */
	public int getElectrocardioExcTimeP(String objectId, Oecg oecg){
		byte[] data = null;
		try {
			data = electrocardioFileService.getFile(false, objectId);
		} catch (Exception e) {
			logger.error("读取异常心电文件失败！"+e.getMessage());
		}
		
		int period = 0;
		if(data != null){
			String dataStr = new String(data);
			int dataPoint = dataStr.split("\n").length;
			period = (int) (((float)dataPoint / oecg.getFs()) * 1000);
		}
		
		return period;
	}

}

