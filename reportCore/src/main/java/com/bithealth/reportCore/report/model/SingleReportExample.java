/*
 * SingleReportExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-20 Created
 */
package com.bithealth.reportCore.report.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SingleReportExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public SingleReportExample() {
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
     * 单项测量报告（OMRR）
     * 
     * @author ${user}
     * @version 1.0 2016-07-20
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
                  return;//
            }
            criteria.add(new Criterion(condition));
        }
        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                  return;//
            }
            criteria.add(new Criterion(condition, value));
        }
        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                  return;//
            }
            criteria.add(new Criterion(condition, value1, value2));
        }
        public Criteria andIDIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }
        public Criteria andIDIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }
        public Criteria andIDEqualTo(Integer value) {
            addCriterion("ID =", value, "ID");
            return (Criteria) this;
        }
        public Criteria andIDNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "ID");
            return (Criteria) this;
        }
        public Criteria andIDGreaterThan(Integer value) {
            addCriterion("ID >", value, "ID");
            return (Criteria) this;
        }
        public Criteria andIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "ID");
            return (Criteria) this;
        }
        public Criteria andIDLessThan(Integer value) {
            addCriterion("ID <", value, "ID");
            return (Criteria) this;
        }
        public Criteria andIDLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "ID");
            return (Criteria) this;
        }
        public Criteria andIDIn(List<Integer> values) {
            addCriterion("ID in", values, "ID");
            return (Criteria) this;
        }
        public Criteria andIDNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "ID");
            return (Criteria) this;
        }
        public Criteria andIDBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "ID");
            return (Criteria) this;
        }
        public Criteria andIDNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "ID");
            return (Criteria) this;
        }
        public Criteria andOrgIdIsNull() {
            addCriterion("OrgId is null");
            return (Criteria) this;
        }
        public Criteria andOrgIdIsNotNull() {
            addCriterion("OrgId is not null");
            return (Criteria) this;
        }
        public Criteria andOrgIdEqualTo(Integer value) {
            addCriterion("OrgId =", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdNotEqualTo(Integer value) {
            addCriterion("OrgId <>", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdGreaterThan(Integer value) {
            addCriterion("OrgId >", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrgId >=", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdLessThan(Integer value) {
            addCriterion("OrgId <", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("OrgId <=", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdIn(List<Integer> values) {
            addCriterion("OrgId in", values, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdNotIn(List<Integer> values) {
            addCriterion("OrgId not in", values, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("OrgId between", value1, value2, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("OrgId not between", value1, value2, "orgId");
            return (Criteria) this;
        }
        public Criteria andReportCodeIsNull() {
            addCriterion("ReportCode is null");
            return (Criteria) this;
        }
        public Criteria andReportCodeIsNotNull() {
            addCriterion("ReportCode is not null");
            return (Criteria) this;
        }
        public Criteria andReportCodeEqualTo(String value) {
            addCriterion("ReportCode =", value, "reportCode");
            return (Criteria) this;
        }
        public Criteria andReportCodeNotEqualTo(String value) {
            addCriterion("ReportCode <>", value, "reportCode");
            return (Criteria) this;
        }
        public Criteria andReportCodeGreaterThan(String value) {
            addCriterion("ReportCode >", value, "reportCode");
            return (Criteria) this;
        }
        public Criteria andReportCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ReportCode >=", value, "reportCode");
            return (Criteria) this;
        }
        public Criteria andReportCodeLessThan(String value) {
            addCriterion("ReportCode <", value, "reportCode");
            return (Criteria) this;
        }
        public Criteria andReportCodeLessThanOrEqualTo(String value) {
            addCriterion("ReportCode <=", value, "reportCode");
            return (Criteria) this;
        }
        public Criteria andReportCodeLike(String value) {
            addCriterion("ReportCode like", value, "reportCode");
            return (Criteria) this;
        }
        public Criteria andReportCodeNotLike(String value) {
            addCriterion("ReportCode not like", value, "reportCode");
            return (Criteria) this;
        }
        public Criteria andReportCodeIn(List<String> values) {
            addCriterion("ReportCode in", values, "reportCode");
            return (Criteria) this;
        }
        public Criteria andReportCodeNotIn(List<String> values) {
            addCriterion("ReportCode not in", values, "reportCode");
            return (Criteria) this;
        }
        public Criteria andReportCodeBetween(String value1, String value2) {
            addCriterion("ReportCode between", value1, value2, "reportCode");
            return (Criteria) this;
        }
        public Criteria andReportCodeNotBetween(String value1, String value2) {
            addCriterion("ReportCode not between", value1, value2, "reportCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeIsNull() {
            addCriterion("TempCode is null");
            return (Criteria) this;
        }
        public Criteria andTempCodeIsNotNull() {
            addCriterion("TempCode is not null");
            return (Criteria) this;
        }
        public Criteria andTempCodeEqualTo(Integer value) {
            addCriterion("TempCode =", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeNotEqualTo(Integer value) {
            addCriterion("TempCode <>", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeGreaterThan(Integer value) {
            addCriterion("TempCode >", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TempCode >=", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeLessThan(Integer value) {
            addCriterion("TempCode <", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeLessThanOrEqualTo(Integer value) {
            addCriterion("TempCode <=", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeIn(List<Integer> values) {
            addCriterion("TempCode in", values, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeNotIn(List<Integer> values) {
            addCriterion("TempCode not in", values, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeBetween(Integer value1, Integer value2) {
            addCriterion("TempCode between", value1, value2, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("TempCode not between", value1, value2, "tempCode");
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
        public Criteria andOptIdIsNull() {
            addCriterion("OptId is null");
            return (Criteria) this;
        }
        public Criteria andOptIdIsNotNull() {
            addCriterion("OptId is not null");
            return (Criteria) this;
        }
        public Criteria andOptIdEqualTo(Short value) {
            addCriterion("OptId =", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotEqualTo(Short value) {
            addCriterion("OptId <>", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdGreaterThan(Short value) {
            addCriterion("OptId >", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdGreaterThanOrEqualTo(Short value) {
            addCriterion("OptId >=", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdLessThan(Short value) {
            addCriterion("OptId <", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdLessThanOrEqualTo(Short value) {
            addCriterion("OptId <=", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdIn(List<Short> values) {
            addCriterion("OptId in", values, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotIn(List<Short> values) {
            addCriterion("OptId not in", values, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdBetween(Short value1, Short value2) {
            addCriterion("OptId between", value1, value2, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotBetween(Short value1, Short value2) {
            addCriterion("OptId not between", value1, value2, "optId");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeIsNull() {
            addCriterion("GrenerTime is null");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeIsNotNull() {
            addCriterion("GrenerTime is not null");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeEqualTo(Date value) {
            addCriterion("GrenerTime =", value, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeNotEqualTo(Date value) {
            addCriterion("GrenerTime <>", value, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeGreaterThan(Date value) {
            addCriterion("GrenerTime >", value, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("GrenerTime >=", value, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeLessThan(Date value) {
            addCriterion("GrenerTime <", value, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeLessThanOrEqualTo(Date value) {
            addCriterion("GrenerTime <=", value, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeIn(List<Date> values) {
            addCriterion("GrenerTime in", values, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeNotIn(List<Date> values) {
            addCriterion("GrenerTime not in", values, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeBetween(Date value1, Date value2) {
            addCriterion("GrenerTime between", value1, value2, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeNotBetween(Date value1, Date value2) {
            addCriterion("GrenerTime not between", value1, value2, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andMeasTimeIsNull() {
            addCriterion("MeasTime is null");
            return (Criteria) this;
        }
        public Criteria andMeasTimeIsNotNull() {
            addCriterion("MeasTime is not null");
            return (Criteria) this;
        }
        public Criteria andMeasTimeEqualTo(Date value) {
            addCriterion("MeasTime =", value, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTimeNotEqualTo(Date value) {
            addCriterion("MeasTime <>", value, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTimeGreaterThan(Date value) {
            addCriterion("MeasTime >", value, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MeasTime >=", value, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTimeLessThan(Date value) {
            addCriterion("MeasTime <", value, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTimeLessThanOrEqualTo(Date value) {
            addCriterion("MeasTime <=", value, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTimeIn(List<Date> values) {
            addCriterion("MeasTime in", values, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTimeNotIn(List<Date> values) {
            addCriterion("MeasTime not in", values, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTimeBetween(Date value1, Date value2) {
            addCriterion("MeasTime between", value1, value2, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTimeNotBetween(Date value1, Date value2) {
            addCriterion("MeasTime not between", value1, value2, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeIsNull() {
            addCriterion("MeasTermTime is null");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeIsNotNull() {
            addCriterion("MeasTermTime is not null");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeEqualTo(Date value) {
            addCriterion("MeasTermTime =", value, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeNotEqualTo(Date value) {
            addCriterion("MeasTermTime <>", value, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeGreaterThan(Date value) {
            addCriterion("MeasTermTime >", value, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MeasTermTime >=", value, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeLessThan(Date value) {
            addCriterion("MeasTermTime <", value, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeLessThanOrEqualTo(Date value) {
            addCriterion("MeasTermTime <=", value, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeIn(List<Date> values) {
            addCriterion("MeasTermTime in", values, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeNotIn(List<Date> values) {
            addCriterion("MeasTermTime not in", values, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeBetween(Date value1, Date value2) {
            addCriterion("MeasTermTime between", value1, value2, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeNotBetween(Date value1, Date value2) {
            addCriterion("MeasTermTime not between", value1, value2, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasNumIsNull() {
            addCriterion("MeasNum is null");
            return (Criteria) this;
        }
        public Criteria andMeasNumIsNotNull() {
            addCriterion("MeasNum is not null");
            return (Criteria) this;
        }
        public Criteria andMeasNumEqualTo(Integer value) {
            addCriterion("MeasNum =", value, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumNotEqualTo(Integer value) {
            addCriterion("MeasNum <>", value, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumGreaterThan(Integer value) {
            addCriterion("MeasNum >", value, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("MeasNum >=", value, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumLessThan(Integer value) {
            addCriterion("MeasNum <", value, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumLessThanOrEqualTo(Integer value) {
            addCriterion("MeasNum <=", value, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumIn(List<Integer> values) {
            addCriterion("MeasNum in", values, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumNotIn(List<Integer> values) {
            addCriterion("MeasNum not in", values, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumBetween(Integer value1, Integer value2) {
            addCriterion("MeasNum between", value1, value2, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumNotBetween(Integer value1, Integer value2) {
            addCriterion("MeasNum not between", value1, value2, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasCorrNoIsNull() {
            addCriterion("MeasCorrNo is null");
            return (Criteria) this;
        }
        public Criteria andMeasCorrNoIsNotNull() {
            addCriterion("MeasCorrNo is not null");
            return (Criteria) this;
        }
        public Criteria andMeasCorrNoEqualTo(Long value) {
            addCriterion("MeasCorrNo =", value, "measCorrNo");
            return (Criteria) this;
        }
        public Criteria andMeasCorrNoNotEqualTo(Long value) {
            addCriterion("MeasCorrNo <>", value, "measCorrNo");
            return (Criteria) this;
        }
        public Criteria andMeasCorrNoGreaterThan(Long value) {
            addCriterion("MeasCorrNo >", value, "measCorrNo");
            return (Criteria) this;
        }
        public Criteria andMeasCorrNoGreaterThanOrEqualTo(Long value) {
            addCriterion("MeasCorrNo >=", value, "measCorrNo");
            return (Criteria) this;
        }
        public Criteria andMeasCorrNoLessThan(Long value) {
            addCriterion("MeasCorrNo <", value, "measCorrNo");
            return (Criteria) this;
        }
        public Criteria andMeasCorrNoLessThanOrEqualTo(Long value) {
            addCriterion("MeasCorrNo <=", value, "measCorrNo");
            return (Criteria) this;
        }
        public Criteria andMeasCorrNoIn(List<Long> values) {
            addCriterion("MeasCorrNo in", values, "measCorrNo");
            return (Criteria) this;
        }
        public Criteria andMeasCorrNoNotIn(List<Long> values) {
            addCriterion("MeasCorrNo not in", values, "measCorrNo");
            return (Criteria) this;
        }
        public Criteria andMeasCorrNoBetween(Long value1, Long value2) {
            addCriterion("MeasCorrNo between", value1, value2, "measCorrNo");
            return (Criteria) this;
        }
        public Criteria andMeasCorrNoNotBetween(Long value1, Long value2) {
            addCriterion("MeasCorrNo not between", value1, value2, "measCorrNo");
            return (Criteria) this;
        }
        public Criteria andMeasCorrTermNoIsNull() {
            addCriterion("MeasCorrTermNo is null");
            return (Criteria) this;
        }
        public Criteria andMeasCorrTermNoIsNotNull() {
            addCriterion("MeasCorrTermNo is not null");
            return (Criteria) this;
        }
        public Criteria andMeasCorrTermNoEqualTo(Long value) {
            addCriterion("MeasCorrTermNo =", value, "measCorrTermNo");
            return (Criteria) this;
        }
        public Criteria andMeasCorrTermNoNotEqualTo(Long value) {
            addCriterion("MeasCorrTermNo <>", value, "measCorrTermNo");
            return (Criteria) this;
        }
        public Criteria andMeasCorrTermNoGreaterThan(Long value) {
            addCriterion("MeasCorrTermNo >", value, "measCorrTermNo");
            return (Criteria) this;
        }
        public Criteria andMeasCorrTermNoGreaterThanOrEqualTo(Long value) {
            addCriterion("MeasCorrTermNo >=", value, "measCorrTermNo");
            return (Criteria) this;
        }
        public Criteria andMeasCorrTermNoLessThan(Long value) {
            addCriterion("MeasCorrTermNo <", value, "measCorrTermNo");
            return (Criteria) this;
        }
        public Criteria andMeasCorrTermNoLessThanOrEqualTo(Long value) {
            addCriterion("MeasCorrTermNo <=", value, "measCorrTermNo");
            return (Criteria) this;
        }
        public Criteria andMeasCorrTermNoIn(List<Long> values) {
            addCriterion("MeasCorrTermNo in", values, "measCorrTermNo");
            return (Criteria) this;
        }
        public Criteria andMeasCorrTermNoNotIn(List<Long> values) {
            addCriterion("MeasCorrTermNo not in", values, "measCorrTermNo");
            return (Criteria) this;
        }
        public Criteria andMeasCorrTermNoBetween(Long value1, Long value2) {
            addCriterion("MeasCorrTermNo between", value1, value2, "measCorrTermNo");
            return (Criteria) this;
        }
        public Criteria andMeasCorrTermNoNotBetween(Long value1, Long value2) {
            addCriterion("MeasCorrTermNo not between", value1, value2, "measCorrTermNo");
            return (Criteria) this;
        }
        public Criteria andReportStateIsNull() {
            addCriterion("ReportState is null");
            return (Criteria) this;
        }
        public Criteria andReportStateIsNotNull() {
            addCriterion("ReportState is not null");
            return (Criteria) this;
        }
        public Criteria andReportStateEqualTo(String value) {
            addCriterion("ReportState =", value, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateNotEqualTo(String value) {
            addCriterion("ReportState <>", value, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateGreaterThan(String value) {
            addCriterion("ReportState >", value, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateGreaterThanOrEqualTo(String value) {
            addCriterion("ReportState >=", value, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateLessThan(String value) {
            addCriterion("ReportState <", value, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateLessThanOrEqualTo(String value) {
            addCriterion("ReportState <=", value, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateLike(String value) {
            addCriterion("ReportState like", value, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateNotLike(String value) {
            addCriterion("ReportState not like", value, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateIn(List<String> values) {
            addCriterion("ReportState in", values, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateNotIn(List<String> values) {
            addCriterion("ReportState not in", values, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateBetween(String value1, String value2) {
            addCriterion("ReportState between", value1, value2, "reportState");
            return (Criteria) this;
        }
        public Criteria andReportStateNotBetween(String value1, String value2) {
            addCriterion("ReportState not between", value1, value2, "reportState");
            return (Criteria) this;
        }
        public Criteria andPendingLevelIsNull() {
            addCriterion("PendingLevel is null");
            return (Criteria) this;
        }
        public Criteria andPendingLevelIsNotNull() {
            addCriterion("PendingLevel is not null");
            return (Criteria) this;
        }
        public Criteria andPendingLevelEqualTo(Short value) {
            addCriterion("PendingLevel =", value, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andPendingLevelNotEqualTo(Short value) {
            addCriterion("PendingLevel <>", value, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andPendingLevelGreaterThan(Short value) {
            addCriterion("PendingLevel >", value, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andPendingLevelGreaterThanOrEqualTo(Short value) {
            addCriterion("PendingLevel >=", value, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andPendingLevelLessThan(Short value) {
            addCriterion("PendingLevel <", value, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andPendingLevelLessThanOrEqualTo(Short value) {
            addCriterion("PendingLevel <=", value, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andPendingLevelIn(List<Short> values) {
            addCriterion("PendingLevel in", values, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andPendingLevelNotIn(List<Short> values) {
            addCriterion("PendingLevel not in", values, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andPendingLevelBetween(Short value1, Short value2) {
            addCriterion("PendingLevel between", value1, value2, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andPendingLevelNotBetween(Short value1, Short value2) {
            addCriterion("PendingLevel not between", value1, value2, "pendingLevel");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagIsNull() {
            addCriterion("RetrialBackTag is null");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagIsNotNull() {
            addCriterion("RetrialBackTag is not null");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagEqualTo(String value) {
            addCriterion("RetrialBackTag =", value, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagNotEqualTo(String value) {
            addCriterion("RetrialBackTag <>", value, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagGreaterThan(String value) {
            addCriterion("RetrialBackTag >", value, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagGreaterThanOrEqualTo(String value) {
            addCriterion("RetrialBackTag >=", value, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagLessThan(String value) {
            addCriterion("RetrialBackTag <", value, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagLessThanOrEqualTo(String value) {
            addCriterion("RetrialBackTag <=", value, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagLike(String value) {
            addCriterion("RetrialBackTag like", value, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagNotLike(String value) {
            addCriterion("RetrialBackTag not like", value, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagIn(List<String> values) {
            addCriterion("RetrialBackTag in", values, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagNotIn(List<String> values) {
            addCriterion("RetrialBackTag not in", values, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagBetween(String value1, String value2) {
            addCriterion("RetrialBackTag between", value1, value2, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andRetrialBackTagNotBetween(String value1, String value2) {
            addCriterion("RetrialBackTag not between", value1, value2, "retrialBackTag");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonIsNull() {
            addCriterion("ApprovalReason is null");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonIsNotNull() {
            addCriterion("ApprovalReason is not null");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonEqualTo(String value) {
            addCriterion("ApprovalReason =", value, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonNotEqualTo(String value) {
            addCriterion("ApprovalReason <>", value, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonGreaterThan(String value) {
            addCriterion("ApprovalReason >", value, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonGreaterThanOrEqualTo(String value) {
            addCriterion("ApprovalReason >=", value, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonLessThan(String value) {
            addCriterion("ApprovalReason <", value, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonLessThanOrEqualTo(String value) {
            addCriterion("ApprovalReason <=", value, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonLike(String value) {
            addCriterion("ApprovalReason like", value, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonNotLike(String value) {
            addCriterion("ApprovalReason not like", value, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonIn(List<String> values) {
            addCriterion("ApprovalReason in", values, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonNotIn(List<String> values) {
            addCriterion("ApprovalReason not in", values, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonBetween(String value1, String value2) {
            addCriterion("ApprovalReason between", value1, value2, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andApprovalReasonNotBetween(String value1, String value2) {
            addCriterion("ApprovalReason not between", value1, value2, "approvalReason");
            return (Criteria) this;
        }
        public Criteria andChkDescIsNull() {
            addCriterion("ChkDesc is null");
            return (Criteria) this;
        }
        public Criteria andChkDescIsNotNull() {
            addCriterion("ChkDesc is not null");
            return (Criteria) this;
        }
        public Criteria andChkDescEqualTo(String value) {
            addCriterion("ChkDesc =", value, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescNotEqualTo(String value) {
            addCriterion("ChkDesc <>", value, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescGreaterThan(String value) {
            addCriterion("ChkDesc >", value, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescGreaterThanOrEqualTo(String value) {
            addCriterion("ChkDesc >=", value, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescLessThan(String value) {
            addCriterion("ChkDesc <", value, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescLessThanOrEqualTo(String value) {
            addCriterion("ChkDesc <=", value, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescLike(String value) {
            addCriterion("ChkDesc like", value, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescNotLike(String value) {
            addCriterion("ChkDesc not like", value, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescIn(List<String> values) {
            addCriterion("ChkDesc in", values, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescNotIn(List<String> values) {
            addCriterion("ChkDesc not in", values, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescBetween(String value1, String value2) {
            addCriterion("ChkDesc between", value1, value2, "chkDesc");
            return (Criteria) this;
        }
        public Criteria andChkDescNotBetween(String value1, String value2) {
            addCriterion("ChkDesc not between", value1, value2, "chkDesc");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 单项测量报告（OMRR）
     * 
     * @author ${user}
     * @version 1.0 2016-07-20
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