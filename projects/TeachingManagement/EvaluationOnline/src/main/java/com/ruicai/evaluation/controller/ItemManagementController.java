package com.ruicai.evaluation.controller;

import com.alibaba.fastjson.JSON;
import com.ruicai.evaluation.service.impl.ItemManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 评价项管理控制器
 *
 * Created by lws on 2017/4/17.
 */
@SuppressWarnings("SameReturnValue")
@Controller
public class ItemManagementController {
    private final ItemManagementServiceImpl service;

    @Autowired
    public ItemManagementController(ItemManagementServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(value = "item", method = RequestMethod.GET)
    public String ItemManagement() {
        return "item";
    }

    @ResponseBody
    @RequestMapping(value = "getEvaluationItemTypes", method = RequestMethod.POST)
    public String getEvaluationItemTypes() {
        return JSON.toJSONString(service.getEvaluationItemTypes());
    }
}
