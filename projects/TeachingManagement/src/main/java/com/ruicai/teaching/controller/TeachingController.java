package com.ruicai.teaching.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 教学管理平台控制器
 *
 * Created by lws on 2017/3/30.
 */
@Controller
public class TeachingController {

    @RequestMapping(value = "/front", method = RequestMethod.GET)
    public String front() {
        System.out.println("hh");
        return "front";
    }

    @RequestMapping(value = "/background", method = RequestMethod.GET)
    public String background() {
        System.out.println("gg");
        return "background";
    }
}
