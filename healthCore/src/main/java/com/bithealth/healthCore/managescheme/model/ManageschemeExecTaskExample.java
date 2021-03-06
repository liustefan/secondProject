/*
 * ManageschemeExecTaskExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-12-08 Created
 */
package com.bithealth.healthCore.managescheme.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManageschemeExecTaskExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public ManageschemeExecTaskExample() {
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
     * [3.0]管理方案_个人执行_任务
     * 
     * @author ${user}
     * @version 1.0 2016-12-08
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
        public Criteria andMSETaskIDIsNull() {
            addCriterion("MSETaskID is null");
            return (Criteria) this;
        }
        public Criteria andMSETaskIDIsNotNull() {
            addCriterion("MSETaskID is not null");
            return (Criteria) this;
        }
        public Criteria andMSETaskIDEqualTo(Long value) {
            addCriterion("MSETaskID =", value, "MSETaskID");
            return (Criteria) this;
        }
        public Criteria andMSETaskIDNotEqualTo(Long value) {
            addCriterion("MSETaskID <>", value, "MSETaskID");
            return (Criteria) this;
        }
        public Criteria andMSETaskIDGreaterThan(Long value) {
            addCriterion("MSETaskID >", value, "MSETaskID");
            return (Criteria) this;
        }
        public Criteria andMSETaskIDGreaterThanOrEqualTo(Long value) {
            addCriterion("MSETaskID >=", value, "MSETaskID");
            return (Criteria) this;
        }
        public Criteria andMSETaskIDLessThan(Long value) {
            addCriterion("MSETaskID <", value, "MSETaskID");
            return (Criteria) this;
        }
        public Criteria andMSETaskIDLessThanOrEqualTo(Long value) {
            addCriterion("MSETaskID <=", value, "MSETaskID");
            return (Criteria) this;
        }
        public Criteria andMSETaskIDIn(List<Long> values) {
            addCriterion("MSETaskID in", values, "MSETaskID");
            return (Criteria) this;
        }
        public Criteria andMSETaskIDNotIn(List<Long> values) {
            addCriterion("MSETaskID not in", values, "MSETaskID");
            return (Criteria) this;
        }
        public Criteria andMSETaskIDBetween(Long value1, Long value2) {
            addCriterion("MSETaskID between", value1, value2, "MSETaskID");
            return (Criteria) this;
        }
        public Criteria andMSETaskIDNotBetween(Long value1, Long value2) {
            addCriterion("MSETaskID not between", value1, value2, "MSETaskID");
            return (Criteria) this;
        }
        public Criteria andMSExecIDIsNull() {
            addCriterion("MSExecID is null");
            return (Criteria) this;
        }
        public Criteria andMSExecIDIsNotNull() {
            addCriterion("MSExecID is not null");
            return (Criteria) this;
        }
        public Criteria andMSExecIDEqualTo(Integer value) {
            addCriterion("MSExecID =", value, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSExecIDNotEqualTo(Integer value) {
            addCriterion("MSExecID <>", value, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSExecIDGreaterThan(Integer value) {
            addCriterion("MSExecID >", value, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSExecIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("MSExecID >=", value, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSExecIDLessThan(Integer value) {
            addCriterion("MSExecID <", value, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSExecIDLessThanOrEqualTo(Integer value) {
            addCriterion("MSExecID <=", value, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSExecIDIn(List<Integer> values) {
            addCriterion("MSExecID in", values, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSExecIDNotIn(List<Integer> values) {
            addCriterion("MSExecID not in", values, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSExecIDBetween(Integer value1, Integer value2) {
            addCriterion("MSExecID between", value1, value2, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSExecIDNotBetween(Integer value1, Integer value2) {
            addCriterion("MSExecID not between", value1, value2, "MSExecID");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDIsNull() {
            addCriterion("MSDTaskID is null");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDIsNotNull() {
            addCriterion("MSDTaskID is not null");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDEqualTo(Integer value) {
            addCriterion("MSDTaskID =", value, "MSDTaskID");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDNotEqualTo(Integer value) {
            addCriterion("MSDTaskID <>", value, "MSDTaskID");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDGreaterThan(Integer value) {
            addCriterion("MSDTaskID >", value, "MSDTaskID");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("MSDTaskID >=", value, "MSDTaskID");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDLessThan(Integer value) {
            addCriterion("MSDTaskID <", value, "MSDTaskID");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDLessThanOrEqualTo(Integer value) {
            addCriterion("MSDTaskID <=", value, "MSDTaskID");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDIn(List<Integer> values) {
            addCriterion("MSDTaskID in", values, "MSDTaskID");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDNotIn(List<Integer> values) {
            addCriterion("MSDTaskID not in", values, "MSDTaskID");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDBetween(Integer value1, Integer value2) {
            addCriterion("MSDTaskID between", value1, value2, "MSDTaskID");
            return (Criteria) this;
        }
        public Criteria andMSDTaskIDNotBetween(Integer value1, Integer value2) {
            addCriterion("MSDTaskID not between", value1, value2, "MSDTaskID");
            return (Criteria) this;
        }
        public Criteria andPlanTimeIsNull() {
            addCriterion("PlanTime is null");
            return (Criteria) this;
        }
        public Criteria andPlanTimeIsNotNull() {
            addCriterion("PlanTime is not null");
            return (Criteria) this;
        }
        public Criteria andPlanTimeEqualTo(Date value) {
            addCriterion("PlanTime =", value, "planTime");
            return (Criteria) this;
        }
        public Criteria andPlanTimeNotEqualTo(Date value) {
            addCriterion("PlanTime <>", value, "planTime");
            return (Criteria) this;
        }
        public Criteria andPlanTimeGreaterThan(Date value) {
            addCriterion("PlanTime >", value, "planTime");
            return (Criteria) this;
        }
        public Criteria andPlanTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PlanTime >=", value, "planTime");
            return (Criteria) this;
        }
        public Criteria andPlanTimeLessThan(Date value) {
            addCriterion("PlanTime <", value, "planTime");
            return (Criteria) this;
        }
        public Criteria andPlanTimeLessThanOrEqualTo(Date value) {
            addCriterion("PlanTime <=", value, "planTime");
            return (Criteria) this;
        }
        public Criteria andPlanTimeIn(List<Date> values) {
            addCriterion("PlanTime in", values, "planTime");
            return (Criteria) this;
        }
        public Criteria andPlanTimeNotIn(List<Date> values) {
            addCriterion("PlanTime not in", values, "planTime");
            return (Criteria) this;
        }
        public Criteria andPlanTimeBetween(Date value1, Date value2) {
            addCriterion("PlanTime between", value1, value2, "planTime");
            return (Criteria) this;
        }
        public Criteria andPlanTimeNotBetween(Date value1, Date value2) {
            addCriterion("PlanTime not between", value1, value2, "planTime");
            return (Criteria) this;
        }
        public Criteria andExecTimeIsNull() {
            addCriterion("ExecTime is null");
            return (Criteria) this;
        }
        public Criteria andExecTimeIsNotNull() {
            addCriterion("ExecTime is not null");
            return (Criteria) this;
        }
        public Criteria andExecTimeEqualTo(Date value) {
            addCriterion("ExecTime =", value, "execTime");
            return (Criteria) this;
        }
        public Criteria andExecTimeNotEqualTo(Date value) {
            addCriterion("ExecTime <>", value, "execTime");
            return (Criteria) this;
        }
        public Criteria andExecTimeGreaterThan(Date value) {
            addCriterion("ExecTime >", value, "execTime");
            return (Criteria) this;
        }
        public Criteria andExecTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ExecTime >=", value, "execTime");
            return (Criteria) this;
        }
        public Criteria andExecTimeLessThan(Date value) {
            addCriterion("ExecTime <", value, "execTime");
            return (Criteria) this;
        }
        public Criteria andExecTimeLessThanOrEqualTo(Date value) {
            addCriterion("ExecTime <=", value, "execTime");
            return (Criteria) this;
        }
        public Criteria andExecTimeIn(List<Date> values) {
            addCriterion("ExecTime in", values, "execTime");
            return (Criteria) this;
        }
        public Criteria andExecTimeNotIn(List<Date> values) {
            addCriterion("ExecTime not in", values, "execTime");
            return (Criteria) this;
        }
        public Criteria andExecTimeBetween(Date value1, Date value2) {
            addCriterion("ExecTime between", value1, value2, "execTime");
            return (Criteria) this;
        }
        public Criteria andExecTimeNotBetween(Date value1, Date value2) {
            addCriterion("ExecTime not between", value1, value2, "execTime");
            return (Criteria) this;
        }
        public Criteria andExecResultIsNull() {
            addCriterion("ExecResult is null");
            return (Criteria) this;
        }
        public Criteria andExecResultIsNotNull() {
            addCriterion("ExecResult is not null");
            return (Criteria) this;
        }
        public Criteria andExecResultEqualTo(String value) {
            addCriterion("ExecResult =", value, "execResult");
            return (Criteria) this;
        }
        public Criteria andExecResultNotEqualTo(String value) {
            addCriterion("ExecResult <>", value, "execResult");
            return (Criteria) this;
        }
        public Criteria andExecResultGreaterThan(String value) {
            addCriterion("ExecResult >", value, "execResult");
            return (Criteria) this;
        }
        public Criteria andExecResultGreaterThanOrEqualTo(String value) {
            addCriterion("ExecResult >=", value, "execResult");
            return (Criteria) this;
        }
        public Criteria andExecResultLessThan(String value) {
            addCriterion("ExecResult <", value, "execResult");
            return (Criteria) this;
        }
        public Criteria andExecResultLessThanOrEqualTo(String value) {
            addCriterion("ExecResult <=", value, "execResult");
            return (Criteria) this;
        }
        public Criteria andExecResultLike(String value) {
            addCriterion("ExecResult like", value, "execResult");
            return (Criteria) this;
        }
        public Criteria andExecResultNotLike(String value) {
            addCriterion("ExecResult not like", value, "execResult");
            return (Criteria) this;
        }
        public Criteria andExecResultIn(List<String> values) {
            addCriterion("ExecResult in", values, "execResult");
            return (Criteria) this;
        }
        public Criteria andExecResultNotIn(List<String> values) {
            addCriterion("ExecResult not in", values, "execResult");
            return (Criteria) this;
        }
        public Criteria andExecResultBetween(String value1, String value2) {
            addCriterion("ExecResult between", value1, value2, "execResult");
            return (Criteria) this;
        }
        public Criteria andExecResultNotBetween(String value1, String value2) {
            addCriterion("ExecResult not between", value1, value2, "execResult");
            return (Criteria) this;
        }
        public Criteria andExecStatusIsNull() {
            addCriterion("ExecStatus is null");
            return (Criteria) this;
        }
        public Criteria andExecStatusIsNotNull() {
            addCriterion("ExecStatus is not null");
            return (Criteria) this;
        }
        public Criteria andExecStatusEqualTo(Byte value) {
            addCriterion("ExecStatus =", value, "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecStatusNotEqualTo(Byte value) {
            addCriterion("ExecStatus <>", value, "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecStatusGreaterThan(Byte value) {
            addCriterion("ExecStatus >", value, "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("ExecStatus >=", value, "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecStatusLessThan(Byte value) {
            addCriterion("ExecStatus <", value, "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecStatusLessThanOrEqualTo(Byte value) {
            addCriterion("ExecStatus <=", value, "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecStatusIn(List<Byte> values) {
            addCriterion("ExecStatus in", values, "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecStatusNotIn(List<Byte> values) {
            addCriterion("ExecStatus not in", values, "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecStatusBetween(Byte value1, Byte value2) {
            addCriterion("ExecStatus between", value1, value2, "execStatus");
            return (Criteria) this;
        }
        public Criteria andExecStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("ExecStatus not between", value1, value2, "execStatus");
            return (Criteria) this;
        }
        public Criteria andCreateIDIsNull() {
            addCriterion("CreateID is null");
            return (Criteria) this;
        }
        public Criteria andCreateIDIsNotNull() {
            addCriterion("CreateID is not null");
            return (Criteria) this;
        }
        public Criteria andCreateIDEqualTo(Integer value) {
            addCriterion("CreateID =", value, "createID");
            return (Criteria) this;
        }
        public Criteria andCreateIDNotEqualTo(Integer value) {
            addCriterion("CreateID <>", value, "createID");
            return (Criteria) this;
        }
        public Criteria andCreateIDGreaterThan(Integer value) {
            addCriterion("CreateID >", value, "createID");
            return (Criteria) this;
        }
        public Criteria andCreateIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("CreateID >=", value, "createID");
            return (Criteria) this;
        }
        public Criteria andCreateIDLessThan(Integer value) {
            addCriterion("CreateID <", value, "createID");
            return (Criteria) this;
        }
        public Criteria andCreateIDLessThanOrEqualTo(Integer value) {
            addCriterion("CreateID <=", value, "createID");
            return (Criteria) this;
        }
        public Criteria andCreateIDIn(List<Integer> values) {
            addCriterion("CreateID in", values, "createID");
            return (Criteria) this;
        }
        public Criteria andCreateIDNotIn(List<Integer> values) {
            addCriterion("CreateID not in", values, "createID");
            return (Criteria) this;
        }
        public Criteria andCreateIDBetween(Integer value1, Integer value2) {
            addCriterion("CreateID between", value1, value2, "createID");
            return (Criteria) this;
        }
        public Criteria andCreateIDNotBetween(Integer value1, Integer value2) {
            addCriterion("CreateID not between", value1, value2, "createID");
            return (Criteria) this;
        }
        public Criteria andCreateTimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }
        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }
        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }
        public Criteria andUpdateIDIsNull() {
            addCriterion("UpdateID is null");
            return (Criteria) this;
        }
        public Criteria andUpdateIDIsNotNull() {
            addCriterion("UpdateID is not null");
            return (Criteria) this;
        }
        public Criteria andUpdateIDEqualTo(Integer value) {
            addCriterion("UpdateID =", value, "updateID");
            return (Criteria) this;
        }
        public Criteria andUpdateIDNotEqualTo(Integer value) {
            addCriterion("UpdateID <>", value, "updateID");
            return (Criteria) this;
        }
        public Criteria andUpdateIDGreaterThan(Integer value) {
            addCriterion("UpdateID >", value, "updateID");
            return (Criteria) this;
        }
        public Criteria andUpdateIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("UpdateID >=", value, "updateID");
            return (Criteria) this;
        }
        public Criteria andUpdateIDLessThan(Integer value) {
            addCriterion("UpdateID <", value, "updateID");
            return (Criteria) this;
        }
        public Criteria andUpdateIDLessThanOrEqualTo(Integer value) {
            addCriterion("UpdateID <=", value, "updateID");
            return (Criteria) this;
        }
        public Criteria andUpdateIDIn(List<Integer> values) {
            addCriterion("UpdateID in", values, "updateID");
            return (Criteria) this;
        }
        public Criteria andUpdateIDNotIn(List<Integer> values) {
            addCriterion("UpdateID not in", values, "updateID");
            return (Criteria) this;
        }
        public Criteria andUpdateIDBetween(Integer value1, Integer value2) {
            addCriterion("UpdateID between", value1, value2, "updateID");
            return (Criteria) this;
        }
        public Criteria andUpdateIDNotBetween(Integer value1, Integer value2) {
            addCriterion("UpdateID not between", value1, value2, "updateID");
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
     * [3.0]管理方案_个人执行_任务
     * 
     * @author ${user}
     * @version 1.0 2016-12-08
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