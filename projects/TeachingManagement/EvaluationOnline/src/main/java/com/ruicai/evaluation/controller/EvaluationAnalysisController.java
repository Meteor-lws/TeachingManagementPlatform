package com.ruicai.evaluation.controller;

import com.ruicai.evaluation.vo.EvaluationAnalysisView;
import com.ruicai.evaluation.vo.EvaluationView;
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

    @RequestMapping(value = "EvaluationAnalysis", method = RequestMethod.GET)
    public String EvaluationAnalysis() {
        return "EvaluationAnalysis";
    }

    @ResponseBody
    @RequestMapping(value = "GetAnalysisResults", method = RequestMethod.POST)
    public String GetAnalysisResults() {
        EvaluationView evaluationView = new EvaluationView();
        EvaluationAnalysisView analysisView = new EvaluationAnalysisView();
        System.out.println(evaluationView + ":" + analysisView);
        return "";
    }
}
