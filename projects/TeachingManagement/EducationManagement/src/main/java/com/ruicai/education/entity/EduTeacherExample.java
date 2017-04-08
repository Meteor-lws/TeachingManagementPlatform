package com.ruicai.education.entity;

import java.util.ArrayList;
import java.util.List;

public class EduTeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EduTeacherExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeIsNull() {
            addCriterion("TEACHER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeIsNotNull() {
            addCriterion("TEACHER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeEqualTo(String value) {
            addCriterion("TEACHER_TYPE =", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeNotEqualTo(String value) {
            addCriterion("TEACHER_TYPE <>", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeGreaterThan(String value) {
            addCriterion("TEACHER_TYPE >", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TEACHER_TYPE >=", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeLessThan(String value) {
            addCriterion("TEACHER_TYPE <", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeLessThanOrEqualTo(String value) {
            addCriterion("TEACHER_TYPE <=", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeLike(String value) {
            addCriterion("TEACHER_TYPE like", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeNotLike(String value) {
            addCriterion("TEACHER_TYPE not like", value, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeIn(List<String> values) {
            addCriterion("TEACHER_TYPE in", values, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeNotIn(List<String> values) {
            addCriterion("TEACHER_TYPE not in", values, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeBetween(String value1, String value2) {
            addCriterion("TEACHER_TYPE between", value1, value2, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherTypeNotBetween(String value1, String value2) {
            addCriterion("TEACHER_TYPE not between", value1, value2, "teacherType");
            return (Criteria) this;
        }

        public Criteria andTeacherSpecialityIsNull() {
            addCriterion("TEACHER_SPECIALITY is null");
            return (Criteria) this;
        }

        public Criteria andTeacherSpecialityIsNotNull() {
            addCriterion("TEACHER_SPECIALITY is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherSpecialityEqualTo(String value) {
            addCriterion("TEACHER_SPECIALITY =", value, "teacherSpeciality");
            return (Criteria) this;
        }

        public Criteria andTeacherSpecialityNotEqualTo(String value) {
            addCriterion("TEACHER_SPECIALITY <>", value, "teacherSpeciality");
            return (Criteria) this;
        }

        public Criteria andTeacherSpecialityGreaterThan(String value) {
            addCriterion("TEACHER_SPECIALITY >", value, "teacherSpeciality");
            return (Criteria) this;
        }

        public Criteria andTeacherSpecialityGreaterThanOrEqualTo(String value) {
            addCriterion("TEACHER_SPECIALITY >=", value, "teacherSpeciality");
            return (Criteria) this;
        }

        public Criteria andTeacherSpecialityLessThan(String value) {
            addCriterion("TEACHER_SPECIALITY <", value, "teacherSpeciality");
            return (Criteria) this;
        }

        public Criteria andTeacherSpecialityLessThanOrEqualTo(String value) {
            addCriterion("TEACHER_SPECIALITY <=", value, "teacherSpeciality");
            return (Criteria) this;
        }

        public Criteria andTeacherSpecialityLike(String value) {
            addCriterion("TEACHER_SPECIALITY like", value, "teacherSpeciality");
            return (Criteria) this;
        }

        public Criteria andTeacherSpecialityNotLike(String value) {
            addCriterion("TEACHER_SPECIALITY not like", value, "teacherSpeciality");
            return (Criteria) this;
        }

        public Criteria andTeacherSpecialityIn(List<String> values) {
            addCriterion("TEACHER_SPECIALITY in", values, "teacherSpeciality");
            return (Criteria) this;
        }

        public Criteria andTeacherSpecialityNotIn(List<String> values) {
            addCriterion("TEACHER_SPECIALITY not in", values, "teacherSpeciality");
            return (Criteria) this;
        }

        public Criteria andTeacherSpecialityBetween(String value1, String value2) {
            addCriterion("TEACHER_SPECIALITY between", value1, value2, "teacherSpeciality");
            return (Criteria) this;
        }

        public Criteria andTeacherSpecialityNotBetween(String value1, String value2) {
            addCriterion("TEACHER_SPECIALITY not between", value1, value2, "teacherSpeciality");
            return (Criteria) this;
        }

        public Criteria andTeacherSexIsNull() {
            addCriterion("TEACHER_SEX is null");
            return (Criteria) this;
        }

        public Criteria andTeacherSexIsNotNull() {
            addCriterion("TEACHER_SEX is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherSexEqualTo(String value) {
            addCriterion("TEACHER_SEX =", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotEqualTo(String value) {
            addCriterion("TEACHER_SEX <>", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexGreaterThan(String value) {
            addCriterion("TEACHER_SEX >", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexGreaterThanOrEqualTo(String value) {
            addCriterion("TEACHER_SEX >=", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexLessThan(String value) {
            addCriterion("TEACHER_SEX <", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexLessThanOrEqualTo(String value) {
            addCriterion("TEACHER_SEX <=", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexLike(String value) {
            addCriterion("TEACHER_SEX like", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotLike(String value) {
            addCriterion("TEACHER_SEX not like", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexIn(List<String> values) {
            addCriterion("TEACHER_SEX in", values, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotIn(List<String> values) {
            addCriterion("TEACHER_SEX not in", values, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexBetween(String value1, String value2) {
            addCriterion("TEACHER_SEX between", value1, value2, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotBetween(String value1, String value2) {
            addCriterion("TEACHER_SEX not between", value1, value2, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNull() {
            addCriterion("TEACHER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNotNull() {
            addCriterion("TEACHER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameEqualTo(String value) {
            addCriterion("TEACHER_NAME =", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotEqualTo(String value) {
            addCriterion("TEACHER_NAME <>", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThan(String value) {
            addCriterion("TEACHER_NAME >", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("TEACHER_NAME >=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThan(String value) {
            addCriterion("TEACHER_NAME <", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("TEACHER_NAME <=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLike(String value) {
            addCriterion("TEACHER_NAME like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotLike(String value) {
            addCriterion("TEACHER_NAME not like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIn(List<String> values) {
            addCriterion("TEACHER_NAME in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotIn(List<String> values) {
            addCriterion("TEACHER_NAME not in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameBetween(String value1, String value2) {
            addCriterion("TEACHER_NAME between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotBetween(String value1, String value2) {
            addCriterion("TEACHER_NAME not between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneIsNull() {
            addCriterion("TEACHER_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneIsNotNull() {
            addCriterion("TEACHER_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneEqualTo(String value) {
            addCriterion("TEACHER_PHONE =", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotEqualTo(String value) {
            addCriterion("TEACHER_PHONE <>", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneGreaterThan(String value) {
            addCriterion("TEACHER_PHONE >", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("TEACHER_PHONE >=", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneLessThan(String value) {
            addCriterion("TEACHER_PHONE <", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneLessThanOrEqualTo(String value) {
            addCriterion("TEACHER_PHONE <=", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneLike(String value) {
            addCriterion("TEACHER_PHONE like", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotLike(String value) {
            addCriterion("TEACHER_PHONE not like", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneIn(List<String> values) {
            addCriterion("TEACHER_PHONE in", values, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotIn(List<String> values) {
            addCriterion("TEACHER_PHONE not in", values, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneBetween(String value1, String value2) {
            addCriterion("TEACHER_PHONE between", value1, value2, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotBetween(String value1, String value2) {
            addCriterion("TEACHER_PHONE not between", value1, value2, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionIsNull() {
            addCriterion("TEACHER_INTRODUCTION is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionIsNotNull() {
            addCriterion("TEACHER_INTRODUCTION is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionEqualTo(String value) {
            addCriterion("TEACHER_INTRODUCTION =", value, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionNotEqualTo(String value) {
            addCriterion("TEACHER_INTRODUCTION <>", value, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionGreaterThan(String value) {
            addCriterion("TEACHER_INTRODUCTION >", value, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("TEACHER_INTRODUCTION >=", value, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionLessThan(String value) {
            addCriterion("TEACHER_INTRODUCTION <", value, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionLessThanOrEqualTo(String value) {
            addCriterion("TEACHER_INTRODUCTION <=", value, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionLike(String value) {
            addCriterion("TEACHER_INTRODUCTION like", value, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionNotLike(String value) {
            addCriterion("TEACHER_INTRODUCTION not like", value, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionIn(List<String> values) {
            addCriterion("TEACHER_INTRODUCTION in", values, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionNotIn(List<String> values) {
            addCriterion("TEACHER_INTRODUCTION not in", values, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionBetween(String value1, String value2) {
            addCriterion("TEACHER_INTRODUCTION between", value1, value2, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherIntroductionNotBetween(String value1, String value2) {
            addCriterion("TEACHER_INTRODUCTION not between", value1, value2, "teacherIntroduction");
            return (Criteria) this;
        }

        public Criteria andTeacherPictureIsNull() {
            addCriterion("TEACHER_PICTURE is null");
            return (Criteria) this;
        }

        public Criteria andTeacherPictureIsNotNull() {
            addCriterion("TEACHER_PICTURE is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherPictureEqualTo(String value) {
            addCriterion("TEACHER_PICTURE =", value, "teacherPicture");
            return (Criteria) this;
        }

        public Criteria andTeacherPictureNotEqualTo(String value) {
            addCriterion("TEACHER_PICTURE <>", value, "teacherPicture");
            return (Criteria) this;
        }

        public Criteria andTeacherPictureGreaterThan(String value) {
            addCriterion("TEACHER_PICTURE >", value, "teacherPicture");
            return (Criteria) this;
        }

        public Criteria andTeacherPictureGreaterThanOrEqualTo(String value) {
            addCriterion("TEACHER_PICTURE >=", value, "teacherPicture");
            return (Criteria) this;
        }

        public Criteria andTeacherPictureLessThan(String value) {
            addCriterion("TEACHER_PICTURE <", value, "teacherPicture");
            return (Criteria) this;
        }

        public Criteria andTeacherPictureLessThanOrEqualTo(String value) {
            addCriterion("TEACHER_PICTURE <=", value, "teacherPicture");
            return (Criteria) this;
        }

        public Criteria andTeacherPictureLike(String value) {
            addCriterion("TEACHER_PICTURE like", value, "teacherPicture");
            return (Criteria) this;
        }

        public Criteria andTeacherPictureNotLike(String value) {
            addCriterion("TEACHER_PICTURE not like", value, "teacherPicture");
            return (Criteria) this;
        }

        public Criteria andTeacherPictureIn(List<String> values) {
            addCriterion("TEACHER_PICTURE in", values, "teacherPicture");
            return (Criteria) this;
        }

        public Criteria andTeacherPictureNotIn(List<String> values) {
            addCriterion("TEACHER_PICTURE not in", values, "teacherPicture");
            return (Criteria) this;
        }

        public Criteria andTeacherPictureBetween(String value1, String value2) {
            addCriterion("TEACHER_PICTURE between", value1, value2, "teacherPicture");
            return (Criteria) this;
        }

        public Criteria andTeacherPictureNotBetween(String value1, String value2) {
            addCriterion("TEACHER_PICTURE not between", value1, value2, "teacherPicture");
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