package com.hjj.controller;

import com.alibaba.fastjson.JSON;
import com.hjj.vo.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 朱高 on 2017/4/1.
 */
@Controller
public class ExaminationOnline {

    @RequestMapping(value = "/analysis", method = RequestMethod.GET)
    public String totoAnalysis() {
        return "onlineExam/analysis";
    }

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public String toProblemManagement() {
        return "onlineExam/problemManagement";
    }
    @RequestMapping(value = "/examination", method = RequestMethod.GET)
    public String toExaminationArrangement() {
        return "onlineExam/examinationArrangement";
    }

    @RequestMapping(value = "/datagrid", method = RequestMethod.POST)
    @ResponseBody
    public String jsonToObject(Datagrid datagrid) {
        System.out.println(datagrid);
        List<ClassMessage> list = new ArrayList<>();
        int i = (datagrid.getPage() - 1) * datagrid.getRows() + 1;
        for (; i <= 1000; i++) {
            if (i % datagrid.getRows() == 0) {
                break;
            }
            ClassMessage classMessage = new ClassMessage();
            classMessage.setId("" + i);
            classMessage.setClassName("JAVA-" + i);
            classMessage.setInvigilator("朱高");
            classMessage.setTestPhase("第一阶段");
            classMessage.setTestPlace("1512");
            classMessage.setTestTime("2014-05-02");
            list.add(classMessage);
        }
        String json = "{\"total\":120,\"rows\":" + JSON.toJSONString((List) list) + "}";
        System.out.println("json = " + json);
        return json;
    }

    @RequestMapping(value = "/className", method = RequestMethod.POST)
    @ResponseBody
    public String className(Tree tree) {
        List<Tree> list = new ArrayList<>();
        if (tree.getId() == 0) {
            Tree tree1 = new Tree(1, "JAVA", "closed", "", "", 0);
            list.add(tree1);

            Tree tree2 = new Tree(2, "UI", "closed", "", "", 0);
            list.add(tree2);

            Tree tree3 = new Tree(3, "H5", "closed", "", "", 0);
            list.add(tree3);
        } else if (tree.getId() == 1) {
            Tree tree1 = new Tree(4, "JAVA-1701", "open", "", "", 1);
            list.add(tree1);

            Tree tree2 = new Tree(5, "JAVA-1702", "open", "", "", 1);
            list.add(tree2);

            Tree tree3 = new Tree(6, "JAVA-1703", "open", "", "", 1);
            list.add(tree3);
        } else if (tree.getId() == 2) {
            Tree tree1 = new Tree(7, "UI-1701", "open", "", "", 2);
            list.add(tree1);

            Tree tree2 = new Tree(8, "UI-1702", "open", "", "", 2);
            list.add(tree2);

            Tree tree3 = new Tree(9, "UI-1703", "open", "", "", 2);
            list.add(tree3);
        } else if (tree.getId() == 3) {
            Tree tree1 = new Tree(10, "H5-1701", "open", "", "", 3);
            list.add(tree1);

            Tree tree2 = new Tree(11, "H5-1702", "open", "", "", 3);
            list.add(tree2);

            Tree tree3 = new Tree(12, "H5-1703", "open", "", "", 3);
            list.add(tree3);
        }
        String json = JSON.toJSONString(list);
        System.out.println("className = " + json);
        return json;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(ClassMessage classMessage) {
        System.out.println("add");
        System.out.println("classMessage = [" + classMessage + "]");

        return "1";
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public String find(ClassMessage classMessage) {
        String json = JSON.toJSONString(classMessage);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    @ResponseBody
    public String remove(ClassMessage classMessage) {
        System.out.println(JSON.toJSONString(classMessage));
        return "1";
    }

    @RequestMapping(value = "searchGrade", method = RequestMethod.POST)
    @ResponseBody
    public String searchGrade(ClassMessage classMessage) {
        System.out.println(classMessage);
        List list = new ArrayList();
        System.out.println(classMessage.getClassName().equals("4"));
        for (int i = 1; i <= 20; i++) {
            Student student = new Student(i, "朱高" + i);
            list.add(student);
        }
        System.out.println(JSON.toJSONString(list));
        return JSON.toJSONString(list);
    }

    @RequestMapping(value = "question", method = RequestMethod.POST)
    @ResponseBody
    public String questionFindAll() {
        List list = new ArrayList();
        for (int i = 0; i < 30; i++) {
            Question question;
            if (i % 4 == 0) {
                question = new Question(i, "请问下列选项正确的是，A...  B...  C...  D...", "选择题", "2017-03-16", "徐明", (int) (Math.random() * 100), "第一阶段");
            } else if (i % 4 == 1) {
                question = new Question(i, "判断下列题目是否正确", "判断题", "2017-03-16", "徐明", (int) (Math.random() * 100), "第二阶段");
            } else if (i % 4 == 2) {
                question = new Question(i, "什么是Java面向对象编程思想", "编程题", "2017-03-16", "徐明", (int) (Math.random() * 100), "第三阶段");
            } else {
                question = new Question(i, "什么是Java面向对象编程思想", "问答题", "2017-03-16", "徐明", (int) (Math.random() * 100), "第四阶段");
            }
            list.add(question);
        }
        return JSON.toJSONString(list);
    }

    @RequestMapping(value = "/echartsTest", method = RequestMethod.GET)
    @ResponseBody
    public String echartsTest() throws InterruptedException {
        Thread.sleep(2000);
        Echarts echarts = new Echarts();
        List list = new ArrayList();
        List data = new ArrayList();
        list.add("第一阶段");//"衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子";
        list.add("第二阶段");
        list.add("第三阶段");
        list.add("第四阶段");
        echarts.setCategories(list);
        list = new ArrayList();
        list.add(35);//data: [5, 20, 36, 10, 10, 20]
        list.add(70);
        list.add(86);
        list.add(70);
        data.add(list);
        //echarts.setData(data);
        list = new ArrayList();
        list.add(50);//data: [5, 20, 36, 10, 10, 20]
        list.add(70);
        list.add(80);
        list.add(60);
        data.add(list);

        list = new ArrayList();
        list.add(60);//data: [5, 20, 36, 10, 10, 20]
        list.add(90);
        list.add(77);
        list.add(63);

        data.add(list);
        echarts.setData(data);
        list = new ArrayList();
        list.add("JAVA-1701");
        list.add("JAVA-1702");
        list.add("JAVA-1703");
        echarts.setLegend(list);
        String json = JSON.toJSONString(echarts);
        System.out.println(json);

        return json;
    }

    @RequestMapping(value = "searchPie", method = RequestMethod.GET)
    @ResponseBody
    public String searchPie() throws InterruptedException {
        Thread.sleep(2000);
        List list = new ArrayList();
        Echarts echarts = new Echarts("60分以下", 5);
        list.add(echarts);
        echarts = new Echarts("60--70", 10);
        list.add(echarts);
        echarts = new Echarts("71--80", 13);
        list.add(echarts);
        echarts = new Echarts("81--100", 6);
        list.add(echarts);
        String json = JSON.toJSONString(list);
        System.out.println(json);
        return json;
    }
}
