package com.bithealth.dataConversionServer.qiangHua.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





import com.bithealth.dataConversionServer.dataSource.DataSourceSwitch;
import com.bithealth.dataConversionServer.qiangHua.bean.ThypertensionVisits;
import com.bithealth.dataConversionServer.qiangHua.dao.ThypertensionVisitsMapper;
import com.bithealth.dataConversionServer.qiangHua.service.HypertensionService;
import com.bithealth.dataConversionServer.util.Constants;
import com.bithealth.dataConversionServer.util.SystemUtils;




@Service("hypertensionVisitsTask")
public class HypertensionVisitsTask {
	
	private Logger logger = Logger.getLogger(HypertensionVisitsTask.class);
	
	@Autowired
	private ThypertensionVisitsMapper thypertensionVisitsMapper;
	
	@Autowired
	private HypertensionService hypertensionServiceImpl;
	
	public void getHypertensionVisits() {
		try{
	        //将数据源切换到强华数库
	        DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_3);
	        int count = thypertensionVisitsMapper.queryHypertensionVisitsCount(null);
	        if(count == 0) {
	        	return;
	        }
	        Map<String, Object> param = new HashMap<String, Object>();
	        int pageSize = SystemUtils.getInt(Constants.QH_EVERY_TIME_NUM);
	        param.put(Constants.PAGE_SIZE_KEY, pageSize <= 0 ? 500 : pageSize);
	        int totalPage = (count % pageSize) == 0 ? (count/pageSize) : (count/pageSize + 1);
	        for(int cur = 1; cur <= totalPage; cur++) {
	        	List<ThypertensionVisits>  hyperVisitsList = thypertensionVisitsMapper.queryThypertensionVisits(param);
	        	if(hyperVisitsList == null || hyperVisitsList.size() == 0) {
	        	    logger.error("查询强华高血压随访数据没有更新。");
	 	        	break;
	 	        } else {
	 	        	savePhHyper(hyperVisitsList);	 	        	
	 	        }
	        }
	        logger.info("同步强华随访高血压数据定时任务完成。");
		}catch(Exception e){
			logger.error("定时从强华数据库获取数据入库异常，"+e);
		}
	}
	
	private void savePhHyper(List<ThypertensionVisits>  hyperVisitsList) {
		List<String> suctList = new ArrayList<String>();
		List<String> errtList = new ArrayList<String>();
     	DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_1);
     	for(ThypertensionVisits visit : hyperVisitsList) {
     		if(hypertensionServiceImpl.saveHypertension(visit) > 0) {
     			suctList.add(visit.getHypeGid());
     		} else {
     			errtList.add(visit.getHypeGid());
     		}
     	}
     	DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_3);
     	Map<String, Object> param = new HashMap<String, Object>();
     	
     	if(suctList.size() > 0) {
     		param.put("dataFlag", 0 + "");
         	param.put("dataList", suctList);
         	thypertensionVisitsMapper.updateDataFlag(param);
     	}
     	
     	if(errtList.size() > 0) {
     		param.put("dataFlag", 2 + "");
         	param.put("dataList", errtList);
         	thypertensionVisitsMapper.updateDataFlag(param);
     	}
	}
	

}