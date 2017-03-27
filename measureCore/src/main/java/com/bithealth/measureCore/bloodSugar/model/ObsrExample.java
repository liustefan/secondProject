/*
 * ObsrExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-05 Created
 */
package com.bithealth.measureCore.bloodSugar.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObsrExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public ObsrExample() {
        oredCriteria = new ArrayList<Criteria>();
    }
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
    public String getOrderByClause() {
        return orderByClause;
    }
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }
    public boolean isDistinct() {
        return distinct;
    }
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 血糖测量表（OBSR）
     * 
     * @author ${user}
     * @version 1.0 2016-07-05
     */
    protected abstract static class GeneratedCriteria {

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }
        public boolean isValid() {
            return criteria.size() > 0;
        }
        public List<Criterion> getAllCriteria() {
            return criteria;
        }
        public List<Criterion> getCriteria() {
            return criteria;
        }
        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }
        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }
        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }
        public Criteria andDocentryIsNull() {
            addCriterion("Docentry is null");
            return (Criteria) this;
        }
        public Criteria andDocentryIsNotNull() {
            addCriterion("Docentry is not null");
            return (Criteria) this;
        }
        public Criteria andDocentryEqualTo(Long value) {
            addCriterion("Docentry =", value, "docentry");
            return (Criteria) this;
        }
        public Criteria andDocentryNotEqualTo(Long value) {
            addCriterion("Docentry <>", value, "docentry");
            return (Criteria) this;
        }
        public Criteria andDocentryGreaterThan(Long value) {
            addCriterion("Docentry >", value, "docentry");
            return (Criteria) this;
        }
        public Criteria andDocentryGreaterThanOrEqualTo(Long value) {
            addCriterion("Docentry >=", value, "docentry");
            return (Criteria) this;
        }
        public Criteria andDocentryLessThan(Long value) {
            addCriterion("Docentry <", value, "docentry");
            return (Criteria) this;
        }
        public Criteria andDocentryLessThanOrEqualTo(Long value) {
            addCriterion("Docentry <=", value, "docentry");
            return (Criteria) this;
        }
        public Criteria andDocentryIn(List<Long> values) {
            addCriterion("Docentry in", values, "docentry");
            return (Criteria) this;
        }
        public Criteria andDocentryNotIn(List<Long> values) {
            addCriterion("Docentry not in", values, "docentry");
            return (Criteria) this;
        }
        public Criteria andDocentryBetween(Long value1, Long value2) {
            addCriterion("Docentry between", value1, value2, "docentry");
            return (Criteria) this;
        }
        public Criteria andDocentryNotBetween(Long value1, Long value2) {
            addCriterion("Docentry not between", value1, value2, "docentry");
            return (Criteria) this;
        }
        public Criteria andEventidIsNull() {
            addCriterion("EventId is null");
            return (Criteria) this;
        }
        public Criteria andEventidIsNotNull() {
            addCriterion("EventId is not null");
            return (Criteria) this;
        }
        public Criteria andEventidEqualTo(Long value) {
            addCriterion("EventId =", value, "eventid");
            return (Criteria) this;
        }
        public Criteria andEventidNotEqualTo(Long value) {
            addCriterion("EventId <>", value, "eventid");
            return (Criteria) this;
        }
        public Criteria andEventidGreaterThan(Long value) {
            addCriterion("EventId >", value, "eventid");
            return (Criteria) this;
        }
        public Criteria andEventidGreaterThanOrEqualTo(Long value) {
            addCriterion("EventId >=", value, "eventid");
            return (Criteria) this;
        }
        public Criteria andEventidLessThan(Long value) {
            addCriterion("EventId <", value, "eventid");
            return (Criteria) this;
        }
        public Criteria andEventidLessThanOrEqualTo(Long value) {
            addCriterion("EventId <=", value, "eventid");
            return (Criteria) this;
        }
        public Criteria andEventidIn(List<Long> values) {
            addCriterion("EventId in", values, "eventid");
            return (Criteria) this;
        }
        public Criteria andEventidNotIn(List<Long> values) {
            addCriterion("EventId not in", values, "eventid");
            return (Criteria) this;
        }
        public Criteria andEventidBetween(Long value1, Long value2) {
            addCriterion("EventId between", value1, value2, "eventid");
            return (Criteria) this;
        }
        public Criteria andEventidNotBetween(Long value1, Long value2) {
            addCriterion("EventId not between", value1, value2, "eventid");
            return (Criteria) this;
        }
        public Criteria andMemberidIsNull() {
            addCriterion("Memberid is null");
            return (Criteria) this;
        }
        public Criteria andMemberidIsNotNull() {
            addCriterion("Memberid is not null");
            return (Criteria) this;
        }
        public Criteria andMemberidEqualTo(Integer value) {
            addCriterion("Memberid =", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotEqualTo(Integer value) {
            addCriterion("Memberid <>", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidGreaterThan(Integer value) {
            addCriterion("Memberid >", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Memberid >=", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidLessThan(Integer value) {
            addCriterion("Memberid <", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidLessThanOrEqualTo(Integer value) {
            addCriterion("Memberid <=", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidIn(List<Integer> values) {
            addCriterion("Memberid in", values, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotIn(List<Integer> values) {
            addCriterion("Memberid not in", values, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidBetween(Integer value1, Integer value2) {
            addCriterion("Memberid between", value1, value2, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotBetween(Integer value1, Integer value2) {
            addCriterion("Memberid not between", value1, value2, "memberid");
            return (Criteria) this;
        }
        public Criteria andUploadtimeIsNull() {
            addCriterion("UploadTime is null");
            return (Criteria) this;
        }
        public Criteria andUploadtimeIsNotNull() {
            addCriterion("UploadTime is not null");
            return (Criteria) this;
        }
        public Criteria andUploadtimeEqualTo(Date value) {
            addCriterion("UploadTime =", value, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andUploadtimeNotEqualTo(Date value) {
            addCriterion("UploadTime <>", value, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andUploadtimeGreaterThan(Date value) {
            addCriterion("UploadTime >", value, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andUploadtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UploadTime >=", value, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andUploadtimeLessThan(Date value) {
            addCriterion("UploadTime <", value, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andUploadtimeLessThanOrEqualTo(Date value) {
            addCriterion("UploadTime <=", value, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andUploadtimeIn(List<Date> values) {
            addCriterion("UploadTime in", values, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andUploadtimeNotIn(List<Date> values) {
            addCriterion("UploadTime not in", values, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andUploadtimeBetween(Date value1, Date value2) {
            addCriterion("UploadTime between", value1, value2, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andUploadtimeNotBetween(Date value1, Date value2) {
            addCriterion("UploadTime not between", value1, value2, "uploadtime");
            return (Criteria) this;
        }
        public Criteria andTesttimeIsNull() {
            addCriterion("TestTime is null");
            return (Criteria) this;
        }
        public Criteria andTesttimeIsNotNull() {
            addCriterion("TestTime is not null");
            return (Criteria) this;
        }
        public Criteria andTesttimeEqualTo(Date value) {
            addCriterion("TestTime =", value, "testtime");
            return (Criteria) this;
        }
        public Criteria andTesttimeNotEqualTo(Date value) {
            addCriterion("TestTime <>", value, "testtime");
            return (Criteria) this;
        }
        public Criteria andTesttimeGreaterThan(Date value) {
            addCriterion("TestTime >", value, "testtime");
            return (Criteria) this;
        }
        public Criteria andTesttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("TestTime >=", value, "testtime");
            return (Criteria) this;
        }
        public Criteria andTesttimeLessThan(Date value) {
            addCriterion("TestTime <", value, "testtime");
            return (Criteria) this;
        }
        public Criteria andTesttimeLessThanOrEqualTo(Date value) {
            addCriterion("TestTime <=", value, "testtime");
            return (Criteria) this;
        }
        public Criteria andTesttimeIn(List<Date> values) {
            addCriterion("TestTime in", values, "testtime");
            return (Criteria) this;
        }
        public Criteria andTesttimeNotIn(List<Date> values) {
            addCriterion("TestTime not in", values, "testtime");
            return (Criteria) this;
        }
        public Criteria andTesttimeBetween(Date value1, Date value2) {
            addCriterion("TestTime between", value1, value2, "testtime");
            return (Criteria) this;
        }
        public Criteria andTesttimeNotBetween(Date value1, Date value2) {
            addCriterion("TestTime not between", value1, value2, "testtime");
            return (Criteria) this;
        }
        public Criteria andDeltagIsNull() {
            addCriterion("DelTag is null");
            return (Criteria) this;
        }
        public Criteria andDeltagIsNotNull() {
            addCriterion("DelTag is not null");
            return (Criteria) this;
        }
        public Criteria andDeltagEqualTo(String value) {
            addCriterion("DelTag =", value, "deltag");
            return (Criteria) this;
        }
        public Criteria andDeltagNotEqualTo(String value) {
            addCriterion("DelTag <>", value, "deltag");
            return (Criteria) this;
        }
        public Criteria andDeltagGreaterThan(String value) {
            addCriterion("DelTag >", value, "deltag");
            return (Criteria) this;
        }
        public Criteria andDeltagGreaterThanOrEqualTo(String value) {
            addCriterion("DelTag >=", value, "deltag");
            return (Criteria) this;
        }
        public Criteria andDeltagLessThan(String value) {
            addCriterion("DelTag <", value, "deltag");
            return (Criteria) this;
        }
        public Criteria andDeltagLessThanOrEqualTo(String value) {
            addCriterion("DelTag <=", value, "deltag");
            return (Criteria) this;
        }
        public Criteria andDeltagLike(String value) {
            addCriterion("DelTag like", value, "deltag");
            return (Criteria) this;
        }
        public Criteria andDeltagNotLike(String value) {
            addCriterion("DelTag not like", value, "deltag");
            return (Criteria) this;
        }
        public Criteria andDeltagIn(List<String> values) {
            addCriterion("DelTag in", values, "deltag");
            return (Criteria) this;
        }
        public Criteria andDeltagNotIn(List<String> values) {
            addCriterion("DelTag not in", values, "deltag");
            return (Criteria) this;
        }
        public Criteria andDeltagBetween(String value1, String value2) {
            addCriterion("DelTag between", value1, value2, "deltag");
            return (Criteria) this;
        }
        public Criteria andDeltagNotBetween(String value1, String value2) {
            addCriterion("DelTag not between", value1, value2, "deltag");
            return (Criteria) this;
        }
        public Criteria andBsvalueIsNull() {
            addCriterion("BsValue is null");
            return (Criteria) this;
        }
        public Criteria andBsvalueIsNotNull() {
            addCriterion("BsValue is not null");
            return (Criteria) this;
        }
        public Criteria andBsvalueEqualTo(BigDecimal value) {
            addCriterion("BsValue =", value, "bsvalue");
            return (Criteria) this;
        }
        public Criteria andBsvalueNotEqualTo(BigDecimal value) {
            addCriterion("BsValue <>", value, "bsvalue");
            return (Criteria) this;
        }
        public Criteria andBsvalueGreaterThan(BigDecimal value) {
            addCriterion("BsValue >", value, "bsvalue");
            return (Criteria) this;
        }
        public Criteria andBsvalueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BsValue >=", value, "bsvalue");
            return (Criteria) this;
        }
        public Criteria andBsvalueLessThan(BigDecimal value) {
            addCriterion("BsValue <", value, "bsvalue");
            return (Criteria) this;
        }
        public Criteria andBsvalueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BsValue <=", value, "bsvalue");
            return (Criteria) this;
        }
        public Criteria andBsvalueIn(List<BigDecimal> values) {
            addCriterion("BsValue in", values, "bsvalue");
            return (Criteria) this;
        }
        public Criteria andBsvalueNotIn(List<BigDecimal> values) {
            addCriterion("BsValue not in", values, "bsvalue");
            return (Criteria) this;
        }
        public Criteria andBsvalueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BsValue between", value1, value2, "bsvalue");
            return (Criteria) this;
        }
        public Criteria andBsvalueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BsValue not between", value1, value2, "bsvalue");
            return (Criteria) this;
        }
        public Criteria andTimeperiodIsNull() {
            addCriterion("timePeriod is null");
            return (Criteria) this;
        }
        public Criteria andTimeperiodIsNotNull() {
            addCriterion("timePeriod is not null");
            return (Criteria) this;
        }
        public Criteria andTimeperiodEqualTo(String value) {
            addCriterion("timePeriod =", value, "timeperiod");
            return (Criteria) this;
        }
        public Criteria andTimeperiodNotEqualTo(String value) {
            addCriterion("timePeriod <>", value, "timeperiod");
            return (Criteria) this;
        }
        public Criteria andTimeperiodGreaterThan(String value) {
            addCriterion("timePeriod >", value, "timeperiod");
            return (Criteria) this;
        }
        public Criteria andTimeperiodGreaterThanOrEqualTo(String value) {
            addCriterion("timePeriod >=", value, "timeperiod");
            return (Criteria) this;
        }
        public Criteria andTimeperiodLessThan(String value) {
            addCriterion("timePeriod <", value, "timeperiod");
            return (Criteria) this;
        }
        public Criteria andTimeperiodLessThanOrEqualTo(String value) {
            addCriterion("timePeriod <=", value, "timeperiod");
            return (Criteria) this;
        }
        public Criteria andTimeperiodLike(String value) {
            addCriterion("timePeriod like", value, "timeperiod");
            return (Criteria) this;
        }
        public Criteria andTimeperiodNotLike(String value) {
            addCriterion("timePeriod not like", value, "timeperiod");
            return (Criteria) this;
        }
        public Criteria andTimeperiodIn(List<String> values) {
            addCriterion("timePeriod in", values, "timeperiod");
            return (Criteria) this;
        }
        public Criteria andTimeperiodNotIn(List<String> values) {
            addCriterion("timePeriod not in", values, "timeperiod");
            return (Criteria) this;
        }
        public Criteria andTimeperiodBetween(String value1, String value2) {
            addCriterion("timePeriod between", value1, value2, "timeperiod");
            return (Criteria) this;
        }
        public Criteria andTimeperiodNotBetween(String value1, String value2) {
            addCriterion("timePeriod not between", value1, value2, "timeperiod");
            return (Criteria) this;
        }
        public Criteria andAnalysisresultIsNull() {
            addCriterion("AnalysisResult is null");
            return (Criteria) this;
        }
        public Criteria andAnalysisresultIsNotNull() {
            addCriterion("AnalysisResult is not null");
            return (Criteria) this;
        }
        public Criteria andAnalysisresultEqualTo(String value) {
            addCriterion("AnalysisResult =", value, "analysisresult");
            return (Criteria) this;
        }
        public Criteria andAnalysisresultNotEqualTo(String value) {
            addCriterion("AnalysisResult <>", value, "analysisresult");
            return (Criteria) this;
        }
        public Criteria andAnalysisresultGreaterThan(String value) {
            addCriterion("AnalysisResult >", value, "analysisresult");
            return (Criteria) this;
        }
        public Criteria andAnalysisresultGreaterThanOrEqualTo(String value) {
            addCriterion("AnalysisResult >=", value, "analysisresult");
            return (Criteria) this;
        }
        public Criteria andAnalysisresultLessThan(String value) {
            addCriterion("AnalysisResult <", value, "analysisresult");
            return (Criteria) this;
        }
        public Criteria andAnalysisresultLessThanOrEqualTo(String value) {
            addCriterion("AnalysisResult <=", value, "analysisresult");
            return (Criteria) this;
        }
        public Criteria andAnalysisresultLike(String value) {
            addCriterion("AnalysisResult like", value, "analysisresult");
            return (Criteria) this;
        }
        public Criteria andAnalysisresultNotLike(String value) {
            addCriterion("AnalysisResult not like", value, "analysisresult");
            return (Criteria) this;
        }
        public Criteria andAnalysisresultIn(List<String> values) {
            addCriterion("AnalysisResult in", values, "analysisresult");
            return (Criteria) this;
        }
        public Criteria andAnalysisresultNotIn(List<String> values) {
            addCriterion("AnalysisResult not in", values, "analysisresult");
            return (Criteria) this;
        }
        public Criteria andAnalysisresultBetween(String value1, String value2) {
            addCriterion("AnalysisResult between", value1, value2, "analysisresult");
            return (Criteria) this;
        }
        public Criteria andAnalysisresultNotBetween(String value1, String value2) {
            addCriterion("AnalysisResult not between", value1, value2, "analysisresult");
            return (Criteria) this;
        }
        public Criteria andDevicecodeIsNull() {
            addCriterion("DeviceCode is null");
            return (Criteria) this;
        }
        public Criteria andDevicecodeIsNotNull() {
            addCriterion("DeviceCode is not null");
            return (Criteria) this;
        }
        public Criteria andDevicecodeEqualTo(String value) {
            addCriterion("DeviceCode =", value, "devicecode");
            return (Criteria) this;
        }
        public Criteria andDevicecodeNotEqualTo(String value) {
            addCriterion("DeviceCode <>", value, "devicecode");
            return (Criteria) this;
        }
        public Criteria andDevicecodeGreaterThan(String value) {
            addCriterion("DeviceCode >", value, "devicecode");
            return (Criteria) this;
        }
        public Criteria andDevicecodeGreaterThanOrEqualTo(String value) {
            addCriterion("DeviceCode >=", value, "devicecode");
            return (Criteria) this;
        }
        public Criteria andDevicecodeLessThan(String value) {
            addCriterion("DeviceCode <", value, "devicecode");
            return (Criteria) this;
        }
        public Criteria andDevicecodeLessThanOrEqualTo(String value) {
            addCriterion("DeviceCode <=", value, "devicecode");
            return (Criteria) this;
        }
        public Criteria andDevicecodeLike(String value) {
            addCriterion("DeviceCode like", value, "devicecode");
            return (Criteria) this;
        }
        public Criteria andDevicecodeNotLike(String value) {
            addCriterion("DeviceCode not like", value, "devicecode");
            return (Criteria) this;
        }
        public Criteria andDevicecodeIn(List<String> values) {
            addCriterion("DeviceCode in", values, "devicecode");
            return (Criteria) this;
        }
        public Criteria andDevicecodeNotIn(List<String> values) {
            addCriterion("DeviceCode not in", values, "devicecode");
            return (Criteria) this;
        }
        public Criteria andDevicecodeBetween(String value1, String value2) {
            addCriterion("DeviceCode between", value1, value2, "devicecode");
            return (Criteria) this;
        }
        public Criteria andDevicecodeNotBetween(String value1, String value2) {
            addCriterion("DeviceCode not between", value1, value2, "devicecode");
            return (Criteria) this;
        }
        public Criteria andBluetoothmacaddrIsNull() {
            addCriterion("BluetoothMacAddr is null");
            return (Criteria) this;
        }
        public Criteria andBluetoothmacaddrIsNotNull() {
            addCriterion("BluetoothMacAddr is not null");
            return (Criteria) this;
        }
        public Criteria andBluetoothmacaddrEqualTo(String value) {
            addCriterion("BluetoothMacAddr =", value, "bluetoothmacaddr");
            return (Criteria) this;
        }
        public Criteria andBluetoothmacaddrNotEqualTo(String value) {
            addCriterion("BluetoothMacAddr <>", value, "bluetoothmacaddr");
            return (Criteria) this;
        }
        public Criteria andBluetoothmacaddrGreaterThan(String value) {
            addCriterion("BluetoothMacAddr >", value, "bluetoothmacaddr");
            return (Criteria) this;
        }
        public Criteria andBluetoothmacaddrGreaterThanOrEqualTo(String value) {
            addCriterion("BluetoothMacAddr >=", value, "bluetoothmacaddr");
            return (Criteria) this;
        }
        public Criteria andBluetoothmacaddrLessThan(String value) {
            addCriterion("BluetoothMacAddr <", value, "bluetoothmacaddr");
            return (Criteria) this;
        }
        public Criteria andBluetoothmacaddrLessThanOrEqualTo(String value) {
            addCriterion("BluetoothMacAddr <=", value, "bluetoothmacaddr");
            return (Criteria) this;
        }
        public Criteria andBluetoothmacaddrLike(String value) {
            addCriterion("BluetoothMacAddr like", value, "bluetoothmacaddr");
            return (Criteria) this;
        }
        public Criteria andBluetoothmacaddrNotLike(String value) {
            addCriterion("BluetoothMacAddr not like", value, "bluetoothmacaddr");
            return (Criteria) this;
        }
        public Criteria andBluetoothmacaddrIn(List<String> values) {
            addCriterion("BluetoothMacAddr in", values, "bluetoothmacaddr");
            return (Criteria) this;
        }
        public Criteria andBluetoothmacaddrNotIn(List<String> values) {
            addCriterion("BluetoothMacAddr not in", values, "bluetoothmacaddr");
            return (Criteria) this;
        }
        public Criteria andBluetoothmacaddrBetween(String value1, String value2) {
            addCriterion("BluetoothMacAddr between", value1, value2, "bluetoothmacaddr");
            return (Criteria) this;
        }
        public Criteria andBluetoothmacaddrNotBetween(String value1, String value2) {
            addCriterion("BluetoothMacAddr not between", value1, value2, "bluetoothmacaddr");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 血糖测量表（OBSR）
     * 
     * @author ${user}
     * @version 1.0 2016-07-05
     */
    public static class Criterion {

        private String condition;
        private Object value;
        private Object secondValue;
        private boolean noValue;
        private boolean singleValue;
        private boolean betweenValue;
        private boolean listValue;
        private String typeHandler;

        public String getCondition() {
            return condition;
        }
        public Object getValue() {
            return value;
        }
        public Object getSecondValue() {
            return secondValue;
        }
        public boolean isNoValue() {
            return noValue;
        }
        public boolean isSingleValue() {
            return singleValue;
        }
        public boolean isBetweenValue() {
            return betweenValue;
        }
        public boolean isListValue() {
            return listValue;
        }
        public String getTypeHandler() {
            return typeHandler;
        }
        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }
        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }
        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }
        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }
        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}