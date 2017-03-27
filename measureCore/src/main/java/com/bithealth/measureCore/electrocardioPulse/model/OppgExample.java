/*
 * OppgExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.measureCore.electrocardioPulse.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OppgExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public OppgExample() {
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
     * 脉搏测量表（OPPG）
     * 
     * @author ${user}
     * @version 1.0 2016-07-12
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
        public Criteria andTimelengthIsNull() {
            addCriterion("TimeLength is null");
            return (Criteria) this;
        }
        public Criteria andTimelengthIsNotNull() {
            addCriterion("TimeLength is not null");
            return (Criteria) this;
        }
        public Criteria andTimelengthEqualTo(Integer value) {
            addCriterion("TimeLength =", value, "timelength");
            return (Criteria) this;
        }
        public Criteria andTimelengthNotEqualTo(Integer value) {
            addCriterion("TimeLength <>", value, "timelength");
            return (Criteria) this;
        }
        public Criteria andTimelengthGreaterThan(Integer value) {
            addCriterion("TimeLength >", value, "timelength");
            return (Criteria) this;
        }
        public Criteria andTimelengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("TimeLength >=", value, "timelength");
            return (Criteria) this;
        }
        public Criteria andTimelengthLessThan(Integer value) {
            addCriterion("TimeLength <", value, "timelength");
            return (Criteria) this;
        }
        public Criteria andTimelengthLessThanOrEqualTo(Integer value) {
            addCriterion("TimeLength <=", value, "timelength");
            return (Criteria) this;
        }
        public Criteria andTimelengthIn(List<Integer> values) {
            addCriterion("TimeLength in", values, "timelength");
            return (Criteria) this;
        }
        public Criteria andTimelengthNotIn(List<Integer> values) {
            addCriterion("TimeLength not in", values, "timelength");
            return (Criteria) this;
        }
        public Criteria andTimelengthBetween(Integer value1, Integer value2) {
            addCriterion("TimeLength between", value1, value2, "timelength");
            return (Criteria) this;
        }
        public Criteria andTimelengthNotBetween(Integer value1, Integer value2) {
            addCriterion("TimeLength not between", value1, value2, "timelength");
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
        public Criteria andMeasuretimeIsNull() {
            addCriterion("MeasureTime is null");
            return (Criteria) this;
        }
        public Criteria andMeasuretimeIsNotNull() {
            addCriterion("MeasureTime is not null");
            return (Criteria) this;
        }
        public Criteria andMeasuretimeEqualTo(Date value) {
            addCriterion("MeasureTime =", value, "measuretime");
            return (Criteria) this;
        }
        public Criteria andMeasuretimeNotEqualTo(Date value) {
            addCriterion("MeasureTime <>", value, "measuretime");
            return (Criteria) this;
        }
        public Criteria andMeasuretimeGreaterThan(Date value) {
            addCriterion("MeasureTime >", value, "measuretime");
            return (Criteria) this;
        }
        public Criteria andMeasuretimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MeasureTime >=", value, "measuretime");
            return (Criteria) this;
        }
        public Criteria andMeasuretimeLessThan(Date value) {
            addCriterion("MeasureTime <", value, "measuretime");
            return (Criteria) this;
        }
        public Criteria andMeasuretimeLessThanOrEqualTo(Date value) {
            addCriterion("MeasureTime <=", value, "measuretime");
            return (Criteria) this;
        }
        public Criteria andMeasuretimeIn(List<Date> values) {
            addCriterion("MeasureTime in", values, "measuretime");
            return (Criteria) this;
        }
        public Criteria andMeasuretimeNotIn(List<Date> values) {
            addCriterion("MeasureTime not in", values, "measuretime");
            return (Criteria) this;
        }
        public Criteria andMeasuretimeBetween(Date value1, Date value2) {
            addCriterion("MeasureTime between", value1, value2, "measuretime");
            return (Criteria) this;
        }
        public Criteria andMeasuretimeNotBetween(Date value1, Date value2) {
            addCriterion("MeasureTime not between", value1, value2, "measuretime");
            return (Criteria) this;
        }
        public Criteria andPulsebeatcountIsNull() {
            addCriterion("PulsebeatCount is null");
            return (Criteria) this;
        }
        public Criteria andPulsebeatcountIsNotNull() {
            addCriterion("PulsebeatCount is not null");
            return (Criteria) this;
        }
        public Criteria andPulsebeatcountEqualTo(Short value) {
            addCriterion("PulsebeatCount =", value, "pulsebeatcount");
            return (Criteria) this;
        }
        public Criteria andPulsebeatcountNotEqualTo(Short value) {
            addCriterion("PulsebeatCount <>", value, "pulsebeatcount");
            return (Criteria) this;
        }
        public Criteria andPulsebeatcountGreaterThan(Short value) {
            addCriterion("PulsebeatCount >", value, "pulsebeatcount");
            return (Criteria) this;
        }
        public Criteria andPulsebeatcountGreaterThanOrEqualTo(Short value) {
            addCriterion("PulsebeatCount >=", value, "pulsebeatcount");
            return (Criteria) this;
        }
        public Criteria andPulsebeatcountLessThan(Short value) {
            addCriterion("PulsebeatCount <", value, "pulsebeatcount");
            return (Criteria) this;
        }
        public Criteria andPulsebeatcountLessThanOrEqualTo(Short value) {
            addCriterion("PulsebeatCount <=", value, "pulsebeatcount");
            return (Criteria) this;
        }
        public Criteria andPulsebeatcountIn(List<Short> values) {
            addCriterion("PulsebeatCount in", values, "pulsebeatcount");
            return (Criteria) this;
        }
        public Criteria andPulsebeatcountNotIn(List<Short> values) {
            addCriterion("PulsebeatCount not in", values, "pulsebeatcount");
            return (Criteria) this;
        }
        public Criteria andPulsebeatcountBetween(Short value1, Short value2) {
            addCriterion("PulsebeatCount between", value1, value2, "pulsebeatcount");
            return (Criteria) this;
        }
        public Criteria andPulsebeatcountNotBetween(Short value1, Short value2) {
            addCriterion("PulsebeatCount not between", value1, value2, "pulsebeatcount");
            return (Criteria) this;
        }
        public Criteria andSlowpulseIsNull() {
            addCriterion("SlowPulse is null");
            return (Criteria) this;
        }
        public Criteria andSlowpulseIsNotNull() {
            addCriterion("SlowPulse is not null");
            return (Criteria) this;
        }
        public Criteria andSlowpulseEqualTo(Short value) {
            addCriterion("SlowPulse =", value, "slowpulse");
            return (Criteria) this;
        }
        public Criteria andSlowpulseNotEqualTo(Short value) {
            addCriterion("SlowPulse <>", value, "slowpulse");
            return (Criteria) this;
        }
        public Criteria andSlowpulseGreaterThan(Short value) {
            addCriterion("SlowPulse >", value, "slowpulse");
            return (Criteria) this;
        }
        public Criteria andSlowpulseGreaterThanOrEqualTo(Short value) {
            addCriterion("SlowPulse >=", value, "slowpulse");
            return (Criteria) this;
        }
        public Criteria andSlowpulseLessThan(Short value) {
            addCriterion("SlowPulse <", value, "slowpulse");
            return (Criteria) this;
        }
        public Criteria andSlowpulseLessThanOrEqualTo(Short value) {
            addCriterion("SlowPulse <=", value, "slowpulse");
            return (Criteria) this;
        }
        public Criteria andSlowpulseIn(List<Short> values) {
            addCriterion("SlowPulse in", values, "slowpulse");
            return (Criteria) this;
        }
        public Criteria andSlowpulseNotIn(List<Short> values) {
            addCriterion("SlowPulse not in", values, "slowpulse");
            return (Criteria) this;
        }
        public Criteria andSlowpulseBetween(Short value1, Short value2) {
            addCriterion("SlowPulse between", value1, value2, "slowpulse");
            return (Criteria) this;
        }
        public Criteria andSlowpulseNotBetween(Short value1, Short value2) {
            addCriterion("SlowPulse not between", value1, value2, "slowpulse");
            return (Criteria) this;
        }
        public Criteria andSlowtimeIsNull() {
            addCriterion("SlowTime is null");
            return (Criteria) this;
        }
        public Criteria andSlowtimeIsNotNull() {
            addCriterion("SlowTime is not null");
            return (Criteria) this;
        }
        public Criteria andSlowtimeEqualTo(Short value) {
            addCriterion("SlowTime =", value, "slowtime");
            return (Criteria) this;
        }
        public Criteria andSlowtimeNotEqualTo(Short value) {
            addCriterion("SlowTime <>", value, "slowtime");
            return (Criteria) this;
        }
        public Criteria andSlowtimeGreaterThan(Short value) {
            addCriterion("SlowTime >", value, "slowtime");
            return (Criteria) this;
        }
        public Criteria andSlowtimeGreaterThanOrEqualTo(Short value) {
            addCriterion("SlowTime >=", value, "slowtime");
            return (Criteria) this;
        }
        public Criteria andSlowtimeLessThan(Short value) {
            addCriterion("SlowTime <", value, "slowtime");
            return (Criteria) this;
        }
        public Criteria andSlowtimeLessThanOrEqualTo(Short value) {
            addCriterion("SlowTime <=", value, "slowtime");
            return (Criteria) this;
        }
        public Criteria andSlowtimeIn(List<Short> values) {
            addCriterion("SlowTime in", values, "slowtime");
            return (Criteria) this;
        }
        public Criteria andSlowtimeNotIn(List<Short> values) {
            addCriterion("SlowTime not in", values, "slowtime");
            return (Criteria) this;
        }
        public Criteria andSlowtimeBetween(Short value1, Short value2) {
            addCriterion("SlowTime between", value1, value2, "slowtime");
            return (Criteria) this;
        }
        public Criteria andSlowtimeNotBetween(Short value1, Short value2) {
            addCriterion("SlowTime not between", value1, value2, "slowtime");
            return (Criteria) this;
        }
        public Criteria andQuickpulseIsNull() {
            addCriterion("QuickPulse is null");
            return (Criteria) this;
        }
        public Criteria andQuickpulseIsNotNull() {
            addCriterion("QuickPulse is not null");
            return (Criteria) this;
        }
        public Criteria andQuickpulseEqualTo(Short value) {
            addCriterion("QuickPulse =", value, "quickpulse");
            return (Criteria) this;
        }
        public Criteria andQuickpulseNotEqualTo(Short value) {
            addCriterion("QuickPulse <>", value, "quickpulse");
            return (Criteria) this;
        }
        public Criteria andQuickpulseGreaterThan(Short value) {
            addCriterion("QuickPulse >", value, "quickpulse");
            return (Criteria) this;
        }
        public Criteria andQuickpulseGreaterThanOrEqualTo(Short value) {
            addCriterion("QuickPulse >=", value, "quickpulse");
            return (Criteria) this;
        }
        public Criteria andQuickpulseLessThan(Short value) {
            addCriterion("QuickPulse <", value, "quickpulse");
            return (Criteria) this;
        }
        public Criteria andQuickpulseLessThanOrEqualTo(Short value) {
            addCriterion("QuickPulse <=", value, "quickpulse");
            return (Criteria) this;
        }
        public Criteria andQuickpulseIn(List<Short> values) {
            addCriterion("QuickPulse in", values, "quickpulse");
            return (Criteria) this;
        }
        public Criteria andQuickpulseNotIn(List<Short> values) {
            addCriterion("QuickPulse not in", values, "quickpulse");
            return (Criteria) this;
        }
        public Criteria andQuickpulseBetween(Short value1, Short value2) {
            addCriterion("QuickPulse between", value1, value2, "quickpulse");
            return (Criteria) this;
        }
        public Criteria andQuickpulseNotBetween(Short value1, Short value2) {
            addCriterion("QuickPulse not between", value1, value2, "quickpulse");
            return (Criteria) this;
        }
        public Criteria andQuicktimeIsNull() {
            addCriterion("QuickTime is null");
            return (Criteria) this;
        }
        public Criteria andQuicktimeIsNotNull() {
            addCriterion("QuickTime is not null");
            return (Criteria) this;
        }
        public Criteria andQuicktimeEqualTo(Short value) {
            addCriterion("QuickTime =", value, "quicktime");
            return (Criteria) this;
        }
        public Criteria andQuicktimeNotEqualTo(Short value) {
            addCriterion("QuickTime <>", value, "quicktime");
            return (Criteria) this;
        }
        public Criteria andQuicktimeGreaterThan(Short value) {
            addCriterion("QuickTime >", value, "quicktime");
            return (Criteria) this;
        }
        public Criteria andQuicktimeGreaterThanOrEqualTo(Short value) {
            addCriterion("QuickTime >=", value, "quicktime");
            return (Criteria) this;
        }
        public Criteria andQuicktimeLessThan(Short value) {
            addCriterion("QuickTime <", value, "quicktime");
            return (Criteria) this;
        }
        public Criteria andQuicktimeLessThanOrEqualTo(Short value) {
            addCriterion("QuickTime <=", value, "quicktime");
            return (Criteria) this;
        }
        public Criteria andQuicktimeIn(List<Short> values) {
            addCriterion("QuickTime in", values, "quicktime");
            return (Criteria) this;
        }
        public Criteria andQuicktimeNotIn(List<Short> values) {
            addCriterion("QuickTime not in", values, "quicktime");
            return (Criteria) this;
        }
        public Criteria andQuicktimeBetween(Short value1, Short value2) {
            addCriterion("QuickTime between", value1, value2, "quicktime");
            return (Criteria) this;
        }
        public Criteria andQuicktimeNotBetween(Short value1, Short value2) {
            addCriterion("QuickTime not between", value1, value2, "quicktime");
            return (Criteria) this;
        }
        public Criteria andPulserateIsNull() {
            addCriterion("PulseRate is null");
            return (Criteria) this;
        }
        public Criteria andPulserateIsNotNull() {
            addCriterion("PulseRate is not null");
            return (Criteria) this;
        }
        public Criteria andPulserateEqualTo(Short value) {
            addCriterion("PulseRate =", value, "pulserate");
            return (Criteria) this;
        }
        public Criteria andPulserateNotEqualTo(Short value) {
            addCriterion("PulseRate <>", value, "pulserate");
            return (Criteria) this;
        }
        public Criteria andPulserateGreaterThan(Short value) {
            addCriterion("PulseRate >", value, "pulserate");
            return (Criteria) this;
        }
        public Criteria andPulserateGreaterThanOrEqualTo(Short value) {
            addCriterion("PulseRate >=", value, "pulserate");
            return (Criteria) this;
        }
        public Criteria andPulserateLessThan(Short value) {
            addCriterion("PulseRate <", value, "pulserate");
            return (Criteria) this;
        }
        public Criteria andPulserateLessThanOrEqualTo(Short value) {
            addCriterion("PulseRate <=", value, "pulserate");
            return (Criteria) this;
        }
        public Criteria andPulserateIn(List<Short> values) {
            addCriterion("PulseRate in", values, "pulserate");
            return (Criteria) this;
        }
        public Criteria andPulserateNotIn(List<Short> values) {
            addCriterion("PulseRate not in", values, "pulserate");
            return (Criteria) this;
        }
        public Criteria andPulserateBetween(Short value1, Short value2) {
            addCriterion("PulseRate between", value1, value2, "pulserate");
            return (Criteria) this;
        }
        public Criteria andPulserateNotBetween(Short value1, Short value2) {
            addCriterion("PulseRate not between", value1, value2, "pulserate");
            return (Criteria) this;
        }
        public Criteria andSpoIsNull() {
            addCriterion("Spo is null");
            return (Criteria) this;
        }
        public Criteria andSpoIsNotNull() {
            addCriterion("Spo is not null");
            return (Criteria) this;
        }
        public Criteria andSpoEqualTo(Short value) {
            addCriterion("Spo =", value, "spo");
            return (Criteria) this;
        }
        public Criteria andSpoNotEqualTo(Short value) {
            addCriterion("Spo <>", value, "spo");
            return (Criteria) this;
        }
        public Criteria andSpoGreaterThan(Short value) {
            addCriterion("Spo >", value, "spo");
            return (Criteria) this;
        }
        public Criteria andSpoGreaterThanOrEqualTo(Short value) {
            addCriterion("Spo >=", value, "spo");
            return (Criteria) this;
        }
        public Criteria andSpoLessThan(Short value) {
            addCriterion("Spo <", value, "spo");
            return (Criteria) this;
        }
        public Criteria andSpoLessThanOrEqualTo(Short value) {
            addCriterion("Spo <=", value, "spo");
            return (Criteria) this;
        }
        public Criteria andSpoIn(List<Short> values) {
            addCriterion("Spo in", values, "spo");
            return (Criteria) this;
        }
        public Criteria andSpoNotIn(List<Short> values) {
            addCriterion("Spo not in", values, "spo");
            return (Criteria) this;
        }
        public Criteria andSpoBetween(Short value1, Short value2) {
            addCriterion("Spo between", value1, value2, "spo");
            return (Criteria) this;
        }
        public Criteria andSpoNotBetween(Short value1, Short value2) {
            addCriterion("Spo not between", value1, value2, "spo");
            return (Criteria) this;
        }
        public Criteria andSpo1IsNull() {
            addCriterion("SPO1 is null");
            return (Criteria) this;
        }
        public Criteria andSpo1IsNotNull() {
            addCriterion("SPO1 is not null");
            return (Criteria) this;
        }
        public Criteria andSpo1EqualTo(Short value) {
            addCriterion("SPO1 =", value, "spo1");
            return (Criteria) this;
        }
        public Criteria andSpo1NotEqualTo(Short value) {
            addCriterion("SPO1 <>", value, "spo1");
            return (Criteria) this;
        }
        public Criteria andSpo1GreaterThan(Short value) {
            addCriterion("SPO1 >", value, "spo1");
            return (Criteria) this;
        }
        public Criteria andSpo1GreaterThanOrEqualTo(Short value) {
            addCriterion("SPO1 >=", value, "spo1");
            return (Criteria) this;
        }
        public Criteria andSpo1LessThan(Short value) {
            addCriterion("SPO1 <", value, "spo1");
            return (Criteria) this;
        }
        public Criteria andSpo1LessThanOrEqualTo(Short value) {
            addCriterion("SPO1 <=", value, "spo1");
            return (Criteria) this;
        }
        public Criteria andSpo1In(List<Short> values) {
            addCriterion("SPO1 in", values, "spo1");
            return (Criteria) this;
        }
        public Criteria andSpo1NotIn(List<Short> values) {
            addCriterion("SPO1 not in", values, "spo1");
            return (Criteria) this;
        }
        public Criteria andSpo1Between(Short value1, Short value2) {
            addCriterion("SPO1 between", value1, value2, "spo1");
            return (Criteria) this;
        }
        public Criteria andSpo1NotBetween(Short value1, Short value2) {
            addCriterion("SPO1 not between", value1, value2, "spo1");
            return (Criteria) this;
        }
        public Criteria andCoIsNull() {
            addCriterion("CO is null");
            return (Criteria) this;
        }
        public Criteria andCoIsNotNull() {
            addCriterion("CO is not null");
            return (Criteria) this;
        }
        public Criteria andCoEqualTo(BigDecimal value) {
            addCriterion("CO =", value, "co");
            return (Criteria) this;
        }
        public Criteria andCoNotEqualTo(BigDecimal value) {
            addCriterion("CO <>", value, "co");
            return (Criteria) this;
        }
        public Criteria andCoGreaterThan(BigDecimal value) {
            addCriterion("CO >", value, "co");
            return (Criteria) this;
        }
        public Criteria andCoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CO >=", value, "co");
            return (Criteria) this;
        }
        public Criteria andCoLessThan(BigDecimal value) {
            addCriterion("CO <", value, "co");
            return (Criteria) this;
        }
        public Criteria andCoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CO <=", value, "co");
            return (Criteria) this;
        }
        public Criteria andCoIn(List<BigDecimal> values) {
            addCriterion("CO in", values, "co");
            return (Criteria) this;
        }
        public Criteria andCoNotIn(List<BigDecimal> values) {
            addCriterion("CO not in", values, "co");
            return (Criteria) this;
        }
        public Criteria andCoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CO between", value1, value2, "co");
            return (Criteria) this;
        }
        public Criteria andCoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CO not between", value1, value2, "co");
            return (Criteria) this;
        }
        public Criteria andSiIsNull() {
            addCriterion("SI is null");
            return (Criteria) this;
        }
        public Criteria andSiIsNotNull() {
            addCriterion("SI is not null");
            return (Criteria) this;
        }
        public Criteria andSiEqualTo(BigDecimal value) {
            addCriterion("SI =", value, "si");
            return (Criteria) this;
        }
        public Criteria andSiNotEqualTo(BigDecimal value) {
            addCriterion("SI <>", value, "si");
            return (Criteria) this;
        }
        public Criteria andSiGreaterThan(BigDecimal value) {
            addCriterion("SI >", value, "si");
            return (Criteria) this;
        }
        public Criteria andSiGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SI >=", value, "si");
            return (Criteria) this;
        }
        public Criteria andSiLessThan(BigDecimal value) {
            addCriterion("SI <", value, "si");
            return (Criteria) this;
        }
        public Criteria andSiLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SI <=", value, "si");
            return (Criteria) this;
        }
        public Criteria andSiIn(List<BigDecimal> values) {
            addCriterion("SI in", values, "si");
            return (Criteria) this;
        }
        public Criteria andSiNotIn(List<BigDecimal> values) {
            addCriterion("SI not in", values, "si");
            return (Criteria) this;
        }
        public Criteria andSiBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SI between", value1, value2, "si");
            return (Criteria) this;
        }
        public Criteria andSiNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SI not between", value1, value2, "si");
            return (Criteria) this;
        }
        public Criteria andSvIsNull() {
            addCriterion("SV is null");
            return (Criteria) this;
        }
        public Criteria andSvIsNotNull() {
            addCriterion("SV is not null");
            return (Criteria) this;
        }
        public Criteria andSvEqualTo(BigDecimal value) {
            addCriterion("SV =", value, "sv");
            return (Criteria) this;
        }
        public Criteria andSvNotEqualTo(BigDecimal value) {
            addCriterion("SV <>", value, "sv");
            return (Criteria) this;
        }
        public Criteria andSvGreaterThan(BigDecimal value) {
            addCriterion("SV >", value, "sv");
            return (Criteria) this;
        }
        public Criteria andSvGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SV >=", value, "sv");
            return (Criteria) this;
        }
        public Criteria andSvLessThan(BigDecimal value) {
            addCriterion("SV <", value, "sv");
            return (Criteria) this;
        }
        public Criteria andSvLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SV <=", value, "sv");
            return (Criteria) this;
        }
        public Criteria andSvIn(List<BigDecimal> values) {
            addCriterion("SV in", values, "sv");
            return (Criteria) this;
        }
        public Criteria andSvNotIn(List<BigDecimal> values) {
            addCriterion("SV not in", values, "sv");
            return (Criteria) this;
        }
        public Criteria andSvBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SV between", value1, value2, "sv");
            return (Criteria) this;
        }
        public Criteria andSvNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SV not between", value1, value2, "sv");
            return (Criteria) this;
        }
        public Criteria andCiIsNull() {
            addCriterion("CI is null");
            return (Criteria) this;
        }
        public Criteria andCiIsNotNull() {
            addCriterion("CI is not null");
            return (Criteria) this;
        }
        public Criteria andCiEqualTo(BigDecimal value) {
            addCriterion("CI =", value, "ci");
            return (Criteria) this;
        }
        public Criteria andCiNotEqualTo(BigDecimal value) {
            addCriterion("CI <>", value, "ci");
            return (Criteria) this;
        }
        public Criteria andCiGreaterThan(BigDecimal value) {
            addCriterion("CI >", value, "ci");
            return (Criteria) this;
        }
        public Criteria andCiGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CI >=", value, "ci");
            return (Criteria) this;
        }
        public Criteria andCiLessThan(BigDecimal value) {
            addCriterion("CI <", value, "ci");
            return (Criteria) this;
        }
        public Criteria andCiLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CI <=", value, "ci");
            return (Criteria) this;
        }
        public Criteria andCiIn(List<BigDecimal> values) {
            addCriterion("CI in", values, "ci");
            return (Criteria) this;
        }
        public Criteria andCiNotIn(List<BigDecimal> values) {
            addCriterion("CI not in", values, "ci");
            return (Criteria) this;
        }
        public Criteria andCiBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CI between", value1, value2, "ci");
            return (Criteria) this;
        }
        public Criteria andCiNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CI not between", value1, value2, "ci");
            return (Criteria) this;
        }
        public Criteria andSpiIsNull() {
            addCriterion("SPI is null");
            return (Criteria) this;
        }
        public Criteria andSpiIsNotNull() {
            addCriterion("SPI is not null");
            return (Criteria) this;
        }
        public Criteria andSpiEqualTo(BigDecimal value) {
            addCriterion("SPI =", value, "spi");
            return (Criteria) this;
        }
        public Criteria andSpiNotEqualTo(BigDecimal value) {
            addCriterion("SPI <>", value, "spi");
            return (Criteria) this;
        }
        public Criteria andSpiGreaterThan(BigDecimal value) {
            addCriterion("SPI >", value, "spi");
            return (Criteria) this;
        }
        public Criteria andSpiGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SPI >=", value, "spi");
            return (Criteria) this;
        }
        public Criteria andSpiLessThan(BigDecimal value) {
            addCriterion("SPI <", value, "spi");
            return (Criteria) this;
        }
        public Criteria andSpiLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SPI <=", value, "spi");
            return (Criteria) this;
        }
        public Criteria andSpiIn(List<BigDecimal> values) {
            addCriterion("SPI in", values, "spi");
            return (Criteria) this;
        }
        public Criteria andSpiNotIn(List<BigDecimal> values) {
            addCriterion("SPI not in", values, "spi");
            return (Criteria) this;
        }
        public Criteria andSpiBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPI between", value1, value2, "spi");
            return (Criteria) this;
        }
        public Criteria andSpiNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPI not between", value1, value2, "spi");
            return (Criteria) this;
        }
        public Criteria andKIsNull() {
            addCriterion("K is null");
            return (Criteria) this;
        }
        public Criteria andKIsNotNull() {
            addCriterion("K is not null");
            return (Criteria) this;
        }
        public Criteria andKEqualTo(BigDecimal value) {
            addCriterion("K =", value, "k");
            return (Criteria) this;
        }
        public Criteria andKNotEqualTo(BigDecimal value) {
            addCriterion("K <>", value, "k");
            return (Criteria) this;
        }
        public Criteria andKGreaterThan(BigDecimal value) {
            addCriterion("K >", value, "k");
            return (Criteria) this;
        }
        public Criteria andKGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("K >=", value, "k");
            return (Criteria) this;
        }
        public Criteria andKLessThan(BigDecimal value) {
            addCriterion("K <", value, "k");
            return (Criteria) this;
        }
        public Criteria andKLessThanOrEqualTo(BigDecimal value) {
            addCriterion("K <=", value, "k");
            return (Criteria) this;
        }
        public Criteria andKIn(List<BigDecimal> values) {
            addCriterion("K in", values, "k");
            return (Criteria) this;
        }
        public Criteria andKNotIn(List<BigDecimal> values) {
            addCriterion("K not in", values, "k");
            return (Criteria) this;
        }
        public Criteria andKBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("K between", value1, value2, "k");
            return (Criteria) this;
        }
        public Criteria andKNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("K not between", value1, value2, "k");
            return (Criteria) this;
        }
        public Criteria andK1IsNull() {
            addCriterion("K1 is null");
            return (Criteria) this;
        }
        public Criteria andK1IsNotNull() {
            addCriterion("K1 is not null");
            return (Criteria) this;
        }
        public Criteria andK1EqualTo(BigDecimal value) {
            addCriterion("K1 =", value, "k1");
            return (Criteria) this;
        }
        public Criteria andK1NotEqualTo(BigDecimal value) {
            addCriterion("K1 <>", value, "k1");
            return (Criteria) this;
        }
        public Criteria andK1GreaterThan(BigDecimal value) {
            addCriterion("K1 >", value, "k1");
            return (Criteria) this;
        }
        public Criteria andK1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("K1 >=", value, "k1");
            return (Criteria) this;
        }
        public Criteria andK1LessThan(BigDecimal value) {
            addCriterion("K1 <", value, "k1");
            return (Criteria) this;
        }
        public Criteria andK1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("K1 <=", value, "k1");
            return (Criteria) this;
        }
        public Criteria andK1In(List<BigDecimal> values) {
            addCriterion("K1 in", values, "k1");
            return (Criteria) this;
        }
        public Criteria andK1NotIn(List<BigDecimal> values) {
            addCriterion("K1 not in", values, "k1");
            return (Criteria) this;
        }
        public Criteria andK1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("K1 between", value1, value2, "k1");
            return (Criteria) this;
        }
        public Criteria andK1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("K1 not between", value1, value2, "k1");
            return (Criteria) this;
        }
        public Criteria andVIsNull() {
            addCriterion("V is null");
            return (Criteria) this;
        }
        public Criteria andVIsNotNull() {
            addCriterion("V is not null");
            return (Criteria) this;
        }
        public Criteria andVEqualTo(BigDecimal value) {
            addCriterion("V =", value, "v");
            return (Criteria) this;
        }
        public Criteria andVNotEqualTo(BigDecimal value) {
            addCriterion("V <>", value, "v");
            return (Criteria) this;
        }
        public Criteria andVGreaterThan(BigDecimal value) {
            addCriterion("V >", value, "v");
            return (Criteria) this;
        }
        public Criteria andVGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("V >=", value, "v");
            return (Criteria) this;
        }
        public Criteria andVLessThan(BigDecimal value) {
            addCriterion("V <", value, "v");
            return (Criteria) this;
        }
        public Criteria andVLessThanOrEqualTo(BigDecimal value) {
            addCriterion("V <=", value, "v");
            return (Criteria) this;
        }
        public Criteria andVIn(List<BigDecimal> values) {
            addCriterion("V in", values, "v");
            return (Criteria) this;
        }
        public Criteria andVNotIn(List<BigDecimal> values) {
            addCriterion("V not in", values, "v");
            return (Criteria) this;
        }
        public Criteria andVBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("V between", value1, value2, "v");
            return (Criteria) this;
        }
        public Criteria andVNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("V not between", value1, value2, "v");
            return (Criteria) this;
        }
        public Criteria andTprIsNull() {
            addCriterion("TPR is null");
            return (Criteria) this;
        }
        public Criteria andTprIsNotNull() {
            addCriterion("TPR is not null");
            return (Criteria) this;
        }
        public Criteria andTprEqualTo(BigDecimal value) {
            addCriterion("TPR =", value, "tpr");
            return (Criteria) this;
        }
        public Criteria andTprNotEqualTo(BigDecimal value) {
            addCriterion("TPR <>", value, "tpr");
            return (Criteria) this;
        }
        public Criteria andTprGreaterThan(BigDecimal value) {
            addCriterion("TPR >", value, "tpr");
            return (Criteria) this;
        }
        public Criteria andTprGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TPR >=", value, "tpr");
            return (Criteria) this;
        }
        public Criteria andTprLessThan(BigDecimal value) {
            addCriterion("TPR <", value, "tpr");
            return (Criteria) this;
        }
        public Criteria andTprLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TPR <=", value, "tpr");
            return (Criteria) this;
        }
        public Criteria andTprIn(List<BigDecimal> values) {
            addCriterion("TPR in", values, "tpr");
            return (Criteria) this;
        }
        public Criteria andTprNotIn(List<BigDecimal> values) {
            addCriterion("TPR not in", values, "tpr");
            return (Criteria) this;
        }
        public Criteria andTprBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TPR between", value1, value2, "tpr");
            return (Criteria) this;
        }
        public Criteria andTprNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TPR not between", value1, value2, "tpr");
            return (Criteria) this;
        }
        public Criteria andPwttIsNull() {
            addCriterion("PWTT is null");
            return (Criteria) this;
        }
        public Criteria andPwttIsNotNull() {
            addCriterion("PWTT is not null");
            return (Criteria) this;
        }
        public Criteria andPwttEqualTo(BigDecimal value) {
            addCriterion("PWTT =", value, "pwtt");
            return (Criteria) this;
        }
        public Criteria andPwttNotEqualTo(BigDecimal value) {
            addCriterion("PWTT <>", value, "pwtt");
            return (Criteria) this;
        }
        public Criteria andPwttGreaterThan(BigDecimal value) {
            addCriterion("PWTT >", value, "pwtt");
            return (Criteria) this;
        }
        public Criteria andPwttGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PWTT >=", value, "pwtt");
            return (Criteria) this;
        }
        public Criteria andPwttLessThan(BigDecimal value) {
            addCriterion("PWTT <", value, "pwtt");
            return (Criteria) this;
        }
        public Criteria andPwttLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PWTT <=", value, "pwtt");
            return (Criteria) this;
        }
        public Criteria andPwttIn(List<BigDecimal> values) {
            addCriterion("PWTT in", values, "pwtt");
            return (Criteria) this;
        }
        public Criteria andPwttNotIn(List<BigDecimal> values) {
            addCriterion("PWTT not in", values, "pwtt");
            return (Criteria) this;
        }
        public Criteria andPwttBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PWTT between", value1, value2, "pwtt");
            return (Criteria) this;
        }
        public Criteria andPwttNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PWTT not between", value1, value2, "pwtt");
            return (Criteria) this;
        }
        public Criteria andPmIsNull() {
            addCriterion("Pm is null");
            return (Criteria) this;
        }
        public Criteria andPmIsNotNull() {
            addCriterion("Pm is not null");
            return (Criteria) this;
        }
        public Criteria andPmEqualTo(BigDecimal value) {
            addCriterion("Pm =", value, "pm");
            return (Criteria) this;
        }
        public Criteria andPmNotEqualTo(BigDecimal value) {
            addCriterion("Pm <>", value, "pm");
            return (Criteria) this;
        }
        public Criteria andPmGreaterThan(BigDecimal value) {
            addCriterion("Pm >", value, "pm");
            return (Criteria) this;
        }
        public Criteria andPmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Pm >=", value, "pm");
            return (Criteria) this;
        }
        public Criteria andPmLessThan(BigDecimal value) {
            addCriterion("Pm <", value, "pm");
            return (Criteria) this;
        }
        public Criteria andPmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Pm <=", value, "pm");
            return (Criteria) this;
        }
        public Criteria andPmIn(List<BigDecimal> values) {
            addCriterion("Pm in", values, "pm");
            return (Criteria) this;
        }
        public Criteria andPmNotIn(List<BigDecimal> values) {
            addCriterion("Pm not in", values, "pm");
            return (Criteria) this;
        }
        public Criteria andPmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Pm between", value1, value2, "pm");
            return (Criteria) this;
        }
        public Criteria andPmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Pm not between", value1, value2, "pm");
            return (Criteria) this;
        }
        public Criteria andAcIsNull() {
            addCriterion("AC is null");
            return (Criteria) this;
        }
        public Criteria andAcIsNotNull() {
            addCriterion("AC is not null");
            return (Criteria) this;
        }
        public Criteria andAcEqualTo(BigDecimal value) {
            addCriterion("AC =", value, "ac");
            return (Criteria) this;
        }
        public Criteria andAcNotEqualTo(BigDecimal value) {
            addCriterion("AC <>", value, "ac");
            return (Criteria) this;
        }
        public Criteria andAcGreaterThan(BigDecimal value) {
            addCriterion("AC >", value, "ac");
            return (Criteria) this;
        }
        public Criteria andAcGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("AC >=", value, "ac");
            return (Criteria) this;
        }
        public Criteria andAcLessThan(BigDecimal value) {
            addCriterion("AC <", value, "ac");
            return (Criteria) this;
        }
        public Criteria andAcLessThanOrEqualTo(BigDecimal value) {
            addCriterion("AC <=", value, "ac");
            return (Criteria) this;
        }
        public Criteria andAcIn(List<BigDecimal> values) {
            addCriterion("AC in", values, "ac");
            return (Criteria) this;
        }
        public Criteria andAcNotIn(List<BigDecimal> values) {
            addCriterion("AC not in", values, "ac");
            return (Criteria) this;
        }
        public Criteria andAcBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AC between", value1, value2, "ac");
            return (Criteria) this;
        }
        public Criteria andAcNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("AC not between", value1, value2, "ac");
            return (Criteria) this;
        }
        public Criteria andImagenumIsNull() {
            addCriterion("ImageNum is null");
            return (Criteria) this;
        }
        public Criteria andImagenumIsNotNull() {
            addCriterion("ImageNum is not null");
            return (Criteria) this;
        }
        public Criteria andImagenumEqualTo(Short value) {
            addCriterion("ImageNum =", value, "imagenum");
            return (Criteria) this;
        }
        public Criteria andImagenumNotEqualTo(Short value) {
            addCriterion("ImageNum <>", value, "imagenum");
            return (Criteria) this;
        }
        public Criteria andImagenumGreaterThan(Short value) {
            addCriterion("ImageNum >", value, "imagenum");
            return (Criteria) this;
        }
        public Criteria andImagenumGreaterThanOrEqualTo(Short value) {
            addCriterion("ImageNum >=", value, "imagenum");
            return (Criteria) this;
        }
        public Criteria andImagenumLessThan(Short value) {
            addCriterion("ImageNum <", value, "imagenum");
            return (Criteria) this;
        }
        public Criteria andImagenumLessThanOrEqualTo(Short value) {
            addCriterion("ImageNum <=", value, "imagenum");
            return (Criteria) this;
        }
        public Criteria andImagenumIn(List<Short> values) {
            addCriterion("ImageNum in", values, "imagenum");
            return (Criteria) this;
        }
        public Criteria andImagenumNotIn(List<Short> values) {
            addCriterion("ImageNum not in", values, "imagenum");
            return (Criteria) this;
        }
        public Criteria andImagenumBetween(Short value1, Short value2) {
            addCriterion("ImageNum between", value1, value2, "imagenum");
            return (Criteria) this;
        }
        public Criteria andImagenumNotBetween(Short value1, Short value2) {
            addCriterion("ImageNum not between", value1, value2, "imagenum");
            return (Criteria) this;
        }
        public Criteria andPrlevelIsNull() {
            addCriterion("PRLevel is null");
            return (Criteria) this;
        }
        public Criteria andPrlevelIsNotNull() {
            addCriterion("PRLevel is not null");
            return (Criteria) this;
        }
        public Criteria andPrlevelEqualTo(Short value) {
            addCriterion("PRLevel =", value, "prlevel");
            return (Criteria) this;
        }
        public Criteria andPrlevelNotEqualTo(Short value) {
            addCriterion("PRLevel <>", value, "prlevel");
            return (Criteria) this;
        }
        public Criteria andPrlevelGreaterThan(Short value) {
            addCriterion("PRLevel >", value, "prlevel");
            return (Criteria) this;
        }
        public Criteria andPrlevelGreaterThanOrEqualTo(Short value) {
            addCriterion("PRLevel >=", value, "prlevel");
            return (Criteria) this;
        }
        public Criteria andPrlevelLessThan(Short value) {
            addCriterion("PRLevel <", value, "prlevel");
            return (Criteria) this;
        }
        public Criteria andPrlevelLessThanOrEqualTo(Short value) {
            addCriterion("PRLevel <=", value, "prlevel");
            return (Criteria) this;
        }
        public Criteria andPrlevelIn(List<Short> values) {
            addCriterion("PRLevel in", values, "prlevel");
            return (Criteria) this;
        }
        public Criteria andPrlevelNotIn(List<Short> values) {
            addCriterion("PRLevel not in", values, "prlevel");
            return (Criteria) this;
        }
        public Criteria andPrlevelBetween(Short value1, Short value2) {
            addCriterion("PRLevel between", value1, value2, "prlevel");
            return (Criteria) this;
        }
        public Criteria andPrlevelNotBetween(Short value1, Short value2) {
            addCriterion("PRLevel not between", value1, value2, "prlevel");
            return (Criteria) this;
        }
        public Criteria andKlevelIsNull() {
            addCriterion("KLevel is null");
            return (Criteria) this;
        }
        public Criteria andKlevelIsNotNull() {
            addCriterion("KLevel is not null");
            return (Criteria) this;
        }
        public Criteria andKlevelEqualTo(Short value) {
            addCriterion("KLevel =", value, "klevel");
            return (Criteria) this;
        }
        public Criteria andKlevelNotEqualTo(Short value) {
            addCriterion("KLevel <>", value, "klevel");
            return (Criteria) this;
        }
        public Criteria andKlevelGreaterThan(Short value) {
            addCriterion("KLevel >", value, "klevel");
            return (Criteria) this;
        }
        public Criteria andKlevelGreaterThanOrEqualTo(Short value) {
            addCriterion("KLevel >=", value, "klevel");
            return (Criteria) this;
        }
        public Criteria andKlevelLessThan(Short value) {
            addCriterion("KLevel <", value, "klevel");
            return (Criteria) this;
        }
        public Criteria andKlevelLessThanOrEqualTo(Short value) {
            addCriterion("KLevel <=", value, "klevel");
            return (Criteria) this;
        }
        public Criteria andKlevelIn(List<Short> values) {
            addCriterion("KLevel in", values, "klevel");
            return (Criteria) this;
        }
        public Criteria andKlevelNotIn(List<Short> values) {
            addCriterion("KLevel not in", values, "klevel");
            return (Criteria) this;
        }
        public Criteria andKlevelBetween(Short value1, Short value2) {
            addCriterion("KLevel between", value1, value2, "klevel");
            return (Criteria) this;
        }
        public Criteria andKlevelNotBetween(Short value1, Short value2) {
            addCriterion("KLevel not between", value1, value2, "klevel");
            return (Criteria) this;
        }
        public Criteria andSvlevelIsNull() {
            addCriterion("SVLevel is null");
            return (Criteria) this;
        }
        public Criteria andSvlevelIsNotNull() {
            addCriterion("SVLevel is not null");
            return (Criteria) this;
        }
        public Criteria andSvlevelEqualTo(Short value) {
            addCriterion("SVLevel =", value, "svlevel");
            return (Criteria) this;
        }
        public Criteria andSvlevelNotEqualTo(Short value) {
            addCriterion("SVLevel <>", value, "svlevel");
            return (Criteria) this;
        }
        public Criteria andSvlevelGreaterThan(Short value) {
            addCriterion("SVLevel >", value, "svlevel");
            return (Criteria) this;
        }
        public Criteria andSvlevelGreaterThanOrEqualTo(Short value) {
            addCriterion("SVLevel >=", value, "svlevel");
            return (Criteria) this;
        }
        public Criteria andSvlevelLessThan(Short value) {
            addCriterion("SVLevel <", value, "svlevel");
            return (Criteria) this;
        }
        public Criteria andSvlevelLessThanOrEqualTo(Short value) {
            addCriterion("SVLevel <=", value, "svlevel");
            return (Criteria) this;
        }
        public Criteria andSvlevelIn(List<Short> values) {
            addCriterion("SVLevel in", values, "svlevel");
            return (Criteria) this;
        }
        public Criteria andSvlevelNotIn(List<Short> values) {
            addCriterion("SVLevel not in", values, "svlevel");
            return (Criteria) this;
        }
        public Criteria andSvlevelBetween(Short value1, Short value2) {
            addCriterion("SVLevel between", value1, value2, "svlevel");
            return (Criteria) this;
        }
        public Criteria andSvlevelNotBetween(Short value1, Short value2) {
            addCriterion("SVLevel not between", value1, value2, "svlevel");
            return (Criteria) this;
        }
        public Criteria andColevelIsNull() {
            addCriterion("COLevel is null");
            return (Criteria) this;
        }
        public Criteria andColevelIsNotNull() {
            addCriterion("COLevel is not null");
            return (Criteria) this;
        }
        public Criteria andColevelEqualTo(Short value) {
            addCriterion("COLevel =", value, "colevel");
            return (Criteria) this;
        }
        public Criteria andColevelNotEqualTo(Short value) {
            addCriterion("COLevel <>", value, "colevel");
            return (Criteria) this;
        }
        public Criteria andColevelGreaterThan(Short value) {
            addCriterion("COLevel >", value, "colevel");
            return (Criteria) this;
        }
        public Criteria andColevelGreaterThanOrEqualTo(Short value) {
            addCriterion("COLevel >=", value, "colevel");
            return (Criteria) this;
        }
        public Criteria andColevelLessThan(Short value) {
            addCriterion("COLevel <", value, "colevel");
            return (Criteria) this;
        }
        public Criteria andColevelLessThanOrEqualTo(Short value) {
            addCriterion("COLevel <=", value, "colevel");
            return (Criteria) this;
        }
        public Criteria andColevelIn(List<Short> values) {
            addCriterion("COLevel in", values, "colevel");
            return (Criteria) this;
        }
        public Criteria andColevelNotIn(List<Short> values) {
            addCriterion("COLevel not in", values, "colevel");
            return (Criteria) this;
        }
        public Criteria andColevelBetween(Short value1, Short value2) {
            addCriterion("COLevel between", value1, value2, "colevel");
            return (Criteria) this;
        }
        public Criteria andColevelNotBetween(Short value1, Short value2) {
            addCriterion("COLevel not between", value1, value2, "colevel");
            return (Criteria) this;
        }
        public Criteria andAclevelIsNull() {
            addCriterion("ACLevel is null");
            return (Criteria) this;
        }
        public Criteria andAclevelIsNotNull() {
            addCriterion("ACLevel is not null");
            return (Criteria) this;
        }
        public Criteria andAclevelEqualTo(Short value) {
            addCriterion("ACLevel =", value, "aclevel");
            return (Criteria) this;
        }
        public Criteria andAclevelNotEqualTo(Short value) {
            addCriterion("ACLevel <>", value, "aclevel");
            return (Criteria) this;
        }
        public Criteria andAclevelGreaterThan(Short value) {
            addCriterion("ACLevel >", value, "aclevel");
            return (Criteria) this;
        }
        public Criteria andAclevelGreaterThanOrEqualTo(Short value) {
            addCriterion("ACLevel >=", value, "aclevel");
            return (Criteria) this;
        }
        public Criteria andAclevelLessThan(Short value) {
            addCriterion("ACLevel <", value, "aclevel");
            return (Criteria) this;
        }
        public Criteria andAclevelLessThanOrEqualTo(Short value) {
            addCriterion("ACLevel <=", value, "aclevel");
            return (Criteria) this;
        }
        public Criteria andAclevelIn(List<Short> values) {
            addCriterion("ACLevel in", values, "aclevel");
            return (Criteria) this;
        }
        public Criteria andAclevelNotIn(List<Short> values) {
            addCriterion("ACLevel not in", values, "aclevel");
            return (Criteria) this;
        }
        public Criteria andAclevelBetween(Short value1, Short value2) {
            addCriterion("ACLevel between", value1, value2, "aclevel");
            return (Criteria) this;
        }
        public Criteria andAclevelNotBetween(Short value1, Short value2) {
            addCriterion("ACLevel not between", value1, value2, "aclevel");
            return (Criteria) this;
        }
        public Criteria andSilevelIsNull() {
            addCriterion("SILevel is null");
            return (Criteria) this;
        }
        public Criteria andSilevelIsNotNull() {
            addCriterion("SILevel is not null");
            return (Criteria) this;
        }
        public Criteria andSilevelEqualTo(Short value) {
            addCriterion("SILevel =", value, "silevel");
            return (Criteria) this;
        }
        public Criteria andSilevelNotEqualTo(Short value) {
            addCriterion("SILevel <>", value, "silevel");
            return (Criteria) this;
        }
        public Criteria andSilevelGreaterThan(Short value) {
            addCriterion("SILevel >", value, "silevel");
            return (Criteria) this;
        }
        public Criteria andSilevelGreaterThanOrEqualTo(Short value) {
            addCriterion("SILevel >=", value, "silevel");
            return (Criteria) this;
        }
        public Criteria andSilevelLessThan(Short value) {
            addCriterion("SILevel <", value, "silevel");
            return (Criteria) this;
        }
        public Criteria andSilevelLessThanOrEqualTo(Short value) {
            addCriterion("SILevel <=", value, "silevel");
            return (Criteria) this;
        }
        public Criteria andSilevelIn(List<Short> values) {
            addCriterion("SILevel in", values, "silevel");
            return (Criteria) this;
        }
        public Criteria andSilevelNotIn(List<Short> values) {
            addCriterion("SILevel not in", values, "silevel");
            return (Criteria) this;
        }
        public Criteria andSilevelBetween(Short value1, Short value2) {
            addCriterion("SILevel between", value1, value2, "silevel");
            return (Criteria) this;
        }
        public Criteria andSilevelNotBetween(Short value1, Short value2) {
            addCriterion("SILevel not between", value1, value2, "silevel");
            return (Criteria) this;
        }
        public Criteria andVlevelIsNull() {
            addCriterion("VLevel is null");
            return (Criteria) this;
        }
        public Criteria andVlevelIsNotNull() {
            addCriterion("VLevel is not null");
            return (Criteria) this;
        }
        public Criteria andVlevelEqualTo(Short value) {
            addCriterion("VLevel =", value, "vlevel");
            return (Criteria) this;
        }
        public Criteria andVlevelNotEqualTo(Short value) {
            addCriterion("VLevel <>", value, "vlevel");
            return (Criteria) this;
        }
        public Criteria andVlevelGreaterThan(Short value) {
            addCriterion("VLevel >", value, "vlevel");
            return (Criteria) this;
        }
        public Criteria andVlevelGreaterThanOrEqualTo(Short value) {
            addCriterion("VLevel >=", value, "vlevel");
            return (Criteria) this;
        }
        public Criteria andVlevelLessThan(Short value) {
            addCriterion("VLevel <", value, "vlevel");
            return (Criteria) this;
        }
        public Criteria andVlevelLessThanOrEqualTo(Short value) {
            addCriterion("VLevel <=", value, "vlevel");
            return (Criteria) this;
        }
        public Criteria andVlevelIn(List<Short> values) {
            addCriterion("VLevel in", values, "vlevel");
            return (Criteria) this;
        }
        public Criteria andVlevelNotIn(List<Short> values) {
            addCriterion("VLevel not in", values, "vlevel");
            return (Criteria) this;
        }
        public Criteria andVlevelBetween(Short value1, Short value2) {
            addCriterion("VLevel between", value1, value2, "vlevel");
            return (Criteria) this;
        }
        public Criteria andVlevelNotBetween(Short value1, Short value2) {
            addCriterion("VLevel not between", value1, value2, "vlevel");
            return (Criteria) this;
        }
        public Criteria andTprlevelIsNull() {
            addCriterion("TPRLevel is null");
            return (Criteria) this;
        }
        public Criteria andTprlevelIsNotNull() {
            addCriterion("TPRLevel is not null");
            return (Criteria) this;
        }
        public Criteria andTprlevelEqualTo(Short value) {
            addCriterion("TPRLevel =", value, "tprlevel");
            return (Criteria) this;
        }
        public Criteria andTprlevelNotEqualTo(Short value) {
            addCriterion("TPRLevel <>", value, "tprlevel");
            return (Criteria) this;
        }
        public Criteria andTprlevelGreaterThan(Short value) {
            addCriterion("TPRLevel >", value, "tprlevel");
            return (Criteria) this;
        }
        public Criteria andTprlevelGreaterThanOrEqualTo(Short value) {
            addCriterion("TPRLevel >=", value, "tprlevel");
            return (Criteria) this;
        }
        public Criteria andTprlevelLessThan(Short value) {
            addCriterion("TPRLevel <", value, "tprlevel");
            return (Criteria) this;
        }
        public Criteria andTprlevelLessThanOrEqualTo(Short value) {
            addCriterion("TPRLevel <=", value, "tprlevel");
            return (Criteria) this;
        }
        public Criteria andTprlevelIn(List<Short> values) {
            addCriterion("TPRLevel in", values, "tprlevel");
            return (Criteria) this;
        }
        public Criteria andTprlevelNotIn(List<Short> values) {
            addCriterion("TPRLevel not in", values, "tprlevel");
            return (Criteria) this;
        }
        public Criteria andTprlevelBetween(Short value1, Short value2) {
            addCriterion("TPRLevel between", value1, value2, "tprlevel");
            return (Criteria) this;
        }
        public Criteria andTprlevelNotBetween(Short value1, Short value2) {
            addCriterion("TPRLevel not between", value1, value2, "tprlevel");
            return (Criteria) this;
        }
        public Criteria andSpolevelIsNull() {
            addCriterion("SPOLevel is null");
            return (Criteria) this;
        }
        public Criteria andSpolevelIsNotNull() {
            addCriterion("SPOLevel is not null");
            return (Criteria) this;
        }
        public Criteria andSpolevelEqualTo(Short value) {
            addCriterion("SPOLevel =", value, "spolevel");
            return (Criteria) this;
        }
        public Criteria andSpolevelNotEqualTo(Short value) {
            addCriterion("SPOLevel <>", value, "spolevel");
            return (Criteria) this;
        }
        public Criteria andSpolevelGreaterThan(Short value) {
            addCriterion("SPOLevel >", value, "spolevel");
            return (Criteria) this;
        }
        public Criteria andSpolevelGreaterThanOrEqualTo(Short value) {
            addCriterion("SPOLevel >=", value, "spolevel");
            return (Criteria) this;
        }
        public Criteria andSpolevelLessThan(Short value) {
            addCriterion("SPOLevel <", value, "spolevel");
            return (Criteria) this;
        }
        public Criteria andSpolevelLessThanOrEqualTo(Short value) {
            addCriterion("SPOLevel <=", value, "spolevel");
            return (Criteria) this;
        }
        public Criteria andSpolevelIn(List<Short> values) {
            addCriterion("SPOLevel in", values, "spolevel");
            return (Criteria) this;
        }
        public Criteria andSpolevelNotIn(List<Short> values) {
            addCriterion("SPOLevel not in", values, "spolevel");
            return (Criteria) this;
        }
        public Criteria andSpolevelBetween(Short value1, Short value2) {
            addCriterion("SPOLevel between", value1, value2, "spolevel");
            return (Criteria) this;
        }
        public Criteria andSpolevelNotBetween(Short value1, Short value2) {
            addCriterion("SPOLevel not between", value1, value2, "spolevel");
            return (Criteria) this;
        }
        public Criteria andCilevelIsNull() {
            addCriterion("CILevel is null");
            return (Criteria) this;
        }
        public Criteria andCilevelIsNotNull() {
            addCriterion("CILevel is not null");
            return (Criteria) this;
        }
        public Criteria andCilevelEqualTo(Short value) {
            addCriterion("CILevel =", value, "cilevel");
            return (Criteria) this;
        }
        public Criteria andCilevelNotEqualTo(Short value) {
            addCriterion("CILevel <>", value, "cilevel");
            return (Criteria) this;
        }
        public Criteria andCilevelGreaterThan(Short value) {
            addCriterion("CILevel >", value, "cilevel");
            return (Criteria) this;
        }
        public Criteria andCilevelGreaterThanOrEqualTo(Short value) {
            addCriterion("CILevel >=", value, "cilevel");
            return (Criteria) this;
        }
        public Criteria andCilevelLessThan(Short value) {
            addCriterion("CILevel <", value, "cilevel");
            return (Criteria) this;
        }
        public Criteria andCilevelLessThanOrEqualTo(Short value) {
            addCriterion("CILevel <=", value, "cilevel");
            return (Criteria) this;
        }
        public Criteria andCilevelIn(List<Short> values) {
            addCriterion("CILevel in", values, "cilevel");
            return (Criteria) this;
        }
        public Criteria andCilevelNotIn(List<Short> values) {
            addCriterion("CILevel not in", values, "cilevel");
            return (Criteria) this;
        }
        public Criteria andCilevelBetween(Short value1, Short value2) {
            addCriterion("CILevel between", value1, value2, "cilevel");
            return (Criteria) this;
        }
        public Criteria andCilevelNotBetween(Short value1, Short value2) {
            addCriterion("CILevel not between", value1, value2, "cilevel");
            return (Criteria) this;
        }
        public Criteria andSpilevelIsNull() {
            addCriterion("SPILevel is null");
            return (Criteria) this;
        }
        public Criteria andSpilevelIsNotNull() {
            addCriterion("SPILevel is not null");
            return (Criteria) this;
        }
        public Criteria andSpilevelEqualTo(Short value) {
            addCriterion("SPILevel =", value, "spilevel");
            return (Criteria) this;
        }
        public Criteria andSpilevelNotEqualTo(Short value) {
            addCriterion("SPILevel <>", value, "spilevel");
            return (Criteria) this;
        }
        public Criteria andSpilevelGreaterThan(Short value) {
            addCriterion("SPILevel >", value, "spilevel");
            return (Criteria) this;
        }
        public Criteria andSpilevelGreaterThanOrEqualTo(Short value) {
            addCriterion("SPILevel >=", value, "spilevel");
            return (Criteria) this;
        }
        public Criteria andSpilevelLessThan(Short value) {
            addCriterion("SPILevel <", value, "spilevel");
            return (Criteria) this;
        }
        public Criteria andSpilevelLessThanOrEqualTo(Short value) {
            addCriterion("SPILevel <=", value, "spilevel");
            return (Criteria) this;
        }
        public Criteria andSpilevelIn(List<Short> values) {
            addCriterion("SPILevel in", values, "spilevel");
            return (Criteria) this;
        }
        public Criteria andSpilevelNotIn(List<Short> values) {
            addCriterion("SPILevel not in", values, "spilevel");
            return (Criteria) this;
        }
        public Criteria andSpilevelBetween(Short value1, Short value2) {
            addCriterion("SPILevel between", value1, value2, "spilevel");
            return (Criteria) this;
        }
        public Criteria andSpilevelNotBetween(Short value1, Short value2) {
            addCriterion("SPILevel not between", value1, value2, "spilevel");
            return (Criteria) this;
        }
        public Criteria andPwttlevelIsNull() {
            addCriterion("PWTTLevel is null");
            return (Criteria) this;
        }
        public Criteria andPwttlevelIsNotNull() {
            addCriterion("PWTTLevel is not null");
            return (Criteria) this;
        }
        public Criteria andPwttlevelEqualTo(Short value) {
            addCriterion("PWTTLevel =", value, "pwttlevel");
            return (Criteria) this;
        }
        public Criteria andPwttlevelNotEqualTo(Short value) {
            addCriterion("PWTTLevel <>", value, "pwttlevel");
            return (Criteria) this;
        }
        public Criteria andPwttlevelGreaterThan(Short value) {
            addCriterion("PWTTLevel >", value, "pwttlevel");
            return (Criteria) this;
        }
        public Criteria andPwttlevelGreaterThanOrEqualTo(Short value) {
            addCriterion("PWTTLevel >=", value, "pwttlevel");
            return (Criteria) this;
        }
        public Criteria andPwttlevelLessThan(Short value) {
            addCriterion("PWTTLevel <", value, "pwttlevel");
            return (Criteria) this;
        }
        public Criteria andPwttlevelLessThanOrEqualTo(Short value) {
            addCriterion("PWTTLevel <=", value, "pwttlevel");
            return (Criteria) this;
        }
        public Criteria andPwttlevelIn(List<Short> values) {
            addCriterion("PWTTLevel in", values, "pwttlevel");
            return (Criteria) this;
        }
        public Criteria andPwttlevelNotIn(List<Short> values) {
            addCriterion("PWTTLevel not in", values, "pwttlevel");
            return (Criteria) this;
        }
        public Criteria andPwttlevelBetween(Short value1, Short value2) {
            addCriterion("PWTTLevel between", value1, value2, "pwttlevel");
            return (Criteria) this;
        }
        public Criteria andPwttlevelNotBetween(Short value1, Short value2) {
            addCriterion("PWTTLevel not between", value1, value2, "pwttlevel");
            return (Criteria) this;
        }
        public Criteria andAbnormaldataIsNull() {
            addCriterion("AbnormalData is null");
            return (Criteria) this;
        }
        public Criteria andAbnormaldataIsNotNull() {
            addCriterion("AbnormalData is not null");
            return (Criteria) this;
        }
        public Criteria andAbnormaldataEqualTo(Integer value) {
            addCriterion("AbnormalData =", value, "abnormaldata");
            return (Criteria) this;
        }
        public Criteria andAbnormaldataNotEqualTo(Integer value) {
            addCriterion("AbnormalData <>", value, "abnormaldata");
            return (Criteria) this;
        }
        public Criteria andAbnormaldataGreaterThan(Integer value) {
            addCriterion("AbnormalData >", value, "abnormaldata");
            return (Criteria) this;
        }
        public Criteria andAbnormaldataGreaterThanOrEqualTo(Integer value) {
            addCriterion("AbnormalData >=", value, "abnormaldata");
            return (Criteria) this;
        }
        public Criteria andAbnormaldataLessThan(Integer value) {
            addCriterion("AbnormalData <", value, "abnormaldata");
            return (Criteria) this;
        }
        public Criteria andAbnormaldataLessThanOrEqualTo(Integer value) {
            addCriterion("AbnormalData <=", value, "abnormaldata");
            return (Criteria) this;
        }
        public Criteria andAbnormaldataIn(List<Integer> values) {
            addCriterion("AbnormalData in", values, "abnormaldata");
            return (Criteria) this;
        }
        public Criteria andAbnormaldataNotIn(List<Integer> values) {
            addCriterion("AbnormalData not in", values, "abnormaldata");
            return (Criteria) this;
        }
        public Criteria andAbnormaldataBetween(Integer value1, Integer value2) {
            addCriterion("AbnormalData between", value1, value2, "abnormaldata");
            return (Criteria) this;
        }
        public Criteria andAbnormaldataNotBetween(Integer value1, Integer value2) {
            addCriterion("AbnormalData not between", value1, value2, "abnormaldata");
            return (Criteria) this;
        }
        public Criteria andPpgrrIsNull() {
            addCriterion("Ppgrr is null");
            return (Criteria) this;
        }
        public Criteria andPpgrrIsNotNull() {
            addCriterion("Ppgrr is not null");
            return (Criteria) this;
        }
        public Criteria andPpgrrEqualTo(String value) {
            addCriterion("Ppgrr =", value, "ppgrr");
            return (Criteria) this;
        }
        public Criteria andPpgrrNotEqualTo(String value) {
            addCriterion("Ppgrr <>", value, "ppgrr");
            return (Criteria) this;
        }
        public Criteria andPpgrrGreaterThan(String value) {
            addCriterion("Ppgrr >", value, "ppgrr");
            return (Criteria) this;
        }
        public Criteria andPpgrrGreaterThanOrEqualTo(String value) {
            addCriterion("Ppgrr >=", value, "ppgrr");
            return (Criteria) this;
        }
        public Criteria andPpgrrLessThan(String value) {
            addCriterion("Ppgrr <", value, "ppgrr");
            return (Criteria) this;
        }
        public Criteria andPpgrrLessThanOrEqualTo(String value) {
            addCriterion("Ppgrr <=", value, "ppgrr");
            return (Criteria) this;
        }
        public Criteria andPpgrrLike(String value) {
            addCriterion("Ppgrr like", value, "ppgrr");
            return (Criteria) this;
        }
        public Criteria andPpgrrNotLike(String value) {
            addCriterion("Ppgrr not like", value, "ppgrr");
            return (Criteria) this;
        }
        public Criteria andPpgrrIn(List<String> values) {
            addCriterion("Ppgrr in", values, "ppgrr");
            return (Criteria) this;
        }
        public Criteria andPpgrrNotIn(List<String> values) {
            addCriterion("Ppgrr not in", values, "ppgrr");
            return (Criteria) this;
        }
        public Criteria andPpgrrBetween(String value1, String value2) {
            addCriterion("Ppgrr between", value1, value2, "ppgrr");
            return (Criteria) this;
        }
        public Criteria andPpgrrNotBetween(String value1, String value2) {
            addCriterion("Ppgrr not between", value1, value2, "ppgrr");
            return (Criteria) this;
        }
        public Criteria andRawppgIsNull() {
            addCriterion("RawPPG is null");
            return (Criteria) this;
        }
        public Criteria andRawppgIsNotNull() {
            addCriterion("RawPPG is not null");
            return (Criteria) this;
        }
        public Criteria andRawppgEqualTo(String value) {
            addCriterion("RawPPG =", value, "rawppg");
            return (Criteria) this;
        }
        public Criteria andRawppgNotEqualTo(String value) {
            addCriterion("RawPPG <>", value, "rawppg");
            return (Criteria) this;
        }
        public Criteria andRawppgGreaterThan(String value) {
            addCriterion("RawPPG >", value, "rawppg");
            return (Criteria) this;
        }
        public Criteria andRawppgGreaterThanOrEqualTo(String value) {
            addCriterion("RawPPG >=", value, "rawppg");
            return (Criteria) this;
        }
        public Criteria andRawppgLessThan(String value) {
            addCriterion("RawPPG <", value, "rawppg");
            return (Criteria) this;
        }
        public Criteria andRawppgLessThanOrEqualTo(String value) {
            addCriterion("RawPPG <=", value, "rawppg");
            return (Criteria) this;
        }
        public Criteria andRawppgLike(String value) {
            addCriterion("RawPPG like", value, "rawppg");
            return (Criteria) this;
        }
        public Criteria andRawppgNotLike(String value) {
            addCriterion("RawPPG not like", value, "rawppg");
            return (Criteria) this;
        }
        public Criteria andRawppgIn(List<String> values) {
            addCriterion("RawPPG in", values, "rawppg");
            return (Criteria) this;
        }
        public Criteria andRawppgNotIn(List<String> values) {
            addCriterion("RawPPG not in", values, "rawppg");
            return (Criteria) this;
        }
        public Criteria andRawppgBetween(String value1, String value2) {
            addCriterion("RawPPG between", value1, value2, "rawppg");
            return (Criteria) this;
        }
        public Criteria andRawppgNotBetween(String value1, String value2) {
            addCriterion("RawPPG not between", value1, value2, "rawppg");
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
        public Criteria andIcountIsNull() {
            addCriterion("ICount is null");
            return (Criteria) this;
        }
        public Criteria andIcountIsNotNull() {
            addCriterion("ICount is not null");
            return (Criteria) this;
        }
        public Criteria andIcountEqualTo(Short value) {
            addCriterion("ICount =", value, "icount");
            return (Criteria) this;
        }
        public Criteria andIcountNotEqualTo(Short value) {
            addCriterion("ICount <>", value, "icount");
            return (Criteria) this;
        }
        public Criteria andIcountGreaterThan(Short value) {
            addCriterion("ICount >", value, "icount");
            return (Criteria) this;
        }
        public Criteria andIcountGreaterThanOrEqualTo(Short value) {
            addCriterion("ICount >=", value, "icount");
            return (Criteria) this;
        }
        public Criteria andIcountLessThan(Short value) {
            addCriterion("ICount <", value, "icount");
            return (Criteria) this;
        }
        public Criteria andIcountLessThanOrEqualTo(Short value) {
            addCriterion("ICount <=", value, "icount");
            return (Criteria) this;
        }
        public Criteria andIcountIn(List<Short> values) {
            addCriterion("ICount in", values, "icount");
            return (Criteria) this;
        }
        public Criteria andIcountNotIn(List<Short> values) {
            addCriterion("ICount not in", values, "icount");
            return (Criteria) this;
        }
        public Criteria andIcountBetween(Short value1, Short value2) {
            addCriterion("ICount between", value1, value2, "icount");
            return (Criteria) this;
        }
        public Criteria andIcountNotBetween(Short value1, Short value2) {
            addCriterion("ICount not between", value1, value2, "icount");
            return (Criteria) this;
        }
        public Criteria andAddvalueIsNull() {
            addCriterion("AddValue is null");
            return (Criteria) this;
        }
        public Criteria andAddvalueIsNotNull() {
            addCriterion("AddValue is not null");
            return (Criteria) this;
        }
        public Criteria andAddvalueEqualTo(Integer value) {
            addCriterion("AddValue =", value, "addvalue");
            return (Criteria) this;
        }
        public Criteria andAddvalueNotEqualTo(Integer value) {
            addCriterion("AddValue <>", value, "addvalue");
            return (Criteria) this;
        }
        public Criteria andAddvalueGreaterThan(Integer value) {
            addCriterion("AddValue >", value, "addvalue");
            return (Criteria) this;
        }
        public Criteria andAddvalueGreaterThanOrEqualTo(Integer value) {
            addCriterion("AddValue >=", value, "addvalue");
            return (Criteria) this;
        }
        public Criteria andAddvalueLessThan(Integer value) {
            addCriterion("AddValue <", value, "addvalue");
            return (Criteria) this;
        }
        public Criteria andAddvalueLessThanOrEqualTo(Integer value) {
            addCriterion("AddValue <=", value, "addvalue");
            return (Criteria) this;
        }
        public Criteria andAddvalueIn(List<Integer> values) {
            addCriterion("AddValue in", values, "addvalue");
            return (Criteria) this;
        }
        public Criteria andAddvalueNotIn(List<Integer> values) {
            addCriterion("AddValue not in", values, "addvalue");
            return (Criteria) this;
        }
        public Criteria andAddvalueBetween(Integer value1, Integer value2) {
            addCriterion("AddValue between", value1, value2, "addvalue");
            return (Criteria) this;
        }
        public Criteria andAddvalueNotBetween(Integer value1, Integer value2) {
            addCriterion("AddValue not between", value1, value2, "addvalue");
            return (Criteria) this;
        }
        public Criteria andFsIsNull() {
            addCriterion("Fs is null");
            return (Criteria) this;
        }
        public Criteria andFsIsNotNull() {
            addCriterion("Fs is not null");
            return (Criteria) this;
        }
        public Criteria andFsEqualTo(Short value) {
            addCriterion("Fs =", value, "fs");
            return (Criteria) this;
        }
        public Criteria andFsNotEqualTo(Short value) {
            addCriterion("Fs <>", value, "fs");
            return (Criteria) this;
        }
        public Criteria andFsGreaterThan(Short value) {
            addCriterion("Fs >", value, "fs");
            return (Criteria) this;
        }
        public Criteria andFsGreaterThanOrEqualTo(Short value) {
            addCriterion("Fs >=", value, "fs");
            return (Criteria) this;
        }
        public Criteria andFsLessThan(Short value) {
            addCriterion("Fs <", value, "fs");
            return (Criteria) this;
        }
        public Criteria andFsLessThanOrEqualTo(Short value) {
            addCriterion("Fs <=", value, "fs");
            return (Criteria) this;
        }
        public Criteria andFsIn(List<Short> values) {
            addCriterion("Fs in", values, "fs");
            return (Criteria) this;
        }
        public Criteria andFsNotIn(List<Short> values) {
            addCriterion("Fs not in", values, "fs");
            return (Criteria) this;
        }
        public Criteria andFsBetween(Short value1, Short value2) {
            addCriterion("Fs between", value1, value2, "fs");
            return (Criteria) this;
        }
        public Criteria andFsNotBetween(Short value1, Short value2) {
            addCriterion("Fs not between", value1, value2, "fs");
            return (Criteria) this;
        }
        public Criteria andPpgresultIsNull() {
            addCriterion("PPGResult is null");
            return (Criteria) this;
        }
        public Criteria andPpgresultIsNotNull() {
            addCriterion("PPGResult is not null");
            return (Criteria) this;
        }
        public Criteria andPpgresultEqualTo(Short value) {
            addCriterion("PPGResult =", value, "ppgresult");
            return (Criteria) this;
        }
        public Criteria andPpgresultNotEqualTo(Short value) {
            addCriterion("PPGResult <>", value, "ppgresult");
            return (Criteria) this;
        }
        public Criteria andPpgresultGreaterThan(Short value) {
            addCriterion("PPGResult >", value, "ppgresult");
            return (Criteria) this;
        }
        public Criteria andPpgresultGreaterThanOrEqualTo(Short value) {
            addCriterion("PPGResult >=", value, "ppgresult");
            return (Criteria) this;
        }
        public Criteria andPpgresultLessThan(Short value) {
            addCriterion("PPGResult <", value, "ppgresult");
            return (Criteria) this;
        }
        public Criteria andPpgresultLessThanOrEqualTo(Short value) {
            addCriterion("PPGResult <=", value, "ppgresult");
            return (Criteria) this;
        }
        public Criteria andPpgresultIn(List<Short> values) {
            addCriterion("PPGResult in", values, "ppgresult");
            return (Criteria) this;
        }
        public Criteria andPpgresultNotIn(List<Short> values) {
            addCriterion("PPGResult not in", values, "ppgresult");
            return (Criteria) this;
        }
        public Criteria andPpgresultBetween(Short value1, Short value2) {
            addCriterion("PPGResult between", value1, value2, "ppgresult");
            return (Criteria) this;
        }
        public Criteria andPpgresultNotBetween(Short value1, Short value2) {
            addCriterion("PPGResult not between", value1, value2, "ppgresult");
            return (Criteria) this;
        }
        public Criteria andStatustagIsNull() {
            addCriterion("StatusTag is null");
            return (Criteria) this;
        }
        public Criteria andStatustagIsNotNull() {
            addCriterion("StatusTag is not null");
            return (Criteria) this;
        }
        public Criteria andStatustagEqualTo(Short value) {
            addCriterion("StatusTag =", value, "statustag");
            return (Criteria) this;
        }
        public Criteria andStatustagNotEqualTo(Short value) {
            addCriterion("StatusTag <>", value, "statustag");
            return (Criteria) this;
        }
        public Criteria andStatustagGreaterThan(Short value) {
            addCriterion("StatusTag >", value, "statustag");
            return (Criteria) this;
        }
        public Criteria andStatustagGreaterThanOrEqualTo(Short value) {
            addCriterion("StatusTag >=", value, "statustag");
            return (Criteria) this;
        }
        public Criteria andStatustagLessThan(Short value) {
            addCriterion("StatusTag <", value, "statustag");
            return (Criteria) this;
        }
        public Criteria andStatustagLessThanOrEqualTo(Short value) {
            addCriterion("StatusTag <=", value, "statustag");
            return (Criteria) this;
        }
        public Criteria andStatustagIn(List<Short> values) {
            addCriterion("StatusTag in", values, "statustag");
            return (Criteria) this;
        }
        public Criteria andStatustagNotIn(List<Short> values) {
            addCriterion("StatusTag not in", values, "statustag");
            return (Criteria) this;
        }
        public Criteria andStatustagBetween(Short value1, Short value2) {
            addCriterion("StatusTag between", value1, value2, "statustag");
            return (Criteria) this;
        }
        public Criteria andStatustagNotBetween(Short value1, Short value2) {
            addCriterion("StatusTag not between", value1, value2, "statustag");
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
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 脉搏测量表（OPPG）
     * 
     * @author ${user}
     * @version 1.0 2016-07-12
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