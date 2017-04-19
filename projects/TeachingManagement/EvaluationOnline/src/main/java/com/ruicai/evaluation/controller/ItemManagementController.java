package com.ruicai.evaluation.controller;

import com.alibaba.fastjson.JSON;
import com.ruicai.evaluation.po.evaluation.EvaluationItem;
import com.ruicai.evaluation.service.impl.ItemManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "ItemManagement", method = RequestMethod.GET)
    public String ItemManagement() {
        return "ItemManagement";
    }

    @ResponseBody
    @RequestMapping(value = "getEvaluationItemTypes", method = RequestMethod.POST)
    public String getEvaluationItemTypes() {
        return JSON.toJSONString(service.getEvaluationItemTypes());
    }

    @ResponseBody
    @RequestMapping(value = "getEvaluationItems", method = RequestMethod.POST)
    public String getEvaluationItems(int page, int rows, String typeId, String enable, String itemContent) {
        return JSON.toJSONString(service.getEvaluationItems(page, rows, typeId, enable, itemContent));
    }

    @ResponseBody
    @RequestMapping(value = "addEvaluationItem", method = RequestMethod.POST)
    public String addEvaluationItem(EvaluationItem item) {
        service.addEvaluationItem(item);
        return "修改评价项成功";
    }

    @ResponseBody
    @RequestMapping(value = "editEvaluationItem", method = RequestMethod.POST)
    public String editEvaluationItem(EvaluationItem item) {
        service.editEvaluationItem(item);
        return "修改评价项成功";
    }

    @ResponseBody
    @RequestMapping(value = "deleteEvaluationItems", method = RequestMethod.POST)
    public String deleteEvaluationItems(String data) {
        List<EvaluationItem> items = JSON.parseArray(data, EvaluationItem.class);
        List<String> ids = new ArrayList<>();
        for (EvaluationItem item : items) {
            ids.add(item.getId());
        }
        service.deleteEvaluationItems(ids);
        return "删除评价项成功";
    }
}
