package com.bithealth.dataConversionServer.model;

import java.util.Date;

import javax.persistence.Entity;

import com.bithealth.sdk.core.generic.GenericModel;

@Entity
public class DataFileRelation extends GenericModel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_relation.id
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_relation.data_id
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    private String dataId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_relation.prg_id
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    private String prgId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_relation.company_code
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    private Integer companyCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_relation.type
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_relation.file_status
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    private Integer fileStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_relation.member_id
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    private String memberId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_relation.time
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_relation.create_by
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    private String createBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_relation.create_date
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_relation.update_by
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    private String updateBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_relation.update_date
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    private Date updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_relation.method_code
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    private String methodCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_relation.fail_times
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    private Integer failTimes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_relation.fail_reason
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    private String failReason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_relation.source_key
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    private Long sourceKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column data_center_relation.data_file
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    private byte[] dataFile;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_relation.id
     *
     * @return the value of data_center_relation.id
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_relation.id
     *
     * @param id the value for data_center_relation.id
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_relation.data_id
     *
     * @return the value of data_center_relation.data_id
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public String getDataId() {
        return dataId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_relation.data_id
     *
     * @param dataId the value for data_center_relation.data_id
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_relation.prg_id
     *
     * @return the value of data_center_relation.prg_id
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public String getPrgId() {
        return prgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_relation.prg_id
     *
     * @param prgId the value for data_center_relation.prg_id
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public void setPrgId(String prgId) {
        this.prgId = prgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_relation.company_code
     *
     * @return the value of data_center_relation.company_code
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public Integer getCompanyCode() {
        return companyCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_relation.company_code
     *
     * @param companyCode the value for data_center_relation.company_code
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public void setCompanyCode(Integer companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_relation.type
     *
     * @return the value of data_center_relation.type
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_relation.type
     *
     * @param type the value for data_center_relation.type
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_relation.file_status
     *
     * @return the value of data_center_relation.file_status
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public Integer getFileStatus() {
        return fileStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_relation.file_status
     *
     * @param fileStatus the value for data_center_relation.file_status
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public void setFileStatus(Integer fileStatus) {
        this.fileStatus = fileStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_relation.member_id
     *
     * @return the value of data_center_relation.member_id
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_relation.member_id
     *
     * @param memberId the value for data_center_relation.member_id
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_relation.time
     *
     * @return the value of data_center_relation.time
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_relation.time
     *
     * @param time the value for data_center_relation.time
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_relation.create_by
     *
     * @return the value of data_center_relation.create_by
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_relation.create_by
     *
     * @param createBy the value for data_center_relation.create_by
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_relation.create_date
     *
     * @return the value of data_center_relation.create_date
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_relation.create_date
     *
     * @param createDate the value for data_center_relation.create_date
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_relation.update_by
     *
     * @return the value of data_center_relation.update_by
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_relation.update_by
     *
     * @param updateBy the value for data_center_relation.update_by
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_relation.update_date
     *
     * @return the value of data_center_relation.update_date
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_relation.update_date
     *
     * @param updateDate the value for data_center_relation.update_date
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_relation.method_code
     *
     * @return the value of data_center_relation.method_code
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public String getMethodCode() {
        return methodCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_relation.method_code
     *
     * @param methodCode the value for data_center_relation.method_code
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public void setMethodCode(String methodCode) {
        this.methodCode = methodCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_relation.fail_times
     *
     * @return the value of data_center_relation.fail_times
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public Integer getFailTimes() {
        return failTimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_relation.fail_times
     *
     * @param failTimes the value for data_center_relation.fail_times
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public void setFailTimes(Integer failTimes) {
        this.failTimes = failTimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_relation.fail_reason
     *
     * @return the value of data_center_relation.fail_reason
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public String getFailReason() {
        return failReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_relation.fail_reason
     *
     * @param failReason the value for data_center_relation.fail_reason
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_relation.source_key
     *
     * @return the value of data_center_relation.source_key
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public Long getSourceKey() {
        return sourceKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_relation.source_key
     *
     * @param sourceKey the value for data_center_relation.source_key
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public void setSourceKey(Long sourceKey) {
        this.sourceKey = sourceKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column data_center_relation.data_file
     *
     * @return the value of data_center_relation.data_file
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public byte[] getDataFile() {
        return dataFile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column data_center_relation.data_file
     *
     * @param dataFile the value for data_center_relation.data_file
     *
     * @mbggenerated Tue Jul 19 10:54:01 CST 2016
     */
    public void setDataFile(byte[] dataFile) {
        this.dataFile = dataFile;
    }
}