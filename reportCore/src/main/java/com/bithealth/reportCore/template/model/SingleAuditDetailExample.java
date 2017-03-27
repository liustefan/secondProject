/*
 * SingleAuditDetailExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-14 Created
 */
package com.bithealth.reportCore.template.model;

import java.util.ArrayList;
import java.util.List;

public class SingleAuditDetailExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public SingleAuditDetailExample() {
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
     * 审核模板明细设置(RTS1)
     * 
     * @author ${user}
     * @version 1.0 2016-07-14
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
        public Criteria andTagIsNull() {
            addCriterion("Tag is null");
            return (Criteria) this;
        }
        public Criteria andTagIsNotNull() {
            addCriterion("Tag is not null");
            return (Criteria) this;
        }
        public Criteria andTagEqualTo(String value) {
            addCriterion("Tag =", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotEqualTo(String value) {
            addCriterion("Tag <>", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagGreaterThan(String value) {
            addCriterion("Tag >", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("Tag >=", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagLessThan(String value) {
            addCriterion("Tag <", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("Tag <=", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagLike(String value) {
            addCriterion("Tag like", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotLike(String value) {
            addCriterion("Tag not like", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagIn(List<String> values) {
            addCriterion("Tag in", values, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotIn(List<String> values) {
            addCriterion("Tag not in", values, "tag");
            return (Criteria) this;
        }
        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("Tag between", value1, value2, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("Tag not between", value1, value2, "tag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 审核模板明细设置(RTS1)
     * 
     * @author ${user}
     * @version 1.0 2016-07-14
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