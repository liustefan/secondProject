/*
 * DocToGroupExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.doctorCore.docGroup.model;

import java.util.ArrayList;
import java.util.List;

public class DocToGroupExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public DocToGroupExample() {
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
     * 医生分组明细(DGP1)
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
        public Criteria andOdgpidIsNull() {
            addCriterion("OdgpId is null");
            return (Criteria) this;
        }
        public Criteria andOdgpidIsNotNull() {
            addCriterion("OdgpId is not null");
            return (Criteria) this;
        }
        public Criteria andOdgpidEqualTo(Integer value) {
            addCriterion("OdgpId =", value, "odgpid");
            return (Criteria) this;
        }
        public Criteria andOdgpidNotEqualTo(Integer value) {
            addCriterion("OdgpId <>", value, "odgpid");
            return (Criteria) this;
        }
        public Criteria andOdgpidGreaterThan(Integer value) {
            addCriterion("OdgpId >", value, "odgpid");
            return (Criteria) this;
        }
        public Criteria andOdgpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OdgpId >=", value, "odgpid");
            return (Criteria) this;
        }
        public Criteria andOdgpidLessThan(Integer value) {
            addCriterion("OdgpId <", value, "odgpid");
            return (Criteria) this;
        }
        public Criteria andOdgpidLessThanOrEqualTo(Integer value) {
            addCriterion("OdgpId <=", value, "odgpid");
            return (Criteria) this;
        }
        public Criteria andOdgpidIn(List<Integer> values) {
            addCriterion("OdgpId in", values, "odgpid");
            return (Criteria) this;
        }
        public Criteria andOdgpidNotIn(List<Integer> values) {
            addCriterion("OdgpId not in", values, "odgpid");
            return (Criteria) this;
        }
        public Criteria andOdgpidBetween(Integer value1, Integer value2) {
            addCriterion("OdgpId between", value1, value2, "odgpid");
            return (Criteria) this;
        }
        public Criteria andOdgpidNotBetween(Integer value1, Integer value2) {
            addCriterion("OdgpId not between", value1, value2, "odgpid");
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
        public Criteria andOrgidIsNull() {
            addCriterion("OrgId is null");
            return (Criteria) this;
        }
        public Criteria andOrgidIsNotNull() {
            addCriterion("OrgId is not null");
            return (Criteria) this;
        }
        public Criteria andOrgidEqualTo(Integer value) {
            addCriterion("OrgId =", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidNotEqualTo(Integer value) {
            addCriterion("OrgId <>", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidGreaterThan(Integer value) {
            addCriterion("OrgId >", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrgId >=", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidLessThan(Integer value) {
            addCriterion("OrgId <", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidLessThanOrEqualTo(Integer value) {
            addCriterion("OrgId <=", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidIn(List<Integer> values) {
            addCriterion("OrgId in", values, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidNotIn(List<Integer> values) {
            addCriterion("OrgId not in", values, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidBetween(Integer value1, Integer value2) {
            addCriterion("OrgId between", value1, value2, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidNotBetween(Integer value1, Integer value2) {
            addCriterion("OrgId not between", value1, value2, "orgid");
            return (Criteria) this;
        }
        public Criteria andAuditlevelIsNull() {
            addCriterion("AuditLevel is null");
            return (Criteria) this;
        }
        public Criteria andAuditlevelIsNotNull() {
            addCriterion("AuditLevel is not null");
            return (Criteria) this;
        }
        public Criteria andAuditlevelEqualTo(Short value) {
            addCriterion("AuditLevel =", value, "auditlevel");
            return (Criteria) this;
        }
        public Criteria andAuditlevelNotEqualTo(Short value) {
            addCriterion("AuditLevel <>", value, "auditlevel");
            return (Criteria) this;
        }
        public Criteria andAuditlevelGreaterThan(Short value) {
            addCriterion("AuditLevel >", value, "auditlevel");
            return (Criteria) this;
        }
        public Criteria andAuditlevelGreaterThanOrEqualTo(Short value) {
            addCriterion("AuditLevel >=", value, "auditlevel");
            return (Criteria) this;
        }
        public Criteria andAuditlevelLessThan(Short value) {
            addCriterion("AuditLevel <", value, "auditlevel");
            return (Criteria) this;
        }
        public Criteria andAuditlevelLessThanOrEqualTo(Short value) {
            addCriterion("AuditLevel <=", value, "auditlevel");
            return (Criteria) this;
        }
        public Criteria andAuditlevelIn(List<Short> values) {
            addCriterion("AuditLevel in", values, "auditlevel");
            return (Criteria) this;
        }
        public Criteria andAuditlevelNotIn(List<Short> values) {
            addCriterion("AuditLevel not in", values, "auditlevel");
            return (Criteria) this;
        }
        public Criteria andAuditlevelBetween(Short value1, Short value2) {
            addCriterion("AuditLevel between", value1, value2, "auditlevel");
            return (Criteria) this;
        }
        public Criteria andAuditlevelNotBetween(Short value1, Short value2) {
            addCriterion("AuditLevel not between", value1, value2, "auditlevel");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 医生分组明细(DGP1)
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