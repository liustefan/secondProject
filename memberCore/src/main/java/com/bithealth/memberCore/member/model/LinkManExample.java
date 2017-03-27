/*
 * LinkManExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.model;

import java.util.ArrayList;
import java.util.List;

public class LinkManExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public LinkManExample() {
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
     * 紧急联系人(MEM1)
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
        public Criteria andContactnameIsNull() {
            addCriterion("ContactName is null");
            return (Criteria) this;
        }
        public Criteria andContactnameIsNotNull() {
            addCriterion("ContactName is not null");
            return (Criteria) this;
        }
        public Criteria andContactnameEqualTo(String value) {
            addCriterion("ContactName =", value, "contactname");
            return (Criteria) this;
        }
        public Criteria andContactnameNotEqualTo(String value) {
            addCriterion("ContactName <>", value, "contactname");
            return (Criteria) this;
        }
        public Criteria andContactnameGreaterThan(String value) {
            addCriterion("ContactName >", value, "contactname");
            return (Criteria) this;
        }
        public Criteria andContactnameGreaterThanOrEqualTo(String value) {
            addCriterion("ContactName >=", value, "contactname");
            return (Criteria) this;
        }
        public Criteria andContactnameLessThan(String value) {
            addCriterion("ContactName <", value, "contactname");
            return (Criteria) this;
        }
        public Criteria andContactnameLessThanOrEqualTo(String value) {
            addCriterion("ContactName <=", value, "contactname");
            return (Criteria) this;
        }
        public Criteria andContactnameLike(String value) {
            addCriterion("ContactName like", value, "contactname");
            return (Criteria) this;
        }
        public Criteria andContactnameNotLike(String value) {
            addCriterion("ContactName not like", value, "contactname");
            return (Criteria) this;
        }
        public Criteria andContactnameIn(List<String> values) {
            addCriterion("ContactName in", values, "contactname");
            return (Criteria) this;
        }
        public Criteria andContactnameNotIn(List<String> values) {
            addCriterion("ContactName not in", values, "contactname");
            return (Criteria) this;
        }
        public Criteria andContactnameBetween(String value1, String value2) {
            addCriterion("ContactName between", value1, value2, "contactname");
            return (Criteria) this;
        }
        public Criteria andContactnameNotBetween(String value1, String value2) {
            addCriterion("ContactName not between", value1, value2, "contactname");
            return (Criteria) this;
        }
        public Criteria andContactmobphoneIsNull() {
            addCriterion("ContactMobPhone is null");
            return (Criteria) this;
        }
        public Criteria andContactmobphoneIsNotNull() {
            addCriterion("ContactMobPhone is not null");
            return (Criteria) this;
        }
        public Criteria andContactmobphoneEqualTo(String value) {
            addCriterion("ContactMobPhone =", value, "contactmobphone");
            return (Criteria) this;
        }
        public Criteria andContactmobphoneNotEqualTo(String value) {
            addCriterion("ContactMobPhone <>", value, "contactmobphone");
            return (Criteria) this;
        }
        public Criteria andContactmobphoneGreaterThan(String value) {
            addCriterion("ContactMobPhone >", value, "contactmobphone");
            return (Criteria) this;
        }
        public Criteria andContactmobphoneGreaterThanOrEqualTo(String value) {
            addCriterion("ContactMobPhone >=", value, "contactmobphone");
            return (Criteria) this;
        }
        public Criteria andContactmobphoneLessThan(String value) {
            addCriterion("ContactMobPhone <", value, "contactmobphone");
            return (Criteria) this;
        }
        public Criteria andContactmobphoneLessThanOrEqualTo(String value) {
            addCriterion("ContactMobPhone <=", value, "contactmobphone");
            return (Criteria) this;
        }
        public Criteria andContactmobphoneLike(String value) {
            addCriterion("ContactMobPhone like", value, "contactmobphone");
            return (Criteria) this;
        }
        public Criteria andContactmobphoneNotLike(String value) {
            addCriterion("ContactMobPhone not like", value, "contactmobphone");
            return (Criteria) this;
        }
        public Criteria andContactmobphoneIn(List<String> values) {
            addCriterion("ContactMobPhone in", values, "contactmobphone");
            return (Criteria) this;
        }
        public Criteria andContactmobphoneNotIn(List<String> values) {
            addCriterion("ContactMobPhone not in", values, "contactmobphone");
            return (Criteria) this;
        }
        public Criteria andContactmobphoneBetween(String value1, String value2) {
            addCriterion("ContactMobPhone between", value1, value2, "contactmobphone");
            return (Criteria) this;
        }
        public Criteria andContactmobphoneNotBetween(String value1, String value2) {
            addCriterion("ContactMobPhone not between", value1, value2, "contactmobphone");
            return (Criteria) this;
        }
        public Criteria andRelationIsNull() {
            addCriterion("Relation is null");
            return (Criteria) this;
        }
        public Criteria andRelationIsNotNull() {
            addCriterion("Relation is not null");
            return (Criteria) this;
        }
        public Criteria andRelationEqualTo(String value) {
            addCriterion("Relation =", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationNotEqualTo(String value) {
            addCriterion("Relation <>", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationGreaterThan(String value) {
            addCriterion("Relation >", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationGreaterThanOrEqualTo(String value) {
            addCriterion("Relation >=", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationLessThan(String value) {
            addCriterion("Relation <", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationLessThanOrEqualTo(String value) {
            addCriterion("Relation <=", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationLike(String value) {
            addCriterion("Relation like", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationNotLike(String value) {
            addCriterion("Relation not like", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationIn(List<String> values) {
            addCriterion("Relation in", values, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationNotIn(List<String> values) {
            addCriterion("Relation not in", values, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationBetween(String value1, String value2) {
            addCriterion("Relation between", value1, value2, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationNotBetween(String value1, String value2) {
            addCriterion("Relation not between", value1, value2, "relation");
            return (Criteria) this;
        }
        public Criteria andMessagetagIsNull() {
            addCriterion("MessageTag is null");
            return (Criteria) this;
        }
        public Criteria andMessagetagIsNotNull() {
            addCriterion("MessageTag is not null");
            return (Criteria) this;
        }
        public Criteria andMessagetagEqualTo(String value) {
            addCriterion("MessageTag =", value, "messagetag");
            return (Criteria) this;
        }
        public Criteria andMessagetagNotEqualTo(String value) {
            addCriterion("MessageTag <>", value, "messagetag");
            return (Criteria) this;
        }
        public Criteria andMessagetagGreaterThan(String value) {
            addCriterion("MessageTag >", value, "messagetag");
            return (Criteria) this;
        }
        public Criteria andMessagetagGreaterThanOrEqualTo(String value) {
            addCriterion("MessageTag >=", value, "messagetag");
            return (Criteria) this;
        }
        public Criteria andMessagetagLessThan(String value) {
            addCriterion("MessageTag <", value, "messagetag");
            return (Criteria) this;
        }
        public Criteria andMessagetagLessThanOrEqualTo(String value) {
            addCriterion("MessageTag <=", value, "messagetag");
            return (Criteria) this;
        }
        public Criteria andMessagetagLike(String value) {
            addCriterion("MessageTag like", value, "messagetag");
            return (Criteria) this;
        }
        public Criteria andMessagetagNotLike(String value) {
            addCriterion("MessageTag not like", value, "messagetag");
            return (Criteria) this;
        }
        public Criteria andMessagetagIn(List<String> values) {
            addCriterion("MessageTag in", values, "messagetag");
            return (Criteria) this;
        }
        public Criteria andMessagetagNotIn(List<String> values) {
            addCriterion("MessageTag not in", values, "messagetag");
            return (Criteria) this;
        }
        public Criteria andMessagetagBetween(String value1, String value2) {
            addCriterion("MessageTag between", value1, value2, "messagetag");
            return (Criteria) this;
        }
        public Criteria andMessagetagNotBetween(String value1, String value2) {
            addCriterion("MessageTag not between", value1, value2, "messagetag");
            return (Criteria) this;
        }
        public Criteria andReceivetagIsNull() {
            addCriterion("ReceiveTag is null");
            return (Criteria) this;
        }
        public Criteria andReceivetagIsNotNull() {
            addCriterion("ReceiveTag is not null");
            return (Criteria) this;
        }
        public Criteria andReceivetagEqualTo(String value) {
            addCriterion("ReceiveTag =", value, "receivetag");
            return (Criteria) this;
        }
        public Criteria andReceivetagNotEqualTo(String value) {
            addCriterion("ReceiveTag <>", value, "receivetag");
            return (Criteria) this;
        }
        public Criteria andReceivetagGreaterThan(String value) {
            addCriterion("ReceiveTag >", value, "receivetag");
            return (Criteria) this;
        }
        public Criteria andReceivetagGreaterThanOrEqualTo(String value) {
            addCriterion("ReceiveTag >=", value, "receivetag");
            return (Criteria) this;
        }
        public Criteria andReceivetagLessThan(String value) {
            addCriterion("ReceiveTag <", value, "receivetag");
            return (Criteria) this;
        }
        public Criteria andReceivetagLessThanOrEqualTo(String value) {
            addCriterion("ReceiveTag <=", value, "receivetag");
            return (Criteria) this;
        }
        public Criteria andReceivetagLike(String value) {
            addCriterion("ReceiveTag like", value, "receivetag");
            return (Criteria) this;
        }
        public Criteria andReceivetagNotLike(String value) {
            addCriterion("ReceiveTag not like", value, "receivetag");
            return (Criteria) this;
        }
        public Criteria andReceivetagIn(List<String> values) {
            addCriterion("ReceiveTag in", values, "receivetag");
            return (Criteria) this;
        }
        public Criteria andReceivetagNotIn(List<String> values) {
            addCriterion("ReceiveTag not in", values, "receivetag");
            return (Criteria) this;
        }
        public Criteria andReceivetagBetween(String value1, String value2) {
            addCriterion("ReceiveTag between", value1, value2, "receivetag");
            return (Criteria) this;
        }
        public Criteria andReceivetagNotBetween(String value1, String value2) {
            addCriterion("ReceiveTag not between", value1, value2, "receivetag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 紧急联系人(MEM1)
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