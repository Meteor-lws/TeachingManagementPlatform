package com.ruicai.system.po;

import java.util.ArrayList;
import java.util.List;

public class ExamPaperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExamPaperExample() {
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

        public Criteria andPaperStageIsNull() {
            addCriterion("PAPER_STAGE is null");
            return (Criteria) this;
        }

        public Criteria andPaperStageIsNotNull() {
            addCriterion("PAPER_STAGE is not null");
            return (Criteria) this;
        }

        public Criteria andPaperStageEqualTo(String value) {
            addCriterion("PAPER_STAGE =", value, "paperStage");
            return (Criteria) this;
        }

        public Criteria andPaperStageNotEqualTo(String value) {
            addCriterion("PAPER_STAGE <>", value, "paperStage");
            return (Criteria) this;
        }

        public Criteria andPaperStageGreaterThan(String value) {
            addCriterion("PAPER_STAGE >", value, "paperStage");
            return (Criteria) this;
        }

        public Criteria andPaperStageGreaterThanOrEqualTo(String value) {
            addCriterion("PAPER_STAGE >=", value, "paperStage");
            return (Criteria) this;
        }

        public Criteria andPaperStageLessThan(String value) {
            addCriterion("PAPER_STAGE <", value, "paperStage");
            return (Criteria) this;
        }

        public Criteria andPaperStageLessThanOrEqualTo(String value) {
            addCriterion("PAPER_STAGE <=", value, "paperStage");
            return (Criteria) this;
        }

        public Criteria andPaperStageLike(String value) {
            addCriterion("PAPER_STAGE like", value, "paperStage");
            return (Criteria) this;
        }

        public Criteria andPaperStageNotLike(String value) {
            addCriterion("PAPER_STAGE not like", value, "paperStage");
            return (Criteria) this;
        }

        public Criteria andPaperStageIn(List<String> values) {
            addCriterion("PAPER_STAGE in", values, "paperStage");
            return (Criteria) this;
        }

        public Criteria andPaperStageNotIn(List<String> values) {
            addCriterion("PAPER_STAGE not in", values, "paperStage");
            return (Criteria) this;
        }

        public Criteria andPaperStageBetween(String value1, String value2) {
            addCriterion("PAPER_STAGE between", value1, value2, "paperStage");
            return (Criteria) this;
        }

        public Criteria andPaperStageNotBetween(String value1, String value2) {
            addCriterion("PAPER_STAGE not between", value1, value2, "paperStage");
            return (Criteria) this;
        }

        public Criteria andPaperSubjectIsNull() {
            addCriterion("PAPER_SUBJECT is null");
            return (Criteria) this;
        }

        public Criteria andPaperSubjectIsNotNull() {
            addCriterion("PAPER_SUBJECT is not null");
            return (Criteria) this;
        }

        public Criteria andPaperSubjectEqualTo(String value) {
            addCriterion("PAPER_SUBJECT =", value, "paperSubject");
            return (Criteria) this;
        }

        public Criteria andPaperSubjectNotEqualTo(String value) {
            addCriterion("PAPER_SUBJECT <>", value, "paperSubject");
            return (Criteria) this;
        }

        public Criteria andPaperSubjectGreaterThan(String value) {
            addCriterion("PAPER_SUBJECT >", value, "paperSubject");
            return (Criteria) this;
        }

