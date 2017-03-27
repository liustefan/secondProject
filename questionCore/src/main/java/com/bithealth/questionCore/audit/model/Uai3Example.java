/*
 * Uai3Example.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-19 Created
 */
package com.bithealth.questionCore.audit.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Uai3Example {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public Uai3Example() {
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
     * 单份答卷审核结果（UAI3）
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
        public Criteria andAnsNumberIsNull() {
            addCriterion("AnsNumber is null");
            return (Criteria) this;
        }
        public Criteria andAnsNumberIsNotNull() {
            addCriterion("AnsNumber is not null");
            return (Criteria) this;
        }
        public Criteria andAnsNumberEqualTo(Integer value) {
            addCriterion("AnsNumber =", value, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberNotEqualTo(Integer value) {
            addCriterion("AnsNumber <>", value, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberGreaterThan(Integer value) {
            addCriterion("AnsNumber >", value, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("AnsNumber >=", value, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberLessThan(Integer value) {
            addCriterion("AnsNumber <", value, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberLessThanOrEqualTo(Integer value) {
            addCriterion("AnsNumber <=", value, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberIn(List<Integer> values) {
            addCriterion("AnsNumber in", values, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberNotIn(List<Integer> values) {
            addCriterion("AnsNumber not in", values, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberBetween(Integer value1, Integer value2) {
            addCriterion("AnsNumber between", value1, value2, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andAnsNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("AnsNumber not between", value1, value2, "ansNumber");
            return (Criteria) this;
        }
        public Criteria andLineNumIsNull() {
            addCriterion("LineNum is null");
            return (Criteria) this;
        }
        public Criteria andLineNumIsNotNull() {
            addCriterion("LineNum is not null");
            return (Criteria) this;
        }
        public Criteria andLineNumEqualTo(Short value) {
            addCriterion("LineNum =", value, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumNotEqualTo(Short value) {
            addCriterion("LineNum <>", value, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumGreaterThan(Short value) {
            addCriterion("LineNum >", value, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumGreaterThanOrEqualTo(Short value) {
            addCriterion("LineNum >=", value, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumLessThan(Short value) {
            addCriterion("LineNum <", value, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumLessThanOrEqualTo(Short value) {
            addCriterion("LineNum <=", value, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumIn(List<Short> values) {
            addCriterion("LineNum in", values, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumNotIn(List<Short> values) {
            addCriterion("LineNum not in", values, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumBetween(Short value1, Short value2) {
            addCriterion("LineNum between", value1, value2, "lineNum");
            return (Criteria) this;
        }
        public Criteria andLineNumNotBetween(Short value1, Short value2) {
            addCriterion("LineNum not between", value1, value2, "lineNum");
            return (Criteria) this;
        }
        public Criteria andFunIdIsNull() {
            addCriterion("FunId is null");
            return (Criteria) this;
        }
        public Criteria andFunIdIsNotNull() {
            addCriterion("FunId is not null");
            return (Criteria) this;
        }
        public Criteria andFunIdEqualTo(Short value) {
            addCriterion("FunId =", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdNotEqualTo(Short value) {
            addCriterion("FunId <>", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdGreaterThan(Short value) {
            addCriterion("FunId >", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdGreaterThanOrEqualTo(Short value) {
            addCriterion("FunId >=", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdLessThan(Short value) {
            addCriterion("FunId <", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdLessThanOrEqualTo(Short value) {
            addCriterion("FunId <=", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdIn(List<Short> values) {
            addCriterion("FunId in", values, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdNotIn(List<Short> values) {
            addCriterion("FunId not in", values, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdBetween(Short value1, Short value2) {
            addCriterion("FunId between", value1, value2, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdNotBetween(Short value1, Short value2) {
            addCriterion("FunId not between", value1, value2, "funId");
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
        public Criteria andDiagnosisIsNull() {
            addCriterion("diagnosis is null");
            return (Criteria) this;
        }
        public Criteria andDiagnosisIsNotNull() {
            addCriterion("diagnosis is not null");
            return (Criteria) this;
        }
        public Criteria andDiagnosisEqualTo(String value) {
            addCriterion("diagnosis =", value, "diagnosis");
            return (Criteria) this;
        }
        public Criteria andDiagnosisNotEqualTo(String value) {
            addCriterion("diagnosis <>", value, "diagnosis");
            return (Criteria) this;
        }
        public Criteria andDiagnosisGreaterThan(String value) {
            addCriterion("diagnosis >", value, "diagnosis");
            return (Criteria) this;
        }
        public Criteria andDiagnosisGreaterThanOrEqualTo(String value) {
            addCriterion("diagnosis >=", value, "diagnosis");
            return (Criteria) this;
        }
        public Criteria andDiagnosisLessThan(String value) {
            addCriterion("diagnosis <", value, "diagnosis");
            return (Criteria) this;
        }
        public Criteria andDiagnosisLessThanOrEqualTo(String value) {
            addCriterion("diagnosis <=", value, "diagnosis");
            return (Criteria) this;
        }
        public Criteria andDiagnosisLike(String value) {
            addCriterion("diagnosis like", value, "diagnosis");
            return (Criteria) this;
        }
        public Criteria andDiagnosisNotLike(String value) {
            addCriterion("diagnosis not like", value, "diagnosis");
            return (Criteria) this;
        }
        public Criteria andDiagnosisIn(List<String> values) {
            addCriterion("diagnosis in", values, "diagnosis");
            return (Criteria) this;
        }
        public Criteria andDiagnosisNotIn(List<String> values) {
            addCriterion("diagnosis not in", values, "diagnosis");
            return (Criteria) this;
        }
        public Criteria andDiagnosisBetween(String value1, String value2) {
            addCriterion("diagnosis between", value1, value2, "diagnosis");
            return (Criteria) this;
        }
        public Criteria andDiagnosisNotBetween(String value1, String value2) {
            addCriterion("diagnosis not between", value1, value2, "diagnosis");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 单份答卷审核结果（UAI3）
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