package com.ruicai.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 主网页控制器
 *
 * Created by lws on 2017/4/1.
 */
@SuppressWarnings("SameReturnValue")
@Controller
public class WebController {

    @RequestMapping(value = "/front", method = RequestMethod.GET)
    public String front() {
        return "front";
    }

    @RequestMapping(value = "/background", method = RequestMethod.GET)
    public String background() {
        return "background";
    }
}
