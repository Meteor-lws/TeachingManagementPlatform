package com.ruicai.edu.service;

import java.util.List;

import com.ruicai.edu.entity.Classes;
import com.ruicai.edu.entity.Teacher;

public interface ClassesService {
   
	public List<Classes> selectClass();
	
	public int addClass(Classes classes);
	
	public int updateClass(Classes classes);
	
	public List<Classes> fidnall();
	
	public List<Classes> findbyid(int cid);
	
	public List<Teacher> findteacher();
}
