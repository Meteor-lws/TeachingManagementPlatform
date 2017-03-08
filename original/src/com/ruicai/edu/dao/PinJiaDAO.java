package com.ruicai.edu.dao;

import java.util.List;

import com.ruicai.edu.entity.Relation;

public interface PinJiaDAO {
  public abstract List<Relation> select(int s_id);//班级查老师  
}
