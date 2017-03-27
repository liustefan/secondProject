/*
 * DoctorScoreExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.doctorCore.doctor.model;

import java.util.ArrayList;
import java.util.List;

public class DoctorScoreExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public DoctorScoreExample() {
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
     * 医生积分表（DOC2）
     * 
     * @author ${user}
     * @version 1.0 2016-06-23
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
        public Criteria andMonintegralIsNull() {
            addCriterion("MonIntegral is null");
            return (Criteria) this;
        }
        public Criteria andMonintegralIsNotNull() {
            addCriterion("MonIntegral is not null");
            return (Criteria) this;
        }
        public Criteria andMonintegralEqualTo(Integer value) {
            addCriterion("MonIntegral =", value, "monintegral");
            return (Criteria) this;
        }
        public Criteria andMonintegralNotEqualTo(Integer value) {
            addCriterion("MonIntegral <>", value, "monintegral");
            return (Criteria) this;
        }
        public Criteria andMonintegralGreaterThan(Integer value) {
            addCriterion("MonIntegral >", value, "monintegral");
            return (Criteria) this;
        }
        public Criteria andMonintegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("MonIntegral >=", value, "monintegral");
            return (Criteria) this;
        }
        public Criteria andMonintegralLessThan(Integer value) {
            addCriterion("MonIntegral <", value, "monintegral");
            return (Criteria) this;
        }
        public Criteria andMonintegralLessThanOrEqualTo(Integer value) {
            addCriterion("MonIntegral <=", value, "monintegral");
            return (Criteria) this;
        }
        public Criteria andMonintegralIn(List<Integer> values) {
            addCriterion("MonIntegral in", values, "monintegral");
            return (Criteria) this;
        }
        public Criteria andMonintegralNotIn(List<Integer> values) {
            addCriterion("MonIntegral not in", values, "monintegral");
            return (Criteria) this;
        }
        public Criteria andMonintegralBetween(Integer value1, Integer value2) {
            addCriterion("MonIntegral between", value1, value2, "monintegral");
            return (Criteria) this;
        }
        public Criteria andMonintegralNotBetween(Integer value1, Integer value2) {
            addCriterion("MonIntegral not between", value1, value2, "monintegral");
            return (Criteria) this;
        }
        public Criteria andAccintegralIsNull() {
            addCriterion("AccIntegral is null");
            return (Criteria) this;
        }
        public Criteria andAccintegralIsNotNull() {
            addCriterion("AccIntegral is not null");
            return (Criteria) this;
        }
        public Criteria andAccintegralEqualTo(Integer value) {
            addCriterion("AccIntegral =", value, "accintegral");
            return (Criteria) this;
        }
        public Criteria andAccintegralNotEqualTo(Integer value) {
            addCriterion("AccIntegral <>", value, "accintegral");
            return (Criteria) this;
        }
        public Criteria andAccintegralGreaterThan(Integer value) {
            addCriterion("AccIntegral >", value, "accintegral");
            return (Criteria) this;
        }
        public Criteria andAccintegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("AccIntegral >=", value, "accintegral");
            return (Criteria) this;
        }
        public Criteria andAccintegralLessThan(Integer value) {
            addCriterion("AccIntegral <", value, "accintegral");
            return (Criteria) this;
        }
        public Criteria andAccintegralLessThanOrEqualTo(Integer value) {
            addCriterion("AccIntegral <=", value, "accintegral");
            return (Criteria) this;
        }
        public Criteria andAccintegralIn(List<Integer> values) {
            addCriterion("AccIntegral in", values, "accintegral");
            return (Criteria) this;
        }
        public Criteria andAccintegralNotIn(List<Integer> values) {
            addCriterion("AccIntegral not in", values, "accintegral");
            return (Criteria) this;
        }
        public Criteria andAccintegralBetween(Integer value1, Integer value2) {
            addCriterion("AccIntegral between", value1, value2, "accintegral");
            return (Criteria) this;
        }
        public Criteria andAccintegralNotBetween(Integer value1, Integer value2) {
            addCriterion("AccIntegral not between", value1, value2, "accintegral");
            return (Criteria) this;
        }
        public Criteria andMonreportIsNull() {
            addCriterion("MonReport is null");
            return (Criteria) this;
        }
        public Criteria andMonreportIsNotNull() {
            addCriterion("MonReport is not null");
            return (Criteria) this;
        }
        public Criteria andMonreportEqualTo(Integer value) {
            addCriterion("MonReport =", value, "monreport");
            return (Criteria) this;
        }
        public Criteria andMonreportNotEqualTo(Integer value) {
            addCriterion("MonReport <>", value, "monreport");
            return (Criteria) this;
        }
        public Criteria andMonreportGreaterThan(Integer value) {
            addCriterion("MonReport >", value, "monreport");
            return (Criteria) this;
        }
        public Criteria andMonreportGreaterThanOrEqualTo(Integer value) {
            addCriterion("MonReport >=", value, "monreport");
            return (Criteria) this;
        }
        public Criteria andMonreportLessThan(Integer value) {
            addCriterion("MonReport <", value, "monreport");
            return (Criteria) this;
        }
        public Criteria andMonreportLessThanOrEqualTo(Integer value) {
            addCriterion("MonReport <=", value, "monreport");
            return (Criteria) this;
        }
        public Criteria andMonreportIn(List<Integer> values) {
            addCriterion("MonReport in", values, "monreport");
            return (Criteria) this;
        }
        public Criteria andMonreportNotIn(List<Integer> values) {
            addCriterion("MonReport not in", values, "monreport");
            return (Criteria) this;
        }
        public Criteria andMonreportBetween(Integer value1, Integer value2) {
            addCriterion("MonReport between", value1, value2, "monreport");
            return (Criteria) this;
        }
        public Criteria andMonreportNotBetween(Integer value1, Integer value2) {
            addCriterion("MonReport not between", value1, value2, "monreport");
            return (Criteria) this;
        }
        public Criteria andAccreportIsNull() {
            addCriterion("AccReport is null");
            return (Criteria) this;
        }
        public Criteria andAccreportIsNotNull() {
            addCriterion("AccReport is not null");
            return (Criteria) this;
        }
        public Criteria andAccreportEqualTo(Integer value) {
            addCriterion("AccReport =", value, "accreport");
            return (Criteria) this;
        }
        public Criteria andAccreportNotEqualTo(Integer value) {
            addCriterion("AccReport <>", value, "accreport");
            return (Criteria) this;
        }
        public Criteria andAccreportGreaterThan(Integer value) {
            addCriterion("AccReport >", value, "accreport");
            return (Criteria) this;
        }
        public Criteria andAccreportGreaterThanOrEqualTo(Integer value) {
            addCriterion("AccReport >=", value, "accreport");
            return (Criteria) this;
        }
        public Criteria andAccreportLessThan(Integer value) {
            addCriterion("AccReport <", value, "accreport");
            return (Criteria) this;
        }
        public Criteria andAccreportLessThanOrEqualTo(Integer value) {
            addCriterion("AccReport <=", value, "accreport");
            return (Criteria) this;
        }
        public Criteria andAccreportIn(List<Integer> values) {
            addCriterion("AccReport in", values, "accreport");
            return (Criteria) this;
        }
        public Criteria andAccreportNotIn(List<Integer> values) {
            addCriterion("AccReport not in", values, "accreport");
            return (Criteria) this;
        }
        public Criteria andAccreportBetween(Integer value1, Integer value2) {
            addCriterion("AccReport between", value1, value2, "accreport");
            return (Criteria) this;
        }
        public Criteria andAccreportNotBetween(Integer value1, Integer value2) {
            addCriterion("AccReport not between", value1, value2, "accreport");
            return (Criteria) this;
        }
        public Criteria andMonreplyIsNull() {
            addCriterion("MonReply is null");
            return (Criteria) this;
        }
        public Criteria andMonreplyIsNotNull() {
            addCriterion("MonReply is not null");
            return (Criteria) this;
        }
        public Criteria andMonreplyEqualTo(Integer value) {
            addCriterion("MonReply =", value, "monreply");
            return (Criteria) this;
        }
        public Criteria andMonreplyNotEqualTo(Integer value) {
            addCriterion("MonReply <>", value, "monreply");
            return (Criteria) this;
        }
        public Criteria andMonreplyGreaterThan(Integer value) {
            addCriterion("MonReply >", value, "monreply");
            return (Criteria) this;
        }
        public Criteria andMonreplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("MonReply >=", value, "monreply");
            return (Criteria) this;
        }
        public Criteria andMonreplyLessThan(Integer value) {
            addCriterion("MonReply <", value, "monreply");
            return (Criteria) this;
        }
        public Criteria andMonreplyLessThanOrEqualTo(Integer value) {
            addCriterion("MonReply <=", value, "monreply");
            return (Criteria) this;
        }
        public Criteria andMonreplyIn(List<Integer> values) {
            addCriterion("MonReply in", values, "monreply");
            return (Criteria) this;
        }
        public Criteria andMonreplyNotIn(List<Integer> values) {
            addCriterion("MonReply not in", values, "monreply");
            return (Criteria) this;
        }
        public Criteria andMonreplyBetween(Integer value1, Integer value2) {
            addCriterion("MonReply between", value1, value2, "monreply");
            return (Criteria) this;
        }
        public Criteria andMonreplyNotBetween(Integer value1, Integer value2) {
            addCriterion("MonReply not between", value1, value2, "monreply");
            return (Criteria) this;
        }
        public Criteria andAccreplyIsNull() {
            addCriterion("AccReply is null");
            return (Criteria) this;
        }
        public Criteria andAccreplyIsNotNull() {
            addCriterion("AccReply is not null");
            return (Criteria) this;
        }
        public Criteria andAccreplyEqualTo(Integer value) {
            addCriterion("AccReply =", value, "accreply");
            return (Criteria) this;
        }
        public Criteria andAccreplyNotEqualTo(Integer value) {
            addCriterion("AccReply <>", value, "accreply");
            return (Criteria) this;
        }
        public Criteria andAccreplyGreaterThan(Integer value) {
            addCriterion("AccReply >", value, "accreply");
            return (Criteria) this;
        }
        public Criteria andAccreplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("AccReply >=", value, "accreply");
            return (Criteria) this;
        }
        public Criteria andAccreplyLessThan(Integer value) {
            addCriterion("AccReply <", value, "accreply");
            return (Criteria) this;
        }
        public Criteria andAccreplyLessThanOrEqualTo(Integer value) {
            addCriterion("AccReply <=", value, "accreply");
            return (Criteria) this;
        }
        public Criteria andAccreplyIn(List<Integer> values) {
            addCriterion("AccReply in", values, "accreply");
            return (Criteria) this;
        }
        public Criteria andAccreplyNotIn(List<Integer> values) {
            addCriterion("AccReply not in", values, "accreply");
            return (Criteria) this;
        }
        public Criteria andAccreplyBetween(Integer value1, Integer value2) {
            addCriterion("AccReply between", value1, value2, "accreply");
            return (Criteria) this;
        }
        public Criteria andAccreplyNotBetween(Integer value1, Integer value2) {
            addCriterion("AccReply not between", value1, value2, "accreply");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 医生积分表（DOC2）
     * 
     * @author ${user}
     * @version 1.0 2016-06-23
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