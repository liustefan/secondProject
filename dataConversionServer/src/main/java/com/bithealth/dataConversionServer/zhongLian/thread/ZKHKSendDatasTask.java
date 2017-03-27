package com.bithealth.dataConversionServer.zhongLian.thread;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.dataConversionServer.dao.CenterConfigMapper;
import com.bithealth.dataConversionServer.dao.DataCenterAreaConfigMapper;
import com.bithealth.dataConversionServer.dataSource.DataSourceSwitch;
import com.bithealth.dataConversionServer.enmu.CompanyConfigEnmu;
import com.bithealth.dataConversionServer.enmu.OperationEnmu;
import com.bithealth.dataConversionServer.enmu.OperationEnmuForGoodDoctor;
import com.bithealth.dataConversionServer.model.DataCenterAreaConfig;
import com.bithealth.dataConversionServer.model.DataFileRelation;
import com.bithealth.dataConversionServer.service.DataSendService;
import com.bithealth.dataConversionServer.util.Constants;
import com.bithealth.dataConversionServer.util.TimeUtil;




/**
 * @ClassName:     zkhkSendDatasTask.java 
 * @Description:   中科汇康发送高血压,糖尿病,血糖,血压,健康体检定时任务
 * @author         liuxiaoqin  
 * @version        V1.0   
 * @Date           2015年12月25日 上午10:00:40
*****/
@Service("zkhkSendDatasTask")
public class ZKHKSendDatasTask {
    
	private static Logger logger = Logger.getLogger(ZKHKSendDatasTask.class);
	
	@Resource(name="dataSendService")  
    private DataSendService dataSendService;
	@Autowired
    private CenterConfigMapper centerConfigDao;
	
	@Autowired
    private DataCenterAreaConfigMapper areaConfigDao;
	
	
	
	 /** 
	 * @Title: SendDataToZLJY 
	 * @Description: 发送测量体检数据到合作公-司中联佳裕 
	 *     
	 * @retrun void
	 */
	public void SendDataToZLJY(){
		try {
			ZKHKSendDatas(CompanyConfigEnmu.COMPANY_ZLJY);
		} catch (Exception e) {
			logger.error("发送测量体检数据到合作公司-中联佳裕异常");
		}
	}
	
	 /** 
	 * @Title: SendDataToGoodDoctor 
	 * @Description: 发送测量体检数据到合作公司-好医生 
	 *     
	 * @retrun void
	 */
	public void SendDataToGoodDoctor(){
		try {
			ZKHKSendDatas(CompanyConfigEnmu.COMPANY_GOOD_DOCTOR);
		} catch (Exception e) {
			logger.error("发送测量体检数据到合作公司-好医生异常");
		}
	}
	
	
	
