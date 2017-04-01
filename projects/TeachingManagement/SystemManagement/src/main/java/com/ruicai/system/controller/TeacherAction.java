package com.ruicai.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 教师管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherAction {

    @RequestMapping("/index.action")
    public String index() {

        return "teacherEdit";
    }
}
