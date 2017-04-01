package com.ruicai.education.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 课表管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
@RequestMapping("/schedule")
public class ScheduleAction {

    @RequestMapping("/index.action")
    public String index() {
        return "scheduleEdit";
    }
}
