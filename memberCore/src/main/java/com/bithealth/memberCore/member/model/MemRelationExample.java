/*
 * MemRelationExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-30 Created
 */
package com.bithealth.memberCore.member.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bithealth.memberCore.enmu.MemberSource;


public class MemRelationExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public MemRelationExample() {
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
     * 会员档案关联信息表
     * 
     * @author ${user}
     * @version 1.0 2016-06-30
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
        public Criteria andUniqueIdIsNull() {
            addCriterion("unique_id is null");
            return (Criteria) this;
        }
        public Criteria andUniqueIdIsNotNull() {
            addCriterion("unique_id is not null");
            return (Criteria) this;
        }
        public Criteria andUniqueIdEqualTo(String value) {
            addCriterion("unique_id =", value, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdNotEqualTo(String value) {
            addCriterion("unique_id <>", value, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdGreaterThan(String value) {
            addCriterion("unique_id >", value, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdGreaterThanOrEqualTo(String value) {
            addCriterion("unique_id >=", value, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdLessThan(String value) {
            addCriterion("unique_id <", value, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdLessThanOrEqualTo(String value) {
            addCriterion("unique_id <=", value, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdLike(String value) {
            addCriterion("unique_id like", value, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdNotLike(String value) {
            addCriterion("unique_id not like", value, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdIn(List<String> values) {
            addCriterion("unique_id in", values, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdNotIn(List<String> values) {
            addCriterion("unique_id not in", values, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdBetween(String value1, String value2) {
            addCriterion("unique_id between", value1, value2, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andUniqueIdNotBetween(String value1, String value2) {
            addCriterion("unique_id not between", value1, value2, "uniqueId");
            return (Criteria) this;
        }
        public Criteria andLogogramIsNull() {
            addCriterion("logogram is null");
            return (Criteria) this;
        }
        public Criteria andLogogramIsNotNull() {
            addCriterion("logogram is not null");
            return (Criteria) this;
        }
        public Criteria andLogogramEqualTo(String value) {
            addCriterion("logogram =", value, "logogram");
            return (Criteria) this;
        }
        public Criteria andLogogramNotEqualTo(String value) {
            addCriterion("logogram <>", value, "logogram");
            return (Criteria) this;
        }
        public Criteria andLogogramGreaterThan(String value) {
            addCriterion("logogram >", value, "logogram");
            return (Criteria) this;
        }
        public Criteria andLogogramGreaterThanOrEqualTo(String value) {
            addCriterion("logogram >=", value, "logogram");
            return (Criteria) this;
        }
        public Criteria andLogogramLessThan(String value) {
            addCriterion("logogram <", value, "logogram");
            return (Criteria) this;
        }
        public Criteria andLogogramLessThanOrEqualTo(String value) {
            addCriterion("logogram <=", value, "logogram");
            return (Criteria) this;
        }
        public Criteria andLogogramLike(String value) {
            addCriterion("logogram like", value, "logogram");
            return (Criteria) this;
        }
        public Criteria andLogogramNotLike(String value) {
            addCriterion("logogram not like", value, "logogram");
            return (Criteria) this;
        }
        public Criteria andLogogramIn(List<String> values) {
            addCriterion("logogram in", values, "logogram");
            return (Criteria) this;
        }
        public Criteria andLogogramNotIn(List<String> values) {
            addCriterion("logogram not in", values, "logogram");
            return (Criteria) this;
        }
        public Criteria andLogogramBetween(String value1, String value2) {
            addCriterion("logogram between", value1, value2, "logogram");
            return (Criteria) this;
        }
        public Criteria andLogogramNotBetween(String value1, String value2) {
            addCriterion("logogram not between", value1, value2, "logogram");
            return (Criteria) this;
        }
        public Criteria andRelationIsNull() {
            addCriterion("relation is null");
            return (Criteria) this;
        }
        public Criteria andRelationIsNotNull() {
            addCriterion("relation is not null");
            return (Criteria) this;
        }
        public Criteria andRelationEqualTo(Integer value) {
            addCriterion("relation =", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationNotEqualTo(Integer value) {
            addCriterion("relation <>", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationGreaterThan(Integer value) {
            addCriterion("relation >", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationGreaterThanOrEqualTo(Integer value) {
            addCriterion("relation >=", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationLessThan(Integer value) {
            addCriterion("relation <", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationLessThanOrEqualTo(Integer value) {
            addCriterion("relation <=", value, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationIn(List<Integer> values) {
            addCriterion("relation in", values, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationNotIn(List<Integer> values) {
            addCriterion("relation not in", values, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationBetween(Integer value1, Integer value2) {
            addCriterion("relation between", value1, value2, "relation");
            return (Criteria) this;
        }
        public Criteria andRelationNotBetween(Integer value1, Integer value2) {
            addCriterion("relation not between", value1, value2, "relation");
            return (Criteria) this;
        }
        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }
        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }
        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }
        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }
        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }
        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }
        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }
        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }
        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }
        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }
        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }
        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }
        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }
        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }
        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }
        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }
        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }
        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }
        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }
        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }
        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }
        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }
        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }
        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }
        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }
        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }
        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }
        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }
        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }
        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }
        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }
        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }
        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }
        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }
        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }
        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }
        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }
        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }
        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }
        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }
        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }
        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }
        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }
        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }
        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }
        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }
        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }
        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }
        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }
        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }
        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }
        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }
        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }
        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }
        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }
        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }
        public Criteria andVillageIsNull() {
            addCriterion("village is null");
            return (Criteria) this;
        }
        public Criteria andVillageIsNotNull() {
            addCriterion("village is not null");
            return (Criteria) this;
        }
        public Criteria andVillageEqualTo(String value) {
            addCriterion("village =", value, "village");
            return (Criteria) this;
        }
        public Criteria andVillageNotEqualTo(String value) {
            addCriterion("village <>", value, "village");
            return (Criteria) this;
        }
        public Criteria andVillageGreaterThan(String value) {
            addCriterion("village >", value, "village");
            return (Criteria) this;
        }
        public Criteria andVillageGreaterThanOrEqualTo(String value) {
            addCriterion("village >=", value, "village");
            return (Criteria) this;
        }
        public Criteria andVillageLessThan(String value) {
            addCriterion("village <", value, "village");
            return (Criteria) this;
        }
        public Criteria andVillageLessThanOrEqualTo(String value) {
            addCriterion("village <=", value, "village");
            return (Criteria) this;
        }
        public Criteria andVillageLike(String value) {
            addCriterion("village like", value, "village");
            return (Criteria) this;
        }
        public Criteria andVillageNotLike(String value) {
            addCriterion("village not like", value, "village");
            return (Criteria) this;
        }
        public Criteria andVillageIn(List<String> values) {
            addCriterion("village in", values, "village");
            return (Criteria) this;
        }
        public Criteria andVillageNotIn(List<String> values) {
            addCriterion("village not in", values, "village");
            return (Criteria) this;
        }
        public Criteria andVillageBetween(String value1, String value2) {
            addCriterion("village between", value1, value2, "village");
            return (Criteria) this;
        }
        public Criteria andVillageNotBetween(String value1, String value2) {
            addCriterion("village not between", value1, value2, "village");
            return (Criteria) this;
        }
        public Criteria andNeighborhoodCommitteeIsNull() {
            addCriterion("neighborhood_committee is null");
            return (Criteria) this;
        }
        public Criteria andNeighborhoodCommitteeIsNotNull() {
            addCriterion("neighborhood_committee is not null");
            return (Criteria) this;
        }
        public Criteria andNeighborhoodCommitteeEqualTo(String value) {
            addCriterion("neighborhood_committee =", value, "neighborhoodCommittee");
            return (Criteria) this;
        }
        public Criteria andNeighborhoodCommitteeNotEqualTo(String value) {
            addCriterion("neighborhood_committee <>", value, "neighborhoodCommittee");
            return (Criteria) this;
        }
        public Criteria andNeighborhoodCommitteeGreaterThan(String value) {
            addCriterion("neighborhood_committee >", value, "neighborhoodCommittee");
            return (Criteria) this;
        }
        public Criteria andNeighborhoodCommitteeGreaterThanOrEqualTo(String value) {
            addCriterion("neighborhood_committee >=", value, "neighborhoodCommittee");
            return (Criteria) this;
        }
        public Criteria andNeighborhoodCommitteeLessThan(String value) {
            addCriterion("neighborhood_committee <", value, "neighborhoodCommittee");
            return (Criteria) this;
        }
        public Criteria andNeighborhoodCommitteeLessThanOrEqualTo(String value) {
            addCriterion("neighborhood_committee <=", value, "neighborhoodCommittee");
            return (Criteria) this;
        }
        public Criteria andNeighborhoodCommitteeLike(String value) {
            addCriterion("neighborhood_committee like", value, "neighborhoodCommittee");
            return (Criteria) this;
        }
        public Criteria andNeighborhoodCommitteeNotLike(String value) {
            addCriterion("neighborhood_committee not like", value, "neighborhoodCommittee");
            return (Criteria) this;
        }
        public Criteria andNeighborhoodCommitteeIn(List<String> values) {
            addCriterion("neighborhood_committee in", values, "neighborhoodCommittee");
            return (Criteria) this;
        }
        public Criteria andNeighborhoodCommitteeNotIn(List<String> values) {
            addCriterion("neighborhood_committee not in", values, "neighborhoodCommittee");
            return (Criteria) this;
        }
        public Criteria andNeighborhoodCommitteeBetween(String value1, String value2) {
            addCriterion("neighborhood_committee between", value1, value2, "neighborhoodCommittee");
            return (Criteria) this;
        }
        public Criteria andNeighborhoodCommitteeNotBetween(String value1, String value2) {
            addCriterion("neighborhood_committee not between", value1, value2, "neighborhoodCommittee");
            return (Criteria) this;
        }
        public Criteria andLiveStatusIsNull() {
            addCriterion("live_status is null");
            return (Criteria) this;
        }
        public Criteria andLiveStatusIsNotNull() {
            addCriterion("live_status is not null");
            return (Criteria) this;
        }
        public Criteria andLiveStatusEqualTo(Integer value) {
            addCriterion("live_status =", value, "liveStatus");
            return (Criteria) this;
        }
        public Criteria andLiveStatusNotEqualTo(Integer value) {
            addCriterion("live_status <>", value, "liveStatus");
            return (Criteria) this;
        }
        public Criteria andLiveStatusGreaterThan(Integer value) {
            addCriterion("live_status >", value, "liveStatus");
            return (Criteria) this;
        }
        public Criteria andLiveStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("live_status >=", value, "liveStatus");
            return (Criteria) this;
        }
        public Criteria andLiveStatusLessThan(Integer value) {
            addCriterion("live_status <", value, "liveStatus");
            return (Criteria) this;
        }
        public Criteria andLiveStatusLessThanOrEqualTo(Integer value) {
            addCriterion("live_status <=", value, "liveStatus");
            return (Criteria) this;
        }
        public Criteria andLiveStatusIn(List<Integer> values) {
            addCriterion("live_status in", values, "liveStatus");
            return (Criteria) this;
        }
        public Criteria andLiveStatusNotIn(List<Integer> values) {
            addCriterion("live_status not in", values, "liveStatus");
            return (Criteria) this;
        }
        public Criteria andLiveStatusBetween(Integer value1, Integer value2) {
            addCriterion("live_status between", value1, value2, "liveStatus");
            return (Criteria) this;
        }
        public Criteria andLiveStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("live_status not between", value1, value2, "liveStatus");
            return (Criteria) this;
        }
        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }
        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }
        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }
        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }
        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }
        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }
        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }
        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }
        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }
        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }
        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }
        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }
        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }
        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }
        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }
        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }
        public Criteria andPayTypeEqualTo(Integer value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }
        public Criteria andPayTypeNotEqualTo(Integer value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }
        public Criteria andPayTypeGreaterThan(Integer value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }
        public Criteria andPayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }
        public Criteria andPayTypeLessThan(Integer value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }
        public Criteria andPayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }
        public Criteria andPayTypeIn(List<Integer> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }
        public Criteria andPayTypeNotIn(List<Integer> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }
        public Criteria andPayTypeBetween(Integer value1, Integer value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }
        public Criteria andPayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }
        public Criteria andMedicalAccountIsNull() {
            addCriterion("medical_account is null");
            return (Criteria) this;
        }
        public Criteria andMedicalAccountIsNotNull() {
            addCriterion("medical_account is not null");
            return (Criteria) this;
        }
        public Criteria andMedicalAccountEqualTo(String value) {
            addCriterion("medical_account =", value, "medicalAccount");
            return (Criteria) this;
        }
        public Criteria andMedicalAccountNotEqualTo(String value) {
            addCriterion("medical_account <>", value, "medicalAccount");
            return (Criteria) this;
        }
        public Criteria andMedicalAccountGreaterThan(String value) {
            addCriterion("medical_account >", value, "medicalAccount");
            return (Criteria) this;
        }
        public Criteria andMedicalAccountGreaterThanOrEqualTo(String value) {
            addCriterion("medical_account >=", value, "medicalAccount");
            return (Criteria) this;
        }
        public Criteria andMedicalAccountLessThan(String value) {
            addCriterion("medical_account <", value, "medicalAccount");
            return (Criteria) this;
        }
        public Criteria andMedicalAccountLessThanOrEqualTo(String value) {
            addCriterion("medical_account <=", value, "medicalAccount");
            return (Criteria) this;
        }
        public Criteria andMedicalAccountLike(String value) {
            addCriterion("medical_account like", value, "medicalAccount");
            return (Criteria) this;
        }
        public Criteria andMedicalAccountNotLike(String value) {
            addCriterion("medical_account not like", value, "medicalAccount");
            return (Criteria) this;
        }
        public Criteria andMedicalAccountIn(List<String> values) {
            addCriterion("medical_account in", values, "medicalAccount");
            return (Criteria) this;
        }
        public Criteria andMedicalAccountNotIn(List<String> values) {
            addCriterion("medical_account not in", values, "medicalAccount");
            return (Criteria) this;
        }
        public Criteria andMedicalAccountBetween(String value1, String value2) {
            addCriterion("medical_account between", value1, value2, "medicalAccount");
            return (Criteria) this;
        }
        public Criteria andMedicalAccountNotBetween(String value1, String value2) {
            addCriterion("medical_account not between", value1, value2, "medicalAccount");
            return (Criteria) this;
        }
        public Criteria andAgroAccountIsNull() {
            addCriterion("agro_account is null");
            return (Criteria) this;
        }
        public Criteria andAgroAccountIsNotNull() {
            addCriterion("agro_account is not null");
            return (Criteria) this;
        }
        public Criteria andAgroAccountEqualTo(String value) {
            addCriterion("agro_account =", value, "agroAccount");
            return (Criteria) this;
        }
        public Criteria andAgroAccountNotEqualTo(String value) {
            addCriterion("agro_account <>", value, "agroAccount");
            return (Criteria) this;
        }
        public Criteria andAgroAccountGreaterThan(String value) {
            addCriterion("agro_account >", value, "agroAccount");
            return (Criteria) this;
        }
        public Criteria andAgroAccountGreaterThanOrEqualTo(String value) {
            addCriterion("agro_account >=", value, "agroAccount");
            return (Criteria) this;
        }
        public Criteria andAgroAccountLessThan(String value) {
            addCriterion("agro_account <", value, "agroAccount");
            return (Criteria) this;
        }
        public Criteria andAgroAccountLessThanOrEqualTo(String value) {
            addCriterion("agro_account <=", value, "agroAccount");
            return (Criteria) this;
        }
        public Criteria andAgroAccountLike(String value) {
            addCriterion("agro_account like", value, "agroAccount");
            return (Criteria) this;
        }
        public Criteria andAgroAccountNotLike(String value) {
            addCriterion("agro_account not like", value, "agroAccount");
            return (Criteria) this;
        }
        public Criteria andAgroAccountIn(List<String> values) {
            addCriterion("agro_account in", values, "agroAccount");
            return (Criteria) this;
        }
        public Criteria andAgroAccountNotIn(List<String> values) {
            addCriterion("agro_account not in", values, "agroAccount");
            return (Criteria) this;
        }
        public Criteria andAgroAccountBetween(String value1, String value2) {
            addCriterion("agro_account between", value1, value2, "agroAccount");
            return (Criteria) this;
        }
        public Criteria andAgroAccountNotBetween(String value1, String value2) {
            addCriterion("agro_account not between", value1, value2, "agroAccount");
            return (Criteria) this;
        }
        public Criteria andSurveyTimeIsNull() {
            addCriterion("survey_time is null");
            return (Criteria) this;
        }
        public Criteria andSurveyTimeIsNotNull() {
            addCriterion("survey_time is not null");
            return (Criteria) this;
        }
        public Criteria andSurveyTimeEqualTo(Date value) {
            addCriterion("survey_time =", value, "surveyTime");
            return (Criteria) this;
        }
        public Criteria andSurveyTimeNotEqualTo(Date value) {
            addCriterion("survey_time <>", value, "surveyTime");
            return (Criteria) this;
        }
        public Criteria andSurveyTimeGreaterThan(Date value) {
            addCriterion("survey_time >", value, "surveyTime");
            return (Criteria) this;
        }
        public Criteria andSurveyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("survey_time >=", value, "surveyTime");
            return (Criteria) this;
        }
        public Criteria andSurveyTimeLessThan(Date value) {
            addCriterion("survey_time <", value, "surveyTime");
            return (Criteria) this;
        }
        public Criteria andSurveyTimeLessThanOrEqualTo(Date value) {
            addCriterion("survey_time <=", value, "surveyTime");
            return (Criteria) this;
        }
        public Criteria andSurveyTimeIn(List<Date> values) {
            addCriterion("survey_time in", values, "surveyTime");
            return (Criteria) this;
        }
        public Criteria andSurveyTimeNotIn(List<Date> values) {
            addCriterion("survey_time not in", values, "surveyTime");
            return (Criteria) this;
        }
        public Criteria andSurveyTimeBetween(Date value1, Date value2) {
            addCriterion("survey_time between", value1, value2, "surveyTime");
            return (Criteria) this;
        }
        public Criteria andSurveyTimeNotBetween(Date value1, Date value2) {
            addCriterion("survey_time not between", value1, value2, "surveyTime");
            return (Criteria) this;
        }
        public Criteria andFetationStatusIsNull() {
            addCriterion("fetation_status is null");
            return (Criteria) this;
        }
        public Criteria andFetationStatusIsNotNull() {
            addCriterion("fetation_status is not null");
            return (Criteria) this;
        }
        public Criteria andFetationStatusEqualTo(Integer value) {
            addCriterion("fetation_status =", value, "fetationStatus");
            return (Criteria) this;
        }
        public Criteria andFetationStatusNotEqualTo(Integer value) {
            addCriterion("fetation_status <>", value, "fetationStatus");
            return (Criteria) this;
        }
        public Criteria andFetationStatusGreaterThan(Integer value) {
            addCriterion("fetation_status >", value, "fetationStatus");
            return (Criteria) this;
        }
        public Criteria andFetationStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("fetation_status >=", value, "fetationStatus");
            return (Criteria) this;
        }
        public Criteria andFetationStatusLessThan(Integer value) {
            addCriterion("fetation_status <", value, "fetationStatus");
            return (Criteria) this;
        }
        public Criteria andFetationStatusLessThanOrEqualTo(Integer value) {
            addCriterion("fetation_status <=", value, "fetationStatus");
            return (Criteria) this;
        }
        public Criteria andFetationStatusIn(List<Integer> values) {
            addCriterion("fetation_status in", values, "fetationStatus");
            return (Criteria) this;
        }
        public Criteria andFetationStatusNotIn(List<Integer> values) {
            addCriterion("fetation_status not in", values, "fetationStatus");
            return (Criteria) this;
        }
        public Criteria andFetationStatusBetween(Integer value1, Integer value2) {
            addCriterion("fetation_status between", value1, value2, "fetationStatus");
            return (Criteria) this;
        }
        public Criteria andFetationStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("fetation_status not between", value1, value2, "fetationStatus");
            return (Criteria) this;
        }
        public Criteria andCertificateTypeIsNull() {
            addCriterion("certificate_type is null");
            return (Criteria) this;
        }
        public Criteria andCertificateTypeIsNotNull() {
            addCriterion("certificate_type is not null");
            return (Criteria) this;
        }
        public Criteria andCertificateTypeEqualTo(Integer value) {
            addCriterion("certificate_type =", value, "certificateType");
            return (Criteria) this;
        }
        public Criteria andCertificateTypeNotEqualTo(Integer value) {
            addCriterion("certificate_type <>", value, "certificateType");
            return (Criteria) this;
        }
        public Criteria andCertificateTypeGreaterThan(Integer value) {
            addCriterion("certificate_type >", value, "certificateType");
            return (Criteria) this;
        }
        public Criteria andCertificateTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("certificate_type >=", value, "certificateType");
            return (Criteria) this;
        }
        public Criteria andCertificateTypeLessThan(Integer value) {
            addCriterion("certificate_type <", value, "certificateType");
            return (Criteria) this;
        }
        public Criteria andCertificateTypeLessThanOrEqualTo(Integer value) {
            addCriterion("certificate_type <=", value, "certificateType");
            return (Criteria) this;
        }
        public Criteria andCertificateTypeIn(List<Integer> values) {
            addCriterion("certificate_type in", values, "certificateType");
            return (Criteria) this;
        }
        public Criteria andCertificateTypeNotIn(List<Integer> values) {
            addCriterion("certificate_type not in", values, "certificateType");
            return (Criteria) this;
        }
        public Criteria andCertificateTypeBetween(Integer value1, Integer value2) {
            addCriterion("certificate_type between", value1, value2, "certificateType");
            return (Criteria) this;
        }
        public Criteria andCertificateTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("certificate_type not between", value1, value2, "certificateType");
            return (Criteria) this;
        }
        public Criteria andFileTypeIsNull() {
            addCriterion("file_type is null");
            return (Criteria) this;
        }
        public Criteria andFileTypeIsNotNull() {
            addCriterion("file_type is not null");
            return (Criteria) this;
        }
        public Criteria andFileTypeEqualTo(Integer value) {
            addCriterion("file_type =", value, "fileType");
            return (Criteria) this;
        }
        public Criteria andFileTypeNotEqualTo(Integer value) {
            addCriterion("file_type <>", value, "fileType");
            return (Criteria) this;
        }
        public Criteria andFileTypeGreaterThan(Integer value) {
            addCriterion("file_type >", value, "fileType");
            return (Criteria) this;
        }
        public Criteria andFileTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_type >=", value, "fileType");
            return (Criteria) this;
        }
        public Criteria andFileTypeLessThan(Integer value) {
            addCriterion("file_type <", value, "fileType");
            return (Criteria) this;
        }
        public Criteria andFileTypeLessThanOrEqualTo(Integer value) {
            addCriterion("file_type <=", value, "fileType");
            return (Criteria) this;
        }
        public Criteria andFileTypeIn(List<Integer> values) {
            addCriterion("file_type in", values, "fileType");
            return (Criteria) this;
        }
        public Criteria andFileTypeNotIn(List<Integer> values) {
            addCriterion("file_type not in", values, "fileType");
            return (Criteria) this;
        }
        public Criteria andFileTypeBetween(Integer value1, Integer value2) {
            addCriterion("file_type between", value1, value2, "fileType");
            return (Criteria) this;
        }
        public Criteria andFileTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("file_type not between", value1, value2, "fileType");
            return (Criteria) this;
        }
        public Criteria andFileStatusIsNull() {
            addCriterion("file_status is null");
            return (Criteria) this;
        }
        public Criteria andFileStatusIsNotNull() {
            addCriterion("file_status is not null");
            return (Criteria) this;
        }
        public Criteria andFileStatusEqualTo(Integer value) {
            addCriterion("file_status =", value, "fileStatus");
            return (Criteria) this;
        }
        public Criteria andFileStatusNotEqualTo(Integer value) {
            addCriterion("file_status <>", value, "fileStatus");
            return (Criteria) this;
        }
        public Criteria andFileStatusGreaterThan(Integer value) {
            addCriterion("file_status >", value, "fileStatus");
            return (Criteria) this;
        }
        public Criteria andFileStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_status >=", value, "fileStatus");
            return (Criteria) this;
        }
        public Criteria andFileStatusLessThan(Integer value) {
            addCriterion("file_status <", value, "fileStatus");
            return (Criteria) this;
        }
        public Criteria andFileStatusLessThanOrEqualTo(Integer value) {
            addCriterion("file_status <=", value, "fileStatus");
            return (Criteria) this;
        }
        public Criteria andFileStatusIn(List<Integer> values) {
            addCriterion("file_status in", values, "fileStatus");
            return (Criteria) this;
        }
        public Criteria andFileStatusNotIn(List<Integer> values) {
            addCriterion("file_status not in", values, "fileStatus");
            return (Criteria) this;
        }
        public Criteria andFileStatusBetween(Integer value1, Integer value2) {
            addCriterion("file_status between", value1, value2, "fileStatus");
            return (Criteria) this;
        }
        public Criteria andFileStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("file_status not between", value1, value2, "fileStatus");
            return (Criteria) this;
        }
        public Criteria andPrgidIsNull() {
            addCriterion("prgid is null");
            return (Criteria) this;
        }
        public Criteria andPrgidIsNotNull() {
            addCriterion("prgid is not null");
            return (Criteria) this;
        }
        public Criteria andPrgidEqualTo(String value) {
            addCriterion("prgid =", value, "prgid");
            return (Criteria) this;
        }
        public Criteria andPrgidNotEqualTo(String value) {
            addCriterion("prgid <>", value, "prgid");
            return (Criteria) this;
        }
        public Criteria andPrgidGreaterThan(String value) {
            addCriterion("prgid >", value, "prgid");
            return (Criteria) this;
        }
        public Criteria andPrgidGreaterThanOrEqualTo(String value) {
            addCriterion("prgid >=", value, "prgid");
            return (Criteria) this;
        }
        public Criteria andPrgidLessThan(String value) {
            addCriterion("prgid <", value, "prgid");
            return (Criteria) this;
        }
        public Criteria andPrgidLessThanOrEqualTo(String value) {
            addCriterion("prgid <=", value, "prgid");
            return (Criteria) this;
        }
        public Criteria andPrgidLike(String value) {
            addCriterion("prgid like", value, "prgid");
            return (Criteria) this;
        }
        public Criteria andPrgidNotLike(String value) {
            addCriterion("prgid not like", value, "prgid");
            return (Criteria) this;
        }
        public Criteria andPrgidIn(List<String> values) {
            addCriterion("prgid in", values, "prgid");
            return (Criteria) this;
        }
        public Criteria andPrgidNotIn(List<String> values) {
            addCriterion("prgid not in", values, "prgid");
            return (Criteria) this;
        }
        public Criteria andPrgidBetween(String value1, String value2) {
            addCriterion("prgid between", value1, value2, "prgid");
            return (Criteria) this;
        }
        public Criteria andPrgidNotBetween(String value1, String value2) {
            addCriterion("prgid not between", value1, value2, "prgid");
            return (Criteria) this;
        }
        public Criteria andOtherPayIsNull() {
            addCriterion("other_pay is null");
            return (Criteria) this;
        }
        public Criteria andOtherPayIsNotNull() {
            addCriterion("other_pay is not null");
            return (Criteria) this;
        }
        public Criteria andOtherPayEqualTo(String value) {
            addCriterion("other_pay =", value, "otherPay");
            return (Criteria) this;
        }
        public Criteria andOtherPayNotEqualTo(String value) {
            addCriterion("other_pay <>", value, "otherPay");
            return (Criteria) this;
        }
        public Criteria andOtherPayGreaterThan(String value) {
            addCriterion("other_pay >", value, "otherPay");
            return (Criteria) this;
        }
        public Criteria andOtherPayGreaterThanOrEqualTo(String value) {
            addCriterion("other_pay >=", value, "otherPay");
            return (Criteria) this;
        }
        public Criteria andOtherPayLessThan(String value) {
            addCriterion("other_pay <", value, "otherPay");
            return (Criteria) this;
        }
        public Criteria andOtherPayLessThanOrEqualTo(String value) {
            addCriterion("other_pay <=", value, "otherPay");
            return (Criteria) this;
        }
        public Criteria andOtherPayLike(String value) {
            addCriterion("other_pay like", value, "otherPay");
            return (Criteria) this;
        }
        public Criteria andOtherPayNotLike(String value) {
            addCriterion("other_pay not like", value, "otherPay");
            return (Criteria) this;
        }
        public Criteria andOtherPayIn(List<String> values) {
            addCriterion("other_pay in", values, "otherPay");
            return (Criteria) this;
        }
        public Criteria andOtherPayNotIn(List<String> values) {
            addCriterion("other_pay not in", values, "otherPay");
            return (Criteria) this;
        }
        public Criteria andOtherPayBetween(String value1, String value2) {
            addCriterion("other_pay between", value1, value2, "otherPay");
            return (Criteria) this;
        }
        public Criteria andOtherPayNotBetween(String value1, String value2) {
            addCriterion("other_pay not between", value1, value2, "otherPay");
            return (Criteria) this;
        }
        public Criteria andFamilyCodeIsNull() {
            addCriterion("family_code is null");
            return (Criteria) this;
        }
        public Criteria andFamilyCodeIsNotNull() {
            addCriterion("family_code is not null");
            return (Criteria) this;
        }
        public Criteria andFamilyCodeEqualTo(String value) {
            addCriterion("family_code =", value, "familyCode");
            return (Criteria) this;
        }
        public Criteria andFamilyCodeNotEqualTo(String value) {
            addCriterion("family_code <>", value, "familyCode");
            return (Criteria) this;
        }
        public Criteria andFamilyCodeGreaterThan(String value) {
            addCriterion("family_code >", value, "familyCode");
            return (Criteria) this;
        }
        public Criteria andFamilyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("family_code >=", value, "familyCode");
            return (Criteria) this;
        }
        public Criteria andFamilyCodeLessThan(String value) {
            addCriterion("family_code <", value, "familyCode");
            return (Criteria) this;
        }
        public Criteria andFamilyCodeLessThanOrEqualTo(String value) {
            addCriterion("family_code <=", value, "familyCode");
            return (Criteria) this;
        }
        public Criteria andFamilyCodeLike(String value) {
            addCriterion("family_code like", value, "familyCode");
            return (Criteria) this;
        }
        public Criteria andFamilyCodeNotLike(String value) {
            addCriterion("family_code not like", value, "familyCode");
            return (Criteria) this;
        }
        public Criteria andFamilyCodeIn(List<String> values) {
            addCriterion("family_code in", values, "familyCode");
            return (Criteria) this;
        }
        public Criteria andFamilyCodeNotIn(List<String> values) {
            addCriterion("family_code not in", values, "familyCode");
            return (Criteria) this;
        }
        public Criteria andFamilyCodeBetween(String value1, String value2) {
            addCriterion("family_code between", value1, value2, "familyCode");
            return (Criteria) this;
        }
        public Criteria andFamilyCodeNotBetween(String value1, String value2) {
            addCriterion("family_code not between", value1, value2, "familyCode");
            return (Criteria) this;
        }
        public Criteria andBelongAreaIsNull() {
            addCriterion("belong_area is null");
            return (Criteria) this;
        }
        public Criteria andBelongAreaIsNotNull() {
            addCriterion("belong_area is not null");
            return (Criteria) this;
        }
        public Criteria andBelongAreaEqualTo(String value) {
            addCriterion("belong_area =", value, "belongArea");
            return (Criteria) this;
        }
        public Criteria andBelongAreaNotEqualTo(String value) {
            addCriterion("belong_area <>", value, "belongArea");
            return (Criteria) this;
        }
        public Criteria andBelongAreaGreaterThan(String value) {
            addCriterion("belong_area >", value, "belongArea");
            return (Criteria) this;
        }
        public Criteria andBelongAreaGreaterThanOrEqualTo(String value) {
            addCriterion("belong_area >=", value, "belongArea");
            return (Criteria) this;
        }
        public Criteria andBelongAreaLessThan(String value) {
            addCriterion("belong_area <", value, "belongArea");
            return (Criteria) this;
        }
        public Criteria andBelongAreaLessThanOrEqualTo(String value) {
            addCriterion("belong_area <=", value, "belongArea");
            return (Criteria) this;
        }
        public Criteria andBelongAreaLike(String value) {
            addCriterion("belong_area like", value, "belongArea");
            return (Criteria) this;
        }
        public Criteria andBelongAreaNotLike(String value) {
            addCriterion("belong_area not like", value, "belongArea");
            return (Criteria) this;
        }
        public Criteria andBelongAreaIn(List<String> values) {
            addCriterion("belong_area in", values, "belongArea");
            return (Criteria) this;
        }
        public Criteria andBelongAreaNotIn(List<String> values) {
            addCriterion("belong_area not in", values, "belongArea");
            return (Criteria) this;
        }
        public Criteria andBelongAreaBetween(String value1, String value2) {
            addCriterion("belong_area between", value1, value2, "belongArea");
            return (Criteria) this;
        }
        public Criteria andBelongAreaNotBetween(String value1, String value2) {
            addCriterion("belong_area not between", value1, value2, "belongArea");
            return (Criteria) this;
        }
        public Criteria andFileStatusDescIsNull() {
            addCriterion("file_status_desc is null");
            return (Criteria) this;
        }
        public Criteria andFileStatusDescIsNotNull() {
            addCriterion("file_status_desc is not null");
            return (Criteria) this;
        }
        public Criteria andFileStatusDescEqualTo(Integer value) {
            addCriterion("file_status_desc =", value, "fileStatusDesc");
            return (Criteria) this;
        }
        public Criteria andFileStatusDescNotEqualTo(Integer value) {
            addCriterion("file_status_desc <>", value, "fileStatusDesc");
            return (Criteria) this;
        }
        public Criteria andFileStatusDescGreaterThan(Integer value) {
            addCriterion("file_status_desc >", value, "fileStatusDesc");
            return (Criteria) this;
        }
        public Criteria andFileStatusDescGreaterThanOrEqualTo(Integer value) {
            addCriterion("file_status_desc >=", value, "fileStatusDesc");
            return (Criteria) this;
        }
        public Criteria andFileStatusDescLessThan(Integer value) {
            addCriterion("file_status_desc <", value, "fileStatusDesc");
            return (Criteria) this;
        }
        public Criteria andFileStatusDescLessThanOrEqualTo(Integer value) {
            addCriterion("file_status_desc <=", value, "fileStatusDesc");
            return (Criteria) this;
        }
        public Criteria andFileStatusDescIn(List<Integer> values) {
            addCriterion("file_status_desc in", values, "fileStatusDesc");
            return (Criteria) this;
        }
        public Criteria andFileStatusDescNotIn(List<Integer> values) {
            addCriterion("file_status_desc not in", values, "fileStatusDesc");
            return (Criteria) this;
        }
        public Criteria andFileStatusDescBetween(Integer value1, Integer value2) {
            addCriterion("file_status_desc between", value1, value2, "fileStatusDesc");
            return (Criteria) this;
        }
        public Criteria andFileStatusDescNotBetween(Integer value1, Integer value2) {
            addCriterion("file_status_desc not between", value1, value2, "fileStatusDesc");
            return (Criteria) this;
        }
        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }
        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }
        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }
        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }
        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }
        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }
        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }
        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }
        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }
        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }
        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }
        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }
        public Criteria andSourceEqualsTo(MemberSource source) {
        	if(source != null) {
        		addCriterion("EXISTS (SELECT 1 FROM omem o WHERE o.`unique_id` =  unique_id AND o.`source`=" + source.getCode() + ")");
        	}
        	return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 会员档案关联信息表
     * 
     * @author ${user}
     * @version 1.0 2016-06-30
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