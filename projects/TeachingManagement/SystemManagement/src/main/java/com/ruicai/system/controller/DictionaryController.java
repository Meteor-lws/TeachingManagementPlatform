package com.ruicai.system.controller;

import com.alibaba.fastjson.JSON;
import com.ruicai.system.po.system.SystemDictionary;
import com.ruicai.system.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 数据字典控制器
 *
 * Created by XuMing on 2017/4/5.
 */
@SuppressWarnings("SameReturnValue")
@Controller
public class DictionaryController {

    private final DictionaryService service;

    @Autowired
    public DictionaryController(DictionaryService service) {
        this.service = service;
    }

    @RequestMapping(value = "/dictionary", method = RequestMethod.GET)
    public String dictionary() {
        return "dictionary";
    }

    @ResponseBody
    @RequestMapping(value = "/isDictionaryNameExist", method = RequestMethod.POST)
    public String isDictionaryNameExist(String dictionaryName) {
        return String.valueOf(service.isDictionaryNameExist(dictionaryName));
    }

    @ResponseBody
    @RequestMapping(value = "/addDictionary", method = RequestMethod.POST)
    public String addDictionary(SystemDictionary dictionary) {
        service.addDictionary(dictionary);
        return "添加数据字典成功";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteDictionaries", method = RequestMethod.POST)
    public String deleteDictionaries(String data) {
        List<SystemDictionary> dictionaries = JSON.parseArray(data, SystemDictionary.class);
        service.deleteDictionaries(dictionaries);
        return "删除数据字典成功";
    }

    @ResponseBody
    @RequestMapping(value = "/editDictionary", method = RequestMethod.POST)
    public String editDictionary(SystemDictionary dictionary) {
        service.editDictionary(dictionary);
        return "修改数据字典成功";
    }

    @ResponseBody
    @RequestMapping(value = "/getDictionaryById", method = RequestMethod.POST)
    public String getDictionaryById(String id) {
        return JSON.toJSONString(service.getDictionaryById(id));
    }

    @ResponseBody
    @RequestMapping(value = "/getDictionaries", method = RequestMethod.POST)
    public String getDictionaries(String type, String name, String value, String describe, int page, int rows) {
        return JSON.toJSONString(service.getDictionaries(type, name, value, describe, page, rows));
    }
}
