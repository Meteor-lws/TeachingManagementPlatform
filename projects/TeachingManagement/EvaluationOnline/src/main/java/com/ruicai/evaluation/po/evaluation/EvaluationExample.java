package com.ruicai.evaluation.po.evaluation;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EvaluationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EvaluationExample() {
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

        public Criteria andStudentIdIsNull() {
            addCriterion("STUDENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("STUDENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(String value) {
            addCriterion("STUDENT_ID =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(String value) {
            addCriterion("STUDENT_ID <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(String value) {
            addCriterion("STUDENT_ID >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(String value) {
            addCriterion("STUDENT_ID >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(String value) {
            addCriterion("STUDENT_ID <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(String value) {
            addCriterion("STUDENT_ID <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLike(String value) {
            addCriterion("STUDENT_ID like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotLike(String value) {
            addCriterion("STUDENT_ID not like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<String> values) {
            addCriterion("STUDENT_ID in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<String> values) {
            addCriterion("STUDENT_ID not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(String value1, String value2) {
            addCriterion("STUDENT_ID between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(String value1, String value2) {
            addCriterion("STUDENT_ID not between", value1, value2, "studentId");
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

        public Criteria andEvaluationTimeIsNull() {
            addCriterion("EVALUATION_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeIsNotNull() {
            addCriterion("EVALUATION_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeEqualTo(Date value) {
            addCriterion("EVALUATION_TIME =", value, "evaluationTime");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeNotEqualTo(Date value) {
            addCriterion("EVALUATION_TIME <>", value, "evaluationTime");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeGreaterThan(Date value) {
            addCriterion("EVALUATION_TIME >", value, "evaluationTime");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EVALUATION_TIME >=", value, "evaluationTime");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeLessThan(Date value) {
            addCriterion("EVALUATION_TIME <", value, "evaluationTime");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeLessThanOrEqualTo(Date value) {
            addCriterion("EVALUATION_TIME <=", value, "evaluationTime");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeIn(List<Date> values) {
            addCriterion("EVALUATION_TIME in", values, "evaluationTime");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeNotIn(List<Date> values) {
            addCriterion("EVALUATION_TIME not in", values, "evaluationTime");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeBetween(Date value1, Date value2) {
            addCriterion("EVALUATION_TIME between", value1, value2, "evaluationTime");
            return (Criteria) this;
        }

        public Criteria andEvaluationTimeNotBetween(Date value1, Date value2) {
            addCriterion("EVALUATION_TIME not between", value1, value2, "evaluationTime");
            return (Criteria) this;
        }

        public Criteria andEvaluationFeedbackIsNull() {
            addCriterion("EVALUATION_FEEDBACK is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationFeedbackIsNotNull() {
            addCriterion("EVALUATION_FEEDBACK is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationFeedbackEqualTo(String value) {
            addCriterion("EVALUATION_FEEDBACK =", value, "evaluationFeedback");
            return (Criteria) this;
        }

        public Criteria andEvaluationFeedbackNotEqualTo(String value) {
            addCriterion("EVALUATION_FEEDBACK <>", value, "evaluationFeedback");
            return (Criteria) this;
        }

        public Criteria andEvaluationFeedbackGreaterThan(String value) {
            addCriterion("EVALUATION_FEEDBACK >", value, "evaluationFeedback");
            return (Criteria) this;
        }

        public Criteria andEvaluationFeedbackGreaterThanOrEqualTo(String value) {
            addCriterion("EVALUATION_FEEDBACK >=", value, "evaluationFeedback");
            return (Criteria) this;
        }

        public Criteria andEvaluationFeedbackLessThan(String value) {
            addCriterion("EVALUATION_FEEDBACK <", value, "evaluationFeedback");
            return (Criteria) this;
        }

        public Criteria andEvaluationFeedbackLessThanOrEqualTo(String value) {
            addCriterion("EVALUATION_FEEDBACK <=", value, "evaluationFeedback");
            return (Criteria) this;
        }

        public Criteria andEvaluationFeedbackLike(String value) {
            addCriterion("EVALUATION_FEEDBACK like", value, "evaluationFeedback");
            return (Criteria) this;
        }

        public Criteria andEvaluationFeedbackNotLike(String value) {
            addCriterion("EVALUATION_FEEDBACK not like", value, "evaluationFeedback");
            return (Criteria) this;
        }

        public Criteria andEvaluationFeedbackIn(List<String> values) {
            addCriterion("EVALUATION_FEEDBACK in", values, "evaluationFeedback");
            return (Criteria) this;
        }

        public Criteria andEvaluationFeedbackNotIn(List<String> values) {
            addCriterion("EVALUATION_FEEDBACK not in", values, "evaluationFeedback");
            return (Criteria) this;
        }

        public Criteria andEvaluationFeedbackBetween(String value1, String value2) {
            addCriterion("EVALUATION_FEEDBACK between", value1, value2, "evaluationFeedback");
            return (Criteria) this;
        }

        public Criteria andEvaluationFeedbackNotBetween(String value1, String value2) {
            addCriterion("EVALUATION_FEEDBACK not between", value1, value2, "evaluationFeedback");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreIsNull() {
            addCriterion("EVALUATION_SCORE is null");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreIsNotNull() {
            addCriterion("EVALUATION_SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreEqualTo(Short value) {
            addCriterion("EVALUATION_SCORE =", value, "evaluationScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreNotEqualTo(Short value) {
            addCriterion("EVALUATION_SCORE <>", value, "evaluationScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreGreaterThan(Short value) {
            addCriterion("EVALUATION_SCORE >", value, "evaluationScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreGreaterThanOrEqualTo(Short value) {
            addCriterion("EVALUATION_SCORE >=", value, "evaluationScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreLessThan(Short value) {
            addCriterion("EVALUATION_SCORE <", value, "evaluationScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreLessThanOrEqualTo(Short value) {
            addCriterion("EVALUATION_SCORE <=", value, "evaluationScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreIn(List<Short> values) {
            addCriterion("EVALUATION_SCORE in", values, "evaluationScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreNotIn(List<Short> values) {
            addCriterion("EVALUATION_SCORE not in", values, "evaluationScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreBetween(Short value1, Short value2) {
            addCriterion("EVALUATION_SCORE between", value1, value2, "evaluationScore");
            return (Criteria) this;
        }

        public Criteria andEvaluationScoreNotBetween(Short value1, Short value2) {
            addCriterion("EVALUATION_SCORE not between", value1, value2, "evaluationScore");
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