/*
 * Mfq11Example.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-12 Created
 */
package com.bithealth.questionCore.question.model;

import java.util.ArrayList;
import java.util.List;

public class Mfq11Example {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public Mfq11Example() {
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
     * 问题回答项明细表（MFQ11）
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
        public Criteria andAnsidIsNull() {
            addCriterion("Ansid is null");
            return (Criteria) this;
        }
        public Criteria andAnsidIsNotNull() {
            addCriterion("Ansid is not null");
            return (Criteria) this;
        }
        public Criteria andAnsidEqualTo(Short value) {
            addCriterion("Ansid =", value, "ansid");
            return (Criteria) this;
        }
        public Criteria andAnsidNotEqualTo(Short value) {
            addCriterion("Ansid <>", value, "ansid");
            return (Criteria) this;
        }
        public Criteria andAnsidGreaterThan(Short value) {
            addCriterion("Ansid >", value, "ansid");
            return (Criteria) this;
        }
        public Criteria andAnsidGreaterThanOrEqualTo(Short value) {
            addCriterion("Ansid >=", value, "ansid");
            return (Criteria) this;
        }
        public Criteria andAnsidLessThan(Short value) {
            addCriterion("Ansid <", value, "ansid");
            return (Criteria) this;
        }
        public Criteria andAnsidLessThanOrEqualTo(Short value) {
            addCriterion("Ansid <=", value, "ansid");
            return (Criteria) this;
        }
        public Criteria andAnsidIn(List<Short> values) {
            addCriterion("Ansid in", values, "ansid");
            return (Criteria) this;
        }
        public Criteria andAnsidNotIn(List<Short> values) {
            addCriterion("Ansid not in", values, "ansid");
            return (Criteria) this;
        }
        public Criteria andAnsidBetween(Short value1, Short value2) {
            addCriterion("Ansid between", value1, value2, "ansid");
            return (Criteria) this;
        }
        public Criteria andAnsidNotBetween(Short value1, Short value2) {
            addCriterion("Ansid not between", value1, value2, "ansid");
            return (Criteria) this;
        }
        public Criteria andDescriptionIsNull() {
            addCriterion("Description is null");
            return (Criteria) this;
        }
        public Criteria andDescriptionIsNotNull() {
            addCriterion("Description is not null");
            return (Criteria) this;
        }
        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("Description =", value, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("Description <>", value, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("Description >", value, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("Description >=", value, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionLessThan(String value) {
            addCriterion("Description <", value, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("Description <=", value, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionLike(String value) {
            addCriterion("Description like", value, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionNotLike(String value) {
            addCriterion("Description not like", value, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("Description in", values, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("Description not in", values, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("Description between", value1, value2, "description");
            return (Criteria) this;
        }
        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("Description not between", value1, value2, "description");
            return (Criteria) this;
        }
        public Criteria andMarkIsNull() {
            addCriterion("Mark is null");
            return (Criteria) this;
        }
        public Criteria andMarkIsNotNull() {
            addCriterion("Mark is not null");
            return (Criteria) this;
        }
        public Criteria andMarkEqualTo(String value) {
            addCriterion("Mark =", value, "mark");
            return (Criteria) this;
        }
        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("Mark <>", value, "mark");
            return (Criteria) this;
        }
        public Criteria andMarkGreaterThan(String value) {
            addCriterion("Mark >", value, "mark");
            return (Criteria) this;
        }
        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("Mark >=", value, "mark");
            return (Criteria) this;
        }
        public Criteria andMarkLessThan(String value) {
            addCriterion("Mark <", value, "mark");
            return (Criteria) this;
        }
        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("Mark <=", value, "mark");
            return (Criteria) this;
        }
        public Criteria andMarkLike(String value) {
            addCriterion("Mark like", value, "mark");
            return (Criteria) this;
        }
        public Criteria andMarkNotLike(String value) {
            addCriterion("Mark not like", value, "mark");
            return (Criteria) this;
        }
        public Criteria andMarkIn(List<String> values) {
            addCriterion("Mark in", values, "mark");
            return (Criteria) this;
        }
        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("Mark not in", values, "mark");
            return (Criteria) this;
        }
        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("Mark between", value1, value2, "mark");
            return (Criteria) this;
        }
        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("Mark not between", value1, value2, "mark");
            return (Criteria) this;
        }
        public Criteria andScoreIsNull() {
            addCriterion("Score is null");
            return (Criteria) this;
        }
        public Criteria andScoreIsNotNull() {
            addCriterion("Score is not null");
            return (Criteria) this;
        }
        public Criteria andScoreEqualTo(Double value) {
            addCriterion("Score =", value, "score");
            return (Criteria) this;
        }
        public Criteria andScoreNotEqualTo(Double value) {
            addCriterion("Score <>", value, "score");
            return (Criteria) this;
        }
        public Criteria andScoreGreaterThan(Double value) {
            addCriterion("Score >", value, "score");
            return (Criteria) this;
        }
        public Criteria andScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("Score >=", value, "score");
            return (Criteria) this;
        }
        public Criteria andScoreLessThan(Double value) {
            addCriterion("Score <", value, "score");
            return (Criteria) this;
        }
        public Criteria andScoreLessThanOrEqualTo(Double value) {
            addCriterion("Score <=", value, "score");
            return (Criteria) this;
        }
        public Criteria andScoreIn(List<Double> values) {
            addCriterion("Score in", values, "score");
            return (Criteria) this;
        }
        public Criteria andScoreNotIn(List<Double> values) {
            addCriterion("Score not in", values, "score");
            return (Criteria) this;
        }
        public Criteria andScoreBetween(Double value1, Double value2) {
            addCriterion("Score between", value1, value2, "score");
            return (Criteria) this;
        }
        public Criteria andScoreNotBetween(Double value1, Double value2) {
            addCriterion("Score not between", value1, value2, "score");
            return (Criteria) this;
        }
        public Criteria andFillTagIsNull() {
            addCriterion("FillTag is null");
            return (Criteria) this;
        }
        public Criteria andFillTagIsNotNull() {
            addCriterion("FillTag is not null");
            return (Criteria) this;
        }
        public Criteria andFillTagEqualTo(String value) {
            addCriterion("FillTag =", value, "fillTag");
            return (Criteria) this;
        }
        public Criteria andFillTagNotEqualTo(String value) {
            addCriterion("FillTag <>", value, "fillTag");
            return (Criteria) this;
        }
        public Criteria andFillTagGreaterThan(String value) {
            addCriterion("FillTag >", value, "fillTag");
            return (Criteria) this;
        }
        public Criteria andFillTagGreaterThanOrEqualTo(String value) {
            addCriterion("FillTag >=", value, "fillTag");
            return (Criteria) this;
        }
        public Criteria andFillTagLessThan(String value) {
            addCriterion("FillTag <", value, "fillTag");
            return (Criteria) this;
        }
        public Criteria andFillTagLessThanOrEqualTo(String value) {
            addCriterion("FillTag <=", value, "fillTag");
            return (Criteria) this;
        }
        public Criteria andFillTagLike(String value) {
            addCriterion("FillTag like", value, "fillTag");
            return (Criteria) this;
        }
        public Criteria andFillTagNotLike(String value) {
            addCriterion("FillTag not like", value, "fillTag");
            return (Criteria) this;
        }
        public Criteria andFillTagIn(List<String> values) {
            addCriterion("FillTag in", values, "fillTag");
            return (Criteria) this;
        }
        public Criteria andFillTagNotIn(List<String> values) {
            addCriterion("FillTag not in", values, "fillTag");
            return (Criteria) this;
        }
        public Criteria andFillTagBetween(String value1, String value2) {
            addCriterion("FillTag between", value1, value2, "fillTag");
            return (Criteria) this;
        }
        public Criteria andFillTagNotBetween(String value1, String value2) {
            addCriterion("FillTag not between", value1, value2, "fillTag");
            return (Criteria) this;
        }
        public Criteria andFillblankIsNull() {
            addCriterion("Fillblank is null");
            return (Criteria) this;
        }
        public Criteria andFillblankIsNotNull() {
            addCriterion("Fillblank is not null");
            return (Criteria) this;
        }
        public Criteria andFillblankEqualTo(String value) {
            addCriterion("Fillblank =", value, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankNotEqualTo(String value) {
            addCriterion("Fillblank <>", value, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankGreaterThan(String value) {
            addCriterion("Fillblank >", value, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankGreaterThanOrEqualTo(String value) {
            addCriterion("Fillblank >=", value, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankLessThan(String value) {
            addCriterion("Fillblank <", value, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankLessThanOrEqualTo(String value) {
            addCriterion("Fillblank <=", value, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankLike(String value) {
            addCriterion("Fillblank like", value, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankNotLike(String value) {
            addCriterion("Fillblank not like", value, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankIn(List<String> values) {
            addCriterion("Fillblank in", values, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankNotIn(List<String> values) {
            addCriterion("Fillblank not in", values, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankBetween(String value1, String value2) {
            addCriterion("Fillblank between", value1, value2, "fillblank");
            return (Criteria) this;
        }
        public Criteria andFillblankNotBetween(String value1, String value2) {
            addCriterion("Fillblank not between", value1, value2, "fillblank");
            return (Criteria) this;
        }
        public Criteria andIsValidateIsNull() {
            addCriterion("isValidate is null");
            return (Criteria) this;
        }
        public Criteria andIsValidateIsNotNull() {
            addCriterion("isValidate is not null");
            return (Criteria) this;
        }
        public Criteria andIsValidateEqualTo(Boolean value) {
            addCriterion("isValidate =", value, "isValidate");
            return (Criteria) this;
        }
        public Criteria andIsValidateNotEqualTo(Boolean value) {
            addCriterion("isValidate <>", value, "isValidate");
            return (Criteria) this;
        }
        public Criteria andIsValidateGreaterThan(Boolean value) {
            addCriterion("isValidate >", value, "isValidate");
            return (Criteria) this;
        }
        public Criteria andIsValidateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isValidate >=", value, "isValidate");
            return (Criteria) this;
        }
        public Criteria andIsValidateLessThan(Boolean value) {
            addCriterion("isValidate <", value, "isValidate");
            return (Criteria) this;
        }
        public Criteria andIsValidateLessThanOrEqualTo(Boolean value) {
            addCriterion("isValidate <=", value, "isValidate");
            return (Criteria) this;
        }
        public Criteria andIsValidateIn(List<Boolean> values) {
            addCriterion("isValidate in", values, "isValidate");
            return (Criteria) this;
        }
        public Criteria andIsValidateNotIn(List<Boolean> values) {
            addCriterion("isValidate not in", values, "isValidate");
            return (Criteria) this;
        }
        public Criteria andIsValidateBetween(Boolean value1, Boolean value2) {
            addCriterion("isValidate between", value1, value2, "isValidate");
            return (Criteria) this;
        }
        public Criteria andIsValidateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isValidate not between", value1, value2, "isValidate");
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
        public Criteria andMinScoreEqualTo(Short value) {
            addCriterion("MinScore =", value, "minScore");
            return (Criteria) this;
        }
        public Criteria andMinScoreNotEqualTo(Short value) {
            addCriterion("MinScore <>", value, "minScore");
            return (Criteria) this;
        }
        public Criteria andMinScoreGreaterThan(Short value) {
            addCriterion("MinScore >", value, "minScore");
            return (Criteria) this;
        }
        public Criteria andMinScoreGreaterThanOrEqualTo(Short value) {
            addCriterion("MinScore >=", value, "minScore");
            return (Criteria) this;
        }
        public Criteria andMinScoreLessThan(Short value) {
            addCriterion("MinScore <", value, "minScore");
            return (Criteria) this;
        }
        public Criteria andMinScoreLessThanOrEqualTo(Short value) {
            addCriterion("MinScore <=", value, "minScore");
            return (Criteria) this;
        }
        public Criteria andMinScoreIn(List<Short> values) {
            addCriterion("MinScore in", values, "minScore");
            return (Criteria) this;
        }
        public Criteria andMinScoreNotIn(List<Short> values) {
            addCriterion("MinScore not in", values, "minScore");
            return (Criteria) this;
        }
        public Criteria andMinScoreBetween(Short value1, Short value2) {
            addCriterion("MinScore between", value1, value2, "minScore");
            return (Criteria) this;
        }
        public Criteria andMinScoreNotBetween(Short value1, Short value2) {
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
        public Criteria andMaxScoreEqualTo(Short value) {
            addCriterion("MaxScore =", value, "maxScore");
            return (Criteria) this;
        }
        public Criteria andMaxScoreNotEqualTo(Short value) {
            addCriterion("MaxScore <>", value, "maxScore");
            return (Criteria) this;
        }
        public Criteria andMaxScoreGreaterThan(Short value) {
            addCriterion("MaxScore >", value, "maxScore");
            return (Criteria) this;
        }
        public Criteria andMaxScoreGreaterThanOrEqualTo(Short value) {
            addCriterion("MaxScore >=", value, "maxScore");
            return (Criteria) this;
        }
        public Criteria andMaxScoreLessThan(Short value) {
            addCriterion("MaxScore <", value, "maxScore");
            return (Criteria) this;
        }
        public Criteria andMaxScoreLessThanOrEqualTo(Short value) {
            addCriterion("MaxScore <=", value, "maxScore");
            return (Criteria) this;
        }
        public Criteria andMaxScoreIn(List<Short> values) {
            addCriterion("MaxScore in", values, "maxScore");
            return (Criteria) this;
        }
        public Criteria andMaxScoreNotIn(List<Short> values) {
            addCriterion("MaxScore not in", values, "maxScore");
            return (Criteria) this;
        }
        public Criteria andMaxScoreBetween(Short value1, Short value2) {
            addCriterion("MaxScore between", value1, value2, "maxScore");
            return (Criteria) this;
        }
        public Criteria andMaxScoreNotBetween(Short value1, Short value2) {
            addCriterion("MaxScore not between", value1, value2, "maxScore");
            return (Criteria) this;
        }
        public Criteria andComTagIsNull() {
            addCriterion("ComTag is null");
            return (Criteria) this;
        }
        public Criteria andComTagIsNotNull() {
            addCriterion("ComTag is not null");
            return (Criteria) this;
        }
        public Criteria andComTagEqualTo(String value) {
            addCriterion("ComTag =", value, "comTag");
            return (Criteria) this;
        }
        public Criteria andComTagNotEqualTo(String value) {
            addCriterion("ComTag <>", value, "comTag");
            return (Criteria) this;
        }
        public Criteria andComTagGreaterThan(String value) {
            addCriterion("ComTag >", value, "comTag");
            return (Criteria) this;
        }
        public Criteria andComTagGreaterThanOrEqualTo(String value) {
            addCriterion("ComTag >=", value, "comTag");
            return (Criteria) this;
        }
        public Criteria andComTagLessThan(String value) {
            addCriterion("ComTag <", value, "comTag");
            return (Criteria) this;
        }
        public Criteria andComTagLessThanOrEqualTo(String value) {
            addCriterion("ComTag <=", value, "comTag");
            return (Criteria) this;
        }
        public Criteria andComTagLike(String value) {
            addCriterion("ComTag like", value, "comTag");
            return (Criteria) this;
        }
        public Criteria andComTagNotLike(String value) {
            addCriterion("ComTag not like", value, "comTag");
            return (Criteria) this;
        }
        public Criteria andComTagIn(List<String> values) {
            addCriterion("ComTag in", values, "comTag");
            return (Criteria) this;
        }
        public Criteria andComTagNotIn(List<String> values) {
            addCriterion("ComTag not in", values, "comTag");
            return (Criteria) this;
        }
        public Criteria andComTagBetween(String value1, String value2) {
            addCriterion("ComTag between", value1, value2, "comTag");
            return (Criteria) this;
        }
        public Criteria andComTagNotBetween(String value1, String value2) {
            addCriterion("ComTag not between", value1, value2, "comTag");
            return (Criteria) this;
        }
        public Criteria andCreateidIsNull() {
            addCriterion("Createid is null");
            return (Criteria) this;
        }
        public Criteria andCreateidIsNotNull() {
            addCriterion("Createid is not null");
            return (Criteria) this;
        }
        public Criteria andCreateidEqualTo(Integer value) {
            addCriterion("Createid =", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotEqualTo(Integer value) {
            addCriterion("Createid <>", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidGreaterThan(Integer value) {
            addCriterion("Createid >", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Createid >=", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidLessThan(Integer value) {
            addCriterion("Createid <", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidLessThanOrEqualTo(Integer value) {
            addCriterion("Createid <=", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidIn(List<Integer> values) {
            addCriterion("Createid in", values, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotIn(List<Integer> values) {
            addCriterion("Createid not in", values, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidBetween(Integer value1, Integer value2) {
            addCriterion("Createid between", value1, value2, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotBetween(Integer value1, Integer value2) {
            addCriterion("Createid not between", value1, value2, "createid");
            return (Criteria) this;
        }
        public Criteria andDocNameIsNull() {
            addCriterion("DocName is null");
            return (Criteria) this;
        }
        public Criteria andDocNameIsNotNull() {
            addCriterion("DocName is not null");
            return (Criteria) this;
        }
        public Criteria andDocNameEqualTo(String value) {
            addCriterion("DocName =", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameNotEqualTo(String value) {
            addCriterion("DocName <>", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameGreaterThan(String value) {
            addCriterion("DocName >", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameGreaterThanOrEqualTo(String value) {
            addCriterion("DocName >=", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameLessThan(String value) {
            addCriterion("DocName <", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameLessThanOrEqualTo(String value) {
            addCriterion("DocName <=", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameLike(String value) {
            addCriterion("DocName like", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameNotLike(String value) {
            addCriterion("DocName not like", value, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameIn(List<String> values) {
            addCriterion("DocName in", values, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameNotIn(List<String> values) {
            addCriterion("DocName not in", values, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameBetween(String value1, String value2) {
            addCriterion("DocName between", value1, value2, "docName");
            return (Criteria) this;
        }
        public Criteria andDocNameNotBetween(String value1, String value2) {
            addCriterion("DocName not between", value1, value2, "docName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 问题回答项明细表（MFQ11）
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