	/** 
     * @Title: ZKHKSendDatas 
     * @Description: 中科汇康发送高血压随访,糖尿病随访,健康体检,血糖,血压,脉搏数据
     * @throws Exception    
     * @retrun void
     */
    public void ZKHKSendDatas(CompanyConfigEnmu companyEnmu) throws Exception{
        Date startTime;//本次定时任务开始发送测量数据的起始时间
        DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_2);
        List<DataCenterAreaConfig> areaConfigList = areaConfigDao.queryAreaConfigByParam(companyEnmu.getSource());
        for(DataCenterAreaConfig areaConfig : areaConfigList){
        	int differDays = TimeUtil.differDays(areaConfig.getLastSendTime(), new Date());
        	if(differDays > 0) {
        		for(int i = 1; i < differDays; i++) {
        			//startTime = TimeUtil.addTimeByDate(1, areaConfig.getLastSendTime()) ;
        			SimpleDateFormat datetimeFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        			startTime = datetimeFormat2.parse("2015-07-22 00:00:00");
                    queryAndsendData(startTime, areaConfig.getAreaId(),companyEnmu);
                    //更新下次查询的时间
                    DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_2);
                    areaConfig.setLastSendTime(startTime);
                    areaConfigDao.updateLastSendTime(areaConfig);
        		}
        	}
        }
    }

     /** 
     * @Title: queryAndsendData 
     * @Description: 根据时间和区域获取该区域的会员测量数据 
     * @param startTime
     * @param prgid
     * @throws Exception    
     * @retrun void
     */
    private void queryAndsendData(Date startTime,String prgid,CompanyConfigEnmu companyEnmu) throws Exception{
    	
        //获取要发送的血糖数据xml字符串list
        DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_1);
        List<DataFileRelation> bloodGlucoses = dataSendService.getBloodGlucoseXmlStrs(startTime,prgid,companyEnmu.getSource());
        if(!isEmpty(bloodGlucoses)){
            DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_2);//将数据源切换到数据收发服务数据库         
            String opt = "";
            if(CompanyConfigEnmu.COMPANY_ZLJY.getCompanyCode() == companyEnmu.getCompanyCode()){
            	opt = OperationEnmu.ZLJY_OPERATION_6.getValue();
            }else if(CompanyConfigEnmu.COMPANY_GOOD_DOCTOR.getCompanyCode() == companyEnmu.getCompanyCode()){
            	opt = OperationEnmuForGoodDoctor.ZLJY_OPERATION_5.getValue();
            }
            dataSendService.saveRelationAndSendMsgToMq(bloodGlucoses,opt,companyEnmu.getCompanyCode());
            logger.info("组装["+TimeUtil.formatDate(startTime)+"] 血糖数据成功。");
        }else{
        	logger.info("无["+TimeUtil.formatDate(startTime)+"]这一天的"+companyEnmu.getDesc()+"会员血糖测量信息");
        }
        
        //获取要发送血压数据
        DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_1);
        List<DataFileRelation> bloodPressureList = dataSendService.getBloodPressureXmlStrs(startTime,prgid,companyEnmu.getSource());
        if(!isEmpty(bloodPressureList)){
        	DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_2);//将数据源切换到数据收发服务数据库
            String opt = "";
            if(CompanyConfigEnmu.COMPANY_ZLJY.getCompanyCode() == companyEnmu.getCompanyCode()){
            	opt = OperationEnmu.ZLJY_OPERATION_5.getValue();
            }else if(CompanyConfigEnmu.COMPANY_GOOD_DOCTOR.getCompanyCode() == companyEnmu.getCompanyCode()){
            	opt = OperationEnmuForGoodDoctor.ZLJY_OPERATION_4.getValue();
            }
            dataSendService.saveRelationAndSendMsgToMq(bloodPressureList,opt,companyEnmu.getCompanyCode());
            logger.info("组装["+TimeUtil.formatDate(startTime)+"] 血压数据成功。");
        }else{
        	logger.info("无["+TimeUtil.formatDate(startTime)+"]这一天的"+companyEnmu.getDesc()+"会员血压，脉搏测量信息！");
        }
       
        //获取要发送的糖尿病随访xml字符串list 
        DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_1);
        List<DataFileRelation> diabetesVisitsXmlStrsList = dataSendService.getDiabetesVisitsXmlStrs(startTime,prgid,companyEnmu.getSource());
        if(!isEmpty(diabetesVisitsXmlStrsList)){
            DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_2);//将数据源切换到数据收发服务数据库
            String opt = "";
            if(CompanyConfigEnmu.COMPANY_ZLJY.getCompanyCode() == companyEnmu.getCompanyCode()){
            	opt = OperationEnmu.ZLJY_OPERATION_7.getValue();
            }else if(CompanyConfigEnmu.COMPANY_GOOD_DOCTOR.getCompanyCode() == companyEnmu.getCompanyCode()){
            	opt = OperationEnmuForGoodDoctor.ZLJY_OPERATION_6.getValue();
            }
            dataSendService.saveRelationAndSendMsgToMq(diabetesVisitsXmlStrsList,opt,companyEnmu.getCompanyCode()); 
            logger.info("组装["+TimeUtil.formatDate(startTime)+"] 随访糖尿病数据成功。");
        }else{
        	logger.info("无["+TimeUtil.formatDate(startTime)+"]这一天的"+companyEnmu.getDesc()+"会员随访糖尿病数据！");
        }
        
        //获取要发送高血压随访的xml字符串list
        DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_1);
        List<DataFileRelation> hypertensionVisitsXmlStrsList = dataSendService.getHypertensionVisitsXmlStrs(startTime,prgid,companyEnmu.getSource());
        if(!isEmpty(hypertensionVisitsXmlStrsList)){
            DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_2);//将数据源切换到数据收发服务数据库
            String opt = "";
            if(CompanyConfigEnmu.COMPANY_ZLJY.getCompanyCode() == companyEnmu.getCompanyCode()){
            	opt = OperationEnmu.ZLJY_OPERATION_8.getValue();
            }else if(CompanyConfigEnmu.COMPANY_GOOD_DOCTOR.getCompanyCode() == companyEnmu.getCompanyCode()){
            	opt = OperationEnmuForGoodDoctor.ZLJY_OPERATION_7.getValue();
            }
            dataSendService.saveRelationAndSendMsgToMq(hypertensionVisitsXmlStrsList,opt,companyEnmu.getCompanyCode());
            logger.info("组装["+TimeUtil.formatDate(startTime)+"] 随访高血压据成功。");
        }else{
        	logger.info("无["+TimeUtil.formatDate(startTime)+"]这一天的"+companyEnmu.getDesc()+"会员随访高血压数据！");
        }
        
        //获取要发送健康体检的xml字符串list
        DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_1);
        List<DataFileRelation> healthExamsXmlStrsList = dataSendService.getHealthExamsXmlStrs(startTime,prgid,companyEnmu.getSource());
        if(!isEmpty(healthExamsXmlStrsList)){
            DataSourceSwitch.setDataSourceType(Constants.DATA_SOURCE_2);//将数据源切换到数据收发服务数据库
            String opt = "";
            if(CompanyConfigEnmu.COMPANY_ZLJY.getCompanyCode() == companyEnmu.getCompanyCode()){
            	opt = OperationEnmu.ZLJY_OPERATION_3.getValue();
            }else if(CompanyConfigEnmu.COMPANY_GOOD_DOCTOR.getCompanyCode() == companyEnmu.getCompanyCode()){
            	opt = OperationEnmuForGoodDoctor.ZLJY_OPERATION_3.getValue();
            }
            dataSendService.saveRelationAndSendMsgToMq(healthExamsXmlStrsList,opt,companyEnmu.getCompanyCode());
            logger.info("组装["+TimeUtil.formatDate(startTime)+"] 体检数据成功。");
        }else{
        	logger.info("无["+TimeUtil.formatDate(startTime)+"]这一天的会员体检数据！");
        }
    }
    
    @SuppressWarnings("rawtypes")
	private boolean isEmpty(List list){
    	if(list != null && list.size() > 0){
    		return false;
    	}else{
    		return true;
    	}
    }
}
