package com.ruicai.evaluation.dao;

import com.ruicai.evaluation.entity.EvaluationType;

import java.util.List;

/**
 * 评价类型DAO接口
 *
 * Created by lws on 2017/4/4.
 */
public interface EvaluationTypeDao {
    List<EvaluationType> findAll();
}
