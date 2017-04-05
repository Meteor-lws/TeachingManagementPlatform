package com.ruicai.evaluation.dao;

import com.ruicai.evaluation.entity.Message;

import java.util.List;

/**
 * 留言DAO接口
 *
 * Created by lws on 2017/4/4.
 */
public interface MessageDao {
    List<Message> findAll();

    void deleteMessages(int[] ids);
}
