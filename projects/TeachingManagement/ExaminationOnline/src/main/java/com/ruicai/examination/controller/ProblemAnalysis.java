package com.ruicai.examination.controller;

import com.alibaba.fastjson.JSON;
import com.ruicai.examination.vo.Echarts;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 朱高 on 2017/5/5.
 */
@Controller
public class ProblemAnalysis {

    @RequestMapping(value = "/analysis", method = RequestMethod.GET)
    public String analysis() {
        return "onlineExam/analysis";
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
