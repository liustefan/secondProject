/*
 * CareInfoExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-09-05 Created
 */
package com.bithealth.centCore.care.model;

import java.util.ArrayList;
import java.util.List;

public class CareInfoExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public CareInfoExample() {
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
     * [1.1]关注表
     * 
     * @author ${user}
     * @version 1.0 2016-09-05
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
        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }
        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }
        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }
        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }
        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }
        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }
        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }
        public Criteria andFocusTypeIsNull() {
            addCriterion("focusType is null");
            return (Criteria) this;
        }
        public Criteria andFocusTypeIsNotNull() {
            addCriterion("focusType is not null");
            return (Criteria) this;
        }
        public Criteria andFocusTypeEqualTo(Integer value) {
            addCriterion("focusType =", value, "focusType");
            return (Criteria) this;
        }
        public Criteria andFocusTypeNotEqualTo(Integer value) {
            addCriterion("focusType <>", value, "focusType");
            return (Criteria) this;
        }
        public Criteria andFocusTypeGreaterThan(Integer value) {
            addCriterion("focusType >", value, "focusType");
            return (Criteria) this;
        }
        public Criteria andFocusTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("focusType >=", value, "focusType");
            return (Criteria) this;
        }
        public Criteria andFocusTypeLessThan(Integer value) {
            addCriterion("focusType <", value, "focusType");
            return (Criteria) this;
        }
        public Criteria andFocusTypeLessThanOrEqualTo(Integer value) {
            addCriterion("focusType <=", value, "focusType");
            return (Criteria) this;
        }
        public Criteria andFocusTypeIn(List<Integer> values) {
            addCriterion("focusType in", values, "focusType");
            return (Criteria) this;
        }
        public Criteria andFocusTypeNotIn(List<Integer> values) {
            addCriterion("focusType not in", values, "focusType");
            return (Criteria) this;
        }
        public Criteria andFocusTypeBetween(Integer value1, Integer value2) {
            addCriterion("focusType between", value1, value2, "focusType");
            return (Criteria) this;
        }
        public Criteria andFocusTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("focusType not between", value1, value2, "focusType");
            return (Criteria) this;
        }
        public Criteria andMemberIdIsNull() {
            addCriterion("memberId is null");
            return (Criteria) this;
        }
        public Criteria andMemberIdIsNotNull() {
            addCriterion("memberId is not null");
            return (Criteria) this;
        }
        public Criteria andMemberIdEqualTo(Integer value) {
            addCriterion("memberId =", value, "memberId");
            return (Criteria) this;
        }
        public Criteria andMemberIdNotEqualTo(Integer value) {
            addCriterion("memberId <>", value, "memberId");
            return (Criteria) this;
        }
        public Criteria andMemberIdGreaterThan(Integer value) {
            addCriterion("memberId >", value, "memberId");
            return (Criteria) this;
        }
        public Criteria andMemberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("memberId >=", value, "memberId");
            return (Criteria) this;
        }
        public Criteria andMemberIdLessThan(Integer value) {
            addCriterion("memberId <", value, "memberId");
            return (Criteria) this;
        }
        public Criteria andMemberIdLessThanOrEqualTo(Integer value) {
            addCriterion("memberId <=", value, "memberId");
            return (Criteria) this;
        }
        public Criteria andMemberIdIn(List<Integer> values) {
            addCriterion("memberId in", values, "memberId");
            return (Criteria) this;
        }
        public Criteria andMemberIdNotIn(List<Integer> values) {
            addCriterion("memberId not in", values, "memberId");
            return (Criteria) this;
        }
        public Criteria andMemberIdBetween(Integer value1, Integer value2) {
            addCriterion("memberId between", value1, value2, "memberId");
            return (Criteria) this;
        }
        public Criteria andMemberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("memberId not between", value1, value2, "memberId");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDIsNull() {
            addCriterion("memberGUID is null");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDIsNotNull() {
            addCriterion("memberGUID is not null");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDEqualTo(String value) {
            addCriterion("memberGUID =", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDNotEqualTo(String value) {
            addCriterion("memberGUID <>", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDGreaterThan(String value) {
            addCriterion("memberGUID >", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDGreaterThanOrEqualTo(String value) {
            addCriterion("memberGUID >=", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDLessThan(String value) {
            addCriterion("memberGUID <", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDLessThanOrEqualTo(String value) {
            addCriterion("memberGUID <=", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDLike(String value) {
            addCriterion("memberGUID like", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDNotLike(String value) {
            addCriterion("memberGUID not like", value, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDIn(List<String> values) {
            addCriterion("memberGUID in", values, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDNotIn(List<String> values) {
            addCriterion("memberGUID not in", values, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDBetween(String value1, String value2) {
            addCriterion("memberGUID between", value1, value2, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andMemberGUIDNotBetween(String value1, String value2) {
            addCriterion("memberGUID not between", value1, value2, "memberGUID");
            return (Criteria) this;
        }
        public Criteria andFocusIdIsNull() {
            addCriterion("focusId is null");
            return (Criteria) this;
        }
        public Criteria andFocusIdIsNotNull() {
            addCriterion("focusId is not null");
            return (Criteria) this;
        }
        public Criteria andFocusIdEqualTo(Integer value) {
            addCriterion("focusId =", value, "focusId");
            return (Criteria) this;
        }
        public Criteria andFocusIdNotEqualTo(Integer value) {
            addCriterion("focusId <>", value, "focusId");
            return (Criteria) this;
        }
        public Criteria andFocusIdGreaterThan(Integer value) {
            addCriterion("focusId >", value, "focusId");
            return (Criteria) this;
        }
        public Criteria andFocusIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("focusId >=", value, "focusId");
            return (Criteria) this;
        }
        public Criteria andFocusIdLessThan(Integer value) {
            addCriterion("focusId <", value, "focusId");
            return (Criteria) this;
        }
        public Criteria andFocusIdLessThanOrEqualTo(Integer value) {
            addCriterion("focusId <=", value, "focusId");
            return (Criteria) this;
        }
        public Criteria andFocusIdIn(List<Integer> values) {
            addCriterion("focusId in", values, "focusId");
            return (Criteria) this;
        }
        public Criteria andFocusIdNotIn(List<Integer> values) {
            addCriterion("focusId not in", values, "focusId");
            return (Criteria) this;
        }
        public Criteria andFocusIdBetween(Integer value1, Integer value2) {
            addCriterion("focusId between", value1, value2, "focusId");
            return (Criteria) this;
        }
        public Criteria andFocusIdNotBetween(Integer value1, Integer value2) {
            addCriterion("focusId not between", value1, value2, "focusId");
            return (Criteria) this;
        }
        public Criteria andFocusGUIDIsNull() {
            addCriterion("focusGUID is null");
            return (Criteria) this;
        }
        public Criteria andFocusGUIDIsNotNull() {
            addCriterion("focusGUID is not null");
            return (Criteria) this;
        }
        public Criteria andFocusGUIDEqualTo(String value) {
            addCriterion("focusGUID =", value, "focusGUID");
            return (Criteria) this;
        }
        public Criteria andFocusGUIDNotEqualTo(String value) {
            addCriterion("focusGUID <>", value, "focusGUID");
            return (Criteria) this;
        }
        public Criteria andFocusGUIDGreaterThan(String value) {
            addCriterion("focusGUID >", value, "focusGUID");
            return (Criteria) this;
        }
        public Criteria andFocusGUIDGreaterThanOrEqualTo(String value) {
            addCriterion("focusGUID >=", value, "focusGUID");
            return (Criteria) this;
        }
        public Criteria andFocusGUIDLessThan(String value) {
            addCriterion("focusGUID <", value, "focusGUID");
            return (Criteria) this;
        }
        public Criteria andFocusGUIDLessThanOrEqualTo(String value) {
            addCriterion("focusGUID <=", value, "focusGUID");
            return (Criteria) this;
        }
        public Criteria andFocusGUIDLike(String value) {
            addCriterion("focusGUID like", value, "focusGUID");
            return (Criteria) this;
        }
        public Criteria andFocusGUIDNotLike(String value) {
            addCriterion("focusGUID not like", value, "focusGUID");
            return (Criteria) this;
        }
        public Criteria andFocusGUIDIn(List<String> values) {
            addCriterion("focusGUID in", values, "focusGUID");
            return (Criteria) this;
        }
        public Criteria andFocusGUIDNotIn(List<String> values) {
            addCriterion("focusGUID not in", values, "focusGUID");
            return (Criteria) this;
        }
        public Criteria andFocusGUIDBetween(String value1, String value2) {
            addCriterion("focusGUID between", value1, value2, "focusGUID");
            return (Criteria) this;
        }
        public Criteria andFocusGUIDNotBetween(String value1, String value2) {
            addCriterion("focusGUID not between", value1, value2, "focusGUID");
            return (Criteria) this;
        }
        public Criteria andFocusStatusIsNull() {
            addCriterion("focusStatus is null");
            return (Criteria) this;
        }
        public Criteria andFocusStatusIsNotNull() {
            addCriterion("focusStatus is not null");
            return (Criteria) this;
        }
        public Criteria andFocusStatusEqualTo(Integer value) {
            addCriterion("focusStatus =", value, "focusStatus");
            return (Criteria) this;
        }
        public Criteria andFocusStatusNotEqualTo(Integer value) {
            addCriterion("focusStatus <>", value, "focusStatus");
            return (Criteria) this;
        }
        public Criteria andFocusStatusGreaterThan(Integer value) {
            addCriterion("focusStatus >", value, "focusStatus");
            return (Criteria) this;
        }
        public Criteria andFocusStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("focusStatus >=", value, "focusStatus");
            return (Criteria) this;
        }
        public Criteria andFocusStatusLessThan(Integer value) {
            addCriterion("focusStatus <", value, "focusStatus");
            return (Criteria) this;
        }
        public Criteria andFocusStatusLessThanOrEqualTo(Integer value) {
            addCriterion("focusStatus <=", value, "focusStatus");
            return (Criteria) this;
        }
        public Criteria andFocusStatusIn(List<Integer> values) {
            addCriterion("focusStatus in", values, "focusStatus");
            return (Criteria) this;
        }
        public Criteria andFocusStatusNotIn(List<Integer> values) {
            addCriterion("focusStatus not in", values, "focusStatus");
            return (Criteria) this;
        }
        public Criteria andFocusStatusBetween(Integer value1, Integer value2) {
            addCriterion("focusStatus between", value1, value2, "focusStatus");
            return (Criteria) this;
        }
        public Criteria andFocusStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("focusStatus not between", value1, value2, "focusStatus");
            return (Criteria) this;
        }
        public Criteria andFocusPIsNull() {
            addCriterion("focusP is null");
            return (Criteria) this;
        }
        public Criteria andFocusPIsNotNull() {
            addCriterion("focusP is not null");
            return (Criteria) this;
        }
        public Criteria andFocusPEqualTo(String value) {
            addCriterion("focusP =", value, "focusP");
            return (Criteria) this;
        }
        public Criteria andFocusPNotEqualTo(String value) {
            addCriterion("focusP <>", value, "focusP");
            return (Criteria) this;
        }
        public Criteria andFocusPGreaterThan(String value) {
            addCriterion("focusP >", value, "focusP");
            return (Criteria) this;
        }
        public Criteria andFocusPGreaterThanOrEqualTo(String value) {
            addCriterion("focusP >=", value, "focusP");
            return (Criteria) this;
        }
        public Criteria andFocusPLessThan(String value) {
            addCriterion("focusP <", value, "focusP");
            return (Criteria) this;
        }
        public Criteria andFocusPLessThanOrEqualTo(String value) {
            addCriterion("focusP <=", value, "focusP");
            return (Criteria) this;
        }
        public Criteria andFocusPLike(String value) {
            addCriterion("focusP like", value, "focusP");
            return (Criteria) this;
        }
        public Criteria andFocusPNotLike(String value) {
            addCriterion("focusP not like", value, "focusP");
            return (Criteria) this;
        }
        public Criteria andFocusPIn(List<String> values) {
            addCriterion("focusP in", values, "focusP");
            return (Criteria) this;
        }
        public Criteria andFocusPNotIn(List<String> values) {
            addCriterion("focusP not in", values, "focusP");
            return (Criteria) this;
        }
        public Criteria andFocusPBetween(String value1, String value2) {
            addCriterion("focusP between", value1, value2, "focusP");
            return (Criteria) this;
        }
        public Criteria andFocusPNotBetween(String value1, String value2) {
            addCriterion("focusP not between", value1, value2, "focusP");
            return (Criteria) this;
        }
        public Criteria andFocusPedIsNull() {
            addCriterion("focusPed is null");
            return (Criteria) this;
        }
        public Criteria andFocusPedIsNotNull() {
            addCriterion("focusPed is not null");
            return (Criteria) this;
        }
        public Criteria andFocusPedEqualTo(String value) {
            addCriterion("focusPed =", value, "focusPed");
            return (Criteria) this;
        }
        public Criteria andFocusPedNotEqualTo(String value) {
            addCriterion("focusPed <>", value, "focusPed");
            return (Criteria) this;
        }
        public Criteria andFocusPedGreaterThan(String value) {
            addCriterion("focusPed >", value, "focusPed");
            return (Criteria) this;
        }
        public Criteria andFocusPedGreaterThanOrEqualTo(String value) {
            addCriterion("focusPed >=", value, "focusPed");
            return (Criteria) this;
        }
        public Criteria andFocusPedLessThan(String value) {
            addCriterion("focusPed <", value, "focusPed");
            return (Criteria) this;
        }
        public Criteria andFocusPedLessThanOrEqualTo(String value) {
            addCriterion("focusPed <=", value, "focusPed");
            return (Criteria) this;
        }
        public Criteria andFocusPedLike(String value) {
            addCriterion("focusPed like", value, "focusPed");
            return (Criteria) this;
        }
        public Criteria andFocusPedNotLike(String value) {
            addCriterion("focusPed not like", value, "focusPed");
            return (Criteria) this;
        }
        public Criteria andFocusPedIn(List<String> values) {
            addCriterion("focusPed in", values, "focusPed");
            return (Criteria) this;
        }
        public Criteria andFocusPedNotIn(List<String> values) {
            addCriterion("focusPed not in", values, "focusPed");
            return (Criteria) this;
        }
        public Criteria andFocusPedBetween(String value1, String value2) {
            addCriterion("focusPed between", value1, value2, "focusPed");
            return (Criteria) this;
        }
        public Criteria andFocusPedNotBetween(String value1, String value2) {
            addCriterion("focusPed not between", value1, value2, "focusPed");
            return (Criteria) this;
        }
        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }
        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }
        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }
        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }
        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }
        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
            return (Criteria) this;
        }
        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }
        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }
        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeLike(String value) {
            addCriterion("createTime like", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("createTime not like", value, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }
        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }
        public Criteria andNewsLetterIsNull() {
            addCriterion("newsLetter is null");
            return (Criteria) this;
        }
        public Criteria andNewsLetterIsNotNull() {
            addCriterion("newsLetter is not null");
            return (Criteria) this;
        }
        public Criteria andNewsLetterEqualTo(Short value) {
            addCriterion("newsLetter =", value, "newsLetter");
            return (Criteria) this;
        }
        public Criteria andNewsLetterNotEqualTo(Short value) {
            addCriterion("newsLetter <>", value, "newsLetter");
            return (Criteria) this;
        }
        public Criteria andNewsLetterGreaterThan(Short value) {
            addCriterion("newsLetter >", value, "newsLetter");
            return (Criteria) this;
        }
        public Criteria andNewsLetterGreaterThanOrEqualTo(Short value) {
            addCriterion("newsLetter >=", value, "newsLetter");
            return (Criteria) this;
        }
        public Criteria andNewsLetterLessThan(Short value) {
            addCriterion("newsLetter <", value, "newsLetter");
            return (Criteria) this;
        }
        public Criteria andNewsLetterLessThanOrEqualTo(Short value) {
            addCriterion("newsLetter <=", value, "newsLetter");
            return (Criteria) this;
        }
        public Criteria andNewsLetterIn(List<Short> values) {
            addCriterion("newsLetter in", values, "newsLetter");
            return (Criteria) this;
        }
        public Criteria andNewsLetterNotIn(List<Short> values) {
            addCriterion("newsLetter not in", values, "newsLetter");
            return (Criteria) this;
        }
        public Criteria andNewsLetterBetween(Short value1, Short value2) {
            addCriterion("newsLetter between", value1, value2, "newsLetter");
            return (Criteria) this;
        }
        public Criteria andNewsLetterNotBetween(Short value1, Short value2) {
            addCriterion("newsLetter not between", value1, value2, "newsLetter");
            return (Criteria) this;
        }
        public Criteria andMemberRemarkIsNull() {
            addCriterion("memberRemark is null");
            return (Criteria) this;
        }
        public Criteria andMemberRemarkIsNotNull() {
            addCriterion("memberRemark is not null");
            return (Criteria) this;
        }
        public Criteria andMemberRemarkEqualTo(String value) {
            addCriterion("memberRemark =", value, "memberRemark");
            return (Criteria) this;
        }
        public Criteria andMemberRemarkNotEqualTo(String value) {
            addCriterion("memberRemark <>", value, "memberRemark");
            return (Criteria) this;
        }
        public Criteria andMemberRemarkGreaterThan(String value) {
            addCriterion("memberRemark >", value, "memberRemark");
            return (Criteria) this;
        }
        public Criteria andMemberRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("memberRemark >=", value, "memberRemark");
            return (Criteria) this;
        }
        public Criteria andMemberRemarkLessThan(String value) {
            addCriterion("memberRemark <", value, "memberRemark");
            return (Criteria) this;
        }
        public Criteria andMemberRemarkLessThanOrEqualTo(String value) {
            addCriterion("memberRemark <=", value, "memberRemark");
            return (Criteria) this;
        }
        public Criteria andMemberRemarkLike(String value) {
            addCriterion("memberRemark like", value, "memberRemark");
            return (Criteria) this;
        }
        public Criteria andMemberRemarkNotLike(String value) {
            addCriterion("memberRemark not like", value, "memberRemark");
            return (Criteria) this;
        }
        public Criteria andMemberRemarkIn(List<String> values) {
            addCriterion("memberRemark in", values, "memberRemark");
            return (Criteria) this;
        }
        public Criteria andMemberRemarkNotIn(List<String> values) {
            addCriterion("memberRemark not in", values, "memberRemark");
            return (Criteria) this;
        }
        public Criteria andMemberRemarkBetween(String value1, String value2) {
            addCriterion("memberRemark between", value1, value2, "memberRemark");
            return (Criteria) this;
        }
        public Criteria andMemberRemarkNotBetween(String value1, String value2) {
            addCriterion("memberRemark not between", value1, value2, "memberRemark");
            return (Criteria) this;
        }
        public Criteria andFocusRemarkIsNull() {
            addCriterion("focusRemark is null");
            return (Criteria) this;
        }
        public Criteria andFocusRemarkIsNotNull() {
            addCriterion("focusRemark is not null");
            return (Criteria) this;
        }
        public Criteria andFocusRemarkEqualTo(String value) {
            addCriterion("focusRemark =", value, "focusRemark");
            return (Criteria) this;
        }
        public Criteria andFocusRemarkNotEqualTo(String value) {
            addCriterion("focusRemark <>", value, "focusRemark");
            return (Criteria) this;
        }
        public Criteria andFocusRemarkGreaterThan(String value) {
            addCriterion("focusRemark >", value, "focusRemark");
            return (Criteria) this;
        }
        public Criteria andFocusRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("focusRemark >=", value, "focusRemark");
            return (Criteria) this;
        }
        public Criteria andFocusRemarkLessThan(String value) {
            addCriterion("focusRemark <", value, "focusRemark");
            return (Criteria) this;
        }
        public Criteria andFocusRemarkLessThanOrEqualTo(String value) {
            addCriterion("focusRemark <=", value, "focusRemark");
            return (Criteria) this;
        }
        public Criteria andFocusRemarkLike(String value) {
            addCriterion("focusRemark like", value, "focusRemark");
            return (Criteria) this;
        }
        public Criteria andFocusRemarkNotLike(String value) {
            addCriterion("focusRemark not like", value, "focusRemark");
            return (Criteria) this;
        }
        public Criteria andFocusRemarkIn(List<String> values) {
            addCriterion("focusRemark in", values, "focusRemark");
            return (Criteria) this;
        }
        public Criteria andFocusRemarkNotIn(List<String> values) {
            addCriterion("focusRemark not in", values, "focusRemark");
            return (Criteria) this;
        }
        public Criteria andFocusRemarkBetween(String value1, String value2) {
            addCriterion("focusRemark between", value1, value2, "focusRemark");
            return (Criteria) this;
        }
        public Criteria andFocusRemarkNotBetween(String value1, String value2) {
            addCriterion("focusRemark not between", value1, value2, "focusRemark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * [1.1]关注表
     * 
     * @author ${user}
     * @version 1.0 2016-09-05
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