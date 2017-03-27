package com.bithealth.dataConversionServer.qiangHua.thread;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bithealth.dataConversionServer.dataSource.DataSourceSwitch;
import com.bithealth.dataConversionServer.qiangHua.bean.TdiabetesVisits;
import com.bithealth.dataConversionServer.qiangHua.service.IPhDiabetesService;
import com.bithealth.dataConversionServer.qiangHua.service.ITdiabetesVisitsService;
import com.bithealth.dataConversionServer.util.Constants;
import com.bithealth.dataConversionServer.util.SystemUtils;
import com.bithealth.dataConversionServer.util.XmlUtil;




/*
 * 糖尿病随访
 */
@Component
@Service("diabetesVisitsTask")
public class DiabetesVisitsTask {
    
    private Logger logger = Logger.getLogger(DiabetesVisitsTask.class);
	@Autowired
	private ITdiabetesVisitsService tdiabetesVisitsService;
	@Autowired
	private IPhDiabetesService phDiabetesService;

	private List<TdiabetesVisits> lists  = new ArrayList<TdiabetesVisits>();
	
	
	public void saveDiabetesVisitsData(){
	    try{
	    int  num =Integer.parseInt(SystemUtils.getValue(Constants.QH_EVERY_TIME_NUM));
	    //将数据源切换到强华数库
	    DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_3);
	    long count=tdiabetesVisitsService.selectByCount();// 查询的总数
	    int times=XmlUtil.getTimes(num, count);
	    for(int i=0;i<times;i++){
		lists=tdiabetesVisitsService.select(num);
		DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_1);
		if(lists.size()>0|| lists!=null){
		    for(int j=0;j<lists.size();j++){
			  int state = 0;
			TdiabetesVisits tdiabetesVisits= lists.get(j);
			try{
				boolean fla=phDiabetesService.saveAll(tdiabetesVisits);
			    System.out.println("==========fla:"+fla);
			    if(fla==false) state=1; else state=0;
			}catch(Exception e){
			    e.printStackTrace();
			}finally{
			    TdiabetesVisits  tdiabetes= new TdiabetesVisits();
			    tdiabetes.setDiabGid(tdiabetesVisits.getDiabGid());//DIAB_GID
			    tdiabetes.setHrGid(tdiabetesVisits.getHrGid());
			    tdiabetes.setDataFlag(String.valueOf(state));
			    DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_3);
			    tdiabetesVisitsService.update(tdiabetes);
			    DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_1);
			}
		    }
		}else{
		    logger.error("获取数据为空或为异常！");
		}
	    }

	    }catch(Exception e){
		e.printStackTrace();
	    }
	}
	
	

}