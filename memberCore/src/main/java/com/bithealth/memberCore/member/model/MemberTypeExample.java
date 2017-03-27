/*
 * MemberTypeExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.model;

import java.util.ArrayList;
import java.util.List;

public class MemberTypeExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MemberTypeExample() {
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
     * 会员类型(OMES)
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
        public Criteria andMemidIsNull() {
            addCriterion("MemId is null");
            return (Criteria) this;
        }
        public Criteria andMemidIsNotNull() {
            addCriterion("MemId is not null");
            return (Criteria) this;
        }
        public Criteria andMemidEqualTo(Short value) {
            addCriterion("MemId =", value, "memid");
            return (Criteria) this;
        }
        public Criteria andMemidNotEqualTo(Short value) {
            addCriterion("MemId <>", value, "memid");
            return (Criteria) this;
        }
        public Criteria andMemidGreaterThan(Short value) {
            addCriterion("MemId >", value, "memid");
            return (Criteria) this;
        }
        public Criteria andMemidGreaterThanOrEqualTo(Short value) {
            addCriterion("MemId >=", value, "memid");
            return (Criteria) this;
        }
        public Criteria andMemidLessThan(Short value) {
            addCriterion("MemId <", value, "memid");
            return (Criteria) this;
        }
        public Criteria andMemidLessThanOrEqualTo(Short value) {
            addCriterion("MemId <=", value, "memid");
            return (Criteria) this;
        }
        public Criteria andMemidIn(List<Short> values) {
            addCriterion("MemId in", values, "memid");
            return (Criteria) this;
        }
        public Criteria andMemidNotIn(List<Short> values) {
            addCriterion("MemId not in", values, "memid");
            return (Criteria) this;
        }
        public Criteria andMemidBetween(Short value1, Short value2) {
            addCriterion("MemId between", value1, value2, "memid");
            return (Criteria) this;
        }
        public Criteria andMemidNotBetween(Short value1, Short value2) {
            addCriterion("MemId not between", value1, value2, "memid");
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
        public Criteria andMemnameIsNull() {
            addCriterion("MemName is null");
            return (Criteria) this;
        }
        public Criteria andMemnameIsNotNull() {
            addCriterion("MemName is not null");
            return (Criteria) this;
        }
        public Criteria andMemnameEqualTo(String value) {
            addCriterion("MemName =", value, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameNotEqualTo(String value) {
            addCriterion("MemName <>", value, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameGreaterThan(String value) {
            addCriterion("MemName >", value, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameGreaterThanOrEqualTo(String value) {
            addCriterion("MemName >=", value, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameLessThan(String value) {
            addCriterion("MemName <", value, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameLessThanOrEqualTo(String value) {
            addCriterion("MemName <=", value, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameLike(String value) {
            addCriterion("MemName like", value, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameNotLike(String value) {
            addCriterion("MemName not like", value, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameIn(List<String> values) {
            addCriterion("MemName in", values, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameNotIn(List<String> values) {
            addCriterion("MemName not in", values, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameBetween(String value1, String value2) {
            addCriterion("MemName between", value1, value2, "memname");
            return (Criteria) this;
        }
        public Criteria andMemnameNotBetween(String value1, String value2) {
            addCriterion("MemName not between", value1, value2, "memname");
            return (Criteria) this;
        }
        public Criteria andMemdescIsNull() {
            addCriterion("MemDesc is null");
            return (Criteria) this;
        }
        public Criteria andMemdescIsNotNull() {
            addCriterion("MemDesc is not null");
            return (Criteria) this;
        }
        public Criteria andMemdescEqualTo(String value) {
            addCriterion("MemDesc =", value, "memdesc");
            return (Criteria) this;
        }
        public Criteria andMemdescNotEqualTo(String value) {
            addCriterion("MemDesc <>", value, "memdesc");
            return (Criteria) this;
        }
        public Criteria andMemdescGreaterThan(String value) {
            addCriterion("MemDesc >", value, "memdesc");
            return (Criteria) this;
        }
        public Criteria andMemdescGreaterThanOrEqualTo(String value) {
            addCriterion("MemDesc >=", value, "memdesc");
            return (Criteria) this;
        }
        public Criteria andMemdescLessThan(String value) {
            addCriterion("MemDesc <", value, "memdesc");
            return (Criteria) this;
        }
        public Criteria andMemdescLessThanOrEqualTo(String value) {
            addCriterion("MemDesc <=", value, "memdesc");
            return (Criteria) this;
        }
        public Criteria andMemdescLike(String value) {
            addCriterion("MemDesc like", value, "memdesc");
            return (Criteria) this;
        }
        public Criteria andMemdescNotLike(String value) {
            addCriterion("MemDesc not like", value, "memdesc");
            return (Criteria) this;
        }
        public Criteria andMemdescIn(List<String> values) {
            addCriterion("MemDesc in", values, "memdesc");
            return (Criteria) this;
        }
        public Criteria andMemdescNotIn(List<String> values) {
            addCriterion("MemDesc not in", values, "memdesc");
            return (Criteria) this;
        }
        public Criteria andMemdescBetween(String value1, String value2) {
            addCriterion("MemDesc between", value1, value2, "memdesc");
            return (Criteria) this;
        }
        public Criteria andMemdescNotBetween(String value1, String value2) {
            addCriterion("MemDesc not between", value1, value2, "memdesc");
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
     * 会员类型(OMES)
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