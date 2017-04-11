package com.ruicai.system.po.system;

import java.util.ArrayList;
import java.util.List;

public class SystemDictionaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemDictionaryExample() {
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

        public Criteria andDictionaryTypeIdIsNull() {
            addCriterion("DICTIONARY_TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeIdIsNotNull() {
            addCriterion("DICTIONARY_TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeIdEqualTo(String value) {
            addCriterion("DICTIONARY_TYPE_ID =", value, "dictionaryTypeId");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeIdNotEqualTo(String value) {
            addCriterion("DICTIONARY_TYPE_ID <>", value, "dictionaryTypeId");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeIdGreaterThan(String value) {
            addCriterion("DICTIONARY_TYPE_ID >", value, "dictionaryTypeId");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("DICTIONARY_TYPE_ID >=", value, "dictionaryTypeId");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeIdLessThan(String value) {
            addCriterion("DICTIONARY_TYPE_ID <", value, "dictionaryTypeId");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeIdLessThanOrEqualTo(String value) {
            addCriterion("DICTIONARY_TYPE_ID <=", value, "dictionaryTypeId");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeIdLike(String value) {
            addCriterion("DICTIONARY_TYPE_ID like", value, "dictionaryTypeId");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeIdNotLike(String value) {
            addCriterion("DICTIONARY_TYPE_ID not like", value, "dictionaryTypeId");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeIdIn(List<String> values) {
            addCriterion("DICTIONARY_TYPE_ID in", values, "dictionaryTypeId");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeIdNotIn(List<String> values) {
            addCriterion("DICTIONARY_TYPE_ID not in", values, "dictionaryTypeId");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeIdBetween(String value1, String value2) {
            addCriterion("DICTIONARY_TYPE_ID between", value1, value2, "dictionaryTypeId");
            return (Criteria) this;
        }

        public Criteria andDictionaryTypeIdNotBetween(String value1, String value2) {
            addCriterion("DICTIONARY_TYPE_ID not between", value1, value2, "dictionaryTypeId");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameIsNull() {
            addCriterion("DICTIONARY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameIsNotNull() {
            addCriterion("DICTIONARY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameEqualTo(String value) {
            addCriterion("DICTIONARY_NAME =", value, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameNotEqualTo(String value) {
            addCriterion("DICTIONARY_NAME <>", value, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameGreaterThan(String value) {
            addCriterion("DICTIONARY_NAME >", value, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameGreaterThanOrEqualTo(String value) {
            addCriterion("DICTIONARY_NAME >=", value, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameLessThan(String value) {
            addCriterion("DICTIONARY_NAME <", value, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameLessThanOrEqualTo(String value) {
            addCriterion("DICTIONARY_NAME <=", value, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameLike(String value) {
            addCriterion("DICTIONARY_NAME like", value, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameNotLike(String value) {
            addCriterion("DICTIONARY_NAME not like", value, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameIn(List<String> values) {
            addCriterion("DICTIONARY_NAME in", values, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameNotIn(List<String> values) {
            addCriterion("DICTIONARY_NAME not in", values, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameBetween(String value1, String value2) {
            addCriterion("DICTIONARY_NAME between", value1, value2, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryNameNotBetween(String value1, String value2) {
            addCriterion("DICTIONARY_NAME not between", value1, value2, "dictionaryName");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueIsNull() {
            addCriterion("DICTIONARY_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueIsNotNull() {
            addCriterion("DICTIONARY_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueEqualTo(String value) {
            addCriterion("DICTIONARY_VALUE =", value, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueNotEqualTo(String value) {
            addCriterion("DICTIONARY_VALUE <>", value, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueGreaterThan(String value) {
            addCriterion("DICTIONARY_VALUE >", value, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueGreaterThanOrEqualTo(String value) {
            addCriterion("DICTIONARY_VALUE >=", value, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueLessThan(String value) {
            addCriterion("DICTIONARY_VALUE <", value, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueLessThanOrEqualTo(String value) {
            addCriterion("DICTIONARY_VALUE <=", value, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueLike(String value) {
            addCriterion("DICTIONARY_VALUE like", value, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueNotLike(String value) {
            addCriterion("DICTIONARY_VALUE not like", value, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueIn(List<String> values) {
            addCriterion("DICTIONARY_VALUE in", values, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueNotIn(List<String> values) {
            addCriterion("DICTIONARY_VALUE not in", values, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueBetween(String value1, String value2) {
            addCriterion("DICTIONARY_VALUE between", value1, value2, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryValueNotBetween(String value1, String value2) {
            addCriterion("DICTIONARY_VALUE not between", value1, value2, "dictionaryValue");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeIsNull() {
            addCriterion("DICTIONARY_DESCRIBE is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeIsNotNull() {
            addCriterion("DICTIONARY_DESCRIBE is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeEqualTo(String value) {
            addCriterion("DICTIONARY_DESCRIBE =", value, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeNotEqualTo(String value) {
            addCriterion("DICTIONARY_DESCRIBE <>", value, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeGreaterThan(String value) {
            addCriterion("DICTIONARY_DESCRIBE >", value, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("DICTIONARY_DESCRIBE >=", value, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeLessThan(String value) {
            addCriterion("DICTIONARY_DESCRIBE <", value, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeLessThanOrEqualTo(String value) {
            addCriterion("DICTIONARY_DESCRIBE <=", value, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeLike(String value) {
            addCriterion("DICTIONARY_DESCRIBE like", value, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeNotLike(String value) {
            addCriterion("DICTIONARY_DESCRIBE not like", value, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeIn(List<String> values) {
            addCriterion("DICTIONARY_DESCRIBE in", values, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeNotIn(List<String> values) {
            addCriterion("DICTIONARY_DESCRIBE not in", values, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeBetween(String value1, String value2) {
            addCriterion("DICTIONARY_DESCRIBE between", value1, value2, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionaryDescribeNotBetween(String value1, String value2) {
            addCriterion("DICTIONARY_DESCRIBE not between", value1, value2, "dictionaryDescribe");
            return (Criteria) this;
        }

        public Criteria andDictionarySortNumberIsNull() {
            addCriterion("DICTIONARY_SORT_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andDictionarySortNumberIsNotNull() {
            addCriterion("DICTIONARY_SORT_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andDictionarySortNumberEqualTo(Short value) {
            addCriterion("DICTIONARY_SORT_NUMBER =", value, "dictionarySortNumber");
            return (Criteria) this;
        }

        public Criteria andDictionarySortNumberNotEqualTo(Short value) {
            addCriterion("DICTIONARY_SORT_NUMBER <>", value, "dictionarySortNumber");
            return (Criteria) this;
        }

        public Criteria andDictionarySortNumberGreaterThan(Short value) {
            addCriterion("DICTIONARY_SORT_NUMBER >", value, "dictionarySortNumber");
            return (Criteria) this;
        }

        public Criteria andDictionarySortNumberGreaterThanOrEqualTo(Short value) {
            addCriterion("DICTIONARY_SORT_NUMBER >=", value, "dictionarySortNumber");
            return (Criteria) this;
        }

        public Criteria andDictionarySortNumberLessThan(Short value) {
            addCriterion("DICTIONARY_SORT_NUMBER <", value, "dictionarySortNumber");
            return (Criteria) this;
        }

        public Criteria andDictionarySortNumberLessThanOrEqualTo(Short value) {
            addCriterion("DICTIONARY_SORT_NUMBER <=", value, "dictionarySortNumber");
            return (Criteria) this;
        }

        public Criteria andDictionarySortNumberIn(List<Short> values) {
            addCriterion("DICTIONARY_SORT_NUMBER in", values, "dictionarySortNumber");
            return (Criteria) this;
        }

        public Criteria andDictionarySortNumberNotIn(List<Short> values) {
            addCriterion("DICTIONARY_SORT_NUMBER not in", values, "dictionarySortNumber");
            return (Criteria) this;
        }

        public Criteria andDictionarySortNumberBetween(Short value1, Short value2) {
            addCriterion("DICTIONARY_SORT_NUMBER between", value1, value2, "dictionarySortNumber");
            return (Criteria) this;
        }

        public Criteria andDictionarySortNumberNotBetween(Short value1, Short value2) {
            addCriterion("DICTIONARY_SORT_NUMBER not between", value1, value2, "dictionarySortNumber");
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