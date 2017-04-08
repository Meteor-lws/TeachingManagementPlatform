package com.ruicai.system.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EduClassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EduClassExample() {
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

        public Criteria andHeadTeacherIdIsNull() {
            addCriterion("HEAD_TEACHER_ID is null");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherIdIsNotNull() {
            addCriterion("HEAD_TEACHER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherIdEqualTo(String value) {
            addCriterion("HEAD_TEACHER_ID =", value, "headTeacherId");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherIdNotEqualTo(String value) {
            addCriterion("HEAD_TEACHER_ID <>", value, "headTeacherId");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherIdGreaterThan(String value) {
            addCriterion("HEAD_TEACHER_ID >", value, "headTeacherId");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherIdGreaterThanOrEqualTo(String value) {
            addCriterion("HEAD_TEACHER_ID >=", value, "headTeacherId");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherIdLessThan(String value) {
            addCriterion("HEAD_TEACHER_ID <", value, "headTeacherId");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherIdLessThanOrEqualTo(String value) {
            addCriterion("HEAD_TEACHER_ID <=", value, "headTeacherId");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherIdLike(String value) {
            addCriterion("HEAD_TEACHER_ID like", value, "headTeacherId");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherIdNotLike(String value) {
            addCriterion("HEAD_TEACHER_ID not like", value, "headTeacherId");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherIdIn(List<String> values) {
            addCriterion("HEAD_TEACHER_ID in", values, "headTeacherId");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherIdNotIn(List<String> values) {
            addCriterion("HEAD_TEACHER_ID not in", values, "headTeacherId");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherIdBetween(String value1, String value2) {
            addCriterion("HEAD_TEACHER_ID between", value1, value2, "headTeacherId");
            return (Criteria) this;
        }

        public Criteria andHeadTeacherIdNotBetween(String value1, String value2) {
            addCriterion("HEAD_TEACHER_ID not between", value1, value2, "headTeacherId");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIdIsNull() {
            addCriterion("MAIN_TEACHER_ID is null");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIdIsNotNull() {
            addCriterion("MAIN_TEACHER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIdEqualTo(String value) {
            addCriterion("MAIN_TEACHER_ID =", value, "mainTeacherId");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIdNotEqualTo(String value) {
            addCriterion("MAIN_TEACHER_ID <>", value, "mainTeacherId");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIdGreaterThan(String value) {
            addCriterion("MAIN_TEACHER_ID >", value, "mainTeacherId");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIdGreaterThanOrEqualTo(String value) {
            addCriterion("MAIN_TEACHER_ID >=", value, "mainTeacherId");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIdLessThan(String value) {
            addCriterion("MAIN_TEACHER_ID <", value, "mainTeacherId");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIdLessThanOrEqualTo(String value) {
            addCriterion("MAIN_TEACHER_ID <=", value, "mainTeacherId");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIdLike(String value) {
            addCriterion("MAIN_TEACHER_ID like", value, "mainTeacherId");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIdNotLike(String value) {
            addCriterion("MAIN_TEACHER_ID not like", value, "mainTeacherId");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIdIn(List<String> values) {
            addCriterion("MAIN_TEACHER_ID in", values, "mainTeacherId");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIdNotIn(List<String> values) {
            addCriterion("MAIN_TEACHER_ID not in", values, "mainTeacherId");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIdBetween(String value1, String value2) {
            addCriterion("MAIN_TEACHER_ID between", value1, value2, "mainTeacherId");
            return (Criteria) this;
        }

        public Criteria andMainTeacherIdNotBetween(String value1, String value2) {
            addCriterion("MAIN_TEACHER_ID not between", value1, value2, "mainTeacherId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdIsNull() {
            addCriterion("ASSISTANT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAssistantIdIsNotNull() {
            addCriterion("ASSISTANT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAssistantIdEqualTo(String value) {
            addCriterion("ASSISTANT_ID =", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdNotEqualTo(String value) {
            addCriterion("ASSISTANT_ID <>", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdGreaterThan(String value) {
            addCriterion("ASSISTANT_ID >", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdGreaterThanOrEqualTo(String value) {
            addCriterion("ASSISTANT_ID >=", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdLessThan(String value) {
            addCriterion("ASSISTANT_ID <", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdLessThanOrEqualTo(String value) {
            addCriterion("ASSISTANT_ID <=", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdLike(String value) {
            addCriterion("ASSISTANT_ID like", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdNotLike(String value) {
            addCriterion("ASSISTANT_ID not like", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdIn(List<String> values) {
            addCriterion("ASSISTANT_ID in", values, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdNotIn(List<String> values) {
            addCriterion("ASSISTANT_ID not in", values, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdBetween(String value1, String value2) {
            addCriterion("ASSISTANT_ID between", value1, value2, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdNotBetween(String value1, String value2) {
            addCriterion("ASSISTANT_ID not between", value1, value2, "assistantId");
            return (Criteria) this;
        }

        public Criteria andClassTypeIsNull() {
            addCriterion("CLASS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andClassTypeIsNotNull() {
            addCriterion("CLASS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andClassTypeEqualTo(String value) {
            addCriterion("CLASS_TYPE =", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeNotEqualTo(String value) {
            addCriterion("CLASS_TYPE <>", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeGreaterThan(String value) {
            addCriterion("CLASS_TYPE >", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CLASS_TYPE >=", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeLessThan(String value) {
            addCriterion("CLASS_TYPE <", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeLessThanOrEqualTo(String value) {
            addCriterion("CLASS_TYPE <=", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeLike(String value) {
            addCriterion("CLASS_TYPE like", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeNotLike(String value) {
            addCriterion("CLASS_TYPE not like", value, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeIn(List<String> values) {
            addCriterion("CLASS_TYPE in", values, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeNotIn(List<String> values) {
            addCriterion("CLASS_TYPE not in", values, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeBetween(String value1, String value2) {
            addCriterion("CLASS_TYPE between", value1, value2, "classType");
            return (Criteria) this;
        }

        public Criteria andClassTypeNotBetween(String value1, String value2) {
            addCriterion("CLASS_TYPE not between", value1, value2, "classType");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("CLASS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("CLASS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("CLASS_NAME =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("CLASS_NAME <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("CLASS_NAME >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("CLASS_NAME >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("CLASS_NAME <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("CLASS_NAME <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("CLASS_NAME like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("CLASS_NAME not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("CLASS_NAME in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("CLASS_NAME not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("CLASS_NAME between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("CLASS_NAME not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassStartDateIsNull() {
            addCriterion("CLASS_START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andClassStartDateIsNotNull() {
            addCriterion("CLASS_START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andClassStartDateEqualTo(Date value) {
            addCriterion("CLASS_START_DATE =", value, "classStartDate");
            return (Criteria) this;
        }

        public Criteria andClassStartDateNotEqualTo(Date value) {
            addCriterion("CLASS_START_DATE <>", value, "classStartDate");
            return (Criteria) this;
        }

        public Criteria andClassStartDateGreaterThan(Date value) {
            addCriterion("CLASS_START_DATE >", value, "classStartDate");
            return (Criteria) this;
        }

        public Criteria andClassStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CLASS_START_DATE >=", value, "classStartDate");
            return (Criteria) this;
        }

        public Criteria andClassStartDateLessThan(Date value) {
            addCriterion("CLASS_START_DATE <", value, "classStartDate");
            return (Criteria) this;
        }

        public Criteria andClassStartDateLessThanOrEqualTo(Date value) {
            addCriterion("CLASS_START_DATE <=", value, "classStartDate");
            return (Criteria) this;
        }

        public Criteria andClassStartDateIn(List<Date> values) {
            addCriterion("CLASS_START_DATE in", values, "classStartDate");
            return (Criteria) this;
        }

        public Criteria andClassStartDateNotIn(List<Date> values) {
            addCriterion("CLASS_START_DATE not in", values, "classStartDate");
            return (Criteria) this;
        }

        public Criteria andClassStartDateBetween(Date value1, Date value2) {
            addCriterion("CLASS_START_DATE between", value1, value2, "classStartDate");
            return (Criteria) this;
        }

        public Criteria andClassStartDateNotBetween(Date value1, Date value2) {
            addCriterion("CLASS_START_DATE not between", value1, value2, "classStartDate");
            return (Criteria) this;
        }

        public Criteria andClassEndDateIsNull() {
            addCriterion("CLASS_END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andClassEndDateIsNotNull() {
            addCriterion("CLASS_END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andClassEndDateEqualTo(Date value) {
            addCriterion("CLASS_END_DATE =", value, "classEndDate");
            return (Criteria) this;
        }

        public Criteria andClassEndDateNotEqualTo(Date value) {
            addCriterion("CLASS_END_DATE <>", value, "classEndDate");
            return (Criteria) this;
        }

        public Criteria andClassEndDateGreaterThan(Date value) {
            addCriterion("CLASS_END_DATE >", value, "classEndDate");
            return (Criteria) this;
        }

        public Criteria andClassEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CLASS_END_DATE >=", value, "classEndDate");
            return (Criteria) this;
        }

        public Criteria andClassEndDateLessThan(Date value) {
            addCriterion("CLASS_END_DATE <", value, "classEndDate");
            return (Criteria) this;
        }

        public Criteria andClassEndDateLessThanOrEqualTo(Date value) {
            addCriterion("CLASS_END_DATE <=", value, "classEndDate");
            return (Criteria) this;
        }

        public Criteria andClassEndDateIn(List<Date> values) {
            addCriterion("CLASS_END_DATE in", values, "classEndDate");
            return (Criteria) this;
        }

        public Criteria andClassEndDateNotIn(List<Date> values) {
            addCriterion("CLASS_END_DATE not in", values, "classEndDate");
            return (Criteria) this;
        }

        public Criteria andClassEndDateBetween(Date value1, Date value2) {
            addCriterion("CLASS_END_DATE between", value1, value2, "classEndDate");
            return (Criteria) this;
        }

        public Criteria andClassEndDateNotBetween(Date value1, Date value2) {
            addCriterion("CLASS_END_DATE not between", value1, value2, "classEndDate");
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