package com.ruicai.evaluation.entity;

import java.util.ArrayList;
import java.util.List;

public class SysResExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysResExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
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

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("PARENT_ID =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("PARENT_ID <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("PARENT_ID >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_ID >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("PARENT_ID <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("PARENT_ID <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("PARENT_ID like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("PARENT_ID not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("PARENT_ID in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("PARENT_ID not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("PARENT_ID between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("PARENT_ID not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andResTypeIsNull() {
            addCriterion("RES_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andResTypeIsNotNull() {
            addCriterion("RES_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andResTypeEqualTo(String value) {
            addCriterion("RES_TYPE =", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotEqualTo(String value) {
            addCriterion("RES_TYPE <>", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeGreaterThan(String value) {
            addCriterion("RES_TYPE >", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RES_TYPE >=", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeLessThan(String value) {
            addCriterion("RES_TYPE <", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeLessThanOrEqualTo(String value) {
            addCriterion("RES_TYPE <=", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeLike(String value) {
            addCriterion("RES_TYPE like", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotLike(String value) {
            addCriterion("RES_TYPE not like", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeIn(List<String> values) {
            addCriterion("RES_TYPE in", values, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotIn(List<String> values) {
            addCriterion("RES_TYPE not in", values, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeBetween(String value1, String value2) {
            addCriterion("RES_TYPE between", value1, value2, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotBetween(String value1, String value2) {
            addCriterion("RES_TYPE not between", value1, value2, "resType");
            return (Criteria) this;
        }

        public Criteria andResNameIsNull() {
            addCriterion("RES_NAME is null");
            return (Criteria) this;
        }

        public Criteria andResNameIsNotNull() {
            addCriterion("RES_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andResNameEqualTo(String value) {
            addCriterion("RES_NAME =", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotEqualTo(String value) {
            addCriterion("RES_NAME <>", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameGreaterThan(String value) {
            addCriterion("RES_NAME >", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameGreaterThanOrEqualTo(String value) {
            addCriterion("RES_NAME >=", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameLessThan(String value) {
            addCriterion("RES_NAME <", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameLessThanOrEqualTo(String value) {
            addCriterion("RES_NAME <=", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameLike(String value) {
            addCriterion("RES_NAME like", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotLike(String value) {
            addCriterion("RES_NAME not like", value, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameIn(List<String> values) {
            addCriterion("RES_NAME in", values, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotIn(List<String> values) {
            addCriterion("RES_NAME not in", values, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameBetween(String value1, String value2) {
            addCriterion("RES_NAME between", value1, value2, "resName");
            return (Criteria) this;
        }

        public Criteria andResNameNotBetween(String value1, String value2) {
            addCriterion("RES_NAME not between", value1, value2, "resName");
            return (Criteria) this;
        }

        public Criteria andResValueIsNull() {
            addCriterion("RES_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andResValueIsNotNull() {
            addCriterion("RES_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andResValueEqualTo(String value) {
            addCriterion("RES_VALUE =", value, "resValue");
            return (Criteria) this;
        }

        public Criteria andResValueNotEqualTo(String value) {
            addCriterion("RES_VALUE <>", value, "resValue");
            return (Criteria) this;
        }

        public Criteria andResValueGreaterThan(String value) {
            addCriterion("RES_VALUE >", value, "resValue");
            return (Criteria) this;
        }

        public Criteria andResValueGreaterThanOrEqualTo(String value) {
            addCriterion("RES_VALUE >=", value, "resValue");
            return (Criteria) this;
        }

        public Criteria andResValueLessThan(String value) {
            addCriterion("RES_VALUE <", value, "resValue");
            return (Criteria) this;
        }

        public Criteria andResValueLessThanOrEqualTo(String value) {
            addCriterion("RES_VALUE <=", value, "resValue");
            return (Criteria) this;
        }

        public Criteria andResValueLike(String value) {
            addCriterion("RES_VALUE like", value, "resValue");
            return (Criteria) this;
        }

        public Criteria andResValueNotLike(String value) {
            addCriterion("RES_VALUE not like", value, "resValue");
            return (Criteria) this;
        }

        public Criteria andResValueIn(List<String> values) {
            addCriterion("RES_VALUE in", values, "resValue");
            return (Criteria) this;
        }

        public Criteria andResValueNotIn(List<String> values) {
            addCriterion("RES_VALUE not in", values, "resValue");
            return (Criteria) this;
        }

        public Criteria andResValueBetween(String value1, String value2) {
            addCriterion("RES_VALUE between", value1, value2, "resValue");
            return (Criteria) this;
        }

        public Criteria andResValueNotBetween(String value1, String value2) {
            addCriterion("RES_VALUE not between", value1, value2, "resValue");
            return (Criteria) this;
        }

        public Criteria andResVisibleIsNull() {
            addCriterion("RES_VISIBLE is null");
            return (Criteria) this;
        }

        public Criteria andResVisibleIsNotNull() {
            addCriterion("RES_VISIBLE is not null");
            return (Criteria) this;
        }

        public Criteria andResVisibleEqualTo(Short value) {
            addCriterion("RES_VISIBLE =", value, "resVisible");
            return (Criteria) this;
        }

        public Criteria andResVisibleNotEqualTo(Short value) {
            addCriterion("RES_VISIBLE <>", value, "resVisible");
            return (Criteria) this;
        }

        public Criteria andResVisibleGreaterThan(Short value) {
            addCriterion("RES_VISIBLE >", value, "resVisible");
            return (Criteria) this;
        }

        public Criteria andResVisibleGreaterThanOrEqualTo(Short value) {
            addCriterion("RES_VISIBLE >=", value, "resVisible");
            return (Criteria) this;
        }

        public Criteria andResVisibleLessThan(Short value) {
            addCriterion("RES_VISIBLE <", value, "resVisible");
            return (Criteria) this;
        }

        public Criteria andResVisibleLessThanOrEqualTo(Short value) {
            addCriterion("RES_VISIBLE <=", value, "resVisible");
            return (Criteria) this;
        }

        public Criteria andResVisibleIn(List<Short> values) {
            addCriterion("RES_VISIBLE in", values, "resVisible");
            return (Criteria) this;
        }

        public Criteria andResVisibleNotIn(List<Short> values) {
            addCriterion("RES_VISIBLE not in", values, "resVisible");
            return (Criteria) this;
        }

        public Criteria andResVisibleBetween(Short value1, Short value2) {
            addCriterion("RES_VISIBLE between", value1, value2, "resVisible");
            return (Criteria) this;
        }

        public Criteria andResVisibleNotBetween(Short value1, Short value2) {
            addCriterion("RES_VISIBLE not between", value1, value2, "resVisible");
            return (Criteria) this;
        }

        public Criteria andResEnableIsNull() {
            addCriterion("RES_ENABLE is null");
            return (Criteria) this;
        }

        public Criteria andResEnableIsNotNull() {
            addCriterion("RES_ENABLE is not null");
            return (Criteria) this;
        }

        public Criteria andResEnableEqualTo(Short value) {
            addCriterion("RES_ENABLE =", value, "resEnable");
            return (Criteria) this;
        }

        public Criteria andResEnableNotEqualTo(Short value) {
            addCriterion("RES_ENABLE <>", value, "resEnable");
            return (Criteria) this;
        }

        public Criteria andResEnableGreaterThan(Short value) {
            addCriterion("RES_ENABLE >", value, "resEnable");
            return (Criteria) this;
        }

        public Criteria andResEnableGreaterThanOrEqualTo(Short value) {
            addCriterion("RES_ENABLE >=", value, "resEnable");
            return (Criteria) this;
        }

        public Criteria andResEnableLessThan(Short value) {
            addCriterion("RES_ENABLE <", value, "resEnable");
            return (Criteria) this;
        }

        public Criteria andResEnableLessThanOrEqualTo(Short value) {
            addCriterion("RES_ENABLE <=", value, "resEnable");
            return (Criteria) this;
        }

        public Criteria andResEnableIn(List<Short> values) {
            addCriterion("RES_ENABLE in", values, "resEnable");
            return (Criteria) this;
        }

        public Criteria andResEnableNotIn(List<Short> values) {
            addCriterion("RES_ENABLE not in", values, "resEnable");
            return (Criteria) this;
        }

        public Criteria andResEnableBetween(Short value1, Short value2) {
            addCriterion("RES_ENABLE between", value1, value2, "resEnable");
            return (Criteria) this;
        }

        public Criteria andResEnableNotBetween(Short value1, Short value2) {
            addCriterion("RES_ENABLE not between", value1, value2, "resEnable");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
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

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

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
    }
}