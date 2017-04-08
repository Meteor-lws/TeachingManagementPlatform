package com.ruicai.teaching.po;

import java.util.ArrayList;
import java.util.List;

public class EvaItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EvaItemExample() {
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

        public Criteria andItemTypeIsNull() {
            addCriterion("ITEM_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNotNull() {
            addCriterion("ITEM_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeEqualTo(String value) {
            addCriterion("ITEM_TYPE =", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotEqualTo(String value) {
            addCriterion("ITEM_TYPE <>", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThan(String value) {
            addCriterion("ITEM_TYPE >", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_TYPE >=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThan(String value) {
            addCriterion("ITEM_TYPE <", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThanOrEqualTo(String value) {
            addCriterion("ITEM_TYPE <=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLike(String value) {
            addCriterion("ITEM_TYPE like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotLike(String value) {
            addCriterion("ITEM_TYPE not like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeIn(List<String> values) {
            addCriterion("ITEM_TYPE in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotIn(List<String> values) {
            addCriterion("ITEM_TYPE not in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeBetween(String value1, String value2) {
            addCriterion("ITEM_TYPE between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotBetween(String value1, String value2) {
            addCriterion("ITEM_TYPE not between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemContentIsNull() {
            addCriterion("ITEM_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andItemContentIsNotNull() {
            addCriterion("ITEM_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andItemContentEqualTo(String value) {
            addCriterion("ITEM_CONTENT =", value, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentNotEqualTo(String value) {
            addCriterion("ITEM_CONTENT <>", value, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentGreaterThan(String value) {
            addCriterion("ITEM_CONTENT >", value, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentGreaterThanOrEqualTo(String value) {
            addCriterion("ITEM_CONTENT >=", value, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentLessThan(String value) {
            addCriterion("ITEM_CONTENT <", value, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentLessThanOrEqualTo(String value) {
            addCriterion("ITEM_CONTENT <=", value, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentLike(String value) {
            addCriterion("ITEM_CONTENT like", value, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentNotLike(String value) {
            addCriterion("ITEM_CONTENT not like", value, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentIn(List<String> values) {
            addCriterion("ITEM_CONTENT in", values, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentNotIn(List<String> values) {
            addCriterion("ITEM_CONTENT not in", values, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentBetween(String value1, String value2) {
            addCriterion("ITEM_CONTENT between", value1, value2, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemContentNotBetween(String value1, String value2) {
            addCriterion("ITEM_CONTENT not between", value1, value2, "itemContent");
            return (Criteria) this;
        }

        public Criteria andItemEnableIsNull() {
            addCriterion("ITEM_ENABLE is null");
            return (Criteria) this;
        }

        public Criteria andItemEnableIsNotNull() {
            addCriterion("ITEM_ENABLE is not null");
            return (Criteria) this;
        }

        public Criteria andItemEnableEqualTo(Short value) {
            addCriterion("ITEM_ENABLE =", value, "itemEnable");
            return (Criteria) this;
        }

        public Criteria andItemEnableNotEqualTo(Short value) {
            addCriterion("ITEM_ENABLE <>", value, "itemEnable");
            return (Criteria) this;
        }

        public Criteria andItemEnableGreaterThan(Short value) {
            addCriterion("ITEM_ENABLE >", value, "itemEnable");
            return (Criteria) this;
        }

        public Criteria andItemEnableGreaterThanOrEqualTo(Short value) {
            addCriterion("ITEM_ENABLE >=", value, "itemEnable");
            return (Criteria) this;
        }

        public Criteria andItemEnableLessThan(Short value) {
            addCriterion("ITEM_ENABLE <", value, "itemEnable");
            return (Criteria) this;
        }

        public Criteria andItemEnableLessThanOrEqualTo(Short value) {
            addCriterion("ITEM_ENABLE <=", value, "itemEnable");
            return (Criteria) this;
        }

        public Criteria andItemEnableIn(List<Short> values) {
            addCriterion("ITEM_ENABLE in", values, "itemEnable");
            return (Criteria) this;
        }

        public Criteria andItemEnableNotIn(List<Short> values) {
            addCriterion("ITEM_ENABLE not in", values, "itemEnable");
            return (Criteria) this;
        }

        public Criteria andItemEnableBetween(Short value1, Short value2) {
            addCriterion("ITEM_ENABLE between", value1, value2, "itemEnable");
            return (Criteria) this;
        }

        public Criteria andItemEnableNotBetween(Short value1, Short value2) {
            addCriterion("ITEM_ENABLE not between", value1, value2, "itemEnable");
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