package com.ruicai.edu.entity;

public class Student {

	private int s_id;         //
	private String s_account; //
	private String s_pass;    //
	private String s_name;      //
	private String  s_class;     //所在班级
	private String s_sex;     //
	private String t_name;
	
	
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String tName) {
		t_name = tName;
	}
	
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int sId) {
		s_id = sId;
	}
	public String getS_account() {
		return s_account;
	}
	public void setS_account(String sAccount) {
		s_account = sAccount;
	}
	public String getS_pass() {
		return s_pass;
	}
	public void setS_pass(String sPass) {
		s_pass = sPass;
	}
	
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	
	
	public String getS_class() {
		return s_class;
	}
	public void setS_class(String sClass) {
		s_class = sClass;
	}
	public String getS_sex() {
		return s_sex;
	}
	public void setS_sex(String sSex) {
		s_sex = sSex;
	}
	
	
}
