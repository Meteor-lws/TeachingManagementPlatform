package com.ruicai.system.service;

import java.util.List;

/**
 * 通用Service接口
 *
 * Created by lws on 2017/4/10.
 */
public interface BaseService<T> {
    T findById(String id);
    List<T> findAll();

    void deleteById(String id);
}
