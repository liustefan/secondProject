/*
 * HabitExample.java
 * Copyright(C) 2016-2026  深圳中科汇康技术有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2016-06-23 Created
 */
package com.bithealth.memberCore.member.model;

import java.util.ArrayList;
import java.util.List;

public class HabitExample {

    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria;

    public HabitExample() {
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
     * 会员习惯信息（MEM7）
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
        public Criteria andSmokingIsNull() {
            addCriterion("Smoking is null");
            return (Criteria) this;
        }
        public Criteria andSmokingIsNotNull() {
            addCriterion("Smoking is not null");
            return (Criteria) this;
        }
        public Criteria andSmokingEqualTo(String value) {
            addCriterion("Smoking =", value, "smoking");
            return (Criteria) this;
        }
        public Criteria andSmokingNotEqualTo(String value) {
            addCriterion("Smoking <>", value, "smoking");
            return (Criteria) this;
        }
        public Criteria andSmokingGreaterThan(String value) {
            addCriterion("Smoking >", value, "smoking");
            return (Criteria) this;
        }
        public Criteria andSmokingGreaterThanOrEqualTo(String value) {
            addCriterion("Smoking >=", value, "smoking");
            return (Criteria) this;
        }
        public Criteria andSmokingLessThan(String value) {
            addCriterion("Smoking <", value, "smoking");
            return (Criteria) this;
        }
        public Criteria andSmokingLessThanOrEqualTo(String value) {
            addCriterion("Smoking <=", value, "smoking");
            return (Criteria) this;
        }
        public Criteria andSmokingLike(String value) {
            addCriterion("Smoking like", value, "smoking");
            return (Criteria) this;
        }
        public Criteria andSmokingNotLike(String value) {
            addCriterion("Smoking not like", value, "smoking");
            return (Criteria) this;
        }
        public Criteria andSmokingIn(List<String> values) {
            addCriterion("Smoking in", values, "smoking");
            return (Criteria) this;
        }
        public Criteria andSmokingNotIn(List<String> values) {
            addCriterion("Smoking not in", values, "smoking");
            return (Criteria) this;
        }
        public Criteria andSmokingBetween(String value1, String value2) {
            addCriterion("Smoking between", value1, value2, "smoking");
            return (Criteria) this;
        }
        public Criteria andSmokingNotBetween(String value1, String value2) {
            addCriterion("Smoking not between", value1, value2, "smoking");
            return (Criteria) this;
        }
        public Criteria andDodrinkIsNull() {
            addCriterion("DoDrink is null");
            return (Criteria) this;
        }
        public Criteria andDodrinkIsNotNull() {
            addCriterion("DoDrink is not null");
            return (Criteria) this;
        }
        public Criteria andDodrinkEqualTo(String value) {
            addCriterion("DoDrink =", value, "dodrink");
            return (Criteria) this;
        }
        public Criteria andDodrinkNotEqualTo(String value) {
            addCriterion("DoDrink <>", value, "dodrink");
            return (Criteria) this;
        }
        public Criteria andDodrinkGreaterThan(String value) {
            addCriterion("DoDrink >", value, "dodrink");
            return (Criteria) this;
        }
        public Criteria andDodrinkGreaterThanOrEqualTo(String value) {
            addCriterion("DoDrink >=", value, "dodrink");
            return (Criteria) this;
        }
        public Criteria andDodrinkLessThan(String value) {
            addCriterion("DoDrink <", value, "dodrink");
            return (Criteria) this;
        }
        public Criteria andDodrinkLessThanOrEqualTo(String value) {
            addCriterion("DoDrink <=", value, "dodrink");
            return (Criteria) this;
        }
        public Criteria andDodrinkLike(String value) {
            addCriterion("DoDrink like", value, "dodrink");
            return (Criteria) this;
        }
        public Criteria andDodrinkNotLike(String value) {
            addCriterion("DoDrink not like", value, "dodrink");
            return (Criteria) this;
        }
        public Criteria andDodrinkIn(List<String> values) {
            addCriterion("DoDrink in", values, "dodrink");
            return (Criteria) this;
        }
        public Criteria andDodrinkNotIn(List<String> values) {
            addCriterion("DoDrink not in", values, "dodrink");
            return (Criteria) this;
        }
        public Criteria andDodrinkBetween(String value1, String value2) {
            addCriterion("DoDrink between", value1, value2, "dodrink");
            return (Criteria) this;
        }
        public Criteria andDodrinkNotBetween(String value1, String value2) {
            addCriterion("DoDrink not between", value1, value2, "dodrink");
            return (Criteria) this;
        }
        public Criteria andDontfoodIsNull() {
            addCriterion("DoNtFood is null");
            return (Criteria) this;
        }
        public Criteria andDontfoodIsNotNull() {
            addCriterion("DoNtFood is not null");
            return (Criteria) this;
        }
        public Criteria andDontfoodEqualTo(String value) {
            addCriterion("DoNtFood =", value, "dontfood");
            return (Criteria) this;
        }
        public Criteria andDontfoodNotEqualTo(String value) {
            addCriterion("DoNtFood <>", value, "dontfood");
            return (Criteria) this;
        }
        public Criteria andDontfoodGreaterThan(String value) {
            addCriterion("DoNtFood >", value, "dontfood");
            return (Criteria) this;
        }
        public Criteria andDontfoodGreaterThanOrEqualTo(String value) {
            addCriterion("DoNtFood >=", value, "dontfood");
            return (Criteria) this;
        }
        public Criteria andDontfoodLessThan(String value) {
            addCriterion("DoNtFood <", value, "dontfood");
            return (Criteria) this;
        }
        public Criteria andDontfoodLessThanOrEqualTo(String value) {
            addCriterion("DoNtFood <=", value, "dontfood");
            return (Criteria) this;
        }
        public Criteria andDontfoodLike(String value) {
            addCriterion("DoNtFood like", value, "dontfood");
            return (Criteria) this;
        }
        public Criteria andDontfoodNotLike(String value) {
            addCriterion("DoNtFood not like", value, "dontfood");
            return (Criteria) this;
        }
        public Criteria andDontfoodIn(List<String> values) {
            addCriterion("DoNtFood in", values, "dontfood");
            return (Criteria) this;
        }
        public Criteria andDontfoodNotIn(List<String> values) {
            addCriterion("DoNtFood not in", values, "dontfood");
            return (Criteria) this;
        }
        public Criteria andDontfoodBetween(String value1, String value2) {
            addCriterion("DoNtFood between", value1, value2, "dontfood");
            return (Criteria) this;
        }
        public Criteria andDontfoodNotBetween(String value1, String value2) {
            addCriterion("DoNtFood not between", value1, value2, "dontfood");
            return (Criteria) this;
        }
        public Criteria andStaplefoodIsNull() {
            addCriterion("StapleFood is null");
            return (Criteria) this;
        }
        public Criteria andStaplefoodIsNotNull() {
            addCriterion("StapleFood is not null");
            return (Criteria) this;
        }
        public Criteria andStaplefoodEqualTo(String value) {
            addCriterion("StapleFood =", value, "staplefood");
            return (Criteria) this;
        }
        public Criteria andStaplefoodNotEqualTo(String value) {
            addCriterion("StapleFood <>", value, "staplefood");
            return (Criteria) this;
        }
        public Criteria andStaplefoodGreaterThan(String value) {
            addCriterion("StapleFood >", value, "staplefood");
            return (Criteria) this;
        }
        public Criteria andStaplefoodGreaterThanOrEqualTo(String value) {
            addCriterion("StapleFood >=", value, "staplefood");
            return (Criteria) this;
        }
        public Criteria andStaplefoodLessThan(String value) {
            addCriterion("StapleFood <", value, "staplefood");
            return (Criteria) this;
        }
        public Criteria andStaplefoodLessThanOrEqualTo(String value) {
            addCriterion("StapleFood <=", value, "staplefood");
            return (Criteria) this;
        }
        public Criteria andStaplefoodLike(String value) {
            addCriterion("StapleFood like", value, "staplefood");
            return (Criteria) this;
        }
        public Criteria andStaplefoodNotLike(String value) {
            addCriterion("StapleFood not like", value, "staplefood");
            return (Criteria) this;
        }
        public Criteria andStaplefoodIn(List<String> values) {
            addCriterion("StapleFood in", values, "staplefood");
            return (Criteria) this;
        }
        public Criteria andStaplefoodNotIn(List<String> values) {
            addCriterion("StapleFood not in", values, "staplefood");
            return (Criteria) this;
        }
        public Criteria andStaplefoodBetween(String value1, String value2) {
            addCriterion("StapleFood between", value1, value2, "staplefood");
            return (Criteria) this;
        }
        public Criteria andStaplefoodNotBetween(String value1, String value2) {
            addCriterion("StapleFood not between", value1, value2, "staplefood");
            return (Criteria) this;
        }
        public Criteria andSleepcondIsNull() {
            addCriterion("SleepCond is null");
            return (Criteria) this;
        }
        public Criteria andSleepcondIsNotNull() {
            addCriterion("SleepCond is not null");
            return (Criteria) this;
        }
        public Criteria andSleepcondEqualTo(String value) {
            addCriterion("SleepCond =", value, "sleepcond");
            return (Criteria) this;
        }
        public Criteria andSleepcondNotEqualTo(String value) {
            addCriterion("SleepCond <>", value, "sleepcond");
            return (Criteria) this;
        }
        public Criteria andSleepcondGreaterThan(String value) {
            addCriterion("SleepCond >", value, "sleepcond");
            return (Criteria) this;
        }
        public Criteria andSleepcondGreaterThanOrEqualTo(String value) {
            addCriterion("SleepCond >=", value, "sleepcond");
            return (Criteria) this;
        }
        public Criteria andSleepcondLessThan(String value) {
            addCriterion("SleepCond <", value, "sleepcond");
            return (Criteria) this;
        }
        public Criteria andSleepcondLessThanOrEqualTo(String value) {
            addCriterion("SleepCond <=", value, "sleepcond");
            return (Criteria) this;
        }
        public Criteria andSleepcondLike(String value) {
            addCriterion("SleepCond like", value, "sleepcond");
            return (Criteria) this;
        }
        public Criteria andSleepcondNotLike(String value) {
            addCriterion("SleepCond not like", value, "sleepcond");
            return (Criteria) this;
        }
        public Criteria andSleepcondIn(List<String> values) {
            addCriterion("SleepCond in", values, "sleepcond");
            return (Criteria) this;
        }
        public Criteria andSleepcondNotIn(List<String> values) {
            addCriterion("SleepCond not in", values, "sleepcond");
            return (Criteria) this;
        }
        public Criteria andSleepcondBetween(String value1, String value2) {
            addCriterion("SleepCond between", value1, value2, "sleepcond");
            return (Criteria) this;
        }
        public Criteria andSleepcondNotBetween(String value1, String value2) {
            addCriterion("SleepCond not between", value1, value2, "sleepcond");
            return (Criteria) this;
        }
        public Criteria andLikesportsIsNull() {
            addCriterion("LikeSports is null");
            return (Criteria) this;
        }
        public Criteria andLikesportsIsNotNull() {
            addCriterion("LikeSports is not null");
            return (Criteria) this;
        }
        public Criteria andLikesportsEqualTo(String value) {
            addCriterion("LikeSports =", value, "likesports");
            return (Criteria) this;
        }
        public Criteria andLikesportsNotEqualTo(String value) {
            addCriterion("LikeSports <>", value, "likesports");
            return (Criteria) this;
        }
        public Criteria andLikesportsGreaterThan(String value) {
            addCriterion("LikeSports >", value, "likesports");
            return (Criteria) this;
        }
        public Criteria andLikesportsGreaterThanOrEqualTo(String value) {
            addCriterion("LikeSports >=", value, "likesports");
            return (Criteria) this;
        }
        public Criteria andLikesportsLessThan(String value) {
            addCriterion("LikeSports <", value, "likesports");
            return (Criteria) this;
        }
        public Criteria andLikesportsLessThanOrEqualTo(String value) {
            addCriterion("LikeSports <=", value, "likesports");
            return (Criteria) this;
        }
        public Criteria andLikesportsLike(String value) {
            addCriterion("LikeSports like", value, "likesports");
            return (Criteria) this;
        }
        public Criteria andLikesportsNotLike(String value) {
            addCriterion("LikeSports not like", value, "likesports");
            return (Criteria) this;
        }
        public Criteria andLikesportsIn(List<String> values) {
            addCriterion("LikeSports in", values, "likesports");
            return (Criteria) this;
        }
        public Criteria andLikesportsNotIn(List<String> values) {
            addCriterion("LikeSports not in", values, "likesports");
            return (Criteria) this;
        }
        public Criteria andLikesportsBetween(String value1, String value2) {
            addCriterion("LikeSports between", value1, value2, "likesports");
            return (Criteria) this;
        }
        public Criteria andLikesportsNotBetween(String value1, String value2) {
            addCriterion("LikeSports not between", value1, value2, "likesports");
            return (Criteria) this;
        }
        public Criteria andMovelongIsNull() {
            addCriterion("MoveLong is null");
            return (Criteria) this;
        }
        public Criteria andMovelongIsNotNull() {
            addCriterion("MoveLong is not null");
            return (Criteria) this;
        }
        public Criteria andMovelongEqualTo(String value) {
            addCriterion("MoveLong =", value, "movelong");
            return (Criteria) this;
        }
        public Criteria andMovelongNotEqualTo(String value) {
            addCriterion("MoveLong <>", value, "movelong");
            return (Criteria) this;
        }
        public Criteria andMovelongGreaterThan(String value) {
            addCriterion("MoveLong >", value, "movelong");
            return (Criteria) this;
        }
        public Criteria andMovelongGreaterThanOrEqualTo(String value) {
            addCriterion("MoveLong >=", value, "movelong");
            return (Criteria) this;
        }
        public Criteria andMovelongLessThan(String value) {
            addCriterion("MoveLong <", value, "movelong");
            return (Criteria) this;
        }
        public Criteria andMovelongLessThanOrEqualTo(String value) {
            addCriterion("MoveLong <=", value, "movelong");
            return (Criteria) this;
        }
        public Criteria andMovelongLike(String value) {
            addCriterion("MoveLong like", value, "movelong");
            return (Criteria) this;
        }
        public Criteria andMovelongNotLike(String value) {
            addCriterion("MoveLong not like", value, "movelong");
            return (Criteria) this;
        }
        public Criteria andMovelongIn(List<String> values) {
            addCriterion("MoveLong in", values, "movelong");
            return (Criteria) this;
        }
        public Criteria andMovelongNotIn(List<String> values) {
            addCriterion("MoveLong not in", values, "movelong");
            return (Criteria) this;
        }
        public Criteria andMovelongBetween(String value1, String value2) {
            addCriterion("MoveLong between", value1, value2, "movelong");
            return (Criteria) this;
        }
        public Criteria andMovelongNotBetween(String value1, String value2) {
            addCriterion("MoveLong not between", value1, value2, "movelong");
            return (Criteria) this;
        }
        public Criteria andTimesegIsNull() {
            addCriterion("TimeSeg is null");
            return (Criteria) this;
        }
        public Criteria andTimesegIsNotNull() {
            addCriterion("TimeSeg is not null");
            return (Criteria) this;
        }
        public Criteria andTimesegEqualTo(String value) {
            addCriterion("TimeSeg =", value, "timeseg");
            return (Criteria) this;
        }
        public Criteria andTimesegNotEqualTo(String value) {
            addCriterion("TimeSeg <>", value, "timeseg");
            return (Criteria) this;
        }
        public Criteria andTimesegGreaterThan(String value) {
            addCriterion("TimeSeg >", value, "timeseg");
            return (Criteria) this;
        }
        public Criteria andTimesegGreaterThanOrEqualTo(String value) {
            addCriterion("TimeSeg >=", value, "timeseg");
            return (Criteria) this;
        }
        public Criteria andTimesegLessThan(String value) {
            addCriterion("TimeSeg <", value, "timeseg");
            return (Criteria) this;
        }
        public Criteria andTimesegLessThanOrEqualTo(String value) {
            addCriterion("TimeSeg <=", value, "timeseg");
            return (Criteria) this;
        }
        public Criteria andTimesegLike(String value) {
            addCriterion("TimeSeg like", value, "timeseg");
            return (Criteria) this;
        }
        public Criteria andTimesegNotLike(String value) {
            addCriterion("TimeSeg not like", value, "timeseg");
            return (Criteria) this;
        }
        public Criteria andTimesegIn(List<String> values) {
            addCriterion("TimeSeg in", values, "timeseg");
            return (Criteria) this;
        }
        public Criteria andTimesegNotIn(List<String> values) {
            addCriterion("TimeSeg not in", values, "timeseg");
            return (Criteria) this;
        }
        public Criteria andTimesegBetween(String value1, String value2) {
            addCriterion("TimeSeg between", value1, value2, "timeseg");
            return (Criteria) this;
        }
        public Criteria andTimesegNotBetween(String value1, String value2) {
            addCriterion("TimeSeg not between", value1, value2, "timeseg");
            return (Criteria) this;
        }
        public Criteria andWeeknumtimesIsNull() {
            addCriterion("WeekNumTimes is null");
            return (Criteria) this;
        }
        public Criteria andWeeknumtimesIsNotNull() {
            addCriterion("WeekNumTimes is not null");
            return (Criteria) this;
        }
        public Criteria andWeeknumtimesEqualTo(Short value) {
            addCriterion("WeekNumTimes =", value, "weeknumtimes");
            return (Criteria) this;
        }
        public Criteria andWeeknumtimesNotEqualTo(Short value) {
            addCriterion("WeekNumTimes <>", value, "weeknumtimes");
            return (Criteria) this;
        }
        public Criteria andWeeknumtimesGreaterThan(Short value) {
            addCriterion("WeekNumTimes >", value, "weeknumtimes");
            return (Criteria) this;
        }
        public Criteria andWeeknumtimesGreaterThanOrEqualTo(Short value) {
            addCriterion("WeekNumTimes >=", value, "weeknumtimes");
            return (Criteria) this;
        }
        public Criteria andWeeknumtimesLessThan(Short value) {
            addCriterion("WeekNumTimes <", value, "weeknumtimes");
            return (Criteria) this;
        }
        public Criteria andWeeknumtimesLessThanOrEqualTo(Short value) {
            addCriterion("WeekNumTimes <=", value, "weeknumtimes");
            return (Criteria) this;
        }
        public Criteria andWeeknumtimesIn(List<Short> values) {
            addCriterion("WeekNumTimes in", values, "weeknumtimes");
            return (Criteria) this;
        }
        public Criteria andWeeknumtimesNotIn(List<Short> values) {
            addCriterion("WeekNumTimes not in", values, "weeknumtimes");
            return (Criteria) this;
        }
        public Criteria andWeeknumtimesBetween(Short value1, Short value2) {
            addCriterion("WeekNumTimes between", value1, value2, "weeknumtimes");
            return (Criteria) this;
        }
        public Criteria andWeeknumtimesNotBetween(Short value1, Short value2) {
            addCriterion("WeekNumTimes not between", value1, value2, "weeknumtimes");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    /**
     * 会员习惯信息（MEM7）
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