package com.ruicai.edu.action;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.Request;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.ruicai.edu.entity.Grade;
import com.ruicai.edu.entity.GradeInfo;
import com.ruicai.edu.entity.Student;
import com.ruicai.edu.getsqlsession.Json;
import com.ruicai.edu.service.GradeService;
import com.ruicai.edu.service.StudentService;
import com.ruicai.edu.service.imp.GradeServiceImp;
import com.ruicai.edu.service.imp.StudentServiceImp;

public class StudentAction extends ActionSupport {
	StudentService studentService = new StudentServiceImp();
	GradeService gradeService=new GradeServiceImp();
	private Student student;
	private List<Student> students;
	private String providerIds;
	private String  sid;
	private String  tid;
	
	private String name;
	private Map<String, Object> map;
	private List<String> list;
	
	
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String loadStudents() {// 加载所有学生信息
		students = studentService.queryStudent();
		// System.out.println(students);
		System.out.println("已经加载所有学生信息"+student);
		return "loadStudents";
	}
	public String selectStudentsByTeacherid() {// 加载所有学生信息
		
		/*students = studentService.selectStudentsByTeacherid(tid);
		List<GradeInfo> infos=new ArrayList<GradeInfo>();
		int teacherSum=0;
		int unMarkCount=0;
		int size=students.size()==0?1:students.size();
		for (Student student : students) {
			int id=student.getS_id();
			GradeInfo gradeInfo=new GradeInfo();
			gradeInfo.s_id=id;
			gradeInfo.s_name=student.getS_name();
			gradeInfo.s_class=student.getS_class();
			int sumMark=gradeService.getSumMark(""+id,tid);
			if(sumMark==0){
				gradeInfo.sum="未评价";
				unMarkCount++;
			}else{
				gradeInfo.sum=sumMark+"";
			}
			teacherSum+=sumMark;
			gradeInfo.advice=gradeService.findAdviceByStudentID(""+id,tid);
			infos.add(gradeInfo);
		}*/
		List<GradeInfo> infos=gradeService.loadGradeInfoByTeacherId(tid);
		int teacherSum=0;
		int unMarkCount=0;
		int size=infos.size()==0?1:infos.size();
		for (GradeInfo info : infos) {
			int sumMark=Integer.parseInt(info.getSum());
			if(sumMark==0){
				info.sum="未评价";
				unMarkCount++;
			}
			teacherSum+=sumMark;
		}
		JSONArray array=new JSONArray();
		JSONObject obj=new JSONObject();
		/*obj.put("s_name", );
		obj.put("s_class", teacherSum/infos.size());*/
		obj.put("s_class", "总分");
		obj.put("sum", teacherSum);
		array.add(obj);
		obj=new JSONObject();
		obj.put("s_class", "平均分");
		DecimalFormat format=new DecimalFormat("#.00");
		if(size-unMarkCount!=0)
		   obj.put("sum",format.format(teacherSum/(size-unMarkCount)));
		else
		   obj.put("sum",0);
		array.add(obj);
		map=new HashMap<String, Object>();
		map.put("total", size);
		map.put("rows", infos);
		map.put("footer", array);
		return "selectStudentsByTeacherid";
	}

	public String deleteStudents() throws IOException {// 删除对应学生信息
		providerIds = providerIds.substring(0, providerIds.length() - 1);
		String[] deleteIds = providerIds.split(",");
		int delCount = studentService.deleteStudent(deleteIds);
		if(delCount>0){
			map= new HashMap<String, Object>();
			map.put("success", true);
			map.put("msg", "删除成功");
		}else{
			map.put("success", false);
			map.put("msg", "删除失败");
		}
		
		return "loads";
	}

	public String addStudent() throws IOException { // 添加和修改学生信息
		System.out.println("进入添加");
		int mag= studentService.addStudent(student);
		System.out.println(mag);
		if(mag>0){
			map= new HashMap<String, Object>();
			map.put("success", true);
			map.put("msg", "添加成功");
		}else{
			map.put("success", false);
			map.put("msg", "添加失败");
		}
		
		return "loads";
	}

	public String updateStudent() throws IOException {// 修改
		System.out.println("进入更新");
		student.setS_id(Integer.parseInt(sid));
	 int mag=studentService.updateOneStudent(student);
		if(mag>0)
		{
			map= new HashMap<String, Object>();
			map.put("success",true);
			map.put("msg","更新成功");
		}
		else
		{
			map.put("success", true);
			map.put("msg","更新失败");
		}
		return "loads";
	}

	public String selectOne() { // 查找对应学生信息
		System.out.println("查找" + name);
		students = studentService.showStudent(name);
		System.out.println(students + "返回的数列");
		return "loadStudents";
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}


	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String getProviderIds() {
		return providerIds;
	}

	public void setProviderIds(String providerIds) {
		this.providerIds = providerIds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}






}
