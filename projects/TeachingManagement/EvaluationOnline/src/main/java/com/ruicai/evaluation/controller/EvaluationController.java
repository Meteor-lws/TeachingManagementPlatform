package com.ruicai.evaluation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 在线评教控制器
 *
 * Created by lws on 2017/3/31.
 */
@SuppressWarnings("SameReturnValue")
@Controller
public class EvaluationController {

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
}
