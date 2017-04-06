package com.ruicai.education.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 学生管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
public class StudentAction {

    @RequestMapping("/student")
    public String index() {
        return "studentEdit";
    }
}
