package com.ruicai.examination.po.education;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EducationAttendanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EducationAttendanceExample() {
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

        public Criteria andAttendanceStatusIsNull() {
            addCriterion("ATTENDANCE_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusIsNotNull() {
            addCriterion("ATTENDANCE_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusEqualTo(String value) {
            addCriterion("ATTENDANCE_STATUS =", value, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusNotEqualTo(String value) {
            addCriterion("ATTENDANCE_STATUS <>", value, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusGreaterThan(String value) {
            addCriterion("ATTENDANCE_STATUS >", value, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ATTENDANCE_STATUS >=", value, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusLessThan(String value) {
            addCriterion("ATTENDANCE_STATUS <", value, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusLessThanOrEqualTo(String value) {
            addCriterion("ATTENDANCE_STATUS <=", value, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusLike(String value) {
            addCriterion("ATTENDANCE_STATUS like", value, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusNotLike(String value) {
            addCriterion("ATTENDANCE_STATUS not like", value, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusIn(List<String> values) {
            addCriterion("ATTENDANCE_STATUS in", values, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusNotIn(List<String> values) {
            addCriterion("ATTENDANCE_STATUS not in", values, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusBetween(String value1, String value2) {
            addCriterion("ATTENDANCE_STATUS between", value1, value2, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceStatusNotBetween(String value1, String value2) {
            addCriterion("ATTENDANCE_STATUS not between", value1, value2, "attendanceStatus");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeIsNull() {
            addCriterion("ATTENDANCE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeIsNotNull() {
            addCriterion("ATTENDANCE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeEqualTo(Date value) {
            addCriterion("ATTENDANCE_TIME =", value, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeNotEqualTo(Date value) {
            addCriterion("ATTENDANCE_TIME <>", value, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeGreaterThan(Date value) {
            addCriterion("ATTENDANCE_TIME >", value, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ATTENDANCE_TIME >=", value, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeLessThan(Date value) {
            addCriterion("ATTENDANCE_TIME <", value, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeLessThanOrEqualTo(Date value) {
            addCriterion("ATTENDANCE_TIME <=", value, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeIn(List<Date> values) {
            addCriterion("ATTENDANCE_TIME in", values, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeNotIn(List<Date> values) {
            addCriterion("ATTENDANCE_TIME not in", values, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeBetween(Date value1, Date value2) {
            addCriterion("ATTENDANCE_TIME between", value1, value2, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceTimeNotBetween(Date value1, Date value2) {
            addCriterion("ATTENDANCE_TIME not between", value1, value2, "attendanceTime");
            return (Criteria) this;
        }

        public Criteria andAttendanceRemarkIsNull() {
            addCriterion("ATTENDANCE_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andAttendanceRemarkIsNotNull() {
            addCriterion("ATTENDANCE_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andAttendanceRemarkEqualTo(String value) {
            addCriterion("ATTENDANCE_REMARK =", value, "attendanceRemark");
            return (Criteria) this;
        }

        public Criteria andAttendanceRemarkNotEqualTo(String value) {
            addCriterion("ATTENDANCE_REMARK <>", value, "attendanceRemark");
            return (Criteria) this;
        }

        public Criteria andAttendanceRemarkGreaterThan(String value) {
            addCriterion("ATTENDANCE_REMARK >", value, "attendanceRemark");
            return (Criteria) this;
        }

        public Criteria andAttendanceRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("ATTENDANCE_REMARK >=", value, "attendanceRemark");
            return (Criteria) this;
        }

        public Criteria andAttendanceRemarkLessThan(String value) {
            addCriterion("ATTENDANCE_REMARK <", value, "attendanceRemark");
            return (Criteria) this;
        }

        public Criteria andAttendanceRemarkLessThanOrEqualTo(String value) {
            addCriterion("ATTENDANCE_REMARK <=", value, "attendanceRemark");
            return (Criteria) this;
        }

        public Criteria andAttendanceRemarkLike(String value) {
            addCriterion("ATTENDANCE_REMARK like", value, "attendanceRemark");
            return (Criteria) this;
        }

        public Criteria andAttendanceRemarkNotLike(String value) {
            addCriterion("ATTENDANCE_REMARK not like", value, "attendanceRemark");
            return (Criteria) this;
        }

        public Criteria andAttendanceRemarkIn(List<String> values) {
            addCriterion("ATTENDANCE_REMARK in", values, "attendanceRemark");
            return (Criteria) this;
        }

        public Criteria andAttendanceRemarkNotIn(List<String> values) {
            addCriterion("ATTENDANCE_REMARK not in", values, "attendanceRemark");
            return (Criteria) this;
        }

        public Criteria andAttendanceRemarkBetween(String value1, String value2) {
            addCriterion("ATTENDANCE_REMARK between", value1, value2, "attendanceRemark");
            return (Criteria) this;
        }

        public Criteria andAttendanceRemarkNotBetween(String value1, String value2) {
            addCriterion("ATTENDANCE_REMARK not between", value1, value2, "attendanceRemark");
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