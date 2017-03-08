package com.ruicai.edu.entity;


public class Teacher {

	private int t_id;   //教师编号
	private String t_name;//教师姓名
	private String t_sex;//教师性别
	private String t_jianJie;//教师简介
	private String t_photo;//教师照片
	private String t_account;//教师账号
	private String t_pass;   //教师密码
	private String t_zhuanYe;//教师专业（JAVA，ui,html5,安卓）
	private String t_leiXing;//教师类型（高级讲师，助教，班主任）
	private long t_phone;    //教师电话
	private String t_class;  //教师班级
	
	public String getT_class() {
		return t_class;
	}
	public void setT_class(String tClass) {
		t_class = tClass;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(Integer tId) {
		t_id = tId;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String tName) {
		t_name = tName;
	}
	public String getT_sex() {
		return t_sex;
	}
	public void setT_sex(String tSex) {
		t_sex = tSex;
	}
	public String getT_jianJie() {
		return t_jianJie;
	}
	public void setT_jianJie(String tJianJie) {
		t_jianJie = tJianJie;
	}
	public String getT_photo() {
		return t_photo;
	}
	public void setT_photo(String tPhoto) {
		t_photo = tPhoto;
	}
	public String getT_account() {
		return t_account;
	}
	public void setT_account(String tAccount) {
		t_account = tAccount;
	}
	public String getT_pass() {
		return t_pass;
	}
	public void setT_pass(String tPass) {
		t_pass = tPass;
	}
	public String getT_zhuanYe() {
		return t_zhuanYe;
	}
	public void setT_zhuanYe(String tZhuanYe) {
		t_zhuanYe = tZhuanYe;
	}
	public String getT_leiXing() {
		return t_leiXing;
	}
	public void setT_leiXing(String tLeiXing) {
		t_leiXing = tLeiXing;
	}
	public long getT_phone() {
		return t_phone;
	}
	public void setT_phone(Long tPhone) {
		t_phone = tPhone;
	}
	
}
