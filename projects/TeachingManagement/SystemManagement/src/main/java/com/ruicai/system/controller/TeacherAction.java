package com.ruicai.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 教师管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
public class TeacherAction {

    @RequestMapping("/teacher")
    public String index() {

        return "teacherEdit";
    }
}
