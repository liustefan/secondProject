/*
 * Mfq21Example.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

import java.util.ArrayList;
import java.util.List;

public class Mfq21Example {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public Mfq21Example() {
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
     * 总分比较值设置（MFQ21)
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
        public Criteria andConvidIsNull() {
            addCriterion("Convid is null");
            return (Criteria) this;
        }
        public Criteria andConvidIsNotNull() {
            addCriterion("Convid is not null");
            return (Criteria) this;
        }
        public Criteria andConvidEqualTo(Short value) {
            addCriterion("Convid =", value, "convid");
            return (Criteria) this;
        }
        public Criteria andConvidNotEqualTo(Short value) {
            addCriterion("Convid <>", value, "convid");
            return (Criteria) this;
        }
        public Criteria andConvidGreaterThan(Short value) {
            addCriterion("Convid >", value, "convid");
            return (Criteria) this;
        }
        public Criteria andConvidGreaterThanOrEqualTo(Short value) {
            addCriterion("Convid >=", value, "convid");
            return (Criteria) this;
        }
        public Criteria andConvidLessThan(Short value) {
            addCriterion("Convid <", value, "convid");
            return (Criteria) this;
        }
        public Criteria andConvidLessThanOrEqualTo(Short value) {
            addCriterion("Convid <=", value, "convid");
            return (Criteria) this;
        }
        public Criteria andConvidIn(List<Short> values) {
            addCriterion("Convid in", values, "convid");
            return (Criteria) this;
        }
        public Criteria andConvidNotIn(List<Short> values) {
            addCriterion("Convid not in", values, "convid");
            return (Criteria) this;
        }
        public Criteria andConvidBetween(Short value1, Short value2) {
            addCriterion("Convid between", value1, value2, "convid");
            return (Criteria) this;
        }
        public Criteria andConvidNotBetween(Short value1, Short value2) {
            addCriterion("Convid not between", value1, value2, "convid");
            return (Criteria) this;
        }
        public Criteria andMinScoreIsNull() {
            addCriterion("MinScore is null");
            return (Criteria) this;
        }
        public Criteria andMinScoreIsNotNull() {
            addCriterion("MinScore is not null");
            return (Criteria) this;
        }
        public Criteria andMinScoreEqualTo(Double value) {
            addCriterion("MinScore =", value, "minScore");
            return (Criteria) this;
        }
        public Criteria andMinScoreNotEqualTo(Double value) {
            addCriterion("MinScore <>", value, "minScore");
            return (Criteria) this;
        }
        public Criteria andMinScoreGreaterThan(Double value) {
            addCriterion("MinScore >", value, "minScore");
            return (Criteria) this;
        }
        public Criteria andMinScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("MinScore >=", value, "minScore");
            return (Criteria) this;
        }
        public Criteria andMinScoreLessThan(Double value) {
            addCriterion("MinScore <", value, "minScore");
            return (Criteria) this;
        }
        public Criteria andMinScoreLessThanOrEqualTo(Double value) {
            addCriterion("MinScore <=", value, "minScore");
            return (Criteria) this;
        }
        public Criteria andMinScoreIn(List<Double> values) {
            addCriterion("MinScore in", values, "minScore");
            return (Criteria) this;
        }
        public Criteria andMinScoreNotIn(List<Double> values) {
            addCriterion("MinScore not in", values, "minScore");
            return (Criteria) this;
        }
        public Criteria andMinScoreBetween(Double value1, Double value2) {
            addCriterion("MinScore between", value1, value2, "minScore");
            return (Criteria) this;
        }
        public Criteria andMinScoreNotBetween(Double value1, Double value2) {
            addCriterion("MinScore not between", value1, value2, "minScore");
            return (Criteria) this;
        }
        public Criteria andMaxScoreIsNull() {
            addCriterion("MaxScore is null");
            return (Criteria) this;
        }
        public Criteria andMaxScoreIsNotNull() {
            addCriterion("MaxScore is not null");
            return (Criteria) this;
        }
        public Criteria andMaxScoreEqualTo(Double value) {
            addCriterion("MaxScore =", value, "maxScore");
            return (Criteria) this;
        }
        public Criteria andMaxScoreNotEqualTo(Double value) {
            addCriterion("MaxScore <>", value, "maxScore");
            return (Criteria) this;
        }
        public Criteria andMaxScoreGreaterThan(Double value) {
            addCriterion("MaxScore >", value, "maxScore");
            return (Criteria) this;
        }
        public Criteria andMaxScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("MaxScore >=", value, "maxScore");
            return (Criteria) this;
        }
        public Criteria andMaxScoreLessThan(Double value) {
            addCriterion("MaxScore <", value, "maxScore");
            return (Criteria) this;
        }
        public Criteria andMaxScoreLessThanOrEqualTo(Double value) {
            addCriterion("MaxScore <=", value, "maxScore");
            return (Criteria) this;
        }
        public Criteria andMaxScoreIn(List<Double> values) {
            addCriterion("MaxScore in", values, "maxScore");
            return (Criteria) this;
        }
        public Criteria andMaxScoreNotIn(List<Double> values) {
            addCriterion("MaxScore not in", values, "maxScore");
            return (Criteria) this;
        }
        public Criteria andMaxScoreBetween(Double value1, Double value2) {
            addCriterion("MaxScore between", value1, value2, "maxScore");
            return (Criteria) this;
        }
        public Criteria andMaxScoreNotBetween(Double value1, Double value2) {
            addCriterion("MaxScore not between", value1, value2, "maxScore");
            return (Criteria) this;
        }
        public Criteria andConclusionIsNull() {
            addCriterion("Conclusion is null");
            return (Criteria) this;
        }
        public Criteria andConclusionIsNotNull() {
            addCriterion("Conclusion is not null");
            return (Criteria) this;
        }
        public Criteria andConclusionEqualTo(String value) {
            addCriterion("Conclusion =", value, "conclusion");
            return (Criteria) this;
        }
        public Criteria andConclusionNotEqualTo(String value) {
            addCriterion("Conclusion <>", value, "conclusion");
            return (Criteria) this;
        }
        public Criteria andConclusionGreaterThan(String value) {
            addCriterion("Conclusion >", value, "conclusion");
            return (Criteria) this;
        }
        public Criteria andConclusionGreaterThanOrEqualTo(String value) {
            addCriterion("Conclusion >=", value, "conclusion");
            return (Criteria) this;
        }
        public Criteria andConclusionLessThan(String value) {
            addCriterion("Conclusion <", value, "conclusion");
            return (Criteria) this;
        }
        public Criteria andConclusionLessThanOrEqualTo(String value) {
            addCriterion("Conclusion <=", value, "conclusion");
            return (Criteria) this;
        }
        public Criteria andConclusionLike(String value) {
            addCriterion("Conclusion like", value, "conclusion");
            return (Criteria) this;
        }
        public Criteria andConclusionNotLike(String value) {
            addCriterion("Conclusion not like", value, "conclusion");
            return (Criteria) this;
        }
        public Criteria andConclusionIn(List<String> values) {
            addCriterion("Conclusion in", values, "conclusion");
            return (Criteria) this;
        }
        public Criteria andConclusionNotIn(List<String> values) {
            addCriterion("Conclusion not in", values, "conclusion");
            return (Criteria) this;
        }
        public Criteria andConclusionBetween(String value1, String value2) {
            addCriterion("Conclusion between", value1, value2, "conclusion");
            return (Criteria) this;
        }
        public Criteria andConclusionNotBetween(String value1, String value2) {
            addCriterion("Conclusion not between", value1, value2, "conclusion");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 总分比较值设置（MFQ21)
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