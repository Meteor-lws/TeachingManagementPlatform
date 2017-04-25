package com.ruicai.system.po.system;

import java.util.ArrayList;
import java.util.List;

public class SystemDictionaryTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemDictionaryTypeExample() {
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

        public Criteria andDictionaryTypeNameIsNull() {
            addCriterion("DICTIONARY_TYPE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameIsNotNull() {
            addCriterion("DICTIONARY_TYPE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameEqualTo(String value) {
            addCriterion("DICTIONARY_TYPE_NAME =", value, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameNotEqualTo(String value) {
            addCriterion("DICTIONARY_TYPE_NAME <>", value, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameGreaterThan(String value) {
            addCriterion("DICTIONARY_TYPE_NAME >", value, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("DICTIONARY_TYPE_NAME >=", value, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameLessThan(String value) {
            addCriterion("DICTIONARY_TYPE_NAME <", value, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameLessThanOrEqualTo(String value) {
            addCriterion("DICTIONARY_TYPE_NAME <=", value, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameLike(String value) {
            addCriterion("DICTIONARY_TYPE_NAME like", value, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameNotLike(String value) {
            addCriterion("DICTIONARY_TYPE_NAME not like", value, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameIn(List<String> values) {
            addCriterion("DICTIONARY_TYPE_NAME in", values, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameNotIn(List<String> values) {
            addCriterion("DICTIONARY_TYPE_NAME not in", values, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameBetween(String value1, String value2) {
            addCriterion("DICTIONARY_TYPE_NAME between", value1, value2, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeNameNotBetween(String value1, String value2) {
            addCriterion("DICTIONARY_TYPE_NAME not between", value1, value2, "dictionaryTypeName");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeDescribeIsNull() {
            addCriterion("DICTIONARY_TYPE_DESCRIBE is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeDescribeIsNotNull() {
            addCriterion("DICTIONARY_TYPE_DESCRIBE is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeDescribeEqualTo(String value) {
            addCriterion("DICTIONARY_TYPE_DESCRIBE =", value, "dictionaryTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeDescribeNotEqualTo(String value) {
            addCriterion("DICTIONARY_TYPE_DESCRIBE <>", value, "dictionaryTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeDescribeGreaterThan(String value) {
            addCriterion("DICTIONARY_TYPE_DESCRIBE >", value, "dictionaryTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("DICTIONARY_TYPE_DESCRIBE >=", value, "dictionaryTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeDescribeLessThan(String value) {
            addCriterion("DICTIONARY_TYPE_DESCRIBE <", value, "dictionaryTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeDescribeLessThanOrEqualTo(String value) {
            addCriterion("DICTIONARY_TYPE_DESCRIBE <=", value, "dictionaryTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeDescribeLike(String value) {
            addCriterion("DICTIONARY_TYPE_DESCRIBE like", value, "dictionaryTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeDescribeNotLike(String value) {
            addCriterion("DICTIONARY_TYPE_DESCRIBE not like", value, "dictionaryTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeDescribeIn(List<String> values) {
            addCriterion("DICTIONARY_TYPE_DESCRIBE in", values, "dictionaryTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeDescribeNotIn(List<String> values) {
            addCriterion("DICTIONARY_TYPE_DESCRIBE not in", values, "dictionaryTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeDescribeBetween(String value1, String value2) {
            addCriterion("DICTIONARY_TYPE_DESCRIBE between", value1, value2, "dictionaryTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeDescribeNotBetween(String value1, String value2) {
            addCriterion("DICTIONARY_TYPE_DESCRIBE not between", value1, value2, "dictionaryTypeDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeSortNumberIsNull() {
            addCriterion("DICTIONARY_TYPE_SORT_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeSortNumberIsNotNull() {
            addCriterion("DICTIONARY_TYPE_SORT_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeSortNumberEqualTo(Short value) {
            addCriterion("DICTIONARY_TYPE_SORT_NUMBER =", value, "dictionaryTypeSortNumber");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeSortNumberNotEqualTo(Short value) {
            addCriterion("DICTIONARY_TYPE_SORT_NUMBER <>", value, "dictionaryTypeSortNumber");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeSortNumberGreaterThan(Short value) {
            addCriterion("DICTIONARY_TYPE_SORT_NUMBER >", value, "dictionaryTypeSortNumber");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeSortNumberGreaterThanOrEqualTo(Short value) {
            addCriterion("DICTIONARY_TYPE_SORT_NUMBER >=", value, "dictionaryTypeSortNumber");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeSortNumberLessThan(Short value) {
            addCriterion("DICTIONARY_TYPE_SORT_NUMBER <", value, "dictionaryTypeSortNumber");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeSortNumberLessThanOrEqualTo(Short value) {
            addCriterion("DICTIONARY_TYPE_SORT_NUMBER <=", value, "dictionaryTypeSortNumber");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeSortNumberIn(List<Short> values) {
            addCriterion("DICTIONARY_TYPE_SORT_NUMBER in", values, "dictionaryTypeSortNumber");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeSortNumberNotIn(List<Short> values) {
            addCriterion("DICTIONARY_TYPE_SORT_NUMBER not in", values, "dictionaryTypeSortNumber");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeSortNumberBetween(Short value1, Short value2) {
            addCriterion("DICTIONARY_TYPE_SORT_NUMBER between", value1, value2, "dictionaryTypeSortNumber");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeSortNumberNotBetween(Short value1, Short value2) {
            addCriterion("DICTIONARY_TYPE_SORT_NUMBER not between", value1, value2, "dictionaryTypeSortNumber");
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