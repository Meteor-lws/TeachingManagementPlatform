package com.ruicai.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by XuMing on 2017/4/5.
 */
@Controller
public class DictionaryAction {
    @RequestMapping("/dictionary")
    public String index() {
        return "dictionaryEdit";
    }

}
