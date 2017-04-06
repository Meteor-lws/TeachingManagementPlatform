package com.ruicai.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by XuMing on 2017/4/4.
 */
@Controller
public class PremissionAction {
    @RequestMapping("/premission")
    public String index() {
        return "premissionEdit";
    }
}
