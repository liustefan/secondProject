/*
 * OasrExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-19 Created
 */
package com.bithealth.questionCore.audit.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OasrExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public OasrExample() {
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
     * 当生成测量报告或会员提交答卷时，根据对应的审核模板生成所有审核步骤记录
     * 
     * @author ${user}
     * @version 1.0 2016-07-19
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
        public Criteria andSerialNumberIsNull() {
            addCriterion("oasr.serialNumber is null");
            return (Criteria) this;
        }
        public Criteria andSerialNumberIsNotNull() {
            addCriterion("oasr.serialNumber is not null");
            return (Criteria) this;
        }
        public Criteria andSerialNumberEqualTo(Long value) {
            addCriterion("oasr.serialNumber =", value, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberNotEqualTo(Long value) {
            addCriterion("oasr.serialNumber <>", value, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberGreaterThan(Long value) {
            addCriterion("oasr.serialNumber >", value, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("oasr.serialNumber >=", value, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberLessThan(Long value) {
            addCriterion("oasr.serialNumber <", value, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberLessThanOrEqualTo(Long value) {
            addCriterion("oasr.serialNumber <=", value, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberIn(List<Long> values) {
            addCriterion("oasr.serialNumber in", values, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberNotIn(List<Long> values) {
            addCriterion("oasr.serialNumber not in", values, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberBetween(Long value1, Long value2) {
            addCriterion("oasr.serialNumber between", value1, value2, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberNotBetween(Long value1, Long value2) {
            addCriterion("oasr.serialNumber not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andReportNoIsNull() {
            addCriterion("oasr.ReportNo is null");
            return (Criteria) this;
        }
        public Criteria andReportNoIsNotNull() {
            addCriterion("oasr.ReportNo is not null");
            return (Criteria) this;
        }
        public Criteria andReportNoEqualTo(Integer value) {
            addCriterion("oasr.ReportNo =", value, "reportNo");
            return (Criteria) this;
        }
        public Criteria andReportNoNotEqualTo(Integer value) {
            addCriterion("oasr.ReportNo <>", value, "reportNo");
            return (Criteria) this;
        }
        public Criteria andReportNoGreaterThan(Integer value) {
            addCriterion("oasr.ReportNo >", value, "reportNo");
            return (Criteria) this;
        }
        public Criteria andReportNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("oasr.ReportNo >=", value, "reportNo");
            return (Criteria) this;
        }
        public Criteria andReportNoLessThan(Integer value) {
            addCriterion("oasr.ReportNo <", value, "reportNo");
            return (Criteria) this;
        }
        public Criteria andReportNoLessThanOrEqualTo(Integer value) {
            addCriterion("oasr.ReportNo <=", value, "reportNo");
            return (Criteria) this;
        }
        public Criteria andReportNoIn(List<Integer> values) {
            addCriterion("oasr.ReportNo in", values, "reportNo");
            return (Criteria) this;
        }
        public Criteria andReportNoNotIn(List<Integer> values) {
            addCriterion("oasr.ReportNo not in", values, "reportNo");
            return (Criteria) this;
        }
        public Criteria andReportNoBetween(Integer value1, Integer value2) {
            addCriterion("oasr.ReportNo between", value1, value2, "reportNo");
            return (Criteria) this;
        }
        public Criteria andReportNoNotBetween(Integer value1, Integer value2) {
            addCriterion("oasr.ReportNo not between", value1, value2, "reportNo");
            return (Criteria) this;
        }
        public Criteria andOptIdIsNull() {
            addCriterion("oasr.OptId is null");
            return (Criteria) this;
        }
        public Criteria andOptIdIsNotNull() {
            addCriterion("oasr.OptId is not null");
            return (Criteria) this;
        }
        public Criteria andOptIdEqualTo(Short value) {
            addCriterion("oasr.OptId =", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotEqualTo(Short value) {
            addCriterion("oasr.OptId <>", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdGreaterThan(Short value) {
            addCriterion("oasr.OptId >", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdGreaterThanOrEqualTo(Short value) {
            addCriterion("oasr.OptId >=", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdLessThan(Short value) {
            addCriterion("oasr.OptId <", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdLessThanOrEqualTo(Short value) {
            addCriterion("oasr.OptId <=", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdIn(List<Short> values) {
            addCriterion("oasr.OptId in", values, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotIn(List<Short> values) {
            addCriterion("oasr.OptId not in", values, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdBetween(Short value1, Short value2) {
            addCriterion("oasr.OptId between", value1, value2, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotBetween(Short value1, Short value2) {
            addCriterion("oasr.OptId not between", value1, value2, "optId");
            return (Criteria) this;
        }
        public Criteria andOptNameIsNull() {
            addCriterion("oasr.OptName is null");
            return (Criteria) this;
        }
        public Criteria andOptNameIsNotNull() {
            addCriterion("oasr.OptName is not null");
            return (Criteria) this;
        }
        public Criteria andOptNameEqualTo(String value) {
            addCriterion("oasr.OptName =", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameNotEqualTo(String value) {
            addCriterion("oasr.OptName <>", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameGreaterThan(String value) {
            addCriterion("oasr.OptName >", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameGreaterThanOrEqualTo(String value) {
            addCriterion("oasr.OptName >=", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameLessThan(String value) {
            addCriterion("oasr.OptName <", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameLessThanOrEqualTo(String value) {
            addCriterion("oasr.OptName <=", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameLike(String value) {
            addCriterion("oasr.OptName like", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameNotLike(String value) {
            addCriterion("oasr.OptName not like", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameIn(List<String> values) {
            addCriterion("oasr.OptName in", values, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameNotIn(List<String> values) {
            addCriterion("oasr.OptName not in", values, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameBetween(String value1, String value2) {
            addCriterion("oasr.OptName between", value1, value2, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameNotBetween(String value1, String value2) {
            addCriterion("oasr.OptName not between", value1, value2, "optName");
            return (Criteria) this;
        }
        public Criteria andMemberidIsNull() {
            addCriterion("oasr.Memberid is null");
            return (Criteria) this;
        }
        public Criteria andMemberidIsNotNull() {
            addCriterion("oasr.Memberid is not null");
            return (Criteria) this;
        }
        public Criteria andMemberidEqualTo(Integer value) {
            addCriterion("oasr.Memberid =", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotEqualTo(Integer value) {
            addCriterion("oasr.Memberid <>", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidGreaterThan(Integer value) {
            addCriterion("oasr.Memberid >", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidGreaterThanOrEqualTo(Integer value) {
            addCriterion("oasr.Memberid >=", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidLessThan(Integer value) {
            addCriterion("oasr.Memberid <", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidLessThanOrEqualTo(Integer value) {
            addCriterion("oasr.Memberid <=", value, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidIn(List<Integer> values) {
            addCriterion("oasr.Memberid in", values, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotIn(List<Integer> values) {
            addCriterion("oasr.Memberid not in", values, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidBetween(Integer value1, Integer value2) {
            addCriterion("oasr.Memberid between", value1, value2, "memberid");
            return (Criteria) this;
        }
        public Criteria andMemberidNotBetween(Integer value1, Integer value2) {
            addCriterion("oasr.Memberid not between", value1, value2, "memberid");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeIsNull() {
            addCriterion("oasr.DocGrpCode is null");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeIsNotNull() {
            addCriterion("oasr.DocGrpCode is not null");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeEqualTo(Integer value) {
            addCriterion("oasr.DocGrpCode =", value, "docGrpCode");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeNotEqualTo(Integer value) {
            addCriterion("oasr.DocGrpCode <>", value, "docGrpCode");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeGreaterThan(Integer value) {
            addCriterion("oasr.DocGrpCode >", value, "docGrpCode");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("oasr.DocGrpCode >=", value, "docGrpCode");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeLessThan(Integer value) {
            addCriterion("oasr.DocGrpCode <", value, "docGrpCode");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeLessThanOrEqualTo(Integer value) {
            addCriterion("oasr.DocGrpCode <=", value, "docGrpCode");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeIn(List<Integer> values) {
            addCriterion("oasr.DocGrpCode in", values, "docGrpCode");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeNotIn(List<Integer> values) {
            addCriterion("oasr.DocGrpCode not in", values, "docGrpCode");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeBetween(Integer value1, Integer value2) {
            addCriterion("oasr.DocGrpCode between", value1, value2, "docGrpCode");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("oasr.DocGrpCode not between", value1, value2, "docGrpCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeIsNull() {
            addCriterion("oasr.TempCode is null");
            return (Criteria) this;
        }
        public Criteria andTempCodeIsNotNull() {
            addCriterion("oasr.TempCode is not null");
            return (Criteria) this;
        }
        public Criteria andTempCodeEqualTo(Integer value) {
            addCriterion("oasr.TempCode =", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeNotEqualTo(Integer value) {
            addCriterion("oasr.TempCode <>", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeGreaterThan(Integer value) {
            addCriterion("oasr.TempCode >", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("oasr.TempCode >=", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeLessThan(Integer value) {
            addCriterion("oasr.TempCode <", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeLessThanOrEqualTo(Integer value) {
            addCriterion("oasr.TempCode <=", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeIn(List<Integer> values) {
            addCriterion("oasr.TempCode in", values, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeNotIn(List<Integer> values) {
            addCriterion("oasr.TempCode not in", values, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeBetween(Integer value1, Integer value2) {
            addCriterion("oasr.TempCode between", value1, value2, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("oasr.TempCode not between", value1, value2, "tempCode");
            return (Criteria) this;
        }
        public Criteria andMeasTimeIsNull() {
            addCriterion("oasr.MeasTime is null");
            return (Criteria) this;
        }
        public Criteria andMeasTimeIsNotNull() {
            addCriterion("oasr.MeasTime is not null");
            return (Criteria) this;
        }
        public Criteria andMeasTimeEqualTo(Date value) {
            addCriterion("oasr.MeasTime =", value, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTimeNotEqualTo(Date value) {
            addCriterion("oasr.MeasTime <>", value, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTimeGreaterThan(Date value) {
            addCriterion("oasr.MeasTime >", value, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("oasr.MeasTime >=", value, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTimeLessThan(Date value) {
            addCriterion("oasr.MeasTime <", value, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTimeLessThanOrEqualTo(Date value) {
            addCriterion("oasr.MeasTime <=", value, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTimeIn(List<Date> values) {
            addCriterion("oasr.MeasTime in", values, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTimeNotIn(List<Date> values) {
            addCriterion("oasr.MeasTime not in", values, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTimeBetween(Date value1, Date value2) {
            addCriterion("oasr.MeasTime between", value1, value2, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTimeNotBetween(Date value1, Date value2) {
            addCriterion("oasr.MeasTime not between", value1, value2, "measTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeIsNull() {
            addCriterion("oasr.MeasTermTime is null");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeIsNotNull() {
            addCriterion("oasr.MeasTermTime is not null");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeEqualTo(Date value) {
            addCriterion("oasr.MeasTermTime =", value, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeNotEqualTo(Date value) {
            addCriterion("oasr.MeasTermTime <>", value, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeGreaterThan(Date value) {
            addCriterion("oasr.MeasTermTime >", value, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("oasr.MeasTermTime >=", value, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeLessThan(Date value) {
            addCriterion("oasr.MeasTermTime <", value, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeLessThanOrEqualTo(Date value) {
            addCriterion("oasr.MeasTermTime <=", value, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeIn(List<Date> values) {
            addCriterion("oasr.MeasTermTime in", values, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeNotIn(List<Date> values) {
            addCriterion("oasr.MeasTermTime not in", values, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeBetween(Date value1, Date value2) {
            addCriterion("oasr.MeasTermTime between", value1, value2, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasTermTimeNotBetween(Date value1, Date value2) {
            addCriterion("oasr.MeasTermTime not between", value1, value2, "measTermTime");
            return (Criteria) this;
        }
        public Criteria andMeasNumIsNull() {
            addCriterion("oasr.MeasNum is null");
            return (Criteria) this;
        }
        public Criteria andMeasNumIsNotNull() {
            addCriterion("oasr.MeasNum is not null");
            return (Criteria) this;
        }
        public Criteria andMeasNumEqualTo(Short value) {
            addCriterion("oasr.MeasNum =", value, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumNotEqualTo(Short value) {
            addCriterion("oasr.MeasNum <>", value, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumGreaterThan(Short value) {
            addCriterion("oasr.MeasNum >", value, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumGreaterThanOrEqualTo(Short value) {
            addCriterion("oasr.MeasNum >=", value, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumLessThan(Short value) {
            addCriterion("oasr.MeasNum <", value, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumLessThanOrEqualTo(Short value) {
            addCriterion("oasr.MeasNum <=", value, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumIn(List<Short> values) {
            addCriterion("oasr.MeasNum in", values, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumNotIn(List<Short> values) {
            addCriterion("oasr.MeasNum not in", values, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumBetween(Short value1, Short value2) {
            addCriterion("oasr.MeasNum between", value1, value2, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumNotBetween(Short value1, Short value2) {
            addCriterion("oasr.MeasNum not between", value1, value2, "measNum");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeIsNull() {
            addCriterion("oasr.GrenerTime is null");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeIsNotNull() {
            addCriterion("oasr.GrenerTime is not null");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeEqualTo(Date value) {
            addCriterion("oasr.GrenerTime =", value, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeNotEqualTo(Date value) {
            addCriterion("oasr.GrenerTime <>", value, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeGreaterThan(Date value) {
            addCriterion("oasr.GrenerTime >", value, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("oasr.GrenerTime >=", value, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeLessThan(Date value) {
            addCriterion("oasr.GrenerTime <", value, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeLessThanOrEqualTo(Date value) {
            addCriterion("oasr.GrenerTime <=", value, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeIn(List<Date> values) {
            addCriterion("oasr.GrenerTime in", values, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeNotIn(List<Date> values) {
            addCriterion("oasr.GrenerTime not in", values, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeBetween(Date value1, Date value2) {
            addCriterion("oasr.GrenerTime between", value1, value2, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andGrenerTimeNotBetween(Date value1, Date value2) {
            addCriterion("oasr.GrenerTime not between", value1, value2, "grenerTime");
            return (Criteria) this;
        }
        public Criteria andAuditLevelIsNull() {
            addCriterion("oasr.AuditLevel is null");
            return (Criteria) this;
        }
        public Criteria andAuditLevelIsNotNull() {
            addCriterion("oasr.AuditLevel is not null");
            return (Criteria) this;
        }
        public Criteria andAuditLevelEqualTo(Short value) {
            addCriterion("oasr.AuditLevel =", value, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditLevelNotEqualTo(Short value) {
            addCriterion("oasr.AuditLevel <>", value, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditLevelGreaterThan(Short value) {
            addCriterion("oasr.AuditLevel >", value, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditLevelGreaterThanOrEqualTo(Short value) {
            addCriterion("oasr.AuditLevel >=", value, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditLevelLessThan(Short value) {
            addCriterion("oasr.AuditLevel <", value, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditLevelLessThanOrEqualTo(Short value) {
            addCriterion("oasr.AuditLevel <=", value, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditLevelIn(List<Short> values) {
            addCriterion("oasr.AuditLevel in", values, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditLevelNotIn(List<Short> values) {
            addCriterion("oasr.AuditLevel not in", values, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditLevelBetween(Short value1, Short value2) {
            addCriterion("oasr.AuditLevel between", value1, value2, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditLevelNotBetween(Short value1, Short value2) {
            addCriterion("oasr.AuditLevel not between", value1, value2, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditStateIsNull() {
            addCriterion("oasr.AuditState is null");
            return (Criteria) this;
        }
        public Criteria andAuditStateIsNotNull() {
            addCriterion("oasr.AuditState is not null");
            return (Criteria) this;
        }
        public Criteria andAuditStateEqualTo(String value) {
            addCriterion("oasr.AuditState =", value, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateNotEqualTo(String value) {
            addCriterion("oasr.AuditState <>", value, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateGreaterThan(String value) {
            addCriterion("oasr.AuditState >", value, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateGreaterThanOrEqualTo(String value) {
            addCriterion("oasr.AuditState >=", value, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateLessThan(String value) {
            addCriterion("oasr.AuditState <", value, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateLessThanOrEqualTo(String value) {
            addCriterion("oasr.AuditState <=", value, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateLike(String value) {
            addCriterion("oasr.AuditState like", value, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateNotLike(String value) {
            addCriterion("oasr.AuditState not like", value, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateIn(List<String> values) {
            addCriterion("oasr.AuditState in", values, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateNotIn(List<String> values) {
            addCriterion("oasr.AuditState not in", values, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateBetween(String value1, String value2) {
            addCriterion("oasr.AuditState between", value1, value2, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateNotBetween(String value1, String value2) {
            addCriterion("oasr.AuditState not between", value1, value2, "auditState");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherIsNull() {
            addCriterion("oasr.SubmitOther is null");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherIsNotNull() {
            addCriterion("oasr.SubmitOther is not null");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherEqualTo(String value) {
            addCriterion("oasr.SubmitOther =", value, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherNotEqualTo(String value) {
            addCriterion("oasr.SubmitOther <>", value, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherGreaterThan(String value) {
            addCriterion("oasr.SubmitOther >", value, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherGreaterThanOrEqualTo(String value) {
            addCriterion("oasr.SubmitOther >=", value, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherLessThan(String value) {
            addCriterion("oasr.SubmitOther <", value, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherLessThanOrEqualTo(String value) {
            addCriterion("oasr.SubmitOther <=", value, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherLike(String value) {
            addCriterion("oasr.SubmitOther like", value, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherNotLike(String value) {
            addCriterion("oasr.SubmitOther not like", value, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherIn(List<String> values) {
            addCriterion("oasr.SubmitOther in", values, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherNotIn(List<String> values) {
            addCriterion("oasr.SubmitOther not in", values, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherBetween(String value1, String value2) {
            addCriterion("oasr.SubmitOther between", value1, value2, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherNotBetween(String value1, String value2) {
            addCriterion("oasr.SubmitOther not between", value1, value2, "submitOther");
            return (Criteria) this;
        }
        public Criteria andYNTagIsNull() {
            addCriterion("oasr.YNTag is null");
            return (Criteria) this;
        }
        public Criteria andYNTagIsNotNull() {
            addCriterion("oasr.YNTag is not null");
            return (Criteria) this;
        }
        public Criteria andYNTagEqualTo(String value) {
            addCriterion("oasr.YNTag =", value, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagNotEqualTo(String value) {
            addCriterion("oasr.YNTag <>", value, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagGreaterThan(String value) {
            addCriterion("oasr.YNTag >", value, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagGreaterThanOrEqualTo(String value) {
            addCriterion("oasr.YNTag >=", value, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagLessThan(String value) {
            addCriterion("oasr.YNTag <", value, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagLessThanOrEqualTo(String value) {
            addCriterion("oasr.YNTag <=", value, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagLike(String value) {
            addCriterion("oasr.YNTag like", value, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagNotLike(String value) {
            addCriterion("oasr.YNTag not like", value, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagIn(List<String> values) {
            addCriterion("oasr.YNTag in", values, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagNotIn(List<String> values) {
            addCriterion("oasr.YNTag not in", values, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagBetween(String value1, String value2) {
            addCriterion("oasr.YNTag between", value1, value2, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagNotBetween(String value1, String value2) {
            addCriterion("oasr.YNTag not between", value1, value2, "YNTag");
            return (Criteria) this;
        }
        public Criteria andDocidIsNull() {
            addCriterion("oasr.Docid is null");
            return (Criteria) this;
        }
        public Criteria andDocidIsNotNull() {
            addCriterion("oasr.Docid is not null");
            return (Criteria) this;
        }
        public Criteria andDocidEqualTo(Integer value) {
            addCriterion("answer.Docid =", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidNotEqualTo(Integer value) {
            addCriterion("answer.Docid <>", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidGreaterThan(Integer value) {
            addCriterion("answer.Docid >", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidGreaterThanOrEqualTo(Integer value) {
            addCriterion("answer.Docid >=", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidLessThan(Integer value) {
            addCriterion("answer.Docid <", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidLessThanOrEqualTo(Integer value) {
            addCriterion("answer.Docid <=", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidIn(List<Integer> values) {
            addCriterion("answer.Docid in", values, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidNotIn(List<Integer> values) {
            addCriterion("answer.Docid not in", values, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidBetween(Integer value1, Integer value2) {
            addCriterion("answer.Docid between", value1, value2, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidNotBetween(Integer value1, Integer value2) {
            addCriterion("answer.Docid not between", value1, value2, "docid");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeIsNull() {
            addCriterion("oasr.AuditDatetime is null");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeIsNotNull() {
            addCriterion("oasr.AuditDatetime is not null");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeEqualTo(Date value) {
            addCriterion("oasr.AuditDatetime =", value, "auditDatetime");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeNotEqualTo(Date value) {
            addCriterion("oasr.AuditDatetime <>", value, "auditDatetime");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeGreaterThan(Date value) {
            addCriterion("oasr.AuditDatetime >", value, "auditDatetime");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("oasr.AuditDatetime >=", value, "auditDatetime");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeLessThan(Date value) {
            addCriterion("oasr.AuditDatetime <", value, "auditDatetime");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("oasr.AuditDatetime <=", value, "auditDatetime");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeIn(List<Date> values) {
            addCriterion("oasr.AuditDatetime in", values, "auditDatetime");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeNotIn(List<Date> values) {
            addCriterion("oasr.AuditDatetime not in", values, "auditDatetime");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeBetween(Date value1, Date value2) {
            addCriterion("oasr.AuditDatetime between", value1, value2, "auditDatetime");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("oasr.AuditDatetime not between", value1, value2, "auditDatetime");
            return (Criteria) this;
        }
        public Criteria andFunIdEqualTo(Short value) {
            addCriterion("oopt.funId =", value, "funId");
            return (Criteria) this;
        }
        public Criteria andUseTagEqualTo(String value) {
            addCriterion("omem.UseTag =", value, "UseTag");
            return (Criteria) this;
        }
        public Criteria andCombAnsidIsNull() {
            addCriterion("cam1.CombAnsid is null");
            return (Criteria) this;
        }
        
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 当生成测量报告或会员提交答卷时，根据对应的审核模板生成所有审核步骤记录
     * 
     * @author ${user}
     * @version 1.0 2016-07-19
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