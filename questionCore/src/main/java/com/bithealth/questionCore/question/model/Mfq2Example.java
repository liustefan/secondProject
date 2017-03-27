/*
 * Mfq2Example.java
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

public class Mfq2Example {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public Mfq2Example() {
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
     * 问卷总分信息表（MFQ2）
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
        public Criteria andStartidIsNull() {
            addCriterion("Startid is null");
            return (Criteria) this;
        }
        public Criteria andStartidIsNotNull() {
            addCriterion("Startid is not null");
            return (Criteria) this;
        }
        public Criteria andStartidEqualTo(Integer value) {
            addCriterion("Startid =", value, "startid");
            return (Criteria) this;
        }
        public Criteria andStartidNotEqualTo(Integer value) {
            addCriterion("Startid <>", value, "startid");
            return (Criteria) this;
        }
        public Criteria andStartidGreaterThan(Integer value) {
            addCriterion("Startid >", value, "startid");
            return (Criteria) this;
        }
        public Criteria andStartidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Startid >=", value, "startid");
            return (Criteria) this;
        }
        public Criteria andStartidLessThan(Integer value) {
            addCriterion("Startid <", value, "startid");
            return (Criteria) this;
        }
        public Criteria andStartidLessThanOrEqualTo(Integer value) {
            addCriterion("Startid <=", value, "startid");
            return (Criteria) this;
        }
        public Criteria andStartidIn(List<Integer> values) {
            addCriterion("Startid in", values, "startid");
            return (Criteria) this;
        }
        public Criteria andStartidNotIn(List<Integer> values) {
            addCriterion("Startid not in", values, "startid");
            return (Criteria) this;
        }
        public Criteria andStartidBetween(Integer value1, Integer value2) {
            addCriterion("Startid between", value1, value2, "startid");
            return (Criteria) this;
        }
        public Criteria andStartidNotBetween(Integer value1, Integer value2) {
            addCriterion("Startid not between", value1, value2, "startid");
            return (Criteria) this;
        }
        public Criteria andEndidIsNull() {
            addCriterion("Endid is null");
            return (Criteria) this;
        }
        public Criteria andEndidIsNotNull() {
            addCriterion("Endid is not null");
            return (Criteria) this;
        }
        public Criteria andEndidEqualTo(Integer value) {
            addCriterion("Endid =", value, "endid");
            return (Criteria) this;
        }
        public Criteria andEndidNotEqualTo(Integer value) {
            addCriterion("Endid <>", value, "endid");
            return (Criteria) this;
        }
        public Criteria andEndidGreaterThan(Integer value) {
            addCriterion("Endid >", value, "endid");
            return (Criteria) this;
        }
        public Criteria andEndidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Endid >=", value, "endid");
            return (Criteria) this;
        }
        public Criteria andEndidLessThan(Integer value) {
            addCriterion("Endid <", value, "endid");
            return (Criteria) this;
        }
        public Criteria andEndidLessThanOrEqualTo(Integer value) {
            addCriterion("Endid <=", value, "endid");
            return (Criteria) this;
        }
        public Criteria andEndidIn(List<Integer> values) {
            addCriterion("Endid in", values, "endid");
            return (Criteria) this;
        }
        public Criteria andEndidNotIn(List<Integer> values) {
            addCriterion("Endid not in", values, "endid");
            return (Criteria) this;
        }
        public Criteria andEndidBetween(Integer value1, Integer value2) {
            addCriterion("Endid between", value1, value2, "endid");
            return (Criteria) this;
        }
        public Criteria andEndidNotBetween(Integer value1, Integer value2) {
            addCriterion("Endid not between", value1, value2, "endid");
            return (Criteria) this;
        }
        public Criteria andCountmethodIsNull() {
            addCriterion("countmethod is null");
            return (Criteria) this;
        }
        public Criteria andCountmethodIsNotNull() {
            addCriterion("countmethod is not null");
            return (Criteria) this;
        }
        public Criteria andCountmethodEqualTo(String value) {
            addCriterion("countmethod =", value, "countmethod");
            return (Criteria) this;
        }
        public Criteria andCountmethodNotEqualTo(String value) {
            addCriterion("countmethod <>", value, "countmethod");
            return (Criteria) this;
        }
        public Criteria andCountmethodGreaterThan(String value) {
            addCriterion("countmethod >", value, "countmethod");
            return (Criteria) this;
        }
        public Criteria andCountmethodGreaterThanOrEqualTo(String value) {
            addCriterion("countmethod >=", value, "countmethod");
            return (Criteria) this;
        }
        public Criteria andCountmethodLessThan(String value) {
            addCriterion("countmethod <", value, "countmethod");
            return (Criteria) this;
        }
        public Criteria andCountmethodLessThanOrEqualTo(String value) {
            addCriterion("countmethod <=", value, "countmethod");
            return (Criteria) this;
        }
        public Criteria andCountmethodLike(String value) {
            addCriterion("countmethod like", value, "countmethod");
            return (Criteria) this;
        }
        public Criteria andCountmethodNotLike(String value) {
            addCriterion("countmethod not like", value, "countmethod");
            return (Criteria) this;
        }
        public Criteria andCountmethodIn(List<String> values) {
            addCriterion("countmethod in", values, "countmethod");
            return (Criteria) this;
        }
        public Criteria andCountmethodNotIn(List<String> values) {
            addCriterion("countmethod not in", values, "countmethod");
            return (Criteria) this;
        }
        public Criteria andCountmethodBetween(String value1, String value2) {
            addCriterion("countmethod between", value1, value2, "countmethod");
            return (Criteria) this;
        }
        public Criteria andCountmethodNotBetween(String value1, String value2) {
            addCriterion("countmethod not between", value1, value2, "countmethod");
            return (Criteria) this;
        }
        public Criteria andTotalScoreIsNull() {
            addCriterion("TotalScore is null");
            return (Criteria) this;
        }
        public Criteria andTotalScoreIsNotNull() {
            addCriterion("TotalScore is not null");
            return (Criteria) this;
        }
        public Criteria andTotalScoreEqualTo(Double value) {
            addCriterion("TotalScore =", value, "totalScore");
            return (Criteria) this;
        }
        public Criteria andTotalScoreNotEqualTo(Double value) {
            addCriterion("TotalScore <>", value, "totalScore");
            return (Criteria) this;
        }
        public Criteria andTotalScoreGreaterThan(Double value) {
            addCriterion("TotalScore >", value, "totalScore");
            return (Criteria) this;
        }
        public Criteria andTotalScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("TotalScore >=", value, "totalScore");
            return (Criteria) this;
        }
        public Criteria andTotalScoreLessThan(Double value) {
            addCriterion("TotalScore <", value, "totalScore");
            return (Criteria) this;
        }
        public Criteria andTotalScoreLessThanOrEqualTo(Double value) {
            addCriterion("TotalScore <=", value, "totalScore");
            return (Criteria) this;
        }
        public Criteria andTotalScoreIn(List<Double> values) {
            addCriterion("TotalScore in", values, "totalScore");
            return (Criteria) this;
        }
        public Criteria andTotalScoreNotIn(List<Double> values) {
            addCriterion("TotalScore not in", values, "totalScore");
            return (Criteria) this;
        }
        public Criteria andTotalScoreBetween(Double value1, Double value2) {
            addCriterion("TotalScore between", value1, value2, "totalScore");
            return (Criteria) this;
        }
        public Criteria andTotalScoreNotBetween(Double value1, Double value2) {
            addCriterion("TotalScore not between", value1, value2, "totalScore");
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
     * 问卷总分信息表（MFQ2）
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