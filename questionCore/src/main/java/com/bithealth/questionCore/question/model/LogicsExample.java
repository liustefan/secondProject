/*
 * LogicsExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

import java.util.ArrayList;
import java.util.List;

public class LogicsExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public LogicsExample() {
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
     * 单份问卷中问题作答逻辑（logics）
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
        public Criteria andQuestIdIsNull() {
            addCriterion("questId is null");
            return (Criteria) this;
        }
        public Criteria andQuestIdIsNotNull() {
            addCriterion("questId is not null");
            return (Criteria) this;
        }
        public Criteria andQuestIdEqualTo(Integer value) {
            addCriterion("questId =", value, "questId");
            return (Criteria) this;
        }
        public Criteria andQuestIdNotEqualTo(Integer value) {
            addCriterion("questId <>", value, "questId");
            return (Criteria) this;
        }
        public Criteria andQuestIdGreaterThan(Integer value) {
            addCriterion("questId >", value, "questId");
            return (Criteria) this;
        }
        public Criteria andQuestIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("questId >=", value, "questId");
            return (Criteria) this;
        }
        public Criteria andQuestIdLessThan(Integer value) {
            addCriterion("questId <", value, "questId");
            return (Criteria) this;
        }
        public Criteria andQuestIdLessThanOrEqualTo(Integer value) {
            addCriterion("questId <=", value, "questId");
            return (Criteria) this;
        }
        public Criteria andQuestIdIn(List<Integer> values) {
            addCriterion("questId in", values, "questId");
            return (Criteria) this;
        }
        public Criteria andQuestIdNotIn(List<Integer> values) {
            addCriterion("questId not in", values, "questId");
            return (Criteria) this;
        }
        public Criteria andQuestIdBetween(Integer value1, Integer value2) {
            addCriterion("questId between", value1, value2, "questId");
            return (Criteria) this;
        }
        public Criteria andQuestIdNotBetween(Integer value1, Integer value2) {
            addCriterion("questId not between", value1, value2, "questId");
            return (Criteria) this;
        }
        public Criteria andProblemIdIsNull() {
            addCriterion("problemId is null");
            return (Criteria) this;
        }
        public Criteria andProblemIdIsNotNull() {
            addCriterion("problemId is not null");
            return (Criteria) this;
        }
        public Criteria andProblemIdEqualTo(Integer value) {
            addCriterion("problemId =", value, "problemId");
            return (Criteria) this;
        }
        public Criteria andProblemIdNotEqualTo(Integer value) {
            addCriterion("problemId <>", value, "problemId");
            return (Criteria) this;
        }
        public Criteria andProblemIdGreaterThan(Integer value) {
            addCriterion("problemId >", value, "problemId");
            return (Criteria) this;
        }
        public Criteria andProblemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("problemId >=", value, "problemId");
            return (Criteria) this;
        }
        public Criteria andProblemIdLessThan(Integer value) {
            addCriterion("problemId <", value, "problemId");
            return (Criteria) this;
        }
        public Criteria andProblemIdLessThanOrEqualTo(Integer value) {
            addCriterion("problemId <=", value, "problemId");
            return (Criteria) this;
        }
        public Criteria andProblemIdIn(List<Integer> values) {
            addCriterion("problemId in", values, "problemId");
            return (Criteria) this;
        }
        public Criteria andProblemIdNotIn(List<Integer> values) {
            addCriterion("problemId not in", values, "problemId");
            return (Criteria) this;
        }
        public Criteria andProblemIdBetween(Integer value1, Integer value2) {
            addCriterion("problemId between", value1, value2, "problemId");
            return (Criteria) this;
        }
        public Criteria andProblemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("problemId not between", value1, value2, "problemId");
            return (Criteria) this;
        }
        public Criteria andAnswerIdIsNull() {
            addCriterion("answerId is null");
            return (Criteria) this;
        }
        public Criteria andAnswerIdIsNotNull() {
            addCriterion("answerId is not null");
            return (Criteria) this;
        }
        public Criteria andAnswerIdEqualTo(Integer value) {
            addCriterion("answerId =", value, "answerId");
            return (Criteria) this;
        }
        public Criteria andAnswerIdNotEqualTo(Integer value) {
            addCriterion("answerId <>", value, "answerId");
            return (Criteria) this;
        }
        public Criteria andAnswerIdGreaterThan(Integer value) {
            addCriterion("answerId >", value, "answerId");
            return (Criteria) this;
        }
        public Criteria andAnswerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("answerId >=", value, "answerId");
            return (Criteria) this;
        }
        public Criteria andAnswerIdLessThan(Integer value) {
            addCriterion("answerId <", value, "answerId");
            return (Criteria) this;
        }
        public Criteria andAnswerIdLessThanOrEqualTo(Integer value) {
            addCriterion("answerId <=", value, "answerId");
            return (Criteria) this;
        }
        public Criteria andAnswerIdIn(List<Integer> values) {
            addCriterion("answerId in", values, "answerId");
            return (Criteria) this;
        }
        public Criteria andAnswerIdNotIn(List<Integer> values) {
            addCriterion("answerId not in", values, "answerId");
            return (Criteria) this;
        }
        public Criteria andAnswerIdBetween(Integer value1, Integer value2) {
            addCriterion("answerId between", value1, value2, "answerId");
            return (Criteria) this;
        }
        public Criteria andAnswerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("answerId not between", value1, value2, "answerId");
            return (Criteria) this;
        }
        public Criteria andProblemIdsIsNull() {
            addCriterion("problemIds is null");
            return (Criteria) this;
        }
        public Criteria andProblemIdsIsNotNull() {
            addCriterion("problemIds is not null");
            return (Criteria) this;
        }
        public Criteria andProblemIdsEqualTo(String value) {
            addCriterion("problemIds =", value, "problemIds");
            return (Criteria) this;
        }
        public Criteria andProblemIdsNotEqualTo(String value) {
            addCriterion("problemIds <>", value, "problemIds");
            return (Criteria) this;
        }
        public Criteria andProblemIdsGreaterThan(String value) {
            addCriterion("problemIds >", value, "problemIds");
            return (Criteria) this;
        }
        public Criteria andProblemIdsGreaterThanOrEqualTo(String value) {
            addCriterion("problemIds >=", value, "problemIds");
            return (Criteria) this;
        }
        public Criteria andProblemIdsLessThan(String value) {
            addCriterion("problemIds <", value, "problemIds");
            return (Criteria) this;
        }
        public Criteria andProblemIdsLessThanOrEqualTo(String value) {
            addCriterion("problemIds <=", value, "problemIds");
            return (Criteria) this;
        }
        public Criteria andProblemIdsLike(String value) {
            addCriterion("problemIds like", value, "problemIds");
            return (Criteria) this;
        }
        public Criteria andProblemIdsNotLike(String value) {
            addCriterion("problemIds not like", value, "problemIds");
            return (Criteria) this;
        }
        public Criteria andProblemIdsIn(List<String> values) {
            addCriterion("problemIds in", values, "problemIds");
            return (Criteria) this;
        }
        public Criteria andProblemIdsNotIn(List<String> values) {
            addCriterion("problemIds not in", values, "problemIds");
            return (Criteria) this;
        }
        public Criteria andProblemIdsBetween(String value1, String value2) {
            addCriterion("problemIds between", value1, value2, "problemIds");
            return (Criteria) this;
        }
        public Criteria andProblemIdsNotBetween(String value1, String value2) {
            addCriterion("problemIds not between", value1, value2, "problemIds");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 单份问卷中问题作答逻辑（logics）
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