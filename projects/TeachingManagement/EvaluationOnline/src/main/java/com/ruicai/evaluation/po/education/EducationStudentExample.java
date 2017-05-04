package com.ruicai.evaluation.po.education;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EducationStudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EducationStudentExample() {
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

        public Criteria andStudentEducationIsNull() {
            addCriterion("STUDENT_EDUCATION is null");
            return (Criteria) this;
        }

        public Criteria andStudentEducationIsNotNull() {
            addCriterion("STUDENT_EDUCATION is not null");
            return (Criteria) this;
        }

        public Criteria andStudentEducationEqualTo(String value) {
            addCriterion("STUDENT_EDUCATION =", value, "studentEducation");
            return (Criteria) this;
        }

        public Criteria andStudentEducationNotEqualTo(String value) {
            addCriterion("STUDENT_EDUCATION <>", value, "studentEducation");
            return (Criteria) this;
        }

        public Criteria andStudentEducationGreaterThan(String value) {
            addCriterion("STUDENT_EDUCATION >", value, "studentEducation");
            return (Criteria) this;
        }

        public Criteria andStudentEducationGreaterThanOrEqualTo(String value) {
            addCriterion("STUDENT_EDUCATION >=", value, "studentEducation");
            return (Criteria) this;
        }

        public Criteria andStudentEducationLessThan(String value) {
            addCriterion("STUDENT_EDUCATION <", value, "studentEducation");
            return (Criteria) this;
        }

        public Criteria andStudentEducationLessThanOrEqualTo(String value) {
            addCriterion("STUDENT_EDUCATION <=", value, "studentEducation");
            return (Criteria) this;
        }

        public Criteria andStudentEducationLike(String value) {
            addCriterion("STUDENT_EDUCATION like", value, "studentEducation");
            return (Criteria) this;
        }

        public Criteria andStudentEducationNotLike(String value) {
            addCriterion("STUDENT_EDUCATION not like", value, "studentEducation");
            return (Criteria) this;
        }

        public Criteria andStudentEducationIn(List<String> values) {
            addCriterion("STUDENT_EDUCATION in", values, "studentEducation");
            return (Criteria) this;
        }

        public Criteria andStudentEducationNotIn(List<String> values) {
            addCriterion("STUDENT_EDUCATION not in", values, "studentEducation");
            return (Criteria) this;
        }

        public Criteria andStudentEducationBetween(String value1, String value2) {
            addCriterion("STUDENT_EDUCATION between", value1, value2, "studentEducation");
            return (Criteria) this;
        }

        public Criteria andStudentEducationNotBetween(String value1, String value2) {
            addCriterion("STUDENT_EDUCATION not between", value1, value2, "studentEducation");
            return (Criteria) this;
        }

        public Criteria andStudentSexIsNull() {
            addCriterion("STUDENT_SEX is null");
            return (Criteria) this;
        }

        public Criteria andStudentSexIsNotNull() {
            addCriterion("STUDENT_SEX is not null");
            return (Criteria) this;
        }

        public Criteria andStudentSexEqualTo(String value) {
            addCriterion("STUDENT_SEX =", value, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexNotEqualTo(String value) {
            addCriterion("STUDENT_SEX <>", value, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexGreaterThan(String value) {
            addCriterion("STUDENT_SEX >", value, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexGreaterThanOrEqualTo(String value) {
            addCriterion("STUDENT_SEX >=", value, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexLessThan(String value) {
            addCriterion("STUDENT_SEX <", value, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexLessThanOrEqualTo(String value) {
            addCriterion("STUDENT_SEX <=", value, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexLike(String value) {
            addCriterion("STUDENT_SEX like", value, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexNotLike(String value) {
            addCriterion("STUDENT_SEX not like", value, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexIn(List<String> values) {
            addCriterion("STUDENT_SEX in", values, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexNotIn(List<String> values) {
            addCriterion("STUDENT_SEX not in", values, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexBetween(String value1, String value2) {
            addCriterion("STUDENT_SEX between", value1, value2, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexNotBetween(String value1, String value2) {
            addCriterion("STUDENT_SEX not between", value1, value2, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentNameIsNull() {
            addCriterion("STUDENT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStudentNameIsNotNull() {
            addCriterion("STUDENT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNameEqualTo(String value) {
            addCriterion("STUDENT_NAME =", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotEqualTo(String value) {
            addCriterion("STUDENT_NAME <>", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThan(String value) {
            addCriterion("STUDENT_NAME >", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThanOrEqualTo(String value) {
            addCriterion("STUDENT_NAME >=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThan(String value) {
            addCriterion("STUDENT_NAME <", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThanOrEqualTo(String value) {
            addCriterion("STUDENT_NAME <=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLike(String value) {
            addCriterion("STUDENT_NAME like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotLike(String value) {
            addCriterion("STUDENT_NAME not like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameIn(List<String> values) {
            addCriterion("STUDENT_NAME in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotIn(List<String> values) {
            addCriterion("STUDENT_NAME not in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameBetween(String value1, String value2) {
            addCriterion("STUDENT_NAME between", value1, value2, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotBetween(String value1, String value2) {
            addCriterion("STUDENT_NAME not between", value1, value2, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentIdNumberIsNull() {
            addCriterion("STUDENT_ID_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdNumberIsNotNull() {
            addCriterion("STUDENT_ID_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdNumberEqualTo(String value) {
            addCriterion("STUDENT_ID_NUMBER =", value, "studentIdNumber");
            return (Criteria) this;
        }

        public Criteria andStudentIdNumberNotEqualTo(String value) {
            addCriterion("STUDENT_ID_NUMBER <>", value, "studentIdNumber");
            return (Criteria) this;
        }

        public Criteria andStudentIdNumberGreaterThan(String value) {
            addCriterion("STUDENT_ID_NUMBER >", value, "studentIdNumber");
            return (Criteria) this;
        }

        public Criteria andStudentIdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("STUDENT_ID_NUMBER >=", value, "studentIdNumber");
            return (Criteria) this;
        }

        public Criteria andStudentIdNumberLessThan(String value) {
            addCriterion("STUDENT_ID_NUMBER <", value, "studentIdNumber");
            return (Criteria) this;
        }

        public Criteria andStudentIdNumberLessThanOrEqualTo(String value) {
            addCriterion("STUDENT_ID_NUMBER <=", value, "studentIdNumber");
            return (Criteria) this;
        }

        public Criteria andStudentIdNumberLike(String value) {
            addCriterion("STUDENT_ID_NUMBER like", value, "studentIdNumber");
            return (Criteria) this;
        }

        public Criteria andStudentIdNumberNotLike(String value) {
            addCriterion("STUDENT_ID_NUMBER not like", value, "studentIdNumber");
            return (Criteria) this;
        }

        public Criteria andStudentIdNumberIn(List<String> values) {
            addCriterion("STUDENT_ID_NUMBER in", values, "studentIdNumber");
            return (Criteria) this;
        }

        public Criteria andStudentIdNumberNotIn(List<String> values) {
            addCriterion("STUDENT_ID_NUMBER not in", values, "studentIdNumber");
            return (Criteria) this;
        }

        public Criteria andStudentIdNumberBetween(String value1, String value2) {
            addCriterion("STUDENT_ID_NUMBER between", value1, value2, "studentIdNumber");
            return (Criteria) this;
        }

        public Criteria andStudentIdNumberNotBetween(String value1, String value2) {
            addCriterion("STUDENT_ID_NUMBER not between", value1, value2, "studentIdNumber");
            return (Criteria) this;
        }

        public Criteria andStudentSchoolIsNull() {
            addCriterion("STUDENT_SCHOOL is null");
            return (Criteria) this;
        }

        public Criteria andStudentSchoolIsNotNull() {
            addCriterion("STUDENT_SCHOOL is not null");
            return (Criteria) this;
        }

        public Criteria andStudentSchoolEqualTo(String value) {
            addCriterion("STUDENT_SCHOOL =", value, "studentSchool");
            return (Criteria) this;
        }

        public Criteria andStudentSchoolNotEqualTo(String value) {
            addCriterion("STUDENT_SCHOOL <>", value, "studentSchool");
            return (Criteria) this;
        }

        public Criteria andStudentSchoolGreaterThan(String value) {
            addCriterion("STUDENT_SCHOOL >", value, "studentSchool");
            return (Criteria) this;
        }

        public Criteria andStudentSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("STUDENT_SCHOOL >=", value, "studentSchool");
            return (Criteria) this;
        }

        public Criteria andStudentSchoolLessThan(String value) {
            addCriterion("STUDENT_SCHOOL <", value, "studentSchool");
            return (Criteria) this;
        }

        public Criteria andStudentSchoolLessThanOrEqualTo(String value) {
            addCriterion("STUDENT_SCHOOL <=", value, "studentSchool");
            return (Criteria) this;
        }

        public Criteria andStudentSchoolLike(String value) {
            addCriterion("STUDENT_SCHOOL like", value, "studentSchool");
            return (Criteria) this;
        }

        public Criteria andStudentSchoolNotLike(String value) {
            addCriterion("STUDENT_SCHOOL not like", value, "studentSchool");
            return (Criteria) this;
        }

        public Criteria andStudentSchoolIn(List<String> values) {
            addCriterion("STUDENT_SCHOOL in", values, "studentSchool");
            return (Criteria) this;
        }

        public Criteria andStudentSchoolNotIn(List<String> values) {
            addCriterion("STUDENT_SCHOOL not in", values, "studentSchool");
            return (Criteria) this;
        }

        public Criteria andStudentSchoolBetween(String value1, String value2) {
            addCriterion("STUDENT_SCHOOL between", value1, value2, "studentSchool");
            return (Criteria) this;
        }

        public Criteria andStudentSchoolNotBetween(String value1, String value2) {
            addCriterion("STUDENT_SCHOOL not between", value1, value2, "studentSchool");
            return (Criteria) this;
        }

        public Criteria andStudentSpecialtyIsNull() {
            addCriterion("STUDENT_SPECIALTY is null");
            return (Criteria) this;
        }

        public Criteria andStudentSpecialtyIsNotNull() {
            addCriterion("STUDENT_SPECIALTY is not null");
            return (Criteria) this;
        }

        public Criteria andStudentSpecialtyEqualTo(String value) {
            addCriterion("STUDENT_SPECIALTY =", value, "studentSpecialty");
            return (Criteria) this;
        }

        public Criteria andStudentSpecialtyNotEqualTo(String value) {
            addCriterion("STUDENT_SPECIALTY <>", value, "studentSpecialty");
            return (Criteria) this;
        }

        public Criteria andStudentSpecialtyGreaterThan(String value) {
            addCriterion("STUDENT_SPECIALTY >", value, "studentSpecialty");
            return (Criteria) this;
        }

        public Criteria andStudentSpecialtyGreaterThanOrEqualTo(String value) {
            addCriterion("STUDENT_SPECIALTY >=", value, "studentSpecialty");
            return (Criteria) this;
        }

        public Criteria andStudentSpecialtyLessThan(String value) {
            addCriterion("STUDENT_SPECIALTY <", value, "studentSpecialty");
            return (Criteria) this;
        }

        public Criteria andStudentSpecialtyLessThanOrEqualTo(String value) {
            addCriterion("STUDENT_SPECIALTY <=", value, "studentSpecialty");
            return (Criteria) this;
        }

        public Criteria andStudentSpecialtyLike(String value) {
            addCriterion("STUDENT_SPECIALTY like", value, "studentSpecialty");
            return (Criteria) this;
        }

        public Criteria andStudentSpecialtyNotLike(String value) {
            addCriterion("STUDENT_SPECIALTY not like", value, "studentSpecialty");
            return (Criteria) this;
        }

        public Criteria andStudentSpecialtyIn(List<String> values) {
            addCriterion("STUDENT_SPECIALTY in", values, "studentSpecialty");
            return (Criteria) this;
        }

        public Criteria andStudentSpecialtyNotIn(List<String> values) {
            addCriterion("STUDENT_SPECIALTY not in", values, "studentSpecialty");
            return (Criteria) this;
        }

        public Criteria andStudentSpecialtyBetween(String value1, String value2) {
            addCriterion("STUDENT_SPECIALTY between", value1, value2, "studentSpecialty");
            return (Criteria) this;
        }

        public Criteria andStudentSpecialtyNotBetween(String value1, String value2) {
            addCriterion("STUDENT_SPECIALTY not between", value1, value2, "studentSpecialty");
            return (Criteria) this;
        }

        public Criteria andStudentGraduationIsNull() {
            addCriterion("STUDENT_GRADUATION is null");
            return (Criteria) this;
        }

        public Criteria andStudentGraduationIsNotNull() {
            addCriterion("STUDENT_GRADUATION is not null");
            return (Criteria) this;
        }

        public Criteria andStudentGraduationEqualTo(Date value) {
            addCriterion("STUDENT_GRADUATION =", value, "studentGraduation");
            return (Criteria) this;
        }

        public Criteria andStudentGraduationNotEqualTo(Date value) {
            addCriterion("STUDENT_GRADUATION <>", value, "studentGraduation");
            return (Criteria) this;
        }

        public Criteria andStudentGraduationGreaterThan(Date value) {
            addCriterion("STUDENT_GRADUATION >", value, "studentGraduation");
            return (Criteria) this;
        }

        public Criteria andStudentGraduationGreaterThanOrEqualTo(Date value) {
            addCriterion("STUDENT_GRADUATION >=", value, "studentGraduation");
            return (Criteria) this;
        }

        public Criteria andStudentGraduationLessThan(Date value) {
            addCriterion("STUDENT_GRADUATION <", value, "studentGraduation");
            return (Criteria) this;
        }

        public Criteria andStudentGraduationLessThanOrEqualTo(Date value) {
            addCriterion("STUDENT_GRADUATION <=", value, "studentGraduation");
            return (Criteria) this;
        }

        public Criteria andStudentGraduationIn(List<Date> values) {
            addCriterion("STUDENT_GRADUATION in", values, "studentGraduation");
            return (Criteria) this;
        }

        public Criteria andStudentGraduationNotIn(List<Date> values) {
            addCriterion("STUDENT_GRADUATION not in", values, "studentGraduation");
            return (Criteria) this;
        }

        public Criteria andStudentGraduationBetween(Date value1, Date value2) {
            addCriterion("STUDENT_GRADUATION between", value1, value2, "studentGraduation");
            return (Criteria) this;
        }

        public Criteria andStudentGraduationNotBetween(Date value1, Date value2) {
            addCriterion("STUDENT_GRADUATION not between", value1, value2, "studentGraduation");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneIsNull() {
            addCriterion("STUDENT_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneIsNotNull() {
            addCriterion("STUDENT_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneEqualTo(String value) {
            addCriterion("STUDENT_PHONE =", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneNotEqualTo(String value) {
            addCriterion("STUDENT_PHONE <>", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneGreaterThan(String value) {
            addCriterion("STUDENT_PHONE >", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("STUDENT_PHONE >=", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneLessThan(String value) {
            addCriterion("STUDENT_PHONE <", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneLessThanOrEqualTo(String value) {
            addCriterion("STUDENT_PHONE <=", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneLike(String value) {
            addCriterion("STUDENT_PHONE like", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneNotLike(String value) {
            addCriterion("STUDENT_PHONE not like", value, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneIn(List<String> values) {
            addCriterion("STUDENT_PHONE in", values, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneNotIn(List<String> values) {
            addCriterion("STUDENT_PHONE not in", values, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneBetween(String value1, String value2) {
            addCriterion("STUDENT_PHONE between", value1, value2, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPhoneNotBetween(String value1, String value2) {
            addCriterion("STUDENT_PHONE not between", value1, value2, "studentPhone");
            return (Criteria) this;
        }

        public Criteria andStudentFamilyPhoneIsNull() {
            addCriterion("STUDENT_FAMILY_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andStudentFamilyPhoneIsNotNull() {
            addCriterion("STUDENT_FAMILY_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andStudentFamilyPhoneEqualTo(String value) {
            addCriterion("STUDENT_FAMILY_PHONE =", value, "studentFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStudentFamilyPhoneNotEqualTo(String value) {
            addCriterion("STUDENT_FAMILY_PHONE <>", value, "studentFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStudentFamilyPhoneGreaterThan(String value) {
            addCriterion("STUDENT_FAMILY_PHONE >", value, "studentFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStudentFamilyPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("STUDENT_FAMILY_PHONE >=", value, "studentFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStudentFamilyPhoneLessThan(String value) {
            addCriterion("STUDENT_FAMILY_PHONE <", value, "studentFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStudentFamilyPhoneLessThanOrEqualTo(String value) {
            addCriterion("STUDENT_FAMILY_PHONE <=", value, "studentFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStudentFamilyPhoneLike(String value) {
            addCriterion("STUDENT_FAMILY_PHONE like", value, "studentFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStudentFamilyPhoneNotLike(String value) {
            addCriterion("STUDENT_FAMILY_PHONE not like", value, "studentFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStudentFamilyPhoneIn(List<String> values) {
            addCriterion("STUDENT_FAMILY_PHONE in", values, "studentFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStudentFamilyPhoneNotIn(List<String> values) {
            addCriterion("STUDENT_FAMILY_PHONE not in", values, "studentFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStudentFamilyPhoneBetween(String value1, String value2) {
            addCriterion("STUDENT_FAMILY_PHONE between", value1, value2, "studentFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStudentFamilyPhoneNotBetween(String value1, String value2) {
            addCriterion("STUDENT_FAMILY_PHONE not between", value1, value2, "studentFamilyPhone");
            return (Criteria) this;
        }

        public Criteria andStudentPictureIsNull() {
            addCriterion("STUDENT_PICTURE is null");
            return (Criteria) this;
        }

        public Criteria andStudentPictureIsNotNull() {
            addCriterion("STUDENT_PICTURE is not null");
            return (Criteria) this;
        }

        public Criteria andStudentPictureEqualTo(String value) {
            addCriterion("STUDENT_PICTURE =", value, "studentPicture");
            return (Criteria) this;
        }

        public Criteria andStudentPictureNotEqualTo(String value) {
            addCriterion("STUDENT_PICTURE <>", value, "studentPicture");
            return (Criteria) this;
        }

        public Criteria andStudentPictureGreaterThan(String value) {
            addCriterion("STUDENT_PICTURE >", value, "studentPicture");
            return (Criteria) this;
        }

        public Criteria andStudentPictureGreaterThanOrEqualTo(String value) {
            addCriterion("STUDENT_PICTURE >=", value, "studentPicture");
            return (Criteria) this;
        }

        public Criteria andStudentPictureLessThan(String value) {
            addCriterion("STUDENT_PICTURE <", value, "studentPicture");
            return (Criteria) this;
        }

        public Criteria andStudentPictureLessThanOrEqualTo(String value) {
            addCriterion("STUDENT_PICTURE <=", value, "studentPicture");
            return (Criteria) this;
        }

        public Criteria andStudentPictureLike(String value) {
            addCriterion("STUDENT_PICTURE like", value, "studentPicture");
            return (Criteria) this;
        }

        public Criteria andStudentPictureNotLike(String value) {
            addCriterion("STUDENT_PICTURE not like", value, "studentPicture");
            return (Criteria) this;
        }

        public Criteria andStudentPictureIn(List<String> values) {
            addCriterion("STUDENT_PICTURE in", values, "studentPicture");
            return (Criteria) this;
        }

        public Criteria andStudentPictureNotIn(List<String> values) {
            addCriterion("STUDENT_PICTURE not in", values, "studentPicture");
            return (Criteria) this;
        }

        public Criteria andStudentPictureBetween(String value1, String value2) {
            addCriterion("STUDENT_PICTURE between", value1, value2, "studentPicture");
            return (Criteria) this;
        }

        public Criteria andStudentPictureNotBetween(String value1, String value2) {
            addCriterion("STUDENT_PICTURE not between", value1, value2, "studentPicture");
            return (Criteria) this;
        }

        public Criteria andStudentConductIsNull() {
            addCriterion("STUDENT_CONDUCT is null");
            return (Criteria) this;
        }

        public Criteria andStudentConductIsNotNull() {
            addCriterion("STUDENT_CONDUCT is not null");
            return (Criteria) this;
        }

        public Criteria andStudentConductEqualTo(BigDecimal value) {
            addCriterion("STUDENT_CONDUCT =", value, "studentConduct");
            return (Criteria) this;
        }

        public Criteria andStudentConductNotEqualTo(BigDecimal value) {
            addCriterion("STUDENT_CONDUCT <>", value, "studentConduct");
            return (Criteria) this;
        }

        public Criteria andStudentConductGreaterThan(BigDecimal value) {
            addCriterion("STUDENT_CONDUCT >", value, "studentConduct");
            return (Criteria) this;
        }

        public Criteria andStudentConductGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STUDENT_CONDUCT >=", value, "studentConduct");
            return (Criteria) this;
        }

        public Criteria andStudentConductLessThan(BigDecimal value) {
            addCriterion("STUDENT_CONDUCT <", value, "studentConduct");
            return (Criteria) this;
        }

        public Criteria andStudentConductLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STUDENT_CONDUCT <=", value, "studentConduct");
            return (Criteria) this;
        }

        public Criteria andStudentConductIn(List<BigDecimal> values) {
            addCriterion("STUDENT_CONDUCT in", values, "studentConduct");
            return (Criteria) this;
        }

        public Criteria andStudentConductNotIn(List<BigDecimal> values) {
            addCriterion("STUDENT_CONDUCT not in", values, "studentConduct");
            return (Criteria) this;
        }

        public Criteria andStudentConductBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STUDENT_CONDUCT between", value1, value2, "studentConduct");
            return (Criteria) this;
        }

        public Criteria andStudentConductNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STUDENT_CONDUCT not between", value1, value2, "studentConduct");
            return (Criteria) this;
        }

        public Criteria andStudentInsuranceIsNull() {
            addCriterion("STUDENT_INSURANCE is null");
            return (Criteria) this;
        }

        public Criteria andStudentInsuranceIsNotNull() {
            addCriterion("STUDENT_INSURANCE is not null");
            return (Criteria) this;
        }

        public Criteria andStudentInsuranceEqualTo(String value) {
            addCriterion("STUDENT_INSURANCE =", value, "studentInsurance");
            return (Criteria) this;
        }

        public Criteria andStudentInsuranceNotEqualTo(String value) {
            addCriterion("STUDENT_INSURANCE <>", value, "studentInsurance");
            return (Criteria) this;
        }

        public Criteria andStudentInsuranceGreaterThan(String value) {
            addCriterion("STUDENT_INSURANCE >", value, "studentInsurance");
            return (Criteria) this;
        }

        public Criteria andStudentInsuranceGreaterThanOrEqualTo(String value) {
            addCriterion("STUDENT_INSURANCE >=", value, "studentInsurance");
            return (Criteria) this;
        }

        public Criteria andStudentInsuranceLessThan(String value) {
            addCriterion("STUDENT_INSURANCE <", value, "studentInsurance");
            return (Criteria) this;
        }

        public Criteria andStudentInsuranceLessThanOrEqualTo(String value) {
            addCriterion("STUDENT_INSURANCE <=", value, "studentInsurance");
            return (Criteria) this;
        }

        public Criteria andStudentInsuranceLike(String value) {
            addCriterion("STUDENT_INSURANCE like", value, "studentInsurance");
            return (Criteria) this;
        }

        public Criteria andStudentInsuranceNotLike(String value) {
            addCriterion("STUDENT_INSURANCE not like", value, "studentInsurance");
            return (Criteria) this;
        }

        public Criteria andStudentInsuranceIn(List<String> values) {
            addCriterion("STUDENT_INSURANCE in", values, "studentInsurance");
            return (Criteria) this;
        }

        public Criteria andStudentInsuranceNotIn(List<String> values) {
            addCriterion("STUDENT_INSURANCE not in", values, "studentInsurance");
            return (Criteria) this;
        }

        public Criteria andStudentInsuranceBetween(String value1, String value2) {
            addCriterion("STUDENT_INSURANCE between", value1, value2, "studentInsurance");
            return (Criteria) this;
        }

        public Criteria andStudentInsuranceNotBetween(String value1, String value2) {
            addCriterion("STUDENT_INSURANCE not between", value1, value2, "studentInsurance");
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