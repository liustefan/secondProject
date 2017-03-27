/*
 * PhHealthexamdetailinpatientExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-27 Created
 */
package com.bithealth.inspectCore.physical.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhHealthexamdetailinpatientExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public PhHealthexamdetailinpatientExample() {
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
     * 公共卫生_健康体检明细_住院史表
     * 
     * @author ${user}
     * @version 1.0 2016-06-27
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
            	return;
            }
            criteria.add(new Criterion(condition));
        }
        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
            	return;
            }
            criteria.add(new Criterion(condition, value));
        }
        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
            	return;
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
        public Criteria andLogIDEqualTo(Long value) {
            addCriterion("LogID =", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotEqualTo(Long value) {
            addCriterion("LogID <>", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDGreaterThan(Long value) {
            addCriterion("LogID >", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDGreaterThanOrEqualTo(Long value) {
            addCriterion("LogID >=", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDLessThan(Long value) {
            addCriterion("LogID <", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDLessThanOrEqualTo(Long value) {
            addCriterion("LogID <=", value, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDIn(List<Long> values) {
            addCriterion("LogID in", values, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotIn(List<Long> values) {
        	if(values != null && !values.isEmpty())
        		addCriterion("LogID not in", values, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDBetween(Long value1, Long value2) {
            addCriterion("LogID between", value1, value2, "logID");
            return (Criteria) this;
        }
        public Criteria andLogIDNotBetween(Long value1, Long value2) {
            addCriterion("LogID not between", value1, value2, "logID");
            return (Criteria) this;
        }
        public Criteria andHExamIDIsNull() {
            addCriterion("HExamID is null");
            return (Criteria) this;
        }
        public Criteria andHExamIDIsNotNull() {
            addCriterion("HExamID is not null");
            return (Criteria) this;
        }
        public Criteria andHExamIDEqualTo(Long value) {
            addCriterion("HExamID =", value, "HExamID");
            return (Criteria) this;
        }
        public Criteria andHExamIDNotEqualTo(Integer value) {
            addCriterion("HExamID <>", value, "HExamID");
            return (Criteria) this;
        }
        public Criteria andHExamIDGreaterThan(Integer value) {
            addCriterion("HExamID >", value, "HExamID");
            return (Criteria) this;
        }
        public Criteria andHExamIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("HExamID >=", value, "HExamID");
            return (Criteria) this;
        }
        public Criteria andHExamIDLessThan(Integer value) {
            addCriterion("HExamID <", value, "HExamID");
            return (Criteria) this;
        }
        public Criteria andHExamIDLessThanOrEqualTo(Integer value) {
            addCriterion("HExamID <=", value, "HExamID");
            return (Criteria) this;
        }
        public Criteria andHExamIDIn(List<Long> values) {
            addCriterion("HExamID in", values, "HExamID");
            return (Criteria) this;
        }
        public Criteria andHExamIDNotIn(List<Integer> values) {
            addCriterion("HExamID not in", values, "HExamID");
            return (Criteria) this;
        }
        public Criteria andHExamIDBetween(Integer value1, Integer value2) {
            addCriterion("HExamID between", value1, value2, "HExamID");
            return (Criteria) this;
        }
        public Criteria andHExamIDNotBetween(Integer value1, Integer value2) {
            addCriterion("HExamID not between", value1, value2, "HExamID");
            return (Criteria) this;
        }
        public Criteria andStartDateIsNull() {
            addCriterion("StartDate is null");
            return (Criteria) this;
        }
        public Criteria andStartDateIsNotNull() {
            addCriterion("StartDate is not null");
            return (Criteria) this;
        }
        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("StartDate =", value, "startDate");
            return (Criteria) this;
        }
        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterion("StartDate <>", value, "startDate");
            return (Criteria) this;
        }
        public Criteria andStartDateGreaterThan(Date value) {
            addCriterion("StartDate >", value, "startDate");
            return (Criteria) this;
        }
        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("StartDate >=", value, "startDate");
            return (Criteria) this;
        }
        public Criteria andStartDateLessThan(Date value) {
            addCriterion("StartDate <", value, "startDate");
            return (Criteria) this;
        }
        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("StartDate <=", value, "startDate");
            return (Criteria) this;
        }
        public Criteria andStartDateIn(List<Date> values) {
            addCriterion("StartDate in", values, "startDate");
            return (Criteria) this;
        }
        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterion("StartDate not in", values, "startDate");
            return (Criteria) this;
        }
        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("StartDate between", value1, value2, "startDate");
            return (Criteria) this;
        }
        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("StartDate not between", value1, value2, "startDate");
            return (Criteria) this;
        }
        public Criteria andEndTimeIsNull() {
            addCriterion("EndTime is null");
            return (Criteria) this;
        }
        public Criteria andEndTimeIsNotNull() {
            addCriterion("EndTime is not null");
            return (Criteria) this;
        }
        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("EndTime =", value, "endTime");
            return (Criteria) this;
        }
        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("EndTime <>", value, "endTime");
            return (Criteria) this;
        }
        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("EndTime >", value, "endTime");
            return (Criteria) this;
        }
        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EndTime >=", value, "endTime");
            return (Criteria) this;
        }
        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("EndTime <", value, "endTime");
            return (Criteria) this;
        }
        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("EndTime <=", value, "endTime");
            return (Criteria) this;
        }
        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("EndTime in", values, "endTime");
            return (Criteria) this;
        }
        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("EndTime not in", values, "endTime");
            return (Criteria) this;
        }
        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("EndTime between", value1, value2, "endTime");
            return (Criteria) this;
        }
        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("EndTime not between", value1, value2, "endTime");
            return (Criteria) this;
        }
        public Criteria andRessonIsNull() {
            addCriterion("Resson is null");
            return (Criteria) this;
        }
        public Criteria andRessonIsNotNull() {
            addCriterion("Resson is not null");
            return (Criteria) this;
        }
        public Criteria andRessonEqualTo(String value) {
            addCriterion("Resson =", value, "resson");
            return (Criteria) this;
        }
        public Criteria andRessonNotEqualTo(String value) {
            addCriterion("Resson <>", value, "resson");
            return (Criteria) this;
        }
        public Criteria andRessonGreaterThan(String value) {
            addCriterion("Resson >", value, "resson");
            return (Criteria) this;
        }
        public Criteria andRessonGreaterThanOrEqualTo(String value) {
            addCriterion("Resson >=", value, "resson");
            return (Criteria) this;
        }
        public Criteria andRessonLessThan(String value) {
            addCriterion("Resson <", value, "resson");
            return (Criteria) this;
        }
        public Criteria andRessonLessThanOrEqualTo(String value) {
            addCriterion("Resson <=", value, "resson");
            return (Criteria) this;
        }
        public Criteria andRessonLike(String value) {
            addCriterion("Resson like", value, "resson");
            return (Criteria) this;
        }
        public Criteria andRessonNotLike(String value) {
            addCriterion("Resson not like", value, "resson");
            return (Criteria) this;
        }
        public Criteria andRessonIn(List<String> values) {
            addCriterion("Resson in", values, "resson");
            return (Criteria) this;
        }
        public Criteria andRessonNotIn(List<String> values) {
            addCriterion("Resson not in", values, "resson");
            return (Criteria) this;
        }
        public Criteria andRessonBetween(String value1, String value2) {
            addCriterion("Resson between", value1, value2, "resson");
            return (Criteria) this;
        }
        public Criteria andRessonNotBetween(String value1, String value2) {
            addCriterion("Resson not between", value1, value2, "resson");
            return (Criteria) this;
        }
        public Criteria andInstitutionIsNull() {
            addCriterion("Institution is null");
            return (Criteria) this;
        }
        public Criteria andInstitutionIsNotNull() {
            addCriterion("Institution is not null");
            return (Criteria) this;
        }
        public Criteria andInstitutionEqualTo(String value) {
            addCriterion("Institution =", value, "institution");
            return (Criteria) this;
        }
        public Criteria andInstitutionNotEqualTo(String value) {
            addCriterion("Institution <>", value, "institution");
            return (Criteria) this;
        }
        public Criteria andInstitutionGreaterThan(String value) {
            addCriterion("Institution >", value, "institution");
            return (Criteria) this;
        }
        public Criteria andInstitutionGreaterThanOrEqualTo(String value) {
            addCriterion("Institution >=", value, "institution");
            return (Criteria) this;
        }
        public Criteria andInstitutionLessThan(String value) {
            addCriterion("Institution <", value, "institution");
            return (Criteria) this;
        }
        public Criteria andInstitutionLessThanOrEqualTo(String value) {
            addCriterion("Institution <=", value, "institution");
            return (Criteria) this;
        }
        public Criteria andInstitutionLike(String value) {
            addCriterion("Institution like", value, "institution");
            return (Criteria) this;
        }
        public Criteria andInstitutionNotLike(String value) {
            addCriterion("Institution not like", value, "institution");
            return (Criteria) this;
        }
        public Criteria andInstitutionIn(List<String> values) {
            addCriterion("Institution in", values, "institution");
            return (Criteria) this;
        }
        public Criteria andInstitutionNotIn(List<String> values) {
            addCriterion("Institution not in", values, "institution");
            return (Criteria) this;
        }
        public Criteria andInstitutionBetween(String value1, String value2) {
            addCriterion("Institution between", value1, value2, "institution");
            return (Criteria) this;
        }
        public Criteria andInstitutionNotBetween(String value1, String value2) {
            addCriterion("Institution not between", value1, value2, "institution");
            return (Criteria) this;
        }
        public Criteria andPatientIDIsNull() {
            addCriterion("PatientID is null");
            return (Criteria) this;
        }
        public Criteria andPatientIDIsNotNull() {
            addCriterion("PatientID is not null");
            return (Criteria) this;
        }
        public Criteria andPatientIDEqualTo(String value) {
            addCriterion("PatientID =", value, "patientID");
            return (Criteria) this;
        }
        public Criteria andPatientIDNotEqualTo(String value) {
            addCriterion("PatientID <>", value, "patientID");
            return (Criteria) this;
        }
        public Criteria andPatientIDGreaterThan(String value) {
            addCriterion("PatientID >", value, "patientID");
            return (Criteria) this;
        }
        public Criteria andPatientIDGreaterThanOrEqualTo(String value) {
            addCriterion("PatientID >=", value, "patientID");
            return (Criteria) this;
        }
        public Criteria andPatientIDLessThan(String value) {
            addCriterion("PatientID <", value, "patientID");
            return (Criteria) this;
        }
        public Criteria andPatientIDLessThanOrEqualTo(String value) {
            addCriterion("PatientID <=", value, "patientID");
            return (Criteria) this;
        }
        public Criteria andPatientIDLike(String value) {
            addCriterion("PatientID like", value, "patientID");
            return (Criteria) this;
        }
        public Criteria andPatientIDNotLike(String value) {
            addCriterion("PatientID not like", value, "patientID");
            return (Criteria) this;
        }
        public Criteria andPatientIDIn(List<String> values) {
            addCriterion("PatientID in", values, "patientID");
            return (Criteria) this;
        }
        public Criteria andPatientIDNotIn(List<String> values) {
            addCriterion("PatientID not in", values, "patientID");
            return (Criteria) this;
        }
        public Criteria andPatientIDBetween(String value1, String value2) {
            addCriterion("PatientID between", value1, value2, "patientID");
            return (Criteria) this;
        }
        public Criteria andPatientIDNotBetween(String value1, String value2) {
            addCriterion("PatientID not between", value1, value2, "patientID");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 公共卫生_健康体检明细_住院史表
     * 
     * @author ${user}
     * @version 1.0 2016-06-27
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