package com.ruicai.evaluation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 评价分析控制器
 *
 * Created by lws on 2017/4/17.
 */
@SuppressWarnings("SameReturnValue")
@Controller
public class EvaluationAnalysisController {

    @RequestMapping(value = "EvaluationAnalysis", method = RequestMethod.GET)
    public String EvaluationAnalysis() {
        return "EvaluationAnalysis";
    }
}
