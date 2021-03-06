package com.bithealth.taskMgrCore.dao;
 
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bithealth.sdk.core.generic.GenericBaseDao;
import com.bithealth.taskMgrCore.model.JobConfig;
import com.bithealth.taskMgrCore.model.JobConfigExample;

public interface JobConfigMapper extends GenericBaseDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_job_config
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    int countByExample(JobConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_job_config
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    int deleteByExample(JobConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_job_config
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_job_config
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    int insert(JobConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_job_config
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    int insertSelective(JobConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_job_config
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    List<JobConfig> selectByExample(JobConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_job_config
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    JobConfig selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_job_config
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    int updateByExampleSelective(@Param("record") JobConfig record, @Param("example") JobConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_job_config
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    int updateByExample(@Param("record") JobConfig record, @Param("example") JobConfigExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_job_config
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    int updateByPrimaryKeySelective(JobConfig record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data_center_job_config
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    int updateByPrimaryKey(JobConfig record);
    
    
    List<JobConfig> selectAll(int type);
    
    
    JobConfig selectByPrimaryName(String name);
}