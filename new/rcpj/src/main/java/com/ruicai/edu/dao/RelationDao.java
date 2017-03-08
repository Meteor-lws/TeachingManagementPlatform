package com.ruicai.edu.dao;

import java.util.List;

import com.ruicai.edu.entity.Relation;

public interface RelationDao {
	
	public List<Relation> findbyid (int r_sid);

}
