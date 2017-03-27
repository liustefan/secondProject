/*
 * MemSingleReportTemplateExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-07-20 Created
 */
package com.bithealth.reportCore.report.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MemSingleReportTemplateExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MemSingleReportTemplateExample() {
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
     * 会员测量报告审核设置(OMAS)
     * 
     * @author ${user}
     * @version 1.0 2016-07-20
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
        public Criteria andTempCodeIsNull() {
            addCriterion("TempCode is null");
            return (Criteria) this;
        }
        public Criteria andTempCodeIsNotNull() {
            addCriterion("TempCode is not null");
            return (Criteria) this;
        }
        public Criteria andTempCodeEqualTo(Integer value) {
            addCriterion("TempCode =", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeNotEqualTo(Integer value) {
            addCriterion("TempCode <>", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeGreaterThan(Integer value) {
            addCriterion("TempCode >", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("TempCode >=", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeLessThan(Integer value) {
            addCriterion("TempCode <", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeLessThanOrEqualTo(Integer value) {
            addCriterion("TempCode <=", value, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeIn(List<Integer> values) {
            addCriterion("TempCode in", values, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeNotIn(List<Integer> values) {
            addCriterion("TempCode not in", values, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeBetween(Integer value1, Integer value2) {
            addCriterion("TempCode between", value1, value2, "tempCode");
            return (Criteria) this;
        }
        public Criteria andTempCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("TempCode not between", value1, value2, "tempCode");
            return (Criteria) this;
        }
        public Criteria andOdgpIdIsNull() {
            addCriterion("OdgpId is null");
            return (Criteria) this;
        }
        public Criteria andOdgpIdIsNotNull() {
            addCriterion("OdgpId is not null");
            return (Criteria) this;
        }
        public Criteria andOdgpIdEqualTo(Integer value) {
            addCriterion("OdgpId =", value, "odgpId");
            return (Criteria) this;
        }
        public Criteria andOdgpIdNotEqualTo(Integer value) {
            addCriterion("OdgpId <>", value, "odgpId");
            return (Criteria) this;
        }
        public Criteria andOdgpIdGreaterThan(Integer value) {
            addCriterion("OdgpId >", value, "odgpId");
            return (Criteria) this;
        }
        public Criteria andOdgpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("OdgpId >=", value, "odgpId");
            return (Criteria) this;
        }
        public Criteria andOdgpIdLessThan(Integer value) {
            addCriterion("OdgpId <", value, "odgpId");
            return (Criteria) this;
        }
        public Criteria andOdgpIdLessThanOrEqualTo(Integer value) {
            addCriterion("OdgpId <=", value, "odgpId");
            return (Criteria) this;
        }
        public Criteria andOdgpIdIn(List<Integer> values) {
            addCriterion("OdgpId in", values, "odgpId");
            return (Criteria) this;
        }
        public Criteria andOdgpIdNotIn(List<Integer> values) {
            addCriterion("OdgpId not in", values, "odgpId");
            return (Criteria) this;
        }
        public Criteria andOdgpIdBetween(Integer value1, Integer value2) {
            addCriterion("OdgpId between", value1, value2, "odgpId");
            return (Criteria) this;
        }
        public Criteria andOdgpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("OdgpId not between", value1, value2, "odgpId");
            return (Criteria) this;
        }
        public Criteria andOptIdIsNull() {
            addCriterion("OptId is null");
            return (Criteria) this;
        }
        public Criteria andOptIdIsNotNull() {
            addCriterion("OptId is not null");
            return (Criteria) this;
        }
        public Criteria andOptIdEqualTo(Short value) {
            addCriterion("OptId =", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotEqualTo(Short value) {
            addCriterion("OptId <>", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdGreaterThan(Short value) {
            addCriterion("OptId >", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdGreaterThanOrEqualTo(Short value) {
            addCriterion("OptId >=", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdLessThan(Short value) {
            addCriterion("OptId <", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdLessThanOrEqualTo(Short value) {
            addCriterion("OptId <=", value, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdIn(List<Short> values) {
            addCriterion("OptId in", values, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotIn(List<Short> values) {
            addCriterion("OptId not in", values, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdBetween(Short value1, Short value2) {
            addCriterion("OptId between", value1, value2, "optId");
            return (Criteria) this;
        }
        public Criteria andOptIdNotBetween(Short value1, Short value2) {
            addCriterion("OptId not between", value1, value2, "optId");
            return (Criteria) this;
        }
        public Criteria andFunIdIsNull() {
            addCriterion("FunId is null");
            return (Criteria) this;
        }
        public Criteria andFunIdIsNotNull() {
            addCriterion("FunId is not null");
            return (Criteria) this;
        }
        public Criteria andFunIdEqualTo(Short value) {
            addCriterion("FunId =", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdNotEqualTo(Short value) {
            addCriterion("FunId <>", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdGreaterThan(Short value) {
            addCriterion("FunId >", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdGreaterThanOrEqualTo(Short value) {
            addCriterion("FunId >=", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdLessThan(Short value) {
            addCriterion("FunId <", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdLessThanOrEqualTo(Short value) {
            addCriterion("FunId <=", value, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdIn(List<Short> values) {
            addCriterion("FunId in", values, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdNotIn(List<Short> values) {
            addCriterion("FunId not in", values, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdBetween(Short value1, Short value2) {
            addCriterion("FunId between", value1, value2, "funId");
            return (Criteria) this;
        }
        public Criteria andFunIdNotBetween(Short value1, Short value2) {
            addCriterion("FunId not between", value1, value2, "funId");
            return (Criteria) this;
        }
        public Criteria andCurrUesedNumIsNull() {
            addCriterion("CurrUesedNum is null");
            return (Criteria) this;
        }
        public Criteria andCurrUesedNumIsNotNull() {
            addCriterion("CurrUesedNum is not null");
            return (Criteria) this;
        }
        public Criteria andCurrUesedNumEqualTo(Long value) {
            addCriterion("CurrUesedNum =", value, "currUesedNum");
            return (Criteria) this;
        }
        public Criteria andCurrUesedNumNotEqualTo(Long value) {
            addCriterion("CurrUesedNum <>", value, "currUesedNum");
            return (Criteria) this;
        }
        public Criteria andCurrUesedNumGreaterThan(Long value) {
            addCriterion("CurrUesedNum >", value, "currUesedNum");
            return (Criteria) this;
        }
        public Criteria andCurrUesedNumGreaterThanOrEqualTo(Long value) {
            addCriterion("CurrUesedNum >=", value, "currUesedNum");
            return (Criteria) this;
        }
        public Criteria andCurrUesedNumLessThan(Long value) {
            addCriterion("CurrUesedNum <", value, "currUesedNum");
            return (Criteria) this;
        }
        public Criteria andCurrUesedNumLessThanOrEqualTo(Long value) {
            addCriterion("CurrUesedNum <=", value, "currUesedNum");
            return (Criteria) this;
        }
        public Criteria andCurrUesedNumIn(List<Long> values) {
            addCriterion("CurrUesedNum in", values, "currUesedNum");
            return (Criteria) this;
        }
        public Criteria andCurrUesedNumNotIn(List<Long> values) {
            addCriterion("CurrUesedNum not in", values, "currUesedNum");
            return (Criteria) this;
        }
        public Criteria andCurrUesedNumBetween(Long value1, Long value2) {
            addCriterion("CurrUesedNum between", value1, value2, "currUesedNum");
            return (Criteria) this;
        }
        public Criteria andCurrUesedNumNotBetween(Long value1, Long value2) {
            addCriterion("CurrUesedNum not between", value1, value2, "currUesedNum");
            return (Criteria) this;
        }
        public Criteria andEndProDateIsNull() {
            addCriterion("EndProDate is null");
            return (Criteria) this;
        }
        public Criteria andEndProDateIsNotNull() {
            addCriterion("EndProDate is not null");
            return (Criteria) this;
        }
        public Criteria andEndProDateEqualTo(Date value) {
            addCriterionForJDBCDate("EndProDate =", value, "endProDate");
            return (Criteria) this;
        }
        public Criteria andEndProDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("EndProDate <>", value, "endProDate");
            return (Criteria) this;
        }
        public Criteria andEndProDateGreaterThan(Date value) {
            addCriterionForJDBCDate("EndProDate >", value, "endProDate");
            return (Criteria) this;
        }
        public Criteria andEndProDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EndProDate >=", value, "endProDate");
            return (Criteria) this;
        }
        public Criteria andEndProDateLessThan(Date value) {
            addCriterionForJDBCDate("EndProDate <", value, "endProDate");
            return (Criteria) this;
        }
        public Criteria andEndProDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EndProDate <=", value, "endProDate");
            return (Criteria) this;
        }
        public Criteria andEndProDateIn(List<Date> values) {
            addCriterionForJDBCDate("EndProDate in", values, "endProDate");
            return (Criteria) this;
        }
        public Criteria andEndProDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("EndProDate not in", values, "endProDate");
            return (Criteria) this;
        }
        public Criteria andEndProDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EndProDate between", value1, value2, "endProDate");
            return (Criteria) this;
        }
        public Criteria andEndProDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EndProDate not between", value1, value2, "endProDate");
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
        public Criteria andCreateNameIsNull() {
            addCriterion("CreateName is null");
            return (Criteria) this;
        }
        public Criteria andCreateNameIsNotNull() {
            addCriterion("CreateName is not null");
            return (Criteria) this;
        }
        public Criteria andCreateNameEqualTo(String value) {
            addCriterion("CreateName =", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameNotEqualTo(String value) {
            addCriterion("CreateName <>", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameGreaterThan(String value) {
            addCriterion("CreateName >", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("CreateName >=", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameLessThan(String value) {
            addCriterion("CreateName <", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameLessThanOrEqualTo(String value) {
            addCriterion("CreateName <=", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameLike(String value) {
            addCriterion("CreateName like", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameNotLike(String value) {
            addCriterion("CreateName not like", value, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameIn(List<String> values) {
            addCriterion("CreateName in", values, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameNotIn(List<String> values) {
            addCriterion("CreateName not in", values, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameBetween(String value1, String value2) {
            addCriterion("CreateName between", value1, value2, "createName");
            return (Criteria) this;
        }
        public Criteria andCreateNameNotBetween(String value1, String value2) {
            addCriterion("CreateName not between", value1, value2, "createName");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 会员测量报告审核设置(OMAS)
     * 
     * @author ${user}
     * @version 1.0 2016-07-20
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