package com.bithealth.dataConversionServer.model;

import javax.persistence.Entity;

import com.bithealth.sdk.core.generic.GenericModel;

@Entity
public class JobConfig extends GenericModel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_job_config.id
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_job_config.job_id
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    private String jobId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_job_config.job_time_expression
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    private String jobTimeExpression;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_job_config.job_name
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    private String jobName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_job_config.job_status
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    private String jobStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_job_config.job_desc
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    private String jobDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_job_config.job_type
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    private Integer jobType;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_job_config.id
     *
     * @return the value of data_center_job_config.id
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_job_config.id
     *
     * @param id the value for data_center_job_config.id
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_job_config.job_id
     *
     * @return the value of data_center_job_config.job_id
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    public String getJobId() {
        return jobId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_job_config.job_id
     *
     * @param jobId the value for data_center_job_config.job_id
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_job_config.job_time_expression
     *
     * @return the value of data_center_job_config.job_time_expression
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    public String getJobTimeExpression() {
        return jobTimeExpression;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_job_config.job_time_expression
     *
     * @param jobTimeExpression the value for data_center_job_config.job_time_expression
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    public void setJobTimeExpression(String jobTimeExpression) {
        this.jobTimeExpression = jobTimeExpression;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_job_config.job_name
     *
     * @return the value of data_center_job_config.job_name
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_job_config.job_name
     *
     * @param jobName the value for data_center_job_config.job_name
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_job_config.job_status
     *
     * @return the value of data_center_job_config.job_status
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    public String getJobStatus() {
        return jobStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_job_config.job_status
     *
     * @param jobStatus the value for data_center_job_config.job_status
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_job_config.job_desc
     *
     * @return the value of data_center_job_config.job_desc
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    public String getJobDesc() {
        return jobDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_job_config.job_desc
     *
     * @param jobDesc the value for data_center_job_config.job_desc
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_job_config.job_type
     *
     * @return the value of data_center_job_config.job_type
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    public Integer getJobType() {
        return jobType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_job_config.job_type
     *
     * @param jobType the value for data_center_job_config.job_type
     *
     * @mbggenerated Tue Jul 19 10:55:06 CST 2016
     */
    public void setJobType(Integer jobType) {
        this.jobType = jobType;
    }
}