/*
 * MemSumReportTemplateExample.java
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

public class MemSumReportTemplateExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MemSumReportTemplateExample() {
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
     * 会员汇总测量报告关联单项(OSRS)
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
        public Criteria andSumRepTempCodeIsNull() {
            addCriterion("SumRepTempCode is null");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeIsNotNull() {
            addCriterion("SumRepTempCode is not null");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeEqualTo(Integer value) {
            addCriterion("SumRepTempCode =", value, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeNotEqualTo(Integer value) {
            addCriterion("SumRepTempCode <>", value, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeGreaterThan(Integer value) {
            addCriterion("SumRepTempCode >", value, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SumRepTempCode >=", value, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeLessThan(Integer value) {
            addCriterion("SumRepTempCode <", value, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeLessThanOrEqualTo(Integer value) {
            addCriterion("SumRepTempCode <=", value, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeIn(List<Integer> values) {
            addCriterion("SumRepTempCode in", values, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeNotIn(List<Integer> values) {
            addCriterion("SumRepTempCode not in", values, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeBetween(Integer value1, Integer value2) {
            addCriterion("SumRepTempCode between", value1, value2, "sumRepTempCode");
            return (Criteria) this;
        }
        public Criteria andSumRepTempCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("SumRepTempCode not between", value1, value2, "sumRepTempCode");
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
        public Criteria andCurrReportidIsNull() {
            addCriterion("CurrReportid is null");
            return (Criteria) this;
        }
        public Criteria andCurrReportidIsNotNull() {
            addCriterion("CurrReportid is not null");
            return (Criteria) this;
        }
        public Criteria andCurrReportidEqualTo(Integer value) {
            addCriterion("CurrReportid =", value, "currReportid");
            return (Criteria) this;
        }
        public Criteria andCurrReportidNotEqualTo(Integer value) {
            addCriterion("CurrReportid <>", value, "currReportid");
            return (Criteria) this;
        }
        public Criteria andCurrReportidGreaterThan(Integer value) {
            addCriterion("CurrReportid >", value, "currReportid");
            return (Criteria) this;
        }
        public Criteria andCurrReportidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CurrReportid >=", value, "currReportid");
            return (Criteria) this;
        }
        public Criteria andCurrReportidLessThan(Integer value) {
            addCriterion("CurrReportid <", value, "currReportid");
            return (Criteria) this;
        }
        public Criteria andCurrReportidLessThanOrEqualTo(Integer value) {
            addCriterion("CurrReportid <=", value, "currReportid");
            return (Criteria) this;
        }
        public Criteria andCurrReportidIn(List<Integer> values) {
            addCriterion("CurrReportid in", values, "currReportid");
            return (Criteria) this;
        }
        public Criteria andCurrReportidNotIn(List<Integer> values) {
            addCriterion("CurrReportid not in", values, "currReportid");
            return (Criteria) this;
        }
        public Criteria andCurrReportidBetween(Integer value1, Integer value2) {
            addCriterion("CurrReportid between", value1, value2, "currReportid");
            return (Criteria) this;
        }
        public Criteria andCurrReportidNotBetween(Integer value1, Integer value2) {
            addCriterion("CurrReportid not between", value1, value2, "currReportid");
            return (Criteria) this;
        }
        public Criteria andOrgIdIsNull() {
            addCriterion("OrgId is null");
            return (Criteria) this;
        }
        public Criteria andOrgIdIsNotNull() {
            addCriterion("OrgId is not null");
            return (Criteria) this;
        }
        public Criteria andOrgIdEqualTo(Integer value) {
            addCriterion("OrgId =", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdNotEqualTo(Integer value) {
            addCriterion("OrgId <>", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdGreaterThan(Integer value) {
            addCriterion("OrgId >", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrgId >=", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdLessThan(Integer value) {
            addCriterion("OrgId <", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("OrgId <=", value, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdIn(List<Integer> values) {
            addCriterion("OrgId in", values, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdNotIn(List<Integer> values) {
            addCriterion("OrgId not in", values, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("OrgId between", value1, value2, "orgId");
            return (Criteria) this;
        }
        public Criteria andOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("OrgId not between", value1, value2, "orgId");
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
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 会员汇总测量报告关联单项(OSRS)
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