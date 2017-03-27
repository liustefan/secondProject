/*
 * HealthEducationDiseaseExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.cmsCore.healthEducation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HealthEducationDiseaseExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public HealthEducationDiseaseExample() {
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
     * [3.0]健教库_疾病关系
     * 
     * @author ${user}
     * @version 1.0 2016-11-29
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
        public Criteria andLogidIsNull() {
            addCriterion("LogID is null");
            return (Criteria) this;
        }
        public Criteria andLogidIsNotNull() {
            addCriterion("LogID is not null");
            return (Criteria) this;
        }
        public Criteria andLogidEqualTo(Integer value) {
            addCriterion("LogID =", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidNotEqualTo(Integer value) {
            addCriterion("LogID <>", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidGreaterThan(Integer value) {
            addCriterion("LogID >", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidGreaterThanOrEqualTo(Integer value) {
            addCriterion("LogID >=", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidLessThan(Integer value) {
            addCriterion("LogID <", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidLessThanOrEqualTo(Integer value) {
            addCriterion("LogID <=", value, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidIn(List<Integer> values) {
            addCriterion("LogID in", values, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidNotIn(List<Integer> values) {
            addCriterion("LogID not in", values, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidBetween(Integer value1, Integer value2) {
            addCriterion("LogID between", value1, value2, "logid");
            return (Criteria) this;
        }
        public Criteria andLogidNotBetween(Integer value1, Integer value2) {
            addCriterion("LogID not between", value1, value2, "logid");
            return (Criteria) this;
        }
        public Criteria andHeducationidIsNull() {
            addCriterion("HEducationID is null");
            return (Criteria) this;
        }
        public Criteria andHeducationidIsNotNull() {
            addCriterion("HEducationID is not null");
            return (Criteria) this;
        }
        public Criteria andHeducationidEqualTo(Integer value) {
            addCriterion("HEducationID =", value, "heducationid");
            return (Criteria) this;
        }
        public Criteria andHeducationidNotEqualTo(Integer value) {
            addCriterion("HEducationID <>", value, "heducationid");
            return (Criteria) this;
        }
        public Criteria andHeducationidGreaterThan(Integer value) {
            addCriterion("HEducationID >", value, "heducationid");
            return (Criteria) this;
        }
        public Criteria andHeducationidGreaterThanOrEqualTo(Integer value) {
            addCriterion("HEducationID >=", value, "heducationid");
            return (Criteria) this;
        }
        public Criteria andHeducationidLessThan(Integer value) {
            addCriterion("HEducationID <", value, "heducationid");
            return (Criteria) this;
        }
        public Criteria andHeducationidLessThanOrEqualTo(Integer value) {
            addCriterion("HEducationID <=", value, "heducationid");
            return (Criteria) this;
        }
        public Criteria andHeducationidIn(List<Integer> values) {
            addCriterion("HEducationID in", values, "heducationid");
            return (Criteria) this;
        }
        public Criteria andHeducationidNotIn(List<Integer> values) {
            addCriterion("HEducationID not in", values, "heducationid");
            return (Criteria) this;
        }
        public Criteria andHeducationidBetween(Integer value1, Integer value2) {
            addCriterion("HEducationID between", value1, value2, "heducationid");
            return (Criteria) this;
        }
        public Criteria andHeducationidNotBetween(Integer value1, Integer value2) {
            addCriterion("HEducationID not between", value1, value2, "heducationid");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidIsNull() {
            addCriterion("MSDiseaseID is null");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidIsNotNull() {
            addCriterion("MSDiseaseID is not null");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidEqualTo(Integer value) {
            addCriterion("MSDiseaseID =", value, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidNotEqualTo(Integer value) {
            addCriterion("MSDiseaseID <>", value, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidGreaterThan(Integer value) {
            addCriterion("MSDiseaseID >", value, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("MSDiseaseID >=", value, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidLessThan(Integer value) {
            addCriterion("MSDiseaseID <", value, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidLessThanOrEqualTo(Integer value) {
            addCriterion("MSDiseaseID <=", value, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidIn(List<Integer> values) {
            addCriterion("MSDiseaseID in", values, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidNotIn(List<Integer> values) {
            addCriterion("MSDiseaseID not in", values, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidBetween(Integer value1, Integer value2) {
            addCriterion("MSDiseaseID between", value1, value2, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andMsdiseaseidNotBetween(Integer value1, Integer value2) {
            addCriterion("MSDiseaseID not between", value1, value2, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeIsNull() {
            addCriterion("UpdateTime is null");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UpdateTime is not null");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UpdateTime =", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UpdateTime <>", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UpdateTime >", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UpdateTime >=", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UpdateTime <", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UpdateTime <=", value, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UpdateTime in", values, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UpdateTime not in", values, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UpdateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }
        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UpdateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * [3.0]健教库_疾病关系
     * 
     * @author ${user}
     * @version 1.0 2016-11-29
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