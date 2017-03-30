package com.ruicai.edu.action;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ruicai.edu.entity.Student;
import com.ruicai.edu.entity.Teacher;
import com.ruicai.edu.getsqlsession.TestProperties;
import com.ruicai.edu.service.StudentLoginService;
import com.ruicai.edu.service.TeacherLoginService;
import com.ruicai.edu.service.imp.StudentLoginServiceImp;
import com.ruicai.edu.service.imp.TeacherLoginServiceImp;

public class LoginAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private Teacher teacher = new Teacher();
	private Student student = new Student();
	private StudentLoginService studentLoginService;
	private TeacherLoginService teacherLoginService;
	private HttpServletRequest request;
	//前端过来的类型进行判断，如果是1，则是学生登录，如实是2，是老师的登录，是3是管理员登录
	private String leixing;
	private TestProperties properties;
	private String adminName;//前台传进来的管理员的用户名和密码
	private String adminPass;
	
	
	public String execute()throws Exception{
		if(null == leixing){
			return "index";
		}
		properties=new TestProperties().getTestProperties();
		//判断学生还是老师在同一个浏览器中登录，防止多个学生登录
		request = ServletActionContext.getRequest();
		if(request.getSession().getAttribute("student") != null ||request.getSession().getAttribute("teacher")!= null){
			request.getSession().removeAttribute("student");
			request.getSession().removeAttribute("teacher");
		}
		if(leixing.equals("1")){
			//学生登录
			student.setS_account(adminName);
			student.setS_pass(adminPass);
		    studentLoginService = new StudentLoginServiceImp();
			Student student1 = studentLoginService.login(student);
			if(student1 != null){
				//把学生放进session中
				ActionContext.getContext().getSession().put("student", student1);
			
				return "student_login_ok";
			}else{
				this.addFieldError("error", "用户名和密码错误");
				return "student_login_error";
			}
		}else if(leixing.equals("2")){
			//老师 登录
			teacher.setT_account(adminName);
			teacher.setT_pass(adminPass);
		    teacherLoginService = new TeacherLoginServiceImp();
			Teacher teacher1 = teacherLoginService.login(teacher);
			if(teacher1 != null){
				ActionContext.getContext().getSession().put("teacher", teacher1);
				
				return "teacher_login_ok";
			}else {
				this.addFieldError("error", "用户名和密码错误");
				return "teacher_login_error";
			}
		}else if(properties.MD5(adminPass).equals(properties.getParam2())&&properties.getParam1().equals(adminName)&&leixing.equals("0")&&leixing.equals("0")){
				ActionContext.getContext().getSession().put("admin", "admin");
				
				return SUCCESS;
		}else {
			this.addFieldError("error", "用户名和密码错误");
			return "admin_error";
		}
		
	}
	
	//注销的方法

	public String exit(){
		ActionContext.getContext().getSession().clear();
			 return "login2";
	}

	
	public void setStudentLoginService(StudentLoginService studentLoginService) {
		this.studentLoginService = studentLoginService;
	}
	public void setTeacherLoginService(TeacherLoginService teacherLoginService) {
		this.teacherLoginService = teacherLoginService;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getLeixing() {
		return leixing;
	}
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	public TestProperties getProperties() {
		return properties;
	}

	public void setProperties(TestProperties properties) {
		this.properties = properties;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPass() {
		return adminPass;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	

}
