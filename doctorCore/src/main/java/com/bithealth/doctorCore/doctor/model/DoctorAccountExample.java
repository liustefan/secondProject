/*
 * DoctorAccountExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.doctorCore.doctor.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DoctorAccountExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public DoctorAccountExample() {
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
     * 医生登录管理表(doc1)
     * 
     * @author ${user}
     * @version 1.0 2016-06-23
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
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }
        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }
        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }
        public Criteria andDocidIsNull() {
            addCriterion("Docid is null");
            return (Criteria) this;
        }
        public Criteria andDocidIsNotNull() {
            addCriterion("Docid is not null");
            return (Criteria) this;
        }
        public Criteria andDocidEqualTo(Integer value) {
            addCriterion("Docid =", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidNotEqualTo(Integer value) {
            addCriterion("Docid <>", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidGreaterThan(Integer value) {
            addCriterion("Docid >", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Docid >=", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidLessThan(Integer value) {
            addCriterion("Docid <", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidLessThanOrEqualTo(Integer value) {
            addCriterion("Docid <=", value, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidIn(List<Integer> values) {
            addCriterion("Docid in", values, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidNotIn(List<Integer> values) {
            addCriterion("Docid not in", values, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidBetween(Integer value1, Integer value2) {
            addCriterion("Docid between", value1, value2, "docid");
            return (Criteria) this;
        }
        public Criteria andDocidNotBetween(Integer value1, Integer value2) {
            addCriterion("Docid not between", value1, value2, "docid");
            return (Criteria) this;
        }
        public Criteria andOrgidIsNull() {
            addCriterion("OrgId is null");
            return (Criteria) this;
        }
        public Criteria andOrgidIsNotNull() {
            addCriterion("OrgId is not null");
            return (Criteria) this;
        }
        public Criteria andOrgidEqualTo(Integer value) {
            addCriterion("OrgId =", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidNotEqualTo(Integer value) {
            addCriterion("OrgId <>", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidGreaterThan(Integer value) {
            addCriterion("OrgId >", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrgId >=", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidLessThan(Integer value) {
            addCriterion("OrgId <", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidLessThanOrEqualTo(Integer value) {
            addCriterion("OrgId <=", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidIn(List<Integer> values) {
            addCriterion("OrgId in", values, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidNotIn(List<Integer> values) {
            addCriterion("OrgId not in", values, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidBetween(Integer value1, Integer value2) {
            addCriterion("OrgId between", value1, value2, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidNotBetween(Integer value1, Integer value2) {
            addCriterion("OrgId not between", value1, value2, "orgid");
            return (Criteria) this;
        }
        public Criteria andDocaccIsNull() {
            addCriterion("DocAcc is null");
            return (Criteria) this;
        }
        public Criteria andDocaccIsNotNull() {
            addCriterion("DocAcc is not null");
            return (Criteria) this;
        }
        public Criteria andDocaccEqualTo(String value) {
            addCriterion("DocAcc =", value, "docacc");
            return (Criteria) this;
        }
        public Criteria andDocaccNotEqualTo(String value) {
            addCriterion("DocAcc <>", value, "docacc");
            return (Criteria) this;
        }
        public Criteria andDocaccGreaterThan(String value) {
            addCriterion("DocAcc >", value, "docacc");
            return (Criteria) this;
        }
        public Criteria andDocaccGreaterThanOrEqualTo(String value) {
            addCriterion("DocAcc >=", value, "docacc");
            return (Criteria) this;
        }
        public Criteria andDocaccLessThan(String value) {
            addCriterion("DocAcc <", value, "docacc");
            return (Criteria) this;
        }
        public Criteria andDocaccLessThanOrEqualTo(String value) {
            addCriterion("DocAcc <=", value, "docacc");
            return (Criteria) this;
        }
        public Criteria andDocaccLike(String value) {
            addCriterion("DocAcc like", value, "docacc");
            return (Criteria) this;
        }
        public Criteria andDocaccNotLike(String value) {
            addCriterion("DocAcc not like", value, "docacc");
            return (Criteria) this;
        }
        public Criteria andDocaccIn(List<String> values) {
            addCriterion("DocAcc in", values, "docacc");
            return (Criteria) this;
        }
        public Criteria andDocaccNotIn(List<String> values) {
            addCriterion("DocAcc not in", values, "docacc");
            return (Criteria) this;
        }
        public Criteria andDocaccBetween(String value1, String value2) {
            addCriterion("DocAcc between", value1, value2, "docacc");
            return (Criteria) this;
        }
        public Criteria andDocaccNotBetween(String value1, String value2) {
            addCriterion("DocAcc not between", value1, value2, "docacc");
            return (Criteria) this;
        }
        public Criteria andDocpassIsNull() {
            addCriterion("DocPass is null");
            return (Criteria) this;
        }
        public Criteria andDocpassIsNotNull() {
            addCriterion("DocPass is not null");
            return (Criteria) this;
        }
        public Criteria andDocpassEqualTo(String value) {
            addCriterion("DocPass =", value, "docpass");
            return (Criteria) this;
        }
        public Criteria andDocpassNotEqualTo(String value) {
            addCriterion("DocPass <>", value, "docpass");
            return (Criteria) this;
        }
        public Criteria andDocpassGreaterThan(String value) {
            addCriterion("DocPass >", value, "docpass");
            return (Criteria) this;
        }
        public Criteria andDocpassGreaterThanOrEqualTo(String value) {
            addCriterion("DocPass >=", value, "docpass");
            return (Criteria) this;
        }
        public Criteria andDocpassLessThan(String value) {
            addCriterion("DocPass <", value, "docpass");
            return (Criteria) this;
        }
        public Criteria andDocpassLessThanOrEqualTo(String value) {
            addCriterion("DocPass <=", value, "docpass");
            return (Criteria) this;
        }
        public Criteria andDocpassLike(String value) {
            addCriterion("DocPass like", value, "docpass");
            return (Criteria) this;
        }
        public Criteria andDocpassNotLike(String value) {
            addCriterion("DocPass not like", value, "docpass");
            return (Criteria) this;
        }
        public Criteria andDocpassIn(List<String> values) {
            addCriterion("DocPass in", values, "docpass");
            return (Criteria) this;
        }
        public Criteria andDocpassNotIn(List<String> values) {
            addCriterion("DocPass not in", values, "docpass");
            return (Criteria) this;
        }
        public Criteria andDocpassBetween(String value1, String value2) {
            addCriterion("DocPass between", value1, value2, "docpass");
            return (Criteria) this;
        }
        public Criteria andDocpassNotBetween(String value1, String value2) {
            addCriterion("DocPass not between", value1, value2, "docpass");
            return (Criteria) this;
        }
        public Criteria andLogroleIsNull() {
            addCriterion("LogRole is null");
            return (Criteria) this;
        }
        public Criteria andLogroleIsNotNull() {
            addCriterion("LogRole is not null");
            return (Criteria) this;
        }
        public Criteria andLogroleEqualTo(String value) {
            addCriterion("LogRole =", value, "logrole");
            return (Criteria) this;
        }
        public Criteria andLogroleNotEqualTo(String value) {
            addCriterion("LogRole <>", value, "logrole");
            return (Criteria) this;
        }
        public Criteria andLogroleGreaterThan(String value) {
            addCriterion("LogRole >", value, "logrole");
            return (Criteria) this;
        }
        public Criteria andLogroleGreaterThanOrEqualTo(String value) {
            addCriterion("LogRole >=", value, "logrole");
            return (Criteria) this;
        }
        public Criteria andLogroleLessThan(String value) {
            addCriterion("LogRole <", value, "logrole");
            return (Criteria) this;
        }
        public Criteria andLogroleLessThanOrEqualTo(String value) {
            addCriterion("LogRole <=", value, "logrole");
            return (Criteria) this;
        }
        public Criteria andLogroleLike(String value) {
            addCriterion("LogRole like", value, "logrole");
            return (Criteria) this;
        }
        public Criteria andLogroleNotLike(String value) {
            addCriterion("LogRole not like", value, "logrole");
            return (Criteria) this;
        }
        public Criteria andLogroleIn(List<String> values) {
            addCriterion("LogRole in", values, "logrole");
            return (Criteria) this;
        }
        public Criteria andLogroleNotIn(List<String> values) {
            addCriterion("LogRole not in", values, "logrole");
            return (Criteria) this;
        }
        public Criteria andLogroleBetween(String value1, String value2) {
            addCriterion("LogRole between", value1, value2, "logrole");
            return (Criteria) this;
        }
        public Criteria andLogroleNotBetween(String value1, String value2) {
            addCriterion("LogRole not between", value1, value2, "logrole");
            return (Criteria) this;
        }
        public Criteria andTagIsNull() {
            addCriterion("Tag is null");
            return (Criteria) this;
        }
        public Criteria andTagIsNotNull() {
            addCriterion("Tag is not null");
            return (Criteria) this;
        }
        public Criteria andTagEqualTo(String value) {
            addCriterion("Tag =", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotEqualTo(String value) {
            addCriterion("Tag <>", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagGreaterThan(String value) {
            addCriterion("Tag >", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("Tag >=", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagLessThan(String value) {
            addCriterion("Tag <", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("Tag <=", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagLike(String value) {
            addCriterion("Tag like", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotLike(String value) {
            addCriterion("Tag not like", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagIn(List<String> values) {
            addCriterion("Tag in", values, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotIn(List<String> values) {
            addCriterion("Tag not in", values, "tag");
            return (Criteria) this;
        }
        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("Tag between", value1, value2, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("Tag not between", value1, value2, "tag");
            return (Criteria) this;
        }
        public Criteria andFailtimeIsNull() {
            addCriterion("failTime is null");
            return (Criteria) this;
        }
        public Criteria andFailtimeIsNotNull() {
            addCriterion("failTime is not null");
            return (Criteria) this;
        }
        public Criteria andFailtimeEqualTo(Date value) {
            addCriterion("failTime =", value, "failtime");
            return (Criteria) this;
        }
        public Criteria andFailtimeNotEqualTo(Date value) {
            addCriterion("failTime <>", value, "failtime");
            return (Criteria) this;
        }
        public Criteria andFailtimeGreaterThan(Date value) {
            addCriterion("failTime >", value, "failtime");
            return (Criteria) this;
        }
        public Criteria andFailtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("failTime >=", value, "failtime");
            return (Criteria) this;
        }
        public Criteria andFailtimeLessThan(Date value) {
            addCriterion("failTime <", value, "failtime");
            return (Criteria) this;
        }
        public Criteria andFailtimeLessThanOrEqualTo(Date value) {
            addCriterion("failTime <=", value, "failtime");
            return (Criteria) this;
        }
        public Criteria andFailtimeIn(List<Date> values) {
            addCriterion("failTime in", values, "failtime");
            return (Criteria) this;
        }
        public Criteria andFailtimeNotIn(List<Date> values) {
            addCriterion("failTime not in", values, "failtime");
            return (Criteria) this;
        }
        public Criteria andFailtimeBetween(Date value1, Date value2) {
            addCriterion("failTime between", value1, value2, "failtime");
            return (Criteria) this;
        }
        public Criteria andFailtimeNotBetween(Date value1, Date value2) {
            addCriterion("failTime not between", value1, value2, "failtime");
            return (Criteria) this;
        }
        public Criteria andFailcountIsNull() {
            addCriterion("failCount is null");
            return (Criteria) this;
        }
        public Criteria andFailcountIsNotNull() {
            addCriterion("failCount is not null");
            return (Criteria) this;
        }
        public Criteria andFailcountEqualTo(Integer value) {
            addCriterion("failCount =", value, "failcount");
            return (Criteria) this;
        }
        public Criteria andFailcountNotEqualTo(Integer value) {
            addCriterion("failCount <>", value, "failcount");
            return (Criteria) this;
        }
        public Criteria andFailcountGreaterThan(Integer value) {
            addCriterion("failCount >", value, "failcount");
            return (Criteria) this;
        }
        public Criteria andFailcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("failCount >=", value, "failcount");
            return (Criteria) this;
        }
        public Criteria andFailcountLessThan(Integer value) {
            addCriterion("failCount <", value, "failcount");
            return (Criteria) this;
        }
        public Criteria andFailcountLessThanOrEqualTo(Integer value) {
            addCriterion("failCount <=", value, "failcount");
            return (Criteria) this;
        }
        public Criteria andFailcountIn(List<Integer> values) {
            addCriterion("failCount in", values, "failcount");
            return (Criteria) this;
        }
        public Criteria andFailcountNotIn(List<Integer> values) {
            addCriterion("failCount not in", values, "failcount");
            return (Criteria) this;
        }
        public Criteria andFailcountBetween(Integer value1, Integer value2) {
            addCriterion("failCount between", value1, value2, "failcount");
            return (Criteria) this;
        }
        public Criteria andFailcountNotBetween(Integer value1, Integer value2) {
            addCriterion("failCount not between", value1, value2, "failcount");
            return (Criteria) this;
        }
        public Criteria andLastloginaddrIsNull() {
            addCriterion("lastLoginAddr is null");
            return (Criteria) this;
        }
        public Criteria andLastloginaddrIsNotNull() {
            addCriterion("lastLoginAddr is not null");
            return (Criteria) this;
        }
        public Criteria andLastloginaddrEqualTo(String value) {
            addCriterion("lastLoginAddr =", value, "lastloginaddr");
            return (Criteria) this;
        }
        public Criteria andLastloginaddrNotEqualTo(String value) {
            addCriterion("lastLoginAddr <>", value, "lastloginaddr");
            return (Criteria) this;
        }
        public Criteria andLastloginaddrGreaterThan(String value) {
            addCriterion("lastLoginAddr >", value, "lastloginaddr");
            return (Criteria) this;
        }
        public Criteria andLastloginaddrGreaterThanOrEqualTo(String value) {
            addCriterion("lastLoginAddr >=", value, "lastloginaddr");
            return (Criteria) this;
        }
        public Criteria andLastloginaddrLessThan(String value) {
            addCriterion("lastLoginAddr <", value, "lastloginaddr");
            return (Criteria) this;
        }
        public Criteria andLastloginaddrLessThanOrEqualTo(String value) {
            addCriterion("lastLoginAddr <=", value, "lastloginaddr");
            return (Criteria) this;
        }
        public Criteria andLastloginaddrLike(String value) {
            addCriterion("lastLoginAddr like", value, "lastloginaddr");
            return (Criteria) this;
        }
        public Criteria andLastloginaddrNotLike(String value) {
            addCriterion("lastLoginAddr not like", value, "lastloginaddr");
            return (Criteria) this;
        }
        public Criteria andLastloginaddrIn(List<String> values) {
            addCriterion("lastLoginAddr in", values, "lastloginaddr");
            return (Criteria) this;
        }
        public Criteria andLastloginaddrNotIn(List<String> values) {
            addCriterion("lastLoginAddr not in", values, "lastloginaddr");
            return (Criteria) this;
        }
        public Criteria andLastloginaddrBetween(String value1, String value2) {
            addCriterion("lastLoginAddr between", value1, value2, "lastloginaddr");
            return (Criteria) this;
        }
        public Criteria andLastloginaddrNotBetween(String value1, String value2) {
            addCriterion("lastLoginAddr not between", value1, value2, "lastloginaddr");
            return (Criteria) this;
        }
        public Criteria andLastlogintimeIsNull() {
            addCriterion("lastLoginTime is null");
            return (Criteria) this;
        }
        public Criteria andLastlogintimeIsNotNull() {
            addCriterion("lastLoginTime is not null");
            return (Criteria) this;
        }
        public Criteria andLastlogintimeEqualTo(Date value) {
            addCriterion("lastLoginTime =", value, "lastlogintime");
            return (Criteria) this;
        }
        public Criteria andLastlogintimeNotEqualTo(Date value) {
            addCriterion("lastLoginTime <>", value, "lastlogintime");
            return (Criteria) this;
        }
        public Criteria andLastlogintimeGreaterThan(Date value) {
            addCriterion("lastLoginTime >", value, "lastlogintime");
            return (Criteria) this;
        }
        public Criteria andLastlogintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastLoginTime >=", value, "lastlogintime");
            return (Criteria) this;
        }
        public Criteria andLastlogintimeLessThan(Date value) {
            addCriterion("lastLoginTime <", value, "lastlogintime");
            return (Criteria) this;
        }
        public Criteria andLastlogintimeLessThanOrEqualTo(Date value) {
            addCriterion("lastLoginTime <=", value, "lastlogintime");
            return (Criteria) this;
        }
        public Criteria andLastlogintimeIn(List<Date> values) {
            addCriterion("lastLoginTime in", values, "lastlogintime");
            return (Criteria) this;
        }
        public Criteria andLastlogintimeNotIn(List<Date> values) {
            addCriterion("lastLoginTime not in", values, "lastlogintime");
            return (Criteria) this;
        }
        public Criteria andLastlogintimeBetween(Date value1, Date value2) {
            addCriterion("lastLoginTime between", value1, value2, "lastlogintime");
            return (Criteria) this;
        }
        public Criteria andLastlogintimeNotBetween(Date value1, Date value2) {
            addCriterion("lastLoginTime not between", value1, value2, "lastlogintime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 医生登录管理表(doc1)
     * 
     * @author ${user}
     * @version 1.0 2016-06-23
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