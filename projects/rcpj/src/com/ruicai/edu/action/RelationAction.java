package com.ruicai.edu.action;

import java.util.List;

import com.ruicai.edu.entity.Relation;
import com.ruicai.edu.service.RelationService;
import com.ruicai.edu.service.imp.RelationServiceImp;

public class RelationAction {
	private int r_type;
    private	int r_sid;
	private List<Relation> list; 
	
	
	


	public List<Relation> getList() {
		return list;
	}

	public void setList(List<Relation> list) {
		this.list = list;
	}

	public int getR_sid() {
		return r_sid;
	}

	public void setR_sid(int rSid) {
		r_sid = rSid;
	}

	public int getR_type() {
		return r_type;
	}

	public void setR_type(int rType) {
		r_type = rType;
	}

	
	public String findbyid()
	{
		RelationService relationService=new RelationServiceImp();
		list=relationService.findbyid(r_sid);
		if(list!=null)
		{
		  return "findsuccess";
		}
		else
		{
			return "error";
		}
		
	}
}
