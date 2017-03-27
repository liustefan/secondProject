/*
 * ManageschemeTempletDiseaseExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.healthCore.templet.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManageschemeTempletDiseaseExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public ManageschemeTempletDiseaseExample() {
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
     * [3.0]管理方案_模板_疾病关系
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
        public Criteria andLogIDIsNull() {
            addCriterion("LogID is null");
            return (Criteria) this;
        }
        public Criteria andLogIDIsNotNull() {
            addCriterion("LogID is not null");
            return (Criteria) this;
        }
        public Criteria andLogIDEqualTo(Integer value) {
            addCriterion("LogID =", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotEqualTo(Integer value) {
            addCriterion("LogID <>", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDGreaterThan(Integer value) {
            addCriterion("LogID >", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("LogID >=", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDLessThan(Integer value) {
            addCriterion("LogID <", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDLessThanOrEqualTo(Integer value) {
            addCriterion("LogID <=", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDIn(List<Integer> values) {
            addCriterion("LogID in", values, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotIn(List<Integer> values) {
            addCriterion("LogID not in", values, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDBetween(Integer value1, Integer value2) {
            addCriterion("LogID between", value1, value2, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotBetween(Integer value1, Integer value2) {
            addCriterion("LogID not between", value1, value2, "logID");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDIsNull() {
            addCriterion("MSTempletID is null");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDIsNotNull() {
            addCriterion("MSTempletID is not null");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDEqualTo(Integer value) {
            addCriterion("MSTempletID =", value, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDNotEqualTo(Integer value) {
            addCriterion("MSTempletID <>", value, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDGreaterThan(Integer value) {
            addCriterion("MSTempletID >", value, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("MSTempletID >=", value, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDLessThan(Integer value) {
            addCriterion("MSTempletID <", value, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDLessThanOrEqualTo(Integer value) {
            addCriterion("MSTempletID <=", value, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDIn(List<Integer> values) {
            addCriterion("MSTempletID in", values, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDNotIn(List<Integer> values) {
            addCriterion("MSTempletID not in", values, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDBetween(Integer value1, Integer value2) {
            addCriterion("MSTempletID between", value1, value2, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andMSTempletIDNotBetween(Integer value1, Integer value2) {
            addCriterion("MSTempletID not between", value1, value2, "MSTempletID");
            return (Criteria) this;
        }
        public Criteria andMSDiseaseIDIsNull() {
            addCriterion("MSDiseaseID is null");
            return (Criteria) this;
        }
        public Criteria andMSDiseaseIDIsNotNull() {
            addCriterion("MSDiseaseID is not null");
            return (Criteria) this;
        }
        public Criteria andMSDiseaseIDEqualTo(Integer value) {
            addCriterion("MSDiseaseID =", value, "MSDiseaseID");
            return (Criteria) this;
        }
        public Criteria andMSDiseaseIDNotEqualTo(Integer value) {
            addCriterion("MSDiseaseID <>", value, "MSDiseaseID");
            return (Criteria) this;
        }
        public Criteria andMSDiseaseIDGreaterThan(Integer value) {
            addCriterion("MSDiseaseID >", value, "MSDiseaseID");
            return (Criteria) this;
        }
        public Criteria andMSDiseaseIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("MSDiseaseID >=", value, "MSDiseaseID");
            return (Criteria) this;
        }
        public Criteria andMSDiseaseIDLessThan(Integer value) {
            addCriterion("MSDiseaseID <", value, "MSDiseaseID");
            return (Criteria) this;
        }
        public Criteria andMSDiseaseIDLessThanOrEqualTo(Integer value) {
            addCriterion("MSDiseaseID <=", value, "MSDiseaseID");
            return (Criteria) this;
        }
        public Criteria andMSDiseaseIDIn(List<Integer> values) {
            addCriterion("MSDiseaseID in", values, "MSDiseaseID");
            return (Criteria) this;
        }
        public Criteria andMSDiseaseIDNotIn(List<Integer> values) {
            addCriterion("MSDiseaseID not in", values, "MSDiseaseID");
            return (Criteria) this;
        }
        public Criteria andMSDiseaseIDBetween(Integer value1, Integer value2) {
            addCriterion("MSDiseaseID between", value1, value2, "MSDiseaseID");
            return (Criteria) this;
        }
        public Criteria andMSDiseaseIDNotBetween(Integer value1, Integer value2) {
            addCriterion("MSDiseaseID not between", value1, value2, "MSDiseaseID");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeIsNull() {
            addCriterion("UpdateTime is null");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UpdateTime is not null");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UpdateTime =", value, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UpdateTime <>", value, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UpdateTime >", value, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UpdateTime >=", value, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UpdateTime <", value, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UpdateTime <=", value, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UpdateTime in", values, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UpdateTime not in", values, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UpdateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }
        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UpdateTime not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * [3.0]管理方案_模板_疾病关系
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