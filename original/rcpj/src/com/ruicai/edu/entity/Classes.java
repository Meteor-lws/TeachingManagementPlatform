package com.ruicai.edu.entity;

public class Classes {
	   private  int c_id;   //id
	   private  String c_name;//班级名称
	   private  int c_mainteacher;//主讲老师
	   private  int c_classroomteacher;//班主任
	   private  int c_assistantteacher;//助教
	   private  String t_name;//班主任姓名
	   private  String c_stime;
	   private  String c_etime;
	   private  int c_tid;
	   private  int c_type;//是否启用
	   private  String c_mname;
	   private  String c_cname;
	   private  String c_aname;
	   
	   
	   

	public int getC_tid() {
		return c_tid;
	}
	public void setC_tid(int cTid) {
		c_tid = cTid;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String tName) {
		t_name = tName;
	}
	public String getC_stime() {
		return c_stime;
	}
	public void setC_stime(String cStime) {
		c_stime = cStime;
	}
	public String getC_etime() {
		return c_etime;
	}
	public void setC_etime(String cEtime) {
		c_etime = cEtime;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int cId) {
		c_id = cId;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String cName) {
		c_name = cName;
	}
	public int getC_mainteacher() {
		return c_mainteacher;
	}
	public void setC_mainteacher(int cMainteacher) {
		c_mainteacher = cMainteacher;
	}
	public int getC_classroomteacher() {
		return c_classroomteacher;
	}
	public void setC_classroomteacher(int cClassroomteacher) {
		c_classroomteacher = cClassroomteacher;
	}
	public int getC_assistantteacher() {
		return c_assistantteacher;
	}
	public void setC_assistantteacher(int cAssistantteacher) {
		c_assistantteacher = cAssistantteacher;
	}

	public int getC_type() {
		return c_type;
	}
	public void setC_type(int cType) {
		c_type = cType;
	}
	public String getC_mname() {
		return c_mname;
	}
	public void setC_mname(String cMname) {
		c_mname = cMname;
	}
	public String getC_cname() {
		return c_cname;
	}
	public void setC_cname(String cCname) {
		c_cname = cCname;
	}
	public String getC_aname() {
		return c_aname;
	}
	public void setC_aname(String cAname) {
		c_aname = cAname;
	}
	   
	   

}
