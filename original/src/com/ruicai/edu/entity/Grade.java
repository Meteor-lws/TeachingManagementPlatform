package com.ruicai.edu.entity;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

public class Grade {

	private int g_id;     //评分表编号
	private int g_sid;    //评分学生id
	private int g_tid;    //评分老师id
	private Date g_time;  //评分时间
	private int g_mark;   //评分
	private int g_eid;    //评价项的id
	private String g_advice;//评价项的意见
	private String t_name;
	private String s_name;
	private double avg;
	private String e_name;
	
	
	
	
	public String getE_name() {
		return e_name;
	}

	public void setE_name(String eName) {
		e_name = eName;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String sName) {
		s_name = sName;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	public double getAvg() {
		return avg;
	}
	public void setT_name(String tName) {
		t_name = tName;
	}
	public String getT_name() {
		return t_name;
	}
	public Grade(){
		
	}
	
	public Grade(int g_sid,int g_tid,Date g_time){
		this.g_sid=g_sid;
		this.g_tid=g_tid;
		this.g_time=g_time;
	}
	
	
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int gId) {
		g_id = gId;
	}
	public int getG_sid() {
		return g_sid;
	}
	public void setG_sid(int gSid) {
		g_sid = gSid;
	}
	public int getG_tid() {
		return g_tid;
	}
	public void setG_tid(int gTid) {
		g_tid = gTid;
	}
	@JSON(format="yyyy-MM-dd HH:mm:ss")
	public Date getG_time() {
		return g_time;
	}
	public void setG_time(Date gTime) {
		g_time = gTime;
	}
	public int getG_mark() {
		return g_mark;
	}
	public void setG_mark(int gMark) {
		g_mark = gMark;
	}
	public int getG_eid() {
		return g_eid;
	}
	public void setG_eid(int geid) {
		g_eid = geid;
	}
	public String getG_advice() {
		return g_advice;
	}
	public void setG_advice(String gAdvice) {
		g_advice = gAdvice;
	}
	
}
