package com.ruicai.evaluation.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EduAttendanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EduAttendanceExample() {
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

        public Criteria andAttStatusIsNull() {
            addCriterion("ATT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAttStatusIsNotNull() {
            addCriterion("ATT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAttStatusEqualTo(String value) {
            addCriterion("ATT_STATUS =", value, "attStatus");
            return (Criteria) this;
        }

        public Criteria andAttStatusNotEqualTo(String value) {
            addCriterion("ATT_STATUS <>", value, "attStatus");
            return (Criteria) this;
        }

        public Criteria andAttStatusGreaterThan(String value) {
            addCriterion("ATT_STATUS >", value, "attStatus");
            return (Criteria) this;
        }

        public Criteria andAttStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ATT_STATUS >=", value, "attStatus");
            return (Criteria) this;
        }

        public Criteria andAttStatusLessThan(String value) {
            addCriterion("ATT_STATUS <", value, "attStatus");
            return (Criteria) this;
        }

        public Criteria andAttStatusLessThanOrEqualTo(String value) {
            addCriterion("ATT_STATUS <=", value, "attStatus");
            return (Criteria) this;
        }

        public Criteria andAttStatusLike(String value) {
            addCriterion("ATT_STATUS like", value, "attStatus");
            return (Criteria) this;
        }

        public Criteria andAttStatusNotLike(String value) {
            addCriterion("ATT_STATUS not like", value, "attStatus");
            return (Criteria) this;
        }

        public Criteria andAttStatusIn(List<String> values) {
            addCriterion("ATT_STATUS in", values, "attStatus");
            return (Criteria) this;
        }

        public Criteria andAttStatusNotIn(List<String> values) {
            addCriterion("ATT_STATUS not in", values, "attStatus");
            return (Criteria) this;
        }

        public Criteria andAttStatusBetween(String value1, String value2) {
            addCriterion("ATT_STATUS between", value1, value2, "attStatus");
            return (Criteria) this;
        }

        public Criteria andAttStatusNotBetween(String value1, String value2) {
            addCriterion("ATT_STATUS not between", value1, value2, "attStatus");
            return (Criteria) this;
        }

        public Criteria andAttTimeIsNull() {
            addCriterion("ATT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAttTimeIsNotNull() {
            addCriterion("ATT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAttTimeEqualTo(Date value) {
            addCriterion("ATT_TIME =", value, "attTime");
            return (Criteria) this;
        }

        public Criteria andAttTimeNotEqualTo(Date value) {
            addCriterion("ATT_TIME <>", value, "attTime");
            return (Criteria) this;
        }

        public Criteria andAttTimeGreaterThan(Date value) {
            addCriterion("ATT_TIME >", value, "attTime");
            return (Criteria) this;
        }

        public Criteria andAttTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ATT_TIME >=", value, "attTime");
            return (Criteria) this;
        }

        public Criteria andAttTimeLessThan(Date value) {
            addCriterion("ATT_TIME <", value, "attTime");
            return (Criteria) this;
        }

        public Criteria andAttTimeLessThanOrEqualTo(Date value) {
            addCriterion("ATT_TIME <=", value, "attTime");
            return (Criteria) this;
        }

        public Criteria andAttTimeIn(List<Date> values) {
            addCriterion("ATT_TIME in", values, "attTime");
            return (Criteria) this;
        }

        public Criteria andAttTimeNotIn(List<Date> values) {
            addCriterion("ATT_TIME not in", values, "attTime");
            return (Criteria) this;
        }

        public Criteria andAttTimeBetween(Date value1, Date value2) {
            addCriterion("ATT_TIME between", value1, value2, "attTime");
            return (Criteria) this;
        }

        public Criteria andAttTimeNotBetween(Date value1, Date value2) {
            addCriterion("ATT_TIME not between", value1, value2, "attTime");
            return (Criteria) this;
        }

        public Criteria andAttRemarkIsNull() {
            addCriterion("ATT_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andAttRemarkIsNotNull() {
            addCriterion("ATT_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andAttRemarkEqualTo(String value) {
            addCriterion("ATT_REMARK =", value, "attRemark");
            return (Criteria) this;
        }

        public Criteria andAttRemarkNotEqualTo(String value) {
            addCriterion("ATT_REMARK <>", value, "attRemark");
            return (Criteria) this;
        }

        public Criteria andAttRemarkGreaterThan(String value) {
            addCriterion("ATT_REMARK >", value, "attRemark");
            return (Criteria) this;
        }

        public Criteria andAttRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("ATT_REMARK >=", value, "attRemark");
            return (Criteria) this;
        }

        public Criteria andAttRemarkLessThan(String value) {
            addCriterion("ATT_REMARK <", value, "attRemark");
            return (Criteria) this;
        }

        public Criteria andAttRemarkLessThanOrEqualTo(String value) {
            addCriterion("ATT_REMARK <=", value, "attRemark");
            return (Criteria) this;
        }

        public Criteria andAttRemarkLike(String value) {
            addCriterion("ATT_REMARK like", value, "attRemark");
            return (Criteria) this;
        }

        public Criteria andAttRemarkNotLike(String value) {
            addCriterion("ATT_REMARK not like", value, "attRemark");
            return (Criteria) this;
        }

        public Criteria andAttRemarkIn(List<String> values) {
            addCriterion("ATT_REMARK in", values, "attRemark");
            return (Criteria) this;
        }

        public Criteria andAttRemarkNotIn(List<String> values) {
            addCriterion("ATT_REMARK not in", values, "attRemark");
            return (Criteria) this;
        }

        public Criteria andAttRemarkBetween(String value1, String value2) {
            addCriterion("ATT_REMARK between", value1, value2, "attRemark");
            return (Criteria) this;
        }

        public Criteria andAttRemarkNotBetween(String value1, String value2) {
            addCriterion("ATT_REMARK not between", value1, value2, "attRemark");
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