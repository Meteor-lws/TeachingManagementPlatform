package com.ruicai.system.po;

import java.util.ArrayList;
import java.util.List;

public class ExamQuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExamQuestionExample() {
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

        public Criteria andQuestionSubjectIsNull() {
            addCriterion("QUESTION_SUBJECT is null");
            return (Criteria) this;
        }

        public Criteria andQuestionSubjectIsNotNull() {
            addCriterion("QUESTION_SUBJECT is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionSubjectEqualTo(String value) {
            addCriterion("QUESTION_SUBJECT =", value, "questionSubject");
            return (Criteria) this;
        }

        public Criteria andQuestionSubjectNotEqualTo(String value) {
            addCriterion("QUESTION_SUBJECT <>", value, "questionSubject");
            return (Criteria) this;
        }

        public Criteria andQuestionSubjectGreaterThan(String value) {
            addCriterion("QUESTION_SUBJECT >", value, "questionSubject");
            return (Criteria) this;
        }

        public Criteria andQuestionSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("QUESTION_SUBJECT >=", value, "questionSubject");
            return (Criteria) this;
        }

        public Criteria andQuestionSubjectLessThan(String value) {
            addCriterion("QUESTION_SUBJECT <", value, "questionSubject");
            return (Criteria) this;
        }

        public Criteria andQuestionSubjectLessThanOrEqualTo(String value) {
            addCriterion("QUESTION_SUBJECT <=", value, "questionSubject");
            return (Criteria) this;
        }

        public Criteria andQuestionSubjectLike(String value) {
            addCriterion("QUESTION_SUBJECT like", value, "questionSubject");
            return (Criteria) this;
        }

        public Criteria andQuestionSubjectNotLike(String value) {
            addCriterion("QUESTION_SUBJECT not like", value, "questionSubject");
            return (Criteria) this;
        }

        public Criteria andQuestionSubjectIn(List<String> values) {
            addCriterion("QUESTION_SUBJECT in", values, "questionSubject");
            return (Criteria) this;
        }

        public Criteria andQuestionSubjectNotIn(List<String> values) {
            addCriterion("QUESTION_SUBJECT not in", values, "questionSubject");
            return (Criteria) this;
        }

        public Criteria andQuestionSubjectBetween(String value1, String value2) {
            addCriterion("QUESTION_SUBJECT between", value1, value2, "questionSubject");
            return (Criteria) this;
        }

