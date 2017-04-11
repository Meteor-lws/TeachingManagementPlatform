package com.ruicai.system.controller;

import com.alibaba.fastjson.JSON;
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

    @Autowired
    private DictionaryTypeService typeService;

    @RequestMapping(value = "/dictionary", method = RequestMethod.GET)
    public String dictionary() {
        return "dictionary";
    }

    @ResponseBody
    @RequestMapping(value = "/getDictionaryType", method = RequestMethod.POST)
    public String getDictionaryType() {
        return JSON.toJSONString(typeService.getDictionaryTypes());
    }
}
