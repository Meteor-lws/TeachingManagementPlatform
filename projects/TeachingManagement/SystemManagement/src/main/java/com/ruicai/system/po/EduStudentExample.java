package com.ruicai.system.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EduStudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EduStudentExample() {
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

        public Criteria andStuEducationIsNull() {
            addCriterion("STU_EDUCATION is null");
            return (Criteria) this;
        }

        public Criteria andStuEducationIsNotNull() {
            addCriterion("STU_EDUCATION is not null");
            return (Criteria) this;
        }

        public Criteria andStuEducationEqualTo(String value) {
            addCriterion("STU_EDUCATION =", value, "stuEducation");
            return (Criteria) this;
        }

        public Criteria andStuEducationNotEqualTo(String value) {
            addCriterion("STU_EDUCATION <>", value, "stuEducation");
            return (Criteria) this;
        }

        public Criteria andStuEducationGreaterThan(String value) {
            addCriterion("STU_EDUCATION >", value, "stuEducation");
            return (Criteria) this;
        }

        public Criteria andStuEducationGreaterThanOrEqualTo(String value) {
            addCriterion("STU_EDUCATION >=", value, "stuEducation");
            return (Criteria) this;
        }

        public Criteria andStuEducationLessThan(String value) {
            addCriterion("STU_EDUCATION <", value, "stuEducation");
            return (Criteria) this;
        }

        public Criteria andStuEducationLessThanOrEqualTo(String value) {
            addCriterion("STU_EDUCATION <=", value, "stuEducation");
            return (Criteria) this;
        }

        public Criteria andStuEducationLike(String value) {
            addCriterion("STU_EDUCATION like", value, "stuEducation");
            return (Criteria) this;
        }

        public Criteria andStuEducationNotLike(String value) {
            addCriterion("STU_EDUCATION not like", value, "stuEducation");
            return (Criteria) this;
        }

        public Criteria andStuEducationIn(List<String> values) {
            addCriterion("STU_EDUCATION in", values, "stuEducation");
            return (Criteria) this;
        }

        public Criteria andStuEducationNotIn(List<String> values) {
            addCriterion("STU_EDUCATION not in", values, "stuEducation");
            return (Criteria) this;
        }

        public Criteria andStuEducationBetween(String value1, String value2) {
            addCriterion("STU_EDUCATION between", value1, value2, "stuEducation");
            return (Criteria) this;
        }

        public Criteria andStuEducationNotBetween(String value1, String value2) {
            addCriterion("STU_EDUCATION not between", value1, value2, "stuEducation");
            return (Criteria) this;
        }

        public Criteria andStuSexIsNull() {
            addCriterion("STU_SEX is null");
            return (Criteria) this;
        }

        public Criteria andStuSexIsNotNull() {
            addCriterion("STU_SEX is not null");
            return (Criteria) this;
        }

        public Criteria andStuSexEqualTo(String value) {
            addCriterion("STU_SEX =", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexNotEqualTo(String value) {
            addCriterion("STU_SEX <>", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexGreaterThan(String value) {
            addCriterion("STU_SEX >", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexGreaterThanOrEqualTo(String value) {
            addCriterion("STU_SEX >=", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexLessThan(String value) {
            addCriterion("STU_SEX <", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexLessThanOrEqualTo(String value) {
            addCriterion("STU_SEX <=", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexLike(String value) {
            addCriterion("STU_SEX like", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexNotLike(String value) {
            addCriterion("STU_SEX not like", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexIn(List<String> values) {
            addCriterion("STU_SEX in", values, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexNotIn(List<String> values) {
            addCriterion("STU_SEX not in", values, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexBetween(String value1, String value2) {
            addCriterion("STU_SEX between", value1, value2, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexNotBetween(String value1, String value2) {
            addCriterion("STU_SEX not between", value1, value2, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNull() {
            addCriterion("STU_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNotNull() {
            addCriterion("STU_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStuNameEqualTo(String value) {
            addCriterion("STU_NAME =", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotEqualTo(String value) {
            addCriterion("STU_NAME <>", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThan(String value) {
            addCriterion("STU_NAME >", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThanOrEqualTo(String value) {
            addCriterion("STU_NAME >=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThan(String value) {
            addCriterion("STU_NAME <", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThanOrEqualTo(String value) {
            addCriterion("STU_NAME <=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLike(String value) {
            addCriterion("STU_NAME like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotLike(String value) {
            addCriterion("STU_NAME not like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameIn(List<String> values) {
            addCriterion("STU_NAME in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotIn(List<String> values) {
            addCriterion("STU_NAME not in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameBetween(String value1, String value2) {
            addCriterion("STU_NAME between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotBetween(String value1, String value2) {
            addCriterion("STU_NAME not between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuIdNumberIsNull() {
            addCriterion("STU_ID_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andStuIdNumberIsNotNull() {
            addCriterion("STU_ID_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdNumberEqualTo(String value) {
            addCriterion("STU_ID_NUMBER =", value, "stuIdNumber");
            return (Criteria) this;
        }

        public Criteria andStuIdNumberNotEqualTo(String value) {
            addCriterion("STU_ID_NUMBER <>", value, "stuIdNumber");
            return (Criteria) this;
        }

        public Criteria andStuIdNumberGreaterThan(String value) {
            addCriterion("STU_ID_NUMBER >", value, "stuIdNumber");
            return (Criteria) this;
        }

        public Criteria andStuIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("STU_ID_NUMBER >=", value, "stuIdNumber");
            return (Criteria) this;
        }

        public Criteria andStuIdNumberLessThan(String value) {
            addCriterion("STU_ID_NUMBER <", value, "stuIdNumber");
            return (Criteria) this;
        }

        public Criteria andStuIdNumberLessThanOrEqualTo(String value) {
            addCriterion("STU_ID_NUMBER <=", value, "stuIdNumber");
            return (Criteria) this;
        }

        public Criteria andStuIdNumberLike(String value) {
            addCriterion("STU_ID_NUMBER like", value, "stuIdNumber");
            return (Criteria) this;
        }

        public Criteria andStuIdNumberNotLike(String value) {
            addCriterion("STU_ID_NUMBER not like", value, "stuIdNumber");
            return (Criteria) this;
        }

        public Criteria andStuIdNumberIn(List<String> values) {
            addCriterion("STU_ID_NUMBER in", values, "stuIdNumber");
            return (Criteria) this;
        }

        public Criteria andStuIdNumberNotIn(List<String> values) {
            addCriterion("STU_ID_NUMBER not in", values, "stuIdNumber");
            return (Criteria) this;
        }

        public Criteria andStuIdNumberBetween(String value1, String value2) {
            addCriterion("STU_ID_NUMBER between", value1, value2, "stuIdNumber");
            return (Criteria) this;
        }

        public Criteria andStuIdNumberNotBetween(String value1, String value2) {
            addCriterion("STU_ID_NUMBER not between", value1, value2, "stuIdNumber");
            return (Criteria) this;
        }

        public Criteria andStuSchoolIsNull() {
            addCriterion("STU_SCHOOL is null");
            return (Criteria) this;
        }

        public Criteria andStuSchoolIsNotNull() {
            addCriterion("STU_SCHOOL is not null");
            return (Criteria) this;
        }

        public Criteria andStuSchoolEqualTo(String value) {
            addCriterion("STU_SCHOOL =", value, "stuSchool");
            return (Criteria) this;
        }

        public Criteria andStuSchoolNotEqualTo(String value) {
            addCriterion("STU_SCHOOL <>", value, "stuSchool");
            return (Criteria) this;
        }

        public Criteria andStuSchoolGreaterThan(String value) {
            addCriterion("STU_SCHOOL >", value, "stuSchool");
            return (Criteria) this;
        }

        public Criteria andStuSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("STU_SCHOOL >=", value, "stuSchool");
            return (Criteria) this;
        }

        public Criteria andStuSchoolLessThan(String value) {
            addCriterion("STU_SCHOOL <", value, "stuSchool");
            return (Criteria) this;
        }

        public Criteria andStuSchoolLessThanOrEqualTo(String value) {
            addCriterion("STU_SCHOOL <=", value, "stuSchool");
            return (Criteria) this;
        }

        public Criteria andStuSchoolLike(String value) {
            addCriterion("STU_SCHOOL like", value, "stuSchool");
            return (Criteria) this;
        }

        public Criteria andStuSchoolNotLike(String value) {
            addCriterion("STU_SCHOOL not like", value, "stuSchool");
            return (Criteria) this;
        }

        public Criteria andStuSchoolIn(List<String> values) {
            addCriterion("STU_SCHOOL in", values, "stuSchool");
            return (Criteria) this;
        }

        public Criteria andStuSchoolNotIn(List<String> values) {
            addCriterion("STU_SCHOOL not in", values, "stuSchool");
            return (Criteria) this;
        }

        public Criteria andStuSchoolBetween(String value1, String value2) {
            addCriterion("STU_SCHOOL between", value1, value2, "stuSchool");
            return (Criteria) this;
        }

        public Criteria andStuSchoolNotBetween(String value1, String value2) {
            addCriterion("STU_SCHOOL not between", value1, value2, "stuSchool");
            return (Criteria) this;
        }

        public Criteria andStuSpecialtyIsNull() {
            addCriterion("STU_SPECIALTY is null");
            return (Criteria) this;
        }

        public Criteria andStuSpecialtyIsNotNull() {
            addCriterion("STU_SPECIALTY is not null");
            return (Criteria) this;
        }

        public Criteria andStuSpecialtyEqualTo(String value) {
            addCriterion("STU_SPECIALTY =", value, "stuSpecialty");
            return (Criteria) this;
        }

        public Criteria andStuSpecialtyNotEqualTo(String value) {
            addCriterion("STU_SPECIALTY <>", value, "stuSpecialty");
            return (Criteria) this;
        }

        public Criteria andStuSpecialtyGreaterThan(String value) {
            addCriterion("STU_SPECIALTY >", value, "stuSpecialty");
            return (Criteria) this;
        }

        public Criteria andStuSpecialtyGreaterThanOrEqualTo(String value) {
            addCriterion("STU_SPECIALTY >=", value, "stuSpecialty");
            return (Criteria) this;
        }

        public Criteria andStuSpecialtyLessThan(String value) {
            addCriterion("STU_SPECIALTY <", value, "stuSpecialty");
            return (Criteria) this;
        }

        public Criteria andStuSpecialtyLessThanOrEqualTo(String value) {
            addCriterion("STU_SPECIALTY <=", value, "stuSpecialty");
            return (Criteria) this;
        }

        public Criteria andStuSpecialtyLike(String value) {
            addCriterion("STU_SPECIALTY like", value, "stuSpecialty");
            return (Criteria) this;
        }

        public Criteria andStuSpecialtyNotLike(String value) {
            addCriterion("STU_SPECIALTY not like", value, "stuSpecialty");
            return (Criteria) this;
        }

        public Criteria andStuSpecialtyIn(List<String> values) {
            addCriterion("STU_SPECIALTY in", values, "stuSpecialty");
            return (Criteria) this;
        }

        public Criteria andStuSpecialtyNotIn(List<String> values) {
            addCriterion("STU_SPECIALTY not in", values, "stuSpecialty");
            return (Criteria) this;
        }

        public Criteria andStuSpecialtyBetween(String value1, String value2) {
            addCriterion("STU_SPECIALTY between", value1, value2, "stuSpecialty");
            return (Criteria) this;
        }

        public Criteria andStuSpecialtyNotBetween(String value1, String value2) {
            addCriterion("STU_SPECIALTY not between", value1, value2, "stuSpecialty");
            return (Criteria) this;
        }

        public Criteria andStuGraduationIsNull() {
            addCriterion("STU_GRADUATION is null");
            return (Criteria) this;
        }

        public Criteria andStuGraduationIsNotNull() {
            addCriterion("STU_GRADUATION is not null");
            return (Criteria) this;
        }

        public Criteria andStuGraduationEqualTo(Date value) {
            addCriterion("STU_GRADUATION =", value, "stuGraduation");
            return (Criteria) this;
        }

        public Criteria andStuGraduationNotEqualTo(Date value) {
            addCriterion("STU_GRADUATION <>", value, "stuGraduation");
            return (Criteria) this;
        }

        public Criteria andStuGraduationGreaterThan(Date value) {
            addCriterion("STU_GRADUATION >", value, "stuGraduation");
            return (Criteria) this;
        }

        public Criteria andStuGraduationGreaterThanOrEqualTo(Date value) {
            addCriterion("STU_GRADUATION >=", value, "stuGraduation");
            return (Criteria) this;
        }

        public Criteria andStuGraduationLessThan(Date value) {
            addCriterion("STU_GRADUATION <", value, "stuGraduation");
            return (Criteria) this;
        }

        public Criteria andStuGraduationLessThanOrEqualTo(Date value) {
            addCriterion("STU_GRADUATION <=", value, "stuGraduation");
            return (Criteria) this;
        }

        public Criteria andStuGraduationIn(List<Date> values) {
            addCriterion("STU_GRADUATION in", values, "stuGraduation");
            return (Criteria) this;
        }

        public Criteria andStuGraduationNotIn(List<Date> values) {
            addCriterion("STU_GRADUATION not in", values, "stuGraduation");
            return (Criteria) this;
        }

        public Criteria andStuGraduationBetween(Date value1, Date value2) {
            addCriterion("STU_GRADUATION between", value1, value2, "stuGraduation");
            return (Criteria) this;
        }

        public Criteria andStuGraduationNotBetween(Date value1, Date value2) {
            addCriterion("STU_GRADUATION not between", value1, value2, "stuGraduation");
            return (Criteria) this;
        }

        public Criteria andStuPhoneIsNull() {
            addCriterion("STU_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andStuPhoneIsNotNull() {
            addCriterion("STU_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andStuPhoneEqualTo(String value) {
            addCriterion("STU_PHONE =", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotEqualTo(String value) {
            addCriterion("STU_PHONE <>", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneGreaterThan(String value) {
            addCriterion("STU_PHONE >", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("STU_PHONE >=", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLessThan(String value) {
            addCriterion("STU_PHONE <", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLessThanOrEqualTo(String value) {
            addCriterion("STU_PHONE <=", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneLike(String value) {
            addCriterion("STU_PHONE like", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotLike(String value) {
            addCriterion("STU_PHONE not like", value, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneIn(List<String> values) {
            addCriterion("STU_PHONE in", values, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotIn(List<String> values) {
            addCriterion("STU_PHONE not in", values, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneBetween(String value1, String value2) {
            addCriterion("STU_PHONE between", value1, value2, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuPhoneNotBetween(String value1, String value2) {
            addCriterion("STU_PHONE not between", value1, value2, "stuPhone");
            return (Criteria) this;
        }

        public Criteria andStuFamilyPhoneIsNull() {
            addCriterion("STU_FAMILY_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andStuFamilyPhoneIsNotNull() {
            addCriterion("STU_FAMILY_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andStuFamilyPhoneEqualTo(String value) {
            addCriterion("STU_FAMILY_PHONE =", value, "stuFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStuFamilyPhoneNotEqualTo(String value) {
            addCriterion("STU_FAMILY_PHONE <>", value, "stuFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStuFamilyPhoneGreaterThan(String value) {
            addCriterion("STU_FAMILY_PHONE >", value, "stuFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStuFamilyPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("STU_FAMILY_PHONE >=", value, "stuFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStuFamilyPhoneLessThan(String value) {
            addCriterion("STU_FAMILY_PHONE <", value, "stuFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStuFamilyPhoneLessThanOrEqualTo(String value) {
            addCriterion("STU_FAMILY_PHONE <=", value, "stuFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStuFamilyPhoneLike(String value) {
            addCriterion("STU_FAMILY_PHONE like", value, "stuFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStuFamilyPhoneNotLike(String value) {
            addCriterion("STU_FAMILY_PHONE not like", value, "stuFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStuFamilyPhoneIn(List<String> values) {
            addCriterion("STU_FAMILY_PHONE in", values, "stuFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStuFamilyPhoneNotIn(List<String> values) {
            addCriterion("STU_FAMILY_PHONE not in", values, "stuFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStuFamilyPhoneBetween(String value1, String value2) {
            addCriterion("STU_FAMILY_PHONE between", value1, value2, "stuFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStuFamilyPhoneNotBetween(String value1, String value2) {
            addCriterion("STU_FAMILY_PHONE not between", value1, value2, "stuFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStuPictureIsNull() {
            addCriterion("STU_PICTURE is null");
            return (Criteria) this;
        }

        public Criteria andStuPictureIsNotNull() {
            addCriterion("STU_PICTURE is not null");
            return (Criteria) this;
        }

        public Criteria andStuPictureEqualTo(String value) {
            addCriterion("STU_PICTURE =", value, "stuPicture");
            return (Criteria) this;
        }

        public Criteria andStuPictureNotEqualTo(String value) {
            addCriterion("STU_PICTURE <>", value, "stuPicture");
            return (Criteria) this;
        }

        public Criteria andStuPictureGreaterThan(String value) {
            addCriterion("STU_PICTURE >", value, "stuPicture");
            return (Criteria) this;
        }

        public Criteria andStuPictureGreaterThanOrEqualTo(String value) {
            addCriterion("STU_PICTURE >=", value, "stuPicture");
            return (Criteria) this;
        }

        public Criteria andStuPictureLessThan(String value) {
            addCriterion("STU_PICTURE <", value, "stuPicture");
            return (Criteria) this;
        }

        public Criteria andStuPictureLessThanOrEqualTo(String value) {
            addCriterion("STU_PICTURE <=", value, "stuPicture");
            return (Criteria) this;
        }

        public Criteria andStuPictureLike(String value) {
            addCriterion("STU_PICTURE like", value, "stuPicture");
            return (Criteria) this;
        }

        public Criteria andStuPictureNotLike(String value) {
            addCriterion("STU_PICTURE not like", value, "stuPicture");
            return (Criteria) this;
        }

        public Criteria andStuPictureIn(List<String> values) {
            addCriterion("STU_PICTURE in", values, "stuPicture");
            return (Criteria) this;
        }

        public Criteria andStuPictureNotIn(List<String> values) {
            addCriterion("STU_PICTURE not in", values, "stuPicture");
            return (Criteria) this;
        }

        public Criteria andStuPictureBetween(String value1, String value2) {
            addCriterion("STU_PICTURE between", value1, value2, "stuPicture");
            return (Criteria) this;
        }

        public Criteria andStuPictureNotBetween(String value1, String value2) {
            addCriterion("STU_PICTURE not between", value1, value2, "stuPicture");
            return (Criteria) this;
        }

        public Criteria andStuInsuranceIsNull() {
            addCriterion("STU_INSURANCE is null");
            return (Criteria) this;
        }

        public Criteria andStuInsuranceIsNotNull() {
            addCriterion("STU_INSURANCE is not null");
            return (Criteria) this;
        }

        public Criteria andStuInsuranceEqualTo(Short value) {
            addCriterion("STU_INSURANCE =", value, "stuInsurance");
            return (Criteria) this;
        }

        public Criteria andStuInsuranceNotEqualTo(Short value) {
            addCriterion("STU_INSURANCE <>", value, "stuInsurance");
            return (Criteria) this;
        }

        public Criteria andStuInsuranceGreaterThan(Short value) {
            addCriterion("STU_INSURANCE >", value, "stuInsurance");
            return (Criteria) this;
        }

        public Criteria andStuInsuranceGreaterThanOrEqualTo(Short value) {
            addCriterion("STU_INSURANCE >=", value, "stuInsurance");
            return (Criteria) this;
        }

        public Criteria andStuInsuranceLessThan(Short value) {
            addCriterion("STU_INSURANCE <", value, "stuInsurance");
            return (Criteria) this;
        }

        public Criteria andStuInsuranceLessThanOrEqualTo(Short value) {
            addCriterion("STU_INSURANCE <=", value, "stuInsurance");
            return (Criteria) this;
        }

        public Criteria andStuInsuranceIn(List<Short> values) {
            addCriterion("STU_INSURANCE in", values, "stuInsurance");
            return (Criteria) this;
        }

        public Criteria andStuInsuranceNotIn(List<Short> values) {
            addCriterion("STU_INSURANCE not in", values, "stuInsurance");
            return (Criteria) this;
        }

        public Criteria andStuInsuranceBetween(Short value1, Short value2) {
            addCriterion("STU_INSURANCE between", value1, value2, "stuInsurance");
            return (Criteria) this;
        }

        public Criteria andStuInsuranceNotBetween(Short value1, Short value2) {
            addCriterion("STU_INSURANCE not between", value1, value2, "stuInsurance");
            return (Criteria) this;
        }

        public Criteria andStuConductIsNull() {
            addCriterion("STU_CONDUCT is null");
            return (Criteria) this;
        }

        public Criteria andStuConductIsNotNull() {
            addCriterion("STU_CONDUCT is not null");
            return (Criteria) this;
        }

        public Criteria andStuConductEqualTo(Integer value) {
            addCriterion("STU_CONDUCT =", value, "stuConduct");
            return (Criteria) this;
        }

        public Criteria andStuConductNotEqualTo(Integer value) {
            addCriterion("STU_CONDUCT <>", value, "stuConduct");
            return (Criteria) this;
        }

        public Criteria andStuConductGreaterThan(Integer value) {
            addCriterion("STU_CONDUCT >", value, "stuConduct");
            return (Criteria) this;
        }

        public Criteria andStuConductGreaterThanOrEqualTo(Integer value) {
            addCriterion("STU_CONDUCT >=", value, "stuConduct");
            return (Criteria) this;
        }

        public Criteria andStuConductLessThan(Integer value) {
            addCriterion("STU_CONDUCT <", value, "stuConduct");
            return (Criteria) this;
        }

        public Criteria andStuConductLessThanOrEqualTo(Integer value) {
            addCriterion("STU_CONDUCT <=", value, "stuConduct");
            return (Criteria) this;
        }

        public Criteria andStuConductIn(List<Integer> values) {
            addCriterion("STU_CONDUCT in", values, "stuConduct");
            return (Criteria) this;
        }

        public Criteria andStuConductNotIn(List<Integer> values) {
            addCriterion("STU_CONDUCT not in", values, "stuConduct");
            return (Criteria) this;
        }

        public Criteria andStuConductBetween(Integer value1, Integer value2) {
            addCriterion("STU_CONDUCT between", value1, value2, "stuConduct");
            return (Criteria) this;
        }

        public Criteria andStuConductNotBetween(Integer value1, Integer value2) {
            addCriterion("STU_CONDUCT not between", value1, value2, "stuConduct");
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