package com.ruicai.edu.entity;

import java.util.Date;

public class Evaluate {

	private int e_id; //评分项id
	private String e_name;//评分项
	private int   e_use; //是否启用（0，不起用，1启用，默认是1）
	private int e_type;  //评价类型（0学校，1老师。2班主任）
	
	public int getE_id() {
		return e_id;
	}
	public void setE_id(Integer eId) {
		e_id = eId;
	}
	
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String eName) {
		e_name = eName;
	}
	public int getE_use() {
		return e_use;
	}
	public void setE_use(Integer eUse) {
		e_use = eUse;
	}
	public int getE_type() {
		return e_type;
	}
	public void setE_type(Integer eType) {
		e_type = eType;
	}
	
}
