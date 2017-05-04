package com.ruicai.evaluation.po.system;

import java.util.ArrayList;
import java.util.List;

public class SystemResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemResourceExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
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

        public Criteria andResourceTypeIsNull() {
            addCriterion("RESOURCE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIsNotNull() {
            addCriterion("RESOURCE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andResourceTypeEqualTo(String value) {
            addCriterion("RESOURCE_TYPE =", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotEqualTo(String value) {
            addCriterion("RESOURCE_TYPE <>", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeGreaterThan(String value) {
            addCriterion("RESOURCE_TYPE >", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCE_TYPE >=", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLessThan(String value) {
            addCriterion("RESOURCE_TYPE <", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLessThanOrEqualTo(String value) {
            addCriterion("RESOURCE_TYPE <=", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeLike(String value) {
            addCriterion("RESOURCE_TYPE like", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotLike(String value) {
            addCriterion("RESOURCE_TYPE not like", value, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeIn(List<String> values) {
            addCriterion("RESOURCE_TYPE in", values, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotIn(List<String> values) {
            addCriterion("RESOURCE_TYPE not in", values, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeBetween(String value1, String value2) {
            addCriterion("RESOURCE_TYPE between", value1, value2, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceTypeNotBetween(String value1, String value2) {
            addCriterion("RESOURCE_TYPE not between", value1, value2, "resourceType");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNull() {
            addCriterion("RESOURCE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNotNull() {
            addCriterion("RESOURCE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andResourceNameEqualTo(String value) {
            addCriterion("RESOURCE_NAME =", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotEqualTo(String value) {
            addCriterion("RESOURCE_NAME <>", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThan(String value) {
            addCriterion("RESOURCE_NAME >", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCE_NAME >=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThan(String value) {
            addCriterion("RESOURCE_NAME <", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThanOrEqualTo(String value) {
            addCriterion("RESOURCE_NAME <=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLike(String value) {
            addCriterion("RESOURCE_NAME like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotLike(String value) {
            addCriterion("RESOURCE_NAME not like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameIn(List<String> values) {
            addCriterion("RESOURCE_NAME in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotIn(List<String> values) {
            addCriterion("RESOURCE_NAME not in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameBetween(String value1, String value2) {
            addCriterion("RESOURCE_NAME between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotBetween(String value1, String value2) {
            addCriterion("RESOURCE_NAME not between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceValueIsNull() {
            addCriterion("RESOURCE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andResourceValueIsNotNull() {
            addCriterion("RESOURCE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andResourceValueEqualTo(String value) {
            addCriterion("RESOURCE_VALUE =", value, "resourceValue");
            return (Criteria) this;
        }

        public Criteria andResourceValueNotEqualTo(String value) {
            addCriterion("RESOURCE_VALUE <>", value, "resourceValue");
            return (Criteria) this;
        }

        public Criteria andResourceValueGreaterThan(String value) {
            addCriterion("RESOURCE_VALUE >", value, "resourceValue");
            return (Criteria) this;
        }

        public Criteria andResourceValueGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCE_VALUE >=", value, "resourceValue");
            return (Criteria) this;
        }

        public Criteria andResourceValueLessThan(String value) {
            addCriterion("RESOURCE_VALUE <", value, "resourceValue");
            return (Criteria) this;
        }

        public Criteria andResourceValueLessThanOrEqualTo(String value) {
            addCriterion("RESOURCE_VALUE <=", value, "resourceValue");
            return (Criteria) this;
        }

        public Criteria andResourceValueLike(String value) {
            addCriterion("RESOURCE_VALUE like", value, "resourceValue");
            return (Criteria) this;
        }

        public Criteria andResourceValueNotLike(String value) {
            addCriterion("RESOURCE_VALUE not like", value, "resourceValue");
            return (Criteria) this;
        }

        public Criteria andResourceValueIn(List<String> values) {
            addCriterion("RESOURCE_VALUE in", values, "resourceValue");
            return (Criteria) this;
        }

        public Criteria andResourceValueNotIn(List<String> values) {
            addCriterion("RESOURCE_VALUE not in", values, "resourceValue");
            return (Criteria) this;
        }

        public Criteria andResourceValueBetween(String value1, String value2) {
            addCriterion("RESOURCE_VALUE between", value1, value2, "resourceValue");
            return (Criteria) this;
        }

        public Criteria andResourceValueNotBetween(String value1, String value2) {
            addCriterion("RESOURCE_VALUE not between", value1, value2, "resourceValue");
            return (Criteria) this;
        }

        public Criteria andResourceDescribeIsNull() {
            addCriterion("RESOURCE_DESCRIBE is null");
            return (Criteria) this;
        }

        public Criteria andResourceDescribeIsNotNull() {
            addCriterion("RESOURCE_DESCRIBE is not null");
            return (Criteria) this;
        }

        public Criteria andResourceDescribeEqualTo(String value) {
            addCriterion("RESOURCE_DESCRIBE =", value, "resourceDescribe");
            return (Criteria) this;
        }

        public Criteria andResourceDescribeNotEqualTo(String value) {
            addCriterion("RESOURCE_DESCRIBE <>", value, "resourceDescribe");
            return (Criteria) this;
        }

        public Criteria andResourceDescribeGreaterThan(String value) {
            addCriterion("RESOURCE_DESCRIBE >", value, "resourceDescribe");
            return (Criteria) this;
        }

        public Criteria andResourceDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCE_DESCRIBE >=", value, "resourceDescribe");
            return (Criteria) this;
        }

        public Criteria andResourceDescribeLessThan(String value) {
            addCriterion("RESOURCE_DESCRIBE <", value, "resourceDescribe");
            return (Criteria) this;
        }

        public Criteria andResourceDescribeLessThanOrEqualTo(String value) {
            addCriterion("RESOURCE_DESCRIBE <=", value, "resourceDescribe");
            return (Criteria) this;
        }

        public Criteria andResourceDescribeLike(String value) {
            addCriterion("RESOURCE_DESCRIBE like", value, "resourceDescribe");
            return (Criteria) this;
        }

        public Criteria andResourceDescribeNotLike(String value) {
            addCriterion("RESOURCE_DESCRIBE not like", value, "resourceDescribe");
            return (Criteria) this;
        }

        public Criteria andResourceDescribeIn(List<String> values) {
            addCriterion("RESOURCE_DESCRIBE in", values, "resourceDescribe");
            return (Criteria) this;
        }

        public Criteria andResourceDescribeNotIn(List<String> values) {
            addCriterion("RESOURCE_DESCRIBE not in", values, "resourceDescribe");
            return (Criteria) this;
        }

        public Criteria andResourceDescribeBetween(String value1, String value2) {
            addCriterion("RESOURCE_DESCRIBE between", value1, value2, "resourceDescribe");
            return (Criteria) this;
        }

        public Criteria andResourceDescribeNotBetween(String value1, String value2) {
            addCriterion("RESOURCE_DESCRIBE not between", value1, value2, "resourceDescribe");
            return (Criteria) this;
        }

        public Criteria andResourceVisibleIsNull() {
            addCriterion("RESOURCE_VISIBLE is null");
            return (Criteria) this;
        }

        public Criteria andResourceVisibleIsNotNull() {
            addCriterion("RESOURCE_VISIBLE is not null");
            return (Criteria) this;
        }

        public Criteria andResourceVisibleEqualTo(String value) {
            addCriterion("RESOURCE_VISIBLE =", value, "resourceVisible");
            return (Criteria) this;
        }

        public Criteria andResourceVisibleNotEqualTo(String value) {
            addCriterion("RESOURCE_VISIBLE <>", value, "resourceVisible");
            return (Criteria) this;
        }

        public Criteria andResourceVisibleGreaterThan(String value) {
            addCriterion("RESOURCE_VISIBLE >", value, "resourceVisible");
            return (Criteria) this;
        }

        public Criteria andResourceVisibleGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCE_VISIBLE >=", value, "resourceVisible");
            return (Criteria) this;
        }

        public Criteria andResourceVisibleLessThan(String value) {
            addCriterion("RESOURCE_VISIBLE <", value, "resourceVisible");
            return (Criteria) this;
        }

        public Criteria andResourceVisibleLessThanOrEqualTo(String value) {
            addCriterion("RESOURCE_VISIBLE <=", value, "resourceVisible");
            return (Criteria) this;
        }

        public Criteria andResourceVisibleLike(String value) {
            addCriterion("RESOURCE_VISIBLE like", value, "resourceVisible");
            return (Criteria) this;
        }

        public Criteria andResourceVisibleNotLike(String value) {
            addCriterion("RESOURCE_VISIBLE not like", value, "resourceVisible");
            return (Criteria) this;
        }

        public Criteria andResourceVisibleIn(List<String> values) {
            addCriterion("RESOURCE_VISIBLE in", values, "resourceVisible");
            return (Criteria) this;
        }

        public Criteria andResourceVisibleNotIn(List<String> values) {
            addCriterion("RESOURCE_VISIBLE not in", values, "resourceVisible");
            return (Criteria) this;
        }

        public Criteria andResourceVisibleBetween(String value1, String value2) {
            addCriterion("RESOURCE_VISIBLE between", value1, value2, "resourceVisible");
            return (Criteria) this;
        }

        public Criteria andResourceVisibleNotBetween(String value1, String value2) {
            addCriterion("RESOURCE_VISIBLE not between", value1, value2, "resourceVisible");
            return (Criteria) this;
        }

        public Criteria andResourceEnableIsNull() {
            addCriterion("RESOURCE_ENABLE is null");
            return (Criteria) this;
        }

        public Criteria andResourceEnableIsNotNull() {
            addCriterion("RESOURCE_ENABLE is not null");
            return (Criteria) this;
        }

        public Criteria andResourceEnableEqualTo(String value) {
            addCriterion("RESOURCE_ENABLE =", value, "resourceEnable");
            return (Criteria) this;
        }

        public Criteria andResourceEnableNotEqualTo(String value) {
            addCriterion("RESOURCE_ENABLE <>", value, "resourceEnable");
            return (Criteria) this;
        }

        public Criteria andResourceEnableGreaterThan(String value) {
            addCriterion("RESOURCE_ENABLE >", value, "resourceEnable");
            return (Criteria) this;
        }

        public Criteria andResourceEnableGreaterThanOrEqualTo(String value) {
            addCriterion("RESOURCE_ENABLE >=", value, "resourceEnable");
            return (Criteria) this;
        }

        public Criteria andResourceEnableLessThan(String value) {
            addCriterion("RESOURCE_ENABLE <", value, "resourceEnable");
            return (Criteria) this;
        }

        public Criteria andResourceEnableLessThanOrEqualTo(String value) {
            addCriterion("RESOURCE_ENABLE <=", value, "resourceEnable");
            return (Criteria) this;
        }

        public Criteria andResourceEnableLike(String value) {
            addCriterion("RESOURCE_ENABLE like", value, "resourceEnable");
            return (Criteria) this;
        }

        public Criteria andResourceEnableNotLike(String value) {
            addCriterion("RESOURCE_ENABLE not like", value, "resourceEnable");
            return (Criteria) this;
        }

        public Criteria andResourceEnableIn(List<String> values) {
            addCriterion("RESOURCE_ENABLE in", values, "resourceEnable");
            return (Criteria) this;
        }

        public Criteria andResourceEnableNotIn(List<String> values) {
            addCriterion("RESOURCE_ENABLE not in", values, "resourceEnable");
            return (Criteria) this;
        }

        public Criteria andResourceEnableBetween(String value1, String value2) {
            addCriterion("RESOURCE_ENABLE between", value1, value2, "resourceEnable");
            return (Criteria) this;
        }

        public Criteria andResourceEnableNotBetween(String value1, String value2) {
            addCriterion("RESOURCE_ENABLE not between", value1, value2, "resourceEnable");
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