        public Criteria andPaperSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("PAPER_SUBJECT >=", value, "paperSubject");
            return (Criteria) this;
        }

        public Criteria andPaperSubjectLessThan(String value) {
            addCriterion("PAPER_SUBJECT <", value, "paperSubject");
            return (Criteria) this;
        }

        public Criteria andPaperSubjectLessThanOrEqualTo(String value) {
            addCriterion("PAPER_SUBJECT <=", value, "paperSubject");
            return (Criteria) this;
        }

        public Criteria andPaperSubjectLike(String value) {
            addCriterion("PAPER_SUBJECT like", value, "paperSubject");
            return (Criteria) this;
        }

        public Criteria andPaperSubjectNotLike(String value) {
            addCriterion("PAPER_SUBJECT not like", value, "paperSubject");
            return (Criteria) this;
        }

        public Criteria andPaperSubjectIn(List<String> values) {
            addCriterion("PAPER_SUBJECT in", values, "paperSubject");
            return (Criteria) this;
        }

        public Criteria andPaperSubjectNotIn(List<String> values) {
            addCriterion("PAPER_SUBJECT not in", values, "paperSubject");
            return (Criteria) this;
        }

        public Criteria andPaperSubjectBetween(String value1, String value2) {
            addCriterion("PAPER_SUBJECT between", value1, value2, "paperSubject");
            return (Criteria) this;
        }

        public Criteria andPaperSubjectNotBetween(String value1, String value2) {
            addCriterion("PAPER_SUBJECT not between", value1, value2, "paperSubject");
            return (Criteria) this;
        }

        public Criteria andPaperStatusIsNull() {
            addCriterion("PAPER_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPaperStatusIsNotNull() {
            addCriterion("PAPER_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPaperStatusEqualTo(String value) {
            addCriterion("PAPER_STATUS =", value, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusNotEqualTo(String value) {
            addCriterion("PAPER_STATUS <>", value, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusGreaterThan(String value) {
            addCriterion("PAPER_STATUS >", value, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PAPER_STATUS >=", value, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusLessThan(String value) {
            addCriterion("PAPER_STATUS <", value, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusLessThanOrEqualTo(String value) {
            addCriterion("PAPER_STATUS <=", value, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusLike(String value) {
            addCriterion("PAPER_STATUS like", value, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusNotLike(String value) {
            addCriterion("PAPER_STATUS not like", value, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusIn(List<String> values) {
            addCriterion("PAPER_STATUS in", values, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusNotIn(List<String> values) {
            addCriterion("PAPER_STATUS not in", values, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusBetween(String value1, String value2) {
            addCriterion("PAPER_STATUS between", value1, value2, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperStatusNotBetween(String value1, String value2) {
            addCriterion("PAPER_STATUS not between", value1, value2, "paperStatus");
            return (Criteria) this;
        }

        public Criteria andPaperAuthorIsNull() {
            addCriterion("PAPER_AUTHOR is null");
            return (Criteria) this;
        }

        public Criteria andPaperAuthorIsNotNull() {
            addCriterion("PAPER_AUTHOR is not null");
            return (Criteria) this;
        }

        public Criteria andPaperAuthorEqualTo(String value) {
            addCriterion("PAPER_AUTHOR =", value, "paperAuthor");
            return (Criteria) this;
        }

        public Criteria andPaperAuthorNotEqualTo(String value) {
            addCriterion("PAPER_AUTHOR <>", value, "paperAuthor");
            return (Criteria) this;
        }

        public Criteria andPaperAuthorGreaterThan(String value) {
            addCriterion("PAPER_AUTHOR >", value, "paperAuthor");
            return (Criteria) this;
        }

        public Criteria andPaperAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("PAPER_AUTHOR >=", value, "paperAuthor");
            return (Criteria) this;
        }

        public Criteria andPaperAuthorLessThan(String value) {
            addCriterion("PAPER_AUTHOR <", value, "paperAuthor");
            return (Criteria) this;
        }

        public Criteria andPaperAuthorLessThanOrEqualTo(String value) {
            addCriterion("PAPER_AUTHOR <=", value, "paperAuthor");
            return (Criteria) this;
        }

        public Criteria andPaperAuthorLike(String value) {
            addCriterion("PAPER_AUTHOR like", value, "paperAuthor");
            return (Criteria) this;
        }

        public Criteria andPaperAuthorNotLike(String value) {
            addCriterion("PAPER_AUTHOR not like", value, "paperAuthor");
            return (Criteria) this;
        }

        public Criteria andPaperAuthorIn(List<String> values) {
            addCriterion("PAPER_AUTHOR in", values, "paperAuthor");
            return (Criteria) this;
        }

        public Criteria andPaperAuthorNotIn(List<String> values) {
            addCriterion("PAPER_AUTHOR not in", values, "paperAuthor");
            return (Criteria) this;
        }

        public Criteria andPaperAuthorBetween(String value1, String value2) {
            addCriterion("PAPER_AUTHOR between", value1, value2, "paperAuthor");
            return (Criteria) this;
        }

        public Criteria andPaperAuthorNotBetween(String value1, String value2) {
            addCriterion("PAPER_AUTHOR not between", value1, value2, "paperAuthor");
            return (Criteria) this;
        }

        public Criteria andPaperTitleIsNull() {
            addCriterion("PAPER_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andPaperTitleIsNotNull() {
            addCriterion("PAPER_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andPaperTitleEqualTo(String value) {
            addCriterion("PAPER_TITLE =", value, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleNotEqualTo(String value) {
            addCriterion("PAPER_TITLE <>", value, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleGreaterThan(String value) {
            addCriterion("PAPER_TITLE >", value, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleGreaterThanOrEqualTo(String value) {
            addCriterion("PAPER_TITLE >=", value, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleLessThan(String value) {
            addCriterion("PAPER_TITLE <", value, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleLessThanOrEqualTo(String value) {
            addCriterion("PAPER_TITLE <=", value, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleLike(String value) {
            addCriterion("PAPER_TITLE like", value, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleNotLike(String value) {
            addCriterion("PAPER_TITLE not like", value, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleIn(List<String> values) {
            addCriterion("PAPER_TITLE in", values, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleNotIn(List<String> values) {
            addCriterion("PAPER_TITLE not in", values, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleBetween(String value1, String value2) {
            addCriterion("PAPER_TITLE between", value1, value2, "paperTitle");
            return (Criteria) this;
        }

        public Criteria andPaperTitleNotBetween(String value1, String value2) {
            addCriterion("PAPER_TITLE not between", value1, value2, "paperTitle");
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