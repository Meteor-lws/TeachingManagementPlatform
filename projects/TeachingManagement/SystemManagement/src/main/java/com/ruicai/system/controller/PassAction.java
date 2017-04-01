package com.ruicai.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 密码管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
@RequestMapping("/pass")
public class PassAction {

    @RequestMapping("/index.action")
    public String index() {
        return "passEdit";
    }
}
