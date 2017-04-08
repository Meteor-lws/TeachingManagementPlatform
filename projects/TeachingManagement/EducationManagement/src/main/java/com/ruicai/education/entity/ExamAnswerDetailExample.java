package com.ruicai.education.entity;

import java.util.ArrayList;
import java.util.List;

public class ExamAnswerDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExamAnswerDetailExample() {
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

        public Criteria andAnswerIdIsNull() {
            addCriterion("ANSWER_ID is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIsNotNull() {
            addCriterion("ANSWER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdEqualTo(String value) {
            addCriterion("ANSWER_ID =", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotEqualTo(String value) {
            addCriterion("ANSWER_ID <>", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThan(String value) {
            addCriterion("ANSWER_ID >", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThanOrEqualTo(String value) {
            addCriterion("ANSWER_ID >=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThan(String value) {
            addCriterion("ANSWER_ID <", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThanOrEqualTo(String value) {
            addCriterion("ANSWER_ID <=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLike(String value) {
            addCriterion("ANSWER_ID like", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotLike(String value) {
            addCriterion("ANSWER_ID not like", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIn(List<String> values) {
            addCriterion("ANSWER_ID in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotIn(List<String> values) {
            addCriterion("ANSWER_ID not in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdBetween(String value1, String value2) {
            addCriterion("ANSWER_ID between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotBetween(String value1, String value2) {
            addCriterion("ANSWER_ID not between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andPaperDetailIdIsNull() {
            addCriterion("PAPER_DETAIL_ID is null");
            return (Criteria) this;
        }

        public Criteria andPaperDetailIdIsNotNull() {
            addCriterion("PAPER_DETAIL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPaperDetailIdEqualTo(String value) {
            addCriterion("PAPER_DETAIL_ID =", value, "paperDetailId");
            return (Criteria) this;
        }

        public Criteria andPaperDetailIdNotEqualTo(String value) {
            addCriterion("PAPER_DETAIL_ID <>", value, "paperDetailId");
            return (Criteria) this;
        }

        public Criteria andPaperDetailIdGreaterThan(String value) {
            addCriterion("PAPER_DETAIL_ID >", value, "paperDetailId");
            return (Criteria) this;
        }

        public Criteria andPaperDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("PAPER_DETAIL_ID >=", value, "paperDetailId");
            return (Criteria) this;
        }

        public Criteria andPaperDetailIdLessThan(String value) {
            addCriterion("PAPER_DETAIL_ID <", value, "paperDetailId");
            return (Criteria) this;
        }

        public Criteria andPaperDetailIdLessThanOrEqualTo(String value) {
            addCriterion("PAPER_DETAIL_ID <=", value, "paperDetailId");
            return (Criteria) this;
        }

        public Criteria andPaperDetailIdLike(String value) {
            addCriterion("PAPER_DETAIL_ID like", value, "paperDetailId");
            return (Criteria) this;
        }

        public Criteria andPaperDetailIdNotLike(String value) {
            addCriterion("PAPER_DETAIL_ID not like", value, "paperDetailId");
            return (Criteria) this;
        }

        public Criteria andPaperDetailIdIn(List<String> values) {
            addCriterion("PAPER_DETAIL_ID in", values, "paperDetailId");
            return (Criteria) this;
        }

        public Criteria andPaperDetailIdNotIn(List<String> values) {
            addCriterion("PAPER_DETAIL_ID not in", values, "paperDetailId");
            return (Criteria) this;
        }

        public Criteria andPaperDetailIdBetween(String value1, String value2) {
            addCriterion("PAPER_DETAIL_ID between", value1, value2, "paperDetailId");
            return (Criteria) this;
        }

        public Criteria andPaperDetailIdNotBetween(String value1, String value2) {
            addCriterion("PAPER_DETAIL_ID not between", value1, value2, "paperDetailId");
            return (Criteria) this;
        }

        public Criteria andAnswerContentIsNull() {
            addCriterion("ANSWER_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andAnswerContentIsNotNull() {
            addCriterion("ANSWER_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerContentEqualTo(String value) {
            addCriterion("ANSWER_CONTENT =", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentNotEqualTo(String value) {
            addCriterion("ANSWER_CONTENT <>", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentGreaterThan(String value) {
            addCriterion("ANSWER_CONTENT >", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentGreaterThanOrEqualTo(String value) {
            addCriterion("ANSWER_CONTENT >=", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentLessThan(String value) {
            addCriterion("ANSWER_CONTENT <", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentLessThanOrEqualTo(String value) {
            addCriterion("ANSWER_CONTENT <=", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentLike(String value) {
            addCriterion("ANSWER_CONTENT like", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentNotLike(String value) {
            addCriterion("ANSWER_CONTENT not like", value, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentIn(List<String> values) {
            addCriterion("ANSWER_CONTENT in", values, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentNotIn(List<String> values) {
            addCriterion("ANSWER_CONTENT not in", values, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentBetween(String value1, String value2) {
            addCriterion("ANSWER_CONTENT between", value1, value2, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerContentNotBetween(String value1, String value2) {
            addCriterion("ANSWER_CONTENT not between", value1, value2, "answerContent");
            return (Criteria) this;
        }

        public Criteria andAnswerDetailScoreIsNull() {
            addCriterion("ANSWER_DETAIL_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andAnswerDetailScoreIsNotNull() {
            addCriterion("ANSWER_DETAIL_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerDetailScoreEqualTo(Short value) {
            addCriterion("ANSWER_DETAIL_SCORE =", value, "answerDetailScore");
            return (Criteria) this;
        }

        public Criteria andAnswerDetailScoreNotEqualTo(Short value) {
            addCriterion("ANSWER_DETAIL_SCORE <>", value, "answerDetailScore");
            return (Criteria) this;
        }

        public Criteria andAnswerDetailScoreGreaterThan(Short value) {
            addCriterion("ANSWER_DETAIL_SCORE >", value, "answerDetailScore");
            return (Criteria) this;
        }

        public Criteria andAnswerDetailScoreGreaterThanOrEqualTo(Short value) {
            addCriterion("ANSWER_DETAIL_SCORE >=", value, "answerDetailScore");
            return (Criteria) this;
        }

        public Criteria andAnswerDetailScoreLessThan(Short value) {
            addCriterion("ANSWER_DETAIL_SCORE <", value, "answerDetailScore");
            return (Criteria) this;
        }

        public Criteria andAnswerDetailScoreLessThanOrEqualTo(Short value) {
            addCriterion("ANSWER_DETAIL_SCORE <=", value, "answerDetailScore");
            return (Criteria) this;
        }

        public Criteria andAnswerDetailScoreIn(List<Short> values) {
            addCriterion("ANSWER_DETAIL_SCORE in", values, "answerDetailScore");
            return (Criteria) this;
        }

        public Criteria andAnswerDetailScoreNotIn(List<Short> values) {
            addCriterion("ANSWER_DETAIL_SCORE not in", values, "answerDetailScore");
            return (Criteria) this;
        }

        public Criteria andAnswerDetailScoreBetween(Short value1, Short value2) {
            addCriterion("ANSWER_DETAIL_SCORE between", value1, value2, "answerDetailScore");
            return (Criteria) this;
        }

        public Criteria andAnswerDetailScoreNotBetween(Short value1, Short value2) {
            addCriterion("ANSWER_DETAIL_SCORE not between", value1, value2, "answerDetailScore");
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