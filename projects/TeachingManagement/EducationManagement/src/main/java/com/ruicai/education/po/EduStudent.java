package com.ruicai.education.po;

import java.util.Date;

public class EduStudent {
    private String id;

    private String userId;

    private String classId;

    private String stuEducation;

    private String stuSex;

    private String stuName;

    private String stuIdNumber;

    private String stuSchool;

    private String stuSpecialty;

    private Date stuGraduation;

    private String stuPhone;

    private String stuFamilyPhone;

    private String stuPicture;

    private Short stuInsurance;

    private Integer stuConduct;

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

    public String getStuEducation() {
        return stuEducation;
    }

    public void setStuEducation(String stuEducation) {
        this.stuEducation = stuEducation == null ? null : stuEducation.trim();
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex == null ? null : stuSex.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getStuIdNumber() {
        return stuIdNumber;
    }

    public void setStuIdNumber(String stuIdNumber) {
        this.stuIdNumber = stuIdNumber == null ? null : stuIdNumber.trim();
    }

    public String getStuSchool() {
        return stuSchool;
    }

    public void setStuSchool(String stuSchool) {
        this.stuSchool = stuSchool == null ? null : stuSchool.trim();
    }

    public String getStuSpecialty() {
        return stuSpecialty;
    }

    public void setStuSpecialty(String stuSpecialty) {
        this.stuSpecialty = stuSpecialty == null ? null : stuSpecialty.trim();
    }

    public Date getStuGraduation() {
        return stuGraduation;
    }

    public void setStuGraduation(Date stuGraduation) {
        this.stuGraduation = stuGraduation;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone == null ? null : stuPhone.trim();
    }

    public String getStuFamilyPhone() {
        return stuFamilyPhone;
    }

    public void setStuFamilyPhone(String stuFamilyPhone) {
        this.stuFamilyPhone = stuFamilyPhone == null ? null : stuFamilyPhone.trim();
    }

    public String getStuPicture() {
        return stuPicture;
    }

    public void setStuPicture(String stuPicture) {
        this.stuPicture = stuPicture == null ? null : stuPicture.trim();
    }

    public Short getStuInsurance() {
        return stuInsurance;
    }

    public void setStuInsurance(Short stuInsurance) {
        this.stuInsurance = stuInsurance;
    }

    public Integer getStuConduct() {
        return stuConduct;
    }

    public void setStuConduct(Integer stuConduct) {
        this.stuConduct = stuConduct;
    }
}