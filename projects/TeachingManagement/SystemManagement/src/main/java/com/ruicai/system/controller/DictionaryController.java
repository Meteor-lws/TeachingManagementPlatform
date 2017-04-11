package com.ruicai.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 数据字典控制器
 *
 * Created by XuMing on 2017/4/5.
 */
@SuppressWarnings("SameReturnValue")
@Controller
public class DictionaryController {
    @RequestMapping(value = "/dictionary", method = RequestMethod.GET)
    public String dictionary() {
        return "dictionary";
    }
}
