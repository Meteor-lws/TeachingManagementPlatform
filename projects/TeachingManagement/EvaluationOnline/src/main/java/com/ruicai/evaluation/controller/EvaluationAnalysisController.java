package com.ruicai.evaluation.controller;

import com.alibaba.fastjson.JSON;
import com.ruicai.evaluation.service.impl.EvaluationAnalysisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 评价分析控制器
 *
 * Created by lws on 2017/4/17.
 */
@SuppressWarnings("SameReturnValue")
@Controller
public class EvaluationAnalysisController {
    private final EvaluationAnalysisServiceImpl service;

    @Autowired
    public EvaluationAnalysisController(EvaluationAnalysisServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(value = "EvaluationAnalysis", method = RequestMethod.GET)
    public String EvaluationAnalysis() {
        return "EvaluationAnalysis";
    }

    @ResponseBody
    @RequestMapping(value = "GetAnalysisResults", method = RequestMethod.POST)
    public String GetAnalysisResults() {
        return JSON.toJSONString(service.GetAnalysisResults());
    }
}
