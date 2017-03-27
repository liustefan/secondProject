/*
 * OecgExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-11 Created
 */
package com.bithealth.measureCore.electrocardio.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OecgExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public OecgExample() {
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
     * 心电测量表(OECG)
     * 
     * @author ${user}
     * @version 1.0 2016-07-11
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
        public Criteria andEcgtimeIsNull() {
            addCriterion("EcgTime is null");
            return (Criteria) this;
        }
        public Criteria andEcgtimeIsNotNull() {
            addCriterion("EcgTime is not null");
            return (Criteria) this;
        }
        public Criteria andEcgtimeEqualTo(Date value) {
            addCriterion("EcgTime =", value, "ecgtime");
            return (Criteria) this;
        }
        public Criteria andEcgtimeNotEqualTo(Date value) {
            addCriterion("EcgTime <>", value, "ecgtime");
            return (Criteria) this;
        }
        public Criteria andEcgtimeGreaterThan(Date value) {
            addCriterion("EcgTime >", value, "ecgtime");
            return (Criteria) this;
        }
        public Criteria andEcgtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EcgTime >=", value, "ecgtime");
            return (Criteria) this;
        }
        public Criteria andEcgtimeLessThan(Date value) {
            addCriterion("EcgTime <", value, "ecgtime");
            return (Criteria) this;
        }
        public Criteria andEcgtimeLessThanOrEqualTo(Date value) {
            addCriterion("EcgTime <=", value, "ecgtime");
            return (Criteria) this;
        }
        public Criteria andEcgtimeIn(List<Date> values) {
            addCriterion("EcgTime in", values, "ecgtime");
            return (Criteria) this;
        }
        public Criteria andEcgtimeNotIn(List<Date> values) {
            addCriterion("EcgTime not in", values, "ecgtime");
            return (Criteria) this;
        }
        public Criteria andEcgtimeBetween(Date value1, Date value2) {
            addCriterion("EcgTime between", value1, value2, "ecgtime");
            return (Criteria) this;
        }
        public Criteria andEcgtimeNotBetween(Date value1, Date value2) {
            addCriterion("EcgTime not between", value1, value2, "ecgtime");
            return (Criteria) this;
        }
        public Criteria andMeastimeIsNull() {
            addCriterion("MeasTime is null");
            return (Criteria) this;
        }
        public Criteria andMeastimeIsNotNull() {
            addCriterion("MeasTime is not null");
            return (Criteria) this;
        }
        public Criteria andMeastimeEqualTo(Date value) {
            addCriterion("MeasTime =", value, "meastime");
            return (Criteria) this;
        }
        public Criteria andMeastimeNotEqualTo(Date value) {
            addCriterion("MeasTime <>", value, "meastime");
            return (Criteria) this;
        }
        public Criteria andMeastimeGreaterThan(Date value) {
            addCriterion("MeasTime >", value, "meastime");
            return (Criteria) this;
        }
        public Criteria andMeastimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MeasTime >=", value, "meastime");
            return (Criteria) this;
        }
        public Criteria andMeastimeLessThan(Date value) {
            addCriterion("MeasTime <", value, "meastime");
            return (Criteria) this;
        }
        public Criteria andMeastimeLessThanOrEqualTo(Date value) {
            addCriterion("MeasTime <=", value, "meastime");
            return (Criteria) this;
        }
        public Criteria andMeastimeIn(List<Date> values) {
            addCriterion("MeasTime in", values, "meastime");
            return (Criteria) this;
        }
        public Criteria andMeastimeNotIn(List<Date> values) {
            addCriterion("MeasTime not in", values, "meastime");
            return (Criteria) this;
        }
        public Criteria andMeastimeBetween(Date value1, Date value2) {
            addCriterion("MeasTime between", value1, value2, "meastime");
            return (Criteria) this;
        }
        public Criteria andMeastimeNotBetween(Date value1, Date value2) {
            addCriterion("MeasTime not between", value1, value2, "meastime");
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
        public Criteria andHeartnumIsNull() {
            addCriterion("HeartNum is null");
            return (Criteria) this;
        }
        public Criteria andHeartnumIsNotNull() {
            addCriterion("HeartNum is not null");
            return (Criteria) this;
        }
        public Criteria andHeartnumEqualTo(Integer value) {
            addCriterion("HeartNum =", value, "heartnum");
            return (Criteria) this;
        }
        public Criteria andHeartnumNotEqualTo(Integer value) {
            addCriterion("HeartNum <>", value, "heartnum");
            return (Criteria) this;
        }
        public Criteria andHeartnumGreaterThan(Integer value) {
            addCriterion("HeartNum >", value, "heartnum");
            return (Criteria) this;
        }
        public Criteria andHeartnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("HeartNum >=", value, "heartnum");
            return (Criteria) this;
        }
        public Criteria andHeartnumLessThan(Integer value) {
            addCriterion("HeartNum <", value, "heartnum");
            return (Criteria) this;
        }
        public Criteria andHeartnumLessThanOrEqualTo(Integer value) {
            addCriterion("HeartNum <=", value, "heartnum");
            return (Criteria) this;
        }
        public Criteria andHeartnumIn(List<Integer> values) {
            addCriterion("HeartNum in", values, "heartnum");
            return (Criteria) this;
        }
        public Criteria andHeartnumNotIn(List<Integer> values) {
            addCriterion("HeartNum not in", values, "heartnum");
            return (Criteria) this;
        }
        public Criteria andHeartnumBetween(Integer value1, Integer value2) {
            addCriterion("HeartNum between", value1, value2, "heartnum");
            return (Criteria) this;
        }
        public Criteria andHeartnumNotBetween(Integer value1, Integer value2) {
            addCriterion("HeartNum not between", value1, value2, "heartnum");
            return (Criteria) this;
        }
        public Criteria andSlowestbeatIsNull() {
            addCriterion("SlowestBeat is null");
            return (Criteria) this;
        }
        public Criteria andSlowestbeatIsNotNull() {
            addCriterion("SlowestBeat is not null");
            return (Criteria) this;
        }
        public Criteria andSlowestbeatEqualTo(Short value) {
            addCriterion("SlowestBeat =", value, "slowestbeat");
            return (Criteria) this;
        }
        public Criteria andSlowestbeatNotEqualTo(Short value) {
            addCriterion("SlowestBeat <>", value, "slowestbeat");
            return (Criteria) this;
        }
        public Criteria andSlowestbeatGreaterThan(Short value) {
            addCriterion("SlowestBeat >", value, "slowestbeat");
            return (Criteria) this;
        }
        public Criteria andSlowestbeatGreaterThanOrEqualTo(Short value) {
            addCriterion("SlowestBeat >=", value, "slowestbeat");
            return (Criteria) this;
        }
        public Criteria andSlowestbeatLessThan(Short value) {
            addCriterion("SlowestBeat <", value, "slowestbeat");
            return (Criteria) this;
        }
        public Criteria andSlowestbeatLessThanOrEqualTo(Short value) {
            addCriterion("SlowestBeat <=", value, "slowestbeat");
            return (Criteria) this;
        }
        public Criteria andSlowestbeatIn(List<Short> values) {
            addCriterion("SlowestBeat in", values, "slowestbeat");
            return (Criteria) this;
        }
        public Criteria andSlowestbeatNotIn(List<Short> values) {
            addCriterion("SlowestBeat not in", values, "slowestbeat");
            return (Criteria) this;
        }
        public Criteria andSlowestbeatBetween(Short value1, Short value2) {
            addCriterion("SlowestBeat between", value1, value2, "slowestbeat");
            return (Criteria) this;
        }
        public Criteria andSlowestbeatNotBetween(Short value1, Short value2) {
            addCriterion("SlowestBeat not between", value1, value2, "slowestbeat");
            return (Criteria) this;
        }
        public Criteria andSlowesttimeIsNull() {
            addCriterion("SlowestTime is null");
            return (Criteria) this;
        }
        public Criteria andSlowesttimeIsNotNull() {
            addCriterion("SlowestTime is not null");
            return (Criteria) this;
        }
        public Criteria andSlowesttimeEqualTo(Integer value) {
            addCriterion("SlowestTime =", value, "slowesttime");
            return (Criteria) this;
        }
        public Criteria andSlowesttimeNotEqualTo(Integer value) {
            addCriterion("SlowestTime <>", value, "slowesttime");
            return (Criteria) this;
        }
        public Criteria andSlowesttimeGreaterThan(Integer value) {
            addCriterion("SlowestTime >", value, "slowesttime");
            return (Criteria) this;
        }
        public Criteria andSlowesttimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SlowestTime >=", value, "slowesttime");
            return (Criteria) this;
        }
        public Criteria andSlowesttimeLessThan(Integer value) {
            addCriterion("SlowestTime <", value, "slowesttime");
            return (Criteria) this;
        }
        public Criteria andSlowesttimeLessThanOrEqualTo(Integer value) {
            addCriterion("SlowestTime <=", value, "slowesttime");
            return (Criteria) this;
        }
        public Criteria andSlowesttimeIn(List<Integer> values) {
            addCriterion("SlowestTime in", values, "slowesttime");
            return (Criteria) this;
        }
        public Criteria andSlowesttimeNotIn(List<Integer> values) {
            addCriterion("SlowestTime not in", values, "slowesttime");
            return (Criteria) this;
        }
        public Criteria andSlowesttimeBetween(Integer value1, Integer value2) {
            addCriterion("SlowestTime between", value1, value2, "slowesttime");
            return (Criteria) this;
        }
        public Criteria andSlowesttimeNotBetween(Integer value1, Integer value2) {
            addCriterion("SlowestTime not between", value1, value2, "slowesttime");
            return (Criteria) this;
        }
        public Criteria andFastestbeatIsNull() {
            addCriterion("FastestBeat is null");
            return (Criteria) this;
        }
        public Criteria andFastestbeatIsNotNull() {
            addCriterion("FastestBeat is not null");
            return (Criteria) this;
        }
        public Criteria andFastestbeatEqualTo(Short value) {
            addCriterion("FastestBeat =", value, "fastestbeat");
            return (Criteria) this;
        }
        public Criteria andFastestbeatNotEqualTo(Short value) {
            addCriterion("FastestBeat <>", value, "fastestbeat");
            return (Criteria) this;
        }
        public Criteria andFastestbeatGreaterThan(Short value) {
            addCriterion("FastestBeat >", value, "fastestbeat");
            return (Criteria) this;
        }
        public Criteria andFastestbeatGreaterThanOrEqualTo(Short value) {
            addCriterion("FastestBeat >=", value, "fastestbeat");
            return (Criteria) this;
        }
        public Criteria andFastestbeatLessThan(Short value) {
            addCriterion("FastestBeat <", value, "fastestbeat");
            return (Criteria) this;
        }
        public Criteria andFastestbeatLessThanOrEqualTo(Short value) {
            addCriterion("FastestBeat <=", value, "fastestbeat");
            return (Criteria) this;
        }
        public Criteria andFastestbeatIn(List<Short> values) {
            addCriterion("FastestBeat in", values, "fastestbeat");
            return (Criteria) this;
        }
        public Criteria andFastestbeatNotIn(List<Short> values) {
            addCriterion("FastestBeat not in", values, "fastestbeat");
            return (Criteria) this;
        }
        public Criteria andFastestbeatBetween(Short value1, Short value2) {
            addCriterion("FastestBeat between", value1, value2, "fastestbeat");
            return (Criteria) this;
        }
        public Criteria andFastestbeatNotBetween(Short value1, Short value2) {
            addCriterion("FastestBeat not between", value1, value2, "fastestbeat");
            return (Criteria) this;
        }
        public Criteria andFastesttimeIsNull() {
            addCriterion("FastestTime is null");
            return (Criteria) this;
        }
        public Criteria andFastesttimeIsNotNull() {
            addCriterion("FastestTime is not null");
            return (Criteria) this;
        }
        public Criteria andFastesttimeEqualTo(Integer value) {
            addCriterion("FastestTime =", value, "fastesttime");
            return (Criteria) this;
        }
        public Criteria andFastesttimeNotEqualTo(Integer value) {
            addCriterion("FastestTime <>", value, "fastesttime");
            return (Criteria) this;
        }
        public Criteria andFastesttimeGreaterThan(Integer value) {
            addCriterion("FastestTime >", value, "fastesttime");
            return (Criteria) this;
        }
        public Criteria andFastesttimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("FastestTime >=", value, "fastesttime");
            return (Criteria) this;
        }
        public Criteria andFastesttimeLessThan(Integer value) {
            addCriterion("FastestTime <", value, "fastesttime");
            return (Criteria) this;
        }
        public Criteria andFastesttimeLessThanOrEqualTo(Integer value) {
            addCriterion("FastestTime <=", value, "fastesttime");
            return (Criteria) this;
        }
        public Criteria andFastesttimeIn(List<Integer> values) {
            addCriterion("FastestTime in", values, "fastesttime");
            return (Criteria) this;
        }
        public Criteria andFastesttimeNotIn(List<Integer> values) {
            addCriterion("FastestTime not in", values, "fastesttime");
            return (Criteria) this;
        }
        public Criteria andFastesttimeBetween(Integer value1, Integer value2) {
            addCriterion("FastestTime between", value1, value2, "fastesttime");
            return (Criteria) this;
        }
        public Criteria andFastesttimeNotBetween(Integer value1, Integer value2) {
            addCriterion("FastestTime not between", value1, value2, "fastesttime");
            return (Criteria) this;
        }
        public Criteria andAverageheartIsNull() {
            addCriterion("AverageHeart is null");
            return (Criteria) this;
        }
        public Criteria andAverageheartIsNotNull() {
            addCriterion("AverageHeart is not null");
            return (Criteria) this;
        }
        public Criteria andAverageheartEqualTo(Integer value) {
            addCriterion("AverageHeart =", value, "averageheart");
            return (Criteria) this;
        }
        public Criteria andAverageheartNotEqualTo(Integer value) {
            addCriterion("AverageHeart <>", value, "averageheart");
            return (Criteria) this;
        }
        public Criteria andAverageheartGreaterThan(Integer value) {
            addCriterion("AverageHeart >", value, "averageheart");
            return (Criteria) this;
        }
        public Criteria andAverageheartGreaterThanOrEqualTo(Integer value) {
            addCriterion("AverageHeart >=", value, "averageheart");
            return (Criteria) this;
        }
        public Criteria andAverageheartLessThan(Integer value) {
            addCriterion("AverageHeart <", value, "averageheart");
            return (Criteria) this;
        }
        public Criteria andAverageheartLessThanOrEqualTo(Integer value) {
            addCriterion("AverageHeart <=", value, "averageheart");
            return (Criteria) this;
        }
        public Criteria andAverageheartIn(List<Integer> values) {
            addCriterion("AverageHeart in", values, "averageheart");
            return (Criteria) this;
        }
        public Criteria andAverageheartNotIn(List<Integer> values) {
            addCriterion("AverageHeart not in", values, "averageheart");
            return (Criteria) this;
        }
        public Criteria andAverageheartBetween(Integer value1, Integer value2) {
            addCriterion("AverageHeart between", value1, value2, "averageheart");
            return (Criteria) this;
        }
        public Criteria andAverageheartNotBetween(Integer value1, Integer value2) {
            addCriterion("AverageHeart not between", value1, value2, "averageheart");
            return (Criteria) this;
        }
        public Criteria andSdnnIsNull() {
            addCriterion("SDNN is null");
            return (Criteria) this;
        }
        public Criteria andSdnnIsNotNull() {
            addCriterion("SDNN is not null");
            return (Criteria) this;
        }
        public Criteria andSdnnEqualTo(BigDecimal value) {
            addCriterion("SDNN =", value, "sdnn");
            return (Criteria) this;
        }
        public Criteria andSdnnNotEqualTo(BigDecimal value) {
            addCriterion("SDNN <>", value, "sdnn");
            return (Criteria) this;
        }
        public Criteria andSdnnGreaterThan(BigDecimal value) {
            addCriterion("SDNN >", value, "sdnn");
            return (Criteria) this;
        }
        public Criteria andSdnnGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SDNN >=", value, "sdnn");
            return (Criteria) this;
        }
        public Criteria andSdnnLessThan(BigDecimal value) {
            addCriterion("SDNN <", value, "sdnn");
            return (Criteria) this;
        }
        public Criteria andSdnnLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SDNN <=", value, "sdnn");
            return (Criteria) this;
        }
        public Criteria andSdnnIn(List<BigDecimal> values) {
            addCriterion("SDNN in", values, "sdnn");
            return (Criteria) this;
        }
        public Criteria andSdnnNotIn(List<BigDecimal> values) {
            addCriterion("SDNN not in", values, "sdnn");
            return (Criteria) this;
        }
        public Criteria andSdnnBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SDNN between", value1, value2, "sdnn");
            return (Criteria) this;
        }
        public Criteria andSdnnNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SDNN not between", value1, value2, "sdnn");
            return (Criteria) this;
        }
        public Criteria andPnn50IsNull() {
            addCriterion("PNN50 is null");
            return (Criteria) this;
        }
        public Criteria andPnn50IsNotNull() {
            addCriterion("PNN50 is not null");
            return (Criteria) this;
        }
        public Criteria andPnn50EqualTo(BigDecimal value) {
            addCriterion("PNN50 =", value, "pnn50");
            return (Criteria) this;
        }
        public Criteria andPnn50NotEqualTo(BigDecimal value) {
            addCriterion("PNN50 <>", value, "pnn50");
            return (Criteria) this;
        }
        public Criteria andPnn50GreaterThan(BigDecimal value) {
            addCriterion("PNN50 >", value, "pnn50");
            return (Criteria) this;
        }
        public Criteria andPnn50GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PNN50 >=", value, "pnn50");
            return (Criteria) this;
        }
        public Criteria andPnn50LessThan(BigDecimal value) {
            addCriterion("PNN50 <", value, "pnn50");
            return (Criteria) this;
        }
        public Criteria andPnn50LessThanOrEqualTo(BigDecimal value) {
            addCriterion("PNN50 <=", value, "pnn50");
            return (Criteria) this;
        }
        public Criteria andPnn50In(List<BigDecimal> values) {
            addCriterion("PNN50 in", values, "pnn50");
            return (Criteria) this;
        }
        public Criteria andPnn50NotIn(List<BigDecimal> values) {
            addCriterion("PNN50 not in", values, "pnn50");
            return (Criteria) this;
        }
        public Criteria andPnn50Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("PNN50 between", value1, value2, "pnn50");
            return (Criteria) this;
        }
        public Criteria andPnn50NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PNN50 not between", value1, value2, "pnn50");
            return (Criteria) this;
        }
        public Criteria andHrviIsNull() {
            addCriterion("HRVI is null");
            return (Criteria) this;
        }
        public Criteria andHrviIsNotNull() {
            addCriterion("HRVI is not null");
            return (Criteria) this;
        }
        public Criteria andHrviEqualTo(BigDecimal value) {
            addCriterion("HRVI =", value, "hrvi");
            return (Criteria) this;
        }
        public Criteria andHrviNotEqualTo(BigDecimal value) {
            addCriterion("HRVI <>", value, "hrvi");
            return (Criteria) this;
        }
        public Criteria andHrviGreaterThan(BigDecimal value) {
            addCriterion("HRVI >", value, "hrvi");
            return (Criteria) this;
        }
        public Criteria andHrviGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HRVI >=", value, "hrvi");
            return (Criteria) this;
        }
        public Criteria andHrviLessThan(BigDecimal value) {
            addCriterion("HRVI <", value, "hrvi");
            return (Criteria) this;
        }
        public Criteria andHrviLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HRVI <=", value, "hrvi");
            return (Criteria) this;
        }
        public Criteria andHrviIn(List<BigDecimal> values) {
            addCriterion("HRVI in", values, "hrvi");
            return (Criteria) this;
        }
        public Criteria andHrviNotIn(List<BigDecimal> values) {
            addCriterion("HRVI not in", values, "hrvi");
            return (Criteria) this;
        }
        public Criteria andHrviBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HRVI between", value1, value2, "hrvi");
            return (Criteria) this;
        }
        public Criteria andHrviNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HRVI not between", value1, value2, "hrvi");
            return (Criteria) this;
        }
        public Criteria andRmssdIsNull() {
            addCriterion("RMSSD is null");
            return (Criteria) this;
        }
        public Criteria andRmssdIsNotNull() {
            addCriterion("RMSSD is not null");
            return (Criteria) this;
        }
        public Criteria andRmssdEqualTo(BigDecimal value) {
            addCriterion("RMSSD =", value, "rmssd");
            return (Criteria) this;
        }
        public Criteria andRmssdNotEqualTo(BigDecimal value) {
            addCriterion("RMSSD <>", value, "rmssd");
            return (Criteria) this;
        }
        public Criteria andRmssdGreaterThan(BigDecimal value) {
            addCriterion("RMSSD >", value, "rmssd");
            return (Criteria) this;
        }
        public Criteria andRmssdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RMSSD >=", value, "rmssd");
            return (Criteria) this;
        }
        public Criteria andRmssdLessThan(BigDecimal value) {
            addCriterion("RMSSD <", value, "rmssd");
            return (Criteria) this;
        }
        public Criteria andRmssdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RMSSD <=", value, "rmssd");
            return (Criteria) this;
        }
        public Criteria andRmssdIn(List<BigDecimal> values) {
            addCriterion("RMSSD in", values, "rmssd");
            return (Criteria) this;
        }
        public Criteria andRmssdNotIn(List<BigDecimal> values) {
            addCriterion("RMSSD not in", values, "rmssd");
            return (Criteria) this;
        }
        public Criteria andRmssdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RMSSD between", value1, value2, "rmssd");
            return (Criteria) this;
        }
        public Criteria andRmssdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RMSSD not between", value1, value2, "rmssd");
            return (Criteria) this;
        }
        public Criteria andTpIsNull() {
            addCriterion("TP is null");
            return (Criteria) this;
        }
        public Criteria andTpIsNotNull() {
            addCriterion("TP is not null");
            return (Criteria) this;
        }
        public Criteria andTpEqualTo(BigDecimal value) {
            addCriterion("TP =", value, "tp");
            return (Criteria) this;
        }
        public Criteria andTpNotEqualTo(BigDecimal value) {
            addCriterion("TP <>", value, "tp");
            return (Criteria) this;
        }
        public Criteria andTpGreaterThan(BigDecimal value) {
            addCriterion("TP >", value, "tp");
            return (Criteria) this;
        }
        public Criteria andTpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TP >=", value, "tp");
            return (Criteria) this;
        }
        public Criteria andTpLessThan(BigDecimal value) {
            addCriterion("TP <", value, "tp");
            return (Criteria) this;
        }
        public Criteria andTpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TP <=", value, "tp");
            return (Criteria) this;
        }
        public Criteria andTpIn(List<BigDecimal> values) {
            addCriterion("TP in", values, "tp");
            return (Criteria) this;
        }
        public Criteria andTpNotIn(List<BigDecimal> values) {
            addCriterion("TP not in", values, "tp");
            return (Criteria) this;
        }
        public Criteria andTpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TP between", value1, value2, "tp");
            return (Criteria) this;
        }
        public Criteria andTpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TP not between", value1, value2, "tp");
            return (Criteria) this;
        }
        public Criteria andVlfIsNull() {
            addCriterion("VLF is null");
            return (Criteria) this;
        }
        public Criteria andVlfIsNotNull() {
            addCriterion("VLF is not null");
            return (Criteria) this;
        }
        public Criteria andVlfEqualTo(BigDecimal value) {
            addCriterion("VLF =", value, "vlf");
            return (Criteria) this;
        }
        public Criteria andVlfNotEqualTo(BigDecimal value) {
            addCriterion("VLF <>", value, "vlf");
            return (Criteria) this;
        }
        public Criteria andVlfGreaterThan(BigDecimal value) {
            addCriterion("VLF >", value, "vlf");
            return (Criteria) this;
        }
        public Criteria andVlfGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("VLF >=", value, "vlf");
            return (Criteria) this;
        }
        public Criteria andVlfLessThan(BigDecimal value) {
            addCriterion("VLF <", value, "vlf");
            return (Criteria) this;
        }
        public Criteria andVlfLessThanOrEqualTo(BigDecimal value) {
            addCriterion("VLF <=", value, "vlf");
            return (Criteria) this;
        }
        public Criteria andVlfIn(List<BigDecimal> values) {
            addCriterion("VLF in", values, "vlf");
            return (Criteria) this;
        }
        public Criteria andVlfNotIn(List<BigDecimal> values) {
            addCriterion("VLF not in", values, "vlf");
            return (Criteria) this;
        }
        public Criteria andVlfBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VLF between", value1, value2, "vlf");
            return (Criteria) this;
        }
        public Criteria andVlfNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VLF not between", value1, value2, "vlf");
            return (Criteria) this;
        }
        public Criteria andLfIsNull() {
            addCriterion("LF is null");
            return (Criteria) this;
        }
        public Criteria andLfIsNotNull() {
            addCriterion("LF is not null");
            return (Criteria) this;
        }
        public Criteria andLfEqualTo(BigDecimal value) {
            addCriterion("LF =", value, "lf");
            return (Criteria) this;
        }
        public Criteria andLfNotEqualTo(BigDecimal value) {
            addCriterion("LF <>", value, "lf");
            return (Criteria) this;
        }
        public Criteria andLfGreaterThan(BigDecimal value) {
            addCriterion("LF >", value, "lf");
            return (Criteria) this;
        }
        public Criteria andLfGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LF >=", value, "lf");
            return (Criteria) this;
        }
        public Criteria andLfLessThan(BigDecimal value) {
            addCriterion("LF <", value, "lf");
            return (Criteria) this;
        }
        public Criteria andLfLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LF <=", value, "lf");
            return (Criteria) this;
        }
        public Criteria andLfIn(List<BigDecimal> values) {
            addCriterion("LF in", values, "lf");
            return (Criteria) this;
        }
        public Criteria andLfNotIn(List<BigDecimal> values) {
            addCriterion("LF not in", values, "lf");
            return (Criteria) this;
        }
        public Criteria andLfBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LF between", value1, value2, "lf");
            return (Criteria) this;
        }
        public Criteria andLfNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LF not between", value1, value2, "lf");
            return (Criteria) this;
        }
        public Criteria andHfIsNull() {
            addCriterion("HF is null");
            return (Criteria) this;
        }
        public Criteria andHfIsNotNull() {
            addCriterion("HF is not null");
            return (Criteria) this;
        }
        public Criteria andHfEqualTo(BigDecimal value) {
            addCriterion("HF =", value, "hf");
            return (Criteria) this;
        }
        public Criteria andHfNotEqualTo(BigDecimal value) {
            addCriterion("HF <>", value, "hf");
            return (Criteria) this;
        }
        public Criteria andHfGreaterThan(BigDecimal value) {
            addCriterion("HF >", value, "hf");
            return (Criteria) this;
        }
        public Criteria andHfGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HF >=", value, "hf");
            return (Criteria) this;
        }
        public Criteria andHfLessThan(BigDecimal value) {
            addCriterion("HF <", value, "hf");
            return (Criteria) this;
        }
        public Criteria andHfLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HF <=", value, "hf");
            return (Criteria) this;
        }
        public Criteria andHfIn(List<BigDecimal> values) {
            addCriterion("HF in", values, "hf");
            return (Criteria) this;
        }
        public Criteria andHfNotIn(List<BigDecimal> values) {
            addCriterion("HF not in", values, "hf");
            return (Criteria) this;
        }
        public Criteria andHfBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HF between", value1, value2, "hf");
            return (Criteria) this;
        }
        public Criteria andHfNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HF not between", value1, value2, "hf");
            return (Criteria) this;
        }
        public Criteria andLfHfIsNull() {
            addCriterion("LF_HF is null");
            return (Criteria) this;
        }
        public Criteria andLfHfIsNotNull() {
            addCriterion("LF_HF is not null");
            return (Criteria) this;
        }
        public Criteria andLfHfEqualTo(BigDecimal value) {
            addCriterion("LF_HF =", value, "lfHf");
            return (Criteria) this;
        }
        public Criteria andLfHfNotEqualTo(BigDecimal value) {
            addCriterion("LF_HF <>", value, "lfHf");
            return (Criteria) this;
        }
        public Criteria andLfHfGreaterThan(BigDecimal value) {
            addCriterion("LF_HF >", value, "lfHf");
            return (Criteria) this;
        }
        public Criteria andLfHfGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LF_HF >=", value, "lfHf");
            return (Criteria) this;
        }
        public Criteria andLfHfLessThan(BigDecimal value) {
            addCriterion("LF_HF <", value, "lfHf");
            return (Criteria) this;
        }
        public Criteria andLfHfLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LF_HF <=", value, "lfHf");
            return (Criteria) this;
        }
        public Criteria andLfHfIn(List<BigDecimal> values) {
            addCriterion("LF_HF in", values, "lfHf");
            return (Criteria) this;
        }
        public Criteria andLfHfNotIn(List<BigDecimal> values) {
            addCriterion("LF_HF not in", values, "lfHf");
            return (Criteria) this;
        }
        public Criteria andLfHfBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LF_HF between", value1, value2, "lfHf");
            return (Criteria) this;
        }
        public Criteria andLfHfNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LF_HF not between", value1, value2, "lfHf");
            return (Criteria) this;
        }
        public Criteria andSd1IsNull() {
            addCriterion("SD1 is null");
            return (Criteria) this;
        }
        public Criteria andSd1IsNotNull() {
            addCriterion("SD1 is not null");
            return (Criteria) this;
        }
        public Criteria andSd1EqualTo(BigDecimal value) {
            addCriterion("SD1 =", value, "sd1");
            return (Criteria) this;
        }
        public Criteria andSd1NotEqualTo(BigDecimal value) {
            addCriterion("SD1 <>", value, "sd1");
            return (Criteria) this;
        }
        public Criteria andSd1GreaterThan(BigDecimal value) {
            addCriterion("SD1 >", value, "sd1");
            return (Criteria) this;
        }
        public Criteria andSd1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SD1 >=", value, "sd1");
            return (Criteria) this;
        }
        public Criteria andSd1LessThan(BigDecimal value) {
            addCriterion("SD1 <", value, "sd1");
            return (Criteria) this;
        }
        public Criteria andSd1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("SD1 <=", value, "sd1");
            return (Criteria) this;
        }
        public Criteria andSd1In(List<BigDecimal> values) {
            addCriterion("SD1 in", values, "sd1");
            return (Criteria) this;
        }
        public Criteria andSd1NotIn(List<BigDecimal> values) {
            addCriterion("SD1 not in", values, "sd1");
            return (Criteria) this;
        }
        public Criteria andSd1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("SD1 between", value1, value2, "sd1");
            return (Criteria) this;
        }
        public Criteria andSd1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SD1 not between", value1, value2, "sd1");
            return (Criteria) this;
        }
        public Criteria andSd2IsNull() {
            addCriterion("SD2 is null");
            return (Criteria) this;
        }
        public Criteria andSd2IsNotNull() {
            addCriterion("SD2 is not null");
            return (Criteria) this;
        }
        public Criteria andSd2EqualTo(BigDecimal value) {
            addCriterion("SD2 =", value, "sd2");
            return (Criteria) this;
        }
        public Criteria andSd2NotEqualTo(BigDecimal value) {
            addCriterion("SD2 <>", value, "sd2");
            return (Criteria) this;
        }
        public Criteria andSd2GreaterThan(BigDecimal value) {
            addCriterion("SD2 >", value, "sd2");
            return (Criteria) this;
        }
        public Criteria andSd2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SD2 >=", value, "sd2");
            return (Criteria) this;
        }
        public Criteria andSd2LessThan(BigDecimal value) {
            addCriterion("SD2 <", value, "sd2");
            return (Criteria) this;
        }
        public Criteria andSd2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("SD2 <=", value, "sd2");
            return (Criteria) this;
        }
        public Criteria andSd2In(List<BigDecimal> values) {
            addCriterion("SD2 in", values, "sd2");
            return (Criteria) this;
        }
        public Criteria andSd2NotIn(List<BigDecimal> values) {
            addCriterion("SD2 not in", values, "sd2");
            return (Criteria) this;
        }
        public Criteria andSd2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("SD2 between", value1, value2, "sd2");
            return (Criteria) this;
        }
        public Criteria andSd2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SD2 not between", value1, value2, "sd2");
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
        public Criteria andSdnnlevelIsNull() {
            addCriterion("SDNNLevel is null");
            return (Criteria) this;
        }
        public Criteria andSdnnlevelIsNotNull() {
            addCriterion("SDNNLevel is not null");
            return (Criteria) this;
        }
        public Criteria andSdnnlevelEqualTo(Short value) {
            addCriterion("SDNNLevel =", value, "sdnnlevel");
            return (Criteria) this;
        }
        public Criteria andSdnnlevelNotEqualTo(Short value) {
            addCriterion("SDNNLevel <>", value, "sdnnlevel");
            return (Criteria) this;
        }
        public Criteria andSdnnlevelGreaterThan(Short value) {
            addCriterion("SDNNLevel >", value, "sdnnlevel");
            return (Criteria) this;
        }
        public Criteria andSdnnlevelGreaterThanOrEqualTo(Short value) {
            addCriterion("SDNNLevel >=", value, "sdnnlevel");
            return (Criteria) this;
        }
        public Criteria andSdnnlevelLessThan(Short value) {
            addCriterion("SDNNLevel <", value, "sdnnlevel");
            return (Criteria) this;
        }
        public Criteria andSdnnlevelLessThanOrEqualTo(Short value) {
            addCriterion("SDNNLevel <=", value, "sdnnlevel");
            return (Criteria) this;
        }
        public Criteria andSdnnlevelIn(List<Short> values) {
            addCriterion("SDNNLevel in", values, "sdnnlevel");
            return (Criteria) this;
        }
        public Criteria andSdnnlevelNotIn(List<Short> values) {
            addCriterion("SDNNLevel not in", values, "sdnnlevel");
            return (Criteria) this;
        }
        public Criteria andSdnnlevelBetween(Short value1, Short value2) {
            addCriterion("SDNNLevel between", value1, value2, "sdnnlevel");
            return (Criteria) this;
        }
        public Criteria andSdnnlevelNotBetween(Short value1, Short value2) {
            addCriterion("SDNNLevel not between", value1, value2, "sdnnlevel");
            return (Criteria) this;
        }
        public Criteria andPnn50levelIsNull() {
            addCriterion("PNN50Level is null");
            return (Criteria) this;
        }
        public Criteria andPnn50levelIsNotNull() {
            addCriterion("PNN50Level is not null");
            return (Criteria) this;
        }
        public Criteria andPnn50levelEqualTo(Short value) {
            addCriterion("PNN50Level =", value, "pnn50level");
            return (Criteria) this;
        }
        public Criteria andPnn50levelNotEqualTo(Short value) {
            addCriterion("PNN50Level <>", value, "pnn50level");
            return (Criteria) this;
        }
        public Criteria andPnn50levelGreaterThan(Short value) {
            addCriterion("PNN50Level >", value, "pnn50level");
            return (Criteria) this;
        }
        public Criteria andPnn50levelGreaterThanOrEqualTo(Short value) {
            addCriterion("PNN50Level >=", value, "pnn50level");
            return (Criteria) this;
        }
        public Criteria andPnn50levelLessThan(Short value) {
            addCriterion("PNN50Level <", value, "pnn50level");
            return (Criteria) this;
        }
        public Criteria andPnn50levelLessThanOrEqualTo(Short value) {
            addCriterion("PNN50Level <=", value, "pnn50level");
            return (Criteria) this;
        }
        public Criteria andPnn50levelIn(List<Short> values) {
            addCriterion("PNN50Level in", values, "pnn50level");
            return (Criteria) this;
        }
        public Criteria andPnn50levelNotIn(List<Short> values) {
            addCriterion("PNN50Level not in", values, "pnn50level");
            return (Criteria) this;
        }
        public Criteria andPnn50levelBetween(Short value1, Short value2) {
            addCriterion("PNN50Level between", value1, value2, "pnn50level");
            return (Criteria) this;
        }
        public Criteria andPnn50levelNotBetween(Short value1, Short value2) {
            addCriterion("PNN50Level not between", value1, value2, "pnn50level");
            return (Criteria) this;
        }
        public Criteria andHrvilevelIsNull() {
            addCriterion("HRVILevel is null");
            return (Criteria) this;
        }
        public Criteria andHrvilevelIsNotNull() {
            addCriterion("HRVILevel is not null");
            return (Criteria) this;
        }
        public Criteria andHrvilevelEqualTo(Short value) {
            addCriterion("HRVILevel =", value, "hrvilevel");
            return (Criteria) this;
        }
        public Criteria andHrvilevelNotEqualTo(Short value) {
            addCriterion("HRVILevel <>", value, "hrvilevel");
            return (Criteria) this;
        }
        public Criteria andHrvilevelGreaterThan(Short value) {
            addCriterion("HRVILevel >", value, "hrvilevel");
            return (Criteria) this;
        }
        public Criteria andHrvilevelGreaterThanOrEqualTo(Short value) {
            addCriterion("HRVILevel >=", value, "hrvilevel");
            return (Criteria) this;
        }
        public Criteria andHrvilevelLessThan(Short value) {
            addCriterion("HRVILevel <", value, "hrvilevel");
            return (Criteria) this;
        }
        public Criteria andHrvilevelLessThanOrEqualTo(Short value) {
            addCriterion("HRVILevel <=", value, "hrvilevel");
            return (Criteria) this;
        }
        public Criteria andHrvilevelIn(List<Short> values) {
            addCriterion("HRVILevel in", values, "hrvilevel");
            return (Criteria) this;
        }
        public Criteria andHrvilevelNotIn(List<Short> values) {
            addCriterion("HRVILevel not in", values, "hrvilevel");
            return (Criteria) this;
        }
        public Criteria andHrvilevelBetween(Short value1, Short value2) {
            addCriterion("HRVILevel between", value1, value2, "hrvilevel");
            return (Criteria) this;
        }
        public Criteria andHrvilevelNotBetween(Short value1, Short value2) {
            addCriterion("HRVILevel not between", value1, value2, "hrvilevel");
            return (Criteria) this;
        }
        public Criteria andRmssdlevelIsNull() {
            addCriterion("RMSSDLevel is null");
            return (Criteria) this;
        }
        public Criteria andRmssdlevelIsNotNull() {
            addCriterion("RMSSDLevel is not null");
            return (Criteria) this;
        }
        public Criteria andRmssdlevelEqualTo(Short value) {
            addCriterion("RMSSDLevel =", value, "rmssdlevel");
            return (Criteria) this;
        }
        public Criteria andRmssdlevelNotEqualTo(Short value) {
            addCriterion("RMSSDLevel <>", value, "rmssdlevel");
            return (Criteria) this;
        }
        public Criteria andRmssdlevelGreaterThan(Short value) {
            addCriterion("RMSSDLevel >", value, "rmssdlevel");
            return (Criteria) this;
        }
        public Criteria andRmssdlevelGreaterThanOrEqualTo(Short value) {
            addCriterion("RMSSDLevel >=", value, "rmssdlevel");
            return (Criteria) this;
        }
        public Criteria andRmssdlevelLessThan(Short value) {
            addCriterion("RMSSDLevel <", value, "rmssdlevel");
            return (Criteria) this;
        }
        public Criteria andRmssdlevelLessThanOrEqualTo(Short value) {
            addCriterion("RMSSDLevel <=", value, "rmssdlevel");
            return (Criteria) this;
        }
        public Criteria andRmssdlevelIn(List<Short> values) {
            addCriterion("RMSSDLevel in", values, "rmssdlevel");
            return (Criteria) this;
        }
        public Criteria andRmssdlevelNotIn(List<Short> values) {
            addCriterion("RMSSDLevel not in", values, "rmssdlevel");
            return (Criteria) this;
        }
        public Criteria andRmssdlevelBetween(Short value1, Short value2) {
            addCriterion("RMSSDLevel between", value1, value2, "rmssdlevel");
            return (Criteria) this;
        }
        public Criteria andRmssdlevelNotBetween(Short value1, Short value2) {
            addCriterion("RMSSDLevel not between", value1, value2, "rmssdlevel");
            return (Criteria) this;
        }
        public Criteria andTplevelIsNull() {
            addCriterion("TPLevel is null");
            return (Criteria) this;
        }
        public Criteria andTplevelIsNotNull() {
            addCriterion("TPLevel is not null");
            return (Criteria) this;
        }
        public Criteria andTplevelEqualTo(Short value) {
            addCriterion("TPLevel =", value, "tplevel");
            return (Criteria) this;
        }
        public Criteria andTplevelNotEqualTo(Short value) {
            addCriterion("TPLevel <>", value, "tplevel");
            return (Criteria) this;
        }
        public Criteria andTplevelGreaterThan(Short value) {
            addCriterion("TPLevel >", value, "tplevel");
            return (Criteria) this;
        }
        public Criteria andTplevelGreaterThanOrEqualTo(Short value) {
            addCriterion("TPLevel >=", value, "tplevel");
            return (Criteria) this;
        }
        public Criteria andTplevelLessThan(Short value) {
            addCriterion("TPLevel <", value, "tplevel");
            return (Criteria) this;
        }
        public Criteria andTplevelLessThanOrEqualTo(Short value) {
            addCriterion("TPLevel <=", value, "tplevel");
            return (Criteria) this;
        }
        public Criteria andTplevelIn(List<Short> values) {
            addCriterion("TPLevel in", values, "tplevel");
            return (Criteria) this;
        }
        public Criteria andTplevelNotIn(List<Short> values) {
            addCriterion("TPLevel not in", values, "tplevel");
            return (Criteria) this;
        }
        public Criteria andTplevelBetween(Short value1, Short value2) {
            addCriterion("TPLevel between", value1, value2, "tplevel");
            return (Criteria) this;
        }
        public Criteria andTplevelNotBetween(Short value1, Short value2) {
            addCriterion("TPLevel not between", value1, value2, "tplevel");
            return (Criteria) this;
        }
        public Criteria andVlflevelIsNull() {
            addCriterion("VLFLevel is null");
            return (Criteria) this;
        }
        public Criteria andVlflevelIsNotNull() {
            addCriterion("VLFLevel is not null");
            return (Criteria) this;
        }
        public Criteria andVlflevelEqualTo(Short value) {
            addCriterion("VLFLevel =", value, "vlflevel");
            return (Criteria) this;
        }
        public Criteria andVlflevelNotEqualTo(Short value) {
            addCriterion("VLFLevel <>", value, "vlflevel");
            return (Criteria) this;
        }
        public Criteria andVlflevelGreaterThan(Short value) {
            addCriterion("VLFLevel >", value, "vlflevel");
            return (Criteria) this;
        }
        public Criteria andVlflevelGreaterThanOrEqualTo(Short value) {
            addCriterion("VLFLevel >=", value, "vlflevel");
            return (Criteria) this;
        }
        public Criteria andVlflevelLessThan(Short value) {
            addCriterion("VLFLevel <", value, "vlflevel");
            return (Criteria) this;
        }
        public Criteria andVlflevelLessThanOrEqualTo(Short value) {
            addCriterion("VLFLevel <=", value, "vlflevel");
            return (Criteria) this;
        }
        public Criteria andVlflevelIn(List<Short> values) {
            addCriterion("VLFLevel in", values, "vlflevel");
            return (Criteria) this;
        }
        public Criteria andVlflevelNotIn(List<Short> values) {
            addCriterion("VLFLevel not in", values, "vlflevel");
            return (Criteria) this;
        }
        public Criteria andVlflevelBetween(Short value1, Short value2) {
            addCriterion("VLFLevel between", value1, value2, "vlflevel");
            return (Criteria) this;
        }
        public Criteria andVlflevelNotBetween(Short value1, Short value2) {
            addCriterion("VLFLevel not between", value1, value2, "vlflevel");
            return (Criteria) this;
        }
        public Criteria andLflevelIsNull() {
            addCriterion("LFLevel is null");
            return (Criteria) this;
        }
        public Criteria andLflevelIsNotNull() {
            addCriterion("LFLevel is not null");
            return (Criteria) this;
        }
        public Criteria andLflevelEqualTo(Short value) {
            addCriterion("LFLevel =", value, "lflevel");
            return (Criteria) this;
        }
        public Criteria andLflevelNotEqualTo(Short value) {
            addCriterion("LFLevel <>", value, "lflevel");
            return (Criteria) this;
        }
        public Criteria andLflevelGreaterThan(Short value) {
            addCriterion("LFLevel >", value, "lflevel");
            return (Criteria) this;
        }
        public Criteria andLflevelGreaterThanOrEqualTo(Short value) {
            addCriterion("LFLevel >=", value, "lflevel");
            return (Criteria) this;
        }
        public Criteria andLflevelLessThan(Short value) {
            addCriterion("LFLevel <", value, "lflevel");
            return (Criteria) this;
        }
        public Criteria andLflevelLessThanOrEqualTo(Short value) {
            addCriterion("LFLevel <=", value, "lflevel");
            return (Criteria) this;
        }
        public Criteria andLflevelIn(List<Short> values) {
            addCriterion("LFLevel in", values, "lflevel");
            return (Criteria) this;
        }
        public Criteria andLflevelNotIn(List<Short> values) {
            addCriterion("LFLevel not in", values, "lflevel");
            return (Criteria) this;
        }
        public Criteria andLflevelBetween(Short value1, Short value2) {
            addCriterion("LFLevel between", value1, value2, "lflevel");
            return (Criteria) this;
        }
        public Criteria andLflevelNotBetween(Short value1, Short value2) {
            addCriterion("LFLevel not between", value1, value2, "lflevel");
            return (Criteria) this;
        }
        public Criteria andHflevelIsNull() {
            addCriterion("HFLevel is null");
            return (Criteria) this;
        }
        public Criteria andHflevelIsNotNull() {
            addCriterion("HFLevel is not null");
            return (Criteria) this;
        }
        public Criteria andHflevelEqualTo(Short value) {
            addCriterion("HFLevel =", value, "hflevel");
            return (Criteria) this;
        }
        public Criteria andHflevelNotEqualTo(Short value) {
            addCriterion("HFLevel <>", value, "hflevel");
            return (Criteria) this;
        }
        public Criteria andHflevelGreaterThan(Short value) {
            addCriterion("HFLevel >", value, "hflevel");
            return (Criteria) this;
        }
        public Criteria andHflevelGreaterThanOrEqualTo(Short value) {
            addCriterion("HFLevel >=", value, "hflevel");
            return (Criteria) this;
        }
        public Criteria andHflevelLessThan(Short value) {
            addCriterion("HFLevel <", value, "hflevel");
            return (Criteria) this;
        }
        public Criteria andHflevelLessThanOrEqualTo(Short value) {
            addCriterion("HFLevel <=", value, "hflevel");
            return (Criteria) this;
        }
        public Criteria andHflevelIn(List<Short> values) {
            addCriterion("HFLevel in", values, "hflevel");
            return (Criteria) this;
        }
        public Criteria andHflevelNotIn(List<Short> values) {
            addCriterion("HFLevel not in", values, "hflevel");
            return (Criteria) this;
        }
        public Criteria andHflevelBetween(Short value1, Short value2) {
            addCriterion("HFLevel between", value1, value2, "hflevel");
            return (Criteria) this;
        }
        public Criteria andHflevelNotBetween(Short value1, Short value2) {
            addCriterion("HFLevel not between", value1, value2, "hflevel");
            return (Criteria) this;
        }
        public Criteria andLhrlevelIsNull() {
            addCriterion("LHRLevel is null");
            return (Criteria) this;
        }
        public Criteria andLhrlevelIsNotNull() {
            addCriterion("LHRLevel is not null");
            return (Criteria) this;
        }
        public Criteria andLhrlevelEqualTo(Short value) {
            addCriterion("LHRLevel =", value, "lhrlevel");
            return (Criteria) this;
        }
        public Criteria andLhrlevelNotEqualTo(Short value) {
            addCriterion("LHRLevel <>", value, "lhrlevel");
            return (Criteria) this;
        }
        public Criteria andLhrlevelGreaterThan(Short value) {
            addCriterion("LHRLevel >", value, "lhrlevel");
            return (Criteria) this;
        }
        public Criteria andLhrlevelGreaterThanOrEqualTo(Short value) {
            addCriterion("LHRLevel >=", value, "lhrlevel");
            return (Criteria) this;
        }
        public Criteria andLhrlevelLessThan(Short value) {
            addCriterion("LHRLevel <", value, "lhrlevel");
            return (Criteria) this;
        }
        public Criteria andLhrlevelLessThanOrEqualTo(Short value) {
            addCriterion("LHRLevel <=", value, "lhrlevel");
            return (Criteria) this;
        }
        public Criteria andLhrlevelIn(List<Short> values) {
            addCriterion("LHRLevel in", values, "lhrlevel");
            return (Criteria) this;
        }
        public Criteria andLhrlevelNotIn(List<Short> values) {
            addCriterion("LHRLevel not in", values, "lhrlevel");
            return (Criteria) this;
        }
        public Criteria andLhrlevelBetween(Short value1, Short value2) {
            addCriterion("LHRLevel between", value1, value2, "lhrlevel");
            return (Criteria) this;
        }
        public Criteria andLhrlevelNotBetween(Short value1, Short value2) {
            addCriterion("LHRLevel not between", value1, value2, "lhrlevel");
            return (Criteria) this;
        }
        public Criteria andHrlevelIsNull() {
            addCriterion("HRLevel is null");
            return (Criteria) this;
        }
        public Criteria andHrlevelIsNotNull() {
            addCriterion("HRLevel is not null");
            return (Criteria) this;
        }
        public Criteria andHrlevelEqualTo(Short value) {
            addCriterion("HRLevel =", value, "hrlevel");
            return (Criteria) this;
        }
        public Criteria andHrlevelNotEqualTo(Short value) {
            addCriterion("HRLevel <>", value, "hrlevel");
            return (Criteria) this;
        }
        public Criteria andHrlevelGreaterThan(Short value) {
            addCriterion("HRLevel >", value, "hrlevel");
            return (Criteria) this;
        }
        public Criteria andHrlevelGreaterThanOrEqualTo(Short value) {
            addCriterion("HRLevel >=", value, "hrlevel");
            return (Criteria) this;
        }
        public Criteria andHrlevelLessThan(Short value) {
            addCriterion("HRLevel <", value, "hrlevel");
            return (Criteria) this;
        }
        public Criteria andHrlevelLessThanOrEqualTo(Short value) {
            addCriterion("HRLevel <=", value, "hrlevel");
            return (Criteria) this;
        }
        public Criteria andHrlevelIn(List<Short> values) {
            addCriterion("HRLevel in", values, "hrlevel");
            return (Criteria) this;
        }
        public Criteria andHrlevelNotIn(List<Short> values) {
            addCriterion("HRLevel not in", values, "hrlevel");
            return (Criteria) this;
        }
        public Criteria andHrlevelBetween(Short value1, Short value2) {
            addCriterion("HRLevel between", value1, value2, "hrlevel");
            return (Criteria) this;
        }
        public Criteria andHrlevelNotBetween(Short value1, Short value2) {
            addCriterion("HRLevel not between", value1, value2, "hrlevel");
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
        public Criteria andAddvalueEqualTo(Short value) {
            addCriterion("AddValue =", value, "addvalue");
            return (Criteria) this;
        }
        public Criteria andAddvalueNotEqualTo(Short value) {
            addCriterion("AddValue <>", value, "addvalue");
            return (Criteria) this;
        }
        public Criteria andAddvalueGreaterThan(Short value) {
            addCriterion("AddValue >", value, "addvalue");
            return (Criteria) this;
        }
        public Criteria andAddvalueGreaterThanOrEqualTo(Short value) {
            addCriterion("AddValue >=", value, "addvalue");
            return (Criteria) this;
        }
        public Criteria andAddvalueLessThan(Short value) {
            addCriterion("AddValue <", value, "addvalue");
            return (Criteria) this;
        }
        public Criteria andAddvalueLessThanOrEqualTo(Short value) {
            addCriterion("AddValue <=", value, "addvalue");
            return (Criteria) this;
        }
        public Criteria andAddvalueIn(List<Short> values) {
            addCriterion("AddValue in", values, "addvalue");
            return (Criteria) this;
        }
        public Criteria andAddvalueNotIn(List<Short> values) {
            addCriterion("AddValue not in", values, "addvalue");
            return (Criteria) this;
        }
        public Criteria andAddvalueBetween(Short value1, Short value2) {
            addCriterion("AddValue between", value1, value2, "addvalue");
            return (Criteria) this;
        }
        public Criteria andAddvalueNotBetween(Short value1, Short value2) {
            addCriterion("AddValue not between", value1, value2, "addvalue");
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
        public Criteria andRawecgimgIsNull() {
            addCriterion("RawECGImg is null");
            return (Criteria) this;
        }
        public Criteria andRawecgimgIsNotNull() {
            addCriterion("RawECGImg is not null");
            return (Criteria) this;
        }
        public Criteria andRawecgimgEqualTo(String value) {
            addCriterion("RawECGImg =", value, "rawecgimg");
            return (Criteria) this;
        }
        public Criteria andRawecgimgNotEqualTo(String value) {
            addCriterion("RawECGImg <>", value, "rawecgimg");
            return (Criteria) this;
        }
        public Criteria andRawecgimgGreaterThan(String value) {
            addCriterion("RawECGImg >", value, "rawecgimg");
            return (Criteria) this;
        }
        public Criteria andRawecgimgGreaterThanOrEqualTo(String value) {
            addCriterion("RawECGImg >=", value, "rawecgimg");
            return (Criteria) this;
        }
        public Criteria andRawecgimgLessThan(String value) {
            addCriterion("RawECGImg <", value, "rawecgimg");
            return (Criteria) this;
        }
        public Criteria andRawecgimgLessThanOrEqualTo(String value) {
            addCriterion("RawECGImg <=", value, "rawecgimg");
            return (Criteria) this;
        }
        public Criteria andRawecgimgLike(String value) {
            addCriterion("RawECGImg like", value, "rawecgimg");
            return (Criteria) this;
        }
        public Criteria andRawecgimgNotLike(String value) {
            addCriterion("RawECGImg not like", value, "rawecgimg");
            return (Criteria) this;
        }
        public Criteria andRawecgimgIn(List<String> values) {
            addCriterion("RawECGImg in", values, "rawecgimg");
            return (Criteria) this;
        }
        public Criteria andRawecgimgNotIn(List<String> values) {
            addCriterion("RawECGImg not in", values, "rawecgimg");
            return (Criteria) this;
        }
        public Criteria andRawecgimgBetween(String value1, String value2) {
            addCriterion("RawECGImg between", value1, value2, "rawecgimg");
            return (Criteria) this;
        }
        public Criteria andRawecgimgNotBetween(String value1, String value2) {
            addCriterion("RawECGImg not between", value1, value2, "rawecgimg");
            return (Criteria) this;
        }
        public Criteria andFreqpsdIsNull() {
            addCriterion("FreqPSD is null");
            return (Criteria) this;
        }
        public Criteria andFreqpsdIsNotNull() {
            addCriterion("FreqPSD is not null");
            return (Criteria) this;
        }
        public Criteria andFreqpsdEqualTo(String value) {
            addCriterion("FreqPSD =", value, "freqpsd");
            return (Criteria) this;
        }
        public Criteria andFreqpsdNotEqualTo(String value) {
            addCriterion("FreqPSD <>", value, "freqpsd");
            return (Criteria) this;
        }
        public Criteria andFreqpsdGreaterThan(String value) {
            addCriterion("FreqPSD >", value, "freqpsd");
            return (Criteria) this;
        }
        public Criteria andFreqpsdGreaterThanOrEqualTo(String value) {
            addCriterion("FreqPSD >=", value, "freqpsd");
            return (Criteria) this;
        }
        public Criteria andFreqpsdLessThan(String value) {
            addCriterion("FreqPSD <", value, "freqpsd");
            return (Criteria) this;
        }
        public Criteria andFreqpsdLessThanOrEqualTo(String value) {
            addCriterion("FreqPSD <=", value, "freqpsd");
            return (Criteria) this;
        }
        public Criteria andFreqpsdLike(String value) {
            addCriterion("FreqPSD like", value, "freqpsd");
            return (Criteria) this;
        }
        public Criteria andFreqpsdNotLike(String value) {
            addCriterion("FreqPSD not like", value, "freqpsd");
            return (Criteria) this;
        }
        public Criteria andFreqpsdIn(List<String> values) {
            addCriterion("FreqPSD in", values, "freqpsd");
            return (Criteria) this;
        }
        public Criteria andFreqpsdNotIn(List<String> values) {
            addCriterion("FreqPSD not in", values, "freqpsd");
            return (Criteria) this;
        }
        public Criteria andFreqpsdBetween(String value1, String value2) {
            addCriterion("FreqPSD between", value1, value2, "freqpsd");
            return (Criteria) this;
        }
        public Criteria andFreqpsdNotBetween(String value1, String value2) {
            addCriterion("FreqPSD not between", value1, value2, "freqpsd");
            return (Criteria) this;
        }
        public Criteria andRrintervalIsNull() {
            addCriterion("RRInterval is null");
            return (Criteria) this;
        }
        public Criteria andRrintervalIsNotNull() {
            addCriterion("RRInterval is not null");
            return (Criteria) this;
        }
        public Criteria andRrintervalEqualTo(String value) {
            addCriterion("RRInterval =", value, "rrinterval");
            return (Criteria) this;
        }
        public Criteria andRrintervalNotEqualTo(String value) {
            addCriterion("RRInterval <>", value, "rrinterval");
            return (Criteria) this;
        }
        public Criteria andRrintervalGreaterThan(String value) {
            addCriterion("RRInterval >", value, "rrinterval");
            return (Criteria) this;
        }
        public Criteria andRrintervalGreaterThanOrEqualTo(String value) {
            addCriterion("RRInterval >=", value, "rrinterval");
            return (Criteria) this;
        }
        public Criteria andRrintervalLessThan(String value) {
            addCriterion("RRInterval <", value, "rrinterval");
            return (Criteria) this;
        }
        public Criteria andRrintervalLessThanOrEqualTo(String value) {
            addCriterion("RRInterval <=", value, "rrinterval");
            return (Criteria) this;
        }
        public Criteria andRrintervalLike(String value) {
            addCriterion("RRInterval like", value, "rrinterval");
            return (Criteria) this;
        }
        public Criteria andRrintervalNotLike(String value) {
            addCriterion("RRInterval not like", value, "rrinterval");
            return (Criteria) this;
        }
        public Criteria andRrintervalIn(List<String> values) {
            addCriterion("RRInterval in", values, "rrinterval");
            return (Criteria) this;
        }
        public Criteria andRrintervalNotIn(List<String> values) {
            addCriterion("RRInterval not in", values, "rrinterval");
            return (Criteria) this;
        }
        public Criteria andRrintervalBetween(String value1, String value2) {
            addCriterion("RRInterval between", value1, value2, "rrinterval");
            return (Criteria) this;
        }
        public Criteria andRrintervalNotBetween(String value1, String value2) {
            addCriterion("RRInterval not between", value1, value2, "rrinterval");
            return (Criteria) this;
        }
        public Criteria andRawecgIsNull() {
            addCriterion("RawECG is null");
            return (Criteria) this;
        }
        public Criteria andRawecgIsNotNull() {
            addCriterion("RawECG is not null");
            return (Criteria) this;
        }
        public Criteria andRawecgEqualTo(String value) {
            addCriterion("RawECG =", value, "rawecg");
            return (Criteria) this;
        }
        public Criteria andRawecgNotEqualTo(String value) {
            addCriterion("RawECG <>", value, "rawecg");
            return (Criteria) this;
        }
        public Criteria andRawecgGreaterThan(String value) {
            addCriterion("RawECG >", value, "rawecg");
            return (Criteria) this;
        }
        public Criteria andRawecgGreaterThanOrEqualTo(String value) {
            addCriterion("RawECG >=", value, "rawecg");
            return (Criteria) this;
        }
        public Criteria andRawecgLessThan(String value) {
            addCriterion("RawECG <", value, "rawecg");
            return (Criteria) this;
        }
        public Criteria andRawecgLessThanOrEqualTo(String value) {
            addCriterion("RawECG <=", value, "rawecg");
            return (Criteria) this;
        }
        public Criteria andRawecgLike(String value) {
            addCriterion("RawECG like", value, "rawecg");
            return (Criteria) this;
        }
        public Criteria andRawecgNotLike(String value) {
            addCriterion("RawECG not like", value, "rawecg");
            return (Criteria) this;
        }
        public Criteria andRawecgIn(List<String> values) {
            addCriterion("RawECG in", values, "rawecg");
            return (Criteria) this;
        }
        public Criteria andRawecgNotIn(List<String> values) {
            addCriterion("RawECG not in", values, "rawecg");
            return (Criteria) this;
        }
        public Criteria andRawecgBetween(String value1, String value2) {
            addCriterion("RawECG between", value1, value2, "rawecg");
            return (Criteria) this;
        }
        public Criteria andRawecgNotBetween(String value1, String value2) {
            addCriterion("RawECG not between", value1, value2, "rawecg");
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
        public Criteria andEcgresultIsNull() {
            addCriterion("ECGResult is null");
            return (Criteria) this;
        }
        public Criteria andEcgresultIsNotNull() {
            addCriterion("ECGResult is not null");
            return (Criteria) this;
        }
        public Criteria andEcgresultEqualTo(Short value) {
            addCriterion("ECGResult =", value, "ecgresult");
            return (Criteria) this;
        }
        public Criteria andEcgresultNotEqualTo(Short value) {
            addCriterion("ECGResult <>", value, "ecgresult");
            return (Criteria) this;
        }
        public Criteria andEcgresultGreaterThan(Short value) {
            addCriterion("ECGResult >", value, "ecgresult");
            return (Criteria) this;
        }
        public Criteria andEcgresultGreaterThanOrEqualTo(Short value) {
            addCriterion("ECGResult >=", value, "ecgresult");
            return (Criteria) this;
        }
        public Criteria andEcgresultLessThan(Short value) {
            addCriterion("ECGResult <", value, "ecgresult");
            return (Criteria) this;
        }
        public Criteria andEcgresultLessThanOrEqualTo(Short value) {
            addCriterion("ECGResult <=", value, "ecgresult");
            return (Criteria) this;
        }
        public Criteria andEcgresultIn(List<Short> values) {
            addCriterion("ECGResult in", values, "ecgresult");
            return (Criteria) this;
        }
        public Criteria andEcgresultNotIn(List<Short> values) {
            addCriterion("ECGResult not in", values, "ecgresult");
            return (Criteria) this;
        }
        public Criteria andEcgresultBetween(Short value1, Short value2) {
            addCriterion("ECGResult between", value1, value2, "ecgresult");
            return (Criteria) this;
        }
        public Criteria andEcgresultNotBetween(Short value1, Short value2) {
            addCriterion("ECGResult not between", value1, value2, "ecgresult");
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
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 心电测量表(OECG)
     * 
     * @author ${user}
     * @version 1.0 2016-07-11
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