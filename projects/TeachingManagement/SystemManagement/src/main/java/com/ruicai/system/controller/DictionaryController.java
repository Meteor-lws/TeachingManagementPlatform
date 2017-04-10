package com.ruicai.system.controller;

import com.ruicai.system.po.system.SystemDictionary;
import com.ruicai.system.service.DictionaryService;
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

    @Autowired
    private DictionaryService service;

    @RequestMapping(value = "/dictionary", method = RequestMethod.GET)
    public String dictionary() {
        return "dictionary";
    }

    @ResponseBody
    @RequestMapping(value = "/getDictionary", method = RequestMethod.POST)
    public String getDictionary(String id) {
        return service.getDictionary(id);
    }

    @ResponseBody
    @RequestMapping(value = "/getDictionaries", method = RequestMethod.POST)
    public String getDictionaries() {
        System.out.println(service + ",.................................................................");
        return service.getDictionaries();
    }

    @ResponseBody
    @RequestMapping(value = "/addDictionary", method = RequestMethod.POST)
    public String addDictionary(SystemDictionary dictionary) {
        service.addDictionary(dictionary);
        return "添加数据字典成功";
    }

    @ResponseBody
    @RequestMapping(value = "/editDictionary", method = RequestMethod.POST)
    public String editDictionary(SystemDictionary dictionary) {
        service.editDictionary(dictionary);
        return "修改数据字典成功";
    }

    @ResponseBody
    @RequestMapping(value = "/removeDictionaryById", method = RequestMethod.POST)
    public String removeDictionaryById(String id) {
        service.removeDictionary(id);
        return "删除数据字典成功";
    }
}
