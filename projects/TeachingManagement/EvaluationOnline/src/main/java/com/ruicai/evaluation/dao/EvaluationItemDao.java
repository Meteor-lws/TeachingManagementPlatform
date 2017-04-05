package com.ruicai.evaluation.dao;

import com.ruicai.evaluation.entity.EvaluationItem;

import java.util.List;

/**
 * 评价项DAO接口
 *
 * Created by lws on 2017/4/4.
 */
public interface EvaluationItemDao {
    List<EvaluationItem> findAll();
}
