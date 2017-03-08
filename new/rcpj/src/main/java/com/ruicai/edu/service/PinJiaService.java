package com.ruicai.edu.service;

import java.util.List;

import com.ruicai.edu.entity.Relation;

public interface PinJiaService {
  public abstract List<Relation> select(int s_id);
}
