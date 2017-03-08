package com.ruicai.edu.entity;

public class BBS {
 private int b_id;//留言编号
 private String b_ly;//留言内容
 private String b_time;//留言时间
 private int b_sid;//学生ID
 private int b_tid;//老师ID
 private String s_name;//学生姓名
 private String t_name;//老师姓名

 
 
 

public String getS_name() {
	return s_name;
}
public void setS_name(String sName) {
	s_name = sName;
}
public String getT_name() {
	return t_name;
}
public void setT_name(String tName) {
	t_name = tName;
}
public int getB_id() {
	return b_id;
}
public void setB_id(int bId) {
	b_id = bId;
}
public String getB_ly() {
	return b_ly;
}
public void setB_ly(String bLy) {
	b_ly = bLy;
}
public String getB_time() {
	return b_time;
}
public void setB_time(String bTime) {
	b_time = bTime;
}
public int getB_sid() {
	return b_sid;
}
public void setB_sid(int bSid) {
	b_sid = bSid;
}
public int getB_tid() {
	return b_tid;
}
public void setB_tid(int bTid) {
	b_tid = bTid;
}

}
