package com.ruicai.edu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.ruicai.edu.entity.Relation;
import com.ruicai.edu.entity.Student;
import com.ruicai.edu.service.PinJiaService;
import com.ruicai.edu.service.imp.PinjiaServiceImp;

public class PinJiaAction {

	private String teacherID;
	private PinJiaService pinJiaService = new PinjiaServiceImp();
	private HttpServletRequest request;

	public String choiceStudent() {
		// 过滤学生评价权限
		System.out.println(teacherID);
		request = ServletActionContext.getRequest();
		int tid = Integer.parseInt(teacherID);// 接收；老师id
		Student student = (Student) ActionContext.getContext().getSession()
				.get("student");
		int sid = student.getS_id();// 根据学生得到班级，再查班级内的老师是否是当前点击的老师
		List<Relation> list = pinJiaService.select(sid);

		for (int i = 0; i < list.size(); i++) {// 同班的老师和学生
			if (tid == list.get(i).getR_tid() && list.get(i).getR_type() == 0) {
				ActionContext.getContext().getSession().put("teacherId", list.get(i).getR_tid());
				return "success";
			}
			System.out.println("没找到");
		}

		return "error";
	}

	
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public String pString() {
		return teacherID;
	}
	
	public void setPinJiaService(PinJiaService pinJiaService) {
		this.pinJiaService = pinJiaService;
	}
	public PinJiaService getPinJiaService() {
		return pinJiaService;
	}
}
