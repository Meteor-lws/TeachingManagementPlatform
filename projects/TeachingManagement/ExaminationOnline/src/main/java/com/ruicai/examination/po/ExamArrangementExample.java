package com.ruicai.examination.po;

import java.util.ArrayList;
import java.util.List;

public class ExamArrangementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExamArrangementExample() {
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

        public Criteria andClassIdIsNull() {
            addCriterion("CLASS_ID is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("CLASS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(String value) {
            addCriterion("CLASS_ID =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(String value) {
            addCriterion("CLASS_ID <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(String value) {
            addCriterion("CLASS_ID >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(String value) {
            addCriterion("CLASS_ID >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(String value) {
            addCriterion("CLASS_ID <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(String value) {
            addCriterion("CLASS_ID <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLike(String value) {
            addCriterion("CLASS_ID like", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotLike(String value) {
            addCriterion("CLASS_ID not like", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<String> values) {
            addCriterion("CLASS_ID in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<String> values) {
            addCriterion("CLASS_ID not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(String value1, String value2) {
            addCriterion("CLASS_ID between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(String value1, String value2) {
            addCriterion("CLASS_ID not between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNull() {
            addCriterion("TEACHER_ID is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("TEACHER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(String value) {
            addCriterion("TEACHER_ID =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(String value) {
            addCriterion("TEACHER_ID <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(String value) {
            addCriterion("TEACHER_ID >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(String value) {
            addCriterion("TEACHER_ID >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(String value) {
            addCriterion("TEACHER_ID <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(String value) {
            addCriterion("TEACHER_ID <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLike(String value) {
            addCriterion("TEACHER_ID like", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotLike(String value) {
            addCriterion("TEACHER_ID not like", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<String> values) {
            addCriterion("TEACHER_ID in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<String> values) {
            addCriterion("TEACHER_ID not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(String value1, String value2) {
            addCriterion("TEACHER_ID between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(String value1, String value2) {
            addCriterion("TEACHER_ID not between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andPaperIdIsNull() {
            addCriterion("PAPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andPaperIdIsNotNull() {
            addCriterion("PAPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPaperIdEqualTo(String value) {
            addCriterion("PAPER_ID =", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotEqualTo(String value) {
            addCriterion("PAPER_ID <>", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThan(String value) {
            addCriterion("PAPER_ID >", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdGreaterThanOrEqualTo(String value) {
            addCriterion("PAPER_ID >=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThan(String value) {
            addCriterion("PAPER_ID <", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLessThanOrEqualTo(String value) {
            addCriterion("PAPER_ID <=", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdLike(String value) {
            addCriterion("PAPER_ID like", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotLike(String value) {
            addCriterion("PAPER_ID not like", value, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdIn(List<String> values) {
            addCriterion("PAPER_ID in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotIn(List<String> values) {
            addCriterion("PAPER_ID not in", values, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdBetween(String value1, String value2) {
            addCriterion("PAPER_ID between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andPaperIdNotBetween(String value1, String value2) {
            addCriterion("PAPER_ID not between", value1, value2, "paperId");
            return (Criteria) this;
        }

        public Criteria andExamStageIsNull() {
            addCriterion("EXAM_STAGE is null");
            return (Criteria) this;
        }

        public Criteria andExamStageIsNotNull() {
            addCriterion("EXAM_STAGE is not null");
            return (Criteria) this;
        }

        public Criteria andExamStageEqualTo(String value) {
            addCriterion("EXAM_STAGE =", value, "examStage");
            return (Criteria) this;
        }

        public Criteria andExamStageNotEqualTo(String value) {
            addCriterion("EXAM_STAGE <>", value, "examStage");
            return (Criteria) this;
        }

        public Criteria andExamStageGreaterThan(String value) {
            addCriterion("EXAM_STAGE >", value, "examStage");
            return (Criteria) this;
        }

        public Criteria andExamStageGreaterThanOrEqualTo(String value) {
            addCriterion("EXAM_STAGE >=", value, "examStage");
            return (Criteria) this;
        }

        public Criteria andExamStageLessThan(String value) {
            addCriterion("EXAM_STAGE <", value, "examStage");
            return (Criteria) this;
        }

        public Criteria andExamStageLessThanOrEqualTo(String value) {
            addCriterion("EXAM_STAGE <=", value, "examStage");
            return (Criteria) this;
        }

        public Criteria andExamStageLike(String value) {
            addCriterion("EXAM_STAGE like", value, "examStage");
            return (Criteria) this;
        }

        public Criteria andExamStageNotLike(String value) {
            addCriterion("EXAM_STAGE not like", value, "examStage");
            return (Criteria) this;
        }

        public Criteria andExamStageIn(List<String> values) {
            addCriterion("EXAM_STAGE in", values, "examStage");
            return (Criteria) this;
        }

        public Criteria andExamStageNotIn(List<String> values) {
            addCriterion("EXAM_STAGE not in", values, "examStage");
            return (Criteria) this;
        }

        public Criteria andExamStageBetween(String value1, String value2) {
            addCriterion("EXAM_STAGE between", value1, value2, "examStage");
            return (Criteria) this;
        }

        public Criteria andExamStageNotBetween(String value1, String value2) {
            addCriterion("EXAM_STAGE not between", value1, value2, "examStage");
            return (Criteria) this;
        }

        public Criteria andExamTimeIsNull() {
            addCriterion("EXAM_TIME is null");
            return (Criteria) this;
        }

        public Criteria andExamTimeIsNotNull() {
            addCriterion("EXAM_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andExamTimeEqualTo(Object value) {
            addCriterion("EXAM_TIME =", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeNotEqualTo(Object value) {
            addCriterion("EXAM_TIME <>", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeGreaterThan(Object value) {
            addCriterion("EXAM_TIME >", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeGreaterThanOrEqualTo(Object value) {
            addCriterion("EXAM_TIME >=", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeLessThan(Object value) {
            addCriterion("EXAM_TIME <", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeLessThanOrEqualTo(Object value) {
            addCriterion("EXAM_TIME <=", value, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeIn(List<Object> values) {
            addCriterion("EXAM_TIME in", values, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeNotIn(List<Object> values) {
            addCriterion("EXAM_TIME not in", values, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeBetween(Object value1, Object value2) {
            addCriterion("EXAM_TIME between", value1, value2, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamTimeNotBetween(Object value1, Object value2) {
            addCriterion("EXAM_TIME not between", value1, value2, "examTime");
            return (Criteria) this;
        }

        public Criteria andExamAddressIsNull() {
            addCriterion("EXAM_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andExamAddressIsNotNull() {
            addCriterion("EXAM_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andExamAddressEqualTo(String value) {
            addCriterion("EXAM_ADDRESS =", value, "examAddress");
            return (Criteria) this;
        }

        public Criteria andExamAddressNotEqualTo(String value) {
            addCriterion("EXAM_ADDRESS <>", value, "examAddress");
            return (Criteria) this;
        }

        public Criteria andExamAddressGreaterThan(String value) {
            addCriterion("EXAM_ADDRESS >", value, "examAddress");
            return (Criteria) this;
        }

        public Criteria andExamAddressGreaterThanOrEqualTo(String value) {
            addCriterion("EXAM_ADDRESS >=", value, "examAddress");
            return (Criteria) this;
        }

        public Criteria andExamAddressLessThan(String value) {
            addCriterion("EXAM_ADDRESS <", value, "examAddress");
            return (Criteria) this;
        }

        public Criteria andExamAddressLessThanOrEqualTo(String value) {
            addCriterion("EXAM_ADDRESS <=", value, "examAddress");
            return (Criteria) this;
        }

        public Criteria andExamAddressLike(String value) {
            addCriterion("EXAM_ADDRESS like", value, "examAddress");
            return (Criteria) this;
        }

        public Criteria andExamAddressNotLike(String value) {
            addCriterion("EXAM_ADDRESS not like", value, "examAddress");
            return (Criteria) this;
        }

        public Criteria andExamAddressIn(List<String> values) {
            addCriterion("EXAM_ADDRESS in", values, "examAddress");
            return (Criteria) this;
        }

        public Criteria andExamAddressNotIn(List<String> values) {
            addCriterion("EXAM_ADDRESS not in", values, "examAddress");
            return (Criteria) this;
        }

        public Criteria andExamAddressBetween(String value1, String value2) {
            addCriterion("EXAM_ADDRESS between", value1, value2, "examAddress");
            return (Criteria) this;
        }

        public Criteria andExamAddressNotBetween(String value1, String value2) {
            addCriterion("EXAM_ADDRESS not between", value1, value2, "examAddress");
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