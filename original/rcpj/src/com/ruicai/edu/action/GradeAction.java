package com.ruicai.edu.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.ruicai.edu.entity.Evaluate;
import com.ruicai.edu.entity.Grade;
import com.ruicai.edu.entity.Relation;
import com.ruicai.edu.entity.Student;
import com.ruicai.edu.entity.Teacher;
import com.ruicai.edu.service.GradeService;
import com.ruicai.edu.service.imp.GradeServiceImp;


public class GradeAction {

	private String select;
	private String advice;
	private String g_time;
	private String g_name;
	private List studentList;
	private List teacherList;
	private List<Grade> list;
	private Map<String, Object> map=new HashMap<String, Object>();
	

	private String studentID,teacherID;


	//	private HashMap<String, Object> map = new HashMap<String, Object>();
	private GradeService gradeService = new GradeServiceImp();
	
	//开启下一轮
	public void beginNext() throws Exception{
		System.out.println("进来了");
		int count = gradeService.beginNext();
		System.out.println(count);
	}
	
	//查未评价
	public String selectNoPinJia() throws Exception{
		System.out.println("进来了");
		studentList = gradeService.selectNoPinJia();
		System.out.println("查出来student了");
		return "loadStudent";
	}
	//查平均分每月
	public String selectAvg() throws Exception{
		g_time = g_time.substring(0, 7);
		System.out.println("action的时间参数"+g_time);
	    teacherList = gradeService.selectAvg(g_time);
	    


	    
		return "loadTeacher";
	}
	
	public String addGrade(){
		
//		学员正常进入后才有session
		System.out.println("学生对象的引用"+ActionContext.getContext().getSession().get("student"));
		Student student=(Student) ActionContext.getContext().getSession().get("student");
//		grade.setG_sid(student.getS_id());
		System.out.println("老师对象的引用"+ActionContext.getContext().getSession().get("teacherId"));
		Integer teacherID=(Integer) ActionContext.getContext().getSession().get("teacherId");
		System.out.println(teacherID);
		System.out.println("测试一下");
		System.out.println(select);
		String[] a=select.split(",");
		List<Evaluate> list=(List) ActionContext.getContext().getSession().get("evaluates");
		List insertList = new ArrayList<Grade>();
		
		for(int i=0;i<list.size();i++){
			Grade grade=new Grade(student.getS_id(), teacherID, new Date());  //构造函数，参数依次是学生id，老师id，评价时间	
			grade.setG_eid(list.get(i).getE_id());
			grade.setG_mark( Integer.parseInt ( a[i].trim() ) );
			insertList.add(grade);
		}
		
		Grade grade=new Grade(student.getS_id(),teacherID,new Date());
		System.out.println(advice);
		grade.setG_advice(advice);
		Relation relation =new Relation();
		relation.setR_sid(student.getS_id());
		relation.setR_tid(teacherID);	
		System.out.println("成功添加"+new GradeServiceImp().addGrade(insertList)+"行");
		System.out.println("成功添加"+new GradeServiceImp().addGradeAdvice(grade,relation)+"行");
		return "success";
	}
	
    public String findgrade()
    {
    	list=gradeService.findgrade();
    	if(list!=null)
    	{
    		return "findsuccess";
    	}
    	else
    	{
    		return "error";
    	}
    }
    public String findgradeByStudentID()
    {
    	list=gradeService.findgradeByStudentID(studentID,teacherID);
    	JSONArray arr=new JSONArray();
		JSONObject obj=new JSONObject();
		obj.put("e_name", "所属老师");
		obj.put("g_time", "总分");
		obj.put("g_mark", "平均分");
		arr.add(obj);
		obj=new JSONObject();
		obj.put("e_name", "王艺");
		obj.put("g_time", "20");
		obj.put("g_mark", "30");
		arr.add(obj);
		map=new HashMap<String, Object>();
		map.put("total", list.size());
		map.put("rows", list);
		map.put("footer", arr);
    	return "findgradeByStudentID";
    }
    
    public String selectBYtime()
    {
    	System.out.println(g_time);
    	list=gradeService.selectBYtime(g_time);
    	if(list!=null)
    	{
    		return "bytimesuccess";
    	}
    	else
    	{
    		return "error";
    	}
    }
    
    public String selectBYname()
    {
    	list=gradeService.selectBYname(g_name);
    	if(list!=null)
    	{
    		return "bynamesuccess";
    	}
    	else
    	{
    		return "error";
    	}
    }
    
    public String selectAll()
    {
    	System.out.println(g_time+ g_name);
    	Map<String,Object>map=new HashMap<String, Object>();
    	map.put("g_name", g_name);
    	map.put("g_time",g_time);
    	list=gradeService.selectAll(map);
    	if(list!=null)
    	{
    		return "allsuccess";
    	}
    	else
    	{
    		return "error";
    	}
    }
	
//getter,setter方法	

    
	
	public String getSelect() {
		return select;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String gName) {
		g_name = gName;
	}

	public List<Grade> getList() {
		return list;
	}

	public void setList(List<Grade> list) {
		this.list = list;
	}

	public void setSelect(String select) {
		this.select = select;
	}


	public String getAdvice() {
		return advice;
	}


	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public GradeService getGradeService() {
		return gradeService;
	}

	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}

	public String getG_time() {
		return g_time;
	}

	public void setG_time(String gTime) {
		g_time = gTime;
	}

	public List getStudentList() {
		return studentList;
	}

	public void setStudentList(List studentList) {
		this.studentList = studentList;
	}
	public void setTeacherList(List teacherList) {
		this.teacherList = teacherList;
	}
	public List getTeacherList() {
		return teacherList;
	}
	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
//	public void setMap(HashMap<String, Object> map) {
//		this.map =map;
//	}
//	
//	public Map<String, Object> getMap() {
//		return map;
//	}
	
}
