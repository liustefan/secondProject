package com.bithealth.taskMgrCore.server.impl;

import java.util.List;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bithealth.taskMgrCore.dao.JobConfigMapper;
import com.bithealth.taskMgrCore.model.JobConfig;
import com.bithealth.taskMgrCore.quartz.QuertzScheduleJob;
import com.bithealth.taskMgrCore.server.IJobConfigService;

/**
 * @ClassName:     JobConfigServiceImpl.java 
 * @Description:   TODO
 * @author         zengxuhua  
 * @version        V1.0   
 * @Date           2015年12月21日 下午4:06:02
 *****/
@Service("jobConfigService")
public class JobConfigServiceImpl implements IJobConfigService {

	@Autowired
	private JobConfigMapper jobConfigMapper;
	
	@Autowired
	QuertzScheduleJob quertzScheduleJob ;
	
	@Override
	public int deleteByPrimaryKey(Integer id) throws SchedulerException {
	    	JobConfig jobConfig	=jobConfigMapper.selectByPrimaryKey(id);
		int i= jobConfigMapper.deleteByPrimaryKey(jobConfig.getId());
		if(i==1){
		    quertzScheduleJob.pauseJob(jobConfig);
		}
		return i;
	}

	@Override
	public int insert(JobConfig record) {
		return jobConfigMapper.insert(record);
	}

	@Override
	public int insertSelective(JobConfig record) throws Exception {
		int i=jobConfigMapper.insertSelective(record);
		if(record.getJobStatus().equals("0")){
		    quertzScheduleJob.startJob(record);
		}
		return i;
	}

	@Override
	public JobConfig selectByPrimaryKey(Integer id) {
		return jobConfigMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<JobConfig> selectAll(int type) {
		return jobConfigMapper.selectAll(type);
	}

	/** 
	 * @Title: updateByPrimaryKeySelective 
	 * @Description: TODO 
	 * @param:     
	 * @return:      
	 * @throws
	 * @throws SchedulerException 
	 */
	@Override
	public int updateByPrimaryKeySelective(JobConfig record) throws SchedulerException {
	    	int i=jobConfigMapper.updateByPrimaryKeySelective(record);
        	    if(1==i&&record.getJobStatus().equals("0")){
        	    	    quertzScheduleJob.pauseJob(record);
        	    	    quertzScheduleJob.startJob(record);
        	    	// TODO 跟新定时任务的执行规则
        		//  quertzScheduleJob.rescheduleJob(record);
        	    }else if(record.getJobStatus().equals("1")){
        		  quertzScheduleJob.pauseJob(record);
        	    }
	    return i;
	}

	@Override
	public int updateByPrimaryKey(JobConfig record) throws SchedulerException {
		int i=jobConfigMapper.updateByPrimaryKey(record);
		if(1==i&&record.getJobStatus().equals("0")){
	    	    quertzScheduleJob.pauseJob(record);
	    	    quertzScheduleJob.startJob(record);
	    	}else if(record.getJobStatus().equals("1")){
  		  quertzScheduleJob.pauseJob(record);
    	    }
		return i;
	}

	

}
