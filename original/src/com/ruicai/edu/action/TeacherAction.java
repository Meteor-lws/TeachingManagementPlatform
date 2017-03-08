package com.ruicai.edu.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.ruicai.edu.entity.Teacher;
import com.ruicai.edu.service.TeacherService;
import com.ruicai.edu.service.imp.TeacherServiceImpl;

public class TeacherAction {
     TeacherService teacherService=new TeacherServiceImpl();
     private List<Teacher> teachers ;//用于返回查询多个老师信息的集合
     private String msg;//用于检查登录名唯一，修改、删除操作的返回消息
     private Teacher teacher;//用于根据ID或者loginName等唯一标示查询老师的详细信息
     private File teacherImg;//用于上传teacher的照片
     private JSONObject jsonMessage;//由于前台页面表单Name值为teacher.XX,在修改teacher信息时load teacher 信息就不能用 teacher对象传值，
                                    //用Map.put（“teacher.XX”，teacher.XX）存值，再进行封装
     								//用于分页：由于分页需要total属性，所以不能用List<teahcer> 的方式传递值
	 private String ids;//用于删除teachers时，取得老师ID
	 private String page;//用于分页显示，当前页
	 private String rows;//用于页面显示，每页行数
	 private int studentID;
	
	
	

	/**
     * 后台管理员点击教师管理跳转
     * @return
     */
	public String loadManager() {
 		return "loadManager";
 	}
     /***
      * 加载所有的老师
      * @return
      */
    /* public String loadTeachers() {
    	//System.out.println("加载全部老师！");
		teachers=teacherService.queryTeacherList();
		return "loadTeachers";
	}*/
	
     /**
      * 根据注册用户名，判断是否存在，若存在，返回usered，若不存在返回isOK
      * @return
      */
     public String checkName() {
    	 msg=teacherService.checkTeacherLoginName(teacher.getT_account());
    	 return "checkName";
	 }
     /***
      * 添加教师信息
      * @return
      */
     public String addTeacher(){
    	 msg=teacherService.addTeacher(teacher,teacherImg);
    	 return "addTeacher";
     }
     /***
      * 修改教师信息
      * @return
      */
     public String updateTeacher(){
    	 msg=teacherService.updateTeacher(teacher,teacherImg);
    	 return "updateTeacher";
     }
     /**
      * 查询所有老师以便提供选择
      * @return
      */
     public String loadAllteachersForSelect() {
		 teachers=teacherService.loadAllteachersForSelect();
    	 return "loadAllteachersForSelect";
	}
     /**
      * 根据老师ID查询老师信息
      * @return
      */
     public String getTeacherByID() {
    	jsonMessage=teacherService.getTeacherByID(teacher.getT_id(),jsonMessage);
    	System.out.println(jsonMessage);
		return "getTeacherByID";
	}
     /**
      * 根据筛选条件查询老师信息
      * @return
      */
     public String loadTeachersByFilter() {
    	 teachers=teacherService.loadTeachersByFilter(teacher.getT_name(), teacher.getT_zhuanYe(), teacher.getT_leiXing());
    	 
    	 return "loadTeachersByFilter";
	}
     /**
      * 根据学生ID查询老师信息
      * @return
      */
     public String loadTeachersByStudentID() {
    	 teachers=teacherService.loadTeachersByStudentID(studentID);
    	 return "loadTeachersByFilter";
	}
     /**
      * 分页
      * @return
      */
     public String loadTeachersByPages(){
    	 jsonMessage=teacherService.loadTeachersByPages(Integer.parseInt(page), Integer.parseInt(rows));
    	 return "loadTeachersByPages";
     }
     /**
      * 删除老师操作
      * @return
      */
     public String deleteTeacher() {
    	 msg=teacherService.deleteTeacher(ids);
    	 return "deleteTeacher";
	}
     
     
     
    /**************************Get\Set构造器************************************/ 
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
     
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public File getTeacherImg() {
		return teacherImg;
	}

	public void setTeacherImg(File teacherImg) {
		this.teacherImg = teacherImg;
	}
	
	public JSONObject getJsonMessage() {
		return jsonMessage;
	}
	public void setJsonMessage(JSONObject jsonMessage) {
		this.jsonMessage = jsonMessage;
	}
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}
	
}
