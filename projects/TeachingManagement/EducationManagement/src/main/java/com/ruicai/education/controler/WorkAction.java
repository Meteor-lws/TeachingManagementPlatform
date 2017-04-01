package com.ruicai.education.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 考勤管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
@RequestMapping("/work")
public class WorkAction {

    @RequestMapping("/index.action")
    public String index() {
        return "workEdit";
    }
}
