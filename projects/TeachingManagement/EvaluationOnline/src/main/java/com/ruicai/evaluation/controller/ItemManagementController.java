package com.ruicai.evaluation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 评价项管理控制器
 *
 * Created by lws on 2017/4/17.
 */
@SuppressWarnings("SameReturnValue")
@Controller
public class ItemManagementController {

    @RequestMapping(value = "ItemManagement", method = RequestMethod.GET)
    public String ItemManagement() {
        return "ItemManagement";
    }
}
