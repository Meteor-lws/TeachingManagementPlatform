package com.ruicai.system.po;

import java.util.Date;

public class EducationStudent {
    private String id;

    private String userId;

    private String classId;

    private String studentEducation;

    private String studentSex;

    private String studentName;

    private String studentIdNumber;

    private String studentSchool;

    private String studentSpecialty;

    private Date studentGraduation;

    private String studentPhone;

    private String studentFamilyPhone;

    private String studentPicture;

    private Short studentInsurance;

    private Integer studentConduct;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public String getStudentEducation() {
        return studentEducation;
    }

    public void setStudentEducation(String studentEducation) {
        this.studentEducation = studentEducation == null ? null : studentEducation.trim();
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex == null ? null : studentSex.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentIdNumber() {
        return studentIdNumber;
    }

    public void setStudentIdNumber(String studentIdNumber) {
        this.studentIdNumber = studentIdNumber == null ? null : studentIdNumber.trim();
    }

    public String getStudentSchool() {
        return studentSchool;
    }

    public void setStudentSchool(String studentSchool) {
        this.studentSchool = studentSchool == null ? null : studentSchool.trim();
    }

    public String getStudentSpecialty() {
        return studentSpecialty;
    }

    public void setStudentSpecialty(String studentSpecialty) {
        this.studentSpecialty = studentSpecialty == null ? null : studentSpecialty.trim();
    }

    public Date getStudentGraduation() {
        return studentGraduation;
    }

    public void setStudentGraduation(Date studentGraduation) {
        this.studentGraduation = studentGraduation;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone == null ? null : studentPhone.trim();
    }

    public String getStudentFamilyPhone() {
        return studentFamilyPhone;
    }

    public void setStudentFamilyPhone(String studentFamilyPhone) {
        this.studentFamilyPhone = studentFamilyPhone == null ? null : studentFamilyPhone.trim();
    }

    public String getStudentPicture() {
        return studentPicture;
    }

    public void setStudentPicture(String studentPicture) {
        this.studentPicture = studentPicture == null ? null : studentPicture.trim();
    }

    public Short getStudentInsurance() {
        return studentInsurance;
    }

    public void setStudentInsurance(Short studentInsurance) {
        this.studentInsurance = studentInsurance;
    }

    public Integer getStudentConduct() {
        return studentConduct;
    }

    public void setStudentConduct(Integer studentConduct) {
        this.studentConduct = studentConduct;
    }
}