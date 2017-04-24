package com.ruicai.education.po.education;

import com.ruicai.education.util.MyDateFormate;

import java.sql.Timestamp;

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

    private Timestamp studentGraduation;

    private String studentPhone;

    private String studentFamilyPhone;

    private String studentPicture;

    private String studentInsurance;

    private Integer studentConduct;

    private String studentSpecialtyView;

    private String studentSexView;

    private String studentInsuranceView;

    private String studentEducationView;

    private String[] role;

    private String studentGraduationView;


    public String getStudentGraduationView() {
        return studentGraduationView;
    }


    public String getStudentSpecialtyView() {
        return studentSpecialtyView;
    }

    public void setStudentSpecialtyView(String studentSpecialtyView) {
        this.studentSpecialtyView = studentSpecialtyView;
    }

    public String getStudentSexView() {
        return studentSexView;
    }

    public void setStudentSexView(String studentSexView) {
        this.studentSexView = studentSexView;
    }

    public String getStudentInsuranceView() {
        return studentInsuranceView;
    }

    public void setStudentInsuranceView(String studentInsuranceView) {
        this.studentInsuranceView = studentInsuranceView;
    }

    public String getStudentEducationView() {
        return studentEducationView;
    }

    public void setStudentEducationView(String studentEducationView) {
        this.studentEducationView = studentEducationView;
    }

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

    public String[] getRole() {
        return role;
    }

    public void setRole(String[] role) {
        this.role = role;
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

    public Timestamp getStudentGraduation() {
        return studentGraduation;
    }

    public void setStudentGraduation(Timestamp studentGraduation) {
        this.studentGraduation = studentGraduation;
        this.studentGraduationView = MyDateFormate.timeStampToString(studentGraduation);
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

    public String getStudentInsurance() {
        return studentInsurance;
    }

    public void setStudentInsurance(String studentInsurance) {
        this.studentInsurance = studentInsurance;
    }

    public Integer getStudentConduct() {
        return studentConduct;
    }

    public void setStudentConduct(Integer studentConduct) {
        this.studentConduct = studentConduct;
    }
}