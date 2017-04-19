package com.ruicai.education.po.education;

import java.util.List;

public class EducationTeacher {
    private String id;

    private String userId;

    private String teacherType;

    private String teacherSpeciality;

    private String teacherSex;

    private String teacherName;

    private String teacherPhone;

    private String teacherIntroduction;

    private String teacherSexView;

    private String teacherSpecialityView;

    private String teacherTypeView;

    private String teacherPicture;
    private String[] role;
    private List<UserToRoleKey> roles;

    public String getTeacherSexView() {
        return teacherSexView;
    }

    public void setTeacherSexView(String teacherSexView) {
        this.teacherSexView = teacherSexView;
    }

    public String getTeacherSpecialityView() {
        return teacherSpecialityView;
    }

    public void setTeacherSpecialityView(String teacherSpecialityView) {
        this.teacherSpecialityView = teacherSpecialityView;
    }

    public String getTeacherTypeView() {
        return teacherTypeView;
    }

    public void setTeacherTypeView(String teacherTypeView) {
        this.teacherTypeView = teacherTypeView;
    }

    public String[] getRole() {
        return role;
    }

    public void setRole(String[] role) {
        this.role = role;
    }

    public List<UserToRoleKey> getRoles() {
        return roles;
    }

    public void setRoles(List<UserToRoleKey> roles) {
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(String teacherType) {
        this.teacherType = teacherType;
    }

    public String getTeacherSpeciality() {
        return teacherSpeciality;
    }

    public void setTeacherSpeciality(String teacherSpeciality) {
        this.teacherSpeciality = teacherSpeciality;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacherIntroduction() {
        return teacherIntroduction;
    }

    public void setTeacherIntroduction(String teacherIntroduction) {
        this.teacherIntroduction = teacherIntroduction;
    }

    public String getTeacherPicture() {
        return teacherPicture;
    }

    public void setTeacherPicture(String teacherPicture) {
        this.teacherPicture = teacherPicture;
    }

}