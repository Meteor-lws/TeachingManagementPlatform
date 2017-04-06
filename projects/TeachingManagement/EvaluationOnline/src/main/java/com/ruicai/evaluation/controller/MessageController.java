package com.ruicai.evaluation.controller;

import com.alibaba.fastjson.JSON;
import com.ruicai.evaluation.dao.MessageDao;
import com.ruicai.evaluation.entity.Message;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
 * 留言审核控制器
 *
 * Created by lws on 2017/4/5.
*/

@SuppressWarnings("SameReturnValue")
@Controller
public class MessageController {
    private SqlSessionFactory sessionFactory;

    MessageController() {
        Logger logger = LoggerFactory.getLogger(EvaluationController.class);
        try (InputStream mybatisConfig = Resources.getResourceAsStream("mybatis/config.xml")) {
            sessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfig);
        } catch (IOException e) {
            logger.error("加载MyBatis配置文件失败");
        }
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String message() {
        return "message";
    }

    @ResponseBody
    @RequestMapping(value = "/messageData", method = RequestMethod.POST)
    public String messageData() {
        List<Message> messages;
        try (SqlSession session = sessionFactory.openSession()) {
            MessageDao dao = session.getMapper(MessageDao.class);
            messages = dao.findAll();
        }
        return JSON.toJSONString(messages);
    }

    @ResponseBody
    @RequestMapping(value = "/removeMessage", method = RequestMethod.POST)
    public String removeMessage(@RequestParam(value = "ids[]") int[] ids) {
        try (SqlSession session = sessionFactory.openSession()) {
            MessageDao dao = session.getMapper(MessageDao.class);
            dao.deleteMessages(ids);
            session.commit();
        }
        return "删除留言成功";
    }
}
