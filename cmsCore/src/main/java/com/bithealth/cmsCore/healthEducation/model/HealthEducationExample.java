/*
 * HealthEducationExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-11-29 Created
 */
package com.bithealth.cmsCore.healthEducation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bithealth.cmsCore.model.HealthnewsInfoExample.Criteria;

public class HealthEducationExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public HealthEducationExample() {
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
     * [3.0]健教库
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
        public Criteria andHeducationtypeIsNull() {
            addCriterion("HEducationType is null");
            return (Criteria) this;
        }
        public Criteria andHeducationtypeIsNotNull() {
            addCriterion("HEducationType is not null");
            return (Criteria) this;
        }
        public Criteria andHeducationtypeEqualTo(Byte value) {
            addCriterion("HEducationType =", value, "heducationtype");
            return (Criteria) this;
        }
        public Criteria andHeducationtypeNotEqualTo(Byte value) {
            addCriterion("HEducationType <>", value, "heducationtype");
            return (Criteria) this;
        }
        public Criteria andHeducationtypeGreaterThan(Byte value) {
            addCriterion("HEducationType >", value, "heducationtype");
            return (Criteria) this;
        }
        public Criteria andHeducationtypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("HEducationType >=", value, "heducationtype");
            return (Criteria) this;
        }
        public Criteria andHeducationtypeLessThan(Byte value) {
            addCriterion("HEducationType <", value, "heducationtype");
            return (Criteria) this;
        }
        public Criteria andHeducationtypeLessThanOrEqualTo(Byte value) {
            addCriterion("HEducationType <=", value, "heducationtype");
            return (Criteria) this;
        }
        public Criteria andHeducationtypeIn(List<Byte> values) {
            addCriterion("HEducationType in", values, "heducationtype");
            return (Criteria) this;
        }
        public Criteria andHeducationtypeNotIn(List<Byte> values) {
            addCriterion("HEducationType not in", values, "heducationtype");
            return (Criteria) this;
        }
        public Criteria andHeducationtypeBetween(Byte value1, Byte value2) {
            addCriterion("HEducationType between", value1, value2, "heducationtype");
            return (Criteria) this;
        }
        public Criteria andHeducationtypeNotBetween(Byte value1, Byte value2) {
            addCriterion("HEducationType not between", value1, value2, "heducationtype");
            return (Criteria) this;
        }
        public Criteria andTitleIsNull() {
            addCriterion("Title is null");
            return (Criteria) this;
        }
        public Criteria andTitleIsNotNull() {
            addCriterion("Title is not null");
            return (Criteria) this;
        }
        public Criteria andTitleEqualTo(String value) {
            addCriterion("Title =", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("Title <>", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleGreaterThan(String value) {
            addCriterion("Title >", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("Title >=", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleLessThan(String value) {
            addCriterion("Title <", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("Title <=", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleLike(String value) {
        	if(StringUtils.isNotEmpty(value))
            addCriterion("Title like", "%" + value + "%", "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotLike(String value) {
            addCriterion("Title not like", value, "title");
            return (Criteria) this;
        }
        public Criteria andTitleIn(List<String> values) {
            addCriterion("Title in", values, "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("Title not in", values, "title");
            return (Criteria) this;
        }
        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("Title between", value1, value2, "title");
            return (Criteria) this;
        }
        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("Title not between", value1, value2, "title");
            return (Criteria) this;
        }
        public Criteria andSourcewayIsNull() {
            addCriterion("SourceWay is null");
            return (Criteria) this;
        }
        public Criteria andSourcewayIsNotNull() {
            addCriterion("SourceWay is not null");
            return (Criteria) this;
        }
        public Criteria andSourcewayEqualTo(Byte value) {
            addCriterion("SourceWay =", value, "sourceway");
            return (Criteria) this;
        }
        public Criteria andSourcewayNotEqualTo(Byte value) {
            addCriterion("SourceWay <>", value, "sourceway");
            return (Criteria) this;
        }
        public Criteria andSourcewayGreaterThan(Byte value) {
            addCriterion("SourceWay >", value, "sourceway");
            return (Criteria) this;
        }
        public Criteria andSourcewayGreaterThanOrEqualTo(Byte value) {
            addCriterion("SourceWay >=", value, "sourceway");
            return (Criteria) this;
        }
        public Criteria andSourcewayLessThan(Byte value) {
            addCriterion("SourceWay <", value, "sourceway");
            return (Criteria) this;
        }
        public Criteria andSourcewayLessThanOrEqualTo(Byte value) {
            addCriterion("SourceWay <=", value, "sourceway");
            return (Criteria) this;
        }
        public Criteria andSourcewayIn(List<Byte> values) {
            addCriterion("SourceWay in", values, "sourceway");
            return (Criteria) this;
        }
        public Criteria andSourcewayNotIn(List<Byte> values) {
            addCriterion("SourceWay not in", values, "sourceway");
            return (Criteria) this;
        }
        public Criteria andSourcewayBetween(Byte value1, Byte value2) {
            addCriterion("SourceWay between", value1, value2, "sourceway");
            return (Criteria) this;
        }
        public Criteria andSourcewayNotBetween(Byte value1, Byte value2) {
            addCriterion("SourceWay not between", value1, value2, "sourceway");
            return (Criteria) this;
        }
        
        public Criteria andSourceIDIsNull() {
            addCriterion("SourceID is null");
            return (Criteria) this;
        }
        public Criteria andSourceIDIsNotNull() {
            addCriterion("SourceID is not null");
            return (Criteria) this;
        }
        public Criteria andSourceIDEqualTo(Integer value) {
            addCriterion("SourceID =", value, "sourceid");
            return (Criteria) this;
        }
        public Criteria andSourceIDNotEqualTo(Integer value) {
            addCriterion("SourceID <>", value, "sourceid");
            return (Criteria) this;
        }
        public Criteria andSourceIDGreaterThan(Integer value) {
            addCriterion("SourceID >", value, "sourceid");
            return (Criteria) this;
        }
        public Criteria andSourceIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("SourceID >=", value, "sourceid");
            return (Criteria) this;
        }
        public Criteria andSourceIDLessThan(Integer value) {
            addCriterion("SourceID <", value, "sourceid");
            return (Criteria) this;
        }
        public Criteria andSourceIDLessThanOrEqualTo(Integer value) {
            addCriterion("SourceID=", value, "sourceid");
            return (Criteria) this;
        }
        public Criteria andSourceIDIn(List<Integer> values) {
            addCriterion("SourceID in", values, "sourceid");
            return (Criteria) this;
        }
        public Criteria andSourceIDNotIn(List<Integer> values) {
            addCriterion("SourceID not in", values, "sourceid");
            return (Criteria) this;
        }
        public Criteria andSourceIDBetween(Integer value1, Integer value2) {
            addCriterion("SourceID between", value1, value2, "sourceid");
            return (Criteria) this;
        }
        public Criteria andSourceIDNotBetween(Integer value1, Integer value2) {
            addCriterion("SourceID not between", value1, value2, "sourceid");
            return (Criteria) this;
        }
        
        public Criteria andContentIsNull() {
            addCriterion("Content is null");
            return (Criteria) this;
        }
        public Criteria andContentIsNotNull() {
            addCriterion("Content is not null");
            return (Criteria) this;
        }
        public Criteria andContentEqualTo(String value) {
            addCriterion("Content =", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotEqualTo(String value) {
            addCriterion("Content <>", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentGreaterThan(String value) {
            addCriterion("Content >", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("Content >=", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentLessThan(String value) {
            addCriterion("Content <", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("Content <=", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentLike(String value) {
            addCriterion("Content like", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotLike(String value) {
            addCriterion("Content not like", value, "content");
            return (Criteria) this;
        }
        public Criteria andContentIn(List<String> values) {
            addCriterion("Content in", values, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotIn(List<String> values) {
            addCriterion("Content not in", values, "content");
            return (Criteria) this;
        }
        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("Content between", value1, value2, "content");
            return (Criteria) this;
        }
        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("Content not between", value1, value2, "content");
            return (Criteria) this;
        }
        public Criteria andOrgidIsNull() {
            addCriterion("OrgID is null");
            return (Criteria) this;
        }
        public Criteria andOrgidIsNotNull() {
            addCriterion("OrgID is not null");
            return (Criteria) this;
        }
        public Criteria andOrgidEqualTo(Integer value) {
            addCriterion("OrgID =", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidNotEqualTo(Integer value) {
            addCriterion("OrgID <>", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidGreaterThan(Integer value) {
            addCriterion("OrgID >", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrgID >=", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidLessThan(Integer value) {
            addCriterion("OrgID <", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidLessThanOrEqualTo(Integer value) {
            addCriterion("OrgID <=", value, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidIn(List<Integer> values) {
            addCriterion("OrgID in", values, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidNotIn(List<Integer> values) {
            addCriterion("OrgID not in", values, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidBetween(Integer value1, Integer value2) {
            addCriterion("OrgID between", value1, value2, "orgid");
            return (Criteria) this;
        }
        public Criteria andOrgidNotBetween(Integer value1, Integer value2) {
            addCriterion("OrgID not between", value1, value2, "orgid");
            return (Criteria) this;
        }
        public Criteria andUserangeIsNull() {
            addCriterion("UseRange is null");
            return (Criteria) this;
        }
        public Criteria andUserangeIsNotNull() {
            addCriterion("UseRange is not null");
            return (Criteria) this;
        }
        public Criteria andUserangeEqualTo(Byte value) {
            addCriterion("UseRange =", value, "userange");
            return (Criteria) this;
        }
        public Criteria andUserangeNotEqualTo(Byte value) {
            addCriterion("UseRange <>", value, "userange");
            return (Criteria) this;
        }
        public Criteria andUserangeGreaterThan(Byte value) {
            addCriterion("UseRange >", value, "userange");
            return (Criteria) this;
        }
        public Criteria andUserangeGreaterThanOrEqualTo(Byte value) {
            addCriterion("UseRange >=", value, "userange");
            return (Criteria) this;
        }
        public Criteria andUserangeLessThan(Byte value) {
            addCriterion("UseRange <", value, "userange");
            return (Criteria) this;
        }
        public Criteria andUserangeLessThanOrEqualTo(Byte value) {
            addCriterion("UseRange <=", value, "userange");
            return (Criteria) this;
        }
        public Criteria andUserangeIn(List<Byte> values) {
            addCriterion("UseRange in", values, "userange");
            return (Criteria) this;
        }
        public Criteria andUserangeNotIn(List<Byte> values) {
            addCriterion("UseRange not in", values, "userange");
            return (Criteria) this;
        }
        public Criteria andUserangeBetween(Byte value1, Byte value2) {
            addCriterion("UseRange between", value1, value2, "userange");
            return (Criteria) this;
        }
        public Criteria andUserangeNotBetween(Byte value1, Byte value2) {
            addCriterion("UseRange not between", value1, value2, "userange");
            return (Criteria) this;
        }
        public Criteria andCreateidIsNull() {
            addCriterion("CreateID is null");
            return (Criteria) this;
        }
        public Criteria andCreateidIsNotNull() {
            addCriterion("CreateID is not null");
            return (Criteria) this;
        }
        public Criteria andCreateidEqualTo(Integer value) {
            addCriterion("CreateID =", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotEqualTo(Integer value) {
            addCriterion("CreateID <>", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidGreaterThan(Integer value) {
            addCriterion("CreateID >", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CreateID >=", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidLessThan(Integer value) {
            addCriterion("CreateID <", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidLessThanOrEqualTo(Integer value) {
            addCriterion("CreateID <=", value, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidIn(List<Integer> values) {
            addCriterion("CreateID in", values, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotIn(List<Integer> values) {
            addCriterion("CreateID not in", values, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidBetween(Integer value1, Integer value2) {
            addCriterion("CreateID between", value1, value2, "createid");
            return (Criteria) this;
        }
        public Criteria andCreateidNotBetween(Integer value1, Integer value2) {
            addCriterion("CreateID not between", value1, value2, "createid");
            return (Criteria) this;
        }
        public Criteria andCreatetimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }
        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }
        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createtime");
            return (Criteria) this;
        }
        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }
        public Criteria andUpdateidIsNull() {
            addCriterion("UpdateID is null");
            return (Criteria) this;
        }
        public Criteria andUpdateidIsNotNull() {
            addCriterion("UpdateID is not null");
            return (Criteria) this;
        }
        public Criteria andUpdateidEqualTo(Integer value) {
            addCriterion("UpdateID =", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidNotEqualTo(Integer value) {
            addCriterion("UpdateID <>", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidGreaterThan(Integer value) {
            addCriterion("UpdateID >", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidGreaterThanOrEqualTo(Integer value) {
            addCriterion("UpdateID >=", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidLessThan(Integer value) {
            addCriterion("UpdateID <", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidLessThanOrEqualTo(Integer value) {
            addCriterion("UpdateID <=", value, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidIn(List<Integer> values) {
            addCriterion("UpdateID in", values, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidNotIn(List<Integer> values) {
            addCriterion("UpdateID not in", values, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidBetween(Integer value1, Integer value2) {
            addCriterion("UpdateID between", value1, value2, "updateid");
            return (Criteria) this;
        }
        public Criteria andUpdateidNotBetween(Integer value1, Integer value2) {
            addCriterion("UpdateID not between", value1, value2, "updateid");
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
        
        //扩展方法
        public Criteria andHealthDiseaseIn(List<Integer> values) {
            addCriterion("tb_healtheducation_disease.msdiseaseid in", values, "msdiseaseid");
            return (Criteria) this;
        }
        public Criteria andHealthDiseaseEqualTo(Integer values) {
            addCriterion("tb_healtheducation_disease.msdiseaseid =", values, "msdiseaseid");
            return (Criteria) this;
        }
        
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * [3.0]健教库
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