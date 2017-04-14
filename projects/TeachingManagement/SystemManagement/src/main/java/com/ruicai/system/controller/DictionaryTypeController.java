package com.ruicai.system.controller;

import com.alibaba.fastjson.JSON;
import com.ruicai.system.po.system.SystemDictionaryType;
import com.ruicai.system.service.DictionaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 字典啊类型控制器
 *
 * Created by lws on 2017/4/14.
 */
@SuppressWarnings("SameReturnValue")
@Controller
public class DictionaryTypeController {

    private final DictionaryTypeService service;

    @Autowired
    public DictionaryTypeController(DictionaryTypeService service) {
        this.service = service;
    }

    @ResponseBody
    @RequestMapping(value = "/isTypeNameExist", method = RequestMethod.POST)
    public String isTypeNameExist(String typeName) {
        return String.valueOf(service.isTypeNameExist(typeName));
    }

    @ResponseBody
    @RequestMapping(value = "/addDictionaryType", method = RequestMethod.POST)
    public String addDictionaryType(SystemDictionaryType dictionaryType) {
        service.addDictionaryType(dictionaryType);
        return "添加字典类型成功";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteDictionaryType", method = RequestMethod.POST)
    public String deleteDictionaryType(String id) {
        service.deleteDictionaryType(id);
        return "删除字典类型成功";
    }

    @ResponseBody
    @RequestMapping(value = "/editDictionaryType", method = RequestMethod.POST)
    public String editDictionaryType(SystemDictionaryType dictionaryType) {
        service.editDictionaryType(dictionaryType);
        return "修改字典类型成功";
    }

    @ResponseBody
    @RequestMapping(value = "/getDictionaryTypeById", method = RequestMethod.POST)
    public String getDictionaryTypeById(String id) {
        return JSON.toJSONString(service.getDictionaryTypeById(id));
    }

    @ResponseBody
    @RequestMapping(value = "/getDictionaryTypes", method = RequestMethod.POST)
    public String getDictionaryTypes() {
        return JSON.toJSONString(service.getDictionaryTypes());
    }
}
