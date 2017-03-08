package com.ruicai.edu.dao;

/*
 * 数据库接口
 */
import java.util.List;
import java.util.Map;

import com.ruicai.edu.entity.BBS;
import com.ruicai.edu.entity.Teacher;

public interface BBS_Dao {
	//查询留言
	public  List<BBS> liuyanAll();
	
	//删除指定留言
	public  int liuyanDelete(int ids);
	
	//查询指定留言
	public List<BBS> liuyanFind(String b_ly);
	
	//前台显示老师数据
	public List<Teacher> liuyanShow(int t_id);
	
	//显示留言
	public List<BBS>liuyanOnclick(int t_id);
	
	//添加留言
	public int liuyanAdd(Map<String,Object> map);
	
	
}
