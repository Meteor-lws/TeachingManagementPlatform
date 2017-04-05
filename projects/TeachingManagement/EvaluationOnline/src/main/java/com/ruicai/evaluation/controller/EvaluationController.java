package com.ruicai.evaluation.controller;

import com.alibaba.fastjson.JSON;
import com.ruicai.evaluation.dao.EvaluationItemDao;
import com.ruicai.evaluation.dao.EvaluationTypeDao;
import com.ruicai.evaluation.dao.MessageDao;
import com.ruicai.evaluation.entity.EvaluationItem;
import com.ruicai.evaluation.entity.EvaluationType;
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

/**
 * 在线评教控制器
 *
 * Created by lws on 2017/3/31.
 */
@SuppressWarnings("SameReturnValue")
@Controller
public class EvaluationController {
    private final Logger logger;
    private SqlSessionFactory sessionFactory;

    EvaluationController() {
        logger = LoggerFactory.getLogger(EvaluationController.class);
        try (InputStream mybatisConfig = Resources.getResourceAsStream("mybatis/config.xml")) {
            sessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfig);
        } catch (IOException e) {
            logger.error(e.toString());
        }
    }

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public String item() {
        return "item";
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String message() {
        return "message";
    }

    @RequestMapping(value = "/analysis", method = RequestMethod.GET)
    public String analysis() {
        return "analysis";
    }

    @ResponseBody
    @RequestMapping(value = "/evaluationType", method = RequestMethod.POST)
    public String evaluationType() {
        List<EvaluationType> types;
        try (SqlSession session = sessionFactory.openSession()) {
            EvaluationTypeDao dao = session.getMapper(EvaluationTypeDao.class);
            types = dao.findAll();
        }
        return JSON.toJSONString(types);
    }

    @ResponseBody
    @RequestMapping(value = "/evaluationItem", method = RequestMethod.POST)
    public String evaluationItem() {
        List<EvaluationItem> items;
        try (SqlSession session = sessionFactory.openSession()) {
            EvaluationItemDao dao = session.getMapper(EvaluationItemDao.class);
            items = dao.findAll();
        }
        return JSON.toJSONString(items);
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
    public String removeMessage(@RequestParam(value = "urls[]", required = false, defaultValue = "") String[] urls) {
        for (String url : urls) {
            logger.debug(url);
        }
        // for (int id : data.getIds()) {
        //     logger.debug(String.valueOf(id));
        // }
        // try (SqlSession session = sessionFactory.openSession()) {
        //     MessageDao dao = session.getMapper(MessageDao.class);
        //     dao.deleteMessages(messages);
        // }
        return "success";
    }
}
