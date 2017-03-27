package com.bithealth.common.cache.model;

import java.util.Date;

public class CacheLog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cache_log.id
     *
     * @mbggenerated Fri May 13 10:34:56 CST 2016
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cache_log.prefix
     *
     * @mbggenerated Fri May 13 10:34:56 CST 2016
     */
    private String prefix;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cache_log.cache_key
     *
     * @mbggenerated Fri May 13 10:34:56 CST 2016
     */
    private String cacheKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cache_log.add_time
     *
     * @mbggenerated Fri May 13 10:34:56 CST 2016
     */
    private Date addTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cache_log.id
     *
     * @return the value of cache_log.id
     *
     * @mbggenerated Fri May 13 10:34:56 CST 2016
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cache_log.id
     *
     * @param id the value for cache_log.id
     *
     * @mbggenerated Fri May 13 10:34:56 CST 2016
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cache_log.prefix
     *
     * @return the value of cache_log.prefix
     *
     * @mbggenerated Fri May 13 10:34:56 CST 2016
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cache_log.prefix
     *
     * @param prefix the value for cache_log.prefix
     *
     * @mbggenerated Fri May 13 10:34:56 CST 2016
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cache_log.cache_key
     *
     * @return the value of cache_log.cache_key
     *
     * @mbggenerated Fri May 13 10:34:56 CST 2016
     */
    public String getCacheKey() {
        return cacheKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cache_log.cache_key
     *
     * @param cacheKey the value for cache_log.cache_key
     *
     * @mbggenerated Fri May 13 10:34:56 CST 2016
     */
    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cache_log.add_time
     *
     * @return the value of cache_log.add_time
     *
     * @mbggenerated Fri May 13 10:34:56 CST 2016
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cache_log.add_time
     *
     * @param addTime the value for cache_log.add_time
     *
     * @mbggenerated Fri May 13 10:34:56 CST 2016
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}