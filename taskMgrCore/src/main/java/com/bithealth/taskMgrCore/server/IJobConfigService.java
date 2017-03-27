package com.bithealth.taskMgrCore.server;

import java.util.List;

import org.quartz.SchedulerException;

import com.bithealth.taskMgrCore.model.JobConfig;
 

/**
 * @ClassName:     IJobConfigService.java 
 * @Description:   TODO
 * @author         zengxuhua  
 * @version        V1.0   
 * @Date           2015年12月21日 下午4:05:08
 *****/
public interface IJobConfigService {

	
    int deleteByPrimaryKey(Integer id)throws SchedulerException;
    
    int insert(JobConfig record)throws SchedulerException;

    int insertSelective(JobConfig record) throws Exception;

    JobConfig selectByPrimaryKey(Integer id);
   
    List<JobConfig> selectAll(int type);
   
    int updateByPrimaryKeySelective(JobConfig record) throws SchedulerException;

    int updateByPrimaryKey(JobConfig record) throws SchedulerException;
}
