/*
 * AuditProgressExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-20 Created
 */
package com.bithealth.reportCore.report.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuditProgressExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public AuditProgressExample() {
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
        public Criteria andSerialNumberIsNull() {
            addCriterion("serialNumber is null");
            return (Criteria) this;
        }
        public Criteria andSerialNumberIsNotNull() {
            addCriterion("serialNumber is not null");
            return (Criteria) this;
        }
        public Criteria andSerialNumberEqualTo(Long value) {
            addCriterion("serialNumber =", value, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberNotEqualTo(Long value) {
            addCriterion("serialNumber <>", value, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberGreaterThan(Long value) {
            addCriterion("serialNumber >", value, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("serialNumber >=", value, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberLessThan(Long value) {
            addCriterion("serialNumber <", value, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberLessThanOrEqualTo(Long value) {
            addCriterion("serialNumber <=", value, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberIn(List<Long> values) {
            addCriterion("serialNumber in", values, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberNotIn(List<Long> values) {
            addCriterion("serialNumber not in", values, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberBetween(Long value1, Long value2) {
            addCriterion("serialNumber between", value1, value2, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andSerialNumberNotBetween(Long value1, Long value2) {
            addCriterion("serialNumber not between", value1, value2, "serialNumber");
            return (Criteria) this;
        }
        public Criteria andReportNoIsNull() {
            addCriterion("ReportNo is null");
            return (Criteria) this;
        }
        public Criteria andReportNoIsNotNull() {
            addCriterion("ReportNo is not null");
            return (Criteria) this;
        }
        public Criteria andReportNoEqualTo(Integer value) {
            addCriterion("ReportNo =", value, "reportNo");
            return (Criteria) this;
        }
        public Criteria andReportNoNotEqualTo(Integer value) {
            addCriterion("ReportNo <>", value, "reportNo");
            return (Criteria) this;
        }
        public Criteria andReportNoGreaterThan(Integer value) {
            addCriterion("ReportNo >", value, "reportNo");
            return (Criteria) this;
        }
        public Criteria andReportNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ReportNo >=", value, "reportNo");
            return (Criteria) this;
        }
        public Criteria andReportNoLessThan(Integer value) {
            addCriterion("ReportNo <", value, "reportNo");
            return (Criteria) this;
        }
        public Criteria andReportNoLessThanOrEqualTo(Integer value) {
            addCriterion("ReportNo <=", value, "reportNo");
            return (Criteria) this;
        }
        public Criteria andReportNoIn(List<Integer> values) {
            addCriterion("ReportNo in", values, "reportNo");
            return (Criteria) this;
        }
        public Criteria andReportNoNotIn(List<Integer> values) {
            addCriterion("ReportNo not in", values, "reportNo");
            return (Criteria) this;
        }
        public Criteria andReportNoBetween(Integer value1, Integer value2) {
            addCriterion("ReportNo between", value1, value2, "reportNo");
            return (Criteria) this;
        }
        public Criteria andReportNoNotBetween(Integer value1, Integer value2) {
            addCriterion("ReportNo not between", value1, value2, "reportNo");
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
        public Criteria andOptNameIsNull() {
            addCriterion("OptName is null");
            return (Criteria) this;
        }
        public Criteria andOptNameIsNotNull() {
            addCriterion("OptName is not null");
            return (Criteria) this;
        }
        public Criteria andOptNameEqualTo(String value) {
            addCriterion("OptName =", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameNotEqualTo(String value) {
            addCriterion("OptName <>", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameGreaterThan(String value) {
            addCriterion("OptName >", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameGreaterThanOrEqualTo(String value) {
            addCriterion("OptName >=", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameLessThan(String value) {
            addCriterion("OptName <", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameLessThanOrEqualTo(String value) {
            addCriterion("OptName <=", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameLike(String value) {
            addCriterion("OptName like", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameNotLike(String value) {
            addCriterion("OptName not like", value, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameIn(List<String> values) {
            addCriterion("OptName in", values, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameNotIn(List<String> values) {
            addCriterion("OptName not in", values, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameBetween(String value1, String value2) {
            addCriterion("OptName between", value1, value2, "optName");
            return (Criteria) this;
        }
        public Criteria andOptNameNotBetween(String value1, String value2) {
            addCriterion("OptName not between", value1, value2, "optName");
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
        public Criteria andDocGrpCodeIsNull() {
            addCriterion("DocGrpCode is null");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeIsNotNull() {
            addCriterion("DocGrpCode is not null");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeEqualTo(Integer value) {
            addCriterion("DocGrpCode =", value, "docGrpCode");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeNotEqualTo(Integer value) {
            addCriterion("DocGrpCode <>", value, "docGrpCode");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeGreaterThan(Integer value) {
            addCriterion("DocGrpCode >", value, "docGrpCode");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("DocGrpCode >=", value, "docGrpCode");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeLessThan(Integer value) {
            addCriterion("DocGrpCode <", value, "docGrpCode");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeLessThanOrEqualTo(Integer value) {
            addCriterion("DocGrpCode <=", value, "docGrpCode");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeIn(List<Integer> values) {
            addCriterion("DocGrpCode in", values, "docGrpCode");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeNotIn(List<Integer> values) {
            addCriterion("DocGrpCode not in", values, "docGrpCode");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeBetween(Integer value1, Integer value2) {
            addCriterion("DocGrpCode between", value1, value2, "docGrpCode");
            return (Criteria) this;
        }
        public Criteria andDocGrpCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("DocGrpCode not between", value1, value2, "docGrpCode");
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
        public Criteria andMeasNumEqualTo(Short value) {
            addCriterion("MeasNum =", value, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumNotEqualTo(Short value) {
            addCriterion("MeasNum <>", value, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumGreaterThan(Short value) {
            addCriterion("MeasNum >", value, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumGreaterThanOrEqualTo(Short value) {
            addCriterion("MeasNum >=", value, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumLessThan(Short value) {
            addCriterion("MeasNum <", value, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumLessThanOrEqualTo(Short value) {
            addCriterion("MeasNum <=", value, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumIn(List<Short> values) {
            addCriterion("MeasNum in", values, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumNotIn(List<Short> values) {
            addCriterion("MeasNum not in", values, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumBetween(Short value1, Short value2) {
            addCriterion("MeasNum between", value1, value2, "measNum");
            return (Criteria) this;
        }
        public Criteria andMeasNumNotBetween(Short value1, Short value2) {
            addCriterion("MeasNum not between", value1, value2, "measNum");
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
        public Criteria andAuditLevelIsNull() {
            addCriterion("AuditLevel is null");
            return (Criteria) this;
        }
        public Criteria andAuditLevelIsNotNull() {
            addCriterion("AuditLevel is not null");
            return (Criteria) this;
        }
        public Criteria andAuditLevelEqualTo(Short value) {
            addCriterion("AuditLevel =", value, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditLevelNotEqualTo(Short value) {
            addCriterion("AuditLevel <>", value, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditLevelGreaterThan(Short value) {
            addCriterion("AuditLevel >", value, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditLevelGreaterThanOrEqualTo(Short value) {
            addCriterion("AuditLevel >=", value, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditLevelLessThan(Short value) {
            addCriterion("AuditLevel <", value, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditLevelLessThanOrEqualTo(Short value) {
            addCriterion("AuditLevel <=", value, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditLevelIn(List<Short> values) {
            addCriterion("AuditLevel in", values, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditLevelNotIn(List<Short> values) {
            addCriterion("AuditLevel not in", values, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditLevelBetween(Short value1, Short value2) {
            addCriterion("AuditLevel between", value1, value2, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditLevelNotBetween(Short value1, Short value2) {
            addCriterion("AuditLevel not between", value1, value2, "auditLevel");
            return (Criteria) this;
        }
        public Criteria andAuditStateIsNull() {
            addCriterion("AuditState is null");
            return (Criteria) this;
        }
        public Criteria andAuditStateIsNotNull() {
            addCriterion("AuditState is not null");
            return (Criteria) this;
        }
        public Criteria andAuditStateEqualTo(String value) {
            addCriterion("AuditState =", value, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateNotEqualTo(String value) {
            addCriterion("AuditState <>", value, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateGreaterThan(String value) {
            addCriterion("AuditState >", value, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateGreaterThanOrEqualTo(String value) {
            addCriterion("AuditState >=", value, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateLessThan(String value) {
            addCriterion("AuditState <", value, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateLessThanOrEqualTo(String value) {
            addCriterion("AuditState <=", value, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateLike(String value) {
            addCriterion("AuditState like", value, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateNotLike(String value) {
            addCriterion("AuditState not like", value, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateIn(List<String> values) {
            addCriterion("AuditState in", values, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateNotIn(List<String> values) {
            addCriterion("AuditState not in", values, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateBetween(String value1, String value2) {
            addCriterion("AuditState between", value1, value2, "auditState");
            return (Criteria) this;
        }
        public Criteria andAuditStateNotBetween(String value1, String value2) {
            addCriterion("AuditState not between", value1, value2, "auditState");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherIsNull() {
            addCriterion("SubmitOther is null");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherIsNotNull() {
            addCriterion("SubmitOther is not null");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherEqualTo(String value) {
            addCriterion("SubmitOther =", value, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherNotEqualTo(String value) {
            addCriterion("SubmitOther <>", value, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherGreaterThan(String value) {
            addCriterion("SubmitOther >", value, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherGreaterThanOrEqualTo(String value) {
            addCriterion("SubmitOther >=", value, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherLessThan(String value) {
            addCriterion("SubmitOther <", value, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherLessThanOrEqualTo(String value) {
            addCriterion("SubmitOther <=", value, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherLike(String value) {
            addCriterion("SubmitOther like", value, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherNotLike(String value) {
            addCriterion("SubmitOther not like", value, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherIn(List<String> values) {
            addCriterion("SubmitOther in", values, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherNotIn(List<String> values) {
            addCriterion("SubmitOther not in", values, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherBetween(String value1, String value2) {
            addCriterion("SubmitOther between", value1, value2, "submitOther");
            return (Criteria) this;
        }
        public Criteria andSubmitOtherNotBetween(String value1, String value2) {
            addCriterion("SubmitOther not between", value1, value2, "submitOther");
            return (Criteria) this;
        }
        public Criteria andYNTagIsNull() {
            addCriterion("YNTag is null");
            return (Criteria) this;
        }
        public Criteria andYNTagIsNotNull() {
            addCriterion("YNTag is not null");
            return (Criteria) this;
        }
        public Criteria andYNTagEqualTo(String value) {
            addCriterion("YNTag =", value, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagNotEqualTo(String value) {
            addCriterion("YNTag <>", value, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagGreaterThan(String value) {
            addCriterion("YNTag >", value, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagGreaterThanOrEqualTo(String value) {
            addCriterion("YNTag >=", value, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagLessThan(String value) {
            addCriterion("YNTag <", value, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagLessThanOrEqualTo(String value) {
            addCriterion("YNTag <=", value, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagLike(String value) {
            addCriterion("YNTag like", value, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagNotLike(String value) {
            addCriterion("YNTag not like", value, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagIn(List<String> values) {
            addCriterion("YNTag in", values, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagNotIn(List<String> values) {
            addCriterion("YNTag not in", values, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagBetween(String value1, String value2) {
            addCriterion("YNTag between", value1, value2, "YNTag");
            return (Criteria) this;
        }
        public Criteria andYNTagNotBetween(String value1, String value2) {
            addCriterion("YNTag not between", value1, value2, "YNTag");
            return (Criteria) this;
        }
        public Criteria andDocidIsNull() {
            addCriterion("Docid is null");
            return (Criteria) this;
        }
        public Criteria andDocidIsNotNull() {
            addCriterion("Docid is not null");
            return (Criteria) this;
        }
        public Criteria andDocidEqualTo(Integer value) {
            addCriterion("Docid =", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidNotEqualTo(Integer value) {
            addCriterion("Docid <>", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidGreaterThan(Integer value) {
            addCriterion("Docid >", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Docid >=", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidLessThan(Integer value) {
            addCriterion("Docid <", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidLessThanOrEqualTo(Integer value) {
            addCriterion("Docid <=", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidIn(List<Integer> values) {
            addCriterion("Docid in", values, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidNotIn(List<Integer> values) {
            addCriterion("Docid not in", values, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidBetween(Integer value1, Integer value2) {
            addCriterion("Docid between", value1, value2, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidNotBetween(Integer value1, Integer value2) {
            addCriterion("Docid not between", value1, value2, "docid");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeIsNull() {
            addCriterion("AuditDatetime is null");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeIsNotNull() {
            addCriterion("AuditDatetime is not null");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeEqualTo(Date value) {
            addCriterion("AuditDatetime =", value, "auditDatetime");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeNotEqualTo(Date value) {
            addCriterion("AuditDatetime <>", value, "auditDatetime");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeGreaterThan(Date value) {
            addCriterion("AuditDatetime >", value, "auditDatetime");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("AuditDatetime >=", value, "auditDatetime");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeLessThan(Date value) {
            addCriterion("AuditDatetime <", value, "auditDatetime");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("AuditDatetime <=", value, "auditDatetime");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeIn(List<Date> values) {
            addCriterion("AuditDatetime in", values, "auditDatetime");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeNotIn(List<Date> values) {
            addCriterion("AuditDatetime not in", values, "auditDatetime");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeBetween(Date value1, Date value2) {
            addCriterion("AuditDatetime between", value1, value2, "auditDatetime");
            return (Criteria) this;
        }
        public Criteria andAuditDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("AuditDatetime not between", value1, value2, "auditDatetime");
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