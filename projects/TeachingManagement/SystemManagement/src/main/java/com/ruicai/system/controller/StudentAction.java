package com.ruicai.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 学生管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
@RequestMapping("/student")
public class StudentAction {

    @RequestMapping("/index.action")
    public String index() {
        return "studentEdit";
    }
}
