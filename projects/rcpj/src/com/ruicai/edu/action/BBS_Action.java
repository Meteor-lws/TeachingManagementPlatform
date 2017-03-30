package com.ruicai.edu.action;

import java.util.ArrayList;
import java.util.List;

import com.ruicai.edu.entity.BBS;
import com.ruicai.edu.entity.Teacher;
import com.ruicai.edu.getsqlsession.GetTime;
import com.ruicai.edu.service.BBS_Service;
import com.ruicai.edu.service.imp.BBS_Serviceipm;

public class BBS_Action {
   private String ids;//多选框传回字符串
   private List<BBS> list;//对象集合
   private String b_ly;//留言内容
   private int s_id;//获取学生的ID
   private int t_id;//获取老师的ID
   private List<Teacher>tlist;
   private String text;
   private String mag;
   
  
   
   public String getMag() {
	return mag;
}
public void setMag(String mag) {
	this.mag = mag;
}
public List<Teacher> getTlist() {
	return tlist;
}
public void setTlist(List<Teacher> tlist) {
	this.tlist = tlist;
}
public String getIds() {
	return ids;
}
public void setT_id(int tId) {
	t_id = tId;
}
	public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
	public List<BBS> getList() {
		return list;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int sId) {
		s_id = sId;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(Integer tId) {
		t_id = tId;
	}
	public void setList(List<BBS> list) {
		this.list = list;
	}


	public String getB_ly() {
		return b_ly;
	}
	public void setB_ly(String bLy) {
		b_ly = bLy;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	/*
	 *  查询全部留言
	 */
	public String liuyanAll()
	{
		BBS_Service bbsServiceipm=new BBS_Serviceipm();
		list=bbsServiceipm.liuyanAll();
		if(list!=null)
		{
		return "success";
		}
		else
		{
			return "error";
		}
	}
	
	/*
	 * 删除指定留言
	 */
	
	public String liuyanDelete()
	{
		BBS_Service bbsServiceimp=new BBS_Serviceipm();
	    int count=bbsServiceimp.liuyanDelete(ids);
	    if(count==1)
	  {
	    	mag="删除成功";
		  return "success";
		 
	  }
	  else {
		return "error";
	  }
	}
	
	/*
	 * 查询指定留言
	 */
	public String liuyanFind()
	{
		BBS_Service bbsServiceimp=new BBS_Serviceipm();
		list=new ArrayList<BBS>();
		list=bbsServiceimp.liuyanFind(b_ly);
		if(list!=null)
		{
			return "success";
		}
		else
		{
			return "error";
		}
	}
	/*
	 * 在前台老师数据
	 */
	public String liuyanShow()
	{
		BBS_Service bbsServiceimp=new BBS_Serviceipm();
		tlist=new ArrayList<Teacher>();
		tlist=bbsServiceimp.liuyanShow(t_id);
		if(tlist!=null)
		{
			return "success";
		}
		else
		{
			return "error";
		}
		
	}
	/*
	 * 显示留言
	 */
	public String liuyanOnclick()
	{
		BBS_Service bbsServiceimp=new BBS_Serviceipm();
		list=new ArrayList<BBS>();
		list=bbsServiceimp.liuyanOnclick(t_id);
		
			System.out.println("成功");
			return "success";
	}
	
	/*
	 * 添加留言
	 */
	public String liuyanAdd()
	{
		BBS_Service bbsServiceimp=new BBS_Serviceipm();
		System.out.println(s_id);
		System.out.println(t_id);
		System.out.println(text);
		String b_time=GetTime.gettime();
		int i=	bbsServiceimp.liuyanAdd(text, b_time, s_id, t_id);
		if(i==1)
		{
			return "success";
		}
		else
		{
			return "error";
		}
	}

}

