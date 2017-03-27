/*
 * Mfq1Example.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Mfq1Example {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public Mfq1Example() {
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
     * 问卷信息明细表（MFQ1)
     * 
     * @author ${user}
     * @version 1.0 2016-07-12
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
        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                 return;
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }
        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                  return;//
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }
        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                  return;//
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }
        public Criteria andQustidIsNull() {
            addCriterion("Qustid is null");
            return (Criteria) this;
        }
        public Criteria andQustidIsNotNull() {
            addCriterion("Qustid is not null");
            return (Criteria) this;
        }
        public Criteria andQustidEqualTo(Integer value) {
            addCriterion("Qustid =", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidNotEqualTo(Integer value) {
            addCriterion("Qustid <>", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidGreaterThan(Integer value) {
            addCriterion("Qustid >", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Qustid >=", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidLessThan(Integer value) {
            addCriterion("Qustid <", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidLessThanOrEqualTo(Integer value) {
            addCriterion("Qustid <=", value, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidIn(List<Integer> values) {
            addCriterion("Qustid in", values, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidNotIn(List<Integer> values) {
            addCriterion("Qustid not in", values, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidBetween(Integer value1, Integer value2) {
            addCriterion("Qustid between", value1, value2, "qustid");
            return (Criteria) this;
        }
        public Criteria andQustidNotBetween(Integer value1, Integer value2) {
            addCriterion("Qustid not between", value1, value2, "qustid");
            return (Criteria) this;
        }
        public Criteria andProblemidIsNull() {
            addCriterion("Problemid is null");
            return (Criteria) this;
        }
        public Criteria andProblemidIsNotNull() {
            addCriterion("Problemid is not null");
            return (Criteria) this;
        }
        public Criteria andProblemidEqualTo(Integer value) {
            addCriterion("Problemid =", value, "problemid");
            return (Criteria) this;
        }
        public Criteria andProblemidNotEqualTo(Integer value) {
            addCriterion("Problemid <>", value, "problemid");
            return (Criteria) this;
        }
        public Criteria andProblemidGreaterThan(Integer value) {
            addCriterion("Problemid >", value, "problemid");
            return (Criteria) this;
        }
        public Criteria andProblemidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Problemid >=", value, "problemid");
            return (Criteria) this;
        }
        public Criteria andProblemidLessThan(Integer value) {
            addCriterion("Problemid <", value, "problemid");
            return (Criteria) this;
        }
        public Criteria andProblemidLessThanOrEqualTo(Integer value) {
            addCriterion("Problemid <=", value, "problemid");
            return (Criteria) this;
        }
        public Criteria andProblemidIn(List<Integer> values) {
            addCriterion("Problemid in", values, "problemid");
            return (Criteria) this;
        }
        public Criteria andProblemidNotIn(List<Integer> values) {
            addCriterion("Problemid not in", values, "problemid");
            return (Criteria) this;
        }
        public Criteria andProblemidBetween(Integer value1, Integer value2) {
            addCriterion("Problemid between", value1, value2, "problemid");
            return (Criteria) this;
        }
        public Criteria andProblemidNotBetween(Integer value1, Integer value2) {
            addCriterion("Problemid not between", value1, value2, "problemid");
            return (Criteria) this;
        }
        public Criteria andQustTypeidIsNull() {
            addCriterion("QustTypeid is null");
            return (Criteria) this;
        }
        public Criteria andQustTypeidIsNotNull() {
            addCriterion("QustTypeid is not null");
            return (Criteria) this;
        }
        public Criteria andQustTypeidEqualTo(Short value) {
            addCriterion("QustTypeid =", value, "qustTypeid");
            return (Criteria) this;
        }
        public Criteria andQustTypeidNotEqualTo(Short value) {
            addCriterion("QustTypeid <>", value, "qustTypeid");
            return (Criteria) this;
        }
        public Criteria andQustTypeidGreaterThan(Short value) {
            addCriterion("QustTypeid >", value, "qustTypeid");
            return (Criteria) this;
        }
        public Criteria andQustTypeidGreaterThanOrEqualTo(Short value) {
            addCriterion("QustTypeid >=", value, "qustTypeid");
            return (Criteria) this;
        }
        public Criteria andQustTypeidLessThan(Short value) {
            addCriterion("QustTypeid <", value, "qustTypeid");
            return (Criteria) this;
        }
        public Criteria andQustTypeidLessThanOrEqualTo(Short value) {
            addCriterion("QustTypeid <=", value, "qustTypeid");
            return (Criteria) this;
        }
        public Criteria andQustTypeidIn(List<Short> values) {
            addCriterion("QustTypeid in", values, "qustTypeid");
            return (Criteria) this;
        }
        public Criteria andQustTypeidNotIn(List<Short> values) {
            addCriterion("QustTypeid not in", values, "qustTypeid");
            return (Criteria) this;
        }
        public Criteria andQustTypeidBetween(Short value1, Short value2) {
            addCriterion("QustTypeid between", value1, value2, "qustTypeid");
            return (Criteria) this;
        }
        public Criteria andQustTypeidNotBetween(Short value1, Short value2) {
            addCriterion("QustTypeid not between", value1, value2, "qustTypeid");
            return (Criteria) this;
        }
        public Criteria andProDescIsNull() {
            addCriterion("ProDesc is null");
            return (Criteria) this;
        }
        public Criteria andProDescIsNotNull() {
            addCriterion("ProDesc is not null");
            return (Criteria) this;
        }
        public Criteria andProDescEqualTo(String value) {
            addCriterion("ProDesc =", value, "proDesc");
            return (Criteria) this;
        }
        public Criteria andProDescNotEqualTo(String value) {
            addCriterion("ProDesc <>", value, "proDesc");
            return (Criteria) this;
        }
        public Criteria andProDescGreaterThan(String value) {
            addCriterion("ProDesc >", value, "proDesc");
            return (Criteria) this;
        }
        public Criteria andProDescGreaterThanOrEqualTo(String value) {
            addCriterion("ProDesc >=", value, "proDesc");
            return (Criteria) this;
        }
        public Criteria andProDescLessThan(String value) {
            addCriterion("ProDesc <", value, "proDesc");
            return (Criteria) this;
        }
        public Criteria andProDescLessThanOrEqualTo(String value) {
            addCriterion("ProDesc <=", value, "proDesc");
            return (Criteria) this;
        }
        public Criteria andProDescLike(String value) {
            addCriterion("ProDesc like", value, "proDesc");
            return (Criteria) this;
        }
        public Criteria andProDescNotLike(String value) {
            addCriterion("ProDesc not like", value, "proDesc");
            return (Criteria) this;
        }
        public Criteria andProDescIn(List<String> values) {
            addCriterion("ProDesc in", values, "proDesc");
            return (Criteria) this;
        }
        public Criteria andProDescNotIn(List<String> values) {
            addCriterion("ProDesc not in", values, "proDesc");
            return (Criteria) this;
        }
        public Criteria andProDescBetween(String value1, String value2) {
            addCriterion("ProDesc between", value1, value2, "proDesc");
            return (Criteria) this;
        }
        public Criteria andProDescNotBetween(String value1, String value2) {
            addCriterion("ProDesc not between", value1, value2, "proDesc");
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
        public Criteria andAnsTypeIsNull() {
            addCriterion("AnsType is null");
            return (Criteria) this;
        }
        public Criteria andAnsTypeIsNotNull() {
            addCriterion("AnsType is not null");
            return (Criteria) this;
        }
        public Criteria andAnsTypeEqualTo(String value) {
            addCriterion("AnsType =", value, "ansType");
            return (Criteria) this;
        }
        public Criteria andAnsTypeNotEqualTo(String value) {
            addCriterion("AnsType <>", value, "ansType");
            return (Criteria) this;
        }
        public Criteria andAnsTypeGreaterThan(String value) {
            addCriterion("AnsType >", value, "ansType");
            return (Criteria) this;
        }
        public Criteria andAnsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("AnsType >=", value, "ansType");
            return (Criteria) this;
        }
        public Criteria andAnsTypeLessThan(String value) {
            addCriterion("AnsType <", value, "ansType");
            return (Criteria) this;
        }
        public Criteria andAnsTypeLessThanOrEqualTo(String value) {
            addCriterion("AnsType <=", value, "ansType");
            return (Criteria) this;
        }
        public Criteria andAnsTypeLike(String value) {
            addCriterion("AnsType like", value, "ansType");
            return (Criteria) this;
        }
        public Criteria andAnsTypeNotLike(String value) {
            addCriterion("AnsType not like", value, "ansType");
            return (Criteria) this;
        }
        public Criteria andAnsTypeIn(List<String> values) {
            addCriterion("AnsType in", values, "ansType");
            return (Criteria) this;
        }
        public Criteria andAnsTypeNotIn(List<String> values) {
            addCriterion("AnsType not in", values, "ansType");
            return (Criteria) this;
        }
        public Criteria andAnsTypeBetween(String value1, String value2) {
            addCriterion("AnsType between", value1, value2, "ansType");
            return (Criteria) this;
        }
        public Criteria andAnsTypeNotBetween(String value1, String value2) {
            addCriterion("AnsType not between", value1, value2, "ansType");
            return (Criteria) this;
        }
        public Criteria andRelationIsNull() {
            addCriterion("relation is null");
            return (Criteria) this;
        }
        public Criteria andRelationIsNotNull() {
            addCriterion("relation is not null");
            return (Criteria) this;
        }
        public Criteria andRelationEqualTo(String value) {
            addCriterion("relation =", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationNotEqualTo(String value) {
            addCriterion("relation <>", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationGreaterThan(String value) {
            addCriterion("relation >", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationGreaterThanOrEqualTo(String value) {
            addCriterion("relation >=", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationLessThan(String value) {
            addCriterion("relation <", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationLessThanOrEqualTo(String value) {
            addCriterion("relation <=", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationLike(String value) {
            addCriterion("relation like", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationNotLike(String value) {
            addCriterion("relation not like", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationIn(List<String> values) {
            addCriterion("relation in", values, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationNotIn(List<String> values) {
            addCriterion("relation not in", values, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationBetween(String value1, String value2) {
            addCriterion("relation between", value1, value2, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationNotBetween(String value1, String value2) {
            addCriterion("relation not between", value1, value2, "relation");
            return (Criteria) this;
        }
        public Criteria andUproblemidIsNull() {
            addCriterion("Uproblemid is null");
            return (Criteria) this;
        }
        public Criteria andUproblemidIsNotNull() {
            addCriterion("Uproblemid is not null");
            return (Criteria) this;
        }
        public Criteria andUproblemidEqualTo(Integer value) {
            addCriterion("Uproblemid =", value, "uproblemid");
            return (Criteria) this;
        }
        public Criteria andUproblemidNotEqualTo(Integer value) {
            addCriterion("Uproblemid <>", value, "uproblemid");
            return (Criteria) this;
        }
        public Criteria andUproblemidGreaterThan(Integer value) {
            addCriterion("Uproblemid >", value, "uproblemid");
            return (Criteria) this;
        }
        public Criteria andUproblemidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Uproblemid >=", value, "uproblemid");
            return (Criteria) this;
        }
        public Criteria andUproblemidLessThan(Integer value) {
            addCriterion("Uproblemid <", value, "uproblemid");
            return (Criteria) this;
        }
        public Criteria andUproblemidLessThanOrEqualTo(Integer value) {
            addCriterion("Uproblemid <=", value, "uproblemid");
            return (Criteria) this;
        }
        public Criteria andUproblemidIn(List<Integer> values) {
            addCriterion("Uproblemid in", values, "uproblemid");
            return (Criteria) this;
        }
        public Criteria andUproblemidNotIn(List<Integer> values) {
            addCriterion("Uproblemid not in", values, "uproblemid");
            return (Criteria) this;
        }
        public Criteria andUproblemidBetween(Integer value1, Integer value2) {
            addCriterion("Uproblemid between", value1, value2, "uproblemid");
            return (Criteria) this;
        }
        public Criteria andUproblemidNotBetween(Integer value1, Integer value2) {
            addCriterion("Uproblemid not between", value1, value2, "uproblemid");
            return (Criteria) this;
        }
        public Criteria andUansidIsNull() {
            addCriterion("Uansid is null");
            return (Criteria) this;
        }
        public Criteria andUansidIsNotNull() {
            addCriterion("Uansid is not null");
            return (Criteria) this;
        }
        public Criteria andUansidEqualTo(Short value) {
            addCriterion("Uansid =", value, "uansid");
            return (Criteria) this;
        }
        public Criteria andUansidNotEqualTo(Short value) {
            addCriterion("Uansid <>", value, "uansid");
            return (Criteria) this;
        }
        public Criteria andUansidGreaterThan(Short value) {
            addCriterion("Uansid >", value, "uansid");
            return (Criteria) this;
        }
        public Criteria andUansidGreaterThanOrEqualTo(Short value) {
            addCriterion("Uansid >=", value, "uansid");
            return (Criteria) this;
        }
        public Criteria andUansidLessThan(Short value) {
            addCriterion("Uansid <", value, "uansid");
            return (Criteria) this;
        }
        public Criteria andUansidLessThanOrEqualTo(Short value) {
            addCriterion("Uansid <=", value, "uansid");
            return (Criteria) this;
        }
        public Criteria andUansidIn(List<Short> values) {
            addCriterion("Uansid in", values, "uansid");
            return (Criteria) this;
        }
        public Criteria andUansidNotIn(List<Short> values) {
            addCriterion("Uansid not in", values, "uansid");
            return (Criteria) this;
        }
        public Criteria andUansidBetween(Short value1, Short value2) {
            addCriterion("Uansid between", value1, value2, "uansid");
            return (Criteria) this;
        }
        public Criteria andUansidNotBetween(Short value1, Short value2) {
            addCriterion("Uansid not between", value1, value2, "uansid");
            return (Criteria) this;
        }
        public Criteria andCreateDateIsNull() {
            addCriterion("CreateDate is null");
            return (Criteria) this;
        }
        public Criteria andCreateDateIsNotNull() {
            addCriterion("CreateDate is not null");
            return (Criteria) this;
        }
        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("CreateDate =", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CreateDate <>", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("CreateDate >", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CreateDate >=", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("CreateDate <", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CreateDate <=", value, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("CreateDate in", values, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CreateDate not in", values, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CreateDate between", value1, value2, "createDate");
            return (Criteria) this;
        }
        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CreateDate not between", value1, value2, "createDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 问卷信息明细表（MFQ1)
     * 
     * @author ${user}
     * @version 1.0 2016-07-12
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