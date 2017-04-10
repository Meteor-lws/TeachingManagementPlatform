package com.ruicai.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 学生管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
public class StudentController {

    @RequestMapping("/student")
    public String index() {
        return "studentEdit";
    }
}
