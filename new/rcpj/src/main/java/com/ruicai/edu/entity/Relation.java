package com.ruicai.edu.entity;

public class Relation {
private int r_type;//学生投票状态
private int r_sid;//老师id
private int r_tid;//学生id

public void setR_type(int rType) {
	r_type = rType;
}
public int getR_type() {
	return r_type;
}
public int getR_sid() {
	return r_sid;
}
public void setR_sid(int rSid) {
	r_sid = rSid;
}
public int getR_tid() {
	return r_tid;
}
public void setR_tid(int rTid) {
	r_tid = rTid;
}

}
