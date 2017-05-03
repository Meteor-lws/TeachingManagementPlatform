package com.ruicai.system.po.system;

public class SystemUser {
    private String id;

    private String userStatus;

    private String userType;

    private String userName;

    private String userStatusView;

    private String userTypeView;


    private String userPwd;

    private String userNumber;

    public String getUserStatusView() {
        return userStatusView;
    }

    public void setUserStatusView(String userStatusView) {
        this.userStatusView = userStatusView;
    }

    public String getUserTypeView() {
        return userTypeView;
    }

    public void setUserTypeView(String userTypeView) {
        this.userTypeView = userTypeView;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus == null ? null : userStatus.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber == null ? null : userNumber.trim();
    }
}