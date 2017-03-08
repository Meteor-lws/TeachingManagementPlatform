package com.ruicai.edu.dao;

import java.util.List;
import java.util.Map;

import com.ruicai.edu.entity.Classes;
import com.ruicai.edu.entity.Teacher;

public interface ClassesDao {
    
	public List<Classes> selectClass();
	
	public int addClass(Classes classes);
	
	public int updateClass(Classes classes);
	
	public List<Classes> findall();
	
	public List<Classes>findbyid(int cid);
	
	public List<Teacher> findteacher();
}
