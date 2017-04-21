package com.ruicai.evaluation.po.evaluation;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EvaluationMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EvaluationMessageExample() {
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

        public Criteria andMessageFromIsNull() {
            addCriterion("MESSAGE_FROM is null");
            return (Criteria) this;
        }

        public Criteria andMessageFromIsNotNull() {
            addCriterion("MESSAGE_FROM is not null");
            return (Criteria) this;
        }

        public Criteria andMessageFromEqualTo(String value) {
            addCriterion("MESSAGE_FROM =", value, "messageFrom");
            return (Criteria) this;
        }

        public Criteria andMessageFromNotEqualTo(String value) {
            addCriterion("MESSAGE_FROM <>", value, "messageFrom");
            return (Criteria) this;
        }

        public Criteria andMessageFromGreaterThan(String value) {
            addCriterion("MESSAGE_FROM >", value, "messageFrom");
            return (Criteria) this;
        }

        public Criteria andMessageFromGreaterThanOrEqualTo(String value) {
            addCriterion("MESSAGE_FROM >=", value, "messageFrom");
            return (Criteria) this;
        }

        public Criteria andMessageFromLessThan(String value) {
            addCriterion("MESSAGE_FROM <", value, "messageFrom");
            return (Criteria) this;
        }

        public Criteria andMessageFromLessThanOrEqualTo(String value) {
            addCriterion("MESSAGE_FROM <=", value, "messageFrom");
            return (Criteria) this;
        }

        public Criteria andMessageFromLike(String value) {
            addCriterion("MESSAGE_FROM like", value, "messageFrom");
            return (Criteria) this;
        }

        public Criteria andMessageFromNotLike(String value) {
            addCriterion("MESSAGE_FROM not like", value, "messageFrom");
            return (Criteria) this;
        }

        public Criteria andMessageFromIn(List<String> values) {
            addCriterion("MESSAGE_FROM in", values, "messageFrom");
            return (Criteria) this;
        }

        public Criteria andMessageFromNotIn(List<String> values) {
            addCriterion("MESSAGE_FROM not in", values, "messageFrom");
            return (Criteria) this;
        }

        public Criteria andMessageFromBetween(String value1, String value2) {
            addCriterion("MESSAGE_FROM between", value1, value2, "messageFrom");
            return (Criteria) this;
        }

        public Criteria andMessageFromNotBetween(String value1, String value2) {
            addCriterion("MESSAGE_FROM not between", value1, value2, "messageFrom");
            return (Criteria) this;
        }

        public Criteria andMessageToIsNull() {
            addCriterion("MESSAGE_TO is null");
            return (Criteria) this;
        }

        public Criteria andMessageToIsNotNull() {
            addCriterion("MESSAGE_TO is not null");
            return (Criteria) this;
        }

        public Criteria andMessageToEqualTo(String value) {
            addCriterion("MESSAGE_TO =", value, "messageTo");
            return (Criteria) this;
        }

        public Criteria andMessageToNotEqualTo(String value) {
            addCriterion("MESSAGE_TO <>", value, "messageTo");
            return (Criteria) this;
        }

        public Criteria andMessageToGreaterThan(String value) {
            addCriterion("MESSAGE_TO >", value, "messageTo");
            return (Criteria) this;
        }

        public Criteria andMessageToGreaterThanOrEqualTo(String value) {
            addCriterion("MESSAGE_TO >=", value, "messageTo");
            return (Criteria) this;
        }

        public Criteria andMessageToLessThan(String value) {
            addCriterion("MESSAGE_TO <", value, "messageTo");
            return (Criteria) this;
        }

        public Criteria andMessageToLessThanOrEqualTo(String value) {
            addCriterion("MESSAGE_TO <=", value, "messageTo");
            return (Criteria) this;
        }

        public Criteria andMessageToLike(String value) {
            addCriterion("MESSAGE_TO like", value, "messageTo");
            return (Criteria) this;
        }

        public Criteria andMessageToNotLike(String value) {
            addCriterion("MESSAGE_TO not like", value, "messageTo");
            return (Criteria) this;
        }

        public Criteria andMessageToIn(List<String> values) {
            addCriterion("MESSAGE_TO in", values, "messageTo");
            return (Criteria) this;
        }

        public Criteria andMessageToNotIn(List<String> values) {
            addCriterion("MESSAGE_TO not in", values, "messageTo");
            return (Criteria) this;
        }

        public Criteria andMessageToBetween(String value1, String value2) {
            addCriterion("MESSAGE_TO between", value1, value2, "messageTo");
            return (Criteria) this;
        }

        public Criteria andMessageToNotBetween(String value1, String value2) {
            addCriterion("MESSAGE_TO not between", value1, value2, "messageTo");
            return (Criteria) this;
        }

        public Criteria andMessageStatusIsNull() {
            addCriterion("MESSAGE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andMessageStatusIsNotNull() {
            addCriterion("MESSAGE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andMessageStatusEqualTo(String value) {
            addCriterion("MESSAGE_STATUS =", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusNotEqualTo(String value) {
            addCriterion("MESSAGE_STATUS <>", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusGreaterThan(String value) {
            addCriterion("MESSAGE_STATUS >", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusGreaterThanOrEqualTo(String value) {
            addCriterion("MESSAGE_STATUS >=", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusLessThan(String value) {
            addCriterion("MESSAGE_STATUS <", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusLessThanOrEqualTo(String value) {
            addCriterion("MESSAGE_STATUS <=", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusLike(String value) {
            addCriterion("MESSAGE_STATUS like", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusNotLike(String value) {
            addCriterion("MESSAGE_STATUS not like", value, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusIn(List<String> values) {
            addCriterion("MESSAGE_STATUS in", values, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusNotIn(List<String> values) {
            addCriterion("MESSAGE_STATUS not in", values, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusBetween(String value1, String value2) {
            addCriterion("MESSAGE_STATUS between", value1, value2, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageStatusNotBetween(String value1, String value2) {
            addCriterion("MESSAGE_STATUS not between", value1, value2, "messageStatus");
            return (Criteria) this;
        }

        public Criteria andMessageTimeIsNull() {
            addCriterion("MESSAGE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andMessageTimeIsNotNull() {
            addCriterion("MESSAGE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andMessageTimeEqualTo(Date value) {
            addCriterion("MESSAGE_TIME =", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeNotEqualTo(Date value) {
            addCriterion("MESSAGE_TIME <>", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeGreaterThan(Date value) {
            addCriterion("MESSAGE_TIME >", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MESSAGE_TIME >=", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeLessThan(Date value) {
            addCriterion("MESSAGE_TIME <", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeLessThanOrEqualTo(Date value) {
            addCriterion("MESSAGE_TIME <=", value, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeIn(List<Date> values) {
            addCriterion("MESSAGE_TIME in", values, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeNotIn(List<Date> values) {
            addCriterion("MESSAGE_TIME not in", values, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeBetween(Date value1, Date value2) {
            addCriterion("MESSAGE_TIME between", value1, value2, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageTimeNotBetween(Date value1, Date value2) {
            addCriterion("MESSAGE_TIME not between", value1, value2, "messageTime");
            return (Criteria) this;
        }

        public Criteria andMessageContentIsNull() {
            addCriterion("MESSAGE_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andMessageContentIsNotNull() {
            addCriterion("MESSAGE_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andMessageContentEqualTo(String value) {
            addCriterion("MESSAGE_CONTENT =", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotEqualTo(String value) {
            addCriterion("MESSAGE_CONTENT <>", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentGreaterThan(String value) {
            addCriterion("MESSAGE_CONTENT >", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentGreaterThanOrEqualTo(String value) {
            addCriterion("MESSAGE_CONTENT >=", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLessThan(String value) {
            addCriterion("MESSAGE_CONTENT <", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLessThanOrEqualTo(String value) {
            addCriterion("MESSAGE_CONTENT <=", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentLike(String value) {
            addCriterion("MESSAGE_CONTENT like", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotLike(String value) {
            addCriterion("MESSAGE_CONTENT not like", value, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentIn(List<String> values) {
            addCriterion("MESSAGE_CONTENT in", values, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotIn(List<String> values) {
            addCriterion("MESSAGE_CONTENT not in", values, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentBetween(String value1, String value2) {
            addCriterion("MESSAGE_CONTENT between", value1, value2, "messageContent");
            return (Criteria) this;
        }

        public Criteria andMessageContentNotBetween(String value1, String value2) {
            addCriterion("MESSAGE_CONTENT not between", value1, value2, "messageContent");
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