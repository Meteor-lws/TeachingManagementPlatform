package com.ruicai.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 密码管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
public class UserController {

    @RequestMapping("/user")
    public String index() {
        return "userEdit";
    }

    @RequestMapping(value = "UserManagement", method = RequestMethod.GET)
    public String UserManagement() {
        return "UserManagement";
    }
}
