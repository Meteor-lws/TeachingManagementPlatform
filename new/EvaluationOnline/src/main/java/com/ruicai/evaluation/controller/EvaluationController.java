package com.ruicai.evaluation.controller;

import com.alibaba.fastjson.JSON;
import com.ruicai.evaluation.dto.Datagrid;
import com.ruicai.evaluation.dto.Pager;
import com.ruicai.evaluation.entity.Evaluation;
import com.ruicai.evaluation.entity.EvaluationType;
import com.ruicai.evaluation.entity.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 在线评教子系统控制器
 * <p>
 * Created by lws on 2017/3/27.
 */
@Controller
public class EvaluationController {
    private List<EvaluationType> types;
    private List<Evaluation> evaluations;
    private List<Message> messages;

    private EvaluationController() {
        prepareEvaluationTypes();
        prepareEvaluations();
        prepareMessages();
    }

    private void prepareEvaluationTypes() {
        types = new ArrayList<>();
        EvaluationType type;
        type = new EvaluationType();
        type.setId(1);
        type.setType("讲师");
        types.add(type);
        type = new EvaluationType();
        type.setId(2);
        type.setType("班主任");
        types.add(type);
        type = new EvaluationType();
        type.setId(3);
        type.setType("助教");
        types.add(type);
    }

    private void prepareEvaluations() {
        int p1, p2;
        Random random = new Random();
        int length = minMax(100, 200);
        evaluations = new ArrayList<>();
        String[] contents = {"准备认真", "态度和蔼", "生动有趣", "案例丰富", "关心学生"};
        for (int i = 0; i < length; i++) {
            p1 = random.nextInt(3);
            p2 = random.nextInt(5);
            Evaluation evaluation = new Evaluation();
            evaluation.setId(i);
            evaluation.setEnable("是");
            evaluation.setType(types.get(p1).getType());
            evaluation.setContent(contents[p2]);
            evaluations.add(evaluation);
        }
    }

    private void prepareMessages() {
        int p1, p2, p3, p4;
        messages = new ArrayList<>();
        Random random = new Random();
        int length = minMax(200, 300);
        String[] contents = {"你好", "我不好", "你在哪", "我看不见", "再见了"};
        String[] users = {"张三", "李四", "王五", "刘大", "胡小"};
        String[] times = {"2017-02-23", "2017-03-22", "2017-03-24", "2017-03-20", "2017-03-15"};
        for (int i = 0; i < length; i++) {
            p1 = random.nextInt(5);
            p2 = random.nextInt(5);
            p3 = random.nextInt(5);
            p4 = random.nextInt(5);
            Message message = new Message();
            message.setId(i);
            message.setContent(contents[p1]);
            message.setFrom(users[p2]);
            message.setTo(users[p3]);
            message.setTime(times[p4]);
            messages.add(message);
        }
    }

    private int minMax(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }

    @ResponseBody
    @RequestMapping(value = "/EvaluationType", method = RequestMethod.POST)
    public String EvaluationType() {
        return JSON.toJSONString(types);
    }

    @ResponseBody
    @RequestMapping(value = "/EvaluationData", method = RequestMethod.POST)
    public String EvaluationData(Pager pager) {
        Datagrid<Evaluation> datagrid = new Datagrid<>();
        datagrid.setTotal(evaluations.size());
        int from = (pager.getPage() - 1) * pager.getRows();
        int to = pager.getPage() * pager.getRows();
        if (to > evaluations.size()) {
            to = evaluations.size();
        }
        datagrid.setRows(evaluations.subList(from, to));
        return JSON.toJSONString(datagrid);
    }

    @ResponseBody
    @RequestMapping(value = "/MessageData", method = RequestMethod.POST)
    public String MessageData(Pager pager) {
        Datagrid<Message> datagrid = new Datagrid<>();
        datagrid.setTotal(messages.size());
        int from = (pager.getPage() - 1) * pager.getRows();
        int to = pager.getPage() * pager.getRows();
        if (to > messages.size()) {
            to = messages.size();
        }
        datagrid.setRows(messages.subList(from, to));
        return JSON.toJSONString(datagrid);
    }

    @ResponseBody
    @RequestMapping(value = "/AddEvaluation", method = RequestMethod.POST)
    public String AddEvaluation(Evaluation evaluation) {
        evaluation.setId(evaluations.size());
        evaluations.add(0, evaluation);
        return evaluation.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/EditEvaluation", method = RequestMethod.POST)
    public String EditEvaluation(Evaluation evaluation) {
        System.out.println(evaluation);
        evaluations.set(evaluation.getId(), evaluation);
        return evaluation.toString();
    }
}
