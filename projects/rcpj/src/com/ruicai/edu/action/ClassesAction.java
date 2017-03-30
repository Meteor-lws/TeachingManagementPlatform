package com.ruicai.edu.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruicai.edu.entity.Classes;
import com.ruicai.edu.entity.Teacher;
import com.ruicai.edu.service.ClassesService;
import com.ruicai.edu.service.imp.ClasserServiceImp;

public class ClassesAction {
    
  private List<Classes> list;
  private Classes classes;
  private Map<String, Object> map;
  private int type;
  private String classname;
  private int cid;
  private List<Teacher> tlist;
  
  
  
  
  
public List<Teacher> getTlist() {
	return tlist;
}

public void setTlist(List<Teacher> tlist) {
	this.tlist = tlist;
}

public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

public int getType() {
	return type;
}

public void setType(int type) {
	this.type = type;
}

public String getClassname() {
	return classname;
}

public void setClassname(String classname) {
	this.classname = classname;
}

public Map<String, Object> getMap() {
	return map;
}

public void setMap(Map<String, Object> map) {
	this.map = map;
}

public Classes getClasses() {
	return classes;
}

public void setClasses(Classes classes) {
	this.classes = classes;
}

public List<Classes> getList() {
	return list;
}

public void setList(List<Classes> list) {
	this.list = list;
}
  
  //----------------------------------------------------------------------------------
 public String selectClass()
 {
	 ClassesService classesService=new ClasserServiceImp();
	 list=classesService.selectClass();
	 if(list!=null)
	 {
		 return "clasuccess";
	 }
	 else
	 {
		 return "error";
	 }
 }
 
 public String addClass()
 {
	 ClassesService classesService=new ClasserServiceImp();
	 int count=classesService.addClass(classes);
	 System.out.println(count);
		if(count>0){
			map= new HashMap<String, Object>();
			map.put("success", true);
			map.put("msg", "添加成功");
		}else{
			map.put("success", false);
			map.put("msg", "添加失败");
		}
		return "addsuccess";
 }
 
 public String updateClass()
 {
	 ClassesService classesService=new ClasserServiceImp();
	 int count=classesService.updateClass(classes);
		if(count>0){
			map= new HashMap<String, Object>();
			map.put("success", true);
			map.put("msg", "修改成功");
		}else{
			map.put("success", false);
			map.put("msg", "修改失败");
		}
		return "updatesuccess";
 }
 
 public String findall()
 {
	 ClassesService classesService=new ClasserServiceImp();
	 list=classesService.fidnall();
	 if(list!=null)
	 {
		 return "findsuccess";
	 }
	 else
	 {
		 return "error";
	 }
 }
 
 public String findbyid()
 {
	 ClassesService classesService=new ClasserServiceImp();
	 list=classesService.findbyid(cid);
	 if(list!=null)
	 {
		 return "byidsuccess";
	 }
	 else
	 {
		 return "error";
	 }
 }
 
 public String findteacher()
 {
	 ClassesService classesService=new ClasserServiceImp();
	 tlist=classesService.findteacher();
	 if(tlist!=null)
	 {
		 return "tsuccess";
	 }
	 else
	 {
		 return "error";
	 }
 }
}
