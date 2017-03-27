 
/**
 * @PackageName:      com.bithealth.questionCore.model
 * @FileName:     AnswerExample.java  
 * @Description: TODO(用一句话描述该文件做什么)  
 * Copyright:    Copyright(C) 2016-2026 
 * 公司:          深圳中科汇康技术有限公司 
 * @author:      名字  * 
 * @version      V1.0  
 * @Createdate:  2016年8月16日 上午11:16:36  
 * 
 */

package com.bithealth.questionCore.model;

import java.util.ArrayList;
import java.util.List;


/**
 * 类名称: AnswerExample  
 * 功能描述: TODO ADD FUNCTION.  
 * 增加/修改原 因: TODO ADD REASON(可选).  
 * 日期: 2016年8月16日 上午11:16:36 
 * 
 * @author baozj
 * @version  
 */
public class AnswerExample {

	 protected String orderByClause;
	    protected boolean distinct;
	    protected List<Criteria> oredCriteria;

	    public AnswerExample() {
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
	        public Criteria andMemberIdEqualTo(Integer value) {
	            addCriterion("memberId =", value, "memberId");
	            return (Criteria) this;
	        }
	        public Criteria andTagEqualTo(Integer value) {
	            addCriterion("Tag =", value, "Tag");
	            return (Criteria) this;
	        }
	        public Criteria andTagIn(List<String> values) {
	            addCriterion("Tag in", values, "Tag");
	            return (Criteria) this;
	        }

	    }

	    public static class Criteria extends GeneratedCriteria {


	        protected Criteria() {
	            super();
	        }
	    }

	    /**
	     * 组合问卷审核结果（CAM2）
	     * 
	     * @author ${user}
	     * @version 1.0 2016-07-19
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