        public Criteria andQuestionSubjectNotBetween(String value1, String value2) {
            addCriterion("QUESTION_SUBJECT not between", value1, value2, "questionSubject");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIsNull() {
            addCriterion("QUESTION_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIsNotNull() {
            addCriterion("QUESTION_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeEqualTo(String value) {
            addCriterion("QUESTION_TYPE =", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotEqualTo(String value) {
            addCriterion("QUESTION_TYPE <>", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeGreaterThan(String value) {
            addCriterion("QUESTION_TYPE >", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("QUESTION_TYPE >=", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLessThan(String value) {
            addCriterion("QUESTION_TYPE <", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLessThanOrEqualTo(String value) {
            addCriterion("QUESTION_TYPE <=", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLike(String value) {
            addCriterion("QUESTION_TYPE like", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotLike(String value) {
            addCriterion("QUESTION_TYPE not like", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIn(List<String> values) {
            addCriterion("QUESTION_TYPE in", values, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotIn(List<String> values) {
            addCriterion("QUESTION_TYPE not in", values, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeBetween(String value1, String value2) {
            addCriterion("QUESTION_TYPE between", value1, value2, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotBetween(String value1, String value2) {
            addCriterion("QUESTION_TYPE not between", value1, value2, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreIsNull() {
            addCriterion("QUESTION_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreIsNotNull() {
            addCriterion("QUESTION_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreEqualTo(Short value) {
            addCriterion("QUESTION_SCORE =", value, "questionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreNotEqualTo(Short value) {
            addCriterion("QUESTION_SCORE <>", value, "questionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreGreaterThan(Short value) {
            addCriterion("QUESTION_SCORE >", value, "questionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreGreaterThanOrEqualTo(Short value) {
            addCriterion("QUESTION_SCORE >=", value, "questionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreLessThan(Short value) {
            addCriterion("QUESTION_SCORE <", value, "questionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreLessThanOrEqualTo(Short value) {
            addCriterion("QUESTION_SCORE <=", value, "questionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreIn(List<Short> values) {
            addCriterion("QUESTION_SCORE in", values, "questionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreNotIn(List<Short> values) {
            addCriterion("QUESTION_SCORE not in", values, "questionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreBetween(Short value1, Short value2) {
            addCriterion("QUESTION_SCORE between", value1, value2, "questionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionScoreNotBetween(Short value1, Short value2) {
            addCriterion("QUESTION_SCORE not between", value1, value2, "questionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionContentIsNull() {
            addCriterion("QUESTION_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andQuestionContentIsNotNull() {
            addCriterion("QUESTION_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionContentEqualTo(String value) {
            addCriterion("QUESTION_CONTENT =", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentNotEqualTo(String value) {
            addCriterion("QUESTION_CONTENT <>", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentGreaterThan(String value) {
            addCriterion("QUESTION_CONTENT >", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentGreaterThanOrEqualTo(String value) {
            addCriterion("QUESTION_CONTENT >=", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentLessThan(String value) {
            addCriterion("QUESTION_CONTENT <", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentLessThanOrEqualTo(String value) {
            addCriterion("QUESTION_CONTENT <=", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentLike(String value) {
            addCriterion("QUESTION_CONTENT like", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentNotLike(String value) {
            addCriterion("QUESTION_CONTENT not like", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentIn(List<String> values) {
            addCriterion("QUESTION_CONTENT in", values, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentNotIn(List<String> values) {
            addCriterion("QUESTION_CONTENT not in", values, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentBetween(String value1, String value2) {
            addCriterion("QUESTION_CONTENT between", value1, value2, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentNotBetween(String value1, String value2) {
            addCriterion("QUESTION_CONTENT not between", value1, value2, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionAnswerIsNull() {
            addCriterion("QUESTION_ANSWER is null");
            return (Criteria) this;
        }

        public Criteria andQuestionAnswerIsNotNull() {
            addCriterion("QUESTION_ANSWER is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionAnswerEqualTo(String value) {
            addCriterion("QUESTION_ANSWER =", value, "questionAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestionAnswerNotEqualTo(String value) {
            addCriterion("QUESTION_ANSWER <>", value, "questionAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestionAnswerGreaterThan(String value) {
            addCriterion("QUESTION_ANSWER >", value, "questionAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestionAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("QUESTION_ANSWER >=", value, "questionAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestionAnswerLessThan(String value) {
            addCriterion("QUESTION_ANSWER <", value, "questionAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestionAnswerLessThanOrEqualTo(String value) {
            addCriterion("QUESTION_ANSWER <=", value, "questionAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestionAnswerLike(String value) {
            addCriterion("QUESTION_ANSWER like", value, "questionAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestionAnswerNotLike(String value) {
            addCriterion("QUESTION_ANSWER not like", value, "questionAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestionAnswerIn(List<String> values) {
            addCriterion("QUESTION_ANSWER in", values, "questionAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestionAnswerNotIn(List<String> values) {
            addCriterion("QUESTION_ANSWER not in", values, "questionAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestionAnswerBetween(String value1, String value2) {
            addCriterion("QUESTION_ANSWER between", value1, value2, "questionAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestionAnswerNotBetween(String value1, String value2) {
            addCriterion("QUESTION_ANSWER not between", value1, value2, "questionAnswer");
            return (Criteria) this;
        }

        public Criteria andQuestionSelectionsIsNull() {
            addCriterion("QUESTION_SELECTIONS is null");
            return (Criteria) this;
        }

        public Criteria andQuestionSelectionsIsNotNull() {
            addCriterion("QUESTION_SELECTIONS is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionSelectionsEqualTo(Integer value) {
            addCriterion("QUESTION_SELECTIONS =", value, "questionSelections");
            return (Criteria) this;
        }

        public Criteria andQuestionSelectionsNotEqualTo(Integer value) {
            addCriterion("QUESTION_SELECTIONS <>", value, "questionSelections");
            return (Criteria) this;
        }

        public Criteria andQuestionSelectionsGreaterThan(Integer value) {
            addCriterion("QUESTION_SELECTIONS >", value, "questionSelections");
            return (Criteria) this;
        }

        public Criteria andQuestionSelectionsGreaterThanOrEqualTo(Integer value) {
            addCriterion("QUESTION_SELECTIONS >=", value, "questionSelections");
            return (Criteria) this;
        }

        public Criteria andQuestionSelectionsLessThan(Integer value) {
            addCriterion("QUESTION_SELECTIONS <", value, "questionSelections");
            return (Criteria) this;
        }

        public Criteria andQuestionSelectionsLessThanOrEqualTo(Integer value) {
            addCriterion("QUESTION_SELECTIONS <=", value, "questionSelections");
            return (Criteria) this;
        }

        public Criteria andQuestionSelectionsIn(List<Integer> values) {
            addCriterion("QUESTION_SELECTIONS in", values, "questionSelections");
            return (Criteria) this;
        }

        public Criteria andQuestionSelectionsNotIn(List<Integer> values) {
            addCriterion("QUESTION_SELECTIONS not in", values, "questionSelections");
            return (Criteria) this;
        }

        public Criteria andQuestionSelectionsBetween(Integer value1, Integer value2) {
            addCriterion("QUESTION_SELECTIONS between", value1, value2, "questionSelections");
            return (Criteria) this;
        }

        public Criteria andQuestionSelectionsNotBetween(Integer value1, Integer value2) {
            addCriterion("QUESTION_SELECTIONS not between", value1, value2, "questionSelections");
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