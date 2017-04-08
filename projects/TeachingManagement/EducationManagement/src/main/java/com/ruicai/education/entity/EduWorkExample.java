package com.ruicai.education.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EduWorkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EduWorkExample() {
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

        public Criteria andWorkTypeIsNull() {
            addCriterion("WORK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIsNotNull() {
            addCriterion("WORK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTypeEqualTo(String value) {
            addCriterion("WORK_TYPE =", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotEqualTo(String value) {
            addCriterion("WORK_TYPE <>", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThan(String value) {
            addCriterion("WORK_TYPE >", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_TYPE >=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThan(String value) {
            addCriterion("WORK_TYPE <", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLessThanOrEqualTo(String value) {
            addCriterion("WORK_TYPE <=", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeLike(String value) {
            addCriterion("WORK_TYPE like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotLike(String value) {
            addCriterion("WORK_TYPE not like", value, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeIn(List<String> values) {
            addCriterion("WORK_TYPE in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotIn(List<String> values) {
            addCriterion("WORK_TYPE not in", values, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeBetween(String value1, String value2) {
            addCriterion("WORK_TYPE between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkTypeNotBetween(String value1, String value2) {
            addCriterion("WORK_TYPE not between", value1, value2, "workType");
            return (Criteria) this;
        }

        public Criteria andWorkUrlIsNull() {
            addCriterion("WORK_URL is null");
            return (Criteria) this;
        }

        public Criteria andWorkUrlIsNotNull() {
            addCriterion("WORK_URL is not null");
            return (Criteria) this;
        }

        public Criteria andWorkUrlEqualTo(String value) {
            addCriterion("WORK_URL =", value, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlNotEqualTo(String value) {
            addCriterion("WORK_URL <>", value, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlGreaterThan(String value) {
            addCriterion("WORK_URL >", value, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_URL >=", value, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlLessThan(String value) {
            addCriterion("WORK_URL <", value, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlLessThanOrEqualTo(String value) {
            addCriterion("WORK_URL <=", value, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlLike(String value) {
            addCriterion("WORK_URL like", value, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlNotLike(String value) {
            addCriterion("WORK_URL not like", value, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlIn(List<String> values) {
            addCriterion("WORK_URL in", values, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlNotIn(List<String> values) {
            addCriterion("WORK_URL not in", values, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlBetween(String value1, String value2) {
            addCriterion("WORK_URL between", value1, value2, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUrlNotBetween(String value1, String value2) {
            addCriterion("WORK_URL not between", value1, value2, "workUrl");
            return (Criteria) this;
        }

        public Criteria andWorkUploadTimeIsNull() {
            addCriterion("WORK_UPLOAD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andWorkUploadTimeIsNotNull() {
            addCriterion("WORK_UPLOAD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andWorkUploadTimeEqualTo(Date value) {
            addCriterion("WORK_UPLOAD_TIME =", value, "workUploadTime");
            return (Criteria) this;
        }

        public Criteria andWorkUploadTimeNotEqualTo(Date value) {
            addCriterion("WORK_UPLOAD_TIME <>", value, "workUploadTime");
            return (Criteria) this;
        }

        public Criteria andWorkUploadTimeGreaterThan(Date value) {
            addCriterion("WORK_UPLOAD_TIME >", value, "workUploadTime");
            return (Criteria) this;
        }

        public Criteria andWorkUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("WORK_UPLOAD_TIME >=", value, "workUploadTime");
            return (Criteria) this;
        }

        public Criteria andWorkUploadTimeLessThan(Date value) {
            addCriterion("WORK_UPLOAD_TIME <", value, "workUploadTime");
            return (Criteria) this;
        }

        public Criteria andWorkUploadTimeLessThanOrEqualTo(Date value) {
            addCriterion("WORK_UPLOAD_TIME <=", value, "workUploadTime");
            return (Criteria) this;
        }

        public Criteria andWorkUploadTimeIn(List<Date> values) {
            addCriterion("WORK_UPLOAD_TIME in", values, "workUploadTime");
            return (Criteria) this;
        }

        public Criteria andWorkUploadTimeNotIn(List<Date> values) {
            addCriterion("WORK_UPLOAD_TIME not in", values, "workUploadTime");
            return (Criteria) this;
        }

        public Criteria andWorkUploadTimeBetween(Date value1, Date value2) {
            addCriterion("WORK_UPLOAD_TIME between", value1, value2, "workUploadTime");
            return (Criteria) this;
        }

        public Criteria andWorkUploadTimeNotBetween(Date value1, Date value2) {
            addCriterion("WORK_UPLOAD_TIME not between", value1, value2, "workUploadTime");
            return (Criteria) this;
        }

        public Criteria andWorkRemarkIsNull() {
            addCriterion("WORK_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andWorkRemarkIsNotNull() {
            addCriterion("WORK_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andWorkRemarkEqualTo(String value) {
            addCriterion("WORK_REMARK =", value, "workRemark");
            return (Criteria) this;
        }

        public Criteria andWorkRemarkNotEqualTo(String value) {
            addCriterion("WORK_REMARK <>", value, "workRemark");
            return (Criteria) this;
        }

        public Criteria andWorkRemarkGreaterThan(String value) {
            addCriterion("WORK_REMARK >", value, "workRemark");
            return (Criteria) this;
        }

        public Criteria andWorkRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_REMARK >=", value, "workRemark");
            return (Criteria) this;
        }

        public Criteria andWorkRemarkLessThan(String value) {
            addCriterion("WORK_REMARK <", value, "workRemark");
            return (Criteria) this;
        }

        public Criteria andWorkRemarkLessThanOrEqualTo(String value) {
            addCriterion("WORK_REMARK <=", value, "workRemark");
            return (Criteria) this;
        }

        public Criteria andWorkRemarkLike(String value) {
            addCriterion("WORK_REMARK like", value, "workRemark");
            return (Criteria) this;
        }

        public Criteria andWorkRemarkNotLike(String value) {
            addCriterion("WORK_REMARK not like", value, "workRemark");
            return (Criteria) this;
        }

        public Criteria andWorkRemarkIn(List<String> values) {
            addCriterion("WORK_REMARK in", values, "workRemark");
            return (Criteria) this;
        }

        public Criteria andWorkRemarkNotIn(List<String> values) {
            addCriterion("WORK_REMARK not in", values, "workRemark");
            return (Criteria) this;
        }

        public Criteria andWorkRemarkBetween(String value1, String value2) {
            addCriterion("WORK_REMARK between", value1, value2, "workRemark");
            return (Criteria) this;
        }

        public Criteria andWorkRemarkNotBetween(String value1, String value2) {
            addCriterion("WORK_REMARK not between", value1, value2, "workRemark");
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