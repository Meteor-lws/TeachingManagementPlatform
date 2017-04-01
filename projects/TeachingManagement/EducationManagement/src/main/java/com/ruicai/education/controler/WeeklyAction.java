package com.ruicai.education.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 周报管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
@RequestMapping("/weekly")
public class WeeklyAction {

    @RequestMapping("/index.action")
    public String index() {
        return "weeklyEdit";
    }
}
