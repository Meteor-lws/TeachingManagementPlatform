package com.ruicai.system.controller;

import com.alibaba.fastjson.JSON;
import com.ruicai.system.service.DictionaryService;
import com.ruicai.system.service.DictionaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 数据字典控制器
 *
 * Created by XuMing on 2017/4/5.
 */
@SuppressWarnings("SameReturnValue")
@Controller
public class DictionaryController {

    private final DictionaryTypeService typeService;

    private final DictionaryService dictionaryService;

    @Autowired
    public DictionaryController(DictionaryTypeService typeService, DictionaryService dictionaryService) {
        this.typeService = typeService;
        this.dictionaryService = dictionaryService;
    }

    @RequestMapping(value = "/dictionary", method = RequestMethod.GET)
    public String dictionary() {
        return "dictionary";
    }

    @ResponseBody
    @RequestMapping(value = "/getDictionaryTypes", method = RequestMethod.POST)
    public String getDictionaryTypes() {
        return JSON.toJSONString(typeService.getDictionaryTypes());
    }

    @ResponseBody
    @RequestMapping(value = "/getDictionariesByTypeId", method = RequestMethod.POST)
    public String getDictionariesByTypeId(String typeId) {
        return typeId == null ? null : JSON.toJSONString(dictionaryService.getDictionariesByTypeId(typeId));
    }
}
