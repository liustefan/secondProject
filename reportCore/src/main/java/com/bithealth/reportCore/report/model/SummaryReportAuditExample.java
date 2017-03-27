/*
 * SummaryReportAuditExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-20 Created
 */
package com.bithealth.reportCore.report.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SummaryReportAuditExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public SummaryReportAuditExample() {
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
     * 汇总测量审核结果(SMR1)
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
        public Criteria andLogidIsNull() {
            addCriterion("logid is null");
            return (Criteria) this;
        }
        public Criteria andLogidIsNotNull() {
            addCriterion("logid is not null");
            return (Criteria) this;
        }
        public Criteria andLogidEqualTo(Integer value) {
            addCriterion("logid =", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidNotEqualTo(Integer value) {
            addCriterion("logid <>", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidGreaterThan(Integer value) {
            addCriterion("logid >", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidGreaterThanOrEqualTo(Integer value) {
            addCriterion("logid >=", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidLessThan(Integer value) {
            addCriterion("logid <", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidLessThanOrEqualTo(Integer value) {
            addCriterion("logid <=", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidIn(List<Integer> values) {
            addCriterion("logid in", values, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidNotIn(List<Integer> values) {
            addCriterion("logid not in", values, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidBetween(Integer value1, Integer value2) {
            addCriterion("logid between", value1, value2, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidNotBetween(Integer value1, Integer value2) {
            addCriterion("logid not between", value1, value2, "logid");
            return (Criteria) this;
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
        public Criteria andAuditDescIsNull() {
            addCriterion("AuditDesc is null");
            return (Criteria) this;
        }
        public Criteria andAuditDescIsNotNull() {
            addCriterion("AuditDesc is not null");
            return (Criteria) this;
        }
        public Criteria andAuditDescEqualTo(String value) {
            addCriterion("AuditDesc =", value, "auditDesc");
            return (Criteria) this;
        }
        public Criteria andAuditDescNotEqualTo(String value) {
            addCriterion("AuditDesc <>", value, "auditDesc");
            return (Criteria) this;
        }
        public Criteria andAuditDescGreaterThan(String value) {
            addCriterion("AuditDesc >", value, "auditDesc");
            return (Criteria) this;
        }
        public Criteria andAuditDescGreaterThanOrEqualTo(String value) {
            addCriterion("AuditDesc >=", value, "auditDesc");
            return (Criteria) this;
        }
        public Criteria andAuditDescLessThan(String value) {
            addCriterion("AuditDesc <", value, "auditDesc");
            return (Criteria) this;
        }
        public Criteria andAuditDescLessThanOrEqualTo(String value) {
            addCriterion("AuditDesc <=", value, "auditDesc");
            return (Criteria) this;
        }
        public Criteria andAuditDescLike(String value) {
            addCriterion("AuditDesc like", value, "auditDesc");
            return (Criteria) this;
        }
        public Criteria andAuditDescNotLike(String value) {
            addCriterion("AuditDesc not like", value, "auditDesc");
            return (Criteria) this;
        }
        public Criteria andAuditDescIn(List<String> values) {
            addCriterion("AuditDesc in", values, "auditDesc");
            return (Criteria) this;
        }
        public Criteria andAuditDescNotIn(List<String> values) {
            addCriterion("AuditDesc not in", values, "auditDesc");
            return (Criteria) this;
        }
        public Criteria andAuditDescBetween(String value1, String value2) {
            addCriterion("AuditDesc between", value1, value2, "auditDesc");
            return (Criteria) this;
        }
        public Criteria andAuditDescNotBetween(String value1, String value2) {
            addCriterion("AuditDesc not between", value1, value2, "auditDesc");
            return (Criteria) this;
        }
        public Criteria andAuditTimeIsNull() {
            addCriterion("AuditTime is null");
            return (Criteria) this;
        }
        public Criteria andAuditTimeIsNotNull() {
            addCriterion("AuditTime is not null");
            return (Criteria) this;
        }
        public Criteria andAuditTimeEqualTo(Date value) {
            addCriterion("AuditTime =", value, "auditTime");
            return (Criteria) this;
        }
        public Criteria andAuditTimeNotEqualTo(Date value) {
            addCriterion("AuditTime <>", value, "auditTime");
            return (Criteria) this;
        }
        public Criteria andAuditTimeGreaterThan(Date value) {
            addCriterion("AuditTime >", value, "auditTime");
            return (Criteria) this;
        }
        public Criteria andAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("AuditTime >=", value, "auditTime");
            return (Criteria) this;
        }
        public Criteria andAuditTimeLessThan(Date value) {
            addCriterion("AuditTime <", value, "auditTime");
            return (Criteria) this;
        }
        public Criteria andAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("AuditTime <=", value, "auditTime");
            return (Criteria) this;
        }
        public Criteria andAuditTimeIn(List<Date> values) {
            addCriterion("AuditTime in", values, "auditTime");
            return (Criteria) this;
        }
        public Criteria andAuditTimeNotIn(List<Date> values) {
            addCriterion("AuditTime not in", values, "auditTime");
            return (Criteria) this;
        }
        public Criteria andAuditTimeBetween(Date value1, Date value2) {
            addCriterion("AuditTime between", value1, value2, "auditTime");
            return (Criteria) this;
        }
        public Criteria andAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("AuditTime not between", value1, value2, "auditTime");
            return (Criteria) this;
        }
        public Criteria andAuditModeIsNull() {
            addCriterion("AuditMode is null");
            return (Criteria) this;
        }
        public Criteria andAuditModeIsNotNull() {
            addCriterion("AuditMode is not null");
            return (Criteria) this;
        }
        public Criteria andAuditModeEqualTo(String value) {
            addCriterion("AuditMode =", value, "auditMode");
            return (Criteria) this;
        }
        public Criteria andAuditModeNotEqualTo(String value) {
            addCriterion("AuditMode <>", value, "auditMode");
            return (Criteria) this;
        }
        public Criteria andAuditModeGreaterThan(String value) {
            addCriterion("AuditMode >", value, "auditMode");
            return (Criteria) this;
        }
        public Criteria andAuditModeGreaterThanOrEqualTo(String value) {
            addCriterion("AuditMode >=", value, "auditMode");
            return (Criteria) this;
        }
        public Criteria andAuditModeLessThan(String value) {
            addCriterion("AuditMode <", value, "auditMode");
            return (Criteria) this;
        }
        public Criteria andAuditModeLessThanOrEqualTo(String value) {
            addCriterion("AuditMode <=", value, "auditMode");
            return (Criteria) this;
        }
        public Criteria andAuditModeLike(String value) {
            addCriterion("AuditMode like", value, "auditMode");
            return (Criteria) this;
        }
        public Criteria andAuditModeNotLike(String value) {
            addCriterion("AuditMode not like", value, "auditMode");
            return (Criteria) this;
        }
        public Criteria andAuditModeIn(List<String> values) {
            addCriterion("AuditMode in", values, "auditMode");
            return (Criteria) this;
        }
        public Criteria andAuditModeNotIn(List<String> values) {
            addCriterion("AuditMode not in", values, "auditMode");
            return (Criteria) this;
        }
        public Criteria andAuditModeBetween(String value1, String value2) {
            addCriterion("AuditMode between", value1, value2, "auditMode");
            return (Criteria) this;
        }
        public Criteria andAuditModeNotBetween(String value1, String value2) {
            addCriterion("AuditMode not between", value1, value2, "auditMode");
            return (Criteria) this;
        }
        public Criteria andStatIsNull() {
            addCriterion("Stat is null");
            return (Criteria) this;
        }
        public Criteria andStatIsNotNull() {
            addCriterion("Stat is not null");
            return (Criteria) this;
        }
        public Criteria andStatEqualTo(Short value) {
            addCriterion("Stat =", value, "stat");
            return (Criteria) this;
        }
        public Criteria andStatNotEqualTo(Short value) {
            addCriterion("Stat <>", value, "stat");
            return (Criteria) this;
        }
        public Criteria andStatGreaterThan(Short value) {
            addCriterion("Stat >", value, "stat");
            return (Criteria) this;
        }
        public Criteria andStatGreaterThanOrEqualTo(Short value) {
            addCriterion("Stat >=", value, "stat");
            return (Criteria) this;
        }
        public Criteria andStatLessThan(Short value) {
            addCriterion("Stat <", value, "stat");
            return (Criteria) this;
        }
        public Criteria andStatLessThanOrEqualTo(Short value) {
            addCriterion("Stat <=", value, "stat");
            return (Criteria) this;
        }
        public Criteria andStatIn(List<Short> values) {
            addCriterion("Stat in", values, "stat");
            return (Criteria) this;
        }
        public Criteria andStatNotIn(List<Short> values) {
            addCriterion("Stat not in", values, "stat");
            return (Criteria) this;
        }
        public Criteria andStatBetween(Short value1, Short value2) {
            addCriterion("Stat between", value1, value2, "stat");
            return (Criteria) this;
        }
        public Criteria andStatNotBetween(Short value1, Short value2) {
            addCriterion("Stat not between", value1, value2, "stat");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 汇总测量审核结果(SMR1)
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